import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

public class MP3Player {
    private AdvancedPlayer player;
    private Thread thread;
    private volatile boolean isPlaying = false;
    private volatile boolean stopRequested = false;
    private boolean loop = false;

    private JSlider volumeSlider;
    private float volume = 1.0f; // Placeholder - not supported in JLayer directly

    public MP3Player() {
    }

    public void showVolumeControl() {
        JFrame frame = new JFrame("Volume Control");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(volumeSlider);
        frame.setSize(300, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void playFromURL(String urlString, boolean loop) {
        stop(); // prevent overlap
        this.loop = loop;
        stopRequested = false;

        thread = new Thread(() -> {
            do {
                try {
                    InputStream is = new BufferedInputStream(new URL(urlString).openStream());
                    player = new AdvancedPlayer(is);
                    isPlaying = true;

                    player.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                            isPlaying = false;
                        }
                    });

                    player.play();
                } catch (Exception e) {
                    System.err.println("MP3Player error: " + e.getMessage());
                    break;
                }
            } while (loop && !stopRequested);
        });
        thread.start();
    }

    public void stop() {
        stopRequested = true;
        isPlaying = false;

        try {
            if (player != null) {
                player.close();
            }
            if (thread != null && thread.isAlive()) {
                thread.interrupt();
            }
        } catch (Exception ignored) {}
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
