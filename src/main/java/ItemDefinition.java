import sign.signlink;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;


final class ItemDefinition {


    public static Class12 aClass12_159 = new Class12(false, 50);
    public static boolean aBoolean182 = true;
    public static int anInt203;
    public static int frugooItems = 5;
    static Class12 aClass12_158 = new Class12(false, 100);
    private static ItemDefinition[] cache;
    private static int anInt180;
    private static Stream aStream_183;
    private static boolean aBoolean187;
    private static int[] anIntArray195;
    public int value;
    public int anInt157;
    public boolean membersObject;
    public int tertiaryFemaleEquipmentModel;
    public int certTemplateID;
    public int secondaryMaleHeadPiece;
    public String[] groundActions;
    public String name;
    public int secondaryFemaleHeadPiece;
    public boolean stackable;
    public byte[] description;
    public int certID;
    public int spriteScale;
    public int tertiaryMaleEquipmentModel;
    public String[] itemActions;
    public int spritePitch;
    public int[] stackIDs;
    public int primaryFemaleHeadPiece;
    public int spriteCameraRoll;
    public int noteable;
    public int[] stackAmounts;
    public int anInt202;
    private byte femaleTranslation;
    private int[] modifiedModelColors;
    private int[] originalModelColors;
    private boolean stockmarket;
    private int[] retextureDst;
    private int[] retextureSrc;
    private int secondaryFemaleModel;
    private int primaryMaleModel;
    private int anInt167;
    private int spriteTranslateX;
    private final int anInt171;
    public int modelId;
    private int primaryMaleHeadPiece;
    private final int anInt177;
    private int anInt184;
    private boolean aBoolean186;
    private int secondaryMaleModel;
    private int anInt191;
    private int anInt192;
    private int spriteTranslateY;
    private int anInt196;
    private int primaryFemaleModel;
    private int spriteCameraYaw;
    private byte maleTranslation;
    private boolean aBoolean206;
    private int lendID;
    private int lentItemID;
    private int anInt5735;

    ItemDefinition() {
        anInt157 = -1;
        anInt171 = 9;
        anInt177 = 9;
        aBoolean186 = false;
        aBoolean206 = false;
    }

    public static void method191(int i) {
        aClass12_159 = null;
        aClass12_158 = null;
        anIntArray195 = null;
        if (i >= 0)
            aBoolean187 = !aBoolean187;
        cache = null;
        aStream_183 = null;
    }
    public static void dumpStackableList() {
        try {
            File file = new File("stackables.dat");

            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < anInt203; i++) {
                    ItemDefinition definition = method198(i);
                    if (definition != null) {
                        writer.write(definition.anInt157 + "\t" + definition.stackable);
                        writer.newLine();
                    } else {
                        writer.write(i + "\tfalse");
                        writer.newLine();
                    }
                }
            }

            System.out.println("Finished dumping noted items definitions.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] unNoteable = {};

    public static void dumpNotes() {
        try {
            FileOutputStream out = new FileOutputStream(new File("notes.dat"));
            for (int j = 0; j < anInt203; j++) {
                ItemDefinition item = method198(j);
                        out.write(item.certID != -1 ? 0 : 1);
            }
            out.write(-1);
            out.close();
        } catch (IOException ioe) {ioe.printStackTrace();}
    }

    public static void dumpStackable() {
        try {
            FileOutputStream out = new FileOutputStream(new File("stackable.dat"));
            for (int j = 0; j < anInt203; j++) {
                ItemDefinition definition = method198(j);
                out.write(definition.stackable ? 0 : 1);
            }
            out.write(-1);
            out.close();
        } catch (IOException ioe) {ioe.printStackTrace();}
    }
    public static void dumpSellable() {
        try {
            FileOutputStream out = new FileOutputStream(new File("sellable.dat"));
            for (int j = 0; j < anInt203; j++) {
                ItemDefinition definition = method198(j);
                out.write(definition.value >= 1 ? 0 : 1);
            }
            out.write(-1);
            out.close();
        } catch (IOException ioe) {ioe.printStackTrace();}
    }
    public static void dumpNewItems() {
        for(int i = 0; i < 30000; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter("Item Dump.txt", true));
                if(class8.name != null) {
                    bw.write("<item members='true'  name='" + class8.name + "'  type='"+i+"'> </item>");
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ioe2) {
            }
        }
    }
    public static void dumpNotableList() {
        try {
            File file = new File("note_id.dat");

            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < anInt203; i++) {
                    ItemDefinition definition = method198(i);
                    if (definition != null) {
                        if (definition.certID == -1 && definition.certID != -1) {
                            writer.write(definition.anInt157 + "\t" + definition.certID);
                            writer.newLine();
                        }
                    } else {
                        writer.write(i + "\t-1");
                        writer.newLine();
                    }
                }
            }

            System.out.println("Finished dumping noted items definitions.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dumpCfg() {
        boolean delete = (new File(signlink.findcachedir() + ("/dumps/item.cfg")).delete());
        for (int i = 20085; i < 30000; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;
            String des = "";
            if (!Objects.equals(class8.name, "null")) {
                if (class8.description != null)
                    des = new String(class8.description);
                else
                    des = "Its a " + class8.name;
                try {
                    BufferedWriter bufferedwriter;
                    bufferedwriter = null;
                    BufferedWriter bufferedWriter2 = bufferedwriter = new BufferedWriter(new FileWriter(signlink.findcachedir() + ("/dumps/newitem.cfg"), true));
                    bufferedwriter.write("item = " + i + "\t" + class8.name.replace(" ", "_") + "\t" + des.replace(" ", "_") + "\t" + class8.value + "\t" + class8.value + "\t" + class8.value + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0");
                    bufferedwriter.newLine();
                    bufferedwriter.flush();
                } catch (Exception e) {
                }
            }
        }
    }

    public static void dumpItemsList() {
        for (int i = 0; i < 9200; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(signlink.findcachedir() + ("/dumps/ItemList.txt"), true));
                if (class8.name != null) {
                    bw.write("ID: " + i + "\t\tName: " + class8.name);
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ioe2) {
            }
        }
    }


