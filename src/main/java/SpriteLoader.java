import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public final class SpriteLoader implements Closeable {
    private Sprite[] cache;
    private static final Map<String, Sprite> spriteMap = new HashMap();
    private FileChannel dataChannel;
    private FileChannel metaChannel;

    public SpriteLoader() {
    }

    private static BufferedImage convert(BufferedImage image, int type) {
        BufferedImage converted = new BufferedImage(image.getWidth(), image.getHeight(), type);
        converted.getGraphics().drawImage(image, 0, 0, (ImageObserver)null);
        return converted;
    }

    public void init(Path dataFile, Path metaFile) throws IOException {
        this.dataChannel = FileChannel.open(dataFile, StandardOpenOption.READ);
        this.metaChannel = FileChannel.open(metaFile, StandardOpenOption.READ);
        int spriteCount = Math.toIntExact(this.metaChannel.size() / 10L);
        this.cache = new Sprite[spriteCount];
        System.out.println("Loaded " + spriteCount + " sprites!");

    }

    public Sprite lookup(int id) {
        try {
            if (this.contains(id)) {
                return this.cache[id];
            } else if (this.dataChannel.isOpen() && this.metaChannel.isOpen()) {
                int entries = Math.toIntExact(this.metaChannel.size() / 10L);
                if (id > entries) {
                    System.out.printf("id=%d > size=%d%n", id, entries);
                    return null;
                } else {
                    this.metaChannel.position((long)(id * 10));
                    ByteBuffer metaBuf = ByteBuffer.allocate(10);
                    this.metaChannel.read(metaBuf);
                    metaBuf.flip();
                    int pos = (metaBuf.get() & 255) << 16 | (metaBuf.get() & 255) << 8 | metaBuf.get() & 255;
                    int len = (metaBuf.get() & 255) << 16 | (metaBuf.get() & 255) << 8 | metaBuf.get() & 255;
                    int offsetX = metaBuf.getShort() & 255;
                    int offsetY = metaBuf.getShort() & 255;
                    ByteBuffer dataBuf = ByteBuffer.allocate(len);
                    this.dataChannel.position((long)pos);
                    this.dataChannel.read(dataBuf);
                    dataBuf.flip();

                    Object pixels;
                    try (InputStream is = new ByteArrayInputStream(dataBuf.array())) {
                        BufferedImage bimage = ImageIO.read(is);
                        if (bimage != null) {
                            if (bimage.getType() != 2) {
                                bimage = convert(bimage, 2);
                            }

                            int[] pixels2 = ((DataBufferInt)bimage.getRaster().getDataBuffer()).getData();
                            Sprite sprite = new Sprite(bimage.getWidth(), bimage.getHeight(), offsetX, offsetY, pixels2);
                            this.cache[id] = sprite;
                            Sprite var14 = sprite;
                            return var14;
                        }

                        System.out.printf("Could not read image at %d%n", id);
                        pixels = null;
                    }

                    return (Sprite)pixels;
                }
            } else {
                System.out.println("Sprite channels are closed!");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("No sprite found for id=%d%n", id);
            return null;
        }
    }

    public static Sprite lookup(String id) {
        if (spriteMap.containsKey(id)) {
            return (Sprite)spriteMap.get(id);
        } else {
            Sprite sprite = new Sprite(id);
            if (sprite == null) {
                System.out.println("Can't find sprite " + id);
                return null;
            } else {
                spriteMap.put(id, sprite);
                return sprite;
            }
        }
    }

    public static Sprite setHeight(String id, int height) {
        if (!spriteMap.containsKey(id)) {
            lookup(id);
            return setHeight(id, height);
        } else {
            Sprite sprite = lookup(id);
            sprite.myHeight = height;
            Sprite.height = height;
            spriteMap.put(id, sprite);
            return sprite;
        }
    }

    public boolean contains(int id) {
        return id < this.cache.length && this.cache[id] != null;
    }

    public void set(int id, Sprite sprite) {
        if (this.contains(id)) {
            this.cache[id] = sprite;
        }
    }

    public void close() throws IOException {
        this.dataChannel.close();
        this.metaChannel.close();
    }
}
