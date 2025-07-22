import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import javax.swing.*;

public class Applet_Sub1 extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener, MouseWheelListener {
    public int key;
    public static int anInt34;
    public int myWidth;
    public int myHeight;
    ClientFrame gameFrame;
    public Graphics aGraphics12;
    public boolean isApplet;
    public RSImageProducer aRSImageProducer_13;
    private int anInt4;
    public int clickMode3;
    public int saveClickX;
    public int saveClickY;
    public long aLong29;
    public int anInt22;
    private int anInt32;
    public int anInt8;
    public boolean aBoolean9 = false;
    private int anInt5 = 20;
    public boolean aBoolean16 = true;
    public int anInt18;
    public int anInt23;
    public int anInt24;
    public long aLong25;
    public boolean mouseWheelDown;
    public int mouseWheelX;
    public int mouseWheelY;
    public int clickMode2;
    public int mouseX;
    public int mouseY;
    private int anInt33;
    public boolean aBoolean17 = true;
    private boolean aBoolean1 = true;
    private int anInt2 = 24869;
    private int anInt3 = 748;
    public int anInt6 = 1;
    private long[] aLongArray7 = new long[10];
    public Sprite[] aSpriteArray14 = new Sprite[6];
    public int[] anIntArray30 = new int[128];
    private int[] anIntArray31 = new int[128];

    public void refreshFrameSize(boolean undecorated, int width, int height, boolean resizable, boolean full) throws Exception {
        boolean createdByApplet = this.isApplet && !full;
        this.myWidth = width;
        this.myHeight = height;
        if(this.gameFrame != null) {
            this.gameFrame.dispose();
        }

        if(!createdByApplet) {
            this.gameFrame = new ClientFrame(this, width, height, resizable, undecorated);
            this.gameFrame.addWindowListener(this);
        }

        this.aGraphics12 = ((Container)(createdByApplet?this:this.gameFrame)).getGraphics();
        if(!createdByApplet) {
            this.method11(0).addMouseWheelListener(this);
            this.method11(0).addMouseListener(this);
            this.method11(0).addMouseMotionListener(this);
            this.method11(0).addKeyListener(this);
            this.method11(0).addFocusListener(this);
        }

    }

    public boolean appletClient() {
        return this.gameFrame == null && this.isApplet;
    }