    private int currentcolors;
    private int currenttextures;
    private int currentstackid;
    private int currentstackamount;
    //Start item dump
    public static void dumpItems2() {
        for(int i = 0; i < 30000; i++) {
            ItemDefinition itemDef = method198(i);
            BufferedWriter bw = null;

            try {
                itemDef.currentcolors = 0;
                itemDef.currenttextures = 0;
                itemDef.currentstackid = 0;
                itemDef.currentstackamount = 0;
                bw = new BufferedWriter(new FileWriter(signlink.findcachedir() + "/dumps/ghritemdump.txt", true));

                bw.newLine();
                bw.write("	if(i == "+i+") //ID");
                bw.newLine();
                bw.write("		{");
                bw.newLine();
                bw.write("			class8.itemActions = new String[] {"+ Arrays.toString(itemDef.itemActions)+"};");
                bw.newLine();
                bw.write("			class8.groundActions = new String[] {"+Arrays.toString(itemDef.groundActions)+"};");
                bw.newLine();
                bw.write("			class8.name = \""+itemDef.name+"\"; //Name");
                bw.newLine();
                bw.write("			class8.description = \""+itemDef.description+"\"; //Description");
                bw.newLine();
                if(itemDef.originalModelColors != null) {
                    for(int i2 = 0; i2 < itemDef.originalModelColors.length; i2++) {
                        if(i2 == 0) {
                        }
                        if(i2 != itemDef.originalModelColors.length - 1) {
                            itemDef.currentcolors += 1;
                        } else {
                            itemDef.currentcolors += 1;                         									if(itemDef.currentcolors != 0)
                            {
                                bw.write("			class8.originalModelColors = new short["+itemDef.currentcolors+"];");
                                bw.newLine();
                                bw.write("			class8.modifiedModelColors = new short["+itemDef.currentcolors+"];");
                                bw.newLine();
                            }
                            itemDef.currentcolors = 0;
                        }
                    }
                }
                if(itemDef.originalModelColors != null) {
                    for(int i2 = 0; i2 < itemDef.originalModelColors.length; i2++) {
                        if(i2 == 0) {
                        }
                        if(i2 != itemDef.originalModelColors.length - 1) {                             	bw.write("			class8.originalModelColors["+itemDef.currentcolors+"] = " +itemDef.originalModelColors[i2]+";");
                            itemDef.currentcolors += 1;
                            bw.newLine();
                        } else {                            						bw.write("			class8.originalModelColors["+itemDef.currentcolors+"] = " +itemDef.originalModelColors[i2]+";");
                            itemDef.currentcolors = 0;
                            bw.newLine();
                        }
                    }
                }
                if(itemDef.modifiedModelColors != null) {
                    for(int i2 = 0; i2 < itemDef.modifiedModelColors.length; i2++) {
                        if(i2 == 0) {
                        }
                        if(i2 != itemDef.modifiedModelColors.length - 1) {                             	bw.write("			class8.modifiedModelColors["+itemDef.currentcolors+"] = " +itemDef.modifiedModelColors[i2]+";");
                            itemDef.currentcolors += 1;
                            bw.newLine();
                        } else {                            						bw.write("			class8.modifiedModelColors["+itemDef.currentcolors+"] = " +itemDef.modifiedModelColors[i2]+";");
                            itemDef.currentcolors = 0;
                            bw.newLine();
                        }
                    }
                    if(itemDef.stackIDs != null) {
                        for(int i2 = 0; i2 < itemDef.stackIDs.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 != itemDef.stackIDs.length - 1) {
                                itemDef.currentstackid += 1;
                            } else {
                                itemDef.currentstackid += 1;
                                {
                                    bw.write("			class8.stackIDs = new int["+itemDef.currentstackid+"];");
                                    bw.newLine();
                                }
                                itemDef.currentstackid = 0;
                            }
                        }
                    }
                    if(itemDef.stackAmounts != null) {
                        for(int i2 = 0; i2 < itemDef.stackAmounts.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 != itemDef.stackAmounts.length - 1) {
                                itemDef.currentstackamount += 1;
                            } else {
                                itemDef.currentstackamount += 1;
                                {
                                    bw.write("			class8.stackAmounts = new int["+itemDef.currentstackamount+"];");
                                    bw.newLine();
                                }
                                itemDef.currentstackamount = 0;
                            }
                        }
                    }
                    if(itemDef.stackIDs != null) {
                        for(int i2 = 0; i2 < itemDef.stackIDs.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 != itemDef.stackIDs.length - 1) {                             	bw.write("			class8.stackIds["+itemDef.currentstackid+"] = " +itemDef.stackIDs[i2]+";");
                                itemDef.currentstackid += 1;
                                bw.newLine();
                            } else {                            						bw.write("			class8.stackIds["+itemDef.currentstackid+"] = " +itemDef.stackIDs[i2]+";");
                                itemDef.currentstackid = 0;
                                bw.newLine();
                            }
                        }
                    }
                    if(itemDef.stackAmounts != null) {
                        for(int i2 = 0; i2 < itemDef.stackAmounts.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 == itemDef.stackAmounts.length - 1) {                            						bw.write("			class8.stackAmounts["+itemDef.currentstackamount+"] = " +itemDef.stackAmounts[i2]+";");
                                itemDef.currentstackamount = 0;
                                bw.newLine();
                            } else {                             	bw.write("			class8.stackAmounts["+itemDef.currentstackamount+"] = " +itemDef.stackAmounts[i2]+";");
                                itemDef.currentstackamount += 1;
                                bw.newLine();
                            }
                        }
                    }
                }
                bw.write("			class8.modelId = "+itemDef.modelId+";");
                bw.newLine();
                bw.write("			class8.spriteScale = "+itemDef.spriteScale+";");
                bw.newLine();
                bw.write("			class8.spritePitch = "+itemDef.spritePitch+";");
                bw.newLine();
                bw.write("			class8.spriteCameraRoll = "+itemDef.spriteCameraRoll+";");
                bw.newLine();
                bw.write("			class8.spriteCameraYaw = "+itemDef.spriteCameraYaw+";");
                bw.newLine();
                bw.write("			class8.spriteTranslateX = "+itemDef.spriteCameraYaw +";");
                bw.newLine();
                bw.write("			class8.spriteTranslateY = "+itemDef.spriteTranslateY+";");
                bw.newLine();
                bw.write("			class8.primaryMaleModel = "+itemDef.primaryMaleModel+";");
                bw.newLine();
                bw.write("			class8.primaryFemaleModel = "+itemDef.primaryFemaleModel+";");
                bw.newLine();
                bw.write("			class8.secondaryMaleModel = "+itemDef.secondaryMaleModel+";");
                bw.newLine();
                bw.write("			class8.secondaryFemaleModel = "+itemDef.secondaryFemaleModel+";");
                bw.newLine();
                bw.write("			class8.primaryMaleHeadPiece = "+itemDef.primaryMaleHeadPiece+";");
                bw.newLine();
                bw.write("			class8.primaryFemaleHeadPiece = "+itemDef.primaryFemaleHeadPiece+";");
                bw.newLine();
                bw.write("			class8.value = "+itemDef.value+";");
                bw.newLine();
                bw.write("			class8.certID = " + itemDef.certID + ";");
                bw.newLine();
                bw.write("			class8.certTemplateID = " + itemDef.certTemplateID + ";");
                bw.newLine();
                bw.write("			class8.stackable = " + itemDef.stackable + ";");
                bw.newLine();
                bw.write("			class8.anInt202 = " + itemDef.anInt202 + ";");
                bw.newLine();
                bw.write("		}");
                bw.newLine();
                bw.newLine();
                bw.flush();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                if (bw != null) try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }

    public static void dumpItems() {
        for (int i = 0; i < anInt203; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;

            try {
                bw = new BufferedWriter(new FileWriter(signlink.findcachedir() + ("/dumps/itemdump.cfg"), true));
                bw.write("====================");
                bw.newLine();
                bw.write("Item Name: " + class8.name);
                bw.newLine();
                bw.write("Item ID: " + i);
                bw.newLine();
                if (class8.modifiedModelColors != null) {
                    for (int i2 = 0; i2 < class8.modifiedModelColors.length; i2++) {
                        if (i2 == 0) {
                            bw.write("Original model colors: ");
                        }
                        if (i2 != class8.modifiedModelColors.length - 1) {
                            bw.write(class8.modifiedModelColors[i2] + ", ");
                        } else {
                            bw.write("" + class8.modifiedModelColors[i2]);
                            bw.newLine();
                        }
                    }
                }
                if (class8.originalModelColors != null) {
                    for (int i2 = 0; i2 < class8.originalModelColors.length; i2++) {
                        if (i2 == 0) {
                            bw.write("Changed model colors: ");
                        }
                        if (i2 != class8.originalModelColors.length - 1) {
                            bw.write(class8.originalModelColors[i2] + ", ");
                        } else {
                            bw.write("" + class8.originalModelColors[i2]);
                            bw.newLine();
                        }
                    }
                }
                bw.write("class8.modelId = " + class8.modelId + ";");
                bw.newLine();
                bw.write("class8.anInt181 = " + class8.spriteScale + ";");
                bw.newLine();
                bw.write("class8.anInt190 = " + class8.spritePitch + ";");
                bw.newLine();
                bw.write("class8.anInt198 = " + class8.spriteCameraRoll + ";");
                bw.newLine();
                bw.write("class8.anInt204 = " + class8.spriteCameraYaw + ";");
                bw.newLine();
                bw.write("class8.anInt169 = " + class8.spriteTranslateX + ";");
                bw.newLine();
                bw.write("class8.anInt194 = " + class8.spriteTranslateY + ";");
                bw.newLine();
                bw.write("class8.anInt165 = " + class8.primaryMaleModel + ";");
                bw.newLine();
                bw.write("class8.anInt200 = " + class8.primaryFemaleModel + ";");
                bw.newLine();
                bw.write("class8.anInt188 = " + class8.secondaryMaleModel + ";");
                bw.newLine();
                bw.write("class8.anInt164 = " + class8.secondaryFemaleModel + ";");
                bw.newLine();
                bw.write("class8.anInt175 = " + class8.primaryMaleHeadPiece + ";");
                bw.newLine();
                bw.write("class8.anInt197 = " + class8.primaryFemaleHeadPiece + ";");
                bw.newLine();
                bw.flush();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                if (bw != null) try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }

    public static void load(FileArchive fileArchive) {
        aStream_183 = new Stream(fileArchive.method571("obj.dat"), 891);
        Stream stream = new Stream(fileArchive.method571("obj.idx"), 891);
        anInt203 = stream.readUnsignedShort();
        System.out.println("634 Items Amount: " + anInt203);
        anIntArray195 = new int[anInt203 + 20000];
        int i = 2;
        for (int j = 0; j < anInt203; j++) {
            anIntArray195[j] = i;
            i += stream.readUnsignedShort();
        }

        cache = new ItemDefinition[10];
        for (int k = 0; k < 10; k++)
            cache[k] = new ItemDefinition();
        dumpStackable();
        dumpNotes();
        //dumpItems2();
        //dumpNewItems();
        if (Configuration.dumpDataLists) {
            TempWriter writer2 = new TempWriter("item_fields");
            FieldGenerator generator = new FieldGenerator(writer2::writeLine);
            IntStream.range(0, 100_000).forEach(id -> {
                try {
                    ItemDefinition definition = ItemDefinition.method198(id);
                    generator.add(definition.name + (definition.certTemplateID != -1 ? " noted" : ""), id);
                } catch (Exception e) {
                }
            });
            writer2.close();
        }

    }
    public static ItemDefinition copy(ItemDefinition itemDef, int newId, int copyingItemId, String newName, String...actions) {
        ItemDefinition copyItemDef = method198(copyingItemId);
        itemDef.method197();
        itemDef.anInt157 = newId;
        itemDef.name = newName;
        itemDef.originalModelColors = copyItemDef.originalModelColors;
        itemDef.modifiedModelColors = copyItemDef.modifiedModelColors;
        itemDef.modelId = copyItemDef.modelId;
        itemDef.primaryMaleModel = copyItemDef.primaryMaleModel;
        itemDef.primaryFemaleModel = copyItemDef.primaryFemaleModel;
        itemDef.spriteScale = copyItemDef.spriteScale;
        itemDef.spritePitch = copyItemDef.spritePitch;
        itemDef.spriteCameraRoll = copyItemDef.spriteCameraRoll;
        itemDef.spriteTranslateX = copyItemDef.spriteTranslateX;
        itemDef.spriteTranslateY = copyItemDef.spriteTranslateY;
        itemDef.itemActions = copyItemDef.itemActions;
        itemDef.itemActions = new String[5];
        if (actions != null) {
            System.arraycopy(actions, 0, itemDef.itemActions, 0, actions.length);
        }
        return itemDef;
    }
    public static ItemDefinition method198(int i) {
        for (int j = 0; j < 10; j++)
            if (cache[j].anInt157 == i)
                return cache[j];

        anInt180 = (anInt180 + 1) % 10;
        ItemDefinition class8 = cache[anInt180];
        aStream_183.currentPosition = anIntArray195[i];
        class8.anInt157 = i;
        class8.method197();
        class8.readValues(true, aStream_183);

        switch(i){
            case 23000:
                copy(class8, 23_000, 6_542, "Resource box", "Open");
                break;
            case 23001:
                copy(class8, 23_001, 6_542, "Resource box(medium)", "Open");
                break;
            case 23002:
                copy(class8, 23_002, 6_542, "Resource box(large)", "Open");
                break;
            case 23003:
                copy(class8, 23_003, 6_542, "Resource box(huge)", "Open");
                break;
        }
        method198_2(i, class8);
        method198_3(i, class8);
        method198_4(i, class8);
        method198_5(i, class8);

        if (i == 23004) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Summon from the";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7446;//color change
            class8.originalModelColors[0] = 926;//color change 1
            class8.modelId = 8933;//itemdrop look
            class8.spriteScale = 1595;//zoom
            class8.spritePitch = 196; //rotation rotation up/down
            class8.spriteCameraRoll = 2031;//rotation left/right
            class8.spriteCameraYaw = 2047;//i think more zoom stuff
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 8932;//male weild
            class8.primaryFemaleModel = 8932;//female weild
            class8.primaryMaleHeadPiece = 2;  //offset
            class8.primaryFemaleHeadPiece = -1;  //offset
            class8.name = "Monkey Bag";
            class8.description = "Wear a monkey for FREE!".getBytes();
        }

        if(i == 25340)
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 71770;
            class8.spriteScale = 2050;
            class8.spritePitch = 222;
            class8.spriteCameraRoll = 1958;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 72130;
            class8.primaryFemaleModel = 72130;
            class8.primaryMaleHeadPiece = 0;
            class8.primaryFemaleHeadPiece = -28;
            class8.name = "Lucky Saradomin Godsword";
            class8.description = "A brutally heavy sword. Requires Attack (75).".getBytes();
        }
        if(i == 25341)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 71769; //Model ID
            class8.spriteScale = 2000;
            class8.spritePitch = 228;
            class8.spriteCameraRoll = 1985;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = 5;
            class8.primaryFemaleHeadPiece = -55;
            class8.primaryMaleModel = 72135;//male wearing
            class8.primaryFemaleModel = 72135;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Lucky Armadyl Godsword";//Name of the new item
            class8.description = "A brutally heavy sword. Requires Attack (75).".getBytes();//examin info
        }
        if (i == 28431)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 70730; //Model ID
            class8.spriteScale = 1758;
            class8.spritePitch = 512;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 70669;//male wearing
            class8.primaryFemaleModel = 70669;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Dragonbone platebody";//Name of the new item
            class8.description = "Provides excellent protection with a meaner, bonier look.".getBytes();//examin info
        }
        if (i == 27431)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 70899; //Model ID
            class8.spriteScale = 1897;
            class8.spritePitch = 520;
            class8.spriteCameraRoll = 520;
            class8.spriteCameraYaw = 1;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 70900;//male wearing
            class8.primaryFemaleModel = 70900;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Golden katana";//Name of the new item
            class8.description = "A fine blade from the Eastern Lands.".getBytes();//examin info
        }
        if (i == 25342)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 71767; //Model ID
            class8.spriteScale = 2128;
            class8.spritePitch = 243;
            class8.spriteCameraRoll = 1964;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = 0;
            class8.primaryFemaleHeadPiece = 0;
            class8.primaryMaleModel = 72138;//male wearing
            class8.primaryFemaleModel = 72138;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Lucky Zamorak Godsword";//Name of the new item
            class8.description = "A brutally heavy sword. Requires Attack (75).".getBytes();//examin info
        }
        if (i == 25343) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 71766;//item look
            class8.spriteScale = 1616;
            class8.spritePitch = 192;
            class8.spriteCameraRoll = 1161;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 72137;
            class8.primaryFemaleModel = 72137;
            class8.primaryMaleHeadPiece = -18;
            class8.primaryFemaleHeadPiece = 75;
            class8.name = "Lucky Bandos godsword";
            class8.description = "A brutally heavy sword. Requires Attack (75).".getBytes();
        }
        if(i == 25342)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 71768; //Model ID
            class8.spriteScale = 3355;
            class8.spritePitch = 512;
            class8.spriteCameraRoll = 256;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = 3;
            class8.primaryFemaleHeadPiece = -9;
            class8.primaryMaleModel = 72134;//male wearing
            class8.primaryFemaleModel = 72134;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Lucky Zamorakian spear";//Name of the new item
            class8.description = "A versatile spear wielded by agents of chaos. Requires Attack (75).".getBytes();//examin info
        }
        if(i == 25343)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 66212; //Model ID
            class8.spriteScale = 2151;
            class8.spritePitch = 636;
            class8.spriteCameraRoll = 1521;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = 0;
            class8.primaryFemaleHeadPiece = 3;
            class8.primaryMaleModel = 66272;//male wearing
            class8.primaryFemaleModel = 66272;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Lucky Saradomin sword";//Name of the new item
            class8.description = "The incredible blade of an icyene. Requires Attack (75).".getBytes();//examin info
        }
        if(i == 25344)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 66196; //Model ID
            class8.spriteScale = 840;
            class8.spritePitch = 200;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -2;
            class8.primaryFemaleHeadPiece = 56;
            class8.primaryMaleModel = 66262;//male wearing
            class8.primaryFemaleModel = 66262;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Lucky abyssal whip";//Name of the new item
            class8.description = "A weapon from the Abyss. Requires Attack (70).".getBytes();//examin info
        }
        if(i == 25345)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 79426; //Model ID
            class8.spriteScale = 2891;
            class8.spritePitch = 512;
            class8.spriteCameraRoll = 1266;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = 0;
            class8.primaryFemaleHeadPiece = 0;
            class8.primaryMaleModel = 80034;//male wearing
            class8.primaryFemaleModel = 80034;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Lucky dragon 2h sword";//Name of the new item
            class8.description = "A two-handed dragon sword.".getBytes();//examin info
        }
        if (i == 23106) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 100;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "White whip";
            class8.description = "Made By The White Knights.".getBytes();
        }

        if (i == 25111) { //lava helm
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 10394;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 6020;
            class8.originalModelColors[1] = 6020;
            class8.modelId = 6583;
            class8.spriteScale = 860;
            class8.spritePitch = 2012;
            class8.spriteCameraRoll = 188;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 17;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 6653;
            class8.primaryFemaleModel = 6687;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 6570;
            class8.primaryFemaleHeadPiece = 6575;
            class8.name = "Ivandis helm";
            class8.description = "It's a Ivandis helm".getBytes();
        }
        if (i == 30139)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 43072;
            class8.originalModelColors[0] = 925;
            class8.modifiedModelColors[1] = 4550;
            class8.originalModelColors[1] = 925;
            class8.modelId = 14148; //Model ID
            class8.spriteScale = 1330; //zoom increase will make it smaller
            class8.spritePitch = 310; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 1800; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = 0; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.primaryMaleModel = 14147;//male wearing
            class8.primaryFemaleModel = 14146;//female wearing
            class8.secondaryFemaleModel = 14146;//Female arms/sleeves
            class8.secondaryMaleModel = 14147;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Torva platebody";//Name of the new item
            class8.description = "Provides excellent protection".getBytes();//examin info
        }
        if (i == 30143) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14150;
            class8.primaryMaleModel = 10110;
            class8.primaryFemaleModel = 14149;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.spriteScale = 2151;
            class8.spritePitch = 429;
            class8.spriteCameraRoll = 1189;
            class8.spriteTranslateY = 5;
            class8.name = "Torva platelegs";
            class8.description = "A pair of Torva platelegs".getBytes();
        }
        if (i == 28358)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 43072;
            class8.originalModelColors[0] = 925;
            class8.modifiedModelColors[1] = 4550;
            class8.originalModelColors[1] = 925;
            class8.modelId = 74148; //Model ID
            class8.spriteScale = 1330; //zoom increase will make it smaller
            class8.spritePitch = 310; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 1800; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = 0; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.primaryMaleModel = 74147;//male wearing
            class8.primaryFemaleModel = 74146;//female wearing
            class8.secondaryFemaleModel = 74146;//Female arms/sleeves
            class8.secondaryMaleModel = 74147;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Ice Torva platebody";//Name of the new item
            class8.description = "Provides excellent protection".getBytes();//examin info
        }
        if (i == 28359) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 74150;
            class8.primaryMaleModel = 70110;
            class8.primaryFemaleModel = 74149;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.spriteScale = 2151;
            class8.spritePitch = 429;
            class8.spriteCameraRoll = 1189;
            class8.spriteTranslateY = 5;
            class8.name = "Ice Torva platelegs";
            class8.description = "A pair of Ice Torva platelegs".getBytes();
        }
        if (i == 30137) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 14153;//item look
            class8.spriteScale = 700;
            class8.spritePitch = 1100;
            class8.spriteCameraRoll = 650;
            class8.spriteCameraYaw = 1148;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = -25;
            class8.primaryMaleModel = 14151;
            class8.primaryFemaleModel = 14152;
            class8.name = "Torva full helm ";
            class8.description = "A ancient warior's full helm.".getBytes();
        }

        if (i == 25107) { //ladies legs
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 62920;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 62928;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.modelId = 5026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ladies Platelegs";
            class8.description = "Ladies platelegs".getBytes();
        }


        if (i == 25112) { //ivandis legs
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 26667;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.modelId = 5026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ivandis Platelegs";
            class8.description = "Stride through enemies territory in a heart beat.".getBytes();
        }
        if (i == 25109) { //ladies helm
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 10394;
            class8.originalModelColors[0] = 62928;
            class8.modifiedModelColors[1] = 6020;
            class8.originalModelColors[1] = 6020;
            class8.modelId = 6583;
            class8.spriteScale = 860;
            class8.spritePitch = 2012;
            class8.spriteCameraRoll = 188;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 17;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 6653;
            class8.primaryFemaleModel = 6687;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 6570;
            class8.primaryFemaleHeadPiece = 6575;
            class8.name = "Ladies Helm";
            class8.description = "It's a Ladies helm".getBytes();
        }

        if (i == 25113) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 10283;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 10270;
            class8.originalModelColors[1] = 24648;
            class8.modifiedModelColors[2] = 3326;
            class8.originalModelColors[2] = 24640;
            class8.modelId = 8700;
            class8.spriteScale = 710;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 2000;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 2;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 8726;
            class8.primaryFemaleModel = 8750;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ivandis Gauntlets";
            class8.description = "Ivandis Gauntlets.".getBytes();
        }
        if (i == 25215) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 8741;
            class8.originalModelColors[0] = 924;
            class8.modifiedModelColors[1] = 14490;
            class8.originalModelColors[1] = 921;
            class8.modelId = 6578;
            class8.spriteScale = 1250;
            class8.spritePitch = 468;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = 6669;
            class8.primaryFemaleModel = 6697;
            class8.secondaryMaleModel = 170;
            class8.secondaryFemaleModel = 348;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Draconic Top";
            class8.description = "A draconic Ahrims top.".getBytes();
        }
        if (i == 25216) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 14490;
            class8.originalModelColors[0] = 924;
            class8.modifiedModelColors[1] = 45468;
            class8.originalModelColors[1] = 921;
            class8.modelId = 6577;
            class8.spriteScale = 1730;
            class8.spritePitch = 504;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 6659;
            class8.primaryFemaleModel = 6691;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Draconic Bottoms";
            class8.description = "A draconic Ahrims bottoms.".getBytes();
        }
        if (i == 25217) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 8741;
            class8.originalModelColors[0] = 924;
            class8.modelId = 5419;
            class8.spriteScale = 730;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 2036;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 5430;
            class8.primaryFemaleModel = 5435;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 5428;
            class8.primaryFemaleHeadPiece = 5429;
            class8.name = "Draconic Hood";
            class8.description = "A draconic Ahrims Hood.".getBytes();
        }
        if (i == 25234) // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 28;
            class8.modifiedModelColors[0] = 74;
            class8.originalModelColors[0] = 38676;
            class8.originalModelColors[0] = 760;
            class8.modelId = 5139;
            class8.spriteScale = 490;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 192;
            class8.spriteCameraYaw = 138;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 5114;//male wearing 15413
            class8.primaryFemaleModel = 5114;//female wearing 15413
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Slayer Sword";
            class8.description = "A Slayer sword by thedragon.".getBytes();
        }
        if (i == 25106) {//ladies gaunts
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 10283;
            class8.originalModelColors[0] = 62928;
            class8.modifiedModelColors[1] = 10270;
            class8.originalModelColors[1] = 62928;
            class8.modifiedModelColors[2] = 3326;
            class8.originalModelColors[2] = 62928;
            class8.modelId = 8700;
            class8.spriteScale = 710;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 2000;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 2;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 8726;
            class8.primaryFemaleModel = 8750;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ladies Gauntlets";
            class8.description = "Ladies Gauntlets.".getBytes();
        }
        if (i == 25118) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 153;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 278;
            class8.primaryFemaleModel = 278;
            class8.primaryMaleHeadPiece = 0;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon tail";
            class8.description = "A demon tail.".getBytes();
        }

        if (i == 25119) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 153;
            class8.spriteScale = 760;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 28;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 242;
            class8.primaryFemaleModel = 242;
            class8.primaryMaleHeadPiece = 0;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Horns #1";
            class8.description = "Horns of a demon.".getBytes();
        }

        if (i == 25120) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 153;
            class8.spriteScale = 760;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 28;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 239;
            class8.primaryFemaleModel = 239;
            class8.primaryMaleHeadPiece = 0;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Horns #2";
            class8.description = "Horns of a demon.".getBytes();
        }

        if (i == 25121) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 153;
            class8.spriteScale = 760;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 28;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 229;
            class8.primaryFemaleModel = 229;
            class8.primaryMaleHeadPiece = 0;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Head";
            class8.description = "The head of a demon.".getBytes();
        }

        if (i == 25122) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 153;
            class8.spriteScale = 770;
            class8.spritePitch = 152;
            class8.spriteCameraRoll = 160;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -6;
            class8.primaryMaleModel = 182;
            class8.primaryFemaleModel = 182;
            class8.primaryMaleHeadPiece = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Feet";
            class8.description = "The feet of a demon.".getBytes();
        }

        if (i == 25123) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 153;
            class8.spriteScale = 770;
            class8.spritePitch = 152;
            class8.spriteCameraRoll = 160;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -6;
            class8.primaryMaleModel = 180;
            class8.primaryFemaleModel = 180;
            class8.primaryMaleHeadPiece = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Hands";
            class8.description = "The hands of a demon.".getBytes();
        }
        if (i == 25114) { //ivandis chain
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.modifiedModelColors[0] = 914;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 918;
            class8.originalModelColors[1] = 24648;
            class8.modifiedModelColors[2] = 922;
            class8.originalModelColors[2] = 24640;
            class8.modifiedModelColors[3] = 391;
            class8.originalModelColors[3] = 26706;
            class8.modifiedModelColors[4] = 917;
            class8.originalModelColors[4] = 24648;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 3820;
            class8.primaryFemaleModel = 3821;
            class8.modelId = 3823;
            class8.secondaryMaleModel = 156;
            class8.secondaryFemaleModel = 337;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ivandis Chainmail";
            class8.description = "Its a Ivandis Chain".getBytes();
        }

        if (i == 25115) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 26706;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ivandis Boots";
            class8.description = "Ivandis boots".getBytes();
        }

        if (i == 25105) { //ladies chain
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.modifiedModelColors[0] = 914;
            class8.originalModelColors[0] = 62928;
            class8.modifiedModelColors[1] = 918;
            class8.originalModelColors[1] = 62931;
            class8.modifiedModelColors[2] = 922;
            class8.originalModelColors[2] = 62928;
            class8.modifiedModelColors[3] = 391;
            class8.originalModelColors[3] = 62930;
            class8.modifiedModelColors[4] = 917;
            class8.originalModelColors[4] = 62928;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 3820;
            class8.primaryFemaleModel = 3821;
            class8.modelId = 3823;
            class8.secondaryMaleModel = 156;
            class8.secondaryFemaleModel = 337;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ladies Chainmail";
            class8.description = "Its a Ladies Chain".getBytes();
        }

        if (i == 25104) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 62928;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 62928;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 62928;
            class8.modelId = 5198;//Drop model & inv model
            class8.spriteScale = 1900;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 500;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5196;//female wearing
            class8.primaryMaleModel = 5196;//male wearing
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ladies shield";
            class8.description = "Ladies shield".getBytes();
        }


        if (i == 25103) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 62929;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ladies Boots";
            class8.description = "Ladies boots".getBytes();
        }
        if (i == 25102) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 62928;
            class8.modifiedModelColors[1] = 935;
            class8.originalModelColors[1] = 62930;
            class8.modelId = 6033;//Item Look
            class8.spriteScale = 980;
            class8.spritePitch = 350;
            class8.spriteCameraRoll = 1020;
            class8.spriteCameraYaw = 324;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 6031;
            class8.primaryFemaleModel = 6031;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ladies Blade";
            class8.description = "".getBytes();
        }

        if (i == 23109) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 43968;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 5198;//Drop model & inv model
            class8.spriteScale = 1900;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 500;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5196;//female wearing
            class8.primaryMaleModel = 5196;//male wearing
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Crystal shield";
            class8.description = "Blue Crystal shield".getBytes();
        }

        if (i == 25203) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 43968;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 3902;//Drop model & inv model
            class8.spriteScale = 1570;
            class8.spritePitch = 192;
            class8.spriteCameraRoll = 76;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5197;//female wearing
            class8.primaryMaleModel = 5197;//male wearing
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Crystal shield";
            class8.description = "Blue Crystal shield".getBytes();
        }

        if (i == 25116) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 24648;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 24640;
            class8.modelId = 5198;//Drop model & inv model
            class8.spriteScale = 1900;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 500;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5196;//female wearing
            class8.primaryMaleModel = 5196;//male wearing
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ivandis shield";
            class8.description = "Ivandis shield".getBytes();
        }

        if (i == 25117) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 935;
            class8.originalModelColors[1] = 24648;
            class8.modelId = 6033;//Item Look
            class8.spriteScale = 980;
            class8.spritePitch = 350;
            class8.spriteCameraRoll = 1020;
            class8.spriteCameraYaw = 324;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 6031;
            class8.primaryFemaleModel = 6031;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ivandis Blade";
            class8.description = "Show no mercy, led anger rule your fury.".getBytes();
        }
        if (i == 23115) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 128;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 128;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 128;
            class8.modelId = 5198;//Drop model & inv model
            class8.spriteScale = 1900;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 500;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5196;//female wearing
            class8.primaryMaleModel = 5196;//male wearing
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Crystal shield";
            class8.description = "Black Crystal shield".getBytes();
        }
        if (i == 23117) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; //this is the new option to equipt, can change to w/e u want
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;  //original color
            class8.originalModelColors[0] = 0; //changed color
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Black h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 23118) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; //this is the new option to equipt, can change to w/e u want
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;  //original color
            class8.originalModelColors[0] = 11200; //changed color
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Yellow h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }

        if (i == 12365) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; //t
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 22416;  //original color
            class8.originalModelColors[0] = 11200; //changed color
            class8.modifiedModelColors[1] = 22424;  //original color
            class8.originalModelColors[1] = 11200; //changed color
            class8.modelId = 2745;
            class8.spriteScale = 1030;
            class8.spritePitch = 548;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 314;
            class8.primaryFemaleModel = 477;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Yellow d'hide body";
            class8.description = "really a yellow d'hide body".getBytes();
        }

        if (i == 23094)    //WH1P!!!!
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; //this is the new option to equipt, can change to w/e u want
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;  //original color
            class8.originalModelColors[0] = 36133; //changed color
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Whip";
            class8.description = "A whip made of Rune".getBytes();
        }

        if (i == 24632) { //Black Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 3196;
            class8.spriteScale = 1370;
            class8.spritePitch = 204;
            class8.spriteCameraRoll = 804;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3189;
            class8.primaryFemaleModel = 3194;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ice Cape";
            class8.description = "It's Black Platelegs (B)".getBytes();
        }

        if (i == 23091) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            //Purple: 926-127
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 128;
            class8.modelId = 2635;//Item Look
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Black Party Hat";
            class8.description = "A nice hat from a cracker.".getBytes();
        }
        if (i == 24090) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 51136;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Purple santa hat ";
            class8.description = "Purple santa hat.".getBytes();
        }
        if (i == 12322) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 35321;
            class8.modifiedModelColors[1] = 35321;
            class8.originalModelColors[1] = 35321;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "sky santa hat ";
            class8.description = "Sky santa hat.".getBytes();
        }
        if (i == 24091) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 6;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Black santa hat ";
            class8.description = "Black santa hat.".getBytes();
        }

        if (i == 24092) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Mithril santa hat ";
            class8.description = "Mithril santa hat.".getBytes();
        }

        if (i == 24093) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Rune santa hat ";
            class8.description = "Rune santa hat.".getBytes();
        }

        if (i == 24094) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 1000;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Dragon santa hat ";
            class8.description = "Dragon santa hat.".getBytes();
        }

        if (i == 24095) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Addy santa hat ";
            class8.description = "Addy santa hat.".getBytes();
        }

        if (i == 24096) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 7114;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Gold santa hat ";
            class8.description = "Gold santa hat.".getBytes();
        }

        if (i == 24097) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 10394;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Barrows santa hat ";
            class8.description = "Barrows santa hat.".getBytes();
        }

        if (i == 24098) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 43968;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7097;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Blue santa hat ";
            class8.description = "Blue santa hat.".getBytes();
        }

        if (i == 25095) //Replace with the id you want
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 14623; //Model ID
            class8.spriteScale = 800; //1200 zoom increase will make it smaller
            class8.spritePitch = 572; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 0; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = 0; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.primaryMaleModel = 14623;//male wearing
            class8.primaryFemaleModel = 14623;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Winged Sandals";//Name of the new item
            class8.description = "Apollo's gift.".getBytes();//examine info
        }
        if (i == 27885) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 14045;
            class8.spriteScale = 2000;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteTranslateX = 25;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14046;
            class8.primaryFemaleModel = 14046;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Bandos whip";
            class8.description = "A whip from the warchief Graardor".getBytes();
        }
        if (i == 24100) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 6073;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Orange Whip";
            class8.description = "a Orange Whip".getBytes();
        }

        if (i == 24101) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 51136;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Purple Whip";
            class8.description = "a Purple Whip".getBytes();
        }

        if (i == 24102) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 25;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Unknown Color Whip";
            class8.description = "a Unknown Color Whip".getBytes();
        }

        if (i == 24103) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 950;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Red Whip";
            class8.description = "a Red Whip".getBytes();
        }

        if (i == 24104) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 43968;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Whip";
            class8.description = "a Blue Whip".getBytes();
        }

        if (i == 24105) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 10394;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Barrows Whip";
            class8.description = "a Barrows Whip".getBytes();
        }

        if (i == 24106) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 7114;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gold Whip";
            class8.description = "a Gold Whip".getBytes();
        }
        if (i == 24107) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 100;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "White Whip";
            class8.description = "a White Whip".getBytes();
        }

        if (i == 25000) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 924;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dragon Whip";
            class8.description = "It Is a Dragon Whip if ur rich its for u!".getBytes();
        }

        if (i == 25001) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "die!";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 0;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Death Whip";
            class8.description = "omfg its a death whip!".getBytes();
        }

        if (i == 28000) { //black phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 0;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Black Party Hat";
            class8.description = "An Black Party Hat.".getBytes();
        }

        if (i == 24109) { //orange phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 6073;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Orange Party Hat";
            class8.description = "An Orange Party Hat.".getBytes();
        }

        if (i == 24110) { //Gold phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 8128;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Gold Party Hat";
            class8.description = "A Gold Party Hat.".getBytes();
        }

        if (i == 24111) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 50;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Grey Party Hat";
            class8.description = "A Grey Party Hat.".getBytes();
        }

        if (i == 24112) { //Bronze phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 5652;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Bronze Party Hat";
            class8.description = "A Bronze Party Hat.".getBytes();
        }

        if (i == 24113) { //Steel phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 41;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Steel Party Hat";
            class8.description = "A Steel Party Hat.".getBytes();
        }

        if (i == 24114) { //Mithril phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 43297;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Mithril Party Hat";
            class8.description = "A Mithril Party Hat.".getBytes();
        }
        if (i == 25090) { //Mithril phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "look at";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 586;
            class8.originalModelColors[0] = 43297;
            class8.modelId = 546;
            class8.spriteScale = 654;
            class8.spritePitch = 852;
            class8.spriteCameraRoll = 36;
            class8.spriteCameraYaw = 85;
            class8.spriteTranslateX = 8745;
            class8.spriteTranslateY = 5487;
            class8.primaryMaleModel = 9856;
            class8.primaryFemaleModel = 8547;
            class8.primaryMaleHeadPiece = 2103;
            class8.primaryFemaleHeadPiece = 8956;
            class8.name = "rum deal";
            class8.description = "omfg its the rum deal thingy.".getBytes();
        }
        if (i == 24115) { //Adamant phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 21662;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Adamant Party Hat";
            class8.description = "An Addy Party Hat.".getBytes();
        }

        if (i == 24116) { //Rune phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 36133;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Rune Party Hat";
            class8.description = "A Rune Party Hat.".getBytes();
        }

        if (i == 24117) { //Dragon phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 924;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Dragon Party Hat";
            class8.description = "A Dragon Party Hat.".getBytes();
        }

        if (i == 24118) { //Barrows phat
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 10388;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Barrows Party Hat";
            class8.description = "A Party Hat worn by the Barrows Brothers.".getBytes();
        }

        if (i == 24119) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 22464;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Green Whip";
            class8.description = "a Green Whip".getBytes();
        }
        if (i == 12345) // Your desired item id (the one you use after ::pickup ##### #)
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; // String name, this can be changed to wield, or attach, or whatever you want
            class8.modelId = 12122; // Drop/Inv Model
            class8.primaryMaleModel = 12121; // Male Wield Model
            class8.primaryFemaleModel = 12121; // Female Wield
            class8.secondaryMaleModel = -1; // Male arms/sleeves (Leave as -1 if not used)
            class8.secondaryFemaleModel = -1; // Female arms/sleeves (Leave as -1 if not used)
            class8.spriteScale = 800; // Zoom - Increase to make inv model smaller
            class8.spritePitch = 498; // Rotate up/down -  Increase to rotate upwards
            class8.spriteCameraRoll = 1300; // Rotate right/left - Increase to rotate right
            class8.spriteTranslateX = -1; // Position in inv, increase to move right
            class8.spriteTranslateY = -1; // Position in inv, increase to move up\t
            class8.name = "Bandos Cape"; // Item Name
            class8.description = "The Legendary God Cape".getBytes(); // Item Examine
        }
        if (i == 23119) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.modelId = 3288;
            class8.spriteScale = 2000;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = 1;
            class8.spriteCameraYaw = 14;
            class8.primaryMaleModel = 3287;
            class8.primaryFemaleModel = 3287;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;
            class8.name = "Death Cape";
            class8.description = "Death Cape made by death! ".getBytes();
        }


        if (i == 23603) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 28;
            class8.modifiedModelColors[0] = 74;
            class8.originalModelColors[0] = 10512;
            class8.originalModelColors[0] = 10512;
            class8.modelId = 4671;
            class8.spriteScale = 490;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 192;
            class8.spriteCameraYaw = 138;
            class8.noteable = -1;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 4672;
            class8.primaryFemaleModel = 4672;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Barrows defender";
            class8.description = "A defensive weapon.".getBytes();
        }

        if (i == 24571) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 32465;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 64449;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.modelId = 5026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mod Sgs Platelegs";
            class8.description = "A set of Mod Sgs's platelegs.".getBytes();
        }
        if (i == 23172) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 12234;
            class8.spriteScale = 1100;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 550;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12233;
            class8.primaryFemaleModel = 12233;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bandos C'Bow";
            class8.description = "A great bow, used by the best warriors.".getBytes();
        }
        if (i == 23173) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 13421;
            class8.spriteScale = 1100;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 550;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 13422;
            class8.primaryFemaleModel = 13422;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Dragon C'Bow";
            class8.description = "A powerful and rare crossbow".getBytes();
        }
        if (i == 23015) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9226;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9233;
            class8.primaryFemaleModel = 9233;
            class8.name = "Death Cape (blue)";
            class8.description = "Its A Death Cape (blue)".getBytes();
        }
        if (i == 23014) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9232;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9231;
            class8.primaryFemaleModel = 9231;
            class8.name = "Death Cape (green)";
            class8.description = "Its A Death Cape (green)".getBytes();
        }
        if (i == 23013) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9230;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9229;
            class8.primaryFemaleModel = 9229;
            class8.name = "Death Cape (sky)";
            class8.description = "Its A Death Cape (sky)".getBytes();
        }
        if (i == 23012) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9228;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9227;
            class8.primaryFemaleModel = 9227;
            class8.name = "Mod Sgs Death Cape";
            class8.description = "Its Mod Sgs's Death cape".getBytes();
        }
        if (i == 12312) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 6073;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Orange cavalier";
            class8.description = "a Orange cavalier".getBytes();
        }
        if (i == 12313) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 51136;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Purple cavalier";
            class8.description = "a Purple cavalier".getBytes();
        }
        if (i == 12314) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 25;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Unknown Color cavalier";
            class8.description = "a Unknown Color cavalier".getBytes();
        }
        if (i == 12315) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 950;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Red cavalier";
            class8.description = "a Red cavalier".getBytes();
        }

        if (i == 26030) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 8245;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 8245;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Dark Gray santa hat ";
            class8.description = "Dark Gray santa hat.".getBytes();
        }
        if (i == 26031) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 18105;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 18105;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Lime Green santa hat ";
            class8.description = "Lime Green santa hat.".getBytes();
        }
        if (i == 26032) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 45549;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 45549;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Unknowed White santa hat ";
            class8.description = "Unknowed White santa hat.".getBytes();
        }
        if (i == 26033) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 50971;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 50971;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Deep Purple santa hat ";
            class8.description = "Deep Purple santa hat.".getBytes();
        }
        if (i == 26034) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 60176;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 60176;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Deeper Purple santa hat ";
            class8.description = "Deeper Purple santa hat.".getBytes();
        }
        if (i == 26035) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 19213;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 19213;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Deep Green santa hat ";
            class8.description = "Deep Green santa hat.".getBytes();
        }
        if (i == 26035) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 3654;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 3654;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Dull Orange santa hat ";
            class8.description = "Dull Orange santa hat.".getBytes();
        }
        if (i == 26036) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 12904;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 12904;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Bright Yellow santa hat ";
            class8.description = "Bright Yellow santa hat.".getBytes();
        }
        if (i == 26037) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 618;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 618;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Bright Pink santa hat ";
            class8.description = "Bright Pink santa hat.".getBytes();
        }
        if (i == 26038) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 46440;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 46440;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Bright Blue santa hat ";
            class8.description = "Bright Blue santa hat.".getBytes();
        }
        if (i == 26039) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 11378;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 11378;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Bright Gray santa hat ";
            class8.description = "Bright Gray santa hat.".getBytes();
        }
        if (i == 26040) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 36207;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 36207;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Bright Sky Blue santa hat ";
            class8.description = "Bright Sky Blue santa hat.".getBytes();
        }
        if (i == 26041) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 32562;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 32562;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Teal santa hat ";
            class8.description = "Teal santa hat.".getBytes();
        }
        if (i == 26042) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 8245;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 8245;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Dark Gray santa hat ";
            class8.description = "Dark Gray santa hat.".getBytes();
        }

        if (i == 25612) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 32984;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Diamond Whip";
            class8.description = "a Diamond Whip".getBytes();
        }


        if (i == 25613) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 33;
            class8.originalModelColors[0] = 32984;
            class8.modifiedModelColors[1] = 49;
            class8.originalModelColors[1] = 32984;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 32984;
            class8.modelId = 2558;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 301;
            class8.primaryFemaleModel = 464;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Diamond chainbody";
            class8.description = "a Diamond chainbody".getBytes();
        }

        if (i == 25614) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 24;
            class8.originalModelColors[0] = 32984;
            class8.modifiedModelColors[1] = 61;
            class8.originalModelColors[1] = 32984;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 32984;
            class8.modelId = 2605;
            class8.spriteScale = 1250;
            class8.spritePitch = 488;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 306;
            class8.primaryFemaleModel = 468;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Diamond Platebody";
            class8.description = "a Diamond Platebody".getBytes();
        }

        if (i == 25615) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 32984;
            class8.modelId = 2833;
            class8.spriteScale = 640;
            class8.spritePitch = 108;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 219;
            class8.primaryFemaleModel = 395;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 57;
            class8.primaryFemaleHeadPiece = 117;
            class8.name = "Diamond Med Helm";
            class8.description = "a Diamond Med Helm".getBytes();
        }

        if (i == 25616) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 32984;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 48030;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Diamond full Helm";
            class8.description = "a Diamond full Helm".getBytes();
        }

        if (i == 25617) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 32984;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 32984;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 32984;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Diamond Platelegs";
            class8.description = "a Diamond platelegs".getBytes();
        }

        if (i == 24343) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 10394;
            class8.originalModelColors[0] = 6069;
            class8.modifiedModelColors[1] = 6020;
            class8.originalModelColors[1] = 6020;
            class8.modelId = 6583;
            class8.spriteScale = 860;
            class8.spritePitch = 2012;
            class8.spriteCameraRoll = 188;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 17;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 6653;
            class8.primaryFemaleModel = 6687;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 6570;
            class8.primaryFemaleHeadPiece = 6575;
            class8.name = "Lava Helm";
            class8.description = "It's a Lava helm".getBytes();
        }
        if (i == 24338) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 6072;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 6054;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.modelId = 5026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lava Platelegs";
            class8.description = "Lava platelegs".getBytes();
        }
        if (i == 24342) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 10283;
            class8.originalModelColors[0] = 6069;
            class8.modifiedModelColors[1] = 10270;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 3326;
            class8.originalModelColors[2] = 6074;
            class8.modelId = 8700;
            class8.spriteScale = 710;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 2000;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 2;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 8726;
            class8.primaryFemaleModel = 8750;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lava Gauntlets";
            class8.description = "Lava Gauntlets.".getBytes();
        }
        if (i == 24339) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.modifiedModelColors[0] = 914;
            class8.originalModelColors[0] = 6070;
            class8.modifiedModelColors[1] = 918;
            class8.originalModelColors[1] = 6070;
            class8.modifiedModelColors[2] = 922;
            class8.originalModelColors[2] = 6071;
            class8.modifiedModelColors[3] = 391;
            class8.originalModelColors[3] = 6070;
            class8.modifiedModelColors[4] = 917;
            class8.originalModelColors[4] = 6069;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 3820;
            class8.primaryFemaleModel = 3821;
            class8.modelId = 3823;
            class8.secondaryMaleModel = 156;
            class8.secondaryFemaleModel = 337;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lava Chainmail";
            class8.description = "It's a Lava Chain".getBytes();
        }
        if (i == 24340) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 6073;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 6069;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 6069;
            class8.modelId = 5198;
            class8.spriteScale = 1900;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 500;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5196;
            class8.primaryMaleModel = 5196;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lava shield";
            class8.description = "Lava shield".getBytes();
        }
        if (i == 24341) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 6073;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lava Boots";
            class8.description = "Lava boots".getBytes();
        }
        if (i == 24243) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 10394;
            class8.originalModelColors[0] = -22221;
            class8.modifiedModelColors[1] = 6020;
            class8.originalModelColors[1] = -22221;
            class8.modelId = 6583;
            class8.spriteScale = 860;
            class8.spritePitch = 2012;
            class8.spriteCameraRoll = 188;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 17;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 6653;
            class8.primaryFemaleModel = 6687;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 6570;
            class8.primaryFemaleHeadPiece = 6575;
            class8.name = "Blue Dragon Helm";
            class8.description = "It's a Blue Dragon helm".getBytes();
        }
        if (i == 24238) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = -22221;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = -22221;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.modelId = 5026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Dragon Platelegs";
            class8.description = "Blue Dragon platelegs".getBytes();
        }
        if (i == 24242) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 10283;
            class8.originalModelColors[0] = -22221;
            class8.modifiedModelColors[1] = 10270;
            class8.originalModelColors[1] = -22221;
            class8.modifiedModelColors[2] = 3326;
            class8.originalModelColors[2] = -22221;
            class8.modelId = 8700;
            class8.spriteScale = 710;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 2000;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 2;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 8726;
            class8.primaryFemaleModel = 8750;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Dragon Gauntlets";
            class8.description = "Blue Dragon Gauntlets.".getBytes();
        }
        if (i == 24239) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.modifiedModelColors[0] = 914;
            class8.originalModelColors[0] = -22221;
            class8.modifiedModelColors[1] = 918;
            class8.originalModelColors[1] = -22221;
            class8.modifiedModelColors[2] = 922;
            class8.originalModelColors[2] = -22221;
            class8.modifiedModelColors[3] = 391;
            class8.originalModelColors[3] = -22221;
            class8.modifiedModelColors[4] = 917;
            class8.originalModelColors[4] = -22221;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 3820;
            class8.primaryFemaleModel = 3821;
            class8.modelId = 3823;
            class8.secondaryMaleModel = 156;
            class8.secondaryFemaleModel = 337;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Dragon chainbody";
            class8.description = "It's a Blue Dragon Chain".getBytes();
        }
        if (i == 24240) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 43127;
            class8.originalModelColors[0] = 43968;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 36975;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 5198;
            class8.spriteScale = 1900;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 500;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryFemaleModel = 5196;
            class8.primaryMaleModel = 5196;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue shield";
            class8.description = "Blue shield".getBytes();
        }
        if (i == 24241) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43968;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue Boots";
            class8.description = "Blue boots".getBytes();
        }


        if (i == 25712) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43968;
            class8.modelId = 2373;
            class8.spriteScale = 1180;
            class8.spritePitch = 300;
            class8.spriteCameraRoll = 1120;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = 4;
            class8.primaryMaleModel = 490;
            class8.primaryFemaleModel = 490;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue scimitar";
            class8.description = "a Blue scimitar".getBytes();
        }

        if (i == 12316) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 10394;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Barrows cavalier";
            class8.description = "a Barrows cavalier".getBytes();
        }
        if (i == 12317) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 7114;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Gold cavalier";
            class8.description = "a Gold cavalier".getBytes();
        }
        if (i == 12318) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 100;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "White cavalier";
            class8.description = "a White cavalier".getBytes();
        }
        if (i == 12319) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 924;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Dragon cavalier";
            class8.description = "a Dragon cavalier".getBytes();
        }
        if (i == 23482) { //Black Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platelegs (G)";
            class8.description = "It's Steel Platelegs (G)".getBytes();
        }
        if (i == 23483) { //Black Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43072;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platebody (G)";
            class8.description = "It's a Steel Platebody (G)".getBytes();
        }
        if (i == 23484) { //Black Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Steel Helm (G)";
            class8.description = "It's a Steel Helm (G)".getBytes();
        }
        if (i == 23485) { //Black Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Kiteshield (G)";
            class8.description = "It's a Steel Kiteshield (G)".getBytes();
        }
        if (i == 23486) { //Black Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platelegs (W)";
            class8.description = "It's Steel Platelegs (W)".getBytes();
        }
        if (i == 23487) { //Black Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43072;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platebody (W)";
            class8.description = "It's a Steel Platebody (W)".getBytes();
        }
        if (i == 23488) { //Black Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Steel Helm (W)";
            class8.description = "It's a Steel Helm (W)".getBytes();
        }
        if (i == 23489) { //Black Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Kiteshield (W)";
            class8.description = "It's a Steel Kiteshield (W)".getBytes();
        }
        if (i == 23490) { //Black Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platelegs (B)";
            class8.description = "It's Steel Platelegs (B)".getBytes();
        }
        if (i == 23491) { //Black Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43072;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platebody (B)";
            class8.description = "It's a Steel Platebody (B)".getBytes();
        }
        if (i == 23492) { //Black Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Steel Helm (B)";
            class8.description = "It's a Steel Helm (B)".getBytes();
        }
        if (i == 23493) { //Black Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Kiteshield (B)";
            class8.description = "It's a Steel Kiteshield (B)".getBytes();
        }
        if (i == 23494) { //Steel Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platelegs (O)";
            class8.description = "It's Steel Platelegs (O)".getBytes();
        }
        if (i == 23495) { //Steel Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43072;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platebody (O)";
            class8.description = "It's a Steel Platebody (O)".getBytes();
        }
        if (i == 23496) { //Steel Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Steel Helm (O)";
            class8.description = "It's a Steel Helm (O)".getBytes();
        }
        if (i == 23497) { //Steel Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Kiteshield (O)";
            class8.description = "It's a Steel Kiteshield (O)".getBytes();
        }
        if (i == 23498) { //Steel Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platelegs (P)";
            class8.description = "It's Steel Platelegs (P)".getBytes();
        }
        if (i == 23499) { //Steel Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43072;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Platebody (P)";
            class8.description = "It's a Steel Platebody (P)".getBytes();
        }
        if (i == 23500) { //Steel Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Steel Helm (P)";
            class8.description = "It's a Steel Helm (P)".getBytes();
        }
        if (i == 23501) { //Steel Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Kiteshield (P)";
            class8.description = "It's a Steel Kiteshield (P)".getBytes();
        }
        if (i == 23502) { //Mith Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platelegs (G)";
            class8.description = "It's Mith Platelegs (G)".getBytes();
        }
        if (i == 23503) { //Mith Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43297;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platebody (G)";
            class8.description = "It's a Mith Platebody (G)".getBytes();
        }
        if (i == 23504) { //Mith Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Mith Helm (G)";
            class8.description = "It's a Mith Helm (G)".getBytes();
        }
        if (i == 23505) { //Mith Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Kiteshield (G)";
            class8.description = "It's a Mith Kiteshield (G)".getBytes();
        }
        if (i == 23506) { //Mith Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platelegs (W)";
            class8.description = "It's Mith Platelegs (W)".getBytes();
        }
        if (i == 23507) { //Mith Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43297;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platebody (W)";
            class8.description = "It's a Mith Platebody (W)".getBytes();
        }
        if (i == 23508) { //Mith Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Mith Helm (W)";
            class8.description = "It's a Mith Helm (W)".getBytes();
        }
        if (class8.certTemplateID != -1)
            class8.method199((byte) 61);
        if (!aBoolean182 && class8.membersObject) {
            class8.name = "Members Object";
            class8.description = "Login to a members' server to use this object.".getBytes();
            class8.groundActions = null;
            class8.itemActions = null;
            class8.anInt202 = 0;
        }

        return class8;
    }

    public static ItemDefinition method198_2(int i, ItemDefinition class8) {

        if (i == 24568) {
            Jukkyname("Mod sgs Platebody", "Its Mod Sgs's platebody.");
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            Jukkycolors(61, 32465, 0);
            Jukkycolors(24, 64449, 1);
            Jukkycolors(41, 32465, 2);
            Jukkycolors(10394, 32465, 3);
            Jukkycolors(10518, 64449, 4);
            Jukkycolors(10388, 64449, 5);
            Jukkycolors(10514, 64449, 6);
            Jukkycolors(10508, 64449, 7);
            Jukkyzoom(1380, 452, 0, 0, 0, -1, -1, -1, false);
            JukkyModels(6646, 3379, 6685, 3383, 2378);
        }
        if (i == 23509) { //Mith Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Kiteshield (W)";
            class8.description = "It's a Mith Kiteshield (W)".getBytes();
        }
        if (i == 23510) { //Mith Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platelegs (B)";
            class8.description = "It's Mith Platelegs (B)".getBytes();
        }
        if (i == 23511) { //Mith Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43297;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platebody (B)";
            class8.description = "It's a Mith Platebody (B)".getBytes();
        }
        if (i == 23512) { //Mith Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Mith Helm (B)";
            class8.description = "It's a Mith Helm (B)".getBytes();
        }
        if (i == 23513) { //Mith Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Kiteshield (B)";
            class8.description = "It's a Mith Kiteshield (B)".getBytes();
        }
        if (i == 23514) { //Mith Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platelegs (O)";
            class8.description = "It's Mith Platelegs (O)".getBytes();
        }
        if (i == 23515) { //Mith Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43297;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platebody (O)";
            class8.description = "It's a Mith Platebody (O)".getBytes();
        }
        if (i == 23516) { //Mith Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Mith Helm (O)";
            class8.description = "It's a Mith Helm (O)".getBytes();
        }
        if (i == 23517) { //Mith Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Kiteshield (O)";
            class8.description = "It's a Mith Kiteshield (O)".getBytes();
        }
        if (i == 23518) { //Mith Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platelegs (P)";
            class8.description = "It's Mith Platelegs (P)".getBytes();
        }
        if (i == 23519) { //Mith Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 43297;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Platebody (P)";
            class8.description = "It's a Mith Platebody (P)".getBytes();
        }
        if (i == 23520) { //Mith Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Mith Helm (P)";
            class8.description = "It's a Mith Helm (P)".getBytes();
        }
        if (i == 23521) { //Mith Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Kiteshield (P)";
            class8.description = "It's a Mith Kiteshield (P)".getBytes();
        }
        if (i == 23522) { //Adamant Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platelegs (G)";
            class8.description = "It's Adamant Platelegs (G)".getBytes();
        }
        if (i == 23523) { //Adamant Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 21662;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platebody (G)";
            class8.description = "It's a Adamant Platebody (G)".getBytes();
        }
        if (i == 23524) { //Adamant Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Adamant Helm (G)";
            class8.description = "It's a Adamant Helm (G)".getBytes();
        }
        if (i == 23525) { //Adamant Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Kiteshield (G)";
            class8.description = "It's a Adamant Kiteshield (G)".getBytes();
        }
        if (i == 23526) { //Adamant Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platelegs (W)";
            class8.description = "It's Adamant Platelegs (W)".getBytes();
        }
        if (i == 23527) { //Adamant Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 21662;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platebody (W)";
            class8.description = "It's a Adamant Platebody (W)".getBytes();
        }
        if (i == 23528) { //Adamant Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Adamant Helm (W)";
            class8.description = "It's a Adamant Helm (W)".getBytes();
        }
        if (i == 23529) { //Adamant Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Kiteshield (W)";
            class8.description = "It's a Adamant Kiteshield (W)".getBytes();
        }
        if (i == 23530) { //Adamant Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platelegs (B)";
            class8.description = "It's Adamant Platelegs (B)".getBytes();
        }
        if (i == 23531) { //Adamant Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 21662;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platebody (B)";
            class8.description = "It's a Adamant Platebody (B)".getBytes();
        }
        if (i == 23532) { //Adamant Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Adamant Helm (B)";
            class8.description = "It's a Adamant Helm (B)".getBytes();
        }
        if (i == 23533) { //Adamant Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Kiteshield (B)";
            class8.description = "It's a Adamant Kiteshield (B)".getBytes();
        }
        if (i == 23534) { //Adamant Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platelegs (O)";
            class8.description = "It's Adamant Platelegs (O)".getBytes();
        }
        if (i == 23535) { //Adamant Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 21662;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platebody (O)";
            class8.description = "It's a Adamant Platebody (O)".getBytes();
        }
        if (i == 23536) { //Adamant Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Adamant Helm (O)";
            class8.description = "It's a Adamant Helm (O)".getBytes();
        }
        if (i == 23537) { //Adamant Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Kiteshield (O)";
            class8.description = "It's a Adamant Kiteshield (O)".getBytes();
        }
        if (i == 23538) { //Adamant Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platelegs (P)";
            class8.description = "It's Adamant Platelegs (P)".getBytes();
        }
        if (i == 23539) { //Adamant Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 21662;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Platebody (P)";
            class8.description = "It's a Adamant Platebody (P)".getBytes();
        }
        if (i == 23540) { //Adamant Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Adamant Helm (P)";
            class8.description = "It's a Adamant Helm (P)".getBytes();
        }
        if (i == 23541) { //Adamant Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adamant Kiteshield (P)";
            class8.description = "It's a Adamant Kiteshield (P)".getBytes();
        }
        if (i == 23542) { //Rune Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platelegs (G)";
            class8.description = "It's Rune Platelegs (G)".getBytes();
        }
        if (i == 23543) { //Rune Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 36133;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platebody (G)";
            class8.description = "It's a Rune Platebody (G)".getBytes();
        }
        if (i == 23544) { //Rune Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Rune Helm (G)";
            class8.description = "It's a Rune Helm (G)".getBytes();
        }
        if (i == 23545) { //Rune Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Kiteshield (G)";
            class8.description = "It's a Rune Kiteshield (G)".getBytes();
        }
        if (i == 23546) { //Rune Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platelegs (W)";
            class8.description = "It's Rune Platelegs (W)".getBytes();
        }
        if (i == 23547) { //Rune Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 36133;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platebody (W)";
            class8.description = "It's a Rune Platebody (W)".getBytes();
        }
        if (i == 23548) { //Rune Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Rune Helm (W)";
            class8.description = "It's a Rune Helm (W)".getBytes();
        }
        if (i == 23549) { //Rune Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Kiteshield (W)";
            class8.description = "It's a Rune Kiteshield (W)".getBytes();
        }
        if (i == 23550) { //Rune Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platelegs (B)";
            class8.description = "It's Rune Platelegs (B)".getBytes();
        }
        if (i == 23551) { //Rune Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 36133;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platebody (B)";
            class8.description = "It's a Rune Platebody (B)".getBytes();
        }
        if (i == 23552) { //Rune Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Rune Helm (B)";
            class8.description = "It's a Rune Helm (B)".getBytes();
        }
        if (i == 23553) { //Rune Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Kiteshield (B)";
            class8.description = "It's a Rune Kiteshield (B)".getBytes();
        }
        if (i == 23554) { //Rune Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platelegs (O)";
            class8.description = "It's Rune Platelegs (O)".getBytes();
        }
        if (i == 23555) { //Rune Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 36133;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platebody (O)";
            class8.description = "It's a Rune Platebody (O)".getBytes();
        }
        if (i == 23556) { //Rune Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Rune Helm (O)";
            class8.description = "It's a Rune Helm (O)".getBytes();
        }
        if (i == 23557) { //Rune Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Kiteshield (O)";
            class8.description = "It's a Rune Kiteshield (O)".getBytes();
        }
        if (i == 23558) { //Rune Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platelegs (P)";
            class8.description = "It's Rune Platelegs (P)".getBytes();
        }
        if (i == 23559) { //Rune Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 36133;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Platebody (P)";
            class8.description = "It's a Rune Platebody (P)".getBytes();
        }
        if (i == 23560) { //Rune Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Rune Helm (P)";
            class8.description = "It's a Rune Helm (P)".getBytes();
        }
        if (i == 23561) { //Rune Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Kiteshield (P)";
            class8.description = "It's a Rune Kiteshield (P)".getBytes();
        }
        if (i == 26004) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 18105;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Lime Green Party Hat.";
            class8.description = "Lime Green Party Hat.".getBytes();
        }
        if (i == 26005) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 45549;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Unknowed White Partyhat";
            class8.description = "Unknowed White Partyhat".getBytes();
        }
        if (i == 26006) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 50971;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Deep Purple Partyhat";
            class8.description = "Deep Purple Partyhat".getBytes();
        }
        if (i == 26007) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 60176;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Deeper Purple Partyhat";
            class8.description = "Deeper Purple Partyhat".getBytes();
        }
        if (i == 26008) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 19213;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Deep Green Partyhat";
            class8.description = "Deep Green Partyhat".getBytes();
        }
        if (i == 26009) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 3654;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Dull Orange Partyhat";
            class8.description = "Dull Orange Partyhat".getBytes();
        }
        if (i == 26010) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 12904;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Bright Yellow Partyhat";
            class8.description = "Bright Yellow Partyhat".getBytes();
        }
        if (i == 26011) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 618;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Bright Pink Partyhat";
            class8.description = "Bright Pink Partyhat".getBytes();
        }
        if (i == 26012) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 46440;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Bright Blue Partyhat";
            class8.description = "Bright Blue Partyhat".getBytes();
        }
        if (i == 26013) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 11378;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Bright Gray Partyhat";
            class8.description = "Bright Gray Partyhat".getBytes();
        }
        if (i == 26014) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 36207;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Bright Sky Blue Partyhat";
            class8.description = "Bright Sky Blue Partyhat".getBytes();
        }
        if (i == 26015) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 32562;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Teal Partyhat";
            class8.description = "Teal Partyhat".getBytes();
        }
        if (i == 26016) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 8245;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Dark Gray Partyhat";
            class8.description = "Dark Gray Partyhat".getBytes();
        }
        if (i == 26017) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 18105;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lime Green Whip";
            class8.description = "Lime Green whip".getBytes();
        }
        if (i == 26018) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 45549;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Unknowed White Whip";
            class8.description = "Unknowed White whip".getBytes();
        }
        if (i == 26019) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 50971;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deep Purple Whip";
            class8.description = "Deep Purple whip".getBytes();
        }
        if (i == 26020) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 60176;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deeper Purple Whip";
            class8.description = "Deeper Purple whip".getBytes();
        }
        if (i == 26021) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 19213;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deep Green Whip";
            class8.description = "Deep Green whip".getBytes();
        }
        if (i == 26022) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 3654;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dull Orange Whip";
            class8.description = "Dull Orange whip".getBytes();
        }
        if (i == 26023) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 12904;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Yellow Whip";
            class8.description = "Bright Yellow whip".getBytes();
        }
        if (i == 26024) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 618;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Pink Whip";
            class8.description = "Bright Pink whip".getBytes();
        }
        if (i == 26025) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 46440;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Blue Whip";
            class8.description = "Bright Blue whip".getBytes();
        }
        if (i == 26026) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 11378;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Gray Whip";
            class8.description = "Bright Gray whip".getBytes();
        }
        if (i == 26027) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 36207;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Sky Blue Whip";
            class8.description = "Bright Sky Blue whip".getBytes();
        }
        if (i == 26028) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 32562;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Teal Whip";
            class8.description = "Teal whip".getBytes();
        }
        if (i == 26029) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 8245;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dark Gray Whip";
            class8.description = "Dark Gray whip".getBytes();
        }
        if (i == 23174) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 13876;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 13846;
            class8.primaryFemaleModel = 13846;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze crossbow";
            class8.description = "Bronze crossbow".getBytes();
        }
        if (i == 23175) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 6447;
            class8.originalModelColors[0] = 8478;
            class8.modifiedModelColors[1] = 6443;
            class8.originalModelColors[1] = 8598;
            class8.modifiedModelColors[2] = 6439;
            class8.originalModelColors[2] = 8846;
            class8.modifiedModelColors[3] = 7054;
            class8.originalModelColors[3] = 41;
            class8.modifiedModelColors[4] = 5652;
            class8.originalModelColors[4] = 33;
            class8.modifiedModelColors[5] = 5656;
            class8.originalModelColors[5] = 24;
            class8.modelId = 13876;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 13846;
            class8.primaryFemaleModel = 13846;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron crossbow";
            class8.description = "Iron crossbow".getBytes();
        }
        if (i == 25232) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 12605;
            class8.spriteScale = 2000;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 14;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 12607;
            class8.primaryFemaleModel = 12607;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;
            class8.name = "Batman cape";
            class8.description = "Omfg Wheres BatMan!".getBytes();
        }
        if (i == 11342) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 64200;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 64201;// wield
            class8.primaryFemaleModel = 64201;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Black Energy";
            class8.description = "A strong sword made of Black energy.".getBytes();
        }
        if (i == 11343) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 64202;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 64203;// wield
            class8.primaryFemaleModel = 64203;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Easter Energy sword";
            class8.description = "From the easter bunny. =)".getBytes();
        }
        if (i == 11344) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 64204;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 64205;// wield
            class8.primaryFemaleModel = 64205;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Green Energy sword";
            class8.description = "An Green Energy Sword".getBytes();
        }

        if (i == 11345) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 64206;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 64207;// wield
            class8.primaryFemaleModel = 64207;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Purple Energy sword";
            class8.description = "An Purple Energy Sword".getBytes();
        }
        if (i == 11015) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 23998;
            class8.spriteScale = 1049;
            class8.spritePitch = 609;
            class8.spriteCameraRoll = 2047;
            class8.spriteCameraYaw = 1950;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 24034;
            class8.primaryFemaleModel = 24046;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chicken head";
            class8.description = "It's a Chicken head".getBytes();
        }

        if (i == 11016) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 23997;
            class8.spriteScale = 848;
            class8.spritePitch = 127;
            class8.spriteCameraRoll = 1931;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -4;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 24033;
            class8.primaryFemaleModel = 24045;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chicken feet";
            class8.description = "It's a Chicken feet".getBytes();
        }
        if (i == 11017) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 24000;
            class8.spriteScale = 1488;
            class8.spritePitch = 595;
            class8.spriteCameraRoll = 2047;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -8;
            class8.spriteTranslateY = -12;
            class8.primaryMaleModel = 24037;
            class8.primaryFemaleModel = 24048;
            class8.secondaryMaleModel = 24032;
            class8.secondaryFemaleModel = 24044;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chicken wings";
            class8.description = "It's a Chicken wings".getBytes();
        }
        if (i == 11018) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 23999;
            class8.spriteScale = 1744;
            class8.spritePitch = 622;
            class8.spriteCameraRoll = 2047;
            class8.spriteCameraYaw = 28;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 24035;
            class8.primaryFemaleModel = 24047;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chicken legs";
            class8.description = "It's a Chicken legs".getBytes();
        }

        if (i == 25678) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14200; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14201; //Male
            class8.primaryFemaleModel = 14201; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Money cape";
            class8.description = "Its A money cape".getBytes();
        }
        if (i == 24202) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 13426; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 13417; //Male
            class8.primaryFemaleModel = 13417; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Polypore staff";
            class8.description = "Its A Polypore staff.".getBytes();
        }
        if (i == 25185) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14531; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14532; //Male
            class8.primaryFemaleModel = 14532; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Dragon fire shield";
            class8.description = "A heavy shield with a snarling, draconic visage.".getBytes();
        }
        if (i == 29083) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 950;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 95004;
            class8.primaryFemaleModel = 95004;
            class8.modelId = 95006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black dragon platelegs";
            class8.description = "Omg, you killed that thing??".getBytes();
        }
        if (i == 29084) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 950;
            class8.spriteScale = 1300;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 7;
            class8.primaryMaleModel = 95003;
            class8.primaryFemaleModel = 95007;
            class8.modelId = 95007;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black dragon platebody";
            class8.description = "Is he dead or just sleeping!?".getBytes();
        }
        if (i == 29584) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93025;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93026;
            class8.modelId = 93026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demonic Cape";
            class8.description = "Cache 27".getBytes();
        }
        if (i == 29017) {
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57260;
            class8.originalModelColors[1] = 954;
            class8.modifiedModelColors[2] = 55218;
            class8.originalModelColors[2] = 954;
            class8.modifiedModelColors[3] = 55220;
            class8.originalModelColors[3] = 954;
            class8.modifiedModelColors[4] = 56246;
            class8.originalModelColors[4] = 954;
            class8.modifiedModelColors[5] = 56221;
            class8.originalModelColors[5] = 954;
            class8.modifiedModelColors[6] = 56230;
            class8.originalModelColors[6] = 954;
            class8.modifiedModelColors[7] = 57126;
            class8.originalModelColors[7] = 954;
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "Black and red death Cape";
            class8.description = "Its A Black and red death cape".getBytes();
        }
        if (i == 29018) {
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57260;
            class8.originalModelColors[1] = 53432;
            class8.modifiedModelColors[2] = 55218;
            class8.originalModelColors[2] = 53432;
            class8.modifiedModelColors[3] = 55220;
            class8.originalModelColors[3] = 53432;
            class8.modifiedModelColors[4] = 56246;
            class8.originalModelColors[4] = 53432;
            class8.modifiedModelColors[5] = 56221;
            class8.originalModelColors[5] = 53432;
            class8.modifiedModelColors[6] = 56230;
            class8.originalModelColors[6] = 53432;
            class8.modifiedModelColors[7] = 57126;
            class8.originalModelColors[7] = 53432;
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "Black and light purple death Cape";
            class8.description = "Its A Black and light purple death cape".getBytes();
        }
        if (i == 29019) {
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57260;
            class8.originalModelColors[1] = 32691;
            class8.modifiedModelColors[2] = 55218;
            class8.originalModelColors[2] = 32691;
            class8.modifiedModelColors[3] = 55220;
            class8.originalModelColors[3] = 32691;
            class8.modifiedModelColors[4] = 56246;
            class8.originalModelColors[4] = 32691;
            class8.modifiedModelColors[5] = 56221;
            class8.originalModelColors[5] = 32691;
            class8.modifiedModelColors[6] = 56230;
            class8.originalModelColors[6] = 32691;
            class8.modifiedModelColors[7] = 57126;
            class8.originalModelColors[7] = 32691;
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "Black and teal death Cape";
            class8.description = "Its A Black and teal death cape".getBytes();
        }
        if (i == 29020) {
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57260;
            class8.originalModelColors[1] = 13221;
            class8.modifiedModelColors[2] = 55218;
            class8.originalModelColors[2] = 13221;
            class8.modifiedModelColors[3] = 55220;
            class8.originalModelColors[3] = 13221;
            class8.modifiedModelColors[4] = 56246;
            class8.originalModelColors[4] = 13221;
            class8.modifiedModelColors[5] = 56221;
            class8.originalModelColors[5] = 13221;
            class8.modifiedModelColors[6] = 56230;
            class8.originalModelColors[6] = 13221;
            class8.modifiedModelColors[7] = 57126;
            class8.originalModelColors[7] = 13221;
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "Black and light green death Cape";
            class8.description = "Its A Black and light green death cape".getBytes();
        }
        if (i == 29021) {
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57260;
            class8.originalModelColors[1] = 5039;
            class8.modifiedModelColors[2] = 55218;
            class8.originalModelColors[2] = 5039;
            class8.modifiedModelColors[3] = 55220;
            class8.originalModelColors[3] = 5039;
            class8.modifiedModelColors[4] = 56246;
            class8.originalModelColors[4] = 5039;
            class8.modifiedModelColors[5] = 56221;
            class8.originalModelColors[5] = 5039;
            class8.modifiedModelColors[6] = 56230;
            class8.originalModelColors[6] = 5039;
            class8.modifiedModelColors[7] = 57126;
            class8.originalModelColors[7] = 5039;
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "Black and orange death Cape";
            class8.description = "Its A Black and orange death cape".getBytes();
        }
        if (i == 29022) {
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 125;
            class8.modifiedModelColors[1] = 57260;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 55218;
            class8.originalModelColors[2] = 0;
            class8.modifiedModelColors[3] = 55220;
            class8.originalModelColors[3] = 0;
            class8.modifiedModelColors[4] = 56246;
            class8.originalModelColors[4] = 0;
            class8.modifiedModelColors[5] = 56221;
            class8.originalModelColors[5] = 0;
            class8.modifiedModelColors[6] = 56230;
            class8.originalModelColors[6] = 0;
            class8.modifiedModelColors[7] = 57126;
            class8.originalModelColors[7] = 0;
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "white and black death Cape";
            class8.description = "Its A white and black death cape".getBytes();
        }
        if (i == 24887) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 13039;
            class8.spriteScale = 1104;
            class8.spritePitch = 321;
            class8.spriteCameraRoll = 24;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -5;
            class8.spriteTranslateY = 2;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 13040;
            class8.primaryFemaleModel = 13040;
            class8.stackable = false;
            class8.name = "Barrelchest Anchor";
            class8.description = "A Anchor".getBytes();
        }
        if (i == 24322) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 13768;
            class8.spriteScale = 2000;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 1200;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 16;
            class8.spriteTranslateY = 1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 13767;
            class8.primaryFemaleModel = 13767;
            class8.stackable = false;
            class8.name = "Twin Ghostblades";
            class8.description = "Most powerful weapon on GHr crafted by the Gods themselves.".getBytes();
        }

        if (i == 25094) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 23016) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9233;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9234;
            class8.primaryFemaleModel = 9234;
            class8.name = "Black and yellow death Cape";
            class8.description = "Its A Black and yellow death cape".getBytes();
        }
        if (i == 23017) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 9235;
            class8.spriteScale = 467;
            class8.spritePitch = 74;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 9236;
            class8.primaryFemaleModel = 9236;
            class8.name = "Black and Purple death Cape";
            class8.description = "Its A Black and Purple death cape".getBytes();
        }
        if (i == 23120) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.modelId = 13920;
            class8.spriteScale = 2000;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = 1;
            class8.spriteCameraYaw = 14;
            class8.primaryMaleModel = 13921;
            class8.primaryFemaleModel = 13921;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;
            class8.name = "Angel Cape";
            class8.description = "Large winged angel cape".getBytes();
        }

        if (i == 28390) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13200;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 2434;
            class8.spriteCameraRoll = 0;
            class8.spritePitch = 458;
            class8.spriteTranslateX = -3;
            class8.primaryMaleModel = 13200;
            class8.modelId = 13201;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal kiteshield";
            class8.description = "Its a Primal kiteshield".getBytes();
        }
        if (i == 28391) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13202;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 1447;
            class8.spriteCameraRoll = 0;
            class8.spritePitch = 485;
            class8.spriteTranslateX = 0;
            class8.primaryMaleModel = 13203;
            class8.modelId = 13204;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal platebody";
            class8.description = "Its a Primal platebody".getBytes();
        }
        if (i == 28392) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Weild";
            class8.modelId = 13206;
            class8.primaryMaleModel = 13205;
            class8.primaryFemaleModel = 13205;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.spriteScale = 1840;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 1300;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.spriteCameraRoll = 1552;
            class8.name = "Primal 2h";
            class8.description = "A 2h sword of pure evil.".getBytes();
            class8.maleTranslation = -10;
            class8.femaleTranslation = -10;
        }
        if (i == 28393) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13207;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 921;
            class8.spriteCameraRoll = 0;
            class8.spritePitch = 121;
            class8.spriteTranslateX = 0;
            class8.primaryMaleModel = 13208;
            class8.modelId = 13209;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal full helm";
            class8.description = "Its a Primal full helm".getBytes();
        }
        if (i == 28394) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13210;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 1730;
            class8.spriteCameraRoll = 0;
            class8.spritePitch = 525;
            class8.spriteTranslateX = 7;
            class8.primaryMaleModel = 13211;
            class8.modelId = 13212;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal platelegs";
            class8.description = "It are Primal platelegs".getBytes();
        }
        if (i == 28395) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13213;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 1711;
            class8.spriteCameraRoll = 0;
            class8.spritePitch = 488;
            class8.spriteTranslateX = -1;
            class8.primaryMaleModel = 13214;
            class8.modelId = 13215;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal plateskirt";
            class8.description = "A Primal plateskirt".getBytes();
        }
        if (i == 28396) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13216;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 789;
            class8.spriteCameraRoll = 156;
            class8.spritePitch = 164;
            class8.spriteTranslateX = 0;
            class8.primaryMaleModel = 13217;
            class8.modelId = 13218;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal boots";
            class8.description = "A pair of Primal boots".getBytes();
        }
        if (i == 28397) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 13219;
            class8.spriteTranslateY = 0;
            class8.spriteScale = 930;
            class8.spriteCameraRoll = 828;
            class8.spritePitch = 420;
            class8.spriteTranslateX = 3;
            class8.primaryMaleModel = 13220;
            class8.modelId = 13220;
            class8.secondaryFemaleModel = -1;
            class8.name = "Primal gauntlets";
            class8.description = "A pair of Primal gauntlets".getBytes();
        }

        if (i == 24108) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 11200;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Yellow Whip";
            class8.description = "a Yellow Whip".getBytes();
        }
        if (i == 23677) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14125; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14126; //Male
            class8.primaryFemaleModel = 14126; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Moderator cape";
            class8.description = "Its A moderator Cape".getBytes();
        }
        if (i == 23678) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14127; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14128; //Male
            class8.primaryFemaleModel = 14128; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Administrator cape";
            class8.description = "Its an administrator cape".getBytes();
        }
        if (i == 23679) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14129; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14130; //Male
            class8.primaryFemaleModel = 14130; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Owner cape";
            class8.description = "Its an owner cape".getBytes();
        }

        if (i == 24164) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 7114;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 7114;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Golden Bunny ears";
            class8.description = "Golden Bunny ears".getBytes();
        }
        if (i == 24165) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 43968;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Blue Bunny ears";
            class8.description = "Its a Blue Bunny ears".getBytes();
        }
        if (i == 24166) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 950;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 950;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Red Bunny ears";
            class8.description = "Its a Red Bunny ears".getBytes();
        }
        if (i == 24167) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 51136;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Purple Bunny ears";
            class8.description = "Its a Purple Bunny ears".getBytes();
        }
        if (i == 24168) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 22464;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Green Bunny ears";
            class8.description = "Its a Green Bunny ears".getBytes();
        }
        if (i == 24169) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 6073;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Orange Bunny ears";
            class8.description = "Its a Orange Bunny ears".getBytes();
        }
        if (i == 24170) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 10394;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 10394;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Barrows Bunny ears";
            class8.description = "Its A Barrows Bunny ears".getBytes();
        }
        if (i == 24171) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 926;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 926;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Dragon Bunny ears";
            class8.description = "Its A Dragon Bunny ears".getBytes();
        }
        if (i == 24172) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 5652;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Bronze Bunny ears";
            class8.description = "Its A Bronze Bunny ears".getBytes();
        }
        if (i == 24173) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 33;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Iron Bunny ears";
            class8.description = "Its A Iron Bunny ears".getBytes();
        }
        if (i == 24174) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 43072;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Steel Bunny ears";
            class8.description = "Its A Steel Bunny ears".getBytes();
        }
        if (i == 24175) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 8;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 8;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Black Bunny ears";
            class8.description = "Its A Black Bunny ears".getBytes();
        }
        if (i == 24176) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 43297;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Mith Bunny ears";
            class8.description = "Its A Mith Bunny ears".getBytes();
        }
        if (i == 24177) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 36133;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Rune Bunny ears";
            class8.description = "Its A Rune Bunny ears".getBytes();
        }
        if (i == 24178) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 21662;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Adam Bunny ears";
            class8.description = "Its A Adam Bunny ears".getBytes();
        }
        if (i == 24179) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 6069;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 6069;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Lava Bunny ears";
            class8.description = "Its A lava Bunny ears".getBytes();
        }

        if (i == 24180) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 26706;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 26706;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Ivandis Bunny ears";
            class8.description = "Its A Ivandis Bunny ears".getBytes();
        }
        if (i == 24181) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 62920;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 62920;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Ladies Bunny ears";
            class8.description = "Its A Ladies Bunny ears".getBytes();
        }

        if (i == 24182) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 10394;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 10394;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 10394;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Barrows Flowers";
            class8.description = "Its A Barrow Flower".getBytes();
        }


        if (i == 24183) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 926;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 926;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 926;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Dragon Flowers";
            class8.description = "Its A Dragon Flowers".getBytes();
        }

        if (i == 24184) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 5652;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Bronze Flowers";
            class8.description = "Its A Bronze Flowers".getBytes();
        }

        if (i == 24185) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 33;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Iron Flowers";
            class8.description = "Its A Iron Flowers".getBytes();
        }

        if (i == 24186) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 43072;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 43072;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 43072;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Steel Flowers";
            class8.description = "Its A Steel Flowers".getBytes();
        }

        if (i == 24187) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 43297;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 43297;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 43297;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Mith Flowers";
            class8.description = "Its A Mith Flowers".getBytes();
        }

        if (i == 24188) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 21662;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 21662;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 21662;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Adam Flowers";
            class8.description = "Its A Adam Flowers".getBytes();
        }

        if (i == 24189) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 48596;
            class8.originalModelColors[0] = 36133;
            class8.modifiedModelColors[1] = 37196;
            class8.originalModelColors[1] = 36133;
            class8.modifiedModelColors[2] = 53167;
            class8.originalModelColors[2] = 36133;
            class8.modelId = 1781;
            class8.spriteScale = 840;
            class8.spritePitch = 612;
            class8.spriteCameraRoll = 816;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 677;
            class8.primaryFemaleModel = 677;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Rune Flowers";
            class8.description = "Its A Rune Flowers".getBytes();
        }
        if (i == 24190) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 32707;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 32707;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Light Blue Bunny ears";
            class8.description = "Its A Light Blue Bunny ears".getBytes();
        }
        if (i == 24191) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 52685;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 52685;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Light Purple Bunny ears";
            class8.description = "Its A Light Purple Bunny ears".getBytes();
        }
        if (i == 24192) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 13140;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 13140;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Light Yellow Bunny ears";
            class8.description = "Its A Light Yellow Bunny ears".getBytes();
        }
        if (i == 24193) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 20245;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 20245;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Forest Green Bunny ears";
            class8.description = "Its A Forest Green Bunny ears".getBytes();
        }
        if (i == 24194) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 50976;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 50976;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Dark Purple Bunny ears";
            class8.description = "Its A Dark Purple Bunny ears".getBytes();
        }
        if (i == 12323) {
            class8.name = "Grim reaper hood";
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[4] = "Destroy";
            class8.modelId = 10179;
            class8.primaryMaleModel = 10186;
            class8.secondaryMaleModel = -1;
            class8.anInt202 = 0;
            class8.stackable = false;
            class8.spriteCameraRoll = 858;
            class8.spriteScale = 1762;
            class8.value = 1;
            class8.primaryFemaleModel = 10185;
            class8.secondaryFemaleModel = -1;
            class8.spriteTranslateX = 3;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateY = -26;
            class8.certID = -1;
            class8.spritePitch = 2047;
            class8.description = "It's a Grim reaper hood.".getBytes();
        }
        if (i == 24517) // Your desired item id (the one you use after :ickup ##### #)
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; // String name, this can be changed to wield, or attach, or whatever you want
            class8.modelId = 14117; // Drop/Inv Model
            class8.spriteScale = 2083;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 1883;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 14115; // Male Wield Model
            class8.primaryFemaleModel = 14115; // Female Wield
            class8.secondaryMaleModel = 14116; // Male arms/sleeves (Leave as -1 if not used) and also the models come different with sleeves so i might have to redo it
            class8.secondaryFemaleModel = -1; // Female arms/sleeves (Leave as -1 if not used)
            class8.name = "Dagon'hai top"; // Item Name
            class8.description = "A robe worn by members of the Dagon'hai.".getBytes(); // Item Examine
        }
        if (i == 12311) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = -23903;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Navy cavalier";
            class8.description = "a Navy cavalier".getBytes();
        }
        if (i == 24518) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14119;
            class8.spriteScale = 917;
            class8.spritePitch = 212;
            class8.spriteCameraRoll = 1883;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 14118;
            class8.primaryFemaleModel = 14118;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Dagon'hai hat";
            class8.description = "A hat worn by members of the Dagon'hai.".getBytes();
        }
        if (i == 24519) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 14121;
            class8.spriteScale = 2083;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14120;
            class8.primaryFemaleModel = 14120;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Dagon'hai Robes";
            class8.description = "Robes worn by members of the Dagon'hai.".getBytes();
        }
        if (i == 2949) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.name = "Golden Hammer";
            class8.description = "A Replica Hammer Made Of Solid Gold.".getBytes();
        }
        if (i == 2946) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.name = "Golden Tinderbox";
            class8.description = "A Replica Tinderbox Made Of Solid Gold.".getBytes();
        }
        if (i == 773) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.name = "Perfect Ring";
            class8.description = "It's A Perfect Ring.".getBytes();
        }
        if (i == 28013) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 21662;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Adam Whip";
            class8.description = "Whip Made Of Adam".getBytes();
        }
        if (i == 28014) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 36133;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rune Whip";
            class8.description = "Whip Made Of Rune".getBytes();
        }
        if (i == 28015) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 43297;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mith Whip";
            class8.description = "Whip Made Of Mithril".getBytes();
        }
        if (i == 28016) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 8;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Whip";
            class8.description = "Whip Made Of Black".getBytes();
        }
        if (i == 28017) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 43072;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Steel Whip";
            class8.description = "Whip Made Of Steel".getBytes();
        }
        if (i == 28018) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 33;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Whip";
            class8.description = "Whip Made Of Iron".getBytes();
        }
        if (i == 28019) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 5652;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Whip";
            class8.description = "Whip Made Of Bronze".getBytes();
        }
        if (i == 23093) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 926;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dragon Whip";
            class8.description = "A whip made of Dragon".getBytes();
        }
        if (i == 24562) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 49500;
            class8.modelId = 2602;
            class8.spriteScale = 860;
            class8.spritePitch = 100;
            class8.spriteCameraRoll = 1348;
            class8.spriteCameraYaw = 96;
            class8.spriteTranslateX = -13;
            class8.spriteTranslateY = -2;
            class8.primaryMaleModel = 518;
            class8.primaryFemaleModel = 518;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "sexy whip";
            class8.description = "hshsh".getBytes();
        }
        if (i == 25679) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modelId = 103;//item look
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 104;
            class8.primaryFemaleModel = 104;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Faylin Godsword";
            class8.description = "A Godsword made by Faylin, a very powerful Angel.".getBytes();
        }
        if (i == 12321) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 8254; //Model ID
            class8.spriteScale = 2000; //1200 zoom increase will make it smaller
            class8.spritePitch = 572; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 0; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = 0; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.primaryMaleModel = 8255;//male wearing
            class8.primaryFemaleModel = 8255;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Long Blade Of Ulysses";//Name of the new item
            class8.description = "An ancient, and powerful long blade of Ulysses.".getBytes();//examine info
        }
        if (i == 2749) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 41;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[0] = 924;
            class8.originalModelColors[1] = 127;
            class8.originalModelColors[2] = 924;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa Legs";
            class8.description = "Santa Legs".getBytes();
        }
        if (i == 2750) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 41;
            class8.modifiedModelColors[2] = 24;
            class8.modifiedModelColors[3] = 11187;
            class8.originalModelColors[0] = 127;
            class8.originalModelColors[1] = 924;
            class8.originalModelColors[2] = 127;
            class8.originalModelColors[3] = 127;
            class8.modelId = 3020;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa plate";
            class8.description = "Santa plate".getBytes();
        }
        if (i == 2751) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 7054;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[0] = 127;
            class8.originalModelColors[1] = 924;
            class8.originalModelColors[2] = 924;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa Kite";
            class8.description = "Santa Kite".getBytes();
        }
        if (i == 2752) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 926;
            class8.modifiedModelColors[1] = 7700;
            class8.modifiedModelColors[2] = 11200;
            class8.modifiedModelColors[3] = 6032;
            class8.originalModelColors[0] = 127;
            class8.originalModelColors[1] = 127;
            class8.originalModelColors[2] = 924;
            class8.originalModelColors[3] = 127;
            class8.modelId = 2603;
            class8.spriteScale = 2140;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 948;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 323;
            class8.primaryFemaleModel = 481;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa cape";
            class8.description = "Santa cape".getBytes();
        }
        if (i == 2753) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 39009;
            class8.modifiedModelColors[1] = 40918;
            class8.originalModelColors[0] = 127;
            class8.originalModelColors[1] = 924;
            class8.originalModelColors[2] = 924;
            class8.originalModelColors[3] = 127;
            class8.modelId = 5039;
            class8.spriteScale = 830;
            class8.spritePitch = 536;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = 4953;
            class8.primaryFemaleModel = 5030;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa Gloves";
            class8.description = "Santa Gloves".getBytes();
        }
        if (i == 2754) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 127;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa Boots";
            class8.description = "Santa boots".getBytes();
        }
        if (i == 2755) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 41;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[0] = 11200;
            class8.originalModelColors[1] = 0;
            class8.originalModelColors[2] = 11200;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black & Yellow Legs";
            class8.description = "Black & Yellow Legs".getBytes();
        }
        if (i == 2756) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 41;
            class8.modifiedModelColors[2] = 24;
            class8.modifiedModelColors[3] = 11187;
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 11200;
            class8.originalModelColors[2] = 0;
            class8.originalModelColors[3] = 0;
            class8.modelId = 3020;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black & Yellow plate";
            class8.description = "Black & Yellow plate".getBytes();
        }
        if (i == 2757) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 7054;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 11200;
            class8.originalModelColors[2] = 11200;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black & Yellow Kite";
            class8.description = "Black & Yellow Kite".getBytes();
        }
        if (i == 2758) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 926;
            class8.modifiedModelColors[1] = 7700;
            class8.modifiedModelColors[2] = 11200;
            class8.modifiedModelColors[3] = 6032;
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 0;
            class8.originalModelColors[2] = 11200;
            class8.originalModelColors[3] = 0;
            class8.modelId = 2603;
            class8.spriteScale = 2140;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 948;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 323;
            class8.primaryFemaleModel = 481;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black & Yellow cape";
            class8.description = "Black & Yellow cape".getBytes();
        }
        if (i == 2759) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 39009;
            class8.modifiedModelColors[1] = 40918;
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 11200;
            class8.originalModelColors[2] = 11200;
            class8.originalModelColors[3] = 0;
            class8.modelId = 5039;
            class8.spriteScale = 830;
            class8.spritePitch = 536;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = 4953;
            class8.primaryFemaleModel = 5030;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black & Yellow Gloves";
            class8.description = "Black & Yellow Gloves".getBytes();
        }
        if (i == 2760) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black & Yellow Boots";
            class8.description = "Black & Yellow boots".getBytes();
        }
        if (i == 25680) // ITEM ID
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Play";
            class8.modelId = 11134; // Drop/Inv Model
            class8.primaryMaleModel = 11135; // Male Wield Model
            class8.primaryFemaleModel = 11135; // Female Wield
            class8.secondaryMaleModel = -1; // Male arms/sleeves
            class8.secondaryFemaleModel = -1; // Female arms/sleeves
            class8.spriteScale = 850; // Zoom
            class8.spritePitch = 498; // Rotate up/down
            class8.spriteCameraRoll = 1300; // Rotate right/left
            class8.spriteTranslateX = -1; // Position in inv, increase to move right
            class8.spriteTranslateY = -1; // Position in inv, increase to move up
            class8.name = "Winkman's Guitar"; // Item Name
            class8.description = "Whoa, Nice Guitar Dude!".getBytes(); // Item Examine
        }
        if (i == 24091) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 6;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Emo santa hat ";
            class8.description = "Emo santa hat.".getBytes();
        }
        if (i == 28012) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 926;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Black santa hat ";
            class8.description = "Black santa hat.".getBytes();
        }
        if (i == 25055) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 62928;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Pink Party Hat";
            class8.description = "A Pink Party Hat.".getBytes();
        }
        if (i == 25999) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 39758;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Light blue Party Hat";
            class8.description = "A Light blue Party Hat.".getBytes();
        }
        if (i == 26000) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 20763;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "dark green Party Hat";
            class8.description = "A dark green Party Hat.".getBytes();
        }
        if (i == 26001) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 44588;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Dark Blue Party Hat";
            class8.description = "A dark blue Party Hat.".getBytes();
        }
        if (i == 26002) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 64028;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Blood Red Party Hat";
            class8.description = "A Blood Red Party Hat.".getBytes();
        }
        if (i == 26003) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 33640;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Lighter blue Party Hat";
            class8.description = "Lighter blue Party Hat.".getBytes();
        }
        if (i == 24560) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 35321;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "sky phat";
            class8.description = "A sky Party Hat.".getBytes();
        }
        if (i == 23117) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 0;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Black h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 23118) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 11200;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Yellow h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 24099) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 23421;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 0;
            class8.modelId = 2537;
            class8.spriteScale = 540;
            class8.spritePitch = 72;
            class8.spriteCameraRoll = 136;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 189;
            class8.secondaryMaleModel = -1;
            class8.primaryFemaleModel = 366;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 69;
            class8.primaryFemaleHeadPiece = 127;
            class8.stackable = false;
            class8.name = "Pimp santa hat ";
            class8.description = "Pimpin santa hat.".getBytes();
        }
        if (i == 24105) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 10394;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = " Barrows Whip";
            class8.description = "a Barrows Whip".getBytes();
        }
        if (i == 24555) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 62928;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = " sissy Whip";
            class8.description = "a sissy  Whip".getBytes();
        }
        if (i == 24106) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 7114;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gold Whip";
            class8.description = "a Gold Whip".getBytes();
        }
        if (i == 11078) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 8128;
            class8.modelId = 2635;
            class8.spriteScale = 440;
            class8.spritePitch = 76;
            class8.spriteCameraRoll = 1850;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 187;
            class8.primaryFemaleModel = 363;
            class8.primaryMaleHeadPiece = 29;
            class8.primaryFemaleHeadPiece = 87;
            class8.name = "Godz Party Hat";
            class8.description = "A  Party Hat for owner godz.".getBytes();
        }


        if (i == 25681) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 12214;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 12213;
            class8.primaryFemaleModel = 12213;
            class8.stackable = false;
            class8.name = "Dragon Godsword";
            class8.description = "A godsword From the Greatest Dragons.".getBytes();
        }
        if (i == 29954) // Your desired item id (the one you use after ::pickup ##### #)
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield"; // String name, this can be changed to wield, or attach, or whatever you want
            class8.modelId = 12556; // Drop/Inv Model
            class8.primaryMaleModel = 12555; // Male Wield Model
            class8.primaryFemaleModel = 12555; // Female Wield
            class8.secondaryMaleModel = -1; // Male arms/sleeves (Leave as -1 if not used)
            class8.secondaryFemaleModel = -1; // Female arms/sleeves (Leave as -1 if not used)
            class8.spriteScale = 2000; // Zoom - Increase to make inv model smaller
            class8.spritePitch = 500; // Rotate up/down -  Increase to rotate upwards
            class8.spriteCameraRoll = 0; // Rotate right/left - Increase to rotate right
            class8.spriteTranslateX = -1; // Position in  inv, increase to move right
            class8.spriteTranslateY = -1; // Position in inv, increase to move up
            class8.name = "Dungeoneering cape"; // Item Name
            class8.description = "A nice looking cape.".getBytes(); // Item Examine
        }
        if(i == 25259) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = '\u9e70';
            class8.spriteScale = 1382;
            class8.spritePitch = 364;
            class8.spriteCameraRoll = 1158;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 8;
            class8.spriteTranslateY = -12;
            class8.primaryMaleModel = '\ubd56';
            class8.primaryFemaleModel = '\ubd56';
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dragon pickaxe";
            class8.description = "Used for mining.".getBytes();
        }
        if (i == 27979) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 8553; //inv and drop
            class8.spriteScale = 2000;
            class8.spritePitch = 434;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 8554; //m wear
            class8.primaryFemaleModel = 8554; //f wear
            class8.name = "Demon Wind Shuriken";
            class8.description = "A razor sharp shuriken weapon.".getBytes();
        }
        if (i == 11338) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 14200;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 14201;// wield
            class8.primaryFemaleModel = 14201;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Energy sword";
            class8.description = "A strong sword made of energy.".getBytes();
        }
        if (i == 11339) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 5221;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 5222;// wield
            class8.primaryFemaleModel = 5222;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Red Energy sword";
            class8.description = "A strong sword made of red energy.".getBytes();
        }
        if (i == 11340) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 6221;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 6222;// wield
            class8.primaryFemaleModel = 6222;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "X-Mas Energy sword";
            class8.description = "From Santa...".getBytes();
        }
        if (i == 11341) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 7221;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 7222;// wield
            class8.primaryFemaleModel = 7222;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "valentines Energy sword";
            class8.description = "From traxxas Have a Happy valentines Day =)".getBytes();
        }
        if (i == 24200) // ItemID
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 60831;
            class8.spriteScale = 1744;
            class8.spritePitch = 330;
            class8.spriteCameraRoll = 1505;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 57780;
            class8.primaryFemaleModel = 57784;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Korasi sword";
            class8.description = "It's a Korasi sword".getBytes();
        }
        if (i == 23214) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 13215;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 13214;
            class8.primaryFemaleModel = 13214;
            class8.stackable = false;
            class8.name = "Zaros Godsword";
            class8.description = "A sword containing magical power.".getBytes();
        }
        if (i == 24590)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";//New option
            class8.modelId = 3000; //Model ID
            class8.spriteScale = 730;//Model Zoom
            class8.spritePitch = 567;//Model Rotation
            class8.spriteCameraRoll = 1120;//
            class8.spriteTranslateX = -4;//
            class8.spriteTranslateY = -1;//
            class8.primaryMaleModel = 3001;
            class8.primaryFemaleModel = 3002;
            class8.secondaryMaleHeadPiece = 63;
            class8.secondaryFemaleHeadPiece = 120;
            class8.anInt167 = 100;
            class8.anInt192 = 100;
            class8.anInt191 = 100;
            class8.anInt196 = 15;
            class8.anInt184 = 100;
            class8.spriteCameraYaw = 1923;
            class8.stackable = false;
            class8.name = "Ava's accumulator";
            class8.description = "Ava's accumulator".getBytes();
        }
        if (i == 26897) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 10378;
            class8.spriteScale = 1200;
            class8.spritePitch = 1;
            class8.spriteCameraRoll = 1;
            class8.spriteCameraYaw = 1;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 50;
            class8.primaryMaleModel = 10378;
            class8.primaryFemaleModel = 10378;
            class8.secondaryMaleModel = 10374;
            class8.secondaryFemaleModel = 10374;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Ninja Body";
            class8.description = "Stealthy.".getBytes();
        }

        if (i == 24010)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 14061; //
            class8.stackable = false;//Stackable
            class8.spriteScale = 1800; //zoom increase will make it smaller
            class8.spritePitch = 470; //model rotate up+down increase to move down away from you
            class8.spriteCameraRoll = 129; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = -1; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.spriteCameraYaw = 28;
            class8.primaryMaleModel = 14062;//male wearing
            class8.primaryFemaleModel = 14062;//female wearing
            class8.spriteCameraYaw = 28;
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Vesta's longsword";//Name of the new item
            class8.description = "This item degrades in combat, and will turn to dust.".getBytes();//examin info
        }
        if (i == 24011)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 14063; //
            class8.stackable = false;//Stackable
            class8.spriteScale = 1600; //zoom increase will make it smaller
            class8.spritePitch = 470; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 129; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = -1; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.spriteCameraYaw = 28;
            class8.primaryMaleModel = 14064;//male wearing
            class8.primaryFemaleModel = 14064;//female wearing
            class8.spriteCameraYaw = 28;
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Vesta's spear";//Name of the new item
            class8.description = "This item degrades in combat, and will turn to dust.".getBytes();//examin info
        }
        if (i == 24012)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 14069; //
            class8.stackable = false;//Stackable
            class8.spriteScale = 650; //zoom increase will make it smaller
            class8.spritePitch = 470; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 0; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = -1; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.spriteCameraYaw = 28;
            class8.primaryMaleModel = 14070;//male wearing
            class8.primaryFemaleModel = 14070;//female wearing
            class8.spriteCameraYaw = 28;
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Morrigan's coif";//Name of the new item
            class8.description = "This item degrades in combat, and will turn to dust.".getBytes();//examin info
        }
        if (i == 24013)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 14071; //
            class8.stackable = false;//Stackable
            class8.spriteScale = 1600; //zoom increase will make it smaller
            class8.spritePitch = 470; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 129; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = -1; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.spriteCameraYaw = 28;
            class8.primaryMaleModel = 14072;//male wearing
            class8.primaryFemaleModel = 14072;//female wearing
            class8.spriteCameraYaw = 28;
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Morrigan's javelin";//Name of the new item
            class8.description = "This item degrades in combat, and will turn to dust.".getBytes();//examin info
        }
        if (i == 24014)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.modelId = 14073; //
            class8.stackable = false;//Stackable
            class8.spriteScale = 1000; //zoom increase will make it smaller
            class8.spritePitch = 470; //model rotate up+down increase to move doen away from you
            class8.spriteCameraRoll = 129; //model rotate side ways increase to move right in circle
            class8.spriteTranslateX = -1; // model offset increase to move to the right
            class8.spriteTranslateY = 1; //model offset increase to move up
            class8.spriteCameraYaw = 28;
            class8.primaryMaleModel = 14074;//male wearing
            class8.primaryFemaleModel = 14074;//female wearing
            class8.spriteCameraYaw = 28;
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Morrigan's throwing axe";//Name of the new item
            class8.description = "This item degrades in combat, and will turn to dust.".getBytes();//examin info
        }
        if (i == 26898) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 10377;
            class8.spriteScale = 1500;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 10377;
            class8.primaryFemaleModel = 10377;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Ninja legs";
            class8.description = "Stealthy.".getBytes();
        }
        if (i == 26899) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 10376;
            class8.spriteScale = 700;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 80;
            class8.primaryMaleModel = 10376;
            class8.primaryFemaleModel = 10376;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Ninja Balaclava";
            class8.description = "Stealthy.".getBytes();
        }
        if (i == 26890) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 10312;
            class8.spriteScale = 700;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 80;
            class8.primaryMaleModel = 10312;
            class8.primaryFemaleModel = 10312;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Samurai armor";
            class8.description = "Nice armor from the far east.".getBytes();
        }
        if (i == 26851) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Weild";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 80;
            class8.modifiedModelColors[1] = 6550;
            class8.originalModelColors[1] = 15;
            class8.modifiedModelColors[2] = 6430;
            class8.originalModelColors[2] = 10;
            class8.modelId = 10379;
            class8.spriteScale = 700;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 300;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -14;
            class8.spriteTranslateY = 27;
            class8.primaryMaleModel = 10379;
            class8.primaryFemaleModel = 10379;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Katana";
            class8.description = "Weilded by ninjas.".getBytes();
        }
        if (i == 26852) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Weild";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 10379;
            class8.spriteScale = 700;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 300;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -14;
            class8.spriteTranslateY = 27;
            class8.primaryMaleModel = 5233;
            class8.primaryFemaleModel = 5233;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Katana";
            class8.description = "A nicely crafted sword and holder.".getBytes();
        }
        if (i == 27276) { //Black Plateskirt (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modifiedModelColors[3] = 25238;
            class8.originalModelColors[3] = 0;
            class8.modelId = 4208;
            class8.spriteScale = 1100;
            class8.spritePitch = 620;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = 5;
            class8.primaryMaleModel = 4206;
            class8.primaryFemaleModel = 4207;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Plateskirt (G)";
            class8.description = "It's a Black Plateskirt (G)".getBytes();
        }
        if (i == 23422) { //Black Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platelegs (G)";
            class8.description = "It's Black Platelegs (G)".getBytes();
        }
        if (i == 23423) { //Black Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 0;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platebody (G)";
            class8.description = "It's a Black Platebody (G)".getBytes();
        }
        if (i == 23424) { //Black Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Black Helm (G)";
            class8.description = "It's a Black Helm (G)".getBytes();
        }
        if (i == 23425) { //Black Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Kiteshield (G)";
            class8.description = "It's a Black Kiteshield (G)".getBytes();
        }
        if (i == 23426) { //Black Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platelegs (W)";
            class8.description = "It's Black Platelegs (W)".getBytes();
        }
        if (i == 23427) { //Black Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 0;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platebody (W)";
            class8.description = "It's a Black Platebody (W)".getBytes();
        }
        if (i == 23428) { //Black Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Black Helm (W)";
            class8.description = "It's a Black Helm (W)".getBytes();
        }
        if (i == 23429) { //Black Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Kiteshield (W)";
            class8.description = "It's a Black Kiteshield (W)".getBytes();
        }

        if (i == 23434) { //Black Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platelegs (B)";
            class8.description = "It's Black Platelegs (B)".getBytes();
        }
        if (i == 23435) { //Black Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 0;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platebody (B)";
            class8.description = "It's a Black Platebody (B)".getBytes();
        }
        if (i == 23436) { //Black Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Black Helm (B)";
            class8.description = "It's a Black Helm (B)".getBytes();
        }
        if (i == 23437) { //Black Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Kiteshield (B)";
            class8.description = "It's a Black Kiteshield (B)".getBytes();
        }

        if (i == 23438) { //Black Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platelegs (O)";
            class8.description = "It's Black Platelegs (O)".getBytes();
        }
        if (i == 23439) { //Black Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 0;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platebody (O)";
            class8.description = "It's a Black Platebody (O)".getBytes();
        }
        if (i == 23440) { //Black Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Black Helm (O)";
            class8.description = "It's a Black Helm (O)".getBytes();
        }
        if (i == 23441) { //Black Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Kiteshield (O)";
            class8.description = "It's a Black Kiteshield (O)".getBytes();
        }


        if (i == 27277) { //Black Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platelegs (P)";
            class8.description = "It's Black Platelegs (P)".getBytes();
        }
        if (i == 27278) { //Black Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 0;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Platebody (P)";
            class8.description = "It's a Black Platebody (P)".getBytes();
        }
        if (i == 27279) { //Black Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Black Helm (P)";
            class8.description = "It's a Black Helm (P)".getBytes();
        }
        if (i == 27280) { //Black Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Kiteshield (P)";
            class8.description = "It's a Black Kiteshield (P)".getBytes();
        }
        if (i == 27281) { //Black Plateskirt (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modifiedModelColors[3] = 25238;
            class8.originalModelColors[3] = 0;
            class8.modelId = 4208;
            class8.spriteScale = 1100;
            class8.spritePitch = 620;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = 5;
            class8.primaryMaleModel = 4206;
            class8.primaryFemaleModel = 4207;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Black Plateskirt (P)";
            class8.description = "It's a Black Plateskirt (P)".getBytes();
        }
        if (i == 23442) { //Black Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platelegs (G)";
            class8.description = "It's Bronze Platelegs (G)".getBytes();
        }
        if (i == 23443) { //Black Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 5652;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platebody (G)";
            class8.description = "It's a Bronze Platebody (G)".getBytes();
        }
        if (i == 23444) { //Black Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Bronze Helm (G)";
            class8.description = "It's a Bronze Helm (G)".getBytes();
        }
        if (i == 23445) { //Black Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Kiteshield (G)";
            class8.description = "It's a Bronze Kiteshield (G)".getBytes();
        }
        if (i == 23446) { //Black Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platelegs (W)";
            class8.description = "It's Bronze Platelegs (W)".getBytes();
        }
        if (i == 23447) { //Black Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 5652;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platebody (W)";
            class8.description = "It's a Bronze Platebody (W)".getBytes();
        }
        if (i == 23448) { //Black Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Bronze Helm (W)";
            class8.description = "It's a Bronze Helm (W)".getBytes();
        }
        if (i == 23449) { //Black Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Kiteshield (W)";
            class8.description = "It's a Bronze Kiteshield (W)".getBytes();
        }
        if (i == 23450) { //Black Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platelegs (B)";
            class8.description = "It's Bronze Platelegs (B)".getBytes();
        }
        if (i == 23451) { //Black Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 5652;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platebody (B)";
            class8.description = "It's a Bronze Platebody (B)".getBytes();
        }
        if (i == 23452) { //Black Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Bronze Helm (B)";
            class8.description = "It's a Bronze Helm (B)".getBytes();
        }
        if (i == 23453) { //Black Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Kiteshield (B)";
            class8.description = "It's a Bronze Kiteshield (B)".getBytes();
        }
        if (i == 23454) { //Bronze Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platelegs (O)";
            class8.description = "It's Bronze Platelegs (O)".getBytes();
        }
        if (i == 23455) { //Bronze Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 5652;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platebody (O)";
            class8.description = "It's a Bronze Platebody (O)".getBytes();
        }
        if (i == 23456) { //Bronze Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Bronze Helm (O)";
            class8.description = "It's a Bronze Helm (O)".getBytes();
        }
        if (i == 23457) { //Bronze Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Kiteshield (O)";
            class8.description = "It's a Bronze Kiteshield (O)".getBytes();
        }
        if (i == 23458) { //Bronze Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platelegs (P)";
            class8.description = "It's Bronze Platelegs (P)".getBytes();
        }
        if (i == 23459) { //Bronze Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 5652;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Platebody (P)";
            class8.description = "It's a Bronze Platebody (P)".getBytes();
        }
        if (i == 23460) { //Bronze Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Bronze Helm (P)";
            class8.description = "It's a Bronze Helm (P)".getBytes();
        }
        if (i == 23461) { //Bronze Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 5652;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bronze Kiteshield (P)";
            class8.description = "It's a Bronze Kiteshield (P)".getBytes();
        }
        if (i == 23462) { //Black Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platelegs (G)";
            class8.description = "It's Iron Platelegs (G)".getBytes();
        }
        if (i == 23463) { //Black Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 22464;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 33;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platebody (G)";
            class8.description = "It's a Iron Platebody (G)".getBytes();
        }
        if (i == 23464) { //Black Helm (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 22464;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Iron Helm (G)";
            class8.description = "It's a Iron Helm (G)".getBytes();
        }
        if (i == 23465) { //Black Kiteshield (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 22464;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Kiteshield (G)";
            class8.description = "It's a Iron Kiteshield (G)".getBytes();
        }
        if (i == 23466) { //Black Platelegs (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platelegs (W)";
            class8.description = "It's Iron Platelegs (W)".getBytes();
        }
        if (i == 23467) { //Black Platebody (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 100;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 33;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platebody (W)";
            class8.description = "It's a Iron Platebody (W)".getBytes();
        }
        if (i == 23468) { //Black Helm (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 100;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Iron Helm (W)";
            class8.description = "It's a Iron Helm (W)".getBytes();
        }
        if (i == 23469) { //Black Kiteshield (W)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 100;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Kiteshield (W)";
            class8.description = "It's a Iron Kiteshield (W)".getBytes();
        }
        if (i == 23470) { //Black Platelegs (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platelegs (B)";
            class8.description = "It's Iron Platelegs (B)".getBytes();
        }
        if (i == 23471) { //Black Platebody (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 33;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platebody (B)";
            class8.description = "It's a Iron Platebody (B)".getBytes();
        }
        if (i == 23472) { //Black Helm (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 43968;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Iron Helm (B)";
            class8.description = "It's a Iron Helm (B)".getBytes();
        }
        if (i == 23473) { //Black Kiteshield (B)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 43968;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Kiteshield (B)";
            class8.description = "It's a Iron Kiteshield (B)".getBytes();
        }
        if (i == 23474) { //Iron Platelegs (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platelegs (O)";
            class8.description = "It's Iron Platelegs (O)".getBytes();
        }
        if (i == 23475) { //Iron Platebody (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 33;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platebody (O)";
            class8.description = "It's a Iron Platebody (O)".getBytes();
        }
        if (i == 23476) { //Iron Helm (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 6073;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Iron Helm (O)";
            class8.description = "It's a Iron Helm (O)".getBytes();
        }
        if (i == 23477) { //Iron Kiteshield (O)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 6073;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Kiteshield (O)";
            class8.description = "It's a Iron Kiteshield (O)".getBytes();
        }
        if (i == 23478) { //Iron Platelegs (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platelegs (P)";
            class8.description = "It's Iron Platelegs (P)".getBytes();
        }
        if (i == 23479) { //Iron Platebody (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 51136;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 33;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Platebody (P)";
            class8.description = "It's a Iron Platebody (P)".getBytes();
        }
        if (i == 23480) { //Iron Helm (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 51136;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Iron Helm (P)";
            class8.description = "It's a Iron Helm (P)".getBytes();
        }
        if (i == 23481) { //Iron Kiteshield (P)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 33;
            class8.modifiedModelColors[1] = 57;
            class8.originalModelColors[1] = 33;
            class8.modifiedModelColors[2] = 7054;
            class8.originalModelColors[2] = 51136;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Iron Kiteshield (P)";
            class8.description = "It's a Iron Kiteshield (P)".getBytes();
        }
        if (i == 28785) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 0x1286b;
            class8.spriteScale = 1579;
            class8.spritePitch = 533;
            class8.spriteCameraRoll = 533;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -4;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 0x1286b;
            class8.primaryFemaleModel = 0x1286b;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "@blu@ Ice katana";
            class8.description = "Ghr's ninjas only".getBytes();
        }
        if (i == 6570) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 0;
            class8.originalModelColors[0] = 0;
            class8.modelId = 9631;//item look
            class8.spriteScale = 2000;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 2047;
            class8.spriteTranslateX = -8;
            class8.spriteTranslateY = 12;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Fire Cape";
            class8.description = "A cape of fire.".getBytes();
        }

        if (i == 25618) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 931;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ruby Whip";
            class8.description = "a Ruby Whip".getBytes();
        }


        if (i == 25619) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 33;
            class8.originalModelColors[0] = 931;
            class8.modifiedModelColors[1] = 49;
            class8.originalModelColors[1] = 931;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 931;
            class8.modelId = 2558;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 301;
            class8.primaryFemaleModel = 464;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ruby chainbody";
            class8.description = "a Ruby chainbody".getBytes();
        }

        if (i == 25620) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 24;
            class8.originalModelColors[0] = 931;
            class8.modifiedModelColors[1] = 61;
            class8.originalModelColors[1] = 931;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 931;
            class8.modelId = 2605;
            class8.spriteScale = 1250;
            class8.spritePitch = 488;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 306;
            class8.primaryFemaleModel = 468;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ruby Platebody";
            class8.description = "a Ruby Platebody".getBytes();
        }

        if (i == 25621) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 931;
            class8.modelId = 2833;
            class8.spriteScale = 640;
            class8.spritePitch = 108;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 219;
            class8.primaryFemaleModel = 395;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 57;
            class8.primaryFemaleHeadPiece = 117;
            class8.name = "Ruby Med Helm";
            class8.description = "a Ruby Med Helm".getBytes();
        }

        if (i == 25622) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 931;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 48030;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Ruby full Helm";
            class8.description = "a Ruby full Helm".getBytes();
        }

        if (i == 25623) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 931;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 931;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 931;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ruby Platelegs";
            class8.description = "a Ruby platelegs".getBytes();
        }
        if (i == 24321) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 40;
            class8.originalModelColors[0] = 1;
            class8.modelId = 9631;
            class8.spriteScale = 2000;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 2047;
            class8.primaryMaleModel = 9638;
            class8.primaryFemaleModel = 9638;
            class8.spriteTranslateX = -8;
            class8.spriteTranslateY = 12;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Water Cape";
            class8.description = "A cape of water.".getBytes();
        }
        if (i == 24322) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 40;
            class8.originalModelColors[0] = 50;
            class8.modelId = 9631;
            class8.spriteScale = 2000;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 2047;
            class8.primaryMaleModel = 9638;
            class8.primaryFemaleModel = 9638;
            class8.spriteTranslateX = -8;
            class8.spriteTranslateY = 12;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Water Cape";
            class8.description = "A cape of water.".getBytes();
        }
        if (i == 12324) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 18105;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Lime Green cavalier";
            class8.description = "a Lime Green cavalier".getBytes();
        }
        if (i == 12325) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 45549;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Unknowed White cavalier";
            class8.description = "a Unknowed White cavalier".getBytes();
        }
        if (i == 12326) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 50971;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Deep Purple cavalier";
            class8.description = "a Deep Purple cavalier".getBytes();
        }
        if (i == 12327) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 60176;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Deeprt Purple cavalier";
            class8.description = "a Deeper Purple cavalier".getBytes();
        }
        if (i == 12328) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 19213;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Deep Green cavalier";
            class8.description = "a Deep Green cavalier".getBytes();
        }
        if (i == 12329) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 3654;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Dull Orange cavalier";
            class8.description = "a Dull Orange cavalier".getBytes();
        }
        if (i == 12330) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 12904;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Bright Yellow cavalier";
            class8.description = "a Bright Yellow cavalier".getBytes();
        }
        if (i == 12331) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 618;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Bright Pink cavalier";
            class8.description = "a Bright Pink cavalier".getBytes();
        }
        if (i == 12332) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 46440;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Bright blue cavalier";
            class8.description = "a Bright Blue cavalier".getBytes();
        }
        if (i == 12333) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 11378;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Bright Gray cavalier";
            class8.description = "a Bright Gray cavalier".getBytes();
        }
        if (i == 12334) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 36207;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Bright Sky Blue cavalier";
            class8.description = "a Bright Sky Blue cavalier".getBytes();
        }
        if (i == 12335) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 32562;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Teal cavalier";
            class8.description = "a Teal cavalier".getBytes();
        }
        if (i == 12336) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 8245;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Dark Gray cavalier";
            class8.description = "a Dark Gray cavalier".getBytes();
        }
        if (i == 12366) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 18105;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Lime Green h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12367) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 45549;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Unknowed White h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12368) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 50971;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Deep Purple h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12369) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 60176;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Deeper Purple h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12370) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 19213;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Deep Green h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12370) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 3654;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Dull Orange h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12371) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 12904;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Bright Yellow h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12372) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 618;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Bright PInk h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12373) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 46440;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Bright Blue h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12374) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 11378;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Bright Gray h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12375) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 36207;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Bright Sky Blue h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12376) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 32562;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Teal h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 12377) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 8245;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "Dark Gray h'ween Mask";
            class8.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }

        if (i == 26123) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 7079;
            class8.originalModelColors[0] = 43968;
            class8.modifiedModelColors[1] = 7073;
            class8.originalModelColors[1] = 43968;
            class8.modifiedModelColors[2] = 8111;
            class8.originalModelColors[2] = 43968;
            class8.modifiedModelColors[3] = 8107;
            class8.originalModelColors[3] = 43968;
            class8.modelId = 11074;
            class8.spriteScale = 1000;
            class8.spritePitch = 140;
            class8.spriteCameraRoll = 1796;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 11076;
            class8.primaryFemaleModel = 11076;
            class8.secondaryMaleModel = 11077;
            class8.secondaryFemaleModel = 11077;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "blue Lit bug lantern";
            class8.description = "Its an blue Lit bug lantern".getBytes();
        }

        if (i == 28747) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 57626;
            class8.spriteScale = 2128;
            class8.spritePitch = 431;
            class8.spriteCameraRoll = 10;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 57675;
            class8.primaryFemaleModel = 57675;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Faithful shield";
            class8.description = "Its an Faithful shield.".getBytes();
        }

        if (i == 249) {
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 22418;
            class8.originalModelColors[0] = 22428;
            class8.modifiedModelColors[1] = 22428;
            class8.originalModelColors[1] = 22418;
            class8.modelId = 2364;
            class8.spriteScale = 789;
            class8.spritePitch = 581;
            class8.spriteCameraRoll = 1770;
            class8.spriteCameraYaw = 97;
            class8.spriteTranslateX = 8;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Clean guam";
            class8.description = "Its Clean guam".getBytes();
        }
        if (i == 26213) // Your desired item id (the one you use after ::pickup ##### #)
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear"; // String name, this can be changed to wield, or attach, or whatever you want
            class8.modifiedModelColors = new int[12];
            class8.originalModelColors = new int[12];
            class8.modifiedModelColors[0] = 7884;
            class8.originalModelColors[0] = 588;
            class8.modifiedModelColors[1] = 7856;
            class8.originalModelColors[1] = 578;
            class8.modifiedModelColors[2] = 7892;
            class8.originalModelColors[2] = 596;
            class8.modifiedModelColors[3] = 7876;
            class8.originalModelColors[3] = 580;
            class8.modifiedModelColors[4] = 7860;
            class8.originalModelColors[4] = 564;
            class8.modifiedModelColors[5] = 7864;
            class8.originalModelColors[5] = 568;
            class8.modifiedModelColors[6] = 7880;
            class8.originalModelColors[6] = 584;
            class8.modifiedModelColors[7] = 7880;
            class8.originalModelColors[7] = 576;
            class8.modifiedModelColors[8] = 7872;
            class8.originalModelColors[8] = 578;
            class8.modifiedModelColors[9] = 7888;
            class8.originalModelColors[9] = 580;
            class8.modifiedModelColors[10] = 7848;
            class8.originalModelColors[10] = 578;
            class8.modifiedModelColors[11] = 7856;
            class8.originalModelColors[11] = 578;
            class8.modelId = 51845;
            class8.spriteScale = 2256;
            class8.spritePitch = 456;
            class8.spriteCameraRoll = 513;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 51795;
            class8.primaryFemaleModel = 51795;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Staff of Light"; // Item Name
            class8.description = "Humming with power.".getBytes(); // Item Examine
        }

        if (i == 25124) {
            class8.itemActions = new String[5];
            class8.itemActions[0] = "Choose-dice";
            class8.modelId = 47850;
            class8.spriteScale = 1104;
            class8.spritePitch = 215;
            class8.spriteCameraRoll = 94;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dice bag";
            class8.description = "Its a Dice Bag".getBytes();
        }
        if (i == 24670) {
            Jukkyname("Mod Sgs Platebody V.2", "Made By Mod Sgsrocks From Godzhell.");
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors = new int[8];
            Jukkycolors(61, 47009, 0);
            Jukkycolors(24, 64162, 1);
            Jukkycolors(41, 47009, 2);
            Jukkycolors(10394, 47009, 3);
            Jukkycolors(10518, 64162, 4);
            Jukkycolors(10388, 64162, 5);
            Jukkycolors(10514, 64162, 6);
            Jukkycolors(10508, 64162, 7);
            Jukkyzoom(1380, 452, 0, 0, 0, -1, -1, -1, false);
            JukkyModels(6646, 3379, 6685, 3383, 2378);
        }
        if (i == 24671) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 47009;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 64162;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.modelId = 5026;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Mod Sgs Platelegs V.2";
            class8.description = "Made By Mod Sgsrocks From Godzhell.".getBytes();
        }
        if (i == 24536) {
            class8.itemActions = new String[5];
            class8.itemActions[0] = "Read";
            class8.itemActions[4] = "Destroy";
            class8.modelId = 44853;
            class8.spriteScale = 1114;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 138;
            class8.spriteCameraYaw = 83;
            class8.spriteTranslateX = 4;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Turkey book";
            class8.description = "Its a Turkey book".getBytes();
        }
        if (i == 24537) {
            class8.itemActions = new String[5];
            class8.itemActions[0] = "Heal";
            class8.itemActions[1] = "Food-Count";
            class8.itemActions[4] = "Destroy";
            class8.modelId = 44855;
            class8.spriteScale = 1616;
            class8.spritePitch = 221;
            class8.spriteCameraRoll = 168;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -73;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cornucopia";
            class8.description = "Its a Cornucopia".getBytes();
        }
        if (i == 24538) {
            class8.itemActions = new String[5];
            class8.itemActions[0] = "Heal";
            class8.itemActions[1] = "Food-Count";
            class8.itemActions[4] = "Destroy";
            class8.modelId = 44857;
            class8.spriteScale = 1616;
            class8.spritePitch = 221;
            class8.spriteCameraRoll = 168;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -73;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cornucopia";
            class8.description = "Its a Cornucopia".getBytes();
        }
        if (i == 24539) {
            class8.itemActions = new String[5];
            //class8.aStringArray189[0] = "Heal";
//class8.aStringArray189[1] = "Food-Count";
//class8.aStringArray189[4] = "Destroy";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 5784;
            class8.originalModelColors[0] = 200;
            class8.modifiedModelColors[1] = 5786;
            class8.originalModelColors[1] = 202;
            class8.modifiedModelColors[2] = 5788;
            class8.originalModelColors[2] = 204;
            class8.modifiedModelColors[3] = 5790;
            class8.originalModelColors[3] = 206;
            class8.modelId = 44856;
            class8.spriteScale = 2000;
            class8.spritePitch = 194;
            class8.spriteCameraRoll = 1563;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -5;
            class8.spriteTranslateY = -15;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Raw turkey";
            class8.description = "Its a Raw turkey".getBytes();
        }
        if (i == 24540) {
            class8.itemActions = new String[5];
            class8.itemActions[0] = "Eat";
            //class8.aStringArray189[1] = "Food-Count";
            //class8.aStringArray189[4] = "Destroy";
            //class8.anIntArray156 = new int[4];
            //class8.anIntArray160 = new int[4];
            //class8.anIntArray156[0] = 5784;
            //class8.anIntArray160[0] = 200;
            //class8.anIntArray156[1] = 5786;
            //class8.anIntArray160[1] = 202;
            //class8.anIntArray156[2] = 5788;
            //class8.anIntArray160[2] = 204;
            //class8.anIntArray156[3] = 5790;
            //class8.anIntArray160[3] = 206;
            class8.modelId = 44856;
            class8.spriteScale = 2000;
            class8.spritePitch = 194;
            class8.spriteCameraRoll = 1563;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -5;
            class8.spriteTranslateY = -15;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cooked turkey";
            class8.description = "Its a Cooked turkey".getBytes();
        }
        if (i == 24541) {
            class8.itemActions = new String[5];
            //class8.aStringArray189[0] = "Eat";
//class8.aStringArray189[1] = "Food-Count";
//class8.aStringArray189[4] = "Destroy";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 5784;
            class8.originalModelColors[0] = 20;
            class8.modifiedModelColors[1] = 5786;
            class8.originalModelColors[1] = 22;
            class8.modifiedModelColors[2] = 5788;
            class8.originalModelColors[2] = 24;
            class8.modifiedModelColors[3] = 5790;
            class8.originalModelColors[3] = 26;
            class8.modelId = 44856;
            class8.spriteScale = 2000;
            class8.spritePitch = 194;
            class8.spriteCameraRoll = 1563;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -5;
            class8.spriteTranslateY = -15;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Burnt turkey";
            class8.description = "Its a Burnt turkey".getBytes();
        }
        if (i == 24542) {
            class8.itemActions = new String[5];
            //class8.aStringArray189[0] = "Heal";
//class8.aStringArray189[1] = "Food-Count";
//class8.aStringArray189[4] = "Destroy";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 5784;
            class8.originalModelColors[0] = 200;
            class8.modifiedModelColors[1] = 5786;
            class8.originalModelColors[1] = 202;
            class8.modifiedModelColors[2] = 5788;
            class8.originalModelColors[2] = 204;
            class8.modifiedModelColors[3] = 5790;
            class8.originalModelColors[3] = 206;
            class8.modelId = 44854;
            class8.spriteScale = 1616;
            class8.spritePitch = 484;
            class8.spriteCameraRoll = 498;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -9;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Raw turkey drumstick";
            class8.description = "Its a Raw turkey drumstick".getBytes();
        }
        if (i == 24543) {
            class8.itemActions = new String[5];
            class8.itemActions[0] = "Eat";
            //class8.aStringArray189[1] = "Food-Count";
            //class8.aStringArray189[4] = "Destroy";
            //class8.anIntArray156 = new int[4];
            //class8.anIntArray160 = new int[4];
            //class8.anIntArray156[0] = 5784;
            //class8.anIntArray160[0] = 200;
            //class8.anIntArray156[1] = 5786;
            //class8.anIntArray160[1] = 202;
            //class8.anIntArray156[2] = 5788;
            //class8.anIntArray160[2] = 204;
            //class8.anIntArray156[3] = 5790;
            //class8.anIntArray160[3] = 206;
            class8.modelId = 44854;
            class8.spriteScale = 1616;
            class8.spritePitch = 484;
            class8.spriteCameraRoll = 498;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -9;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cooked turkey drumstick";
            class8.description = "Its a Cooked turkey drumstick".getBytes();
        }
        if (i == 24544) {
            class8.itemActions = new String[5];
            //class8.aStringArray189[0] = "Eat";
//class8.aStringArray189[1] = "Food-Count";
//class8.aStringArray189[4] = "Destroy";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 5784;
            class8.originalModelColors[0] = 20;
            class8.modifiedModelColors[1] = 5786;
            class8.originalModelColors[1] = 22;
            class8.modifiedModelColors[2] = 5788;
            class8.originalModelColors[2] = 24;
            class8.modifiedModelColors[3] = 5790;
            class8.originalModelColors[3] = 26;
            class8.modelId = 44854;
            class8.spriteScale = 1616;
            class8.spritePitch = 484;
            class8.spriteCameraRoll = 498;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -9;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Burnt turkey drumstick";
            class8.description = "Its a Burnt turkey drumstick".getBytes();
        }
        if (i == 28432)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";//New option
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 70728; //Model ID
            class8.spriteScale = 1772;
            class8.spritePitch = 512;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 70665;//male wearing
            class8.primaryFemaleModel = 70665;//female wearing
            class8.stackable = false;//Stackable
            class8.name = "Dragonbone platelegs";//Name of the new item
            class8.description = "Looks pretty heavy. And mean. And bony.".getBytes();//examin info
        }
        if (i == 12378) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 18105;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Lime Green beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12379) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 45549;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Unknowed White beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12380) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 50971;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Deep Purple beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12381) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 60176;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Deeper Purple beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12382) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 19213;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Deep Green beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12383) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 3654;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Dull Orange beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12384) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 12904;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Bright Yellow beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12385) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 618;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Bright PInk beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12386) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 46440;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Bright Blue beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12387) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 11378;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Bright Gray beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12388) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 36207;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Bright Sky Blue beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12389) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 32562;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Teal beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }
        if (i == 12390) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 10659;
            class8.originalModelColors[0] = 8245;
            class8.modelId = 3373;
            class8.spriteScale = 560;
            class8.spritePitch = 136;
            class8.spriteCameraRoll = 1936;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 198;
            class8.primaryFemaleModel = 373;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 40;
            class8.primaryFemaleHeadPiece = 98;
            class8.name = "Dark Gray beret";
            class8.description = "Parlez-voius francais?".getBytes();
        }

        return class8;
    }

    public static ItemDefinition method198_3(int i, ItemDefinition class8) {

        if (i == 28365) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 4445;
            class8.primaryMaleModel = 4446;
            class8.primaryFemaleModel = 4446;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.spriteScale = 2151;
            class8.spritePitch = 429;
            class8.spriteCameraRoll = 1189;
            class8.spriteTranslateY = 5;
            class8.name = "Sword of 1000 truths";
            class8.description = "Lich King sword".getBytes();
        }
        if (i == 28358) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 62692;
            class8.primaryMaleModel = 62750;
            class8.primaryFemaleModel = 62750;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.spriteScale = 2151;
            class8.spritePitch = 429;
            class8.spriteCameraRoll = 1189;
            class8.spriteTranslateY = 5;
            class8.name = "Zaryte Bow";
            class8.description = "A powerful bow".getBytes();
        }

        if (i == 23482) { //Black Platelegs (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 11200;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 11200;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 0;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Kyubi Legs";
            class8.description = "It's Kurama's legs".getBytes();
        }

        if (i == 23483) { //Black Platebody (G)
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 11200;
            class8.modifiedModelColors[1] = 24;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 11200;
            class8.modelId = 2378;
            class8.spriteScale = 1180;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 3379;
            class8.primaryFemaleModel = 3383;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Kyubi Platebody";
            class8.description = "It's Kurama's body".getBytes();
        }
        if (i == 29568) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 23708;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 23708;
            class8.modelId = 23708;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "RPG";
            class8.description = "From Halo".getBytes();
        }
        if (i == 29567) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 39029;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 39029;
            class8.modelId = 39029;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Scarlet Spirit Shield";
            class8.description = "Spirit Shield".getBytes();
        }
        if (i == 29566) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 71126;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 71126;
            class8.modelId = 71126;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Off-Hand Drygore Rapier";
            class8.description = "Off-hand".getBytes();
        }
        if (i == 29565) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 72117;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 72117;
            class8.modelId = 72117;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Spine Cape";
            class8.description = "Ripped from a monster".getBytes();
        }
        if (i == 29564) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 72119;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 72119;
            class8.modelId = 72120;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chain Chomp";
            class8.description = "Ripped from mario".getBytes();
        }
        if (i == 29563) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70001;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70001;
            class8.modelId = 70000;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Knightmare Plate";
            class8.description = "Death".getBytes();
        }
        if (i == 29562) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70003;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70003;
            class8.modelId = 70002;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Knightmare Legs";
            class8.description = "Death".getBytes();
        }
        if (i == 29561) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70005;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70005;
            class8.modelId = 70004;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Knightmare Boots";
            class8.description = "Death".getBytes();
        }
        if (i == 29560) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70007;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70007;
            class8.modelId = 70006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Knightmare Gloves";
            class8.description = "Death".getBytes();
        }
        if (i == 29559) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70009;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70009;
            class8.modelId = 70008;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Knightmare Helm";
            class8.description = "Death".getBytes();
        }
        if (i == 29558) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70011;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70011;
            class8.modelId = 70010;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Soul Edge";
            class8.description = "Sword that destroys souls".getBytes();
        }
        if (i == 29557) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70012;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70012;
            class8.modelId = 70012;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Claws Cape";
            class8.description = "Dragon Claws Cape".getBytes();
        }
        if (i == 29556) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70013;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70013;
            class8.modelId = 70013;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pacman Cape";
            class8.description = "Pacman!".getBytes();
        }
        if (i == 29555) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70014;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70014;
            class8.modelId = 70014;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Seth Sword";
            class8.description = "Sword that destroys cows".getBytes();
        }
        if (i == 29554) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 22;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 22;
            class8.modelId = 604;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Swoc Sword";
            class8.description = "Sword that destroys cows".getBytes();
        }
        if (i == 29553) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 80040;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 80040;
            class8.modelId = 80041;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Plate";
            class8.description = "Death".getBytes();
        }
        if (i == 29552) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95041;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95041;
            class8.modelId = 95043;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Legs";
            class8.description = "Death".getBytes();
        }
        if (i == 29551) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 63301;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 63301;
            class8.modelId = 63300;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Boots";
            class8.description = "Death".getBytes();
        }
        if (i == 29550) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 75667;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 75667;
            class8.modelId = 75666;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Gloves";
            class8.description = "Death".getBytes();
        }
        if (i == 29549) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 75665;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 75665;
            class8.modelId = 75664;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Helm";
            class8.description = "Death".getBytes();
        }
        if (i == 29548) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 62113;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 62113;
            class8.modelId = 62112;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Cape";
            class8.description = "Cape that destroys souls".getBytes();
        }

        if (i == 29547) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 62109;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 62109;
            class8.modelId = 62108;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Coffin Shield";
            class8.description = "Shield that destroys souls".getBytes();
        }
        if (i == 29546) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93095;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93095;
            class8.modelId = 93096;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Light Plate";
            class8.description = "Death".getBytes();
        }
        if (i == 29545) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93093;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93093;
            class8.modelId = 93094;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Light Legs";
            class8.description = "Death".getBytes();
        }
        if (i == 29544) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93045;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93045;
            class8.modelId = 93046;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Light Helmet";
            class8.description = "Death".getBytes();
        }
        if (i == 29543) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 81000;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 81000;
            class8.modelId = 81001;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Sexy Cape";
            class8.description = "Cape that shows sexyness".getBytes();
        }
        if (i == 29542) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 62101;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 62101;
            class8.modelId = 62100;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cow Cape";
            class8.description = "Cape that shows sexyness".getBytes();
        }
        if (i == 29541) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 87656;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 27656;
            class8.modelId = 27657;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Quest Cape";
            class8.description = "Cape that shows sexyness".getBytes();
        }
        if (i == 29540) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93001;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93001;
            class8.modelId = 93002;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Master Admin Cape";
            class8.description = "Admin Cape".getBytes();
        }
        if (i == 29539) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95012;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95012;
            class8.modelId = 95011;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Kiln Cape";
            class8.description = "Killed Jad".getBytes();
        }
        if (i == 29538) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 81066;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 81066;
            class8.modelId = 81067;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29537) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 73122;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 73122;
            class8.modelId = 73121;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bob Cape";
            class8.description = "Made by Joel".getBytes();
        }
        if (i == 29536) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 96500;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 96500;
            class8.modelId = 96501;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Veteran Cape";
            class8.description = "SwocScape vet".getBytes();
        }
        if (i == 29535) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95047;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95047;
            class8.modelId = 95048;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pyrebob Shield 2";
            class8.description = "Fire Shield".getBytes();
        }

        if (i == 29534) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95045;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95045;
            class8.modelId = 95046;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pyrebob Sword";
            class8.description = "Fire Sword".getBytes();
        }
        if (i == 29533) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 54555;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 54555;
            class8.modelId = 81063;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Golden Platelegs";
            class8.description = "Gold".getBytes();
        }
        if (i == 29532) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 72061;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 72061;
            class8.modelId = 72060;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Golden Plate";
            class8.description = "Gold".getBytes();
        }
        if (i == 29531) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 81020;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 81020;
            class8.modelId = 81021;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Sword of Ages";
            class8.description = "From MS".getBytes();
        }
        if (i == 29530) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 81030;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 81030;
            class8.modelId = 81031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Sword of the Sea";
            class8.description = "From MS".getBytes();
        }
        if (i == 29529) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 81026;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 81026;
            class8.modelId = 81027;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Slenderman Tenticles";
            class8.description = "From Slenderman".getBytes();
        }
        if (i == 29528) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 72049;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 72049;
            class8.modelId = 72048;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Sword of spirits";
            class8.description = "From MS".getBytes();
        }
        if (i == 29527) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93031;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93031;
            class8.modelId = 93032;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Blades";
            class8.description = "Rainbow Sword".getBytes();
        }
        if (i == 29526) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 80014;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 80014;
            class8.modelId = 80015;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Hween";
            class8.description = "Rainbow Hween".getBytes();
        }
        if (i == 29525) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 28998;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 28998;
            class8.modelId = 28999;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Claws";
            class8.description = "Rainbow Claws".getBytes();
        }
        if (i == 29524) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 80012;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 80012;
            class8.modelId = 80013;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Cav";
            class8.description = "Rainbow Cav".getBytes();
        }
        if (i == 29523) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 58050;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 58050;
            class8.modelId = 58051;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Whip";
            class8.description = "Rainbow Whip".getBytes();
        }
        if (i == 29522) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93057;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93057;
            class8.modelId = 93058;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Crown";
            class8.description = "Rainbow Crown".getBytes();
        }
        if (i == 29521) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95037;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95037;
            class8.modelId = 95038;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Drygore Legs";
            class8.description = "Drygore".getBytes();
        }
        if (i == 29520) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95008;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95008;
            class8.modelId = 95022;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Drygore Plate";
            class8.description = "Drygore".getBytes();
        }
        if (i == 29519) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93077;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93077;
            class8.modelId = 93078;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Wolf Helm";
            class8.description = "Wolf".getBytes();
        }
        if (i == 29518) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 95077;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 95077;
            class8.modelId = 95078;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Superman Cape";
            class8.description = "Superman".getBytes();
        }
        if (i == 29517) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93101;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93101;
            class8.modelId = 93102;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Superman Plate";
            class8.description = "Superman".getBytes();
        }
        if (i == 29516) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 93099;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 93099;
            class8.modelId = 93100;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Superman Legs";
            class8.description = "Superman".getBytes();
        }
        if (i == 29515) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 53006;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 53006;
            class8.modelId = 53006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cool Cape";
            class8.description = "Cape".getBytes();
        }

        if (i == 29505) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70533;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70533;
            class8.modelId = 69597;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Monkey Cape";
            class8.description = "Cape".getBytes();
        }
        if (i == 29506) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 9995;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 9995;
            class8.modelId = 62853;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Plate";
            class8.description = "Death".getBytes();
        }
        if (i == 29507) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 9996;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 9996;
            class8.modelId = 62773;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Legs";
            class8.description = "Death".getBytes();
        }
        if (i == 29508) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 70949;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 70949;
            class8.modelId = 70962;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Rainbow Skull";
            class8.description = "Death".getBytes();
        }
        if (i == 29510) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 71936;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 71936;
            class8.modelId = 71935;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Summoning Shield";
            class8.description = "Death".getBytes();
        }
        if (i == 29511) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 71932;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 71932;
            class8.modelId = 71931;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Slayer Shield";
            class8.description = "Death".getBytes();
        }
        if (i == 29512) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 8883;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 8883;
            class8.modelId = 8884;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Strength Shield";
            class8.description = "Death".getBytes();
        }
        if (i == 29513) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 62826;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 62826;
            class8.modelId = 62827;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Swoc Shield";
            class8.description = "Death".getBytes();
        }
        if (i == 29514) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 71995;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 71995;
            class8.modelId = 71996;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Shark Fists";
            class8.description = "Death".getBytes();
        }
        if (i == 29501) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 71987;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 71987;
            class8.modelId = 71986;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Golden Scythe";
            class8.description = "Death".getBytes();
        }
        if (i == 29500) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19500;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19500;
            class8.modelId = 19500;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Wings";
            class8.description = "Pure Demon".getBytes();
        }
        if (i == 29499) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19501;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19501;
            class8.modelId = 19502;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Slayer Cape";
            class8.description = "Death".getBytes();
        }
        if (i == 29498) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 14390;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 14390;
            class8.modelId = 14390;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Corrupt Wings";
            class8.description = "Death".getBytes();
        }
        if (i == 29497) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 18865;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 18865;
            class8.modelId = 18865;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Batarang";
            class8.description = "Batman".getBytes();
        }
        if (i == 29496) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 18864;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 18864;
            class8.modelId = 18864;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dark Knight cape";
            class8.description = "Batman".getBytes();
        }
        if (i == 29495) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 18862;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 18862;
            class8.modelId = 18862;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Butterfly Wings";
            class8.description = "wings".getBytes();
        }
        if (i == 29494) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 66433;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 66433;
            class8.modelId = 66433;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pegasus Suit";
            class8.description = "boom".getBytes();
        }
        if (i == 29493) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 67890;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 67890;
            class8.modelId = 67891;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Demon Plate";
            class8.description = "demons".getBytes();
        }
        if (i == 29492) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 61666;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 61666;
            class8.modelId = 61666;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Jail Orb";
            class8.description = "demons".getBytes();
        }
        if (i == 29491) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19490;
            class8.spriteScale = 2000;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryFemaleModel = 19490;
            class8.modelId = 19490;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Owner Hat";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29490) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19489;
            class8.spriteScale = 1300;
            class8.spritePitch = 300;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 0;
            class8.primaryFemaleModel = 19489;
            class8.modelId = 19489;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Owner Plate";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29489) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19488;
            class8.spriteScale = 1740;
            class8.spritePitch = 300;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryFemaleModel = 19488;
            class8.modelId = 19488;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Owner Legs";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29488) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19487;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19487;
            class8.modelId = 19487;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Owner Cape";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29487) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19486;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19486;
            class8.modelId = 19486;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Owner Gloves";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29486) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 19485;
            class8.spriteScale = 595;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.noteable = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 19485;
            class8.primaryFemaleModel = 19485;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Owner Boots";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29485) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 19484;
            class8.spriteScale = 595;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.noteable = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 19484;
            class8.primaryFemaleModel = 19484;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Seth Hood";
            class8.description = "Seth's noob hood".getBytes();
        }
        if (i == 29484) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19483;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19483;
            class8.modelId = 19483;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Seth Body";
            class8.description = "Seth's noob body".getBytes();
        }
        if (i == 29483) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19482;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19482;
            class8.modelId = 19482;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Seth Chaps";
            class8.description = "Seth's noob chaps".getBytes();
        }
        if (i == 29482) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19481;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19481;
            class8.modelId = 19481;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deathtouch Dart";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29481) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19480;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19480;
            class8.modelId = 19480;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Corruption Cape";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29480) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19479;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19479;
            class8.modelId = 19479;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Tattered Wings";
            class8.description = "Swoc".getBytes();
        }
        if (i == 29479) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19478;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19478;
            class8.modelId = 19477;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Torva Cape";
            class8.description = "Torva cape".getBytes();
        }
        if (i == 29478) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19476;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19476;
            class8.modelId = 19475;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deadric Bow";
            class8.description = "From Skyrim".getBytes();
        }
        if (i == 29477) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19474;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19474;
            class8.modelId = 19474;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Obliteration";
            class8.description = "Weapon of Destruction".getBytes();
        }
        if (i == 29476) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19473;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19473;
            class8.modelId = 19473;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Brutal Claws";
            class8.description = "Weapon of Destruction".getBytes();

        }
        if (i == 29475) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19471;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19471;
            class8.modelId = 19472;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Beats Headset";
            class8.description = "Red Beats".getBytes();
        }
        if (i == 29474) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19470;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19470;
            class8.modelId = 19470;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Cow Head";
            class8.description = "Cow".getBytes();
        }
        if (i == 29473) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19469;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19469;
            class8.modelId = 19469;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Sun Glasses";
            class8.description = "Shades".getBytes();
        }
        if (i == 29472) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19467;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19467;
            class8.modelId = 19468;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Master Admin Cape";
            class8.description = "Admin".getBytes();
        }
        if (i == 29471) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 19465;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 19465;
            class8.modelId = 19466;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Master Mod Cape";
            class8.description = "Mod".getBytes();
        }
        if (i == 29470) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 50333;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 50333;
            class8.modelId = 50332;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Wolf Head";
            class8.description = "In memory of a fallen hunter".getBytes();
        }
        if (i == 29469) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 50335;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 50335;
            class8.modelId = 50334;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Wolf Plate";
            class8.description = "In memory of a fallen hunter".getBytes();
        }
        if (i == 29468) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 50337;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 50337;
            class8.modelId = 50336;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Wolf Bow";
            class8.description = "In memory of a fallen hunter".getBytes();
        }
        if (i == 29467) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.primaryMaleModel = 50339;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 50339;
            class8.modelId = 50338;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Wolf Legs";
            class8.description = "In memory of a fallen hunter".getBytes();
        }
        if (i == 12391) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 18105;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Lime Green Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12392) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 45549;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Unknowed White Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12393) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 50971;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deep Purple Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12394) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 60176;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deeper Purple Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12395) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 19213;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Deep Green Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12396) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 3654;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dull Orange Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12397) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 12904;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Yellow Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12398) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 618;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright PInk Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12399) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 46440;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Blue Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12400) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 11378;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Gray Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12401) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 36207;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Bright Sky Blue Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12402) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 32562;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Teal Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 12403) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 9529;
            class8.originalModelColors[0] = 8245;
            class8.modelId = 7079;
            class8.spriteScale = 730;
            class8.spritePitch = 584;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 7000;
            class8.primaryFemaleModel = 7006;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dark Gray Shorts";
            class8.description = "These look great, on dwarves!".getBytes();
        }
        if (i == 25339) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 82217;
            class8.spriteScale = 2000;
            class8.spritePitch = 228;
            class8.spriteCameraRoll = 1985;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = -55;
            class8.primaryMaleModel = 82125;
            class8.primaryFemaleModel = 82125;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "X-MAS godsword";
            class8.description = "Its a Armadyl godsword".getBytes();
        }
        if (i == 11346) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 64208;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 64209;// wield
            class8.primaryFemaleModel = 64209;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Orange Energy sword";
            class8.description = "An Orange Energy Sword".getBytes();
        }
        if (i == 11347) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 67221;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 67222;// wield
            class8.primaryFemaleModel = 67222;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Halloween Energy sword";
            class8.description = "From traxxas Have a Happy Halloween =)".getBytes();
        }
        if (i == 11348) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 67223;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 67224;// wield
            class8.primaryFemaleModel = 67224;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Bronze Energy sword";
            class8.description = "an energy sword made of bronze.".getBytes();
        }
        if (i == 11349) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 67225;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 67226;// wield
            class8.primaryFemaleModel = 67226;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Steel Energy sword";
            class8.description = "an energy sword made of steel.".getBytes();
        }
        if (i == 11350) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 67227;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 67228;// wield
            class8.primaryFemaleModel = 67228;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Mithril Energy sword";
            class8.description = "an energy sword made of mithril.".getBytes();
        }
        if (i == 11351) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 67229;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 67230;// wield
            class8.primaryFemaleModel = 67230;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Adamant Energy sword";
            class8.description = "an energy sword made of adamant.".getBytes();
        }
        if (i == 11352) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 67231;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 67232;// wield
            class8.primaryFemaleModel = 67232;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
