import java.applet.AppletContext;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Desktop.Action;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractMap.SimpleEntry;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

import com.google.common.base.Preconditions;
import sign.signlink;

public class client extends Applet_Sub1 {
    public static boolean controlIsDown;
    public static int cameratoggle;
    private String clanname;
    private boolean prayClicked;
    private boolean specialHover;
    private boolean autocast;
    public boolean isPoisoned;
    public boolean clickedQuickPrayers;
    public int xpAddedPos;
    public int expAdded;
    private long totalExp;
    private int anInt898;
    public String[] playerTitles;
    private int menuScreenArea;
    private int anInt1020;
    private int anInt1040;
    private int anInt1041;
    public boolean broadcastActive;
    public String broadcastMessage;
    private static int aPort;
    private static final byte aByte1200 = 9;
    int anInt1237;
    int anInt1238;
    private int anInt1275;
    public static int anInt1290;
    public static int showpackets;
    public static int showframeids;
    private String inputString;
    private int anInt1186;
    private int anInt1187;
    public static client.ScreenMode currentScreenMode;
    public static int currentGameWidth;
    public static int currentGameHeight;
    public static int screenAreaWidth;
    public static int screenAreaHeight;
    private static boolean changeChatArea;
    private static boolean changeTabArea;
    public static int cameraZoom;
    public static int log_view_dist = 9;
    private static boolean showChatComponents;
    private static boolean showTabComponents;
    public static int[] fullScreenTextureArray;
    private static int[] anIntArray1180;
    private static int[] anIntArray1181;
    private static int[] anIntArray1182;
    private static RSImageProducer aRSImageProducer_1165;
    private static boolean aBoolean1224 = true;
    private int menuActionRow;
    private int digits;
    private int modifiableXValue = 1; // u dont care if it starts at 1? Can't see a real problem with it :P kk
    public static int TotalRead = 0;
    private final Sprite[] inputSprites = new Sprite[7];
    private boolean aBoolean872;
    private int packet;
    private boolean aBoolean991;
    private int anInt1211;
    private static int anInt957 = 10;
    static int ondemand_offset;
    private static boolean aBoolean959 = true;
    public static String server;
    public static client instance;
    private boolean aBoolean1242;
    private int anInt989;
    private int anInt1084;
    private int anInt1085;
    private int anInt1086;
    private int anInt1087;
    private int anInt1088;
    private boolean menuOpen;
    private boolean inputTaken;
    private int anInt985;
    public static boolean loggedIn;
    public static int fadingTo;
    private static int anInt1097;
    private static int anInt1051;
    private int anInt1071;
    private DoubleEndedQueue[][][] aDoubleEndedQueueArrayArrayArray827;
    private int anInt886;
    private int anInt1066;
    private int anInt1067;
    private int currentSound;
    private int anInt839;
    private int anInt893;
    private int publicChatMode;
    private boolean aBoolean1233;
    private static int anInt940;
    private int privateChatMode;
    private int tradeMode;
    private String reportAbuseInput;
    private boolean canMute;
    static int openInterfaceID;
    private int reportAbuseInterfaceID;
    private int anInt961;
    private boolean musicEnabled;
    private boolean aBoolean848;
    private int anInt1253;
    private boolean aBoolean1255;
    private int anInt1249;
    private int splitPrivateChat;
    private int anInt913;
    private int nextSong;
    private boolean songChanging;
    private int previousSong;
    private int anInt974;
    private int spriteDrawX;
    private int spriteDrawY;
    private int friendsCount;
    private boolean tabAreaAltered;
    private byte[] aByteArray912;
    private static int anInt854;
    private int xCameraPos;
    private int zCameraPos;
    private int yCameraPos;
    private static boolean aBoolean919 = true;
    private int yCameraCurve;
    private int xCameraCurve;
    private static int anInt846;
    private Pattern pattern;

    private Matcher matcher;
    private Class24 socketStream;
    private int anInt833;
    private int currentSong;
    private boolean aBoolean1031;
    private int npcCount;
    static int loopCycle;
    private int anInt1261;
    private int inputDialogState;
    private boolean messagePromptRaised;
    private String promptInput;
    private int friendsListAction;
    private String aString1121;
    private int anInt1011;
    private boolean aBoolean1047;
    private Background aBackground_966;
    private Background aBackground_967;
    private Background[] aBackgroundArray1152;
    private static boolean aBoolean1231;
    private Sprite aSprite_1201;
    private Sprite aSprite_1202;
    private int[] anIntArray851;
    private int[] anIntArray852;
    private int[] anIntArray853;
    private int[] anIntArray850;
    private int[] anIntArray1190;
    private int[] anIntArray1191;
    private int[] anIntArray828;
    private int[] anIntArray829;
    private volatile boolean aBoolean880;
    private volatile boolean aBoolean831;
    private static boolean lowMemory;
    private long aLong824;
    private int anInt1023;
    private int anInt883;
    private int anInt1104;
    private int anInt1016;
    private boolean aBoolean1017;
    boolean aBoolean954;
    private int anInt1009;
    private int anInt945;
    private int anInt916;
    private int crossType;
    private int atInventoryLoopCycle;
    private int atInventoryInterfaceType;
    private String aString844;
    private int anInt1213;
    private int anInt914;
    private int anInt915;
    private int anInt988;
    private int anInt1278;
    private int anInt1279;
    private int anInt1131;
    private int anInt896;
    private int anInt1132;
    private int anInt897;
    private int anInt1254;
    private int anInt1209;
    private int anInt1210;
    private int anInt1170;
    private int anInt1171;
    private int anInt1010;
    private int cButtonHPos = -1;
    private int cButtonCPos = 0;
    private int chatTypeView = 0;
    private int setChannel;
    private static RSImageProducer aRSImageProducer_1166;
    private RSImageProducer aRSImageProducer_1164;
    private static RSImageProducer aRSImageProducer_1163;
    private RSImageProducer aRSImageProducer_1125;
    private RSImageProducer aRSImageProducer_1110;
    private RSImageProducer aRSImageProducer_1111;
    private RSImageProducer aRSImageProducer_1107;
    private RSImageProducer aRSImageProducer_1108;
    private RSImageProducer aRSImageProducer_1109;
    private RSImageProducer aRSImageProducer_1112;
    private RSImageProducer aRSImageProducer_1113;
    private RSImageProducer aRSImageProducer_1114;
    private RSImageProducer aRSImageProducer_1115;
    private int anInt1079;
    private String aString1049;
    private int anInt992;
    private boolean aBoolean972;
    private int packetSize;
    private int anInt1021;
    private int anInt1038;
    private int anInt1184;
    private int anInt1185;
    private int clanChatMode = 0;
    static int tabID;
    private int atInventoryInterface;
    private int atInventoryIndex;
    private static int anInt1188;
    private static int anInt924;
    private boolean aBoolean1149;
    private int anInt1136;
    private int anInt1137;
    private int anInt1138;
    private int anInt1282;
    String aString1139;
    private boolean aBoolean1103;
    private static int anInt986;
    public boolean expDrops = true;
    public boolean skillOrbs = true;
    private boolean runClicked = true;
    private static int anInt1226;
    private static int anInt1134;
    private static int anInt1175;
    private static int anInt1155;
    private long aLong953;
    private int anInt1283;
    private int anInt1284;
    private int anInt1285;
    String aString1286;
    private int anInt1251;
    MouseDetection aMouseDetection_879;
    public static OnDemandFetcher onDemandFetcher;
    private Stream aStream_834;
    private Stream stream;
    private Stream aStream_847;
    private Stream in;
    private int[] mapCoordinates;
    private byte[][] terrainData;
    private byte[][] mapData;
    private int[] terrainIndices;
    private int[] objectIndices;
    private int[][][] anIntArrayArrayArray1214;
    private Sprite[] BlackMap;
    private byte[][][] aByteArrayArrayArray1258;
    private Class25 aClass25_946;
    private Class11[] collisionMaps;
    private int[][] anIntArrayArray901;
    private int[][] anIntArrayArray825;
    private int[] anIntArray1280;
    private int[] anIntArray1281;
    private RSImageProducer leftFrame;
    private RSImageProducer topFrame;
    private Sprite aSprite_1196;
    private Background aBackground_1197;
    private Background worldswitch;
    private Sprite aSprite_1198;
    private Sprite Mapicon;
    private Sprite aSprite_1027;
    private Sprite aSprite_1028;
    private Sprite aSprite_1029;
    private Sprite[] sideIcons;
    private Sprite aSprite_1143;
    private Sprite aSprite_1144;
    private Background aBackground_1145;
    private Sprite aSprite_1146;
    private Sprite aSprite_1147;
    private Sprite aSprite_865;
    private Sprite aSprite_866;
    private Background aBackground_867;
    private Sprite aSprite_868;
    private Background aBackground_869;
    private Sprite compassImage;
    private Sprite[] aSpriteArray987;
    private Sprite[] headIcons;
    private Sprite[] skullIcons;
    private Sprite[] aSpriteArray1150;
    private Sprite aSprite_1074;
    private Sprite aSprite_1075;
    private Sprite aSprite_1076;
    private Sprite aSprite_1077;
    private Sprite aSprite_1078;
    private Background[] aBackgroundArray1060;
    private Sprite[] aSpriteArray1033;
    private int[][] anIntArrayArray929;
    private Player[] players;
    int[] anIntArray892;
    private int[] anIntArray894;
    private Stream[] aStreamArray895;
    int[] anIntArray840;
    private Npc[] npcs;
    int[] npcIndices;
    private DoubleEndedQueue aDoubleEndedQueue_1179;
    private DoubleEndedQueue aDoubleEndedQueue_1013;
    private DoubleEndedQueue aDoubleEndedQueue_1056;
    private int[] menuActionCmd2;
    private int[] menuActionCmd3;
    private int[] menuActionID;
    private long[] menuActionCmd1;
    private String[] menuActionName;
    public int[] variousSettings;
    private int[] anIntArray1072;
    private int[] anIntArray1073;
    private Sprite[] aSpriteArray1140;
    private Sprite minimapImage;
    private String[] friendsList;
    private long[] friendsListAsLongs;
    private int[] friendsNodeIDs;
    private String amountOrNameInput;
    static boolean fpsOn;
    static boolean clientData;
    private boolean transparentTabArea = false;
    public boolean roofsOff = false;
    private Sprite aSprite_931;
    private Sprite aSprite_932;
    private int anInt1026;
    private int anInt1048;
    private int anInt1039;
    private String aString1266;
    private String aString1267;
    private long aLong1215;
    private int myPrivilege;
    public static boolean aBoolean1205;
    private int currentSkill = -1;
    long aLong1220;
    int anInt1022;
    private int anInt841;
    private int anInt842;
    private int anInt843;
    private int hintType;
    private int anInt1262;
    private int anInt891;
    private ISAACRandomGen aISAACRandomGen_1000;
    static Player localPlayer;
    private int anInt900;
    private int dialogID;
    private int backDialogID;
    private int invOverlayInterfaceID;
    private int openWalkableInterface;
    private int anInt1055;
    private int anInt1054;
    private static int anInt1288;
    private static int anInt941;
    private static int anInt1260;
    private int anInt1264;
    private int anInt1257;
    private long aLong1172;
    private boolean aBoolean1252;
    private static boolean aBoolean993;
    private boolean aBoolean926;
    private FileArchive titleStreamLoader;
    private TextDrawingArea smallText;
    private TextDrawingArea regularText;
    private TextDrawingArea boldText;
    public RSFont newSmallFont;
    public RSFont newRegularFont;
    public RSFont newBoldFont;
    public RSFont newFancyFont;
    private TextDrawingArea aTextDrawingArea_1273;
    private Sprite aSprite_1001;
    private Sprite aSprite_870;
    private Sprite aSprite_871;
    private Sprite aSprite_1024;
    private Sprite aSprite_1025;
    public static boolean flip = false;
    public static boolean flip_s = false;
    public static boolean flip_r = false;
    private String macAddress;
    private int anInt1119;
    private static int anInt1117;
    private int anInt1218;
    private static int anInt1096 = -192;
    private int anInt939;
    static int anInt1089;
    private int anInt1014;
    private int anInt1015;
    private static int anInt1005;
    private int anInt984;
    static int anInt1061;
    private static int anInt1142;
    private static int anInt849;
    private int anInt822;
    private int anInt949;
    private int anInt950;
    private int anInt951;
    private int anInt952;
    private int anInt918;
    private boolean hpHover;
    private boolean prayHover;
    private boolean runHover;
    private boolean worldHover;
    private boolean expCounterHover;
    private Socket aSocket832;
    private volatile boolean drawingFlames;
    private int anInt1058;
    private int anInt1208;
    private int anInt1118;
    private int anInt1216;
    private String myUsername;
    private String myPassword;
    public static int zoom;
    public static int lftrit;
    public static int fwdbwd;
    private int xpCounter;
    private boolean loadingMap;
    private int anInt1167;
    private int anInt1154;
    private int anInt1120;
    private int anInt1193;
    private int anInt1006;
    private int anInt1268;
    private int anInt1269;
    private String clanUsername;
    private String clanMessage;
    private String clanTitle;
    private int channelRights;
    private boolean aBoolean1160;
    private int anInt1098;
    private int anInt1099;
    private int anInt1100;
    private int anInt1101;
    private int anInt1102;
    public static int MapX;
    public static int mapX;
    public static int MapY;
    public static int mapY;
    private boolean aBoolean1159;
    private int currentRegionX;
    private int currentRegionY;
    private int baseX;
    private int baseY;
    private boolean aBoolean1141;
    public long broadcastTimer;
    private int anInt1036;
    private int anInt1037;
    private int anInt1148;
    private int anInt1222;
    private int anInt933;
    private int anInt937;
    private int anInt938;
    private int anInt934;
    private int anInt935;
    private int anInt936;
    private int anInt1169;
    private int anInt878;
    private int anInt995;
    private int anInt996;
    private int anInt997;
    private int anInt998;
    private int anInt999;
    private int anInt1046;
    private int anInt884;
    private int renderCount;
    static boolean switching;
    static int step;
    public static int currentFogColor = 0;
    private FogHandler fogHandler = new FogHandler();
    public boolean FogToggle = false;
    public boolean skyLoad = true;
    public boolean runEnergy = false;
    public final int[] orbX = new int[]{0, 0, 24};
    public final int[] orbY = new int[]{41, 85, 122};
    public final int[] orbTextX = new int[]{15, 16, 40};
    public final int[] orbTextY = new int[]{67, 111, 148};
    public final int[] coloredOrbX = new int[]{27, 27, 51};
    public final int[] coloredOrbY = new int[]{45, 89, 126};
    public final int[] currentInterface = new int[]{4016, 4012, 149};
    public final int[] maximumInterface = new int[]{4017, 4013, 149};
    public final int[] orbIconX = new int[]{33, 30, 58};
    public final int[] orbIconY = new int[]{52, 92, 130};
    public boolean hp = true;
    public int resizeable = 0;
    public PlayerTitles playerTitle = new PlayerTitles();
    private String[] clanList = new String[100];
    public boolean loadOrbs = true;
    public int chattab = 0;
    private boolean sendingAutochat = false;
    private int[][] xp_added = new int[10][3];
    private Sprite[] skill_sprites;
    private final int[] chatRights;
    private int[] anIntArray965;
    private final int[] modeX;
    private final int[] modeNamesX;
    private final int[] modeNamesY;
    private final int[] channelButtonsX;
    private final String[] modeNames;
    final int[] sideIconsX;
    final int[] sideIconsY;
    final int[] sideIconsId;
    final int[] sideIconsTab;
    private final int[] redStonesX;
    private final int[] redStonesY;
    private final int[] redStonesId;
    private final int[] tabClickX;
    private final int[] tabClickStart;
    private final int[] tabClickY;
    private final int[] anIntArray1177;
    private final int anInt1239;
    private boolean aBoolean830;
    private int anInt838;
    private String[] clanTitles;
    private int[] currentExp;
    private int[] anIntArray873;
    private int anInt874;
    private int anInt875;
    private boolean[] aBooleanArray876;
    private int anInt877;
    private int anInt882;
    private int anInt888;
    private int maxPlayerCount;
    private int anInt902;
    private byte aByte920;
    private int anInt921;
    private int[] currentLevels;
    private byte aByte923;
    private long[] aLongArray925;
    private int anInt927;
    private int[] anIntArray928;
    private CRC32 aCRC32_930;
    private int[] chatTypes;
    private String[] chatNames;
    private String[] chatMessages;
    private int[] anIntArray968;
    private int[] anIntArray969;
    Class14[] aClass14Array970;
    private byte aByte973;
    private int anInt975;
    private int[] anIntArray976;
    private int[] anIntArray977;
    private int[] anIntArray978;
    private int[] anIntArray979;
    private int[] overheadTextColour;
    private int[] anIntArray981;
    private int[] overheadTextCycle;
    private String[] aStringArray983;
    private int[] anIntArray990;
    private boolean aBoolean994;
    private int anInt1002;
    private byte aByte1012;
    private int[] anIntArray1030;
    private boolean aBoolean1043;
    private int[] maximumLevels;
    private int[] anIntArray1045;
    private int anInt1050;
    private int[] anIntArray1052;
    private int[] anIntArray1057;
    private Widget aClass9_1059;
    private Sprite[] gameframe;
    private int anInt1063;
    private int[] anIntArray1065;
    private int anInt1081;
    private int[] anIntArray1090;
    private int anInt1105;
    private boolean aBoolean1106;
    private int anInt1116;
    private String[] aStringArray1127;
    private boolean[] aBooleanArray1128;
    private int[][][] anIntArrayArrayArray1129;
    private int anInt1135;
    public static int port = 29432;
    private boolean aBoolean1176;
    private byte aByte1194;
    private final int[] anIntArray1203;
    private boolean aBoolean1206;
    private final int[] sound;
    private final byte aByte1217;
    private final Sprite[] ModIcons;
    private int[] anIntArray1229;
    private int[] anIntArray1240;
    private int[] soundType;
    private int[] soundDelay;
    private final int[] soundVolume;
    private byte aByte1274;
    private boolean aBoolean1277;
    private int anInt1289;
    public static final ClientDiscordRPC RICH_PRESENCE = new ClientDiscordRPC();
    public static boolean newDamage = false;
    public static final Rectangle MAXIMUM_SCREEN_BOUNDS = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    public static int IDLE_TIME = '\uea60';
    public static boolean nearby = true;
    private static byte aByte823 = 77;
    private static BigInteger aBigInteger856 = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    static final int[][] anIntArrayArray1003 = new int[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010}, {8741, 12, '\ufa1e', '\ua89a', 7735, 8404, 1701, '\u961e', 24094, 10153, '\udd2d', 4783, 1341, 16578, '\u88bb', 25239}, {25238, 8742, 12, '\ufa1e', '\ua89a', 7735, 8404, 1701, '\u961e', 24094, 10153, '\udd2d', 4783, 1341, 16578, '\u88bb'}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
    private static BigInteger aBigInteger1032 = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    static int[] tabInterfaceIDs = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static String aString1162 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ";
    static final int[] anIntArray1204 = new int[]{9104, 10275, 7595, 3610, 7975, 8526, 918, '\u9792', 24466, 10145, '\ue51e', 5027, 1457, 16565, '\u88af', 25486};
    private static int[] anIntArray1019;
    public static int[] anIntArray1232;
    private final boolean loginmusicEnabled = true;

    public void appearInChat(String x) {
        this.pushMessage(" ", 80, x);
        System.out.println("Reached appearInChat for: " + x);
    }

    private static String getErrorLogDirectory() {
        return signlink.findcachedir() + Configuration.ERROR_LOG_DIRECTORY;
    }

    private static void enableExceptionLogging() throws IOException {
        if (!new File(getErrorLogDirectory()).exists()) {
            Preconditions.checkState(new File(getErrorLogDirectory()).mkdirs());
        }

        TeeOutputStream outputStream = new TeeOutputStream(System.err, new FileOutputStream(getErrorLogDirectory() + Configuration.ERROR_LOG_FILE, true));
        System.setErr(new PrintStream(outputStream));
    }
    private void drawInputField(Widget child, int xPosition, int yPosition, int width, int height) {
        int clickX = super.saveClickX, clickY = super.saveClickY;
        Sprite[] inputSprites = this.inputSprites;
        int xModification = 0, yModification = 0;
        for (int row = 0; row < width; row += 12) {
            if (row + 12 > width)
                row -= 12 - (width - row);
            inputSprites[6].drawSprite(xModification <= 0 ? xPosition + row : xPosition + xModification, yPosition);
            for (int collumn = 0; collumn < height; collumn += 12) {
                if (collumn + 12 > height)
                    collumn -= 12 - (height - collumn);
                inputSprites[6].drawSprite(xPosition + row,
                        yModification <= 0 ? yPosition + collumn : yPosition + yModification);
            }
        }
        inputSprites[1].drawSprite(xPosition, yPosition);
        inputSprites[0].drawSprite(xPosition, yPosition + height - 8);
        inputSprites[2].drawSprite(xPosition + width - 4, yPosition);
        inputSprites[3].drawSprite(xPosition + width - 4, yPosition + height - 8);
        xModification = 0;
        yModification = 0;
        for (int top = 0; top < width; top += 8) {
            if (top + 8 > width)
                top -= 8 - (width - top);
            inputSprites[5].drawSprite(xPosition + top, yPosition);
            inputSprites[5].drawSprite(xPosition + top, yPosition + height - 1);
        }
        for (int bottom = 0; bottom < height; bottom += 8) {
            if (bottom + 8 > height)
                bottom -= 8 - (height - bottom);
            inputSprites[4].drawSprite(xPosition, yPosition + bottom);
            inputSprites[4].drawSprite(xPosition + width - 1, yPosition + bottom);
        }
        String message = child.message;
        if (regularText.getTextWidth(message) > child.width - 10)
            message = message.substring(message.length() - (child.width / 10) - 1);
        if (child.displayAsterisks)
            this.regularText.method389(false, true, (xPosition + 4), child.textColor,
                    TextClass.method588(message, 0) +
                            (((!child.isInFocus ? 0 : 1) & (loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : ""),
                    (yPosition + (height / 2) + 6));
        else
            this.regularText.method389(false, true, (xPosition + 4), child.textColor,
                    message +
                            (((!child.isInFocus ? 0 : 1) & (loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : ""),
                    (yPosition + (height / 2) + 6));


        boolean clicked = false;
        if (currentScreenMode != ScreenMode.RESIZABLE) {
            int x = 516;
            int y = 168;
            clicked = clickX >= xPosition + x && clickX <= xPosition + x + child.width && clickY >= yPosition + y && clickY <= yPosition + y + child.height;
        } else {
            clicked = clickX >= xPosition && clickX <= xPosition + child.width && clickY >= yPosition && clickY <= yPosition + child.height;
        }

        if (clicked && !child.isInFocus && getInputFieldFocusOwner() != child) {
            if ((super.clickMode2 == 1 && !menuOpen)) {
                Widget.currentInputFieldId = child.id;
                setInputFieldFocusOwner(child);
                if (child.message != null && child.message.equals(child.defaultInputFieldText))
                    child.message = "";
                if (child.message == null)
                    child.message = "";
            }
        }
    }
    public void setInputFieldFocusOwner(Widget owner) {
        for (Widget rsi : Widget.interfaceCache)
            if (rsi != null)
                rsi.isInFocus = rsi == owner;
    }

    public Widget getInputFieldFocusOwner() {
        for (Widget rsi : Widget.interfaceCache)
            if (rsi != null)
                if (rsi.isInFocus)
                    return rsi;
        return null;
    }

    public void resetInputFieldFocus() {
        for (Widget rsi : Widget.interfaceCache)
            if (rsi != null)
                rsi.isInFocus = false;
        Widget.currentInputFieldId = -1;
    }

    public boolean isFieldInFocus() {
        if (openInterfaceID == -1 && invOverlayInterfaceID <= 0) {
            return false;
        }
        for (Widget rsi : Widget.interfaceCache) {
            if (rsi != null) {
                if (rsi.type == 16 && rsi.isInFocus) {
                    return true;
                }
            }
        }
        return false;
    }
    void sendPacket(int packet) {
        if(packet == 103) {
            this.stream.createFrame(103);
            this.stream.writeUnsignedByte(this.inputString.length() - 1);
            this.stream.writeString(this.inputString.substring(2));
            this.inputString = "";
        }

    }

    public void maps() {
        for(int MapIndex = 0; MapIndex < 3736; ++MapIndex) {
            byte[] abyte0 = this.GetMap(MapIndex);
            if(abyte0 != null && abyte0.length > 0) {
                this.aClass14Array970[4].method234(abyte0.length, abyte0, (byte)2, MapIndex);
            }
        }

    }

    void mouseWheelDragged(int i, int j) {
        if(this.mouseWheelDown) {
            this.anInt1186 += i * 3;
            this.anInt1187 += j << 1;
        }
    }

    public boolean isServerUpdating() {
        return this.anInt1104 > 0;
    }

    public boolean isResized() {
        return currentScreenMode != client.ScreenMode.FIXED;
    }

    public static void currentScreenMode(client.ScreenMode mode) {
        if(currentScreenMode != mode) {
            currentScreenMode = mode;
            if(mode == client.ScreenMode.FIXED) {
                currentGameWidth = 765;       // ✅ Total client width
                currentGameHeight = 503;      // ✅ Total client height

                screenAreaWidth = 516;        // ✅ Game viewport (rendered world) width
                screenAreaHeight = 338;       // ✅ Game viewport height

                changeChatArea = false;
                changeTabArea = false;
                cameraZoom = 600;
                log_view_dist = 9;
                changeChatArea = false;
                changeTabArea = false;
            } else if(mode == client.ScreenMode.RESIZABLE) {
                currentGameWidth = 766;
                currentGameHeight = 529;
                cameraZoom = 850;
                log_view_dist = 10;
            } else if(mode == client.ScreenMode.FULLSCREEN) {
                cameraZoom = 600;
                log_view_dist = 10;
                currentGameWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                currentGameHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            }

            rebuildFrameSize(mode, currentGameWidth, currentGameHeight);
            setBounds();
            System.out.println("ScreenMode: " + mode.toString());
        }

        showChatComponents = currentScreenMode == client.ScreenMode.FIXED?true:showChatComponents;
        showTabComponents = currentScreenMode == client.ScreenMode.FIXED?true:showTabComponents;
    }

    public void refreshFrameSize() {
        if(currentScreenMode == client.ScreenMode.RESIZABLE) {
            if(currentGameWidth != (this.appletClient()?this.method11(0).getWidth():this.gameFrame.getFrameWidth())) {
                currentGameWidth = this.appletClient()?this.method11(0).getWidth():this.gameFrame.getFrameWidth();
                screenAreaWidth = currentGameWidth;
                setBounds();
            }

            if(currentGameHeight != (this.appletClient()?this.method11(0).getHeight():this.gameFrame.getFrameHeight())) {
                currentGameHeight = this.appletClient()?this.method11(0).getHeight():this.gameFrame.getFrameHeight();
                screenAreaHeight = currentGameHeight;
                setBounds();
            }
        }

    }

    public static void rebuildFrameSize(client.ScreenMode screenMode, int screenWidth, int screenHeight) {
        try {
            screenAreaWidth = screenMode == client.ScreenMode.FIXED?516:screenWidth;
            screenAreaHeight = screenMode == client.ScreenMode.FIXED?338:screenHeight;
            currentGameWidth = screenWidth;
            currentGameHeight = screenHeight;
            instance.refreshFrameSize(screenMode == client.ScreenMode.FULLSCREEN, screenWidth, screenHeight, screenMode == client.ScreenMode.RESIZABLE, screenMode != client.ScreenMode.FIXED);
            setBounds();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    private boolean stackTabs() {
        return currentGameWidth < 1100;
    }

    private boolean checkMainScreenBounds() {
        return this.checkBounds(0, currentGameWidth - (this.stackTabs()?231:462), currentGameHeight - (this.stackTabs()?73:37), currentGameWidth, currentGameHeight)?false:(this.checkBounds(0, currentGameWidth - 225, 0, currentGameWidth, 170)?false:(this.checkBounds(0, currentGameWidth - 204, currentGameHeight - (this.stackTabs()?73:37) - 275, currentGameWidth, currentGameHeight)?false:!this.checkBounds(0, 0, currentGameHeight - 168, 516, currentGameHeight)));
    }

    static SimpleEntry getMostFrequentN2(ArrayList values) {
        ArrayList frequencies = new ArrayList();
        int maxIndex = 0;

        label26:
        for(int i = 0; i < values.size(); ++i) {
            int value = ((Integer)values.get(i)).intValue();

            for(int j = 0; j < frequencies.size(); ++j) {
                if(((Integer)((SimpleEntry)frequencies.get(j)).getKey()).intValue() == value) {
                    ((SimpleEntry)frequencies.get(j)).setValue(Integer.valueOf(((Integer)((SimpleEntry)frequencies.get(j)).getValue()).intValue() + 1));
                    if(((Integer)((SimpleEntry)frequencies.get(maxIndex)).getValue()).intValue() < ((Integer)((SimpleEntry)frequencies.get(j)).getValue()).intValue()) {
                        maxIndex = j;
                    }
                    continue label26;
                }
            }

            frequencies.add(new SimpleEntry(Integer.valueOf(value), Integer.valueOf(1)));
        }

        return (SimpleEntry)frequencies.get(maxIndex);
    }

    private boolean checkBounds(int type, int x1, int y1, int x2, int y2) {
        return type != 0?Math.pow((double)(x1 + type - x2), 2.0D) + Math.pow((double)(y1 + type - y2), 2.0D) < Math.pow((double)type, 2.0D):this.mouseX >= x1 && this.mouseX <= x2 && this.mouseY >= y1 && this.mouseY <= y2;
    }

    private static void setBounds() {
        Rasterizer.method365(currentGameWidth, currentGameHeight);
        fullScreenTextureArray = Rasterizer.lineOffsets;
        Rasterizer.method365(currentScreenMode == client.ScreenMode.FIXED?(aRSImageProducer_1166 != null?aRSImageProducer_1166.anInt316:519):currentGameWidth, currentScreenMode == client.ScreenMode.FIXED?(aRSImageProducer_1166 != null?aRSImageProducer_1166.anInt317:165):currentGameHeight);
        anIntArray1180 = Rasterizer.lineOffsets;
        Rasterizer.method365(currentScreenMode == client.ScreenMode.FIXED?(aRSImageProducer_1163 != null?aRSImageProducer_1163.anInt316:249):currentGameWidth, currentScreenMode == client.ScreenMode.FIXED?(aRSImageProducer_1163 != null?aRSImageProducer_1163.anInt317:335):currentGameHeight);
        anIntArray1181 = Rasterizer.lineOffsets;
        Rasterizer.method365(screenAreaWidth, screenAreaHeight);
        anIntArray1182 = Rasterizer.lineOffsets;
        method456();
    }

    public static void method456() {
        int[] ai = new int[9];

        for(int i8 = 0; i8 < 9; ++i8) {
            int k8 = 128 + i8 * 32 + 15;
            int l8 = 600 + k8 * 3;
            int i9 = Rasterizer.anIntArray1470[k8];
            ai[i8] = l8 * i9 >> 16;
        }

        if(currentScreenMode == client.ScreenMode.RESIZABLE && currentGameWidth >= 766 && currentGameWidth <= 1025 && currentGameHeight >= 504 && currentGameHeight <= 850) {
            log_view_dist = 9;
            cameraZoom = 575;
        } else if(currentScreenMode == client.ScreenMode.FIXED) {
            cameraZoom = 600;
        } else if(currentScreenMode != client.ScreenMode.FIXED || currentScreenMode == client.ScreenMode.FULLSCREEN) {
            log_view_dist = 10;
            cameraZoom = 600;
        }

        Class25.setupViewport(500, 800, currentScreenMode == client.ScreenMode.FIXED?516:screenAreaWidth, currentScreenMode == client.ScreenMode.FIXED?335:screenAreaHeight, ai);
        if(loggedIn) {
            aRSImageProducer_1165 = new RSImageProducer(screenAreaWidth, screenAreaHeight);
        }

    }

    public byte[] GetMap(int Index) {
        try {
            File e = new File("./Maps/" + Index + ".gz");
            byte[] aByte = new byte[(int)e.length()];
            FileInputStream Fis = new FileInputStream(e);
            Fis.read(aByte);
            System.out.println("" + Index + " aByte = [" + aByte + "]!");
            Fis.close();
            return aByte;
        } catch (Exception var5) {
            return null;
        }
    }

    public void deletethatobject(int i, int j) {
        int k1 = mapX - 6;
        int l1 = mapY - 6;
        int i2 = i - k1 * 8;
        int j2 = j - l1 * 8;
        byte byte0 = 10;
        int k2 = this.anIntArray1177[byte0];
        if(j2 > 0 && j2 < 103 && i2 > 0 && i2 < 103) {
            this.method130(404, -1, 6951, -1, k2, j2, 10, 0, i2, 0);
        }

    }

    public void makeGlobalObject(int i, int j, int k, int l, int i1, int j1) {
        int k1 = mapX - 6;
        int l1 = mapY - 6;
        int i2 = i - k1 * 8;
        int j2 = j - l1 * 8;
        byte byte0 = 10;
        int k2 = this.anIntArray1177[byte0];
        if(j2 > 0 && j2 < 103 && i2 > 0 && i2 < 103) {
            this.method130(404, -1, k, l, k2, j2, i1, j1, i2, 0);
        }

    }

    public void loadNewObjects() {
        this.makeGlobalObject(2807, 2787, 2213, 1, 10, 1);
        this.makeGlobalObject(2807, 2786, 2213, 1, 10, 1);
        this.makeGlobalObject(2807, 2785, 2213, 1, 10, 1);
        this.makeGlobalObject(2807, 2784, 2213, 1, 10, 1);
        this.makeGlobalObject(2807, 2783, 2213, 1, 10, 1);
    }

    private static final String method14(int i, int j) {
        String s = String.valueOf(i);

        for(int k = s.length() - 3; k > 0; k -= 3) {
            s = s.substring(0, k) + "," + s.substring(k);
        }

        if(j != 0) {
            aBoolean1224 = !aBoolean1224;
        }

        if(s.length() > 8) {
            s = "<col=65280>" + s.substring(0, s.length() - 8) + " million <col=65280>(" + s + ")";
        } else if(s.length() > 4) {
            s = "<col=ffffff>" + s.substring(0, s.length() - 4) + "K <col=ffffff>(" + s + ")";
        }

        return " " + s;
    }

    public final void method15(int i) {
        if (!loginmusicEnabled) { // some boolean you toggle
            if (signlink.music != null) {
                signlink.music.stop();
            }
            signlink.fadeMidi = 0;
            signlink.midi = "stop";
        }
    }

    public void processExtraMenus() {
        label90: {
            boolean fixed = currentScreenMode == client.ScreenMode.FIXED;
            if(fixed) {
                if(super.mouseX < 542 || super.mouseX > 579 || super.mouseY < 2 || super.mouseY > 38) {
                    break label90;
                }
            } else if(super.mouseX < currentGameWidth - 180 || super.mouseX > currentGameWidth - 139 || super.mouseY < 0 || super.mouseY > 40) {
                break label90;
            }

            this.menuActionName[1] = "Look North";
            this.menuActionID[1] = 1150;
            this.menuActionRow = 2;
        }

        if(currentScreenMode != client.ScreenMode.FIXED && changeTabArea && super.mouseX >= currentGameWidth - 26 && super.mouseX <= currentGameWidth - 1 && super.mouseY >= 2 && super.mouseY <= 24) {
            this.menuActionName[1] = "Logout";
            this.menuActionID[1] = 700;
            this.menuActionRow = 2;
        }

        if(this.worldHover && this.loadOrbs) {
            this.menuActionName[1] = "Floating <col=ff9040>World Map";
            this.menuActionID[1] = 850;
            this.menuActionRow = 2;
        }

        if(this.expCounterHover) {
            if(this.expDrops) {
                this.menuActionName[3] = "Hide <col=ff9040>XP drops";
                this.menuActionID[3] = 258;
            }

            if(!this.expDrops) {
                this.menuActionName[3] = "Show <col=ff9040>XP drops";
                this.menuActionID[3] = 258;
            }

            this.menuActionName[2] = "Setup <col=ff9040>XP drops";
            this.menuActionID[2] = 257;
            this.menuActionRow = 4;
        }

        if(this.prayHover && this.loadOrbs) {
            this.menuActionName[2] = this.prayClicked?"Turn quick-prayers off":"Turn quick-prayers on";
            this.menuActionID[2] = 1500;
            this.menuActionRow = 2;
            this.menuActionName[1] = "Select quick-prayers";
            this.menuActionID[1] = 1506;
            this.menuActionRow = 3;
        }

        if(this.runHover && this.loadOrbs) {
            this.menuActionName[1] = !this.runClicked?"Turn run mode on":"Turn run mode off";
            this.menuActionID[1] = 1050;
            this.menuActionRow = 2;
        }

    }

    private void drawExpCounterDrops() {
        boolean wilderness = this.openWalkableInterface == 23300;
        RSFont xp_font = this.newSmallFont;
        byte font_height = 24;
        int x = currentGameWidth - 280;
        int x2 = currentGameWidth;
        int y = wilderness?-100:-100;
        String xpString = insertCommas(this.totalExp);
        this.digits = this.xpCounter == 0?1:1 + (int)Math.floor(Math.log10((double)this.xpCounter));
        int lengthToRemove = Integer.toString(this.xpCounter).length();
        int i = this.regularText.getTextWidth(Integer.toString(this.xpCounter)) - this.regularText.getTextWidth(Integer.toString(this.xpCounter)) / 2;
        int a = lengthToRemove == 1?5:(lengthToRemove - 1) * 5;
        DrawingArea.drawBoxOutline(x2 - 380, 4, 120, 30, 3682339);
        DrawingArea.drawBoxOutline(x2 - 379, 5, 118, 28, 5919301);
        DrawingArea.drawTransparentBox(x2 - 378, 6, 116, 26, 5919301, 150);
        this.gameframe[56].drawSprite(x2 - 379, 1);
        this.smallText.drawTextWithPotentialShadow(true, x2 - 265 - this.smallText.getTextWidth(xpString), 16777215, xpString, 25);

        for(i = 0; i < this.xp_added.length; ++i) {
            if(this.xp_added[i][0] > -1) {
                if(this.xp_added[i][2] >= 0) {
                    int transparency = 256;
                    if(this.xp_added[i][2] > 120) {
                        transparency = (10 - (this.xp_added[i][2] - 120)) * 256 / 20;
                    }

                    if(transparency > 0) {
                        String s = "<col=ffffff><shad=000000><trans=" + transparency + ">+" + NumberFormat.getIntegerInstance().format((long)this.xp_added[i][1]);
                        int icons_x_off = 0;
                        Sprite sprite = null;

                        for(int i2 = 0; i2 < this.skill_sprites.length; ++i2) {
                            if((this.xp_added[i][0] & 1 << i2) != 0) {
                                sprite = this.skill_sprites[i2];
                                icons_x_off += sprite.myWidth + 3;
                                sprite.drawSprite(x - a + 12 - xp_font.getTextWidth(s) - icons_x_off, y + 157 + (140 - this.xp_added[i][2]) - font_height / 2 - sprite.myHeight / 2, transparency);
                            }
                        }

                        xp_font.drawBasicString(s, x - a + 12 - xp_font.getTextWidth(s), y + 150 + (140 - this.xp_added[i][2]), 16750848, -1);
                    }
                }

                ++this.xp_added[i][2];
                if(this.xp_added[i][2] >= (wilderness?60:240)) {
                    this.xp_added[i][0] = -1;
                }
            }
        }

    }

    public static String getFileNameWithoutExtension(String fileName) {
        File tmpFile = new File(fileName);
        tmpFile.getName();
        int whereDot = tmpFile.getName().lastIndexOf(46);
        return 0 < whereDot && whereDot <= tmpFile.getName().length() - 2?tmpFile.getName().substring(0, whereDot):"";
    }

    public void preloadModels() {
        File file = new File(signlink.findcachedir() + "/raw/");
        File[] fileArray = file.listFiles();

        for(int y = 0; y < fileArray.length; ++y) {
            String sss = fileArray[y].getName();
            System.out.println("Parsing model file " + sss);
            byte[] buffer = ReadFile(signlink.findcachedir() + "/raw/" + sss);
            Model.method460(buffer, Integer.parseInt(getFileNameWithoutExtension(sss)));
        }

    }

    public static final byte[] ReadFile(String s) {
        try {
            File file = new File(s);
            int i = (int)file.length();
            byte[] e = new byte[i];
            DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(s)));
            datainputstream.readFully(e, 0, i);
            datainputstream.close();
            ++TotalRead;
            return e;
        } catch (Exception var5) {
            System.out.println("Read Error: " + s);
            return null;
        }
    }

    public final void method16() {
        int backoffSeconds = 5;
        this.anIntArray1090[8] = 0;
        int attempts = 0;

        while (this.anIntArray1090[8] == 0) {
            String errorMessage = "Unknown problem";
            method13(20, (byte) 4, "Connecting to Ghreborn web server...");

            try {
                // Randomized CRC URL
                String url = "crc" + ((int) (Math.random() * 99999999)) + "-317";
                DataInputStream in = method132(url);

                // Read 40 bytes (expected CRC stream)
                byte[] crcData = new byte[40];
                in.readFully(crcData, 0, 40);
                in.close();

                Stream stream = new Stream(crcData, 891);

                // Fill local CRCs
                for (int i = 0; i < 9; i++) {
                    this.anIntArray1090[i] = stream.readDWord();
                }

                // Validate the 10th checksum word
                int expectedChecksum = stream.readDWord();
                int computedChecksum = 1234;

                for (int i = 0; i < 9; i++) {
                    computedChecksum = (computedChecksum << 1) + this.anIntArray1090[i];
                }

                if (expectedChecksum != computedChecksum) {
                    errorMessage = "Checksum mismatch.";
                    this.anIntArray1090[8] = 0;
                }

            } catch (EOFException e) {
                errorMessage = "EOF while reading CRCs";
                this.anIntArray1090[8] = 0;
            } catch (IOException e) {
                errorMessage = "I/O error during CRC check";
                this.anIntArray1090[8] = 0;
            } catch (Exception e) {
                errorMessage = "Unhandled error: " + e.getMessage();
                this.anIntArray1090[8] = 0;

                if (!signlink.reporterror) {
                    return;
                }
            }

            // If failed, retry with backoff
            if (this.anIntArray1090[8] == 0) {
                attempts++;

                for (int countdown = backoffSeconds; countdown > 0; countdown--) {
                    if (attempts >= 10) {
                        method13(10, (byte) 4, "Game updated - please reload page.");
                        countdown = 1;
                    } else {
                        method13(10, (byte) 4, errorMessage + " - Retrying in " + countdown + " seconds.");
                    }

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException ignored) {}
                }

                backoffSeconds = Math.min(backoffSeconds * 2, 60);
                this.aBoolean872 = !this.aBoolean872;
            }
        }
    }


    public final boolean method17(int i, int j) {
        if(j < 0) {
            return false;
        } else {
            int k = this.menuActionID[j];
            if(i != 9) {
                this.packet = -1;
            }

            if(k >= 2000) {
                k -= 2000;
            }

            return k == 337;
        }
    }

    public final String prefixRank(int s) {
        switch(s) {
            case 1:
                return "Lord ";
            case 2:
                return "Lady ";
            case 3:
                return "Sir ";
            case 4:
                return "Dame ";
            case 5:
                return "Duderino ";
            case 6:
                return "Dudette ";
            case 7:
                return "Lionheart ";
            case 8:
                return "Crusader ";
            case 9:
                return "Hellraiser ";
            case 10:
                return "Desperado ";
            case 11:
                return "Baron ";
            case 12:
                return "Baroness ";
            case 13:
                return "Count ";
            case 14:
                return "Countess ";
            case 15:
                return "Overlord ";
            case 16:
                return "Overlordess ";
            case 17:
                return "Bandito ";
            case 18:
                return "Duke ";
            case 19:
                return "Duchess ";
            case 20:
                return "Big Cheese ";
            case 21:
                return "Bigwig ";
            case 22:
                return "King ";
            case 23:
                return "Queen ";
            case 24:
                return "Wunderkind ";
            case 592:
                return "The eternal ";
            default:
                return "";
        }
    }

    public final String suffixRank(int s) {
        switch(s) {
            case 1000:
                return " the Brave";
            case 1001:
                return " the Warrior";
            case 1002:
                return " the Mage";
            case 1003:
                return " the Ranger";
            case 1004:
                return " the Cow";
            default:
                return "";
        }
    }

    public final String prefixColor(int s) {
        switch(s) {
            case 1:
                return "@or2@";
            case 2:
                return "@or2@";
            case 3:
                return "@or2@";
            case 4:
                return "@or2@";
            case 5:
                return "@or2@";
            case 6:
                return "@or2@";
            case 7:
                return "@or2@";
            case 8:
                return "@or2@";
            case 9:
                return "@or2@";
            case 10:
                return "@or2@";
            case 11:
                return "@or2@";
            case 12:
                return "@or2@";
            case 13:
                return "@red@";
            case 14:
                return "@red@";
            case 15:
                return "@red@";
            case 16:
                return "@red@";
            case 17:
                return "@or2@";
            case 18:
                return "@or2@";
            case 19:
                return "@or2@";
            case 20:
                return "@or2@";
            case 21:
                return "@or2@";
            case 22:
                return "@or2@";
            case 23:
                return "@or2@";
            case 24:
                return "@or2@";
            case 592:
                return "@whi@";
            default:
                return "@or2@";
        }
    }

    public final String suffixColor(int s) {
        switch(s) {
            case 1000:
                return "@or2@";
            case 1001:
                return "@or2@";
            case 1002:
                return "@or2@";
            case 1003:
                return "@or2@";
            case 1004:
                return "@whi@";
            default:
                return "@or2@";
        }
    }

    private boolean chatStateCheck() {
        return this.messagePromptRaised || this.inputDialogState != 0 || this.aString844 != null || this.backDialogID != -1 || this.dialogID != -1;
    }

    public final void drawChatArea(int i) {
        int yOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 165;
        boolean yOffset2 = currentScreenMode == client.ScreenMode.FIXED;
        if(currentScreenMode == client.ScreenMode.FIXED) {
            aRSImageProducer_1166.initDrawingArea();
        }

        Rasterizer.lineOffsets = anIntArray1180;
        if(this.chatStateCheck()) {
            showChatComponents = true;
            this.gameframe[0].drawSprite(0, yOffset);
        }

        if(showChatComponents) {
            if(changeChatArea && !this.chatStateCheck()) {
                DrawingArea.method339(7 + yOffset, 5723991, 506, 7);
                DrawingArea.drawAlphaGradient(7, 7 + yOffset, 506, 135, 0, 16777215, 20);
            } else {
                this.gameframe[0].drawSprite(0, yOffset);
            }
        }

        if(!showChatComponents || changeChatArea) {
            DrawingArea.drawAlphaPixels(7, currentGameHeight - 23, 506, 24, 0, 100);
        }

        this.drawChannelButtons();
        TextDrawingArea textDrawingArea = this.regularText;
        if(this.messagePromptRaised) {
            this.newBoldFont.drawCenteredString(this.aString1121, 259, 60 + yOffset, 0, -1);
            this.newBoldFont.drawCenteredString(this.promptInput + "*", 259, 80 + yOffset, 128, -1);
        } else if(this.inputDialogState == 1) {
            this.newBoldFont.drawCenteredString("Enter amount:", 259, yOffset + 60, 0, -1);
            this.newBoldFont.drawCenteredString(this.amountOrNameInput + "*", 259, 80 + yOffset, 128, -1);
        } else if(this.inputDialogState == 2) {
            this.newBoldFont.drawCenteredString("Enter Name:", 259, 60 + yOffset, 0, -1);
            this.newBoldFont.drawCenteredString(this.amountOrNameInput + "*", 259, 80 + yOffset, 128, -1);
        } else if(this.aString844 != null) {
            this.newBoldFont.drawCenteredString(this.aString844, 259, 60 + yOffset, 0, -1);
            this.newBoldFont.drawCenteredString("Click to continue", 259, 80 + yOffset, 128, -1);
        } else if(this.backDialogID != -1) {
            this.drawInterface(0, 20, Widget.interfaceCache[this.backDialogID], 20 + yOffset);
        } else if(this.dialogID != -1) {
            this.drawInterface(0, 20, Widget.interfaceCache[this.dialogID], 20 + yOffset);
        } else if(showChatComponents) {
            int j77 = -3;
            int j = 0;
            int shadow = changeChatArea?0:-1;
            DrawingArea.setDrawingArea(122 + yOffset, 8, 497, 7 + yOffset);

            int xOffset;
            for(int s = 0; s < 500; ++s) {
                if(this.chatMessages[s] != null) {
                    xOffset = this.chatTypes[s];
                    int yPos = 70 - j77 * 14 + anInt1089 + 5;
                    String s1 = this.chatNames[s];
                    byte byte0 = 0;
                    if(s1 != null && s1.startsWith("@cr1@")) {
                        s1 = s1.substring(5);
                        byte0 = 1;
                    } else if(s1 != null && s1.startsWith("@cr2@")) {
                        s1 = s1.substring(5);
                        byte0 = 2;
                    } else if(s1 != null && s1.startsWith("@cr3@")) {
                        s1 = s1.substring(5);
                        byte0 = 3;
                    } else if(s1 != null && s1.startsWith("@cr4@")) {
                        s1 = s1.substring(5);
                        byte0 = 4;
                    } else if(s1 != null && s1.startsWith("@cr5@")) {
                        s1 = s1.substring(5);
                        byte0 = 5;
                    } else if(s1 != null && s1.startsWith("@cr6@")) {
                        s1 = s1.substring(5);
                        byte0 = 6;
                    } else if(s1 != null && s1.startsWith("@cr7@")) {
                        s1 = s1.substring(5);
                        byte0 = 7;
                    } else if(s1 != null && s1.startsWith("@cr8@")) {
                        s1 = s1.substring(5);
                        byte0 = 8;
                    } else if(s1 != null && s1.startsWith("@cr9@")) {
                        s1 = s1.substring(5);
                        byte0 = 9;
                    } else if(s1 != null && s1.startsWith("@cr10@")) {
                        s1 = s1.substring(6);
                        byte0 = 10;
                    } else if(s1 != null && s1.startsWith("@cr11@")) {
                        s1 = s1.substring(6);
                        byte0 = 11;
                    } else if(s1 != null && s1.startsWith("@cr12@")) {
                        s1 = s1.substring(6);
                        byte0 = 12;
                    } else if(s1 != null && s1.startsWith("@cr13@")) {
                        s1 = s1.substring(6);
                        byte0 = 13;
                    } else if(s1 != null && s1.startsWith("@cr14@")) {
                        s1 = s1.substring(6);
                        byte0 = 14;
                    } else if(s1 != null && s1.startsWith("@cr15@")) {
                        s1 = s1.substring(6);
                        byte0 = 15;
                    } else if(s1 != null && s1.startsWith("@cr16@")) {
                        s1 = s1.substring(6);
                        byte0 = 16;
                    } else if(s1 != null && s1.startsWith("@cr17@")) {
                        s1 = s1.substring(6);
                        byte0 = 17;
                    } else if(s1 != null && s1.startsWith("@cr18@")) {
                        s1 = s1.substring(6);
                        byte0 = 18;
                    } else if(s1 != null && s1.startsWith("@cr19@")) {
                        s1 = s1.substring(6);
                        byte0 = 19;
                    } else if(s1 != null && s1.startsWith("@cr20@")) {
                        s1 = s1.substring(6);
                        byte0 = 20;
                    } else if(s1 != null && s1.startsWith("@cr21@")) {
                        s1 = s1.substring(6);
                        byte0 = 21;
                    } else if(s1 != null && s1.startsWith("@cr22@")) {
                        s1 = s1.substring(6);
                        byte0 = 22;
                    } else if(s1 != null && s1.startsWith("@cr23@")) {
                        s1 = s1.substring(6);
                        byte0 = 23;
                    } else if(s1 != null && s1.startsWith("@cr24@")) {
                        s1 = s1.substring(6);
                        byte0 = 24;
                    } else if(s1 != null && s1.startsWith("@cr25@")) {
                        s1 = s1.substring(6);
                        byte0 = 25;
                    }

                    if(xOffset == 0 && (this.chatTypeView == 5 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString(this.chatMessages[s], 11, yPos + yOffset, changeChatArea?16777215:0, shadow);
                        ++j;
                        ++j77;
                    }

                    int xPos;
                    if((xOffset == 1 || xOffset == 2) && (xOffset == 1 || this.publicChatMode == 0 || this.publicChatMode == 1 && this.method109(s1)) && (this.chatTypeView == 1 || this.chatTypeView == 0)) {
                        xPos = 11;
                        switch(byte0) {
                            case 1:
                                this.ModIcons[0].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 2:
                                this.ModIcons[1].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 3:
                                this.ModIcons[2].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 4:
                                this.ModIcons[3].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 5:
                                this.ModIcons[4].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 6:
                                this.ModIcons[5].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 7:
                                this.ModIcons[6].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 8:
                                this.ModIcons[7].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 9:
                                this.ModIcons[8].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 10:
                                this.ModIcons[9].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 11:
                                this.ModIcons[10].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 12:
                                this.ModIcons[11].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 13:
                                this.ModIcons[12].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 14:
                                this.ModIcons[13].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 15:
                                this.ModIcons[14].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 16:
                                this.ModIcons[15].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 17:
                                this.ModIcons[16].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 18:
                                this.ModIcons[17].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 19:
                                this.ModIcons[18].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 20:
                                this.ModIcons[19].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 21:
                                this.ModIcons[20].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 22:
                                this.ModIcons[21].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                                break;
                            case 23:
                                this.ModIcons[22].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                            case 24:
                                this.ModIcons[23].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                            case 25:
                                this.ModIcons[24].drawSprite(xPos, yPos - 12 + yOffset);
                                xPos += 14;
                        }

                        this.newRegularFont.drawBasicString(s1 + ":", xPos, yPos + yOffset, changeChatArea?16777215:0, shadow);
                        xPos += textDrawingArea.getTextWidth(s1) + 8;
                        this.newRegularFont.drawBasicString(this.chatMessages[s], xPos, yPos + yOffset, changeChatArea?8366591:255, shadow);
                        ++j;
                        ++j77;
                    }

                    if((xOffset == 3 || xOffset == 7) && (this.splitPrivateChat == 0 || this.chatTypeView == 2) && (xOffset == 7 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s1)) && (this.chatTypeView == 2 || this.chatTypeView == 0)) {
                        byte var161 = 11;
                        this.newRegularFont.drawBasicString("From", var161, yPos + yOffset, changeChatArea?0:16777215, shadow);
                        xPos = var161 + textDrawingArea.getTextWidth("From ");
                        switch(byte0) {
                            case 1:
                                this.ModIcons[0].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 2:
                                this.ModIcons[1].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 3:
                                this.ModIcons[2].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 4:
                                this.ModIcons[3].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 5:
                                this.ModIcons[4].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 6:
                                this.ModIcons[5].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 7:
                                this.ModIcons[6].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 8:
                                this.ModIcons[7].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 9:
                                this.ModIcons[8].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 10:
                                this.ModIcons[9].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 11:
                                this.ModIcons[10].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 12:
                                this.ModIcons[11].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 13:
                                this.ModIcons[12].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 14:
                                this.ModIcons[13].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 15:
                                this.ModIcons[14].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 16:
                                this.ModIcons[15].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 17:
                                this.ModIcons[16].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 18:
                                this.ModIcons[17].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 19:
                                this.ModIcons[18].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 20:
                                this.ModIcons[19].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 21:
                                this.ModIcons[20].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 22:
                                this.ModIcons[21].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 23:
                                this.ModIcons[22].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 24:
                                this.ModIcons[23].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                                break;
                            case 25:
                                this.ModIcons[24].drawSprite(xPos, yPos - 12);
                                xPos += 14;
                        }

                        this.newRegularFont.drawBasicString(s1 + ":", xPos, yPos + yOffset, changeChatArea?16777215:0, shadow);
                        xPos += textDrawingArea.getTextWidth(s1) + 8;
                        this.newRegularFont.drawBasicString(this.chatMessages[s], xPos, yPos + yOffset, 8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if(xOffset == 4 && (this.tradeMode == 0 || this.tradeMode == 1 && this.method109(s1)) && (this.chatTypeView == 3 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[s], 11, yPos + yOffset, 8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if(xOffset == 5 && this.splitPrivateChat == 0 && this.privateChatMode < 2 && (this.chatTypeView == 2 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[s], 11, yPos + yOffset, 8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if(xOffset == 6 && (this.splitPrivateChat == 0 || this.chatTypeView == 2) && this.privateChatMode < 2 && (this.chatTypeView == 2 || this.chatTypeView == 0)) {
                        this.newRegularFont.drawBasicString("To " + s1 + ":", 11, yPos + yOffset, changeChatArea?16777215:0, shadow);
                        this.newRegularFont.drawBasicString(this.chatMessages[s], 15 + textDrawingArea.getTextWidth("To :" + s1), yPos + yOffset, 8388736, shadow);
                        ++j;
                        ++j77;
                    }

                    if(xOffset == 8 && (this.tradeMode == 0 || this.tradeMode == 1 && this.method109(s1))) {
                        if(this.chatTypeView == 3 || this.chatTypeView == 0) {
                            this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[s], 11, yPos + yOffset, 8270336, shadow);
                            ++j;
                            ++j77;
                        }

                        if(xOffset == 11 && this.clanChatMode == 0) {
                            if(this.chatTypeView == 11) {
                                this.newRegularFont.drawBasicString(s1 + " " + this.chatMessages[s], 11, yPos + yOffset, 8270336, shadow);
                                ++j;
                                ++j77;
                            }

                            if(xOffset == 12) {
                                this.newRegularFont.drawBasicString(this.chatMessages[s], 11, yPos + yOffset, 8270336, shadow);
                                ++j;
                            }
                        }
                    }

                    if(xOffset == 16) {
                        int var17 = 51;
                        int clanNameWidth = textDrawingArea.getTextWidth(this.clanname);
                        if(this.chatTypeView == 11 || this.chatTypeView == 0) {
                            if(yPos > 0 && yPos < 110) {
                                switch(this.chatRights[s]) {
                                    case 1:
                                        var17 += clanNameWidth;
                                        this.ModIcons[0].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 2:
                                        var17 += clanNameWidth;
                                        this.ModIcons[1].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 3:
                                        var17 += clanNameWidth;
                                        this.ModIcons[2].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 4:
                                        var17 += clanNameWidth;
                                        this.ModIcons[3].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 5:
                                        var17 += clanNameWidth;
                                        this.ModIcons[4].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 6:
                                        var17 += clanNameWidth;
                                        this.ModIcons[5].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 7:
                                        var17 += clanNameWidth;
                                        this.ModIcons[6].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 8:
                                        var17 += clanNameWidth;
                                        this.ModIcons[7].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 9:
                                        var17 += clanNameWidth;
                                        this.ModIcons[8].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 10:
                                        var17 += clanNameWidth;
                                        this.ModIcons[9].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 11:
                                        var17 += clanNameWidth;
                                        this.ModIcons[10].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 12:
                                        var17 += clanNameWidth;
                                        this.ModIcons[11].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 13:
                                        var17 += clanNameWidth;
                                        this.ModIcons[12].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 14:
                                        var17 += clanNameWidth;
                                        this.ModIcons[13].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 15:
                                        var17 += clanNameWidth;
                                        this.ModIcons[14].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 16:
                                        var17 += clanNameWidth;
                                        this.ModIcons[15].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 17:
                                        var17 += clanNameWidth;
                                        this.ModIcons[16].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 18:
                                        var17 += clanNameWidth;
                                        this.ModIcons[17].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 19:
                                        var17 += clanNameWidth;
                                        this.ModIcons[18].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 20:
                                        var17 += clanNameWidth;
                                        this.ModIcons[19].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 21:
                                        var17 += clanNameWidth;
                                        this.ModIcons[20].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 22:
                                        var17 += clanNameWidth;
                                        this.ModIcons[21].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 23:
                                        var17 += clanNameWidth;
                                        this.ModIcons[22].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 24:
                                        var17 += clanNameWidth;
                                        this.ModIcons[23].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    case 25:
                                        var17 += clanNameWidth;
                                        this.ModIcons[24].drawSprite(var17 - 18, yPos - 12);
                                        var17 += 15;
                                        break;
                                    default:
                                        var17 += clanNameWidth;
                                }
                            }

                            this.newRegularFont.drawBasicString("[", 19, yPos, changeChatArea?16777215:0, shadow);
                            this.newRegularFont.drawBasicString("]", clanNameWidth + 16 + 11, yPos, changeChatArea?16777215:0, shadow);
                            this.newRegularFont.drawBasicString("" + capitalize(this.clanname) + "", 25, yPos, 255, -1);
                            this.newRegularFont.drawBasicString(capitalize(this.chatNames[s]) + ":", var17 - 17, yPos);
                            var17 += this.newRegularFont.getTextWidth(this.chatNames[s]) + 7;
                            this.newRegularFont.drawBasicString(capitalize(this.chatMessages[s]), var17 - 16, yPos, 8388608, -1);
                            ++j;
                            ++j77;
                        }
                    }
                }
            }

            DrawingArea.defaultDrawingAreaSize();
            this.anInt1211 = j * 14 + 7 + 5;
            if(this.anInt1211 < 111) {
                this.anInt1211 = 111;
            }

            this.drawScrollbar(114, this.anInt1211 - anInt1089 - 113, 7 + yOffset, 496, this.anInt1211, changeChatArea);
            String var16;
            if(localPlayer != null && localPlayer.name != null) {
                var16 = this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title);
            } else {
                var16 = TextClass.fixName(this.myUsername);
            }

            DrawingArea.setDrawingArea(140 + yOffset, 8, 509, 120 + yOffset);
            xOffset = 0;
            if(this.myPrivilege > 0) {
                this.ModIcons[this.myPrivilege - 1].drawSprite(10, 122 + yOffset);
                xOffset += 14;
            }

            this.newRegularFont.drawBasicString(var16 + ":", xOffset + 11, 133 + yOffset, changeChatArea?16777215:0, shadow);
            this.newRegularFont.drawBasicString(this.inputString + "*", xOffset + 12 + textDrawingArea.getTextWidth(var16 + ": "), 133 + yOffset, changeChatArea?8366591:255, shadow);
            DrawingArea.method339(121 + yOffset, changeChatArea?5723991:8418912, 506, 7);
            DrawingArea.defaultDrawingAreaSize();
        }

        if(this.menuOpen) {
            this.drawMenu(0, currentScreenMode == client.ScreenMode.FIXED?338:0);
        }

        if(currentScreenMode == client.ScreenMode.FIXED) {
            aRSImageProducer_1166.method238(338, 23680, super.aGraphics12, 0);
        }

        aRSImageProducer_1165.initDrawingArea();
        Rasterizer.lineOffsets = anIntArray1182;
        if(i < 6 || i > 6) {
            this.aBoolean991 = !this.aBoolean991;
        }

    }

    public static String capitalize(String s) {
        for(int i = 0; i < s.length(); ++i) {
            if(i == 0) {
                s = String.format("%s%s", new Object[]{Character.valueOf(Character.toUpperCase(s.charAt(0))), s.substring(1)});
            }

            if(!Character.isLetterOrDigit(s.charAt(i)) && i + 1 < s.length()) {
                s = String.format("%s%s%s", new Object[]{s.subSequence(0, i + 1), Character.valueOf(Character.toUpperCase(s.charAt(i + 1))), s.substring(i + 2)});
            }
        }

        return s;
    }

    public void drawChannelButtons() {
        int yOffset = currentScreenMode == client.ScreenMode.FIXED ? 0 : currentGameHeight - 165;
        gameframe[27].drawSprite(0, 143 + yOffset);

        String[] text = {"On", "Friends", "Off", "Hide", "Autochat"};
        int[] textColor = {0x00FF00, 0xFFFF00, 0xFF0000, 0xFFFFFF, 0xDAA520};

        // Draw selected tab
        switch (cButtonCPos) {
            case 0: case 1: case 2: case 3: case 4: case 5: case 6:
                gameframe[5].drawSprite(channelButtonsX[cButtonCPos], 143 + yOffset);
                break;
        }

        // Draw hover highlight
        if (cButtonHPos == cButtonCPos) {
            switch (cButtonHPos) {
                case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
                    gameframe[6].drawSprite(channelButtonsX[cButtonHPos], 143 + yOffset);
                    break;
            }
        } else {
            switch (cButtonHPos) {
                case 0: case 1: case 2: case 3: case 4: case 5:
                    gameframe[3].drawSprite(channelButtonsX[cButtonHPos], 143 + yOffset);
                    break;
                case 6:
                    gameframe[8].drawSprite(channelButtonsX[cButtonHPos], 143 + yOffset);
                    break;
            }
        }

        // Label the buttons
        for (int i = 0; i < modeNamesX.length; ++i) {
            smallText.method389(true, true, modeNamesX[i], 0xFFFFFF, modeNames[i], modeNamesY[i] + yOffset);
        }

        // Safely draw chat mode status
        int[] modes = {publicChatMode, privateChatMode, clanChatMode, tradeMode};
        for (int i = 0; i < modeX.length && i < modes.length; ++i) {
            int modeIndex = modes[i];

            if (modeIndex >= 0 && modeIndex < text.length && modeIndex < textColor.length) {
                smallText.method382(
                        textColor[modeIndex],
                        modeX[i],
                        anInt939,
                        text[modeIndex],
                        164 + yOffset,
                        true
                );
            } else {
                // Optional: draw a fallback or log warning
                smallText.method382(
                        0x888888,
                        modeX[i],
                        anInt939,
                        "??",
                        164 + yOffset,
                        true
                );
            }
        }
    }


    public void rightClickChatButtons() {
        if(this.mouseY >= currentGameHeight - 22 && this.mouseY <= currentGameHeight) {
            if(super.mouseX >= 5 && super.mouseX <= 61) {
                this.menuActionName[1] = "View All";
                this.menuActionCmd3[1] = 999;
                this.menuActionRow = 2;
            } else if(super.mouseX >= 71 && super.mouseX <= 127) {
                this.menuActionName[1] = "View Game";
                this.menuActionCmd3[1] = 998;
                this.menuActionRow = 2;
            } else if(super.mouseX >= 137 && super.mouseX <= 193) {
                this.menuActionName[1] = "Hide public";
                this.menuActionCmd3[1] = 997;
                this.menuActionName[2] = "Off public";
                this.menuActionCmd3[2] = 996;
                this.menuActionName[3] = "Friends public";
                this.menuActionCmd3[3] = 995;
                this.menuActionName[4] = "On public";
                this.menuActionCmd3[4] = 994;
                this.menuActionName[5] = "View public";
                this.menuActionCmd3[5] = 993;
                this.menuActionRow = 6;
            } else if(super.mouseX >= 203 && super.mouseX <= 259) {
                this.menuActionName[1] = "Off private";
                this.menuActionCmd3[1] = 992;
                this.menuActionName[2] = "Friends private";
                this.menuActionCmd3[2] = 991;
                this.menuActionName[3] = "On private";
                this.menuActionCmd3[3] = 990;
                this.menuActionName[4] = "View private";
                this.menuActionCmd3[4] = 989;
                this.menuActionRow = 5;
            } else if(super.mouseX >= 269 && super.mouseX <= 325) {
                this.menuActionName[1] = "Off clan chat";
                this.menuActionCmd3[1] = 1003;
                this.menuActionName[2] = "Friends clan chat";
                this.menuActionCmd3[2] = 1002;
                this.menuActionName[3] = "On clan chat";
                this.menuActionCmd3[3] = 1001;
                this.menuActionName[4] = "View clan chat";
                this.menuActionCmd3[4] = 1000;
                this.menuActionRow = 5;
            } else if(super.mouseX >= 335 && super.mouseX <= 391) {
                this.menuActionName[1] = "Off trade";
                this.menuActionCmd3[1] = 987;
                this.menuActionName[2] = "Friends trade";
                this.menuActionCmd3[2] = 986;
                this.menuActionName[3] = "On trade";
                this.menuActionCmd3[3] = 985;
                this.menuActionName[4] = "View trade";
                this.menuActionCmd3[4] = 984;
                this.menuActionRow = 5;
            } else if(super.mouseX >= 404 && super.mouseX <= 515) {
                this.menuActionName[1] = "Report Abuse";
                this.menuActionCmd3[1] = 606;
                this.menuActionRow = 2;
            }
        }

    }

    public final void init() {
        try {
            anInt957 = 0;
            ondemand_offset = 0;
            try {
                enableExceptionLogging(); // Don't remove this!
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            method52(true);
            aBoolean959 = true;
            signlink.storeid = 32;
            signlink.startpriv(InetAddress.getLocalHost());
            server = Configuration.SERVER_ADDRESS;
            this.method2(currentGameWidth, false, currentGameWidth);
            instance = this;
        } catch (Exception var2) {
            ;
        }
    }

    public final void method12(Runnable runnable, int i) {
        if(i > 10) {
            i = 10;
        }

        if(signlink.mainapp != null) {
            signlink.startthread(runnable, i);
        } else {
            super.method12(runnable, i);
        }
    }

    public final Socket method19(int i) throws IOException {
        return signlink.mainapp != null?signlink.opensocket(i):new Socket(InetAddress.getByName(this.getCodeBase().getHost()), i);
    }

    public final void method20(int i) {
        if(i != 4) {
            this.packet = this.in.readUnsignedByte();
        }

        if(this.anInt1086 == 0) {
            int j = super.clickMode3;
            if(this.anInt1136 == 1 && super.saveClickX >= 516 && super.saveClickY >= 160 && super.saveClickX <= 765 && super.saveClickY <= 205) {
                j = 0;
            }

            int i1;
            int l1;
            int j2;
            if(this.menuOpen) {
                if(j != 1) {
                    i1 = super.mouseX;
                    l1 = super.mouseY;
                    if(this.menuScreenArea == 0) {
                        i1 += 0;
                        l1 += 0;
                    }

                    if(this.menuScreenArea == 1) {
                        i1 -= 516;
                        l1 -= 160;
                    }

                    if(this.menuScreenArea == 2) {
                        i1 -= 17;
                        l1 -= 343;
                    }

                    if(this.menuScreenArea == 3) {
                        i1 -= 516;
                        l1 += 0;
                    }

                    if(i1 < this.anInt949 - 10 || i1 > this.anInt949 + this.anInt951 + 10 || l1 < this.anInt950 - 10 || l1 > this.anInt950 + this.anInt952 + 10) {
                        this.menuOpen = false;
                        if(this.menuScreenArea == 1) {
                            ;
                        }

                        if(this.menuScreenArea == 2) {
                            this.inputTaken = true;
                        }
                    }
                }

                if(j == 1) {
                    i1 = this.anInt949;
                    l1 = this.anInt950;
                    j2 = this.anInt951;
                    int var11 = super.saveClickX;
                    int l2 = super.saveClickY;
                    switch(this.menuScreenArea) {
                        case 0:
                            var11 += 0;
                            l2 += 0;
                            break;
                        case 1:
                            var11 -= 516;
                            l2 -= 160;
                            break;
                        case 2:
                            var11 -= 17;
                            l2 -= 343;
                            break;
                        case 3:
                            var11 -= 516;
                            l2 += 0;
                    }

                    int i3 = -1;

                    for(int j3 = 0; j3 < this.menuActionRow; ++j3) {
                        int k3 = l1 + 31 + (this.menuActionRow - 1 - j3) * 15;
                        if(var11 > i1 && var11 < i1 + j2 && l2 > k3 - 13 && l2 < k3 + 3) {
                            i3 = j3;
                        }
                    }

                    if(i3 != -1) {
                        this.doAction(i3, false);
                    }

                    this.menuOpen = false;
                    if(this.menuScreenArea == 1) {
                        ;
                    }

                    if(this.menuScreenArea == 2) {
                        this.inputTaken = true;
                        return;
                    }
                }
            } else {
                if(j == 1 && this.menuActionRow > 0) {
                    i1 = this.menuActionID[this.menuActionRow - 1];
                    if(i1 == 632 || i1 == 78 || i1 == 867 || i1 == 431 || i1 == 53 || i1 == 74 || i1 == 454 || i1 == 539 || i1 == 493 || i1 == 847 || i1 == 447 || i1 == 1125) {
                        l1 = this.menuActionCmd2[this.menuActionRow - 1];
                        j2 = this.menuActionCmd3[this.menuActionRow - 1];
                        Widget class9 = Widget.interfaceCache[j2];
                        if(class9.deleteOnDrag2 || class9.dragDeletes) {
                            this.aBoolean1242 = false;
                            this.anInt989 = 0;
                            this.anInt1084 = j2;
                            this.anInt1085 = l1;
                            this.anInt1086 = 2;
                            this.anInt1087 = super.saveClickX;
                            this.anInt1088 = super.saveClickY;
                            if(Widget.interfaceCache[j2].parentID == openInterfaceID) {
                                this.anInt1086 = 1;
                            }

                            if(Widget.interfaceCache[j2].parentID == this.backDialogID) {
                                this.anInt1086 = 3;
                            }

                            return;
                        }
                    }
                }

                if(j == 1 && (this.anInt1253 == 1 || this.method17(9, this.menuActionRow - 1)) && this.menuActionRow > 2) {
                    j = 2;
                }

                if(j == 1 && this.menuActionRow > 0) {
                    this.doAction(this.menuActionRow - 1, false);
                }

                if(j == 2 && this.menuActionRow > 0) {
                    this.method116(true);
                }

                this.minimapHovers();
            }

        }
    }

    public String indexLocation(int cacheIndex, int index) {
        return "D:/dump/index" + cacheIndex + "/" + (index != -1?index + ".gz":"");
    }

    public void repackCacheIndex(int cacheIndex) {
        System.out.println("Started repacking index " + cacheIndex + ".");
        int indexLength = (new File(this.indexLocation(cacheIndex, -1))).listFiles().length;
        File[] file = (new File(this.indexLocation(cacheIndex, -1))).listFiles();

        try {
            for(int e = 0; e < indexLength; ++e) {
                int fileIndex = Integer.parseInt(getFileNameWithoutExtension(file[e].toString()));
                byte[] data = this.fileToByteArray(cacheIndex, fileIndex);
                if(data != null && data.length > 0) {
                    this.aClass14Array970[cacheIndex].method234(data.length, data, (byte)2, fileIndex);
                    System.out.println("Repacked " + fileIndex + ".");
                } else {
                    System.out.println("Unable to locate index " + fileIndex + ".");
                }
            }
        } catch (Exception var7) {
            System.out.println("Error packing cache index " + cacheIndex + ".");
        }

        System.out.println("Finished repacking " + cacheIndex + ".");
    }

    public byte[] fileToByteArray(int cacheIndex, int index) {
        try {
            if(this.indexLocation(cacheIndex, index).length() > 0 && this.indexLocation(cacheIndex, index) != null) {
                File var6 = new File(this.indexLocation(cacheIndex, index));
                byte[] fileData = new byte[(int)var6.length()];
                FileInputStream fis = new FileInputStream(var6);
                fis.read(fileData);
                fis.close();
                return fileData;
            } else {
                return null;
            }
        } catch (Exception var61) {
            return null;
        }
    }

    public final void method21(boolean flag, int i, byte[] abyte0) {
        signlink.fadeMidi = flag?1:0;
        signlink.midisave(abyte0, abyte0.length);
        if(i != 0) {
            this.packet = this.in.readUnsignedByte();
        }

    }

    public final void method22(boolean flag) {
        int k;
        int j1;
        int i2;
        int l2;
        int l3;
        int j7;
        int k8;
        int var17;
        try {
            this.anInt985 = -1;
            this.aDoubleEndedQueue_1056.method256();
            this.aDoubleEndedQueue_1013.method256();
            this.loadNewObjects();
            Rasterizer.method366();
            this.method23(false);
            this.aClass25_946.method274(619);
            System.gc();

            for(k = 0; k < 4; ++k) {
                this.collisionMaps[k].method210();
            }

            for(k = 0; k < 4; ++k) {
                for(j1 = 0; j1 < 104; ++j1) {
                    for(i2 = 0; i2 < 104; ++i2) {
                        this.aByteArrayArrayArray1258[k][j1][i2] = 0;
                    }
                }
            }

            ObjectManager var15 = new ObjectManager(this.aByteArrayArrayArray1258, -60, 104, 104, this.anIntArrayArrayArray1214);
            j1 = this.terrainData.length;
            this.stream.createFrame(0);
            if(!this.aBoolean1159) {
                byte[] j5;
                for(i2 = 0; i2 < j1; ++i2) {
                    l2 = (this.mapCoordinates[i2] >> 8) * 64 - this.baseX;
                    l3 = (this.mapCoordinates[i2] & 255) * 64 - this.baseY;
                    j5 = this.terrainData[i2];
                    if(j5 != null) {
                        var15.method180(j5, l3, l2, (this.currentRegionX - 6) * 8, (this.currentRegionY - 6) * 8, (byte)4, this.collisionMaps);
                    }
                }

                for(i2 = 0; i2 < j1; ++i2) {
                    l2 = (this.mapCoordinates[i2] >> 8) * 64 - this.baseX;
                    l3 = (this.mapCoordinates[i2] & 255) * 64 - this.baseY;
                    j5 = this.terrainData[i2];
                    if(j5 == null && this.currentRegionY < 800) {
                        var15.method174(l3 * 8, 8, 0, 8, l2 * 8);
                    }
                }

                ++anInt1097;
                if(anInt1097 > 160) {
                    anInt1097 = 0;
                    this.stream.createFrame(238);
                    this.stream.writeUnsignedByte(96);
                }

                this.stream.createFrame(0);

                for(i2 = 0; i2 < j1; ++i2) {
                    byte[] var16 = this.mapData[i2];
                    if(var16 != null) {
                        l3 = (this.mapCoordinates[i2] >> 8) * 64 - this.baseX;
                        var17 = (this.mapCoordinates[i2] & 255) * 64 - this.baseY;
                        var15.method190(l3, this.collisionMaps, var17, 7, this.aClass25_946, var16);
                    }
                }
            }

            if(this.aBoolean1159) {
                i2 = 0;

                label254:
                while(true) {
                    int k11;
                    int i12;
                    int j12;
                    int k12;
                    if(i2 >= 4) {
                        for(i2 = 0; i2 < 13; ++i2) {
                            for(l2 = 0; l2 < 13; ++l2) {
                                l3 = this.anIntArrayArrayArray1129[0][i2][l2];
                                if(l3 == -1) {
                                    var15.method174(l2 * 8, 8, 0, 8, i2 * 8);
                                }
                            }
                        }

                        this.stream.createFrame(0);
                        i2 = 0;

                        while(true) {
                            if(i2 >= 4) {
                                break label254;
                            }

                            for(l2 = 0; l2 < 13; ++l2) {
                                for(l3 = 0; l3 < 13; ++l3) {
                                    var17 = this.anIntArrayArrayArray1129[i2][l2][l3];
                                    if(var17 != -1) {
                                        j7 = var17 >> 24 & 3;
                                        k8 = var17 >> 1 & 3;
                                        k11 = var17 >> 14 & 1023;
                                        i12 = var17 >> 3 & 2047;
                                        j12 = (k11 / 8 << 8) + i12 / 8;

                                        for(k12 = 0; k12 < this.mapCoordinates.length; ++k12) {
                                            if(this.mapCoordinates[k12] == j12 && this.mapData[k12] != null) {
                                                var15.method183(this.collisionMaps, this.aClass25_946, j7, l2 * 8, (i12 & 7) * 8, true, i2, this.mapData[k12], (k11 & 7) * 8, k8, l3 * 8);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                            ++i2;
                        }
                    }

                    for(l2 = 0; l2 < 13; ++l2) {
                        for(l3 = 0; l3 < 13; ++l3) {
                            var17 = this.anIntArrayArrayArray1129[i2][l2][l3];
                            if(var17 != -1) {
                                j7 = var17 >> 24 & 3;
                                k8 = var17 >> 1 & 3;
                                k11 = var17 >> 14 & 1023;
                                i12 = var17 >> 3 & 2047;
                                j12 = (k11 / 8 << 8) + i12 / 8;

                                for(k12 = 0; k12 < this.mapCoordinates.length; ++k12) {
                                    if(this.mapCoordinates[k12] == j12 && this.terrainData[k12] != null) {
                                        var15.method179(j7, k8, this.collisionMaps, 9, l2 * 8, (k11 & 7) * 8, this.terrainData[k12], (i12 & 7) * 8, i2, l3 * 8);
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    ++i2;
                }
            }

            this.stream.createFrame(0);
            var15.method171(this.collisionMaps, this.aClass25_946, 2);
            fadingTo = ((Integer)getMostFrequentN2(var15.colors).getKey()).intValue();
            aRSImageProducer_1165.initDrawingArea();
            this.stream.createFrame(0);
            i2 = ObjectManager.anInt145;
            if(i2 > this.anInt918) {
                i2 = this.anInt918;
            }

            if(i2 < this.anInt918 - 1) {
                i2 = this.anInt918 - 1;
            }

            if(lowMemory) {
                this.aClass25_946.method275(ObjectManager.anInt145, -34686);
            } else {
                this.aClass25_946.method275(0, -34686);
            }

            for(l2 = 0; l2 < 104; ++l2) {
                for(l3 = 0; l3 < 104; ++l3) {
                    this.method25(l2, l3);
                }
            }

            ++anInt1051;
            if(anInt1051 > 98) {
                anInt1051 = 0;
                this.stream.createFrame(150);
            }

            this.method63(-919);
        } catch (Exception var14) {
            ;
        }

        ObjectDefinition.aClass12_785.method224();
        loggedIn &= flag;
        if(super.gameFrame != null) {
            //this.stream.createFrame(210);
           // this.stream.writeDWord(1057001181);
        }

        if(lowMemory && signlink.cache_dat != null) {
            k = onDemandFetcher.method555(79, 0);

            for(j1 = 0; j1 < k; ++j1) {
                i2 = onDemandFetcher.method559(j1, -203);
                if((i2 & 121) == 0) {
                    Model.method461(116, j1);
                }
            }
        }

        System.gc();
        Rasterizer.method367();
        onDemandFetcher.method566(0);
        k = (this.currentRegionX - 6) / 8 - 1;
        j1 = (this.currentRegionX + 6) / 8 + 1;
        i2 = (this.currentRegionY - 6) / 8 - 1;
        l2 = (this.currentRegionY + 6) / 8 + 1;
        if(this.aBoolean1141) {
            k = 49;
            j1 = 50;
            i2 = 49;
            l2 = 50;
        }

        for(l3 = k; l3 <= j1; ++l3) {
            for(var17 = i2; var17 <= l2; ++var17) {
                if(l3 == k || l3 == j1 || var17 == i2 || var17 == l2) {
                    j7 = onDemandFetcher.method562(0, 0, var17, l3);
                    if(j7 != -1) {
                        onDemandFetcher.method560(j7, 3, false);
                    }

                    k8 = onDemandFetcher.method562(1, 0, var17, l3);
                    if(k8 != -1) {
                        onDemandFetcher.method560(k8, 3, false);
                    }
                }
            }
        }

    }

    public final void method23(boolean flag) {
        ObjectDefinition.aClass12_785.method224();
        ObjectDefinition.aClass12_780.method224();
        Class5.aClass12_95.method224();
        ItemDefinition.aClass12_159.method224();
        ItemDefinition.aClass12_158.method224();
        if(flag) {
            this.packet = -1;
        }

        Player.aClass12_1704.method224();
        Class23.aClass12_415.method224();
    }

    public final void method24(boolean flag, int i) {
        int[] ai = this.minimapImage.myPixels;
        int j = ai.length;

        int j1;
        for(j1 = 0; j1 < j; ++j1) {
            ai[j1] = 0;
        }

        int l1;
        int k2;
        for(j1 = 1; j1 < 103; ++j1) {
            l1 = 24628 + (103 - j1) * 512 * 4;

            for(k2 = 1; k2 < 103; ++k2) {
                if((this.aByteArrayArrayArray1258[i][k2][j1] & 24) == 0) {
                    this.aClass25_946.drawMinimapTile(ai, l1, 512, i, k2, j1);
                }

                if(i < 3 && (this.aByteArrayArrayArray1258[i + 1][k2][j1] & 8) != 0) {
                    this.aClass25_946.drawMinimapTile(ai, l1, 512, i + 1, k2, j1);
                }

                l1 += 4;
            }
        }

        j1 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
        l1 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
        this.minimapImage.method343(0);

        int l2;
        for(k2 = 1; k2 < 103; ++k2) {
            for(l2 = 1; l2 < 103; ++l2) {
                if((this.aByteArrayArrayArray1258[i][l2][k2] & 24) == 0) {
                    this.method50(k2, -960, j1, l2, l1, i);
                }

                if(i < 3 && (this.aByteArrayArrayArray1258[i + 1][l2][k2] & 8) != 0) {
                    this.method50(k2, -960, j1, l2, l1, i + 1);
                }
            }
        }

        aRSImageProducer_1165.initDrawingArea();
        loggedIn &= flag;
        this.anInt1071 = 0;

        for(k2 = 0; k2 < 104; ++k2) {
            for(l2 = 0; l2 < 104; ++l2) {
                long i3 = this.aClass25_946.method303(this.anInt918, k2, l2);
                if(i3 != 0L) {
                    int objId = ObjectKey.getObjectId(i3);
                    int j3 = ObjectDefinition.forID(objId).anInt746;
                    if(j3 >= 0) {
                        int k3 = k2;
                        int l3 = l2;
                        if(j3 != 22 && j3 != 29 && j3 != 34 && j3 != 36 && j3 != 46 && j3 != 47 && j3 != 48) {
                            byte byte0 = 104;
                            byte byte1 = 104;
                            int[][] ai1 = this.collisionMaps[this.anInt918].anIntArrayArray294;

                            for(int i4 = 0; i4 < 10; ++i4) {
                                int j4 = (int)(Math.random() * 4.0D);
                                if(j4 == 0 && k3 > 0 && k3 > k2 - 3 && (ai1[k3 - 1][l3] & 19398920) == 0) {
                                    --k3;
                                }

                                if(j4 == 1 && k3 < byte0 - 1 && k3 < k2 + 3 && (ai1[k3 + 1][l3] & 19399040) == 0) {
                                    ++k3;
                                }

                                if(j4 == 2 && l3 > 0 && l3 > l2 - 3 && (ai1[k3][l3 - 1] & 19398914) == 0) {
                                    --l3;
                                }

                                if(j4 == 3 && l3 < byte1 - 1 && l3 < l2 + 3 && (ai1[k3][l3 + 1] & 19398944) == 0) {
                                    ++l3;
                                }
                            }
                        }

                        this.aSpriteArray1140[this.anInt1071] = this.aSpriteArray1033[j3];
                        this.anIntArray1072[this.anInt1071] = k3;
                        this.anIntArray1073[this.anInt1071] = l3;
                        ++this.anInt1071;
                    }
                }
            }
        }

    }

    public final void method25(int i, int j) {
        DoubleEndedQueue doubleEndedQueue = this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][i][j];
        if(doubleEndedQueue == null) {
            this.aClass25_946.method295(this.anInt918, i, j);
        } else {
            int k = -99999999;
            Class30_Sub2_Sub4_Sub2 obj = null;

            Class30_Sub2_Sub4_Sub2 obj1;
            int i1;
            for(obj1 = (Class30_Sub2_Sub4_Sub2) doubleEndedQueue.reverseGetFirst(); obj1 != null; obj1 = (Class30_Sub2_Sub4_Sub2) doubleEndedQueue.reverseGetNext(false)) {
                ItemDefinition obj2 = ItemDefinition.method198(obj1.anInt1558);
                i1 = obj2.value;
                if(obj2.stackable) {
                    i1 *= obj1.anInt1559 + 1;
                }

                if(i1 > k) {
                    k = i1;
                    obj = obj1;
                }
            }

            doubleEndedQueue.method250(-493, (Class30)((Class30)obj));
            obj1 = null;
            Class30_Sub2_Sub4_Sub2 obj21 = null;

            for(Class30_Sub2_Sub4_Sub2 i11 = (Class30_Sub2_Sub4_Sub2) doubleEndedQueue.reverseGetFirst(); i11 != null; i11 = (Class30_Sub2_Sub4_Sub2) doubleEndedQueue.reverseGetNext(false)) {
                if(i11.anInt1558 != ((Class30_Sub2_Sub4_Sub2)((Class30_Sub2_Sub4_Sub2)obj)).anInt1558 && obj1 == null) {
                    obj1 = i11;
                }

                if(i11.anInt1558 != ((Class30_Sub2_Sub4_Sub2)((Class30_Sub2_Sub4_Sub2)obj)).anInt1558 && i11.anInt1558 != ((Class30_Sub2_Sub4_Sub2)((Class30_Sub2_Sub4_Sub2)obj1)).anInt1558 && obj21 == null) {
                    obj21 = i11;
                }
            }

            i1 = i + (j << 7) + 1610612736;
            this.aClass25_946.method281((byte)7, i, i1, (Animable)((Animable)obj1), this.method42(this.anInt918, j * 128 + 64, true, i * 128 + 64), (Animable)((Animable)obj21), (Animable)((Animable)obj), this.anInt918, j);
        }
    }

    public final void method26(boolean flag, int i) {
        for(int j = 0; j < this.npcCount; ++j) {
            Npc npc = this.npcs[this.npcIndices[j]];
            long k = 536870912L | (long)this.npcIndices[j] << 32;
            if(npc != null && npc.method449(aBoolean1224) && npc.desc.aBoolean93 == flag) {
                int l = npc.anInt1550 >> 7;
                int i1 = npc.anInt1551 >> 7;
                if(l >= 0 && l < 104 && i1 >= 0 && i1 < 104) {
                    if(npc.anInt1540 == 1 && (npc.anInt1550 & 127) == 64 && (npc.anInt1551 & 127) == 64) {
                        if(this.anIntArrayArray929[l][i1] == this.renderCount) {
                            continue;
                        }

                        this.anIntArrayArray929[l][i1] = this.renderCount;
                    }

                    if(!npc.desc.aBoolean84) {
                        k |= Long.MIN_VALUE;
                    }

                    this.aClass25_946.method285(this.anInt918, npc.anInt1552, (byte)6, this.method42(this.anInt918, npc.anInt1551, true, npc.anInt1550), k, npc.anInt1551, (npc.anInt1540 - 1) * 64 + 60, npc.anInt1550, npc, npc.aBoolean1541);
                }
            }
        }

        if(i == -30815) {
            ;
        }

    }

    public final boolean method27(int i) {
        if(i != 11456) {
            throw new NullPointerException();
        } else {
            return signlink.wavereplay();
        }
    }

    private final void method28(String s) {
        System.out.println(s);

        try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "loaderror_" + s + ".html"));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        while(true) {
            while(true) {
                try {
                    Thread.sleep(1000L);
                } catch (Exception var4) {
                    ;
                }
            }
        }
    }

    public final void buildInterfaceMenu(int i, int j, Widget class9, int k, int l, int i1, int j1) {
        if(class9.type == 0 && class9.children != null && !class9.isMouseoverTriggered) {
            if(k >= i && i1 >= l && k <= i + class9.width && i1 <= l + class9.height) {
                int k1 = class9.children.length;
                if(j != 13037) {
                    this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
                }

                for(int l1 = 0; l1 < k1; ++l1) {
                    int i2 = class9.childX[l1] + i;
                    int j2 = class9.childY[l1] + l - j1;
                    Widget class9_1 = Widget.interfaceCache[class9.children[l1]];
                    i2 += class9_1.anInt263;
                    j2 += class9_1.anInt265;
                    if((class9_1.mOverInterToTrigger >= 0 || class9_1.anInt216 != 0) && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                        if(class9_1.mOverInterToTrigger >= 0) {
                            this.anInt886 = class9_1.mOverInterToTrigger;
                        } else {
                            this.anInt886 = class9_1.id;
                        }
                    }

                    if(class9_1.type == 0) {
                        this.buildInterfaceMenu(i2, 13037, class9_1, k, j2, i1, class9_1.scrollPosition);
                        if(class9_1.scrollMax > class9_1.height) {
                            this.method65(i2 + class9_1.width, class9_1.height, k, i1, class9_1, j2, true, class9_1.scrollMax, 0);
                        }
                    } else {
                        if(class9_1.atActionType == 1 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                            boolean k2 = false;
                            if(class9_1.contentType != 0) {
                                k2 = this.method103(class9_1, false);
                            }

                            if(!k2) {
                                this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                                this.menuActionID[this.menuActionRow] = 315;
                                this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                ++this.menuActionRow;
                            }
                        }

                        if(class9_1.atActionType == 2 && this.anInt1136 == 0 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                            String var20 = class9_1.selectedActionName;
                            if(var20.indexOf(" ") != -1) {
                                var20 = var20.substring(0, var20.indexOf(" "));
                            }

                            this.menuActionName[this.menuActionRow] = var20 + " <col=65280>" + class9_1.spellName;
                            this.menuActionID[this.menuActionRow] = 626;
                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                            ++this.menuActionRow;
                        }

                        if(class9_1.atActionType == 3 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                            this.menuActionName[this.menuActionRow] = "Close";
                            this.menuActionID[this.menuActionRow] = 200;
                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                            ++this.menuActionRow;
                        }

                        if(class9_1.atActionType == 4 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                            this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                            this.menuActionID[this.menuActionRow] = 169;
                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                            ++this.menuActionRow;
                        }

                        if(class9_1.atActionType == 5 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                            this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                            this.menuActionID[this.menuActionRow] = 646;
                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                            ++this.menuActionRow;
                        }

                        if(class9_1.atActionType == 6 && !this.aBoolean1149 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width && i1 < j2 + class9_1.height) {
                            this.menuActionName[this.menuActionRow] = class9_1.tooltip;
                            this.menuActionID[this.menuActionRow] = 679;
                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                            ++this.menuActionRow;
                        }
                        if (class9_1.atActionType == 8 && !aBoolean1149 && k >= i2 && i1 >= j2 && k < i2 + class9_1.width
                                && i1 < j2 + class9_1.height) {
                            for (int s1 = 0; s1 < class9_1.tooltips.length; s1++) {
								/*if (!Widget.interfaceCache[32007].isMouseoverTriggered) {
									if (class9_1.id > 32016) {
										continue;
									}
								}*/
                                menuActionName[menuActionRow] = class9_1.tooltips[s1];
                                menuActionID[menuActionRow] = 1700 + s1;
                                menuActionCmd3[menuActionRow] = class9_1.id;
                                menuActionRow++;
                            }
                        }
                        int var21;
                        if(k >= i2 && i1 >= j2 && k < i2 + (class9_1.type == 4?100:class9_1.width) && i1 < j2 + class9_1.height && class9_1.actions != null && (class9_1.type == 4 && class9_1.message.length() > 0 || class9_1.type == 5)) {
                            for(var21 = class9_1.actions.length - 1; var21 >= 0; --var21) {
                                if(class9_1.actions[var21] != null) {
                                    this.menuActionName[this.menuActionRow] = class9_1.actions[var21] + (class9_1.type == 4?" " + class9_1.message:"");
                                    this.menuActionID[this.menuActionRow] = 647;
                                    this.menuActionCmd2[this.menuActionRow] = var21;
                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                    ++this.menuActionRow;
                                }
                            }
                        }

                        if(class9_1.type == 2) {
                            var21 = 0;

                            for(int l2 = 0; l2 < class9_1.height; ++l2) {
                                for(int i3 = 0; i3 < class9_1.width; ++i3) {
                                    int j3 = i2 + i3 * (32 + class9_1.invSpritePadX);
                                    int k3 = j2 + l2 * (32 + class9_1.invSpritePadY);
                                    if(var21 < 20) {
                                        j3 += class9_1.spritesX[var21];
                                        k3 += class9_1.spritesY[var21];
                                    }

                                    if(k >= j3 && i1 >= k3 && k < j3 + 32 && i1 < k3 + 32) {
                                        this.anInt1066 = var21;
                                        this.anInt1067 = class9_1.id;
                                        if(class9_1.inventoryItemId[var21] > 0) {
                                            ItemDefinition class8 = ItemDefinition.method198(class9_1.inventoryItemId[var21] - 1);
                                            if(this.anInt1282 == 1 && class9_1.isInventoryInterface) {
                                                if(class9_1.id != this.anInt1284 || var21 != this.anInt1283) {
                                                    this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=ff9040>" + class8.name;
                                                    this.menuActionID[this.menuActionRow] = 870;
                                                    this.menuActionCmd1[this.menuActionRow] = (long)class8.anInt157;
                                                    this.menuActionCmd2[this.menuActionRow] = var21;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                }
                                            } else if(this.anInt1136 == 1 && class9_1.isInventoryInterface) {
                                                if((this.anInt1138 & 16) == 16) {
                                                    this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ff9040>" + class8.name;
                                                    this.menuActionID[this.menuActionRow] = 543;
                                                    this.menuActionCmd1[this.menuActionRow] = (long)class8.anInt157;
                                                    this.menuActionCmd2[this.menuActionRow] = var21;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                }
                                            } else {
                                                int j4;
                                                if (class9_1.isInventoryInterface) {
                                                    for (j4 = 4; j4 >= 3; --j4) {
                                                        if (class8.itemActions != null && class8.itemActions[j4] != null) {
                                                            this.menuActionName[this.menuActionRow] = class8.itemActions[j4] + " <col=ff9040>" + class8.name;
                                                            if (j4 == 3) {
                                                                this.menuActionID[this.menuActionRow] = 493;
                                                            }

                                                            if (j4 == 4) {
                                                                this.menuActionID[this.menuActionRow] = 847;
                                                            }

                                                            this.menuActionCmd1[this.menuActionRow] = (long) class8.anInt157;
                                                            this.menuActionCmd2[this.menuActionRow] = var21;
                                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                            ++this.menuActionRow;
                                                        } else if (j4 == 4) {
                                                            this.menuActionName[this.menuActionRow] = "Drop <col=ff9040>" + class8.name;
                                                            this.menuActionID[this.menuActionRow] = 847;
                                                            this.menuActionCmd1[this.menuActionRow] = (long) class8.anInt157;
                                                            this.menuActionCmd2[this.menuActionRow] = var21;
                                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                            ++this.menuActionRow;
                                                        }
                                                    }
                                                }

                                                if (class9_1.usableItemInterface) {
                                                    this.menuActionName[this.menuActionRow] = "Use <col=ff9040>" + class8.name;
                                                    this.menuActionID[this.menuActionRow] = 447;
                                                    this.menuActionCmd1[this.menuActionRow] = (long) class8.anInt157;
                                                    this.menuActionCmd2[this.menuActionRow] = var21;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                }

                                                if (class9_1.isInventoryInterface && class8.itemActions != null) {
                                                    for (j4 = 2; j4 >= 0; --j4) {
                                                        if (class8.itemActions[j4] != null) {
                                                            this.menuActionName[this.menuActionRow] = class8.itemActions[j4] + " <col=ff9040>" + class8.name;
                                                            if (j4 == 0) {
                                                                this.menuActionID[this.menuActionRow] = 74;
                                                            }

                                                            if (j4 == 1) {
                                                                this.menuActionID[this.menuActionRow] = 454;
                                                            }

                                                            if (j4 == 2) {
                                                                this.menuActionID[this.menuActionRow] = 539;
                                                            }

                                                            this.menuActionCmd1[this.menuActionRow] = (long) class8.anInt157;
                                                            this.menuActionCmd2[this.menuActionRow] = var21;
                                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                            ++this.menuActionRow;
                                                        }
                                                    }
                                                }
                                                if (class9_1.id == 5382) {
                                                    if (modifiableXValue > 0) {// so issue is when x = 0
                                                        if (class9_1.actions.length < 9) {
                                                            class9_1.actions = new String[]{
                                                                    "Withdraw-1",
                                                                    "Withdraw-5",
                                                                    "Withdraw-10",
                                                                    "Withdraw-All",
                                                                    "Withdraw-X",
                                                                    "Withdraw-" + modifiableXValue,
                                                                    "Withdraw-All-but-1"
                                                            };
                                                        } else {
                                                            class9_1.actions[5] = "Withdraw-" + modifiableXValue;
                                                        }
                                                    }
                                                }
                                                if (class9_1.actions != null) {
                                                    for (j4 = 8; j4 >= 0; --j4) {
                                                        if (j4 > class9_1.actions.length - 1)
                                                            continue;
                                                        if (class9_1.actions[j4] != null) {
                                                            this.menuActionName[this.menuActionRow] = class9_1.actions[j4] + " <col=ff9040>" + class8.name;
                                                            if (j4 == 0) {
                                                                this.menuActionID[this.menuActionRow] = 632;
                                                            }

                                                            if (j4 == 1) {
                                                                this.menuActionID[this.menuActionRow] = 78;
                                                            }

                                                            if (j4 == 2) {
                                                                this.menuActionID[this.menuActionRow] = 867;
                                                            }

                                                            if (j4 == 3) {
                                                                this.menuActionID[this.menuActionRow] = 431;
                                                            }

                                                            if (j4 == 4) {
                                                                this.menuActionID[this.menuActionRow] = 53;
                                                            }

                                                            if (j4 == 5) {
                                                                this.menuActionID[this.menuActionRow] = 300;
                                                            }
                                                            if (j4 == 6) {
                                                                menuActionID[menuActionRow] = 291;
                                                            }

                                                            this.menuActionCmd1[this.menuActionRow] = (long) class8.anInt157;
                                                            this.menuActionCmd2[this.menuActionRow] = var21;
                                                            this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                            ++this.menuActionRow;
                                                        }
                                                    }
                                                }

                                                if (class9_1.isItemSearchComponent) {
                                                    menuActionName[menuActionRow] = "Select @lre@" + class8.name;
                                                    menuActionID[menuActionRow] = 1130;
                                                    menuActionCmd1[menuActionRow] = class8.anInt157;
                                                    menuActionCmd2[menuActionRow] = var21;
                                                    menuActionCmd3[menuActionRow] = class9_1.id;
                                                    menuActionRow++;
                                                } else {
                                                    if (this.myPrivilege != 2 && this.myPrivilege != 9 && this.myPrivilege != 10 && this.myPrivilege != 4) {
                                                        this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>" + class8.name + "</col>";
                                                    } else {
                                                        this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>" + class8.name + "</col><col=65280>(</col>ID:<col=ffffff>" + class8.anInt157 + "</col><col=65280>)</col>(Model:</col><col=ffffff>" + class8.modelId + "</col><col=65280>)";
                                                    }

                                                    this.menuActionID[this.menuActionRow] = 1125;
                                                    this.menuActionCmd1[this.menuActionRow] = (long) class8.anInt157;
                                                    this.menuActionCmd2[this.menuActionRow] = var21;
                                                    this.menuActionCmd3[this.menuActionRow] = class9_1.id;
                                                    ++this.menuActionRow;
                                                }
                                            }
                                        }
                                    }

                                    ++var21;
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public void drawTransparentScrollBar(int x, int y, int height, int maxScroll, int pos) {
        this.gameframe[33].drawARGBSprite(x, y, 120);
        this.gameframe[34].drawARGBSprite(x, y + height - 16, 120);
        DrawingArea.drawVerticalLine(x, y + 16, height - 32, 16777215, 64);
        DrawingArea.drawVerticalLine(x + 15, y + 16, height - 32, 16777215, 64);
        int barHeight = (height - 32) * height / maxScroll;
        if(barHeight < 10) {
            barHeight = 10;
        }

        int barPos = 0;
        if(maxScroll != height) {
            barPos = (height - 32 - barHeight) * pos / (maxScroll - height);
        }

        DrawingArea.drawRectangle(x, y + 16 + barPos, 16, 5 + y + 16 + barPos + barHeight - 5 - (y + 16 + barPos), 16777215, 32);
    }

    public void playSound(int id, int type, int delay, int volume) {
        this.sound[this.currentSound] = id;
        this.soundType[this.currentSound] = type;
        this.soundDelay[this.currentSound] = Sound.anIntArray326[id];
        this.soundVolume[this.currentSound] = volume;
        ++this.currentSound;
    }

    public void drawScrollbar(int height, int pos, int y, int x, int maxScroll, boolean transparent) {
        if(transparent) {
            this.drawTransparentScrollBar(x, y, height, maxScroll, pos);
        } else {
            this.aSprite_1024.drawSprite(x, y);
            this.aSprite_1025.drawSprite(x, y + height - 16);
            DrawingArea.drawPixels(height - 32, y + 16, x, 1, 16);
            DrawingArea.drawPixels(height - 32, y + 16, x, 4011046, 15);
            DrawingArea.drawPixels(height - 32, y + 16, x, 3419425, 13);
            DrawingArea.drawPixels(height - 32, y + 16, x, 3024925, 11);
            DrawingArea.drawPixels(height - 32, y + 16, x, 2696219, 10);
            DrawingArea.drawPixels(height - 32, y + 16, x, 2433049, 9);
            DrawingArea.drawPixels(height - 32, y + 16, x, 1, 1);
            int k1 = (height - 32) * height / maxScroll;
            if(k1 < 8) {
                k1 = 8;
            }

            int l1 = (height - 32 - k1) * pos / (maxScroll - height);
            DrawingArea.drawPixels(k1, y + 16 + l1, x, this.anInt1063, 16);
            DrawingArea.method341(y + 16 + l1, 1, k1, x);
            DrawingArea.method341(y + 16 + l1, 3230769, k1, x + 1);
            DrawingArea.method341(y + 16 + l1, 3626039, k1, x + 2);
            DrawingArea.method341(y + 16 + l1, 3955773, k1, x + 3);
            DrawingArea.method341(y + 16 + l1, 3955773, k1, x + 4);
            DrawingArea.method341(y + 16 + l1, 4087870, k1, x + 5);
            DrawingArea.method341(y + 16 + l1, 4087870, k1, x + 6);
            DrawingArea.method341(y + 16 + l1, 4351297, k1, x + 7);
            DrawingArea.method341(y + 16 + l1, 4351297, k1, x + 8);
            DrawingArea.method341(y + 16 + l1, 4087870, k1, x + 9);
            DrawingArea.method341(y + 16 + l1, 4087870, k1, x + 10);
            DrawingArea.method341(y + 16 + l1, 4021565, k1, x + 11);
            DrawingArea.method341(y + 16 + l1, 4021565, k1, x + 12);
            DrawingArea.method341(y + 16 + l1, 4087870, k1, x + 13);
            DrawingArea.method341(y + 16 + l1, 3626039, k1, x + 14);
            DrawingArea.method339(y + 16 + l1, 1, 15, x);
            DrawingArea.method339(y + 17 + l1, 1, 15, x);
            DrawingArea.method339(y + 17 + l1, 4087870, 14, x);
            DrawingArea.method339(y + 17 + l1, 3955773, 13, x);
            DrawingArea.method339(y + 17 + l1, 4616006, 11, x);
            DrawingArea.method339(y + 17 + l1, 3626039, 10, x);
            DrawingArea.method339(y + 17 + l1, 3955773, 7, x);
            DrawingArea.method339(y + 17 + l1, 3626039, 5, x);
            DrawingArea.method339(y + 17 + l1, 3955773, 4, x);
            DrawingArea.method339(y + 17 + l1, 3230769, 3, x);
            DrawingArea.method339(y + 17 + l1, 1, 2, x);
            DrawingArea.method339(y + 18 + l1, 1, 16, x);
            DrawingArea.method339(y + 18 + l1, 5655352, 15, x);
            DrawingArea.method339(y + 18 + l1, 4087870, 14, x);
            DrawingArea.method339(y + 18 + l1, 6444608, 11, x);
            DrawingArea.method339(y + 18 + l1, 4087870, 10, x);
            DrawingArea.method339(y + 18 + l1, 3955773, 7, x);
            DrawingArea.method339(y + 18 + l1, 7233606, 5, x);
            DrawingArea.method339(y + 18 + l1, 7430727, 4, x);
            DrawingArea.method339(y + 18 + l1, 8088141, 3, x);
            DrawingArea.method339(y + 18 + l1, 3230769, 2, x);
            DrawingArea.method339(y + 18 + l1, 1, 1, x);
            DrawingArea.method339(y + 19 + l1, 1, 16, x);
            DrawingArea.method339(y + 19 + l1, 4087870, 15, x);
            DrawingArea.method339(y + 19 + l1, 5655352, 14, x);
            DrawingArea.method339(y + 19 + l1, 4087870, 11, x);
            DrawingArea.method339(y + 19 + l1, 4351297, 9, x);
            DrawingArea.method339(y + 19 + l1, 4087870, 7, x);
            DrawingArea.method339(y + 19 + l1, 3955773, 5, x);
            DrawingArea.method339(y + 19 + l1, 7233606, 4, x);
            DrawingArea.method339(y + 19 + l1, 3626039, 3, x);
            DrawingArea.method339(y + 19 + l1, 3230769, 2, x);
            DrawingArea.method339(y + 19 + l1, 1, 1, x);
            DrawingArea.method339(y + 20 + l1, 1, 16, x);
            DrawingArea.method339(y + 20 + l1, 3626039, 15, x);
            DrawingArea.method339(y + 20 + l1, 5523766, 14, x);
            DrawingArea.method339(y + 20 + l1, 4021565, 13, x);
            DrawingArea.method339(y + 20 + l1, 4087870, 10, x);
            DrawingArea.method339(y + 20 + l1, 4351297, 8, x);
            DrawingArea.method339(y + 20 + l1, 4087870, 6, x);
            DrawingArea.method339(y + 20 + l1, 3955773, 4, x);
            DrawingArea.method339(y + 20 + l1, 3626039, 3, x);
            DrawingArea.method339(y + 20 + l1, 3230769, 2, x);
            DrawingArea.method339(y + 20 + l1, 1, 1, x);
            DrawingArea.method341(y + 16 + l1, 1, k1, x + 15);
            DrawingArea.method339(y + 15 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 14 + l1 + k1, 1, 15, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4142890, 14, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4471853, 10, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4734511, 9, x);
            DrawingArea.method339(y + 14 + l1 + k1, 4866095, 7, x);
            DrawingArea.method339(y + 14 + l1 + k1, 3626039, 4, x);
            DrawingArea.method339(y + 14 + l1 + k1, 5655352, 3, x);
            DrawingArea.method339(y + 14 + l1 + k1, 1, 2, x);
            DrawingArea.method339(y + 13 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 13 + l1 + k1, 4471853, 15, x);
            DrawingArea.method339(y + 13 + l1 + k1, 3626039, 11, x);
            DrawingArea.method339(y + 13 + l1 + k1, 4087870, 9, x);
            DrawingArea.method339(y + 13 + l1 + k1, 5523766, 7, x);
            DrawingArea.method339(y + 13 + l1 + k1, 5655352, 6, x);
            DrawingArea.method339(y + 13 + l1 + k1, 4021565, 4, x);
            DrawingArea.method339(y + 13 + l1 + k1, 6444608, 3, x);
            DrawingArea.method339(y + 13 + l1 + k1, 3955773, 2, x);
            DrawingArea.method339(y + 13 + l1 + k1, 1, 1, x);
            DrawingArea.method339(y + 12 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 12 + l1 + k1, 4471853, 15, x);
            DrawingArea.method339(y + 12 + l1 + k1, 3626039, 14, x);
            DrawingArea.method339(y + 12 + l1 + k1, 5523766, 12, x);
            DrawingArea.method339(y + 12 + l1 + k1, 5655352, 11, x);
            DrawingArea.method339(y + 12 + l1 + k1, 4021565, 10, x);
            DrawingArea.method339(y + 12 + l1 + k1, 4087870, 7, x);
            DrawingArea.method339(y + 12 + l1 + k1, 4351297, 4, x);
            DrawingArea.method339(y + 12 + l1 + k1, 7233606, 3, x);
            DrawingArea.method339(y + 12 + l1 + k1, 8088141, 2, x);
            DrawingArea.method339(y + 12 + l1 + k1, 1, 1, x);
            DrawingArea.method339(y + 11 + l1 + k1, 1, 16, x);
            DrawingArea.method339(y + 11 + l1 + k1, 3626039, 15, x);
            DrawingArea.method339(y + 11 + l1 + k1, 4087870, 14, x);
            DrawingArea.method339(y + 11 + l1 + k1, 5655352, 13, x);
            DrawingArea.method339(y + 11 + l1 + k1, 4021565, 11, x);
            DrawingArea.method339(y + 11 + l1 + k1, 4087870, 9, x);
            DrawingArea.method339(y + 11 + l1 + k1, 4351297, 7, x);
            DrawingArea.method339(y + 11 + l1 + k1, 4087870, 5, x);
            DrawingArea.method339(y + 11 + l1 + k1, 3955773, 4, x);
            DrawingArea.method339(y + 11 + l1 + k1, 3626039, 3, x);
            DrawingArea.method339(y + 11 + l1 + k1, 8088141, 2, x);
            DrawingArea.method339(y + 11 + l1 + k1, 1, 1, x);
        }

    }

    public void launchURL(String url) {
        if(!url.toLowerCase().startsWith("http")) {
            url = "http://" + url;
        }

        String osName = System.getProperty("os.name");

        try {
            if(osName.startsWith("Mac OS")) {
                Class e = Class.forName("com.apple.eio.FileManager");
                Method openURL = e.getDeclaredMethod("openURL", new Class[]{String.class});
                openURL.invoke((Object)null, new Object[]{url});
            } else if(osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception var5) {
            this.pushMessage("Failed to open URL.", 0, "");
            System.err.println("Failed to launcher url on operating system " + osName);
            var5.printStackTrace();
        }

    }

    private void updateNPCs(Stream stream, int i) {
        this.anInt839 = 0;
        this.anInt893 = 0;
        this.method139(stream);
        this.method46(i, stream, (byte)2);
        this.updateNpcState(i, stream, true);

        int i1;
        for(i1 = 0; i1 < this.anInt839; ++i1) {
            int l = this.anIntArray840[i1];
            if(this.npcs[l].anInt1537 != loopCycle) {
                this.npcs[l].desc = null;
                this.npcs[l] = null;
            }
        }

        for(i1 = 0; i1 < this.npcCount; ++i1) {
            if(this.npcs[this.npcIndices[i1]] == null) {
                signlink.reporterror(this.myUsername + " null entry in npc list - pos:" + i1 + " size:" + this.npcCount);
                throw new RuntimeException("eek");
            }
        }

    }

    public final void method32(boolean flag) {
        loggedIn &= flag;
        if(super.clickMode3 == 1) {
            if(super.saveClickX >= 6 && super.saveClickX <= 106 && super.saveClickY >= 467 && super.saveClickY <= 499) {
                this.publicChatMode = (this.publicChatMode + 1) % 4;
                this.aBoolean1233 = true;
                this.inputTaken = true;
                this.stream.createFrame(95);
                this.stream.writeUnsignedByte(this.publicChatMode);
                this.stream.writeUnsignedByte(this.privateChatMode);
                this.stream.writeUnsignedByte(this.tradeMode);
            }

            if(super.saveClickX >= 135 && super.saveClickX <= 235 && super.saveClickY >= 467 && super.saveClickY <= 499) {
                this.privateChatMode = (this.privateChatMode + 1) % 3;
                this.aBoolean1233 = true;
                this.inputTaken = true;
                this.stream.createFrame(95);
                this.stream.writeUnsignedByte(this.publicChatMode);
                this.stream.writeUnsignedByte(this.privateChatMode);
                this.stream.writeUnsignedByte(this.tradeMode);
            }

            if(super.saveClickX >= 273 && super.saveClickX <= 373 && super.saveClickY >= 467 && super.saveClickY <= 499) {
                this.tradeMode = (this.tradeMode + 1) % 3;
                this.aBoolean1233 = true;
                this.inputTaken = true;
                this.stream.createFrame(95);
                this.stream.writeUnsignedByte(this.publicChatMode);
                this.stream.writeUnsignedByte(this.privateChatMode);
                this.stream.writeUnsignedByte(this.tradeMode);
            }

            int j;
            if(super.saveClickX >= 412 && super.saveClickX <= 512 && super.saveClickY >= 467 && super.saveClickY <= 499) {
                if(openInterfaceID == -1) {
                    this.clearTopInterfaces(537);
                    this.reportAbuseInput = "";
                    this.canMute = false;

                    for(j = 0; j < Widget.interfaceCache.length; ++j) {
                        if(Widget.interfaceCache[j] != null && Widget.interfaceCache[j].contentType == 600) {
                            this.reportAbuseInterfaceID = openInterfaceID = Widget.interfaceCache[j].parentID;
                            break;
                        }
                    }
                } else {
                    this.pushMessage("Please close the interface you have open before using \'report abuse\'", 0, "");
                }
            }

            ++anInt940;
            if(anInt940 > 1386) {
                anInt940 = 0;
                this.stream.createFrame(165);
                this.stream.writeUnsignedByte(0);
                j = this.stream.currentPosition;
                this.stream.writeUnsignedByte(139);
                this.stream.writeUnsignedByte(150);
                this.stream.writeWord(32131);
                this.stream.writeUnsignedByte((int)(Math.random() * 256.0D));
                this.stream.writeWord(3250);
                this.stream.writeUnsignedByte(177);
                this.stream.writeWord(24859);
                this.stream.writeUnsignedByte(119);
                if((int)(Math.random() * 2.0D) == 0) {
                    this.stream.writeWord('\ub882');
                }

                if((int)(Math.random() * 2.0D) == 0) {
                    this.stream.writeUnsignedByte(21);
                }

                this.stream.method407(this.stream.currentPosition - j, (byte)0);
            }
        }

    }

    public final void method33(boolean flag, int i) {
        int j = VarpDefinition.aVarpDefinitionArray701[i].anInt709;
        if(j != 0) {
            int k = this.variousSettings[i];
            if(flag) {
                this.anInt961 = (int) this.aISAACRandomGen_1000.getNextIntKey();
            }

            if(j == 1) {
                if(k == 1) {
                    Rasterizer.method372(0.9D);
                }

                if(k == 2) {
                    Rasterizer.method372(0.8D);
                }

                if(k == 3) {
                    Rasterizer.method372(0.7D);
                }

                if(k == 4) {
                    Rasterizer.method372(0.6D);
                }

                ItemDefinition.aClass12_158.method224();
                this.aBoolean1255 = true;
            }

            if(j == 3) {
                boolean flag1 = this.musicEnabled;
                if(k == 0) {
                    this.adjustVolume(this.musicEnabled, 100);
                    this.musicEnabled = true;
                }

                if(k == 1) {
                    this.adjustVolume(this.musicEnabled, 80);
                    this.musicEnabled = true;
                }

                if(k == 2) {
                    this.method123((byte)0, this.musicEnabled, 70);
                    this.musicEnabled = true;
                }

                if(k == 3) {
                    this.method123((byte)0, this.musicEnabled, 40);
                    this.musicEnabled = true;
                }

                if(k == 4) {
                    this.musicEnabled = false;
                }

                if(this.musicEnabled != flag1) {
                    if(this.musicEnabled) {
                        this.nextSong = this.currentSong;
                        this.songChanging = true;
                        onDemandFetcher.method558(2, this.nextSong);
                    } else {
                        this.stopMidi();
                    }

                    this.previousSong = 0;
                }
            }

            if(j == 4) {
                SoundPlayer.setVolume(k);
                if(k == 0) {
                    this.aBoolean848 = true;
                    this.method111((byte)2, -1200);
                }

                if(k == 1) {
                    this.aBoolean848 = true;
                    this.method111((byte)2, -800);
                }

                if(k == 2) {
                    this.aBoolean848 = true;
                    this.method111((byte)2, -400);
                }

                if(k == 3) {
                    this.aBoolean848 = true;
                    this.method111((byte)2, 0);
                }

                if(k == 4) {
                    this.aBoolean848 = false;
                }
            }

            if(j == 5) {
                this.anInt1253 = k;
            }

            if(j == 6) {
                this.anInt1249 = k;
            }

            if(j == 8) {
                this.splitPrivateChat = k;
                this.inputTaken = true;
            }

            if(j == 9) {
                this.anInt913 = k;
            }

        }
    }

    public final void method34(int var1) {
        this.anInt974 = 0;

        int var2;
        int var14;
        for(var2 = -1; var2 < this.anInt891 + this.npcCount; ++var2) {
            Object var12;
            if(var2 == -1) {
                var12 = localPlayer;
            } else if(var2 < this.anInt891) {
                var12 = this.players[this.anIntArray892[var2]];
            } else {
                var12 = this.npcs[this.npcIndices[var2 - this.anInt891]];
            }

            if(var12 != null && ((Class30_Sub2_Sub4_Sub1)var12).method449(aBoolean1224)) {
                Class5 var13;
                if(var12 instanceof Npc) {
                    var13 = ((Npc)var12).desc;
                    if(var13.anIntArray88 != null) {
                        var13 = var13.method161();
                    }

                    if(var13 == null) {
                        continue;
                    }
                }

                if(var2 < this.anInt891) {
                    var14 = 30;
                    Player var7 = (Player)var12;
                    if(var7.headIcon >= 0) {
                        this.method127(true, (Class30_Sub2_Sub4_Sub1)var12, ((Class30_Sub2_Sub4_Sub1)var12).anInt1507 + 15);
                        if(this.spriteDrawX > -1) {
                            if(var7.skullIcon < 2) {
                                this.skullIcons[var7.skullIcon].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - var14);
                                var14 += 25;
                            }

                            if(var7.headIcon < 7) {
                                this.headIcons[var7.headIcon].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - var14);
                                var14 += 18;
                            }
                        }
                    }

                    if(var2 >= 0 && this.hintType == 10 && this.anInt933 == this.anIntArray892[var2]) {
                        this.method127(true, (Class30_Sub2_Sub4_Sub1)var12, ((Class30_Sub2_Sub4_Sub1)var12).anInt1507 + 15);
                        if(this.spriteDrawX > -1) {
                            this.headIcons[7].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - var14);
                        }
                    }
                } else {
                    var13 = ((Npc)var12).desc;
                    if(var13.anInt75 >= 0 && var13.anInt75 < this.headIcons.length) {
                        this.method127(true, (Class30_Sub2_Sub4_Sub1)var12, ((Class30_Sub2_Sub4_Sub1)var12).anInt1507 + 15);
                        if(this.spriteDrawX > -1) {
                            this.headIcons[var13.anInt75].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 30);
                        }
                    }

                    if(this.hintType == 1 && this.anInt1222 == this.npcIndices[var2 - this.anInt891] && loopCycle % 20 < 10) {
                        this.method127(true, (Class30_Sub2_Sub4_Sub1)var12, ((Class30_Sub2_Sub4_Sub1)var12).anInt1507 + 15);
                        if(this.spriteDrawX > -1) {
                            this.headIcons[0].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 28);
                        }
                    }
                }

                if(((Class30_Sub2_Sub4_Sub1)var12).aString1506 != null && (var2 >= this.anInt891 || this.publicChatMode == 0 || this.publicChatMode == 3 || this.publicChatMode == 1 && this.method109(((Player)var12).name))) {
                    this.method127(true, (Class30_Sub2_Sub4_Sub1)var12, ((Class30_Sub2_Sub4_Sub1)var12).anInt1507);
                    if(this.spriteDrawX > -1 && this.anInt974 < this.anInt975) {
                        this.anIntArray979[this.anInt974] = this.boldText.method384(((Class30_Sub2_Sub4_Sub1)var12).aString1506, true) / 2;
                        this.anIntArray978[this.anInt974] = this.boldText.anInt1497;
                        this.anIntArray976[this.anInt974] = this.spriteDrawX;
                        this.anIntArray977[this.anInt974] = this.spriteDrawY;
                        this.overheadTextColour[this.anInt974] = ((Class30_Sub2_Sub4_Sub1)var12).anInt1513;
                        this.anIntArray981[this.anInt974] = ((Class30_Sub2_Sub4_Sub1)var12).anInt1531;
                        this.overheadTextCycle[this.anInt974] = ((Class30_Sub2_Sub4_Sub1)var12).textCycle;
                        this.aStringArray983[this.anInt974++] = ((Class30_Sub2_Sub4_Sub1)var12).aString1506;
                        if(this.anInt1249 == 0 && ((Class30_Sub2_Sub4_Sub1)var12).anInt1531 >= 1 && ((Class30_Sub2_Sub4_Sub1)var12).anInt1531 <= 3) {
                            this.anIntArray978[this.anInt974] += 10;
                            this.anIntArray977[this.anInt974] += 5;
                        }

                        if(this.anInt1249 == 0 && ((Class30_Sub2_Sub4_Sub1)var12).anInt1531 == 4) {
                            this.anIntArray979[this.anInt974] = 60;
                        }

                        if(this.anInt1249 == 0 && ((Class30_Sub2_Sub4_Sub1)var12).anInt1531 == 5) {
                            this.anIntArray978[this.anInt974] += 5;
                        }
                    }
                }

                Class30_Sub2_Sub4_Sub1 entity = (Class30_Sub2_Sub4_Sub1) var12;

                if (entity.anInt1532 > loopCycle) {
                    this.method127(true, entity, entity.anInt1507 + 15);

                    if (this.spriteDrawX > -1 && entity.maxHealth > 0) {
                        int fullBarWidth = 30;
                        if (entity instanceof Npc) {
                            int maxHp = entity.maxHealth;
                            fullBarWidth = (maxHp >= 255) ? Math.min(maxHp, 300) : 30;
                        }

                        int current = entity.currentHealth;
                        int max = entity.maxHealth;

// Sanity checks
                        if (max <= 0) max = 1;
                        if (current > max) current = max;
                        if (current < 0) current = 0;

                        int barHeight = currentScreenMode == ScreenMode.FIXED ? 5 : 7;
                        int barX = this.spriteDrawX - (fullBarWidth / 2);
                        int barY = this.spriteDrawY - 3;

                        int hpBarWidth = current * fullBarWidth / max;
                        int missingBarWidth = fullBarWidth - hpBarWidth;

                        double healthPercent = (double) current / max;
                        int barColor;

                        if (healthPercent <= 0.25) {
                            barColor = 0xFFA500; // Orange
                        } else if (healthPercent <= 0.5) {
                            barColor = 0xFFFF00; // Yellow
                        } else {
                            barColor = 0x00FF00; // Green
                        }

// Optional: show text like 29/99
                        if (this.hp) {
                            this.boldText.method382(
                                    0xFF0000,
                                    this.spriteDrawX,
                                    -918,
                                    current + "/" + max,
                                    this.spriteDrawY - 9,
                                    true
                            );
                        }

// Draw green portion (current HP)
                        DrawingArea.drawPixels(
                                barHeight,
                                barY,
                                barX,
                                barColor,
                                hpBarWidth
                        );

// Draw red portion (missing HP)
                        DrawingArea.drawPixels(
                                barHeight,
                                barY,
                                barX + hpBarWidth,
                                0xFF0000,
                                missingBarWidth
                        );
                    }
                }


                for(var14 = 0; var14 < 4; ++var14) {
                    if(((Class30_Sub2_Sub4_Sub1)var12).anIntArray1516[var14] > loopCycle) {
                        this.method127(true, (Class30_Sub2_Sub4_Sub1)var12, ((Class30_Sub2_Sub4_Sub1)var12).anInt1507 / 2);
                        if(this.spriteDrawX > -1) {
                            if(var14 == 1) {
                                this.spriteDrawY -= 20;
                            }

                            if(var14 == 2) {
                                this.spriteDrawX -= 15;
                                this.spriteDrawY -= 10;
                            }

                            if(var14 == 3) {
                                this.spriteDrawX += 15;
                                this.spriteDrawY -= 10;
                            }

                            try {
                                this.aSpriteArray987[((Class30_Sub2_Sub4_Sub1)var12).anIntArray1515[var14]].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 12);
                                this.smallText.method381(0, String.valueOf(((Class30_Sub2_Sub4_Sub1)var12).anIntArray1514[var14]), 23693, this.spriteDrawY + 4, this.spriteDrawX);
                                this.smallText.method381(16777215, String.valueOf(((Class30_Sub2_Sub4_Sub1)var12).anIntArray1514[var14]), 23693, this.spriteDrawY + 3, this.spriteDrawX - 1);
                            } catch (ArrayIndexOutOfBoundsException var121) {
                                ;
                            } catch (NullPointerException var131) {
                                ;
                            }
                        }
                    }
                }
            }
        }

        if(var1 != 0) {
            this.method6();
        }

        for(var2 = 0; var2 < this.anInt974; ++var2) {
            int var141 = this.anIntArray976[var2];
            var14 = this.anIntArray977[var2];
            int var151 = this.anIntArray979[var2];
            int var6 = this.anIntArray978[var2];
            boolean var16 = true;

            while(var16) {
                var16 = false;

                for(int var15 = 0; var15 < var2; ++var15) {
                    if(var14 + 2 > this.anIntArray977[var15] - this.anIntArray978[var15] && var14 - var6 < this.anIntArray977[var15] + 2 && var141 - var151 < this.anIntArray976[var15] + this.anIntArray979[var15] && var141 + var151 > this.anIntArray976[var15] - this.anIntArray979[var15] && this.anIntArray977[var15] - this.anIntArray978[var15] < var14) {
                        var14 = this.anIntArray977[var15] - this.anIntArray978[var15];
                        var16 = true;
                    }
                }
            }

            this.spriteDrawX = this.anIntArray976[var2];
            this.spriteDrawY = this.anIntArray977[var2] = var14;
            String var17 = this.aStringArray983[var2];
            if(this.anInt1249 == 0) {
                int colour = 16776960;
                if(this.overheadTextColour[var2] < 6) {
                    colour = this.anIntArray965[this.overheadTextColour[var2]];
                }

                if(this.overheadTextColour[var2] == 6) {
                    colour = this.renderCount % 20 >= 10?16776960:16711680;
                }

                if(this.overheadTextColour[var2] == 7) {
                    colour = this.renderCount % 20 >= 10?'\uffff':255;
                }

                if(this.overheadTextColour[var2] == 8) {
                    colour = this.renderCount % 20 >= 10?8454016:'\ub000';
                }

                int var10;
                if(this.overheadTextColour[var2] == 9) {
                    var10 = 150 - this.overheadTextCycle[var2];
                    if(var10 < 50) {
                        colour = 16711680 + 1280 * var10;
                    } else if(var10 < 100) {
                        colour = 16776960 - 327680 * (var10 - 50);
                    } else if(var10 < 150) {
                        colour = '\uff00' + 5 * (var10 - 100);
                    }
                }

                if(this.overheadTextColour[var2] == 10) {
                    var10 = 150 - this.overheadTextCycle[var2];
                    if(var10 < 50) {
                        colour = 16711680 + 5 * var10;
                    } else if(var10 < 100) {
                        colour = 16711935 - 327680 * (var10 - 50);
                    } else if(var10 < 150) {
                        colour = 255 + 327680 * (var10 - 100) - 5 * (var10 - 100);
                    }
                }

                if(this.overheadTextColour[var2] == 11) {
                    var10 = 150 - this.overheadTextCycle[var2];
                    if(var10 < 50) {
                        colour = 16777215 - 327685 * var10;
                    } else if(var10 < 100) {
                        colour = '\uff00' + 327685 * (var10 - 50);
                    } else if(var10 < 150) {
                        colour = 16777215 - 327680 * (var10 - 100);
                    }
                }
                if (overheadTextColour[var2] == 12) {
                    colour = 0x004BFF;
                }
                if (overheadTextColour[var2] == 13) {
                    colour = 0x9D4674;
                }
                if (overheadTextColour[var2] == 14) {
                    colour = renderCount % 20 >= 10 ? 0xFF00FF : 0x9900FF;
                }
                if(this.anIntArray981[var2] == 0) {
                    this.boldText.method381(0, var17, 23693, this.spriteDrawY + 1, this.spriteDrawX);
                    this.boldText.method381(colour, var17, 23693, this.spriteDrawY, this.spriteDrawX);
                }

                if(this.anIntArray981[var2] == 1) {
                    this.boldText.method386(0, true, var17, this.spriteDrawX, this.renderCount, this.spriteDrawY + 1);
                    this.boldText.method386(colour, true, var17, this.spriteDrawX, this.renderCount, this.spriteDrawY);
                }

                if(this.anIntArray981[var2] == 2) {
                    this.boldText.method387(this.spriteDrawX, var17, this.renderCount, this.spriteDrawY + 1, this.aByte1194, 0);
                    this.boldText.method387(this.spriteDrawX, var17, this.renderCount, this.spriteDrawY, this.aByte1194, colour);
                }

                if(this.anIntArray981[var2] == 3) {
                    this.boldText.method388(150 - this.overheadTextCycle[var2], var17, true, this.renderCount, this.spriteDrawY + 1, this.spriteDrawX, 0);
                    this.boldText.method388(150 - this.overheadTextCycle[var2], var17, true, this.renderCount, this.spriteDrawY, this.spriteDrawX, colour);
                }

                int var11;
                if(this.anIntArray981[var2] == 4) {
                    var10 = this.boldText.method384(var17, true);
                    var11 = (150 - this.overheadTextCycle[var2]) * (var10 + 100) / 150;
                    DrawingArea.setDrawingArea(334, this.spriteDrawX - 50, this.spriteDrawX + 50, 0);
                    this.boldText.method385(0, var17, this.spriteDrawY + 1, 822, this.spriteDrawX + 50 - var11);
                    this.boldText.method385(colour, var17, this.spriteDrawY, 822, this.spriteDrawX + 50 - var11);
                    DrawingArea.method332(4);
                }

                if(this.anIntArray981[var2] == 5) {
                    var10 = 150 - this.overheadTextCycle[var2];
                    var11 = 0;
                    if(var10 < 25) {
                        var11 = var10 - 25;
                    } else if(var10 > 125) {
                        var11 = var10 - 125;
                    }

                    DrawingArea.setDrawingArea(this.spriteDrawY + 5, 0, 512, this.spriteDrawY - this.boldText.anInt1497 - 1);
                    this.boldText.method381(0, var17, 23693, this.spriteDrawY + 1 + var11, this.spriteDrawX);
                    this.boldText.method381(colour, var17, 23693, this.spriteDrawY + var11, this.spriteDrawX);
                    DrawingArea.method332(4);
                }
            } else {
                this.boldText.method381(0, var17, 23693, this.spriteDrawY + 1, this.spriteDrawX);
                this.boldText.method381(16776960, var17, 23693, this.spriteDrawY, this.spriteDrawX);
            }
        }

    }

    public final void method35(boolean flag, long l) {
        try {
            if(l != 0L) {
                for(int runtimeexception = 0; runtimeexception < this.friendsCount; ++runtimeexception) {
                    if(this.friendsListAsLongs[runtimeexception] == l) {
                        --this.friendsCount;
                        this.tabAreaAltered = true;

                        for(int j = runtimeexception; j < this.friendsCount; ++j) {
                            this.friendsList[j] = this.friendsList[j + 1];
                            this.friendsNodeIDs[j] = this.friendsNodeIDs[j + 1];
                            this.friendsListAsLongs[j] = this.friendsListAsLongs[j + 1];
                        }

                        this.stream.createFrame(215);
                        this.stream.method404(5, l);
                        break;
                    }
                }

                if(!flag) {
                    ;
                }
            }
        } catch (RuntimeException var6) {
            signlink.reporterror("18622, " + flag + ", " + l + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public final void drawTabArea(byte byte0) {
        int xOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 241;
        int yOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 336;
        if(currentScreenMode == client.ScreenMode.FIXED) {
            aRSImageProducer_1163.initDrawingArea();
        }

        Rasterizer.lineOffsets = anIntArray1181;
        if(byte0 == -81) {
            int x;
            int y;
            if(currentScreenMode == client.ScreenMode.FIXED) {
                this.gameframe[14].drawSprite(0, 0);
            } else if(currentScreenMode != client.ScreenMode.FIXED && !changeTabArea) {
                DrawingArea.method335(4076841, currentGameHeight - 304, 195, 270, this.transparentTabArea?80:256, 0, currentGameWidth - 217);
                this.gameframe[25].drawSprite(xOffset, yOffset);
            } else {
                int index;
                if(currentGameWidth >= 1000) {
                    if(showTabComponents) {
                        DrawingArea.method335(4076841, currentGameHeight - 304, 197, 265, this.transparentTabArea?80:256, 0, currentGameWidth - 197);
                        this.gameframe[28].drawSprite(currentGameWidth - 204, currentGameHeight - 311);
                    }

                    x = currentGameWidth - 417;
                    y = currentGameHeight - 37;

                    for(index = 0; x <= currentGameWidth - 30 && index < 13; ++index) {
                        this.gameframe[24].drawSprite(x, y);
                        x += 32;
                    }
                } else if(currentGameWidth < 1000) {
                    if(showTabComponents) {
                        DrawingArea.method335(4076841, currentGameHeight - 341, 195, 265, this.transparentTabArea?80:256, 0, currentGameWidth - 197);
                        this.gameframe[28].drawSprite(currentGameWidth - 204, currentGameHeight - 348);
                    }

                    x = currentGameWidth - 226;
                    y = currentGameHeight - 73;

                    for(index = 0; x <= currentGameWidth - 32 && index < 7; ++index) {
                        this.gameframe[24].drawSprite(x, y);
                        x += 32;
                    }

                    x = currentGameWidth - 226;
                    y = currentGameHeight - 37;

                    for(index = 0; x <= currentGameWidth - 32 && index < 7; ++index) {
                        this.gameframe[24].drawSprite(x, y);
                        x += 32;
                    }
                }
            }

            if(this.invOverlayInterfaceID == -1) {
                this.drawRedStones();
                this.drawSideIcons();
            }

            if(showTabComponents) {
                x = currentScreenMode == client.ScreenMode.FIXED?31:currentGameWidth - 215;
                y = currentScreenMode == client.ScreenMode.FIXED?37:currentGameHeight - 299;
                if(changeTabArea) {
                    x = currentGameWidth - 197;
                    y = currentGameWidth >= 1000?currentGameHeight - 303:currentGameHeight - 340;
                }

                if(this.invOverlayInterfaceID != -1) {
                    this.drawInterface(0, x, Widget.interfaceCache[this.invOverlayInterfaceID], y);
                } else if(tabInterfaceIDs[tabID] != -1) {
                    this.drawInterface(0, x, Widget.interfaceCache[tabInterfaceIDs[tabID]], y);
                }
            }

            if(this.menuOpen) {
                this.drawMenu(currentScreenMode == client.ScreenMode.FIXED?516:0, currentScreenMode == client.ScreenMode.FIXED?168:0);
            }

            if(currentScreenMode == client.ScreenMode.FIXED) {
                aRSImageProducer_1163.method238(168, 23680, super.aGraphics12, 516);
                aRSImageProducer_1165.initDrawingArea();
            }

            Rasterizer.lineOffsets = anIntArray1182;
        }
    }

    public void drawSideIcons() {
        int xOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 247;
        int yOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 336;
        int iconId;
        if(currentScreenMode == client.ScreenMode.FIXED || currentScreenMode != client.ScreenMode.FIXED && !changeTabArea) {
            for(iconId = 0; iconId < this.sideIconsTab.length; ++iconId) {
                if(tabInterfaceIDs[this.sideIconsTab[iconId]] != -1 && this.sideIconsId[iconId] != -1) {
                    this.sideIcons[this.sideIconsId[iconId]].drawSprite(this.sideIconsX[iconId] + xOffset, this.sideIconsY[iconId] + yOffset);
                }
            }
        } else {
            int[] iconId1;
            int[] iconX;
            int[] iconY;
            if(changeTabArea && currentGameWidth < 1000) {
                iconId1 = new int[]{0, 1, 2, 3, 4, 5, 6, -1, 8, 9, 7, 11, 12, 13};
                iconX = new int[]{219, 189, 156, 126, 93, 62, 30, 219, 189, 156, 124, 92, 59, 28};
                iconY = new int[]{67, 69, 67, 69, 72, 72, 69, 32, 29, 29, 32, 30, 33, 31, 32};

                for(iconId = 0; iconId < this.sideIconsTab.length; ++iconId) {
                    if(tabInterfaceIDs[this.sideIconsTab[iconId]] != -1 && iconId1[iconId] != -1) {
                        this.sideIcons[iconId1[iconId]].drawSprite(currentGameWidth - iconX[iconId], currentGameHeight - iconY[iconId]);
                    }
                }
            } else if(changeTabArea && currentGameWidth >= 1000) {
                iconId1 = new int[]{0, 1, 2, 3, 4, 5, 6, -1, 8, 9, 7, 11, 12, 13};
                iconX = new int[]{50, 80, 114, 143, 176, 208, 240, 242, 273, 306, 338, 370, 404, 433};
                iconY = new int[]{30, 32, 30, 32, 34, 34, 32, 32, 29, 29, 32, 31, 32, 32, 32};

                for(iconId = 0; iconId < this.sideIconsTab.length; ++iconId) {
                    if(tabInterfaceIDs[this.sideIconsTab[iconId]] != -1 && iconId1[iconId] != -1) {
                        this.sideIcons[iconId1[iconId]].drawSprite(currentGameWidth - 461 + iconX[iconId], currentGameHeight - iconY[iconId]);
                    }
                }
            }
        }

    }

    private void drawRedStones() {
        int xOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 247;
        int yOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 336;
        if(currentScreenMode != client.ScreenMode.FIXED && (currentScreenMode == client.ScreenMode.FIXED || changeTabArea)) {
            int[] stoneX;
            if(changeTabArea && currentGameWidth < 1000) {
                stoneX = new int[]{226, 194, 162, 130, 99, 65, 34, 219, 195, 161, 130, 98, 65, 33};
                int[] stoneY = new int[]{73, 73, 73, 73, 73, 73, 73, -1, 37, 37, 37, 37, 37, 37, 37};
                if(tabInterfaceIDs[tabID] != -1 && tabID != 10 && showTabComponents) {
                    if(tabID == 7) {
                        this.gameframe[13].drawSprite(currentGameWidth - 130, currentGameHeight - 37);
                    }

                    this.gameframe[13].drawSprite(currentGameWidth - stoneX[tabID], currentGameHeight - stoneY[tabID]);
                }
            } else if(changeTabArea && currentGameWidth >= 1000) {
                stoneX = new int[]{417, 385, 353, 321, 289, 256, 224, 129, 193, 161, 130, 98, 65, 33};
                if(tabInterfaceIDs[tabID] != -1 && tabID != 10 && showTabComponents) {
                    this.gameframe[13].drawSprite(currentGameWidth - stoneX[tabID], currentGameHeight - 37);
                }
            }
        } else if(tabInterfaceIDs[tabID] != -1 && tabID != 15) {
            this.gameframe[this.redStonesId[tabID]].drawSprite(this.redStonesX[tabID] + xOffset, this.redStonesY[tabID] + yOffset);
        }

    }

    private void buildPublicChat(int j) {
        int l = 0;

        for(int i1 = 0; i1 < 500; ++i1) {
            if(this.chatMessages[i1] != null && this.chatTypeView == 1) {
                int j1 = this.chatTypes[i1];
                String s = this.chatNames[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                if(k1 < -23) {
                    break;
                }

                if(s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr25@")) {
                    s = s.substring(6);
                }

                if((j1 == 1 || j1 == 2) && (j1 == 1 || this.publicChatMode == 0 || this.publicChatMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1 && !s.equals(localPlayer.name)) {
                        if(this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse <col=FFFFFF>" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    private void buildFriendChat(int j) {
        int l = 0;

        for(int i1 = 0; i1 < 500; ++i1) {
            if(this.chatMessages[i1] != null && this.chatTypeView == 2) {
                int j1 = this.chatTypes[i1];
                String s = this.chatNames[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                if(k1 < -23) {
                    break;
                }

                if(s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr25@")) {
                    s = s.substring(6);
                }

                if((j1 == 5 || j1 == 6) && (this.splitPrivateChat == 0 || this.chatTypeView == 2) && (j1 == 6 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s))) {
                    ++l;
                }

                if((j1 == 3 || j1 == 7) && (this.splitPrivateChat == 0 || this.chatTypeView == 2) && (j1 == 7 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1) {
                        if(this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse <col=FFFFFF>" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    private void buildDuelorTrade(int j) {
        int l = 0;

        for(int i1 = 0; i1 < 500; ++i1) {
            if(this.chatMessages[i1] != null && (this.chatTypeView == 3 || this.chatTypeView == 4)) {
                int j1 = this.chatTypes[i1];
                String s = this.chatNames[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                if(k1 < -23) {
                    break;
                }

                if(s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }

                if(this.chatTypeView == 3 && j1 == 4 && (this.tradeMode == 0 || this.tradeMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept trade <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 484;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if(this.chatTypeView == 4 && j1 == 8 && (this.tradeMode == 0 || this.tradeMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept challenge <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 6;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if(j1 == 12) {
                    if(j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Go-to <col=255>" + s;
                        this.menuActionID[this.menuActionRow] = 915;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    public final void method37(int i, int j) {
        if(i <= 0) {
            this.packet = -1;
        }

        if(!lowMemory) {
            Background class30_sub2_sub1_sub2_2;
            int i1;
            int l1;
            byte[] abyte2;
            byte[] abyte5;
            int k2;
            if(Rasterizer.anIntArray1480[24] >= j) {
                class30_sub2_sub1_sub2_2 = Rasterizer.aBackgroundArray1474s[24];
                i1 = class30_sub2_sub1_sub2_2.anInt1452 * class30_sub2_sub1_sub2_2.anInt1453 - 1;
                l1 = class30_sub2_sub1_sub2_2.anInt1452 * this.anInt945 * 2;
                abyte2 = class30_sub2_sub1_sub2_2.aByteArray1450;
                abyte5 = this.aByteArray912;

                for(k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                class30_sub2_sub1_sub2_2.aByteArray1450 = abyte5;
                this.aByteArray912 = abyte2;
                Rasterizer.method370(24);
            }

            if(Rasterizer.anIntArray1480[17] >= j) {
                class30_sub2_sub1_sub2_2 = Rasterizer.aBackgroundArray1474s[17];
                i1 = class30_sub2_sub1_sub2_2.anInt1452 * class30_sub2_sub1_sub2_2.anInt1453 - 1;
                l1 = class30_sub2_sub1_sub2_2.anInt1452 * this.anInt945 * 2;
                abyte2 = class30_sub2_sub1_sub2_2.aByteArray1450;
                abyte5 = this.aByteArray912;

                for(k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                class30_sub2_sub1_sub2_2.aByteArray1450 = abyte5;
                this.aByteArray912 = abyte2;
                Rasterizer.method370(17);
                ++anInt854;
                if(anInt854 > 1235) {
                    anInt854 = 0;
                    this.stream.createFrame(226);
                    this.stream.writeUnsignedByte(0);
                    k2 = this.stream.currentPosition;
                    this.stream.writeWord('\ue562');
                    this.stream.writeUnsignedByte(240);
                    this.stream.writeWord((int)(Math.random() * 65536.0D));
                    this.stream.writeUnsignedByte((int)(Math.random() * 256.0D));
                    if((int)(Math.random() * 2.0D) == 0) {
                        this.stream.writeWord('\uca71');
                    }

                    this.stream.writeUnsignedByte((int)(Math.random() * 256.0D));
                    this.stream.writeWord((int)(Math.random() * 65536.0D));
                    this.stream.writeWord(7130);
                    this.stream.writeWord((int)(Math.random() * 65536.0D));
                    this.stream.writeWord('\uf0d9');
                    this.stream.method407(this.stream.currentPosition - k2, (byte)0);
                }
            }

            if(Rasterizer.anIntArray1480[24] >= j) {
                class30_sub2_sub1_sub2_2 = Rasterizer.aBackgroundArray1474s[24];
                i1 = class30_sub2_sub1_sub2_2.anInt1452 * class30_sub2_sub1_sub2_2.anInt1453 - 1;
                l1 = class30_sub2_sub1_sub2_2.anInt1452 * this.anInt945 * 2;
                abyte2 = class30_sub2_sub1_sub2_2.aByteArray1450;
                abyte5 = this.aByteArray912;

                for(k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                class30_sub2_sub1_sub2_2.aByteArray1450 = abyte5;
                this.aByteArray912 = abyte2;
                Rasterizer.method370(24);
            }

            if(Rasterizer.anIntArray1480[40] >= j) {
                class30_sub2_sub1_sub2_2 = Rasterizer.aBackgroundArray1474s[40];
                i1 = class30_sub2_sub1_sub2_2.anInt1452 * class30_sub2_sub1_sub2_2.anInt1453 - 1;
                l1 = class30_sub2_sub1_sub2_2.anInt1452 * this.anInt945 * 2;
                abyte2 = class30_sub2_sub1_sub2_2.aByteArray1450;
                abyte5 = this.aByteArray912;

                for(k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                class30_sub2_sub1_sub2_2.aByteArray1450 = abyte5;
                this.aByteArray912 = abyte2;
                Rasterizer.method370(40);
            }

            if(Rasterizer.anIntArray1480[34] >= j) {
                class30_sub2_sub1_sub2_2 = Rasterizer.aBackgroundArray1474s[34];
                i1 = class30_sub2_sub1_sub2_2.anInt1452 * class30_sub2_sub1_sub2_2.anInt1453 - 1;
                l1 = class30_sub2_sub1_sub2_2.anInt1452 * this.anInt945 * 2;
                abyte2 = class30_sub2_sub1_sub2_2.aByteArray1450;
                abyte5 = this.aByteArray912;

                for(k2 = 0; k2 <= i1; ++k2) {
                    abyte5[k2] = abyte2[k2 - l1 & i1];
                }

                class30_sub2_sub1_sub2_2.aByteArray1450 = abyte5;
                this.aByteArray912 = abyte2;
                Rasterizer.method370(34);
            }
        }

    }

    public final void method38(byte byte0) {
        if(byte0 != -92) {
            this.stream.writeUnsignedByte(214);
        }

        int k;
        int l;
        for(k = -1; k < this.anInt891; ++k) {
            if(k == -1) {
                l = this.maxPlayerCount;
            } else {
                l = this.anIntArray892[k];
            }

            Player npc = this.players[l];
            if(npc != null && npc.textCycle > 0) {
                --npc.textCycle;
                if(npc.textCycle == 0) {
                    npc.aString1506 = null;
                }
            }
        }

        for(k = 0; k < this.npcCount; ++k) {
            l = this.npcIndices[k];
            Npc var5 = this.npcs[l];
            if(var5 != null && var5.textCycle > 0) {
                --var5.textCycle;
                if(var5.textCycle == 0) {
                    var5.aString1506 = null;
                }
            }
        }

    }

    public final void method39(byte byte0) {
        int i = this.anInt1098 * 128 + 64;
        int j = this.anInt1099 * 128 + 64;
        int k = this.method42(this.anInt918, j, true, i) - this.anInt1100;
        if(this.xCameraPos < i) {
            this.xCameraPos += this.anInt1101 + (i - this.xCameraPos) * this.anInt1102 / 1000;
            if(this.xCameraPos > i) {
                this.xCameraPos = i;
            }
        }

        if(this.xCameraPos > i) {
            this.xCameraPos -= this.anInt1101 + (this.xCameraPos - i) * this.anInt1102 / 1000;
            if(this.xCameraPos < i) {
                this.xCameraPos = i;
            }
        }

        if(this.zCameraPos < k) {
            this.zCameraPos += this.anInt1101 + (k - this.zCameraPos) * this.anInt1102 / 1000;
            if(this.zCameraPos > k) {
                this.zCameraPos = k;
            }
        }

        if(this.zCameraPos > k) {
            this.zCameraPos -= this.anInt1101 + (this.zCameraPos - k) * this.anInt1102 / 1000;
            if(this.zCameraPos < k) {
                this.zCameraPos = k;
            }
        }

        if(this.yCameraPos < j) {
            this.yCameraPos += this.anInt1101 + (j - this.yCameraPos) * this.anInt1102 / 1000;
            if(this.yCameraPos > j) {
                this.yCameraPos = j;
            }
        }

        if(this.yCameraPos > j) {
            this.yCameraPos -= this.anInt1101 + (this.yCameraPos - j) * this.anInt1102 / 1000;
            if(this.yCameraPos < j) {
                this.yCameraPos = j;
            }
        }

        i = this.anInt995 * 128 + 64;
        j = this.anInt996 * 128 + 64;
        k = this.method42(this.anInt918, j, true, i) - this.anInt997;
        int l = i - this.xCameraPos;
        int i1 = k - this.zCameraPos;
        int j1 = j - this.yCameraPos;
        int k1 = (int)Math.sqrt((double)(l * l + j1 * j1));
        int l1 = (int)(Math.atan2((double)i1, (double)k1) * 325.949D) & 2047;
        if(byte0 == 5) {
            boolean byte01 = false;
        } else {
            aBoolean919 = !aBoolean919;
        }

        int i2 = (int)(Math.atan2((double)l, (double)j1) * -325.949D) & 2047;
        if(l1 < 128) {
            l1 = 128;
        }

        if(l1 > 383) {
            l1 = 383;
        }

        if(this.yCameraCurve < l1) {
            this.yCameraCurve += this.anInt998 + (l1 - this.yCameraCurve) * this.anInt999 / 1000;
            if(this.yCameraCurve > l1) {
                this.yCameraCurve = l1;
            }
        }

        if(this.yCameraCurve > l1) {
            this.yCameraCurve -= this.anInt998 + (this.yCameraCurve - l1) * this.anInt999 / 1000;
            if(this.yCameraCurve < l1) {
                this.yCameraCurve = l1;
            }
        }

        int j2 = i2 - this.xCameraCurve;
        if(j2 > 1024) {
            j2 -= 2048;
        }

        if(j2 < -1024) {
            j2 += 2048;
        }

        if(j2 > 0) {
            this.xCameraCurve += this.anInt998 + j2 * this.anInt999 / 1000;
            this.xCameraCurve &= 2047;
        }

        if(j2 < 0) {
            this.xCameraCurve -= this.anInt998 + -j2 * this.anInt999 / 1000;
            this.xCameraCurve &= 2047;
        }

        int k2 = i2 - this.xCameraCurve;
        if(k2 > 1024) {
            k2 -= 2048;
        }

        if(k2 < -1024) {
            k2 += 2048;
        }

        if(k2 < 0 && j2 > 0 || k2 > 0 && j2 < 0) {
            this.xCameraCurve = i2;
        }

    }

    public final void drawMenu(int x, int y) {
        int xPos = this.anInt949 - x;
        int yPos = -y + this.anInt950;
        int k = this.anInt951;
        int l = this.anInt952 + 1;
        this.inputTaken = true;
        this.tabAreaAltered = true;
        int i1 = 6116423;
        DrawingArea.drawPixels(l, yPos, xPos, i1, k);
        DrawingArea.drawPixels(16, yPos + 1, xPos + 1, 0, k - 2);
        DrawingArea.fillPixels(xPos + 1, k - 2, l - 19, 0, yPos + 18, true);
        this.newBoldFont.drawBasicString("Choose Option", xPos + 3, yPos + 14, i1, 0);
        int j1 = super.mouseX - x;
        int k1 = -y + super.mouseY;

        for(int l1 = 0; l1 < this.menuActionRow; ++l1) {
            int i2 = yPos + 31 + (this.menuActionRow - 1 - l1) * 15;
            int j2 = 16777215;
            if(j1 > xPos && j1 < xPos + k && k1 > i2 - 13 && k1 < i2 + 3) {
                DrawingArea.drawPixels(15, i2 - 11, xPos + 3, 7301469, this.anInt951 - 6);
                j2 = 16776960;
            }

            this.newBoldFont.drawBasicString(this.menuActionName[l1], xPos + 3, i2, j2, 0);
        }

    }

    public final void method41(byte byte0, long l) {
        try {
            if(l != 0L) {
                if(this.friendsCount >= 100 && this.anInt1046 != 1) {
                    this.pushMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "");
                } else if(this.friendsCount >= 200) {
                    this.pushMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "");
                } else {
                    String runtimeexception = TextClass.fixName(TextClass.nameForLong(l));

                    int j;
                    for(j = 0; j < this.friendsCount; ++j) {
                        if(this.friendsListAsLongs[j] == l) {
                            this.pushMessage(runtimeexception + " is already on your friend list", 0, "");
                            return;
                        }
                    }

                    if(byte0 != 68) {
                        this.packet = -1;
                    }

                    for(j = 0; j < this.anInt822; ++j) {
                        if(this.aLongArray925[j] == l) {
                            this.pushMessage("Please remove " + runtimeexception + " from your ignore list first", 0, "");
                            return;
                        }
                    }

                    if(!runtimeexception.equals(localPlayer.name)) {
                        this.friendsList[this.friendsCount] = runtimeexception;
                        this.friendsListAsLongs[this.friendsCount] = l;
                        this.friendsNodeIDs[this.friendsCount] = 0;
                        ++this.friendsCount;
                        this.tabAreaAltered = true;
                        this.stream.createFrame(188);
                        this.stream.method404(5, l);
                    }
                }
            }
        } catch (RuntimeException var6) {
            signlink.reporterror("15283, " + byte0 + ", " + l + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public final int method42(int i, int j, boolean flag, int k) {
        loggedIn &= flag;
        int l = k >> 7;
        int i1 = j >> 7;
        if(l >= 0 && i1 >= 0 && l <= 103 && i1 <= 103) {
            int j1 = i;
            if(i < 3 && (this.aByteArrayArrayArray1258[1][l][i1] & 2) == 2) {
                j1 = i + 1;
            }

            int k1 = k & 127;
            int l1 = j & 127;
            int i2 = this.anIntArrayArrayArray1214[j1][l][i1] * (128 - k1) + this.anIntArrayArrayArray1214[j1][l + 1][i1] * k1 >> 7;
            int j2 = this.anIntArrayArrayArray1214[j1][l][i1 + 1] * (128 - k1) + this.anIntArrayArrayArray1214[j1][l + 1][i1 + 1] * k1 >> 7;
            return i2 * (128 - l1) + j2 * l1 >> 7;
        } else {
            return 0;
        }
    }

    private static final String intToKOrMil(int j) {

        return j < 100000?String.valueOf(j):(j < 10000000?j / 1000 + "K":j / 1000000 + "M");
    }

    public final void method44(boolean flag) {
        try {
            if(this.socketStream != null) {
                this.socketStream.method267();
            }
        } catch (Exception var3) {
            ;
        }

        this.socketStream = null;
        if(flag) {
            loggedIn = false;
            this.anInt833 = 0;
            this.method23(false);
            this.aClass25_946.method274(619);

            for(int i = 0; i < 4; ++i) {
                this.collisionMaps[i].method210();
            }

            System.gc();
            this.method15(860);
            this.currentSong = -1;
            BroadcastManager.broadcasts = new Broadcast[1000];
            this.nextSong = -1;
            this.previousSong = 0;
            currentScreenMode(client.ScreenMode.FIXED);
        }
    }

    public final void method45(int i) {
        if(i != 0) {
            this.packet = -1;
        }

        this.aBoolean1031 = true;

        for(int j = 0; j < 7; ++j) {
            this.anIntArray1065[j] = -1;

            for(int k = 0; k < Class38.anInt655; ++k) {
                if(!Class38.aClass38Array656[k].notSelectable && Class38.aClass38Array656[k].bodyPartId == j + (this.aBoolean1047?0:7)) {
                    this.anIntArray1065[j] = k;
                    break;
                }
            }
        }

    }

    private final void method46(int i, Stream stream, byte byte0) {
        int k;
        if(byte0 != 2) {
            for(k = 1; k > 0; ++k) {
                ;
            }
        }

        while(stream.anInt1407 + 21 < i * 8) {
            k = stream.readBits(14);
            if(k == 16383) {
                break;
            }

            if(this.npcs[k] == null) {
                this.npcs[k] = new Npc();
            }

            Npc npc = this.npcs[k];
            this.npcIndices[this.npcCount++] = k;
            npc.anInt1537 = loopCycle;
            int l = stream.readBits(5);
            if(l > 15) {
                l -= 32;
            }

            int i1 = stream.readBits(5);
            if(i1 > 15) {
                i1 -= 32;
            }

            int j1 = stream.readBits(1);
            int npcId = stream.readBits(14);
            npc.desc = Class5.method159(npcId);
            int k1 = stream.readBits(1);
            if(k1 == 1) {
                this.anIntArray894[this.anInt893++] = k;
            }

            npc.anInt1540 = npc.desc.aByte68;
            npc.anInt1504 = npc.desc.anInt79;
            npc.anInt1554 = npc.desc.anInt67;
            npc.anInt1555 = npc.desc.anInt58;
            npc.anInt1556 = npc.desc.anInt83;
            npc.anInt1557 = npc.desc.anInt55;
            npc.anInt1511 = npc.desc.anInt77;
            npc.setPos(localPlayer.anIntArray1500[0] + i1, localPlayer.anIntArray1501[0] + l, j1 == 1, false);
        }

        stream.method420(true);
    }

    public final void method7(int i) {
        if(!this.aBoolean1252 && !this.aBoolean926 && !this.aBoolean1176) {
            ++loopCycle;
            if(!loggedIn) {
                this.method140(true);
            } else {
                this.method62(this.anInt1218);
            }

            this.method57(false);
            if(i != this.anInt1058) {
                aBoolean919 = !aBoolean919;
            }

        }
    }

    public final void method47(int i, boolean flag) {
        if(localPlayer.anInt1550 >> 7 == this.anInt1261 && localPlayer.anInt1551 >> 7 == this.anInt1262) {
            this.anInt1261 = 0;
        }

        int j = this.anInt891;
        int l;
        if(i != 0) {
            for(l = 1; l > 0; ++l) {
                ;
            }
        }

        if(flag) {
            j = 1;
        }

        for(l = 0; l < j; ++l) {
            Player player;
            long i1;
            if(flag) {
                player = localPlayer;
                i1 = (long)this.maxPlayerCount << 32;
            } else {
                player = this.players[this.anIntArray892[l]];
                i1 = (long)this.anIntArray892[l] << 32;
            }

            if(player != null && player.method449(aBoolean1224)) {
                player.aBoolean1699 = false;
                if((lowMemory && this.anInt891 > 50 || this.anInt891 > 200) && !flag && player.anInt1517 == player.anInt1511) {
                    player.aBoolean1699 = true;
                }

                int j1 = player.anInt1550 >> 7;
                int k1 = player.anInt1551 >> 7;
                if(j1 >= 0 && j1 < 104 && k1 >= 0 && k1 < 104) {
                    if(player.aModel_1714 != null && loopCycle >= player.anInt1707 && loopCycle < player.anInt1708) {
                        player.aBoolean1699 = false;
                        player.anInt1709 = this.method42(this.anInt918, player.anInt1551, true, player.anInt1550);
                        this.aClass25_946.method286(60, this.anInt918, player.anInt1551, player, player.anInt1552, player.anInt1722, player.anInt1550, player.anInt1709, player.anInt1719, player.anInt1721, i1, player.anInt1720, (byte)35);
                    } else {
                        if((player.anInt1550 & 127) == 64 && (player.anInt1551 & 127) == 64) {
                            if(this.anIntArrayArray929[j1][k1] == this.renderCount) {
                                continue;
                            }

                            this.anIntArrayArray929[j1][k1] = this.renderCount;
                        }

                        player.anInt1709 = this.method42(this.anInt918, player.anInt1551, true, player.anInt1550);
                        this.aClass25_946.method285(this.anInt918, player.anInt1552, (byte)6, player.anInt1709, i1, player.anInt1551, 60, player.anInt1550, player, player.aBoolean1541);
                    }
                }
            }
        }

    }

    public final boolean method48(int i, Widget class9) {
        if(i <= 0) {
            this.packet = -1;
        }

        int j = class9.contentType;
        if(this.anInt900 == 2) {
            if(j == 201) {
                this.inputTaken = true;
                this.inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 1;
                this.aString1121 = "Enter name of friend to add to list";
            }

            if(j == 202) {
                this.inputTaken = true;
                this.inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 2;
                this.aString1121 = "Enter name of friend to delete from list";
            }
        }

        if(j == 205) {
            this.anInt1011 = 250;
            return true;
        } else {
            if(j == 501) {
                this.inputTaken = true;
                this.inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 4;
                this.aString1121 = "Enter name of player to add to list";
            }

            if(j == 502) {
                this.inputTaken = true;
                this.inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 5;
                this.aString1121 = "Enter name of player to delete from list";
            }

            if(j == 550) {
                this.inputTaken = true;
                this.inputDialogState = 0;
                this.messagePromptRaised = true;
                this.promptInput = "";
                this.friendsListAction = 6;
                this.aString1121 = "Enter the name of the chat you wish to join";
            }

            int l1;
            int k1;
            int j2;
            if(j >= 300 && j <= 313) {
                l1 = (j - 300) / 2;
                k1 = j & 1;
                j2 = this.anIntArray1065[l1];
                if(j2 != -1) {
                    while(true) {
                        if(k1 == 0) {
                            --j2;
                            if(j2 < 0) {
                                j2 = Class38.anInt655 - 1;
                            }
                        }

                        if(k1 == 1) {
                            ++j2;
                            if(j2 >= Class38.anInt655) {
                                j2 = 0;
                            }
                        }

                        if(!Class38.aClass38Array656[j2].notSelectable && Class38.aClass38Array656[j2].bodyPartId == l1 + (this.aBoolean1047?0:7)) {
                            this.anIntArray1065[l1] = j2;
                            this.aBoolean1031 = true;
                            break;
                        }
                    }
                }
            }

            if(j >= 314 && j <= 323) {
                l1 = (j - 314) / 2;
                k1 = j & 1;
                j2 = this.anIntArray990[l1];
                if(k1 == 0) {
                    --j2;
                    if(j2 < 0) {
                        j2 = anIntArrayArray1003[l1].length - 1;
                    }
                }

                if(k1 == 1) {
                    ++j2;
                    if(j2 >= anIntArrayArray1003[l1].length) {
                        j2 = 0;
                    }
                }

                this.anIntArray990[l1] = j2;
                this.aBoolean1031 = true;
            }

            if(j == 324 && !this.aBoolean1047) {
                this.aBoolean1047 = true;
                this.method45(0);
            }

            if(j == 325 && this.aBoolean1047) {
                this.aBoolean1047 = false;
                this.method45(0);
            }

            if(j == 326) {
                this.stream.createFrame(101);
                this.stream.writeWord(this.aBoolean1047?0:1);

                for(l1 = 0; l1 < 7; ++l1) {
                    this.stream.writeWord(this.anIntArray1065[l1]);
                }

                for(l1 = 0; l1 < 5; ++l1) {
                    this.stream.writeWord(this.anIntArray990[l1]);
                }

                return true;
            } else {
                if(j == 620) {
                    this.canMute = !this.canMute;
                    if(this.myPrivilege >= 1) {
                        if(this.canMute) {
                            class9.message = "Moderator option: Mute player for 48 hours: <ON>";
                        } else {
                            class9.message = "Moderator option: Mute player for 48 hours: <OFF>";
                        }
                    }
                }

                if(j >= 601 && j <= 613) {
                    this.clearTopInterfaces(537);
                    if(this.reportAbuseInput.length() > 0) {
                        this.stream.createFrame(218);
                        this.stream.method404(5, TextClass.longForName(this.reportAbuseInput));
                        this.stream.writeUnsignedByte(j - 601);
                        this.stream.writeUnsignedByte(this.canMute?1:0);
                    }
                }

                return false;
            }
        }
    }

    private final void method49(int i, byte byte0, Stream stream) {
        if(byte0 == 2) {
            boolean var8 = false;

            for(int j = 0; j < this.anInt893; ++j) {
                int k = this.anIntArray894[j];
                Player player = this.players[k];
                int l = stream.readUnsignedByte();
                if((l & 64) != 0) {
                    l += stream.readUnsignedByte() << 8;
                }

                this.method107(l, k, stream, this.aByte923, player);
            }

        }
    }

    public final void method50(int i, int j, int k, int l, int i1, int j1) {
        long k1 = this.aClass25_946.method300(j1, l, i);
        if(j < 0) {
            int j2;
            int class46;
            int e;
            int i4;
            int l4;
            int ai1;
            if(k1 != 0L) {
                j2 = this.aClass25_946.method304(j1, l, i, k1);
                class46 = j2 >> 6 & 3;
                e = j2 & 31;
                i4 = k;
                if(k1 > 0L) {
                    i4 = i1;
                }

                int[] j4 = this.minimapImage.myPixels;
                l4 = 24624 + l * 4 + (103 - i) * 512 * 4;
                ai1 = ObjectKey.getObjectId(k1);
                ObjectDefinition l5 = ObjectDefinition.forID(ai1);
                if(l5.anInt758 != -1) {
                    try {
                        Background e1 = this.aBackgroundArray1060[l5.anInt758];
                        if(e1 != null) {
                            int i6 = (l5.anInt744 * 4 - e1.anInt1452) / 2;
                            int j6 = (l5.anInt761 * 4 - e1.anInt1453) / 2;
                            e1.method361(48 + l * 4 + i6, 48 + (104 - i - l5.anInt761) * 4 + j6);
                        }
                    } catch (Exception var22) {
                        var22.printStackTrace();
                    }
                } else {
                    if(e == 0 || e == 2) {
                        if(class46 == 0) {
                            j4[l4] = i4;
                            j4[l4 + 512] = i4;
                            j4[l4 + 1024] = i4;
                            j4[l4 + 1536] = i4;
                        } else if(class46 == 1) {
                            j4[l4] = i4;
                            j4[l4 + 1] = i4;
                            j4[l4 + 2] = i4;
                            j4[l4 + 3] = i4;
                        } else if(class46 == 2) {
                            j4[l4 + 3] = i4;
                            j4[l4 + 3 + 512] = i4;
                            j4[l4 + 3 + 1024] = i4;
                            j4[l4 + 3 + 1536] = i4;
                        } else if(class46 == 3) {
                            j4[l4 + 1536] = i4;
                            j4[l4 + 1536 + 1] = i4;
                            j4[l4 + 1536 + 2] = i4;
                            j4[l4 + 1536 + 3] = i4;
                        }
                    }

                    if(e == 3) {
                        if(class46 == 0) {
                            j4[l4] = i4;
                        } else if(class46 == 1) {
                            j4[l4 + 3] = i4;
                        } else if(class46 == 2) {
                            j4[l4 + 3 + 1536] = i4;
                        } else if(class46 == 3) {
                            j4[l4 + 1536] = i4;
                        }
                    }

                    if(e == 2) {
                        if(class46 == 3) {
                            j4[l4] = i4;
                            j4[l4 + 512] = i4;
                            j4[l4 + 1024] = i4;
                            j4[l4 + 1536] = i4;
                        } else if(class46 == 0) {
                            j4[l4] = i4;
                            j4[l4 + 1] = i4;
                            j4[l4 + 2] = i4;
                            j4[l4 + 3] = i4;
                        } else if(class46 == 1) {
                            j4[l4 + 3] = i4;
                            j4[l4 + 3 + 512] = i4;
                            j4[l4 + 3 + 1024] = i4;
                            j4[l4 + 3 + 1536] = i4;
                        } else if(class46 == 2) {
                            j4[l4 + 1536] = i4;
                            j4[l4 + 1536 + 1] = i4;
                            j4[l4 + 1536 + 2] = i4;
                            j4[l4 + 1536 + 3] = i4;
                        }
                    }
                }
            }

            k1 = this.aClass25_946.method302(j1, l, i);
            if(k1 != 0L) {
                j2 = this.aClass25_946.method304(j1, l, i, k1);
                class46 = j2 >> 6 & 3;
                e = j2 & 31;
                i4 = ObjectKey.getObjectId(k1);
                ObjectDefinition j41 = ObjectDefinition.forID(i4);
                int l51;
                if(j41.anInt758 != -1) {
                    try {
                        Background l41 = this.aBackgroundArray1060[j41.anInt758];
                        if(l41 != null) {
                            ai1 = (j41.anInt744 * 4 - l41.anInt1452) / 2;
                            l51 = (j41.anInt761 * 4 - l41.anInt1453) / 2;
                            l41.method361(48 + l * 4 + ai1, 48 + (104 - i - j41.anInt761) * 4 + l51);
                        }
                    } catch (Exception var21) {
                        var21.printStackTrace();
                    }
                } else if(e == 9) {
                    l4 = 15658734;
                    if(k1 > 0L) {
                        l4 = 15597568;
                    }

                    int[] ai11 = this.minimapImage.myPixels;
                    l51 = 24624 + l * 4 + (103 - i) * 512 * 4;
                    if(class46 != 0 && class46 != 2) {
                        ai11[l51] = l4;
                        ai11[l51 + 512 + 1] = l4;
                        ai11[l51 + 1024 + 2] = l4;
                        ai11[l51 + 1536 + 3] = l4;
                    } else {
                        ai11[l51 + 1536] = l4;
                        ai11[l51 + 1024 + 1] = l4;
                        ai11[l51 + 512 + 2] = l4;
                        ai11[l51 + 3] = l4;
                    }
                }
            }

            k1 = this.aClass25_946.method303(j1, l, i);
            if(k1 != 0L) {
                j2 = ObjectKey.getObjectId(k1);
                ObjectDefinition class461 = ObjectDefinition.forID(j2);
                if(class461.anInt758 != -1) {
                    try {
                        Background e2 = this.aBackgroundArray1060[class461.anInt758];
                        if(e2 != null) {
                            i4 = (class461.anInt744 * 4 - e2.anInt1452) / 2;
                            int j42 = (class461.anInt761 * 4 - e2.anInt1453) / 2;
                            e2.method361(48 + l * 4 + i4, 48 + (104 - i - class461.anInt761) * 4 + j42);
                        }
                    } catch (Exception var20) {
                        var20.printStackTrace();
                    }
                }
            }

        }
    }

    public final void loadTitleScreen(int i) {
        this.aBackground_966 = new Background(this.titleStreamLoader, "titlebox", 0);
        if(i <= 0) {
            aBoolean1231 = !aBoolean1231;
        }

        this.aBackground_967 = new Background(this.titleStreamLoader, "titlebutton", 0);
        this.aBackgroundArray1152 = new Background[12];
        int j = 0;

        try {
            j = Integer.parseInt(this.getParameter("fl_icon"));
        } catch (Exception var4) {
            ;
        }

        int j4;
        if(j == 0) {
            for(j4 = 0; j4 < 12; ++j4) {
                ;
            }
        } else {
            for(j4 = 0; j4 < 12; ++j4) {
                ;
            }
        }

        this.aSprite_1201 = new Sprite(128, 265);
        this.aSprite_1202 = new Sprite(128, 265);

        for(j4 = 0; j4 < '\u8480'; ++j4) {
            this.aSprite_1201.myPixels[j4] = this.aRSImageProducer_1110.anIntArray315[j4];
        }

        for(j4 = 0; j4 < '\u8480'; ++j4) {
            this.aSprite_1202.myPixels[j4] = this.aRSImageProducer_1111.anIntArray315[j4];
        }

        this.anIntArray851 = new int[256];

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4] = j4 * 262144;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4 + 64] = 6684672 + 1024 * j4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4 + 128] = 419328 + 4 * j4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray851[j4 + 192] = 6710886;
        }

        this.anIntArray852 = new int[256];

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4] = j4 * 1024;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4 + 64] = '\uff00' + 4 * j4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4 + 128] = '\uffff' + 262144 * j4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray852[j4 + 192] = 6710886;
        }

        this.anIntArray853 = new int[256];

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4] = j4 * 4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4 + 64] = 255 + 393216 * j4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4 + 128] = 6684774 + 1024 * j4;
        }

        for(j4 = 0; j4 < 64; ++j4) {
            this.anIntArray853[j4 + 192] = 6710886;
        }

        this.anIntArray850 = new int[256];
        this.anIntArray1190 = new int['\u8000'];
        this.anIntArray1191 = new int['\u8000'];
        this.method106((Background)null, -135);
        this.anIntArray828 = new int['\u8000'];
        this.anIntArray829 = new int['\u8000'];
        this.method13(10, (byte)4, "Connecting To Fileserver");
        if(!this.aBoolean831) {
            this.aBoolean880 = true;
            this.aBoolean831 = true;
            this.method12(this, 2);
        }

    }

    public static final void method52(boolean flag) {
        Class25.lowMem = false;
        Rasterizer.lowMem = false;
        lowMemory = false;
        ObjectManager.aBoolean151 = false;
        if(flag) {
            aBoolean919 = !aBoolean919;
        }

        ObjectDefinition.aBoolean752 = false;
    }

    public static final void main(String[] args) {
        try {
            anInt957 = 0;
            ondemand_offset = 0;
            try {
                enableExceptionLogging(); // Don't remove this!
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            method52(false);
            aBoolean959 = true;
            signlink.storeid = 32;
            signlink.startpriv(InetAddress.getLocalHost());
            instance = new client();
            currentScreenMode(client.ScreenMode.FIXED);
            server = Configuration.SERVER_ADDRESS;
            System.out.println("Connecting to " + Configuration.SERVER_ADDRESS);
            instance.method1(currentGameHeight, currentGameWidth);
           // ClientDiscordRPC var10000 = RICH_PRESENCE;
          //  ClientDiscordRPC.initialize();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void setserver(String s) {
        server = s;
    }

    public final void method53(int i) {
        if(i == -48877) {
            if(lowMemory && this.anInt1023 == 2 && ObjectManager.anInt131 != this.anInt918) {
                aRSImageProducer_1165.initDrawingArea();
                this.regularText.method381(0, "Loading - please wait.", 23693, 151, 257);
                this.regularText.method381(16777215, "Loading - please wait.", 23693, 150, 256);
                aRSImageProducer_1165.method238(currentScreenMode == client.ScreenMode.FIXED?0:0, 23680, super.aGraphics12, currentScreenMode == client.ScreenMode.FIXED?0:0);
                this.anInt1023 = 1;
                this.aLong824 = System.currentTimeMillis();
            }

            if(this.anInt1023 == 1) {
                int j = this.method54((byte)-95);
                if(j != 0 && System.currentTimeMillis() - this.aLong824 > 360000L) {
                    signlink.reporterror(this.myUsername + " glcfb " + this.aLong1215 + "," + j + "," + lowMemory + "," + this.aClass14Array970[0] + "," + onDemandFetcher.method552() + "," + this.anInt918 + "," + this.currentRegionX + "," + this.currentRegionY);
                    this.aLong824 = System.currentTimeMillis();
                }
            }

            if(this.anInt1023 == 2 && this.anInt918 != this.anInt985) {
                this.anInt985 = this.anInt918;
                this.method24(true, this.anInt918);
            }

        }
    }

    public final int method54(byte byte0) {
        try {
            for(int e = 0; e < this.terrainData.length; ++e) {
                if(this.terrainData[e] == null && this.terrainIndices[e] != -1) {
                    return -1;
                }

                if(this.mapData[e] == null && this.objectIndices[e] != -1) {
                    return -2;
                }
            }

            boolean var8 = true;
            if(byte0 != -95) {
                return 0;
            } else {
                for(int j = 0; j < this.terrainData.length; ++j) {
                    byte[] abyte0 = this.mapData[j];
                    if(abyte0 != null) {
                        int k = (this.mapCoordinates[j] >> 8) * 64 - this.baseX;
                        int l = (this.mapCoordinates[j] & 255) * 64 - this.baseY;
                        if(this.aBoolean1159) {
                            k = 10;
                            l = 10;
                        }

                        var8 &= ObjectManager.method189(k, abyte0, l, 6);
                    }
                }

                if(!var8) {
                    return -3;
                } else if(this.loadingMap) {
                    return -4;
                } else {
                    this.anInt1023 = 2;
                    ObjectManager.anInt131 = this.anInt918;
                    this.method22(true);
                    this.stream.createFrame(121);
                    return 0;
                }
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return 0;
        }
    }

    public final void method55(int i) {
        while(i >= 0) {
            this.method6();
        }

        for(Class30_Sub2_Sub4_Sub4 class30_sub2_sub4_sub4 = (Class30_Sub2_Sub4_Sub4)this.aDoubleEndedQueue_1013.reverseGetFirst(); class30_sub2_sub4_sub4 != null; class30_sub2_sub4_sub4 = (Class30_Sub2_Sub4_Sub4)this.aDoubleEndedQueue_1013.reverseGetNext(false)) {
            if(class30_sub2_sub4_sub4.anInt1597 == this.anInt918 && loopCycle <= class30_sub2_sub4_sub4.anInt1572) {
                if(loopCycle >= class30_sub2_sub4_sub4.anInt1571) {
                    if(class30_sub2_sub4_sub4.anInt1590 > 0) {
                        Npc j = this.npcs[class30_sub2_sub4_sub4.anInt1590 - 1];
                        if(j != null && j.anInt1550 >= 0 && j.anInt1550 < 13312 && j.anInt1551 >= 0 && j.anInt1551 < 13312) {
                            class30_sub2_sub4_sub4.method455(loopCycle, j.anInt1551, this.method42(class30_sub2_sub4_sub4.anInt1597, j.anInt1551, true, j.anInt1550) - class30_sub2_sub4_sub4.anInt1583, j.anInt1550, (byte)-83);
                        }
                    }

                    if(class30_sub2_sub4_sub4.anInt1590 < 0) {
                        int j1 = -class30_sub2_sub4_sub4.anInt1590 - 1;
                        Player player;
                        if(j1 == this.anInt884) {
                            player = localPlayer;
                        } else {
                            player = this.players[j1];
                        }

                        if(player != null && player.anInt1550 >= 0 && player.anInt1550 < 13312 && player.anInt1551 >= 0 && player.anInt1551 < 13312) {
                            class30_sub2_sub4_sub4.method455(loopCycle, player.anInt1551, this.method42(class30_sub2_sub4_sub4.anInt1597, player.anInt1551, true, player.anInt1550) - class30_sub2_sub4_sub4.anInt1583, player.anInt1550, (byte)-83);
                        }
                    }

                    class30_sub2_sub4_sub4.method456(this.anInt945, this.anInt1020);
                    this.aClass25_946.method285(this.anInt918, class30_sub2_sub4_sub4.anInt1595, (byte)6, (int)class30_sub2_sub4_sub4.aDouble1587, -1L, (int)class30_sub2_sub4_sub4.aDouble1586, 60, (int)class30_sub2_sub4_sub4.aDouble1585, class30_sub2_sub4_sub4, false);
                }
            } else {
                class30_sub2_sub4_sub4.unlink();
            }
        }

    }

    public final AppletContext getAppletContext() {
        return signlink.mainapp != null?signlink.mainapp.getAppletContext():super.getAppletContext();
    }

    public final void method56(int i) {
        byte[] abyte0 = this.titleStreamLoader.method571("title.dat");
        Sprite sprite = new Sprite(abyte0, this);
        this.aRSImageProducer_1110.initDrawingArea();
        sprite.method346(0, 0, -32357);
        this.aRSImageProducer_1111.initDrawingArea();
        sprite.method346(-637, 0, -32357);
        this.aRSImageProducer_1107.initDrawingArea();
        sprite.method346(-128, 0, -32357);
        this.aRSImageProducer_1108.initDrawingArea();
        sprite.method346(-202, -371, -32357);
        this.aRSImageProducer_1109.initDrawingArea();
        sprite.method346(-202, -171, -32357);
        this.aRSImageProducer_1112.initDrawingArea();
        sprite.method346(0, -265, -32357);
        this.aRSImageProducer_1113.initDrawingArea();
        sprite.method346(-562, -265, -32357);
        this.aRSImageProducer_1114.initDrawingArea();
        sprite.method346(-128, -171, -32357);
        this.aRSImageProducer_1115.initDrawingArea();
        sprite.method346(-562, -171, -32357);
        int[] ai = new int[sprite.myWidth];

        for(int obj = 0; obj < sprite.myHeight; ++obj) {
            int obj1;
            for(obj1 = 0; obj1 < sprite.myWidth; ++obj1) {
                ai[obj1] = sprite.myPixels[sprite.myWidth - obj1 - 1 + sprite.myWidth * obj];
            }

            for(obj1 = 0; obj1 < sprite.myWidth; ++obj1) {
                sprite.myPixels[obj1 + sprite.myWidth * obj] = ai[obj1];
            }
        }

        if(i == 0) {
            sprite = null;
            Object var7 = null;
            Object var8 = null;
            System.gc();
        }
    }

    public final void method57(boolean flag) {
        if(flag) {
            this.anInt883 = -72;
        }

        while(true) {
            OnDemandData onDemandData = onDemandFetcher.method561();
            if(onDemandData == null) {
                return;
            }

            if(onDemandData.dataType == 0) {
                Model.method460(onDemandData.buffer, onDemandData.ID);
                if((onDemandFetcher.method559(onDemandData.ID, -203) & 98) != 0) {
                    this.tabAreaAltered = true;
                    if(this.backDialogID != -1) {
                        this.inputTaken = true;
                    }
                }
            }
            if(onDemandData.dataType == 2 && onDemandData.ID == this.nextSong && onDemandData.buffer != null) {
                this.method21(this.songChanging, 0, onDemandData.buffer);
            }

            if(onDemandData.dataType == 3 && this.anInt1023 == 1) {
                for(int i = 0; i < this.terrainData.length; ++i) {
                    if(this.terrainIndices[i] == onDemandData.ID) {
                        this.terrainData[i] = onDemandData.buffer;
                        if(onDemandData.buffer == null) {
                            this.terrainIndices[i] = -1;
                        }
                        break;
                    }

                    if(this.objectIndices[i] == onDemandData.ID) {
                        this.mapData[i] = onDemandData.buffer;
                        if(onDemandData.buffer == null) {
                            this.objectIndices[i] = -1;
                        }
                        break;
                    }
                }
            }

            if(onDemandData.dataType == 4) {
                Texture.decode(onDemandData.ID, onDemandData.buffer);
            }
            if (onDemandData.dataType == 5) {
                SoundRequestQueue.process(onDemandData);
            }
            if(onDemandData.dataType == 93 && onDemandFetcher.method564(onDemandData.ID, -520)) {
                ObjectManager.method173((byte)-107, new Stream(onDemandData.buffer, 891), onDemandFetcher);
            }
        }
    }

    public final boolean method59(byte[] abyte0, byte byte0, int i) {
        if(byte0 != 116) {
            throw new NullPointerException();
        } else {
            return abyte0 == null?true:signlink.wavesave(abyte0, i);
        }
    }

    public final void method60(int i, byte byte0) {
        Widget class9 = Widget.interfaceCache[i];

        for(int j = 0; j < class9.children.length && class9.children[j] != -1; ++j) {
            Widget class9_1 = Widget.interfaceCache[class9.children[j]];
            if(class9_1.type == 1) {
                this.method60(class9_1.id, (byte)6);
            }

            class9_1.anInt246 = 0;
            class9_1.anInt208 = 0;
        }

        if(byte0 == 6) {
            boolean var6 = false;
        }

    }

    public final void method61(int i) {
        if(this.hintType == 2) {
            this.method128((this.anInt934 - this.baseX << 7) + this.anInt937, this.anInt936 * 2, this.anInt875, (this.anInt935 - this.baseY << 7) + this.anInt938);
            if(i >= 0) {
                aBoolean1224 = !aBoolean1224;
            }

            if(this.spriteDrawX > -1 && loopCycle % 20 < 10) {
                this.headIcons[0].drawSprite(this.spriteDrawX - 12, this.spriteDrawY - 28);
            }

        }
    }

    public final void method62(int i) {
        this.refreshFrameSize();
        if(this.anInt1104 > 1) {
            --this.anInt1104;
        }

        if(this.anInt1011 > 0) {
            --this.anInt1011;
        }

        int packetsHandled = 0;

        while(this.parsePacket() && packetsHandled++ < 100) {
            ;
        }

        if(loggedIn) {
            if(this.anInt1016 > 0) {
                --this.anInt1016;
            }

            if(super.anIntArray30[1] == 1 || super.anIntArray30[2] == 1 || super.anIntArray30[3] == 1 || super.anIntArray30[4] == 1) {
                this.aBoolean1017 = true;
            }

            if(this.aBoolean1017 && this.anInt1016 <= 0) {
                this.anInt1016 = 20;
                this.aBoolean1017 = false;
                this.stream.createFrame(86);
                this.stream.writeWord(this.anInt1184);
                this.stream.method432(-431, this.anInt1185);
            }

            if(super.aBoolean17 && !this.aBoolean954) {
                this.aBoolean954 = true;
                this.stream.createFrame(3);
                this.stream.writeUnsignedByte(1);
            }

            if(!super.aBoolean17 && this.aBoolean954) {
                this.aBoolean954 = false;
                this.stream.createFrame(3);
                this.stream.writeUnsignedByte(0);
            }

            this.method53(-48877);
            this.method115((byte)8);
            this.method90(false);
            ++this.anInt1009;
            if(this.anInt1009 > 750) {
                this.method68(-670);
            }

            this.method114((byte)-74);
            this.method95(-8066);
            this.method38((byte)-92);
            ++this.anInt945;
            if(this.crossType != 0) {
                this.anInt916 += 20;
                if(this.anInt916 >= 400) {
                    this.crossType = 0;
                }
            }

            if(this.atInventoryInterfaceType != 0) {
                ++this.atInventoryLoopCycle;
                if(this.atInventoryLoopCycle >= 15) {
                    if(this.atInventoryInterfaceType == 2) {
                        this.tabAreaAltered = true;
                    }

                    if(this.atInventoryInterfaceType == 3) {
                        this.inputTaken = true;
                    }

                    this.atInventoryInterfaceType = 0;
                }
            }

            if(this.anInt1086 != 0) {
                ++this.anInt989;
                if(super.mouseX > this.anInt1087 + 5 || super.mouseX < this.anInt1087 - 5 || super.mouseY > this.anInt1088 + 5 || super.mouseY < this.anInt1088 - 5) {
                    this.aBoolean1242 = true;
                }

                if(super.clickMode2 == 0) {
                    if(this.anInt1086 == 2) {
                        this.tabAreaAltered = true;
                    }

                    if(this.anInt1086 == 3) {
                        this.inputTaken = true;
                    }

                    this.anInt1086 = 0;
                    if(this.aBoolean1242 && this.anInt989 >= 10) {
                        this.anInt1067 = -1;
                        this.processRightClick(0);
                        if(this.anInt1067 == this.anInt1084 && this.anInt1066 != this.anInt1085) {
                            Widget exception = Widget.interfaceCache[this.anInt1084];
                            byte k1 = 0;
                            if(this.anInt913 == 1 && exception.contentType == 206) {
                                k1 = 1;
                            }

                            if(exception.inventoryItemId[this.anInt1066] <= 0) {
                                k1 = 0;
                            }

                            int flag;
                            int i4;
                            if(exception.dragDeletes) {
                                flag = this.anInt1085;
                                i4 = this.anInt1066;
                                exception.inventoryItemId[i4] = exception.inventoryItemId[flag];
                                exception.inventoryAmounts[i4] = exception.inventoryAmounts[flag];
                                exception.inventoryItemId[flag] = -1;
                                exception.inventoryAmounts[flag] = 0;
                            } else if(k1 == 1) {
                                flag = this.anInt1085;
                                i4 = this.anInt1066;

                                while(flag != i4) {
                                    if(flag > i4) {
                                        exception.method204(flag, (byte)9, flag - 1);
                                        --flag;
                                    } else if(flag < i4) {
                                        exception.method204(flag, (byte)9, flag + 1);
                                        ++flag;
                                    }
                                }
                            } else {
                                exception.method204(this.anInt1085, (byte)9, this.anInt1066);
                            }

                            this.stream.createFrame(214);
                            this.stream.method433(0, this.anInt1084);
                            this.stream.method424(k1, 0);
                            this.stream.method433(0, this.anInt1085);
                            this.stream.method431(true, this.anInt1066);
                        }
                    } else if((this.anInt1253 == 1 || this.method17(9, this.menuActionRow - 1)) && this.menuActionRow > 2) {
                        this.method116(true);
                    } else if(this.menuActionRow > 0) {
                        this.doAction(this.menuActionRow - 1, false);
                    }

                    this.atInventoryLoopCycle = 10;
                    super.clickMode3 = 0;
                }
            }

            int var9;
            if(Class25.clickedTileX != -1) {
                var9 = Class25.clickedTileX;
                int var10 = Class25.clickedTileY;
                boolean var11 = false;
                if(this.myPrivilege >= 2 && controlIsDown) {
                    this.teleport(this.baseX + var9, this.baseY + var10);
                } else {
                    var11 = this.doWalkTo(0, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, var10, localPlayer.anIntArray1500[0], true, var9);
                }

                Class25.clickedTileX = -1;
                if(var11) {
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 1;
                    this.anInt916 = 0;
                }
            }

            if(super.clickMode3 == 1 && this.aString844 != null) {
                this.aString844 = null;
                this.inputTaken = true;
                super.clickMode3 = 0;
            }

            this.method20(4);
            this.method92(true);
            this.method78();
            this.processChatModeClick();
            if(super.clickMode2 == 1 || super.clickMode3 == 1) {
                ++this.anInt1213;
            }

            if(this.anInt1023 == 2) {
                this.method108(3);
            }

            if(this.anInt1023 == 2 && this.aBoolean1160) {
                this.method39((byte)5);
            }

            for(var9 = 0; var9 < 5; ++var9) {
                ++this.anIntArray1030[var9];
            }

            this.method73(732);
            ++super.anInt18;
            if(super.anInt18 > IDLE_TIME) {
                this.anInt1011 = 250;
                super.anInt18 -= 500;
                this.stream.createFrame(202);
            }

            ++this.anInt988;
            if(i >= 0) {
                this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
            }

            if(this.anInt988 > 500) {
                this.anInt988 = 0;
                var9 = (int)(Math.random() * 8.0D);
                if((var9 & 1) == 1) {
                    this.anInt1278 += this.anInt1279;
                }

                if((var9 & 2) == 2) {
                    this.anInt1131 += this.anInt1132;
                }

                if((var9 & 4) == 4) {
                    this.anInt896 += this.anInt897;
                }
            }

            if(this.anInt1278 < -50) {
                this.anInt1279 = 2;
            }

            if(this.anInt1278 > 50) {
                this.anInt1279 = -2;
            }

            if(this.anInt1131 < -55) {
                this.anInt1132 = 2;
            }

            if(this.anInt1131 > 55) {
                this.anInt1132 = -2;
            }

            if(this.anInt896 < -40) {
                this.anInt897 = 1;
            }

            if(this.anInt896 > 40) {
                this.anInt897 = -1;
            }

            ++this.anInt1254;
            if(this.anInt1254 > 500) {
                this.anInt1254 = 0;
                var9 = (int)(Math.random() * 8.0D);
                if((var9 & 1) == 1) {
                    this.anInt1209 += this.anInt1210;
                }

                if((var9 & 2) == 2) {
                    this.anInt1170 += this.anInt1171;
                }
            }

            if(this.anInt1209 < -60) {
                this.anInt1210 = 2;
            }

            if(this.anInt1209 > 60) {
                this.anInt1210 = -2;
            }

            if(this.anInt1170 < -20) {
                this.anInt1171 = 1;
            }

            if(this.anInt1170 > 10) {
                this.anInt1171 = -1;
            }

            ++this.anInt1010;
            if(this.anInt1010 > 50) {
                this.stream.createFrame(0);
            }

            try {
                if(this.socketStream != null && this.stream.currentPosition > 0) {
                    this.socketStream.queueBytes(this.stream.currentPosition, 0, this.stream.buffer, 0);
                    this.stream.currentPosition = 0;
                    this.anInt1010 = 0;
                    return;
                }
            } catch (IOException var7) {
                this.method68(-670);
                return;
            } catch (Exception var8) {
                this.method44(true);
            }

        }
    }

    public void processChatModeClick() {
        int yOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 503;
        if(super.mouseX >= 5 && super.mouseX <= 61 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 0;
            this.inputTaken = true;
        } else if(super.mouseX >= 71 && super.mouseX <= 127 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 1;
            this.inputTaken = true;
        } else if(super.mouseX >= 137 && super.mouseX <= 193 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 2;
            this.inputTaken = true;
        } else if(super.mouseX >= 203 && super.mouseX <= 259 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 3;
            this.inputTaken = true;
        } else if(super.mouseX >= 269 && super.mouseX <= 325 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 4;
            this.inputTaken = true;
        } else if(super.mouseX >= 335 && super.mouseX <= 391 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 5;
            this.inputTaken = true;
        } else if(super.mouseX >= 404 && super.mouseX <= 515 && super.mouseY >= yOffset + 482 && super.mouseY <= yOffset + 503) {
            this.cButtonHPos = 6;
            this.inputTaken = true;
        } else {
            this.cButtonHPos = -1;
            this.inputTaken = true;
        }

        if(super.clickMode3 == 1) {
            if(super.saveClickX >= 5 && super.saveClickX <= 61 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    if(this.setChannel != 0) {
                        this.cButtonCPos = 0;
                        this.chatTypeView = 0;
                        this.inputTaken = true;
                        this.setChannel = 0;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 0;
                    this.chatTypeView = 0;
                    this.inputTaken = true;
                    this.setChannel = 0;
                }
            } else if(super.saveClickX >= 71 && super.saveClickX <= 127 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    if(this.setChannel != 1 && currentScreenMode != client.ScreenMode.FIXED) {
                        this.cButtonCPos = 1;
                        this.chatTypeView = 5;
                        this.inputTaken = true;
                        this.setChannel = 1;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 1;
                    this.chatTypeView = 5;
                    this.inputTaken = true;
                    this.setChannel = 1;
                }
            } else if(super.saveClickX >= 137 && super.saveClickX <= 193 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    if(this.setChannel != 2 && currentScreenMode != client.ScreenMode.FIXED) {
                        this.cButtonCPos = 2;
                        this.chatTypeView = 1;
                        this.inputTaken = true;
                        this.setChannel = 2;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 2;
                    this.chatTypeView = 1;
                    this.inputTaken = true;
                    this.setChannel = 2;
                }
            } else if(super.saveClickX >= 203 && super.saveClickX <= 259 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    if(this.setChannel != 3 && currentScreenMode != client.ScreenMode.FIXED) {
                        this.cButtonCPos = 3;
                        this.chatTypeView = 2;
                        this.inputTaken = true;
                        this.setChannel = 3;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 3;
                    this.chatTypeView = 2;
                    this.inputTaken = true;
                    this.setChannel = 3;
                }
            } else if(super.saveClickX >= 269 && super.saveClickX <= 325 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    if(this.setChannel != 4 && currentScreenMode != client.ScreenMode.FIXED) {
                        this.cButtonCPos = 4;
                        this.chatTypeView = 11;
                        this.inputTaken = true;
                        this.setChannel = 4;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 4;
                    this.chatTypeView = 11;
                    this.inputTaken = true;
                    this.setChannel = 4;
                }
            } else if(super.saveClickX >= 335 && super.saveClickX <= 391 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    if(this.setChannel != 5 && currentScreenMode != client.ScreenMode.FIXED) {
                        this.cButtonCPos = 5;
                        this.chatTypeView = 3;
                        this.inputTaken = true;
                        this.setChannel = 5;
                    } else {
                        showChatComponents = !showChatComponents;
                    }
                } else {
                    this.cButtonCPos = 5;
                    this.chatTypeView = 3;
                    this.inputTaken = true;
                    this.setChannel = 5;
                }
            } else if(super.saveClickX >= 404 && super.saveClickX <= 515 && super.saveClickY >= yOffset + 482 && super.saveClickY <= yOffset + 505) {
                if(openInterfaceID == -1) {
                    this.clearTopInterfaces(537);
                    this.reportAbuseInput = "";
                    this.canMute = false;

                    for(int i = 0; i < Widget.interfaceCache.length; ++i) {
                        if(Widget.interfaceCache[i] != null && Widget.interfaceCache[i].contentType == 600) {
                            this.reportAbuseInterfaceID = openInterfaceID = Widget.interfaceCache[i].parentID;
                            break;
                        }
                    }
                } else {
                    this.pushMessage("Please close the interface you have open before using \'report abuse\'", 0, "");
                }
            }
        }

    }

    private final void method63(int i) {
        Class30_Sub1 class30_sub1 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetFirst();

        while(i >= 0) {
            for(int j = 1; j > 0; ++j) {
                ;
            }
        }

        for(; class30_sub1 != null; class30_sub1 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetNext(false)) {
            if(class30_sub1.anInt1294 == -1) {
                class30_sub1.anInt1302 = 0;
                this.method89(false, class30_sub1);
            } else {
                class30_sub1.unlink();
            }
        }

    }

    public final void resetImageProducers(int i) {
        if(this.aRSImageProducer_1107 == null) {
            super.aRSImageProducer_13 = null;
            aRSImageProducer_1166 = null;
            this.aRSImageProducer_1164 = null;
            aRSImageProducer_1163 = null;
            aRSImageProducer_1165 = null;
            this.aRSImageProducer_1125 = null;
            this.aRSImageProducer_1110 = new RSImageProducer(128, 265);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1111 = new RSImageProducer(128, 265);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1107 = new RSImageProducer(509, 171);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1108 = new RSImageProducer(360, 132);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1109 = new RSImageProducer(360, 200);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1112 = new RSImageProducer(202, 238);
            if(i < 0 || i > 0) {
                this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
            }

            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1113 = new RSImageProducer(203, 238);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1114 = new RSImageProducer(74, 94);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1115 = new RSImageProducer(75, 94);
            DrawingArea.setAllPixelsToZero();
            if(this.titleStreamLoader != null) {
                this.method56(0);
                this.loadTitleScreen(215);
            }

            this.aBoolean1255 = true;
        }
    }

    public final void method13(int i, byte byte0, String s) {
        this.anInt1079 = i;
        this.aString1049 = s;
        this.resetImageProducers(0);
        if(this.titleStreamLoader == null) {
            super.method13(i, (byte)4, s);
        } else {
            this.aRSImageProducer_1109.initDrawingArea();
            short c = 360;
            short c1 = 200;
            byte byte1 = 20;
            this.boldText.method381(16777215, "Godzhell Reborn is Loading...", 23693, c1 / 2 - 26 - byte1, c / 2);
            int j = c1 / 2 - 18 - byte1;
            DrawingArea.fillPixels(c / 2 - 152, 304, 18, 13421772, j, true);
            DrawingArea.fillPixels(c / 2 - 151, 302, 16, 10855845, j + 1, true);
            DrawingArea.drawPixels(14, j + 2, c / 2 - 150, 7368816, i * 3);
            DrawingArea.drawPixels(14, j + 2, c / 2 - 150 + i * 3, 0, 300 - i * 3);
            this.smallText.method381(16777215, s, 23693, c1 / 2 - 5 - byte1, c / 2);
            this.aRSImageProducer_1109.method238(171, 23680, super.aGraphics12, 202);
            if(byte0 != 4) {
                for(int k = 1; k > 0; ++k) {
                    ;
                }
            }

            if(this.aBoolean1255) {
                this.aBoolean1255 = false;
                if(!this.aBoolean831) {
                    this.aRSImageProducer_1110.method238(0, 23680, super.aGraphics12, 0);
                    this.aRSImageProducer_1111.method238(0, 23680, super.aGraphics12, 637);
                }

                this.aRSImageProducer_1107.method238(0, 23680, super.aGraphics12, 128);
                this.aRSImageProducer_1108.method238(371, 23680, super.aGraphics12, 202);
                this.aRSImageProducer_1112.method238(265, 23680, super.aGraphics12, 0);
                this.aRSImageProducer_1113.method238(265, 23680, super.aGraphics12, 562);
                this.aRSImageProducer_1114.method238(171, 23680, super.aGraphics12, 128);
                this.aRSImageProducer_1115.method238(171, 23680, super.aGraphics12, 562);
            }

        }
    }

    public final void method65(int i, int j, int k, int l, Widget class9, int i1, boolean flag, int j1, int k1) {
        if(this.aBoolean972) {
            this.anInt992 = 32;
        } else {
            this.anInt992 = 0;
        }

        this.aBoolean972 = false;
        this.packetSize += k1;
        if(k >= i && k < i + 16 && l >= i1 && l < i1 + 16) {
            class9.scrollPosition -= this.anInt1213 * 4;
            if(flag) {
                this.tabAreaAltered = true;
                return;
            }
        } else if(k >= i && k < i + 16 && l >= i1 + j - 16 && l < i1 + j) {
            class9.scrollPosition += this.anInt1213 * 4;
            if(flag) {
                this.tabAreaAltered = true;
                return;
            }
        } else if(k >= i - this.anInt992 && k < i + 16 + this.anInt992 && l >= i1 + 16 && l < i1 + j - 16 && this.anInt1213 > 0) {
            int l1 = (j - 32) * j / j1;
            if(l1 < 8) {
                l1 = 8;
            }

            int i2 = l - i1 - 16 - l1 / 2;
            int j2 = j - 32 - l1;
            class9.scrollPosition = (j1 - j) * i2 / j2;
            if(flag) {
                this.tabAreaAltered = true;
            }

            this.aBoolean972 = true;
        }

    }

    public final boolean method66(long i, int j, int k, int l) {
        int i1 = ObjectKey.getObjectId(i);
        int j1 = this.aClass25_946.method304(this.anInt918, k, j, i);
        if(l >= 0) {
            throw new NullPointerException();
        } else if(j1 == -1) {
            return false;
        } else {
            int k1 = j1 & 31;
            int l1 = j1 >> 6 & 3;
            if(k1 != 10 && k1 != 11 && k1 != 22) {
                this.doWalkTo(2, l1, 0, -11308, k1 + 1, localPlayer.anIntArray1501[0], 0, 0, j, localPlayer.anIntArray1500[0], false, k);
            } else {
                ObjectDefinition objectDefinition = ObjectDefinition.forID(i1);
                int i2;
                int j2;
                if(l1 != 0 && l1 != 2) {
                    i2 = objectDefinition.anInt761;
                    j2 = objectDefinition.anInt744;
                } else {
                    i2 = objectDefinition.anInt744;
                    j2 = objectDefinition.anInt761;
                }

                int k2 = objectDefinition.anInt768;
                if(l1 != 0) {
                    k2 = (k2 << l1 & 15) + (k2 >> 4 - l1);
                }

                this.doWalkTo(2, 0, j2, -11308, 0, localPlayer.anIntArray1501[0], i2, k2, j, localPlayer.anIntArray1500[0], false, k);
            }

            this.anInt914 = super.saveClickX;
            this.anInt915 = super.saveClickY;
            this.crossType = 2;
            this.anInt916 = 0;
            return true;
        }
    }

    public final FileArchive loadArchive(int index, String displayName, String urlPrefix, int expectedCrc, byte unusedByte, int statusType) {
        final int MAX_RETRIES = 3;
        final int MAX_CHUNK = 1000;
        final int INITIAL_WAIT = 5;

        byte[] data = null;
        int waitTime = INITIAL_WAIT;
        int retryCount = 0;
        String statusMessage = "Unknown error";

        // Try cache first
        try {
            if (aClass14Array970[0] != null) {
                data = aClass14Array970[0].method233(index);
            }
        } catch (Exception ignored) {}

        // CRC check if enabled
        if (Configuration.Enable_JagGrab && data != null) {
            aCRC32_930.reset();
            aCRC32_930.update(data);
            int actualCrc = (int) aCRC32_930.getValue();
            if (actualCrc != expectedCrc) {
                data = null;
            }
        }

        if (data != null) {
            return new FileArchive(data);
        }

        // Retry loop if not cached or CRC mismatch
        while (data == null) {
            method13(statusType, (byte) 4, "Requesting " + displayName);

            try (DataInputStream in = method132(urlPrefix + expectedCrc)) {
                byte[] header = new byte[6];
                in.readFully(header);
                Stream stream = new Stream(header, 891); // 891 is original seed
                stream.currentPosition = 3;
                int length = stream.read3Bytes() + 6;

                data = new byte[length];
                System.arraycopy(header, 0, data, 0, 6);

                int bytesRead = 6;
                int lastPercent = 0;

                while (bytesRead < length) {
                    int toRead = Math.min(length - bytesRead, MAX_CHUNK);
                    int read = in.read(data, bytesRead, toRead);
                    if (read < 0) throw new IOException("EOF during stream");

                    bytesRead += read;
                    int percent = bytesRead * 100 / length;
                    if (percent != lastPercent) {
                        method13(statusType, (byte) 4, "Loading " + displayName + " - " + percent + "%");
                        lastPercent = percent;
                    }
                }

                // Cache
                try {
                    if (aClass14Array970[0] != null) {
                        aClass14Array970[0].method234(data.length, data, (byte) 2, index);
                    }
                } catch (Exception ignored) {
                    aClass14Array970[0] = null;
                }

                // CRC check again
                if (Configuration.Enable_JagGrab) {
                    aCRC32_930.reset();
                    aCRC32_930.update(data);
                    int actualCrc = (int) aCRC32_930.getValue();
                    if (actualCrc != expectedCrc) {
                        data = null;
                        retryCount++;
                        statusMessage = "Checksum error: " + actualCrc;
                    }
                }

            } catch (IOException e) {
                statusMessage = "Connection error";
                data = null;
            } catch (NullPointerException e) {
                statusMessage = "Null error";
                data = null;
                if (!signlink.reporterror) return null;
            } catch (ArrayIndexOutOfBoundsException e) {
                statusMessage = "Bounds error";
                data = null;
                if (!signlink.reporterror) return null;
            } catch (Exception e) {
                statusMessage = "Unexpected error";
                data = null;
                if (!signlink.reporterror) return null;
            }

            // Retry delay
            if (data == null) {
                for (int countdown = waitTime; countdown > 0; countdown--) {
                    if (retryCount >= MAX_RETRIES) {
                        method13(statusType, (byte) 4, "Game updated - please reload page");
                        break;
                    } else {
                        method13(statusType, (byte) 4, statusMessage + " - Retrying in " + countdown);
                    }

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException ignored) {}
                }

                waitTime = Math.min(waitTime * 2, 60); // Cap at 60
                aBoolean872 = !aBoolean872;
            }
        }

        if (unusedByte != -41) throw new NullPointerException(); // preserve legacy behavior
        return new FileArchive(data);
    }


    public final void method68(int i) {
        if(this.anInt1011 > 0) {
            this.method44(true);
        } else {
            aRSImageProducer_1165.initDrawingArea();
            DrawingArea.fillPixels(2, 229, 39, 16777215, 2, true);
            DrawingArea.drawPixels(37, 3, 3, 0, 227);
            this.regularText.method381(0, "Connection lost", 23693, 19, 120);
            this.regularText.method381(16777215, "Connection lost", 23693, 18, 119);
            this.regularText.method381(0, "Ghreborn is attempting to reestablish", 23693, 34, 117);
            this.regularText.method381(16777215, "Ghreborn is attempting to reestablish", 23693, 34, 116);

            while(i >= 0) {
                this.stream.writeUnsignedByte(164);
            }

            aRSImageProducer_1165.method238(currentScreenMode == client.ScreenMode.FIXED?4:0, 23680, super.aGraphics12, currentScreenMode == client.ScreenMode.FIXED?4:0);
            this.anInt1021 = 0;
            this.anInt1261 = 0;
            Class24 class24 = this.socketStream;
            loggedIn = false;
            this.anInt1038 = 0;
            this.method84(this.myUsername, this.myPassword, true);
            if(!loggedIn) {
                this.method44(true);
            }

            try {
                class24.method267();
            } catch (Exception var4) {
                ;
            }
        }
    }

    public final void doAction(int i, boolean flag) {
        if (i < 0)
            return;
            if(this.inputDialogState != 0 && inputDialogState != 3) {
                this.inputDialogState = 0;
                this.inputTaken = true;
            }

            int j = this.menuActionCmd2[i];
            int buttonPressed = this.menuActionCmd3[i];
            int l = this.menuActionID[i];
            int i1 = (int)this.menuActionCmd1[i];
            long keyLong = this.menuActionCmd1[i];
            //System.out.println("action Button "+buttonPressed);
            switch(buttonPressed) {
                case 19153:
                    if(currentScreenMode != client.ScreenMode.FIXED) {
                        currentScreenMode(client.ScreenMode.FIXED);
                    } else {
                        this.pushMessage("You are already in that screen mode.", 0, "");
                    }
                    break;
                case 19154:
                    if(currentScreenMode != client.ScreenMode.RESIZABLE) {
                        currentScreenMode(client.ScreenMode.RESIZABLE);
                    } else {
                        this.pushMessage("You are already in that screen mode.", 0, "");
                    }
                    break;
                case 19155:
                    if(currentScreenMode != client.ScreenMode.FULLSCREEN) {
                        currentScreenMode(client.ScreenMode.FULLSCREEN);
                    } else {
                        this.pushMessage("You are already in that screen mode.", 0, "");
                    }
            }

            if(l >= 2000) {
                l -= 2000;
            }

            if(l == 1150) {
                this.anInt1184 = 140;
                this.anInt1185 = 0;
            }

            if(l == 700 && tabInterfaceIDs[10] != -1) {
                if(tabID == 10) {
                    showTabComponents = !showTabComponents;
                } else {
                    showTabComponents = true;
                }

                tabID = 10;
                this.tabAreaAltered = true;
            }

            if(l == 1003) {
                this.clanChatMode = 2;
                this.inputTaken = true;
            }

            if(l == 1002) {
                this.clanChatMode = 1;
                this.inputTaken = true;
            }

            if(l == 1001) {
                this.clanChatMode = 0;
                this.inputTaken = true;
            }

            if(l == 1000) {
                this.cButtonCPos = 4;
                this.chatTypeView = 11;
                this.inputTaken = true;
            }

            if(l == 999) {
                this.cButtonCPos = 0;
                this.chatTypeView = 0;
                this.inputTaken = true;
            }

            if(l == 998) {
                this.cButtonCPos = 1;
                this.chatTypeView = 5;
                this.inputTaken = true;
            }

            if(l == 997) {
                this.publicChatMode = 3;
                this.inputTaken = true;
            }

            if(l == 996) {
                this.publicChatMode = 2;
                this.inputTaken = true;
            }

            if(l == 995) {
                this.publicChatMode = 1;
                this.inputTaken = true;
            }

            if(l == 994) {
                this.publicChatMode = 0;
                this.inputTaken = true;
            }

            if(l == 993) {
                this.cButtonCPos = 2;
                this.chatTypeView = 1;
                this.inputTaken = true;
            }

            if(l == 992) {
                this.privateChatMode = 2;
                this.inputTaken = true;
            }

            if(l == 991) {
                this.privateChatMode = 1;
                this.inputTaken = true;
            }

            if(l == 990) {
                this.privateChatMode = 0;
                this.inputTaken = true;
            }

            if(l == 989) {
                this.cButtonCPos = 3;
                this.chatTypeView = 2;
                this.inputTaken = true;
            }

            if(l == 987) {
                this.tradeMode = 2;
                this.inputTaken = true;
            }

            if(l == 986) {
                this.tradeMode = 1;
                this.inputTaken = true;
            }

            if(l == 985) {
                this.tradeMode = 0;
                this.inputTaken = true;
            }

            if(l == 984) {
                this.cButtonCPos = 5;
                this.chatTypeView = 3;
                this.inputTaken = true;
            }

            if(l == 980) {
                this.cButtonCPos = 6;
                this.chatTypeView = 4;
                this.inputTaken = true;
            }

            if(showpackets == 1) {
                System.out.println("packet: " + l);
                System.out.println("packet1: " + j);
            }

            Npc var25;
            if (l >= 1700 && l <= 1710) {
                Widget button = Widget.get(buttonPressed);
                if (button.buttonListener != null)
                    button.buttonListener.accept(buttonPressed);
                // Button Click Packet
                if (button.newButtonClicking) {
                    stream.createFrame(184);
                    stream.writeWord(buttonPressed);
                    //onRealButtonClick(buttonPressed);
                } else {
                    stream.createFrame(185);
                    int offset = buttonPressed + (buttonPressed - 58030) * 10 + (l - 1700);
                    stream.writeWord(offset);
                }
            }
            if (l == 300) {
                stream.createFrame(141);
                stream.method432(-431,j);
                stream.writeWord(buttonPressed);
                stream.method432(-431,i1);
                stream.writeDWord(modifiableXValue);
            }
            if (l == 291) {
                stream.createFrame(140);
                stream.writeWord(buttonPressed);
                stream.method433(0,i1);
                stream.method431(true,j);
                atInventoryLoopCycle = 0;
                atInventoryInterface = buttonPressed;
                atInventoryIndex = j;
                atInventoryInterfaceType = 2;
                if (Widget.interfaceCache[buttonPressed].parentID == openInterfaceID)
                    atInventoryInterfaceType = 1;
                if (Widget.interfaceCache[buttonPressed].parentID == backDialogID)
                    atInventoryInterfaceType = 3;
            }
            if(l == 582) {
                var25 = this.npcs[i1];
                if(var25 != null) {
                    this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var25.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var25.anIntArray1500[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.anInt916 = 0;
                    this.stream.createFrame(57);
                    this.stream.method432(-431, this.anInt1285);
                    this.stream.method432(-431, i1);
                    this.stream.method431(true, this.anInt1283);
                    this.stream.method432(-431, this.anInt1284);
                }
            }

            boolean var16;
            if(l == 234) {
                var16 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                if(!var16) {
                    this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                }

                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.anInt916 = 0;
                this.stream.createFrame(236);
                this.stream.method431(true, buttonPressed + this.baseY);
                this.stream.writeWord(i1);
                this.stream.method431(true, j + this.baseX);
            }

            if(l == 62 && this.method66(keyLong, buttonPressed, j, -770)) {
                this.stream.createFrame(192);
                this.stream.writeWord(this.anInt1284);
                this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                this.stream.method433(0, buttonPressed + this.baseY);
                this.stream.method431(true, this.anInt1283);
                this.stream.method433(0, j + this.baseX);
                this.stream.writeWord(this.anInt1285);
            }

            if(l == 511) {
                var16 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                if(!var16) {
                    this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                }

                this.anInt914 = super.saveClickX;
                this.anInt915 = super.saveClickY;
                this.crossType = 2;
                this.anInt916 = 0;
                this.stream.createFrame(25);
                this.stream.method431(true, this.anInt1284);
                this.stream.method432(-431, this.anInt1285);
                this.stream.writeWord(i1);
                this.stream.method432(-431, buttonPressed + this.baseY);
                this.stream.method433(0, this.anInt1283);
                this.stream.writeWord(j + this.baseX);
            }

            if(l == 74) {
                this.stream.createFrame(122);
                this.stream.method433(0, buttonPressed);
                this.stream.method432(-431, j);
                this.stream.method431(true, i1);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = buttonPressed;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if(l == 315) {
                Widget var17 = Widget.interfaceCache[buttonPressed];
                boolean class8_1 = true;
                if(var17.contentType > 0) {
                    class8_1 = this.method48(505, var17);
                }

                if(class8_1) {
                    this.stream.createFrame(185);
                    this.stream.writeWord(buttonPressed);
                }
            }

            Player var18;
            if(l == 561) {
                var18 = this.players[i1];
                if(var18 != null) {
                    this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var18.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var18.anIntArray1500[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.anInt916 = 0;
                    anInt1188 += i1;
                    if(anInt1188 >= 90) {
                        this.stream.createFrame(136);
                        anInt1188 = 0;
                    }

                    this.stream.createFrame(128);
                    this.stream.writeWord(i1);
                }
            }

            if(l == 20) {
                var25 = this.npcs[i1];
                if(var25 != null) {
                    this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var25.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var25.anIntArray1500[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.anInt916 = 0;
                    this.stream.createFrame(155);
                    this.stream.method431(true, i1);
                }
            }

            if(l == 779) {
                var18 = this.players[i1];
                if(var18 != null) {
                    this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var18.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var18.anIntArray1500[0]);
                    this.anInt914 = super.saveClickX;
                    this.anInt915 = super.saveClickY;
                    this.crossType = 2;
                    this.anInt916 = 0;
                    this.stream.createFrame(153);
                    this.stream.method431(true, i1);
                }
            }

            if(l == 516) {
                if(!this.menuOpen) {
                    this.aClass25_946.method312(false, super.saveClickY - 0, super.saveClickX - 0);
                } else {
                    this.aClass25_946.method312(false, buttonPressed - 0, j - 0);
                }
            }

            if(l == 1062) {
                anInt924 += this.baseX;
                if(anInt924 >= 113) {
                    this.stream.createFrame(183);
                    this.stream.method401(15086193);
                    anInt924 = 0;
                }

                this.method66(keyLong, buttonPressed, j, -770);
                this.stream.createFrame(228);
                this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                this.stream.method432(-431, buttonPressed + this.baseY);
                this.stream.writeWord(j + this.baseX);
            }

            if(l == 679 && !this.aBoolean1149) {
                this.stream.createFrame(40);
                this.stream.writeWord(buttonPressed);
                this.aBoolean1149 = true;
            }

            if(l == 431) {
                this.stream.createFrame(129);
                this.stream.method432(-431, j);
                this.stream.writeWord(buttonPressed);
                this.stream.method432(-431, i1);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = buttonPressed;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            int var19;
            String var20;
            if(l == 337 || l == 42 || l == 792 || l == 322) {
                var20 = this.menuActionName[i];
                var19 = var20.indexOf("<col=ffffff>");
                if(var19 != -1) {
                    long s6 = TextClass.longForName(var20.substring(var19 + 5).trim());
                    if(l == 337) {
                        this.method41((byte)68, s6);
                    }

                    if(l == 42) {
                        this.method113(s6, 4);
                    }

                    if(l == 792) {
                        this.method35(false, s6);
                    }

                    if(l == 322) {
                        this.method122(3, s6);
                    }
                }
            }

            if(l == 53) {
                this.stream.createFrame(135);
                this.stream.method431(true, j);
                this.stream.method432(-431, buttonPressed);
                this.stream.method431(true, i1);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = buttonPressed;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if(l == 539) {
                this.stream.createFrame(16);
                this.stream.method432(-431, i1);
                this.stream.method433(0, j);
                this.stream.method433(0, buttonPressed);
                this.atInventoryLoopCycle = 0;
                this.atInventoryInterface = buttonPressed;
                this.atInventoryIndex = j;
                this.atInventoryInterfaceType = 2;
                if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                    this.atInventoryInterfaceType = 1;
                }

                if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                    this.atInventoryInterfaceType = 3;
                }
            }

            if(l != 9111 && l != 9112 && l != 9115) {
                String var21;
                if(l == 484 || l == 6) {
                    var20 = this.menuActionName[i];
                    var19 = var20.indexOf("<col=ffffff>");
                    if(var19 != -1) {
                        var20 = var20.substring(var19 + 5).trim();
                        var21 = TextClass.fixName(TextClass.nameForLong(TextClass.longForName(var20)));
                        boolean s10 = false;

                        for(int l4 = 0; l4 < this.anInt891; ++l4) {
                            Player k3 = this.players[this.anIntArray892[l4]];
                            if(k3 != null && k3.name != null && k3.name.equalsIgnoreCase(var21)) {
                                this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, k3.anIntArray1501[0], localPlayer.anIntArray1500[0], false, k3.anIntArray1500[0]);
                                if(l == 484) {
                                    this.stream.createFrame(139);
                                    this.stream.method431(true, this.anIntArray892[l4]);
                                }

                                if(l == 6) {
                                    anInt1188 += i1;
                                    if(anInt1188 >= 90) {
                                        this.stream.createFrame(136);
                                        anInt1188 = 0;
                                    }

                                    this.stream.createFrame(128);
                                    this.stream.writeWord(this.anIntArray892[l4]);
                                }

                                s10 = true;
                                break;
                            }
                        }

                        if(!s10) {
                            this.pushMessage("Unable to find " + var21, 0, "");
                        }
                    }
                }

                if(l == 870) {
                    this.stream.createFrame(53);
                    this.stream.writeWord(j);
                    this.stream.method432(-431, this.anInt1283);
                    this.stream.method433(0, i1);
                    this.stream.writeWord(this.anInt1284);
                    this.stream.method431(true, this.anInt1285);
                    this.stream.writeWord(buttonPressed);
                    this.atInventoryLoopCycle = 0;
                    this.atInventoryInterface = buttonPressed;
                    this.atInventoryIndex = j;
                    this.atInventoryInterfaceType = 2;
                    if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                        this.atInventoryInterfaceType = 1;
                    }

                    if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                        this.atInventoryInterfaceType = 3;
                    }
                }

                if(l == 847) {
                    System.out.println("Dropped Item: " + i1);
                    this.stream.createFrame(87);
                    this.stream.method432(-431, i1);
                    this.stream.writeWord(buttonPressed);
                    this.stream.method432(-431, j);
                    this.atInventoryLoopCycle = 0;
                    this.atInventoryInterface = buttonPressed;
                    this.atInventoryIndex = j;
                    this.atInventoryInterfaceType = 2;
                    if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                        this.atInventoryInterfaceType = 1;
                    }

                    if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                        this.atInventoryInterfaceType = 3;
                    }
                }

                String var24;
                if(l == 626) {
                    Widget var17 = Widget.interfaceCache[buttonPressed];
                    this.anInt1136 = 1;
                    this.anInt1137 = buttonPressed;
                    this.anInt1138 = var17.spellUsableOn;
                    this.anInt1282 = 0;
                    this.tabAreaAltered = true;
                    var24 = var17.selectedActionName;
                    if(var24.indexOf(" ") != -1) {
                        var24 = var24.substring(0, var24.indexOf(" "));
                    }

                    var21 = var17.selectedActionName;
                    if(var21.indexOf(" ") != -1) {
                        var21 = var21.substring(var21.indexOf(" ") + 1);
                    }

                    this.aString1139 = var24 + " " + var17.spellName + " " + var21;
                    if(this.anInt1138 == 16) {
                        this.tabAreaAltered = true;
                        tabID = 3;
                        this.aBoolean1103 = true;
                    }

                } else {
                    if(l == 78) {
                        this.stream.createFrame(117);
                        this.stream.writeWord(buttonPressed);
                        this.stream.writeWord(i1);
                        this.stream.method431(true, j);
                        this.atInventoryLoopCycle = 0;
                        this.atInventoryInterface = buttonPressed;
                        this.atInventoryIndex = j;
                        this.atInventoryInterfaceType = 2;
                        if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                            this.atInventoryInterfaceType = 1;
                        }

                        if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                            this.atInventoryInterfaceType = 3;
                        }
                    }

                    if(l == 27) {
                        var18 = this.players[i1];
                        if(var18 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var18.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var18.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            anInt986 += i1;
                            if(anInt986 >= 54) {
                                this.stream.createFrame(189);
                                this.stream.writeUnsignedByte(234);
                                anInt986 = 0;
                            }

                            this.stream.createFrame(73);
                            this.stream.method431(true, i1);
                        }
                    }

                    if(l == 213) {
                        var16 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        if(!var16) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        }

                        this.anInt914 = super.saveClickX;
                        this.anInt915 = super.saveClickY;
                        this.crossType = 2;
                        this.anInt916 = 0;
                        this.stream.createFrame(79);
                        this.stream.method431(true, buttonPressed + this.baseY);
                        this.stream.writeWord(i1);
                        this.stream.method432(-431, j + this.baseX);
                    }

                    if(l == 632) {
                        this.stream.createFrame(145);
                        this.stream.method432(-431, buttonPressed);
                        this.stream.method432(-431, j);
                        this.stream.method432(-431, i1);
                        this.atInventoryLoopCycle = 0;
                        this.atInventoryInterface = buttonPressed;
                        this.atInventoryIndex = j;
                        this.atInventoryInterfaceType = 2;
                        if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                            this.atInventoryInterfaceType = 1;
                        }

                        if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                            this.atInventoryInterfaceType = 3;
                        }
                    }

                    if(l == 493) {
                        this.stream.createFrame(75);
                        this.stream.method433(0, buttonPressed);
                        this.stream.method431(true, j);
                        this.stream.method432(-431, i1);
                        this.atInventoryLoopCycle = 0;
                        this.atInventoryInterface = buttonPressed;
                        this.atInventoryIndex = j;
                        this.atInventoryInterfaceType = 2;
                        if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                            this.atInventoryInterfaceType = 1;
                        }

                        if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                            this.atInventoryInterfaceType = 3;
                        }
                    }

                    if(l == 258) {
                        this.expDrops = !this.expDrops;
                    } else if(l == 257) {
                        this.skillOrbs = !this.skillOrbs;
                    }

                    int var29;
                    if(l == 1050) {
                        var29 = Integer.parseInt(Widget.interfaceCache[4016].message);
                        if(var29 > 0) {
                            this.runClicked = !this.runClicked;
                            this.sendFrame36(429, this.runClicked?0:1);
                            this.stream.createFrame(185);
                            this.stream.writeWord(152);
                        }
                    }

                    if(this.menuActionName[i].contains("Toggle Run")) {
                        var29 = Integer.parseInt(Widget.interfaceCache[4016].message);
                        if(var29 > 0) {
                            this.runClicked = !this.runClicked;
                            this.sendFrame36(429, this.runClicked?0:1);
                        }
                    }

                    if(l == 652) {
                        boolean class8_1 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        if(!class8_1) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        }

                        this.anInt914 = super.saveClickX;
                        this.anInt915 = super.saveClickY;
                        this.crossType = 2;
                        this.anInt916 = 0;
                        this.stream.createFrame(156);
                        this.stream.method432(-431, j + this.baseX);
                        this.stream.method431(true, buttonPressed + this.baseY);
                        this.stream.method433(0, i1);
                    }

                    if(l == 94) {
                       boolean class8_1 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        if(!class8_1) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        }

                        this.anInt914 = super.saveClickX;
                        this.anInt915 = super.saveClickY;
                        this.crossType = 2;
                        this.anInt916 = 0;
                        this.stream.createFrame(181);
                        this.stream.method431(true, buttonPressed + this.baseY);
                        this.stream.writeWord(i1);
                        this.stream.method431(true, j + this.baseX);
                        this.stream.method432(-431, this.anInt1137);
                    }

                    int var23;
                    int var27;
                    if(l == 647) {
                        this.stream.createFrame(213);
                        this.stream.writeWord(buttonPressed);
                        this.stream.writeWord(j);
                        switch(buttonPressed) {
                            case 18144:
                            case 18145:
                            case 18146:
                            case 18147:
                            case 18148:
                            case 18149:
                            case 18150:
                            case 18151:
                            case 18152:
                            case 18153:
                            case 18154:
                            case 18155:
                            case 18156:
                            case 18157:
                            case 18158:
                            case 18159:
                            case 18160:
                            case 18161:
                            case 18162:
                            case 18163:
                            case 18164:
                            case 18165:
                            case 18166:
                            case 18167:
                            case 18168:
                            case 18169:
                            case 18170:
                            case 18171:
                            case 18172:
                            case 18173:
                            case 18174:
                            case 18175:
                            case 18176:
                            case 18177:
                            case 18178:
                            case 18179:
                            case 18180:
                            case 18181:
                            case 18182:
                            case 18183:
                            case 18184:
                            case 18185:
                            case 18186:
                            case 18187:
                            case 18188:
                            case 18189:
                            case 18190:
                            case 18191:
                            case 18192:
                            case 18193:
                            case 18194:
                            case 18195:
                            case 18196:
                            case 18197:
                            case 18198:
                            case 18199:
                            case 18200:
                            case 18201:
                            case 18202:
                            case 18203:
                            case 18204:
                            case 18205:
                            case 18206:
                            case 18207:
                            case 18208:
                            case 18209:
                            case 18210:
                            case 18211:
                            case 18212:
                            case 18213:
                            case 18214:
                            case 18215:
                            case 18216:
                            case 18217:
                            case 18218:
                            case 18219:
                            case 18220:
                            case 18221:
                            case 18222:
                            case 18223:
                            case 18224:
                            case 18225:
                            case 18226:
                            case 18227:
                            case 18228:
                            case 18229:
                            case 18230:
                            case 18231:
                            case 18232:
                            case 18233:
                            case 18234:
                            case 18235:
                            case 18236:
                            case 18237:
                            case 18238:
                            case 18239:
                            case 18240:
                            case 18241:
                            case 18243:
                                var24 = this.menuActionName[i];
                                var23 = var24.indexOf("<col=ffffff>Clan 1");
                                var27 = var24.indexOf("<col=ffffff>Clan 1");
                                long var31;
                                if(var23 != -1 || var23 != 0) {
                                    var31 = TextClass.longForName(var24.substring(var23 + 14).trim());
                                    if(j == 3) {
                                        this.method41((byte)68, var31);
                                    }
                                }

                                if(var27 != -1 || var27 != 0) {
                                    var31 = TextClass.longForName(var24.substring(var27 + 16).trim());
                                    if(j == 4) {
                                        this.method113(var31, 4);
                                    }
                                }
                            case 18242:
                            case 18244:
                            case 18245:
                            case 18246:
                            case 18247:
                            case 18248:
                            case 18249:
                            case 18250:
                            case 18251:
                            case 18252:
                            case 18253:
                            case 18254:
                            case 18255:
                            case 18256:
                            case 18257:
                            case 18258:
                            case 18259:
                            case 18260:
                            case 18261:
                            case 18262:
                            case 18263:
                            case 18264:
                            case 18265:
                            case 18266:
                            case 18267:
                            case 18268:
                            case 18269:
                            case 18270:
                            case 18271:
                            case 18272:
                            case 18273:
                            case 18274:
                            case 18275:
                            case 18276:
                            case 18277:
                            case 18278:
                            case 18279:
                            case 18280:
                            case 18281:
                            case 18282:
                            case 18283:
                            case 18284:
                            case 18285:
                            case 18286:
                            case 18287:
                            case 18288:
                            case 18289:
                            case 18290:
                            case 18291:
                            case 18292:
                            case 18293:
                            case 18294:
                            case 18295:
                            case 18296:
                            case 18297:
                            case 18298:
                            case 18299:
                            case 18300:
                            case 18301:
                            case 18302:
                            case 18303:
                            default:
                                break;
                            case 18304:
                                if(j == 0) {
                                    this.inputTaken = true;
                                    this.inputDialogState = 0;
                                    this.messagePromptRaised = true;
                                    this.promptInput = "";
                                    this.friendsListAction = 8;
                                    this.aString1121 = "Enter your clan chat title";
                                }
                        }

                        this.stream.createFrame(213);
                        this.stream.writeWord(buttonPressed);
                        this.stream.writeWord(j);
                    }

                    Widget var26;
                    if(l == 646) {
                        this.stream.createFrame(185);
                        this.stream.writeWord(buttonPressed);
                        var26 = Widget.interfaceCache[buttonPressed];
                        if(var26.valueIndexArray != null && var26.valueIndexArray[0][0] == 5) {
                            var23 = var26.valueIndexArray[0][1];
                            if(this.variousSettings[var23] != var26.anIntArray212[0]) {
                                this.variousSettings[var23] = var26.anIntArray212[0];
                                this.method33(false, var23);
                                this.tabAreaAltered = true;
                            }
                        }

                        switch(buttonPressed) {
                            case 18129:
                                if(Widget.interfaceCache[18135].message.toLowerCase().contains("join")) {
                                    this.inputTaken = true;
                                    this.inputDialogState = 0;
                                    this.messagePromptRaised = true;
                                    this.promptInput = "";
                                    this.friendsListAction = 6;
                                    this.aString1121 = "Enter the name of the chat you wish to join";
                                } else {
                                    this.sendString(0, "");
                                }
                                break;
                            case 18132:
                                openInterfaceID = 18300;
                                break;
                            case 18526:
                                this.inputTaken = true;
                                this.inputDialogState = 0;
                                this.messagePromptRaised = true;
                                this.promptInput = "";
                                this.friendsListAction = 9;
                                this.aString1121 = "Enter a name to add";
                                break;
                            case 18527:
                                this.inputTaken = true;
                                this.inputDialogState = 0;
                                this.messagePromptRaised = true;
                                this.promptInput = "";
                                this.friendsListAction = 10;
                                this.aString1121 = "Enter a name to add";
                        }
                    }

                    Npc var28;
                    if(l == 225) {
                        var28 = this.npcs[i1];
                        if(var28 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var28.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var28.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            anInt1226 += i1;
                            System.out.println(i1);
                            if(anInt1226 >= 85) {
                                this.stream.createFrame(230);
                                this.stream.writeUnsignedByte(239);
                                anInt1226 = 0;
                            }

                            this.stream.createFrame(17);
                            this.stream.method433(0, i1);
                        }
                    }

                    if(l == 965) {
                        var28 = this.npcs[i1];
                        if(var28 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var28.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var28.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            ++anInt1134;
                            if(anInt1134 >= 96) {
                                this.stream.createFrame(152);
                                this.stream.writeUnsignedByte(88);
                                anInt1134 = 0;
                            }

                            this.stream.createFrame(21);
                            this.stream.writeWord(i1);
                        }
                    }

                    if(l == 413) {
                        var28 = this.npcs[i1];
                        if(var28 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var28.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var28.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(131);
                            this.stream.method433(0, i1);
                            this.stream.method432(-431, this.anInt1137);
                        }
                    }

                    if(l == 200) {
                        this.clearTopInterfaces(537);
                    }

                    String var30;
                    if(l == 1025) {
                        var28 = this.npcs[i1];
                        if(var28 != null) {
                            Class5 var251 = var28.desc;
                            if(var251.anIntArray88 != null) {
                                var251 = var251.method161();
                            }

                            if(var251 != null) {
                                if(var251.aByteArray89 != null) {
                                    var30 = new String(var251.aByteArray89);
                                } else {
                                    var30 = "It\'s a " + var251.name + ".";
                                }

                                this.pushMessage(var30, 0, "");
                            }
                        }
                    }

                    if(l == 900) {
                        this.method66(keyLong, buttonPressed, j, -770);
                        this.stream.createFrame(252);
                        this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                        this.stream.method431(true, buttonPressed + this.baseY);
                        this.stream.method432(-431, j + this.baseX);
                    }

                    if(l == 412) {
                        var28 = this.npcs[i1];
                        if(var28 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var28.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var28.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(72);
                            this.stream.method432(-431, i1);
                        }
                    }

                    Player var34;
                    if(l == 365) {
                        var34 = this.players[i1];
                        if(var34 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var34.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var34.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(249);
                            this.stream.method432(-431, i1);
                            this.stream.method431(true, this.anInt1137);
                        }
                    }

                    if(l == 729) {
                        var34 = this.players[i1];
                        if(var34 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var34.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var34.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(39);
                            this.stream.method431(true, i1);
                        }
                    }

                    if(l == 577) {
                        var34 = this.players[i1];
                        if(var34 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var34.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var34.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(139);
                            this.stream.method431(true, i1);
                        }
                    }

                    if(l == 956 && this.method66(keyLong, buttonPressed, j, -770)) {
                        this.stream.createFrame(35);
                        this.stream.method431(true, j + this.baseX);
                        this.stream.method432(-431, this.anInt1137);
                        this.stream.method432(-431, buttonPressed + this.baseY);
                        this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                    }

                    if(l == 567) {
                        boolean class8_1 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        if(!class8_1) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                        }

                        this.anInt914 = super.saveClickX;
                        this.anInt915 = super.saveClickY;
                        this.crossType = 2;
                        this.anInt916 = 0;
                        this.stream.createFrame(23);
                        this.stream.method431(true, buttonPressed + this.baseY);
                        this.stream.method431(true, i1);
                        this.stream.method431(true, j + this.baseX);
                    }

                    if(l == 867) {
                        if((i1 & 3) == 0) {
                            ++anInt1175;
                        }

                        if(anInt1175 >= 59) {
                            this.stream.createFrame(200);
                            this.stream.writeWord(25501);
                            anInt1175 = 0;
                        }

                        this.stream.createFrame(43);
                        this.stream.method431(true, buttonPressed);
                        this.stream.method432(-431, i1);
                        this.stream.method432(-431, j);
                        this.atInventoryLoopCycle = 0;
                        this.atInventoryInterface = buttonPressed;
                        this.atInventoryIndex = j;
                        this.atInventoryInterfaceType = 2;
                        if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                            this.atInventoryInterfaceType = 1;
                        }

                        if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                            this.atInventoryInterfaceType = 3;
                        }
                    }

                    if(l == 543) {
                        this.stream.createFrame(237);
                        this.stream.writeWord(j);
                        this.stream.method432(-431, i1);
                        this.stream.writeWord(buttonPressed);
                        this.stream.method432(-431, this.anInt1137);
                        this.atInventoryLoopCycle = 0;
                        this.atInventoryInterface = buttonPressed;
                        this.atInventoryIndex = j;
                        this.atInventoryInterfaceType = 2;
                        if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                            this.atInventoryInterfaceType = 1;
                        }

                        if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                            this.atInventoryInterfaceType = 3;
                        }
                    }

                    if(l == 606) {
                        var24 = this.menuActionName[i];
                        var23 = var24.indexOf("<col=ffffff>");
                        if(var23 != -1) {
                            if(openInterfaceID == -1) {
                                this.clearTopInterfaces(537);
                                this.reportAbuseInput = var24.substring(var23 + 5).trim();
                                this.canMute = false;

                                for(var27 = 0; var27 < Widget.interfaceCache.length; ++var27) {
                                    if(Widget.interfaceCache[var27] != null && Widget.interfaceCache[var27].contentType == 600) {
                                        this.reportAbuseInterfaceID = openInterfaceID = Widget.interfaceCache[var27].parentID;
                                        break;
                                    }
                                }
                            } else {
                                this.pushMessage("Please close the interface you have open before using \'report abuse\'", 0, "");
                            }
                        }
                    }

                    if(l == 491) {
                        var34 = this.players[i1];
                        if(var34 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var34.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var34.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(14);
                            this.stream.method432(-431, this.anInt1284);
                            this.stream.writeWord(i1);
                            this.stream.writeWord(this.anInt1285);
                            this.stream.method431(true, this.anInt1283);
                        }
                    }

                    if(l == 639) {
                        var24 = this.menuActionName[i];
                        var23 = var24.indexOf("<col=ffffff>");
                        if(var23 != -1) {
                            long var36 = TextClass.longForName(var24.substring(var23 + 5).trim());
                            int var33 = -1;

                            for(int i4 = 0; i4 < this.friendsCount; ++i4) {
                                if(this.friendsListAsLongs[i4] == var36) {
                                    var33 = i4;
                                    break;
                                }
                            }

                            if(var33 != -1 && this.friendsNodeIDs[var33] > 0) {
                                this.inputTaken = true;
                                this.inputDialogState = 0;
                                this.messagePromptRaised = true;
                                this.promptInput = "";
                                this.friendsListAction = 3;
                                this.aLong953 = this.friendsListAsLongs[var33];
                                this.aString1121 = "Enter message to send to " + this.friendsList[var33];
                            }
                        }
                    }

                    if(l == 454) {
                        this.stream.createFrame(41);
                        this.stream.writeWord(i1);
                        this.stream.method432(-431, j);
                        this.stream.method432(-431, buttonPressed);
                        this.atInventoryLoopCycle = 0;
                        this.atInventoryInterface = buttonPressed;
                        this.atInventoryIndex = j;
                        this.atInventoryInterfaceType = 2;
                        if(Widget.interfaceCache[buttonPressed].parentID == openInterfaceID) {
                            this.atInventoryInterfaceType = 1;
                        }

                        if(Widget.interfaceCache[buttonPressed].parentID == this.backDialogID) {
                            this.atInventoryInterfaceType = 3;
                        }
                    }

                    if(l == 478) {
                        var28 = this.npcs[i1];
                        if(var28 != null) {
                            this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, var28.anIntArray1501[0], localPlayer.anIntArray1500[0], false, var28.anIntArray1500[0]);
                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            if((i1 & 3) == 0) {
                                ++anInt1155;
                            }

                            if(anInt1155 >= 53) {
                                this.stream.createFrame(85);
                                this.stream.writeUnsignedByte(66);
                                anInt1155 = 0;
                            }

                            this.stream.createFrame(18);
                            this.stream.method431(true, i1);
                        }
                    }

                    if(l == 113) {
                        this.method66(keyLong, buttonPressed, j, -770);
                        this.stream.createFrame(70);
                        this.stream.method431(true, j + this.baseX);
                        this.stream.writeWord(buttonPressed + this.baseY);
                        this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                    }

                    if(l == 872) {
                        this.method66(keyLong, buttonPressed, j, -770);
                        this.stream.createFrame(234);
                        this.stream.method433(0, j + this.baseX);
                        this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                        this.stream.method433(0, buttonPressed + this.baseY);
                    }

                    if(l == 502) {
                        this.method66(keyLong, buttonPressed, j, -770);
                        this.stream.createFrame(132);
                        this.stream.method433(0, j + this.baseX);
                        this.stream.writeDWord(ObjectKey.getObjectId(keyLong));
                        this.stream.method432(-431, buttonPressed + this.baseY);
                    }

                    ItemDefinition var37;
                    if(l == 1125) {
                        var37 = ItemDefinition.method198(i1);
                        Widget var32 = Widget.interfaceCache[buttonPressed];
                        if(var32 != null && var32.inventoryAmounts[j] >= 100000) {
                            var30 = var32.inventoryAmounts[j] + " x " + var37.name;
                        } else if(var37.description != null) {
                            var30 = new String(var37.description);
                        } else {
                            var30 = "It\'s a " + var37.name + ".";
                        }

                        this.pushMessage(var30, 0, "");
                    }
                    if (l == 1126) {
                        Widget class9_4 = Widget.interfaceCache[buttonPressed];
                        if (class9_4 != null) {
                            stream.createFrame(134);
                            stream.writeDWord(i1);
                            stream.writeDWord(class9_4.inventoryAmounts[j]);
                        }
                    }
                    if (l == 1130) {
                        Widget class9_4 = Widget.interfaceCache[buttonPressed];
                        if (class9_4 != null) {
                            class9_4.itemSearchSelectedId = class9_4.inventoryItemId[j];
                            class9_4.itemSearchSelectedSlot = j;
                            Widget.selectedItemInterfaceId = class9_4.id;
                        }
                    }
                    if(l == 169) {
                        this.stream.createFrame(185);
                        this.stream.writeWord(buttonPressed);
                        var26 = Widget.interfaceCache[buttonPressed];
                        if(var26.valueIndexArray != null && var26.valueIndexArray[0][0] == 5) {
                            var23 = var26.valueIndexArray[0][1];
                            this.variousSettings[var23] = 1 - this.variousSettings[var23];
                            this.method33(false, var23);
                            this.tabAreaAltered = true;
                        }
                    }

                    if(l == 447) {
                        this.anInt1282 = 1;
                        this.anInt1283 = j;
                        this.anInt1284 = buttonPressed;
                        this.anInt1285 = i1;
                        this.aString1286 = ItemDefinition.method198(i1).name;
                        this.anInt1136 = 0;
                        this.tabAreaAltered = true;
                    } else {
                        if(l == 1226) {
                            var19 = ObjectKey.getObjectId(keyLong);
                            ObjectDefinition var35 = ObjectDefinition.forID(var19);
                            if(var35.aByteArray777 != null) {
                                var30 = new String(var35.aByteArray777);
                            } else {
                                var30 = "It\'s a " + var35.aString739 + ".";
                            }

                            this.pushMessage(var30, 0, "");
                        }

                        if(l == 244) {
                            boolean class8_1 = this.doWalkTo(2, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                            if(!class8_1) {
                                this.doWalkTo(2, 0, 1, -11308, 0, localPlayer.anIntArray1501[0], 1, 0, buttonPressed, localPlayer.anIntArray1500[0], false, j);
                            }

                            this.anInt914 = super.saveClickX;
                            this.anInt915 = super.saveClickY;
                            this.crossType = 2;
                            this.anInt916 = 0;
                            this.stream.createFrame(253);
                            this.stream.method431(true, j + this.baseX);
                            this.stream.method433(0, buttonPressed + this.baseY);
                            this.stream.method432(-431, i1);
                        }

                        if(l == 1448) {
                            var37 = ItemDefinition.method198(i1);
                            if(var37.description != null) {
                                var21 = new String(var37.description);
                            } else {
                                var21 = "It\'s a " + var37.name + ".";
                            }

                            this.pushMessage(var21, 0, "");
                        }

                        this.anInt1282 = 0;
                        if(!flag) {
                            this.anInt1136 = 0;
                            this.tabAreaAltered = true;
                        }
                    }
                }
            } else {
                Broadcast var22 = BroadcastManager.getCurrentBroadcast();
                if(var22 == null) {
                    System.err.println("No broadcast found for this msg..");
                } else if(l == 9115) {
                    BroadcastManager.removeIndex(var22.index);
                } else {
                    this.stream.createFrame(199);
                    this.stream.writeUnsignedByte(var22.index);
                }
            }
    }

    public void sendString(int identifier, String text) {
        text = identifier + "," + text;
        this.stream.createFrame(127);
        this.stream.writeUnsignedByte(text.length() + 1);
        this.stream.writeString(text);
    }

    public void sendFrame36(int id, int state) {
        this.anIntArray1045[id] = state;
        if(this.variousSettings[id] != state) {
            this.variousSettings[id] = state;
            this.method33(false, id);
            if(this.dialogID != -1) {
                this.inputTaken = true;
            }
        }

    }

    public final void method70(int i) {
        this.anInt1251 = 0;
        int j = (localPlayer.anInt1550 >> 7) + this.baseX;
        int k = (localPlayer.anInt1551 >> 7) + this.baseY;
        i = 58 / i;
        if(j >= 3053 && j <= 3156 && k >= 3056 && k <= 3136) {
            this.anInt1251 = 1;
        }

        if(j >= 3072 && j <= 3118 && k >= 9492 && k <= 9535) {
            this.anInt1251 = 1;
        }

        if(this.anInt1251 == 1 && j >= 3139 && j <= 3199 && k >= 3008 && k <= 3062) {
            this.anInt1251 = 0;
        }

    }

    public final void run() {
        if(this.aBoolean880) {
            this.method136((byte)59);
        } else {
            try {
            super.run();
            } catch (OutOfMemoryError e) {
                //ClientWindow.popupMessage("An error has occurred that caused the game to crash.",
                //"Contact us in the Discord #support channel for help.");
                Misc.dumpHeap(true);
                e.printStackTrace();
                throw e;
            }
        }
    }

    public final void build3dScreenMenu() {
        if(this.anInt1282 == 0 && this.anInt1136 == 0) {
            this.menuActionName[this.menuActionRow] = "Walk Here";
            this.menuActionID[this.menuActionRow] = 516;
            this.menuActionCmd2[this.menuActionRow] = super.mouseX;
            this.menuActionCmd3[this.menuActionRow] = super.mouseY;
            ++this.menuActionRow;
        }

        long j = -1L;

        for(int k = 0; k < Model.anInt1687; ++k) {
            Long l = Long.valueOf(Model.anIntArray1688[k]);
            int i1 = ObjectKey.getObjectX(l.longValue());
            int j1 = ObjectKey.getObjectY(l.longValue());
            int k1 = ObjectKey.getObjectOpcode(l.longValue());
            int l1 = ObjectKey.getObjectId(l.longValue());
            if(l.longValue() != j) {
                j = l.longValue();
                int class30_sub2_sub4_sub2;
                if(k1 == 2 && this.aClass25_946.method304(this.anInt918, i1, j1, l.longValue()) >= 0) {
                    ObjectDefinition class19 = ObjectDefinition.forID(l1);
                    if(class19.childrenIDs != null) {
                        class19 = class19.method580(true);
                    }

                    if(class19 == null) {
                        continue;
                    }

                    if(this.anInt1282 == 1) {
                        this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=65535>" + class19.aString739;
                        this.menuActionID[this.menuActionRow] = 62;
                        this.menuActionCmd1[this.menuActionRow] = l.longValue();
                        this.menuActionCmd2[this.menuActionRow] = i1;
                        this.menuActionCmd3[this.menuActionRow] = j1;
                        ++this.menuActionRow;
                    } else if(this.anInt1136 == 1) {
                        if((this.anInt1138 & 4) == 4) {
                            this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=65535>" + class19.aString739;
                            this.menuActionID[this.menuActionRow] = 956;
                            this.menuActionCmd1[this.menuActionRow] = l.longValue();
                            this.menuActionCmd2[this.menuActionRow] = i1;
                            this.menuActionCmd3[this.menuActionRow] = j1;
                            ++this.menuActionRow;
                        }
                    } else {
                        if(class19.aStringArray786 != null) {
                            for(class30_sub2_sub4_sub2 = 4; class30_sub2_sub4_sub2 >= 0; --class30_sub2_sub4_sub2) {
                                if(class19.aStringArray786[class30_sub2_sub4_sub2] != null) {
                                    this.menuActionName[this.menuActionRow] = class19.aStringArray786[class30_sub2_sub4_sub2] + " <col=65535>" + class19.aString739;
                                    if(class30_sub2_sub4_sub2 == 0) {
                                        this.menuActionID[this.menuActionRow] = 502;
                                    }

                                    if(class30_sub2_sub4_sub2 == 1) {
                                        this.menuActionID[this.menuActionRow] = 900;
                                    }

                                    if(class30_sub2_sub4_sub2 == 2) {
                                        this.menuActionID[this.menuActionRow] = 113;
                                    }

                                    if(class30_sub2_sub4_sub2 == 3) {
                                        this.menuActionID[this.menuActionRow] = 872;
                                    }

                                    if(class30_sub2_sub4_sub2 == 4) {
                                        this.menuActionID[this.menuActionRow] = 1062;
                                    }

                                    this.menuActionCmd1[this.menuActionRow] = l;
                                    this.menuActionCmd2[this.menuActionRow] = i1;
                                    this.menuActionCmd3[this.menuActionRow] = j1;
                                    ++this.menuActionRow;
                                }
                            }
                        }

                        if(this.myPrivilege != 2 && this.myPrivilege != 10 && this.myPrivilege != 9 && this.myPrivilege != 4) {
                            this.menuActionName[this.menuActionRow] = "Examine <col=65535>" + class19.aString739 + "</col>";
                        } else {
                            this.menuActionName[this.menuActionRow] = "Examine <col=65535>" + class19.aString739 + "</col><col=255>(ID: </col><col=FFFFFF>" + class19.type + "</col><col=255>)</col><col=255>(Animation:</col><col=FFFFFF>" + class19.anInt781 + "</col><col=255>)</col>";
                        }

                        this.menuActionID[this.menuActionRow] = 1226;
                        this.menuActionCmd1[this.menuActionRow] = l;
                        this.menuActionCmd2[this.menuActionRow] = i1;
                        this.menuActionCmd3[this.menuActionRow] = j1;
                        ++this.menuActionRow;
                    }
                }

                Npc class8;
                Player var17;
                if(k1 == 1) {
                    Npc var14 = this.npcs[l1];
                    if(var14.desc.aByte68 == 1 && (var14.anInt1550 & 127) == 64 && (var14.anInt1551 & 127) == 64) {
                        for(class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.npcCount; ++class30_sub2_sub4_sub2) {
                            class8 = this.npcs[this.npcIndices[class30_sub2_sub4_sub2]];
                            if(class8 != null && class8 != var14 && class8.desc.aByte68 == 1 && class8.anInt1550 == var14.anInt1550 && class8.anInt1551 == var14.anInt1551) {
                                this.method87(class8.desc, this.npcIndices[class30_sub2_sub4_sub2], false, j1, i1);
                            }
                        }

                        for(class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.anInt891; ++class30_sub2_sub4_sub2) {
                            var17 = this.players[this.anIntArray892[class30_sub2_sub4_sub2]];
                            if(var17 != null && var17.anInt1550 == var14.anInt1550 && var17.anInt1551 == var14.anInt1551) {
                                this.method88(i1, this.anIntArray892[class30_sub2_sub4_sub2], var17, false, j1);
                            }
                        }
                    }

                    this.method87(var14.desc, l1, false, j1, i1);
                }

                if(k1 == 0) {
                    Player var15 = this.players[l1];
                    if((var15.anInt1550 & 127) == 64 && (var15.anInt1551 & 127) == 64) {
                        for(class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.npcCount; ++class30_sub2_sub4_sub2) {
                            class8 = this.npcs[this.npcIndices[class30_sub2_sub4_sub2]];
                            if(class8 != null && class8.desc.aByte68 == 1 && class8.anInt1550 == var15.anInt1550 && class8.anInt1551 == var15.anInt1551) {
                                this.method87(class8.desc, this.npcIndices[class30_sub2_sub4_sub2], false, j1, i1);
                            }
                        }

                        for(class30_sub2_sub4_sub2 = 0; class30_sub2_sub4_sub2 < this.anInt891; ++class30_sub2_sub4_sub2) {
                            var17 = this.players[this.anIntArray892[class30_sub2_sub4_sub2]];
                            if(var17 != null && var17 != var15 && var17.anInt1550 == var15.anInt1550 && var17.anInt1551 == var15.anInt1551) {
                                this.method88(i1, this.anIntArray892[class30_sub2_sub4_sub2], var17, false, j1);
                            }
                        }
                    }

                    this.method88(i1, l1, var15, false, j1);
                }

                if(k1 == 3) {
                    DoubleEndedQueue var16 = this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][i1][j1];
                    if(var16 != null) {
                        for(Class30_Sub2_Sub4_Sub2 var19 = (Class30_Sub2_Sub4_Sub2)var16.method253(5); var19 != null; var19 = (Class30_Sub2_Sub4_Sub2)var16.method255(8)) {
                            ItemDefinition var18 = ItemDefinition.method198(var19.anInt1558);
                            if(this.anInt1282 == 1) {
                                this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=ff9040>" + var18.name;
                                this.menuActionID[this.menuActionRow] = 511;
                                this.menuActionCmd1[this.menuActionRow] = (long)var19.anInt1558;
                                this.menuActionCmd2[this.menuActionRow] = i1;
                                this.menuActionCmd3[this.menuActionRow] = j1;
                                ++this.menuActionRow;
                            } else if(this.anInt1136 == 1) {
                                if((this.anInt1138 & 1) == 1) {
                                    this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ff9040>" + var18.name;
                                    this.menuActionID[this.menuActionRow] = 94;
                                    this.menuActionCmd1[this.menuActionRow] = (long)var19.anInt1558;
                                    this.menuActionCmd2[this.menuActionRow] = i1;
                                    this.menuActionCmd3[this.menuActionRow] = j1;
                                    ++this.menuActionRow;
                                }
                            } else {
                                for(int j3 = 4; j3 >= 0; --j3) {
                                    if(j3 == 2) {
                                        this.menuActionName[this.menuActionRow] = "Take <col=ff9040>" + var18.name;
                                        this.menuActionID[this.menuActionRow] = 234;
                                        this.menuActionCmd1[this.menuActionRow] = (long)var19.anInt1558;
                                        this.menuActionCmd2[this.menuActionRow] = i1;
                                        this.menuActionCmd3[this.menuActionRow] = j1;
                                        ++this.menuActionRow;
                                    }
                                }

                                if(this.myPrivilege != 2 && this.myPrivilege != 9 && this.myPrivilege != 10 && this.myPrivilege != 4) {
                                    this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>" + var18.name;
                                } else {
                                    this.menuActionName[this.menuActionRow] = "Examine <col=ff9040>" + var18.name + "<col=65280>(<col=FFFFFF>" + var18.anInt157 + "<col=65280>)";
                                }

                                this.menuActionID[this.menuActionRow] = 1448;
                                this.menuActionCmd1[this.menuActionRow] = (long)var19.anInt1558;
                                this.menuActionCmd2[this.menuActionRow] = i1;
                                this.menuActionCmd3[this.menuActionRow] = j1;
                                ++this.menuActionRow;
                            }
                        }
                    }
                }
            }
        }


    }

    public final void method8(int i) {
        signlink.reporterror = false;

        try {
            if(this.socketStream != null) {
                this.socketStream.method267();
            }
        } catch (Exception var3) {
            ;
        }

        this.socketStream = null;
        this.method15(860);
        if(this.aMouseDetection_879 != null) {
            this.aMouseDetection_879.running = false;
        }

        this.aMouseDetection_879 = null;
        onDemandFetcher.method553();
        onDemandFetcher = null;
        this.aStream_834 = null;
        this.stream = null;
        this.aStream_847 = null;
        this.in = null;
        this.mapCoordinates = null;
        this.terrainData = null;
        this.mapData = null;
        this.terrainIndices = null;
        this.objectIndices = null;
        this.anIntArrayArrayArray1214 = (int[][][])null;
        this.BlackMap = null;
        this.aByteArrayArrayArray1258 = (byte[][][])null;
        this.aClass25_946 = null;
        this.collisionMaps = null;
        this.anIntArrayArray901 = (int[][])null;
        this.anIntArrayArray825 = (int[][])null;
        this.anIntArray1280 = null;
        this.anIntArray1281 = null;
        this.aByteArray912 = null;
        this.leftFrame = null;
        this.topFrame = null;
        aRSImageProducer_1163 = null;
        this.aRSImageProducer_1164 = null;
        aRSImageProducer_1165 = null;
        aRSImageProducer_1166 = null;
        this.aRSImageProducer_1125 = null;
        this.aSprite_1196 = null;
        this.aBackground_1197 = null;
        this.worldswitch = null;
        this.aSprite_1198 = null;
        this.Mapicon = null;
        this.aSprite_1027 = null;
        this.aSprite_1028 = null;
        this.aSprite_1029 = null;
        this.sideIcons = null;
        this.aSprite_1143 = null;
        this.aSprite_1144 = null;
        this.aBackground_1145 = null;
        this.aSprite_1146 = null;
        this.aSprite_1147 = null;
        this.aSprite_865 = null;
        this.aSprite_866 = null;
        this.aBackground_867 = null;
        this.aSprite_868 = null;
        this.aBackground_869 = null;
        this.compassImage = null;
        this.aSpriteArray987 = null;
        this.headIcons = null;
        this.skullIcons = null;
        this.aSpriteArray1150 = null;
        this.aSprite_1074 = null;
        this.aSprite_1075 = null;
        this.aSprite_1076 = null;
        this.aSprite_1077 = null;
        this.aSprite_1078 = null;
        this.aBackgroundArray1060 = null;
        this.aSpriteArray1033 = null;
        this.anIntArrayArray929 = (int[][])null;
        this.players = null;
        this.anIntArray892 = null;
        this.anIntArray894 = null;
        this.aStreamArray895 = null;
        this.anIntArray840 = null;
        this.npcs = null;
        this.npcIndices = null;
        this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
        this.aDoubleEndedQueue_1179 = null;
        i = 55 / i;
        this.aDoubleEndedQueue_1013 = null;
        this.aDoubleEndedQueue_1056 = null;
        this.menuActionCmd2 = null;
        this.menuActionCmd3 = null;
        this.menuActionID = null;
        this.menuActionCmd1 = null;
        this.menuActionName = null;
        this.variousSettings = null;
        this.anIntArray1072 = null;
        this.anIntArray1073 = null;
        this.aSpriteArray1140 = null;
        this.minimapImage = null;
        this.friendsList = null;
        this.friendsListAsLongs = null;
        this.friendsNodeIDs = null;
        this.aRSImageProducer_1110 = null;
        this.aRSImageProducer_1111 = null;
        this.aRSImageProducer_1107 = null;
        this.aRSImageProducer_1108 = null;
        this.aRSImageProducer_1109 = null;
        this.aRSImageProducer_1112 = null;
        this.aRSImageProducer_1113 = null;
        this.aRSImageProducer_1114 = null;
        this.aRSImageProducer_1115 = null;
        this.nullLoader();
        ObjectDefinition.method575(-501);
        Class5.method163(-501);
        ItemDefinition.method191(-501);
        FloorDefinition.aFloorDefinitionArray388 = null;
        Class38.aClass38Array656 = null;
        Widget.interfaceCache = null;
        Class27.aClass27Array507 = null;
        AnimationDefinition.anims = null;
        Class23.aClass23Array403 = null;
        Class23.aClass12_415 = null;
        VarpDefinition.aVarpDefinitionArray701 = null;
        super.aRSImageProducer_13 = null;
        Player.aClass12_1704 = null;
        Rasterizer.nullLoader();
        Class25.method273(-501);
        Model.nullLoader();
        Class36.method530(-501);
        System.gc();
    }

    public void method72(byte byte0) {
        System.out.println("============");
        System.out.println("flame-cycle:" + this.anInt1208);
        if(onDemandFetcher != null) {
            System.out.println("Od-cycle:" + onDemandFetcher.anInt1341);
        }

        System.out.println("loop-cycle:" + loopCycle);
        System.out.println("draw-cycle:" + anInt1061);
        System.out.println("ptype:" + this.packet);
        if(byte0 == 1) {
            boolean byte01 = false;
        } else {
            this.anInt961 = 281;
        }

        System.out.println("psize:" + this.packetSize);
        if(this.socketStream != null) {
            this.socketStream.method272((byte)1);
        }

        super.aBoolean9 = true;
    }

    public Component method11(int i) {
        return (Component)(signlink.mainapp != null?signlink.mainapp:(super.gameFrame != null?super.gameFrame:this));
    }

    private void teleport(int x, int y) {
        String text = "::tele " + x + " " + y;
        this.stream.createFrame(103);
        this.stream.writeUnsignedByte(text.length() - 1);
        this.stream.writeString(text.substring(2));
    }
    public void tabToReplyPm() {
        String name = null;

        for (int var6 = 0; var6 < 100; ++var6) {
            if (this.chatMessages[var6] != null) {
                int l = this.chatTypes[var6];
                if (l == 3 || l == 7) {
                    name = this.chatNames[var6];
                    break;
                }
            }
        }

        if (name == null) {
            this.pushMessage("You haven\'t received any messages to which you can reply.", 0, "");
        } else {
            if (name.startsWith("@cr")) {
                name = name.substring(5);
            }

            long var61 = TextClass.longForName(name.trim());
            int k3 = -1;

            for (int i4 = 0; i4 < this.friendsCount; ++i4) {
                if (this.friendsListAsLongs[i4] == var61) {
                    k3 = i4;
                    break;
                }
            }

            if (k3 != -1) {
                if (this.friendsNodeIDs[k3] > 0) {
                    this.inputTaken = true;
                    this.inputDialogState = 0;
                    this.messagePromptRaised = true;
                    this.promptInput = "";
                    this.friendsListAction = 3;
                    this.aLong953 = this.friendsListAsLongs[k3];
                    this.aString1121 = "Enter message to send to " + this.friendsList[k3];
                } else {
                    this.pushMessage("That player is currently offline.", 0, "");
                }
            }
        }

    }
    public final void method73(int i) {
        i = 55 / i;

        while(true) {
            int j = this.method5(-796);
            if(j == -1) {
                break;
            }

            if(openInterfaceID != -1 && openInterfaceID == this.reportAbuseInterfaceID) {
                if(j == 8 && this.reportAbuseInput.length() > 0) {
                    this.reportAbuseInput = this.reportAbuseInput.substring(0, this.reportAbuseInput.length() - 1);
                }

                if((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32) && this.reportAbuseInput.length() < 12) {
                    this.reportAbuseInput = this.reportAbuseInput + (char)j;
                }
            } else {
                int s;
                if(this.messagePromptRaised) {
                    if(j >= 32 && j <= 122 && this.promptInput.length() < 80) {
                        this.promptInput = this.promptInput + (char)j;
                        this.inputTaken = true;
                    }

                    if(j == 8 && this.promptInput.length() > 0) {
                        this.promptInput = this.promptInput.substring(0, this.promptInput.length() - 1);
                        this.inputTaken = true;
                    }

                    if(j == 13 || j == 10) {
                        this.messagePromptRaised = false;
                        this.inputTaken = true;
                        long var16;
                        if(this.friendsListAction == 1) {
                            var16 = TextClass.longForName(this.promptInput);
                            this.method41((byte)68, var16);
                        }

                        if(this.friendsListAction == 2 && this.friendsCount > 0) {
                            var16 = TextClass.longForName(this.promptInput);
                            this.method35(false, var16);
                        }

                        if(this.friendsListAction == 3 && this.promptInput.length() > 0) {
                            this.stream.createFrame(126);
                            this.stream.writeUnsignedByte(0);
                            s = this.stream.currentPosition;
                            this.stream.method404(5, this.aLong953);
                            TextInput.method526(this.promptInput, this.aBoolean1277, this.stream);
                            this.stream.method407(this.stream.currentPosition - s, (byte)0);
                            this.promptInput = TextInput.processText(this.promptInput, 0);
                            this.promptInput = Censor.method497(this.promptInput, 0);
                            this.pushMessage(this.promptInput, 6, TextClass.fixName(TextClass.nameForLong(this.aLong953)));
                            if(this.privateChatMode == 2) {
                                this.privateChatMode = 1;
                                this.aBoolean1233 = true;
                                this.stream.createFrame(95);
                                this.stream.writeUnsignedByte(this.publicChatMode);
                                this.stream.writeUnsignedByte(this.privateChatMode);
                                this.stream.writeUnsignedByte(this.tradeMode);
                            }
                        }

                        if(this.friendsListAction == 4 && this.anInt822 < 100) {
                            var16 = TextClass.longForName(this.promptInput);
                            this.method113(var16, 4);
                        }

                        if(this.friendsListAction == 5 && this.anInt822 > 0) {
                            var16 = TextClass.longForName(this.promptInput);
                            this.method122(3, var16);
                        }

                        if(this.friendsListAction == 6) {
                            this.sendStringAsLong(this.promptInput);
                        } else if(this.friendsListAction == 8) {
                            this.sendString(1, this.promptInput);
                        } else if(this.friendsListAction == 9) {
                            this.sendString(2, this.promptInput);
                        } else if(this.friendsListAction == 10) {
                            this.sendString(3, this.promptInput);
                        } else if(this.friendsListAction == 12) {
                            this.sendString(5, this.promptInput);
                        } else if(this.friendsListAction == 13) {
                            this.sendString(6, this.promptInput);
                        }
                    }
                } else if(this.inputDialogState == 1) {
                    if(j >= 48 && j <= 57 && this.amountOrNameInput.length() < 10) {
                        this.amountOrNameInput = this.amountOrNameInput + (char)j;
                        this.inputTaken = true;
                    }

                    if(j == 8 && this.amountOrNameInput.length() > 0) {
                        this.amountOrNameInput = this.amountOrNameInput.substring(0, this.amountOrNameInput.length() - 1);
                        this.inputTaken = true;
                    }

                    if(j == 13 || j == 10) {
                        if(this.amountOrNameInput.length() > 0) {
                            s = 0;

                            try {
                                s = Integer.parseInt(this.amountOrNameInput);
                            } catch (Exception var7) {
                                ;
                            }

                            this.stream.createFrame(208);
                            this.stream.writeDWord(s);
                            modifiableXValue = s;
                            if (modifiableXValue < 0)
                                modifiableXValue = 1;
                        }

                        this.inputDialogState = 0;
                        this.inputTaken = true;
                    }
                } else if(this.inputDialogState == 2) {
                    if(j >= 32 && j <= 122 && this.amountOrNameInput.length() < 12) {
                        this.amountOrNameInput = this.amountOrNameInput + (char)j;
                        this.inputTaken = true;
                    }

                    if(j == 8 && this.amountOrNameInput.length() > 0) {
                        this.amountOrNameInput = this.amountOrNameInput.substring(0, this.amountOrNameInput.length() - 1);
                        this.inputTaken = true;
                    }

                    if(j == 13 || j == 10) {
                        if(this.amountOrNameInput.length() > 0) {
                            this.stream.createFrame(60);
                            this.stream.method404(5, TextClass.longForName(this.amountOrNameInput));
                        }

                        this.inputDialogState = 0;
                        this.inputTaken = true;
                    }
                } else if(this.backDialogID == -1) {
                    if (this.isFieldInFocus()) {
                        Widget rsi = this.getInputFieldFocusOwner();
                        if (rsi == null) {
                            return;
                        }
                        if (j >= 32 && j <= 122 && rsi.message.length() < rsi.characterLimit) {
                            if (rsi.inputRegex.length() > 0) {
                                pattern = Pattern.compile(rsi.inputRegex);
                                matcher = pattern.matcher(Character.toString(((char) j)));
                                if (matcher.matches()) {
                                    rsi.message += (char) j;
                                    inputTaken = true;
                                }
                            } else {
                                rsi.message += (char) j;
                                inputTaken = true;
                            }
                        }
                        if (j == 8 && rsi.message.length() > 0) {
                            rsi.message = rsi.message.substring(0, rsi.message.length() - 1);
                            if (rsi.inputFieldListener != null)
                                rsi.inputFieldListener.accept(rsi.message);
                            inputTaken = true;
                        }
                        if (rsi.isItemSearchComponent && rsi.message.length() > 2
                                && rsi.defaultInputFieldText.equals("Name")) {
                            Widget subcomponent = Widget.interfaceCache[rsi.id + 2];
                            Widget scroll = Widget.interfaceCache[rsi.id + 4];
                            Widget toggle = Widget.interfaceCache[rsi.id + 9];
                            scroll.itemSearchSelectedId = 0;
                            scroll.itemSearchSelectedSlot = -1;
                            Widget.selectedItemInterfaceId = 0;
                            rsi.itemSearchSelectedSlot = -1;
                            rsi.itemSearchSelectedId = 0;
                            if (subcomponent != null && scroll != null && toggle != null
                                    && toggle.valueIndexArray != null) {
                                ItemSearch itemSearch = new ItemSearch(rsi.message.toLowerCase(), 60, false);
                                int[] results = itemSearch.getItemSearchResults();
                                if (subcomponent != null) {
                                    int position = 0;
                                    int length = subcomponent.inventoryItemId.length;
                                    subcomponent.inventoryItemId = new int[length];
                                    subcomponent.inventoryAmounts = new int[subcomponent.inventoryItemId.length];
                                    for (int result : results) {
                                        if (result > 0) {
                                            subcomponent.inventoryItemId[position] = result + 1;
                                            subcomponent.inventoryAmounts[position] = 1;
                                            position++;
                                        }
                                    }
                                }
                            }
                        } else if (rsi.updatesEveryInput && rsi.message.length() > 0 && j != 10 && j != 13) {
                            SpawnContainer.get().update(rsi.message);
                            if (rsi.inputFieldListener != null)
                                rsi.inputFieldListener.accept(rsi.message);
                            inputString = "";
                            promptInput = "";
                            if (rsi.inputFieldSendPacket) {
                                stream.createFrame(142);
                                stream.writeUnsignedByte(4 + rsi.message.length() + 1);
                                stream.writeDWord(rsi.id);
                                stream.writeString(rsi.message);
                                return;
                            }
                        } else if ((j == 10 || j == 13) && rsi.message.length() > 0 && !rsi.updatesEveryInput) {
                            inputString = "";
                            promptInput = "";
                            if (rsi.inputFieldListener != null)
                                rsi.inputFieldListener.accept(rsi.message);
                            inputString = "";
                            if (rsi.inputFieldSendPacket) {
                                stream.createFrame(142);
                                stream.writeUnsignedByte(4 + rsi.message.length() + 1);
                                stream.writeDWord(rsi.id);
                                stream.writeString(rsi.message);
                                return;
                            }
                        }
                    } else {
                        if (j >= 32 && j <= 122 && this.inputString.length() < 80) {
                            this.inputString = this.inputString + (char) j;
                            this.inputTaken = true;
                        }

                        if (j == 8 && this.inputString.length() > 0) {
                            this.inputString = this.inputString.substring(0, this.inputString.length() - 1);
                            this.inputTaken = true;
                        }
                        if (j == 9)
                            tabToReplyPm();
                        if ((j == 13 || j == 10) && this.inputString.length() > 0) {
                            int var10;
                            if (this.myPrivilege >= 2) {
                                if (this.inputString.equals("::clientdrop")) {
                                    this.method68(-670);
                                }

                                if (this.inputString.equals("::lag")) {
                                    this.method72((byte) 1);
                                }

                                if (this.inputString.equals("::prefetchmusic")) {
                                    for (s = 0; s < onDemandFetcher.method555(79, 2); ++s) {
                                        onDemandFetcher.method563((byte) 1, 2, s, (byte) 8);
                                    }
                                }

                                if (this.inputString.equals("::data")) {
                                    clientData = !clientData;
                                }

                                if (this.inputString.equals("::dumpitemimg")) {
                                    for (s = 0; s < 20000; ++s) {
                                        Sprite j2 = ItemDefinition.method200(s, 1, 0, 9);
                                        ItemDefinition i3 = ItemDefinition.method198(s);
                                        if (j2 != null && i3.name != null) {
                                            j2.dumpImage("directory/", "" + i3.name + (i3.certTemplateID != -1 ? " noted" : ""), j2, true);
                                        }
                                    }
                                }

                                if (this.inputString.equals("::noclip")) {
                                    for (s = 0; s < 4; ++s) {
                                        for (var10 = 1; var10 < 103; ++var10) {
                                            for (int var11 = 1; var11 < 103; ++var11) {
                                                this.collisionMaps[s].anIntArrayArray294[var10][var11] = 0;
                                            }
                                        }
                                    }
                                }
                            }

                            if (this.inputString.equals("::fpson")) {
                                fpsOn = true;
                            }

                            if (this.inputString.equals("::fpsoff")) {
                                fpsOn = false;
                            }

                            if (this.inputString.equals("::hd")) {
                                Configuration.hdTexturing = !Configuration.hdTexturing;
                            }

                            if (this.inputString.equals("::fog")) {
                                Configuration.distanceFog = !Configuration.distanceFog;
                            }

                            if (this.inputString.equals("::optab") && currentScreenMode != client.ScreenMode.FIXED) {
                                this.transparentTabArea = !this.transparentTabArea;
                            }

                            if (this.inputString.equals("::chat") && currentScreenMode != client.ScreenMode.FIXED) {
                                changeChatArea = !changeChatArea;
                            }

                            if (this.inputString.equals("::tab") && currentScreenMode != client.ScreenMode.FIXED) {
                                changeTabArea = !changeTabArea;
                            }

                            if (this.inputString.equals("::toggleroofs")) {
                                this.roofsOff = !this.roofsOff;
                            }

                            if (this.inputString.equals("::fixed")) {
                                currentScreenMode(client.ScreenMode.FIXED);
                            }

                            if (this.inputString.equals("::resize")) {
                                currentScreenMode(client.ScreenMode.RESIZABLE);
                            }

                            if (this.inputString.equals("::fullscreen") && this.myPrivilege >= 2) {
                                currentScreenMode(client.ScreenMode.FULLSCREEN);
                            }

                            if (this.inputString.startsWith("::drawdistance")) {
                                try {
                                    s = Integer.parseInt(this.inputString.replace("::drawdistance ", ""));
                                    if (s > 150 || s < 30) {
                                        this.pushMessage("Invalid draw distance value, input a value between 30 and 150.", 0, "");
                                        if (s > 150) {
                                            s = 150;
                                        }

                                        if (s < 30) {
                                            s = 30;
                                        }
                                    }

                                    Class25.farZ = s;
                                    this.pushMessage("Set view distance to " + s + "", 0, "");
                                } catch (Exception var9) {
                                    var9.printStackTrace();
                                }
                            }

                            if (this.inputString.startsWith("/")) {
                                this.inputString = "::" + this.inputString;
                            }

                            if (this.inputString.startsWith("::")) {
                                this.stream.createFrame(103);
                                this.stream.writeUnsignedByte(this.inputString.length() - 1);
                                this.stream.writeString(this.inputString.substring(2));
                            } else {
                                String var14 = this.inputString.toLowerCase();
                                if (var14.startsWith("@or1@")) {
                                    this.inputString = this.inputString.substring(5);
                                    this.pushMessage(this.inputString, 14, "");
                                    this.inputString = "";
                                    break;
                                }

                                if (var14.startsWith("@yel@")) {
                                    this.inputString = this.inputString.substring(5);
                                    this.pushMessage(this.inputString, 15, "");
                                    this.inputString = "";
                                    break;
                                }

                                if (var14.startsWith("<col=ff0000>")) {
                                    this.inputString = this.inputString.substring(5);
                                    this.pushMessage(this.inputString, 16, "");
                                    this.inputString = "";
                                    break;
                                }

                                if (var14.startsWith("<col=65280>")) {
                                    this.inputString = this.inputString.substring(5);
                                    this.pushMessage(this.inputString, 17, "");
                                    this.inputString = "";
                                    break;
                                }

                                if (var14.startsWith("@pur@")) {
                                    this.inputString = this.inputString.substring(5);
                                    this.pushMessage(this.inputString, 20, "");
                                    this.inputString = "";
                                    break;
                                }

                                if (var14.startsWith("@blu@")) {
                                    this.inputString = this.inputString.substring(5);
                                    this.pushMessage(this.inputString, 19, "");
                                    this.inputString = "";
                                    break;
                                }

                                byte[] var12;
                                if (var14.startsWith("add model")) {
                                    try {
                                        var10 = Integer.parseInt(var14.substring(10));
                                        var12 = this.GetModel(var10);
                                        if (var12 != null && var12.length > 0) {
                                            this.aClass14Array970[1].method234(var12.length, var12, (byte) 2, var10);
                                            this.pushMessage("Model: [" + var10 + "] added successfully!", 0, "");
                                        } else {
                                            this.pushMessage("Unable to find the model. " + var10, 0, "");
                                        }
                                    } catch (Exception var8) {
                                        this.pushMessage("Syntax - ::add model <path>", 0, "");
                                    }
                                }

                                if (var14.startsWith("add models")) {
                                    for (var10 = 0; var10 < '\u9c40'; ++var10) {
                                        var12 = this.GetModel(var10);
                                        if (var12 != null && var12.length > 0) {
                                            this.aClass14Array970[1].method234(var12.length, var12, (byte) 2, var10);
                                            this.pushMessage("Model: [" + var10 + "] added successfully!", 0, "");
                                        }
                                    }
                                }

                                if (var14.startsWith("dumpcfg")) {
                                    ItemDefinition.dumpCfg();
                                }

                                if (var14.startsWith("dumpitems")) {
                                    ItemDefinition.dumpItems();
                                }

                                if (var14.startsWith("dumpnpc")) {
                                    Class5.dumpNpcList();
                                }

                                if (var14.startsWith("dumpobj")) {
                                    ObjectDefinition.dumpObjectcfg();
                                }

                                if (var14.startsWith("dump")) {
                                    ;
                                }

                                byte var13 = 0;
                                byte var15 = 0;
                                if (var14.startsWith("yellow:")) {
                                    var13 = 0;
                                    this.inputString = this.inputString.substring(7);
                                } else if (var14.startsWith("red:")) {
                                    var13 = 1;
                                    this.inputString = this.inputString.substring(4);
                                } else if (var14.startsWith("green:")) {
                                    var13 = 2;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("cyan:")) {
                                    var13 = 3;
                                    this.inputString = this.inputString.substring(5);
                                } else if (var14.startsWith("purple:")) {
                                    var13 = 4;
                                    this.inputString = this.inputString.substring(7);
                                } else if (var14.startsWith("white:")) {
                                    var13 = 5;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("flash1:")) {
                                    var13 = 6;
                                    this.inputString = this.inputString.substring(7);
                                } else if (var14.startsWith("flash2:")) {
                                    var13 = 7;
                                    this.inputString = this.inputString.substring(7);
                                } else if (var14.startsWith("flash3:")) {
                                    var13 = 8;
                                    this.inputString = this.inputString.substring(7);
                                } else if (var14.startsWith("glow1:")) {
                                    var13 = 9;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("glow2:")) {
                                    var13 = 10;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("glow3:")) {
                                    var13 = 11;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("blue:")) {
                                    var13 = 12;
                                    this.inputString = this.inputString.substring(5);
                                } else if (var14.startsWith("pink:")) {
                                    var13 = 13;
                                    this.inputString = this.inputString.substring(5);
                                } else if (var14.startsWith("flash4:")) {
                                    var13 = 14;
                                    this.inputString = this.inputString.substring(7);
                                }
                                var14 = this.inputString.toLowerCase();
                                if (var14.startsWith("wave:")) {
                                    var15 = 1;
                                    this.inputString = this.inputString.substring(5);
                                } else if (var14.startsWith("wave2:")) {
                                    var15 = 2;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("shake:")) {
                                    var15 = 3;
                                    this.inputString = this.inputString.substring(6);
                                } else if (var14.startsWith("scroll:")) {
                                    var15 = 4;
                                    this.inputString = this.inputString.substring(7);
                                } else if (var14.startsWith("slide:")) {
                                    var15 = 5;
                                    this.inputString = this.inputString.substring(6);
                                }

                                this.stream.createFrame(4);
                                this.stream.writeUnsignedByte(0);
                                int j3 = this.stream.currentPosition;
                                this.stream.method425(301, var15);
                                this.stream.method425(301, var13);
                                this.aStream_834.currentPosition = 0;
                                TextInput.method526(this.inputString, this.aBoolean1277, this.aStream_834);
                                this.stream.method441(0, this.aByte1217, this.aStream_834.buffer, this.aStream_834.currentPosition);
                                this.stream.method407(this.stream.currentPosition - j3, (byte) 0);
                                this.inputString = TextInput.processText(this.inputString, 0);
                                this.inputString = Censor.method497(this.inputString, 0);
                                localPlayer.aString1506 = this.inputString;
                                localPlayer.anInt1513 = var13;
                                localPlayer.anInt1531 = var15;
                                localPlayer.textCycle = 150;
                                if (this.myPrivilege == 1) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr1@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 2) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr2@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 3) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr3@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 4) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr4@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 5) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr5@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 6) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr6@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 7) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr7@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 8) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr8@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 9) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr9@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 10) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr10@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 11) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr11@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 12) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr12@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 13) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr13@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 14) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr14@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 15) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr15@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 16) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr16@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 17) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr17@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 18) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr18@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 19) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr19@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 20) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr20@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 21) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr21@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 22) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr22@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 23) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr23@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 24) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr24@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else if (this.myPrivilege == 25) {
                                    this.pushMessage(localPlayer.aString1506, 1, "@cr25@" + this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                } else {
                                    this.pushMessage(localPlayer.aString1506, 2, this.prefixRank(localPlayer.title) + localPlayer.name + this.suffixRank(localPlayer.title));
                                }

                                if (this.publicChatMode == 2) {
                                    this.publicChatMode = 3;
                                    this.aBoolean1233 = true;
                                    this.stream.createFrame(95);
                                    this.stream.writeUnsignedByte(this.publicChatMode);
                                    this.stream.writeUnsignedByte(this.privateChatMode);
                                    this.stream.writeUnsignedByte(this.tradeMode);
                                }
                            }

                            this.inputString = "";
                            this.inputTaken = true;
                        }
                    }
                }
            }
        }

    }

    public void sendStringAsLong(String string) {
        this.stream.createFrame(60);
        this.stream.method404(5, TextClass.longForName(string));
    }

    public byte[] GetModel(int Index) {
        try {
            File e = new File("./Models/" + Index + ".gz");
            byte[] aByte = new byte[(int)e.length()];
            FileInputStream Fis = new FileInputStream(e);
            Fis.read(aByte);
            this.pushMessage("aByte = [" + aByte + "]!", 0, "");
            Fis.close();
            return aByte;
        } catch (Exception var5) {
            return null;
        }
    }

    private void buildChatAreaMenu(int j) {
        int l = 0;

        for(int i1 = 0; i1 < 500; ++i1) {
            if(this.chatMessages[i1] != null) {
                int j1 = this.chatTypes[i1];
                int k1 = 70 - l * 14 + 42 + anInt1089 + 4 + 5;
                String s = this.chatNames[i1];
                if(this.chatTypeView == 1) {
                    this.buildPublicChat(j);
                    break;
                }

                if(this.chatTypeView == 2) {
                    this.buildFriendChat(j);
                    break;
                }

                if(this.chatTypeView == 3 || this.chatTypeView == 4) {
                    this.buildDuelorTrade(j);
                    break;
                }

                if(this.chatTypeView == 5) {
                    break;
                }

                if(s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr3@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr4@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr5@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr6@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr7@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr8@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr9@")) {
                    s = s.substring(5);
                }

                if(s != null && s.startsWith("@cr10@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr11@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr12@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr13@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr14@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr15@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr16@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr17@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr18@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr19@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr20@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr21@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr22@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr23@")) {
                    s = s.substring(6);
                }

                if(s != null && s.startsWith("@cr24@")) {
                    s = s.substring(6);
                }

                if(j1 == 0) {
                    ++l;
                }

                if((j1 == 1 || j1 == 2) && (j1 == 1 || this.publicChatMode == 0 || this.publicChatMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1 && !s.equals(localPlayer.name)) {
                        if(this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse <col=FFFFFF>" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if((j1 == 3 || j1 == 7) && this.splitPrivateChat == 0 && (j1 == 7 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1) {
                        if(this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4) {
                            this.menuActionName[this.menuActionRow] = "Report abuse <col=FFFFFF>" + s;
                            this.menuActionID[this.menuActionRow] = 606;
                            ++this.menuActionRow;
                        }

                        this.menuActionName[this.menuActionRow] = "Add ignore <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 42;
                        ++this.menuActionRow;
                        this.menuActionName[this.menuActionRow] = "Add friend <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 337;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if(j1 == 4 && (this.tradeMode == 0 || this.tradeMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept trade <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 484;
                        ++this.menuActionRow;
                    }

                    ++l;
                }

                if((j1 == 5 || j1 == 6) && this.splitPrivateChat == 0 && this.privateChatMode < 2) {
                    ++l;
                }

                if(j1 == 8 && (this.tradeMode == 0 || this.tradeMode == 1 && this.method109(s))) {
                    if(j > k1 - 14 && j <= k1) {
                        this.menuActionName[this.menuActionRow] = "Accept challenge <col=FFFFFF>" + s;
                        this.menuActionID[this.menuActionRow] = 6;
                        ++this.menuActionRow;
                    }

                    ++l;
                }
            }
        }

    }

    public final void method75(int i, Widget class9) {
        int j = class9.contentType;
        if(i <= 0) {
            this.stream.writeUnsignedByte(49);
        }

        int var10;
        if(j >= 1 && j <= 100 || j >= 701 && j <= 800) {
            if(j == 1 && this.anInt900 == 0) {
                class9.message = "Loading friend list";
                class9.atActionType = 0;
            } else if(j == 1 && this.anInt900 == 1) {
                class9.message = "Connecting to friendserver";
                class9.atActionType = 0;
            } else if(j == 2 && this.anInt900 != 2) {
                class9.message = "Please wait...";
                class9.atActionType = 0;
            } else {
                var10 = this.friendsCount;
                if(this.anInt900 != 2) {
                    var10 = 0;
                }

                if(j > 700) {
                    j -= 601;
                } else {
                    --j;
                }

                if(j >= var10) {
                    class9.message = "";
                    class9.atActionType = 0;
                } else {
                    class9.message = this.friendsList[j];
                    class9.atActionType = 1;
                }
            }
        } else if(j >= 101 && j <= 200 || j >= 801 && j <= 900) {
            var10 = this.friendsCount;
            if(this.anInt900 != 2) {
                var10 = 0;
            }

            if(j > 800) {
                j -= 701;
            } else {
                j -= 101;
            }

            if(j >= var10) {
                class9.message = "";
                class9.atActionType = 0;
            } else {
                if(this.friendsNodeIDs[j] == 10) {
                    class9.message = "<col=65280>Online";
                } else if(this.friendsNodeIDs[j] == 1) {
                    class9.message = "@red@Offline";
                } else {
                    class9.message = "@red@Offline";
                }

                class9.atActionType = 1;
            }
        } else if(j == 203) {
            var10 = this.friendsCount;
            if(this.anInt900 != 2) {
                var10 = 0;
            }

            class9.scrollMax = var10 * 15 + 20;
            if(class9.scrollMax <= class9.height) {
                class9.scrollMax = class9.height + 1;
            }

        } else if(j >= 401 && j <= 500) {
            j -= 401;
            if(j == 0 && this.anInt900 == 0) {
                class9.message = "Loading ignore list";
                class9.atActionType = 0;
            } else if(j == 1 && this.anInt900 == 0) {
                class9.message = "Please wait...";
                class9.atActionType = 0;
            } else {
                var10 = this.anInt822;
                if(this.anInt900 == 0) {
                    var10 = 0;
                }

                if(j >= var10) {
                    class9.message = "";
                    class9.atActionType = 0;
                } else {
                    class9.message = TextClass.fixName(TextClass.nameForLong(this.aLongArray925[j]));
                    class9.atActionType = 1;
                }
            }
        } else if(j == 503) {
            class9.scrollMax = this.anInt822 * 15 + 20;
            if(class9.scrollMax <= class9.height) {
                class9.scrollMax = class9.height + 1;
            }

        } else {
            int animationSpeed;
            Model characterDisplay;
            int staticFrame;
            if(j == 327) {
                class9.modelRotation1 = 150;
                class9.modelRotation2 = (int)(Math.sin((double)loopCycle / 40.0D) * 256.0D) & 2047;
                if(this.aBoolean1031) {
                    for(var10 = 0; var10 < 7; ++var10) {
                        animationSpeed = this.anIntArray1065[var10];
                        if(animationSpeed >= 0 && !Class38.aClass38Array656[animationSpeed].method537((byte)2)) {
                            return;
                        }
                    }

                    this.aBoolean1031 = false;
                    Model[] var11 = new Model[7];
                    animationSpeed = 0;

                    for(int var9 = 0; var9 < 7; ++var9) {
                        staticFrame = this.anIntArray1065[var9];
                        if(staticFrame >= 0) {
                            var11[animationSpeed++] = Class38.aClass38Array656[staticFrame].method538(false);
                        }
                    }

                    characterDisplay = new Model(animationSpeed, var11, -38);

                    for(staticFrame = 0; staticFrame < 5; ++staticFrame) {
                        if(this.anIntArray990[staticFrame] != 0) {
                            characterDisplay.method476(anIntArrayArray1003[staticFrame][0], anIntArrayArray1003[staticFrame][this.anIntArray990[staticFrame]]);
                            if(staticFrame == 1) {
                                characterDisplay.method476(anIntArray1204[0], anIntArray1204[this.anIntArray990[staticFrame]]);
                            }
                        }
                    }

                    characterDisplay.method469((byte)-71);
                    characterDisplay.method470(AnimationDefinition.anims[localPlayer.anInt1511].frames[0], '\u9e5e');
                    characterDisplay.method479(64, 850, -30, -50, -30, true);
                    class9.anInt233 = 5;
                    class9.mediaID = 0;
                    Widget.method208(0, this.aBoolean994, 5, characterDisplay);
                }

            } else {
                if(j == 328) {
                    short s1 = 150;
                    animationSpeed = (int)(Math.sin((double)loopCycle / 40.0D) * 256.0D) & 2047;
                    class9.modelRotation1 = s1;
                    class9.modelRotation2 = animationSpeed;
                    if(this.aBoolean1031) {
                        characterDisplay = localPlayer.method452(0);

                        for(staticFrame = 0; staticFrame < 5; ++staticFrame) {
                            if(this.anIntArray990[staticFrame] != 0) {
                                characterDisplay.method476(anIntArrayArray1003[staticFrame][0], anIntArrayArray1003[staticFrame][this.anIntArray990[staticFrame]]);
                                if(staticFrame == 1) {
                                    characterDisplay.method476(anIntArray1204[0], anIntArray1204[this.anIntArray990[staticFrame]]);
                                }
                            }
                        }

                        staticFrame = localPlayer.anInt1511;
                        characterDisplay.method469((byte)-71);
                        characterDisplay.method470(AnimationDefinition.anims[staticFrame].frames[0], '\u9e5e');
                        class9.anInt233 = 5;
                        class9.mediaID = 0;
                        Widget.method208(0, this.aBoolean994, 5, characterDisplay);
                    }
                }

                if(j == 324) {
                    if(this.aSprite_931 == null) {
                        this.aSprite_931 = class9.disabledSprite;
                        this.aSprite_932 = class9.enabledSprite;
                    }

                    if(this.aBoolean1047) {
                        class9.disabledSprite = this.aSprite_932;
                    } else {
                        class9.disabledSprite = this.aSprite_931;
                    }
                } else if(j == 325) {
                    if(this.aSprite_931 == null) {
                        this.aSprite_931 = class9.disabledSprite;
                        this.aSprite_932 = class9.enabledSprite;
                    }

                    if(this.aBoolean1047) {
                        class9.disabledSprite = this.aSprite_931;
                    } else {
                        class9.disabledSprite = this.aSprite_932;
                    }
                } else if(j == 600) {
                    class9.message = this.reportAbuseInput;
                    if(loopCycle % 20 < 10) {
                        class9.message = class9.message + "|";
                    } else {
                        class9.message = class9.message + " ";
                    }
                } else {
                    if(j == 620 && class9.message != " " && this.myPrivilege < 1) {
                        class9.message = " ";
                    }

                    String var8;
                    if(j == 650 || j == 655) {
                        if(this.anInt1193 != 0) {
                            if(this.anInt1006 == 0) {
                                var8 = "earlier today";
                            } else if(this.anInt1006 == 1) {
                                var8 = "yesterday";
                            } else {
                                var8 = this.anInt1006 + " days ago";
                            }

                            class9.message = "You last logged in " + var8 + " from: " + signlink.dns;
                        } else {
                            class9.message = "";
                        }
                    }

                    if(j == 651) {
                        if(this.anInt1154 == 0) {
                            class9.message = "0 unread messages";
                            class9.textColor = 16776960;
                        }

                        if(this.anInt1154 == 1) {
                            class9.message = "1 unread message";
                            class9.textColor = '\uff00';
                        }

                        if(this.anInt1154 > 1) {
                            class9.message = this.anInt1154 + " unread messages";
                            class9.textColor = '\uff00';
                        }
                    }

                    if(j == 652) {
                        if(this.anInt1167 == 201) {
                            if(this.anInt1120 == 1) {
                                class9.message = "@yel@This is a non-members world: @whi@Since you are a member we";
                            } else {
                                class9.message = "";
                            }
                        } else if(this.anInt1167 == 200) {
                            class9.message = "You have not yet set any password recovery questions.";
                        } else {
                            if(this.anInt1167 == 0) {
                                var8 = "Earlier today";
                            } else if(this.anInt1167 == 1) {
                                var8 = "Yesterday";
                            } else {
                                var8 = this.anInt1167 + " days ago";
                            }

                            class9.message = var8 + " you changed your recovery questions";
                        }
                    }

                    if(j == 653) {
                        if(this.anInt1167 == 201) {
                            if(this.anInt1120 == 1) {
                                class9.message = "@whi@recommend you use a members world instead. You may use";
                            } else {
                                class9.message = "";
                            }
                        } else if(this.anInt1167 == 200) {
                            class9.message = "We strongly recommend you do so now to secure your account.";
                        } else {
                            class9.message = "If you do not remember making this change then cancel it immediately";
                        }
                    }

                    if(j == 654) {
                        if(this.anInt1167 == 201) {
                            if(this.anInt1120 == 1) {
                                class9.message = "@whi@this world but member benefits are unavailable whilst here.";
                                return;
                            }

                            class9.message = "";
                            return;
                        }

                        if(this.anInt1167 == 200) {
                            class9.message = "Do this from the \'account management\' area on our front webpage";
                            return;
                        }

                        class9.message = "Do this from the \'account management\' area on our front webpage";
                    }

                }
            }
        }
    }

    public final void method76(byte byte0) {
        if(this.splitPrivateChat != 0) {
            TextDrawingArea textDrawingArea = this.regularText;
            if(byte0 != this.aByte1274) {
                aBoolean1231 = !aBoolean1231;
            }

            int i = 0;
            if(this.anInt1104 != 0) {
                i = 1;
            }

            for(int j = 0; j < 500; ++j) {
                if(this.chatMessages[j] != null) {
                    int k = this.chatTypes[j];
                    String s = this.chatNames[j];
                    byte byte1 = 0;
                    if(s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr3@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr4@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr5@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr6@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr7@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr8@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr9@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr10@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr11@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr12@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr13@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr14@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr15@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr16@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr17@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr18@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr19@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr20@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr21@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr22@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr23@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr24@")) {
                        s = s.substring(6);
                    }

                    int j1;
                    if((k == 3 || k == 7) && (k == 7 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s))) {
                        j1 = 329 - i * 13;
                        if(currentScreenMode != client.ScreenMode.FIXED) {
                            j1 = currentGameHeight - 170 - i * 13;
                        }

                        byte k1 = 4;
                        textDrawingArea.method385(0, "From", j1, 822, k1);
                        textDrawingArea.method385('\uffff', "From", j1 - 1, 822, k1);
                        int var10 = k1 + textDrawingArea.method383(this.anInt1116, "From ");
                        if(byte1 == 1) {
                            this.ModIcons[0].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 2) {
                            this.ModIcons[1].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 3) {
                            this.ModIcons[2].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 4) {
                            this.ModIcons[3].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 5) {
                            this.ModIcons[4].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 6) {
                            this.ModIcons[7].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 7) {
                            this.ModIcons[8].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 8) {
                            this.ModIcons[9].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 9) {
                            this.ModIcons[10].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 10) {
                            this.ModIcons[11].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 11) {
                            this.ModIcons[12].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 12) {
                            this.ModIcons[13].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        if(byte1 == 14) {
                            this.ModIcons[15].drawSprite(var10, j1 - 12);
                            var10 += 14;
                        }

                        textDrawingArea.method385(0, s + ": " + this.chatMessages[j], j1, 822, var10);
                        textDrawingArea.method385('\uffff', s + ": " + this.chatMessages[j], j1 - 1, 822, var10);
                        ++i;
                        if(i >= 5) {
                            return;
                        }
                    }

                    if(k == 5 && this.privateChatMode < 2) {
                        j1 = 329 - i * 13;
                        if(currentScreenMode != client.ScreenMode.FIXED) {
                            j1 = currentGameHeight - 170 - i * 13;
                        }

                        textDrawingArea.method385(0, this.chatMessages[j], j1, 822, 4);
                        textDrawingArea.method385('\uffff', this.chatMessages[j], j1 - 1, 822, 4);
                        ++i;
                        if(i >= 5) {
                            return;
                        }
                    }

                    if(k == 6 && this.privateChatMode < 2) {
                        j1 = 329 - i * 13;
                        if(currentScreenMode != client.ScreenMode.FIXED) {
                            j1 = currentGameHeight - 170 - i * 13;
                        }

                        textDrawingArea.method385(0, "To " + s + ": " + this.chatMessages[j], j1, 822, 4);
                        textDrawingArea.method385('\uffff', "To " + s + ": " + this.chatMessages[j], j1 - 1, 822, 4);
                        ++i;
                        if(i >= 5) {
                            return;
                        }
                    }
                }
            }

        }
    }

    public final void pushMessage(String s, int i, String s1) {
        if(i == 0 && this.dialogID != -1) {
            this.aString844 = s;
            super.clickMode3 = 0;
        }

        if(this.backDialogID == -1) {
            this.inputTaken = true;
        }

        for(int j = 499; j > 0; --j) {
            this.chatTypes[j] = this.chatTypes[j - 1];
            this.chatNames[j] = this.chatNames[j - 1];
            this.chatMessages[j] = this.chatMessages[j - 1];
            this.chatRights[j] = this.chatRights[j - 1];
            this.clanTitles[j] = this.clanTitles[j - 1];
        }

        this.chatTypes[0] = i;
        this.chatNames[0] = s1;
        this.chatMessages[0] = s;
        this.chatRights[0] = this.channelRights;
        this.clanTitles[0] = this.clanTitle;
    }

    public final void method78() {
        if(super.clickMode3 == 1) {
            if(currentScreenMode != client.ScreenMode.FIXED && (currentScreenMode == client.ScreenMode.FIXED || changeTabArea)) {
                if(changeTabArea && currentGameWidth < 1000) {
                    if(super.saveClickX >= currentGameWidth - 226 && super.saveClickX <= currentGameWidth - 195 && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[0] != -1) {
                        if(tabID == 0) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 0;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 194 && super.saveClickX <= currentGameWidth - 163 && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[1] != -1) {
                        if(tabID == 1) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 1;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 162 && super.saveClickX <= currentGameWidth - 131 && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[2] != -1) {
                        if(tabID == 2) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 2;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 129 && super.saveClickX <= currentGameWidth - 98 && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[3] != -1) {
                        if(tabID == 3) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 3;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 97 && super.saveClickX <= currentGameWidth - 66 && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[4] != -1) {
                        if(tabID == 4) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 4;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 65 && super.saveClickX <= currentGameWidth - 34 && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[5] != -1) {
                        if(tabID == 5) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 5;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 33 && super.saveClickX <= currentGameWidth && super.saveClickY >= currentGameHeight - 72 && super.saveClickY < currentGameHeight - 40 && tabInterfaceIDs[6] != -1) {
                        if(tabID == 6) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 6;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 194 && super.saveClickX <= currentGameWidth - 163 && super.saveClickY >= currentGameHeight - 37 && super.saveClickY < currentGameHeight - 0 && tabInterfaceIDs[8] != -1) {
                        if(tabID == 8) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 8;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 162 && super.saveClickX <= currentGameWidth - 131 && super.saveClickY >= currentGameHeight - 37 && super.saveClickY < currentGameHeight - 0 && tabInterfaceIDs[9] != -1) {
                        if(tabID == 9) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 9;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 129 && super.saveClickX <= currentGameWidth - 98 && super.saveClickY >= currentGameHeight - 37 && super.saveClickY < currentGameHeight - 0 && tabInterfaceIDs[10] != -1) {
                        if(tabID == 7) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 7;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 97 && super.saveClickX <= currentGameWidth - 66 && super.saveClickY >= currentGameHeight - 37 && super.saveClickY < currentGameHeight - 0 && tabInterfaceIDs[11] != -1) {
                        if(tabID == 11) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 11;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 65 && super.saveClickX <= currentGameWidth - 34 && super.saveClickY >= currentGameHeight - 37 && super.saveClickY < currentGameHeight - 0 && tabInterfaceIDs[12] != -1) {
                        if(tabID == 12) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 12;
                        this.tabAreaAltered = true;
                    }

                    if(super.saveClickX >= currentGameWidth - 33 && super.saveClickX <= currentGameWidth && super.saveClickY >= currentGameHeight - 37 && super.saveClickY < currentGameHeight - 0 && tabInterfaceIDs[13] != -1) {
                        if(tabID == 13) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 13;
                        this.tabAreaAltered = true;
                    }
                } else if(changeTabArea && currentGameWidth >= 1000 && super.mouseY >= currentGameHeight - 37 && super.mouseY <= currentGameHeight) {
                    if(super.mouseX >= currentGameWidth - 417 && super.mouseX <= currentGameWidth - 386) {
                        if(tabID == 0) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 0;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 385 && super.mouseX <= currentGameWidth - 354) {
                        if(tabID == 1) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 1;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 353 && super.mouseX <= currentGameWidth - 322) {
                        if(tabID == 2) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 2;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 321 && super.mouseX <= currentGameWidth - 290) {
                        if(tabID == 3) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 3;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 289 && super.mouseX <= currentGameWidth - 258) {
                        if(tabID == 4) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 4;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 257 && super.mouseX <= currentGameWidth - 226) {
                        if(tabID == 5) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 5;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 225 && super.mouseX <= currentGameWidth - 194) {
                        if(tabID == 6) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 6;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 193 && super.mouseX <= currentGameWidth - 163) {
                        if(tabID == 8) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 8;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 162 && super.mouseX <= currentGameWidth - 131) {
                        if(tabID == 9) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 9;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 130 && super.mouseX <= currentGameWidth - 99) {
                        if(tabID == 7) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 7;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 98 && super.mouseX <= currentGameWidth - 67) {
                        if(tabID == 11) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 11;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 66 && super.mouseX <= currentGameWidth - 45) {
                        if(tabID == 12) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 12;
                        this.tabAreaAltered = true;
                    }

                    if(super.mouseX >= currentGameWidth - 31 && super.mouseX <= currentGameWidth) {
                        if(tabID == 13) {
                            showTabComponents = !showTabComponents;
                        } else {
                            showTabComponents = true;
                        }

                        tabID = 13;
                        this.tabAreaAltered = true;
                    }
                }
            } else {
                int xOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 765;
                int yOffset = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 503;

                for(int i = 0; i < this.tabClickX.length; ++i) {
                    if(super.mouseX >= this.tabClickStart[i] + xOffset && super.mouseX <= this.tabClickStart[i] + this.tabClickX[i] + xOffset && super.mouseY >= this.tabClickY[i] + yOffset && super.mouseY < this.tabClickY[i] + 37 + yOffset && tabInterfaceIDs[i] != -1) {
                        tabID = i;
                        this.tabAreaAltered = true;
                        break;
                    }
                }
            }
        }

    }

    public final void resetImageProducers2(int i) {
        if(aRSImageProducer_1166 == null) {
            this.nullLoader();
            super.aRSImageProducer_13 = null;
            this.aRSImageProducer_1107 = null;
            this.aRSImageProducer_1108 = null;
            this.aRSImageProducer_1109 = null;
            this.aRSImageProducer_1110 = null;
            this.aRSImageProducer_1111 = null;
            this.aRSImageProducer_1112 = null;
            this.aRSImageProducer_1113 = null;
            this.aRSImageProducer_1114 = null;
            this.aRSImageProducer_1115 = null;
            aRSImageProducer_1166 = new RSImageProducer(519, 165);
            this.aRSImageProducer_1164 = new RSImageProducer(249, 168);
            DrawingArea.setAllPixelsToZero();
            this.gameframe[29].drawSprite(0, 0);
            aRSImageProducer_1163 = new RSImageProducer(249, 335);
            aRSImageProducer_1165 = new RSImageProducer(screenAreaWidth, screenAreaHeight);
            DrawingArea.setAllPixelsToZero();
            this.aRSImageProducer_1125 = new RSImageProducer(249, 45);
            this.aBoolean1255 = true;
        }
    }

    public final String method80(boolean flag) {
        loggedIn &= flag;
        return signlink.mainapp != null?signlink.mainapp.getDocumentBase().getHost().toLowerCase():(super.gameFrame != null?"":super.getDocumentBase().getHost().toLowerCase());
    }

    public final void method81(Sprite sprite, int i, int j, int k) {
        int l = k * k + j * j;
        if(i >= 0) {
            this.method6();
        }

        if(l > 4225 && l < 90000) {
            int i1 = this.anInt1185 + this.anInt1209 & 2047;
            int j1 = Model.SINE[i1];
            int k1 = Model.COSINE[i1];
            j1 = j1 * 256 / (this.anInt1170 + 256);
            k1 = k1 * 256 / (this.anInt1170 + 256);
            int l1 = j * j1 + k * k1 >> 16;
            int i2 = j * k1 - k * j1 >> 16;
            double d = Math.atan2((double)l1, (double)i2);
            int j2 = (int)(Math.sin(d) * 63.0D);
            int var14 = (int)(Math.cos(d) * 57.0D);
        } else {
            this.method141(sprite, k, j, false);
        }
    }

    static boolean centerMainScreenInterface() {
        return currentGameWidth <= 900 || currentGameHeight <= 650;
    }

    public boolean mouseInRegion(int x1, int y1, int x2, int y2) {
        return super.mouseX >= x1 && super.mouseX <= x2 && super.mouseY >= y1 && super.mouseY <= y2;
    }

    public boolean mouseMapPosition() {
        return super.mouseX < currentGameWidth - 21 || super.mouseX > currentGameWidth || super.mouseY < 0 || super.mouseY > 21;
    }

    public boolean getMousePositions() {
        if(this.mouseInRegion(currentGameWidth - (currentGameWidth <= 1000?240:420), currentGameHeight - (currentGameWidth <= 1000?90:37), currentGameWidth, currentGameHeight)) {
            return false;
        } else {
            if(showChatComponents) {
                if(changeChatArea) {
                    if(super.mouseX > 0 && super.mouseX < 494 && super.mouseY > currentGameHeight - 175 && super.mouseY < currentGameHeight) {
                        return true;
                    }

                    if(super.mouseX > 494 && super.mouseX < 515 && super.mouseY > currentGameHeight - 175 && super.mouseY < currentGameHeight) {
                        return false;
                    }
                } else if(!changeChatArea && super.mouseX > 0 && super.mouseX < 519 && super.mouseY > currentGameHeight - 175 && super.mouseY < currentGameHeight) {
                    return false;
                }
            }

            if(this.mouseInRegion(currentGameWidth - 216, 0, currentGameWidth, 172)) {
                return false;
            } else if(!changeTabArea) {
                return super.mouseX > 0 && super.mouseY > 0 && super.mouseY < currentGameWidth && super.mouseY < currentGameHeight?super.mouseX < currentGameWidth - 242 || super.mouseY < currentGameHeight - 335:false;
            } else {
                if(showTabComponents) {
                    if(currentGameWidth > 1000) {
                        if(super.mouseX >= currentGameWidth - 420 && super.mouseX <= currentGameWidth && super.mouseY >= currentGameHeight - 37 && super.mouseY <= currentGameHeight || super.mouseX > currentGameWidth - 225 && super.mouseX < currentGameWidth && super.mouseY > currentGameHeight - 37 - 274 && super.mouseY < currentGameHeight) {
                            return false;
                        }
                    } else if(super.mouseX >= currentGameWidth - 210 && super.mouseX <= currentGameWidth && super.mouseY >= currentGameHeight - 74 && super.mouseY <= currentGameHeight || super.mouseX > currentGameWidth - 225 && super.mouseX < currentGameWidth && super.mouseY > currentGameHeight - 74 - 274 && super.mouseY < currentGameHeight) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    private void buildSplitPrivateChatMenu() {
        if(this.splitPrivateChat != 0) {
            boolean listPosition = false;
            boolean update = this.anInt1104 != 0;
            boolean broadcast = BroadcastManager.isDisplayed();
            int var10 = update && broadcast?2:(!broadcast && !update?0:1);
            boolean xPosition = false;
            boolean yPosition = false;

            for(int j = 0; j < 100; ++j) {
                if(this.chatMessages[j] != null) {
                    int k = this.chatTypes[j];
                    String s = this.chatNames[j];
                    if(s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr3@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr4@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr5@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr6@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr7@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr8@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr9@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr10@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr11@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr12@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr13@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr14@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr15@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr16@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr17@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr18@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr19@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr20@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr21@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr22@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr23@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr24@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr25@")) {
                        s = s.substring(6);
                    }

                    if((k == 3 || k == 7) && (k == 7 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s))) {
                        int var11 = currentScreenMode == client.ScreenMode.FIXED?4:0;
                        int var12 = 329 - var10 * 13;
                        if(currentScreenMode != client.ScreenMode.FIXED) {
                            var12 = currentGameHeight - 170 - var10 * 13;
                        }

                        if(super.mouseX > 4 && super.mouseY - var11 > var12 - 10 && super.mouseY - var11 <= var12 + 3) {
                            int i1 = this.regularText.getTextWidth("From:  " + s + this.chatMessages[j]) + 25;
                            if(i1 > 450) {
                                i1 = 450;
                            }

                            if(super.mouseX < 4 + i1) {
                                if(this.myPrivilege == 1 || this.myPrivilege == 2 || this.myPrivilege == 9 || this.myPrivilege == 10 || this.myPrivilege == 4) {
                                    this.menuActionName[this.menuActionRow] = "Report abuse <col=ffffff>" + s;
                                    this.menuActionID[this.menuActionRow] = 2606;
                                    ++this.menuActionRow;
                                }

                                this.menuActionName[this.menuActionRow] = "Add ignore <col=ffffff>" + s;
                                this.menuActionID[this.menuActionRow] = 2042;
                                ++this.menuActionRow;
                                this.menuActionName[this.menuActionRow] = "Add friend <col=ffffff>" + s;
                                this.menuActionID[this.menuActionRow] = 2337;
                                ++this.menuActionRow;
                            }
                        }

                        ++var10;
                        if(var10 >= 5) {
                            return;
                        }
                    }

                    if((k == 5 || k == 6) && this.privateChatMode < 2) {
                        ++var10;
                        if(var10 >= 5) {
                            return;
                        }
                    }
                }
            }
        }

    }

    public final void processRightClick(int i) {
        if(this.anInt1086 == 0) {
            this.menuActionName[0] = "Cancel";
            this.menuActionID[0] = 1107;
            this.menuActionRow = 1;
            if(showChatComponents) {
                this.buildSplitPrivateChatMenu();
            }

            this.buildBroadcasts();
            this.anInt886 = 0;
            if(currentScreenMode == client.ScreenMode.FIXED) {
                if(super.mouseX > 4 && super.mouseY > 4 && super.mouseX < 516 && super.mouseY < 338) {
                    if(openInterfaceID != -1) {
                        this.buildInterfaceMenu(4, 13037, Widget.interfaceCache[openInterfaceID], super.mouseX, 4, super.mouseY, 0);
                    } else {
                        this.build3dScreenMenu();
                    }
                }
            } else if(currentScreenMode != client.ScreenMode.FIXED && this.getMousePositions()) {
                if(super.mouseX > currentGameWidth / 2 - 356 && super.mouseY > currentGameHeight / 2 - 230 && super.mouseX < currentGameWidth / 2 + 356 && super.mouseY < currentGameHeight / 2 + 230 && openInterfaceID != -1) {
                    this.buildInterfaceMenu(currentGameWidth / 2 - 356, 13037, Widget.interfaceCache[openInterfaceID], super.mouseX, currentGameHeight / 2 - 230, super.mouseY, 0);
                } else {
                    this.build3dScreenMenu();
                }
            }

            if(this.anInt886 != this.anInt1026) {
                this.anInt1026 = this.anInt886;
            }

            this.anInt886 = 0;
            int flag;
            int j;
            if(!changeTabArea) {
                flag = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 503;
                j = currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 765;
                if(super.mouseX > 548 + j && super.mouseX < 740 + j && super.mouseY > 207 + flag && super.mouseY < 468 + flag) {
                    if(this.invOverlayInterfaceID != -1) {
                        this.buildInterfaceMenu(548 + j, 13037, Widget.interfaceCache[this.invOverlayInterfaceID], super.mouseX, 207 + flag, super.mouseY, 0);
                    } else if(tabInterfaceIDs[tabID] != -1) {
                        this.buildInterfaceMenu(548 + j, 13037, Widget.interfaceCache[tabInterfaceIDs[tabID]], super.mouseX, 207 + flag, super.mouseY, 0);
                    }
                }
            } else if(changeTabArea) {
                flag = currentGameWidth >= 1000?37:74;
                if(super.mouseX > currentGameWidth - 197 && super.mouseY > currentGameHeight - flag - 267 && super.mouseX < currentGameWidth - 7 && super.mouseY < currentGameHeight - flag - 7 && showTabComponents) {
                    if(this.invOverlayInterfaceID != -1) {
                        this.buildInterfaceMenu(currentGameWidth - 197, 13037, Widget.interfaceCache[this.invOverlayInterfaceID], super.mouseX, currentGameHeight - flag - 267, super.mouseY, 0);
                    } else if(tabInterfaceIDs[tabID] != -1) {
                        this.buildInterfaceMenu(currentGameWidth - 197, 13037, Widget.interfaceCache[tabInterfaceIDs[tabID]], super.mouseX, currentGameHeight - flag - 267, super.mouseY, 0);
                    }
                }
            }

            if(this.anInt886 != this.anInt1048) {
                this.tabAreaAltered = true;
                this.anInt1048 = this.anInt886;
            }

            this.anInt886 = 0;
            if(super.mouseX > 0 && super.mouseY > (currentScreenMode == client.ScreenMode.FIXED?338:currentGameHeight - 165) && super.mouseX < 490 && super.mouseY < (currentScreenMode == client.ScreenMode.FIXED?463:currentGameHeight - 40) && showChatComponents) {
                if(this.backDialogID != -1) {
                    this.buildInterfaceMenu(20, 13037, Widget.interfaceCache[this.backDialogID], super.mouseX, currentScreenMode == client.ScreenMode.FIXED?358:currentGameHeight - 145, super.mouseY, 0);
                } else if(super.mouseY < (currentScreenMode == client.ScreenMode.FIXED?463:currentGameHeight - 40) && super.mouseX < 490) {
                    this.buildChatAreaMenu(super.mouseY - (currentScreenMode == client.ScreenMode.FIXED?338:currentGameHeight - 165));
                }
            }

            if(this.backDialogID != -1 && this.anInt886 != this.anInt1039) {
                this.inputTaken = true;
                this.anInt1039 = this.anInt886;
            }

            this.rightClickChatButtons();
            this.processExtraMenus();
            boolean var8 = false;
            this.packetSize += i;

            while(!var8) {
                var8 = true;

                for(j = 0; j < this.menuActionRow - 1; ++j) {
                    if(this.menuActionID[j] < 1000 && this.menuActionID[j + 1] > 1000) {
                        String s = this.menuActionName[j];
                        this.menuActionName[j] = this.menuActionName[j + 1];
                        this.menuActionName[j + 1] = s;
                        int k = this.menuActionID[j];
                        this.menuActionID[j] = this.menuActionID[j + 1];
                        this.menuActionID[j + 1] = k;
                        k = this.menuActionCmd2[j];
                        this.menuActionCmd2[j] = this.menuActionCmd2[j + 1];
                        this.menuActionCmd2[j + 1] = k;
                        k = this.menuActionCmd3[j];
                        this.menuActionCmd3[j] = this.menuActionCmd3[j + 1];
                        this.menuActionCmd3[j + 1] = k;
                        long k2 = this.menuActionCmd1[j];
                        this.menuActionCmd1[j] = this.menuActionCmd1[j + 1];
                        this.menuActionCmd1[j + 1] = k2;
                        var8 = false;
                    }
                }
            }

        }
    }
    public static String getUserCountry() {
        // Get the default locale for the system
        Locale locale = Locale.getDefault();

        // Retrieve the display country (e.g., "United States")
        return locale.getDisplayCountry();
    }
    public final int method83(boolean flag, int i, int j, int k) {
        if(!flag) {
            this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
        }

        int l = 256 - k;
        return ((i & 16711935) * l + (j & 16711935) * k & -16711936) + ((i & '\uff00') * l + (j & '\uff00') * k & 16711680) >> 8;
    }

    public final void method84(String s, String s1, boolean flag) {
        signlink.errorname = s;

        try {
            if(!flag) {
                this.aString1266 = "@whi@Connecting to";
                this.aString1267 = "@whi@Godzhell Reborn.";
                this.method135(true, false);
            }

            this.socketStream = new Class24(this, -978, this.method19(29432 + ondemand_offset));
            long e = TextClass.longForName(s);
            int i = (int)(e >> 16 & 31L);
            this.stream.currentPosition = 0;
            this.stream.writeUnsignedByte(14);
            this.stream.writeUnsignedByte(i);
            this.socketStream.queueBytes(2, 0, this.stream.buffer, 0);

            int responseCode;
            for(responseCode = 0; responseCode < 8; ++responseCode) {
                this.socketStream.read();
            }

            responseCode = this.socketStream.read();
            int i1 = responseCode;
            int i3;
            if(responseCode == 0) {
                this.socketStream.flushInputStream(this.in.buffer, 0, 8);
                this.in.currentPosition = 0;
                this.aLong1215 = this.in.readQWord(-35089);
                int[] k1 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(this.aLong1215 >> 32), (int)this.aLong1215};
                this.stream.currentPosition = 0;
                this.stream.writeUnsignedByte(10);
                this.stream.writeDWord(k1[0]);
                this.stream.writeDWord(k1[1]);
                this.stream.writeDWord(k1[2]);
                this.stream.writeDWord(k1[3]);
                this.stream.writeDWord((int)signlink.uid);
                this.stream.writeString(s);
                this.stream.writeString(s1);
                this.stream.writeString(this.macAddress);
                this.stream.writeString(FingerPrint.getFingerprint());
                stream.writeString(getUserCountry());
                this.stream.doKeys(aBigInteger1032, aBigInteger856, (byte)0);
                this.aStream_847.currentPosition = 0;
                if(flag) {
                    this.aStream_847.writeUnsignedByte(18);
                } else {
                    this.aStream_847.writeUnsignedByte(16);
                }

                this.aStream_847.writeUnsignedByte(this.stream.currentPosition + 36 + 1 + 1 + 2);
                this.aStream_847.writeUnsignedByte(255);
                this.aStream_847.writeWord(317);
                this.aStream_847.writeUnsignedByte(lowMemory?1:0);

                for(i3 = 0; i3 < 9; ++i3) {
                    this.aStream_847.writeDWord(this.anIntArray1090[i3]);
                }

                this.aStream_847.writeBytes(this.stream.buffer, this.stream.currentPosition, true, 0);
                this.stream.encryption = new ISAACRandomGen(k1);

                for(i3 = 0; i3 < 4; ++i3) {
                    k1[i3] += 50;
                }

                this.aISAACRandomGen_1000 = new ISAACRandomGen(k1);
                this.socketStream.queueBytes(this.aStream_847.currentPosition, 0, this.aStream_847.buffer, 0);
                responseCode = this.socketStream.read();
            }

            if(responseCode == 1) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception var12) {
                    ;
                }

                this.method84(s, s1, flag);
                return;
            }

            int var17;
            if(responseCode == 2) {
                this.myPrivilege = this.socketStream.read();
                aBoolean1205 = this.socketStream.read() == 1;
                this.currentSkill = -1;
                this.aLong1220 = 0L;
                this.anInt1022 = 0;
                signlink.midiplay = false;
                if (signlink.music != null) {
                    signlink.music.stop();
                }
                this.aMouseDetection_879.coordsIndex = 0;
                super.aBoolean17 = true;
                this.aBoolean954 = true;
                loggedIn = true;
                this.stream.currentPosition = 0;
                this.in.currentPosition = 0;
                this.packet = -1;
                this.anInt841 = -1;
                this.anInt842 = -1;
                this.anInt843 = -1;
                this.packetSize = 0;
                this.anInt1009 = 0;
                this.anInt1104 = 0;
                this.anInt1011 = 0;
                this.hintType = 0;
                this.menuActionRow = 0;
                this.menuOpen = false;
                super.anInt18 = 0;

                for(var17 = 0; var17 < 100; ++var17) {
                    this.chatMessages[var17] = null;
                }

                this.anInt1282 = 0;
                this.anInt1136 = 0;
                this.anInt1023 = 0;
                this.currentSound = 0;
                this.anInt1278 = (int)(Math.random() * 100.0D) - 50;
                this.anInt1131 = (int)(Math.random() * 110.0D) - 55;
                this.anInt896 = (int)(Math.random() * 80.0D) - 40;
                this.anInt1209 = (int)(Math.random() * 120.0D) - 60;
                this.anInt1170 = (int)(Math.random() * 30.0D) - 20;
                this.anInt1185 = (int)(Math.random() * 20.0D) - 10 & 2047;
                this.anInt1021 = 0;
                this.anInt985 = -1;
                this.anInt1261 = 0;
                this.anInt1262 = 0;
                this.anInt891 = 0;
                this.npcCount = 0;

                for(var17 = 0; var17 < this.anInt888; ++var17) {
                    this.players[var17] = null;
                    this.aStreamArray895[var17] = null;
                }

                for(var17 = 0; var17 < 16384; ++var17) {
                    this.npcs[var17] = null;
                }

                localPlayer = this.players[this.maxPlayerCount] = new Player();
                this.aDoubleEndedQueue_1013.method256();
                this.aDoubleEndedQueue_1056.method256();

                for(var17 = 0; var17 < 4; ++var17) {
                    for(i3 = 0; i3 < 104; ++i3) {
                        for(int k3 = 0; k3 < 104; ++k3) {
                            this.aDoubleEndedQueueArrayArrayArray827[var17][i3][k3] = null;
                        }
                    }
                }

                this.aDoubleEndedQueue_1179 = new DoubleEndedQueue(169);
                this.anInt900 = 0;
                this.friendsCount = 0;
                this.dialogID = -1;
                this.backDialogID = -1;
                openInterfaceID = -1;
                this.invOverlayInterfaceID = -1;
                this.openWalkableInterface = -1;
                this.aBoolean1149 = false;
                tabID = 3;
                this.inputDialogState = 0;
                this.menuOpen = false;
                this.messagePromptRaised = false;
                this.aString844 = null;
                this.anInt1055 = 0;
                this.anInt1054 = -1;
                this.aBoolean1047 = true;
                this.method45(0);

                for(var17 = 0; var17 < 5; ++var17) {
                    this.anIntArray990[var17] = 0;
                }

                for(var17 = 0; var17 < 5; ++var17) {
                    this.aStringArray1127[var17] = null;
                    this.aBooleanArray1128[var17] = false;
                }

                anInt1175 = 0;
                anInt1134 = 0;
                anInt986 = 0;
                anInt1288 = 0;
                anInt924 = 0;
                anInt1188 = 0;
                anInt1155 = 0;
                anInt1226 = 0;
                anInt941 = 0;
                anInt1260 = 0;
                this.resetImageProducers2(1);
                return;
            }

            if(responseCode == 3) {
                this.aString1266 = "";
                this.aString1267 = "@whi@Invalid username or password.";
                return;
            }

            if(responseCode == 4) {
                this.aString1266 = "@whi@You have been banned.";
                this.aString1267 = "@whi@ Message on discord for details.";
                return;
            }

            if(responseCode == 5) {
                this.aString1266 = "@lre@Your account is already logged in.";
                this.aString1267 = "@lre@Try again in 60 secs...";
                return;
            }

            if(responseCode == 6) {
                this.aString1266 = "@gre@Server has been updated!";
                this.aString1267 = "@gre@Please reload this page.";
                return;
            }

            if(responseCode == 7) {
                this.aString1266 = "@gre@This world is full.";
                this.aString1267 = "@gre@Please use a different server.";
                return;
            }

            if(responseCode == 8) {
                this.aString1266 = "@blu@Unable to connect.";
                this.aString1267 = "@blu@Login server offline.";
                return;
            }

            if(responseCode == 9) {
                this.aString1266 = "@blu@Login limit exceeded.";
                this.aString1267 = "@blu@Too many connections from your address.";
                return;
            }

            if(responseCode == 10) {
                this.aString1266 = "@blu@Unable to connect.";
                this.aString1267 = "@blu@Bad session id.";
                return;
            }

            if(responseCode == 11) {
                this.aString1266 = "@red@Login server rejected session.";
                this.aString1267 = "@lre@Please try again.";
                return;
            }

            if(responseCode == 12) {
                this.aString1266 = "@gre@You need a members account to login to this world.";
                this.aString1267 = "@gre@Please subscribe, or use a different world.";
                return;
            }

            if(responseCode == 13) {
                this.aString1266 = "@blu@Could not complete login.";
                this.aString1267 = "@blu@Please try using a different world.";
                return;
            }

            if(responseCode == 14) {
                this.aString1266 = "<col=65280>The server is being updated.";
                this.aString1267 = "<col=65280>Please wait 1 minute and try again.";
                return;
            }

            if(responseCode == 15) {
                loggedIn = true;
                this.stream.currentPosition = 0;
                this.in.currentPosition = 0;
                this.packet = -1;
                this.anInt841 = -1;
                this.anInt842 = -1;
                this.anInt843 = -1;
                this.packetSize = 0;
                this.anInt1009 = 0;
                this.anInt1104 = 0;
                this.menuActionRow = 0;
                this.menuOpen = false;
                this.aLong824 = System.currentTimeMillis();
                return;
            }

            if(responseCode == 16) {
                this.aString1266 = "@blu@Login attempts exceeded.";
                this.aString1267 = "@blu@Please wait 1 minute and try again.";
                return;
            }

            if(responseCode == 17) {
                this.aString1266 = "<col=65280>You are standing in a members-only area.";
                this.aString1267 = "<col=65280>To play on this world move to a free area first";
                return;
            }

            if(responseCode == 20) {
                this.aString1266 = "@blu@Invalid loginserver requested";
                this.aString1267 = "@blu@Please try using a different world.";
                return;
            }

            if(responseCode != 21) {
                if(responseCode == 22) {
                    this.aString1266 = "@blu@You not in the Private Beta.";
                    this.aString1267 = "@blu@Please apply on the discord.";
                    return;
                }

                if(responseCode == 23) {
                    this.aString1266 = "@whi@You have been ip banned.";
                    this.aString1267 = "@whi@ Message on discord for details.";
                    return;
                }

                if(responseCode == 24) {
                    this.aString1266 = "@whi@You have been mac banned.";
                    this.aString1267 = "@whi@Message on discord for details.";
                    return;
                }

                if(responseCode == 25) {
                    this.aString1266 = "@blu@Client has been updated,";
                    this.aString1267 = "@blu@Redownload the client.";
                    return;
                }
                if(responseCode == 26) {
                    this.aString1266 = "@red@VPN Detected!";
                    this.aString1267 = "@red@Please turn off your VPN to continue.";
                    return;
                }
                if(responseCode == -1) {
                    if(i1 == 0) {
                        if(this.anInt1038 < 2) {
                            try {
                                Thread.sleep(2000L);
                            } catch (Exception var14) {
                                ;
                            }

                            ++this.anInt1038;
                            this.method84(s, s1, flag);
                            return;
                        }

                        this.aString1266 = "@blu@No response from loginserver";
                        this.aString1267 = "@blu@Please wait 1 minute and try again.";
                        return;
                    }

                    this.aString1266 = "@blu@No response from server";
                    this.aString1267 = "@blu@Please try using a different world.";
                    return;
                }

                System.out.println("response:" + responseCode);
                this.aString1266 = "@blu@Unexpected server response";
                this.aString1267 = "@blu@Please try using a different world.";
                return;
            }

            for(var17 = this.socketStream.read(); var17 >= 0; --var17) {
                this.aString1266 = "<col=65280>You have only just left another world";
                this.aString1267 = "<col=65280>Your profile will be transferred in: " + var17 + " seconds";
                this.method135(true, false);

                try {
                    Thread.sleep(1000L);
                } catch (Exception var13) {
                    ;
                }
            }

            this.method84(s, s1, flag);
            return;
        } catch (IOException var15) {
            this.aString1266 = "";
        } catch (Exception var16) {
            var16.printStackTrace();
        }

        this.aString1267 = "@blu@Error Connecting to Server.";
    }

    public final boolean doWalkTo(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, boolean flag, int k2) {
        byte byte0 = 104;
        byte byte1 = 104;

        int j3;
        int k3;
        for(j3 = 0; j3 < byte0; ++j3) {
            for(k3 = 0; k3 < byte1; ++k3) {
                this.anIntArrayArray901[j3][k3] = 0;
                this.anIntArrayArray825[j3][k3] = 99999999;
            }
        }

        j3 = j2;
        k3 = j1;
        this.anIntArrayArray901[j2][j1] = 99;
        this.anIntArrayArray825[j2][j1] = 0;
        byte l3 = 0;
        int i4 = 0;
        this.anIntArray1280[l3] = j2;
        int var27 = l3 + 1;
        this.anIntArray1281[l3] = j1;
        boolean flag1 = false;
        int j4 = this.anIntArray1280.length;
        int[][] ai = this.collisionMaps[this.anInt918].anIntArrayArray294;

        int l5;
        while(i4 != var27) {
            j3 = this.anIntArray1280[i4];
            k3 = this.anIntArray1281[i4];
            i4 = (i4 + 1) % j4;
            if(j3 == k2 && k3 == i2) {
                flag1 = true;
                break;
            }

            if(i1 != 0) {
                if((i1 < 5 || i1 == 10) && this.collisionMaps[this.anInt918].method219(k2, j3, k3, 0, j, i1 - 1, i2)) {
                    flag1 = true;
                    break;
                }

                if(i1 < 10 && this.collisionMaps[this.anInt918].method220(k2, i2, k3, i1 - 1, j, j3, 0)) {
                    flag1 = true;
                    break;
                }
            }

            if(k1 != 0 && k != 0 && this.collisionMaps[this.anInt918].method221((byte)1, i2, k2, j3, k, l1, k1, k3)) {
                flag1 = true;
                break;
            }

            l5 = this.anIntArrayArray825[j3][k3] + 1;
            if(j3 > 0 && this.anIntArrayArray901[j3 - 1][k3] == 0 && (ai[j3 - 1][k3] & 19398920) == 0) {
                this.anIntArray1280[var27] = j3 - 1;
                this.anIntArray1281[var27] = k3;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 - 1][k3] = 2;
                this.anIntArrayArray825[j3 - 1][k3] = l5;
            }

            if(j3 < byte0 - 1 && this.anIntArrayArray901[j3 + 1][k3] == 0 && (ai[j3 + 1][k3] & 19399040) == 0) {
                this.anIntArray1280[var27] = j3 + 1;
                this.anIntArray1281[var27] = k3;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 + 1][k3] = 8;
                this.anIntArrayArray825[j3 + 1][k3] = l5;
            }

            if(k3 > 0 && this.anIntArrayArray901[j3][k3 - 1] == 0 && (ai[j3][k3 - 1] & 19398914) == 0) {
                this.anIntArray1280[var27] = j3;
                this.anIntArray1281[var27] = k3 - 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3][k3 - 1] = 1;
                this.anIntArrayArray825[j3][k3 - 1] = l5;
            }

            if(k3 < byte1 - 1 && this.anIntArrayArray901[j3][k3 + 1] == 0 && (ai[j3][k3 + 1] & 19398944) == 0) {
                this.anIntArray1280[var27] = j3;
                this.anIntArray1281[var27] = k3 + 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3][k3 + 1] = 4;
                this.anIntArrayArray825[j3][k3 + 1] = l5;
            }

            if(j3 > 0 && k3 > 0 && this.anIntArrayArray901[j3 - 1][k3 - 1] == 0 && (ai[j3 - 1][k3 - 1] & 19398926) == 0 && (ai[j3 - 1][k3] & 19398920) == 0 && (ai[j3][k3 - 1] & 19398914) == 0) {
                this.anIntArray1280[var27] = j3 - 1;
                this.anIntArray1281[var27] = k3 - 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 - 1][k3 - 1] = 3;
                this.anIntArrayArray825[j3 - 1][k3 - 1] = l5;
            }

            if(j3 < byte0 - 1 && k3 > 0 && this.anIntArrayArray901[j3 + 1][k3 - 1] == 0 && (ai[j3 + 1][k3 - 1] & 19399043) == 0 && (ai[j3 + 1][k3] & 19399040) == 0 && (ai[j3][k3 - 1] & 19398914) == 0) {
                this.anIntArray1280[var27] = j3 + 1;
                this.anIntArray1281[var27] = k3 - 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 + 1][k3 - 1] = 9;
                this.anIntArrayArray825[j3 + 1][k3 - 1] = l5;
            }

            if(j3 > 0 && k3 < byte1 - 1 && this.anIntArrayArray901[j3 - 1][k3 + 1] == 0 && (ai[j3 - 1][k3 + 1] & 19398968) == 0 && (ai[j3 - 1][k3] & 19398920) == 0 && (ai[j3][k3 + 1] & 19398944) == 0) {
                this.anIntArray1280[var27] = j3 - 1;
                this.anIntArray1281[var27] = k3 + 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 - 1][k3 + 1] = 6;
                this.anIntArrayArray825[j3 - 1][k3 + 1] = l5;
            }

            if(j3 < byte0 - 1 && k3 < byte1 - 1 && this.anIntArrayArray901[j3 + 1][k3 + 1] == 0 && (ai[j3 + 1][k3 + 1] & 19399136) == 0 && (ai[j3 + 1][k3] & 19399040) == 0 && (ai[j3][k3 + 1] & 19398944) == 0) {
                this.anIntArray1280[var27] = j3 + 1;
                this.anIntArray1281[var27] = k3 + 1;
                var27 = (var27 + 1) % j4;
                this.anIntArrayArray901[j3 + 1][k3 + 1] = 12;
                this.anIntArrayArray825[j3 + 1][k3 + 1] = l5;
            }
        }

        this.anInt1264 = 0;
        int k4;
        int k6;
        int i7;
        if(!flag1) {
            if(flag) {
                l5 = 100;

                for(k4 = 1; k4 < 2; ++k4) {
                    for(k6 = k2 - k4; k6 <= k2 + k4; ++k6) {
                        for(i7 = i2 - k4; i7 <= i2 + k4; ++i7) {
                            if(k6 >= 0 && i7 >= 0 && k6 < 104 && i7 < 104 && this.anIntArrayArray825[k6][i7] < l5) {
                                l5 = this.anIntArrayArray825[k6][i7];
                                j3 = k6;
                                k3 = i7;
                                this.anInt1264 = 1;
                                flag1 = true;
                            }
                        }
                    }

                    if(flag1) {
                        break;
                    }
                }
            }

            if(!flag1) {
                return false;
            }
        }

        byte var28 = 0;
        this.anIntArray1280[var28] = j3;
        i4 = var28 + 1;
        this.anIntArray1281[var28] = k3;
        if(l != -11308) {
            for(l5 = 1; l5 > 0; ++l5) {
                ;
            }
        }

        for(k4 = l5 = this.anIntArrayArray901[j3][k3]; j3 != j2 || k3 != j1; k4 = this.anIntArrayArray901[j3][k3]) {
            if(k4 != l5) {
                l5 = k4;
                this.anIntArray1280[i4] = j3;
                this.anIntArray1281[i4++] = k3;
            }

            if((k4 & 2) != 0) {
                ++j3;
            } else if((k4 & 8) != 0) {
                --j3;
            }

            if((k4 & 1) != 0) {
                ++k3;
            } else if((k4 & 4) != 0) {
                --k3;
            }
        }

        if(i4 <= 0) {
            return i != 1;
        } else {
            k4 = i4;
            if(i4 > 25) {
                k4 = 25;
            }

            --i4;
            k6 = this.anIntArray1280[i4];
            i7 = this.anIntArray1281[i4];
            anInt1288 += k4;
            if(anInt1288 >= 92) {
                this.stream.createFrame(36);
                this.stream.writeDWord(0);
                anInt1288 = 0;
            }

            if(i == 0) {
                this.stream.createFrame(164);
                this.stream.writeUnsignedByte(k4 + k4 + 3);
            }

            if(i == 1) {
                this.stream.createFrame(248);
                this.stream.writeUnsignedByte(k4 + k4 + 3 + 14);
            }

            if(i == 2) {
                this.stream.createFrame(98);
                this.stream.writeUnsignedByte(k4 + k4 + 3);
            }

            this.stream.method433(0, k6 + this.baseX);
            this.anInt1261 = this.anIntArray1280[0];
            this.anInt1262 = this.anIntArray1281[0];

            for(int j7 = 1; j7 < k4; ++j7) {
                --i4;
                this.stream.writeUnsignedByte(this.anIntArray1280[i4] - k6);
                this.stream.writeUnsignedByte(this.anIntArray1281[i4] - i7);
            }

            this.stream.method431(true, i7 + this.baseY);
            this.stream.method424(super.anIntArray30[5] != 1?0:1, 0);
            return true;
        }
    }

    private final void updateNpcState(int i, Stream stream, boolean flag) {
        for(int j = 0; j < this.anInt893; ++j) {
            int k = this.anIntArray894[j];
            Npc npc = this.npcs[k];
            int l = stream.readUnsignedShort();
            int l1;
            int k2;
            if((l & 16) != 0) {
                l1 = stream.method434((byte)108);
                if(l1 == '\uffff') {
                    l1 = -1;
                }

                k2 = stream.readUnsignedByte();
                if(l1 == npc.primaryanim && l1 != -1) {
                    int l2 = AnimationDefinition.anims[l1].replayMode;
                    if(l2 == 1) {
                        npc.primaryanim_frameindex = 0;
                        npc.primaryanim_loops_remaining = 0;
                        npc.primaryanim_pause = k2;
                        npc.primaryanim_replaycount = 0;
                    }

                    if(l2 == 2) {
                        npc.primaryanim_replaycount = 0;
                    }
                } else if(l1 == -1 || npc.primaryanim == -1 || AnimationDefinition.anims[l1].anInt359 >= AnimationDefinition.anims[npc.primaryanim].anInt359) {
                    npc.primaryanim = l1;
                    npc.primaryanim_frameindex = 0;
                    npc.primaryanim_loops_remaining = 0;
                    npc.primaryanim_pause = k2;
                    npc.primaryanim_replaycount = 0;
                    npc.anim_delay = npc.waypoint_count;
                }
            }

            if((l & 8) != 0) {
                l1 = stream.readByteS(0);
                k2 = stream.readByteC(false);
                npc.method447(-35698, k2, l1, loopCycle);
                npc.anInt1532 = loopCycle + 300;
                npc.currentHealth = stream.readUnsignedShort();
                npc.maxHealth = stream.readUnsignedShort();
            }

            if((l & 128) != 0) {
                npc.anInt1520 = stream.readUnsignedShort();
                l1 = stream.readDWord();
                npc.anInt1524 = l1 >> 16;
                npc.anInt1523 = loopCycle + (l1 & '\uffff');
                npc.anInt1521 = 0;
                npc.anInt1522 = 0;
                if(npc.anInt1523 > loopCycle) {
                    npc.anInt1521 = -1;
                }

                if(npc.anInt1520 == '\uffff') {
                    npc.anInt1520 = -1;
                }
            }

            if((l & 32) != 0) {
                npc.anInt1502 = stream.readUnsignedShort();
                if(npc.anInt1502 == '\uffff') {
                    npc.anInt1502 = -1;
                }
            }

            if((l & 1) != 0) {
                npc.aString1506 = stream.readString();
                npc.textCycle = 100;
            }

            if((l & 64) != 0) {
                l1 = stream.readByteC(false);
                k2 = stream.readByteA(2);
                npc.method447(-35698, k2, l1, loopCycle);
                npc.anInt1532 = loopCycle + 300;
                npc.currentHealth = stream.readUnsignedShort();
                npc.maxHealth = stream.readUnsignedShort();
            }

            if((l & 2) != 0) {
                npc.desc = Class5.method159(stream.method436((byte)-74));
                npc.anInt1540 = npc.desc.aByte68;
                npc.anInt1504 = npc.desc.anInt79;
                npc.anInt1554 = npc.desc.anInt67;
                npc.anInt1555 = npc.desc.anInt58;
                npc.anInt1556 = npc.desc.anInt83;
                npc.anInt1557 = npc.desc.anInt55;
                npc.anInt1511 = npc.desc.anInt77;
            }

            if((l & 4) != 0) {
                npc.face_x = stream.method434((byte)108);
                npc.face_y = stream.method434((byte)108);
            }
        }

        loggedIn &= flag;
    }

    public final void method87(Class5 class5, int i, boolean flag, int j, int k) {
        if(this.menuActionRow < 400) {
            if(class5.anIntArray88 != null) {
                class5 = class5.method161();
            }

            if(class5 != null) {
                if(class5.aBoolean84) {
                    String s = class5.name;
                    if(flag) {
                        aBoolean919 = !aBoolean919;
                    }

                    if(class5.anInt61 != 0) {
                        s = s + combatDiffColor(localPlayer.combatLevel, class5.anInt61, true) + " (level-" + class5.anInt61 + ")";
                    }

                    if(this.anInt1282 == 1) {
                        this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=ffff00>" + s;
                        this.menuActionID[this.menuActionRow] = 582;
                        this.menuActionCmd1[this.menuActionRow] = (long)i;
                        this.menuActionCmd2[this.menuActionRow] = k;
                        this.menuActionCmd3[this.menuActionRow] = j;
                        ++this.menuActionRow;
                    } else {
                        if(this.anInt1136 == 1) {
                            if((this.anInt1138 & 2) == 2) {
                                this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ffff00>" + s;
                                this.menuActionID[this.menuActionRow] = 413;
                                this.menuActionCmd1[this.menuActionRow] = (long)i;
                                this.menuActionCmd2[this.menuActionRow] = k;
                                this.menuActionCmd3[this.menuActionRow] = j;
                                ++this.menuActionRow;
                                return;
                            }
                        } else {
                            int i1;
                            if(class5.aStringArray66 != null) {
                                for(i1 = 4; i1 >= 0; --i1) {
                                    if(class5.aStringArray66[i1] != null && !class5.aStringArray66[i1].equalsIgnoreCase("attack")) {
                                        this.menuActionName[this.menuActionRow] = class5.aStringArray66[i1] + " <col=ffff00>" + s;
                                        if(i1 == 0) {
                                            this.menuActionID[this.menuActionRow] = 20;
                                        }

                                        if(i1 == 1) {
                                            this.menuActionID[this.menuActionRow] = 412;
                                        }

                                        if(i1 == 2) {
                                            this.menuActionID[this.menuActionRow] = 225;
                                        }

                                        if(i1 == 3) {
                                            this.menuActionID[this.menuActionRow] = 965;
                                        }

                                        if(i1 == 4) {
                                            this.menuActionID[this.menuActionRow] = 478;
                                        }

                                        this.menuActionCmd1[this.menuActionRow] = (long)i;
                                        this.menuActionCmd2[this.menuActionRow] = k;
                                        this.menuActionCmd3[this.menuActionRow] = j;
                                        ++this.menuActionRow;
                                    }
                                }
                            }

                            if(class5.aStringArray66 != null) {
                                for(i1 = 4; i1 >= 0; --i1) {
                                    if(class5.aStringArray66[i1] != null && class5.aStringArray66[i1].equalsIgnoreCase("attack")) {
                                        short c = 0;
                                        if(class5.anInt61 > localPlayer.combatLevel) {
                                            c = 2000;
                                        }

                                        this.menuActionName[this.menuActionRow] = class5.aStringArray66[i1] + " <col=ffff00>" + s;
                                        if(i1 == 0) {
                                            this.menuActionID[this.menuActionRow] = 20 + c;
                                        }

                                        if(i1 == 1) {
                                            this.menuActionID[this.menuActionRow] = 412 + c;
                                        }

                                        if(i1 == 2) {
                                            this.menuActionID[this.menuActionRow] = 225 + c;
                                        }

                                        if(i1 == 3) {
                                            this.menuActionID[this.menuActionRow] = 965 + c;
                                        }

                                        if(i1 == 4) {
                                            this.menuActionID[this.menuActionRow] = 478 + c;
                                        }

                                        this.menuActionCmd1[this.menuActionRow] = (long)i;
                                        this.menuActionCmd2[this.menuActionRow] = k;
                                        this.menuActionCmd3[this.menuActionRow] = j;
                                        ++this.menuActionRow;
                                    }
                                }
                            }

                            if(this.myPrivilege != 2 && this.myPrivilege != 9 && this.myPrivilege != 10 && this.myPrivilege != 4) {
                                this.menuActionName[this.menuActionRow] = "Examine <col=ffff00>" + s;
                            } else {
                                this.menuActionName[this.menuActionRow] = "Examine <col=ffff00>" + s + "</col><col=65280>(<col=ffffff>" + class5.aLong78 + "</col><col=65280>)</col>";
                            }

                            this.menuActionID[this.menuActionRow] = 1025;
                            this.menuActionCmd1[this.menuActionRow] = (long)i;
                            this.menuActionCmd2[this.menuActionRow] = k;
                            this.menuActionCmd3[this.menuActionRow] = j;
                            ++this.menuActionRow;
                        }

                    }
                }
            }
        }
    }

    public final void method88(int i, int j, Player player, boolean flag, int k) {
        if(player != localPlayer) {
            if(this.menuActionRow < 400) {
                if(!flag) {
                    String s;
                    if(player.title == 0) {
                        s = this.prefixColor(player.title) + this.prefixRank(player.title) + "<col=ffffff>" + player.name + this.suffixColor(player.title) + this.suffixRank(player.title) + combatDiffColor(localPlayer.combatLevel, player.combatLevel, true) + " (level-" + player.combatLevel + ")";
                    } else {
                        s = this.prefixColor(player.title) + this.prefixRank(player.title) + "<col=ffffff>" + player.name + this.suffixColor(player.title) + this.suffixRank(player.title) + combatDiffColor(localPlayer.combatLevel, player.combatLevel, true) + " (level-" + player.combatLevel + ")";
                    }

                    int i1;
                    if(this.anInt1282 == 1) {
                        this.menuActionName[this.menuActionRow] = "Use " + this.aString1286 + " with <col=ffffff>" + s;
                        this.menuActionID[this.menuActionRow] = 491;
                        this.menuActionCmd1[this.menuActionRow] = (long)j;
                        this.menuActionCmd2[this.menuActionRow] = i;
                        this.menuActionCmd3[this.menuActionRow] = k;
                        ++this.menuActionRow;
                    } else if(this.anInt1136 == 1) {
                        if((this.anInt1138 & 8) == 8) {
                            this.menuActionName[this.menuActionRow] = this.aString1139 + " <col=ffffff>" + s;
                            this.menuActionID[this.menuActionRow] = 365;
                            this.menuActionCmd1[this.menuActionRow] = (long)j;
                            this.menuActionCmd2[this.menuActionRow] = i;
                            this.menuActionCmd3[this.menuActionRow] = k;
                            ++this.menuActionRow;
                        }
                    } else {
                        for(i1 = 4; i1 >= 0; --i1) {
                            if(this.aStringArray1127[i1] != null) {
                                this.menuActionName[this.menuActionRow] = this.aStringArray1127[i1] + " <col=ffffff>" + s;
                                short c = 0;
                                if(this.aStringArray1127[i1].equalsIgnoreCase("attack")) {
                                    if(player.combatLevel > localPlayer.combatLevel) {
                                        c = 2000;
                                    }

                                    if(localPlayer.team != 0 && player.team != 0) {
                                        if(localPlayer.team == player.team) {
                                            c = 2000;
                                        } else {
                                            c = 0;
                                        }
                                    }
                                } else if(this.aBooleanArray1128[i1]) {
                                    c = 2000;
                                }

                                if(i1 == 0) {
                                    this.menuActionID[this.menuActionRow] = 561 + c;
                                }

                                if(i1 == 1) {
                                    this.menuActionID[this.menuActionRow] = 779 + c;
                                }

                                if(i1 == 2) {
                                    this.menuActionID[this.menuActionRow] = 27 + c;
                                }

                                if(i1 == 3) {
                                    this.menuActionID[this.menuActionRow] = 577 + c;
                                }

                                if(i1 == 4) {
                                    this.menuActionID[this.menuActionRow] = 729 + c;
                                }

                                this.menuActionCmd1[this.menuActionRow] = (long)j;
                                this.menuActionCmd2[this.menuActionRow] = i;
                                this.menuActionCmd3[this.menuActionRow] = k;
                                ++this.menuActionRow;
                            }
                        }
                    }

                    for(i1 = 0; i1 < this.menuActionRow; ++i1) {
                        if(this.menuActionID[i1] == 516) {
                            this.menuActionName[i1] = "Walk here <col=ffffff>" + s;
                            return;
                        }
                    }

                }
            }
        }
    }

    private final void method89(boolean flag, Class30_Sub1 class30_sub1) {
        long i = 0L;
        int j = -1;
        int k = 0;
        int l = 0;
        if(class30_sub1.anInt1296 == 0) {
            i = this.aClass25_946.method300(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        }

        if(class30_sub1.anInt1296 == 1) {
            i = this.aClass25_946.method301(class30_sub1.anInt1295, class30_sub1.anInt1297, 0, class30_sub1.anInt1298);
        }

        if(class30_sub1.anInt1296 == 2) {
            i = this.aClass25_946.method302(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        }

        if(class30_sub1.anInt1296 == 3) {
            i = this.aClass25_946.method303(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        }

        int j1;
        if(i != 0L) {
            j1 = this.aClass25_946.method304(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298, i);
            j = ObjectKey.getObjectId(i);
            k = j1 & 31;
            l = j1 >> 6;
        }

        class30_sub1.anInt1299 = j;
        class30_sub1.anInt1301 = k;
        if(flag) {
            for(j1 = 1; j1 > 0; ++j1) {
                ;
            }
        }

        class30_sub1.anInt1300 = l;
    }

    public final void method90(boolean flag) {
        for(int index = 0; index < this.currentSound; ++index) {
            if(this.soundDelay[index] > 0) {
                --this.soundDelay[index];
            } else {
                boolean flag1 = false;

                try {
                    Stream j = Sound.method241(this.soundType[index], this.sound[index]);
                    new SoundPlayer(new ByteArrayInputStream(j.buffer, 0, j.currentPosition), this.soundVolume[index], this.soundDelay[index]);
                    if(System.currentTimeMillis() + (long)(j.currentPosition / 22) > this.aLong1172 + (long)(this.anInt1257 / 22)) {
                        this.anInt1257 = j.currentPosition;
                        this.aLong1172 = System.currentTimeMillis();
                    }
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

                if(flag1 && this.soundDelay[index] != -5) {
                    this.soundDelay[index] = -5;
                } else {
                    --this.currentSound;

                    for(int var6 = index; var6 < this.currentSound; ++var6) {
                        this.sound[var6] = this.sound[var6 + 1];
                        this.soundType[var6] = this.soundType[var6 + 1];
                        this.soundDelay[var6] = this.soundDelay[var6 + 1];
                        this.soundVolume[var6] = this.soundVolume[var6 + 1];
                    }

                    --index;
                }
            }
        }

        if(this.previousSong > 0) {
            this.previousSong -= 20;
            if(this.previousSong < 0) {
                this.previousSong = 0;
            }

            if(this.previousSong == 0 && this.musicEnabled) {
                this.nextSong = this.currentSong;
                this.songChanging = true;
                onDemandFetcher.method558(2, this.nextSong);
            }
        }

    }

    public final void method6() {
        CacheDownloader.start(this, CacheDownloader.FileType.FILEDATA);
        this.method13(20, (byte)4, "Starting up");
        if(signlink.sunjava) {
            super.anInt6 = 5;
        }

        if(aBoolean993) {
            this.aBoolean1252 = true;
        } else {
            aBoolean993 = true;
            boolean flag = true;
            if(signlink.cache_dat != null) {
                for(int exception = 0; exception < 7; ++exception) {
                    this.aClass14Array970[exception] = new Class14(16777215, signlink.cache_dat, signlink.cache_idx[exception], exception + 1, true);
                }
            }

            try {
                if(Configuration.Enable_JagGrab) {
                    this.method16();
                }
                this.titleStreamLoader = this.loadArchive(1, "title screen", "title", this.anIntArray1090[1], (byte)-41, 25);
                this.smallText = new TextDrawingArea(false, "p11_full", 0, this.titleStreamLoader);
                this.regularText = new TextDrawingArea(false, "p12_full", 0, this.titleStreamLoader);
                this.boldText = new TextDrawingArea(false, "b12_full", 0, this.titleStreamLoader);
                this.newSmallFont = new RSFont(false, "p11_full", this.titleStreamLoader);
                this.newRegularFont = new RSFont(false, "p12_full", this.titleStreamLoader);
                this.newBoldFont = new RSFont(false, "b12_full", this.titleStreamLoader);
                this.newFancyFont = new RSFont(true, "q8_full", this.titleStreamLoader);
                this.newSmallFont.unpackChatImages(this.ModIcons);
                this.newRegularFont.unpackChatImages(this.ModIcons);
                this.newBoldFont.unpackChatImages(this.ModIcons);
                this.newFancyFont.unpackChatImages(this.ModIcons);
                this.aTextDrawingArea_1273 = new TextDrawingArea(true, "q8_full", 0, this.titleStreamLoader);
                this.method56(0);
                this.loadTitleScreen(215);
                FileArchive var33 = this.loadArchive(2, "config", "config", this.anIntArray1090[2], (byte)-41, 30);
                FileArchive fileArchive_1 = this.loadArchive(3, "interface", "interface", this.anIntArray1090[3], (byte)-41, 35);
                FileArchive fileArchive_2 = this.loadArchive(4, "2d graphics", "media", this.anIntArray1090[4], (byte)-41, 40);
                FileArchive fileArchive_3 = this.loadArchive(6, "textures", "textures", this.anIntArray1090[6], (byte)-41, 45);
                FileArchive fileArchive_4 = this.loadArchive(7, "chat system", "wordenc", this.anIntArray1090[7], (byte)-41, 50);
                FileArchive fileArchive_5 = this.loadArchive(8, "sound effects", "sounds", this.anIntArray1090[8], (byte)-41, 55);
                this.aByteArrayArrayArray1258 = new byte[4][104][104];
                this.anIntArrayArrayArray1214 = new int[4][105][105];
                this.aClass25_946 = new Class25(104, 104, this.anIntArrayArrayArray1214, 4);

                for(int fileArchive_6 = 0; fileArchive_6 < 4; ++fileArchive_6) {
                    this.collisionMaps[fileArchive_6] = new Class11(104, 104, true);
                }

                this.minimapImage = new Sprite(512, 512);
                FileArchive var34 = this.loadArchive(5, "update list", "versionlist", this.anIntArray1090[5], (byte)-41, 60);
                this.method13(60, (byte)4, "Connecting to update server");
                onDemandFetcher = new OnDemandFetcher();
                onDemandFetcher.start(var34, this);
                int k;
                if(Configuration.Dump_crcs) {
                    for(k = 0; k < this.aClass14Array970.length; ++k) {
                        onDemandFetcher.crcPack(k, (int)this.aClass14Array970[k].getFileCount());
                    }
                }

                Class36.method528(onDemandFetcher.method557(0));
                Model.method459(onDemandFetcher.getModelCount(), onDemandFetcher);
                this.method13(67, (byte)4, "Requesting Music");
                signlink.midiVolume = 70;
                if(!lowMemory && loginmusicEnabled) {
                    this.nextSong = 457;

                    try {
                        this.nextSong = Integer.parseInt(this.getParameter("music"));
                    } catch (Exception var26) {
                        ;
                    }

                    this.songChanging = true;
                    onDemandFetcher.method558(2, this.nextSong);

                    while(onDemandFetcher.method552() > 0) {
                        this.method57(false);

                        try {
                            Thread.sleep(100L);
                        } catch (Exception var25) {
                            ;
                        }

                        if(onDemandFetcher.anInt1349 > 3) {
                            this.method28("ondemand");
                            return;
                        }
                    }
                }

                this.method13(70, (byte)4, "Requesting animations");
                k = onDemandFetcher.method555(79, 1);

                int sprite;
                for(sprite = 0; sprite < k; ++sprite) {
                    onDemandFetcher.method558(1, sprite);
                }

                while(onDemandFetcher.method552() > 0) {
                    sprite = k - onDemandFetcher.method552();
                    if(sprite > 0) {
                        this.method13(70, (byte)4, "Loading animations - " + sprite * 100 / k + "%");
                    }

                    this.method57(false);

                    try {
                        Thread.sleep(100L);
                    } catch (Exception var24) {
                        ;
                    }

                    if(onDemandFetcher.anInt1349 > 3) {
                        this.method28("ondemand");
                        return;
                    }
                }

                this.method13(75, (byte)4, "Requesting models");
                k = onDemandFetcher.method555(79, 0);

                int i5;
                for(sprite = 0; sprite < k; ++sprite) {
                    i5 = onDemandFetcher.method559(sprite, -203);
                    if((i5 & 1) != 0) {
                        onDemandFetcher.method558(0, sprite);
                    }
                }

                k = onDemandFetcher.method552();

                while(onDemandFetcher.method552() > 0) {
                    sprite = k - onDemandFetcher.method552();
                    if(sprite > 0) {
                        this.method13(75, (byte)4, "Loading models - " + sprite * 100 / k + "%");
                    }

                    this.method57(false);

                    try {
                        Thread.sleep(100L);
                    } catch (Exception var23) {
                        ;
                    }
                }

                this.method13(75, (byte)4, "Requesting HD textures");
                k = onDemandFetcher.method555(79, 4);

                for(sprite = 0; sprite < k; ++sprite) {
                    i5 = onDemandFetcher.method559(sprite, -203);
                    if((i5 & 1) != 0) {
                        onDemandFetcher.method558(4, sprite);
                    }
                }

                k = onDemandFetcher.method552();

                while(onDemandFetcher.method552() > 0) {
                    sprite = k - onDemandFetcher.method552();
                    if(sprite > 0) {
                        this.method13(75, (byte)4, "Loading HD textures - " + sprite * 100 / k + "%");
                    }

                    this.method57(false);

                    try {
                        Thread.sleep(100L);
                    } catch (Exception var22) {
                        ;
                    }
                }
                this.method13(75, (byte)4, "Requesting 2009 sounds");
                k = onDemandFetcher.method555(79, 5);

                for(sprite = 0; sprite < k; ++sprite) {
                    i5 = onDemandFetcher.method559(sprite, -203);
                    if((i5 & 1) != 0) {
                        onDemandFetcher.method558(5, sprite);
                    }
                }

                k = onDemandFetcher.method552();

                while(onDemandFetcher.method552() > 0) {
                    sprite = k - onDemandFetcher.method552();
                    if(sprite > 0) {
                        this.method13(75, (byte)4, "Loading 2009 sounds - " + sprite * 100 / k + "%");
                    }

                    this.method57(false);

                    try {
                        Thread.sleep(100L);
                    } catch (Exception var22) {
                        ;
                    }
                }
                if(onDemandFetcher.anInt1349 > 3) {
                    this.method28("ondemand");
                } else {
                    if(this.aClass14Array970[0] != null) {
                        this.method13(80, (byte)4, "Requesting maps");
                        onDemandFetcher.method558(3, onDemandFetcher.method562(0, 0, 48, 47));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(1, 0, 48, 47));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(0, 0, 48, 48));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(1, 0, 48, 48));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(0, 0, 48, 49));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(1, 0, 48, 49));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(0, 0, 47, 47));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(1, 0, 47, 47));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(0, 0, 47, 48));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(1, 0, 47, 48));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(0, 0, 148, 48));
                        onDemandFetcher.method558(3, onDemandFetcher.method562(1, 0, 148, 48));
                        k = onDemandFetcher.method552();

                        while(onDemandFetcher.method552() > 0) {
                            sprite = k - onDemandFetcher.method552();
                            if(sprite > 0) {
                                this.method13(80, (byte)4, "Loading maps - " + sprite * 100 / k + "%");
                            }

                            this.method57(false);

                            try {
                                Thread.sleep(100L);
                            } catch (Exception var21) {
                                ;
                            }
                        }
                    }

                    for(sprite = 0; sprite < k; ++sprite) {
                        i5 = onDemandFetcher.method559(sprite, -203);
                        byte j5 = 0;
                        if((i5 & 8) != 0) {
                            j5 = 10;
                        } else if((i5 & 32) != 0) {
                            j5 = 9;
                        } else if((i5 & 16) != 0) {
                            j5 = 8;
                        } else if((i5 & 64) != 0) {
                            j5 = 7;
                        } else if((i5 & 128) != 0) {
                            j5 = 6;
                        } else if((i5 & 2) != 0) {
                            j5 = 5;
                        } else if((i5 & 4) != 0) {
                            j5 = 4;
                        }

                        if((i5 & 1) != 0) {
                            j5 = 3;
                        }

                        if(j5 != 0) {
                            onDemandFetcher.method563(j5, 0, sprite, (byte)8);
                        }
                    }

                    onDemandFetcher.method554(aBoolean959, 0);
                    if(!lowMemory) {
                        sprite = onDemandFetcher.method555(79, 2);

                        for(i5 = 1; i5 < sprite; ++i5) {
                            if(onDemandFetcher.method569(i5, 5)) {
                                onDemandFetcher.method563((byte)1, 2, i5, (byte)8);
                            }
                        }
                    }

                    this.method13(85, (byte)4, "Loading Ghreborn Maps");
                    System.out.println("Welcome to Ghreborn.com");
                    this.Mapicon = new Sprite("Minimap/Gen.PNG");
                    this.aSprite_1196 = new Sprite(fileArchive_2, "invback", 0);
                    this.aBackground_1197 = new Background(fileArchive_2, "mapback", 0);
                    this.worldswitch = new Background(fileArchive_2, "worldswitch", 0);
                    this.aSprite_1198 = new Sprite(fileArchive_2, "chatback", 0);
                    this.aSprite_1027 = new Sprite(fileArchive_2, "backbase1", 0);
                    this.aSprite_1028 = new Sprite(fileArchive_2, "backbase2", 0);
                    this.aSprite_1029 = new Sprite(fileArchive_2, "backhmid1", 0);

                    for(sprite = 0; sprite < 15; ++sprite) {
                        this.sideIcons[sprite] = new Sprite(fileArchive_2, "sideicons", sprite);
                    }

                    for(sprite = 0; sprite < 70; ++sprite) {
                        this.gameframe[sprite] = new Sprite("Gameframe/gameframe " + sprite);
                    }
                    for (int i = 0; i < inputSprites.length; i++)
                        inputSprites[i] = new Sprite("Interfaces/Inputfield/SPRITE " + (i + 1));

                    for(sprite = 0; sprite <= 1; ++sprite) {
                        this.BlackMap[sprite] = new Sprite("BlackMap " + sprite);
                    }

                    this.compassImage = new Sprite("COMPASS 0");
                    this.aSprite_1001 = new Sprite(fileArchive_2, "mapedge", 0);
                    this.aSprite_1001.method345(5059);

                    try {
                        for(sprite = 0; sprite < 100; ++sprite) {
                            this.aBackgroundArray1060[sprite] = new Background(fileArchive_2, "mapscene", sprite);
                        }
                    } catch (Exception var31) {
                        ;
                    }

                    try {
                        for(sprite = 0; sprite < 1001; ++sprite) {
                            this.aSpriteArray1033[sprite] = new Sprite(fileArchive_2, "mapfunction", sprite);
                        }
                    } catch (Exception var30) {
                        ;
                    }

                    try {
                        for(sprite = 0; sprite < 30; ++sprite) {
                            this.aSpriteArray987[sprite] = new Sprite(fileArchive_2, "hitmarks", sprite);
                        }
                    } catch (Exception var29) {
                        ;
                    }

                    try {
                        for(sprite = 0; sprite < 85; ++sprite) {
                            this.headIcons[sprite] = new Sprite(fileArchive_2, "headicons_prayer", sprite);
                        }
                    } catch (Exception var28) {
                        ;
                    }

                    try {
                        for(sprite = 0; sprite < 5; ++sprite) {
                            this.skullIcons[sprite] = new Sprite(fileArchive_2, "headicons_pk", sprite);
                        }
                    } catch (Exception var27) {
                        ;
                    }

                    this.aSprite_870 = new Sprite(fileArchive_2, "mapmarker", 0);
                    this.aSprite_871 = new Sprite(fileArchive_2, "mapmarker", 1);

                    for(sprite = 0; sprite < 8; ++sprite) {
                        this.aSpriteArray1150[sprite] = new Sprite(fileArchive_2, "cross", sprite);
                    }

                    this.aSprite_1074 = new Sprite(fileArchive_2, "mapdots", 0);
                    this.aSprite_1075 = new Sprite(fileArchive_2, "mapdots", 1);
                    this.aSprite_1076 = new Sprite(fileArchive_2, "mapdots", 2);
                    this.aSprite_1077 = new Sprite(fileArchive_2, "mapdots", 3);
                    this.aSprite_1078 = new Sprite(fileArchive_2, "mapdots", 4);
                    this.aSprite_1024 = new Sprite(fileArchive_2, "scrollbar", 0);
                    this.aSprite_1025 = new Sprite(fileArchive_2, "scrollbar", 1);
                    this.aSprite_1143 = new Sprite(fileArchive_2, "redstone1", 0);
                    this.aSprite_1144 = new Sprite(fileArchive_2, "redstone2", 0);
                    flip = true;
                    this.aBackground_1145 = new Background(fileArchive_2, "redstone3", 0);
                    this.aSprite_1146 = new Sprite(fileArchive_2, "redstone1", 0);
                    this.aSprite_1147 = new Sprite(fileArchive_2, "redstone2", 0);
                    flip = false;
                    flip_s = true;
                    this.aSprite_865 = new Sprite(fileArchive_2, "redstone1", 0);
                    this.aSprite_866 = new Sprite(fileArchive_2, "redstone2", 0);
                    this.aBackground_867 = new Background(fileArchive_2, "redstone3", 0);
                    flip_s = false;
                    flip_r = true;
                    this.aBackground_867.method359(true);
                    this.aSprite_868 = new Sprite(fileArchive_2, "redstone1", 0);
                    this.aBackground_869 = new Background(fileArchive_2, "redstone2", 0);
                    this.aBackground_869.method358(0);
                    this.aBackground_869.method359(true);

                    for(sprite = 0; sprite < 26; ++sprite) {
                        this.ModIcons[sprite] = new Sprite("player/icon " + sprite);
                    }

                    Sprite var39 = new Sprite(fileArchive_2, "screenframe", 0);
                    this.leftFrame = new RSImageProducer(var39.myWidth, var39.myHeight);
                    var39.method346(0, 0, -32357);
                    var39 = new Sprite(fileArchive_2, "screenframe", 1);
                    this.topFrame = new RSImageProducer(var39.myWidth, var39.myHeight);
                    var39.method346(0, 0, -32357);
                    i5 = (int)(Math.random() * 21.0D) - 10;
                    int var35 = (int)(Math.random() * 21.0D) - 10;
                    int k5 = (int)(Math.random() * 21.0D) - 10;
                    int l5 = (int)(Math.random() * 41.0D) - 20;

                    int aclass30_sub2_sub1_sub4;
                    for(aclass30_sub2_sub1_sub4 = 0; aclass30_sub2_sub1_sub4 < 1001; ++aclass30_sub2_sub1_sub4) {
                        if(this.aSpriteArray1033[aclass30_sub2_sub1_sub4] != null) {
                            this.aSpriteArray1033[aclass30_sub2_sub1_sub4].method344(i5 + l5, var35 + l5, k5 + l5, 0);
                        }
                    }

                    for(aclass30_sub2_sub1_sub4 = 0; aclass30_sub2_sub1_sub4 < 100; ++aclass30_sub2_sub1_sub4) {
                        if(this.aBackgroundArray1060[aclass30_sub2_sub1_sub4] != null) {
                            this.aBackgroundArray1060[aclass30_sub2_sub1_sub4].method360(i5 + l5, var35 + l5, k5 + l5, 0);
                        }
                    }

                    this.method13(86, (byte)4, "Unpacking textures");
                    Rasterizer.method368(fileArchive_3);
                    Rasterizer.method372(0.8D);
                    Rasterizer.method367();
                    this.method13(90, (byte)4, "Unpacking config");
                    AnimationDefinition.load(var33);
                    ObjectDefinition.load(var33);
                    FloorDefinition.load(var33);
                    OverLayFlo317.load(var33);
                    ItemDefinition.load(var33);
                    Class5.method162(var33);
                    Class38.load(var33);
                    Class23.method264(0, var33);
                    VarpDefinition.load(var33);
                    VarBit.load(0, var33);
                    ItemDefinition.aBoolean182 = aBoolean959;
                    if(!lowMemory) {
                        this.method13(92, (byte)4, "Unpacking sounds");
                        byte[] var36 = fileArchive_5.method571("sounds.dat");
                        Stream e = new Stream(var36, 891);
                        Sound.method240(0, e);
                    }

                    this.method13(95, (byte)4, "Unpacking interfaces");
                    RSFont[] var38 = new RSFont[]{this.newSmallFont, this.newRegularFont, this.newBoldFont, this.newFancyFont};
                    Widget.unpack(fileArchive_1, var38, (byte)-84, fileArchive_2);
                    this.method13(100, (byte)4, "Preparing game engine");

                    int j7;
                    int l7;
                    int j8;
                    int var37;
                    for(var37 = 0; var37 < 33; ++var37) {
                        j7 = 999;
                        l7 = 0;

                        for(j8 = 0; j8 < 34; ++j8) {
                            if(this.aBackground_1197.aByteArray1450[j8 + var37 * this.aBackground_1197.anInt1452] == 0) {
                                if(j7 == 999) {
                                    j7 = j8;
                                }
                            } else if(j7 != 999) {
                                l7 = j8;
                                break;
                            }
                        }

                        this.anIntArray968[var37] = j7;
                        this.anIntArray1057[var37] = l7 - j7;
                    }

                    for(var37 = 5; var37 < 156; ++var37) {
                        j7 = 999;
                        l7 = 0;

                        for(j8 = 25; j8 < 172; ++j8) {
                            if(this.aBackground_1197.aByteArray1450[j8 + var37 * this.aBackground_1197.anInt1452] != 0 || j8 <= 34 && var37 <= 34) {
                                if(j7 != 999) {
                                    l7 = j8;
                                    break;
                                }
                            } else if(j7 == 999) {
                                j7 = j8;
                            }
                        }

                        this.anIntArray1052[var37 - 5] = j7 - 25;
                        this.anIntArray1229[var37 - 5] = l7 - j7;
                    }

                    try {
                        this.macAddress = GetNetworkAddress.GetAddress("mac");
                        if(this.macAddress == null) {
                            this.macAddress = "";
                        }

                        if(Configuration.developerMode) {
                            System.out.println(this.macAddress);
                        }
                    } catch (Exception var20) {
                        var20.printStackTrace();
                        this.macAddress = "";
                    }

                    setBounds();
                    Censor.method487(fileArchive_4);
                    this.aMouseDetection_879 = new MouseDetection(this);
                    this.method12(this.aMouseDetection_879, 10);
                    Class30_Sub2_Sub4_Sub5.aClient1609 = this;
                    ObjectDefinition.clientInstance = this;
                    Class5.aClient82 = this;
                }
            } catch (Exception var32) {
                signlink.reporterror("loaderror " + this.aString1049 + " " + this.anInt1079);
                var32.printStackTrace();
                this.aBoolean926 = true;
            }
        }
    }

    private final void method91(Stream stream, int i, byte byte0) {
        if(byte0 == 8) {
            boolean byte01 = false;
        } else {
            this.anInt1119 = -50;
        }

        Player player;
        int l;
        int i1;
        int j1;
        for(; stream.anInt1407 + 10 < i * 8; player.setPos(localPlayer.anIntArray1500[0] + j1, localPlayer.anIntArray1501[0] + i1, l == 1, false)) {
            int j = stream.readBits(11);
            if(j == 2047) {
                break;
            }

            if(this.players[j] == null) {
                this.players[j] = new Player();
                if(this.aStreamArray895[j] != null) {
                    this.players[j].method451(0, this.aStreamArray895[j]);
                }
            }

            this.anIntArray892[this.anInt891++] = j;
            player = this.players[j];
            player.anInt1537 = loopCycle;
            int k = stream.readBits(1);
            if(k == 1) {
                this.anIntArray894[this.anInt893++] = j;
            }

            l = stream.readBits(1);
            i1 = stream.readBits(5);
            if(i1 > 15) {
                i1 -= 32;
            }

            j1 = stream.readBits(5);
            if(j1 > 15) {
                j1 -= 32;
            }
        }

        stream.method420(true);
    }

    public boolean inCircle(int circleX, int circleY, int clickX, int clickY, int radius) {
        return Math.pow((double)(circleX + radius - clickX), 2.0D) + Math.pow((double)(circleY + radius - clickY), 2.0D) < Math.pow((double)radius, 2.0D);
    }

    public final void method92(boolean flag) {
        loggedIn &= flag;
        if(this.anInt1021 == 0) {
            if(super.clickMode3 == 1) {
                int i = super.saveClickX - 25 - 547;
                int j = super.saveClickY - 5 - 3;
                if(currentScreenMode != client.ScreenMode.FIXED) {
                    i = super.saveClickX - (currentGameWidth - 182 + 24);
                    j = super.saveClickY - 8;
                }

                int l;
                if(this.inCircle(0, 0, i, j, 76) && this.mouseMapPosition()) {
                    i -= 73;
                    j -= 75;
                    l = this.anInt1185 + this.anInt1209 & 2047;
                    int i1 = Rasterizer.anIntArray1470[l];
                    int j1 = Rasterizer.anIntArray1471[l];
                    i1 = i1 * (this.anInt1170 + 256) >> 8;
                    j1 = j1 * (this.anInt1170 + 256) >> 8;
                    int k1 = j * i1 + i * j1 >> 11;
                    int l1 = j * j1 - i * i1 >> 11;
                    int i2 = localPlayer.anInt1550 + k1 >> 7;
                    int j2 = localPlayer.anInt1551 - l1 >> 7;
                    boolean flag1 = false;
                    if(this.myPrivilege >= 2 && controlIsDown) {
                        this.teleport(this.baseX + i2, this.baseY + j2);
                    } else {
                        flag1 = this.doWalkTo(1, 0, 0, -11308, 0, localPlayer.anIntArray1501[0], 0, 0, j2, localPlayer.anIntArray1500[0], true, i2);
                    }

                    if(flag1) {
                        this.stream.writeUnsignedByte(i);
                        this.stream.writeUnsignedByte(j);
                        this.stream.writeWord(this.anInt1185);
                        this.stream.writeUnsignedByte(57);
                        this.stream.writeUnsignedByte(this.anInt1209);
                        this.stream.writeUnsignedByte(this.anInt1170);
                        this.stream.writeUnsignedByte(89);
                        this.stream.writeWord(localPlayer.anInt1550);
                        this.stream.writeWord(localPlayer.anInt1551);
                        this.stream.writeUnsignedByte(this.anInt1264);
                        this.stream.writeUnsignedByte(63);
                    }
                }

                ++anInt1117;
                if(anInt1117 > 1151) {
                    anInt1117 = 0;
                    this.stream.createFrame(246);
                    this.stream.writeUnsignedByte(0);
                    l = this.stream.currentPosition;
                    if((int)(Math.random() * 2.0D) == 0) {
                        this.stream.writeUnsignedByte(101);
                    }

                    this.stream.writeUnsignedByte(197);
                    this.stream.writeWord((int)(Math.random() * 65536.0D));
                    this.stream.writeUnsignedByte((int)(Math.random() * 256.0D));
                    this.stream.writeUnsignedByte(67);
                    this.stream.writeWord(14214);
                    if((int)(Math.random() * 2.0D) == 0) {
                        this.stream.writeWord(29487);
                    }

                    this.stream.writeWord((int)(Math.random() * 65536.0D));
                    if((int)(Math.random() * 2.0D) == 0) {
                        this.stream.writeUnsignedByte(220);
                    }

                    this.stream.writeUnsignedByte(180);
                    this.stream.method407(this.stream.currentPosition - l, (byte)0);
                }
            }

        }
    }

    public final String method93(int i, int j) {
        if(i <= 0) {
            this.packet = this.in.readUnsignedByte();
        }

        return j < 999999999?String.valueOf(j):"?";
    }

    public final void method94(int i) {
        if(i != -13873) {
            for(int g = 1; g > 0; ++g) {
                ;
            }
        }

        Graphics var4 = this.method11(0).getGraphics();
        var4.setColor(Color.black);
        var4.fillRect(0, 0, 765, 503);
        this.method4(false, 1);
        byte l;
        int var5;
        if(this.aBoolean926) {
            this.aBoolean831 = false;
            var4.setFont(new Font("Helvetica", 1, 16));
            var4.setColor(Color.yellow);
            l = 35;
            var4.drawString("Sorry, an error has occured whilst loading GodzHell Reborn and Remastered", 30, l);
            var5 = l + 50;
            var4.setColor(Color.white);
            var4.drawString("To fix this try the following (in order):", 30, var5);
            var5 += 50;
            var4.setColor(Color.white);
            var4.setFont(new Font("Helvetica", 1, 12));
            var4.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var5);
            var5 += 30;
            var4.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, var5);
            var5 += 30;
            var4.drawString("3: Try using a different game-world", 30, var5);
            var5 += 30;
            var4.drawString("4: Try rebooting your computer", 30, var5);
            var5 += 30;
            var4.drawString("5: Try selecting a different version of Java from the play-game menu", 30, var5);
        }

        if(this.aBoolean1176) {
            this.aBoolean831 = false;
            var4.setFont(new Font("Helvetica", 1, 20));
            var4.setColor(Color.white);
            var4.drawString("Error - unable to load game!", 50, 50);
            var4.drawString("", 50, 100);
            var4.drawString("", 50, 150);
        }

        if(this.aBoolean1252) {
            this.aBoolean831 = false;
            var4.setColor(Color.yellow);
            l = 35;
            var4.drawString("Error a copy of Demolishscape already appears to be loaded", 30, l);
            var5 = l + 50;
            var4.setColor(Color.white);
            var4.drawString("To fix this try the following (in order):", 30, var5);
            var5 += 50;
            var4.setColor(Color.white);
            var4.setFont(new Font("Helvetica", 1, 12));
            var4.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var5);
            var5 += 30;
            var4.drawString("2: Try rebooting your computer, and reloading", 30, var5);
            var5 += 30;
        }

    }

    public URL getCodeBase() {
        try {
            return new URL("http://" + server + ":" + (29435 + ondemand_offset));
        } catch (Exception var2) {
            return super.getCodeBase();
        }
    }

    public final void method95(int i) {
        for(int j = 0; j < this.npcCount; ++j) {
            int k = this.npcIndices[j];
            Npc npc = this.npcs[k];
            if(npc != null) {
                this.method96('\ub78c', npc.desc.aByte68, npc);
            }
        }

        if(i != -8066) {
            this.anInt1218 = 148;
        }

    }

    public final void method96(int i, int j, Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1) {
        if(i != '\ub78c') {
            this.packet = -1;
        }

        if(class30_sub2_sub4_sub1.anInt1550 < 128 || class30_sub2_sub4_sub1.anInt1551 < 128 || class30_sub2_sub4_sub1.anInt1550 >= 13184 || class30_sub2_sub4_sub1.anInt1551 >= 13184) {
            class30_sub2_sub4_sub1.primaryanim = -1;
            class30_sub2_sub4_sub1.anInt1520 = -1;
            class30_sub2_sub4_sub1.anInt1547 = 0;
            class30_sub2_sub4_sub1.anInt1548 = 0;
            class30_sub2_sub4_sub1.anInt1550 = class30_sub2_sub4_sub1.anIntArray1500[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.anInt1551 = class30_sub2_sub4_sub1.anIntArray1501[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.method446(true);
        }

        if(class30_sub2_sub4_sub1 == localPlayer && (class30_sub2_sub4_sub1.anInt1550 < 1536 || class30_sub2_sub4_sub1.anInt1551 < 1536 || class30_sub2_sub4_sub1.anInt1550 >= 11776 || class30_sub2_sub4_sub1.anInt1551 >= 11776)) {
            class30_sub2_sub4_sub1.primaryanim = -1;
            class30_sub2_sub4_sub1.anInt1520 = -1;
            class30_sub2_sub4_sub1.anInt1547 = 0;
            class30_sub2_sub4_sub1.anInt1548 = 0;
            class30_sub2_sub4_sub1.anInt1550 = class30_sub2_sub4_sub1.anIntArray1500[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.anInt1551 = class30_sub2_sub4_sub1.anIntArray1501[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.method446(true);
        }

        if(class30_sub2_sub4_sub1.anInt1547 > loopCycle) {
            this.method97(class30_sub2_sub4_sub1, true);
        } else if(class30_sub2_sub4_sub1.anInt1548 >= loopCycle) {
            this.method98(class30_sub2_sub4_sub1, this.aByte1012);
        } else {
            this.method99((byte)34, class30_sub2_sub4_sub1);
        }

        try {
            this.method100(class30_sub2_sub4_sub1, -843);
            this.method101(class30_sub2_sub4_sub1, -805);
        } catch (ArrayIndexOutOfBoundsException var5) {
            ;
        }

    }

    public final void method97(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, boolean flag) {
        int i = class30_sub2_sub4_sub1.anInt1547 - loopCycle;
        int j = class30_sub2_sub4_sub1.anInt1543 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
        int k = class30_sub2_sub4_sub1.anInt1545 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
        class30_sub2_sub4_sub1.anInt1550 += (j - class30_sub2_sub4_sub1.anInt1550) / i;
        if(flag) {
            class30_sub2_sub4_sub1.anInt1551 += (k - class30_sub2_sub4_sub1.anInt1551) / i;
            class30_sub2_sub4_sub1.anInt1503 = 0;
            if(class30_sub2_sub4_sub1.anInt1549 == 0) {
                class30_sub2_sub4_sub1.anInt1510 = 1024;
            }

            if(class30_sub2_sub4_sub1.anInt1549 == 1) {
                class30_sub2_sub4_sub1.anInt1510 = 1536;
            }

            if(class30_sub2_sub4_sub1.anInt1549 == 2) {
                class30_sub2_sub4_sub1.anInt1510 = 0;
            }

            if(class30_sub2_sub4_sub1.anInt1549 == 3) {
                class30_sub2_sub4_sub1.anInt1510 = 512;
            }

        }
    }

    public final void method98(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, byte byte0) {
        if(class30_sub2_sub4_sub1.anInt1548 == loopCycle || class30_sub2_sub4_sub1.primaryanim == -1 || class30_sub2_sub4_sub1.primaryanim_pause != 0 || class30_sub2_sub4_sub1.primaryanim_loops_remaining + 1 > AnimationDefinition.anims[class30_sub2_sub4_sub1.primaryanim].method258(class30_sub2_sub4_sub1.primaryanim_frameindex, (byte)-39)) {
            int i = class30_sub2_sub4_sub1.anInt1548 - class30_sub2_sub4_sub1.anInt1547;
            int j = loopCycle - class30_sub2_sub4_sub1.anInt1547;
            int k = class30_sub2_sub4_sub1.anInt1543 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int l = class30_sub2_sub4_sub1.anInt1545 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int i1 = class30_sub2_sub4_sub1.anInt1544 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int j1 = class30_sub2_sub4_sub1.anInt1546 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.anInt1550 = (k * (i - j) + i1 * j) / i;
            class30_sub2_sub4_sub1.anInt1551 = (l * (i - j) + j1 * j) / i;
        }

        class30_sub2_sub4_sub1.anInt1503 = 0;
        if(class30_sub2_sub4_sub1.anInt1549 == 0) {
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        }

        if(class30_sub2_sub4_sub1.anInt1549 == 1) {
            class30_sub2_sub4_sub1.anInt1510 = 1536;
        }

        if(class30_sub2_sub4_sub1.anInt1549 == 2) {
            class30_sub2_sub4_sub1.anInt1510 = 0;
        }

        if(class30_sub2_sub4_sub1.anInt1549 == 3) {
            class30_sub2_sub4_sub1.anInt1510 = 512;
        }

        class30_sub2_sub4_sub1.anInt1552 = class30_sub2_sub4_sub1.anInt1510;
        if(byte0 != this.aByte1012) {
            anInt1096 = -383;
        }

    }

    public final void method99(byte byte0, Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1) {
        class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1511;
        if(class30_sub2_sub4_sub1.waypoint_count == 0) {
            class30_sub2_sub4_sub1.anInt1503 = 0;
        } else {
            if(class30_sub2_sub4_sub1.primaryanim != -1 && class30_sub2_sub4_sub1.primaryanim_pause == 0) {
                AnimationDefinition i = AnimationDefinition.anims[class30_sub2_sub4_sub1.primaryanim];
                if(class30_sub2_sub4_sub1.anim_delay > 0 && i.anInt363 == 0) {
                    ++class30_sub2_sub4_sub1.anInt1503;
                    return;
                }

                if(class30_sub2_sub4_sub1.anim_delay <= 0 && i.anInt364 == 0) {
                    ++class30_sub2_sub4_sub1.anInt1503;
                    return;
                }
            }

            int var10 = class30_sub2_sub4_sub1.anInt1550;
            int j = class30_sub2_sub4_sub1.anInt1551;
            int k = class30_sub2_sub4_sub1.anIntArray1500[class30_sub2_sub4_sub1.waypoint_count - 1] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int l = class30_sub2_sub4_sub1.anIntArray1501[class30_sub2_sub4_sub1.waypoint_count - 1] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            if(k - var10 <= 256 && k - var10 >= -256 && l - j <= 256 && l - j >= -256) {
                if(var10 < k) {
                    if(j < l) {
                        class30_sub2_sub4_sub1.anInt1510 = 1280;
                    } else if(j > l) {
                        class30_sub2_sub4_sub1.anInt1510 = 1792;
                    } else {
                        class30_sub2_sub4_sub1.anInt1510 = 1536;
                    }
                } else if(var10 > k) {
                    if(j < l) {
                        class30_sub2_sub4_sub1.anInt1510 = 768;
                    } else if(j > l) {
                        class30_sub2_sub4_sub1.anInt1510 = 256;
                    } else {
                        class30_sub2_sub4_sub1.anInt1510 = 512;
                    }
                } else if(j < l) {
                    class30_sub2_sub4_sub1.anInt1510 = 1024;
                } else {
                    class30_sub2_sub4_sub1.anInt1510 = 0;
                }

                int i1 = class30_sub2_sub4_sub1.anInt1510 - class30_sub2_sub4_sub1.anInt1552 & 2047;
                if(i1 > 1024) {
                    i1 -= 2048;
                }

                int j1 = class30_sub2_sub4_sub1.anInt1555;
                if(i1 >= -256 && i1 <= 256) {
                    j1 = class30_sub2_sub4_sub1.anInt1554;
                } else if(i1 >= 256 && i1 < 768) {
                    j1 = class30_sub2_sub4_sub1.anInt1557;
                } else if(i1 >= -768 && i1 <= -256) {
                    j1 = class30_sub2_sub4_sub1.anInt1556;
                }

                if(j1 == -1) {
                    j1 = class30_sub2_sub4_sub1.anInt1554;
                }

                class30_sub2_sub4_sub1.anInt1517 = j1;
                int k1 = 4;
                if(byte0 != 34) {
                    anInt1096 = 285;
                }

                if(class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.anInt1510 && class30_sub2_sub4_sub1.anInt1502 == -1 && class30_sub2_sub4_sub1.anInt1504 != 0) {
                    k1 = 2;
                }

                if(class30_sub2_sub4_sub1.waypoint_count > 2) {
                    k1 = 6;
                }

                if(class30_sub2_sub4_sub1.waypoint_count > 3) {
                    k1 = 8;
                }

                if(class30_sub2_sub4_sub1.anInt1503 > 0 && class30_sub2_sub4_sub1.waypoint_count > 1) {
                    k1 = 8;
                    --class30_sub2_sub4_sub1.anInt1503;
                }

                if(class30_sub2_sub4_sub1.aBooleanArray1553[class30_sub2_sub4_sub1.waypoint_count - 1]) {
                    k1 <<= 1;
                }

                if(k1 >= 8 && class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.anInt1554 && class30_sub2_sub4_sub1.anInt1505 != -1) {
                    class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1505;
                }

                if(var10 < k) {
                    class30_sub2_sub4_sub1.anInt1550 += k1;
                    if(class30_sub2_sub4_sub1.anInt1550 > k) {
                        class30_sub2_sub4_sub1.anInt1550 = k;
                    }
                } else if(var10 > k) {
                    class30_sub2_sub4_sub1.anInt1550 -= k1;
                    if(class30_sub2_sub4_sub1.anInt1550 < k) {
                        class30_sub2_sub4_sub1.anInt1550 = k;
                    }
                }

                if(j < l) {
                    class30_sub2_sub4_sub1.anInt1551 += k1;
                    if(class30_sub2_sub4_sub1.anInt1551 > l) {
                        class30_sub2_sub4_sub1.anInt1551 = l;
                    }
                } else if(j > l) {
                    class30_sub2_sub4_sub1.anInt1551 -= k1;
                    if(class30_sub2_sub4_sub1.anInt1551 < l) {
                        class30_sub2_sub4_sub1.anInt1551 = l;
                    }
                }

                if(class30_sub2_sub4_sub1.anInt1550 == k && class30_sub2_sub4_sub1.anInt1551 == l) {
                    --class30_sub2_sub4_sub1.waypoint_count;
                    if(class30_sub2_sub4_sub1.anim_delay > 0) {
                        --class30_sub2_sub4_sub1.anim_delay;
                    }
                }

            } else {
                class30_sub2_sub4_sub1.anInt1550 = k;
                class30_sub2_sub4_sub1.anInt1551 = l;
            }
        }
    }

    public final void method100(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, int i) {
        if(i < 0) {
            if(class30_sub2_sub4_sub1.anInt1504 != 0) {
                int j1;
                int l1;
                if(class30_sub2_sub4_sub1.anInt1502 != -1 && class30_sub2_sub4_sub1.anInt1502 < '\u8000') {
                    Npc l = this.npcs[class30_sub2_sub4_sub1.anInt1502];
                    if(l != null) {
                        j1 = class30_sub2_sub4_sub1.anInt1550 - l.anInt1550;
                        l1 = class30_sub2_sub4_sub1.anInt1551 - l.anInt1551;
                        if(j1 != 0 || l1 != 0) {
                            class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2((double)j1, (double)l1) * 325.949D) & 2047;
                        }
                    }
                }

                if(class30_sub2_sub4_sub1.anInt1502 >= '\u8000') {
                    l1 = class30_sub2_sub4_sub1.anInt1502 - '\u8000';
                    if(l1 == this.anInt884) {
                        l1 = this.maxPlayerCount;
                    }

                    Player j11 = this.players[l1];
                    if(j11 != null) {
                        l1 = class30_sub2_sub4_sub1.anInt1550 - j11.anInt1550;
                        int i2 = class30_sub2_sub4_sub1.anInt1551 - j11.anInt1551;
                        if(l1 != 0 || i2 != 0) {
                            class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2((double)l1, (double)i2) * 325.949D) & 2047;
                        }
                    }
                }

                if((class30_sub2_sub4_sub1.face_x != 0 || class30_sub2_sub4_sub1.face_y != 0) && (class30_sub2_sub4_sub1.waypoint_count == 0 || class30_sub2_sub4_sub1.anInt1503 > 0)) {
                    l1 = class30_sub2_sub4_sub1.anInt1550 - (class30_sub2_sub4_sub1.face_x - this.baseX - this.baseX) * 64;
                    j1 = class30_sub2_sub4_sub1.anInt1551 - (class30_sub2_sub4_sub1.face_y - this.baseY - this.baseY) * 64;
                    if(l1 != 0 || j1 != 0) {
                        class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2((double)l1, (double)j1) * 325.949D) & 2047;
                    }

                    class30_sub2_sub4_sub1.face_x = 0;
                    class30_sub2_sub4_sub1.face_y = 0;
                }

                l1 = class30_sub2_sub4_sub1.anInt1510 - class30_sub2_sub4_sub1.anInt1552 & 2047;
                if(l1 != 0) {
                    if(l1 >= class30_sub2_sub4_sub1.anInt1504 && l1 <= 2048 - class30_sub2_sub4_sub1.anInt1504) {
                        if(l1 > 1024) {
                            class30_sub2_sub4_sub1.anInt1552 -= class30_sub2_sub4_sub1.anInt1504;
                        } else {
                            class30_sub2_sub4_sub1.anInt1552 += class30_sub2_sub4_sub1.anInt1504;
                        }
                    } else {
                        class30_sub2_sub4_sub1.anInt1552 = class30_sub2_sub4_sub1.anInt1510;
                    }

                    class30_sub2_sub4_sub1.anInt1552 &= 2047;
                    if(class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.anInt1511 && class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.anInt1510) {
                        if(class30_sub2_sub4_sub1.anInt1512 != -1) {
                            class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1512;
                            return;
                        }

                        class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1554;
                    }
                }

            }
        }
    }

    public final void method101(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, int i) {
        if(i >= 0) {
            aBoolean919 = !aBoolean919;
        }

        class30_sub2_sub4_sub1.aBoolean1541 = false;
        AnimationDefinition class20_3;
        if(class30_sub2_sub4_sub1.anInt1517 != -1) {
            class20_3 = AnimationDefinition.anims[class30_sub2_sub4_sub1.anInt1517];
            ++class30_sub2_sub4_sub1.anInt1519;
            if(class30_sub2_sub4_sub1.anInt1518 < class20_3.frameCount && class30_sub2_sub4_sub1.anInt1519 > class20_3.method258(class30_sub2_sub4_sub1.anInt1518, (byte)-39)) {
                class30_sub2_sub4_sub1.anInt1519 = 1;
                ++class30_sub2_sub4_sub1.anInt1518;
            }

            if(class30_sub2_sub4_sub1.anInt1518 >= class20_3.frameCount) {
                class30_sub2_sub4_sub1.anInt1519 = 1;
                class30_sub2_sub4_sub1.anInt1518 = 0;
            }
        }

        if(class30_sub2_sub4_sub1.anInt1520 != -1 && loopCycle >= class30_sub2_sub4_sub1.anInt1523) {
            if(class30_sub2_sub4_sub1.anInt1521 < 0) {
                class30_sub2_sub4_sub1.anInt1521 = 0;
            }

            class20_3 = Class23.aClass23Array403[class30_sub2_sub4_sub1.anInt1520].aClass20_407;
            ++class30_sub2_sub4_sub1.anInt1522;

            while(class30_sub2_sub4_sub1.anInt1521 < class20_3.frameCount && class30_sub2_sub4_sub1.anInt1522 > class20_3.method258(class30_sub2_sub4_sub1.anInt1521, (byte)-39)) {
                class30_sub2_sub4_sub1.anInt1522 -= class20_3.method258(class30_sub2_sub4_sub1.anInt1521, (byte)-39);
                ++class30_sub2_sub4_sub1.anInt1521;
            }

            if(class30_sub2_sub4_sub1.anInt1521 >= class20_3.frameCount && (class30_sub2_sub4_sub1.anInt1521 < 0 || class30_sub2_sub4_sub1.anInt1521 >= class20_3.frameCount)) {
                class30_sub2_sub4_sub1.anInt1520 = -1;
            }
        }

        if(class30_sub2_sub4_sub1.primaryanim != -1 && class30_sub2_sub4_sub1.primaryanim_pause <= 1) {
            class20_3 = AnimationDefinition.anims[class30_sub2_sub4_sub1.primaryanim];
            if(class20_3.anInt363 == 1 && class30_sub2_sub4_sub1.anim_delay > 0 && class30_sub2_sub4_sub1.anInt1547 <= loopCycle && class30_sub2_sub4_sub1.anInt1548 < loopCycle) {
                class30_sub2_sub4_sub1.primaryanim_pause = 1;
                return;
            }
        }

        if(class30_sub2_sub4_sub1.primaryanim != -1 && class30_sub2_sub4_sub1.primaryanim_pause == 0) {
            class20_3 = AnimationDefinition.anims[class30_sub2_sub4_sub1.primaryanim];
            ++class30_sub2_sub4_sub1.primaryanim_loops_remaining;

            while(class30_sub2_sub4_sub1.primaryanim_frameindex < class20_3.frameCount && class30_sub2_sub4_sub1.primaryanim_loops_remaining > class20_3.method258(class30_sub2_sub4_sub1.primaryanim_frameindex, (byte)-39)) {
                class30_sub2_sub4_sub1.primaryanim_loops_remaining -= class20_3.method258(class30_sub2_sub4_sub1.primaryanim_frameindex, (byte)-39);
                ++class30_sub2_sub4_sub1.primaryanim_frameindex;
            }

            if(class30_sub2_sub4_sub1.primaryanim_frameindex >= class20_3.frameCount) {
                class30_sub2_sub4_sub1.primaryanim_frameindex -= class20_3.anInt356;
                ++class30_sub2_sub4_sub1.primaryanim_replaycount;
                if(class30_sub2_sub4_sub1.primaryanim_replaycount >= class20_3.anInt362) {
                    class30_sub2_sub4_sub1.primaryanim = -1;
                }

                if(class30_sub2_sub4_sub1.primaryanim_frameindex < 0 || class30_sub2_sub4_sub1.primaryanim_frameindex >= class20_3.frameCount) {
                    class30_sub2_sub4_sub1.primaryanim = -1;
                }
            }

            class30_sub2_sub4_sub1.aBoolean1541 = class20_3.aBoolean358;
        }

        if(class30_sub2_sub4_sub1.primaryanim_pause > 0) {
            --class30_sub2_sub4_sub1.primaryanim_pause;
        }

    }

    public final void method102(boolean flag) {
        if(!flag) {
            this.anInt939 = (int) this.aISAACRandomGen_1000.getNextIntKey();
        }

        if(this.aBoolean1255) {
            this.aBoolean1255 = false;
            this.tabAreaAltered = true;
            this.inputTaken = true;
            this.aBoolean1103 = true;
            this.aBoolean1233 = true;
            if(this.anInt1023 != 2 && currentScreenMode == client.ScreenMode.FIXED) {
                aRSImageProducer_1165.method238(currentScreenMode == client.ScreenMode.FIXED?0:0, 23680, super.aGraphics12, currentScreenMode == client.ScreenMode.FIXED?0:0);
                this.aRSImageProducer_1164.method238(0, 23680, super.aGraphics12, 516);
            }
        }

        if(this.menuOpen) {
            this.tabAreaAltered = true;
        }

        boolean flag2;
        if(this.invOverlayInterfaceID != -1) {
            flag2 = this.method119(this.anInt945, false, this.invOverlayInterfaceID);
            if(flag2) {
                this.tabAreaAltered = true;
            }
        }

        if(this.atInventoryInterfaceType == 2) {
            this.tabAreaAltered = true;
        }

        if(this.anInt1086 == 2) {
            this.tabAreaAltered = true;
        }

        if(this.tabAreaAltered) {
            this.drawTabArea((byte)-81);
            this.tabAreaAltered = false;
        }

        if(this.backDialogID == -1) {
            this.aClass9_1059.scrollPosition = this.anInt1211 - anInt1089 - 110;
            if(super.mouseX > 496 && super.mouseX < 511 && super.mouseY > (currentScreenMode == client.ScreenMode.FIXED?345:currentGameHeight - 158)) {
                this.method65(494, 110, super.mouseX, super.mouseY - (currentScreenMode == client.ScreenMode.FIXED?345:currentGameHeight - 158), this.aClass9_1059, 0, false, this.anInt1211, 0);
            }

            int flag21 = this.anInt1211 - 110 - this.aClass9_1059.scrollPosition;
            if(flag21 < 0) {
                flag21 = 0;
            }

            if(flag21 > this.anInt1211 - 110) {
                flag21 = this.anInt1211 - 110;
            }

            if(anInt1089 != flag21) {
                anInt1089 = flag21;
                this.inputTaken = true;
            }
        }

        if(this.backDialogID != -1) {
            flag2 = this.method119(this.anInt945, false, this.backDialogID);
            if(flag2) {
                this.inputTaken = true;
            }
        }

        if(this.atInventoryInterfaceType == 3) {
            this.inputTaken = true;
        }

        if(this.anInt1086 == 3) {
            this.inputTaken = true;
        }

        if(this.aString844 != null) {
            this.inputTaken = true;
        }

        if(this.menuOpen && this.menuScreenArea == 2) {
            this.inputTaken = true;
        }

        if(this.inputTaken) {
            this.drawChatArea(6);
            this.inputTaken = false;
        }

        if(this.anInt1023 == 2) {
            this.method146((byte)1);
        }

        if(this.anInt1023 == 2 && currentScreenMode == client.ScreenMode.FIXED) {
            this.drawMinimap(false);
            this.aRSImageProducer_1164.method238(0, 23680, super.aGraphics12, 516);
        }

        if(this.anInt1054 != -1) {
            this.aBoolean1103 = true;
        }

        if(this.aBoolean1103) {
            if(this.anInt1054 != -1 && this.anInt1054 == tabID) {
                this.anInt1054 = -1;
                this.stream.createFrame(120);
                this.stream.writeUnsignedByte(tabID);
            }

            this.aBoolean1103 = false;
            this.aRSImageProducer_1125.initDrawingArea();
            aRSImageProducer_1165.initDrawingArea();
        }

        this.anInt945 = 0;
    }

    public final boolean method103(Widget class9, boolean flag) {
        int i = class9.contentType;
        if(flag) {
            this.method6();
        }

        if(i >= 1 && i <= 200 || i >= 701 && i <= 900) {
            if(i >= 801) {
                i -= 701;
            } else if(i >= 701) {
                i -= 601;
            } else if(i >= 101) {
                i -= 101;
            } else {
                --i;
            }

            this.menuActionName[this.menuActionRow] = "Remove <col=ffffff>" + this.friendsList[i];
            this.menuActionID[this.menuActionRow] = 792;
            ++this.menuActionRow;
            this.menuActionName[this.menuActionRow] = "Message <col=ffffff>" + this.friendsList[i];
            this.menuActionID[this.menuActionRow] = 639;
            ++this.menuActionRow;
            if(this.myPrivilege >= 2) {
                this.menuActionName[this.menuActionRow] = "TeleToMe <col=ffffff>" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 638;
                ++this.menuActionRow;
                this.menuActionName[this.menuActionRow] = "TeleTo <col=ffffff>" + this.friendsList[i];
                this.menuActionID[this.menuActionRow] = 637;
                ++this.menuActionRow;
            }

            return true;
        } else if(i >= 401 && i <= 500) {
            this.menuActionName[this.menuActionRow] = "Remove <col=ffffff>" + class9.message;
            this.menuActionID[this.menuActionRow] = 322;
            ++this.menuActionRow;
            return true;
        } else {
            return false;
        }
    }

    public final void method104(boolean flag) {
        Class30_Sub2_Sub4_Sub3 class30_sub2_sub4_sub3 = (Class30_Sub2_Sub4_Sub3)this.aDoubleEndedQueue_1056.reverseGetFirst();

        for(loggedIn &= flag; class30_sub2_sub4_sub3 != null; class30_sub2_sub4_sub3 = (Class30_Sub2_Sub4_Sub3)this.aDoubleEndedQueue_1056.reverseGetNext(false)) {
            if(class30_sub2_sub4_sub3.anInt1560 == this.anInt918 && !class30_sub2_sub4_sub3.aBoolean1567) {
                if(loopCycle >= class30_sub2_sub4_sub3.anInt1564) {
                    class30_sub2_sub4_sub3.method454(this.anInt945, true);
                    if(class30_sub2_sub4_sub3.aBoolean1567) {
                        class30_sub2_sub4_sub3.unlink();
                    } else {
                        this.aClass25_946.method285(class30_sub2_sub4_sub3.anInt1560, 0, (byte)6, class30_sub2_sub4_sub3.anInt1563, -1L, class30_sub2_sub4_sub3.anInt1562, 60, class30_sub2_sub4_sub3.anInt1561, class30_sub2_sub4_sub3, false);
                    }
                }
            } else {
                class30_sub2_sub4_sub3.unlink();
            }
        }

    }

    public final void drawInterface(int j, int k, Widget class9, int l) {
        if(class9.type == 0 && class9.children != null) {
            if(!class9.isMouseoverTriggered || this.anInt1026 == class9.id || this.anInt1048 == class9.id || this.anInt1039 == class9.id) {
                int i1 = DrawingArea.leftX;
                int j1 = DrawingArea.topY;
                int k1 = DrawingArea.bottomX;
                int l1 = DrawingArea.bottomY;
                DrawingArea.setDrawingArea(l + class9.height, k, k + class9.width, l);
                int i2 = class9.children.length;

                for(int j2 = 0; j2 < i2; ++j2) {
                    int _x = class9.childX[j2] + k;
                    int _y = class9.childY[j2] + l - j;
                    Widget class9_1 = Widget.interfaceCache[class9.children[j2]];
                    _x += class9_1.anInt263;
                    _y += class9_1.anInt265;
                    if(class9_1.contentType > 0) {
                        this.method75(950, class9_1);
                    }

                    if(class9_1.type == 0) {
                        if(class9_1.scrollPosition > class9_1.scrollMax - class9_1.height) {
                            class9_1.scrollPosition = class9_1.scrollMax - class9_1.height;
                        }

                        if(class9_1.scrollPosition < 0) {
                            class9_1.scrollPosition = 0;
                        }

                        this.drawInterface(class9_1.scrollPosition, _x, class9_1, _y);
                        if(class9_1.scrollMax > class9_1.height) {
                            this.drawScrollbar(class9_1.height, class9_1.scrollPosition, _y, _x + class9_1.width, class9_1.scrollMax, false);
                        }
                    } else if(class9_1.type != 1) {
                        int k4;
                        int j5;
                        int i6;
                        int i9;
                        int k9;
                        int var25;
                        int var31;
                        int var32;
                        if(class9_1.type == 2) {
                            var25 = 0;

                            for(k4 = 0; k4 < class9_1.height; ++k4) {
                                for(j5 = 0; j5 < class9_1.width; ++j5) {
                                    i6 = _x + j5 * (32 + class9_1.invSpritePadX);
                                    var31 = _y + k4 * (32 + class9_1.invSpritePadY);
                                    if(var25 < 20) {
                                        i6 += class9_1.spritesX[var25];
                                        var31 += class9_1.spritesY[var25];
                                    }

                                    if(class9_1.inventoryItemId[var25] <= 0) {
                                        if(class9_1.sprites != null && var25 < 20) {
                                            Sprite var36 = class9_1.sprites[var25];
                                            if(var36 != null) {
                                                var36.drawSprite(i6, var31);
                                            }
                                        }
                                    } else {
                                        var32 = 0;
                                        i9 = 0;
                                        k9 = class9_1.inventoryItemId[var25] - 1;
                                        if(i6 > DrawingArea.leftX - 32 && i6 < DrawingArea.bottomX && var31 > DrawingArea.topY - 32 && var31 < DrawingArea.bottomY || this.anInt1086 != 0 && this.anInt1085 == var25) {
                                            int l9 = 0;
                                            if(this.anInt1282 == 1 && this.anInt1283 == var25 && this.anInt1284 == class9_1.id) {
                                                l9 = 16777215;
                                            }

                                            Sprite class30_sub2_sub1_sub1_2 = ItemDefinition.method200(k9, class9_1.inventoryAmounts[var25], l9, 9);
                                            if(class30_sub2_sub1_sub1_2 != null) {
                                                int k10;
                                                if(this.anInt1086 != 0 && this.anInt1085 == var25 && this.anInt1084 == class9_1.id) {
                                                    var32 = super.mouseX - this.anInt1087;
                                                    i9 = super.mouseY - this.anInt1088;
                                                    if(var32 < 5 && var32 > -5) {
                                                        var32 = 0;
                                                    }

                                                    if(i9 < 5 && i9 > -5) {
                                                        i9 = 0;
                                                    }

                                                    if(this.anInt989 < 5) {
                                                        var32 = 0;
                                                        i9 = 0;
                                                    }

                                                    class30_sub2_sub1_sub1_2.method350(i6 + var32, var31 + i9, 128, this.aBoolean1043);
                                                    if(var31 + i9 < DrawingArea.topY && class9.scrollPosition > 0) {
                                                        k10 = this.anInt945 * (DrawingArea.topY - var31 - i9) / 3;
                                                        if(k10 > this.anInt945 * 10) {
                                                            k10 = this.anInt945 * 10;
                                                        }

                                                        if(k10 > class9.scrollPosition) {
                                                            k10 = class9.scrollPosition;
                                                        }

                                                        class9.scrollPosition -= k10;
                                                        this.anInt1088 += k10;
                                                    }

                                                    if(var31 + i9 + 32 > DrawingArea.bottomY && class9.scrollPosition < class9.scrollMax - class9.height) {
                                                        k10 = this.anInt945 * (var31 + i9 + 32 - DrawingArea.bottomY) / 3;
                                                        if(k10 > this.anInt945 * 10) {
                                                            k10 = this.anInt945 * 10;
                                                        }

                                                        if(k10 > class9.scrollMax - class9.height - class9.scrollPosition) {
                                                            k10 = class9.scrollMax - class9.height - class9.scrollPosition;
                                                        }

                                                        class9.scrollPosition += k10;
                                                        this.anInt1088 -= k10;
                                                    }
                                                } else if(this.atInventoryInterfaceType != 0 && this.atInventoryIndex == var25 && this.atInventoryInterface == class9_1.id) {
                                                    class30_sub2_sub1_sub1_2.method350(i6, var31, 128, this.aBoolean1043);
                                                } else {
                                                    class30_sub2_sub1_sub1_2.drawSprite(i6, var31);
                                                }
                                                if (class9_1.id == Widget.selectedItemInterfaceId
                                                        && class9_1.itemSearchSelectedSlot > -1
                                                        && class9_1.itemSearchSelectedSlot == var25) {
                                                    for (int i = 32; i > 0; i--) {
                                                        Rasterizer.method338(i6 + i9, i, 256 - Byte.MAX_VALUE, 0x395D84, i,
                                                                var31 + var32, -17319);
                                                    }
                                                    Rasterizer.method338(i6 + i9, 32, 256, 0x395D84, 32, var31 + var32, -17319);
                                                }
                                                if(class30_sub2_sub1_sub1_2.maxWidth == 33 || class9_1.inventoryAmounts[var25] != 1) {
                                                    k10 = class9_1.inventoryAmounts[var25];
                                                    this.smallText.method385(0, intToKOrMil(k10), var31 + 10 + i9, 822, i6 + 1 + var32);
                                                    this.smallText.method385('\uff80', intToKOrMil(k10), var31 + 9 + i9, 822, i6 + var32);
                                                    this.smallText.method385('\uff80', intToKOrMil(k10), var31 + 9 + i9, 822, i6 + var32);
                                                }
                                            }
                                        }
                                    }

                                    ++var25;
                                }
                            }
                        } else if(class9_1.type == 3) {
                            boolean var27 = false;
                            if(this.anInt1039 == class9_1.id || this.anInt1048 == class9_1.id || this.anInt1026 == class9_1.id) {
                                var27 = true;
                            }

                            if(this.method131(class9_1, false)) {
                                k4 = class9_1.secondaryColor;
                                if(var27 && class9_1.anInt239 != 0) {
                                    k4 = class9_1.anInt239;
                                }
                            } else {
                                k4 = class9_1.textColor;
                                if(var27 && class9_1.anInt216 != 0) {
                                    k4 = class9_1.anInt216;
                                }
                            }

                            if(class9_1.aByte254 == 0) {
                                if(class9_1.aBoolean227) {
                                    DrawingArea.drawPixels(class9_1.height, _y, _x, k4, class9_1.width);
                                } else {
                                    DrawingArea.fillPixels(_x, class9_1.width, class9_1.height, k4, _y, true);
                                }
                            } else if(class9_1.aBoolean227) {
                                DrawingArea.method335(k4, _y, class9_1.width, class9_1.height, 256 - (class9_1.aByte254 & 255), 0, _x);
                            } else {
                                DrawingArea.method338(_y, class9_1.height, 256 - (class9_1.aByte254 & 255), k4, class9_1.width, _x, -17319);
                            }
                        } else {
                            RSFont class30_sub2_sub1_sub4_1;
                            if(class9_1.type == 4) {
                                class30_sub2_sub1_sub4_1 = class9_1.textDrawingAreas;
                                String var28 = class9_1.message;
                                boolean var29 = false;
                                if(this.anInt1039 == class9_1.id || this.anInt1048 == class9_1.id || this.anInt1026 == class9_1.id) {
                                    var29 = true;
                                }

                                if(this.method131(class9_1, false)) {
                                    i6 = class9_1.secondaryColor;
                                    if(var29 && class9_1.anInt239 != 0) {
                                        i6 = class9_1.anInt239;
                                    }

                                    if(class9_1.aString228.length() > 0) {
                                        var28 = class9_1.aString228;
                                    }
                                } else {
                                    i6 = class9_1.textColor;
                                    if(var29 && class9_1.anInt216 != 0) {
                                        i6 = class9_1.anInt216;
                                    }
                                }

                                if(class9_1.atActionType == 6 && this.aBoolean1149) {
                                    var28 = "Please wait...";
                                    i6 = class9_1.textColor;
                                }

                                if(DrawingArea.width == 479) {
                                    if(i6 == 16776960) {
                                        i6 = 255;
                                    }

                                    if(i6 == '\uc000') {
                                        i6 = 16777215;
                                    }
                                }

                                for(var31 = _y + class30_sub2_sub1_sub4_1.baseCharacterHeight; var28.length() > 0; var31 += class30_sub2_sub1_sub4_1.baseCharacterHeight) {
                                    if(var28.indexOf("%") != -1) {
                                        label372:
                                        while(true) {
                                            var32 = var28.indexOf("%1");
                                            if(var32 == -1) {
                                                while(true) {
                                                    var32 = var28.indexOf("%2");
                                                    if(var32 == -1) {
                                                        while(true) {
                                                            var32 = var28.indexOf("%3");
                                                            if(var32 == -1) {
                                                                while(true) {
                                                                    var32 = var28.indexOf("%4");
                                                                    if(var32 == -1) {
                                                                        while(true) {
                                                                            var32 = var28.indexOf("%5");
                                                                            if(var32 == -1) {
                                                                                break label372;
                                                                            }

                                                                            var28 = var28.substring(0, var32) + this.method93(369, this.method124(341, class9_1, 4)) + var28.substring(var32 + 2);
                                                                        }
                                                                    }

                                                                    var28 = var28.substring(0, var32) + this.method93(369, this.method124(341, class9_1, 3)) + var28.substring(var32 + 2);
                                                                }
                                                            }

                                                            var28 = var28.substring(0, var32) + this.method93(369, this.method124(341, class9_1, 2)) + var28.substring(var32 + 2);
                                                        }
                                                    }

                                                    var28 = var28.substring(0, var32) + this.method93(369, this.method124(341, class9_1, 1)) + var28.substring(var32 + 2);
                                                }
                                            }

                                            var28 = var28.substring(0, var32) + this.method93(369, this.method124(341, class9_1, 0)) + var28.substring(var32 + 2);
                                        }
                                    }

                                    var32 = var28.indexOf("\\n");
                                    String var35;
                                    if(var32 != -1) {
                                        var35 = var28.substring(0, var32);
                                        var28 = var28.substring(var32 + 2);
                                    } else {
                                        var35 = var28;
                                        var28 = "";
                                    }

                                    if(class9_1.centerText) {
                                        class30_sub2_sub1_sub4_1.drawCenteredString(var35, _x + class9_1.width / 2, var31, i6, class9_1.textShadow?0:-1);
                                    } else {
                                        class30_sub2_sub1_sub4_1.drawBasicString(var35, _x, var31, i6, class9_1.textShadow?0:-1);
                                    }
                                }
                            } else if(class9_1.type == 5) {
                                Sprite var26;
                                if(this.method131(class9_1, false)) {
                                    var26 = class9_1.enabledSprite;
                                } else {
                                    var26 = class9_1.disabledSprite;
                                }

                                if(var26 != null) {
                                    var26.drawSprite(_x, _y);
                                }
                            } else if(class9_1.type == 6) {
                                var25 = Rasterizer.centerX;
                                k4 = Rasterizer.centerY;
                                Rasterizer.centerX = _x + class9_1.width / 2;
                                Rasterizer.centerY = _y + class9_1.height / 2;
                                j5 = Rasterizer.anIntArray1470[class9_1.modelRotation1] * class9_1.modelZoom >> 16;
                                i6 = Rasterizer.anIntArray1471[class9_1.modelRotation1] * class9_1.modelZoom >> 16;
                                boolean var30 = this.method131(class9_1, false);
                                if(var30) {
                                    var32 = class9_1.enabledAnimationId;
                                } else {
                                    var32 = class9_1.disabledAnimationId;
                                }

                                Model var33;
                                if(var32 == -1) {
                                    var33 = class9_1.method209(0, -1, -1, var30);
                                } else {
                                    AnimationDefinition var34 = AnimationDefinition.anims[var32];
                                    var33 = class9_1.method209(0, var34.secondaryFrames[class9_1.anInt246], var34.frames[class9_1.anInt246], var30);
                                }

                                if(var33 != null) {
                                    var33.method482(0, class9_1.modelRotation2, 0, class9_1.modelRotation1, 0, j5, i6);
                                }

                                Rasterizer.centerX = var25;
                                Rasterizer.centerY = k4;
                            } else if(class9_1.type == 7) {
                                class30_sub2_sub1_sub4_1 = class9_1.textDrawingAreas;
                                k4 = 0;

                                for(j5 = 0; j5 < class9_1.height; ++j5) {
                                    for(i6 = 0; i6 < class9_1.width; ++i6) {
                                        if(class9_1.inventoryItemId[k4] > 0) {
                                            ItemDefinition class8 = ItemDefinition.method198(class9_1.inventoryItemId[k4] - 1);
                                            String s2 = class8.name;
                                            if(class8.stackable || class9_1.inventoryAmounts[k4] != 1) {
                                                s2 = s2 + " x" + method14(class9_1.inventoryAmounts[k4], 0);
                                            }

                                            i9 = _x + i6 * (115 + class9_1.invSpritePadX);
                                            k9 = _y + j5 * (12 + class9_1.invSpritePadY);
                                            if(class9_1.centerText) {
                                                class30_sub2_sub1_sub4_1.drawCenteredString(s2, i9 + class9_1.width / 2, k9, class9_1.textColor, class9_1.textShadow?0:-1);
                                            } else {
                                                class30_sub2_sub1_sub4_1.drawBasicString(s2, i9, k9, class9_1.textColor, class9_1.textShadow?0:-1);
                                            }
                                        }

                                        ++k4;
                                    }
                                }
                            } else if (class9_1.type == 16) {
                                drawInputField(class9_1, _x, _y, class9_1.width, class9_1.height);
                            } else if (class9_1.type == 20) {
                                int x = _x;
                                int y = _y;

                                // Set the scroll max based on the strings
                                if (class9_1.scrollableContainerInterfaceId != 0) {
                                    Widget container = Widget.get(class9_1.scrollableContainerInterfaceId);
                                    int scrollMax = class9_1.invAutoScrollHeightOffset;
                                    for (String string : class9_1.stringContainer)
                                        scrollMax += class9_1.invSpritePadY;
                                    if (scrollMax > container.height + 1) {
                                        container.scrollMax = scrollMax;
                                    } else {
                                        container.scrollMax = container.height + 1;
                                    }

                                    container.scrollMax += container.stringContainerContainerExtraScroll;
                                }

                                // Draw the container
                                for (String string : class9_1.stringContainer) {
                                    if (class9_1.centerText) {
                                        class9_1.font.drawCenteredString(string, x, y, class9_1.textColor, class9_1.textShadow ? 0 : -1);
                                    } else {
                                        class9_1.font.drawBasicString(string, x, y, class9_1.textColor, class9_1.textShadow ? 0 : -1);
                                    }
                                    y += class9_1.invSpritePadY;
                                }
                            }
                        }
                    }
                }

                DrawingArea.setDrawingArea(l1, i1, k1, j1);
            }
        }
    }

    public final void method106(Background background, int i) {
        short j = 256;
        if(i >= 0) {
            this.stream.writeUnsignedByte(126);
        }

        int l1;
        for(l1 = 0; l1 < this.anIntArray1190.length; ++l1) {
            this.anIntArray1190[l1] = 0;
        }

        int j2;
        for(l1 = 0; l1 < 5000; ++l1) {
            j2 = (int)(Math.random() * 128.0D * (double)j);
            this.anIntArray1190[j2] = (int)(Math.random() * 256.0D);
        }

        int l2;
        int i3;
        for(l1 = 0; l1 < 20; ++l1) {
            for(j2 = 1; j2 < j - 1; ++j2) {
                for(l2 = 1; l2 < 127; ++l2) {
                    i3 = l2 + (j2 << 7);
                    this.anIntArray1191[i3] = (this.anIntArray1190[i3 - 1] + this.anIntArray1190[i3 + 1] + this.anIntArray1190[i3 - 128] + this.anIntArray1190[i3 + 128]) / 4;
                }
            }

            int[] var10 = this.anIntArray1190;
            this.anIntArray1190 = this.anIntArray1191;
            this.anIntArray1191 = var10;
        }

        if(background != null) {
            l1 = 0;

            for(j2 = 0; j2 < background.anInt1453; ++j2) {
                for(l2 = 0; l2 < background.anInt1452; ++l2) {
                    if(background.aByteArray1450[l1++] != 0) {
                        i3 = l2 + 16 + background.anInt1454;
                        int j3 = j2 + 16 + background.anInt1455;
                        int k3 = i3 + (j3 << 7);
                        this.anIntArray1190[k3] = 0;
                    }
                }
            }
        }

    }

    private final void method107(int i, int j, Stream stream, byte byte0, Player player) {
        if(byte0 != 25) {
            this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
        }

        if((i & 1024) != 0) {
            player.anInt1543 = stream.readByteA(2);
            player.anInt1545 = stream.readByteA(2);
            player.anInt1544 = stream.readByteA(2);
            player.anInt1546 = stream.readByteA(2);
            player.anInt1547 = stream.method436((byte)-74) + loopCycle;
            player.anInt1548 = stream.readUShortA(true) + loopCycle;
            player.anInt1549 = stream.readByteA(2);
            player.method446(true);
        }

        int l1;
        if((i & 256) != 0) {
            player.anInt1520 = stream.method434((byte)108);
            l1 = stream.readDWord();
            player.anInt1524 = l1 >> 16;
            player.anInt1523 = loopCycle + (l1 & '\uffff');
            player.anInt1521 = 0;
            player.anInt1522 = 0;
            if(player.anInt1523 > loopCycle) {
                player.anInt1521 = -1;
            }

            if(player.anInt1520 == '\uffff') {
                player.anInt1520 = -1;
            }
        }

        int l2;
        int stream_1;
        if((i & 8) != 0) {
            l1 = stream.method434((byte)108);
            if(l1 == '\uffff') {
                l1 = -1;
            }

            l2 = stream.readByteC(false);
            if(l1 == player.primaryanim && l1 != -1) {
                stream_1 = AnimationDefinition.anims[l1].replayMode;
                if(stream_1 == 1) {
                    player.primaryanim_frameindex = 0;
                    player.primaryanim_loops_remaining = 0;
                    player.primaryanim_pause = l2;
                    player.primaryanim_replaycount = 0;
                }

                if(stream_1 == 2) {
                    player.primaryanim_replaycount = 0;
                }
            } else if(l1 == -1 || player.primaryanim == -1 || AnimationDefinition.anims[l1].anInt359 >= AnimationDefinition.anims[player.primaryanim].anInt359) {
                player.primaryanim = l1;
                player.primaryanim_frameindex = 0;
                player.primaryanim_loops_remaining = 0;
                player.primaryanim_pause = l2;
                player.primaryanim_replaycount = 0;
                player.anim_delay = player.waypoint_count;
            }
        }

        if((i & 4) != 0) {
            player.aString1506 = stream.readString();
            if(player.aString1506.charAt(0) == 126) {
                player.aString1506 = player.aString1506.substring(1);
                this.pushMessage(player.aString1506, 2, player.name);
            } else if(player == localPlayer) {
                this.pushMessage(player.aString1506, 2, player.name);
            }

            player.anInt1513 = 0;
            player.anInt1531 = 0;
            player.textCycle = 150;
        }

        if((i & 128) != 0) {
            l1 = stream.method434((byte)108);
            l2 = stream.readUnsignedByte();
            stream_1 = stream.readByteC(false);
            int k3 = stream.currentPosition;
            if(player.name != null && player.aBoolean1710) {
                long l3 = TextClass.longForName(player.name);
                boolean flag = false;
                if(l2 <= 1) {
                    for(int exception = 0; exception < this.anInt822; ++exception) {
                        if(this.aLongArray925[exception] == l3) {
                            flag = true;
                            break;
                        }
                    }
                }

                if(!flag && this.anInt1251 == 0) {
                    try {
                        this.aStream_834.currentPosition = 0;
                        stream.method442(stream_1, 0, true, this.aStream_834.buffer);
                        this.aStream_834.currentPosition = 0;
                        String var17 = TextInput.method525(stream_1, true, this.aStream_834);
                        var17 = Censor.method497(var17, 0);
                        player.aString1506 = var17;
                        player.anInt1513 = l1 >> 8;
                        player.anInt1531 = l1 & 255;
                        player.textCycle = 150;
                        switch(l2) {
                            case 1:
                                this.pushMessage(var17, 1, "@cr1@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 2:
                                this.pushMessage(var17, 1, "@cr2@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 3:
                                this.pushMessage(var17, 1, "@cr3@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 4:
                                this.pushMessage(var17, 1, "@cr4@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 5:
                                this.pushMessage(var17, 1, "@cr5@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 6:
                                this.pushMessage(var17, 1, "@cr6@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 7:
                                this.pushMessage(var17, 1, "@cr7@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 8:
                                this.pushMessage(var17, 1, "@cr8@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 9:
                                this.pushMessage(var17, 1, "@cr9@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 10:
                                this.pushMessage(var17, 1, "@cr10@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 11:
                                this.pushMessage(var17, 1, "@cr11@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 12:
                                this.pushMessage(var17, 1, "@cr12@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 13:
                                this.pushMessage(var17, 1, "@cr13@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 14:
                                this.pushMessage(var17, 1, "@cr14@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 15:
                                this.pushMessage(var17, 1, "@cr15@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 16:
                                this.pushMessage(var17, 1, "@cr16@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 17:
                                this.pushMessage(var17, 1, "@cr17@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 18:
                                this.pushMessage(var17, 1, "@cr18@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 19:
                                this.pushMessage(var17, 1, "@cr19@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 20:
                                this.pushMessage(var17, 1, "@cr20@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 21:
                                this.pushMessage(var17, 1, "@cr21@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 22:
                                this.pushMessage(var17, 1, "@cr22@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 23:
                                this.pushMessage(var17, 1, "@cr23@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 24:
                                this.pushMessage(var17, 1, "@cr24@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            case 25:
                                this.pushMessage(var17, 1, "@cr25@" + this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                                break;
                            default:
                                this.pushMessage(var17, 2, this.prefixRank(player.title) + player.name + this.suffixRank(player.title));
                        }
                    } catch (Exception var14) {
                        signlink.reporterror("cde2");
                    }
                }
            }

            stream.currentPosition = k3 + stream_1;
        }

        if((i & 1) != 0) {
            player.anInt1502 = stream.method434((byte)108);
            if(player.anInt1502 == '\uffff') {
                player.anInt1502 = -1;
            }
        }

        if((i & 16) != 0) {
            l1 = stream.readByteC(false);
            byte[] var15 = new byte[l1];
            Stream var16 = new Stream(var15, 891);
            stream.method417(l1, this.aByte920, 0, var15);
            this.aStreamArray895[j] = var16;
            player.method451(0, var16);
        }

        if((i & 2) != 0) {
            player.face_x = stream.method436((byte)-74);
            player.face_y = stream.method434((byte)108);
        }

        if((i & 32) != 0) {
            l1 = stream.readUnsignedByte();
            l2 = stream.readByteS(0);
            player.method447(-35698, l2, l1, loopCycle);
            player.anInt1532 = loopCycle + 300;
            player.currentHealth = stream.readByteC(false);
            player.maxHealth = stream.readUnsignedByte();
        }

        if((i & 512) != 0) {
            l1 = stream.readUnsignedByte();
            l2 = stream.readByteA(2);
            player.method447(-35698, l2, l1, loopCycle);
            player.anInt1532 = loopCycle + 300;
            player.currentHealth = stream.readUnsignedByte();
            player.maxHealth = stream.readByteC(false);
        }

    }

    public final void method108(int i) {
        if(i != 3) {
            this.packet = -1;
        }

        try {
            int _ex = localPlayer.anInt1550 + this.anInt1278;
            int k = localPlayer.anInt1551 + this.anInt1131;
            if(this.anInt1014 - _ex < -500 || this.anInt1014 - _ex > 500 || this.anInt1015 - k < -500 || this.anInt1015 - k > 500) {
                this.anInt1014 = _ex;
                this.anInt1015 = k;
            }

            if(this.anInt1014 != _ex) {
                this.anInt1014 += (_ex - this.anInt1014) / 16;
            }

            if(this.anInt1015 != k) {
                this.anInt1015 += (k - this.anInt1015) / 16;
            }

            if(super.anIntArray30[1] == 1) {
                this.anInt1186 += (-24 - this.anInt1186) / 2;
            } else if(super.anIntArray30[2] == 1) {
                this.anInt1186 += (24 - this.anInt1186) / 2;
            } else {
                this.anInt1186 /= 2;
            }

            if(super.anIntArray30[3] == 1) {
                this.anInt1187 += (12 - this.anInt1187) / 2;
            } else if(super.anIntArray30[4] == 1) {
                this.anInt1187 += (-12 - this.anInt1187) / 2;
            } else {
                this.anInt1187 /= 2;
            }

            this.anInt1185 = this.anInt1185 + this.anInt1186 / 2 & 2047;
            this.anInt1184 += this.anInt1187 / 2;
            if(this.anInt1184 < 128) {
                this.anInt1184 = 128;
            }

            if(this.anInt1184 > 383) {
                this.anInt1184 = 383;
            }

            int l = this.anInt1014 >> 7;
            int i1 = this.anInt1015 >> 7;
            int j1 = this.method42(this.anInt918, this.anInt1015, true, this.anInt1014);
            int k1 = 0;
            int j2;
            if(l > 3 && i1 > 3 && l < 100 && i1 < 100) {
                for(j2 = l - 4; j2 <= l + 4; ++j2) {
                    for(int k2 = i1 - 4; k2 <= i1 + 4; ++k2) {
                        int l2 = this.anInt918;
                        if(l2 < 3 && (this.aByteArrayArrayArray1258[1][j2][k2] & 2) == 2) {
                            ++l2;
                        }

                        int i3 = j1 - this.anIntArrayArrayArray1214[l2][j2][k2];
                        if(i3 > k1) {
                            k1 = i3;
                        }
                    }
                }
            }

            ++anInt1005;
            if(anInt1005 > 1512) {
                anInt1005 = 0;
                this.stream.createFrame(77);
                this.stream.writeUnsignedByte(0);
                j2 = this.stream.currentPosition;
                this.stream.writeUnsignedByte((int)(Math.random() * 256.0D));
                this.stream.writeUnsignedByte(101);
                this.stream.writeUnsignedByte(233);
                this.stream.writeWord('\ub024');
                if((int)(Math.random() * 2.0D) == 0) {
                    this.stream.writeWord('\u8bc8');
                }

                this.stream.writeUnsignedByte((int)(Math.random() * 256.0D));
                this.stream.writeUnsignedByte(64);
                this.stream.writeUnsignedByte(38);
                this.stream.writeWord((int)(Math.random() * 65536.0D));
                this.stream.writeWord((int)(Math.random() * 65536.0D));
                this.stream.method407(this.stream.currentPosition - j2, (byte)0);
            }

            j2 = k1 * 192;
            if(j2 > 98048) {
                j2 = 98048;
            }

            if(j2 < '\u8000') {
                j2 = '\u8000';
            }

            if(j2 > this.anInt984) {
                this.anInt984 += (j2 - this.anInt984) / 24;
            } else if(j2 < this.anInt984) {
                this.anInt984 += (j2 - this.anInt984) / 80;
            }
        } catch (Exception var12) {
            signlink.reporterror("glfc_ex " + localPlayer.anInt1550 + "," + localPlayer.anInt1551 + "," + this.anInt1014 + "," + this.anInt1015 + "," + this.currentRegionX + "," + this.currentRegionY + "," + this.baseX + "," + this.baseY);
            throw new RuntimeException("eek");
        }
    }

    public final void method9(int i) {
        if(!this.aBoolean1252 && !this.aBoolean926 && !this.aBoolean1176) {
            ++anInt1061;
            if(i != 0) {
                this.packet = -1;
            }

            if(!loggedIn) {
                this.method135(false, false);
            } else {
                this.method102(true);
            }

            this.anInt1213 = 0;
        } else {
            this.method94(-13873);
        }
    }

    public final boolean method109(String s) {
        if(s == null) {
            return false;
        } else {
            for(int i = 0; i < this.friendsCount; ++i) {
                if(s.equalsIgnoreCase(this.friendsList[i])) {
                    return true;
                }
            }

            return s.equalsIgnoreCase(localPlayer.name);
        }
    }

    public static final String combatDiffColor(int i, int j, boolean flag) {
        if(!flag) {
            throw new NullPointerException();
        } else {
            int k = i - j;
            return k < -9?"<col=ff0000>":(k < -6?"<col=ff3000>":(k < -3?"<col=ff7000>":(k < 0?"<col=ffb000>":(k > 9?"<col=65280>":(k > 6?"<col=40ff00>":(k > 3?"<col=80ff00>":(k > 0?"<col=c0ff00>":"<col=ffff00>")))))));
        }
    }

    public final void method111(byte byte0, int i) {
        if(byte0 == 2) {
            boolean byte01 = false;
        } else {
            this.method6();
        }

        signlink.wavevol = i;
    }

    private void buildBroadcasts() {
        byte i = 0;
        if(BroadcastManager.isDisplayed()) {
            Broadcast bc = BroadcastManager.getCurrentBroadcast();
            if(bc == null) {
                return;
            }

            boolean update = this.isServerUpdating();
            int yPosition = (!this.isResized()?330:currentGameHeight - 173) - i * 13;
            yPosition -= update?13:0;
            int messageLength = this.newRegularFont.getTextWidth(bc.getDecoratedMessage());
            if(openInterfaceID <= 0 && super.mouseX >= 0 && super.mouseX <= messageLength && super.mouseY >= yPosition - 10 && super.mouseY <= yPosition) {
                this.menuActionName[this.menuActionRow] = "Dismiss";
                this.menuActionID[this.menuActionRow] = 11115;
                ++this.menuActionRow;
                if(bc.type != 0) {
                    this.menuActionName[this.menuActionRow] = bc.type == 1?"Open URL":(bc.type == 2?"Teleport To Location":null);
                    this.menuActionID[this.menuActionRow] = bc.type == 1?11111:11112;
                    ++this.menuActionRow;
                }
            }

            int var6 = i + 1;
            if(var6 >= 1) {
                ;
            }
        }

    }

    public final void draw3dScreen(int i) {
        if(i != 8) {
            this.anInt939 = 130;
        }

        this.method76((byte)-13);
        int y2;
        if(this.crossType == 1) {
            y2 = currentScreenMode == client.ScreenMode.FIXED?4:0;
            this.aSpriteArray1150[this.anInt916 / 100].drawSprite(this.anInt914 - 8 - y2, this.anInt915 - 8 - y2);
            ++anInt1142;
            if(anInt1142 > 67) {
                anInt1142 = 0;
                this.stream.createFrame(78);
            }
        }

        if(this.crossType == 2) {
            y2 = currentScreenMode == client.ScreenMode.FIXED?4:0;
            this.aSpriteArray1150[4 + this.anInt916 / 100].drawSprite(this.anInt914 - 8 - y2, this.anInt915 - 8 - y2);
        }

        if(currentScreenMode == client.ScreenMode.FIXED) {
            this.gameframe[63].drawSprite(516, 0);
            this.gameframe[62].drawSprite(0, 0);
        }

        if(this.openWalkableInterface != -1) {
            this.method119(this.anInt945, false, this.openWalkableInterface);
            if(this.openWalkableInterface == 197 && currentScreenMode != client.ScreenMode.FIXED) {
                this.skullIcons[0].drawSprite(currentGameWidth - 157, 168);
                String x = Widget.interfaceCache[199].message.replace("@yel@", "");
                this.regularText.drawChatInput(14784541, currentGameWidth - 165, x, 207, true);
            } else if(this.openWalkableInterface == 201 && currentScreenMode != client.ScreenMode.FIXED) {
                this.drawInterface(0, currentGameWidth - 560, Widget.interfaceCache[this.openWalkableInterface], -109);
            } else {
                this.drawInterface(0, currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth / 2 - 356, Widget.interfaceCache[this.openWalkableInterface], currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight / 2 - 230);
            }
        }

        if(openInterfaceID != -1) {
            this.method119(this.anInt945, false, openInterfaceID);
            if(currentScreenMode == client.ScreenMode.FIXED) {
                this.drawInterface(0, 0, Widget.interfaceCache[openInterfaceID], 0);
            } else {
                this.drawInterface(0, currentGameWidth / 2 - 356, Widget.interfaceCache[openInterfaceID], currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight / 2 - 230);
            }
        }

        if(!this.menuOpen) {
            this.processRightClick(0);
            this.method125('\ub28a');
        } else if(this.menuScreenArea == 0) {
            this.drawMenu(currentScreenMode == client.ScreenMode.FIXED?0:0, currentScreenMode == client.ScreenMode.FIXED?0:0);
        }

        BroadcastManager.display(this);
        if(this.anInt1055 == 1) {
            this.headIcons[1].drawSprite(currentScreenMode == client.ScreenMode.FIXED?472:currentGameWidth - 85, currentScreenMode == client.ScreenMode.FIXED?296:186);
        }

        int var131;
        int var12;
        int var141;
        int var18;
        if(fpsOn) {
            boolean var161 = true;
            byte y = 20;
            var131 = currentScreenMode == client.ScreenMode.FIXED?515:currentGameWidth - 222;
            var12 = 16776960;
            if(super.anInt8 < 15) {
                var12 = 16711680;
            }

            this.regularText.method380("Fps:" + super.anInt8, var131, var12, (byte)-80, y);
            var18 = y + 15;
            Runtime chunkX = Runtime.getRuntime();
            var141 = (int)((chunkX.totalMemory() - chunkX.freeMemory()) / 1024L);
            var12 = 16776960;
            if(var141 > 33554432 && lowMemory) {
                var12 = 16711680;
            }

            this.regularText.method380("Mem:" + var141 + "k", var131, 16776960, (byte)-80, var18);
            var18 += 15;
        }

        int var17 = this.baseX + (localPlayer.anInt1550 - 6 >> 7);
        var18 = this.baseY + (localPlayer.anInt1551 - 6 >> 7);
        var131 = var17 >> 6;
        var12 = var18 >> 6;
        int var20 = var17 >> 3;
        var141 = var18 >> 3;
        int regionid = var131 * 256 + var12;
        int mapx = this.currentRegionX;
        int mapy = this.currentRegionY;
        int l;
        int var16;
        if(clientData) {
            Runtime j = Runtime.getRuntime();
            l = (int)((j.totalMemory() - j.freeMemory()) / 1024L);
            this.regularText.method385('\uff00', "Players Nearby: " + this.anInt891, 27, -80, 5);
            this.regularText.method385('\uff00', "Npcs Nearby: " + this.npcCount, 41, -80, 5);
            if(mapx <= 1000 && mapy <= 1000) {
                this.regularText.method385(16776960, "Current Region: 0" + mapx + ", 0" + mapy + ", Region ID: " + regionid, 55, -80, 5);
            } else {
                this.regularText.method385(16776960, "Current Region: " + mapx + ", " + mapy + ", Region ID: " + regionid, 55, -80, 5);
            }

            int[] obj;
            for(var16 = 0; var16 < this.terrainIndices.length; ++var16) {
                obj = this.terrainIndices;
                this.regularText.method385(16776960, "Floor map: " + Arrays.toString(obj), 69, -80, 5);
            }

            for(var16 = 0; var16 < this.objectIndices.length; ++var16) {
                obj = this.objectIndices;
                this.regularText.method385(16776960, "Object map: " + Arrays.toString(obj), 83, -80, 5);
            }

            this.regularText.method385(16776960, "Map Data: " + this.terrainIndices[0] + ".dat", 97, -80, 5);
            this.regularText.method385(16776960, "Fps: " + super.anInt8, 111, -80, 5);
            this.regularText.method385(16776960, "Memory Used: " + l / 1024 + "MB", 125, -80, 5);
            this.regularText.method385(16776960, "Coordinates: X: " + var17 + ", Y: " + var18, 153, -80, 5);
            this.regularText.method385(16776960, "Camera Position: X: " + this.xCameraPos + ", Y: " + this.yCameraPos + ", Z: " + this.zCameraPos, 167, -80, 5);
            this.regularText.method385(16776960, "Camera Curve: X: " + this.xCameraCurve + ", Y: " + this.yCameraCurve, -80, 181, 5);
            short var19 = 181;
            var18 = var19 + 15;
        }

        if(this.anInt1104 != 0) {
            int var21 = this.anInt1104 / 50;
            l = var21 / 60;
            var16 = currentScreenMode == client.ScreenMode.FIXED?0:currentGameHeight - 498;
            var21 %= 60;
            if(var21 < 10) {
                this.regularText.method385(16776960, "System update in: " + l + ":0" + var21, 329 + var16, 822, 4);
            } else {
                this.regularText.method385(16776960, "System update in: " + l + ":" + var21, 329 + var16, 822, 4);
            }

            ++anInt849;
            if(anInt849 > 75) {
                anInt849 = 0;
                this.stream.createFrame(148);
            }
        }

    }

    public final void method113(long l, int i) {
        try {
            if(l != 0L) {
                if(this.anInt822 >= 100) {
                    this.pushMessage("Your ignore list is full. Max of 100 hit", 0, "");
                } else {
                    String runtimeexception = TextClass.fixName(TextClass.nameForLong(l));

                    int k;
                    for(k = 0; k < this.anInt822; ++k) {
                        if(this.aLongArray925[k] == l) {
                            this.pushMessage(runtimeexception + " is already on your ignore list", 0, "");
                            return;
                        }
                    }

                    if(i >= 4 && i <= 4) {
                        for(k = 0; k < this.friendsCount; ++k) {
                            if(this.friendsListAsLongs[k] == l) {
                                this.pushMessage("Please remove " + runtimeexception + " from your friend list first", 0, "");
                                return;
                            }
                        }

                        this.aLongArray925[this.anInt822++] = l;
                        this.tabAreaAltered = true;
                        this.stream.createFrame(133);
                        this.stream.method404(5, l);
                    }
                }
            }
        } catch (RuntimeException var6) {
            signlink.reporterror("45688, " + l + ", " + i + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public final void method114(byte byte0) {
        if(byte0 == this.aByte973) {
            for(int i = -1; i < this.anInt891; ++i) {
                int j;
                if(i == -1) {
                    j = this.maxPlayerCount;
                } else {
                    j = this.anIntArray892[i];
                }

                Player player = this.players[j];
                if(player != null) {
                    this.method96('\ub78c', 1, player);
                }
            }

        }
    }

    private final void method115(byte byte0) {
        if(byte0 == 8) {
            boolean var3 = false;
        } else {
            this.stream.writeUnsignedByte(101);
        }

        if(this.anInt1023 == 2) {
            for(Class30_Sub1 class30_sub1 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetFirst(); class30_sub1 != null; class30_sub1 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetNext(false)) {
                if(class30_sub1.anInt1294 > 0) {
                    --class30_sub1.anInt1294;
                }

                if(class30_sub1.anInt1294 == 0) {
                    if(class30_sub1.anInt1299 < 0 || ObjectManager.method178(class30_sub1.anInt1299, class30_sub1.anInt1301, 8)) {
                        this.method142(class30_sub1.anInt1298, class30_sub1.anInt1295, class30_sub1.anInt1300, class30_sub1.anInt1301, class30_sub1.anInt1297, class30_sub1.anInt1296, class30_sub1.anInt1299, 4);
                        class30_sub1.unlink();
                    }
                } else {
                    if(class30_sub1.anInt1302 > 0) {
                        --class30_sub1.anInt1302;
                    }

                    if(class30_sub1.anInt1302 == 0 && class30_sub1.anInt1297 >= 1 && class30_sub1.anInt1298 >= 1 && class30_sub1.anInt1297 <= 102 && class30_sub1.anInt1298 <= 102 && (class30_sub1.anInt1291 < 0 || ObjectManager.method178(class30_sub1.anInt1291, class30_sub1.anInt1293, 8))) {
                        this.method142(class30_sub1.anInt1298, class30_sub1.anInt1295, class30_sub1.anInt1292, class30_sub1.anInt1293, class30_sub1.anInt1297, class30_sub1.anInt1296, class30_sub1.anInt1291, 4);
                        class30_sub1.anInt1302 = -1;
                        if(class30_sub1.anInt1291 == class30_sub1.anInt1299 && class30_sub1.anInt1299 == -1) {
                            class30_sub1.unlink();
                        } else if(class30_sub1.anInt1291 == class30_sub1.anInt1299 && class30_sub1.anInt1292 == class30_sub1.anInt1300 && class30_sub1.anInt1293 == class30_sub1.anInt1301) {
                            class30_sub1.unlink();
                        }
                    }
                }
            }
        }

    }

    public final void method116(boolean flag) {
        int i = this.newBoldFont.getTextWidth("Choose Option");
        loggedIn &= flag;

        int l;
        int i1;
        for(l = 0; l < this.menuActionRow; ++l) {
            i1 = this.newBoldFont.getTextWidth(this.menuActionName[l]);
            if(i1 > i) {
                i = i1;
            }
        }

        i += 8;
        l = 15 * this.menuActionRow + 21;
        if(super.saveClickX > 0 && super.saveClickY > 0 && super.saveClickX < currentGameWidth && super.saveClickY < currentGameHeight) {
            i1 = super.saveClickX - i / 2;
            if(i1 + i > currentGameWidth - 4) {
                i1 = currentGameWidth - 4 - i;
            }

            if(i1 < 0) {
                i1 = 0;
            }

            int l1 = super.saveClickY;
            if(l1 + l > currentGameHeight - 2) {
                l1 = currentGameHeight - 2 - l;
            }

            if(l1 < 0) {
                l1 = 0;
            }

            this.menuOpen = true;
            this.anInt949 = i1;
            this.anInt950 = l1;
            this.anInt951 = i;
            this.anInt952 = 15 * this.menuActionRow + 22;
        }

    }

    private void update_self_player(Stream stream) {
        stream.initBitAccess(this.anInt1118);
        int j = stream.readBits(1);
        if (j == 0)
            return;
            int k = stream.readBits(2);
            if(k == 0) {
                this.anIntArray894[this.anInt893++] = this.maxPlayerCount;
                return;
            }
             if(k == 1) {
                 int j1 = stream.readBits(3);
                 localPlayer.moveInDir(false, (byte)20, j1);
                 int i2 = stream.readBits(1);
                 if(i2 == 1)
                    this.anIntArray894[this.anInt893++] = this.maxPlayerCount;
                    return;
                }

                    if(k == 2) {
                        int j1 = stream.readBits(3);
                        localPlayer.moveInDir(true, (byte)20, j1);
                        int i2 = stream.readBits(3);
                        localPlayer.moveInDir(true, (byte)20, i2);
                        int k2 = stream.readBits(1);
                        if(k2 == 1)
                            this.anIntArray894[this.anInt893++] = this.maxPlayerCount;
                        return;
                    }
                        if(k == 3) {
                            this.anInt918 = stream.readBits(2);
                            int j1 = stream.readBits(1);
                            int i2 = stream.readBits(1);
                            if(i2 == 1)
                                this.anIntArray894[this.anInt893++] = this.maxPlayerCount;
                            int k2 = stream.readBits(7);
                            int l2 = stream.readBits(7);
                            localPlayer.setPos(l2, k2, j1 == 1, false);
                        }

    }

    public void nullLoader() {
        this.aBoolean831 = false;

        while(this.drawingFlames) {
            this.aBoolean831 = false;

            try {
                Thread.sleep(50L);
            } catch (Exception var3) {
                ;
            }
        }

        this.aBackground_966 = null;
        this.aBackground_967 = null;
        this.aBackgroundArray1152 = null;
        this.anIntArray850 = null;
        this.anIntArray851 = null;
        this.anIntArray852 = null;
        this.anIntArray853 = null;
        this.anIntArray1190 = null;
        this.anIntArray1191 = null;
        this.anIntArray828 = null;
        this.anIntArray829 = null;
        this.aSprite_1201 = null;
        this.aSprite_1202 = null;

    }

    public final boolean method119(int i, boolean flag, int j) {
        boolean flag1 = false;
        if(flag) {
            throw new NullPointerException();
        } else {
            Widget class9 = Widget.interfaceCache[j];

            for(int k = 0; k < class9.children.length && class9.children[k] != -1; ++k) {
                Widget class9_1 = Widget.interfaceCache[class9.children[k]];
                if(class9_1.type == 1) {
                    flag1 |= this.method119(i, false, class9_1.id);
                }

                if(class9_1.type == 6 && (class9_1.disabledAnimationId != -1 || class9_1.enabledAnimationId != -1)) {
                    boolean flag2 = this.method131(class9_1, false);
                    int l;
                    if(flag2) {
                        l = class9_1.enabledAnimationId;
                    } else {
                        l = class9_1.disabledAnimationId;
                    }

                    if(l != -1) {
                        AnimationDefinition class20 = AnimationDefinition.anims[l];

                        for(class9_1.anInt208 += i; class9_1.anInt208 > class20.method258(class9_1.anInt246, (byte)-39); flag1 = true) {
                            class9_1.anInt208 -= class20.method258(class9_1.anInt246, (byte)-39) + 1;
                            ++class9_1.anInt246;
                            if(class9_1.anInt246 >= class20.frameCount) {
                                class9_1.anInt246 -= class20.anInt356;
                                if(class9_1.anInt246 < 0 || class9_1.anInt246 >= class20.frameCount) {
                                    class9_1.anInt246 = 0;
                                }
                            }
                        }
                    }
                }
            }

            return flag1;
        }
    }

    public final int method120(int i) {
        if(i <= 0) {
            aBoolean1224 = !aBoolean1224;
        }

        if(this.roofsOff) {
            return this.anInt918;
        } else {
            int j = 3;
            if(this.yCameraCurve < 310) {
                int k = this.xCameraPos >> 7;
                int l = this.yCameraPos >> 7;
                int i1 = localPlayer.anInt1550 >> 7;
                int j1 = localPlayer.anInt1551 >> 7;
                if((this.aByteArrayArrayArray1258[this.anInt918][k][l] & 4) != 0) {
                    j = this.anInt918;
                }

                int k1;
                if(i1 > k) {
                    k1 = i1 - k;
                } else {
                    k1 = k - i1;
                }

                int l1;
                if(j1 > l) {
                    l1 = j1 - l;
                } else {
                    l1 = l - j1;
                }

                int j2;
                int l2;
                if(k1 > l1) {
                    j2 = l1 * 65536 / k1;
                    l2 = '\u8000';

                    while(k != i1) {
                        if(k < i1) {
                            ++k;
                        } else if(k > i1) {
                            --k;
                        }

                        if((this.aByteArrayArrayArray1258[this.anInt918][k][l] & 4) != 0) {
                            j = this.anInt918;
                        }

                        l2 += j2;
                        if(l2 >= 65536) {
                            l2 -= 65536;
                            if(l < j1) {
                                ++l;
                            } else if(l > j1) {
                                --l;
                            }

                            if((this.aByteArrayArrayArray1258[this.anInt918][k][l] & 4) != 0) {
                                j = this.anInt918;
                            }
                        }
                    }
                } else {
                    j2 = k1 * 65536 / l1;
                    l2 = '\u8000';

                    while(l != j1) {
                        if(l < j1) {
                            ++l;
                        } else if(l > j1) {
                            --l;
                        }

                        if((this.aByteArrayArrayArray1258[this.anInt918][k][l] & 4) != 0) {
                            j = this.anInt918;
                        }

                        l2 += j2;
                        if(l2 >= 65536) {
                            l2 -= 65536;
                            if(k < i1) {
                                ++k;
                            } else if(k > i1) {
                                --k;
                            }

                            if((this.aByteArrayArrayArray1258[this.anInt918][k][l] & 4) != 0) {
                                j = this.anInt918;
                            }
                        }
                    }
                }
            }

            if((this.aByteArrayArrayArray1258[this.anInt918][localPlayer.anInt1550 >> 7][localPlayer.anInt1551 >> 7] & 4) != 0) {
                j = this.anInt918;
            }

            return j;
        }
    }

    public final int method121(int i) {
        if(this.roofsOff) {
            return this.anInt918;
        } else {
            int j = this.method42(this.anInt918, this.yCameraPos, true, this.xCameraPos);
            return j - this.zCameraPos < 800 && (this.aByteArrayArrayArray1258[this.anInt918][this.xCameraPos >> 7][this.yCameraPos >> 7] & 4) != 0?this.anInt918:3;
        }
    }

    public final void method122(int i, long l) {
        try {
            if(i != 3) {
                this.method6();
            }

            if(l != 0L) {
                for(int runtimeexception = 0; runtimeexception < this.anInt822; ++runtimeexception) {
                    if(this.aLongArray925[runtimeexception] == l) {
                        --this.anInt822;
                        this.tabAreaAltered = true;

                        for(int k = runtimeexception; k < this.anInt822; ++k) {
                            this.aLongArray925[k] = this.aLongArray925[k + 1];
                        }

                        this.stream.createFrame(74);
                        this.stream.method404(5, l);
                        return;
                    }
                }

            }
        } catch (RuntimeException var6) {
            signlink.reporterror("47229, " + i + ", " + l + ", " + var6.toString());
            throw new RuntimeException();
        }
    }

    public String getParameter(String s) {
        return signlink.mainapp != null?signlink.mainapp.getParameter(s):super.getParameter(s);
    }

    public void playSong(int id) {
        if(this.currentSong != id) {
            this.nextSong = id;
            this.songChanging = true;
            onDemandFetcher.method558(2, this.nextSong);
            this.currentSong = id;
        }

    }

    public final void method123(byte byte0, boolean flag, int i) {
        if(byte0 == 0) {
            boolean byte01 = false;
        } else {
            this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
        }

        signlink.setVolume(i);
        if(flag) {
            signlink.midi = "voladjust";
        }

    }

    public void stopMidi() {
        signlink.music.stop();
        signlink.fadeMidi = 0;
        signlink.midi = "stop";
    }

    private void adjustVolume(boolean updateMidi, int volume) {
        signlink.setVolume(volume);
        if(updateMidi) {
            signlink.midi = "voladjust";
        }

    }

    public final int method124(int i, Widget class9, int j) {
        i = 91 / i;
        if(class9.valueIndexArray != null && j < class9.valueIndexArray.length) {
            try {
                int[] _ex = class9.valueIndexArray[j];
                int k = 0;
                int l = 0;
                byte i1 = 0;

                while(true) {
                    int j1 = _ex[l++];
                    int k1 = 0;
                    byte byte0 = 0;
                    if(j1 == 0) {
                        return k;
                    }

                    if(j1 == 1) {
                        k1 = this.currentLevels[_ex[l++]];
                    }

                    if(j1 == 2) {
                        k1 = this.maximumLevels[_ex[l++]];
                    }

                    if(j1 == 3) {
                        k1 = this.currentExp[_ex[l++]];
                    }

                    Widget j2;
                    int varBit;
                    int l3;
                    if(j1 == 4) {
                        j2 = Widget.interfaceCache[_ex[l++]];
                        varBit = _ex[l++];
                        if(varBit >= 0 && varBit < ItemDefinition.anInt203 && (!ItemDefinition.method198(varBit).membersObject || aBoolean959)) {
                            for(l3 = 0; l3 < j2.inventoryItemId.length; ++l3) {
                                if(j2.inventoryItemId[l3] == varBit + 1) {
                                    k1 += j2.inventoryAmounts[l3];
                                }
                            }
                        }
                    }

                    if(j1 == 5) {
                        k1 = this.variousSettings[_ex[l++]];
                    }

                    if(j1 == 6) {
                        k1 = anIntArray1019[this.maximumLevels[_ex[l++]] - 1];
                    }

                    if(j1 == 7) {
                        k1 = this.variousSettings[_ex[l++]] * 100 / '\ub71b';
                    }

                    if(j1 == 8) {
                        k1 = localPlayer.combatLevel;
                    }

                    int var18;
                    if(j1 == 9) {
                        for(var18 = 0; var18 < Skills.SKILLS_COUNT; ++var18) {
                            if(Skills.SKILLS_ENABLED[var18]) {
                                k1 += this.maximumLevels[var18];
                            }
                        }
                    }

                    if(j1 == 10) {
                        j2 = Widget.interfaceCache[_ex[l++]];
                        varBit = _ex[l++] + 1;
                        if(varBit >= 0 && varBit < ItemDefinition.anInt203 && (!ItemDefinition.method198(varBit).membersObject || aBoolean959)) {
                            for(l3 = 0; l3 < j2.inventoryItemId.length; ++l3) {
                                if(j2.inventoryItemId[l3] == varBit) {
                                    k1 = 999999999;
                                    break;
                                }
                            }
                        }
                    }

                    if(j1 == 11) {
                        k1 = this.anInt1148;
                    }

                    if(j1 == 12) {
                        k1 = this.anInt878;
                    }

                    if(j1 == 13) {
                        var18 = this.variousSettings[_ex[l++]];
                        varBit = _ex[l++];
                        k1 = (var18 & 1 << varBit) == 0?0:1;
                    }

                    if(j1 == 14) {
                        var18 = _ex[l++];
                        VarBit var19 = VarBit.cache[var18];
                        l3 = var19.anInt648;
                        int i4 = var19.anInt649;
                        int j4 = var19.anInt650;
                        int k4 = anIntArray1232[j4 - i4];
                        k1 = this.variousSettings[l3] >> i4 & k4;
                    }

                    if(j1 == 15) {
                        byte0 = 1;
                    }

                    if(j1 == 16) {
                        byte0 = 2;
                    }

                    if(j1 == 17) {
                        byte0 = 3;
                    }

                    if(j1 == 18) {
                        k1 = (localPlayer.anInt1550 >> 7) + this.baseX;
                    }

                    if(j1 == 19) {
                        k1 = (localPlayer.anInt1551 >> 7) + this.baseY;
                    }

                    if(j1 == 20) {
                        k1 = _ex[l++];
                    }

                    if(byte0 == 0) {
                        if(i1 == 0) {
                            k += k1;
                        }

                        if(i1 == 1) {
                            k -= k1;
                        }

                        if(i1 == 2 && k1 != 0) {
                            k /= k1;
                        }

                        if(i1 == 3) {
                            k *= k1;
                        }

                        i1 = 0;
                    } else {
                        i1 = byte0;
                    }
                }
            } catch (Exception var17) {
                return -1;
            }
        } else {
            return -2;
        }
    }

    public int getOrbTextColor(int statusInt) {
        return statusInt >= 75 && statusInt <= Integer.MAX_VALUE?'\uff00':(statusInt >= 50 && statusInt <= 74?16776960:(statusInt >= 25 && statusInt <= 49?16750623:16711680));
    }

    public int getOrbFill(int statusInt) {
        return statusInt <= Integer.MAX_VALUE && statusInt >= 97?0:(statusInt <= 96 && statusInt >= 93?1:(statusInt <= 92 && statusInt >= 89?2:(statusInt <= 88 && statusInt >= 85?3:(statusInt <= 84 && statusInt >= 81?4:(statusInt <= 80 && statusInt >= 77?5:(statusInt <= 76 && statusInt >= 73?6:(statusInt <= 72 && statusInt >= 69?7:(statusInt <= 68 && statusInt >= 65?8:(statusInt <= 64 && statusInt >= 61?9:(statusInt <= 60 && statusInt >= 57?10:(statusInt <= 56 && statusInt >= 53?11:(statusInt <= 52 && statusInt >= 49?12:(statusInt <= 48 && statusInt >= 45?13:(statusInt <= 44 && statusInt >= 41?14:(statusInt <= 40 && statusInt >= 37?15:(statusInt <= 36 && statusInt >= 33?16:(statusInt <= 32 && statusInt >= 29?17:(statusInt <= 28 && statusInt >= 25?18:(statusInt <= 24 && statusInt >= 21?19:(statusInt <= 20 && statusInt >= 17?20:(statusInt <= 16 && statusInt >= 13?21:(statusInt <= 12 && statusInt >= 9?22:(statusInt <= 8 && statusInt >= 7?23:(statusInt <= 6 && statusInt >= 5?24:(statusInt <= 4 && statusInt >= 3?25:(statusInt <= 2 && statusInt >= 1?26:(statusInt <= 0?27:0)))))))))))))))))))))))))));
    }

    private final void minimapHovers() {
        boolean fixed = currentScreenMode == client.ScreenMode.FIXED;
        this.hpHover = fixed?(this.hpHover = super.mouseX >= 516 && super.mouseX <= 571 && super.mouseY >= 47 && super.mouseY < 72):super.mouseX >= currentGameWidth - 220 && super.mouseX <= currentGameWidth - 160 && super.mouseY >= 42 && super.mouseY < 74;
        this.prayHover = fixed?(this.prayHover = super.mouseX >= 518 && super.mouseX <= 572 && super.mouseY >= 85 && super.mouseY < 117):super.mouseX >= currentGameWidth - 220 && super.mouseX <= currentGameWidth - 160 && super.mouseY >= 85 && super.mouseY < 117;
        this.runHover = fixed?super.mouseX >= 540 && super.mouseX <= 593 && super.mouseY >= 123 && super.mouseY < 154:super.mouseX >= currentGameWidth - 193 && super.mouseX <= currentGameWidth - 137 && super.mouseY >= 123 && super.mouseY < 153;
        this.worldHover = fixed?super.mouseX >= 710 && super.mouseX <= 738 && super.mouseY >= 130 && super.mouseY <= 154:super.mouseX >= currentGameWidth - 35 && super.mouseX <= currentGameWidth - 10 && super.mouseY >= 133 && super.mouseY <= 160;
        this.expCounterHover = currentScreenMode == client.ScreenMode.FIXED?super.mouseX >= 515 && super.mouseX <= 540 && super.mouseY >= 20 && super.mouseY <= 45:super.mouseX >= currentGameWidth - 215 && super.mouseX <= currentGameWidth - 190 && super.mouseY >= 20 && super.mouseY <= 45;
    }

    private void loadAllOrbs(int xOffset) {
        if(currentScreenMode == client.ScreenMode.FIXED) {
            this.gameframe[this.expCounterHover?58:57].drawSprite(0, 21);
        } else {
            this.gameframe[this.expCounterHover?58:57].drawSprite(currentGameWidth - 215, 21);
        }

        if(currentScreenMode == client.ScreenMode.FIXED) {
            this.gameframe[59].drawSprite(197, 130);
            this.gameframe[this.worldHover?61:60].drawSprite(201, 134);
        } else {
            this.gameframe[59].drawSprite(currentGameWidth - 36, 135);
            this.gameframe[this.worldHover?61:60].drawSprite(currentGameWidth - 32, 139);
        }

        int[] spriteID = new int[]{this.isPoisoned && this.hpHover?49:48, this.prayHover?49:48, this.runHover?49:48};
        int[] coloredOrbSprite = new int[]{37, this.clickedQuickPrayers?43:40, this.runClicked?41:42};
        int[] orbSprite = new int[]{44, 45, this.runClicked?46:47};
        String cEnergy = Widget.interfaceCache[149].message.replaceAll("%", "");
        Widget.interfaceCache[4016].message.replaceAll("%", "");
        int currentHP = this.currentLevels[3];
        int currentEnergy = Integer.parseInt(cEnergy);

        for(int i = 0; i < 3; ++i) {
            String currentStats = Widget.interfaceCache[this.currentInterface[i]].message.replaceAll("%", "");
            String maxStats = Widget.interfaceCache[this.maximumInterface[i]].message.replaceAll("%", "");
            int currentLevel = Integer.parseInt(currentStats);
            int maxLevel = Integer.parseInt(maxStats);
            int level = (int)((double)currentLevel / (double)maxLevel * 100.0D);
            this.gameframe[spriteID[i]].drawSprite(this.orbX[i] + xOffset, this.orbY[i]);
            this.gameframe[coloredOrbSprite[i]].drawSprite(this.coloredOrbX[i] + xOffset, this.coloredOrbY[i]);
            double percent = i == 2?(this.runEnergy?(double)currentEnergy / 100.0D:100.0D):(double)level / 100.0D;
            double fillHp = 26.0D * percent;
            double fillPrayer = 26.0D * percent;
            double fillRun = 26.0D * percent;
            double[] fill = new double[]{fillHp, fillPrayer, fillRun};
            int depleteFill = 26 - (int)fill[i];
            this.gameframe[36].myHeight = depleteFill;

            try {
                this.gameframe[36].drawSprite(this.coloredOrbX[i] + xOffset, this.coloredOrbY[i]);
            } catch (Exception var25) {
                ;
            }

            this.gameframe[orbSprite[i]].drawSprite(this.orbIconX[i] + xOffset, this.orbIconY[i]);
            this.smallText.method382(this.getOrbTextColor(i == 2?(this.runEnergy?currentEnergy:100):level), this.orbTextX[i] + xOffset, this.anInt939, "" + (i == 2?(this.runEnergy?cEnergy:Integer.valueOf(100)):(i == 0 && newDamage?Integer.valueOf(currentHP * 10):Widget.interfaceCache[this.currentInterface[i]].message.replaceAll("%", ""))), this.orbTextY[i], true);
        }

    }

    public final void method125(int i) {
        if(this.menuActionRow >= 2 || this.anInt1282 != 0 || this.anInt1136 != 0) {
            String s;
            if(this.anInt1282 == 1 && this.menuActionRow < 2) {
                s = "Use " + this.aString1286 + " on...";
            } else {
                s = this.menuActionName[this.menuActionRow - 1];
            }

            if(this.menuActionRow > 2) {
                s = s + "<col=ffffff> / " + (this.menuActionRow - 2) + " more options";
            }

            this.newBoldFont.drawBasicString(s, 4, 15, 16777215, 0);
            if(i != '\ub28a') {
                for(int j = 1; j > 0; ++j) {
                    ;
                }
            }

        }
    }

    public final void drawMinimap(boolean flag) {
        if(currentScreenMode == client.ScreenMode.FIXED) {
            this.aRSImageProducer_1164.initDrawingArea();
        }

        if(this.anInt1021 == 2) {
            if(currentScreenMode == client.ScreenMode.FIXED) {
                this.BlackMap[0].drawSprite(0, 0);
            } else {
                this.gameframe[22].drawSprite(currentGameWidth - 181, 0);
                this.gameframe[23].drawSprite(currentGameWidth - 158, 7);
            }

            if(currentScreenMode != client.ScreenMode.FIXED && changeTabArea) {
                if((super.mouseX < currentGameWidth - 26 || super.mouseX > currentGameWidth - 1 || super.mouseY < 2 || super.mouseY > 24) && tabID != 10) {
                    this.gameframe[31].drawARGBSprite(currentGameWidth - 25, 2, 165);
                } else {
                    this.gameframe[31].drawSprite(currentGameWidth - 25, 2);
                }
            }

            if(this.loadOrbs) {
                this.loadAllOrbs(currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 217);
            }

            this.compassImage.method352(33, this.anInt1185, this.anIntArray1057, 256, this.anIntArray968, -236, currentScreenMode == client.ScreenMode.FIXED?25:24, 4, currentScreenMode == client.ScreenMode.FIXED?29:currentGameWidth - 176, 33, 25);
            if(this.menuOpen) {
                this.drawMenu(currentScreenMode == client.ScreenMode.FIXED?516:0, 0);
            }

            if(currentScreenMode == client.ScreenMode.FIXED) {
                aRSImageProducer_1165.initDrawingArea();
            }
        } else {
            int i = this.anInt1185 + this.anInt1209 & 2047;
            int j = 48 + localPlayer.anInt1550 / 32;
            int l2 = 464 - localPlayer.anInt1551 / 32;
            this.minimapImage.method352(151, i, this.anIntArray1229, 256 + this.anInt1170, this.anIntArray1052, -236, l2, currentScreenMode == client.ScreenMode.FIXED?9:7, currentScreenMode == client.ScreenMode.FIXED?54:currentGameWidth - 158, 146, j);

            int j2;
            int l4;
            int k4;
            for(j2 = 0; j2 < this.anInt1071; ++j2) {
                l4 = this.anIntArray1072[j2] * 4 + 2 - localPlayer.anInt1550 / 32;
                k4 = this.anIntArray1073[j2] * 4 + 2 - localPlayer.anInt1551 / 32;
                this.method141(this.aSpriteArray1140[j2], l4, k4, false);
                this.method141(this.Mapicon, (3255 - this.baseX) * 4 + 2 - localPlayer.anInt1550 / 32, (3290 - this.baseY) * 4 + 2 - localPlayer.anInt1551 / 32, true);
            }

            int l3;
            int flag1;
            for(j2 = 0; j2 < 104; ++j2) {
                for(l4 = 0; l4 < 104; ++l4) {
                    DoubleEndedQueue var16 = this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][j2][l4];
                    if(var16 != null) {
                        l3 = j2 * 4 + 2 - localPlayer.anInt1550 / 32;
                        flag1 = l4 * 4 + 2 - localPlayer.anInt1551 / 32;
                        this.method141(this.aSprite_1074, l3, flag1, false);
                    }
                }
            }

            for(j2 = 0; j2 < this.npcCount; ++j2) {
                Npc var15 = this.npcs[this.npcIndices[j2]];
                if(var15 != null && var15.method449(aBoolean1224)) {
                    Class5 var18 = var15.desc;
                    if(var18.anIntArray88 != null) {
                        var18 = var18.method161();
                    }

                    if(var18 != null && var18.aBoolean87 && var18.aBoolean84) {
                        l3 = var15.anInt1550 / 32 - localPlayer.anInt1550 / 32;
                        flag1 = var15.anInt1551 / 32 - localPlayer.anInt1551 / 32;
                        this.method141(this.aSprite_1075, l3, flag1, false);
                    }
                }
            }

            for(j2 = 0; j2 < this.anInt891; ++j2) {
                Player var17 = this.players[this.anIntArray892[j2]];
                if(var17 != null && var17.method449(aBoolean1224)) {
                    k4 = var17.anInt1550 / 32 - localPlayer.anInt1550 / 32;
                    l3 = var17.anInt1551 / 32 - localPlayer.anInt1551 / 32;
                    boolean var21 = false;
                    boolean flag3 = false;

                    for(int l6 = 0; l6 < this.clanList.length; ++l6) {
                        if(this.clanList[l6] != null) {
                            String clanname = this.clanList[l6];
                            if(clanname.startsWith("<clan")) {
                                clanname = clanname.substring(clanname.indexOf(">") + 1);
                            }

                            if(clanname.equalsIgnoreCase(var17.name)) {
                                flag3 = true;
                                break;
                            }
                        }
                    }

                    long var22 = TextClass.longForName(var17.name);

                    for(int flag2 = 0; flag2 < this.friendsCount; ++flag2) {
                        if(var22 == this.friendsListAsLongs[flag2] && this.friendsNodeIDs[flag2] != 0) {
                            var21 = true;
                            break;
                        }
                    }

                    boolean var23 = false;
                    if(localPlayer.team != 0 && var17.team != 0 && localPlayer.team == var17.team) {
                        var23 = true;
                    }

                    if(var21) {
                        this.method141(this.aSprite_1077, k4, l3, false);
                    } else if(var23) {
                        this.method141(this.aSprite_1078, k4, l3, false);
                    } else {
                        this.method141(this.aSprite_1076, k4, l3, false);
                    }
                }
            }

            if(this.hintType != 0 && loopCycle % 20 < 10) {
                if(this.hintType == 1 && this.anInt1222 >= 0 && this.anInt1222 < this.npcs.length) {
                    Npc var19 = this.npcs[this.anInt1222];
                    if(var19 != null) {
                        l4 = var19.anInt1550 / 32 - localPlayer.anInt1550 / 32;
                        k4 = var19.anInt1551 / 32 - localPlayer.anInt1551 / 32;
                        this.method81(this.aSprite_871, -760, k4, l4);
                    }
                }

                if(this.hintType == 2) {
                    j2 = (this.anInt934 - this.baseX) * 4 + 2 - localPlayer.anInt1550 / 32;
                    l4 = (this.anInt935 - this.baseY) * 4 + 2 - localPlayer.anInt1551 / 32;
                    this.method81(this.aSprite_871, -760, l4, j2);
                }

                if(this.hintType == 10 && this.anInt933 >= 0 && this.anInt933 < this.players.length) {
                    Player var20 = this.players[this.anInt933];
                    if(var20 != null) {
                        l4 = var20.anInt1550 / 32 - localPlayer.anInt1550 / 32;
                        k4 = var20.anInt1551 / 32 - localPlayer.anInt1551 / 32;
                        this.method81(this.aSprite_871, -760, k4, l4);
                    }
                }
            }

            if(this.anInt1261 != 0) {
                j2 = this.anInt1261 * 4 + 2 - localPlayer.anInt1550 / 32;
                l4 = this.anInt1262 * 4 + 2 - localPlayer.anInt1551 / 32;
                this.method141(this.aSprite_870, j2, l4, false);
            }

            DrawingArea.drawPixels(3, currentScreenMode == client.ScreenMode.FIXED?83:80, currentScreenMode == client.ScreenMode.FIXED?127:currentGameWidth - 88, 16777215, 3);
            if(currentScreenMode == client.ScreenMode.FIXED) {
                this.gameframe[29].drawSprite(0, 0);
            } else {
                this.gameframe[22].drawSprite(currentGameWidth - 181, 0);
            }

            this.compassImage.method352(33, this.anInt1185, this.anIntArray1057, 256, this.anIntArray968, -236, currentScreenMode == client.ScreenMode.FIXED?25:24, 4, currentScreenMode == client.ScreenMode.FIXED?29:currentGameWidth - 176, 33, 25);
            if(currentScreenMode != client.ScreenMode.FIXED && changeTabArea) {
                if((super.mouseX < currentGameWidth - 26 || super.mouseX > currentGameWidth - 1 || super.mouseY < 2 || super.mouseY > 24) && tabID != 10) {
                    this.gameframe[31].drawSprite(currentGameWidth - 25, 2);
                } else {
                    this.gameframe[31].drawSprite(currentGameWidth - 25, 2);
                }
            }

            if(this.loadOrbs) {
                this.loadAllOrbs(currentScreenMode == client.ScreenMode.FIXED?0:currentGameWidth - 217);
            }

            if(this.menuOpen) {
                this.drawMenu(currentScreenMode == client.ScreenMode.FIXED?516:0, 0);
            }

            if(currentScreenMode == client.ScreenMode.FIXED) {
                aRSImageProducer_1165.initDrawingArea();
            }
        }

    }

    public final void method127(boolean flag, Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, int i) {
        this.method128(class30_sub2_sub4_sub1.anInt1550, i, this.anInt875, class30_sub2_sub4_sub1.anInt1551);
    }

    public final void method128(int i, int j, int k, int l) {
        if(i >= 128 && l >= 128 && i <= 13056 && l <= 13056) {
            int i1 = this.method42(this.anInt918, l, true, i) - j;
            i -= this.xCameraPos;
            i1 -= this.zCameraPos;
            l -= this.yCameraPos;
            int j1 = Model.SINE[this.yCameraCurve];
            int k1 = Model.COSINE[this.yCameraCurve];
            int l1 = Model.SINE[this.xCameraCurve];
            int i2 = Model.COSINE[this.xCameraCurve];
            int j2 = l * l1 + i * i2 >> 16;
            l = l * i2 - i * l1 >> 16;
            i = j2;
            j2 = i1 * k1 - l * j1 >> 16;
            l = i1 * j1 + l * k1 >> 16;
            if(l >= 50) {
                this.spriteDrawX = Rasterizer.centerX + (i << log_view_dist) / l;
                this.spriteDrawY = Rasterizer.centerY + (j2 << log_view_dist) / l;
            } else {
                this.spriteDrawX = -1;
                this.spriteDrawY = -1;
            }

        } else {
            this.spriteDrawX = -1;
            this.spriteDrawY = -1;
        }
    }

    public final void method129(boolean flag) {
        if(this.splitPrivateChat != 0) {
            int i = 0;
            if(flag) {
                this.packet = -1;
            }

            boolean listPosition = false;
            boolean update = this.anInt1104 != 0;
            boolean broadcast = BroadcastManager.isDisplayed();
            int var12 = update && broadcast?2:(!broadcast && !update?0:1);

            for(int j = 0; j < 500; ++j) {
                if(this.chatMessages[j] != null) {
                    int k = this.chatTypes[j];
                    String s = this.chatNames[j];
                    boolean flag1 = false;
                    if(s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr3@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr4@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr5@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr6@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr7@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr8@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr9@")) {
                        s = s.substring(5);
                    }

                    if(s != null && s.startsWith("@cr10@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr11@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr12@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr13@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr14@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr15@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr16@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr17@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr18@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr19@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr20@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr21@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr22@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr23@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr24@")) {
                        s = s.substring(6);
                    }

                    if(s != null && s.startsWith("@cr25@")) {
                        s = s.substring(6);
                    }

                    if((k == 3 || k == 7) && (k == 7 || this.privateChatMode == 0 || this.privateChatMode == 1 && this.method109(s))) {
                        int l = (!this.isResized()?330:currentGameHeight - 173) - var12 * 13;
                        if(super.mouseX > 4 && super.mouseY - 4 > l - 10 && super.mouseY - (!this.isResized()?5:0) <= l + 3) {
                            int i1 = this.regularText.method383(this.anInt1116, "From:  " + s + this.chatMessages[j]) + 25;
                            if(i1 > 450) {
                                i1 = 450;
                            }

                            if(super.mouseX < 4 + i1) {
                                if(this.myPrivilege >= 1) {
                                    this.menuActionName[this.menuActionRow] = "Report <col=ffffff>" + s;
                                    this.menuActionID[this.menuActionRow] = 2606;
                                    ++this.menuActionRow;
                                }

                                this.menuActionName[this.menuActionRow] = "Add ignore <col=ff0000>" + s;
                                this.menuActionID[this.menuActionRow] = 2042;
                                ++this.menuActionRow;
                                this.menuActionName[this.menuActionRow] = "Add friend <col=ffffff>" + s;
                                this.menuActionID[this.menuActionRow] = 2337;
                                ++this.menuActionRow;
                            }
                        }

                        ++i;
                        if(i >= 5) {
                            return;
                        }
                    }

                    if((k == 5 || k == 6) && this.privateChatMode < 2) {
                        ++i;
                        if(i >= 5) {
                            return;
                        }
                    }
                }
            }

        }
    }

    private final void method130(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2) {
        Class30_Sub1 class30_sub1 = null;

        for(Class30_Sub1 class30_sub1_1 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetFirst(); class30_sub1_1 != null; class30_sub1_1 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetNext(false)) {
            if(class30_sub1_1.anInt1295 == l1 && class30_sub1_1.anInt1297 == i2 && class30_sub1_1.anInt1298 == j1 && class30_sub1_1.anInt1296 == i1) {
                class30_sub1 = class30_sub1_1;
                break;
            }
        }

        if(class30_sub1 == null) {
            class30_sub1 = new Class30_Sub1();
            class30_sub1.anInt1295 = l1;
            class30_sub1.anInt1296 = i1;
            class30_sub1.anInt1297 = i2;
            class30_sub1.anInt1298 = j1;
            this.method89(false, class30_sub1);
            this.aDoubleEndedQueue_1179.insertHead(class30_sub1);
        }

        class30_sub1.anInt1291 = k;
        class30_sub1.anInt1293 = k1;
        class30_sub1.anInt1292 = l;
        class30_sub1.anInt1302 = j2;
        class30_sub1.anInt1294 = j;
        if(i > 0) {
            ;
        }

    }

    public final boolean method131(Widget class9, boolean flag) {
        if(flag) {
            this.anInt883 = -211;
        }

        if(class9.anIntArray245 == null) {
            return false;
        } else {
            for(int i = 0; i < class9.anIntArray245.length; ++i) {
                int j = this.method124(341, class9, i);
                int k = class9.anIntArray212[i];
                if(class9.anIntArray245[i] == 2) {
                    if(j >= k) {
                        return false;
                    }
                } else if(class9.anIntArray245[i] == 3) {
                    if(j <= k) {
                        return false;
                    }
                } else if(class9.anIntArray245[i] == 4) {
                    if(j == k) {
                        return false;
                    }
                } else if(j != k) {
                    return false;
                }
            }

            return true;
        }
    }

    public final DataInputStream method132(String archivePath) throws IOException {
        // Close any existing socket cleanly
        if (this.aSocket832 != null) {
            try {
                this.aSocket832.close();
            } catch (Exception ignored) {}
            this.aSocket832 = null;
        }

        try {
            // Establish fresh JagGrab connection
            this.aSocket832 = this.method19(29433); // can also use dynamic config port
            this.aSocket832.setSoTimeout(10_000);

            InputStream input = this.aSocket832.getInputStream();
            OutputStream output = this.aSocket832.getOutputStream();

            String request = "JAGGRAB /" + archivePath + "\n\n";
            output.write(request.getBytes(StandardCharsets.US_ASCII));
            output.flush();



            return new DataInputStream(input);
        } catch (IOException e) {
            System.err.println("❌ [JagGrab] Connection error for: /" + archivePath + " | " + e.getMessage());
            throw e; // Let method67 handle retries
        }
    }


    public final void method133(byte byte0) {
        short c = 256;
        int i1;
        if(this.anInt1040 > 0) {
            for(i1 = 0; i1 < 256; ++i1) {
                if(this.anInt1040 > 768) {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray851[i1], this.anIntArray852[i1], 1024 - this.anInt1040);
                } else if(this.anInt1040 > 256) {
                    this.anIntArray850[i1] = this.anIntArray852[i1];
                } else {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray852[i1], this.anIntArray851[i1], 256 - this.anInt1040);
                }
            }
        } else if(this.anInt1041 > 0) {
            for(i1 = 0; i1 < 256; ++i1) {
                if(this.anInt1041 > 768) {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray851[i1], this.anIntArray853[i1], 1024 - this.anInt1041);
                } else if(this.anInt1041 > 256) {
                    this.anIntArray850[i1] = this.anIntArray853[i1];
                } else {
                    this.anIntArray850[i1] = this.method83(true, this.anIntArray853[i1], this.anIntArray851[i1], 256 - this.anInt1041);
                }
            }
        } else {
            for(i1 = 0; i1 < 256; ++i1) {
                this.anIntArray850[i1] = this.anIntArray851[i1];
            }
        }

        for(i1 = 0; i1 < '\u8480'; ++i1) {
            this.aRSImageProducer_1110.anIntArray315[i1] = this.aSprite_1201.myPixels[i1];
        }

        i1 = 0;
        int j1 = 1152;

        int k2;
        int i3;
        int k3;
        int i4;
        int k4;
        int i5;
        int j5;
        int k5;
        for(k2 = 1; k2 < c - 1; ++k2) {
            i3 = this.anIntArray969[k2] * (c - k2) / c;
            k3 = 22 + i3;
            if(k3 < 0) {
                k3 = 0;
            }

            i1 += k3;

            for(i4 = k3; i4 < 128; ++i4) {
                k4 = this.anIntArray828[i1++];
                if(k4 != 0) {
                    i5 = k4;
                    j5 = 256 - k4;
                    k4 = this.anIntArray850[k4];
                    k5 = this.aRSImageProducer_1110.anIntArray315[j1];
                    this.aRSImageProducer_1110.anIntArray315[j1++] = ((k4 & 16711935) * i5 + (k5 & 16711935) * j5 & -16711936) + ((k4 & '\uff00') * i5 + (k5 & '\uff00') * j5 & 16711680) >> 8;
                } else {
                    ++j1;
                }
            }

            j1 += k3;
        }

        this.aRSImageProducer_1110.method238(0, 23680, super.aGraphics12, 0);

        for(k2 = 0; k2 < '\u8480'; ++k2) {
            this.aRSImageProducer_1111.anIntArray315[k2] = this.aSprite_1202.myPixels[k2];
        }

        i1 = 0;
        j1 = 1176;

        for(k2 = 1; k2 < c - 1; ++k2) {
            i3 = this.anIntArray969[k2] * (c - k2) / c;
            k3 = 103 - i3;
            j1 += i3;

            for(i4 = 0; i4 < k3; ++i4) {
                k4 = this.anIntArray828[i1++];
                if(k4 != 0) {
                    i5 = k4;
                    j5 = 256 - k4;
                    k4 = this.anIntArray850[k4];
                    k5 = this.aRSImageProducer_1111.anIntArray315[j1];
                    this.aRSImageProducer_1111.anIntArray315[j1++] = ((k4 & 16711935) * i5 + (k5 & 16711935) * j5 & -16711936) + ((k4 & '\uff00') * i5 + (k5 & '\uff00') * j5 & 16711680) >> 8;
                } else {
                    ++j1;
                }
            }

            i1 += 128 - k3;
            j1 += 128 - k3 - i3;
        }

        this.aRSImageProducer_1111.method238(0, 23680, super.aGraphics12, 637);
        if(byte0 != 9) {
            this.packet = this.in.readUnsignedByte();
        }

    }

    private final void method134(byte byte0, int i, Stream stream) {
        int j = stream.readBits(8);
        int l;
        if(j < this.anInt891) {
            for(l = j; l < this.anInt891; ++l) {
                this.anIntArray840[this.anInt839++] = this.anIntArray892[l];
            }
        }

        if(j > this.anInt891) {
            signlink.reporterror(this.myUsername + " Too many players");
            throw new RuntimeException("eek");
        } else {
            this.anInt891 = 0;

            for(l = 0; l < j; ++l) {
                int i1 = this.anIntArray892[l];
                Player player = this.players[i1];
                int j1 = stream.readBits(1);
                if(j1 == 0) {
                    this.anIntArray892[this.anInt891++] = i1;
                    player.anInt1537 = loopCycle;
                } else {
                    int k1 = stream.readBits(2);
                    if(k1 == 0) {
                        this.anIntArray892[this.anInt891++] = i1;
                        player.anInt1537 = loopCycle;
                        this.anIntArray894[this.anInt893++] = i1;
                    } else {
                        int i2;
                        int k2;
                        if(k1 == 1) {
                            this.anIntArray892[this.anInt891++] = i1;
                            player.anInt1537 = loopCycle;
                            i2 = stream.readBits(3);
                            player.moveInDir(false, (byte)20, i2);
                            k2 = stream.readBits(1);
                            if(k2 == 1) {
                                this.anIntArray894[this.anInt893++] = i1;
                            }
                        } else if(k1 == 2) {
                            this.anIntArray892[this.anInt891++] = i1;
                            player.anInt1537 = loopCycle;
                            i2 = stream.readBits(3);
                            player.moveInDir(true, (byte)20, i2);
                            k2 = stream.readBits(3);
                            player.moveInDir(true, (byte)20, k2);
                            int l2 = stream.readBits(1);
                            if(l2 == 1) {
                                this.anIntArray894[this.anInt893++] = i1;
                            }
                        } else if(k1 == 3) {
                            this.anIntArray840[this.anInt839++] = i1;
                        }
                    }
                }
            }

            if(byte0 != 2) {
                this.anInt939 = -80;
            }

        }
    }

    public final void method135(boolean flag, boolean flag1) {
        this.resetImageProducers(0);
        this.aRSImageProducer_1109.initDrawingArea();
        this.aBackground_966.method361(0, 0);
        short c = 360;
        short c1 = 200;
        if(!flag1) {
            int k;
            int j1;
            int i2;
            if(this.anInt833 == 0) {
                k = c1 / 2 + 80;
                this.smallText.method382(7711145, c / 2, this.anInt939, onDemandFetcher.aString1333, k, true);
                k = c1 / 2 - 70;
                this.boldText.method382(16776960, c / 2, this.anInt939, "@whi@Welcome to GodzHell Reborn and Remastered", k, true);
                k = c1 / 2 - 50;
                this.boldText.method382(16776960, c / 2, this.anInt939, "@whi@@ By Undead Games", k, true);
                k = c1 / 2 - 20;
                this.boldText.method382(16711680, c / 2, this.anInt939, "@whi@New and Existing players click Enter to play", k, true);
                k += 30;
                j1 = c / 2 - 80;
                i2 = c1 / 2 + 20;
                this.aBackground_967.method361(j1 - 73, i2 - 20);
                this.boldText.method382(16777215, j1, this.anInt939, "@whi@  About", i2 + 5, true);
                j1 = c / 2 + 80;
                this.aBackground_967.method361(j1 - 73, i2 - 20);
                this.boldText.method382(16777215, j1, this.anInt939, "@whi@Enter", i2 + 5, true);
            }

            if(this.anInt833 == 2) {
                k = c1 / 2 - 40;
                if(this.aString1266.length() > 0) {
                    this.boldText.method382(16776960, c / 2, this.anInt939, this.aString1266, k - 15, true);
                    this.boldText.method382(16776960, c / 2, this.anInt939, this.aString1267, k, true);
                    k += 15;
                } else {
                    this.boldText.method382(16776960, c / 2, this.anInt939, this.aString1267, k - 7, true);
                    k += 15;
                }

                this.boldText.method389(false, true, c / 2 - 90, 16777215, "@whi@Login: " + this.myUsername + (this.anInt1216 == 0 & loopCycle % 40 < 20?"@xxx@|":""), k);
                k += 15;
                this.boldText.method389(false, true, c / 2 - 90, 16777215, "@whi@Password: " + TextClass.method588(this.myPassword, 0) + (this.anInt1216 == 1 & this.anInt1105 % 40 < 20?"|":""), k);
                k += 30;
                this.boldText.method389(false, true, c / 2 - 160, 1048320, "@whi@New users enter a name and password to begin", k);
                k += 70;
                k += 15;
                if(!flag) {
                    j1 = c / 2 - 80;
                    i2 = c1 / 2 + 50;
                    this.aBackground_967.method361(j1 - 73, i2 - 20);
                    this.boldText.method382(16777215, j1, this.anInt939, "@whi@Log in", i2 + 5, true);
                    j1 = c / 2 + 80;
                    this.aBackground_967.method361(j1 - 73, i2 - 20);
                    this.boldText.method382(16777215, j1, this.anInt939, "@whi@Cancel", i2 + 5, true);
                }
            }

            if(this.anInt833 == 3) {
                this.boldText.method382(16777215, c / 2, this.anInt939, "Ghreborn", c1 / 2 - 60, true);
                k = c1 / 2 - 35;
                this.boldText.method382(16777215, c / 2, this.anInt939, "GodzHell.net", k, true);
                k += 15;
                this.boldText.method382(16777215, c / 2, this.anInt939, "Enjoy!", k, true);
                k += 15;
                this.boldText.method382(16777215, c / 2, this.anInt939, "Created by Traxxas!", k, true);
                k += 15;
                this.boldText.method382(16777215, c / 2, this.anInt939, " ", k, true);
                k += 15;
                this.boldText.method382(16777215, c / 2, this.anInt939, "", k, true);
                k += 15;
                this.boldText.method382('\u99ff', c / 2, this.anInt939, "", k, true);
                k += 15;
                j1 = c / 2;
                i2 = c1 / 2 + 50;
                this.aBackground_967.method361(j1 - 73, i2 - 20);
                this.boldText.method382(3394815, j1, this.anInt939, "@whi@Back", i2 + 5, true);
            }

            this.aRSImageProducer_1109.method238(171, 23680, super.aGraphics12, 202);
            if(this.aBoolean1255) {
                this.aBoolean1255 = false;
                this.aRSImageProducer_1107.method238(0, 23680, super.aGraphics12, 128);
                this.aRSImageProducer_1108.method238(371, 23680, super.aGraphics12, 202);
                this.aRSImageProducer_1112.method238(265, 23680, super.aGraphics12, 0);
                this.aRSImageProducer_1113.method238(265, 23680, super.aGraphics12, 562);
                this.aRSImageProducer_1114.method238(171, 23680, super.aGraphics12, 128);
                this.aRSImageProducer_1115.method238(171, 23680, super.aGraphics12, 562);
            }

        }
    }

    public final void method136(byte byte0) {
        this.drawingFlames = true;
        if(byte0 != 59) {
            this.anInt1058 = -186;
        }

        try {
            long l = System.currentTimeMillis();
            int i = 0;
            int j = 20;

            while(this.aBoolean831) {
                ++this.anInt1208;
                this.method133((byte)9);
                ++i;
                if(i > 10) {
                    long l1 = System.currentTimeMillis();
                    int k = (int)(l1 - l) / 10 - j;
                    j = 40 - k;
                    if(j < 5) {
                        j = 5;
                    }

                    i = 0;
                    l = l1;
                }

                try {
                    Thread.sleep((long)j);
                } catch (Exception var9) {
                    ;
                }
            }
        } catch (Exception var10) {
            ;
        }

        this.drawingFlames = false;
    }

    public final void method10(byte byte0) {
        this.aBoolean1255 = true;
        if(byte0 == 1) {
            boolean byte01 = false;
        } else {
            this.anInt1218 = (int) this.aISAACRandomGen_1000.getNextIntKey();
        }
    }

    public final void method137(Stream stream, int j) {
        int i3;
        int l5;
        int k8;
        int j11;
        int k13;
        int l15;
        if(j == 84) {
            i3 = stream.readUnsignedByte();
            l5 = this.anInt1268 + (i3 >> 4 & 7);
            k8 = this.anInt1269 + (i3 & 7);
            j11 = stream.readUnsignedShort();
            k13 = stream.readUnsignedShort();
            l15 = stream.readUnsignedShort();
            if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                DoubleEndedQueue var35 = this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][l5][k8];
                if(var35 != null) {
                    for(Class30_Sub2_Sub4_Sub2 var32 = (Class30_Sub2_Sub4_Sub2)var35.reverseGetFirst(); var32 != null; var32 = (Class30_Sub2_Sub4_Sub2)var35.reverseGetNext(false)) {
                        if(var32.anInt1558 == (j11 & 32767) && var32.anInt1559 == k13) {
                            var32.anInt1559 = l15;
                            break;
                        }
                    }

                    this.method25(l5, k8);
                }
            }

        } else {
            int i17;
            if(j == 105) {
                i3 = stream.readUnsignedByte();
                l5 = this.anInt1268 + (i3 >> 4 & 7);
                k8 = this.anInt1269 + (i3 & 7);
                j11 = stream.readUnsignedShort();
                k13 = stream.readUnsignedByte();
                l15 = k13 >> 4 & 15;
                i17 = k13 & 7;
                if(localPlayer.anIntArray1500[0] >= l5 - l15 && localPlayer.anIntArray1500[0] <= l5 + l15 && localPlayer.anIntArray1501[0] >= k8 - l15 && localPlayer.anIntArray1501[0] <= k8 + l15 && this.aBoolean848 && !lowMemory && this.currentSound < 50) {
                    this.sound[this.currentSound] = j11;
                    this.soundType[this.currentSound] = i17;
                    this.soundDelay[this.currentSound] = Sound.anIntArray326[j11];
                    ++this.currentSound;
                }
            }

            if(j == 215) {
                i3 = stream.readUShortA(true);
                l5 = stream.readByteA(2);
                k8 = this.anInt1268 + (l5 >> 4 & 7);
                j11 = this.anInt1269 + (l5 & 7);
                k13 = stream.readUShortA(true);
                l15 = stream.readUnsignedShort();
                if(k8 >= 0 && j11 >= 0 && k8 < 104 && j11 < 104 && k13 != this.anInt884) {
                    Class30_Sub2_Sub4_Sub2 var34 = new Class30_Sub2_Sub4_Sub2();
                    var34.anInt1558 = i3;
                    var34.anInt1559 = l15;
                    if(this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][k8][j11] == null) {
                        this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][k8][j11] = new DoubleEndedQueue(169);
                    }

                    this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][k8][j11].insertHead(var34);
                    this.method25(k8, j11);
                }

            } else {
                Class30_Sub2_Sub4_Sub2 var30;
                if(j == 156) {
                    i3 = stream.readByteS(0);
                    l5 = this.anInt1268 + (i3 >> 4 & 7);
                    k8 = this.anInt1269 + (i3 & 7);
                    j11 = stream.readUnsignedShort();
                    if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                        DoubleEndedQueue var33 = this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][l5][k8];
                        if(var33 != null) {
                            for(var30 = (Class30_Sub2_Sub4_Sub2)var33.reverseGetFirst(); var30 != null; var30 = (Class30_Sub2_Sub4_Sub2)var33.reverseGetNext(false)) {
                                if(var30.anInt1558 == (j11 & 32767)) {
                                    var30.unlink();
                                    break;
                                }
                            }

                            if(var33.reverseGetFirst() == null) {
                                this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][l5][k8] = null;
                            }

                            this.method25(l5, k8);
                        }
                    }

                } else {
                    int i18;
                    int l18;
                    int k19;
                    int j20;
                    int i21;
                    int class30_sub2_sub4_sub4;
                    if(j == 160) {
                        i3 = stream.readByteA(2);
                        l5 = this.anInt1268 + (i3 >> 4 & 7);
                        k8 = this.anInt1269 + (i3 & 7);
                        j11 = stream.readByteA(2);
                        k13 = j11 >> 2;
                        l15 = j11 & 3;
                        i17 = this.anIntArray1177[k13];
                        i18 = stream.readUShortA(true);
                        if(l5 >= 0 && k8 >= 0 && l5 < 103 && k8 < 103) {
                            l18 = this.anIntArrayArrayArray1214[this.anInt918][l5][k8];
                            k19 = this.anIntArrayArrayArray1214[this.anInt918][l5 + 1][k8];
                            j20 = this.anIntArrayArrayArray1214[this.anInt918][l5 + 1][k8 + 1];
                            i21 = this.anIntArrayArrayArray1214[this.anInt918][l5][k8 + 1];
                            if(i17 == 0) {
                                Class10 var37 = this.aClass25_946.method296(this.anInt918, l5, k8, false);
                                if(var37 != null) {
                                    class30_sub2_sub4_sub4 = ObjectKey.getObjectId(var37.anInt280);
                                    if(k13 == 2) {
                                        var37.aAnimable_278 = new Class30_Sub2_Sub4_Sub5(class30_sub2_sub4_sub4, 4 + l15, 2, k19, (byte)7, j20, l18, i21, i18, false);
                                        var37.aAnimable_279 = new Class30_Sub2_Sub4_Sub5(class30_sub2_sub4_sub4, l15 + 1 & 3, 2, k19, (byte)7, j20, l18, i21, i18, false);
                                    } else {
                                        var37.aAnimable_278 = new Class30_Sub2_Sub4_Sub5(class30_sub2_sub4_sub4, l15, k13, k19, (byte)7, j20, l18, i21, i18, false);
                                    }
                                }
                            }

                            if(i17 == 1) {
                                Class26 var39 = this.aClass25_946.method297(l5, 866, k8, this.anInt918);
                                if(var39 != null) {
                                    var39.aAnimable_504 = new Class30_Sub2_Sub4_Sub5(ObjectKey.getObjectId(var39.anInt505), 0, 4, k19, (byte)7, j20, l18, i21, i18, false);
                                }
                            }

                            if(i17 == 2) {
                                InteractiveObject var40 = this.aClass25_946.method298(l5, k8, (byte)4, this.anInt918);
                                if(k13 == 11) {
                                    k13 = 10;
                                }

                                if(var40 != null) {
                                    var40.aAnimable_521 = new Class30_Sub2_Sub4_Sub5(ObjectKey.getObjectId(var40.anInt529), l15, k13, k19, (byte)7, j20, l18, i21, i18, false);
                                }
                            }

                            if(i17 == 3) {
                                Class49 var41 = this.aClass25_946.method299(k8, l5, this.anInt918, 0);
                                if(var41 != null) {
                                    var41.renderable = new Class30_Sub2_Sub4_Sub5(ObjectKey.getObjectId(var41.anInt815), l15, 22, k19, (byte)7, j20, l18, i21, i18, false);
                                }
                            }
                        }

                    } else {
                        if(j == 147) {
                            i3 = stream.readByteA(2);
                            l5 = this.anInt1268 + (i3 >> 4 & 7);
                            k8 = this.anInt1269 + (i3 & 7);
                            j11 = stream.readUnsignedShort();
                            byte var28 = stream.method430(0);
                            l15 = stream.method434((byte)108);
                            byte var29 = stream.method429((byte)-57);
                            i18 = stream.readUnsignedShort();
                            l18 = stream.readByteA(2);
                            k19 = l18 >> 2;
                            j20 = l18 & 3;
                            i21 = this.anIntArray1177[k19];
                            byte j21 = stream.readSignedByte();
                            class30_sub2_sub4_sub4 = stream.readUnsignedShort();
                            byte byte3 = stream.method429((byte)-57);
                            Player player;
                            if(j11 == this.anInt884) {
                                player = localPlayer;
                            } else {
                                player = this.players[j11];
                            }

                            if(player != null) {
                                ObjectDefinition objectDefinition = ObjectDefinition.forID(class30_sub2_sub4_sub4);
                                int i22 = this.anIntArrayArrayArray1214[this.anInt918][l5][k8];
                                int j22 = this.anIntArrayArrayArray1214[this.anInt918][l5 + 1][k8];
                                int k22 = this.anIntArrayArrayArray1214[this.anInt918][l5 + 1][k8 + 1];
                                int l22 = this.anIntArrayArrayArray1214[this.anInt918][l5][k8 + 1];
                                Model model = objectDefinition.method578(k19, j20, i22, j22, k22, l22, -1);
                                if(model != null) {
                                    this.method130(404, i18 + 1, -1, 0, i21, k8, 0, this.anInt918, l5, l15 + 1);
                                    player.anInt1707 = l15 + loopCycle;
                                    player.anInt1708 = i18 + loopCycle;
                                    player.aModel_1714 = model;
                                    int i23 = objectDefinition.anInt744;
                                    int j23 = objectDefinition.anInt761;
                                    if(j20 == 1 || j20 == 3) {
                                        i23 = objectDefinition.anInt761;
                                        j23 = objectDefinition.anInt744;
                                    }

                                    player.anInt1711 = l5 * 128 + i23 * 64;
                                    player.anInt1713 = k8 * 128 + j23 * 64;
                                    player.anInt1712 = this.method42(this.anInt918, player.anInt1713, true, player.anInt1711);
                                    byte byte5;
                                    if(j21 > var28) {
                                        byte5 = j21;
                                        j21 = var28;
                                        var28 = byte5;
                                    }

                                    if(byte3 > var29) {
                                        byte5 = byte3;
                                        byte3 = var29;
                                        var29 = byte5;
                                    }

                                    player.anInt1719 = l5 + j21;
                                    player.anInt1721 = l5 + var28;
                                    player.anInt1720 = k8 + byte3;
                                    player.anInt1722 = k8 + var29;
                                }
                            }
                        }

                        if(j == 151) {
                            i3 = stream.readByteS(0);
                            l5 = this.anInt1268 + (i3 >> 4 & 7);
                            k8 = this.anInt1269 + (i3 & 7);
                            j11 = stream.method434((byte)108);
                            k13 = stream.readByteA(2);
                            l15 = k13 >> 2;
                            i17 = k13 & 3;
                            i18 = this.anIntArray1177[l15];
                            if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                                this.method130(404, -1, j11, i17, i18, k8, l15, this.anInt918, l5, 0);
                            }

                        } else if(j == 4) {
                            i3 = stream.readUnsignedByte();
                            l5 = this.anInt1268 + (i3 >> 4 & 7);
                            k8 = this.anInt1269 + (i3 & 7);
                            j11 = stream.readUnsignedShort();
                            k13 = stream.readUnsignedByte();
                            l15 = stream.readUnsignedShort();
                            if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104) {
                                l5 = l5 * 128 + 64;
                                k8 = k8 * 128 + 64;
                                Class30_Sub2_Sub4_Sub3 var31 = new Class30_Sub2_Sub4_Sub3(this.anInt918, loopCycle, 6, l15, j11, this.method42(this.anInt918, k8, true, l5) - k13, k8, l5);
                                this.aDoubleEndedQueue_1056.insertHead(var31);
                            }

                        } else if(j == 44) {
                            i3 = stream.method436((byte)-74);
                            l5 = stream.readUnsignedShort();
                            k8 = stream.readUnsignedByte();
                            j11 = this.anInt1268 + (k8 >> 4 & 7);
                            k13 = this.anInt1269 + (k8 & 7);
                            if(j11 >= 0 && k13 >= 0 && j11 < 104 && k13 < 104) {
                                var30 = new Class30_Sub2_Sub4_Sub2();
                                var30.anInt1558 = i3;
                                var30.anInt1559 = l5;
                                if(this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][j11][k13] == null) {
                                    this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][j11][k13] = new DoubleEndedQueue(169);
                                }

                                this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][j11][k13].insertHead(var30);
                                this.method25(j11, k13);
                            }

                        } else if(j == 101) {
                            i3 = stream.readByteC(false);
                            l5 = i3 >> 2;
                            k8 = i3 & 3;
                            j11 = this.anIntArray1177[l5];
                            k13 = stream.readUnsignedByte();
                            l15 = this.anInt1268 + (k13 >> 4 & 7);
                            i17 = this.anInt1269 + (k13 & 7);
                            if(l15 >= 0 && i17 >= 0 && l15 < 104 && i17 < 104) {
                                this.method130(404, -1, -1, k8, j11, i17, l5, this.anInt918, l15, 0);
                            }

                        } else {
                            if(j == 117) {
                                i3 = stream.readUnsignedByte();
                                l5 = this.anInt1268 + (i3 >> 4 & 7);
                                k8 = this.anInt1269 + (i3 & 7);
                                j11 = l5 + stream.readSignedByte();
                                k13 = k8 + stream.readSignedByte();
                                l15 = stream.readSignedWord();
                                i17 = stream.readUnsignedShort();
                                i18 = stream.readUnsignedByte() * 4;
                                l18 = stream.readUnsignedByte() * 4;
                                k19 = stream.readUnsignedShort();
                                j20 = stream.readUnsignedShort();
                                i21 = stream.readUnsignedByte();
                                int var36 = stream.readUnsignedByte();
                                if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104 && j11 >= 0 && k13 >= 0 && j11 < 104 && k13 < 104 && i17 != '\uffff') {
                                    l5 = l5 * 128 + 64;
                                    k8 = k8 * 128 + 64;
                                    j11 = j11 * 128 + 64;
                                    k13 = k13 * 128 + 64;
                                    Class30_Sub2_Sub4_Sub4 var38 = new Class30_Sub2_Sub4_Sub4(i21, l18,  k19 + loopCycle, j20 + loopCycle, var36, this.anInt918, this.method42(this.anInt918, k8, true, l5) - i18, k8, l5, l15, i17);
                                    var38.method455(k19 + loopCycle, k13, this.method42(this.anInt918, k13, true, j11) - l18, j11, (byte)-83);
                                    this.aDoubleEndedQueue_1013.insertHead(var38);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    public static final void method138(byte byte0) {
        Class25.lowMem = true;
        if(byte0 != aByte823) {
            for(int i = 1; i > 0; ++i) {
                ;
            }
        }

        Rasterizer.lowMem = true;
        lowMemory = true;
        ObjectManager.aBoolean151 = true;
        ObjectDefinition.aBoolean752 = true;
    }

    private void method139(Stream stream) {

        try {
            stream.initBitAccess(this.anInt1118);
            int e = stream.readBits(8);
            int i1;
            if(e < this.npcCount) {
                for(i1 = e; i1 < this.npcCount; ++i1) {
                    this.anIntArray840[this.anInt839++] = this.npcIndices[i1];
                }
            }

            if(e > this.npcCount) {
                signlink.reporterror(this.myUsername + " Too many npcs");
                throw new RuntimeException("eek");
            }

            this.npcCount = 0;

            for(i1 = 0; i1 < e; ++i1) {
                int j1 = this.npcIndices[i1];
                Npc npc = this.npcs[j1];
                int k1 = stream.readBits(1);
                if(k1 == 0) {
                    this.npcIndices[this.npcCount++] = j1;
                    npc.anInt1537 = loopCycle;
                } else {
                    int l1 = stream.readBits(2);
                    if(l1 == 0) {
                        this.npcIndices[this.npcCount++] = j1;
                        npc.anInt1537 = loopCycle;
                        this.anIntArray894[this.anInt893++] = j1;
                    } else {
                        int j2;
                        int l2;
                        if(l1 == 1) {
                            this.npcIndices[this.npcCount++] = j1;
                            npc.anInt1537 = loopCycle;
                            j2 = stream.readBits(3);
                            npc.moveInDir(false, (byte)20, j2);
                            l2 = stream.readBits(1);
                            if(l2 == 1) {
                                this.anIntArray894[this.anInt893++] = j1;
                            }
                        } else if(l1 == 2) {
                            this.npcIndices[this.npcCount++] = j1;
                            npc.anInt1537 = loopCycle;
                            j2 = stream.readBits(3);
                            npc.moveInDir(true, (byte)20, j2);
                            l2 = stream.readBits(3);
                            npc.moveInDir(true, (byte)20, l2);
                            int i3 = stream.readBits(1);
                            if(i3 == 1) {
                                this.anIntArray894[this.anInt893++] = j1;
                            }
                        } else if(l1 == 3) {
                            this.anIntArray840[this.anInt839++] = j1;
                        }
                    }
                }
            }
        } catch (Exception var13) {
            var13.printStackTrace();
        }

    }

    public final void method140(boolean flag) {
        if(!flag) {
            this.aDoubleEndedQueueArrayArrayArray827 = (DoubleEndedQueue[][][])null;
        }

        int k;
        int j1;
        if(this.anInt833 == 0) {
            k = super.myWidth / 2 - 80;
            j1 = super.myHeight / 2 + 20;
            j1 += 20;
            k = super.myWidth / 2 + 80;
            if(super.clickMode3 == 1 && super.saveClickX >= k - 75 && super.saveClickX <= k + 75 && super.saveClickY >= j1 - 20 && super.saveClickY <= j1 + 20) {
                this.aString1266 = "@whi@Enter your username and password.";
                this.aString1267 = "";
                this.anInt833 = 2;
                this.anInt1216 = 0;
                return;
            }
        } else {
            if(this.anInt833 == 2) {
                k = super.myHeight / 2 - 40;
                k += 30;
                k += 25;
                if(super.clickMode3 == 1 && super.saveClickY >= k - 15 && super.saveClickY < k) {
                    this.anInt1216 = 0;
                }

                k += 15;
                if(super.clickMode3 == 1 && super.saveClickY >= k - 15 && super.saveClickY < k) {
                    this.anInt1216 = 1;
                }

                k += 15;
                j1 = super.myWidth / 2 - 80;
                int k1 = super.myHeight / 2 + 50;
                k1 += 20;
                if(super.clickMode3 == 1 && super.saveClickX >= j1 - 75 && super.saveClickX <= j1 + 75 && super.saveClickY >= k1 - 20 && super.saveClickY <= k1 + 20) {
                    this.anInt1038 = 0;
                    this.method84(this.myUsername, this.myPassword, false);
                    if(loggedIn) {
                        return;
                    }
                }

                j1 = super.myWidth / 2 + 80;
                if(super.clickMode3 == 1 && super.saveClickX >= j1 - 75 && super.saveClickX <= j1 + 75 && super.saveClickY >= k1 - 20 && super.saveClickY <= k1 + 20) {
                    this.anInt833 = 0;
                }

                while(true) {
                    while(true) {
                        int l1 = this.method5(-796);
                        if(l1 == -1) {
                            return;
                        }

                        boolean flag1 = false;

                        for(int i2 = 0; i2 < aString1162.length(); ++i2) {
                            if(l1 == aString1162.charAt(i2)) {
                                flag1 = true;
                                break;
                            }
                        }

                        if(this.anInt1216 == 0) {
                            if(l1 == 8 && this.myUsername.length() > 0) {
                                this.myUsername = this.myUsername.substring(0, this.myUsername.length() - 1);
                            }

                            if(l1 == 9 || l1 == 10 || l1 == 13) {
                                this.anInt1216 = 1;
                            }

                            if(flag1) {
                                this.myUsername = this.myUsername + (char)l1;
                            }

                            if(this.myUsername.length() > 12) {
                                this.myUsername = this.myUsername.substring(0, 12);
                            }
                        } else if(this.anInt1216 == 1) {
                            if(l1 == 8 && this.myPassword.length() > 0) {
                                this.myPassword = this.myPassword.substring(0, this.myPassword.length() - 1);
                            }

                            if(l1 == 9 || l1 == 10 || l1 == 13) {
                                this.anInt1216 = 0;
                            }

                            if(flag1) {
                                this.myPassword = this.myPassword + (char)l1;
                            }

                            if(this.myPassword.length() > 20) {
                                this.myPassword = this.myPassword.substring(0, 20);
                            }
                        }
                    }
                }
            }

            if(this.anInt833 == 3) {
                k = super.myWidth / 2;
                j1 = super.myHeight / 2 + 50;
                j1 += 20;
                if(super.clickMode3 == 1 && super.saveClickX >= k - 75 && super.saveClickX <= k + 75 && super.saveClickY >= j1 - 20 && super.saveClickY <= j1 + 20) {
                    this.anInt833 = 0;
                }
            }
        }

    }

    public final void method141(Sprite sprite, int i, int j, boolean flag) {
        if(sprite != null) {
            int k = this.anInt1185 + this.anInt1209 & 2047;
            int l = i * i + j * j;
            if(flag) {
                return;
            }

            if(l <= 6400) {
                int i1 = Model.SINE[k];
                int j1 = Model.COSINE[k];
                i1 = i1 * 256 / (this.anInt1170 + 256);
                j1 = j1 * 256 / (this.anInt1170 + 256);
                int k1 = j * i1 + i * j1 >> 16;
                int l1 = j * j1 - i * i1 >> 16;
                if(currentScreenMode == client.ScreenMode.FIXED) {
                    sprite.drawSprite(97 + k1 - sprite.maxWidth / 2 + 30, 83 - l1 - sprite.maxHeight / 2 - 4 + 5);
                } else {
                    sprite.drawSprite(77 + k1 - sprite.maxWidth / 2 + 4 + (currentGameWidth - 167), 85 - l1 - sprite.maxHeight / 2 - 4);
                }
            }
        }

    }

    private final void method142(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
        if(l1 < 4 || l1 > 4) {
            this.packet = this.in.readUnsignedByte();
        }

        if(i1 >= 1 && i >= 1 && i1 <= 102 && i <= 102) {
            if(lowMemory && j != this.anInt918) {
                return;
            }

            long i2 = 0L;
            boolean byte0 = true;
            boolean flag = false;
            boolean flag1 = false;
            if(j1 == 0) {
                i2 = this.aClass25_946.method300(j, i1, i);
            }

            if(j1 == 1) {
                i2 = this.aClass25_946.method301(j, i1, 0, i);
            }

            if(j1 == 2) {
                i2 = this.aClass25_946.method302(j, i1, i);
            }

            if(j1 == 3) {
                i2 = this.aClass25_946.method303(j, i1, i);
            }

            int j3;
            if(i2 != 0L) {
                j3 = this.aClass25_946.method304(j, i1, i, i2);
                int j2 = ObjectKey.getObjectId(i2);
                int k2 = j3 & 31;
                int l2 = j3 >> 6;
                ObjectDefinition objectDefinition_2;
                if(j1 == 0) {
                    this.aClass25_946.method291(i1, j, i, (byte)-119);
                    objectDefinition_2 = ObjectDefinition.forID(j2);
                    if(objectDefinition_2.aBoolean767) {
                        this.collisionMaps[j].method215(l2, k2, objectDefinition_2.aBoolean757, true, i1, i);
                    }
                }

                if(j1 == 1) {
                    this.aClass25_946.method292(0, i, j, i1);
                }

                if(j1 == 2) {
                    this.aClass25_946.method293(j, -978, i1, i);
                    objectDefinition_2 = ObjectDefinition.forID(j2);
                    if(i1 + objectDefinition_2.anInt744 > 103 || i + objectDefinition_2.anInt744 > 103 || i1 + objectDefinition_2.anInt761 > 103 || i + objectDefinition_2.anInt761 > 103) {
                        return;
                    }

                    if(objectDefinition_2.aBoolean767) {
                        this.collisionMaps[j].method216(l2, objectDefinition_2.anInt744, i1, i, (byte)6, objectDefinition_2.anInt761, objectDefinition_2.aBoolean757);
                    }
                }

                if(j1 == 3) {
                    this.aClass25_946.method294((byte)9, j, i, i1);
                    objectDefinition_2 = ObjectDefinition.forID(j2);
                    if(objectDefinition_2.aBoolean767 && objectDefinition_2.hasactions) {
                        this.collisionMaps[j].method218(360, i, i1);
                    }
                }
            }

            if(k1 >= 0) {
                j3 = j;
                if(j < 3 && (this.aByteArrayArrayArray1258[1][i1][i] & 2) == 2) {
                    j3 = j + 1;
                }

                ObjectManager.method188(this.aClass25_946, k, i, l, j3, this.collisionMaps[j], this.anIntArrayArrayArray1214, i1, k1, j, (byte)93);
            }
        }

    }

    private void updatePlayers(int i, Stream stream) {
        this.anInt839 = 0;
        this.anInt893 = 0;
        this.update_self_player(stream);
        this.method134((byte)2, i, stream);
        this.method91(stream, i, (byte)8);
        this.method49(i, (byte)2, stream);

        int i1;
        for(i1 = 0; i1 < this.anInt839; ++i1) {
            int l = this.anIntArray840[i1];
            if(this.players[l].anInt1537 != loopCycle) {
                this.players[l] = null;
            }
        }

        for(i1 = 0; i1 < this.anInt891; ++i1) {
            if(this.players[this.anIntArray892[i1]] == null) {
                signlink.reporterror(this.myUsername + " null entry in pl list - pos:" + i1 + " size:" + this.anInt891);
                throw new RuntimeException("eek");
            }
        }

    }

    public final void method144(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = 2048 - k & 2047;
        int i2 = 2048 - j1 & 2047;
        int j2 = 0;
        int k2 = 0;
        int l2 = j;
        if(i != 0) {
            this.method6();
        }

        int j3;
        int l3;
        int j4;
        if(l1 != 0) {
            j3 = Model.SINE[l1];
            l3 = Model.COSINE[l1];
            j4 = k2 * l3 - j * j3 >> 16;
            l2 = k2 * j3 + j * l3 >> 16;
            k2 = j4;
        }

        if(i2 != 0) {
            if(cameratoggle == 1) {
                if(zoom == 0) {
                    zoom = k2;
                }

                if(lftrit == 0) {
                    lftrit = j2;
                }

                if(fwdbwd == 0) {
                    fwdbwd = l2;
                }

                k2 = zoom;
                j2 = lftrit;
                l2 = fwdbwd;
            }

            j3 = Model.SINE[i2];
            l3 = Model.COSINE[i2];
            j4 = l2 * j3 + j2 * l3 >> 16;
            l2 = l2 * l3 - j2 * j3 >> 16;
            j2 = j4;
        }

        this.xCameraPos = l - j2;
        this.zCameraPos = i1 - k2;
        this.yCameraPos = k1 - l2;
        this.yCameraCurve = k;
        this.xCameraCurve = j1;
    }

    public void handleScrollPosition(String text, int frame) {
        if(text.startsWith(":scp:")) {
            int widget = Integer.parseInt(text.split(" ")[1]);
            Widget widget1 = Widget.interfaceCache[frame];
            widget1.scrollPosition = widget;
        } else if(text.startsWith(":scpfind:")) {
            Widget widget2 = Widget.interfaceCache[frame];
            this.sendString(7, widget2.scrollPosition + "");
        }

    }

    private void drawCounterOnScreen() {
        RSFont xp_font = this.newBoldFont;
        byte font_height = 24;
        short x = 510;
        byte y = -100;
        this.digits = this.xpCounter == 0?1:1 + (int)Math.floor(Math.log10((double)this.xpCounter));
        int lengthToRemove = Integer.toString(this.xpCounter).length();
        int i = this.regularText.getTextWidth(Integer.toString(this.xpCounter)) - this.regularText.getTextWidth(Integer.toString(this.xpCounter)) / 2;
        int a = lengthToRemove == 1?5:(lengthToRemove - 1) * 5;

        for(i = 0; i < this.xp_added.length; ++i) {
            if(this.xp_added[i][0] > -1) {
                if(this.xp_added[i][2] >= 0) {
                    int transparency = 256;
                    if(this.xp_added[i][2] > 120) {
                        transparency = (20 - (this.xp_added[i][2] - 120)) * 256 / 20;
                    }

                    String s = "<col=4682B4><trans=" + transparency + ">+" + NumberFormat.getIntegerInstance().format((long)this.xp_added[i][1]);
                    int icons_x_off = 0;
                    Sprite sprite = null;

                    for(int i2 = 0; i2 < this.skill_sprites.length; ++i2) {
                        if((this.xp_added[i][0] & 1 << i2) != 0) {
                            sprite = this.skill_sprites[i2];
                            icons_x_off += sprite.myWidth + 3;
                            sprite.drawSprite(x - a + 12 - xp_font.getTextWidth(s) - icons_x_off, y + 150 + (140 - this.xp_added[i][2]) - font_height / 2 - sprite.myHeight / 2, transparency);
                        }
                    }

                    xp_font.drawBasicString(s, x - a + 12 - xp_font.getTextWidth(s), y + 150 + (140 - this.xp_added[i][2]), 16777215, -1);
                }

                ++this.xp_added[i][2];
                if(this.xp_added[i][2] >= 140) {
                    this.xp_added[i][0] = -1;
                }
            }
        }

    }

    private void addToXPCounter(int skill, int xp) {
        RSFont xp_font = this.newBoldFont;
        byte font_height = 24;
        if(xp > 0) {
            this.xpCounter += xp;
            int lowest_y_off = Integer.MAX_VALUE;

            int list;
            for(list = 0; list < this.xp_added.length; ++list) {
                if(this.xp_added[list][0] > -1) {
                    lowest_y_off = Math.min(lowest_y_off, this.xp_added[list][2]);
                }
            }

            if(Configuration.xp_merge && lowest_y_off != Integer.MAX_VALUE && lowest_y_off <= 0) {
                for(list = 0; list < this.xp_added.length; ++list) {
                    if(this.xp_added[list][2] == lowest_y_off) {
                        this.xp_added[list][0] |= 1 << skill;
                        this.xp_added[list][1] += xp;
                        return;
                    }
                }
            } else {
                ArrayList var11 = new ArrayList();
                int y = font_height;
                boolean go_on = true;

                int i;
                while(go_on) {
                    go_on = false;

                    for(i = 0; i < this.xp_added.length; ++i) {
                        if(this.xp_added[i][0] != -1 && !var11.contains(new Integer(i)) && this.xp_added[i][2] < y) {
                            this.xp_added[i][2] = y;
                            y += font_height;
                            go_on = true;
                            var11.add(new Integer(i));
                        }
                    }
                }

                byte var10;
                if(lowest_y_off != Integer.MAX_VALUE && lowest_y_off < font_height) {
                    var10 = 0;
                } else {
                    var10 = 0;
                }

                for(i = 0; i < this.xp_added.length; ++i) {
                    if(this.xp_added[i][0] == -1) {
                        this.xp_added[i][0] = 1 << skill;
                        this.xp_added[i][1] = xp;
                        this.xp_added[i][2] = var10;
                        return;
                    }
                }
            }

            System.out.println("Failed to add to exp counter.");
        }
    }

    public static String insertCommas(long i) {
        return String.format("%,d", new Object[]{Long.valueOf(i)});
    }

    public final boolean parsePacket() {
        if(this.socketStream == null) {
            return false;
        } else {
            String s2;
            int j15;
            try {
                int exception = this.socketStream.available();
                if(exception == 0) {
                    return false;
                }

                if(this.packet == -1) {
                    this.socketStream.flushInputStream(this.in.buffer, 0, 1);
                    this.packet = this.in.buffer[0] & 255;
                    if(this.aISAACRandomGen_1000 != null) {
                        this.packet = (this.packet - this.aISAACRandomGen_1000.getNextIntKey() & 255);
                    }

                    this.packetSize = Class31.packetSizes[this.packet];
                    --exception;
                }

                if(this.packetSize == -1) {
                    if(exception <= 0) {
                        return false;
                    }

                    this.socketStream.flushInputStream(this.in.buffer, 0, 1);
                    this.packetSize = this.in.buffer[0] & 255;
                    --exception;
                }

                if(this.packetSize == -2) {
                    if(exception <= 1) {
                        return false;
                    }

                    this.socketStream.flushInputStream(this.in.buffer, 0, 2);
                    this.in.currentPosition = 0;
                    this.packetSize = this.in.readUnsignedShort();
                    exception -= 2;
                }

                if(exception < this.packetSize) {
                    return false;
                }

                this.in.currentPosition = 0;
                this.socketStream.flushInputStream(this.in.buffer, 0, this.packetSize);
                this.anInt1009 = 0;
                this.anInt843 = this.anInt842;
                this.anInt842 = this.anInt841;
                this.anInt841 = this.packet;
                if(this.packet == 81) {
                    this.updatePlayers(this.packetSize, this.in);
                    this.loadingMap = false;
                    this.packet = -1;
                    return true;
                }

                if(this.packet != -1 && showframeids == 1) {
                    System.out.println("Frameid:" + this.packet);
                }

                if(this.packet == 176) {
                    this.anInt1167 = this.in.readByteC(false);
                    this.anInt1154 = this.in.readUShortA(true);
                    this.anInt1120 = this.in.readUnsignedByte();
                    this.anInt1193 = this.in.method440(true);
                    this.anInt1006 = this.in.readUnsignedShort();
                    if(this.anInt1193 != 0 && openInterfaceID == -1) {
                        signlink.dnslookup(TextClass.method586(this.anInt1193, true));
                        this.clearTopInterfaces(537);
                        short var52 = 650;
                        if(this.anInt1167 != 201 || this.anInt1120 == 1) {
                            var52 = 655;
                        }

                        this.reportAbuseInput = "";
                        this.canMute = false;

                        for(j15 = 0; j15 < Widget.interfaceCache.length; ++j15) {
                            if(Widget.interfaceCache[j15] != null && Widget.interfaceCache[j15].contentType == var52) {
                                openInterfaceID = Widget.interfaceCache[j15].parentID;
                                break;
                            }
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                int var23;
                if(this.packet == 2) {
                    var23 = this.in.readUnsignedShort();
                    Widget.interfaceCache[var23].scrollPosition = 0;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 3) {
                    var23 = this.in.readUnsignedShort();
                    j15 = this.in.readUnsignedShort();
                    Widget.interfaceCache[var23].scrollMax = j15;
                    this.packet = -1;
                    return true;
                }
                if (this.packet == 232) {
                    // No data in this packet (packet length is 0)
                    // Just reset the packet and optionally do something visual
                    // For example, reset camera angle or center map view
                    this.packet = -1;
                    return true;
                }
                if (this.packet == 17) {
                    // Packet 17 is commonly used for camera reset or client heartbeat.
                    // This packet usually has no payload (packetSize == 0).


                    this.packet = -1;
                    return true;
                }
                if (this.packet == 216) {
                    // Packet 17 is commonly used for camera reset or client heartbeat.
                    // This packet usually has no payload (packetSize == 0).


                    this.packet = -1;
                    return true;
                }
                if (this.packet == 51) {
                    int i = in.readUnsignedByte();
                    int j = in.readUnsignedByte();
                    int k = in.readUnsignedByte();
                    int l = in.readUnsignedByte();
                    int i1 = in.readUnsignedShort();
                    int j1 = in.readUnsignedShort();
                    int k1 = in.readUnsignedByte();
                    int l1 = in.readUnsignedByte();
                    int i2 = in.readUnsignedShort();
                    int j2 = in.readUnsignedShort();
                    int k2 = in.readUnsignedByte();
                    int l2 = in.readUnsignedByte();

                    // Coordinates relative to region
                    int fromX = i + baseX;
                    int fromY = j + baseY;

                    aDoubleEndedQueue_1179.insertHead(new Class30_Sub2_Sub4_Sub4(
                            fromX * 128 + 64,
                            fromY * 128 + 64,
                            k * 128,
                            l * 128,
                            loopCycle,
                            loopCycle + i2,
                            j1,
                            k1,
                            l1,
                            i1,
                            k2
                    ));


                    this.packet = -1;
                    return true;
                }


                if(this.packet == 64) {
                    this.anInt1268 = this.in.readByteC(false);
                    this.anInt1269 = this.in.readByteA(2);

                    for(var23 = this.anInt1268; var23 < this.anInt1268 + 8; ++var23) {
                        for(j15 = this.anInt1269; j15 < this.anInt1269 + 8; ++j15) {
                            if(this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][var23][j15] != null) {
                                this.aDoubleEndedQueueArrayArrayArray827[this.anInt918][var23][j15] = null;
                                this.method25(var23, j15);
                            }
                        }
                    }

                    for(Class30_Sub1 var48 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetFirst(); var48 != null; var48 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetNext(false)) {
                        if(var48.anInt1297 >= this.anInt1268 && var48.anInt1297 < this.anInt1268 + 8 && var48.anInt1298 >= this.anInt1269 && var48.anInt1298 < this.anInt1269 + 8 && var48.anInt1295 == this.anInt918) {
                            var48.anInt1294 = 0;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 217) {
                    try {
                        this.clanUsername = this.in.readString();
                        this.clanMessage = TextInput.processText(this.in.readString(), 0);
                        this.clanTitle = this.in.readString();
                        this.channelRights = this.in.readUnsignedShort();
                        this.pushMessage(this.clanMessage, 12, this.clanUsername);
                    } catch (Exception var20) {
                        var20.printStackTrace();
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 185) {
                    var23 = this.in.method436((byte)-74);
                    Widget.interfaceCache[var23].anInt233 = 3;
                    if(localPlayer.aClass5_1698 == null) {
                        Widget.interfaceCache[var23].mediaID = (localPlayer.anIntArray1700[0] << 25) + (localPlayer.anIntArray1700[4] << 20) + (localPlayer.equipment[0] << 15) + (localPlayer.equipment[8] << 10) + (localPlayer.equipment[11] << 5) + localPlayer.equipment[1];
                    } else {
                        Widget.interfaceCache[var23].mediaID = (int)(305419896L + localPlayer.aClass5_1698.aLong78);
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 107) {
                    this.aBoolean1160 = false;

                    for(var23 = 0; var23 < 5; ++var23) {
                        this.aBooleanArray876[var23] = false;
                    }

                    this.xpCounter = 0;
                    this.packet = -1;
                    return true;
                }

                int j20;
                Widget var24;
                if(this.packet == 72) {
                    var23 = this.in.method434((byte)108);
                    var24 = Widget.interfaceCache[var23];

                    for(j20 = 0; j20 < var24.inventoryItemId.length; ++j20) {
                        var24.inventoryItemId[j20] = -1;
                        var24.inventoryItemId[j20] = 0;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 214) {
                    this.anInt822 = this.packetSize / 8;

                    for(var23 = 0; var23 < this.anInt822; ++var23) {
                        this.aLongArray925[var23] = this.in.readQWord(-35089);
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 166) {
                    this.aBoolean1160 = true;
                    this.anInt1098 = this.in.readUnsignedByte();
                    this.anInt1099 = this.in.readUnsignedByte();
                    this.anInt1100 = this.in.readUnsignedShort();
                    this.anInt1101 = this.in.readUnsignedByte();
                    this.anInt1102 = this.in.readUnsignedByte();
                    if(this.anInt1102 >= 100) {
                        this.xCameraPos = this.anInt1098 * 128 + 64;
                        this.yCameraPos = this.anInt1099 * 128 + 64;
                        this.zCameraPos = this.method42(this.anInt918, this.yCameraPos, true, this.xCameraPos) - this.anInt1100;
                    }

                    this.packet = -1;
                    return true;
                }

                int i23;
                int l25;
                if(this.packet == 134) {
                    this.tabAreaAltered = true;
                    var23 = this.in.readUnsignedByte();
                    j15 = this.in.method439((byte)41);
                    j20 = this.in.readUnsignedByte();
                    this.currentExp[var23] = j15;
                    this.currentLevels[var23] = j20;
                    this.maximumLevels[var23] = 1;
                    if(var23 < this.currentExp.length) {
                        i23 = j15 - this.currentExp[var23];
                        if(this.currentExp[var23] > -1) {
                            this.addToXPCounter(var23, i23);
                        }

                        for(l25 = 0; l25 < 98; ++l25) {
                            if(j15 >= anIntArray1019[l25]) {
                                this.maximumLevels[var23] = l25 + 2;
                            }
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 71) {
                    var23 = this.in.readUnsignedShort();
                    j15 = this.in.readByteS(0);
                    if(var23 == '\uffff') {
                        var23 = -1;
                    }

                    tabInterfaceIDs[j15] = var23;
                    this.tabAreaAltered = true;
                    this.aBoolean1103 = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 74) {
                    var23 = this.in.method434((byte)108);
                    if(var23 == '\uffff') {
                        var23 = -1;
                    }

                    if(var23 != this.currentSong && this.musicEnabled && this.previousSong == 0) {
                        this.nextSong = var23;
                        this.songChanging = true;
                        onDemandFetcher.method558(2, this.nextSong);
                    }

                    this.currentSong = var23;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 121) {
                    var23 = this.in.method436((byte)-74);
                    j15 = this.in.readUShortA(true);
                    if(this.musicEnabled && !lowMemory) {
                        this.nextSong = var23;
                        this.songChanging = false;
                        onDemandFetcher.method558(2, this.nextSong);
                        this.previousSong = j15;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 109) {
                    this.method44(true);
                    this.packet = -1;
                    return false;
                }

                if(this.packet == 70) {
                    var23 = this.in.readSignedWord();
                    j15 = this.in.method437(-665);
                    j20 = this.in.method434((byte)108);
                    Widget var45 = Widget.interfaceCache[j20];
                    var45.anInt263 = var23;
                    var45.anInt265 = j15;
                    this.packet = -1;
                    return true;
                }

                int j28;
                int i30;
                if(this.packet == 73 || this.packet == 241) {
                    var23 = this.currentRegionX;
                    j15 = this.currentRegionY;
                    if(this.packet == 73) {
                        var23 = mapX = MapX = this.in.readUShortA(true);
                        j15 = mapY = MapY = this.in.readUnsignedShort();
                        this.aBoolean1159 = false;
                    }

                    if(this.packet == 241) {
                        j15 = this.in.readUShortA(true);
                        this.in.initBitAccess(this.anInt1118);
                        j20 = 0;

                        while(true) {
                            if(j20 >= 4) {
                                this.in.method420(true);
                                var23 = this.in.readUnsignedShort();
                                this.aBoolean1159 = true;
                                break;
                            }

                            for(i23 = 0; i23 < 13; ++i23) {
                                for(l25 = 0; l25 < 13; ++l25) {
                                    j28 = this.in.readBits(1);
                                    if(j28 == 1) {
                                        this.anIntArrayArrayArray1129[j20][i23][l25] = this.in.readBits(26);
                                    } else {
                                        this.anIntArrayArrayArray1129[j20][i23][l25] = -1;
                                    }
                                }
                            }

                            ++j20;
                        }
                    }

                    if(this.currentRegionX == var23 && this.currentRegionY == j15 && this.anInt1023 == 2) {
                        this.packet = -1;
                        return true;
                    }

                    this.currentRegionX = var23;
                    this.currentRegionY = j15;
                    this.baseX = (this.currentRegionX - 6) * 8;
                    this.baseY = (this.currentRegionY - 6) * 8;
                    this.aBoolean1141 = false;
                    if((this.currentRegionX / 8 == 48 || this.currentRegionX / 8 == 49) && this.currentRegionY / 8 == 48) {
                        this.aBoolean1141 = true;
                    }

                    if(this.currentRegionX / 8 == 48 && this.currentRegionY / 8 == 148) {
                        this.aBoolean1141 = true;
                    }

                    this.anInt1023 = 1;
                    this.aLong824 = System.currentTimeMillis();
                    aRSImageProducer_1165.initDrawingArea();
                    DrawingArea.fillPixels(2, 210, 22, 16777215, 2, true);
                    DrawingArea.drawPixels(20, 3, 3, 0, 208);
                    this.regularText.method381(0, "Ghreborn is Loading - Please wait....", 23693, 18, 108);
                    this.regularText.method381(16777215, "Ghreborn is Loading - Please wait....", 23693, 17, 107);
                    aRSImageProducer_1165.method238(currentScreenMode == client.ScreenMode.FIXED?0:0, 23680, super.aGraphics12, currentScreenMode == client.ScreenMode.FIXED?0:0);
                    if(this.packet == 73) {
                        j20 = 0;
                        i23 = (this.currentRegionX - 6) / 8;

                        label1403:
                        while(true) {
                            if(i23 > (this.currentRegionX + 6) / 8) {
                                this.terrainData = new byte[j20][];
                                this.mapData = new byte[j20][];
                                this.mapCoordinates = new int[j20];
                                this.terrainIndices = new int[j20];
                                this.objectIndices = new int[j20];
                                j20 = 0;
                                i23 = (this.currentRegionX - 6) / 8;

                                while(true) {
                                    if(i23 > (this.currentRegionX + 6) / 8) {
                                        break label1403;
                                    }

                                    for(l25 = (this.currentRegionY - 6) / 8; l25 <= (this.currentRegionY + 6) / 8; ++l25) {
                                        this.mapCoordinates[j20] = (i23 << 8) + l25;
                                        if(this.aBoolean1141 && (l25 == 49 || l25 == 149 || l25 == 147 || i23 == 50 || i23 == 49 && l25 == 47)) {
                                            this.terrainIndices[j20] = -1;
                                            this.objectIndices[j20] = -1;
                                            ++j20;
                                        } else {
                                            j28 = this.terrainIndices[j20] = onDemandFetcher.method562(0, 0, l25, i23);
                                            if(j28 != -1) {
                                                onDemandFetcher.method558(3, j28);
                                            }

                                            i30 = this.objectIndices[j20] = onDemandFetcher.method562(1, 0, l25, i23);
                                            if(i30 != -1) {
                                                onDemandFetcher.method558(3, i30);
                                            }

                                            ++j20;
                                        }
                                    }

                                    ++i23;
                                }
                            }

                            for(l25 = (this.currentRegionY - 6) / 8; l25 <= (this.currentRegionY + 6) / 8; ++l25) {
                                ++j20;
                            }

                            ++i23;
                        }
                    }

                    int class30_sub1_1;
                    int l33;
                    if(this.packet == 241) {
                        j20 = 0;
                        int[] var43 = new int[676];
                        l25 = 0;

                        label1364:
                        while(true) {
                            int byte6;
                            int var36;
                            int var39;
                            if(l25 >= 4) {
                                this.terrainData = new byte[j20][];
                                this.mapData = new byte[j20][];
                                this.mapCoordinates = new int[j20];
                                this.terrainIndices = new int[j20];
                                this.objectIndices = new int[j20];
                                l25 = 0;

                                while(true) {
                                    if(l25 >= j20) {
                                        break label1364;
                                    }

                                    j28 = this.mapCoordinates[l25] = var43[l25];
                                    i30 = j28 >> 8 & 255;
                                    var36 = j28 & 255;
                                    var39 = this.terrainIndices[l25] = onDemandFetcher.method562(0, 0, var36, i30);
                                    if(var39 != -1) {
                                        onDemandFetcher.method558(3, var39);
                                    }

                                    byte6 = this.objectIndices[l25] = onDemandFetcher.method562(1, 0, var36, i30);
                                    if(byte6 != -1) {
                                        onDemandFetcher.method558(3, byte6);
                                    }

                                    ++l25;
                                }
                            }

                            for(j28 = 0; j28 < 13; ++j28) {
                                for(i30 = 0; i30 < 13; ++i30) {
                                    var36 = this.anIntArrayArrayArray1129[l25][j28][i30];
                                    if(var36 != -1) {
                                        var39 = var36 >> 14 & 1023;
                                        byte6 = var36 >> 3 & 2047;
                                        class30_sub1_1 = (var39 / 8 << 8) + byte6 / 8;

                                        for(l33 = 0; l33 < j20; ++l33) {
                                            if(var43[l33] == class30_sub1_1) {
                                                class30_sub1_1 = -1;
                                                break;
                                            }
                                        }

                                        if(class30_sub1_1 != -1) {
                                            var43[j20++] = class30_sub1_1;
                                        }
                                    }
                                }
                            }

                            ++l25;
                        }
                    }

                    j20 = this.baseX - this.anInt1036;
                    i23 = this.baseY - this.anInt1037;
                    this.anInt1036 = this.baseX;
                    this.anInt1037 = this.baseY;

                    for(l25 = 0; l25 < 16384; ++l25) {
                        Npc var49 = this.npcs[l25];
                        if(var49 != null) {
                            for(i30 = 0; i30 < 10; ++i30) {
                                var49.anIntArray1500[i30] -= j20;
                                var49.anIntArray1501[i30] -= i23;
                            }

                            var49.anInt1550 -= j20 * 128;
                            var49.anInt1551 -= i23 * 128;
                        }
                    }

                    for(l25 = 0; l25 < this.anInt888; ++l25) {
                        Player var50 = this.players[l25];
                        if(var50 != null) {
                            for(i30 = 0; i30 < 10; ++i30) {
                                var50.anIntArray1500[i30] -= j20;
                                var50.anIntArray1501[i30] -= i23;
                            }

                            var50.anInt1550 -= j20 * 128;
                            var50.anInt1551 -= i23 * 128;
                        }
                    }

                    this.loadingMap = true;
                    byte var47 = 0;
                    byte var51 = 104;
                    byte var41 = 1;
                    if(j20 < 0) {
                        var47 = 103;
                        var51 = -1;
                        var41 = -1;
                    }

                    byte var37 = 0;
                    byte var40 = 104;
                    byte var42 = 1;
                    if(i23 < 0) {
                        var37 = 103;
                        var40 = -1;
                        var42 = -1;
                    }

                    for(class30_sub1_1 = var47; class30_sub1_1 != var51; class30_sub1_1 += var41) {
                        for(l33 = var37; l33 != var40; l33 += var42) {
                            int i34 = class30_sub1_1 + j20;
                            int j34 = l33 + i23;

                            for(int k34 = 0; k34 < 4; ++k34) {
                                if(i34 >= 0 && j34 >= 0 && i34 < 104 && j34 < 104) {
                                    this.aDoubleEndedQueueArrayArrayArray827[k34][class30_sub1_1][l33] = this.aDoubleEndedQueueArrayArrayArray827[k34][i34][j34];
                                } else {
                                    this.aDoubleEndedQueueArrayArrayArray827[k34][class30_sub1_1][l33] = null;
                                }
                            }
                        }
                    }

                    for(Class30_Sub1 var46 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetFirst(); var46 != null; var46 = (Class30_Sub1)this.aDoubleEndedQueue_1179.reverseGetNext(false)) {
                        var46.anInt1297 -= j20;
                        var46.anInt1298 -= i23;
                        if(var46.anInt1297 < 0 || var46.anInt1298 < 0 || var46.anInt1297 >= 104 || var46.anInt1298 >= 104) {
                            var46.unlink();
                        }
                    }

                    if(this.anInt1261 != 0) {
                        this.anInt1261 -= j20;
                        this.anInt1262 -= i23;
                    }

                    this.aBoolean1160 = false;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 208) {
                    var23 = this.in.method437(-665);
                    if(var23 >= 0) {
                        this.method60(var23, (byte)6);
                    }

                    this.openWalkableInterface = var23;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 99) {
                    this.anInt1021 = this.in.readUnsignedByte();
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 75) {
                    var23 = this.in.method436((byte)-74);
                    j15 = this.in.method436((byte)-74);
                    Widget.interfaceCache[j15].anInt233 = 2;
                    Widget.interfaceCache[j15].mediaID = var23;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 114) {
                    this.anInt1104 = this.in.method434((byte)108) * 30;
                    this.broadcastTimer = 0L;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 60) {
                    this.anInt1269 = this.in.readUnsignedByte();
                    this.anInt1268 = this.in.readByteC(false);

                    while(this.in.currentPosition < this.packetSize) {
                        var23 = this.in.readUnsignedByte();
                        this.method137(this.in, var23);
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 35) {
                    var23 = this.in.readUnsignedByte();
                    j15 = this.in.readUnsignedByte();
                    j20 = this.in.readUnsignedByte();
                    i23 = this.in.readUnsignedByte();
                    this.aBooleanArray876[var23] = true;
                    this.anIntArray873[var23] = j15;
                    this.anIntArray1203[var23] = j20;
                    this.anIntArray928[var23] = i23;
                    this.anIntArray1030[var23] = 0;
                    this.packet = -1;
                    return true;
                }

                if (this.packet == 174) {
                    int soundId = this.in.readUnsignedShort();
                    int delay = this.in.readUnsignedShort(); // this can be 0
                    int volume = this.in.readUnsignedByte();

                    // Queue download
                    client.onDemandFetcher.method558(5, soundId);

                    // Store the play request in a queue or array for when data arrives
                    SoundRequestQueue.add(new SoundRequest(soundId, volume, delay));

                    this.packet = -1;
                    return true;
                }



                if(this.packet == 104) {
                    var23 = this.in.readByteC(false);
                    j15 = this.in.readByteS(0);
                    String var32 = this.in.readString();
                    if(var23 >= 1 && var23 <= 5) {
                        if(var32.equalsIgnoreCase("null")) {
                            var32 = null;
                        }

                        this.aStringArray1127[var23 - 1] = var32;
                        this.aBooleanArray1128[var23 - 1] = j15 == 0;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 78) {
                    this.anInt1261 = 0;
                    this.packet = -1;
                    return true;
                }

                boolean var34;
                String var35;
                if(this.packet == 253) {
                    s2 = this.in.readString();
                    String var38;
                    if(s2.endsWith(":test:")) {
                        var38 = s2.substring(0, s2.indexOf(":"));
                        System.out.println("s3: " + var38);
                    } else {
                        long var28;
                        if(s2.endsWith(":tradereq:")) {
                            var38 = s2.substring(0, s2.indexOf(":"));
                            var28 = TextClass.longForName(var38);
                            var34 = false;

                            for(j28 = 0; j28 < this.anInt822; ++j28) {
                                if(this.aLongArray925[j28] == var28) {
                                    var34 = true;
                                    break;
                                }
                            }

                            if(!var34 && this.anInt1251 == 0) {
                                this.pushMessage("wishes to trade with you.", 4, var38);
                            }
                        } else if(s2.endsWith(":clan:")) {
                            var38 = s2.substring(0, s2.indexOf(":"));
                            TextClass.longForName(var38);
                            this.pushMessage("Clan: ", 8, var38);
                        } else if(s2.endsWith(":duelreq:")) {
                            var38 = s2.substring(0, s2.indexOf(":"));
                            var28 = TextClass.longForName(var38);
                            var34 = false;

                            for(j28 = 0; j28 < this.anInt822; ++j28) {
                                if(this.aLongArray925[j28] == var28) {
                                    var34 = true;
                                    break;
                                }
                            }

                            if(!var34 && this.anInt1251 == 0) {
                                this.pushMessage("wishes to duel with you.", 8, var38);
                            }
                        } else if(!s2.endsWith(":chalreq:")) {
                            this.pushMessage(s2, 0, "");
                        } else {
                            var38 = s2.substring(0, s2.indexOf(":"));
                            var28 = TextClass.longForName(var38);
                            var34 = false;

                            for(j28 = 0; j28 < this.anInt822; ++j28) {
                                if(this.aLongArray925[j28] == var28) {
                                    var34 = true;
                                    break;
                                }
                            }

                            if(!var34 && this.anInt1251 == 0) {
                                var35 = s2.substring(s2.indexOf(":") + 1, s2.length() - 9);
                                this.pushMessage(var35, 8, var38);
                            }
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 1) {
                    for(var23 = 0; var23 < this.players.length; ++var23) {
                        if(this.players[var23] != null) {
                            this.players[var23].primaryanim = -1;
                        }
                    }

                    for(var23 = 0; var23 < this.npcs.length; ++var23) {
                        if(this.npcs[var23] != null) {
                            this.npcs[var23].primaryanim = -1;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                long var33;
                if(this.packet == 50) {
                    var33 = this.in.readQWord(-35089);
                    j20 = this.in.readUnsignedByte();
                    String var31 = TextClass.fixName(TextClass.nameForLong(var33));

                    for(l25 = 0; l25 < this.friendsCount; ++l25) {
                        if(var33 == this.friendsListAsLongs[l25]) {
                            if(this.friendsNodeIDs[l25] != j20) {
                                this.friendsNodeIDs[l25] = j20;
                                this.tabAreaAltered = true;
                                if(j20 > 1) {
                                    this.pushMessage(var31 + " has logged in.", 5, "");
                                }

                                if(j20 == 1) {
                                    this.pushMessage(var31 + " has logged out.", 5, "");
                                }
                            }

                            var31 = null;
                            break;
                        }
                    }

                    if(var31 != null && this.friendsCount < 200) {
                        this.friendsListAsLongs[this.friendsCount] = var33;
                        this.friendsList[this.friendsCount] = var31;
                        this.friendsNodeIDs[this.friendsCount] = j20;
                        ++this.friendsCount;
                        this.tabAreaAltered = true;
                    }

                    var34 = false;

                    while(!var34) {
                        var34 = true;

                        for(j28 = 0; j28 < this.friendsCount - 1; ++j28) {
                            if(this.friendsNodeIDs[j28] != anInt957 && this.friendsNodeIDs[j28 + 1] == anInt957 || this.friendsNodeIDs[j28] == 0 && this.friendsNodeIDs[j28 + 1] != 0) {
                                i30 = this.friendsNodeIDs[j28];
                                this.friendsNodeIDs[j28] = this.friendsNodeIDs[j28 + 1];
                                this.friendsNodeIDs[j28 + 1] = i30;
                                String s10 = this.friendsList[j28];
                                this.friendsList[j28] = this.friendsList[j28 + 1];
                                this.friendsList[j28 + 1] = s10;
                                long l32 = this.friendsListAsLongs[j28];
                                this.friendsListAsLongs[j28] = this.friendsListAsLongs[j28 + 1];
                                this.friendsListAsLongs[j28 + 1] = l32;
                                this.tabAreaAltered = true;
                                var34 = false;
                            }
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 110) {
                    if(tabID == 12) {
                        this.tabAreaAltered = true;
                    }

                    this.anInt1148 = this.in.readUnsignedByte();
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 254) {
                    this.hintType = this.in.readUnsignedByte();
                    if(this.hintType == 1) {
                        this.anInt1222 = this.in.readUnsignedShort();
                    }

                    if(this.hintType >= 2 && this.hintType <= 6) {
                        if(this.hintType == 2) {
                            this.anInt937 = 64;
                            this.anInt938 = 64;
                        }

                        if(this.hintType == 3) {
                            this.anInt937 = 0;
                            this.anInt938 = 64;
                        }

                        if(this.hintType == 4) {
                            this.anInt937 = 128;
                            this.anInt938 = 64;
                        }

                        if(this.hintType == 5) {
                            this.anInt937 = 64;
                            this.anInt938 = 0;
                        }

                        if(this.hintType == 6) {
                            this.anInt937 = 64;
                            this.anInt938 = 128;
                        }

                        this.hintType = 2;
                        this.anInt934 = this.in.readUnsignedShort();
                        this.anInt935 = this.in.readUnsignedShort();
                        this.anInt936 = this.in.readUnsignedByte();
                    }

                    if(this.hintType == 10) {
                        this.anInt933 = this.in.readUnsignedShort();
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 248) {
                    var23 = this.in.readUShortA(true);
                    j15 = this.in.readUnsignedShort();
                    if(this.backDialogID != -1) {
                        this.backDialogID = -1;
                        this.inputTaken = true;
                    }

                    if(this.inputDialogState != 0) {
                        this.inputDialogState = 0;
                        this.inputTaken = true;
                    }

                    openInterfaceID = var23;
                    this.invOverlayInterfaceID = j15;
                    this.tabAreaAltered = true;
                    this.aBoolean1103 = true;
                    this.aBoolean1149 = false;
                    this.packet = -1;
                    return true;
                }

                Widget var26;
                if(this.packet == 79) {
                    var23 = this.in.method434((byte)108);
                    j15 = this.in.readUShortA(true);
                    var26 = Widget.interfaceCache[var23];
                    if(var26 != null && var26.type == 0) {
                        if(j15 < 0) {
                            j15 = 0;
                        }

                        if(j15 > var26.scrollMax - var26.height) {
                            j15 = var26.scrollMax - var26.height;
                        }

                        var26.scrollPosition = j15;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 68) {
                    for(var23 = 0; var23 < this.variousSettings.length; ++var23) {
                        if(this.variousSettings[var23] != this.anIntArray1045[var23]) {
                            this.variousSettings[var23] = this.anIntArray1045[var23];
                            this.method33(false, var23);
                            this.tabAreaAltered = true;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 196) {
                    var33 = this.in.readQWord(-35089);
                    j20 = this.in.readDWord();
                    i23 = this.in.readUnsignedByte();
                    var34 = false;

                    for(j28 = 0; j28 < 100; ++j28) {
                        if(this.anIntArray1240[j28] == j20) {
                            var34 = true;
                            break;
                        }
                    }

                    if(i23 <= 1) {
                        for(j28 = 0; j28 < this.anInt822; ++j28) {
                            if(this.aLongArray925[j28] == var33) {
                                var34 = true;
                                break;
                            }
                        }
                    }

                    if(!var34 && this.anInt1251 == 0) {
                        try {
                            this.anIntArray1240[this.anInt1169] = j20;
                            this.anInt1169 = (this.anInt1169 + 1) % 100;
                            var35 = TextInput.method525(this.packetSize - 13, true, this.in);
                            if(i23 != 3) {
                                var35 = Censor.method497(var35, 0);
                            }

                            switch(i23) {
                                case 1:
                                    this.pushMessage(var35, 7, "@cr1@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 2:
                                    this.pushMessage(var35, 7, "@cr2@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 3:
                                    this.pushMessage(var35, 7, "@cr3@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 4:
                                    this.pushMessage(var35, 7, "@cr4@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 5:
                                    this.pushMessage(var35, 7, "@cr5@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 6:
                                    this.pushMessage(var35, 7, "@cr6@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 7:
                                    this.pushMessage(var35, 7, "@cr7@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 8:
                                    this.pushMessage(var35, 7, "@cr8@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 9:
                                    this.pushMessage(var35, 7, "@cr9@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 10:
                                    this.pushMessage(var35, 7, "@cr10@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 11:
                                    this.pushMessage(var35, 7, "@cr11@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 12:
                                    this.pushMessage(var35, 7, "@cr12@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 13:
                                    this.pushMessage(var35, 7, "@cr13@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 14:
                                    this.pushMessage(var35, 7, "@cr14@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 15:
                                    this.pushMessage(var35, 7, "@cr15@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 16:
                                    this.pushMessage(var35, 7, "@cr16@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 17:
                                    this.pushMessage(var35, 7, "@cr17@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 18:
                                    this.pushMessage(var35, 7, "@cr18@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 19:
                                    this.pushMessage(var35, 7, "@cr19@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 20:
                                    this.pushMessage(var35, 7, "@cr20@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 21:
                                    this.pushMessage(var35, 7, "@cr21@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                case 22:
                                    this.pushMessage(var35, 7, "@cr22@" + TextClass.fixName(TextClass.nameForLong(var33)));
                                    break;
                                default:
                                    this.pushMessage(var35, 3, TextClass.fixName(TextClass.nameForLong(var33)));
                            }
                        } catch (Exception var19) {
                            signlink.reporterror("cde1");
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 85) {
                    this.anInt1269 = this.in.readByteC(false);
                    this.anInt1268 = this.in.readByteC(false);
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 24) {
                    this.anInt1054 = this.in.readByteA(2);
                    if(this.anInt1054 == tabID) {
                        if(this.anInt1054 == 3) {
                            tabID = 1;
                        } else {
                            tabID = 3;
                        }

                        this.tabAreaAltered = true;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 246) {
                    var23 = this.in.method434((byte)108);
                    j15 = this.in.readUnsignedShort();
                    j20 = this.in.readUnsignedShort();
                    if(j20 == '\uffff') {
                        Widget.interfaceCache[var23].anInt233 = 0;
                        this.packet = -1;
                        return true;
                    }

                    ItemDefinition var29 = ItemDefinition.method198(j20);
                    Widget.interfaceCache[var23].anInt233 = 4;
                    Widget.interfaceCache[var23].mediaID = j20;
                    Widget.interfaceCache[var23].modelRotation1 = var29.spritePitch;
                    Widget.interfaceCache[var23].modelRotation2 = var29.spriteCameraRoll;
                    Widget.interfaceCache[var23].modelZoom = var29.spriteScale * 100 / j15;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 171) {
                    boolean var30 = this.in.readUnsignedByte() == 1;
                    j15 = this.in.readUnsignedShort();
                    Widget.interfaceCache[j15].isMouseoverTriggered = var30;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 142) {
                    var23 = this.in.method434((byte)108);
                    this.method60(var23, (byte)6);
                    if(this.backDialogID != -1) {
                        this.backDialogID = -1;
                        this.inputTaken = true;
                    }

                    if(this.inputDialogState != 0) {
                        this.inputDialogState = 0;
                        this.inputTaken = true;
                    }

                    this.invOverlayInterfaceID = var23;
                    this.tabAreaAltered = true;
                    this.aBoolean1103 = true;
                    openInterfaceID = -1;
                    this.aBoolean1149 = false;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 126) {
                    s2 = this.in.readString();
                    j15 = this.in.readUShortA(true);
                    this.handleScrollPosition(s2, j15);
                    if(!s2.startsWith("www.") && !s2.startsWith("http")) {
                        if(j15 >= 18144 && j15 <= 18244) {
                            this.clanList[j15 - 18144] = s2;
                        }

                        Widget.interfaceCache[j15].message = s2;
                        if(Widget.interfaceCache[j15].parentID == tabInterfaceIDs[tabID]) {
                            this.tabAreaAltered = true;
                        }

                        this.packet = -1;
                        return true;
                    }

                    this.launchURL(s2);
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 170) {
                    try {
                        s2 = this.in.readString();
                    } catch (Exception var18) {
                        var18.printStackTrace();
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 179) {
                    try {
                        var23 = this.in.readUnsignedByte();
                        j15 = this.in.readUnsignedByte();
                        if(var23 == -1) {
                            BroadcastManager.removeIndex(j15);
                            return true;
                        }

                        Broadcast var27 = new Broadcast();
                        var27.type = var23;
                        var27.index = j15;
                        var27.message = this.in.readString();
                        if(var23 == 1) {
                            var27.url = this.in.readString();
                        } else if(var23 == 2) {
                            var27.x = this.in.readDWord();
                            var27.y = this.in.readDWord();
                            var27.z = this.in.readUnsignedByte();
                        }

                        var27.setExpireDelay();
                        BroadcastManager.addBoradcast(var27);
                    } catch (Exception var17) {
                        var17.printStackTrace();
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 206) {
                    this.publicChatMode = this.in.readUnsignedByte();
                    this.privateChatMode = this.in.readUnsignedByte();
                    this.tradeMode = this.in.readUnsignedByte();
                    this.aBoolean1233 = true;
                    this.inputTaken = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 240) {
                    if(tabID == 12) {
                        this.tabAreaAltered = true;
                    }

                    this.anInt878 = this.in.readSignedWord();
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 8) {
                    var23 = this.in.method436((byte)-74);
                    j15 = this.in.readUnsignedShort();
                    Widget.interfaceCache[var23].anInt233 = 1;
                    Widget.interfaceCache[var23].mediaID = j15;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 122) {
                    var23 = this.in.method436((byte)-74);
                    j15 = this.in.method436((byte)-74);
                    j20 = j15 >> 10 & 31;
                    i23 = j15 >> 5 & 31;
                    l25 = j15 & 31;
                    Widget.interfaceCache[var23].textColor = (j20 << 19) + (i23 << 11) + (l25 << 3);
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 53) {
                    this.tabAreaAltered = true;
                    var23 = this.in.readUnsignedShort();
                    var24 = Widget.interfaceCache[var23];
                    j20 = this.in.readUnsignedShort();

                    for(i23 = 0; i23 < j20; ++i23) {
                        l25 = this.in.readUnsignedByte();
                        if(l25 == 255) {
                            l25 = this.in.method440(true);
                        }

                        var24.inventoryItemId[i23] = this.in.method436((byte)-74);
                        var24.inventoryAmounts[i23] = l25;
                    }

                    for(i23 = j20; i23 < var24.inventoryItemId.length; ++i23) {
                        var24.inventoryItemId[i23] = 0;
                        var24.inventoryAmounts[i23] = 0;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 230) {
                    var23 = this.in.readUShortA(true);
                    j15 = this.in.readUnsignedShort();
                    j20 = this.in.readUnsignedShort();
                    i23 = this.in.method436((byte)-74);
                    Widget.interfaceCache[j15].modelRotation1 = j20;
                    Widget.interfaceCache[j15].modelRotation2 = i23;
                    Widget.interfaceCache[j15].modelZoom = var23;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 221) {
                    this.anInt900 = this.in.readUnsignedByte();
                    this.tabAreaAltered = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 177) {
                    this.aBoolean1160 = true;
                    this.anInt995 = this.in.readUnsignedByte();
                    this.anInt996 = this.in.readUnsignedByte();
                    this.anInt997 = this.in.readUnsignedShort();
                    this.anInt998 = this.in.readUnsignedByte();
                    this.anInt999 = this.in.readUnsignedByte();
                    if(this.anInt999 >= 100) {
                        var23 = this.anInt995 * 128 + 64;
                        j15 = this.anInt996 * 128 + 64;
                        j20 = this.method42(this.anInt918, j15, true, var23) - this.anInt997;
                        i23 = var23 - this.xCameraPos;
                        l25 = j20 - this.zCameraPos;
                        j28 = j15 - this.yCameraPos;
                        i30 = (int)Math.sqrt((double)(i23 * i23 + j28 * j28));
                        this.yCameraCurve = (int)(Math.atan2((double)l25, (double)i30) * 325.949D) & 2047;
                        this.xCameraCurve = (int)(Math.atan2((double)i23, (double)j28) * -325.949D) & 2047;
                        if(this.yCameraCurve < 128) {
                            this.yCameraCurve = 128;
                        }

                        if(this.yCameraCurve > 383) {
                            this.yCameraCurve = 383;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 249) {
                    this.anInt1046 = this.in.readByteS(0);
                    this.anInt884 = this.in.method436((byte)-74);
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 65) {
                    this.updateNPCs(this.in, this.packetSize);
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 27) {
                    this.messagePromptRaised = false;
                    this.inputDialogState = 1;
                    this.amountOrNameInput = "";
                    this.inputTaken = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 187) {
                    this.messagePromptRaised = false;
                    this.inputDialogState = 2;
                    this.amountOrNameInput = "";
                    this.inputTaken = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 97) {
                    var23 = this.in.readUnsignedShort();
                    this.method60(var23, (byte)6);
                    if(this.invOverlayInterfaceID != -1) {
                        this.invOverlayInterfaceID = -1;
                        this.tabAreaAltered = true;
                        this.aBoolean1103 = true;
                    }

                    if(this.backDialogID != -1) {
                        this.backDialogID = -1;
                        this.inputTaken = true;
                    }

                    if(this.inputDialogState != 0) {
                        this.inputDialogState = 0;
                        this.inputTaken = true;
                    }

                    openInterfaceID = var23;
                    this.aBoolean1149 = false;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 218) {
                    var23 = this.in.method438(false);
                    this.dialogID = var23;
                    this.inputTaken = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 87) {
                    var23 = this.in.method434((byte)108);
                    j15 = this.in.method439((byte)41);
                    this.anIntArray1045[var23] = j15;
                    if(this.variousSettings[var23] != j15) {
                        this.variousSettings[var23] = j15;
                        this.method33(false, var23);
                        this.tabAreaAltered = true;
                        if(this.dialogID != -1) {
                            this.inputTaken = true;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 36) {
                    var23 = this.in.method434((byte)108);
                    byte var25 = this.in.readSignedByte();
                    this.anIntArray1045[var23] = var25;
                    if(this.variousSettings[var23] != var25) {
                        this.variousSettings[var23] = var25;
                        this.method33(false, var23);
                        this.tabAreaAltered = true;
                        if(this.dialogID != -1) {
                            this.inputTaken = true;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 61) {
                    this.anInt1055 = this.in.readUnsignedByte();
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 200) {
                    var23 = this.in.readUnsignedShort();
                    j15 = this.in.readSignedWord();
                    var26 = Widget.interfaceCache[var23];
                    var26.disabledAnimationId = j15;
                    var26.modelZoom = 1600;
                    if(j15 == -1) {
                        var26.anInt246 = 0;
                        var26.anInt208 = 0;
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 219) {
                    if(this.invOverlayInterfaceID != -1) {
                        this.invOverlayInterfaceID = -1;
                        this.tabAreaAltered = true;
                        this.aBoolean1103 = true;
                    }

                    if(this.backDialogID != -1) {
                        this.backDialogID = -1;
                        this.inputTaken = true;
                    }

                    if(this.inputDialogState != 0) {
                        this.inputDialogState = 0;
                        this.inputTaken = true;
                    }

                    openInterfaceID = -1;
                    this.aBoolean1149 = false;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 34) {
                    this.tabAreaAltered = true;
                    var23 = this.in.readUnsignedShort();
                    var24 = Widget.interfaceCache[var23];

                    while(this.in.currentPosition < this.packetSize) {
                        j20 = this.in.readUSmart();
                        i23 = this.in.readUnsignedShort();
                        l25 = this.in.readUnsignedByte();
                        if(l25 == 255) {
                            l25 = this.in.readDWord();
                        }

                        if(j20 >= 0 && j20 < var24.inventoryItemId.length) {
                            var24.inventoryItemId[j20] = i23;
                            var24.inventoryAmounts[j20] = l25;
                        }
                    }

                    this.packet = -1;
                    return true;
                }

                if(this.packet == 105 || this.packet == 84 || this.packet == 147 || this.packet == 215 || this.packet == 4 || this.packet == 117 || this.packet == 156 || this.packet == 44 || this.packet == 160 || this.packet == 101 || this.packet == 151) {
                    this.method137(this.in, this.packet);
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 106) {
                    tabID = this.in.readByteC(false);
                    this.tabAreaAltered = true;
                    this.aBoolean1103 = true;
                    this.packet = -1;
                    return true;
                }

                if(this.packet == 164) {
                    var23 = this.in.method434((byte)108);
                    this.method60(var23, (byte)6);
                    if(this.invOverlayInterfaceID != -1) {
                        this.invOverlayInterfaceID = -1;
                        this.tabAreaAltered = true;
                        this.aBoolean1103 = true;
                    }

                    this.backDialogID = var23;
                    this.inputTaken = true;
                    openInterfaceID = -1;
                    this.aBoolean1149 = false;
                    this.packet = -1;
                    return true;
                }

                signlink.reporterror("T1 - last packet received " + this.packet + ", packet length " + this.packetSize + ", previous packet " + this.anInt842 + ", third packet " + this.anInt843);
                this.method44(true);
            } catch (IOException var21) {
                this.method68(-670);
            } catch (Exception var22) {
                s2 = "T2 - last packet received" + this.packet + ", previous packet " + this.anInt842 + ", third packet " + this.anInt843 + ", packet length " + this.packetSize + ", ABSX " + (this.baseX + localPlayer.anIntArray1500[0]) + ", ABSY" + (this.baseY + localPlayer.anIntArray1501[0]) + " - packet data ";

                for(j15 = 0; j15 < this.packetSize && j15 < 50; ++j15) {
                    s2 = s2 + this.in.buffer[j15] + ",";
                }

                signlink.reporterror(s2);
                this.method44(true);
            }

            return true;
        }
    }

    public int mixColors(Color color1, Color color2, float i) {
        float ratio = i / 100.0F;
        int red = (int)((float)color2.getRed() * ratio + (float)color1.getRed() * (1.0F - ratio));
        int green = (int)((float)color2.getGreen() * ratio + (float)color1.getGreen() * (1.0F - ratio));
        int blue = (int)((float)color2.getBlue() * ratio + (float)color1.getBlue() * (1.0F - ratio));
        return (new Color(red, green, blue)).getRGB();
    }

    public final void method146(byte byte0) {
        ++this.renderCount;
        this.method47(0, true);
        this.method26(true, this.anInt882);
        this.method47(0, false);
        this.method26(false, this.anInt882);
        this.method55(-948);
        this.method104(true);
        int j;
        int l;
        if(!this.aBoolean1160) {
            j = this.anInt1184;
            if(this.anInt984 / 256 > j) {
                j = this.anInt984 / 256;
            }

            if(this.aBooleanArray876[4] && this.anIntArray1203[4] + 128 > j) {
                j = this.anIntArray1203[4] + 128;
            }

            l = this.anInt1185 + this.anInt896 & 2047;
            this.method144(0, cameraZoom + j * 3, j, this.anInt1014, this.method42(this.anInt918, localPlayer.anInt1551, true, localPlayer.anInt1550) - 50, l, this.anInt1015);
        }

        if(!this.aBoolean1160) {
            j = this.method120(111);
        } else {
            j = this.method121(this.anInt1081);
        }

        l = this.xCameraPos;
        int i1 = this.zCameraPos;
        int j1 = this.yCameraPos;
        int k1 = this.yCameraCurve;
        int l1 = this.xCameraCurve;

        int k2;
        for(k2 = 0; k2 < 5; ++k2) {
            if(this.aBooleanArray876[k2]) {
                int e = (int)(Math.random() * (double)(this.anIntArray873[k2] * 2 + 1) - (double)this.anIntArray873[k2] + Math.sin((double)this.anIntArray1030[k2] * ((double)this.anIntArray928[k2] / 100.0D)) * (double)this.anIntArray1203[k2]);
                if(k2 == 0) {
                    this.xCameraPos += e;
                }

                if(k2 == 1) {
                    this.zCameraPos += e;
                }

                if(k2 == 2) {
                    this.yCameraPos += e;
                }

                if(k2 == 3) {
                    this.xCameraCurve = this.xCameraCurve + e & 2047;
                }

                if(k2 == 4) {
                    this.yCameraCurve += e;
                    if(this.yCameraCurve < 128) {
                        this.yCameraCurve = 128;
                    }

                    if(this.yCameraCurve > 383) {
                        this.yCameraCurve = 383;
                    }
                }
            }
        }

        k2 = Rasterizer.anInt1481;
        Model.aBoolean1684 = true;
        Model.anInt1687 = 0;
        Model.anInt1685 = super.mouseX - (currentScreenMode == client.ScreenMode.FIXED?0:0);
        Model.anInt1686 = super.mouseY - (currentScreenMode == client.ScreenMode.FIXED?0:0);
        DrawingArea.setAllPixelsToZero();
        if(Configuration.distanceFog) {
            if(!switching && currentFogColor != fadingTo) {
                switching = true;
            }

            if(switching) {
                ++step;
                if(step >= 100) {
                    step = 1;
                    switching = false;
                    currentFogColor = fadingTo;
                } else {
                    currentFogColor = this.mixColors(new Color(currentFogColor), new Color(fadingTo), (float)step);
                }
            }
        }

        DrawingArea.drawPixels(currentGameHeight, 0, 0, Configuration.distanceFog?currentFogColor:0, currentGameWidth);

        try {
            this.aClass25_946.method313(this.xCameraPos, this.yCameraPos, this.xCameraCurve, this.zCameraPos, j, this.yCameraCurve, false);
            this.aClass25_946.method288((byte)104);
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        this.method34(this.anInt898);
        this.method61(-252);
        this.method37(854, k2);
        if(this.expDrops) {
            this.drawExpCounterDrops();
        }

        if(currentScreenMode != client.ScreenMode.FIXED) {
            this.drawChatArea(6);
            this.drawMinimap(false);
            this.drawTabArea((byte)-81);
        }

        this.draw3dScreen(8);
        aRSImageProducer_1165.method238(currentScreenMode == client.ScreenMode.FIXED?0:0, 23680, super.aGraphics12, currentScreenMode == client.ScreenMode.FIXED?0:0);
        this.xCameraPos = l;
        this.zCameraPos = i1;
        this.yCameraPos = j1;
        this.yCameraCurve = k1;
        this.xCameraCurve = l1;
    }

    public final void clearTopInterfaces(int i) {
        this.stream.createFrame(130);
        if(this.invOverlayInterfaceID != -1) {
            this.invOverlayInterfaceID = -1;
            this.tabAreaAltered = true;
            this.aBoolean1149 = false;
            this.aBoolean1103 = true;
        }

        if(this.backDialogID != -1) {
            this.backDialogID = -1;
            this.inputTaken = true;
            this.aBoolean1149 = false;
        }

        openInterfaceID = -1;
        if(i <= 0) {
            this.stream.writeUnsignedByte(13);
        }

    }

    public client() {
        this.skill_sprites = new Sprite[Skills.SKILLS_COUNT];
        this.chatRights = new int[500];
        this.anIntArray965 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
        this.modeX = new int[]{164, 230, 296, 362};
        this.modeNamesX = new int[]{26, 86, 150, 212, 286, 349, 427};
        this.modeNamesY = new int[]{158, 158, 153, 153, 153, 153, 158};
        this.channelButtonsX = new int[]{5, 71, 137, 203, 269, 335, 404};
        this.modeNames = new String[]{"All", "Game", "Public", "Private", "Clan", "Trade", "Report Abuse"};
        this.sideIconsX = new int[]{17, 49, 81, 114, 146, 180, 214, 16, 49, 82, 116, 148, 184, 217};
        this.sideIconsY = new int[]{9, 7, 5, 5, 2, 3, 7, 303, 306, 306, 302, 305, 303, 304, 303};
        this.sideIconsId = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        this.sideIconsTab = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        this.redStonesX = new int[]{6, 44, 77, 110, 143, 176, 209, 6, 44, 77, 110, 143, 176, 209};
        this.redStonesY = new int[]{0, 0, 0, 0, 0, 0, 0, 298, 298, 298, 298, 298, 298, 298};
        this.redStonesId = new int[]{9, 13, 13, 13, 13, 13, 10, 11, 13, 13, 13, 13, 13, 12};
        this.tabClickX = new int[]{38, 33, 33, 33, 33, 33, 38, 38, 33, 33, 33, 33, 33, 38};
        this.tabClickStart = new int[]{522, 560, 593, 625, 659, 692, 724, 522, 560, 593, 625, 659, 692, 724};
        this.tabClickY = new int[]{169, 169, 169, 169, 169, 169, 169, 466, 466, 466, 466, 466, 466, 466};
        this.anIntArray1177 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        this.anInt1239 = 100;
        instance = this;
        this.anIntArrayArray825 = new int[104][104];
        this.friendsNodeIDs = new int[200];
        this.aDoubleEndedQueueArrayArrayArray827 = new DoubleEndedQueue[4][104][104];
        this.aBoolean830 = true;
        this.aBoolean831 = false;
        this.aStream_834 = new Stream(new byte[5000], 891);
        this.npcs = new Npc[16384];
        this.npcIndices = new int[16384];
        this.anInt838 = 9;
        this.anIntArray840 = new int[1000];
        this.aStream_847 = Stream.method396(1, 9);
        this.aBoolean848 = true;
        openInterfaceID = -1;
        this.clanTitles = new String[500];
        this.currentExp = new int[Skills.SKILLS_COUNT];
        this.aBoolean872 = false;
        this.anIntArray873 = new int[5];
        this.BlackMap = new Sprite[2];
        this.anInt874 = -1;
        this.anInt875 = -680;
        this.aBooleanArray876 = new boolean[5];
        this.anInt877 = 1834;
        this.aBoolean880 = false;
        this.reportAbuseInput = "";
        this.anInt882 = -30815;
        this.anInt883 = 533;
        this.anInt884 = -1;
        this.menuOpen = false;
        this.inputString = "";
        this.anInt888 = 2048;
        this.maxPlayerCount = 2047;
        this.players = new Player[this.anInt888];
        this.anIntArray892 = new int[this.anInt888];
        this.anIntArray894 = new int[this.anInt888];
        this.aStreamArray895 = new Stream[this.anInt888];
        this.anInt897 = 1;
        this.anIntArrayArray901 = new int[104][104];
        this.anInt902 = 7759444;
        this.aByteArray912 = new byte[16384];
        this.aByte920 = 14;
        this.anInt921 = 732;
        this.currentLevels = new int[Skills.SKILLS_COUNT];
        this.aByte923 = 25;
        this.aLongArray925 = new long[100];
        this.aBoolean926 = false;
        this.anInt927 = 3353893;
        this.anIntArray928 = new int[5];
        this.anIntArrayArray929 = new int[104][104];
        this.aCRC32_930 = new CRC32();
        this.anInt939 = 748;
        this.chatTypes = new int[500];
        this.chatNames = new String[500];
        this.chatMessages = new String[500];
        this.sideIcons = new Sprite[15];
        this.aBoolean954 = true;
        this.friendsListAsLongs = new long[200];
        this.currentSong = -1;
        this.drawingFlames = false;
        this.spriteDrawX = -1;
        this.spriteDrawY = -1;
        this.anIntArray968 = new int[33];
        this.anIntArray969 = new int[256];
        this.aClass14Array970 = new Class14[7];
        this.variousSettings = new int[10000];
        this.aBoolean972 = false;
        this.aByte973 = -74;
        this.anInt975 = 50;
        this.anIntArray976 = new int[this.anInt975];
        this.anIntArray977 = new int[this.anInt975];
        this.anIntArray978 = new int[this.anInt975];
        this.anIntArray979 = new int[this.anInt975];
        this.overheadTextColour = new int[this.anInt975];
        this.anIntArray981 = new int[this.anInt975];
        this.overheadTextCycle = new int[this.anInt975];
        this.aStringArray983 = new String[this.anInt975];
        this.anInt985 = -1;
        this.aSpriteArray987 = new Sprite[30];
        this.anIntArray990 = new int[5];
        this.aBoolean991 = false;
        this.aBoolean994 = false;
        this.anInt1002 = 12233612;
        this.amountOrNameInput = "";
        this.aByte1012 = 24;
        this.aDoubleEndedQueue_1013 = new DoubleEndedQueue(169);
        this.aBoolean1017 = false;
        this.openWalkableInterface = -1;
        this.anIntArray1030 = new int[5];
        this.aBoolean1031 = false;
        this.aSpriteArray1033 = new Sprite[1001];
        this.dialogID = -1;
        this.aBoolean1043 = false;
        this.maximumLevels = new int[Skills.SKILLS_COUNT];
        this.anIntArray1045 = new int[2000];
        this.aBoolean1047 = true;
        this.anInt1050 = 111;
        this.anIntArray1052 = new int[151];
        this.anInt1054 = -1;
        this.aDoubleEndedQueue_1056 = new DoubleEndedQueue(169);
        this.anIntArray1057 = new int[33];
        this.anInt1058 = 24869;
        this.aClass9_1059 = new Widget();
        this.aBackgroundArray1060 = new Background[100];
        this.gameframe = new Sprite[70];
        this.anInt1063 = 5063219;
        this.anIntArray1065 = new int[7];
        this.anIntArray1072 = new int[1000];
        this.anIntArray1073 = new int[1000];
        this.loadingMap = false;
        this.anInt1081 = -733;
        this.friendsList = new String[200];
        this.in = Stream.method396(1, 9);
        this.anIntArray1090 = new int[9];
        this.menuActionCmd2 = new int[500];
        this.menuActionCmd3 = new int[500];
        this.menuActionID = new int[500];
        this.menuActionCmd1 = new long[500];
        this.headIcons = new Sprite[20];
        this.skullIcons = new Sprite[20];
        this.aBoolean1103 = false;
        this.anInt1105 = 519;
        this.aBoolean1106 = false;
        this.anInt1116 = 445;
        this.anInt1118 = -29508;
        this.anInt1119 = -77;
        this.aString1121 = "";
        this.aStringArray1127 = new String[5];
        this.aBooleanArray1128 = new boolean[5];
        this.anIntArrayArrayArray1129 = new int[4][13][13];
        this.anInt1132 = 2;
        this.anInt1135 = -12499;
        this.aSpriteArray1140 = new Sprite[2000];
        this.aBoolean1141 = false;
        this.aBoolean1149 = false;
        this.aSpriteArray1150 = new Sprite[8];
        this.musicEnabled = true;
        this.tabAreaAltered = false;
        loggedIn = false;
        this.canMute = false;
        this.aBoolean1159 = false;
        this.aBoolean1160 = false;
        this.anInt1171 = 1;
        this.myUsername = "";
        this.myPassword = "";
        this.cButtonHPos = -1;
        this.cButtonCPos = 0;
        server = Configuration.SERVER_ADDRESS;
        port = 29432;
        this.aBoolean1176 = false;
        this.reportAbuseInterfaceID = -1;
        this.aDoubleEndedQueue_1179 = new DoubleEndedQueue(169);
        this.anInt1184 = 128;
        this.invOverlayInterfaceID = -1;
        this.stream = Stream.method396(1, 9);
        this.aByte1194 = 5;
        this.menuActionName = new String[500];
        this.anIntArray1203 = new int[5];
        this.aBoolean1206 = true;
        this.sound = new int[50];
        this.anInt1210 = 2;
        this.anInt1211 = 78;
        this.promptInput = "";
        this.aByte1217 = 6;
        this.anInt1218 = -589;
        this.ModIcons = new Sprite[26];
        tabID = 3;
        this.inputTaken = false;
        this.songChanging = true;
        this.anIntArray1229 = new int[151];
        this.collisionMaps = new Class11[4];
        this.aBoolean1233 = false;
        this.anIntArray1240 = new int[100];
        this.soundType = new int[50];
        this.aBoolean1242 = false;
        this.soundDelay = new int[50];
        this.soundVolume = new int[50];
        this.aBoolean1252 = false;
        this.aBoolean1255 = false;
        this.messagePromptRaised = false;
        this.aString1266 = "";
        this.aString1267 = "";
        this.aByte1274 = -13;
        this.backDialogID = -1;
        this.aBoolean1277 = true;
        this.anInt1279 = 2;
        this.anIntArray1280 = new int[4000];
        this.anIntArray1281 = new int[4000];
        this.anInt1289 = -1;
    }

    static {
        currentScreenMode = client.ScreenMode.FIXED;
        currentGameWidth = 765;
        currentGameHeight = 503;
        screenAreaWidth = 516;
        screenAreaHeight = 338;
        cameraZoom = 600;
        showChatComponents = true;
        showTabComponents = true;
        changeChatArea = currentScreenMode != client.ScreenMode.FIXED;
        changeTabArea = currentScreenMode != client.ScreenMode.FIXED;
        anIntArray1019 = new int[1000];
        int i = 0;

        int k;
        for(k = 0; k < 1000; ++k) {
            int l = k + 1;
            int i1 = (int)((double)l + 300.0D * Math.pow(2.0D, (double)l / 7.0D));
            i += i1;
            anIntArray1019[k] = i / 4;
        }

        anIntArray1232 = new int[32];
        i = 2;

        for(k = 0; k < 32; ++k) {
            anIntArray1232[k] = i - 1;
            i += i;
        }

        step = 1;
        switching = false;
    }

    public static enum ScreenMode {
        FIXED(1, 765, 503, false, false),
        RESIZABLE(2, 902, 702, true, false),
        FULLSCREEN(3, (int)client.MAXIMUM_SCREEN_BOUNDS.getWidth(), (int)client.MAXIMUM_SCREEN_BOUNDS.getHeight(), false, true);

        private final int numericalValue;
        private final int width;
        private final int height;
        private final boolean resizable;
        private final boolean undecorated;

        private ScreenMode(int numericalValue, int width, int height, boolean resizable, boolean undecorated) {
            this.numericalValue = numericalValue;
            this.width = width;
            this.height = height;
            this.resizable = resizable;
            this.undecorated = undecorated;
        }

        public int getNumericalValue() {
            return this.numericalValue;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public boolean isResizable() {
            return this.resizable;
        }

        public boolean isUndecorated() {
            return this.undecorated;
        }
    }
}
