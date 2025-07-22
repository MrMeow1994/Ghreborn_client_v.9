import java.time.LocalDateTime;

public class Configuration {
    public static boolean LIVE = true;// Change to true for live client.
    public static final String SERVER_ADDRESS = LIVE ? "ghreborn.ddns.net" : "127.0.0.1";
    public static final int PORT = 29432;
    public static final int TEST_PORT = 43595;
    public static boolean developerMode = false;

    public static final LocalDateTime LAUNCH_TIME = LocalDateTime.now();
    public static final String ERROR_LOG_DIRECTORY = "error_logs/";
    public static String ERROR_LOG_FILE = ("error_log_"
            + LAUNCH_TIME.getYear() + "_"
            + LAUNCH_TIME.getMonth() + "_"
            + LAUNCH_TIME.getDayOfMonth()
            + ".txt").toLowerCase();

    public static boolean dumpDataLists = false;
    public static boolean dumpAnimationData = false;
    public static boolean Enable_JagGrab = true;
    public static boolean Dump_crcs = false;
    public static boolean smoothShading = true;
    public static boolean hdTexturing = false;
    public static boolean distanceFog = false;
    public static boolean xp_merge = false;
}