// class8.aBoolean176 = false;
            class8.name = "Rune Energy sword";
            class8.description = "an energy sword made of rune.".getBytes();
        }
        if (i == 22215) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 508;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 492;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 508;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 492;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22216) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 7663;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 7647;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 7663;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 7647;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22217) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 40374;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 40358;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 40374;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 40358;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22218) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 26934;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 26918;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 26934;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 26918;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22219) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 2192;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 2192;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 2192;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 2192;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 30169) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 62700;
            class8.spriteScale = 1740;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 2045;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 4;
            class8.primaryMaleModel = 62742;
            class8.primaryFemaleModel = 62758;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Virtus robe legs";
            class8.description = "its an Virtus robe legs".getBytes();
        }

        if (i == 30165) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 62704;
            class8.spriteScale = 1122;
            class8.spritePitch = 488;
            class8.spriteCameraRoll = 3;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 62748;
            class8.primaryFemaleModel = 62764;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Virtus robe top";
            class8.description = "its an Virtus robe top".getBytes();
        }

        if (i == 30159) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 62710;
            class8.spriteScale = 928;
            class8.spritePitch = 406;
            class8.spriteCameraRoll = 2041;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 62736;
            class8.primaryFemaleModel = 62755;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 62728;
            class8.primaryFemaleHeadPiece = 62728;
            class8.name = "Virtus Mask";
            class8.description = "its an Virtus Mask".getBytes();
        }
        if (i == 24595) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45273;
            class8.spriteScale = 1360;
            class8.spritePitch = 561;
            class8.spriteCameraRoll = 6;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = 45192;
            class8.primaryFemaleModel = 45199;
            class8.secondaryMaleModel = 45188;
            class8.secondaryFemaleModel = 45197;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa costume top";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24596) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45276;
            class8.spriteScale = 1020;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 2020;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -16;
            class8.primaryMaleModel = 45194;
            class8.primaryFemaleModel = 45201;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ice amulet";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24599) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45276;
            class8.spriteScale = 1020;
            class8.spritePitch = 332;
            class8.spriteCameraRoll = 2020;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -16;
            class8.primaryMaleModel = 45194;
            class8.primaryFemaleModel = 45201;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Ice amulet";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24601) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45278;
            class8.spriteScale = 1114;
            class8.spritePitch = 512;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = 4;
            class8.primaryMaleModel = 45192;
            class8.primaryFemaleModel = 45199;
            class8.secondaryMaleModel = 45188;
            class8.secondaryFemaleModel = 45197;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa costume top";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24602) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45280;
            class8.spriteScale = 659;
            class8.spritePitch = 420;
            class8.spriteCameraRoll = 828;
            class8.spriteCameraYaw = 97;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 45196;
            class8.primaryFemaleModel = 45203;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa costume gloves";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24603) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45275;
            class8.spriteScale = 1872;
            class8.spritePitch = 541;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 4;
            class8.primaryMaleModel = 45195;
            class8.primaryFemaleModel = 45202;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa costume legs";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24604) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45275;
            class8.spriteScale = 1872;
            class8.spritePitch = 541;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 4;
            class8.primaryMaleModel = 45195;
            class8.primaryFemaleModel = 45202;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa costume legs";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24605) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 45272;
            class8.spriteScale = 770;
            class8.spritePitch = 62;
            class8.spriteCameraRoll = 124;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 4;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 45191;
            class8.primaryFemaleModel = 45198;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Santa costume boots";
            class8.description = "Merry X-mas! from traxxas. 2014!".getBytes();
        }
        if (i == 24524) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 99552;
            class8.spriteScale = 770;
            class8.spritePitch = 62;
            class8.spriteCameraRoll = 124;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 4;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 99552;
            class8.primaryFemaleModel = 99552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "rasta wings";
            class8.description = "test".getBytes();
        }
        if (i == 25612) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            // class8.anIntArray156 = new int[1];
