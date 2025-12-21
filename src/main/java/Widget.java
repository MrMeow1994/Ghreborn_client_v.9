import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

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
    public static Int2ObjectOpenHashMap<Widget> interfaceCache = new Int2ObjectOpenHashMap<>();
    public Consumer<String> inputFieldListener;
    public Consumer<Integer> buttonListener;
    public static final int SHOP_CONTAINER = 64016;
    public static final int CLOSE_BUTTON_SMALL = 27302;
    public static final int CLOSE_BUTTON_SMALL_HOVER = 27303;
    public boolean newButtonClicking;
    private int anInt229 = 891;
    private static Class12 aClass12_238;

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
    public int[] valueCompareType;
    public int[] requiredValues;
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
    public int itemSpriteId1;
    public int itemSpriteId2;
    public int itemSpriteZoom1;
    public int itemSpriteZoom2;
    public int itemSpriteIndex;
    public boolean greyScale;
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
    public int mediaType;
    public int mediaID;
    public Sprite disabledSprite;
    public int enabledMediaType;
    public int enabledMediaID;
    public String selectedActionName;
    public String spellName;
    public int spellUsableOn;
    public Sprite enabledSprite;
    public int disabledAnimationId;
    public int enabledAnimationId;
    public String tooltip;
    public int modelZoom;
    public int selectedSpriteId, enabledSpriteId, disabledSpriteId;
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
    private String popupString;

    public Widget() {
        itemSpriteId1 = -1;
        itemSpriteId2 = -1;
        itemSpriteZoom1 = -1;
        itemSpriteZoom2 = -1;
        itemSpriteIndex = 0;
        enabledSpriteId = disabledSpriteId = -1;
    }

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

        while(stream.currentPosition < stream.buffer.length) {
                int k = stream.readUnsignedShort();
                if(k == 65535) {
                    i = stream.readUnsignedShort();
                    k = stream.readUnsignedShort();
                }
            interfaceCache.put(k, new Widget());
                Widget class9 = interfaceCache.get(k);
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
                    class9.valueCompareType = new int[l];
                    class9.requiredValues = new int[l];

                    for(j1 = 0; j1 < l; ++j1) {
                        class9.valueCompareType[j1] = stream.readUnsignedByte();
                        class9.requiredValues[j1] = stream.readUnsignedShort();
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
                        if (class9.parentID == 1644)
                            class9.actions[2] = "Operate";
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
                        class9.mediaType = 1;
                        class9.mediaID = (i3 - 1 << 8) + stream.readUnsignedByte();
                    }

                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) {
                        class9.enabledMediaType = 1;
                        class9.enabledMediaID = (i3 - 1 << 8) + stream.readUnsignedByte();
                    }

                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) {
                        class9.disabledAnimationId = (i3 - 1 << 8) + stream.readUnsignedByte();
                    } else class9.disabledAnimationId = -1;
                    i3 = stream.readUnsignedByte();
                    if(i3 != 0) class9.enabledAnimationId = (i3 - 1 << 8) + stream.readUnsignedByte();
                    else class9.enabledAnimationId = -1;
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
                        if(class9.actions[k4].length() == 0)
                            class9.actions[k4] = null;

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
        completionistCapeCustomizer(aclass30_sub2_sub1_sub4);
        completionistCapeColorPicker(aclass30_sub2_sub1_sub4);
        constructLunar();
        slayerInterface.Unpack3(aclass30_sub2_sub1_sub4);
        shopWidget(aclass30_sub2_sub1_sub4);
        skilllevel(aclass30_sub2_sub1_sub4);
        skillTab602(aclass30_sub2_sub1_sub4);
        musictab(aclass30_sub2_sub1_sub4);
        SummonTab(aclass30_sub2_sub1_sub4);
        scrollCreation(aclass30_sub2_sub1_sub4);
        pouchCreation(aclass30_sub2_sub1_sub4);
       // prayerTabInterface();
        //quickPrayersInterface();
       // curseTabInterface();
        //quickCursesInterface();
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
        interfaceCache.get('\ufa10').invAlwaysInfinity = false;
    }
    public static Widget addFullScreenInterface(int id) {
        interfaceCache.put(id, new Widget());
        Widget rsi = interfaceCache.get(id);
        rsi.id = id;
        rsi.parentID = id;
        rsi.width = 765;
        rsi.height = 503;
        return rsi;
    }
    public static void addClickableTextmusic(int id, String text, String tooltip, RSFont tda[], int idx, int color,
                                             boolean center, boolean shadow, int width) {
        Widget tab = addTabInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.type = 4;
        tab.atActionType = 1;
        tab.width = width;
        tab.height = 15;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        tab.centerText = center;
        tab.textShadow = shadow;
        tab.textDrawingAreas = tda[idx];
        tab.message = text;

        tab.textColor = color;
        tab.secondaryColor = 0;

        tab.secondaryHoverColor = 0;
        tab.tooltip = tooltip;
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

        return interfaceCache.get(interfaceId);
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
    public static void addToItemGroup(int id, int w, int h, int x, int y, String[] actions) {
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
        rsi.actions = actions;

        rsi.type = 2;
    }
    public static Widget addTabInterface(int id) {
        interfaceCache.put(id, new Widget());
        Widget tab = interfaceCache.get(id);
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
        interfaceCache.put(id, new Widget());
        Widget widget = interfaceCache.get(id);
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
        interfaceCache.put(id, new Widget());
        Widget tab = interfaceCache.get(id);
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 1;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = imageLoader(sid, spriteName);
        tab.enabledSprite = imageLoader(sid, spriteName);
        tab.width = tab.enabledSprite.myWidth;
        tab.height = tab.enabledSprite.myHeight;
        tab.tooltip = tooltip;
    }
    public static Widget addSprite(int i, Sprite sprite) {
        interfaceCache.put(i, new Widget());
        Widget rsinterface = interfaceCache.get(i);
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
        addSprite(id, spriteId, spriteName, -1, -1);
    }

    public void totalChildren(int t) {
        this.children = new int[t];
        this.childX = new int[t];
        this.childY = new int[t];
    }

    public static void clanChatSetup(RSFont[] tda) {
        Widget rsi = addInterface(28300);
        rsi.totalChildren(33);
        byte count = 0;
        addSprite(28301, 1, "/Interfaces/Clan Chat/sprite");
        int var15 = count + 1;
        rsi.child(count, 28301, 14, 17);
        addButton(28302, 0, "/Interfaces/Clan Chat/close", "Close");
        interfaceCache.get(28302).atActionType = 3;
        rsi.child(var15++, 28302, 475, 26);
        addText(28303, "Clan Setup", tda, 2, 16750623, true, true);
        rsi.child(var15++, 28303, 256, 26);
        String[] titles = new String[]{"Clan name:", "Who can enter chat?", "Who can talk on chat?", "Who can kick on chat?", "Who can ban on chat?"};
        String[] defaults = new String[]{"Chat Disabled", "Anyone", "Anyone", "Anyone", "Anyone"};
        String[] whoCan = new String[]{"Anyone", "Recruit", "Corporal", "Sergeant", "Lieutenant", "Captain", "General", "Only Me"};
        int id = 0;
        int y = 28304;

        for(int list = 50; id < titles.length; list += 40) {
            addButton(y, 2, "/Interfaces/Clan Chat/sprite", "");
            interfaceCache.get(y).atActionType = 0;
            if(id > 0) {
                interfaceCache.get(y).actions = whoCan;
            } else {
                interfaceCache.get(y).actions = new String[]{"Change title", "Delete clan"};
            }

            addText(y + 1, titles[id], tda, 0, 16750623, true, true);
            addText(y + 2, defaults[id], tda, 1, 16777215, true, true);
            rsi.child(var15++, y, 25, list);
            rsi.child(var15++, y + 1, 100, list + 4);
            rsi.child(var15++, y + 2, 100, list + 17);
            ++id;
            y += 3;
        }

        addSprite(28319, 5, "/Interfaces/Clan Chat/sprite");
        rsi.child(var15++, 28319, 197, 70);
        short var16 = 28320;
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
            interfaceCache.get(clanSetup).actions = ranks;
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
            interfaceCache.get(clanSetup).actions = new String[]{"Unban"};
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
        interfaceCache.get(id).atActionType = 5;
        rsi.child(var15++, id++, 319, var17);
        addButton(id, 0, "/Interfaces/Clan Chat/plus", "Add banned member");
        interfaceCache.get(id).atActionType = 5;
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
        int[] var19 = new int[]{28302, 28304, 28307, 28310, 28313, 28316, 28526, 28527};
        String[] names = new String[]{"close", "sprite", "sprite", "sprite", "sprite", "sprite", "plus", "plus"};
        int[] ids = new int[]{1, 3, 3, 3, 3, 3, 1, 1};

        for(int index = 0; index < var19.length; ++index) {
            rsi = interfaceCache.get(var19[index]);
            rsi.disabledSprite = imageLoader(ids[index], "/Interfaces/Clan Chat/" + names[index]);
        }

    }
    public static void completionistCapeCustomizer(RSFont[] TDA) {
        Widget widget = addInterface(21503);

        int childId = 21504;
        addSprite(childId++, 0, "Interfaces/CompletionistCape/BACKGROUND");

        addText(childId++, "GodzHell Item Customizer", 0xff9933, true, true, -1, TDA, 2);

        addHoverButton(childId++, "Interfaces/CompletionistCape/BANK", 1, 16, 16, "Close", -1, childId, 1);
        addHoveredButton(childId++, "Interfaces/CompletionistCape/BANK", 2, 16, 16, childId++);

        addHoverButton(childId++, "Interfaces/CompletionistCape/BUTTON", 0, 139, 31, "Done", -1, childId, 1);
        addHoveredButton(childId++, "Interfaces/CompletionistCape/BUTTON", 1, 139, 31, childId++);

        addHoverButton(childId++, "Interfaces/CompletionistCape/REFRESH", 0, 16, 16, "Refresh", -1, childId, 1);
        addHoveredButton(childId++, "Interfaces/CompletionistCape/REFRESH", 1, 16, 16, childId++);

        addText(childId++, "Done Customizing", 0xff9933, true, true, -1, TDA, 2);

        addText(childId++, "Select a color to edit", 0xff9933, true, true, -1, TDA, 1);

        addToItemGroup(childId++, 1, 1, 16, 7, null);

        String colorOptions[] = {"Detail (top)", "Background (top)", "Detail (bottom)", "Background (bottom)"};

        for (int i = 0; i < 4; i++) {
            addRectangle(childId++, 46, 42, 0xcd1634, 0, true);
            addText(childId++, colorOptions[i], 0xff9933, true, true, -1, TDA, 0);
            addHoverButton(childId++, "Interfaces/CompletionistCape/INVIS", 0, 46, 42, "Modify", -1, childId, 1);
            addHoveredButton(childId++, "Interfaces/CompletionistCape/INVIS", 1, 46, 42, childId++);
        }

        widget.totalChildren(childId - 21504 - 7);
        childId = 21504;
        int frame = 0;

        widget.child(frame++, childId++, 11, 11);//Background

        widget.child(frame++, childId++, 255, 21);//Title

        widget.child(frame++, childId++, 473, 20);//Close
        widget.child(frame++, childId++, 473, 20);
        childId++;

        widget.child(frame++, childId++, 122, 276);//Done
        widget.child(frame++, childId++, 122, 276);
        childId++;

        widget.child(frame++, childId++, 451, 261);//Refresh
        widget.child(frame++, childId++, 451, 261);
        childId++;

        widget.child(frame++, childId++, 191, 283);//Done text

        widget.child(frame++, childId++, 199, 75);//Select text

        widget.child(frame++, childId++, 400, 170);//Cape

        int startX = 112;
        int startY = 109;
        for (int i = 0; i < 2; i++) {
            widget.child(frame++, childId++, startX, startY);//Cape Box
            widget.child(frame++, childId++, startX + 23, startY + 46);//Cape
            widget.child(frame++, childId++, startX, startY);//Modify
            widget.child(frame++, childId++, startX, startY);
            childId++;

            widget.child(frame++, childId++, startX, startY + 87);//Cape Box
            widget.child(frame++, childId++, startX + 23, startY + 46 + 87);//Cape
            widget.child(frame++, childId++, startX, startY + 87);//Modify
            widget.child(frame++, childId++, startX, startY + 87);
            childId++;

            startX += 122;
        }
    }
    public static void addRectangle(int id, int width, int height, int colour, int alpha, boolean filled) {
        Widget widget = addTabInterface(id);
        widget.type = 3;
        widget.textColor = colour;
        widget.atActionType = 0;
        widget.opacity = (byte) alpha;
        widget.aBoolean227 = filled;
        widget.contentType = 0;
        widget.width = width;
        widget.height = height;
    }

    public static void completionistCapeColorPicker(RSFont[] TDA) {
        Widget widget = addInterface(625);

        int childId = 626;
        addSprite(childId++, 1, "Interfaces/CompletionistCape/BACKGROUND");

        addText(childId++, "GodzHell Item Customizer", 0xff9933, true, true, -1, TDA, 2);

        addHoverButton(childId++, "Interfaces/CompletionistCape/BUTTON", 0, 139, 31, "Confirm", -1, childId, 1);
        addHoveredButton(childId++, "Interfaces/CompletionistCape/BUTTON", 1, 139, 31, childId++);

        addText(childId++, "Confirm", 0xff9933, true, true, -1, TDA, 2);

        addRectangle(childId++, 46, 42, 0xcd1634, 0, true);

        addHoverButton(childId++, "Interfaces/CompletionistCape/BUTTON", 2, 103, 31, "Reset", -1, childId, 1);
        addHoveredButton(childId++, "Interfaces/CompletionistCape/BUTTON", 3, 103, 31, childId++);

        addText(childId++, "Reset", 0xff9933, true, true, -1, TDA, 2);

        widget.totalChildren(childId - 626 - 2);
        childId = 626;
        int frame = 0;

        widget.child(frame++, childId++, 11, 11);//Background
        widget.child(frame++, childId++, 255, 21);//Title
        widget.child(frame++, childId++, 185, 274);//Confirm button
        widget.child(frame++, childId++, 185, 274);
        childId++;

        widget.child(frame++, childId++, 254, 281);//Confirm text
        widget.child(frame++, childId++, 397, 139);//Confirm text
        widget.child(frame++, childId++, 370, 190);//Reset button
        widget.child(frame++, childId++, 370, 190);
        childId++;

        widget.child(frame++, childId++, 422, 197);//Reset text
    }
    public static void clanChatTab(RSFont[] tda) {
        Widget tab = addTabInterface(28128);
        addHoverButton(28129, "/Clan Chat/SPRITE", 6, 72, 32, "Join Chat", 550, 28130, 1);
        addHoveredButton(28130, "/Clan Chat/SPRITE", 7, 72, 32, 28131);
        addHoverButton(28132, "/Clan Chat/SPRITE", 6, 72, 32, "Leave Chat", -1, 28133, 5);
        addHoveredButton(28133, "/Clan Chat/SPRITE", 7, 72, 32, 28134);
        addButton(28250, 0, "/Clan Chat/Lootshare", "Toggle lootshare");
        addText(28135, "Join Chat", tda, 0, 16751360, true, true);
        addText(28136, "Leave Chat", tda, 0, 16751360, true, true);
        addSprite(28137, 37, "/Clan Chat/SPRITE");
        addText(28138, "Clan Chat", tda, 1, 16751360, true, true);
        addText(28139, "Talking in: Not in chat", tda, 0, 16751360, false, true);
        addText(28140, "Owner: None", tda, 0, 16751360, false, true);
        tab.totalChildren(14);
        tab.child(0, 16126, 0, 221);
        tab.child(1, 16126, 0, 59);
        tab.child(2, 28137, 0, 62);
        tab.child(3, 28143, 0, 62);
        tab.child(4, 28129, 15, 226);
        tab.child(5, 28130, 15, 226);
        tab.child(6, 28132, 103, 226);
        tab.child(7, 28133, 103, 226);
        tab.child(8, 28135, 51, 237);
        tab.child(9, 28136, 139, 237);
        tab.child(10, 28138, 95, 1);
        tab.child(11, 28139, 10, 23);
        tab.child(12, 28140, 25, 38);
        tab.child(13, 28250, 145, 15);
        Widget list = addTabInterface(28143);
        list.totalChildren(100);

        int id;
        for(id = 28144; id <= 28244; ++id) {
            addText(id, "", tda, 0, 16777215, false, true);
        }

        id = 28144;

        for(int i = 0; id <= 28243 && i <= 99; ++i) {
            list.children[i] = id;
            list.childX[i] = 5;
            int id2 = 18144;

            for(int i2 = 1; id2 <= 28243 && i2 <= 99; ++i2) {
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
        Widget totalLevel = interfaceCache.get(3984);
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
        rsInterface.valueCompareType = new int[3];
        rsInterface.requiredValues = new int[3];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = ra2;
        rsInterface.valueCompareType[2] = 3;
        rsInterface.requiredValues[2] = lvl;
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
        rsInterface.valueCompareType = new int[1];
        rsInterface.requiredValues = new int[1];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = runeAmount;
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

    public static void SummonTab(RSFont[] TDA) {
        Widget localRSInterface = addTabInterface(17011);
        addSprite(17012, 6, "SummonTab/SUMMON");
        addButton(17013, 7, "/SummonTab/SUMMON", "Click");

        addSprite(17014, 6, "SummonTab/SUMMON");
        addConfigButton(17015, 17032, 14, 8, "/SummonTab/SUMMON", 20, 30,
                "Call Familiar", 1, 5, 300);
        addHoverButton(17018, "/SummonTab/SUMMON", 2, 38, 36,
                "Beast of burden Inventory", -1, 17028, 1);
        addHoveredButton(17028, "/SummonTab/SUMMON", 12, 38, 36, 17029);
        addHoverButton(17029, "/SummonTab/SUMMON", 1, 38, 36, "Call Familiar",
                -1, 17030, 1);
        addHoveredButton(17030, "/SummonTab/SUMMON", 13, 38, 36, 17031);
        addHoverButton(17023, "/SummonTab/SUMMON", 3, 38, 36,
                "Dismiss Familiar", -1, 17033, 1);
        addHoveredButton(17033, "/SummonTab/SUMMON", 15, 38, 36, 17034);
        addSprite(17016, 5, "SummonTab/SUMMON");
        addText(17017, "", TDA, 2, 14329120, false, true);
        addSprite(17019, 9, "SummonTab/SUMMON");
        addText(17021, "", TDA, 0, 16753920, false, true);
        addSprite(17020, 10, "SummonTab/SUMMON");
        addSprite(17024, 11, "SummonTab/SUMMON");
        addText(17025, "", TDA, 0, 16753920, false, true);
        addText(17026, "", TDA, 0, 16753920, false, true);
        addHead2(17027, 75, 55, 2000);
        localRSInterface.totalChildren(19);
        localRSInterface.child(0, 17012, 10, 25);
        localRSInterface.child(1, 17013, 24, 7);
        localRSInterface.child(2, 17014, 10, 25);
        localRSInterface.child(3, 17015, 11, 25);
        localRSInterface.child(4, 17016, 15, 140);
        localRSInterface.child(5, 17017, 45, 143);
        localRSInterface.child(6, 17018, 20, 170);
        localRSInterface.child(7, 17019, 115, 167);
        localRSInterface.child(8, 17020, 143, 170);
        localRSInterface.child(9, 17021, 135, 197);
        localRSInterface.child(10, 17029, 20, 213);
        localRSInterface.child(11, 17023, 67, 193);
        localRSInterface.child(12, 17024, 135, 214);
        localRSInterface.child(13, 17025, 135, 240);
        localRSInterface.child(14, 17026, 21, 59);
        localRSInterface.child(15, 17027, 75, 55);
        localRSInterface.child(16, 17028, 20, 170);
        localRSInterface.child(17, 17030, 20, 213);
        localRSInterface.child(18, 17033, 67, 193);
    }
    public static void pouchCreation(RSFont TDA[]) {
        int totalScrolls = pouchItems.length;
        int xPadding = 53;
        int yPadding = 57;
        int xPos = 13;
        int yPos = 20;
        Widget rsinterface = addTabInterface(23471);
        setChildren(7, rsinterface);
        addSprite(23472, 1, "interfaces/summoning/creation/summoning");
        addButton(23475, 0, "interfaces/summoning/creation/tab",
                "Transform Scrolls");
        addSprite(23474, 1, "interfaces/summoning/creation/pouch");
        addSprite(23473, 1, "interfaces/summoning/creation/tab");
        addSprite(23476, 0, "interfaces/summoning/creation/scroll");
        addInAreaHover(23477, "interfaces/summoning/creation/close", 1, 0, 16,
                16, "Close", 250, 3);
        Widget scroll = addTabInterface(23478);
        setChildren(3 * totalScrolls, scroll);
        for (int i = 0; i < totalScrolls; i++) {
            addInAreaHover(23479 + i * 8, "interfaces/summoning/creation/box",
                    0, 1, 48, 52, "nothing", -1, 0);
            int req[] = { 1, 2, 3 };
            addPouch(23480 + i * 8, req, 1, pouchItems[i],
                    summoningLevelRequirements[i], pouchNames[i], TDA, i, 5);
            addSprite(23485 + i * 8, pouchItems[i], null, 50, 50);
            setBounds(23479 + i * 8, 36 + (i % 8) * xPadding, 0 + (i / 8)
                    * yPadding, 0 + i * 2, scroll);
            setBounds(23480 + i * 8, 43 + (i % 8) * xPadding, 2 + (i / 8)
                    * yPadding, 1 + i * 2, scroll);
        }

        for (int i = 0; i < totalScrolls; i++) {
            int drawX = 5 + (i % 8) * xPadding;
            if (drawX > 292)
                drawX -= 90;
            int drawY = 55 + (i / 8) * yPadding;
            if (drawY > 160)
                drawY -= 80;
            setBounds(23481 + i * 8, drawX, drawY, 2 + (totalScrolls - 1) * 2
                    + i, scroll);
        }

        scroll.parentID = 23478;
        scroll.id = 23478;
        scroll.atActionType = 0;
        scroll.contentType = 0;
        scroll.width = 474;
        scroll.height = 257;
        scroll.scrollMax = 570;
        setBounds(23472, xPos, yPos, 0, rsinterface);
        setBounds(23473, xPos + 9, yPos + 9, 1, rsinterface);
        setBounds(23474, xPos + 29, yPos + 10, 2, rsinterface);
        setBounds(23475, xPos + 79, yPos + 9, 3, rsinterface);
        setBounds(23476, xPos + 106, yPos + 10, 4, rsinterface);
        setBounds(23477, xPos + 461, yPos + 10, 5, rsinterface);
        setBounds(23478, 0, yPos + 39, 6, rsinterface);
    }

    public static void scrollCreation(RSFont TDA[]) {
        int totalScrolls = pouchItems.length;
        int xPadding = 53;
        int yPadding = 57;
        int xPos = 13;
        int yPos = 20;
        Widget rsinterface = addTabInterface(22760);
        setChildren(7, rsinterface);
        addSprite(22761, 0, "interfaces/summoning/creation/summoning");
        addButton(22762, 0, "interfaces/summoning/creation/tab",
                "Infuse Pouches");
        addSprite(22763, 0, "interfaces/summoning/creation/pouch");
        addSprite(22764, 1, "interfaces/summoning/creation/tab");
        addSprite(22765, 1, "interfaces/summoning/creation/scroll");
        addInAreaHover(22766, "interfaces/summoning/creation/close", 1, 0, 16,
                16, "Close", 250, 3);
        Widget scroll = addTabInterface(22767);
        setChildren(4 * totalScrolls, scroll);
        for (int i = 0; i < totalScrolls; i++) {
            addInAreaHover(22768 + i * 9, "interfaces/summoning/creation/box",
                    0, 1, 48, 52, "nothing", -1, 0);
            addScroll(22769 + i * 9, pouchItems[i], 1, scrollItems[i],
                    summoningLevelRequirements[i], scrollNames[i], TDA, i, 5);
            addSprite(22776 + i * 9, pouchItems[i], null, 50, 50);
            setBounds(22768 + i * 9, 36 + (i % 8) * xPadding, 0 + (i / 8)
                    * yPadding, 0 + i * 3, scroll);
            setBounds(22769 + i * 9, 43 + (i % 8) * xPadding, 2 + (i / 8)
                    * yPadding, 1 + i * 3, scroll);
            setBounds(22776 + i * 9, 28 + (i % 8) * xPadding, 28 + (i / 8)
                    * yPadding, 2 + i * 3, scroll);
        }

        for (int i = 0; i < totalScrolls; i++) {
            int drawX = 5 + (i % 8) * xPadding;
            if (drawX > 292)
                drawX -= 90;
            int drawY = 55 + (i / 8) * yPadding;
            if (drawY > 160)
                drawY -= 80;
            setBounds(22770 + i * 9, drawX, drawY, 3 + (totalScrolls - 1) * 3
                    + i, scroll);
        }

        scroll.parentID = 22767;
        scroll.id = 22767;
        scroll.atActionType = 0;
        scroll.contentType = 0;
        scroll.width = 474;
        scroll.height = 257;
        scroll.scrollMax = 570;
        setBounds(22761, xPos, yPos, 0, rsinterface);
        setBounds(22762, xPos + 9, yPos + 9, 1, rsinterface);
        setBounds(22763, xPos + 29, yPos + 10, 2, rsinterface);
        setBounds(22764, xPos + 79, yPos + 9, 3, rsinterface);
        setBounds(22765, xPos + 106, yPos + 10, 4, rsinterface);
        setBounds(22766, xPos + 461, yPos + 10, 5, rsinterface);
        setBounds(22767, 0, yPos + 39, 6, rsinterface);
    }

    public static void addInAreaHover(int i, String imageName, int sId,
                                      int sId2, int w, int h, String text, int contentType, int actionType) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = actionType;
        tab.contentType = contentType;
        tab.opacity = 0;
        tab.mOverInterToTrigger = i;
        if (sId != -1)
            tab.enabledSprite = imageLoader(sId, imageName);
        tab.disabledSprite = imageLoader(sId2, imageName);
        tab.width = w;
        tab.height = h;
        tab.tooltip = text;
    }

    public static void addSprite(int id, int spriteId, String spriteName,
                                 int zoom1, int zoom2) // summon pouch creation
    {
        interfaceCache.put(id, new Widget());
        Widget tab = interfaceCache.get(id);
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        if (spriteName == null) {
            tab.itemSpriteZoom1 = zoom1;
            tab.itemSpriteId1 = spriteId;
            tab.itemSpriteZoom2 = zoom2;
            tab.itemSpriteId2 = spriteId;
        } else {
            tab.disabledSprite = imageLoader(spriteId, spriteName);
            tab.enabledSprite = imageLoader(spriteId, spriteName);
        }
        tab.width = 512;
        tab.height = 334;
    }

    public static void addScroll(int ID, int r1, int ra1, int r2, int lvl,
                                 String name, RSFont TDA[], int imageID, int type) {
        Widget rsInterface = addTabInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID + 1;
        rsInterface.width = 32;
        rsInterface.height = 32;
        rsInterface.tooltip = (new StringBuilder()).append("Transform @or1@")
                .append(name).toString();
        rsInterface.spellName = name;
        rsInterface.valueCompareType = new int[2];
        rsInterface.requiredValues = new int[2];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = lvl - 1;
        rsInterface.valueIndexArray = new int[3][];
        rsInterface.valueIndexArray[0] = new int[4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = r1;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.valueIndexArray[1] = new int[3];
        rsInterface.valueIndexArray[1][0] = 1;
        rsInterface.valueIndexArray[1][1] = 6;
        rsInterface.valueIndexArray[1][2] = 0;
        rsInterface.itemSpriteId1 = r2;
        rsInterface.itemSpriteId2 = r2;
        rsInterface.itemSpriteIndex = imageID;
        rsInterface.greyScale = true;
        Widget hover = addTabInterface(ID + 1);
        hover.mOverInterToTrigger = -1;
        hover.isMouseoverTriggered = true;
        setChildren(5, hover);
        addSprite(ID + 2, 0, "Lunar/BOX");
        addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl)
                        .append(": ").append(name).toString(), 0xff981f, true, true,
                52, 1);
        addText(ID + 4, "This item requires", 0xaf6a1a, true, true, 52, 0);
        addRuneText(ID + 5, ra1, r1, TDA);
        addSprite(ID + 6, r1, null);
        setBounds(ID + 2, 0, 0, 0, hover);
        setBounds(ID + 3, 90, 4, 1, hover);
        setBounds(ID + 4, 90, 19, 2, hover);
        setBounds(ID + 5, 87, 66, 3, hover);
        setBounds(ID + 6, 72, 33, 4, hover);
    }
    public static void addText(int i, String s, int k, boolean l, boolean m,
                               int a, int j) {
        Widget rsinterface = addTabInterface(i);
        rsinterface.parentID = i;
        rsinterface.id = i;
        rsinterface.type = 4;
        rsinterface.atActionType = 0;
        rsinterface.width = 0;
        rsinterface.height = 0;
        rsinterface.contentType = 0;
        rsinterface.mOverInterToTrigger = a;
        rsinterface.centerText = l;
        rsinterface.textShadow = m;
        rsinterface.textDrawingAreas = fonts[j];
        rsinterface.message = s;
        rsinterface.textColor = k;
    }
    public static void addPouch(int ID, int r1[], int ra1, int r2, int lvl,
                                String name, RSFont TDA[], int imageID, int type) {
        Widget rsInterface = addTabInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID + 1;
        rsInterface.width = 32;
        rsInterface.height = 32;
        rsInterface.tooltip = (new StringBuilder()).append("Infuse @or1@")
                .append(name).toString();
        rsInterface.spellName = name;
        rsInterface.valueCompareType = new int[2];
        rsInterface.requiredValues = new int[2];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = lvl - 1;
        rsInterface.valueIndexArray = new int[2 + r1.length][];
        for (int i = 0; i < r1.length; i++) {
            rsInterface.valueIndexArray[i] = new int[4];
            rsInterface.valueIndexArray[i][0] = 4;
            rsInterface.valueIndexArray[i][1] = 3214;
            rsInterface.valueIndexArray[i][2] = r1[i];
            rsInterface.valueIndexArray[i][3] = 0;
        }

        rsInterface.valueIndexArray[1] = new int[3];
        rsInterface.valueIndexArray[1][0] = 1;
        rsInterface.valueIndexArray[1][1] = 6;
        rsInterface.valueIndexArray[1][2] = 0;
        rsInterface.itemSpriteId1 = r2;
        rsInterface.itemSpriteId2 = r2;
        rsInterface.itemSpriteIndex = imageID;
        rsInterface.greyScale = true;
        Widget hover = addTabInterface(ID + 1);
        hover.mOverInterToTrigger = -1;
        hover.isMouseoverTriggered = true;
        setChildren(5, hover);
        addSprite(ID + 2, 0, "Lunar/BOX");
        addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl)
                        .append(": ").append(name).toString(), 0xff981f, true, true,
                52, 1);
        addText(ID + 4, "This item requires", 0xaf6a1a, true, true, 52, 0);
        addRuneText(ID + 5, ra1, r1[0], TDA);
        addSprite(ID + 6, r1[0], null);
        addSprite(ID + 7, r1[1], null);
        addSprite(ID + 8, r1[2], null);
        setBounds(ID + 2, 0, 0, 0, hover);
        setBounds(ID + 3, 90, 4, 1, hover);
        setBounds(ID + 4, 90, 19, 2, hover);
        setBounds(ID + 5, 87, 66, 3, hover);
        setBounds(ID + 6, 14, 33, 4, hover);
    }
    public static void addConfigButton(int ID, int pID, int bID, int bID2,
                                       String bName, int width, int height, String tT, int configID,
                                       int aT, int configFrame) {
        Widget Tab = addTabInterface(ID);
        Tab.parentID = pID;
        Tab.id = ID;
        Tab.type = 5;
        Tab.atActionType = aT;
        Tab.contentType = 0;
        Tab.width = width;
        Tab.height = height;
        Tab.opacity = 0;
        Tab.mOverInterToTrigger = -1;
        Tab.valueCompareType = new int[1];
        Tab.requiredValues = new int[1];
        Tab.valueCompareType[0] = 1;
        Tab.requiredValues[0] = configID;
        Tab.valueIndexArray = new int[1][3];
        Tab.valueIndexArray[0][0] = 5;
        Tab.valueIndexArray[0][1] = configFrame;
        Tab.valueIndexArray[0][2] = 0;
        Tab.enabledSprite = imageLoader(bID, bName);
        Tab.disabledSprite = imageLoader(bID2, bName);
        Tab.tooltip = tT;
    }

    private static void addHead2(int id, int w, int h, int zoom) {// tewst
        Widget rsinterface = addInterface(id);
        rsinterface.type = 6;
        rsinterface.mediaType = 2;
        rsinterface.mediaID = 4000;//
        rsinterface.modelZoom = zoom;
        rsinterface.modelRotation1 = 40;// 40;//wait
        rsinterface.modelRotation2 = 1900;// 1900;
        rsinterface.height = h;
        rsinterface.width = w;
    }

    private static void addHead3(int id, int j, int k, int l) {
        Widget rsinterface = addInterface(id);
        rsinterface.type = 6;
        rsinterface.modelZoom = l;
        rsinterface.modelRotation1 = 40;
        rsinterface.modelRotation2 = 1900;
        rsinterface.height = k;
        rsinterface.width = j;
    }

    public static void musictab(RSFont[] tda) {
        Widget scroll = interfaceCache.get(4262);
        scroll.scrollMax = 12235;
        scroll.width = 168;
        scroll.height = 190;
        setChildren(815, scroll);

        int yPosition = 0;
        int index = 0;
        String[] musicTracks = {
                "7th Realm",
                "A Familiar Feeling",
                "A New Menace",
                "A Pirate's Life for Me",
                "Adorno I",
                "Adorno II",
                "Adorno III",
                "Adorno IV",
                "Adorno IX",
                "Adorno V",
                "Adorno VI",
                "Adorno VII",
                "Adorno VIII",
                "Adorno X",
                "Adventure",
                "Al Kharid",
                "All for the Pest",
                "All's Fairy in Love and War",
                "Alone",
                "Altar Ego",
                "Alternative Root",
                "Ambient Jungle",
                "An Easter United",
                "Ancestral Wisdom",
                "Animal Apogee",
                "Anywhere",
                "Arabian",
                "Arabian2",
                "Arabian3",
                "Arabique",
                "Arboretum",
                "Architect of War",
                "Ardougne Ago",
                "Arma Gonna Get You",
                "Armadyl Alliance",
                "Armageddon",
                "Army of Darkness",
                "Arrival",
                "Artistry",
                "Assault and Battery",
                "Astea Frostweb",
                "Attack1",
                "Attack2",
                "Attack3",
                "Attack4",
                "Attack5",
                "Attack6",
                "Attention",
                "Autumn Voyage",
                "Aye Car Rum Ba",
                "Aztec",
                "Back to Life",
                "Background",
                "Bal'lak the Pummeller",
                "Ballad of Enchantment",
                "Bandit Camp",
                "Bandos Battalion",
                "Bane of Summer",
                "Barb Wire",
                "Barbarianism",
                "Barking Mad",
                "Baroque",
                "Battle of Souls",
                "Beetle Juice",
                "Beyond",
                "Big Chords",
                "Bish Bash Bosh",
                "Bittersweet Bunny",
                "Black of Knight",
                "Black Zabeth",
                "Black Zabeth: LIVE!",
                "Blink",
                "Blistering Barnacles",
                "Bloodbath",
                "Body Parts",
                "Body Talk",
                "Bolrie's Diary",
                "Bone Dance",
                "Bone Dry",
                "Book of Spells",
                "Borderland",
                "Born to Do This",
                "Bounty Hunter Level 1",
                "Bounty Hunter Level 2",
                "Bounty Hunter Level 3",
                "Brain Battle",
                "Breeze",
                "Brew Hoo Hoo",
                "Brimstail's Scales",
                "Bubble and Squeak",
                "Bulwark Beast",
                "But We Can Fight",
                "Cabin Fever",
                "Cage Against the Machine",
                "Camelot",
                "Castle Wars",
                "Castle Wars",
                "Castle Warz",
                "Catacombs and Tombs",
                "Catch Me If You Can",
                "Cave Background",
                "Cave of Beasts",
                "Cave of the Goblins",
                "Cavern",
                "Cavernous Mythology",
                "Cellar Song",
                "Chain of Command",
                "Chain Reaction",
                "Chamber",
                "Charmin' Farmin'",
                "Chef Surprize",
                "Chickened Out",
                "Chompy Hunt",
                "Christmas Caverns",
                "Circus",
                "Citadel I",
                "Citadel II",
                "Citadel III",
                "Citadel IV",
                "Citadel IX ",
                "Citadel Theme",
                "Citadel V ",
                "Citadel VI ",
                "Citadel VII ",
                "Citadel VIII ",
                "Citadel X ",
                "Citadel XI ",
                "Citadel XII ",
                "Citadel XIII ",
                "Citadel XIV ",
                "Citadel XV ",
                "Citadel XVI ",
                "City of the Dead",
                "Clan Wars",
                "Claustrophobia",
                "Close Quarters",
                "Colonel Grimsson",
                "Command Centre",
                "Competition",
                "Competition",
                "Complication",
                "Conspiracy: Part 1",
                "Conspiracy: Part 2",
                "Contest",
                "Cool for Ali Cats",
                "Copris Lunaris",
                "Corporal Punishment",
                "Corporate Callousness",
                "Corridors of Power",
                "Courage",
                "Creature Cruelty",
                "Creepy",
                "Crystal Castle",
                "Crystal Cave",
                "Crystal Sword",
                "Cursed",
                "Dagannoth Dawn",
                "Dance of Death",
                "Dance of the Undead",
                "Dangerous",
                "Dangerous Logic",
                "Dangerous Road",
                "Dangerous Way",
                "Dark",
                "Darkmeyer",
                "Davy Jones's Locker",
                "Dead and Buried",
                "Dead Can Dance",
                "Dead Quiet",
                "Deadlands",
                "Deadliest Catch",
                "Deadliest Catch",
                "Deep Down",
                "Deep Wildy",
                "Demise of the Dorgeshuun",
                "Desert Heat",
                "Desert Island Bear",
                "Desert Smoke",
                "Desert Voyage",
                "Desolate Ruins",
                "Desolo I",
                "Desolo II",
                "Desolo III",
                "Desolo IV",
                "Desolo IX",
                "Desolo V",
                "Desolo VI",
                "Desolo VII",
                "Desolo VIII",
                "Desolo X",
                "Destiny",
                "Diango's Little Helpers",
                "Dillo-gence is Key",
                "Dimension X",
                "Distant Land",
                "Distant Land",
                "Distillery Hilarity",
                "Divine Skinweaver",
                "Dogs of War",
                "Don't Panic Zanik",
                "Doorways",
                "Dorgeshuun City",
                "Dorgeshuun Deep",
                "Down and Out",
                "Down Below",
                "Down to Earth",
                "Dragontooth Island",
                "Dreadnaught",
                "Dream",
                "Dream Theatre",
                "Dreamstate",
                "Duel Arena",
                "Dunjun",
                "Dusk in Yu'biusk",
                "Dwarf Theme",
                "Dynasty",
                "Eagle Peak",
                "Easter Jig",
                "Egypt",
                "Elven Mist",
                "Elven Seed",
                "Emotion",
                "Emperor",
                "Eruption",
                "Escape",
                "Espionage",
                "Etcetera",
                "Everlasting",
                "Everlasting Fire",
                "Everywhere",
                "Evil Bob's Island",
                "Exam Conditions",
                "Exhibit 'A'",
                "Expanse",
                "Expecting",
                "Expedition",
                "Exposed",
                "Face Off",
                "Faerie",
                "Faithless",
                "Fanfare",
                "Fanfare2",
                "Fanfare3",
                "Fangs for the Memory",
                "Far Away",
                "Far Away",
                "Fe Fi Fo Fum",
                "Fear and Loathing",
                "Fenkenstrain's Refrain",
                "Fight of the Dwarves",
                "Fight or Flight",
                "Final Destination",
                "Find My Way",
                "Fire and Brimstone",
                "Fishing",
                "Flesh-spoiler Haasghenahk",
                "Floating Free",
                "Flute Salad",
                "Food for Thought",
                "Forbidden",
                "Forest",
                "Forever",
                "Forgettable Melody",
                "Forgotten",
                "Freshwater",
                "Frogland",
                "Frost Fight",
                "Frostbite",
                "Fruits de Mer",
                "Funny Bunnies",
                "Gaol",
                "Garden",
                "Garden of Autumn",
                "Garden of Spring",
                "Garden of Summer",
                "Garden of Winter",
                "Ghost of Christmas Presents",
                "Give it Your Pest Shot",
                "Glacialis I",
                "Glacialis II",
                "Glacialis III",
                "Glacialis IV",
                "Glacialis IX",
                "Glacialis V",
                "Glacialis VI",
                "Glacialis VII",
                "Glacialis VIII",
                "Glacialis X",
                "Glorious Recallation...",
                "Glorious Recallation...",
                "Glorious Recallation...",
                "Gluttonous Behemoth",
                "Gnome King",
                "Gnome Village",
                "Gnome Village2",
                "Gnomeball",
                "Go with the Flow",
                "Goblin Game",
                "Goblin Village",
                "Godslayer",
                "Golden Touch",
                "Gravecreeper",
                "Greatness",
                "Grimly Fiendish",
                "Grip of the Talon",
                "Grotto",
                "Ground Scape",
                "Grumpy",
                "Gunnarsgrunn",
                "Guthix's Hunter",
                "H.A.M. Fisted",
                "Halloween Party",
                "Ham and Seek",
                "Ham Attack",
                "Har'Lakk the Riftsplitter",
                "Hare-brained Machines",
                "Harmony",
                "Harmony2",
                "Haunted Mine",
                "Have a Blast",
                "Have an Ice Day",
                "Head to Head",
                "Healin' Feelin'",
                "Heart and Mind",
                "Hell's Bells",
                "Hell's Bells",
                "Hermit",
                "High Seas",
                "High Spirits",
                "Historic Memories",
                "Hobgoblin Geomancer",
                "Home Sweet Home",
                "Homescape",
                "Honkytonky Harmony",
                "Honkytonky Medieval",
                "Honkytonky Newbie Melody",
                "Honkytonky Parade",
                "Honkytonky Sea Shanty",
                "Hope Devourer",
                "Horizon",
                "Hot 'n' Bothered",
                "Hypnotized",
                "I'm Counting on You",
                "Iban",
                "Ice Day for Penguins",
                "Ice Melody",
                "Icy a Worried Gnome",
                "Icy Bones",
                "Icy Trouble Ahead",
                "Illusive",
                "Impetuous",
                "In Between",
                "In Security",
                "In the Brine",
                "In the Clink",
                "In the Manor",
                "In the Pits",
                "Inadequacy",
                "Incantation",
                "Incarceration",
                "Insect Queen",
                "Inspiration",
                "Into the Abyss",
                "Intrepid",
                "Island Life",
                "Island of the Trolls",
                "Isle of Everywhere",
                "Itsy Bitsy...",
                "Jailbird",
                "Jaws of the Dagannoth",
                "Jester Minute",
                "Jolly-R",
                "Joy of the Hunt",
                "Judge and Jury",
                "Jungle Bells",
                "Jungle Community",
                "Jungle Hunt",
                "Jungle Island",
                "Jungle Island XMAS",
                "Jungle Troubles",
                "Jungly1",
                "Jungly2",
                "Jungly3",
                "Kal'Ger the Warmonger",
                "Karamja Jam",
                "Kethsi",
                "Kharidian Nights",
                "Kingdom",
                "Knightly",
                "Knightmare",
                "La Mort",
                "Labyrinth",
                "Lair",
                "Lair of Kang Admi",
                "Lament",
                "Lament of Meiyerditch",
                "Lament of the Snow Queen",
                "Lamistard's Labyrinth",
                "Land Down Under",
                "Land of Snow",
                "Land of the Dwarves",
                "Landlubber",
                "Last Stand",
                "Lasting",
                "Lazy Wabbit",
                "Legend",
                "Legion",
                "Lexicus Runewright",
                "Life's a Beach!",
                "Lighthouse",
                "Lightness",
                "Lightwalk",
                "Little Cave of Horrors",
                "Living Rock",
                "Logical Progression",
                "Lonesome",
                "Long Ago",
                "Long Way Home",
                "Looking Back",
                "Lore and Order",
                "Lortnoc Tsep",
                "Lost Soul",
                "Love and Hate",
                "Love Bites",
                "Love Lost",
                "Lullaby",
                "Luminescent Icefiend",
                "Mad Eadgar",
                "Mage Arena",
                "Magic and Mystery",
                "Magic Dance",
                "Magic Magic Magic",
                "Magical Journey",
                "Maiasaura",
                "Major Miner",
                "Making Waves",
                "Malady",
                "March",
                "Marooned",
                "Marzipan",
                "Masquerade",
                "Mastermindless",
                "Mausoleum",
                "Meddling Kids",
                "Medieval",
                "Mellow",
                "Melodrama",
                "Melzar's Maze",
                "Meridian",
                "Metalwork",
                "Method of Madness",
                "Miles Away",
                "Mind Over Matter",
                "Mindful",
                "Miracle Dance",
                "Mirage",
                "Miscellania",
                "Mobilising Armies",
                "Monarch Waltz",
                "Monkey Madness",
                "Monkey See, Monkey Do",
                "Monkey See, Monkey Do",
                "Monkey See, Monkey Do",
                "Monster Melee",
                "Moody",
                "Morytania",
                "Mouse Trap",
                "Mudskipper Melody",
                "Mutant Medley",
                "My Arm's Journey",
                "Mystery Revealed",
                "Narnode's Theme",
                "Natural",
                "Natural Selection",
                "Necrolord",
                "Neverland",
                "Newbie Melody",
                "Nial's Widow",
                "Night of the Vampyre",
                "Night-gazer Khighorahk",
                "Nightfall",
                "No Way Out",
                "Nomad",
                "Norse Code",
                "Null and Void",
                "Occulo I",
                "Occulo II",
                "Occulo III",
                "Occulo IV",
                "Occulo IX",
                "Occulo V",
                "Occulo VI",
                "Occulo VII",
                "Occulo VIII",
                "Occulo X",
                "Ogre the Top",
                "On the Up",
                "On the Wing",
                "Only a King",
                "Oriental",
                "Out of Control",
                "Out of the Deep",
                "Over To Nardah",
                "Overpass",
                "Overture",
                "Parade",
                "Path of Peril",
                "Pathways",
                "Penguin Possible",
                "Pest Control",
                "Pest Control",
                "Pharaoh's Tomb",
                "Phasmatys",
                "Pheasant Peasant",
                "Pinball Wizard",
                "Pirates of Penance",
                "Pirates of Peril",
                "Plane-freezer Lakhrahnaz",
                "Poison Dreams",
                "Poles Apart",
                "Poles Apart",
                "Precarious Void",
                "Prime Time",
                "Principality",
                "Quest",
                "Rammernaut",
                "Rat a Tat Tat",
                "Rat Hunt",
                "Ready for Battle",
                "Regal",
                "Reggae",
                "Reggae2",
                "Rellekka",
                "Rest for the Weary",
                "Return of Lucien",
                "Reunion",
                "Right of Conquest",
                "Right on Track",
                "Righteousness",
                "Rising Damp",
                "Riverside",
                "Roc and Roll",
                "Rocky Rescue",
                "Roll the Bones",
                "Romancing the Crone",
                "Romper Chomper",
                "Root Canal",
                "Roots and Flutes",
                "Royale",
                "Rune Essence",
                "Runed Behemoth",
                "Sad Meadow",
                "Safety in Numbers",
                "Saga",
                "Sagittare",
                "Saltwater",
                "Sarah's Lullaby",
                "Sarcophagus",
                "Sarim's Vermin",
                "Scape Cave",
                "Scape Hunter",
                "Scape Main",
                "Scape Original",
                "Scape Sad",
                "Scape Santa",
                "Scape Scared",
                "Scape Soft",
                "Scape Summon",
                "Scape Theme",
                "Scape Wild",
                "Scarab",
                "Scarabaeoidea",
                "School's Out",
                "Sea Shanty",
                "Sea Shanty XMAS",
                "Sea Shanty2",
                "Seasonal Sports",
                "Second Vision",
                "Serenade",
                "Serene",
                "Settlement",
                "Shadow-forger Ihlakhizan",
                "Shadowland",
                "Shaping Up",
                "Shine",
                "Shining",
                "Shining Spirit",
                "Shipwrecked",
                "Showdown",
                "Sigmund's Showdown",
                "Silent Knight",
                "Simian Scuffle",
                "Skeletal Trio",
                "Slain to Waste",
                "Slice of Silent Movie",
                "Slice of Station",
                "Slither and Thither",
                "Slug a Bug Ball",
                "Slug Poison",
                "Smorgasbord",
                "Snack Attack",
                "Sojourn",
                "Something Fishy",
                "Soul Wars",
                "Soundscape",
                "Spa Bizarre",
                "Sphinx",
                "Spirit",
                "Spirits of Elid",
                "Splendour",
                "Spooky",
                "Spooky Jungle",
                "Spooky2",
                "Spring Song",
                "Stagnant",
                "Starlight",
                "Start",
                "Stealing Creation",
                "Still Night",
                "Stillness",
                "Stillwater",
                "Stomp",
                "Storeroom Shuffle",
                "Storm Brew",
                "Stranded",
                "Strange Place",
                "Stratosphere",
                "Strength of Saradomin",
                "Subterranea",
                "Sunburn",
                "Superstition",
                "Surok's Theme",
                "Suspicious",
                "Tale of Keldagrim",
                "Talking Forest",
                "Tears of Guthix",
                "Technology",
                "Temple",
                "Temple Desecrated",
                "Temple of Light",
                "Temple of Tribes",
                "Terrorbird Tussle",
                "The Adventurer",
                "The Adventurers Re-United!",
                "The Art of Hocus-Pocus",
                "The Cellar Dwellers",
                "The Chosen",
                "The Chosen Commander",
                "The Columbarium",
                "The Dance of the Snow Queen",
                "The Depths",
                "The Desert",
                "The Desolate Isle",
                "The Duke",
                "The Enchanter",
                "The Evil Within",
                "The Factory Floor",
                "The Fallen Hero",
                "The Far Side",
                "The Galleon",
                "The Genie",
                "The Golem",
                "The Heist",
                "The Horn of Chill",
                "The Last Shanty",
                "The Longramble Scramble",
                "The Lost Melody",
                "The Lost Tribe",
                "The Lunar Isle",
                "The Mad Mole",
                "The Mentor",
                "The Mollusc Menace",
                "The Monsters Below",
                "The Muspah's Tomb",
                "The Navigator",
                "The Noble Rodent",
                "The Other Side",
                "The Pact",
                "The Pengmersible",
                "The Phoenix",
                "The Plundered Tomb",
                "The Power of Tears",
                "The Quiz Master",
                "The Records Chamber",
                "The Rogues' Den",
                "The Route of All Evil",
                "The Route of the Problem",
                "The Ruins of Camdozaal",
                "The Shadow",
                "The Slayer",
                "The Sound of Guthix",
                "The Task at Hand",
                "The Terrible Caverns",
                "The Terrible Tower",
                "The Terrible Tunnels",
                "The Throne of Bandos",
                "The Tower",
                "The Trade Parade",
                "The Vacant Abyss",
                "The Void Stares Back",
                "The Waiting Game",
                "The Wrong Path",
                "Theme",
                "These Stones",
                "Thieves' Guild I",
                "Thieves' Guild II",
                "Thieves' Guild III",
                "Thieves' Guild IV",
                "Three of a Kind",
                "Throne of the Demon",
                "Time Out",
                "Time to Mine",
                "Tiptoe",
                "Title Fight",
                "To'Kash the Bloodchiller",
                "TokTz-Ket-Ek-Mack",
                "Tomb Raider",
                "Tomorrow",
                "Too Many Cooks...",
                "Torqueo I",
                "Torqueo II",
                "Torqueo III",
                "Torqueo IV",
                "Torqueo IX",
                "Torqueo V",
                "Torqueo VI",
                "Torqueo VII",
                "Torqueo VIII",
                "Torqueo X",
                "Tournament!",
                "Trawler",
                "Trawler Minor",
                "Tree Spirits",
                "Trees Aren't Your Friends",
                "Tremble",
                "Tribal",
                "Tribal Background",
                "Tribal2",
                "Trick or Treat?",
                "Trinity",
                "Troll Invasion",
                "Trouble Brewing",
                "Troubled",
                "Troubled Spirit",
                "Tune from the Dune",
                "Twilight",
                "TzHaar!",
                "Unavoidable Conflict",
                "Undead Army",
                "Undead Dungeon",
                "Under the Sand",
                "Undercurrent",
                "Underground",
                "Underground Pass",
                "Understanding",
                "Unholy Cursebearer",
                "Unknown Land",
                "Untouchable",
                "Upcoming",
                "Upir Likhyi",
                "Vanescula Fight",
                "Venomous",
                "Venture",
                "Venture2",
                "Victory is Mine",
                "Village",
                "Vision",
                "Void Knights' Theme",
                "Volcanic Vikings",
                "Voodoo Cult",
                "Voyage",
                "Waiting for Battle",
                "Waiting for the Hunt",
                "Waking Dream",
                "Wander",
                "Warped Gulega",
                "Warrior",
                "Warriors' Guild",
                "Waste Defaced",
                "Waterfall",
                "Waterlogged",
                "Way of the Enchanter",
                "Wayward",
                "We Are the Fairies",
                "Well of Voyage",
                "Where Eagles Lair",
                "Who Are We to Judge?",
                "Wild Isle",
                "Wild Side",
                "Wilderness",
                "Wilderness2",
                "Wilderness3",
                "Wildwood",
                "Winter Funfare",
                "Witching",
                "Woe of the Wyvern",
                "Wonder",
                "Wonderous",
                "Woodland",
                "Work Work Work",
                "Workshop",
                "World-gorger Shukarhazh",
                "Wrath and Ruin",
                "Xenophobe",
                "Yesteryear",
                "Yk'Lagor the Thunderous",
                "Yk'Lagor the Thunderous",
                "Zamorak Zoo",
                "Zanik's Theme",
                "Zaros Stirs",
                "Zaros Zeitgeist",
                "Zealot",
                "Zogre Dance",
                "Zombie Invasion",
                "Zombiism",
        };

        for (int i = 0; i < 815; i++) {
            addClickableTextmusic(46387 + i, musicTracks[i], "Play <col=ff981f>"+musicTracks[i]+"</col>",  tda, 1, 0xff0000, false, true, 130);
            setBounds(46387 + i, 10, yPosition + 3, index++, scroll);
            yPosition += 15;
        }

    }
    public static void skilllevel(RSFont[] tda) {
        Widget text = interfaceCache.get(7202);
        Widget attack = interfaceCache.get(6247);
        Widget defence = interfaceCache.get(6253);
        Widget str = interfaceCache.get(6206);
        Widget hits = interfaceCache.get(6216);
        Widget rng = interfaceCache.get(4443);
        Widget pray = interfaceCache.get(6242);
        Widget mage = interfaceCache.get(6211);
        Widget cook = interfaceCache.get(6226);
        Widget wood = interfaceCache.get(4272);
        Widget flet = interfaceCache.get(6231);
        Widget fish = interfaceCache.get(6258);
        Widget fire = interfaceCache.get(4282);
        Widget craf = interfaceCache.get(6263);
        Widget smit = interfaceCache.get(6221);
        Widget mine = interfaceCache.get(4416);
        Widget herb = interfaceCache.get(6237);
        Widget agil = interfaceCache.get(4277);
        Widget thie = interfaceCache.get(4261);
        Widget slay = interfaceCache.get(12122);
        Widget farm = addInterface(25267);
        Widget rune = interfaceCache.get(4267);
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
        rsInterface.valueCompareType = new int[4];
        rsInterface.requiredValues = new int[4];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = ra2;
        rsInterface.valueCompareType[2] = 3;
        rsInterface.requiredValues[2] = ra3;
        rsInterface.valueCompareType[3] = 3;
        rsInterface.requiredValues[3] = lvl;
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
        rsInterface.valueCompareType = new int[4];
        rsInterface.requiredValues = new int[4];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = ra2;
        rsInterface.valueCompareType[2] = 3;
        rsInterface.requiredValues[2] = ra3;
        rsInterface.valueCompareType[3] = 3;
        rsInterface.requiredValues[3] = lvl;
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
        rsInterface.valueCompareType = new int[4];
        rsInterface.requiredValues = new int[4];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = ra2;
        rsInterface.valueCompareType[2] = 3;
        rsInterface.requiredValues[2] = ra3;
        rsInterface.valueCompareType[3] = 3;
        rsInterface.requiredValues[3] = lvl;
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
    public static void addPrayerWithTooltip(int i, int configId, int configFrame, int requiredValues, int prayerSpriteID, int Hover, String tooltip) {
        Widget Interface = addTabInterface(i);
        Interface.id = i;
        Interface.parentID = 5608;
        Interface.type = 5;
        Interface.atActionType = 4;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.mOverInterToTrigger = Hover;
        Interface.disabledSpriteId = 480;
        Interface.enabledSpriteId = -1;
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 1;
        Interface.requiredValues[0] = configId;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 5;
        Interface.valueIndexArray[0][1] = configFrame;
        Interface.valueIndexArray[0][2] = 0;
        Interface.tooltip = tooltip;
        Interface = addTabInterface(i + 1);
        Interface.id = i + 1;
        Interface.parentID = 5608;
        Interface.type = 5;
        Interface.atActionType = 0;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.disabledSpriteId = 548 + prayerSpriteID;
        Interface.enabledSpriteId = 522 + prayerSpriteID;
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 2;
        Interface.requiredValues[0] = requiredValues + 1;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 2;
        Interface.valueIndexArray[0][1] = 5;
        Interface.valueIndexArray[0][2] = 0;
    }
    public static void addTooltip(int id, String text) {
        Widget rsinterface = addTabInterface(id);
        rsinterface.parentID = id;
        rsinterface.type = 0;
        rsinterface.mOverInterToTrigger = -1;
        addTooltipBox(id + 1, text);
        rsinterface.totalChildren(1);
        rsinterface.child(0, id + 1, 0, 0);
    }
    public static void addTooltipBox(int id, String text) {
        Widget rsi = addInterface(id);
        rsi.id = id;
        rsi.parentID = id;
        rsi.type = 8;
        rsi.popupString = text;
    }
    /*
     * Prayer interface
     */
    private static void prayerTabInterface() {
        Widget prayerMenu = addTabInterface(5608);
        int index = 0;
        int prayIndex = 0;
        int firstRowXPos = 10;
        int firstRowYPos = 50;
        int secondRowXPos = 10;
        int secondRowYPos = 86;
        int thirdRowXPos = 10;
        int thirdRowYPos = 122;
        int fourthRowXPos = 10;
        int fourthRowYPos = 159;
        int fifthRowXPos = 10;
        int fifthRowYPos = 86;
        int sixthRowXPos = 1;
        int sixthRowYPos = 52;
        addText(687, "", 0xff981f, false, true, -1, fonts, 1);
        addSpriteLoader(25105, 813);
        addPrayerWithTooltip(25000, 0, 83, 0, prayIndex, 25052, "Activate @lre@Thick Skin");
        prayIndex++;
        addPrayerWithTooltip(25002, 0, 84, 3, prayIndex, 25054, "Activate @lre@Burst of Strength");
        prayIndex++;
        addPrayerWithTooltip(25004, 0, 85, 6, prayIndex, 25056, "Activate @lre@Clarity of Thought");
        prayIndex++;
        addPrayerWithTooltip(25006, 0, 601, 7, prayIndex, 25058, "Activate @lre@Sharp Eye");
        prayIndex++;
        addPrayerWithTooltip(25008, 0, 602, 8, prayIndex, 25060, "Activate @lre@Mystic Will");
        prayIndex++;
        addPrayerWithTooltip(25010, 0, 86, 9, prayIndex, 25062, "Activate @lre@Rock Skin");
        prayIndex++;
        addPrayerWithTooltip(25012, 0, 87, 12, prayIndex, 25064, "Activate @lre@Superhuman Strength");
        prayIndex++;
        addPrayerWithTooltip(25014, 0, 88, 15, prayIndex, 25066, "Activate @lre@Improved Reflexes");
        prayIndex++;
        addPrayerWithTooltip(25016, 0, 89, 18, prayIndex, 25068, "Activate @lre@Rapid Restore");
        prayIndex++;
        addPrayerWithTooltip(25018, 0, 90, 21, prayIndex, 25070, "Activate @lre@Rapid Heal");
        prayIndex++;
        addPrayerWithTooltip(25020, 0, 91, 24, prayIndex, 25072, "Activate @lre@Protect Item");
        prayIndex++;
        addPrayerWithTooltip(25022, 0, 603, 25, prayIndex, 25074, "Activate @lre@Hawk Eye");
        prayIndex++;
        addPrayerWithTooltip(25024, 0, 604, 26, prayIndex, 25076, "Activate @lre@Mystic Lore");
        prayIndex++;
        addPrayerWithTooltip(25026, 0, 92, 27, prayIndex, 25078, "Activate @lre@Steel Skin");
        prayIndex++;
        addPrayerWithTooltip(25028, 0, 93, 30, prayIndex, 25080, "Activate @lre@Ultimate Strength");
        prayIndex++;
        addPrayerWithTooltip(25030, 0, 94, 33, prayIndex, 25082, "Activate @lre@Incredible Reflexes");
        prayIndex++;
        addPrayerWithTooltip(25032, 0, 95, 36, prayIndex, 25084, "Activate @lre@Protect from Magic");
        prayIndex++;
        addPrayerWithTooltip(25034, 0, 96, 39, prayIndex, 25086, "Activate @lre@Protect from Missles");
        prayIndex++;
        addPrayerWithTooltip(25036, 0, 97, 42, prayIndex, 25088, "Activate @lre@Protect from Melee");
        prayIndex++;
        addPrayerWithTooltip(25038, 0, 605, 43, prayIndex, 25090, "Activate @lre@Eagle Eye");
        prayIndex++;
        addPrayerWithTooltip(25040, 0, 606, 44, prayIndex, 25092, "Activate @lre@Mystic Might");
        prayIndex++;
        addPrayerWithTooltip(25042, 0, 98, 45, prayIndex, 25094, "Activate @lre@Retribution");
        prayIndex++;
        addPrayerWithTooltip(25044, 0, 99, 48, prayIndex, 25096, "Activate @lre@Redemption");
        prayIndex++;
        addPrayerWithTooltip(25046, 0, 100, 51, prayIndex, 25098, "Activate @lre@Smite");
        prayIndex++;
        addPrayerWithTooltip(25048, 0, 607, 59, prayIndex, 25100, "Activate @lre@Chivalry");
        prayIndex++;
        addPrayerWithTooltip(25050, 0, 608, 69, prayIndex, 25102, "Activate @lre@Piety");
        prayIndex++;
        addTooltip(25052, "Level 01\nThick Skin\nIncreases your Defence by 5%");
        addTooltip(25054, "Level 04\nBurst of Strength\nIncreases your Strength by 5%");
        addTooltip(25056, "Level 07\nClarity of Thought\nIncreases your Attack by 5%");
        addTooltip(25058, "Level 08\nSharp Eye\nIncreases your Ranged by 5%");
        addTooltip(25060, "Level 09\nMystic Will\nIncreases your Magic by 5%");
        addTooltip(25062, "Level 10\nRock Skin\nIncreases your Defence by 10%");
        addTooltip(25064, "Level 13\nSuperhuman Strength\nIncreases your Strength by 10%");
        addTooltip(25066, "Level 16\nImproved Reflexes\nIncreases your Attack by 10%");
        addTooltip(25068, "Level 19\nRapid Restore\n2x restore rate for all stats\nexcept Hitpoints, Summoning\nand Prayer");
        addTooltip(25070, "Level 22\nRapid Heal\n2x restore rate for the\nHitpoints stat");
        addTooltip(25072, "Level 25\nProtect Item\nKeep 1 extra item if you die");
        addTooltip(25074, "Level 26\nHawk Eye\nIncreases your Ranged by 10%");
        addTooltip(25076, "Level 27\nMystic Lore\nIncreases your Magic by 10%");
        addTooltip(25078, "Level 28\nSteel Skin\nIncreases your Defence by 15%");
        addTooltip(25080, "Level 31\nUltimate Strength\nIncreases your Strength by 15%");
        addTooltip(25082, "Level 34\nIncredible Reflexes\nIncreases your Attack by 15%");
        addTooltip(25084, "Level 37\nProtect from Magic\nProtection from magical attacks");
        addTooltip(25086, "Level 40\nProtect from Missles\nProtection from ranged attacks");
        addTooltip(25088, "Level 43\nProtect from Melee\nProtection from melee attacks");
        addTooltip(25090, "Level 44\nEagle Eye\nIncreases your Ranged by 15%");
        addTooltip(25092, "Level 45\nMystic Might\nIncreases your Magic by 15%");
        addTooltip(25094, "Level 46\nRetribution\nInflicts damage to nearby\ntargets if you die");
        addTooltip(25096, "Level 49\nRedemption\nHeals you when damaged\nand Hitpoints falls\nbelow 10%");
        addTooltip(25098, "Level 52\nSmite\n1/4 of damage dealt is\nalso removed from\nopponent's Prayer");
        addTooltip(25100, "Level 60\nChivalry\nIncreases your Defence by 20%,\nStrength by 18%, and Attack by\n15%");
        addTooltip(25102, "Level 70\nPiety\nIncreases your Defence by 25%,\nStrength by 23%, and Attack by\n20%");
        setChildren(80, prayerMenu);
        setBounds(687, 85, 241, index, prayerMenu);
        index++;
        setBounds(25105, 65, 241, index, prayerMenu);
        index++;
        setBounds(25000, 2, 5, index, prayerMenu);
        index++;
        setBounds(25001, 5, 8, index, prayerMenu);
        index++;
        setBounds(25002, 40, 5, index, prayerMenu);
        index++;
        setBounds(25003, 44, 8, index, prayerMenu);
        index++;
        setBounds(25004, 76, 5, index, prayerMenu);
        index++;
        setBounds(25005, 79, 11, index, prayerMenu);
        index++;
        setBounds(25006, 113, 5, index, prayerMenu);
        index++;
        setBounds(25007, 116, 10, index, prayerMenu);
        index++;
        setBounds(25008, 150, 5, index, prayerMenu);
        index++;
        setBounds(25009, 153, 9, index, prayerMenu);
        index++;
        setBounds(25010, 2, 45, index, prayerMenu);
        index++;
        setBounds(25011, 5, 48, index, prayerMenu);
        index++;
        setBounds(25012, 39, 45, index, prayerMenu);
        index++;
        setBounds(25013, 44, 47, index, prayerMenu);
        index++;
        setBounds(25014, 76, 45, index, prayerMenu);
        index++;
        setBounds(25015, 79, 49, index, prayerMenu);
        index++;
        setBounds(25016, 113, 45, index, prayerMenu);
        index++;
        setBounds(25017, 116, 50, index, prayerMenu);
        index++;
        setBounds(25018, 151, 45, index, prayerMenu);
        index++;
        setBounds(25019, 154, 50, index, prayerMenu);
        index++;
        setBounds(25020, 2, 82, index, prayerMenu);
        index++;
        setBounds(25021, 4, 84, index, prayerMenu);
        index++;
        setBounds(25022, 40, 82, index, prayerMenu);
        index++;
        setBounds(25023, 44, 87, index, prayerMenu);
        index++;
        setBounds(25024, 77, 82, index, prayerMenu);
        index++;
        setBounds(25025, 81, 85, index, prayerMenu);
        index++;
        setBounds(25026, 114, 83, index, prayerMenu);
        index++;
        setBounds(25027, 117, 85, index, prayerMenu);
        index++;
        setBounds(25028, 153, 83, index, prayerMenu);
        index++;
        setBounds(25029, 156, 87, index, prayerMenu);
        index++;
        setBounds(25030, 2, 120, index, prayerMenu);
        index++;
        setBounds(25031, 5, 125, index, prayerMenu);
        index++;
        setBounds(25032, 40, 120, index, prayerMenu);
        index++;
        setBounds(25033, 43, 124, index, prayerMenu);
        index++;
        setBounds(25034, 78, 120, index, prayerMenu);
        index++;
        setBounds(25035, 83, 124, index, prayerMenu);
        index++;
        setBounds(25036, 114, 120, index, prayerMenu);
        index++;
        setBounds(25037, 115, 121, index, prayerMenu);
        index++;
        setBounds(25038, 151, 120, index, prayerMenu);
        index++;
        setBounds(25039, 154, 124, index, prayerMenu);
        index++;
        setBounds(25040, 2, 158, index, prayerMenu);
        index++;
        setBounds(25041, 5, 160, index, prayerMenu);
        index++;
        setBounds(25042, 39, 158, index, prayerMenu);
        index++;
        setBounds(25043, 41, 158, index, prayerMenu);
        index++;
        setBounds(25044, 76, 158, index, prayerMenu);
        index++;
        setBounds(25045, 79, 163, index, prayerMenu);
        index++;
        setBounds(25046, 114, 158, index, prayerMenu);
        index++;
        setBounds(25047, 116, 158, index, prayerMenu);
        index++;
        setBounds(25048, 153, 158, index, prayerMenu);
        index++;
        setBounds(25049, 161, 160, index, prayerMenu);
        index++;
        setBounds(25050, 2, 196, index, prayerMenu);
        index++;
        setBounds(25051, 4, 207, index, prayerMenu);
        setBoundry(++index, 25052, firstRowXPos - 2, firstRowYPos, prayerMenu);
        setBoundry(++index, 25054, firstRowXPos - 5, firstRowYPos, prayerMenu);
        setBoundry(++index, 25056, firstRowXPos, firstRowYPos, prayerMenu);
        setBoundry(++index, 25058, firstRowXPos, firstRowYPos, prayerMenu);
        setBoundry(++index, 25060, firstRowXPos, firstRowYPos, prayerMenu);
        setBoundry(++index, 25062, secondRowXPos - 9, secondRowYPos, prayerMenu);
        setBoundry(++index, 25064, secondRowXPos - 11, secondRowYPos, prayerMenu);
        setBoundry(++index, 25066, secondRowXPos, secondRowYPos, prayerMenu);
        setBoundry(++index, 25068, secondRowXPos, secondRowYPos, prayerMenu);
        setBoundry(++index, 25070, secondRowXPos + 25, secondRowYPos, prayerMenu);
        setBoundry(++index, 25072, thirdRowXPos, thirdRowYPos, prayerMenu);
        setBoundry(++index, 25074, thirdRowXPos - 2, thirdRowYPos, prayerMenu);
        setBoundry(++index, 25076, thirdRowXPos, thirdRowYPos, prayerMenu);
        setBoundry(++index, 25078, thirdRowXPos - 7, thirdRowYPos, prayerMenu);
        setBoundry(++index, 25080, thirdRowXPos - 10, thirdRowYPos, prayerMenu);
        setBoundry(++index, 25082, fourthRowXPos, fourthRowYPos, prayerMenu);
        setBoundry(++index, 25084, fourthRowXPos - 8, fourthRowYPos, prayerMenu);
        setBoundry(++index, 25086, fourthRowXPos - 7, fourthRowYPos, prayerMenu);
        setBoundry(++index, 25088, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
        setBoundry(++index, 25090, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
        setBoundry(++index, 25092, fifthRowXPos, fifthRowYPos, prayerMenu);
        setBoundry(++index, 25094, fifthRowXPos, fifthRowYPos - 20, prayerMenu);
        setBoundry(++index, 25096, fifthRowXPos, fifthRowYPos - 25, prayerMenu);
        setBoundry(++index, 25098, fifthRowXPos + 15, fifthRowYPos - 25, prayerMenu);
        setBoundry(++index, 25100, fifthRowXPos - 12, fifthRowYPos - 20, prayerMenu);
        setBoundry(++index, 25102, sixthRowXPos - 2, sixthRowYPos, prayerMenu);
        index++;
    }
    public static void setBoundry(int frame, int ID, int X, int Y, Widget RSInterface) {
        RSInterface.children[frame] = ID;
        RSInterface.childX[frame] = X;
        RSInterface.childY[frame] = Y;
    }
    public static void addSpriteLoaderButtonWithTooltipBox(int childId, int spriteId, String tooltip, int hoverSpriteId, int tooltipBoxChildId, String tooltipBoxText, int tooltipx, int tooltipy) {
        interfaceCache.put(childId, new Widget());
        Widget rsi = interfaceCache.get(childId);
        rsi.id = childId;
        rsi.parentID = childId;
        rsi.type = 5;
        rsi.atActionType = 1;
        rsi.contentType = 0;
        rsi.mOverInterToTrigger = tooltipBoxChildId;
        rsi.disabledSprite = client.spriteLoader.lookup(spriteId);
        rsi.enabledSprite = client.spriteLoader.lookup(spriteId);
        rsi.width = rsi.disabledSprite.myWidth;
        rsi.height = rsi.enabledSprite.myHeight - 2;
        rsi.tooltip = tooltip;
        //rsi.isFalseTooltip = true;
        addTooltip2(tooltipBoxChildId, tooltipBoxText, tooltipx, tooltipy);
    }

    public static void addSpriteLoader(int childId, int disabledId, int enabledId) {
        interfaceCache.put(childId, new Widget());
        Widget rsi = interfaceCache.get(childId);
        rsi.id = childId;
        rsi.parentID = childId;
        rsi.type = 5;
        rsi.atActionType = 0;
        rsi.contentType = 0;
        rsi.disabledSprite = client.spriteLoader.lookup(disabledId);
        rsi.enabledSprite = client.spriteLoader.lookup(enabledId);
        rsi.width = rsi.disabledSprite.myWidth;
        rsi.height = rsi.enabledSprite.myHeight;
    }

    public static void addSpriteLoader(int childId, int spriteId) {
        interfaceCache.put(childId, new Widget());
        Widget rsi = interfaceCache.get(childId);
        rsi.id = childId;
        rsi.parentID = childId;
        rsi.type = 5;
        rsi.atActionType = 0;
        rsi.contentType = 0;
        rsi.disabledSprite = client.spriteLoader.lookup(spriteId);
        rsi.enabledSprite = client.spriteLoader.lookup(spriteId);


        //rsi.sprite1.spriteLoader = rsi.sprite2.spriteLoader = true;
        //rsi.hoverSprite1 = client.spriteCache.lookup(hoverSpriteId);
        //rsi.hoverSprite2 = client.spriteCache.lookup(hoverSpriteId);
        //rsi.hoverSprite1.spriteLoader = rsi.hoverSprite2.spriteLoader = true;
        //rsi.sprite1 = rsi.sprite2 = spriteId;
        //rsi.hoverSprite1Id = rsi.hoverSprite2Id = hoverSpriteId;
        rsi.width = rsi.disabledSprite.myWidth;
        rsi.height = rsi.enabledSprite.myHeight - 2;
        //rsi.isFalseTooltip = true;
    }

    public static void addTooltip2(int id, String text, int x, int y) {
        Widget rsinterface = addTabInterface(id);
        rsinterface.parentID = id;
        rsinterface.type = 0;
        rsinterface.mOverInterToTrigger = -1;
        addTooltipBox2(id + 1, text);
        rsinterface.totalChildren(1);
        rsinterface.child(0, id + 1, x, y);
    }
    public static void addTooltipBox2(int id, String text) {
        Widget rsi = addInterface(id);
        rsi.id = id;
        rsi.parentID = id;
        rsi.type = 12;
        rsi.message = text;
    }

    public static void addConfigButtonWSpriteLoader(int ID, int pID, int bID, int bID2, int width, int height, String tT, int configID, int aT, int configFrame) {
        Widget Tab = addTabInterface(ID);
        Tab.parentID = pID;
        Tab.id = ID;
        Tab.type = 5;
        Tab.atActionType = aT;
        Tab.contentType = 0;
        Tab.width = width;
        Tab.height = height;
        Tab.mOverInterToTrigger = -1;
        Tab.valueCompareType = new int[1];
        Tab.requiredValues = new int[1];
        Tab.valueCompareType[0] = 1;
        Tab.requiredValues[0] = configID;
        Tab.valueIndexArray = new int[1][3];
        Tab.valueIndexArray[0][0] = 5;
        Tab.valueIndexArray[0][1] = configFrame;
        Tab.valueIndexArray[0][2] = 0;
        Tab.disabledSprite = client.spriteLoader.lookup(bID);
        Tab.enabledSprite = client.spriteLoader.lookup(bID2);
        Tab.tooltip = tT;
    }
    public static void addTransparentSpriteWSpriteLoader(int id, int spriteId, int opacity) {
        interfaceCache.put(id, new Widget());
        Widget tab = interfaceCache.get(id);
        tab.id = id;
        tab.parentID = id;
        tab.type = 9;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.opacity = (byte) opacity;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = client.spriteLoader.lookup(spriteId);
        tab.enabledSprite = client.spriteLoader.lookup(spriteId);
        tab.width = 512;
        tab.height = 334;
    }

    public static void addHoverButtonWSpriteLoader(int i, int spriteId, int width, int height, String text, int contentType, int hoverOver, int aT) {// hoverable
        // button
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = aT;
        tab.contentType = contentType;
        tab.opacity = 0;
        tab.mOverInterToTrigger = hoverOver;
        tab.disabledSprite = client.spriteLoader.lookup(spriteId);
        tab.enabledSprite = client.spriteLoader.lookup(spriteId);
        tab.width = width;
        tab.height = height;
        tab.tooltip = text;
    }

    public static void addButtonWSpriteLoader(int id, int spriteId, String tooltip) {
        interfaceCache.put(id, new Widget());
        Widget tab = interfaceCache.get(id);
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 1;
        tab.contentType = 0;
        tab.opacity = (byte) 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = client.spriteLoader.lookup(spriteId);
        tab.enabledSprite = client.spriteLoader.lookup(spriteId);
        tab.width = tab.disabledSprite.myWidth;
        tab.height = tab.enabledSprite.myHeight - 2;
        tab.tooltip = tooltip;
    }

    public static void addButtonWSpriteLoader(int id, int spriteId, int spriteId2, String tooltip) {
        interfaceCache.put(id, new Widget());
        Widget tab = interfaceCache.get(id);
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 1;
        tab.contentType = 0;
        tab.opacity = (byte) 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = client.spriteLoader.lookup(spriteId2);
        tab.enabledSprite = client.spriteLoader.lookup(spriteId);
        tab.width = tab.disabledSprite.myWidth;
        tab.height = tab.enabledSprite.myHeight - 2;
        tab.tooltip = tooltip;
    }

    public static void addHoveredImageWSpriteLoader(int i, int spriteId, int w, int h, int imgInterface) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 0;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        tab.scrollMax = 0;
        tab.width = w;
        tab.height = h;
        addHoverImageWSpriteLoader(imgInterface, spriteId);
        tab.totalChildren(1);
        tab.child(0, imgInterface, 0, 0);
    }

    public static void addHoverImageWSpriteLoader(int i, int spriteId) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.width = 512;
        tab.height = 334;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        tab.disabledSprite = client.spriteLoader.lookup(spriteId);
        tab.enabledSprite = client.spriteLoader.lookup(spriteId);
    }
    /**
     * Quick prayers interface
     */
    private static void quickPrayersInterface() {
        int frame = 0;
        Widget tab = addTabInterface(17200);
        addSpriteLoader(17201, 935);
        addText(17230, "Select your quick prayers:", fonts, 0, 0xff981f, false, true);
        addTransparentSpriteWSpriteLoader(17229, 936, 50);
        int i = 17202;
        for (int j = 630; j <= 659; j++) {
            addConfigButtonWSpriteLoader(i, 17200, 938, 937, 14, 15, "Select", 0, 1, j);
            i += i == 17229 ? 50 : 1;
        }

        addHoverButtonWSpriteLoader(17231, 939, 190, 24, "Confirm Selection", -1, 17232, 1);
        addHoveredImageWSpriteLoader(17232, 940, 190, 24, 17233);

        setChildren(62, tab);
        setBounds(25001, 5, 28, frame++, tab);
        setBounds(25003, 44, 28, frame++, tab);
        setBounds(25005, 79, 31, frame++, tab);
        setBounds(25007, 116, 30, frame++, tab);
        setBounds(25009, 153, 29, frame++, tab);
        setBounds(25011, 5, 68, frame++, tab);
        setBounds(25013, 44, 67, frame++, tab);
        setBounds(25015, 79, 69, frame++, tab);
        setBounds(25017, 116, 70, frame++, tab);
        setBounds(25019, 154, 70, frame++, tab);
        setBounds(25021, 4, 104, frame++, tab);
        setBounds(25023, 44, 107, frame++, tab);
        setBounds(25025, 81, 105, frame++, tab);
        setBounds(25027, 117, 105, frame++, tab);
        setBounds(25029, 156, 107, frame++, tab);
        setBounds(25031, 5, 145, frame++, tab);
        setBounds(25033, 43, 144, frame++, tab);
        setBounds(25035, 83, 144, frame++, tab);
        setBounds(25037, 115, 141, frame++, tab);
        setBounds(25039, 154, 144, frame++, tab);
        setBounds(25041, 5, 180, frame++, tab);
        setBounds(25043, 41, 178, frame++, tab);
        setBounds(25045, 79, 183, frame++, tab);
        setBounds(25047, 116, 178, frame++, tab);
        setBounds(25049, 161, 180, frame++, tab);
        setBounds(25051, 4, 219, frame++, tab);
        setBounds(18019, 44, 214, frame++, tab);
        setBounds(18026, 80, 214, frame++, tab);
        setBounds(17229, 0, 25, frame++, tab);
        setBounds(17201, 0, 22, frame++, tab);
        setBounds(17201, 0, 237, frame++, tab);
        setBounds(17202, 2, 25, frame++, tab);
        setBounds(17203, 41, 25, frame++, tab);
        setBounds(17204, 76, 25, frame++, tab);
        setBounds(17205, 113, 25, frame++, tab);
        setBounds(17206, 150, 25, frame++, tab);
        setBounds(17207, 2, 65, frame++, tab);
        setBounds(17208, 41, 65, frame++, tab);
        setBounds(17209, 76, 65, frame++, tab);
        setBounds(17210, 113, 65, frame++, tab);
        setBounds(17211, 150, 65, frame++, tab);
        setBounds(17212, 2, 102, frame++, tab);
        setBounds(17213, 41, 102, frame++, tab);
        setBounds(17214, 76, 102, frame++, tab);
        setBounds(17215, 113, 102, frame++, tab);
        setBounds(17216, 150, 102, frame++, tab);
        setBounds(17217, 2, 141, frame++, tab);
        setBounds(17218, 41, 141, frame++, tab);
        setBounds(17219, 76, 141, frame++, tab);
        setBounds(17220, 113, 141, frame++, tab);
        setBounds(17221, 150, 141, frame++, tab);
        setBounds(17222, 2, 177, frame++, tab);
        setBounds(17223, 41, 177, frame++, tab);
        setBounds(17224, 76, 177, frame++, tab);
        setBounds(17225, 113, 177, frame++, tab);
        setBounds(17226, 150, 177, frame++, tab);
        setBounds(17227, 1, 211, frame++, tab);
        setBounds(17230, 5, 5, frame++, tab);
        setBounds(17231, 0, 237, frame++, tab);
        setBounds(17232, 0, 237, frame++, tab);
        setBounds(17279, 41, 211, frame++, tab);
        setBounds(17280, 76, 211, frame++, tab);
    }
    public static void addPrayer(int i, int configId, int configFrame, int requiredValues, int prayerSpriteID, String PrayerName, int Hover) {
        Widget Interface = addTabInterface(i);
        Interface.id = i;
        Interface.parentID = 22500;
        Interface.type = 5;
        Interface.atActionType = 4;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.mOverInterToTrigger = Hover;
        Interface.disabledSpriteId = 480;
        Interface.enabledSpriteId = -1;
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 1;
        Interface.requiredValues[0] = configId;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 5;
        Interface.valueIndexArray[0][1] = configFrame;
        Interface.valueIndexArray[0][2] = 0;
        Interface.tooltip = "Activate@lre@ " + PrayerName;
        Interface = addTabInterface(i + 1);
        Interface.id = i + 1;
        Interface.parentID = 22500;
        Interface.type = 5;
        Interface.atActionType = 0;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.disabledSpriteId = 501 + prayerSpriteID;
        Interface.enabledSpriteId = 481 + prayerSpriteID;
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 2;
        Interface.requiredValues[0] = requiredValues + 1;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 2;
        Interface.valueIndexArray[0][1] = 5;
        Interface.valueIndexArray[0][2] = 0;
    }
    public static void addPrayer(int i, int configId, int configFrame, int requiredValues, int prayerSpriteID, int disablePrayerId, String PrayerName, int Hover) {
        Widget Interface = addTabInterface(i);
        Interface.id = i;
        Interface.parentID = 22500;
        Interface.type = 5;
        Interface.atActionType = 4;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.mOverInterToTrigger = Hover;
        Interface.disabledSpriteId = 480;
        Interface.enabledSpriteId = -1;
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 1;
        Interface.requiredValues[0] = configId;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 5;
        Interface.valueIndexArray[0][1] = configFrame;
        Interface.valueIndexArray[0][2] = 0;
        Interface.tooltip = "Activate@lre@ " + PrayerName;
        Interface = addTabInterface(i + 1);
        Interface.id = i + 1;
        Interface.parentID = 22500;
        Interface.type = 5;
        Interface.atActionType = 0;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.disabledSprite = client.spriteLoader.lookup(disablePrayerId);
        Interface.enabledSprite = client.spriteLoader.lookup(prayerSpriteID);
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 2;
        Interface.requiredValues[0] = requiredValues + 1;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 2;
        Interface.valueIndexArray[0][1] = 5;
        Interface.valueIndexArray[0][2] = 0;
    }
    public static void addPrayer(int i, int configId, int configFrame, int requiredValues, int spriteOn, int spriteOff, String tooltip) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = 5608;
        tab.type = 5;
        tab.atActionType = 4;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = -1;
        tab.disabledSprite = client.spriteLoader.lookup(941);
        tab.enabledSprite = new Sprite("");
        tab.width = 34;
        tab.height = 34;
        tab.valueCompareType = new int[1];
        tab.requiredValues = new int[1];
        tab.valueCompareType[0] = 1;
        tab.requiredValues[0] = configId;
        tab.valueIndexArray = new int[1][3];
        tab.valueIndexArray[0][0] = 5;
        tab.valueIndexArray[0][1] = configFrame;
        tab.valueIndexArray[0][2] = 0;
        tab.tooltip = tooltip;
        Widget tab2 = addTabInterface(i + 1);
        tab2.id = i + 1;
        tab2.parentID = 5608;
        tab2.type = 5;
        tab2.atActionType = 0;
        tab2.contentType = 0;
        tab2.opacity = 0;
        tab2.mOverInterToTrigger = -1;
        tab2.disabledSprite = client.spriteLoader.lookup(spriteOn);
        if (spriteOff != -1) tab2.enabledSprite = client.spriteLoader.lookup(spriteOff);
        tab2.width = 34;
        tab2.height = 34;
        tab2.valueCompareType = new int[1];
        tab2.requiredValues = new int[1];
        tab2.valueCompareType[0] = 2;
        tab2.requiredValues[0] = requiredValues + 1;
        tab2.valueIndexArray = new int[1][3];
        tab2.valueIndexArray[0][0] = 2;
        tab2.valueIndexArray[0][1] = 5;
        tab2.valueIndexArray[0][2] = 0;
        //RSInterface tab3 = addTabInterface(i + 50);
    }
    public static void addPrayerWithTooltipSpriteLoader(int i, int configId, int configFrame, int requiredValues, int spriteOn, int spriteOff, int Hover, String tooltip) {
        Widget Interface = addTabInterface(i);
        Interface.id = i;
        Interface.parentID = 5608;
        Interface.type = 5;
        Interface.atActionType = 4;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.mOverInterToTrigger = Hover;
        Interface.disabledSprite = imageLoader(0, "Interfaces/PrayerTab/PRAYERGLOW");
        Interface.enabledSprite = imageLoader(1, "Interfaces/PrayerTab/PRAYERGLOW");
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 1;
        Interface.requiredValues[0] = configId;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 5;
        Interface.valueIndexArray[0][1] = configFrame;
        Interface.valueIndexArray[0][2] = 0;
        Interface.tooltip = tooltip;
        Interface = addTabInterface(i + 1);
        Interface.id = i + 1;
        Interface.parentID = 5608;
        Interface.type = 5;
        Interface.atActionType = 0;
        Interface.contentType = 0;
        Interface.opacity = 0;
        Interface.disabledSprite = imageLoader(spriteOn,
                "Interfaces/PrayerTab/PRAYERON");
        if (spriteOff != -1) Interface.enabledSprite = imageLoader(spriteOff,
                "Interfaces/PrayerTab/PRAYEROFF");
        Interface.width = 34;
        Interface.height = 34;
        Interface.valueCompareType = new int[1];
        Interface.requiredValues = new int[1];
        Interface.valueCompareType[0] = 2;
        Interface.requiredValues[0] = requiredValues + 1;
        Interface.valueIndexArray = new int[1][3];
        Interface.valueIndexArray[0][0] = 2;
        Interface.valueIndexArray[0][1] = 5;
        Interface.valueIndexArray[0][2] = 0;
    }
    /*
     * Curse tab
     */
    private static void curseTabInterface() {
        Widget Interface = addTabInterface(32500);
        int index = 0;
        addSpriteLoader(688, 814);
        //addTooltip(19021, "This is the effect that prayers\nand curses have during combat.\nIt includes curses that have\nbeen used against you. The\nadjustment has no effect\noutside of combat. The\npercentage shown is relative to\n your skill level, and may vary\ndepending on the enemy you are\nfighting, and the prayers or\n curses used. Partial\npercentages are not shown.");
        addSpriteLoader(689, 815);
        addText(19025, "  Stat Adjustments", 0xFFCC00, false, true, 52, fonts, 0);
        addText(690, "690", 0xFF981F, false, false, -1, fonts, 0);
        addText(691, "691", 0xFF981F, false, false, -1, fonts, 0);
        addText(692, "692", 0xFF981F, false, false, -1, fonts, 0);
        addText(693, "693", 0xFF981F, false, false, -1, fonts, 0);
        addText(694, "694", 0xFF981F, false, false, -1, fonts, 0);
        addText(687, "99/99", 0xFF981F, false, false, -1, fonts, 1);
        addSpriteLoader(32502, 813);
        addPrayer(32503, 0, 610, 49, 7, "Protect Item", 32582);
        addPrayer(32505, 0, 611, 49, 4, "Sap Warrior", 32544);
        addPrayer(32507, 0, 612, 51, 5, "Sap Ranger", 32546);
        addPrayer(32509, 0, 613, 53, 3, "Sap Mage", 32548);
        addPrayer(32511, 0, 614, 55, 2, "Sap Spirit", 32550);
        addPrayer(32513, 0, 615, 58, 18, "Berserker", 32552);
        addPrayer(32515, 0, 616, 61, 15, "Deflect Summoning", 32554);
        addPrayer(32517, 0, 617, 64, 17, "Deflect Magic", 32556);
        addPrayer(32519, 0, 618, 67, 16, "Deflect Missiles", 32558);
        addPrayer(32521, 0, 619, 70, 6, "Deflect Melee", 32560);
        addPrayer(32523, 0, 620, 73, 9, "Leech Attack", 32562);
        addPrayer(32525, 0, 621, 75, 10, "Leech Ranged", 32564);
        addPrayer(32527, 0, 622, 77, 11, "Leech Magic", 32566);
        addPrayer(32529, 0, 623, 79, 12, "Leech Defence", 32568);
        addPrayer(32531, 0, 624, 81, 13, "Leech Strength", 32570);
        addPrayer(32533, 0, 625, 83, 14, "Leech Energy", 32572);
        addPrayer(32535, 0, 626, 91, 1157, 1159, "Torment", 32574);
        addPrayer(32537, 0, 627, 91, 1156, 1158, "Anguish", 32576);
        addPrayer(32539, 0, 628, 91, 8, "Soul Split", 32578);
        addPrayer(32541, 0, 629, 94, 20, "Turmoil", 32580);
        addTooltip(32582, "Level 50\nProtect Item\nKeep 1 extra item if you die");
        addTooltip(32544, "Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time");
        addTooltip(32546, "Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time");
        addTooltip(32548, "Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time");
        addTooltip(32550, "Level 56\nSap Spirit\nDrains enenmy special attack\nenergy");
        addTooltip(32552, "Level 59\nBerserker\nBoosted stats last 15% longer");
        addTooltip(32554, "Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker");
        addTooltip(32556, "Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker");
        addTooltip(32558, "Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker");
        addTooltip(32560, "Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker");
        addTooltip(32562, "Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%, increasing\nto 25% over time");
        addTooltip(32564, "Level 76\nLeech Ranged\nBoosts Ranged by 15% while \ndraining enemy Ranged by 10%\nincreasing to 25% over time");
        addTooltip(32566, "Level 78\nLeech Magic\nBoosts Magic by 15% while \ndraining enemy Magic by 10%\nincreasing to 25% over time");
        addTooltip(32568, "Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time, while draining\n enemy Defence by10%,\nincreasing to 25% over\ntime");
        addTooltip(32570, "Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time, while draining\nenemy Strength by 10%, increasing\n to 25% over time");
        addTooltip(32572, "Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own");
        addTooltip(32574, "Level 95\nTorment\nIncreases Magic and Defence\nby 15%, plus 15% of enemy's\nlevel, and Magic Strength by 23%\nplus 10% of enemy's level");
        addTooltip(32576, "Level 95\nAnguish\nIncreases Ranged and Defence\nby 15%, plus 15% of enemy's\nlevel, and Ranged Strength by 23%\nplus 10% of enemy's level");
        addTooltip(32578, "Level 92\nSoul Split\n1/4 of damage dealt is also removed\nfrom opponent's Prayer and\nadded to your Hitpoints");
        addTooltip(32580, "Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level");
        setChildren(70, Interface);
        /*curse start*/
        setBounds(689, 0, 217, index, Interface);
        index++;
        //setBounds(701, 0, 217, index, Interface);index++;
        setBounds(687, 85, 241, index, Interface);
        index++;
        setBounds(688, 0, 170, index, Interface);
        index++;
        setBounds(690, 2, 200, index, Interface);
        index++;
        setBounds(691, 41, 200, index, Interface);
        index++;
        setBounds(692, 79, 200, index, Interface);
        index++;
        setBounds(693, 117, 200, index, Interface);
        index++;
        setBounds(694, 160, 200, index, Interface);
        index++;
        setBounds(19025, 47, 218, index, Interface);
        index++;
        //setBounds(19030, 47, 219, index, Interface);index++;
        setBounds(32502, 65, 241, index, Interface);
        index++;
        setBounds(32503, 2, 5, index, Interface);
        index++;
        setBounds(32504, 8, 8, index, Interface);
        index++;
        setBounds(32505, 40, 5, index, Interface);
        index++;
        setBounds(32506, 47, 12, index, Interface);
        index++;
        setBounds(32507, 76, 5, index, Interface);
        index++;
        setBounds(32508, 82, 11, index, Interface);
        index++;
        setBounds(32509, 113, 5, index, Interface);
        index++;
        setBounds(32510, 116, 8, index, Interface);
        index++;
        setBounds(32511, 150, 5, index, Interface);
        index++;
        setBounds(32512, 155, 10, index, Interface);
        index++;
        setBounds(32513, 2, 45, index, Interface);
        index++;
        setBounds(32514, 9, 48, index, Interface);
        index++;
        setBounds(32515, 39, 45, index, Interface);
        index++;
        setBounds(32516, 42, 47, index, Interface);
        index++;
        setBounds(32517, 76, 45, index, Interface);
        index++;
        setBounds(32518, 79, 48, index, Interface);
        index++;
        setBounds(32519, 113, 45, index, Interface);
        index++;
        setBounds(32520, 116, 48, index, Interface);
        index++;
        setBounds(32521, 151, 45, index, Interface);
        index++;
        setBounds(32522, 154, 48, index, Interface);
        index++;
        setBounds(32523, 2, 82, index, Interface);
        index++;
        setBounds(32524, 6, 86, index, Interface);
        index++;
        setBounds(32525, 40, 82, index, Interface);
        index++;
        setBounds(32526, 42, 86, index, Interface);
        index++;
        setBounds(32527, 77, 82, index, Interface);
        index++;
        setBounds(32528, 79, 86, index, Interface);
        index++;
        setBounds(32529, 114, 83, index, Interface);
        index++;
        setBounds(32530, 119, 87, index, Interface);
        index++;
        setBounds(32531, 153, 83, index, Interface);
        index++;
        setBounds(32532, 156, 86, index, Interface);
        index++;
        setBounds(32533, 2, 120, index, Interface);
        index++;
        setBounds(32534, 7, 125, index, Interface);
        index++;
        setBounds(32535, 40, 120, index, Interface);
        index++;
        setBounds(32536, 45, 124, index, Interface);
        index++;
        setBounds(32537, 78, 120, index, Interface);
        index++;
        setBounds(32538, 86, 124, index, Interface);
        index++;
        setBounds(32539, 114, 120, index, Interface);
        index++;
        setBounds(32540, 120, 125, index, Interface);
        index++;
        setBounds(32541, 151, 120, index, Interface);
        index++;
        setBounds(32542, 153, 127, index, Interface);
        index++;
        setBounds(32582, 10, 40, index, Interface);
        index++;
        setBounds(32544, 20, 40, index, Interface);
        index++;
        setBounds(32546, 20, 40, index, Interface);
        index++;
        setBounds(32548, 20, 40, index, Interface);
        index++;
        setBounds(32550, 20, 40, index, Interface);
        index++;
        setBounds(32552, 10, 80, index, Interface);
        index++;
        setBounds(32554, 10, 80, index, Interface);
        index++;
        setBounds(32556, 10, 80, index, Interface);
        index++;
        setBounds(32558, 10, 80, index, Interface);
        index++;
        setBounds(32560, 10, 80, index, Interface);
        index++;
        setBounds(32562, 10, 120, index, Interface);
        index++;
        setBounds(32564, 10, 120, index, Interface);
        index++;
        setBounds(32566, 10, 120, index, Interface);
        index++;
        setBounds(32568, 5, 120, index, Interface);
        index++;
        setBounds(32570, 5, 120, index, Interface);
        index++;
        setBounds(32572, 10, 160, index, Interface);
        index++;
        setBounds(32574, 10, 160, index, Interface);
        index++;
        setBounds(32576, 10, 160, index, Interface);
        index++;
        setBounds(32578, 10, 160, index, Interface);
        index++;
        setBounds(32580, 10, 160, index, Interface);
        index++;
    }

    private static void quickCursesInterface() {
        int frame = 0;
        Widget tab = addTabInterface(17234);
        addText(17235, "Select your quick curses:", fonts, 0, 0xff981f, false, true);
        int i = 17202;
        for (int j = 630; i <= 17222 || j <= 656; j++) {
            addConfigButtonWSpriteLoader(i, 17200, 938, 937, 14, 15, "Select", 0, 1, j);
            i++;
        }


        addHoverButtonWSpriteLoader(17231, 939, 190, 24, "Confirm Selection", -1, 17232, 1);
        addHoveredImageWSpriteLoader(17232, 940, 190, 24, 17233);


        setChildren(46, tab);
        setBounds(32504, 5, 8 + 17, frame++, tab);
        setBounds(32506, 44, 8 + 20, frame++, tab);
        setBounds(32508, 79, 11 + 19, frame++, tab);
        setBounds(32510, 116, 10 + 18, frame++, tab);
        setBounds(32512, 153, 9 + 20, frame++, tab);
        setBounds(32514, 5, 48 + 18, frame++, tab);
        setBounds(32516, 44, 47 + 21, frame++, tab);
        setBounds(32518, 79, 49 + 20, frame++, tab);
        setBounds(32520, 116, 50 + 19, frame++, tab);
        setBounds(32522, 154, 50 + 20, frame++, tab);
        setBounds(32524, 4, 84 + 21, frame++, tab);
        setBounds(32526, 44, 87 + 19, frame++, tab);
        setBounds(32528, 81, 85 + 20, frame++, tab);
        setBounds(32530, 117, 85 + 20, frame++, tab);
        setBounds(32532, 156, 87 + 18, frame++, tab);
        setBounds(32534, 5, 125 + 19, frame++, tab);
        setBounds(32536, 43, 124 + 19, frame++, tab);
        setBounds(32538, 83, 124 + 20, frame++, tab);
        setBounds(32540, 115, 125 + 21, frame++, tab);
        setBounds(32542, 154, 126 + 22, frame++, tab);
        setBounds(17229, 0, 25, frame++, tab);
        setBounds(17201, 0, 22, frame++, tab);
        setBounds(17201, 0, 237, frame++, tab);
        setBounds(17202, 2, 25, frame++, tab);
        setBounds(17203, 41, 25, frame++, tab);
        setBounds(17204, 76, 25, frame++, tab);
        setBounds(17205, 113, 25, frame++, tab);
        setBounds(17206, 150, 25, frame++, tab);
        setBounds(17207, 2, 65, frame++, tab);
        setBounds(17208, 41, 65, frame++, tab);
        setBounds(17209, 76, 65, frame++, tab);
        setBounds(17210, 113, 65, frame++, tab);
        setBounds(17211, 150, 65, frame++, tab);
        setBounds(17212, 2, 102, frame++, tab);
        setBounds(17213, 41, 102, frame++, tab);
        setBounds(17214, 76, 102, frame++, tab);
        setBounds(17215, 113, 102, frame++, tab);
        setBounds(17216, 150, 102, frame++, tab);
        setBounds(17217, 2, 141, frame++, tab);
        setBounds(17218, 41, 141, frame++, tab);
        setBounds(17219, 76, 141, frame++, tab);
        setBounds(17220, 113, 141, frame++, tab);
        setBounds(17221, 150, 141, frame++, tab);
        setBounds(17235, 5, 5, frame++, tab);
        setBounds(17231, 0, 237, frame++, tab);
        setBounds(17232, 0, 237, frame++, tab);
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
        hover.type = 8;
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
            model = this.method206(this.enabledMediaType, this.enabledMediaID);
        } else {
            model = this.method206(this.mediaType, this.mediaID);
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
    private static int summoningLevelRequirements[] = { 1, 4, 10, 13, 16, 17,
            18, 19, 22, 23, 25, 28, 29, 31, 32, 33, 34, 34, 34, 34, 36, 40, 41,
            42, 43, 43, 43, 43, 43, 43, 43, 46, 46, 47, 49, 52, 54, 55, 56, 56,
            57, 57, 57, 58, 61, 62, 63, 64, 66, 66, 67, 68, 69, 70, 71, 72, 73,
            74, 75, 76, 76, 77, 78, 79, 79, 79, 80, 83, 83, 85, 86, 88, 89, 92,
            93, 95, 96, 99 };
    private static int pouchItems[] = { 12047, 12043, 12059, 12019, 12009,
            12778, 12049, 12055, 12808, 12067, 12063, 12091, 12800, 12053,
            12065, 12021, 12818, 12780, 12798, 12814, 12073, 12087, 12071,
            12051, 12095, 12097, 12099, 12101, 12103, 12105, 12107, 12075,
            12816, 12041, 12061, 12007, 12035, 12027, 12077, 12531, 12810,
            12812, 12784, 12023, 12085, 12037, 12015, 12045, 12079, 12123,
            12031, 12029, 12033, 12820, 12057, 14623, 12792, 12069, 12011,
            12081, 12782, 12794, 12013, 12802, 12804, 12806, 12025, 12017,
            12788, 12776, 12083, 12039, 12786, 12089, 12796, 12822, 12093,
            12790 };
    private static int scrollItems[] = { 12425, 12445, 12428, 12459, 12533,
            12838, 12460, 12432, 12839, 12430, 12446, 12440, 12834, 12447,
            12433, 12429, 12443, 12443, 12443, 12443, 12461, 12431, 12422,
            12448, 12458, 12458, 12458, 12458, 12458, 12458, 12458, 12462,
            12829, 12426, 12444, 12441, 12454, 12453, 12463, 12424, 12835,
            12836, 12840, 12455, 12468, 12427, 12436, 12467, 12464, 12452,
            12439, 12438, 12423, 12830, 12451, 14622, 12826, 12449, 12450,
            12465, 12841, 12831, 12457, 12824, 12824, 12824, 12442, 12456,
            12837, 12832, 12466, 12434, 12833, 12437, 12827, 12828, 12435,
            12825 };
    private static String scrollNames[] = { "Howl", "Dreadfowl Strike",
            "Egg Spawn", "Slime Spray", "Stony Shell", "Pester",
            "Electric Lash", "Venom Shot", "Fireball Assault", "Cheese Feast",
            "Sandstorm", "Generate Compost", "Explode", "Vampire Touch",
            "Insane Ferocity", "Multichop", "Call of Arms", "Call of Arms",
            "Call of Arms", "Call of Arms", "Bronze Bull Rush", "Unburden",
            "Herbcall", "Evil Flames", "Petrifying gaze", "Petrifying gaze",
            "Petrifying gaze", "Petrifying gaze", "Petrifying gaze",
            "Petrifying gaze", "Petrifying gaze", "Iron Bull Rush",
            "Immense Heat", "Thieving Fingers", "Blood Drain", "Tireless Run",
            "Abyssal Drain", "Dissolve", "Steel Bull Rush", "Fish Rain",
            "Goad", "Ambush", "Rending", "Doomsphere Device", "Dust Cloud",
            "Abyssal Stealth", "Ophidian Incubation", "Poisonous Blast",
            "Mithril Bull Rush", "Toad Bark", "Testudo", "Swallow Whole",
            "Fruitfall", "Famine", "Arctic Blast", "Rise from the Ashes",
            "Volcanic Strength", "Crushing Claw", "Mantis Strike",
            "Adamant Bull Rush", "Inferno", "Deadly Claw", "Acorn Missile",
            "Titan's Consitution", "Titan's Consitution",
            "Titan's Consitution", "Regrowth", "Spike Shot", "Ebon Thunder",
            "Swamp Plague", "Rune Bull Rush", "Healing Aura", "Boil",
            "Magic Focus", "Essence Shipment", "Iron Within", "Winter Storage",
            "Steel of Legends" };
    private static String pouchNames[] = { "Spirit wolf", "Dreadfowl",
            "Spirit spider", "Thorny snail", "Granite crab", "Spirit mosquito",
            "Desert wyrm", "Spirit scorpion", "Spirit tz-kih", "Albino rat",
            "Spirit kalphite", "Compost mound", "Giant chinchompa",
            "Vampire bat", "Honey badger", "Beaver", "Void ravager",
            "Void spinner", "Void torcher", "Void shifter", "Bronze minotaur",
            "Bull ant", "Macaw", "Evil turnip", "Sp. cockatrice",
            "Sp. guthatrice", "Sp. saratrice", "Sp. zamatrice",
            "Sp. pengatrice", "Sp. coraxatrice", "Sp. vulatrice",
            "Iron minotaur", "Pyrelord", "Magpie", "Bloated leech",
            "Spirit terrorbird", "Abyssal parasite", "Spirit jelly",
            "Steel minotaur", "Ibis", "Spirit graahk", "Spirit kyatt",
            "Spirit larupia", "Karam. overlord", "Smoke devil",
            "Abyssal lurker", "Spirit cobra", "Stranger plant",
            "Mithril minotaur", "Barker toad", "War tortoise", "Bunyip",
            "Fruit bat", "Ravenous locust", "Arctic bear", "Phoenix",
            "Obsidian golem", "Granite lobster", "Praying mantis",
            "Adamant minotaur", "Forge regent", "Talon beast", "Giant ent",
            "Fire titan", "Moss titan", "Ice titan", "Hydra",
            "Spirit dagannoth", "Lava titan", "Swamp titan", "Rune minotaur",
            "Unicorn stallion", "Geyser titan", "Wolpertinger",
            "Abyssal titan", "Iron titan", "Pack yak", "Steel titan" };
}
