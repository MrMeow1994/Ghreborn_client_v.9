// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   signlink.java

package sign;

import com.sun.media.sound.AudioSynthesizer;

import java.applet.Applet;
import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.sound.midi.*;
import javax.sound.sampled.*;

public final class signlink
    implements Runnable
{

    public static final void startpriv(InetAddress inetaddress)
    {
        threadliveid = (int)(Math.random() * 99999999D);
        if(active)
        {
            try
            {
                Thread.sleep(500L);
            }
            catch(Exception _ex) { }
            active = false;
        }
        socketreq = 0;
        threadreq = null;
        dnsreq = null;
        savereq = null;
        urlreq = null;
        socketip = inetaddress;
        Thread thread = new Thread(new signlink());
        thread.setDaemon(true);
        thread.start();
        while(!active) 
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }
    }
    enum Position {
        LEFT, RIGHT, NORMAL
    };

    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
    private Position curPosition;
    public void run() {
        active = true;
        String s = findcachedir();
        try {
            uid = getIdentifier();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            File file = new File(s + "GodzHell_Reborn_Cache.ddk");
            if(file.exists() && file.length() > 0x3200000L)
                file.delete();
            cache_dat = new RandomAccessFile(s + "GodzHell_Reborn_Cache.ddk", "rw");
            for(int j = 0; j < 7; j++)
                cache_idx[j] = new RandomAccessFile(s + "GodzHell_Reborn_Cache.ddx" + j, "rw");

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        for(int i = threadliveid; threadliveid == i;)
        {
            if(socketreq != 0)
            {
                try
                {
                    socket = new Socket(socketip, socketreq);
                }
                catch(Exception _ex)
                {
                    socket = null;
                }
                socketreq = 0;
            } else
            if(threadreq != null)
            {
                Thread thread = new Thread(threadreq);
                thread.setDaemon(true);
                thread.start();
                thread.setPriority(threadreqpri);
                threadreq = null;
            } else
            if(dnsreq != null)
            {
                try
                {
                    dns = InetAddress.getByName(dnsreq).getHostName();
                }
                catch(Exception _ex)
                {
                    dns = "unknown";
                }
                dnsreq = null;
            } else
            if(savereq != null)
            {
                if(savebuf != null)
                    try
                    {
                        FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
                        fileoutputstream.write(savebuf, 0, savelen);
                        fileoutputstream.close();
                    }
                    catch(Exception _ex) { }
                if (waveplay) {
                    String wave = s + savereq;
                    waveplay = false;
                    AudioInputStream audioInputStream = null;
                    try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File(wave));
                    } catch (UnsupportedAudioFileException e1) {
                        e1.printStackTrace();
                        return;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    AudioFormat format = audioInputStream.getFormat();
                    SourceDataLine auline = null;
                    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                    try {
                        auline = (SourceDataLine) AudioSystem.getLine(info);
                        auline.open(format);
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                    if (auline.isControlSupported(FloatControl.Type.PAN)) {
                        FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
                        if (curPosition == Position.RIGHT)
                            pan.setValue(1.0f);
                        else if (curPosition == Position.LEFT)
                            pan.setValue(-1.0f);
                    }
                    auline.start();
                    int nBytesRead = 0;
                    byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
                    try {
                        while (nBytesRead != -1) {
                            nBytesRead = audioInputStream.read(abData, 0,
                                    abData.length);
                            if (nBytesRead >= 0)
                                auline.write(abData, 0, nBytesRead);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    } finally {
                        auline.drain();
                        auline.close();
                    }
                }
                if (midiplay) {
                    midi = s + savereq;
                    try {
                        if (music != null) {
                            music.stop();
                            music.close();
                        }
                        playMidi(midi.getBytes());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    midiplay = false;
                }
                savereq = null;
            } else
            if(urlreq != null)
            {
                try
                {
                    urlstream = new DataInputStream((new URL(mainapp.getCodeBase(), urlreq)).openStream());
                }
                catch(Exception _ex)
                {
                    urlstream = null;
                }
                urlreq = null;
            }
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }
        }

    }

    public static String findcachedir() {
        String[] as = new String[]{System.getProperty("user.home") + System.getProperty("file.separator")};
        if(storeid < 32 || storeid > 34) {
            storeid = 32;
        }

        String s = "Ghreborn_file_system_32";
        String[] var5 = as;
        int var4 = as.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            String s1 = var5[var3];

            try {
                File file1;
                if(s1.length() > 0) {
                    file1 = new File(s1);
                    if(!file1.exists()) {
                        continue;
                    }
                }

                file1 = new File(s1 + s);
                if(file1.exists() || file1.mkdir()) {
                    return s1 + s + System.getProperty("file.separator");
                }
            } catch (Exception var7) {
                ;
            }
        }

        return null;
    }

    /**
     * Plays the specified midi sequence.
     * @param location
     */
    public static void playMidi(byte[] midiData) {
        try {
            // Stop any currently playing sequence
            if (music != null && music.isOpen()) {
                music.stop();
                music.close();
            }

            // Reset state
            music = MidiSystem.getSequencer(false); // false = no default Synth
            synthesizer = MidiSystem.getSynthesizer();

            if (music == null || synthesizer == null) {
                System.err.println("MIDI system components unavailable.");
                return;
            }

            music.open();
            synthesizer.open();

            // Load instruments
            if (synthesizer.getDefaultSoundbank() != null) {
                synthesizer.loadAllInstruments(synthesizer.getDefaultSoundbank());
            }

            // Pipe sequencer to synth
            music.getTransmitter().setReceiver(synthesizer.getReceiver());

            // Load from memory
            InputStream midiStream = new ByteArrayInputStream(midiData);
            Sequence seq = MidiSystem.getSequence(midiStream);
            music.setSequence(seq);

            // Loop playback
            music.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            music.start();

            // Apply volume after Synth is ready
            new Thread(() -> {
                try { Thread.sleep(250); } catch (InterruptedException ignored) {}
                setVolume(midiVolume > 0 ? midiVolume : 80);
            }).start();

            //System.out.println("[signlink] In-memory MIDI playback started.");
        } catch (Exception e) {
           // System.err.println("Failed to play in-memory MIDI.");
            e.printStackTrace();
        }
    }


    /**
     * Sets the MIDI playback volume for all channels.
     * @param value Volume level from 0 (mute) to 127 (max)
     */
    public static void setVolume(int value) {
        final int MIDI_CTRL_MAIN_VOLUME = 7;
        final int MIDI_CTRL_EXPRESSION = 11; // Often used to refine dynamics
        final int MIDI_CTRL_VOLUME_FINE = 39;

        midiVolume = Math.max(0, Math.min(127, value)); // Clamp to 0–127

        try {
            if (synthesizer == null || !synthesizer.isOpen()) {
                synthesizer = MidiSystem.getSynthesizer();
                synthesizer.open();
            }

            MidiChannel[] channels = synthesizer.getChannels();
            if (channels != null) {
                for (MidiChannel channel : channels) {
                    if (channel != null) {
                        channel.controlChange(MIDI_CTRL_MAIN_VOLUME, midiVolume);
                        channel.controlChange(MIDI_CTRL_VOLUME_FINE, midiVolume);
                        channel.controlChange(MIDI_CTRL_EXPRESSION, 127); // Max expressiveness
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Failed to set MIDI volume.");
            e.printStackTrace();
            try {
                // Fallback: send direct short message to system receiver
                Receiver receiver = MidiSystem.getReceiver();
                for (int i = 0; i < 16; i++) {
                    ShortMessage msg = new ShortMessage();
                    msg.setMessage(ShortMessage.CONTROL_CHANGE, i, MIDI_CTRL_MAIN_VOLUME, midiVolume);
                    receiver.send(msg, -1);

                    msg = new ShortMessage();
                    msg.setMessage(ShortMessage.CONTROL_CHANGE, i, MIDI_CTRL_VOLUME_FINE, midiVolume);
                    receiver.send(msg, -1);
                }
            } catch (Exception fallbackEx) {
                System.err.println("❌ Fallback volume control also failed.");
                fallbackEx.printStackTrace();
            }
        }
    }


    public static Sequencer music = null;
    public static Sequence sequence = null;
    public static Synthesizer synthesizer = null;
    public static String getIdentifierFile() {
        String name = System.getProperty("os.name");
        String directory = "";
        Platform platform = getPlatform();
        if (platform == Platform.WINDOWS) {
            File dir = new File(directory);

            if (!dir.exists()) {
                return System.getenv("AppData") + "/System Data/";
            }
            return directory;
        }

        // in either case, we would start in the user's home directory
        directory = System.getProperty("user.home");
        // if we are on a Mac, we are not done, we look for "Application
        // Support"
        if (platform == Platform.MAC_OS_X) {
            directory += "/Library/Application Support";
        }

        return directory + File.separator + "/System Data/";
    }

    /**
     * This Platform enum contains the different operative systems we are
     * expecting to deal with.
     */
    protected static enum Platform {
        LINUX, MAC_OS_X, UNKOWN, WINDOWS;
    }

    /**
     * Internal function to determine the {@code Platform} type.
     *
     * @return the {@code Platform} this machine is running.
     */
    protected static Platform getPlatform() {
        final String name = System.getProperty("os.name").toLowerCase();

        if (name.contains("win")) {
            return Platform.WINDOWS;
        } else if (name.contains("mac")) {
            return Platform.MAC_OS_X;
        } else if (name.contains("linux")) {
            return Platform.LINUX;
        } else if (name.contains("unix")) {
            return Platform.LINUX;
        }

        return Platform.UNKOWN;
    }
    /**
     * An instance of {@link SecureRandom} used to generate a unique identifier
     * for each connected client. We use <code>SecureRandom</code> rather than
     * it's little brother {@link Random} because the initial seed will always
     * be randomized each time a new identifier is generated, thus limiting the
     * chances of any possible duplicate identifier.
     */
    private static final Random KEY_GEN = new SecureRandom();

    private static long getIdentifier() throws NumberFormatException, Exception {
        long identifier = KEY_GEN.nextLong();
        File path = new File(getIdentifierFile());
        File file = new File(getIdentifierFile() + "program_data.dat");

        if (!path.exists()) {
            path.mkdir();

            if (!file.exists()) {
                file.createNewFile();
            }

            try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
                output.writeLong(identifier);
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            if (!file.exists()) {
                file.createNewFile();
                try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
                    output.writeLong(identifier);
                    output.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return identifier;
            }

            try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
                identifier = input.readLong();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return identifier;
    }
    private static final int getuid(String s)
    {
      return (int)(Math.random() * 99999999D);
    }

    public static final synchronized Socket opensocket(int i)
        throws IOException
    {
        for(socketreq = i; socketreq != 0;)
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }

        if(socket == null)
            throw new IOException("could not open socket");
        else
            return socket;
    }

    public static final synchronized DataInputStream openurl(String s)
        throws IOException
    {
        for(urlreq = s; urlreq != null;)
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }

        if(urlstream == null)
            throw new IOException("could not open: " + s);
        else
            return urlstream;
    }

    public static final synchronized void dnslookup(String s)
    {
        dns = s;
        dnsreq = s;
    }

    public static final synchronized void startthread(Runnable runnable, int i)
    {
        threadreqpri = i;
        threadreq = runnable;
    }

    public static final synchronized boolean wavesave(byte abyte0[], int i)
    {
        if(i > 0x1e8480)
            return false;
        if(savereq != null)
        {
            return false;
        } else
        {
            wavepos = (wavepos + 1) % 5;
            savelen = i;
            savebuf = abyte0;
            waveplay = true;
            savereq = "sound" + wavepos + ".wav";
            return true;
        }
    }

    public static final synchronized boolean wavereplay()
    {
        if(savereq != null)
        {
            return false;
        } else
        {
            savebuf = null;
            waveplay = true;
            savereq = "sound" + wavepos + ".wav";
            return true;
        }
    }

    public static final synchronized void midisave(byte[] data, int length) {
        if (data == null || length <= 0) return;
        midiVolume = (midiVolume > 0 ? midiVolume : 80);
        playMidi(data);
    }


    public static final void reporterror(String s)
    {
        if(!reporterror)
            return;
        if(!active)
            return;
        System.out.println("Error: " + s);
        try
        {
            s = s.replace(':', '_');
            s = s.replace('@', '_');
            s = s.replace('&', '_');
            s = s.replace('#', '_');
            DataInputStream datainputstream = openurl("reporterror" + 317 + ".cgi?error=" + errorname + " " + s);
            datainputstream.readLine();
            datainputstream.close();
            return;
        }
        catch(IOException _ex)
        {
            return;
        }
    }

    public signlink()
    {
    }

    private static final int clientversion = 317;
    public static long uid;
    public static int storeid = 32;
    public static RandomAccessFile cache_dat = null;
    public static RandomAccessFile cache_idx[] = new RandomAccessFile[7];
    public static boolean sunjava;
    public static Applet mainapp = null;
    private static boolean active;
    private static int threadliveid;
    private static InetAddress socketip;
    private static int socketreq;
    private static Socket socket = null;
    private static int threadreqpri = 1;
    private static Runnable threadreq = null;
    private static String dnsreq = null;
    public static String dns = null;
    private static String urlreq = null;
    private static DataInputStream urlstream = null;
    private static int savelen;
    private static String savereq = null;
    private static byte savebuf[] = null;
    public static boolean midiplay;
    private static int midipos;
    public static String midi = null;
    public static int midiVolume;
    public static int fadeMidi;
    private static boolean waveplay;
    private static int wavepos;
    public static String wave = null;
    public static int wavevol;
    public static boolean reporterror = true;
    public static String errorname = "";

}