//class8.anIntArray160 = new int[1];
//class8.anIntArray160[0] = 32984;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 95409;
            class8.primaryFemaleModel = 95409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Tri Whip";
            class8.description = "a tri Whip".getBytes();
        }
        if (i == 31338) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 84200;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 84201;// wield
            class8.primaryFemaleModel = 84201;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Duel Energy swords";
            class8.description = "A strong swords made of energy.".getBytes();
        }
        if (i == 31690) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Dismantle";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
//class8.anIntArray156[0] = 61;
//class8.anIntArray160[0] = 5652;
            class8.modelId = 88162;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 87731;
            class8.primaryFemaleModel = 87731;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Tri Armadyl godsword";
            class8.description = "Its a Tri Armadyl godsword".getBytes();
        }
        if (i == 30111) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
//class8.anIntArray156[0] = 61;
//class8.anIntArray160[0] = 5652;
            class8.modelId = 98162;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 98162;
            class8.primaryFemaleModel = 98162;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blue halo";
            class8.description = "Its a halo".getBytes();
        }
        if (i == 30112) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
//class8.anIntArray156[0] = 61;
//class8.anIntArray160[0] = 5652;
            class8.modelId = 98163;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 98163;
            class8.primaryFemaleModel = 98163;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Green halo";
            class8.description = "Its a halo".getBytes();
        }
        if (i == 30113) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
