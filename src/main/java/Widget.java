import java.util.List;
import java.util.function.Consumer;

public class Widget {
    public int anInt208;
    public int scrollPosition;
    public int currentFrame;
    public int anInt263;
    public int anInt265;
    public boolean allowInvDraggingToOtherContainers;
    public boolean smallInvSprites;
    public boolean hideInvStackSizes;
    public boolean forceInvStackSizes;
    public boolean invAutoScrollHeight;
    public int invAutoScrollHeightOffset;
    public boolean updatesEveryInput;
    public int msgX, msgY;
    public boolean toggled = false;
    public boolean inputFieldSendPacket = true;
    public String defaultInputFieldText = "";
    public int invAutoScrollInterfaceId;
    public boolean displayAsterisks;
    public boolean isItemSearchComponent;
    public int itemSearchSelectedId, itemSearchSelectedSlot = -1;
    public static int selectedItemInterfaceId = -1;
    public int characterLimit;
    public static int currentInputFieldId;
    public String inputRegex = "";
    public boolean isInFocus;

    public String[] tooltips;

    public Consumer<String> inputFieldListener;
    public Consumer<Integer> buttonListener;
    public static final int SHOP_CONTAINER = 64016;
    public static final int CLOSE_BUTTON_SMALL = 27302;
    public static final int CLOSE_BUTTON_SMALL_HOVER = 27303;
    public boolean newButtonClicking;
    private int anInt229 = 891;
    private static Class12 aClass12_238;
    public static Widget[] interfaceCache;
    static FileArchive aFileArchive;
    public int id;
    public int parentID;
    public int type;
    public int atActionType;
    public int contentType;
    public int width;
    public int height;
    public byte opacity;
    public int mOverInterToTrigger;
    public int[] anIntArray245;
    public int[] anIntArray212;
    public int[][] valueIndexArray;
    public int scrollableContainerInterfaceId;
    public RSFont font;
    public List<String> stringContainer;
    public int stringContainerContainerExtraScroll = 0;
    public int scrollMax;
    public int anInt211;
    public int[] inventoryItemId;
    public int[] inventoryAmounts;
    public boolean isMouseoverTriggered;
    public int[] children;
    public int[] childX;
    public int[] childY;
    public boolean aBoolean251;
    public boolean deleteOnDrag2;
    public boolean aBoolean227;
    public String message;
    public String secondaryText;
    public boolean centerText;
    public boolean isInventoryInterface;
    public int textColor;
    public RSFont textDrawingAreas;
    public static RSFont[] fonts;
    public boolean usableItemInterface;
    public int secondaryColor;
    public int defaultHoverColor;
    public int secondaryHoverColor;
    public boolean textShadow;
    public boolean dragDeletes;
    public int invSpritePadX;
    public int invSpritePadY;
    public int[] spritesX;
    public int[] spritesY;
    public Sprite[] sprites;
    public String[] actions;
    public int anInt233;
    public int mediaID;
    public Sprite disabledSprite;
    public int anInt255;
    public int anInt256;
    public String selectedActionName;
    public String spellName;
    public int spellUsableOn;
    public Sprite enabledSprite;
    public int disabledAnimationId;
    public int enabledAnimationId;
    public String tooltip;
    public int modelZoom;
    public int modelRotation1;
    public int modelRotation2;
    public boolean inventoryhover;
    public boolean invAlwaysInfinity;
    private int anInt213 = 9;
    public static final int TYPE_CONTAINER = 0;
    public static final int TYPE_MODEL_LIST = 1;
    public static final int TYPE_INVENTORY = 2;
    public static final int TYPE_RECTANGLE = 3;
    public static final int TYPE_TEXT = 4;
    public static final int TYPE_SPRITE = 5;
    public static final int TYPE_MODEL = 6;
    public static final int TYPE_ITEM_LIST = 7;
    public static final int TYPE_HOVER = 9;
    public static final int TYPE_CONFIG = 10;
    public static final int TYPE_CONFIG_HOVER = 11;
    public static final int TYPE_SLIDER = 12;
    public static final int TYPE_DROPDOWN = 13;
    public static final int TYPE_KEYBINDS_DROPDOWN = 15;
    public static final int TYPE_XP_POSITION_DROPDOWN = 22;
    public static final int TYPE_ADJUSTABLE_CONFIG = 17;
    public static final int TYPE_BOX = 18;
    public static final int TYPE_MAP = 19;
    public static final int TYPE_STRING_CONTAINER = 20;
    public static final int TYPE_PROGRESS_BAR = 21;
    public static final int TYPE_TEXT_DRAW_FROM_LEFT = 22;
    public static final int TYPE_PROGRESS_BAR_2021 = 23;
    public static final int TYPE_DRAW_BOX = 24;
    public static final int TYPE_HORIZONTAL_STRING_CONTAINER = 25;

    static Class12 aClass12_264 = new Class12(false, 30);

    public void method204(int i, byte byte0, int j) {
        int k = this.inventoryItemId[i];
        this.inventoryItemId[i] = this.inventoryItemId[j];
        if(byte0 == 9) {
            boolean byte01 = false;
        } else {
            this.anInt229 = -76;
        }

        this.inventoryItemId[j] = k;
        k = this.inventoryAmounts[i];
        this.inventoryAmounts[i] = this.inventoryAmounts[j];
        this.inventoryAmounts[j] = k;
    }

