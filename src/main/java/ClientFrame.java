import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import javazoom.jl.player.Player;


import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.URL;
import javax.imageio.ImageIO;
import sign.signlink;

public final class ClientFrame extends Frame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public Toolkit toolkit = Toolkit.getDefaultToolkit();
    public Dimension screenSize;
    public int screenWidth;
    public int screenHeight;
    private final Applet_Sub1 applet;
    protected final Insets insets;

    private static JMenuItem menuItem;
    private int screenshot;
    private boolean takeScreeny = true;
    public ClientFrame(Applet_Sub1 applet, int width, int height, boolean resizable, boolean fullscreen) throws Exception {

        MenuBar menuBar = new MenuBar();
        this.applet = applet;
        Menu fileMenu = new Menu("File");
        fileMenu.add(createMenuItem("Quit"));


        Menu screenshotMenu = new Menu("Screenshot");
        screenshotMenu.add(createMenuItem("Take Screenshot"));

        Menu themesMenu = new Menu("Themes");
        String[] themes = {"Black", "Blue", "Red", "Green", "Grey", "White"};
        for (String theme : themes) {
            themesMenu.add(createMenuItem(theme));
        }


        Menu creditsMenu = new Menu("Credits");
        creditsMenu.add(createMenuItem("Help"));
        creditsMenu.addSeparator();
        creditsMenu.add(createMenuItem("Credits"));
        creditsMenu.add(createMenuItem("About us"));

        Menu idsMenu = new Menu("IDS");
        idsMenu.add(createMenuItem("Item IDs"));
        idsMenu.add(createMenuItem("NPC IDs"));
        idsMenu.add(createMenuItem("Object IDs"));
        idsMenu.add(createMenuItem("New Item IDs"));
        Menu musicMenu = new Menu("Music");

        MenuItem playMusic = new MenuItem("Play");
        MenuItem stopMusic = new MenuItem("Stop");
        MP3Player mp3 = new MP3Player();
        stopMusic.addActionListener(e -> mp3.stop());

        MenuItem volumeControl = new MenuItem("🔊 Volume");
        volumeControl.addActionListener(e -> mp3.showVolumeControl());
       musicMenu.add(playMusic);
        musicMenu.add(stopMusic);
        menuBar.add(fileMenu);
        menuBar.add(screenshotMenu);
        menuBar.add(themesMenu);
        menuBar.add(creditsMenu);
        menuBar.add(idsMenu);
        menuBar.add(musicMenu);

        this.setMenuBar(menuBar);
        ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/4vcxosG.jpg"));
        this.screenSize = this.toolkit.getScreenSize();
        this.screenWidth = (int)this.screenSize.getWidth();
        this.screenHeight = (int)this.screenSize.getHeight();
        this.setTitle("Godzhell Reborn and Remastered.");
        this.setResizable(resizable);
        this.setUndecorated(fullscreen);
        setIconImage(icon.getImage());
        this.setVisible(true);
        this.setFocusTraversalKeysEnabled(false);
        this.insets = this.getInsets();
        if(resizable) {
            this.setMinimumSize(new Dimension(766 + this.insets.left + this.insets.right, 545 + this.insets.top + this.insets.bottom));
        }

        this.setSize(
                765 + insets.left + insets.right,
                515 + insets.top + insets.bottom
        );
        playMusic.addActionListener(e -> {
            // Replace this with your actual file server track
            if (!mp3.isPlaying()) {
                mp3.playFromURL("http://ghreborn.ddns.net:29435/pvpmix.mp3",true);
            }
        });

        this.setLocationRelativeTo((Component)null);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        //this.add(this.com, BorderLayout.CENTER);
        this.requestFocus();
        this.toFront();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit":
                System.exit(0);
                break;
            case "Take Screenshot":
                screeny();
                break;
            case "Black":
                setTheme("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");
                break;
            case "Blue":
                setTheme("org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel");
                break;
            case "Red":
                setTheme("org.pushingpixels.substance.api.skin.SubstanceMagmaLookAndFeel");
                break;
            case "Green":
                setTheme("org.pushingpixels.substance.api.skin.SubstanceSaharaLookAndFeel");
                break;
            case "Grey":
                setTheme("org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel");
                break;
            case "White":
                setTheme("org.pushingpixels.substance.api.skin.SubstanceCremeLookAndFeel");
                break;
            case "Help":
                JOptionPane.showMessageDialog(this, "Ask for help on Discord or in game", "Help", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Credits":
                JOptionPane.showMessageDialog(this, "Have fun on GodzHell!", "Credits", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "About us":
                JOptionPane.showMessageDialog(this, "GodzHell Reborn and Remastered.", "About us", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "We are back guys!. Owner: Sgsrocks", "Read", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Item IDs":
                new Xml$(signlink.findcachedir()+"/all_IDs/Items.xml");
                break;
            case "NPC IDs":
                new Xml$(signlink.findcachedir()+"/all_IDs/NPCs.xml");
                break;
            case "Object IDs":
                new Xml$(signlink.findcachedir()+"/all_IDs/Objects.xml");
                break;
            case "New Item IDs":
                new Xml$(signlink.findcachedir()+"/all_IDs/NewItems.xml");
                break;
            default:
                System.out.println("Unrecognized menu command: " + cmd);
        }
    }

    private void setTheme(String className) {
        try {
            UIManager.setLookAndFeel(className);
            System.out.println("Look and Feel set to " + className);
        } catch (Exception e) {
            System.err.println("Failed to set Look and Feel: " + className);
            e.printStackTrace();
        }
    }


    private MenuItem createMenuItem(String label) {
        MenuItem item = new MenuItem(label);
        item.addActionListener(this);
        return item;
    }

    public Graphics getGraphics() {
        Graphics graphics = super.getGraphics();
        Insets insets = this.getInsets();
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.translate(insets != null?insets.left:0, insets != null?insets.top:0);
        return graphics;
    }
    client client;
    public int getFrameWidth() {
        Insets insets = this.getInsets();
        if (insets == null || insets.left + insets.right == 0)
            return this.getWidth(); // fallback
        return this.getWidth() - (insets.left + insets.right);
    }

    public int getFrameHeight() {
        Insets insets = this.getInsets();
        if (insets == null || insets.top + insets.bottom == 0)
            return this.getHeight(); // fallback
        return this.getHeight() - (insets.top + insets.bottom);
    }
    public void screeny() {
        try {
            Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
            Point point = window.getLocationOnScreen();
            int x = (int)point.getX();
            int y = (int)point.getY();
            int w = window.getWidth();
            int h = window.getHeight();
            Robot robot = new Robot(window.getGraphicsConfiguration().getDevice());
            Rectangle captureSize = new Rectangle(x, y, w, h);
            java.awt.image.BufferedImage bufferedimage = robot.createScreenCapture(captureSize);
            String fileExtension = "GodzHell";
            for (int i = 1; i <= 1000; i++) {
                File file = new File(signlink.findcachedir() + "/Screenshots/" + fileExtension + " " + i + ".png");
                File parentDir = file.getParentFile();

                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs(); // Create missing folders
                }

                if (!file.exists()) {
                    screenshot = i;
                    takeScreeny = true;
                    // Now you're safe to create the file later when actually writing the image
                    break;
                }
            }

            File file = new File(signlink.findcachedir()+"/Screenshots/" + fileExtension + " " + screenshot + ".png");
            if (takeScreeny == true) {
               // client.pushMessage("A picture has been saved in your screenshots folder.", 0, "");
                ImageIO.write(bufferedimage, "png", file);
            } else {
                //client.pushMessage("@red@Uh oh! Your screeny folder is full!", 0, "");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Graphics graphics) {
        this.applet.update(graphics);
    }

    public void paint(Graphics graphics) {
        this.applet.paint(graphics);
    }
}