//class8.anIntArray156[0] = 61;
//class8.anIntArray160[0] = 5652;
            class8.modelId = 98164;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 98164;
            class8.primaryFemaleModel = 98164;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pink halo";
            class8.description = "Its a halo".getBytes();
        }

        if (i == 30114) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
//class8.anIntArray156[0] = 61;
//class8.anIntArray160[0] = 5652;
            class8.modelId = 98165;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 98165;
            class8.primaryFemaleModel = 98165;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Red halo";
            class8.description = "Its a halo".getBytes();
        }

        if (i == 30115) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
//class8.anIntArray156[0] = 61;
//class8.anIntArray160[0] = 5652;
            class8.modelId = 98166;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 98166;
            class8.primaryFemaleModel = 98166;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Yellow halo";
            class8.description = "Its a halo".getBytes();
        }
        if (i == 12637) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 28844;
            class8.spriteScale = 550;
            class8.spritePitch = 228;
            class8.spriteCameraRoll = 141;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = 87630;
            class8.primaryFemaleModel = 88833;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Saradomin halo";
            class8.description = "a Saradomin halo".getBytes();
        }
        if (i == 12638) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 28838;
            class8.spriteScale = 528;
            class8.spritePitch = 327;
            class8.spriteCameraRoll = 213;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 12;
            class8.primaryMaleModel = 87643;
            class8.primaryFemaleModel = 88832;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Zamorak halo";
            class8.description = "a Zamorak halo".getBytes();
        }
        if (i == 12639) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 28837;
            class8.spriteScale = 528;
            class8.spritePitch = 294;
            class8.spriteCameraRoll = 123;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 87642;
            class8.primaryFemaleModel = 88831;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Guthix halo";
            class8.description = "a Guthix halo".getBytes();
        }

        if (i == 22639) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 93866;
            class8.spriteScale = 944;
            class8.spritePitch = 294;
            class8.spriteCameraRoll = 123;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 93866;
            class8.primaryFemaleModel = 93866;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Paradox Wings";
            class8.description = "epic right??".getBytes();
        }
        if (i == 22640) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 93865;
            class8.spriteScale = 528;
            class8.spritePitch = 294;
            class8.spriteCameraRoll = 123;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 93865;
            class8.primaryFemaleModel = 93865;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Crystalline wings";
            class8.description = "epic right??".getBytes();
        }
        if (i == 22641) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 93265;
            class8.spriteScale = 528;
            class8.spritePitch = 294;
            class8.spriteCameraRoll = 123;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 20;
            class8.primaryMaleModel = 93266;
            class8.primaryFemaleModel = 93266;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Owen 2h sword";
            class8.description = "an Owen 2h sword.".getBytes();
        }
        if(i == 26835) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 61;
            class8.originalModelColors[1] = 1000;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "2008 H\'ween boots";
            class8.description = "The 2008 Halloween event boots.".getBytes();
        }

        if(i == 26836) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 12;
            class8.modifiedModelColors[1] = 912;
            class8.originalModelColors[1] = 908;
            class8.modelId = 5026;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "2008 H\'ween legs";
            class8.description = "The 2008 Halloween event platelegs.".getBytes();
        }

        if(i == 26837) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 10266;
            class8.originalModelColors[0] = 12;
            class8.modifiedModelColors[1] = 3171;
            class8.originalModelColors[1] = 908;
            class8.modelId = 8733;
            class8.spriteScale = 1190;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 8733;
            class8.primaryFemaleModel = 8736;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "2008 H\'ween plate";
            class8.description = "The 2008 Halloween event Platebody...".getBytes();
        }

        if(i == 26838) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 10283;
            class8.originalModelColors[0] = 12;
            class8.modifiedModelColors[1] = 10270;
            class8.originalModelColors[1] = 908;
            class8.modelId = 8700;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 8726;
            class8.primaryFemaleModel = 8750;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "2008 H\'ween gloves";
            class8.description = "2008 Halloween event gloves.".getBytes();
        }

        if(i == 26839) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 926;
            class8.originalModelColors[0] = 0;
            class8.modelId = 2438;
            class8.spriteScale = 730;
            class8.spritePitch = 516;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -10;
            class8.primaryMaleModel = 3188;
            class8.primaryFemaleModel = 3192;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 1755;
            class8.primaryFemaleHeadPiece = 3187;
            class8.name = "2008 Mask";
            class8.description = "The 2008 Halloween event whip.".getBytes();
        }

        if (i == 29569) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91067;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91066;
            class8.primaryMaleModel = 91066;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Blue)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29570) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91068;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91069;
            class8.primaryMaleModel = 91069;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Green)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29571) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91070;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91071;
            class8.primaryMaleModel = 91071;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Light Blue)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29572) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91072;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91073;
            class8.primaryMaleModel = 91073;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Orange)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29573) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91074;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91075;
            class8.primaryMaleModel = 91075;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Pink)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29574) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91076;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91077;
            class8.primaryMaleModel = 91077;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Purple)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 29575) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 91078;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 91079;
            class8.primaryMaleModel = 91079;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Dr Cape (Red)";
            class8.description = "Trust me im a doctor".getBytes();
        }
        if (i == 12337) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 7073;
            class8.originalModelColors[0] = 5231;
            class8.modifiedModelColors[1] = 127;
            class8.originalModelColors[1] = 24;
            class8.modelId = 2451;
            class8.spriteScale = 690;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 1856;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 186;
            class8.primaryFemaleModel = 362;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "White cavalier";
            class8.description = "an cavalier from osrs.".getBytes();
        }
        if (i == 12463) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.originalModelColors[0] = 5904;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 5652;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors[2] = 4395;
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Bronze dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12465) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.originalModelColors[0] = 20;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 24;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors[2] = 33;
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Iron dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12467) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.originalModelColors[0] = 5161;
            class8.modifiedModelColors[1] = 38119;
            class8.originalModelColors[1] = 3123;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors[2] = 3148;
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Steel dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12468) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.modifiedModelColors[1] = 38119;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors = new int[]{-27364, -27359, -27479};
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Mithril dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12471) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 38119;
            class8.originalModelColors[0] = 6072;
            class8.modifiedModelColors[1] = 40167;
            class8.originalModelColors[1] = 6072;
            class8.modelId = 28714;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28512;
            class8.primaryFemaleModel = 28581;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Lava dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12518) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.modifiedModelColors[1] = 38119;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors = new int[]{22049, 21910, 25484};
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Green dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12520) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.modifiedModelColors[1] = 38119;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors = new int[]{-27099, -26841, -26845};
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Blue dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12522) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.modifiedModelColors[1] = 38119;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors = new int[]{935, 941, 716};
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Red dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12524) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 127;
            class8.modifiedModelColors[1] = 38119;
            class8.modifiedModelColors[2] = 38315;
            class8.originalModelColors = new int[]{0, 30, 26};
            class8.modelId = 28739;
            class8.spriteScale = 905;
            class8.spritePitch = 202;
            class8.spriteCameraRoll = 121;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 22;
            class8.primaryMaleModel = 28508;
            class8.primaryFemaleModel = 28552;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 28;
            class8.primaryFemaleHeadPiece = 86;
            class8.name = "Black dragon mask";
            class8.description = "an dragon mask from osrs.".getBytes();
        }
        if (i == 12347) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.originalModelColors = new int[]{109, 11179, 9917, 9771, 8867, 10910};
            class8.modifiedModelColors = new int[]{105, 64, 55172, 47, 35, 26};
            class8.modelId = 20235;
            class8.spriteTranslateX = -1;
            class8.spriteScale = 1373;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteTranslateY = 7;
            class8.spriteCameraYaw = 2047;
            class8.primaryMaleModel = 20158;
            class8.primaryFemaleModel = 20214;
            class8.secondaryFemaleModel = 20122;
            class8.secondaryMaleModel = 20178;
            class8.stackable = false;
            class8.name = "Gold ele' shirt";
            class8.description = "A well made elegant shirt.".getBytes();
        }
        if (i == 12348) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.originalModelColors = new int[]{11179, 11059, 11179, 9771, 10913};
            class8.modifiedModelColors = new int[]{105, 5169, 35, 26, 55272};
            class8.modelId = 20234;
            class8.spriteTranslateX = -1;
            class8.spriteScale = 1221;
            class8.spritePitch = 1333;
            class8.spriteCameraRoll = 0;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 20140;
            class8.primaryFemaleModel = 20195;
            class8.secondaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.stackable = false;
            class8.name = "Gold ele' legs";
            class8.description = "A well made elegant legs.".getBytes();
        }
        if (i == 12489) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.originalModelColors = new int[]{7114};
            class8.modifiedModelColors = new int[]{61};
            class8.modelId = 2373;
            class8.spriteScale = 1180;
            class8.spritePitch = 300;
            class8.spriteCameraRoll = 1120;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -6;
            class8.spriteTranslateY = 4;
            class8.primaryMaleModel = 490;
            class8.primaryFemaleModel = 490;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Gilded scimitar";
            class8.description = "an Gilded scimitar from osrs".getBytes();
        }
        if (i == 12491) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.originalModelColors = new int[]{7114, 7104};
            class8.modifiedModelColors = new int[]{61, 5400};
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Gilded boots";
            class8.description = "an Gilded boots from osrs".getBytes();
        }
        if (i == 12419) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.originalModelColors = new int[]{107, 7114, 5239, 6253, 7114};
            class8.modifiedModelColors = new int[]{695, 55977, 9152, 41920, 17979};
            class8.modelId = 10583;
            class8.spriteScale = 1150;
            class8.spritePitch = 112;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 10684;
            class8.primaryFemaleModel = 10691;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 10679;
            class8.primaryFemaleHeadPiece = 10679;
            class8.stackable = false;
            class8.name = "Light infinity hat";
            class8.description = "an Light infinity hat from osrs".getBytes();
        }
        if (i == 12420) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.originalModelColors = new int[]{107, 7114, 6622, 6253, 5239, 7114};
            class8.modifiedModelColors = new int[]{695, 55977, 24512, 46016, 9152, 58316};
            class8.modelId = 10586;
            class8.spriteScale = 1380;
            class8.spritePitch = 468;
            class8.spriteCameraRoll = 2044;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 10687;
            class8.primaryFemaleModel = 10694;
            class8.secondaryMaleModel = 10681;
            class8.secondaryFemaleModel = 10688;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Light infinity top";
            class8.description = "an Light infinity top from osrs".getBytes();
        }
        if (i == 12421) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.originalModelColors = new int[]{107, 7114, 6622, 6253, 7114};
            class8.modifiedModelColors = new int[]{695, 55977, 24512, 46016, 58316};
            class8.modelId = 10585;
            class8.spriteScale = 1760;
            class8.spritePitch = 304;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 30;
            class8.primaryMaleModel = 10686;
            class8.primaryFemaleModel = 10693;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Light infinity bottoms";
            class8.description = "an Light infinity bottoms from osrs".getBytes();
        }
        if (i == 12457) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[5];
            class8.originalModelColors = new int[5];
            class8.originalModelColors = new int[]{0, -8535, -10344, -7220, -8535};
            class8.modifiedModelColors = new int[]{695, 55977, 9152, 41920, 17979};
            class8.modelId = 10583;
            class8.spriteScale = 1150;
            class8.spritePitch = 112;
            class8.spriteCameraRoll = 68;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 10684;
            class8.primaryFemaleModel = 10691;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 10679;
            class8.primaryFemaleHeadPiece = 10679;
            class8.stackable = false;
            class8.name = "Dark infinity hat";
            class8.description = "an Dark infinity hat from osrs".getBytes();
        }
        if (i == 12458) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.originalModelColors = new int[]{0, -8535, -10344, 0, 0, -8535};
            class8.modifiedModelColors = new int[]{695, 55977, 24512, 46016, 9152, 58316};
            class8.modelId = 10586;
            class8.spriteScale = 1380;
            class8.spritePitch = 468;
            class8.spriteCameraRoll = 2044;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 10687;
            class8.primaryFemaleModel = 10694;
            class8.secondaryMaleModel = 10681;
            class8.secondaryFemaleModel = 10688;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Dark infinity top";
            class8.description = "an Dark infinity top from osrs".getBytes();
        }
        if (i == 12459) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.originalModelColors = new int[]{0, -8535, -10344, 0, -8535};
            class8.modifiedModelColors = new int[]{695, 55977, 24512, 46016, 58316};
            class8.modelId = 10585;
            class8.spriteScale = 1760;
            class8.spritePitch = 304;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 30;
            class8.primaryMaleModel = 10686;
            class8.primaryFemaleModel = 10693;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Dark infinity bottoms";
            class8.description = "an Dark infinity bottoms from osrs".getBytes();
        }
        if (i == 24195) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 18105;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 18105;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Lime Green Bunny ears";
            class8.description = "Its A Lime Green Bunny ears".getBytes();
        }
        if (i == 24196) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 45549;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 45549;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Unknowned White Bunny ears";
            class8.description = "Its A Unknowned White Bunny ears".getBytes();
        }
        if (i == 24197) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 50971;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 50971;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Deep Purple Bunny ears";
            class8.description = "Its A Deep Purple Bunny ears".getBytes();
        }
        if (i == 24198) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 60176;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 60176;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Deeper Purple Bunny ears";
            class8.description = "Its A Deeper Purple Bunny ears".getBytes();
        }
        if (i == 24199) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 19213;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 19213;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Deep Green Bunny ears";
            class8.description = "Its A Deep Green Bunny ears".getBytes();
        }
        if (i == 24200) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 3654;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 3654;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Dull Orange Bunny ears";
            class8.description = "Its A Dull Orange Bunny ears".getBytes();
        }
        if (i == 24201) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 12904;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 12904;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Bright Yellow Bunny ears";
            class8.description = "Its A Bright Yellow Bunny ears".getBytes();
        }
        if (i == 24202) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 618;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 618;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Bright Pink Bunny ears";
            class8.description = "Its A Bright Pink Bunny ears".getBytes();
        }
        if (i == 24203) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 46440;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 46440;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Bright Blue Bunny ears";
            class8.description = "Its A Bright Blue Bunny ears".getBytes();
        }
        if (i == 24204) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 11378;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 11378;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Bright Gray Bunny ears";
            class8.description = "Its A Bright Gray Bunny ears".getBytes();
        }
        if (i == 24205) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 36207;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 36207;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Bright Sky Blue Bunny ears";
            class8.description = "Its A Bright Sky Blue Bunny ears".getBytes();
        }
        if (i == 24206) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 32562;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 32562;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Teal Bunny ears";
            class8.description = "Its A Teal Bunny ears".getBytes();
        }
        if (i == 24207) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 933;
            class8.originalModelColors[0] = 8245;
            class8.modifiedModelColors[1] = 10351;
            class8.originalModelColors[1] = 8245;
            class8.modelId = 2553;
            class8.spriteScale = 550;
            class8.spritePitch = 360;
            class8.spriteCameraRoll = 4;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 3352;
            class8.primaryFemaleModel = 3353;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 33;
            class8.primaryFemaleHeadPiece = 91;
            class8.stackable = false;
            class8.name = "Dark Gray Bunny ears";
            class8.description = "Its A Dark Gray Bunny ears".getBytes();
        }
        if (i == 24711) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 0;
            class8.modifiedModelColors[3] = 20607;
            class8.originalModelColors[3] = 0;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 0;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 0;
            class8.modelId = 71948;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71951;
            class8.primaryFemaleModel = 71953;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Depleted pendant";
            class8.description = "It's a Depleted pendant.".getBytes();
        }
        if (i == 24712) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 0;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 0;
            class8.modifiedModelColors[3] = 20607;
            class8.originalModelColors[3] = 0;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 0;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 0;
            class8.modelId = 71949;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71950;
            class8.primaryFemaleModel = 71952;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Depleted prized pendant";
            class8.description = "It's a Depleted prized pendant.".getBytes();
        }
        if (i == 24713) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Check";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 65408;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 65441;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 65458;
            class8.modifiedModelColors[3] = 20607;
            class8.originalModelColors[3] = 8086;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 8119;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 8187;
            class8.modelId = 71948;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71951;
            class8.primaryFemaleModel = 71953;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pendant of Attack";
            class8.description = "It's a Pendant of Attack.".getBytes();
        }
        if (i == 24714) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Check";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 65408;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 65441;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 65458;
            class8.modifiedModelColors[3] = 20607;
            class8.originalModelColors[3] = 8086;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 8119;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 8187;
            class8.modelId = 71949;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71950;
            class8.primaryFemaleModel = 71952;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Prized pendant of Attack";
            class8.description = "It's a Prized pendant of Attack.".getBytes();
        }
        if (i == 24715) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Check";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 26505;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 26516;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 26537;
            class8.modifiedModelColors[3] = 20607;
            class8.originalModelColors[3] = 918;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 951;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 1019;
            class8.modelId = 71948;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71951;
            class8.primaryFemaleModel = 71953;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pendant of Strength";
            class8.description = "It's a Pendant of Strength.".getBytes();
        }
        if (i == 24716) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Check";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 26505;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 26516;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 26537;
            class8.modifiedModelColors[3] = 20607;
            class8.originalModelColors[3] = 918;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 951;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 1019;
            class8.modelId = 71949;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71950;
            class8.primaryFemaleModel = 71952;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Prized pendant of Strength";
            class8.description = "It's a Prized pendant of Strength.".getBytes();
        }
        if (i == 24717) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Check";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 37780;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 37793;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 26537;
            class8.modifiedModelColors[3] = 37838;
            class8.originalModelColors[3] = 20607;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 64601;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 64639;
            class8.modelId = 71948;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71951;
            class8.primaryFemaleModel = 71953;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Pendant of Defence";
            class8.description = "It's a Pendant of Defence.".getBytes();
        }
        if (i == 24718) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[2] = "Check";
            class8.modifiedModelColors = new int[6];
            class8.originalModelColors = new int[6];
            class8.modifiedModelColors[0] = 32779;
            class8.originalModelColors[0] = 37780;
            class8.modifiedModelColors[1] = 33754;
            class8.originalModelColors[1] = 37793;
            class8.modifiedModelColors[2] = 54245;
            class8.originalModelColors[2] = 26537;
            class8.modifiedModelColors[3] = 37838;
            class8.originalModelColors[3] = 20607;
            class8.modifiedModelColors[4] = 21466;
            class8.originalModelColors[4] = 64601;
            class8.modifiedModelColors[5] = 54245;
            class8.originalModelColors[5] = 64639;
            class8.modelId = 71949;
            class8.spriteScale = 592;
            class8.spritePitch = 552;
            class8.spriteCameraRoll = 242;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 71950;
            class8.primaryFemaleModel = 71952;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Prized pendant of Defence";
            class8.description = "It's a Prized pendant of Defence.".getBytes();
        }
        if (i == 30786) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 79221;
            class8.spriteScale = 1382;
            class8.spritePitch = 364;
            class8.spriteCameraRoll = 1158;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 8;
            class8.spriteTranslateY = -12;
            class8.primaryMaleModel = 79828;// wield
            class8.primaryFemaleModel = 79828;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gilded dragon pickaxe";
            class8.description = "Used for mining.".getBytes();
        }
        if (i == 30108) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 65412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 65409;
            class8.primaryFemaleModel = 65409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Easter Whip";
            class8.description = "Happy Easter 2015! =)".getBytes();
        }
        if (i == 30109) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 65413;
            class8.spriteScale = 2000;
            class8.spritePitch = 308;
            class8.spriteCameraRoll = 36;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 17;
            class8.primaryMaleModel = 65410;
            class8.primaryFemaleModel = 65410;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Easter maul";
            class8.description = "Happy Easter 2015! =)".getBytes();
        }
        if (i == 30110) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 65412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 65420;
            class8.primaryFemaleModel = 65420;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Easter Whip ( 3D )";
            class8.description = "Happy Easter 2015! =)".getBytes();
        }
        if (i == 12809) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.originalModelColors = new int[]{7097, 7114, 7114};
            class8.modifiedModelColors = new int[]{43086, 43111, 43098};
            class8.modelId = 28045;
            class8.spriteScale = 2151;
            class8.spritePitch = 636;
            class8.spriteCameraRoll = 1521;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 0;
            class8.spriteCameraYaw = 3;
            class8.primaryMaleModel = 27652;
            class8.primaryFemaleModel = 27652;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;
            class8.name = "Saradomin's blessed sword";
            class8.description = "The blade of an Icyene, blessed with a tear from Saradomin himself.".getBytes();
        }
        if (i == 25624) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 22443;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Emerald Whip";
            class8.description = "a Emerald Whip".getBytes();
        }


        if (i == 25625) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 33;
            class8.originalModelColors[0] = 22443;
            class8.modifiedModelColors[1] = 49;
            class8.originalModelColors[1] = 22443;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 22443;
            class8.modelId = 2558;
            class8.spriteScale = 1100;
            class8.spritePitch = 568;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 2;
            class8.primaryMaleModel = 301;
            class8.primaryFemaleModel = 464;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Emerald chainbody";
            class8.description = "a Emerald chainbody".getBytes();
        }

        if (i == 25626) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 24;
            class8.originalModelColors[0] = 22443;
            class8.modifiedModelColors[1] = 61;
            class8.originalModelColors[1] = 22443;
            class8.modifiedModelColors[2] = 41;
            class8.originalModelColors[2] = 22443;
            class8.modelId = 2605;
            class8.spriteScale = 1250;
            class8.spritePitch = 488;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 306;
            class8.primaryFemaleModel = 468;
            class8.secondaryMaleModel = 164;
            class8.secondaryFemaleModel = 344;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Emerald Platebody";
            class8.description = "a Emerald Platebody".getBytes();
        }

        if (i == 25627) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 22443;
            class8.modelId = 2833;
            class8.spriteScale = 640;
            class8.spritePitch = 108;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 219;
            class8.primaryFemaleModel = 395;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 57;
            class8.primaryFemaleHeadPiece = 117;
            class8.name = "Emerald Med Helm";
            class8.description = "a Emerald Med Helm".getBytes();
        }

        if (i == 25628) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 22443;
            class8.modifiedModelColors[1] = 926;
            class8.originalModelColors[1] = 48030;
            class8.modelId = 2813;
            class8.spriteScale = 800;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 152;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = 6;
            class8.primaryMaleModel = 218;
            class8.primaryFemaleModel = 394;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 56;
            class8.primaryFemaleHeadPiece = 116;
            class8.name = "Emerald full Helm";
            class8.description = "a Emerald full Helm".getBytes();
        }

        if (i == 25629) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors[0] = 61;
            class8.originalModelColors[0] = 22443;
            class8.modifiedModelColors[1] = 41;
            class8.originalModelColors[1] = 22443;
            class8.modifiedModelColors[2] = 57;
            class8.originalModelColors[2] = 22443;
            class8.modelId = 2582;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 268;
            class8.primaryFemaleModel = 432;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Emerald Platelegs";
            class8.description = "a Emerald platelegs".getBytes();
        }
        if (i == 28353) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 54286;
            class8.spriteScale = 1447;
            class8.spritePitch = 525;
            class8.spriteCameraRoll = 350;
            class8.spriteCameraYaw = 40;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = 3;
            class8.primaryMaleModel = 56294;
            class8.primaryFemaleModel = 56294;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chaotic maul";
            class8.description = "A maul used to claim life from those who don't deserve it.".getBytes();
        }
        if (i == 28349) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 54197;
            class8.spriteScale = 1447;
            class8.spritePitch = 1522;
            class8.spriteCameraRoll = 1710;
            class8.spriteCameraYaw = 1158;
            class8.spriteTranslateX = 9;
            class8.spriteTranslateY = -7;
            class8.primaryMaleModel = 56252;
            class8.primaryFemaleModel = 56252;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chaotic rapier";
            class8.description = "A razor-sharp rapier.".getBytes();
        }
        if (i == 28351) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 54204;
            class8.spriteScale = 1579;
            class8.spritePitch = 1603;
            class8.spriteCameraRoll = 1805;
            class8.spriteCameraYaw = 916;
            class8.spriteTranslateX = 3;
            class8.spriteTranslateY = 0;
            class8.primaryMaleModel = 56237;
            class8.primaryFemaleModel = 56237;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chaotic longsword";
            class8.description = "A razor-sharp longsword.".getBytes();
        }
        if (i == 28355) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 54367;
            class8.spriteScale = 1711;
            class8.spritePitch = 471;
            class8.spriteCameraRoll = 391;
            class8.spriteCameraYaw = 2047;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 56286;
            class8.primaryFemaleModel = 56286;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Chaotic staff";
            class8.description = "This staff makes destructive spells more powerful.".getBytes();
        }
        if (i == 30745) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 65261;
            class8.spriteScale = 1513;
            class8.spritePitch = 279;
            class8.spriteCameraRoll = 948;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -3;
            class8.spriteTranslateY = 24;
            class8.primaryMaleModel = 65305;
            class8.primaryFemaleModel = 65318;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Veteran cape";
            class8.description = "Its A Veteran cape.".getBytes();
        }
        if (i == 30744) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 65271;
            class8.spriteScale = 658;
            class8.spritePitch = 323;
            class8.spriteCameraRoll = 798;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 65289;
            class8.primaryFemaleModel = 65314;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = 14;
            class8.primaryFemaleHeadPiece = 7;
            class8.name = "Veteran hood";
            class8.description = "Its A Veteran hood.".getBytes();
        }
        if (i == 23108) {
            class8.itemActions = new String[]{null, "Wield", null, null, "Destroy"};
//class8.anIntArray160 = new int[] {  7114, 7104  };
//          class8.anIntArray156 = new int[] { 61, 5400 };
            class8.modelId = 29121;
            class8.spriteScale = 1660;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 1800;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 29078;
            class8.primaryFemaleModel = 29091;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Wilderness sword 1";
            class8.description = "an Wilderness sword 1 from osrs".getBytes();
        }
        if (i == 23109) {
            class8.itemActions = new String[]{null, "Wield", null, null, "Destroy"};
//class8.anIntArray160 = new int[] {  7114, 7104  };
//          class8.anIntArray156 = new int[] { 61, 5400 };
            class8.modelId = 29128;
            class8.spriteScale = 1660;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 1800;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 29088;
            class8.primaryFemaleModel = 29075;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Wilderness sword 2";
            class8.description = "an Wilderness sword 2 from osrs".getBytes();
        }
        if (i == 23110) {
            class8.itemActions = new String[]{null, "Wield", "Teleport", null, "Destroy"};
//class8.anIntArray160 = new int[] {  7114, 7104  };
//          class8.anIntArray156 = new int[] { 61, 5400 };
            class8.modelId = 29160;
            class8.spriteScale = 1660;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 1800;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 5;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 29093;
            class8.primaryFemaleModel = 29081;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Wilderness sword 3";
            class8.description = "an Wilderness sword 3 from osrs".getBytes();
        }
        if (i == 23111) {
            class8.itemActions = new String[]{null, "Wield", "Teleport", null, "Destroy"};
//class8.anIntArray160 = new int[] {  7114, 7104  };
//          class8.anIntArray156 = new int[] { 61, 5400 };
            class8.modelId = 29157;
            class8.spriteScale = 1660;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 1800;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 7;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 29085;
            class8.primaryFemaleModel = 29092;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Wilderness sword 4";
            class8.description = "an Wilderness sword 4 from osrs".getBytes();
        }
        if (i == 29536) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[]{50111, 43468};
            class8.originalModelColors = new int[]{-23903, -23903};
            class8.primaryMaleModel = 96500;
            class8.spriteScale = 2200;
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryFemaleModel = 96500;
            class8.modelId = 96501;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Veteran Cape (Navy)";
            class8.description = "SwocScape vet".getBytes();
        }
        if (i == 23680) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14125; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14126; //Male
            class8.primaryFemaleModel = 14126; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Ex-Moderator cape";
            class8.description = "Its A Ex-moderator Cape".getBytes();
        }
        if (i == 23681) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14127; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14128; //Male
            class8.primaryFemaleModel = 14128; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Ex-Administrator cape";
            class8.description = "Its an Ex-administrator cape".getBytes();
        }
        if (i == 23682) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modelId = 14129; //Inv & Ground
            class8.spriteScale = 2000; //Zoom
            class8.spritePitch = 572;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 1;
            class8.primaryMaleModel = 14130; //Male
            class8.primaryFemaleModel = 14130; //Female
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.noteable = -1;//noteable
            class8.name = "Ex-Owner cape";
            class8.description = "Its an Ex-owner cape".getBytes();
        }


        return class8;
    }

    public static ItemDefinition method198_4(int i, ItemDefinition class8) {

        return class8;
    }

    public static ItemDefinition method198_5(int i, ItemDefinition class8) {
        if (i == 23124) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 11058;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Off-yellow whip";
            class8.description = "Its an Off-yellow whip".getBytes();
        }
        if (i == 23125) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 19763;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Off-green whip";
            class8.description = "Its an Off-green whip".getBytes();
        }
        if (i == 23126) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 26419;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Teal whip";
            class8.description = "Its an Teal whip".getBytes();
        }
        if (i == 23127) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 944;
            class8.originalModelColors[0] = 38709;
            class8.modelId = 5412;
            class8.spriteScale = 840;
            class8.spritePitch = 280;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -2;
            class8.spriteTranslateY = 56;
            class8.primaryMaleModel = 5409;
            class8.primaryFemaleModel = 5409;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Blueer whip";
            class8.description = "Its an Blueer whip".getBytes();
        }
			/*if(i == 24718) //ID
		{
			class8.aStringArray189 = new String[5];
			class8.aStringArray189[1] = "Wear";
			class8.aString170 = "Crystal greataxe"; //Name
			class8.aByteArray178 = "Its an Crystal greataxe".getBytes(); //Description
			class8.anIntArray156 = new int[1];
			class8.anIntArray160 = new int[1];
			class8.anIntArray156[0] = 10291;
			class8.anIntArray160[0] = 10291;
			class8.anInt174 = 6579;
			class8.anInt181 = 1710;
			class8.anInt190 = 280;
			class8.anInt198 = 2004;
			class8.anInt204 = 0;
			class8.anInt169 = 0;
			class8.anInt194 = 51;
			class8.anInt165 = 96702;
			class8.anInt200 = 96702;
			class8.anInt188 = -1;
			class8.anInt164 = -1;
			class8.anInt175 = -1;
			class8.anInt197 = -1;
		}*/
        if (i == 12766)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.originalModelColors = new int[]{-30173, -28121, -29284, -27116, -24048};
            class8.modifiedModelColors = new int[]{1571, 1575, 1436, 2454, 2576};
            class8.modelId = 4676; //Model ID
            class8.spriteScale = 2128;//Model Zoom
            class8.spritePitch = 591;//Model Rotation
            class8.spriteCameraRoll = 1034;//model rotate side ways increase to move right in circle
            class8.spriteCameraYaw = 138;//Unknown
            class8.noteable = -1;//noteable
            class8.spriteTranslateX = 8;// model offset increase to move to the right
            class8.spriteTranslateY = 11;//model offset increase to move up
            class8.primaryMaleModel = 4677;//male wearing
            class8.primaryFemaleModel = 4677;//female wearing
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.stackable = false;//Stackable//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Dark bow";//Name of the new item
            class8.description = "A very PowerFull Bow".getBytes();//examin info
        }
        if (i == 12767)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.originalModelColors = new int[]{10834, 10586, 12700, 8724, 5648};
            class8.modifiedModelColors = new int[]{1571, 1575, 1436, 2454, 2576};
            class8.modelId = 4676; //Model ID
            class8.spriteScale = 2128;//Model Zoom
            class8.spritePitch = 591;//Model Rotation
            class8.spriteCameraRoll = 1034;//model rotate side ways increase to move right in circle
            class8.spriteCameraYaw = 138;//Unknown
            class8.noteable = -1;//noteable
            class8.spriteTranslateX = 8;// model offset increase to move to the right
            class8.spriteTranslateY = 11;//model offset increase to move up
            class8.primaryMaleModel = 4677;//male wearing
            class8.primaryFemaleModel = 4677;//female wearing
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.stackable = false;//Stackable//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Dark bow";//Name of the new item
            class8.description = "A very PowerFull Bow".getBytes();//examin info
        }
        if (i == 12768)  // change this if you need to "item number"
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";//New option
            class8.originalModelColors = new int[]{103, 90, 10324, 61, 28};
            class8.modifiedModelColors = new int[]{1571, 1575, 1436, 2454, 2576};
            class8.modelId = 4676; //Model ID
            class8.spriteScale = 2128;//Model Zoom
            class8.spritePitch = 591;//Model Rotation
            class8.spriteCameraRoll = 1034;//model rotate side ways increase to move right in circle
            class8.spriteCameraYaw = 138;//Unknown
            class8.noteable = -1;//noteable
            class8.spriteTranslateX = 8;// model offset increase to move to the right
            class8.spriteTranslateY = 11;//model offset increase to move up
            class8.primaryMaleModel = 4677;//male wearing
            class8.primaryFemaleModel = 4677;//female wearing
            class8.primaryMaleHeadPiece = -1;//Unknown
            class8.stackable = false;//Stackable//Unknown
            class8.secondaryFemaleModel = -1;//Female arms/sleeves
            class8.secondaryMaleModel = -1;//male arms/sleeves
            class8.stackable = false;//Stackable
            class8.name = "Dark bow";//Name of the new item
            class8.description = "A very PowerFull Bow".getBytes();//examin info
        }
        if (i == 22220) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 57034;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 57034;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 57034;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 57034;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22221) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 42673;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 42673;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 42673;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 42673;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22222) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 53936;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 53936;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 53936;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 53936;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22223) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 64181;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 64181;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 64181;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 64181;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22224) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 20771;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 20771;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 20771;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 20771;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22225) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 48674;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 48674;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 48674;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 48674;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22226) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 56373;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 56373;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 56373;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 56373;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22227) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 13869;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 13869;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 13869;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 13869;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 22228) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors[0] = 126;
            class8.originalModelColors[0] = 926;
            class8.modifiedModelColors[1] = 110;
            class8.originalModelColors[1] = 926;
            class8.modifiedModelColors[2] = 1142;
            class8.originalModelColors[2] = 926;
            class8.modifiedModelColors[3] = 102;
            class8.originalModelColors[3] = 926;
            class8.modelId = 12020;
            class8.spriteScale = 1000;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 12021;
            class8.primaryFemaleModel = 12022;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.name = "Gnome scarf";
            class8.description = "A scarf. You feel your upper lip stiffening.".getBytes();
        }
        if (i == 27120) {
            class8.itemActions = new String[]{null, "Wear", null, null, "Drop"};
            //class8.anIntArray160 = new int[] { -29403, 7054 };
            //  class8.anIntArray156 = new int[] { 61, 57 };
            class8.modelId = 95624;
            class8.spriteScale = 1600;
            class8.spritePitch = 500;
            class8.spriteCameraRoll = 250;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -4;
            class8.spriteTranslateY = -4;
            class8.primaryMaleModel = 95625;
            class8.primaryFemaleModel = 95625;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.stackable = false;
            class8.name = "Deku Shield";
            class8.description = "The Sheild from zelda.".getBytes();
        }
        if (i == 23542) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modifiedModelColors = new int[0];
            class8.originalModelColors = new int[0];
            class8.modelId = 93084;
            class8.spriteScale = 1957;
            class8.spritePitch = 498;
            class8.spriteCameraRoll = 484;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = -1;
            class8.spriteTranslateY = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.primaryMaleModel = 93083;
            class8.primaryFemaleModel = 13083;
            class8.stackable = false;
            class8.name = "Masamune";
            class8.description = "Auron's Celestial Weapon: The Masamune".getBytes();
        }
        if (i == 25690) //Hylian Shield
        {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Equip";
            class8.name = "Hylian Shield";
            class8.description = "The Hylian Shield from Zelda. - Brian F".getBytes();
            class8.modelId = 93717; //Drop Model - for Inventory also
            class8.spriteScale = 1560; //Zoom - Increase to make smaller
            class8.spritePitch = 500; //Model rotate Up+Down - Increase to move Down away from you
            class8.spriteCameraRoll = 500; //Model rotate Side-Ways - Increase to move Right in Circle
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0; //Model Offset - Increase to move to the Right
            class8.spriteTranslateY = 0; //Model Offset - Increase to move Up
            class8.primaryMaleModel = 93718; //Male Wield
            class8.primaryFemaleModel = 93719; //Female Wield
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
        }
        //Cat mask
        if (i == 25404) {
            class8.name = "Cat mask";
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[4] = "Drop";
            class8.modelId = 33312;
            class8.primaryMaleModel = 33342;
            class8.secondaryMaleModel = -1;
            class8.anInt202 = 0;
            class8.stackable = false;
            class8.spriteCameraRoll = 1808;
            class8.spriteScale = 595;
            class8.value = 800;
            class8.primaryFemaleModel = 33348;
            class8.secondaryFemaleModel = -1;
            class8.spriteTranslateX = -5;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateY = -3;
            class8.certID = 13114;
            class8.spritePitch = 108;
            class8.description = "It's a Cat mask.".getBytes();
        }
        //Bat mask
        if (i == 25405) {
            class8.name = "Bat mask";
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[4] = "Drop";
            class8.modelId = 33316;
            class8.primaryMaleModel = 33339;
            class8.secondaryMaleModel = 215;
            class8.anInt202 = 0;
            class8.stackable = false;
            class8.spriteCameraRoll = 1830;
            class8.spriteScale = 1178;
            class8.value = 800;
            class8.primaryFemaleModel = 33344;
            class8.secondaryFemaleModel = 391;
            class8.spriteTranslateX = -3;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateY = 1;
            class8.certID = 13112;
            class8.spritePitch = 83;
            class8.description = "It's a Bat mask.".getBytes();
        }
        //Sheep mask
        if (i == 25406) {
            class8.name = "Sheep mask";
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[4] = "Drop";
            class8.modelId = 33308;
            class8.primaryMaleModel = 33340;
            class8.secondaryMaleModel = -1;
            class8.anInt202 = 0;
            class8.stackable = false;
            class8.spriteCameraRoll = 1836;
            class8.spriteScale = 738;
            class8.value = 800;
            class8.primaryFemaleModel = 33349;
            class8.secondaryFemaleModel = -1;
            class8.spriteTranslateX = -3;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateY = 1;
            class8.certID = 13108;
            class8.spritePitch = 29;
            class8.description = "It's a Sheep mask.".getBytes();
        }
        //wolf mask
        if (i == 25407) {
            class8.name = "Wolf mask";
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[4] = "Drop";
            class8.modelId = 33309;
            class8.primaryMaleModel = 33341;
            class8.secondaryMaleModel = -1;
            class8.anInt202 = 0;
            class8.stackable = false;
            class8.spriteCameraRoll = 1877;
            class8.spriteScale = 595;
            class8.value = 800;
            class8.primaryFemaleModel = 33350;
            class8.secondaryFemaleModel = -1;
            class8.spriteTranslateX = -3;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateY = -4;
            class8.certID = 13116;
            class8.spritePitch = 54;
            class8.description = "It's a Wolf mask.".getBytes();
        }
        if(i == 26542)
        {
            class8.itemActions = (new String[] {
                    "Open", null, null, null, "Destroy"
            });
            class8.name = "Basic Donator Box";
            class8.description = "What could be inside?".getBytes();
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 22410;
            class8.originalModelColors[0] = 918;
            class8.modelId = 2426;
            class8.spriteScale = 1180;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 172;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
        }
        if(i == 26543)
        {
            class8.itemActions = (new String[] {
                    "Open", null, null, null, "Destroy"
            });
            class8.name = "Super Donator Box";
            class8.description = "What could be inside?".getBytes();
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 22410;
            class8.originalModelColors[0] = 22464;
            class8.modelId = 2426;
            class8.spriteScale = 1180;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 172;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
        }
        if(i == 26544)
        {
            class8.itemActions = (new String[] {
                    "Open", null, null, null, "Destroy"
            });
            class8.name = "Extreme Donator Box";
            class8.description = "What could be inside?".getBytes();
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 22410;
            class8.originalModelColors[0] = 43968;
            class8.modelId = 2426;
            class8.spriteScale = 1180;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 172;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
        }
        if(i == 26547)
        {
            class8.itemActions = (new String[] {
                    "Open", null, null, null, "Destroy"
            });
            class8.name = "legendary Donator Box";
            class8.description = "What could be inside?".getBytes();
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors[0] = 22410;
            class8.originalModelColors[0] = 6073;
            class8.modelId = 2426;
            class8.spriteScale = 1180;
            class8.spritePitch = 160;
            class8.spriteCameraRoll = 172;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = -1;
            class8.primaryFemaleModel = -1;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
        }
        if(i == 25067) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Admin Platelegs"; //Name
            class8.description = "A set of administrators platelegs.".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 8128;
            class8.originalModelColors[1] = 38676;
            class8.modifiedModelColors[0] = 926;
            class8.modifiedModelColors[1] = 912;
            class8.modelId = 5026;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25068) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Admin Crown"; //Name
            class8.description = "Made by Jukk".getBytes();
            class8.originalModelColors = new int[1];
            class8.modifiedModelColors = new int[1];
            class8.originalModelColors[0] = 38676;
            class8.modifiedModelColors[0] = 945;
            class8.modelId = 8774;
            class8.spriteScale = 500;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 90;
            class8.primaryMaleModel = 8774;
            class8.primaryFemaleModel = 8774;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25069) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "G-mod Crown"; //Name
            class8.description = "Made by Jukk".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 22412;
            class8.originalModelColors[1] = 63;
            class8.modifiedModelColors[0] = 945;
            class8.modifiedModelColors[1] = 8128;
            class8.modelId = 8774;
            class8.spriteScale = 500;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 90;
            class8.primaryMaleModel = 8774;
            class8.primaryFemaleModel = 8774;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25070) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Mod Crown"; //Name
            class8.description = "Made by Jukk".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 6073;
            class8.originalModelColors[1] = 63;
            class8.modifiedModelColors[0] = 945;
            class8.modifiedModelColors[1] = 8128;
            class8.modelId = 8774;
            class8.spriteScale = 500;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 90;
            class8.primaryMaleModel = 8774;
            class8.primaryFemaleModel = 8774;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25071) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "SB-mod Crown"; //Name
            class8.description = "Made by Jukk".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 128;
            class8.originalModelColors[1] = 63;
            class8.modifiedModelColors[0] = 945;
            class8.modifiedModelColors[1] = 8128;
            class8.modelId = 8774;
            class8.spriteScale = 500;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 90;
            class8.primaryMaleModel = 8774;
            class8.primaryFemaleModel = 8774;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25072) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Admin Boots"; //Name
            class8.description = "Admin boots".getBytes();
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors[0] = 38676;
            class8.originalModelColors[1] = 0;
            class8.originalModelColors[2] = 0;
            class8.originalModelColors[3] = 0;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 0;
            class8.modifiedModelColors[2] = 0;
            class8.modifiedModelColors[3] = 0;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25073) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Admin Kiteshield"; //Name
            class8.description = "It's an administrator kiteshield.".getBytes();
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors[0] = 8128;
            class8.originalModelColors[1] = 8128;
            class8.originalModelColors[2] = 38676;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 57;
            class8.modifiedModelColors[2] = 7054;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }

        if(i == 25075) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Mod Platebody"; //Name
            class8.description = "A moderator platebody.".getBytes();
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors[0] = 63;
            class8.originalModelColors[1] = 6073;
            class8.originalModelColors[2] = 63;
            class8.originalModelColors[3] = 63;
            class8.originalModelColors[4] = 6073;
            class8.originalModelColors[5] = 6073;
            class8.originalModelColors[6] = 6073;
            class8.originalModelColors[7] = 6073;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 24;
            class8.modifiedModelColors[2] = 41;
            class8.modifiedModelColors[3] = 10394;
            class8.modifiedModelColors[4] = 10518;
            class8.modifiedModelColors[5] = 10388;
            class8.modifiedModelColors[6] = 10514;
            class8.modifiedModelColors[7] = 10508;
            class8.modelId = 2378;
            class8.spriteScale = 1380;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 6646;
            class8.primaryFemaleModel = 6685;
            class8.secondaryMaleModel = 3379;
            class8.secondaryFemaleModel = 3383;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25076) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Mod Platelegs"; //Name
            class8.description = "A set of moderators platelegs.".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 63;
            class8.originalModelColors[1] = 6073;
            class8.modifiedModelColors[0] = 926;
            class8.modifiedModelColors[1] = 912;
            class8.modelId = 5026;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25077) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Mod Boots"; //Name
            class8.description = "Mod boots".getBytes();
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors[0] = 63;
            class8.originalModelColors[1] = 0;
            class8.originalModelColors[2] = 0;
            class8.originalModelColors[3] = 0;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 0;
            class8.modifiedModelColors[2] = 0;
            class8.modifiedModelColors[3] = 0;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25078) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Mod Kiteshield"; //Name
            class8.description = "It's an moderator kiteshield.".getBytes();
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors[0] = 63;
            class8.originalModelColors[1] = 63;
            class8.originalModelColors[2] = 6073;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 57;
            class8.modifiedModelColors[2] = 7054;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25080) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Admin Plateskirt"; //Name
            class8.description = "It's an admin skirt".getBytes();
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors[0] = 8128;
            class8.originalModelColors[1] = 38676;
            class8.originalModelColors[2] = 38676;
            class8.originalModelColors[3] = 8128;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 41;
            class8.modifiedModelColors[2] = 57;
            class8.modifiedModelColors[3] = 25238;
            class8.modelId = 4208;
            class8.spriteScale = 1100;
            class8.spritePitch = 620;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 5;
            class8.primaryMaleModel = 4206;
            class8.primaryFemaleModel = 4207;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25081) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Mod Plateskirt"; //Name
            class8.description = "It's a mod skirt".getBytes();
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors[0] = 63;
            class8.originalModelColors[1] = 6073;
            class8.originalModelColors[2] = 6073;
            class8.originalModelColors[3] = 63;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 41;
            class8.modifiedModelColors[2] = 57;
            class8.modifiedModelColors[3] = 25238;
            class8.modelId = 4208;
            class8.spriteScale = 1100;
            class8.spritePitch = 620;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 5;
            class8.primaryMaleModel = 4206;
            class8.primaryFemaleModel = 4207;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25082) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Owners Platebody"; //Name
            class8.description = "An owners platebody.".getBytes();
            class8.originalModelColors = new int[8];
            class8.modifiedModelColors = new int[8];
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 950;
            class8.originalModelColors[2] = 0;
            class8.originalModelColors[3] = 0;
            class8.originalModelColors[4] = 950;
            class8.originalModelColors[5] = 950;
            class8.originalModelColors[6] = 950;
            class8.originalModelColors[7] = 950;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 24;
            class8.modifiedModelColors[2] = 41;
            class8.modifiedModelColors[3] = 10394;
            class8.modifiedModelColors[4] = 10518;
            class8.modifiedModelColors[5] = 10388;
            class8.modifiedModelColors[6] = 10514;
            class8.modifiedModelColors[7] = 10508;
            class8.modelId = 2378;
            class8.spriteScale = 1380;
            class8.spritePitch = 452;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -1;
            class8.primaryMaleModel = 6646;
            class8.primaryFemaleModel = 6685;
            class8.secondaryMaleModel = 3379;
            class8.secondaryFemaleModel = 3383;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25083) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Owners Platelegs"; //Name
            class8.description = "A set of owners platelegs.".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 950;
            class8.modifiedModelColors[0] = 926;
            class8.modifiedModelColors[1] = 912;
            class8.modelId = 5026;
            class8.spriteScale = 1740;
            class8.spritePitch = 444;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -8;
            class8.primaryMaleModel = 5024;
            class8.primaryFemaleModel = 5025;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25084) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Owners Boots"; //Name
            class8.description = "Owners boots".getBytes();
            class8.originalModelColors = new int[4];
            class8.modifiedModelColors = new int[4];
            class8.originalModelColors[0] = 950;
            class8.originalModelColors[1] = 0;
            class8.originalModelColors[2] = 0;
            class8.originalModelColors[3] = 0;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 0;
            class8.modifiedModelColors[2] = 0;
            class8.modifiedModelColors[3] = 0;
            class8.modelId = 5037;
            class8.spriteScale = 770;
            class8.spritePitch = 164;
            class8.spriteCameraRoll = 156;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -3;
            class8.primaryMaleModel = 4954;
            class8.primaryFemaleModel = 5031;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25085) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Owners Kiteshield"; //Name
            class8.description = "It's an owners kiteshield.".getBytes();
            class8.originalModelColors = new int[3];
            class8.modifiedModelColors = new int[3];
            class8.originalModelColors[0] = 0;
            class8.originalModelColors[1] = 0;
            class8.originalModelColors[2] = 950;
            class8.modifiedModelColors[0] = 61;
            class8.modifiedModelColors[1] = 57;
            class8.modifiedModelColors[2] = 7054;
            class8.modelId = 2339;
            class8.spriteScale = 1560;
            class8.spritePitch = 344;
            class8.spriteCameraRoll = 1104;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -14;
            class8.primaryMaleModel = 486;
            class8.primaryFemaleModel = 486;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        if(i == 25086) //ID
        {
            class8.itemActions = new String[] {null, "Wear", null, null, "Drop"};
            class8.groundActions = new String[] {null, null, "Take", null, null};
            class8.name = "Owners Crown"; //Name
            class8.description = "Made by Jukk".getBytes();
            class8.originalModelColors = new int[2];
            class8.modifiedModelColors = new int[2];
            class8.originalModelColors[0] = 950;
            class8.originalModelColors[1] = 0;
            class8.modifiedModelColors[0] = 945;
            class8.modifiedModelColors[1] = 8128;
            class8.modelId = 8774;
            class8.spriteScale = 500;
            class8.spritePitch = 0;
            class8.spriteCameraRoll = 0;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = 90;
            class8.primaryMaleModel = 8774;
            class8.primaryFemaleModel = 8774;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            class8.value = 1;
            class8.certID = -1;
            class8.certTemplateID = -1;
            class8.stackable = false;
            class8.anInt202 = 0;
        }


        return class8;
    }

    public static void Models(int Ground, int Male, int Female) {
        ItemDefinition class8 = cache[anInt180];
        class8.modelId = Ground;
        class8.primaryMaleModel = Male;
        class8.primaryFemaleModel = Female;
    }

    public static void NewColor(int Old, int New, int Num) {
        ItemDefinition class8 = cache[anInt180];
        class8.modifiedModelColors[Num] = Old;
        class8.originalModelColors[Num] = New;
    }

    public static void NEO(String Name, String Examine, String Option)// NEO = Name Examine Option
    {
        ItemDefinition class8 = cache[anInt180];
        class8.itemActions = new String[5];
        class8.itemActions[1] = Option;
        class8.name = Name;
        class8.description = Examine.getBytes();
    }

    public static void Zoom(int zoom, int X, int Y, int RotateUp, int RotateRight, boolean Stackable) {
        ItemDefinition class8 = cache[anInt180];
        class8.spriteScale = zoom;
        class8.spritePitch = RotateUp;
        class8.spriteCameraRoll = RotateRight;
        class8.spriteTranslateX = Y;
        class8.spriteTranslateY = X;
        class8.stackable = Stackable;
    }

    public static void Jukkycolors(int old, int neww, int num) {
        ItemDefinition class8 = cache[anInt180];

        class8.modifiedModelColors[num] = old;
        class8.originalModelColors[num] = neww;
    }

    public static void Jukkyzoom(int zoom, int rotation, int rotateright, int offsetY, int offsetX, int Brightness, int msc, int msc1, boolean stackable) {
        ItemDefinition class8 = cache[anInt180];
        class8.spriteScale = zoom;
        class8.spritePitch = rotation;
        class8.spriteCameraRoll = rotateright;
        class8.spriteCameraYaw = offsetY;
        class8.spriteTranslateX = offsetX;
        class8.spriteTranslateY = Brightness;
        class8.stackable = stackable;//Stackable
        class8.primaryMaleHeadPiece = msc;//Unknown
        class8.primaryFemaleHeadPiece = msc1;//Unknown
    }

    public static void Jukkyname(String name, String examine) {
        ItemDefinition class8 = cache[anInt180];
        class8.itemActions = new String[5];
        class8.itemActions[1] = "Wear";
        class8.name = name;
        class8.description = examine.getBytes();
    }

    public static void JukkyModels(int male, int malearms, int female, int femalearms, int dropmdl) {
        ItemDefinition class8 = cache[anInt180];
        class8.primaryMaleModel = male;
        class8.secondaryMaleModel = malearms;
        class8.primaryFemaleModel = female;
        class8.secondaryFemaleModel = femalearms;
        class8.modelId = dropmdl;
    }

    public static Sprite method200(int i, int j, int k, int l) {
        if (k == 0) {
            Sprite sprite = (Sprite) aClass12_158.method222(i);
            if (sprite != null && sprite.maxHeight != j && sprite.maxHeight != -1) {
                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition class8 = method198(i);
        class8 = method198_2(i, class8);
        if (class8.stackIDs == null)
            j = -1;
        if (j > 1) {
            int i1 = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (j >= class8.stackAmounts[j1] && class8.stackAmounts[j1] != 0)
                    i1 = class8.stackIDs[j1];

            if (i1 != -1)
                class8 = method198(i1);
            class8 = method198_2(i, class8);
        }
        Model model = class8.method201(1);
        if (model == null)
            return null;
        Sprite class30_sub2_sub1_sub1_2 = null;
        if (class8.certTemplateID != -1) {
            class30_sub2_sub1_sub1_2 = method200(class8.certID, 10, -1, 9);
            if (class30_sub2_sub1_sub1_2 == null)
                return null;
        }
        Sprite class30_sub2_sub1_sub1_1 = new Sprite(32, 32);
        int k1 = Rasterizer.centerX;
        int l1 = Rasterizer.centerY;
        int[] ai = Rasterizer.lineOffsets;
        int[] ai1 = DrawingArea.pixels;
        int i2 = DrawingArea.width;
        int j2 = DrawingArea.height;
        int k2 = DrawingArea.leftX;
        int l2 = DrawingArea.bottomX;
        int i3 = DrawingArea.topY;
        int j3 = DrawingArea.bottomY;
        Rasterizer.aBoolean1464 = false;
        DrawingArea.method331(32, 32, class30_sub2_sub1_sub1_1.myPixels, null);
        DrawingArea.drawPixels(32, 0, 0, 0, 32);
        Rasterizer.method364();
        int k3 = class8.spriteScale;
        if (k == -1)
            k3 = (int) ((double) k3 * 1.5D);
        if (k > 0)
            k3 = (int) ((double) k3 * 1.04D);
        int l3 = Rasterizer.anIntArray1470[class8.spritePitch] * k3 >> 16;
        int i4 = Rasterizer.anIntArray1471[class8.spritePitch] * k3 >> 16;
        model.renderSingle(0, class8.spriteCameraRoll, class8.spriteCameraYaw, class8.spritePitch, class8.spriteTranslateX, l3 + model.modelHeight / 2 + class8.spriteTranslateY, i4 + class8.spriteTranslateY);
        for (int i5 = 31; i5 >= 0; i5--) {
            for (int j4 = 31; j4 >= 0; j4--)
                if (class30_sub2_sub1_sub1_1.myPixels[i5 + j4 * 32] == 0)
                    if (i5 > 0 && class30_sub2_sub1_sub1_1.myPixels[(i5 - 1) + j4 * 32] > 1)
                        class30_sub2_sub1_sub1_1.myPixels[i5 + j4 * 32] = 1;
                    else if (j4 > 0 && class30_sub2_sub1_sub1_1.myPixels[i5 + (j4 - 1) * 32] > 1)
                        class30_sub2_sub1_sub1_1.myPixels[i5 + j4 * 32] = 1;
                    else if (i5 < 31 && class30_sub2_sub1_sub1_1.myPixels[i5 + 1 + j4 * 32] > 1)
                        class30_sub2_sub1_sub1_1.myPixels[i5 + j4 * 32] = 1;
                    else if (j4 < 31 && class30_sub2_sub1_sub1_1.myPixels[i5 + (j4 + 1) * 32] > 1)
                        class30_sub2_sub1_sub1_1.myPixels[i5 + j4 * 32] = 1;

        }

        if (k > 0) {
            for (int j5 = 31; j5 >= 0; j5--) {
                for (int k4 = 31; k4 >= 0; k4--)
                    if (class30_sub2_sub1_sub1_1.myPixels[j5 + k4 * 32] == 0)
                        if (j5 > 0 && class30_sub2_sub1_sub1_1.myPixels[(j5 - 1) + k4 * 32] == 1)
                            class30_sub2_sub1_sub1_1.myPixels[j5 + k4 * 32] = k;
                        else if (k4 > 0 && class30_sub2_sub1_sub1_1.myPixels[j5 + (k4 - 1) * 32] == 1)
                            class30_sub2_sub1_sub1_1.myPixels[j5 + k4 * 32] = k;
                        else if (j5 < 31 && class30_sub2_sub1_sub1_1.myPixels[j5 + 1 + k4 * 32] == 1)
                            class30_sub2_sub1_sub1_1.myPixels[j5 + k4 * 32] = k;
                        else if (k4 < 31 && class30_sub2_sub1_sub1_1.myPixels[j5 + (k4 + 1) * 32] == 1)
                            class30_sub2_sub1_sub1_1.myPixels[j5 + k4 * 32] = k;

            }

        } else if (k == 0) {
            for (int k5 = 31; k5 >= 0; k5--) {
                for (int l4 = 31; l4 >= 0; l4--)
                    if (class30_sub2_sub1_sub1_1.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && class30_sub2_sub1_sub1_1.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
                        class30_sub2_sub1_sub1_1.myPixels[k5 + l4 * 32] = 0x302020;

            }

        }
        if (class8.certTemplateID != -1) {
            int l5 = class30_sub2_sub1_sub1_2.maxWidth;
            int j6 = class30_sub2_sub1_sub1_2.maxHeight;
            class30_sub2_sub1_sub1_2.maxWidth = 32;
            class30_sub2_sub1_sub1_2.maxHeight = 32;
            class30_sub2_sub1_sub1_2.drawSprite(0,  0);
            class30_sub2_sub1_sub1_2.maxWidth = l5;
            class30_sub2_sub1_sub1_2.maxHeight = j6;
        }
        if (k == 0)
            aClass12_158.method223(class30_sub2_sub1_sub1_1, i, (byte) 2);
        DrawingArea.method331(j2, i2, ai1, null);
        DrawingArea.setDrawingArea(j3, k2, l2, i3);
        Rasterizer.centerX = k1;
        Rasterizer.centerY = l1;
        Rasterizer.lineOffsets = ai;
        Rasterizer.aBoolean1464 = true;
        if (l < 9 || l > 9) {
            for (int i6 = 1; i6 > 0; i6++) ;
        }
        if (class8.stackable)
            class30_sub2_sub1_sub1_1.maxWidth = 33;
        else
            class30_sub2_sub1_sub1_1.maxWidth = 32;
        class30_sub2_sub1_sub1_1.maxHeight = j;
        return class30_sub2_sub1_sub1_1;
    }

    public boolean method192(int i, int j) {
        if (i != -2836)
            aBoolean186 = !aBoolean186;
        int k = primaryMaleHeadPiece;
        int l = secondaryMaleHeadPiece;
        if (j == 1) {
            k = primaryFemaleHeadPiece;
            l = secondaryFemaleHeadPiece;
        }
        if (k == -1)
            return true;
        boolean flag = Model.method463(k);
        if (l != -1 && !Model.method463(l))
            flag = false;
        return flag;
    }

    public Model method194(int i, int j) {
        while (i >= 0)
            aBoolean186 = !aBoolean186;
        int k = primaryMaleHeadPiece;
        int l = secondaryMaleHeadPiece;
        if (j == 1) {
            k = primaryFemaleHeadPiece;
            l = secondaryFemaleHeadPiece;
        }
        if (k == -1)
            return null;
        Model model = Model.method462(anInt171, k);
        if (l != -1) {
            Model model_1 = Model.method462(anInt171, l);
            Model[] aclass30_sub2_sub4_sub6 = {
                    model, model_1
            };
            model = new Model(2, aclass30_sub2_sub4_sub6, -38);
        }
        if (modifiedModelColors != null) {
            for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
                model.method476(modifiedModelColors[i1], originalModelColors[i1]);

        }
        return model;
    }

    public boolean method195(int i, int j) {
        if (i != 40903)
            aBoolean206 = !aBoolean206;
        int k = primaryMaleModel;
        int l = secondaryMaleModel;
        int i1 = tertiaryMaleEquipmentModel;
        if (j == 1) {
            k = primaryFemaleModel;
            l = secondaryFemaleModel;
            i1 = tertiaryFemaleEquipmentModel;
        }
        if (k == -1)
            return true;
        boolean flag = Model.method463(k);
        if (l != -1 && !Model.method463(l))
            flag = false;
        if (i1 != -1 && !Model.method463(i1))
            flag = false;
        return flag;
    }

    public Model method196(boolean flag, int i) {
        if (flag)
            throw new NullPointerException();
        int j = primaryMaleModel;
        int k = secondaryMaleModel;
        int l = tertiaryMaleEquipmentModel;
        if (i == 1) {
            j = primaryFemaleModel;
            k = secondaryFemaleModel;
            l = tertiaryFemaleEquipmentModel;
        }
        if (j == -1)
            return null;
        Model model = Model.method462(anInt171, j);
        if (k != -1)
            if (l != -1) {
                Model model_1 = Model.method462(anInt171, k);
                Model model_3 = Model.method462(anInt171, l);
                Model[] aclass30_sub2_sub4_sub6_1 = {
                        model, model_1, model_3
                };
                model = new Model(3, aclass30_sub2_sub4_sub6_1, -38);
            } else {
                Model class30_sub2_sub4_sub6_2 = Model.method462(anInt171, k);
                Model[] aclass30_sub2_sub4_sub6 = {
                        model, class30_sub2_sub4_sub6_2
                };
                model = new Model(2, aclass30_sub2_sub4_sub6, -38);
            }
        if (i == 0 && maleTranslation != 0)
            model.translate(0, maleTranslation, 16384, 0);
        if (i == 1 && femaleTranslation != 0)
            model.translate(0, femaleTranslation, 16384, 0);
        if (modifiedModelColors != null) {
            for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
                model.method476(modifiedModelColors[i1], originalModelColors[i1]);

        }
        return model;
    }

    public void method197() {
        modelId = 0;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        spriteScale = 2000;
        spritePitch = 0;
        spriteCameraRoll = 0;
        spriteCameraYaw = 0;
        spriteTranslateX = 0;
        spriteTranslateY = 0;
        noteable = -1;
        stackable = false;
        value = 1;
        membersObject = false;
        groundActions = null;
        itemActions = null;
        primaryMaleModel = -1;
        secondaryMaleModel = -1;
        maleTranslation = 0;
        primaryFemaleModel = -1;
        secondaryFemaleModel = -1;
        femaleTranslation = 0;
        tertiaryMaleEquipmentModel = -1;
        tertiaryFemaleEquipmentModel = -1;
        primaryMaleHeadPiece = -1;
        secondaryMaleHeadPiece = -1;
        primaryFemaleHeadPiece = -1;
        secondaryFemaleHeadPiece = -1;
        stackIDs = null;
        stackAmounts = null;
        certID = -1;
        certTemplateID = -1;
        anInt167 = 128;
        anInt192 = 128;
        anInt191 = 128;
        anInt196 = 0;
        anInt184 = 0;
        anInt202 = 0;
    }

    public void method199(byte byte0) {
        ItemDefinition class8 = method198(certTemplateID);
        modelId = class8.modelId;
        spriteScale = class8.spriteScale;
        spritePitch = class8.spritePitch;
        spriteCameraRoll = class8.spriteCameraRoll;
        spriteCameraYaw = class8.spriteCameraYaw;
        spriteTranslateX = class8.spriteTranslateX;
        spriteTranslateY = class8.spriteTranslateY;
        if (byte0 != 61)
            aBoolean186 = !aBoolean186;
        modifiedModelColors = class8.modifiedModelColors;
        originalModelColors = class8.originalModelColors;
        ItemDefinition class8_1 = method198(certID);
        name = class8_1.name;
        membersObject = class8_1.membersObject;
        value = class8_1.value;
        String s = "a";
        char c = class8_1.name.charAt(0);
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            s = "an";
        description = ("Swap this note at any bank for " + s + " " + class8_1.name + ".").getBytes();
        stackable = true;
    }

    public Model method201(int i) {
        if (stackIDs != null && i > 1) {
            int j = -1;
            for (int k = 0; k < 10; k++)
                if (i >= stackAmounts[k] && stackAmounts[k] != 0)
                    j = stackIDs[k];

            if (j != -1)
                return method198(j).method201(1);
        }
        Model model = (Model) aClass12_159.method222(anInt157);
        if (model != null)
            return model;
        model = Model.method462(anInt171, modelId);
        if (model == null)
            return null;
        if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
            model.scaleT(anInt167, anInt191, anInt177, anInt192);
        if (modifiedModelColors != null) {
            for (int l = 0; l < modifiedModelColors.length; l++)
                model.method476(modifiedModelColors[l], originalModelColors[l]);

        }
        model.method479(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
        model.aBoolean1659 = true;
        aClass12_159.method223(model, anInt157, (byte) 2);
        return model;
    }

    public Model method202(int i, boolean flag) {
        if (stackIDs != null && i > 1) {
            int j = -1;
            for (int k = 0; k < 10; k++)
                if (i >= stackAmounts[k] && stackAmounts[k] != 0)
                    j = stackIDs[k];

            if (j != -1)
                return method198(j).method202(1, true);
        }
        Model model = Model.method462(anInt171, modelId);
        if (!flag)
            throw new NullPointerException();
        if (model == null)
            return null;
        if (modifiedModelColors != null) {
            for (int l = 0; l < modifiedModelColors.length; l++)
                model.method476(modifiedModelColors[l], originalModelColors[l]);

        }
        return model;
    }

    public void readValues(boolean flag, Stream stream) {
        if (!flag)
            throw new NullPointerException();
        do {
            int opcode = stream.readUnsignedByte();
            if (opcode == 0)
                return;
            if (opcode == 1)
                modelId = stream.readUnsignedShort();
            else if (opcode == 2)
                name = stream.readString();
            else if (opcode == 3)
                description = stream.method416((byte) 30);
            else if (opcode == 4)
                spriteScale = stream.readUnsignedShort();
            else if (opcode == 5)
                spritePitch = stream.readUnsignedShort();
            else if (opcode == 6)
                spriteCameraRoll = stream.readUnsignedShort();
            else if (opcode == 7) {
                spriteTranslateX = stream.readUnsignedShort();
                if (spriteTranslateX > 32767)
                    spriteTranslateX -= 0x10000;
            } else if (opcode == 8) {
                spriteTranslateY = stream.readUnsignedShort();
                if (spriteTranslateY > 32767)
                    spriteTranslateY -= 0x10000;
            } else if (opcode == 11)
                stackable = true;
            else if (opcode == 12)
                value = stream.readUnsignedShort();
            else if (opcode == 16)
                membersObject = true;
            else if (opcode == 23) {
                primaryMaleModel = stream.readUnsignedShort();
                maleTranslation = stream.readSignedByte();
            } else if (opcode == 24)
                secondaryMaleModel = stream.readUnsignedShort();
            else if (opcode == 25) {
                primaryFemaleModel = stream.readUnsignedShort();
                femaleTranslation = stream.readSignedByte();
            } else if (opcode == 26)
                secondaryFemaleModel = stream.readUnsignedShort();
            else if (opcode == 27)
                anInt5735 = stream.readUnsignedByte();
            else if (opcode >= 30 && opcode < 35) {
                if (groundActions == null)
                    groundActions = new String[5];
                groundActions[opcode - 30] = stream.readString();
                if (groundActions[opcode - 30].equalsIgnoreCase("hidden"))
                    groundActions[opcode - 30] = null;
            } else if (opcode >= 35 && opcode < 40) {
                if (itemActions == null)
                    itemActions = new String[5];
                itemActions[opcode - 35] = stream.readString();
                if (itemActions[opcode - 35].equalsIgnoreCase("null"))
                    itemActions[opcode - 35] = null;
            } else if (opcode == 40) {
                int j = stream.readUnsignedByte();
                modifiedModelColors = new int[j];
                originalModelColors = new int[j];
                for (int k = 0; k < j; k++) {
                    modifiedModelColors[k] = stream.readUnsignedShort();
                    originalModelColors[k] = stream.readUnsignedShort();
                }

            } else if (opcode == 78)
                tertiaryMaleEquipmentModel = stream.readUnsignedShort();
            else if (opcode == 79)
                tertiaryFemaleEquipmentModel = stream.readUnsignedShort();
            else if (opcode == 90)
                primaryMaleHeadPiece = stream.readUnsignedShort();
            else if (opcode == 91)
                primaryFemaleHeadPiece = stream.readUnsignedShort();
            else if (opcode == 92)
                secondaryMaleHeadPiece = stream.readUnsignedShort();
            else if (opcode == 93)
                secondaryFemaleHeadPiece = stream.readUnsignedShort();
            else if (opcode == 94)
                stream.readUnsignedShort();
            else if (opcode == 95)
                spriteCameraYaw = stream.readUnsignedShort();
            else if (opcode == 97)
                certID = stream.readUnsignedShort();
            else if (opcode == 98)
                certTemplateID = stream.readUnsignedShort();
            else if (opcode >= 100 && opcode < 110) {
                if (stackIDs == null) {
                    stackIDs = new int[10];
                    stackAmounts = new int[10];
                }
                stackIDs[opcode - 100] = stream.readUnsignedShort();
                stackAmounts[opcode - 100] = stream.readUnsignedShort();
            } else if (opcode == 110)
                anInt167 = stream.readUnsignedShort();
            else if (opcode == 111)
                anInt192 = stream.readUnsignedShort();
            else if (opcode == 112)
                anInt191 = stream.readUnsignedShort();
            else if (opcode == 113)
                anInt196 = stream.readSignedByte();
            else if (opcode == 114)
                anInt184 = stream.readSignedByte() * 5;
            else if (opcode == 115)
                anInt202 = stream.readUnsignedByte();
            else if (opcode == 116)
                lendID = stream.readUnsignedShort();
            else if (opcode == 117)
                lentItemID = stream.readUnsignedShort();
        } while (true);
    }

}