    public static void unpack(FileArchive fileArchive, RSFont[] aclass30_sub2_sub1_sub4, byte byte0, FileArchive fileArchive_1) {
        fonts = aclass30_sub2_sub1_sub4;
        aClass12_238 = new Class12(false, 80000);
        Stream stream = new Stream(fileArchive.method571("data"), 891);
        int i = -1;
        int j = stream.readUnsignedShort();
        interfaceCache = new Widget[80000];

        while(stream.currentPosition < stream.buffer.length) {
                int k = stream.readUnsignedShort();
                if(k == 65535) {
                    i = stream.readUnsignedShort();
                    k = stream.readUnsignedShort();
                }
                Widget class9 = interfaceCache[k] = new Widget();
                class9.id = k;
                class9.parentID = i;
                class9.type = stream.readUnsignedByte();
                class9.atActionType = stream.readUnsignedByte();
                class9.contentType = stream.readUnsignedShort();
                class9.width = stream.readUnsignedShort();
                class9.height = stream.readUnsignedShort();
                class9.opacity = (byte)stream.readUnsignedByte();
                class9.mOverInterToTrigger = stream.readUnsignedByte();
                if(class9.mOverInterToTrigger != 0) {
                    class9.mOverInterToTrigger = (class9.mOverInterToTrigger - 1 << 8) + stream.readUnsignedByte();
                } else {
                    class9.mOverInterToTrigger = -1;
                }

                int l = stream.readUnsignedByte();
                int j1;
                if(l > 0) {
                    class9.anIntArray245 = new int[l];
                    class9.anIntArray212 = new int[l];

                    for(j1 = 0; j1 < l; ++j1) {
                        class9.anIntArray245[j1] = stream.readUnsignedByte();
                        class9.anIntArray212[j1] = stream.readUnsignedShort();
                    }
                }

                j1 = stream.readUnsignedByte();
                int i3;
                int k4;
                if(j1 > 0) {
                    class9.valueIndexArray = new int[j1][];

                    for(i3 = 0; i3 < j1; ++i3) {
                        k4 = stream.readUnsignedShort();
                        class9.valueIndexArray[i3] = new int[k4];

                        for(int s1 = 0; s1 < k4; ++s1) {
                            class9.valueIndexArray[i3][s1] = stream.readUnsignedShort();
                        }
                    }
                }

                if(class9.type == 0) {
                    class9.scrollMax = stream.readUnsignedShort();
                    class9.isMouseoverTriggered = stream.readUnsignedByte() == 1;
                    i3 = stream.readUnsignedShort();
                    class9.children = new int[i3];
                    class9.childX = new int[i3];
                    class9.childY = new int[i3];

                    for(k4 = 0; k4 < i3; ++k4) {
                        class9.children[k4] = stream.readUnsignedShort();
                        class9.childX[k4] = stream.readSignedWord();
                        class9.childY[k4] = stream.readSignedWord();
                    }
                }

                if(class9.type == 1) {
                    class9.anInt211 = stream.readUnsignedShort();
                    class9.aBoolean251 = stream.readUnsignedByte() == 1;
                }

                if(class9.type == 2) {
                    class9.inventoryItemId = new int[class9.width * class9.height];
                    class9.inventoryAmounts = new int[class9.width * class9.height];
                    class9.deleteOnDrag2 = stream.readUnsignedByte() == 1;
                    class9.isInventoryInterface = stream.readUnsignedByte() == 1;
                    class9.usableItemInterface = stream.readUnsignedByte() == 1;
                    class9.dragDeletes = stream.readUnsignedByte() == 1;
                    class9.invSpritePadX = stream.readUnsignedByte();
                    class9.invSpritePadY = stream.readUnsignedByte();
                    class9.spritesX = new int[20];
                    class9.spritesY = new int[20];
                    class9.sprites = new Sprite[20];

                    for(i3 = 0; i3 < 20; ++i3) {
                        k4 = stream.readUnsignedByte();
                        if(k4 == 1) {
                            class9.spritesX[i3] = stream.readSignedWord();
                            class9.spritesY[i3] = stream.readSignedWord();
                            String var15 = stream.readString();
                            if(fileArchive_1 != null && var15.length() > 0) {
                                int i5 = var15.lastIndexOf(",");
                                class9.sprites[i3] = method207(Integer.parseInt(var15.substring(i5 + 1)), false, fileArchive_1, var15.substring(0, i5));
                            }
                        }
                    }

                    class9.actions = new String[6];

                    for(i3 = 0; i3 < 5; ++i3) {
                        class9.actions[i3] = stream.readString();
                        if(class9.actions[i3].length() == 0) {
                            class9.actions[i3] = null;
                        }

                        if(class9.parentID == 3822) {
                            class9.actions[4] = "Sell All";
                        }

                        if(class9.parentID == 3824) {
                            class9.actions[4] = "Buy X";
                        }
                    }
                }

                if(class9.type == 3) {
                    class9.aBoolean227 = stream.readUnsignedByte() == 1;
                }

                if(class9.type == 4 || class9.type == 1) {
                    class9.centerText = stream.readUnsignedByte() == 1;
                    i3 = stream.readUnsignedByte();
                    if(aclass30_sub2_sub1_sub4 != null) {
                        class9.textDrawingAreas = aclass30_sub2_sub1_sub4[i3];
                    }

                    class9.textShadow = stream.readUnsignedByte() == 1;
                }

                if(class9.type == 4) {
                    class9.message = stream.readString();
                    class9.secondaryText = stream.readString();
                }

                if(class9.type == 1 || class9.type == 3 || class9.type == 4) {
                    class9.textColor = stream.readDWord();
                }

                if(class9.type == 3 || class9.type == 4) {
                    class9.secondaryColor = stream.readDWord();
                    class9.defaultHoverColor = stream.readDWord();
                    class9.secondaryHoverColor = stream.readDWord();
                }

                if(class9.type == 5) {
                    String var16 = stream.readString();
                    if(fileArchive_1 != null && var16.length() > 0) {
                        k4 = var16.lastIndexOf(",");
                        class9.disabledSprite = method207(Integer.parseInt(var16.substring(k4 + 1)), false, fileArchive_1, var16.substring(0, k4));
                    }

                    var16 = stream.readString();
                    if(fileArchive_1 != null && var16.length() > 0) {
                        k4 = var16.lastIndexOf(",");
                        class9.enabledSprite = method207(Integer.parseInt(var16.substring(k4 + 1)), false, fileArchive_1, var16.substring(0, k4));
                    }
                }

                if(class9.type == 6) {
                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) {
                        class9.anInt233 = 1;
                        class9.mediaID = (i3 - 1 << 8) + stream.readUnsignedByte();
                    }

                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) {
                        class9.anInt255 = 1;
                        class9.anInt256 = (i3 - 1 << 8) + stream.readUnsignedByte();
                    }

                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) {
                        class9.disabledAnimationId = (i3 - 1 << 8) + stream.readUnsignedByte();
                    } else {
                        class9.disabledAnimationId = -1;
                    }

                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) {
                        class9.enabledAnimationId = (i3 - 1 << 8) + stream.readUnsignedByte();
                    } else {
                        class9.enabledAnimationId = -1;
                    }

                    class9.modelZoom = stream.readUnsignedShort();
                    class9.modelRotation1 = stream.readUnsignedShort();
                    class9.modelRotation2 = stream.readUnsignedShort();
                }

                if(class9.type == 7) {
                    class9.inventoryItemId = new int[class9.width * class9.height];
                    class9.inventoryAmounts = new int[class9.width * class9.height];
                    class9.centerText = stream.readUnsignedByte() == 1;
                    i3 = stream.readUnsignedByte();
                    if(aclass30_sub2_sub1_sub4 != null)
                        class9.textDrawingAreas = aclass30_sub2_sub1_sub4[i3];
                    class9.textShadow = stream.readUnsignedByte() == 1;
                    class9.textColor = stream.readDWord();
                    class9.invSpritePadX = stream.readSignedWord();
                    class9.invSpritePadY = stream.readSignedWord();
                    class9.isInventoryInterface = stream.readUnsignedByte() == 1;
                    class9.actions = new String[6];
                    for(k4 = 0; k4 < 5; ++k4) {
                        class9.actions[k4] = stream.readString();
                        if(class9.actions[k4].length() == 0) {
                            class9.actions[k4] = null;
                        }
                    }
                }

                if(class9.atActionType == 2 || class9.type == 2) {
                    class9.selectedActionName = stream.readString();
                    class9.spellName = stream.readString();
                    class9.spellUsableOn = stream.readUnsignedShort();
                }

                if(class9.type == 8)
                    class9.message = stream.readString();

            if(class9.atActionType == 1 || class9.atActionType == 4 || class9.atActionType == 5
                    || class9.atActionType == 6) {

                class9.tooltip = stream.readString();
                if (class9.tooltip.length() == 0) {
                    if (class9.atActionType == 1)
                        class9.tooltip = "Ok";
                    if (class9.atActionType == 4)
                        class9.tooltip = "Select";
                    if (class9.atActionType == 5)
                        class9.tooltip = "Select";
                    if (class9.atActionType == 6)
                        class9.tooltip = "Continue";
                }
            }
        }
        aFileArchive = fileArchive;
        clanChatTab(aclass30_sub2_sub1_sub4);
        clanChatSetup(aclass30_sub2_sub1_sub4);
        slayerInterface.Unpack(aclass30_sub2_sub1_sub4);
        slayerInterface.Unpack2(aclass30_sub2_sub1_sub4);
        configureLunar(aclass30_sub2_sub1_sub4);
        constructLunar();
        slayerInterface.Unpack3(aclass30_sub2_sub1_sub4);
        shopWidget(aclass30_sub2_sub1_sub4);
        skilllevel(aclass30_sub2_sub1_sub4);
        skillTab602(aclass30_sub2_sub1_sub4);
        SpawnContainer.get().load();
        aClass12_238 = null;
    }

    public static void shopWidget(RSFont[] tda) {
        Widget widget = addInterface('\ufa00');
        setChildren(4, widget);
        addSprite('\ufa01', 1, "Interfaces/Shop/IMAGE");
        addHoverButton('\ufa02', "Interfaces/Shop/IMAGE", 2, 21, 21, "Close Window", 201, '\ufa02', 5);
        addText('\ufa03', "Tony\'s store", tda, 2, 16753920, false, true);
        setBounds('\ufa01', 10, 10, 0, widget);
        setBounds('\ufa0f', 20, 45, 1, widget);
        setBounds('\ufa02', 485, 20, 2, widget);
        setBounds('\ufa03', 200, 20, 3, widget);
        Widget scroll = addInterface('\ufa0f');
        setChildren(1, scroll);
        scroll.height = 252;
        scroll.width = 465;
        scroll.scrollMax = 800;
        addToItemGroup('\ufa10', 10, 40, 14, 14, true, "Value", "Buy 1", "Buy 5", "Buy 10", "Buy X", (String)null);
        setBounds('\ufa10', 8, 8, 0, scroll);
        interfaceCache['\ufa10'].invAlwaysInfinity = false;
    }
    public static Widget addFullScreenInterface(int id) {
        Widget rsi = interfaceCache[id] = new Widget();
        rsi.id = id;
        rsi.parentID = id;
        rsi.width = 765;
        rsi.height = 503;
        return rsi;
    }
    public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height,
                                     boolean asterisks, boolean updatesEveryInput, String regex, Consumer<String> inputFieldListener, boolean sendPacket) {
        addInputField(identity, characterLimit, color, text, width, height, asterisks, updatesEveryInput, regex);
        Widget rsInterface = get(identity);
        rsInterface.inputFieldListener = inputFieldListener;
        rsInterface.inputFieldSendPacket = sendPacket;
    }

    public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height,
                                     boolean asterisks, boolean updatesEveryInput, String regex) {
        Widget field = addFullScreenInterface(identity);
        field.id = identity;
        field.type = 16;
        field.atActionType = 8;
        field.message = text;
        field.width = width;
        field.height = height;
        field.characterLimit = characterLimit;
        field.textColor = color;
        field.displayAsterisks = asterisks;
        field.tooltips = new String[] { "Clear", "Edit" };
        field.defaultInputFieldText = text;
        field.updatesEveryInput = updatesEveryInput;
        field.inputRegex = regex;
    }

    public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height,
                                     boolean asterisks, boolean updatesEveryInput) {
        Widget field = addFullScreenInterface(identity);
        field.id = identity;
        field.type = 16;
        field.atActionType = 8;
        field.message = text;
        field.width = width;
        field.height = height;
        field.characterLimit = characterLimit;
        field.textColor = color;
        field.displayAsterisks = asterisks;
        field.defaultInputFieldText = text;
        field.tooltips = new String[] { "Clear", "Edit" };
        field.updatesEveryInput = updatesEveryInput;
    }

    public static void addInputField(int identity, int characterLimit, int color, String text, int width, int height,
                                     boolean asterisks) {
        Widget field = addFullScreenInterface(identity);
        field.id = identity;
        field.type = 16;
        field.atActionType = 8;
        field.message = text;
        field.width = width;
        field.height = height;
        field.characterLimit = characterLimit;
        field.textColor = color;
        field.displayAsterisks = asterisks;
        field.defaultInputFieldText = text;
        field.tooltips = new String[] { "Clear", "Edit" };
    }

    public static Widget addInterfaceContainer(int interfaceId, int width, int height, int scrollMax) {
        Widget container = addInterface(interfaceId);
        container.width = width;
        container.height = height;
        container.scrollMax = scrollMax;
        return container;
    }

    public static void addItemContainerAutoScrollable(int childId, int width, int height, int invSpritePadX, int invSpritePadY, boolean addPlaceholderItems, int invAutoScrollInterfaceId, String...options) {
        Widget inter = addItemContainer(childId, width, height, invSpritePadX, invSpritePadY, addPlaceholderItems, false, options);
        inter.invAutoScrollHeight = true;
        inter.invAutoScrollInterfaceId = invAutoScrollInterfaceId;
    }

    public static Widget addInventoryContainer(int childId, int width, int height, int invSpritePadX, int invSpritePadY, boolean addPlaceholderItems, String...options) {
        Widget inter = addItemContainer(childId, width, height, invSpritePadX, invSpritePadY, addPlaceholderItems, false, options);
        inter.deleteOnDrag2 = true;
        return inter;
    }

    public static Widget addInventoryContainer(int childId, int width, int height, int invSpritePadX, int invSpritePadY, boolean addPlaceholderItems, boolean smallInvSprites, String...options) {
        Widget inter = addItemContainer(childId, width, height, invSpritePadX, invSpritePadY, addPlaceholderItems, smallInvSprites, options);
        inter.deleteOnDrag2 = true;
        return inter;
    }

    public static Widget addItemContainer(int childId, int width, int height, int invSpritePadX,
                                               int invSpritePadY, boolean addPlaceholderItems, String...options) {
        Widget inter = addItemContainer(childId, width, height, invSpritePadX, invSpritePadY, addPlaceholderItems, false, options);
        return inter;
    }

    public static Widget addItemContainer(int childId, int width, int height, int invSpritePadX,
                                               int invSpritePadY, boolean addPlaceholderItems, boolean smallInvSprites, String...options) {
        Widget rsi = addInterface(childId);
        rsi.smallInvSprites = smallInvSprites;
        rsi.hideInvStackSizes = false;
        rsi.actions = new String[10];
        rsi.spritesX = new int[width * height];
        rsi.inventoryItemId = new int[width * height];
        rsi.inventoryAmounts = new int[width * height];
        rsi.spritesY = new int[width * height];
        rsi.height = height;
        rsi.width = width;
        rsi.usableItemInterface = false;
        rsi.isInventoryInterface = false;
        rsi.type = 2;
        rsi.id = childId;
        rsi.invSpritePadX = invSpritePadX;
        rsi.invSpritePadY = invSpritePadY;


        System.arraycopy(options, 0, rsi.actions, 0, options.length);

        if (addPlaceholderItems) {
            for (int index = 0; index < rsi.inventoryItemId.length; index++) {
                rsi.inventoryItemId[index] = 4152 + (index * 2);
                rsi.inventoryAmounts[index] = index + 1;
            }
        }
        return rsi;
    }
    public static Widget get(int interfaceId) {

        return interfaceCache[interfaceId];
    }
    public static void setBounds(int ID, int X, int Y, int frame, Widget RSinterface) {
        RSinterface.children[frame] = ID;
        RSinterface.childX[frame] = X;
        RSinterface.childY[frame] = Y;
    }

    public static void addToItemGroup(int id, int w, int h, int x, int y, boolean actions, String action1, String action2, String action3, String action4, String action5, String action6) {
        Widget rsi = addInterface(id);
        rsi.width = w;
        rsi.height = h;
        rsi.inventoryItemId = new int[w * h];
        rsi.inventoryAmounts = new int[w * h];
        rsi.usableItemInterface = false;
        rsi.isInventoryInterface = false;
        rsi.isMouseoverTriggered = false;
        rsi.invSpritePadX = x;
        rsi.invSpritePadY = y;
        rsi.spritesX = new int[20];
        rsi.spritesY = new int[20];
        rsi.sprites = new Sprite[20];
        rsi.actions = new String[6];
        if(actions) {
            rsi.actions[0] = action1;
            rsi.actions[1] = action2;
            rsi.actions[2] = action3;
            rsi.actions[3] = action4;
            rsi.actions[4] = action5;
            rsi.actions[5] = action6;
        }

        rsi.type = 2;
    }

    public static Widget addTabInterface(int id) {
        Widget tab = interfaceCache[id] = new Widget();
        tab.id = id;
        tab.parentID = id;
        tab.type = 0;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.width = 512;
        tab.height = 700;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        return tab;
    }

    public static Widget addInterface(int id) {
        Widget widget = interfaceCache[id] = new Widget();
        widget.id = id;
        widget.parentID = id;
        widget.width = 512;
        widget.height = 334;
        return widget;
    }

    public static void addTextButton(int i, String s, String tooltip, int k, boolean l, boolean m, RSFont[] RSFont, int j, int w) {
        Widget rsinterface = addInterface(i);
        rsinterface.parentID = i;
        rsinterface.id = i;
        rsinterface.type = 4;
        rsinterface.atActionType = 1;
        rsinterface.width = w;
        rsinterface.height = 16;
        rsinterface.contentType = 0;
        rsinterface.opacity = 31;
        rsinterface.mOverInterToTrigger = -1;
        rsinterface.centerText = l;
        rsinterface.textShadow = m;
        rsinterface.textDrawingAreas = RSFont[j];
        rsinterface.message = s;
        rsinterface.secondaryText = "";
        rsinterface.secondaryColor = 16750623;
        rsinterface.textColor = 16750623;
        rsinterface.tooltip = tooltip;
    }

    public static void setChildren(int total, Widget i) {
        i.children = new int[total];
        i.childX = new int[total];
        i.childY = new int[total];
    }

    public static void addText(int id, String text, RSFont[] wid, int idx, int color) {
        Widget Tab = addTabInterface(id);
        Tab.id = id;
        Tab.parentID = id;
        Tab.type = 4;
        Tab.atActionType = 0;
        Tab.width = 174;
        Tab.height = 11;
        Tab.contentType = 0;
        Tab.opacity = 0;
        Tab.mOverInterToTrigger = -1;
        Tab.centerText = false;
        Tab.textShadow = true;
        Tab.textDrawingAreas = wid[idx];
        Tab.message = text;
        Tab.secondaryText = "";
        Tab.textColor = color;
        Tab.secondaryColor = 0;
        Tab.defaultHoverColor = 0;
        Tab.secondaryHoverColor = 0;
    }

    public static void addText(int id, String text, RSFont[] tda, int idx, int color, boolean center, boolean shadow) {
        Widget tab = addTabInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.type = 4;
        tab.atActionType = 0;
        tab.width = 0;
        tab.height = 11;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        tab.centerText = center;
        tab.textShadow = shadow;
        tab.textDrawingAreas = tda[idx];
        tab.message = text;
        tab.secondaryText = "";
        tab.textColor = color;
        tab.secondaryColor = 0;
        tab.defaultHoverColor = 0;
    }
    public static void addText(int i, String s, int k, boolean l, boolean m, int a, RSFont[] RSFont, int j) {
        Widget Widget = addInterface(i);
        Widget.parentID = i;
        Widget.id = i;
        Widget.type = 4;
        Widget.atActionType = 0;
        Widget.width = 0;
        Widget.height = 0;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.mOverInterToTrigger = a;
        Widget.centerText = l;
        Widget.textShadow = m;
        Widget.textDrawingAreas = RSFont[j];
        Widget.message = s;
        Widget.secondaryText = "";
        Widget.textColor = k;
    }

    public static void getext(int id, String text, RSFont[] tda, int idx, int color, boolean center, boolean shadow, int width, int height) {
        Widget tab = addTabInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.type = 4;
        tab.atActionType = 0;
        tab.width = width;
        tab.height = height;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        tab.centerText = center;
        tab.textShadow = shadow;
        tab.textDrawingAreas = tda[idx];
        tab.message = text;
        tab.secondaryText = "";
        tab.textColor = color;
        tab.secondaryColor = 0;
        tab.defaultHoverColor = 0;
    }

    public static void addHoverButton(int i, String imageName, int j, int width, int height, String text, int contentType, int hoverOver, int aT) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = aT;
        tab.contentType = contentType;
        tab.opacity = 0;
        tab.msgX = tab.width / 2;
        tab.msgY = (tab.height / 2) + 4;
        tab.toggled = false;
        tab.mOverInterToTrigger = hoverOver;
        tab.disabledSprite = imageLoader(j, imageName);
        tab.enabledSprite = imageLoader(j, imageName);
        tab.width = width;
        tab.height = height;
        tab.tooltip = text;
    }

    public static void addHoverImage(int i, int j, int k, String name) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.msgX = tab.width / 2;
        tab.msgY = (tab.height / 2) + 4;
        tab.width = 512;
        tab.height = 334;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = imageLoader(j, name);
        tab.enabledSprite = imageLoader(k, name);
    }

    public static void addHoveredButton(int i, String imageName, int j, int w, int h, int IMAGEID) {
        Widget tab = addTabInterface(i);
        tab.parentID = i;
        tab.id = i;
        tab.type = 0;
        tab.atActionType = 0;
        tab.width = w;
        tab.height = h;
        tab.isMouseoverTriggered = true;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        tab.scrollMax = 0;
        addHoverImage(IMAGEID, j, j, imageName);
        tab.totalChildren(1);
        tab.child(0, IMAGEID, 0, 0);
    }

    public void child(int frame, int id, int x, int y) {
        this.children[frame] = id;
        this.childX[frame] = x;
        this.childY[frame] = y;
    }

    public void totalChildren(int id, int x, int y) {
        this.children = new int[id];
        this.childX = new int[x];
        this.childY = new int[y];
    }

    protected static Sprite imageLoader(int i, String s) {
        long l = (TextClass.method585((byte)1, s) << 8) + (long)i;
        Sprite sprite = (Sprite)aClass12_238.method222(l);
        if(sprite != null) {
            return sprite;
        } else {
            try {
                sprite = new Sprite(s + " " + i);
                aClass12_238.method223(sprite, l, (byte)2);
                return sprite;
            } catch (Exception var6) {
                return null;
            }
        }
    }

    public static void addButton(int i, int j, String name, int W, int H, String S, int AT) {
        Widget Widget = addInterface(i);
        Widget.id = i;
        Widget.parentID = i;
        Widget.type = 5;
        Widget.atActionType = AT;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.mOverInterToTrigger = 52;
        Widget.disabledSprite = imageLoader(j, name);
        Widget.enabledSprite = imageLoader(j, name);
        Widget.width = W;
        Widget.height = H;
        Widget.tooltip = S;
    }

    public static void addButton(int id, int sid, String spriteName, String tooltip) {
        Widget tab = interfaceCache[id] = new Widget();
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 1;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = imageLoader(sid, spriteName);
        tab.enabledSprite = imageLoader(sid, spriteName);
        tab.width = tab.disabledSprite.myWidth;
        tab.height = tab.enabledSprite.myHeight;
        tab.tooltip = tooltip;
    }
    public static Widget addSprite(int i, Sprite sprite) {
        Widget rsinterface = interfaceCache[i] = new Widget();
        rsinterface.id = i;
        rsinterface.parentID = i;
        rsinterface.type = 5;
        rsinterface.atActionType = 0;
        rsinterface.contentType = 0;
        rsinterface.width = sprite.myWidth;
        rsinterface.height = sprite.myHeight;
        rsinterface.opacity = 0;
        rsinterface.mOverInterToTrigger = 52;
        rsinterface.disabledSprite = sprite;
        rsinterface.enabledSprite = sprite;
        return rsinterface;
    }

    public static void addSprite(int id, int spriteId, String spriteName) {
        Widget tab = interfaceCache[id] = new Widget();
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = imageLoader(spriteId, spriteName);
        tab.enabledSprite = imageLoader(spriteId, spriteName);
        tab.width = 512;
        tab.height = 334;
    }

    public void totalChildren(int t) {
        this.children = new int[t];
        this.childX = new int[t];
        this.childY = new int[t];
    }

    public static void clanChatSetup(RSFont[] tda) {
        Widget rsi = addInterface(18300);
        rsi.totalChildren(33);
        byte count = 0;
        addSprite(18301, 1, "/Interfaces/Clan Chat/sprite");
        int var15 = count + 1;
        rsi.child(count, 18301, 14, 17);
        addButton(18302, 0, "/Interfaces/Clan Chat/close", "Close");
        interfaceCache[18302].atActionType = 3;
        rsi.child(var15++, 18302, 475, 26);
        addText(18303, "Clan Setup", tda, 2, 16750623, true, true);
        rsi.child(var15++, 18303, 256, 26);
        String[] titles = new String[]{"Clan name:", "Who can enter chat?", "Who can talk on chat?", "Who can kick on chat?", "Who can ban on chat?"};
        String[] defaults = new String[]{"Chat Disabled", "Anyone", "Anyone", "Anyone", "Anyone"};
        String[] whoCan = new String[]{"Anyone", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General", "Only Me"};
        int id = 0;
        int y = 18304;

        for(int list = 50; id < titles.length; list += 40) {
            addButton(y, 2, "/Interfaces/Clan Chat/sprite", "");
            interfaceCache[y].atActionType = 0;
            if(id > 0) {
                interfaceCache[y].actions = whoCan;
            } else {
                interfaceCache[y].actions = new String[]{"Change title", "Delete clan"};
            }

            addText(y + 1, titles[id], tda, 0, 16750623, true, true);
            addText(y + 2, defaults[id], tda, 1, 16777215, true, true);
            rsi.child(var15++, y, 25, list);
            rsi.child(var15++, y + 1, 100, list + 4);
            rsi.child(var15++, y + 2, 100, list + 17);
            ++id;
            y += 3;
        }

        addSprite(18319, 5, "/Interfaces/Clan Chat/sprite");
        rsi.child(var15++, 18319, 197, 70);
        short var16 = 18320;
        byte var17 = 74;
        addText(var16, "Ranked Members", tda, 2, 16750623, false, true);
        int var20 = var15++;
        id = var16 + 1;
        rsi.child(var20, var16, 202, var17);
        addText(id, "Banned Members", tda, 2, 16750623, false, true);
        rsi.child(var15++, id++, 339, var17);
        Widget var18 = addInterface(id++);
        byte lines = 100;
        var18.totalChildren(lines);
        String[] ranks = new String[]{"Demote", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General", "Owner"};
        var18.childY[0] = 2;

        int clanSetup;
        for(clanSetup = id; clanSetup < id + lines; ++clanSetup) {
            addText(clanSetup, "", tda, 1, 16777215, false, true);
            interfaceCache[clanSetup].actions = ranks;
            var18.children[clanSetup - id] = clanSetup;
            var18.childX[clanSetup - id] = 2;
            var18.childY[clanSetup - id] = clanSetup - id > 0?var18.childY[clanSetup - id - 1] + 14:0;
        }

        id += lines;
        var18.width = 119;
        var18.height = 210;
        var18.scrollMax = lines * 14 + 2;
        rsi.child(var15++, var18.id, 199, 92);
        var18 = addInterface(id++);
        var18.totalChildren(lines);
        var18.childY[0] = 2;

        for(clanSetup = id; clanSetup < id + lines; ++clanSetup) {
            addText(clanSetup, "", tda, 1, 16777215, false, true);
            interfaceCache[clanSetup].actions = new String[]{"Unban"};
            var18.children[clanSetup - id] = clanSetup;
            var18.childX[clanSetup - id] = 0;
            var18.childY[clanSetup - id] = clanSetup - id > 0?var18.childY[clanSetup - id - 1] + 14:0;
        }

        id += lines;
        var18.width = 119;
        var18.height = 210;
        var18.scrollMax = lines * 14 + 2;
        rsi.child(var15++, var18.id, 339, 92);
        var17 = 47;
        addText(id, "You can manage both ranked and banned members here.", tda, 0, 16750623, true, true);
        rsi.child(var15++, id++, 337, var17);
        addText(id, "Right click on a name to edit the member.", tda, 0, 16750623, true, true);
        rsi.child(var15++, id++, 337, var17 + 11);
        var17 = 75;
        addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add ranked member");
        interfaceCache[id].atActionType = 5;
        rsi.child(var15++, id++, 319, var17);
        addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add banned member");
        interfaceCache[id].atActionType = 5;
        rsi.child(var15++, id++, 459, var17);
        addHoverButton(id, "Interfaces/Clan Chat/sprite", 9, 150, 27, "Allow Teleports", 201, id, 5);
        rsi.child(var15++, id++, 25, 248);
        addText(id, "Allow Teleports :", tda, 1, 16777215, true, true);
        rsi.child(var15++, id++, 101, 254);
        addText(id, "@red@No", tda, 1, 16711680, true, true);
        rsi.child(var15++, id++, 157, 255);
        addHoverButton(id, "Interfaces/Clan Chat/sprite", 12, 150, 27, "Copy-kit", 201, id, 5);
        rsi.child(var15++, id++, 25, 278);
        addText(id, "Allow Copy Kit :", tda, 1, 16777215, true, true);
        rsi.child(var15++, id++, 101, 284);
        addText(id, "No", tda, 1, 16711680, true, true);
        rsi.child(var15++, id++, 157, 285);
        int[] var19 = new int[]{18302, 18304, 18307, 18310, 18313, 18316, 18526, 18527};
        String[] names = new String[]{"close", "sprite", "sprite", "sprite", "sprite", "sprite", "plus", "plus"};
        int[] ids = new int[]{1, 3, 3, 3, 3, 3, 1, 1};

        for(int index = 0; index < var19.length; ++index) {
            rsi = interfaceCache[var19[index]];
            rsi.disabledSprite = imageLoader(ids[index], "/Interfaces/Clan Chat/" + names[index]);
        }

    }

    public static void clanChatTab(RSFont[] tda) {
        Widget tab = addTabInterface(18128);
        addHoverButton(18129, "/Clan Chat/SPRITE", 6, 72, 32, "Join Chat", 550, 18130, 1);
        addHoveredButton(18130, "/Clan Chat/SPRITE", 7, 72, 32, 18131);
        addHoverButton(18132, "/Clan Chat/SPRITE", 6, 72, 32, "Leave Chat", -1, 18133, 5);
        addHoveredButton(18133, "/Clan Chat/SPRITE", 7, 72, 32, 18134);
        addButton(18250, 0, "/Clan Chat/Lootshare", "Toggle lootshare");
        addText(18135, "Join Chat", tda, 0, 16751360, true, true);
        addText(18136, "Leave Chat", tda, 0, 16751360, true, true);
        addSprite(18137, 37, "/Clan Chat/SPRITE");
        addText(18138, "Clan Chat", tda, 1, 16751360, true, true);
        addText(18139, "Talking in: Not in chat", tda, 0, 16751360, false, true);
        addText(18140, "Owner: None", tda, 0, 16751360, false, true);
        tab.totalChildren(14);
        tab.child(0, 16126, 0, 221);
        tab.child(1, 16126, 0, 59);
        tab.child(2, 18137, 0, 62);
        tab.child(3, 18143, 0, 62);
        tab.child(4, 18129, 15, 226);
        tab.child(5, 18130, 15, 226);
        tab.child(6, 18132, 103, 226);
        tab.child(7, 18133, 103, 226);
        tab.child(8, 18135, 51, 237);
        tab.child(9, 18136, 139, 237);
        tab.child(10, 18138, 95, 1);
        tab.child(11, 18139, 10, 23);
        tab.child(12, 18140, 25, 38);
        tab.child(13, 18250, 145, 15);
        Widget list = addTabInterface(18143);
        list.totalChildren(100);

        int id;
        for(id = 18144; id <= 18244; ++id) {
            addText(id, "", tda, 0, 16777215, false, true);
        }

        id = 18144;

        for(int i = 0; id <= 18243 && i <= 99; ++i) {
            list.children[i] = id;
            list.childX[i] = 5;
            int id2 = 18144;

            for(int i2 = 1; id2 <= 18243 && i2 <= 99; ++i2) {
                list.childY[0] = 2;
                list.childY[i2] = list.childY[i2 - 1] + 14;
                ++id2;
            }

            ++id;
        }

        list.height = 158;
        list.width = 174;
        list.scrollMax = 1405;
    }
    public static void addSkillText(int id, boolean max, int skill) {
        Widget text = addInterface(id);
        text.id = id;
        text.parentID = id;
        text.type = 4;
        text.atActionType = 0;
        text.width = 15;
        text.height = 12;
        text.textDrawingAreas = fonts[0];
        text.textShadow = true;
        text.centerText = true;
        text.secondaryColor = 16776960;
        if (!max) {
            text.valueIndexArray = new int[1][];
            text.valueIndexArray[0] = new int[3];
            text.valueIndexArray[0][0] = 1;
            text.valueIndexArray[0][1] = skill;
            text.valueIndexArray[0][2] = 0;
        } else {
            text.valueIndexArray = new int[2][];
            text.valueIndexArray[0] = new int[3];
            text.valueIndexArray[0][0] = 1;
            text.valueIndexArray[0][1] = skill;
            text.valueIndexArray[0][2] = 0;
            text.valueIndexArray[1] = new int[1];
            text.valueIndexArray[1][0] = 0;
        }
        text.message = "%1";
    }
    public static void skillTab602(RSFont[] RSFont) {
        Widget skill = addInterface(3917);
        String[] spriteNames = {
                "Attack",
                "HP",
                "Mine",
                "Strength",
                "Agility",
                "Smith",
                "Defence",
                "Herblore",
                "Fish",
                "Range",
                "Thief", "Cook", "Prayer", "Craft", "Fire", "Mage", "Fletch", "Wood", "Rune", "Slay", "Farm", "Construction", "Hunter", "Summon", "Dungeon" };
        int[] buttons = { 8654, 8655, 8656, 8657, 8658, 8659, 8660, 8861, 8662, 8663, 8664, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928, 28177, 28178, 36179, 36180 };
        int[] hovers = { 4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058, 4094, 4130, 4064, 4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917, 36173, 36174, 36175, 36176 };
        addText(36001, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36002, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36003, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36004, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36005, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36006, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36007, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        addText(36008, "99", 0xFFFF00, false, true, -1, RSFont, 0);
        int[][] text = {{4004, 4005}, {4016, 4017}, {4028, 4029},
                {4006, 4007}, {4018, 4019}, {4030, 4031}, {4008, 4009},
                {4020, 4021}, {4032, 4033}, {4010, 4011}, {4022, 4023},
                {4034, 4035}, {4012, 4013}, {4024, 4025}, {4036, 4037},
                {4014, 4015}, {4026, 4027}, {4038, 4039}, {4152, 4153},
                {12166, 12167}, {13926, 13927}, {36001, 36002},
                {36003, 36004}, {36005, 36006}, {36007, 36008}};

        int[] icons = { 3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973,
                3974, 3975, 3976, 3977, 3978, 3979, 3980, 3981, 3982, 4151,
                12165, 13925, 18181, 18182, 18183, 18184 };

        int[][] buttonCoords = { { 4, 4 }, { 66, 4 }, { 128, 4 }, { 4, 32 },
                { 66, 32 }, { 128, 32 }, { 4, 60 }, { 66, 60 }, { 128, 60 },
                { 4, 88 }, { 66, 88 }, { 128, 88 }, { 4, 116 }, { 66, 116 },
                { 128, 116 }, { 4, 144 }, { 66, 144 }, { 128, 144 },
                { 4, 172 }, { 66, 172 }, { 128, 172 }, { 4, 200 }, { 66, 200 },
                { 128, 200 }, { 4, 229 } };
        int[][] iconCoords = { { 6, 6 }, { 69, 7 }, { 131, 6 }, { 9, 34 },
                { 68, 33 }, { 131, 36 }, { 9, 64 }, { 67, 63 }, { 131, 61 },
                { 7, 91 }, { 68, 94 }, { 133, 90 }, { 6, 118 }, { 70, 120 },
                { 130, 118 }, { 6, 147 }, { 69, 146 }, { 132, 146 },
                { 6, 173 }, { 69, 173 }, { 130, 174 }, { 6, 202 }, { 69, 201 },
                { 131, 202 }, { 6, 230 } };
        int[][] textCoords = { { 31, 7, 44, 18 }, { 93, 7, 106, 18 },
                { 155, 7, 168, 18 }, { 31, 35, 44, 46 }, { 93, 35, 106, 46 },
                { 155, 35, 168, 46 }, { 31, 63, 44, 74 }, { 93, 63, 106, 74 },
                { 155, 63, 168, 74 }, { 31, 91, 44, 102 },
                { 93, 91, 106, 102 }, { 155, 91, 168, 102 },
                { 31, 119, 44, 130 }, { 93, 119, 106, 130 },
                { 155, 119, 168, 130 }, { 31, 149, 44, 158 },
                { 93, 147, 106, 158 }, { 155, 147, 168, 158 },
                { 31, 175, 44, 186 }, { 93, 175, 106, 186 },
                { 155, 175, 168, 186 }, { 31, 203, 44, 214 },
                { 93, 203, 106, 214 }, { 155, 203, 168, 214 },
                { 31, 231, 44, 242 } };
        int[][] newText = { { 18165, 18166, 18167, 18168 },
                { 18169, 18170, 18171, 18172 } };
        for (int i = 0; i < hovers.length; i++) {
            createSkillHover(hovers[i], 505 + i);
            addSkillButton(buttons[i]);
            addImage(icons[i], spriteNames[i]);
        }
        for (int i = 0; i < 4; i++) {
            addSkillText(newText[0][i], false, i + 21);
            addSkillText(newText[1][i], true, i + 21);
        }
        skill.children(icons.length + (text.length * 2) + hovers.length + buttons.length + 1);
        int frame = 0;
        Widget totalLevel = interfaceCache[3984];
        totalLevel.message = "Total level: %1";
        totalLevel.textDrawingAreas = fonts[2];
        skill.child(frame, 3984, 74, 237); frame++;
        for (int i = 0; i < buttons.length; i++) {
            skill.child(frame, buttons[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
        }
        for (int i = 0; i < icons.length; i++) {
            skill.child(frame, icons[i], iconCoords[i][0], iconCoords[i][1]); frame++;
        }
        for (int i = 0; i < text.length; i++) {
            skill.child(frame, text[i][0], textCoords[i][0], textCoords[i][1]); frame++;
        }
        for (int i = 0; i < text.length; i++) {
            skill.child(frame, text[i][1], textCoords[i][2], textCoords[i][3]); frame++;
        }
        for (int i = 0; i < hovers.length; i++) {
            skill.child(frame, hovers[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
        }
    }
    public void children(int total) {
        children = new int[total];
        childX = new int[total];
        childY = new int[total];
    }
    public static void addImage(int id, String s) {
        Widget image = addInterface(id);
        image.type = 5;
        image.atActionType = 0;
        image.contentType = 0;
        image.width = 100;
        image.height = 100;
        image.disabledSprite = getSprite(s);
    }
    public boolean inventoryHover;
    public static void addSkillButton(int id) {
        Widget button = addInterface(id);
        button.type = 5;
        button.atActionType = 5;
        button.contentType = 0;
        button.width = 60;
        button.height = 27;
        button.disabledSprite = getSprite("Button");
        button.tooltip = "View";
    }
    public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1, int ra2,int rune1, int lvl,String name, String descr,RSFont[] RSFont,int sid,int suo,int type){
        Widget rsInterface = addInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID+1;
        rsInterface.spellUsableOn = suo;
        rsInterface.selectedActionName = "Cast On";
        rsInterface.width = 20;
        rsInterface.height = 20;
        rsInterface.tooltip = "Cast <col=65280>"+name;
        rsInterface.spellName = name;
        rsInterface.anIntArray245 = new int[3];
        rsInterface.anIntArray212 = new int[3];
        rsInterface.anIntArray245[0] = 3;
        rsInterface.anIntArray212[0] = ra1;
        rsInterface.anIntArray245[1] = 3;
        rsInterface.anIntArray212[1] = ra2;
        rsInterface.anIntArray245[2] = 3;
        rsInterface.anIntArray212[2] = lvl;
        rsInterface.valueIndexArray = new int[3][];
        rsInterface.valueIndexArray[0] = new int[4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = r1;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.valueIndexArray[1] = new int[4];
        rsInterface.valueIndexArray[1][0] = 4;
        rsInterface.valueIndexArray[1][1] = 3214;
        rsInterface.valueIndexArray[1][2] = r2;
        rsInterface.valueIndexArray[1][3] = 0;
        rsInterface.valueIndexArray[2] = new int[3];
        rsInterface.valueIndexArray[2][0] = 1;
        rsInterface.valueIndexArray[2][1] = 6;
        rsInterface.valueIndexArray[2][2] = 0;
        rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
        rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
        Widget INT = addInterface(ID+1);
        INT.isMouseoverTriggered = true;
        INT.mOverInterToTrigger = -1;
        setChildren(7, INT);
        addLunarSprite(ID+2, 0, "BOX");
        setBounds(ID+2, 0, 0, 0, INT);
        addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);
        setBounds(ID+3, 90, 4, 1, INT);
        addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);
        setBounds(ID+4, 90, 19, 2, INT);
        setBounds(30016, 37, 35, 3, INT);//Rune
        setBounds(rune1, 112, 35, 4, INT);//Rune
        addRuneText(ID+5, ra1+1, r1, RSFont);
        setBounds(ID+5, 50, 66, 5, INT);
        addRuneText(ID+6, ra2+1, r2, RSFont);
        setBounds(ID+6, 123, 66, 6, INT);

    }
    public static void addLunarSprite(int i, int j, String name) {
        Widget Widget = addInterface(i);
        Widget.id = i;
        Widget.parentID = i;
        Widget.type = 5;
        Widget.atActionType = 5;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.mOverInterToTrigger = 52;
        Widget.disabledSprite = LoadLunarSprite(j, name);
        Widget.width = 500;
        Widget.height = 500;
        Widget.tooltip = "";
    }
    public static void addRuneText(int ID, int runeAmount, int RuneID, RSFont[] font) {
        Widget rsInterface = addTabInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 4;
        rsInterface.atActionType = 0;
        rsInterface.contentType = 0;
        rsInterface.width = 0;
        rsInterface.height = 14;
        rsInterface.opacity = 0;
        rsInterface.mOverInterToTrigger = -1;
        rsInterface.anIntArray245 = new int[1];
        rsInterface.anIntArray212 = new int[1];
        rsInterface.anIntArray245[0] = 3;
        rsInterface.anIntArray212[0] = runeAmount;
        rsInterface.valueIndexArray = new int[1][4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = RuneID;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.centerText = true;
        rsInterface.textDrawingAreas = font[0];
        rsInterface.textShadow = true;
        rsInterface.message = "%1/" + runeAmount + "";
        rsInterface.secondaryText = "";
        rsInterface.textColor = 12582912;
        rsInterface.secondaryColor = 49152;
    }
    public static void drawRune(int i, int id, String runeName) {
        Widget Widget = addInterface(i);
        Widget.type = 5;
        Widget.atActionType = 0;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.mOverInterToTrigger = 52;
        Widget.disabledSprite = LoadLunarSprite(id, "RUNE");
        Widget.width = 500;
        Widget.height = 500;
    }

    public static void drawRune(int i, int id) {
        Widget Widget = addInterface(i);
        Widget.type = 5;
        Widget.atActionType = 0;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.mOverInterToTrigger = 52;
        Widget.disabledSprite = LoadLunarSprite(id, "RUNE");
        Widget.width = 500;
        Widget.height = 500;
    }
    public static void homeTeleport(){
        Widget Widget = addInterface(30000);
        Widget.tooltip = "Cast <col=65280>Lunar Home Teleport";
        Widget.id = 30000;
        Widget.parentID = 30000;
        Widget.type = 5;
        Widget.atActionType = 5;
        Widget.contentType = 0;
        Widget.opacity = 0;
        Widget.mOverInterToTrigger = 30001;
        Widget.disabledSprite =  imageLoader(1, "Lunar/SPRITE");
        Widget.width = 20;
        Widget.height = 20;
        Widget Int = addInterface(30001);
        Int.isMouseoverTriggered = true;
        Int.mOverInterToTrigger = -1;
        setChildren(1, Int);
        addLunarSprite(30002, 0, "SPRITE");
        setBounds(30002, 0, 0,0, Int);
    }

    public static void configureLunar(RSFont[] RSFont) {
        constructLunar();
        homeTeleport();
        drawRune(30003, 1, "Fire");
        drawRune(30004, 2, "Water");
        drawRune(30005, 3, "Air");
        drawRune(30006, 4, "Earth");
        drawRune(30007, 5, "Mind");
        drawRune(30008, 6, "Body");
        drawRune(30009, 7, "Death");
        drawRune(30010, 8, "Nature");
        drawRune(30011, 9, "Chaos");
        drawRune(30012, 10, "Law");
        drawRune(30013, 11, "Cosmic");
        drawRune(30014, 12, "Blood");
        drawRune(30015, 13, "Soul");
        drawRune(30016, 14, "Astral");
        addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004,
                64, "Bake Pie", "Bake pies without a stove", RSFont, 0, 16, 2);
        addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant",
                "Cure disease on farming patch", RSFont, 1, 4, 2);
        addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65,
                "Monster Examine",
                "Detect the combat statistics of a\\nmonster", RSFont, 2, 2, 2);
        addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005,
                66, "NPC Contact", "Speak with varied NPCs", RSFont, 3, 0, 2);
        addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006,
                67, "Cure Other", "Cure poisoned players", RSFont, 4, 8, 2);
        addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003,
                67, "Humidify", "fills certain vessels with water", RSFont, 5, 0,
                5);
        addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006,
                68, "Moonclan Teleport", "Teleports you to moonclan island",
                RSFont, 6, 0, 5);
        addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69,
                "Tele Group Moonclan",
                "Teleports players to Moonclan\\nisland", RSFont, 7, 0, 5);
        addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006,
                70, "Ourania Teleport", "Teleports you to ourania rune altar",
                RSFont, 8, 0, 5);
        addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012,
                70, "Cure Me", "Cures Poison", RSFont, 9, 0, 5);
        addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit",
                "Get a kit of hunting gear", RSFont, 10, 0, 5);
        addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004,
                71, "Waterbirth Teleport",
                "Teleports you to Waterbirth island", RSFont, 11, 0, 5);
        addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72,
                "Tele Group Waterbirth",
                "Teleports players to Waterbirth\\nisland", RSFont, 12, 0, 5);
        addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012,
                73, "Cure Group", "Cures Poison on players", RSFont, 13, 0, 5);
        addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74,
                "Stat Spy",
                "Cast on another player to see their\\nskill levels", RSFont, 14,
                8, 2);
        addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,
                "Barbarian Teleport",
                "Teleports you to the Barbarian\\noutpost", RSFont, 15, 0, 5);
        addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,
                "Tele Group Barbarian",
                "Teleports players to the Barbarian\\noutpost", RSFont, 16, 0, 5);
        addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005,
                76, "Superglass Make", "Make glass without a furnace", RSFont, 17,
                16, 2);
        addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004,
                77, "Khazard Teleport", "Teleports you to Port khazard", RSFont,
                18, 0, 5);
        addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004,
                78, "Tele Group Khazard", "Teleports players to Port khazard",
                RSFont, 19, 0, 5);
        addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78,
                "Dream", "Take a rest and restore hitpoints 3\\n times faster",
                RSFont, 20, 0, 5);
        addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004,
                79, "String Jewellery", "String amulets without wool", RSFont, 21,
                0, 5);
        addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004,
                80, "Stat Restore Pot\\nShare",
                "Share a potion with up to 4 nearby\\nplayers", RSFont, 22, 0, 5);
        addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004,
                81, "Magic Imbue", "Combine runes without a talisman", RSFont, 23,
                0, 5);
        addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82,
                "Fertile Soil",
                "Fertilise a farming patch with super\\ncompost", RSFont, 24, 4, 2);
        addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83,
                "Boost Potion Share",
                "Shares a potion with up to 4 nearby\\nplayers", RSFont, 25, 0, 5);
        addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004,
                84, "Fishing Guild Teleport",
                "Teleports you to the fishing guild", RSFont, 26, 0, 5);
        addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004,
                85, "Tele Group Fishing\\nGuild",
                "Teleports players to the Fishing\\nGuild", RSFont, 27, 0, 5);
        addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010,
                85, "Plank Make", "Turn Logs into planks", RSFont, 28, 16, 5);
        /******** Cut Off Limit **********/
        addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004,
                86, "Catherby Teleport", "Teleports you to Catherby", RSFont, 29,
                0, 5);
        addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004,
                87, "Tele Group Catherby", "Teleports players to Catherby",
                RSFont, 30, 0, 5);
        addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004,
                88, "Ice Plateau Teleport", "Teleports you to Ice Plateau",
                RSFont, 31, 0, 5);
        addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89,
                "Tele Group Ice\\n Plateau",
                "Teleports players to Ice Plateau", RSFont, 32, 0, 5);
        addLunar3RunesBigBox(
                30282,
                9075,
                563,
                561,
                2,
                1,
                0,
                30012,
                30010,
                90,
                "Energy Transfer",
                "Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy",
                RSFont, 33, 8, 2);
        addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91,
                "Heal Other",
                "Transfer up to 75% of hitpoints\\n to another player", RSFont,
                34, 8, 2);
        addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92,
                "Vengeance Other",
                "Allows another player to rebound\\ndamage to an opponent",
                RSFont, 35, 8, 2);
        addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006,
                93, "Vengeance", "Rebound damage to an opponent", RSFont, 36, 0, 5);
        addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94,
                "Heal Group", "Transfer up to 75% of hitpoints to a group",
                RSFont, 37, 0, 5);
        addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95,
                "Spellbook Swap",
                "Change to another spellbook for 1\\nspell cast", RSFont, 38, 0, 5);
    }
    public static void skilllevel(RSFont[] tda) {
        Widget text = interfaceCache[7202];
        Widget attack = interfaceCache[6247];
        Widget defence = interfaceCache[6253];
        Widget str = interfaceCache[6206];
        Widget hits = interfaceCache[6216];
        Widget rng = interfaceCache[4443];
        Widget pray = interfaceCache[6242];
        Widget mage = interfaceCache[6211];
        Widget cook = interfaceCache[6226];
        Widget wood = interfaceCache[4272];
        Widget flet = interfaceCache[6231];
        Widget fish = interfaceCache[6258];
        Widget fire = interfaceCache[4282];
        Widget craf = interfaceCache[6263];
        Widget smit = interfaceCache[6221];
        Widget mine = interfaceCache[4416];
        Widget herb = interfaceCache[6237];
        Widget agil = interfaceCache[4277];
        Widget thie = interfaceCache[4261];
        Widget slay = interfaceCache[12122];
        Widget farm = addInterface(25267);
        Widget rune = interfaceCache[4267];
        Widget cons = addInterface(7267);
        Widget hunt = addInterface(29267);
        Widget summ = addInterface(9267);
        Widget dungg = addInterface(32267);
        addSprite(17878, 0, "Interfaces/skillchat/skill");
        addSprite(17879, 1, "Interfaces/skillchat/skill");
        addSprite(17880, 2, "Interfaces/skillchat/skill");
        addSprite(17881, 3, "Interfaces/skillchat/skill");
        addSprite(17882, 4, "Interfaces/skillchat/skill");
        addSprite(17883, 5, "Interfaces/skillchat/skill");
        addSprite(17884, 6, "Interfaces/skillchat/skill");
        addSprite(17885, 7, "Interfaces/skillchat/skill");
        addSprite(17886, 8, "Interfaces/skillchat/skill");
        addSprite(17887, 9, "Interfaces/skillchat/skill");
        addSprite(17888, 10, "Interfaces/skillchat/skill");
        addSprite(17889, 11, "Interfaces/skillchat/skill");
        addSprite(17890, 12, "Interfaces/skillchat/skill");
        addSprite(17891, 13, "Interfaces/skillchat/skill");
        addSprite(17892, 14, "Interfaces/skillchat/skill");
        addSprite(17893, 15, "Interfaces/skillchat/skill");
        addSprite(17894, 16, "Interfaces/skillchat/skill");
        addSprite(17895, 17, "Interfaces/skillchat/skill");
        addSprite(17896, 18, "Interfaces/skillchat/skill");
        addSprite(27897, 19, "Interfaces/skillchat/skill");
        addSprite(17898, 20, "Interfaces/skillchat/skill");
        addSprite(17899, 21, "Interfaces/skillchat/skill");
        addSprite(17900, 22, "Interfaces/skillchat/skill");
        addSprite(17901, 23, "Interfaces/skillchat/skill");
        addSprite(17902, 24, "Interfaces/skillchat/skill");

        setChildren(4, attack);
        setBounds(17878, 20, 30, 0, attack);
        setBounds(4268, 80, 15, 1, attack);
        setBounds(4269, 80, 45, 2, attack);
        setBounds(358, 95, 75, 3, attack);
        setChildren(4, defence);
        setBounds(17879, 20, 30, 0, defence);
        setBounds(4268, 80, 15, 1, defence);
        setBounds(4269, 80, 45, 2, defence);
        setBounds(358, 95, 75, 3, defence);
        setChildren(4, str);
        setBounds(17880, 20, 30, 0, str);
        setBounds(4268, 80, 15, 1, str);
        setBounds(4269, 80, 45, 2, str);
        setBounds(358, 95, 75, 3, str);
        setChildren(4, hits);
        setBounds(17881, 20, 30, 0, hits);
        setBounds(4268, 80, 15, 1, hits);
        setBounds(4269, 80, 45, 2, hits);
        setBounds(358, 95, 75, 3, hits);
        setChildren(4, rng);
        setBounds(17882, 20, 30, 0, rng);
        setBounds(4268, 80, 15, 1, rng);
        setBounds(4269, 80, 45, 2, rng);
        setBounds(358, 95, 75, 3, rng);
        setChildren(4, pray);
        setBounds(17883, 20, 30, 0, pray);
        setBounds(4268, 80, 15, 1, pray);
        setBounds(4269, 80, 45, 2, pray);
        setBounds(358, 95, 75, 3, pray);
        setChildren(4, mage);
        setBounds(17884, 20, 30, 0, mage);
        setBounds(4268, 80, 15, 1, mage);
        setBounds(4269, 80, 45, 2, mage);
        setBounds(358, 95, 75, 3, mage);
        setChildren(4, cook);
        setBounds(17885, 20, 30, 0, cook);
        setBounds(4268, 80, 15, 1, cook);
        setBounds(4269, 80, 45, 2, cook);
        setBounds(358, 95, 75, 3, cook);
        setChildren(4, wood);
        setBounds(17886, 20, 30, 0, wood);
        setBounds(4268, 80, 15, 1, wood);
        setBounds(4269, 80, 45, 2, wood);
        setBounds(358, 95, 75, 3, wood);
        setChildren(4, flet);
        setBounds(17887, 20, 30, 0, flet);
        setBounds(4268, 80, 15, 1, flet);
        setBounds(4269, 80, 45, 2, flet);
        setBounds(358, 95, 75, 3, flet);
        setChildren(4, fish);
        setBounds(17888, 20, 30, 0, fish);
        setBounds(4268, 80, 15, 1, fish);
        setBounds(4269, 80, 45, 2, fish);
        setBounds(358, 95, 75, 3, fish);
        setChildren(4, fire);
        setBounds(17889, 20, 30, 0, fire);
        setBounds(4268, 80, 15, 1, fire);
        setBounds(4269, 80, 45, 2, fire);
        setBounds(358, 95, 75, 3, fire);
        setChildren(4, craf);
        setBounds(17890, 20, 30, 0, craf);
        setBounds(4268, 80, 15, 1, craf);
        setBounds(4269, 80, 45, 2, craf);
        setBounds(358, 95, 75, 3, craf);
        setChildren(4, smit);
        setBounds(17891, 20, 30, 0, smit);
        setBounds(4268, 80, 15, 1, smit);
        setBounds(4269, 80, 45, 2, smit);
        setBounds(358, 95, 75, 3, smit);
        setChildren(4, mine);
        setBounds(17892, 20, 30, 0, mine);
        setBounds(4268, 80, 15, 1, mine);
        setBounds(4269, 80, 45, 2, mine);
        setBounds(358, 95, 75, 3, mine);
        setChildren(4, herb);
        setBounds(17893, 20, 30, 0, herb);
        setBounds(4268, 80, 15, 1, herb);
        setBounds(4269, 80, 45, 2, herb);
        setBounds(358, 95, 75, 3, herb);
        setChildren(4, agil);
        setBounds(17894, 20, 30, 0, agil);
        setBounds(4268, 80, 15, 1, agil);
        setBounds(4269, 80, 45, 2, agil);
        setBounds(358, 95, 75, 3, agil);
        setChildren(4, thie);
        setBounds(17895, 20, 30, 0, thie);
        setBounds(4268, 80, 15, 1, thie);
        setBounds(4269, 80, 45, 2, thie);
        setBounds(358, 95, 75, 3, thie);
        setChildren(4, slay);
        setBounds(17896, 20, 30, 0, slay);
        setBounds(4268, 80, 15, 1, slay);
        setBounds(4269, 80, 45, 2, slay);
        setBounds(358, 95, 75, 3, slay);
        setChildren(4, farm);
        setBounds(27897, 20, 30, 0, farm);
        setBounds(4268, 80, 15, 1, farm);
        setBounds(4269, 80, 45, 2, farm);
        setBounds(358, 95, 75, 3, farm);
        setChildren(4, rune);
        setBounds(17898, 20, 30, 0, rune);
        setBounds(4268, 80, 15, 1, rune);
        setBounds(4269, 80, 45, 2, rune);
        setBounds(358, 95, 75, 3, rune);
        setChildren(4, cons);
        setBounds(17899, 20, 30, 0, cons);
        setBounds(4268, 80, 15, 1, cons);
        setBounds(4269, 80, 45, 2, cons);
        setBounds(358, 95, 75, 3, cons);
        setChildren(4, hunt);
        setBounds(17900, 20, 30, 0, hunt);
        setBounds(4268, 80, 15, 1, hunt);
        setBounds(4269, 80, 45, 2, hunt);
        setBounds(358, 95, 75, 3, hunt);
        setChildren(4, summ);
        setBounds(17901, 20, 30, 0, summ);
        setBounds(4268, 80, 15, 1, summ);
        setBounds(4269, 80, 45, 2, summ);
        setBounds(358, 95, 75, 3, summ);
        setChildren(4, dungg);
        setBounds(17902, 20, 30, 0, dungg);
        setBounds(4268, 80, 15, 1, dungg);
        setBounds(4269, 80, 45, 2, dungg);
        setBounds(358, 95, 75, 3, dungg);
    }
    public static void constructLunar() {
        Widget Interface = addInterface(29999);
        setChildren(80, Interface); //71
        int[] Cid = {30000, 30017, 30025, 30032, 30040, 30048, 30056, 30064, 30075,
                30083, 30091, 30099, 30106, 30114, 30122, 30130, 30138, 30146,
                30154, 30162, 30170, 30178, 30186, 30194, 30202, 30210, 30218,
                30226, 30234, 30242, 30250, 30258, 30266, 30274, 30282, 30290,
                30298, 30306, 30314, 30322, 30001, 30018, 30026, 30033, 30041,
                30049, 30057, 30065, 30076, 30084, 30092, 30100, 30107, 30115,
                30123, 30131, 30139, 30147, 30155, 30163, 30171, 30179, 30187,
                30195, 30203, 30211, 30219, 30227, 30235, 30243, 30251,
                30259, 30267, 30275, 30283, 30291,
                30299, 30307, 30315, 30323 };

        int[] xCord = {11, 40, 71, 103, 135, 165, 8, 39, 71, 103, 135, 165, 12, 42, 71,
                103, 135, 165, 14, 42, 71, 101, 135, 168, 11, 42, 74, 103, 135,
                164, 10, 42, 71, 103, 136, 165, 13, 42, 71, 104, 6, 5, 5, 5, 5,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                5, 5, 5, 5, 5,
                5, 5, 5, 5, 5,
                5, 5, 5, 5 };

        int[] yCord = {9, 9, 12, 10, 12, 10, 39, 39, 39, 39, 39, 37, 68, 68, 68, 68, 68,
                68, 97, 97, 97, 97, 98, 98, 125, 124, 125, 125, 125, 126, 155, 155,
                155, 155, 155, 155, 185, 185, 184, 184, 184, 176, 176, 163, 176,
                176, 176, 176, 163, 176, 176, 176, 176, 163, 176, 163, 163, 163, 176,
                176, 176, 163, 176, 149, 176, 163, 163, 176, 149, 176, 176,
                176, 176, 176, 9, 9,
                9, 9, 9, 9 };

        for(int i = 0; i < Cid.length; i++) {
            setBounds(Cid[i], xCord[i], yCord[i], i, Interface);
        }
    }

    public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,RSFont[] RSFont, int sid,int suo,int type){
        Widget rsInterface = addInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID+1;
        rsInterface.spellUsableOn = suo;
        rsInterface.selectedActionName = "Cast on";
        rsInterface.width = 20;
        rsInterface.height = 20;
        rsInterface.tooltip = "Cast <col=65280>"+name;
        rsInterface.spellName = name;
        rsInterface.anIntArray245 = new int[4];
        rsInterface.anIntArray212 = new int[4];
        rsInterface.anIntArray245[0] = 3;
        rsInterface.anIntArray212[0] = ra1;
        rsInterface.anIntArray245[1] = 3;
        rsInterface.anIntArray212[1] = ra2;
        rsInterface.anIntArray245[2] = 3;
        rsInterface.anIntArray212[2] = ra3;
        rsInterface.anIntArray245[3] = 3;
        rsInterface.anIntArray212[3] = lvl;
        rsInterface.valueIndexArray = new int[4][];
        rsInterface.valueIndexArray[0] = new int[4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = r1;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.valueIndexArray[1] = new int[4];
        rsInterface.valueIndexArray[1][0] = 4;
        rsInterface.valueIndexArray[1][1] = 3214;
        rsInterface.valueIndexArray[1][2] = r2;
        rsInterface.valueIndexArray[1][3] = 0;
        rsInterface.valueIndexArray[2] = new int[4];
        rsInterface.valueIndexArray[2][0] = 4;
        rsInterface.valueIndexArray[2][1] = 3214;
        rsInterface.valueIndexArray[2][2] = r3;
        rsInterface.valueIndexArray[2][3] = 0;
        rsInterface.valueIndexArray[3] = new int[3];
        rsInterface.valueIndexArray[3][0] = 1;
        rsInterface.valueIndexArray[3][1] = 6;
        rsInterface.valueIndexArray[3][2] = 0;
        rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
        rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
        Widget INT = addInterface(ID+1);
        INT.isMouseoverTriggered = true;
        INT.mOverInterToTrigger = -1;
        setChildren(9, INT);
        addLunarSprite(ID+2, 0, "BOX");
        setBounds(ID+2, 0, 0, 0, INT);
        addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);setBounds(ID+3, 90, 4, 1, INT);
        addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);	setBounds(ID+4, 90, 19, 2, INT);
        setBounds(30016, 14, 35, 3, INT);
        setBounds(rune1, 74, 35, 4, INT);
        setBounds(rune2, 130, 35, 5, INT);
        addRuneText(ID+5, ra1+1, r1, RSFont);
        setBounds(ID+5, 26, 66, 6, INT);
        addRuneText(ID+6, ra2+1, r2, RSFont);
        setBounds(ID+6, 87, 66, 7, INT);
        addRuneText(ID+7, ra3+1, r3, RSFont);
        setBounds(ID+7, 142, 66, 8, INT);
    }

    public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,RSFont[] RSFont, int sid,int suo,int type){
        Widget rsInterface = addInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID+1;
        rsInterface.spellUsableOn = suo;
        rsInterface.selectedActionName = "Cast on";
        rsInterface.width = 20;
        rsInterface.height = 20;
        rsInterface.tooltip = "Cast <col=65280>"+name;
        rsInterface.spellName = name;
        rsInterface.anIntArray245 = new int[4];
        rsInterface.anIntArray212 = new int[4];
        rsInterface.anIntArray245[0] = 3;
        rsInterface.anIntArray212[0] = ra1;
        rsInterface.anIntArray245[1] = 3;
        rsInterface.anIntArray212[1] = ra2;
        rsInterface.anIntArray245[2] = 3;
        rsInterface.anIntArray212[2] = ra3;
        rsInterface.anIntArray245[3] = 3;
        rsInterface.anIntArray212[3] = lvl;
        rsInterface.valueIndexArray = new int[4][];
        rsInterface.valueIndexArray[0] = new int[4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = r1;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.valueIndexArray[1] = new int[4];
        rsInterface.valueIndexArray[1][0] = 4;
        rsInterface.valueIndexArray[1][1] = 3214;
        rsInterface.valueIndexArray[1][2] = r2;
        rsInterface.valueIndexArray[1][3] = 0;
        rsInterface.valueIndexArray[2] = new int[4];
        rsInterface.valueIndexArray[2][0] = 4;
        rsInterface.valueIndexArray[2][1] = 3214;
        rsInterface.valueIndexArray[2][2] = r3;
        rsInterface.valueIndexArray[2][3] = 0;
        rsInterface.valueIndexArray[3] = new int[3];
        rsInterface.valueIndexArray[3][0] = 1;
        rsInterface.valueIndexArray[3][1] = 6;
        rsInterface.valueIndexArray[3][2] = 0;
        rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
        rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
        Widget INT = addInterface(ID+1);
        INT.isMouseoverTriggered = true;
        INT.mOverInterToTrigger = -1;
        setChildren(9, INT);
        addLunarSprite(ID+2, 1, "BOX");
        setBounds(ID+2, 0, 0, 0, INT);
        addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);setBounds(ID+3, 90, 4, 1, INT);
        addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);	setBounds(ID+4, 90, 21, 2, INT);
        setBounds(30016, 14, 48, 3, INT);
        setBounds(rune1, 74, 48, 4, INT);
        setBounds(rune2, 130, 48, 5, INT);
        addRuneText(ID+5, ra1+1, r1, RSFont);
        setBounds(ID+5, 26, 79, 6, INT);
        addRuneText(ID+6, ra2+1, r2, RSFont);
        setBounds(ID+6, 87, 79, 7, INT);
        addRuneText(ID+7, ra3+1, r3, RSFont);
        setBounds(ID+7, 142, 79, 8, INT);
    }


    public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,RSFont[] RSFont, int sid,int suo,int type){
        Widget rsInterface = addInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID+1;
        rsInterface.spellUsableOn = suo;
        rsInterface.selectedActionName = "Cast on";
        rsInterface.width = 20;
        rsInterface.height = 20;
        rsInterface.tooltip = "Cast <col=65280>"+name;
        rsInterface.spellName = name;
        rsInterface.anIntArray245 = new int[4];
        rsInterface.anIntArray212 = new int[4];
        rsInterface.anIntArray245[0] = 3;
        rsInterface.anIntArray212[0] = ra1;
        rsInterface.anIntArray245[1] = 3;
        rsInterface.anIntArray212[1] = ra2;
        rsInterface.anIntArray245[2] = 3;
        rsInterface.anIntArray212[2] = ra3;
        rsInterface.anIntArray245[3] = 3;
        rsInterface.anIntArray212[3] = lvl;
        rsInterface.valueIndexArray = new int[4][];
        rsInterface.valueIndexArray[0] = new int[4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = r1;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.valueIndexArray[1] = new int[4];
        rsInterface.valueIndexArray[1][0] = 4;
        rsInterface.valueIndexArray[1][1] = 3214;
        rsInterface.valueIndexArray[1][2] = r2;
        rsInterface.valueIndexArray[1][3] = 0;
        rsInterface.valueIndexArray[2] = new int[4];
        rsInterface.valueIndexArray[2][0] = 4;
        rsInterface.valueIndexArray[2][1] = 3214;
        rsInterface.valueIndexArray[2][2] = r3;
        rsInterface.valueIndexArray[2][3] = 0;
        rsInterface.valueIndexArray[3] = new int[3];
        rsInterface.valueIndexArray[3][0] = 1;
        rsInterface.valueIndexArray[3][1] = 6;
        rsInterface.valueIndexArray[3][2] = 0;
        rsInterface.enabledSprite =  imageLoader(sid, "Lunar/LUNARON");
        rsInterface.disabledSprite =  imageLoader(sid, "Lunar/LUNAROFF");
        Widget INT = addInterface(ID+1);
        INT.isMouseoverTriggered = true;
        INT.mOverInterToTrigger = -1;
        setChildren(9, INT);
        addLunarSprite(ID+2, 2, "BOX");
        setBounds(ID+2, 0, 0, 0, INT);
        addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, RSFont, 1);
        setBounds(ID+3, 90, 4, 1, INT);
        addText(ID+4, descr, 0xAF6A1A, true, true, 52, RSFont, 0);
        setBounds(ID+4, 90, 34, 2, INT);
        setBounds(30016, 14, 61, 3, INT);
        setBounds(rune1, 74, 61, 4, INT);
        setBounds(rune2, 130, 61, 5, INT);
        addRuneText(ID+5, ra1+1, r1, RSFont);
        setBounds(ID+5, 26, 92, 6, INT);
        addRuneText(ID+6, ra2+1, r2, RSFont);
        setBounds(ID+6, 87, 92, 7, INT);
        addRuneText(ID+7, ra3+1, r3, RSFont);
        setBounds(ID+7, 142, 92, 8, INT);
    }

    private static Sprite LoadLunarSprite(int i, String s) {
        Sprite sprite = imageLoader(i, "/Lunar/" + s);
        return sprite;
    }
    public static Sprite getSprite(String s) {
        Sprite image;
        try {
            image = new Sprite("Interfaces/skill/"+s);
            if (image != null) {
                return image;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return image;
    }
    public static void createSkillHover(int id, int x) {
        Widget hover = addInterface(id);
        hover.type = 9;
        hover.message = "TESTING!";
        hover.contentType = x;
        hover.width = 60;
        hover.height = 28;
        hover.inventoryHover = true;
    }
    private Model method206(int i, int j) {
        Model model = (Model)aClass12_264.method222((long)((i << 16) + j));
        if(model != null) {
            return model;
        } else {
            if(i == 1) {
                model = Model.method462(this.anInt213, j);
            }

            if(i == 2) {
                model = Class5.method159(j).method160(true);
            }

            if(i == 3) {
                model = client.localPlayer.method453((byte)-41);
            }

            if(i == 4) {
                model = ItemDefinition.method198(j).method202(50, true);
            }

            if(i == 5) {
                model = null;
            }

            if(model != null) {
                aClass12_264.method223(model, (long)((i << 16) + j), (byte)2);
            }

            return model;
        }
    }

    private static Sprite method207(int i, boolean flag, FileArchive fileArchive, String s) {
        long l = (TextClass.method585((byte)1, s) << 8) + (long)i;
        if(flag) {
            throw new NullPointerException();
        } else {
            Sprite sprite = (Sprite)aClass12_238.method222(l);
            if(sprite != null) {
                return sprite;
            } else {
                try {
                    sprite = new Sprite(fileArchive, s, i);
                    aClass12_238.method223(sprite, l, (byte)2);
                    return sprite;
                } catch (Exception var8) {
                    return null;
                }
            }
        }
    }

    public static void method208(int i, boolean flag, int j, Model model) {
        if(!flag) {
            aClass12_264.method224();
            if(model != null && j != 4) {
                aClass12_264.method223(model, (long)((j << 16) + i), (byte)2);
            }

        }
    }

    public Model method209(int i, int j, int k, boolean flag) {
        Model model;
        if(flag) {
            model = this.method206(this.anInt255, this.anInt256);
        } else {
            model = this.method206(this.anInt233, this.mediaID);
        }

        if(model == null) {
            return null;
        } else if(k == -1 && j == -1 && model.face_color == null) {
            return model;
        } else {
            Model model_1 = new Model(9, true, FrameLoader.method532(k, false) & FrameLoader.method532(j, false), false, model);
            if(k != -1 || j != -1) {
                model_1.createBones();
            }

            if(k != -1) {
                model_1.method470(k, '\u9e5e');
            }

            if(j != -1) {
                model_1.method470(j, '\u9e5e');
            }

            model_1.method479(64, 768, -50, -10, -50, true);
            if(i != 0) {
                throw new NullPointerException();
            } else {
                return model_1;
            }
        }
    }
}
