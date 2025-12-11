import java.awt.*;

public class ColorWheel {

    private static final int RADIUS = 100, ADJUST = 60;

    private static int getCenterX() {
        if (client.currentScreenMode == client.ScreenMode.RESIZABLE) {
            return 931;
        } else {
            return 260;
        }
    }

    private static int getCenterY() {
       if (client.currentScreenMode == client.ScreenMode.RESIZABLE) {
            return 479;
        } else {
            return 160;
        }
    }

    public static void proccessInterfaceClick(int paddingX, int paddingY) {
        if (client.openInterfaceID != 625) {
            return;
        }

        client c = client.instance;

        int centerX = getCenterX(), centerY = getCenterY();
        if (c.clickX >= centerX - RADIUS && c.clickX <= RADIUS + centerX && c.clickY >= centerY - RADIUS && c.clickY <= centerY + RADIUS) {
            Widget box = Widget.interfaceCache.get(632);

            int x = centerX - c.clickX; // [-radius, radius]
            int y = centerY - c.clickY; // [-radius, radius]

            int red = (int) (255 - Math.hypot(100 - x, -0 - y));
            int green = (int) (255 - Math.hypot(-65 - x, y - 75));
            int blue = (int) (255 - Math.hypot(-56 - x, -79 - y));

            if (red >= 230) {
                green -= ADJUST;
                blue -= ADJUST;
            } else if (green >= 230) {
                red -= ADJUST;
                blue -= ADJUST;
            } else if (blue >= 230) {
                red -= ADJUST;
                green -= ADJUST;
            }

            int rgb = convertRBG(red, green, blue);
            box.textColor = covertHSB(rgb);

            c.stream.createFrame(245); // rbg color
            c.stream.writeDWord(rgb);
               // System.out.println("rgb"+rgb);
            c.clickX = -1;
            c.clickY = -1;
        }
    }

    public static int convertRBG(int red, int green, int blue) {
        float[] HSB = Color.RGBtoHSB(red, green, blue, null);
        float hue = (HSB[0]);
        float saturation = (HSB[1]);
        float brightness = (HSB[2]);
        int encode_hue = (int) (hue * 63);            //to 6-bits
        int encode_saturation = (int) (saturation * 7);        //to 3-bits
        int encode_brightness = (int) (brightness * 127);    //to 7-bits
        return (encode_hue << 10) + (encode_saturation << 7) + (encode_brightness);
    }

    public static int covertHSB(int RS2HSB) {
        int decode_hue = (RS2HSB >> 10) & 0x3f;
        int decode_saturation = (RS2HSB >> 7) & 0x07;
        int decode_brightness = (RS2HSB & 0x7f);
        return Color.HSBtoRGB((float) decode_hue / 63, (float) decode_saturation / 7, (float) decode_brightness / 127);
    }

}
