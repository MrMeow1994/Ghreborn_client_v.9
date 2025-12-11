//Credits to MITB
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Xml$
        implements ActionListener, KeyListener
{

    private String itemName[];
    private String itemID[];
    private String fileName;
    private JTextArea namePanel;
    private JTextArea idPanel;
    private JTextField searchPanel;

    public static void main(String args[])
    {
        new Xml$("/all_IDs/Objects.xml");
    }

    public Xml$(URL xmlURL)
    {
        itemName = new String[10000];
        itemID = new String[10000];
        try
        {
            URLConnection xmlConnect = xmlURL.openConnection();
            xmlConnect.setRequestProperty("User-Agent", "Mozilla");
            xmlConnect.connect();
            readStream(xmlConnect.getInputStream());
        }
        catch(IOException e)
        {
            System.out.println((new StringBuilder()).append("Couldn't find the file ").append(fileName).toString());
        }
        initUI();
    }

    public Xml$(String fileName) {
        File file = new File(fileName);
        this.fileName = file.getName();

        try (FileInputStream fis = new FileInputStream(file)) {
            readStream(fis); // readStream now fills itemName and itemID dynamically
        } catch (IOException e) {
            System.err.println("Couldn't find or read the file: " + fileName);
            e.printStackTrace(); // optional, gives more info
            // optionally handle failure gracefully here
        }

        initUI();
    }


    private void readStream(InputStream inputStream) throws IOException {
        ArrayList<Object> names = new ArrayList<>();
        ArrayList<Object> ids = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("name=")) {
                    // Extract name
                    int nameStart = line.indexOf("name=") + 6;
                    int nameEnd = line.indexOf("\"", nameStart);
                    String name = (nameEnd > nameStart) ? line.substring(nameStart, nameEnd) : line.substring(nameStart);

                    // Extract type/id
                    int idStart = line.indexOf("type=") + 6;
                    int idEnd = line.indexOf("\"", idStart);
                    String id = (idEnd > idStart) ? line.substring(idStart, idEnd) : line.substring(idStart);

                    names.add(name);
                    ids.add(id);
                }
            }
        }

        // Convert to arrays if you still need arrays
        itemName = names.toArray(new String[0]);
        itemID = ids.toArray(new String[0]);
    }

    private JTable table; // make this a class field
    private TableRowSorter<TableModel> sorter;
    private DefaultTableModel model;

    // Call this in initUI() after reading itemName/itemID
    private void initUI() {
        JFrame frame = new JFrame(fileName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Build table model (empty for now)
        model = new DefaultTableModel(new Object[]{"Icon", "Name", "ID"}, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
            @Override
            public Class<?> getColumnClass(int col) {
                return col == 0 ? ImageIcon.class : String.class;
            }
        };

        table = new JTable(model);
        table.setRowHeight(32);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JScrollPane scroll = new JScrollPane(table);
        frame.add(scroll, BorderLayout.CENTER);

        // Load ONLY first 40 items
        loadInitialItems(40);

        // Search UI
        searchPanel = new JTextField(15);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> search());

        JPanel searchPane = new JPanel();
        searchPane.add(searchPanel);
        searchPane.add(searchButton);

        frame.add(searchPane, BorderLayout.SOUTH);
        frame.setSize(600, 500);
        frame.setVisible(true);

        searchPanel.requestFocusInWindow();
    }


    private final Map<String, ImageIcon> imageCache = new HashMap<>();

    private ImageIcon loadItemImage(String id) {
        if (imageCache.containsKey(id)) {
            return imageCache.get(id);
        }

        try {
            // Replace with your base URL where images are hosted
            String urlStr = "http://" + client.server + ":" + (29435 + client.ondemand_offset)+"/images/items/" + id + ".png";
            URL url = new URL(urlStr);

            // Load image from URL
            Image image = ImageIO.read(url);

            // Optionally scale to 32x32
            Image scaled = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);

            ImageIcon icon = new ImageIcon(scaled);
            imageCache.put(id, icon); // cache it
            return icon;

        } catch (IOException e) {
            // Fallback: empty transparent image
            ImageIcon fallback = new ImageIcon(new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB));
            imageCache.put(id, fallback);
            return fallback;
        }
    }

    private void loadInitialItems(int limit) {
        int count = 0;

        for (int i = 0; i < itemName.length && itemName[i] != null; i++) {
            if (count >= limit) break;

            model.addRow(new Object[]{
                    loadItemImage(itemID[i]),
                    itemName[i],
                    itemID[i]
            });

            count++;
        }
    }


    private void search() {
        String text = searchPanel.getText().trim().toLowerCase();

        // Clear current rows
        model.setRowCount(0);

        if (text.isEmpty()) {
            // Reload first 40 items
            loadInitialItems(40);
            return;
        }

        // Build filtered rows
        for (int i = 0; i < itemName.length && itemName[i] != null; i++) {
            if (itemName[i].toLowerCase().contains(text)) {
                model.addRow(new Object[]{
                        loadItemImage(itemID[i]),
                        itemName[i],
                        itemID[i]
                });
            }
        }
    }



    public void actionPerformed(ActionEvent evt)
    {
        search();
    }

    public void keyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 10)
        {
            search();
        }
    }

    public void keyReleased(KeyEvent evt)
    {
        if(evt.getKeyCode() == 10)
        {
            searchPanel.setText(searchPanel.getText().replace("\n", ""));
        }
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }
}
