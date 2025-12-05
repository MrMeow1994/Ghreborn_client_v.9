import java.util.*;

public class ParticleAttachment {

    private static final Map<Integer, int[][]> attachments = new HashMap<>();

    public static int[][] getAttachments(int model) {
        return attachments.get(model);
    }

    static {
        // Completionist cape
        attachments.put(65297, new int[][] { { 494, 0 }, { 488, 0 }, { 485, 0 }, { 476, 0 }, { 482, 0 }, { 479, 0 }, { 491, 0 } });
        attachments.put(65316, new int[][] { { 494, 0 }, { 488, 0 }, { 485, 0 }, { 476, 0 }, { 482, 0 }, { 479, 0 }, { 491, 0 } });

        /*master dungeoneering cape*/
        attachments.put(59885, new int[][] {{ 151, 19 }, { 149, 19 }, { 148, 19 }, { 147, 19 }, { 146, 19 }, { 170, 19 }, { 169, 19 }, { 168, 19 }, { 167, 19 }, { 118, 19 }, { 121, 19 }});

        attachments.put(63604, new int[][] {{ 151, 19 }, { 149, 19 }, { 148, 19 }, { 147, 19 }, { 146, 19 }, { 170, 19 }, { 169, 19 }, { 168, 19 }, { 167, 19 }, { 118, 19 }, { 121, 19 } });

    }
}