    final void method1(int i, int j) {
        this.isApplet = false;
        this.myWidth = j;
        this.myHeight = i;

        // Push GUI setup to Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                // Set the Look and Feel safely
                UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");

                // Build the JFrame properly
                this.gameFrame = new ClientFrame(
                        this,
                        this.myWidth,
                        this.myHeight,
                        client.currentScreenMode == client.ScreenMode.RESIZABLE,
                        client.currentScreenMode == client.ScreenMode.FULLSCREEN
                );
// This must come next
                this.gameFrame.setVisible(true);

// Now it's safe to fetch sizes with insets
                client.currentGameWidth = this.gameFrame.getFrameWidth();
                client.currentGameHeight = this.gameFrame.getFrameHeight();
                // Continue graphical setup on the EDT
                this.aGraphics12 = this.method11(0).getGraphics();
                this.aRSImageProducer_13 = new RSImageProducer(this.myWidth, this.myHeight);

                // Finish initialization
                this.method12(this, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public final void method2(int i, boolean flag, int j) {
        this.isApplet = true;
        this.myWidth = j;
        this.myHeight = i;
        this.aGraphics12 = this.method11(0).getGraphics();
        this.aRSImageProducer_13 = new RSImageProducer(this.myWidth, this.myHeight);
        this.method12(this, 1);
        if(!flag) {
            ;
        }

    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        this.handleInterfaceScrolling(e);
        if(this.mouseX > 0 && this.mouseX < 512 && this.mouseY > client.currentGameHeight - 165 && this.mouseY < client.currentGameHeight - 25) {
            int zoom1 = client.anInt1089;
            zoom1 -= notches * 30;
            if(zoom1 < 0) {
                zoom1 = 0;
            }

            if(client.anInt1089 != zoom1) {
                client.anInt1089 = zoom1;
            }
        } else if(client.loggedIn) {
            boolean zoom = client.currentScreenMode == client.ScreenMode.FIXED?this.mouseX < 512:this.mouseX < client.currentGameWidth - 200;
            if(zoom && client.openInterfaceID == -1) {
                client.cameraZoom += notches * 35;
                int max_zoom_1 = client.currentScreenMode == client.ScreenMode.FIXED?-150:-300;
                if(client.cameraZoom < max_zoom_1) {
                    client.cameraZoom = max_zoom_1;
                }

                if(client.cameraZoom > 2200) {
                    client.cameraZoom = 2200;
                }

                if(client.currentScreenMode == client.ScreenMode.FIXED) {
                    if(client.cameraZoom < 70) {
                        client.cameraZoom = 70;
                    }
                } else if(client.cameraZoom < 130) {
                    client.cameraZoom = 130;
                }
            }
        }

    }

    public void handleInterfaceScrolling(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        int positionX = 0;
        int positionY = 0;
        int width = 0;
        int height = 0;
        boolean offsetX = false;
        boolean offsetY = false;
        int childID = 0;
        int tabInterfaceID = client.tabInterfaceIDs[client.tabID];
        Widget rsi;
        int index;
        int var13;
        int var14;
        if(tabInterfaceID != -1) {
            rsi = Widget.interfaceCache[tabInterfaceID];
            var13 = client.currentScreenMode.equals(client.ScreenMode.FIXED)?547:client.currentGameWidth - 197;
            var14 = client.currentScreenMode.equals(client.ScreenMode.FIXED)?205:client.currentGameHeight - (client.currentGameWidth >= 960?37:74) - 267;

            for(index = 0; index < rsi.children.length; ++index) {
                if(Widget.interfaceCache[rsi.children[index]].scrollMax > 0) {
                    childID = index;
                    positionX = rsi.childX[index];
                    positionY = rsi.childY[index];
                    width = Widget.interfaceCache[rsi.children[index]].width;
                    height = Widget.interfaceCache[rsi.children[index]].height;
                    break;
                }
            }

            if(this.mouseX > var13 + positionX && this.mouseY > var14 + positionY && this.mouseX < var13 + positionX + width && this.mouseY < var14 + positionY + height) {
                Widget.interfaceCache[rsi.children[childID]].scrollPosition += rotation * 30;
            }
        }

        if(client.openInterfaceID != -1) {
            rsi = Widget.interfaceCache[client.openInterfaceID];
            var13 = !client.currentScreenMode.equals(client.ScreenMode.FIXED) && !client.centerMainScreenInterface()?client.currentGameWidth / 2 - 256:4;
            var14 = !client.currentScreenMode.equals(client.ScreenMode.FIXED) && !client.centerMainScreenInterface()?client.currentGameHeight / 2 - 167:4;

            for(index = 0; index < rsi.children.length; ++index) {
                if(Widget.interfaceCache[rsi.children[index]].scrollMax > 0 && this.mouseX > var13 + rsi.childX[index] && this.mouseY > var14 + rsi.childY[index] && this.mouseX < var13 + rsi.childX[index] + Widget.interfaceCache[rsi.children[index]].width && this.mouseY < var14 + rsi.childY[index] + Widget.interfaceCache[rsi.children[index]].height) {
                    Widget.interfaceCache[rsi.children[index]].scrollPosition += rotation * 30;
                }
            }
        }

    }

    public void run() {
        this.method11(0).addMouseListener(this);
        this.method11(0).addMouseMotionListener(this);
        this.method11(0).addKeyListener(this);
        this.method11(0).addFocusListener(this);
        this.method11(0).addMouseWheelListener(this);
        this.method11(0).setFocusTraversalKeysEnabled(false);
        if(this.gameFrame != null) {
            this.gameFrame.addWindowListener(this);
        }

        this.method13(0, (byte)4, "Loading...");
        this.method6();
        int i = 0;
        int j = 256;
        int k = 1;
        int i1 = 0;
        int j1 = 0;

        for(int l = 0; l < 10; ++l) {
            this.aLongArray7[l] = System.currentTimeMillis();
        }

        long var15 = System.currentTimeMillis();

        while(true) {
            long l1;
            int l2;
            do {
                if(this.anInt4 < 0) {
                    if(this.anInt4 == -1) {
                        this.method3(4747);
                    }

                    return;
                }

                if(this.anInt4 > 0) {
                    --this.anInt4;
                    if(this.anInt4 == 0) {
                        this.method3(4747);
                        return;
                    }
                }

                int i2 = j;
                int j2 = k;
                j = 300;
                k = 1;
                l1 = System.currentTimeMillis();
                if(this.aLongArray7[i] == 0L) {
                    j = i2;
                    k = j2;
                } else if(l1 > this.aLongArray7[i]) {
                    j = (int)((long)(2560 * this.anInt5) / (l1 - this.aLongArray7[i]));
                }

                if(j < 25) {
                    j = 25;
                }

                if(j > 256) {
                    j = 256;
                    k = (int)((long)this.anInt5 - (l1 - this.aLongArray7[i]) / 10L);
                }

                if(k > this.anInt5) {
                    k = this.anInt5;
                }

                this.aLongArray7[i] = l1;
                i = (i + 1) % 10;
                if(k > 1) {
                    for(l2 = 0; l2 < 10; ++l2) {
                        if(this.aLongArray7[l2] != 0L) {
                            this.aLongArray7[l2] += (long)k;
                        }
                    }
                }

                if(k < this.anInt6) {
                    k = this.anInt6;
                }

                try {
                    Thread.sleep((long)k);
                } catch (InterruptedException var14) {
                    ++j1;
                }

                while(i1 < 256) {
                    this.clickMode3 = this.anInt22;
                    this.saveClickX = this.anInt23;
                    this.saveClickY = this.anInt24;
                    this.aLong29 = this.aLong25;
                    this.anInt22 = 0;
                    this.method7(24869);
                    this.anInt32 = this.anInt33;
                    i1 += j;
                }

                i1 &= 255;
                if(this.anInt5 > 0) {
                    this.anInt8 = 1000 * j / (this.anInt5 * 256);
                }

                this.method9(0);
            } while(!this.aBoolean9);

            System.out.println("ntime:" + l1);

            for(l2 = 0; l2 < 10; ++l2) {
                int i3 = (i - l2 - 1 + 20) % 10;
                System.out.println("otim" + i3 + ":" + this.aLongArray7[i3]);
            }

            System.out.println("fps:" + this.anInt8 + " ratio:" + j + " count:" + i1);
            System.out.println("del:" + k + " deltime:" + this.anInt5 + " mindel:" + this.anInt6);
            System.out.println("intex:" + j1 + " opos:" + i);
            this.aBoolean9 = false;
            j1 = 0;
        }
    }

    public final void method3(int i) {
        this.anInt4 = -2;
        this.method8(493);
        if(i == 4747) {
            if(this.gameFrame != null) {
                try {
                    Thread.sleep(1000L);
                } catch (Exception var3) {
                    ;
                }

                try {
                    System.exit(0);
                    return;
                } catch (Throwable var4) {
                    ;
                }
            }

        }
    }

    public final void method4(boolean flag, int i) {
        if(!flag) {
            this.anInt5 = 1000 / i;
        }
    }

    public final void start() {
        if(this.anInt4 >= 0) {
            this.anInt4 = 0;
        }

    }

    public final void stop() {
        if(this.anInt4 >= 0) {
            this.anInt4 = 4000 / this.anInt5;
        }

    }

    public final void destroy() {
        this.anInt4 = -1;

        try {
            Thread.sleep(5000L);
        } catch (Exception var2) {
            ;
        }

        if(this.anInt4 == -1) {
            this.method3(4747);
        }

    }

    public final void update(Graphics g) {
        if(this.aGraphics12 == null) {
            this.aGraphics12 = g;
        }

        this.aBoolean16 = true;
        this.method10((byte)1);
    }

    public final void paint(Graphics g) {
        if(this.aGraphics12 == null) {
            this.aGraphics12 = g;
        }

        this.aBoolean16 = true;
        this.method10((byte)1);
    }

    public final void mousePressed(MouseEvent mouseevent) {
        int type = mouseevent.getButton();
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if(mouseevent.isControlDown()) {
            client.controlIsDown = true;
        }

        if(this.gameFrame != null) {
            Insets insets = this.gameFrame.getInsets();
            i -= insets.left;
            j -= insets.top;
        }

        this.anInt18 = 0;
        this.anInt23 = i;
        this.anInt24 = j;
        this.aLong25 = System.currentTimeMillis();
        if(SwingUtilities.isMiddleMouseButton(mouseevent)) {
            this.mouseWheelDown = true;
            this.mouseWheelX = i;
            this.mouseWheelY = j;
        } else if(SwingUtilities.isRightMouseButton(mouseevent)) {
            this.anInt22 = 2;
            this.clickMode2 = 2;
        } else if(SwingUtilities.isLeftMouseButton(mouseevent)) {
            this.anInt22 = 1;
            this.clickMode2 = 1;
        }
    }

    public final void mouseDragged(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if(this.gameFrame != null) {
            Insets k = this.gameFrame.getInsets();
            i -= k.left;
            j -= k.top;
        }

        if(this.mouseWheelDown) {
            j = this.mouseWheelX - mouseevent.getX();
            int k1 = this.mouseWheelY - mouseevent.getY();
            this.mouseWheelDragged(j, -k1);
            this.mouseWheelX = mouseevent.getX();
            this.mouseWheelY = mouseevent.getY();
        } else {
            this.anInt18 = 0;
            this.mouseX = i;
            this.mouseY = j;
        }
    }

    void mouseWheelDragged(int param1, int param2) {
    }

    public final void mouseReleased(MouseEvent mouseevent) {
        this.anInt18 = 0;
        this.clickMode2 = 0;
        this.mouseWheelDown = false;
    }

    public final void mouseClicked(MouseEvent mouseevent) {
    }

    public final void mouseEntered(MouseEvent mouseevent) {
    }

    public final void mouseExited(MouseEvent mouseevent) {
        this.anInt18 = 0;
        this.mouseX = -1;
        this.mouseY = -1;
    }

    public final void mouseMoved(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if(this.gameFrame != null) {
            Insets insets = this.gameFrame.getInsets();
            i -= insets.left;
            j -= insets.top;
        }

        this.anInt18 = 0;
        this.mouseX = i;
        this.mouseY = j;
    }

    public final void keyPressed(KeyEvent keyevent) {
        this.anInt18 = 0;
        int i = keyevent.getKeyCode();
        int j = keyevent.getKeyChar();
        if(i == 33) {
            if(client.cameraZoom == 150) {
                return;
            }

            client.cameraZoom -= 50;
        }

        if(i == 34) {
            if(client.cameraZoom == 2300) {
                return;
            }

            client.cameraZoom += 50;
        }

        if(j < 30) {
            j = 0;
        }

        if(i == 37) {
            j = 1;
        }

        if(i == 39) {
            j = 2;
        }

        if(i == 38) {
            j = 3;
        }

        if(i == 40) {
            j = 4;
        }

        if(i == 17) {
            j = 5;
        }

        if(i == 8) {
            j = 8;
        }

        if(i == 127) {
            j = 8;
        }

        if(i == 9) {
            j = 9;
        }

        if(i == 10) {
            j = 10;
        }

        if(i >= 112 && i <= 123) {
            j = 1008 + i - 112;
        }

        if(i == 36) {
            j = 1000;
        }

        if(i == 35) {
            j = 1001;
        }

        if(i == 33) {
            j = 1002;
        }

        if(i == 34) {
            j = 1003;
        }

        if(j > 0 && j < 128) {
            this.anIntArray30[j] = 1;
        }

        if(j > 4) {
            this.anIntArray31[this.anInt33] = j;
            this.anInt33 = this.anInt33 + 1 & 127;
        }

    }

    public final void keyReleased(KeyEvent keyevent) {
        this.anInt18 = 0;
        int i = keyevent.getKeyCode();
        char c = keyevent.getKeyChar();
        if(i == 17) {
            client.controlIsDown = false;
        }

        if(c < 30) {
            c = 0;
        }

        if(i == 37) {
            c = 1;
        }

        if(i == 39) {
            c = 2;
        }

        if(i == 38) {
            c = 3;
        }

        if(i == 40) {
            c = 4;
        }

        if(i == 17) {
            c = 5;
        }

        if(i == 8) {
            c = 8;
        }

        if(i == 127) {
            c = 8;
        }

        if(i == 9) {
            c = 9;
        }

        if(i == 10) {
            c = 10;
        }

        if(c > 0 && c < 128) {
            this.anIntArray30[c] = 0;
        }

    }

    public final void keyTyped(KeyEvent keyevent) {
    }

    public final int method5(int i) {
        label20:
        while(true) {
            int k;
            if(i >= 0) {
                k = 1;

                while(true) {
                    if(k <= 0) {
                        continue label20;
                    }

                    ++k;
                }
            }

            k = -1;
            if(this.anInt33 != this.anInt32) {
                k = this.anIntArray31[this.anInt32];
                this.anInt32 = this.anInt32 + 1 & 127;
            }

            return k;
        }
    }

    public final void focusGained(FocusEvent focusevent) {
        this.aBoolean17 = true;
        this.aBoolean16 = true;
        this.method10((byte)1);
    }

    public final void focusLost(FocusEvent focusevent) {
        this.aBoolean17 = false;

        for(int i = 0; i < 128; ++i) {
            this.anIntArray30[i] = 0;
        }

    }

    public final void windowActivated(WindowEvent windowevent) {
    }

    public final void windowClosed(WindowEvent windowevent) {
    }

    public final void windowClosing(WindowEvent windowevent) {
        this.destroy();
    }

    public final void windowDeactivated(WindowEvent windowevent) {
    }

    public final void windowDeiconified(WindowEvent windowevent) {
    }

    public final void windowIconified(WindowEvent windowevent) {
    }

    public final void windowOpened(WindowEvent windowevent) {
    }

    public void method6() {
    }

    public void method7(int i) {
        if(i == this.anInt2) {
            ;
        }

    }

    public void method8(int i) {
        i = 91 / i;
    }

    public void method9(int i) {
        if(i != 0) {
            for(int j = 1; j > 0; ++j) {
                ;
            }
        }

    }

    public void method10(byte byte0) {
        if(byte0 == 1) {
            boolean byte01 = false;
        }

    }

    public Component method11(int i) {
        if(i != 0) {
            for(int j = 1; j > 0; ++j) {
                ;
            }
        }

        return (Component)(this.gameFrame != null?this.gameFrame:this);
    }

    public void method12(Runnable runnable, int i) {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(i);
    }

    public void method13(int i, byte byte0, String s) {
        while(this.aGraphics12 == null) {
            this.aGraphics12 = this.method11(0).getGraphics();

            try {
                this.method11(0).repaint();
            } catch (Exception var10) {
                ;
            }

            try {
                Thread.sleep(1000L);
            } catch (Exception var9) {
                ;
            }
        }

        Font font = new Font("Helvetica", 1, 13);
        FontMetrics fontmetrics = this.method11(0).getFontMetrics(font);
        Font font1 = new Font("Helvetica", 0, 13);
        this.method11(0).getFontMetrics(font1);
        if(this.aBoolean16) {
            this.aGraphics12.setColor(Color.black);
            this.aGraphics12.fillRect(0, 0, client.currentGameWidth, client.currentGameHeight);
            this.aBoolean16 = false;
        }

        Color color = new Color(140, 17, 17);
        int j = this.myHeight / 2 - 18;
        this.aGraphics12.setColor(color);
        this.aGraphics12.drawRect(client.currentGameWidth / 2 - 152, j, 304, 34);
        this.aGraphics12.fillRect(client.currentGameWidth / 2 - 150, j + 2, i * 3, 30);
        this.aGraphics12.setColor(Color.black);
        if(byte0 == 4) {
            this.aGraphics12.fillRect(client.currentGameWidth / 2 - 150 + i * 3, j + 2, 300 - i * 3, 30);
            this.aGraphics12.setFont(font);
            this.aGraphics12.setColor(Color.white);
            this.aGraphics12.drawString(s, (client.currentGameWidth - fontmetrics.stringWidth(s)) / 2, j + 22);
        }
    }

    public int getFps() {
        return this.anInt8;
    }
}
