import java.util.HashMap;
import java.util.Map;

public class SoundCache {
        private static final Map<Integer, byte[]> cache = new HashMap<>();

        public static void preload(int soundId) {
                if (!cache.containsKey(soundId)) {
                        client.onDemandFetcher.method558(5, soundId); // fetch in advance
                }
        }

        public static void store(int soundId, byte[] data) {
                cache.put(soundId, data);
        }

        public static byte[] get(int soundId) {
                return cache.get(soundId);
        }

        public static boolean isReady(int soundId) {
                return cache.containsKey(soundId);
        }
}
