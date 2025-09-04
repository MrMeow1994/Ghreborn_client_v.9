import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundPlayer implements Runnable {

        private AudioInputStream stream;
        private InputStream soundStream;
        private Thread player;
        private int delay;
        private int soundLevel;
        public static int volume = 0; // 0 = max, 10 = mute

        public SoundPlayer(byte[] data, int soundLevel, int delay) {
                if (data == null || soundLevel <= 0 || soundLevel > 10 || volume >= 10) return;
                this.soundStream = new ByteArrayInputStream(data);
                this.soundLevel = soundLevel;
                this.delay = delay;
                this.player = new Thread(this);
                this.player.start();
        }

        public SoundPlayer(InputStream inputStream, int soundLevel, int delay) {
                if (inputStream == null || soundLevel <= 0 || soundLevel > 10 || volume >= 10) return;
                this.soundStream = inputStream;
                this.soundLevel = soundLevel;
                this.delay = delay;
                this.player = new Thread(this);
                this.player.start();
        }

        @Override
        public void run() {
                try {
                        AudioFormat format = new AudioFormat(
                                AudioFormat.Encoding.PCM_UNSIGNED,
                                22050.0f,
                                8,
                                1,
                                1,
                                22050.0f,
                                false
                        );

                        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                        if (!AudioSystem.isLineSupported(info)) {
                                System.err.println("❌ SourceDataLine format not supported!");
                                return;
                        }

                        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                        line.open(format);

                        // Set gain BEFORE starting the line
                        float userMultiplier = (10 - getVolume()) / 10.0f;
                        float scaled = (soundLevel / 10.0f) * userMultiplier;
                        float dB = getDecibels(scaled);

                        if (line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                                FloatControl gainControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                                dB = Math.max(gainControl.getMinimum(), Math.min(dB, gainControl.getMaximum()));
                                gainControl.setValue(dB);
                        }

                        // 🧼 Pre-fill the line with ~50ms of silence
                        byte[] silence = new byte[1102]; // 22050Hz * 0.05s = 1102 bytes
                        for (int i = 0; i < silence.length; i++) silence[i] = (byte) 0x80; // silence for unsigned PCM

                        line.start();
                        line.write(silence, 0, silence.length);
                        line.flush();

                        // 🔁 Micro delay to let audio driver settle
                        Thread.sleep(10);

                        // Now write actual data
                        byte[] buffer = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = soundStream.read(buffer)) != -1) {
                                line.write(buffer, 0, bytesRead);
                        }

                        line.drain();
                        line.stop();
                        line.close();
                        soundStream.close();

                        player.interrupt();
                } catch (Exception e) {
                        player.interrupt();
                        e.printStackTrace();
                }
        }


        public static void setVolume(int level) {
                volume = Math.max(0, Math.min(10, level)); // 0 = max, 10 = mute
        }

        public static int getVolume() {
                return volume;
        }

        // 🔈 Maps 0.0–1.0 linear gain to decibels
        public float getDecibels(float gain) {
                if (gain <= 0f) return -80f;
                if (gain >= 1f) return 6f;
                return (float) (20.0 * Math.log10(gain));
        }
}
