import com.google.common.base.Preconditions;

import java.util.List;
import java.util.function.Consumer;

public class Widget {
    public int anInt208;
    public int scrollPosition;
    public int anInt246;
    public int anInt263;
    public int anInt265;
    public boolean allowInvDraggingToOtherContainers;
    public boolean smallInvSprites;
    public boolean hideInvStackSizes;
    public boolean forceInvStackSizes;
    public boolean invAutoScrollHeight;
    public int invAutoScrollHeightOffset;
    public boolean updatesEveryInput;
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
    public byte aByte254;
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
    public String aString228;
    public boolean centerText;
    public boolean isInventoryInterface;
    public int textColor;
    public RSFont textDrawingAreas;
    public boolean usableItemInterface;
    public int secondaryColor;
    public int anInt216;
    public int anInt239;
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
    public boolean invAlwaysInfinity;
    private int anInt213 = 9;
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
        aClass12_238 = new Class12(false, 50000);
        Stream stream = new Stream(fileArchive.method571("data"), 891);
        int i = -1;
        int j = stream.readUnsignedShort();
        interfaceCache = new Widget[j + 80000];

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
                class9.aByte254 = (byte)stream.readUnsignedByte();
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
                    class9.aString228 = stream.readString();
                }

                if(class9.type == 1 || class9.type == 3 || class9.type == 4) {
                    class9.textColor = stream.readDWord();
                }

                if(class9.type == 3 || class9.type == 4) {
                    class9.secondaryColor = stream.readDWord();
                    class9.anInt216 = stream.readDWord();
                    class9.anInt239 = stream.readDWord();
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
        slayerInterface.Unpack3(aclass30_sub2_sub1_sub4);
        shopWidget(aclass30_sub2_sub1_sub4);
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
        Preconditions.checkArgument(interfaceId >= 0 && interfaceId < interfaceCache.length);
        Preconditions.checkArgument(interfaceCache[interfaceId] != null);
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
        tab.aByte254 = 0;
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
        rsinterface.aByte254 = 31;
        rsinterface.mOverInterToTrigger = -1;
        rsinterface.centerText = l;
        rsinterface.textShadow = m;
        rsinterface.textDrawingAreas = RSFont[j];
        rsinterface.message = s;
        rsinterface.aString228 = "";
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
        Tab.aByte254 = 0;
        Tab.mOverInterToTrigger = -1;
        Tab.centerText = false;
        Tab.textShadow = true;
        Tab.textDrawingAreas = wid[idx];
        Tab.message = text;
        Tab.aString228 = "";
        Tab.textColor = color;
        Tab.secondaryColor = 0;
        Tab.anInt216 = 0;
        Tab.anInt239 = 0;
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
        tab.aByte254 = 0;
        tab.mOverInterToTrigger = -1;
        tab.centerText = center;
        tab.textShadow = shadow;
        tab.textDrawingAreas = tda[idx];
        tab.message = text;
        tab.aString228 = "";
        tab.textColor = color;
        tab.secondaryColor = 0;
        tab.anInt216 = 0;
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
        tab.aByte254 = 0;
        tab.mOverInterToTrigger = -1;
        tab.centerText = center;
        tab.textShadow = shadow;
        tab.textDrawingAreas = tda[idx];
        tab.message = text;
        tab.aString228 = "";
        tab.textColor = color;
        tab.secondaryColor = 0;
        tab.anInt216 = 0;
    }

    public static void addHoverButton(int i, String imageName, int j, int width, int height, String text, int contentType, int hoverOver, int aT) {
        Widget tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = aT;
        tab.contentType = contentType;
        tab.aByte254 = 0;
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
        tab.width = 512;
        tab.height = 334;
        tab.aByte254 = 0;
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
        tab.aByte254 = 0;
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
        Widget.aByte254 = 0;
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
        tab.aByte254 = 0;
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
        rsinterface.aByte254 = 0;
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
        tab.aByte254 = 0;
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
        } else if(k == -1 && j == -1 && model.anIntArray1640 == null) {
            return model;
        } else {
            Model model_1 = new Model(9, true, Class36.method532(k, false) & Class36.method532(j, false), false, model);
            if(k != -1 || j != -1) {
                model_1.method469((byte)-71);
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
