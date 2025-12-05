import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import sign.signlink;

public final class Sprite extends DrawingArea {
   public String location = signlink.findcachedir() + "Sprites/";
   public int myWidth;
   public int myHeight;
   public int maxWidth;
   public int maxHeight;
   public int drawOffsetX;
   public int drawOffsetY;
   public int[] myPixels;
   private boolean aBoolean1428;
   private int anInt1429;
   private int anInt1431;
   private byte aByte1432;
   private boolean aBoolean1433;
   private int anInt1434;
   private boolean aBoolean1436;
   private boolean aBoolean1435;
   private boolean aBoolean1437;
   private boolean aBoolean1438;
   private int anInt1430;

   public void drawSprite(int i, int k, int color) {
      int tempWidth = this.myWidth + 2;
      int tempHeight = this.myHeight + 2;
      int[] tempArray = new int[tempWidth * tempHeight];

      int l;
      int i1;
      for(l = 0; l < this.myWidth; ++l) {
         for(i1 = 0; i1 < this.myHeight; ++i1) {
            if(this.myPixels[l + i1 * this.myWidth] != 0) {
               tempArray[l + 1 + (i1 + 1) * tempWidth] = this.myPixels[l + i1 * this.myWidth];
            }
         }
      }

      for(l = 0; l < tempWidth; ++l) {
         for(i1 = 0; i1 < tempHeight; ++i1) {
            if(tempArray[l + i1 * tempWidth] == 0) {
               if(l < tempWidth - 1 && tempArray[l + 1 + i1 * tempWidth] > 0 && tempArray[l + 1 + i1 * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }

               if(l > 0 && tempArray[l - 1 + i1 * tempWidth] > 0 && tempArray[l - 1 + i1 * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }

               if(i1 < tempHeight - 1 && tempArray[l + (i1 + 1) * tempWidth] > 0 && tempArray[l + (i1 + 1) * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }

               if(i1 > 0 && tempArray[l + (i1 - 1) * tempWidth] > 0 && tempArray[l + (i1 - 1) * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }
            }
         }
      }

      --i;
      --k;
      i += this.drawOffsetX;
      k += this.drawOffsetY;
      l = i + k * DrawingArea.width;
      i1 = 0;
      int j1 = tempHeight;
      int k1 = tempWidth;
      int l1 = DrawingArea.width - tempWidth;
      int i2 = 0;
      int l2;
      if(k < DrawingArea.topY) {
         l2 = DrawingArea.topY - k;
         j1 = tempHeight - l2;
         k = DrawingArea.topY;
         i1 += l2 * tempWidth;
         l += l2 * DrawingArea.width;
      }

      if(k + j1 > DrawingArea.bottomY) {
         j1 -= k + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 = tempWidth - l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method349(DrawingArea.pixels, tempArray, i1, l, k1, j1, l1, i2, 8);
      }

   }

   public static Image downScaleImage(Image image, int width, int height) {
      return width <= 765 && width <= 503?image:image.getScaledInstance(width, height, 4);
   }

   public void dumpImage(String directory, String name, Sprite sprite, boolean transparency) {
      try {
         DirectColorModel t = new DirectColorModel(24, 16711680, '\uff00', 255);
         int[] bandmasks = new int[]{t.getRedMask(), t.getGreenMask(), t.getBlueMask()};
         int w = sprite.myWidth;
         int h = sprite.myHeight;
         int[] pix = sprite.myPixels;
         if(transparency) {
            for(int buffer = 0; buffer < pix.length; ++buffer) {
               if(pix[buffer] == 0) {
                  pix[buffer] = 16777215;
               }
            }
         }

         DataBufferInt var14 = new DataBufferInt(pix, pix.length);
         WritableRaster raster = Raster.createPackedRaster(var14, w, h, w, bandmasks, (Point)null);
         BufferedImage img = new BufferedImage(t, raster, true, new Hashtable());
         ImageIO.write(img, "png", new File("./" + directory + name + ".png"));
      } catch (Throwable var13) {
         var13.printStackTrace();
      }

   }

   public void drawTransparent(int i, int j, int k) {
      i += this.drawOffsetX;
      j += this.drawOffsetY;
      int i1 = i + j * DrawingArea.width;
      int j1 = 0;
      int k1 = this.myHeight;
      int l1 = this.myWidth;
      int i2 = DrawingArea.width - l1;
      int j2 = 0;
      int i3;
      if(j < DrawingArea.topY) {
         i3 = DrawingArea.topY - j;
         k1 -= i3;
         j = DrawingArea.topY;
         j1 += i3 * l1;
         i1 += i3 * DrawingArea.width;
      }

      if(j + k1 > DrawingArea.bottomY) {
         k1 -= j + k1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - i;
         l1 -= i3;
         i = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(i + l1 > DrawingArea.bottomX) {
         i3 = i + l1 - DrawingArea.bottomX;
         l1 -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(l1 > 0 && k1 > 0) {
         this.method351(j1, l1, DrawingArea.pixels, 0, this.myPixels, j2, k1, i2, k, i1, 8);
      }

   }

   public Sprite(String s) {
      try {
         Image exception = Toolkit.getDefaultToolkit().getImage(this.location + s + ".png");
         ImageIcon sprite = new ImageIcon(exception);
         this.myWidth = sprite.getIconWidth();
         this.myHeight = sprite.getIconHeight();
         this.maxWidth = this.myWidth;
         this.maxHeight = this.myHeight;
         this.drawOffsetX = 0;
         this.drawOffsetY = 0;
         this.myPixels = new int[this.myWidth * this.myHeight];
         PixelGrabber pixelgrabber = new PixelGrabber(exception, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
         pixelgrabber.grabPixels();
         // Make both pure pink (255, 0, 255) and pure white (255, 255, 255) transparent
         applyTransparency(new int[] {
                 0xFFFF00FF, // pink
                 0xFFFFFFFF  // white
         });
         //applyPinkOverlay();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   public Sprite(String s, int width, int height) {
      try {
         Image exception = Toolkit.getDefaultToolkit().createImage(FileOperations.ReadFile(s));
         this.myWidth = width;
         this.myHeight = height;
         this.maxWidth = this.myWidth;
         this.maxHeight = this.myHeight;
         this.drawOffsetX = 0;
         this.drawOffsetY = 0;
         this.myPixels = new int[this.myWidth * this.myHeight];
         PixelGrabber pixelgrabber = new PixelGrabber(exception, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
         pixelgrabber.grabPixels();
         this.setTransparency(255, 0, 255);
         //applyPinkOverlay();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public Sprite(int i, int j) {
      this.aBoolean1428 = false;
      this.anInt1429 = 24869;
      this.anInt1431 = -32357;
      this.aByte1432 = 3;
      this.aBoolean1433 = false;
      this.anInt1434 = -388;
      this.aBoolean1436 = true;
      this.aBoolean1435 = false;
      this.aBoolean1437 = true;
      this.aBoolean1438 = false;
      this.myPixels = new int[i * j];
      this.myWidth = this.maxWidth = i;
      this.myHeight = this.maxHeight = j;
      this.drawOffsetX = this.drawOffsetY = 0;
   }

   public void setTransparency(int transRed, int transGreen, int transBlue) {
      for(int index = 0; index < this.myPixels.length; ++index) {
         if((this.myPixels[index] >> 16 & 255) == transRed && (this.myPixels[index] >> 8 & 255) == transGreen && (this.myPixels[index] & 255) == transBlue) {
            this.myPixels[index] = 0;
         }
      }

   }
   private void applyTransparency(int[] transparentColors) {
      for (int i = 0; i < myPixels.length; i++) {
         int pixel = myPixels[i];
         for (int color : transparentColors) {
            if (pixel == color) {
               myPixels[i] = 0; // Fully transparent
               break;
            }
         }
      }
   }

   public Sprite(byte[] abyte0, Component component) {
      this.aBoolean1428 = false;
      this.anInt1429 = 24869;
      this.anInt1431 = -32357;
      this.aByte1432 = 3;
      this.aBoolean1433 = false;
      this.anInt1434 = -388;
      this.aBoolean1435 = false;
      this.aBoolean1436 = true;
      this.aBoolean1437 = true;
      this.aBoolean1438 = false;

      try {
         Image exception = Toolkit.getDefaultToolkit().createImage(signlink.findcachedir() + "/SPRITES/OLDKOSCAPE.PNG");
         MediaTracker mediatracker = new MediaTracker(component);
         mediatracker.addImage(exception, 0);
         mediatracker.waitForAll();
         this.myWidth = exception.getWidth(component);
         this.myHeight = exception.getHeight(component);
         this.maxWidth = this.myWidth;
         this.maxHeight = this.myHeight;
         this.drawOffsetX = 0;
         this.drawOffsetY = 0;
         this.myPixels = new int[this.myWidth * this.myHeight];
         PixelGrabber pixelgrabber = new PixelGrabber(exception, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
         pixelgrabber.grabPixels();
         this.setTransparency(255, 0, 255);
         //applyPinkOverlay();
      } catch (Exception var6) {
         System.out.println("Error converting jpg");
      }
   }

   public Sprite(FileArchive fileArchive, String s, int i) {
      this.aBoolean1428 = false;
      this.anInt1429 = 24869;
      this.anInt1431 = -32357;
      this.aByte1432 = 3;
      this.aBoolean1433 = false;
      this.anInt1434 = -388;
      this.aBoolean1435 = false;
      this.aBoolean1436 = true;
      this.aBoolean1437 = true;
      this.aBoolean1438 = false;
      Stream stream = new Stream(fileArchive.method571(s + ".dat"), 891);
      Stream stream_1 = new Stream(fileArchive.method571("index.dat"), 891);
      stream_1.currentPosition = stream.readUnsignedShort();
      this.maxWidth = stream_1.readUnsignedShort();
      this.maxHeight = stream_1.readUnsignedShort();
      int j = stream_1.readUnsignedByte();
      int[] ai = new int[j];

      int i1;
      for(i1 = 0; i1 < j - 1; ++i1) {
         ai[i1 + 1] = stream_1.read3Bytes();
         if(ai[i1 + 1] == 0) {
            ai[i1 + 1] = 1;
         }
      }

      for(i1 = 0; i1 < i; ++i1) {
         stream_1.currentPosition += 2;
         stream.currentPosition += stream_1.readUnsignedShort() * stream_1.readUnsignedShort();
         ++stream_1.currentPosition;
      }

      this.drawOffsetX = stream_1.readUnsignedByte();
      this.drawOffsetY = stream_1.readUnsignedByte();
      this.myWidth = stream_1.readUnsignedShort();
      this.myHeight = stream_1.readUnsignedShort();
      i1 = stream_1.readUnsignedByte();
      int j1 = this.myWidth * this.myHeight;
      this.myPixels = new int[j1];
      Image l1;
      PixelGrabber i2;
      if(s.startsWith("back")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/SPRITES/" + s + " " + i + ".png");
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
         } catch (Exception var19) {
            System.out.println(var19);
         }
      } else if(s.startsWith("mapback")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/" + s + " " + i + ".png");
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
         } catch (Exception var18) {
            System.out.println(var18);
         }
      } else if(s.startsWith("staticons")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/" + s + " " + i + ".png");
            this.myWidth = 28;
            this.myHeight = 28;
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
         } catch (Exception var17) {
            System.out.println(var17);
         }
      } else if(s.startsWith("chat")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/CHATBACK 0.png");
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
         } catch (Exception var16) {
            System.out.println(var16);
         }
      } else if(s.startsWith("redstone2")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/REDSTONE2 0.png");
            this.myWidth = 33;
            this.myHeight = 37;
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
            this.setTransparency(255, 0, 255);
         } catch (Exception var15) {
            System.out.println(var15);
         }
      } else if(s.startsWith("redstone1")) {
         try {
            this.myWidth = 38;
            this.myHeight = 37;
            this.myPixels = new int[this.myWidth * this.myHeight];
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/REDSTONE1 0.png");
            if(client.flip) {
               l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/REDSTONE1 1.png");
            }

            if(client.flip_s) {
               l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/REDSTONE1 2.png");
            }

            if(client.flip_r) {
               l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/REDSTONE1 3.png");
            }

            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
            this.setTransparency(255, 0, 255);
         } catch (Exception var14) {
            System.out.println(var14);
         }
      } else if(s.startsWith("scroll")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/" + s + " " + i + ".png");
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
         } catch (Exception var13) {
            System.out.println(var13);
         }
      } else if(s.equalsIgnoreCase("invback")) {
         try {
            l1 = Toolkit.getDefaultToolkit().getImage(signlink.findcachedir() + "/Sprites/" + s + " " + i + ".png");
            this.myPixels = new int[this.myWidth * this.myHeight];
            i2 = new PixelGrabber(l1, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
            i2.grabPixels();
         } catch (Exception var12) {
            System.out.println(var12);
         }
         //applyPinkOverlay();
         this.setTransparency(255, 0, 255);
      } else {
         int var21;
         if(i1 == 0) {
            for(var21 = 0; var21 < j1; ++var21) {
               this.myPixels[var21] = ai[stream.readUnsignedByte()];
            }
             //applyPinkOverlay();
            this.setTransparency(255, 0, 255);
            return;
         }

         if(i1 == 1) {
            for(var21 = 0; var21 < this.myWidth; ++var21) {
               for(int var20 = 0; var20 < this.myHeight; ++var20) {
                  this.myPixels[var21 + var20 * this.myWidth] = ai[stream.readUnsignedByte()];
                  //applyPinkOverlay();
                  this.setTransparency(255, 0, 255);
               }
            }
         }
      }

   }
   private void applyPinkOverlay() {
      Color overlayColor = new Color(0, 0, 0, 255); // RGB for light magenta pink
      int overlayRed = overlayColor.getRed();
      int overlayGreen = overlayColor.getGreen();
      int overlayBlue = overlayColor.getBlue();

      for (int i = 0; i < myPixels.length; i++) {
         int pixel = myPixels[i];
         int alpha = (pixel >> 24) & 0xFF;

         // Check if the pixel is not transparent
         if (alpha != 0) {
            int r = (pixel >> 16) & 0xFF;
            int g = (pixel >> 8) & 0xFF;
            int b = pixel & 0xFF;

            // Skip applying overlay if the pixel is close to the target pink (255, 61, 163)
            if (isCloseToPink(r, g, b, overlayRed, overlayGreen, overlayBlue)) {
               continue;  // Skip applying the overlay to this pixel
            }

            // Apply the pink overlay by blending the current pixel color with the new pink color
            int newRed = (int)((r + overlayRed) / 2);
            int newGreen = (int)((g + overlayGreen) / 2);
            int newBlue = (int)((b + overlayBlue) / 2);

            // Rebuild the pixel with the new blended colors
            myPixels[i] = (alpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
         }
      }
   }

   private boolean isCloseToPink(int r, int g, int b, int overlayRed, int overlayGreen, int overlayBlue) {
      // Define the threshold for how "close" a pixel can be to the pink color (255, 61, 163)
      int threshold = 50;

      // Calculate the RGB difference between the pixel color and the target pink
      int redDiff = Math.abs(r - overlayRed);
      int greenDiff = Math.abs(g - overlayGreen);
      int blueDiff = Math.abs(b - overlayBlue);

      // If the pixel is close enough to the pink color, return true (do not apply overlay)
      return redDiff < threshold && greenDiff < threshold && blueDiff < threshold;
   }
   public static void writeTemp(String tempData, String tempFile) {
      try {
         BufferedWriter LV = new BufferedWriter(new FileWriter(tempFile, true));
         LV.write(tempData);
         LV.newLine();
         LV.flush();
      } catch (IOException var3) {
         ;
      }

   }

   public void method343(int i) {
      if(i != 0) {
         this.aBoolean1438 = !this.aBoolean1438;
      }

      DrawingArea.initDrawingArea(this.myHeight, this.myWidth, this.myPixels, (float[])null);
   }

   public void method344(int i, int j, int k, int l) {
      if(l != 0) {
         this.anInt1430 = 314;
      }

      for(int i1 = 0; i1 < this.myPixels.length; ++i1) {
         int j1 = this.myPixels[i1];
         if(j1 != 0) {
            int k1 = j1 >> 16 & 255;
            k1 += i;
            if(k1 < 1) {
               k1 = 1;
            } else if(k1 > 255) {
               k1 = 255;
            }

            int l1 = j1 >> 8 & 255;
            l1 += j;
            if(l1 < 1) {
               l1 = 1;
            } else if(l1 > 255) {
               l1 = 255;
            }

            int i2 = j1 & 255;
            i2 += k;
            if(i2 < 1) {
               i2 = 1;
            } else if(i2 > 255) {
               i2 = 255;
            }

            this.myPixels[i1] = (k1 << 16) + (l1 << 8) + i2;
         }
      }

   }

   public void method345(int i) {
      int[] ai = new int[this.maxWidth * this.maxHeight];
      if(i != 5059) {
         this.anInt1429 = -247;
      }

      for(int j = 0; j < this.myHeight; ++j) {
         for(int k = 0; k < this.myWidth; ++k) {
            ai[(j + this.drawOffsetY) * this.maxWidth + k + this.drawOffsetX] = this.myPixels[j * this.myWidth + k];
         }
      }

      this.myPixels = ai;
      this.myWidth = this.maxWidth;
      this.myHeight = this.maxHeight;
      this.drawOffsetX = 0;
      this.drawOffsetY = 0;
   }

   public void method346(int i, int j, int k) {
      i += this.drawOffsetX;
      j += this.drawOffsetY;
      int l = i + j * DrawingArea.width;
      int i1 = 0;
      int j1 = this.myHeight;
      int k1 = this.myWidth;
      int l1 = DrawingArea.width - k1;
      int i2 = 0;
      if(k != this.anInt1431) {
         this.aBoolean1438 = !this.aBoolean1438;
      }

      int l2;
      if(j < DrawingArea.topY) {
         l2 = DrawingArea.topY - j;
         j1 -= l2;
         j = DrawingArea.topY;
         i1 += l2 * k1;
         l += l2 * DrawingArea.width;
      }

      if(j + j1 > DrawingArea.bottomY) {
         j1 -= j + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 -= l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method347(l, k1, j1, i2, i1, 28339, l1, this.myPixels, DrawingArea.pixels);
      }
   }

   private void method347(int i, int j, int k, int l, int i1, int j1, int k1, int[] ai, int[] ai1) {
      int l1 = -(j >> 2);
      j = -(j & 3);

      for(int i2 = -k; i2 < 0; ++i2) {
         int k2;
         for(k2 = l1; k2 < 0; ++k2) {
            ai1[i++] = ai[i1++];
            ai1[i++] = ai[i1++];
            ai1[i++] = ai[i1++];
            ai1[i++] = ai[i1++];
         }

         for(k2 = j; k2 < 0; ++k2) {
            ai1[i++] = ai[i1++];
         }

         i += k1;
         i1 += l;
      }

      if(j1 != 28339) {
         this.anInt1431 = 90;
      }

   }

   public void drawARGBSprite(int xPos, int yPos, int alpha) {
      int alphaValue = alpha;
      xPos += this.drawOffsetX;
      yPos += this.drawOffsetY;
      int i1 = xPos + yPos * DrawingArea.width;
      int j1 = 0;
      int spriteHeight = this.myHeight;
      int spriteWidth = this.myWidth;
      int i2 = DrawingArea.width - spriteWidth;
      int j2 = 0;
      int i3;
      if(yPos < DrawingArea.topY) {
         i3 = DrawingArea.topY - yPos;
         spriteHeight -= i3;
         yPos = DrawingArea.topY;
         j1 += i3 * spriteWidth;
         i1 += i3 * DrawingArea.width;
      }

      if(yPos + spriteHeight > DrawingArea.bottomY) {
         spriteHeight -= yPos + spriteHeight - DrawingArea.bottomY;
      }

      if(xPos < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - xPos;
         spriteWidth -= i3;
         xPos = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(xPos + spriteWidth > DrawingArea.bottomX) {
         i3 = xPos + spriteWidth - DrawingArea.bottomX;
         spriteWidth -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(!(spriteWidth <= 0 || spriteHeight <= 0)) {
         this.renderARGBPixels(spriteWidth, spriteHeight, this.myPixels, DrawingArea.pixels, i1, alphaValue, j1, j2, i2);
      }

   }

   private void renderARGBPixels(int spriteWidth, int spriteHeight, int[] spritePixels, int[] renderAreaPixels, int pixel, int alphaValue, int i, int l, int j1) {
      int alpha = alphaValue;

      for(int height = -spriteHeight; height < 0; ++height) {
         for(int width = -spriteWidth; width < 0; ++width) {
            alphaValue = this.myPixels[i] >> 24 & alpha - 1;
            int alphaLevel = 256 - alphaValue;
            if(alphaLevel > 256) {
               alphaValue = 0;
            }

            if(alpha == 0) {
               alphaLevel = 256;
               alphaValue = 0;
            }

            int pixelColor = spritePixels[i++];
            if (pixelColor != 0) {
               int pixelValue = renderAreaPixels[pixel];
               drawAlpha(renderAreaPixels, pixel++, ((pixelColor & 0xff00ff) * alphaValue
                       + (pixelValue & 0xff00ff) * alphaLevel & 0xff00ff00)
                       + ((pixelColor & 0xff00) * alphaValue + (pixelValue & 0xff00) * alphaLevel
                       & 0xff0000) >> 8, alphaValue);
            } else {
               pixel++;
            }
         }

         pixel += j1;
         i += l;
      }

   }
   public static void drawAlpha(int[] pixels, int index, int value, int alpha) {

      // (int) x * 0x8081 >>> 23 is equivalent to (short) x / 255
      int outAlpha = alpha + ((pixels[index] >>> 24) * (255 - alpha) * 0x8081 >>> 23);
      pixels[index] = value & 0x00FFFFFF | outAlpha << 24;
   }
   public void drawSprite(int i, int k) {
      i += this.drawOffsetX;
      k += this.drawOffsetY;
      int l = i + k * DrawingArea.width;
      int i1 = 0;
      int j1 = this.myHeight;
      int k1 = this.myWidth;
      int l1 = DrawingArea.width - k1;
      int i2 = 0;
      int l2;
      if(k < DrawingArea.topY) {
         l2 = DrawingArea.topY - k;
         j1 -= l2;
         k = DrawingArea.topY;
         i1 += l2 * k1;
         l += l2 * DrawingArea.width;
      }

      if(k + j1 > DrawingArea.bottomY) {
         j1 -= k + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 -= l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method349(DrawingArea.pixels, this.myPixels, 0, i1, l, k1, j1, l1, i2);
      }

   }

   private void method349(int[] ai, int[] ai1, int i, int j, int k, int l, int i1, int j1, int k1) {
      int l1 = -(l >> 2);
      l = -(l & 3);

      for(int i2 = -i1; i2 < 0; ++i2) {
         int k2;
         for(k2 = l1; k2 < 0; ++k2) {
            i = ai1[j++];
            if(i != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }

            i = ai1[j++];
            if(i != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }

            i = ai1[j++];
            if(i != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }

            i = ai1[j++];
            if(i != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }
         }

         for(k2 = l; k2 < 0; ++k2) {
            i = ai1[j++];
            if(i != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }
         }

         k += j1;
         j += k1;
      }

   }

   public void method350(int i, int j, int k, boolean flag) {
      i += this.drawOffsetX;
      int i1;
      if(flag) {
         for(i1 = 1; i1 > 0; ++i1) {
            ;
         }
      }

      j += this.drawOffsetY;
      i1 = i + j * DrawingArea.width;
      int j1 = 0;
      int k1 = this.myHeight;
      int l1 = this.myWidth;
      int i2 = DrawingArea.width - l1;
      int j2 = 0;
      int i3;
      if(j < DrawingArea.topY) {
         i3 = DrawingArea.topY - j;
         k1 -= i3;
         j = DrawingArea.topY;
         j1 += i3 * l1;
         i1 += i3 * DrawingArea.width;
      }

      if(j + k1 > DrawingArea.bottomY) {
         k1 -= j + k1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - i;
         l1 -= i3;
         i = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(i + l1 > DrawingArea.bottomX) {
         i3 = i + l1 - DrawingArea.bottomX;
         l1 -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(l1 > 0 && k1 > 0) {
         this.method351(j1, l1, DrawingArea.pixels, 0, this.myPixels, j2, k1, i2, k, i1, 8);
      }
   }

   private void method351(int i, int j, int[] ai, int k, int[] ai1, int l, int i1, int j1, int k1, int l1, int i2) {
      int j2 = 256 - k1;

      for(int k2 = -i1; k2 < 0; ++k2) {
         for(int l2 = -j; l2 < 0; ++l2) {
            k = ai1[i++];
            if(k != 0) {
               int i3 = ai[l1];
               ai[l1++] = ((k & 16711935) * k1 + (i3 & 16711935) * j2 & -16711936) + ((k & '\uff00') * k1 + (i3 & '\uff00') * j2 & 16711680) >> 8;
            } else {
               ++l1;
            }
         }

         l1 += j1;
         i += l;
      }

      if(i2 < 8 || i2 > 8) {
         this.aBoolean1428 = !this.aBoolean1428;
      }

   }

   public void method352(int i, int j, int[] ai, int k, int[] ai1, int l, int i1, int j1, int k1, int l1, int i2) {
      while(l >= 0) {
         this.anInt1434 = 362;
      }

      try {
         int _ex = -l1 / 2;
         int k2 = -i / 2;
         int l2 = (int)(Math.sin((double)j / 326.11D) * 65536.0D);
         int i3 = (int)(Math.cos((double)j / 326.11D) * 65536.0D);
         l2 = l2 * k >> 8;
         i3 = i3 * k >> 8;
         int j3 = (i2 << 16) + k2 * l2 + _ex * i3;
         int k3 = (i1 << 16) + (k2 * i3 - _ex * l2);
         int l3 = k1 + j1 * DrawingArea.width;

         for(j1 = 0; j1 < i; ++j1) {
            int i4 = ai1[j1];
            int j4 = l3 + i4;
            int k4 = j3 + i3 * i4;
            int l4 = k3 - l2 * i4;

            for(k1 = -ai[j1]; k1 < 0; ++k1) {
               DrawingArea.pixels[j4++] = this.myPixels[(k4 >> 16) + (l4 >> 16) * this.myWidth];
               k4 += i3;
               l4 -= l2;
            }

            j3 += l2;
            k3 += i3;
            l3 += DrawingArea.width;
         }
      } catch (Exception var23) {
         ;
      }

   }

   public void method353(int i, int j, int k, int l, int i1, int j1, int k1, double d, int l1) {
      if(i1 == '\ua3e8') {
         try {
            int _ex = -k / 2;
            int j2 = -k1 / 2;
            int k2 = (int)(Math.sin(d) * 65536.0D);
            int l2 = (int)(Math.cos(d) * 65536.0D);
            k2 = k2 * j1 >> 8;
            l2 = l2 * j1 >> 8;
            int i3 = (l << 16) + j2 * k2 + _ex * l2;
            int j3 = (j << 16) + (j2 * l2 - _ex * k2);
            int k3 = l1 + i * DrawingArea.width;

            for(i = 0; i < k1; ++i) {
               int l3 = k3;
               int i4 = i3;
               int j4 = j3;

               for(l1 = -k; l1 < 0; ++l1) {
                  int k4 = this.myPixels[(i4 >> 16) + (j4 >> 16) * this.myWidth];
                  if(k4 != 0) {
                     DrawingArea.pixels[l3++] = k4;
                  } else {
                     ++l3;
                  }

                  i4 += l2;
                  j4 -= k2;
               }

               i3 += k2;
               j3 += l2;
               k3 += DrawingArea.width;
            }

         } catch (Exception var22) {
            ;
         }
      }
   }

   public void method354(Background background, boolean flag, int i, int j) {
      j += this.drawOffsetX;
      i += this.drawOffsetY;
      int k = j + i * DrawingArea.width;
      int l = 0;
      if(flag) {
         this.anInt1429 = -364;
      }

      int i1 = this.myHeight;
      int j1 = this.myWidth;
      int k1 = DrawingArea.width - j1;
      int l1 = 0;
      int k2;
      if(i < DrawingArea.topY) {
         k2 = DrawingArea.topY - i;
         i1 -= k2;
         i = DrawingArea.topY;
         l += k2 * j1;
         k += k2 * DrawingArea.width;
      }

      if(i + i1 > DrawingArea.bottomY) {
         i1 -= i + i1 - DrawingArea.bottomY;
      }

      if(j < DrawingArea.leftX) {
         k2 = DrawingArea.leftX - j;
         j1 -= k2;
         j = DrawingArea.leftX;
         l += k2;
         k += k2;
         l1 += k2;
         k1 += k2;
      }

      if(j + j1 > DrawingArea.bottomX) {
         k2 = j + j1 - DrawingArea.bottomX;
         j1 -= k2;
         l1 += k2;
         k1 += k2;
      }

      if(j1 > 0 && i1 > 0) {
         this.method355(this.myPixels, j1, background.aByteArray1450, i1, DrawingArea.pixels, 0, this.aBoolean1436, k1, k, l1, l);
      }
   }

   private void method355(int[] ai, int i, byte[] abyte0, int j, int[] ai1, int k, boolean flag, int l, int i1, int j1, int k1) {
      int l1 = -(i >> 2);
      int j2;
      if(!flag) {
         for(j2 = 1; j2 > 0; ++j2) {
            ;
         }
      }

      i = -(i & 3);

      for(j2 = -j; j2 < 0; ++j2) {
         int l2;
         for(l2 = l1; l2 < 0; ++l2) {
            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }

            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }

            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }

            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }
         }

         for(l2 = i; l2 < 0; ++l2) {
            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }
         }

         i1 += l;
         k1 += j1;
      }

   }
}
