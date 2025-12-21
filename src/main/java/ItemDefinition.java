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
    public int team;
    private byte femaleTranslation;
    private int[] modifiedModelColors;
    private int[] originalModelColors;
    private boolean stockmarket;
    private int[] retextureDst;
    private int[] retextureSrc;
    private int secondaryFemaleModel;
    private int primaryMaleModel;
    private int groundScaleX;
    private int spriteTranslateX;
    private final int anInt171;
    public int modelId;
    private int primaryMaleHeadPiece;
    private final int anInt177;
    private int diffusion;
    private boolean aBoolean186;
    private int secondaryMaleModel;
    private int groundScaleZ;
    private int groundScaleY;
    private int spriteTranslateY;
    private int ambience;
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
        File file = new File("./temp/notes.dat");

        try (FileOutputStream out = new FileOutputStream(file)) {

            for (int id = 0; id < anInt203; id++) {
                ItemDefinition def = method198(id);

                // 0 = note, 1 = non-note
                boolean isNote = def.certID != -1;
                out.write(isNote ? 0 : 1);
            }

            // No need to write -1 — EOF handles termination.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dumpStacks() {
        try {
            FileOutputStream out = new FileOutputStream(new File("./temp/stackable.dat"));
            for (int j = 0; j < anInt203; j++) {
                ItemDefinition item = method198(j);
                out.write(item.stackable ? 1 : 0);
            }
            out.write(-1);
            out.close();
        } catch (IOException ioe) {ioe.printStackTrace();}
    }
    public static void dumpSellable() {
        try {
            FileOutputStream out = new FileOutputStream(new File("./temp/sellable.dat"));
            for (int j = 0; j < anInt203; j++) {
                ItemDefinition definition = method198(j);
                out.write(definition.value >= 1 ? 1 : 0);
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
                bw = new BufferedWriter(new FileWriter("./temp/Item Dump.txt", true));
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
    public static void dumpPrices() {
        for(int i = 0; i < 30000; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter("/tempprices.txt", true));
                if(class8.name != null) {
                    bw.write(+i+" "+class8.value);
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
            File file = new File("/tempnote_id.dat");

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
    public static void dumpxmlItems() {
        for(int i = 0; i < 40000; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter("./temp/Items.txt", true));
                if(class8.name != null) {
                    bw.write("<item members='"+class8.membersObject+"'  name='" + class8.name + "'  type='"+i+"'>");
                    bw.newLine();
                    bw.write("</item>");
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ioe2) {
            }
        }
    }
    public static void dumpCfg() {
        boolean delete = (new File(signlink.findcachedir() + ("/dumps/item.cfg")).delete());
        for (int i = 22319; i < 30000; i++) {
            ItemDefinition class8 = method198(i);
            BufferedWriter bw = null;
            String des = "";
            if (!Objects.equals(class8.name, "Dwarf remains")) {
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
                bw.write("			class8.anInt202 = " + itemDef.team + ";");
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
      //  dumpStackable();
        //dumpStacks();
        //dumpSellable();
       // dumpNotes();
       // dumpxmlItems();
        dumpCfg();
       // dumpPrices();
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
        ItemDefinition ItemDef = cache[anInt180];
        aStream_183.currentPosition = anIntArray195[i];
        ItemDef.anInt157 = i;
        ItemDef.method197();
        ItemDef.readValues(true, aStream_183);
        if (ItemDef.certTemplateID != -1)
            ItemDef.method199((byte) 61);
        switch(i){
            case 23000:
                copy(ItemDef, 23_000, 6_542, "Resource box", "Open");
                break;
            case 23001:
                copy(ItemDef, 23_001, 6_542, "Resource box(medium)", "Open");
                break;
            case 23002:
                copy(ItemDef, 23_002, 6_542, "Resource box(large)", "Open");
                break;
            case 23003:
                copy(ItemDef, 23_003, 6_542, "Resource box(huge)", "Open");
                break;
        }
        method198_2(i, ItemDef);
        method198_3(i, ItemDef);
        method198_4(i, ItemDef);
        method198_5(i, ItemDef);

        if (i == 23004) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Summon from the";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7446;//color change
            ItemDef.originalModelColors[0] = 926;//color change 1
            ItemDef.modelId = 98933;//itemdrop look
            ItemDef.spriteScale = 1595;//zoom
            ItemDef.spritePitch = 196; //rotation rotation up/down
            ItemDef.spriteCameraRoll = 2031;//rotation left/right
            ItemDef.spriteCameraYaw = 2047;//i think more zoom stuff
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 98932;//male weild
            ItemDef.primaryFemaleModel = 98932;//female weild
            ItemDef.primaryMaleHeadPiece = 2;  //offset
            ItemDef.primaryFemaleHeadPiece = -1;  //offset
            ItemDef.name = "Monkey Bag";
            ItemDef.description = "Wear a monkey for FREE!".getBytes();
        }

        if(i == 25340)
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.originalModelColors[0] = 0;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modelId = 71770;
            ItemDef.spriteScale = 2050;
            ItemDef.spritePitch = 222;
            ItemDef.spriteCameraRoll = 1958;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 72130;
            ItemDef.primaryFemaleModel = 72130;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.primaryFemaleHeadPiece = -28;
            ItemDef.name = "Lucky Saradomin Godsword";
            ItemDef.description = "A brutally heavy sword. Requires Attack (75).".getBytes();
        }
        if(i == 25341)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 71769; //Model ID
            ItemDef.spriteScale = 2000;
            ItemDef.spritePitch = 228;
            ItemDef.spriteCameraRoll = 1985;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = 5;
            ItemDef.primaryFemaleHeadPiece = -55;
            ItemDef.primaryMaleModel = 72135;//male wearing
            ItemDef.primaryFemaleModel = 72135;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Lucky Armadyl Godsword";//Name of the new item
            ItemDef.description = "A brutally heavy sword. Requires Attack (75).".getBytes();//examin info
        }
        if (i == 28431)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 70730; //Model ID
            ItemDef.spriteScale = 1758;
            ItemDef.spritePitch = 512;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.primaryMaleModel = 70669;//male wearing
            ItemDef.primaryFemaleModel = 70669;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Dragonbone platebody";//Name of the new item
            ItemDef.description = "Provides excellent protection with a meaner, bonier look.".getBytes();//examin info
        }
        if (i == 27431)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 70899; //Model ID
            ItemDef.spriteScale = 1897;
            ItemDef.spritePitch = 520;
            ItemDef.spriteCameraRoll = 520;
            ItemDef.spriteCameraYaw = 1;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.primaryMaleModel = 70900;//male wearing
            ItemDef.primaryFemaleModel = 70900;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Golden katana";//Name of the new item
            ItemDef.description = "A fine blade from the Eastern Lands.".getBytes();//examin info
        }
        if (i == 25342)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 71767; //Model ID
            ItemDef.spriteScale = 2128;
            ItemDef.spritePitch = 243;
            ItemDef.spriteCameraRoll = 1964;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.primaryFemaleHeadPiece = 0;
            ItemDef.primaryMaleModel = 72138;//male wearing
            ItemDef.primaryFemaleModel = 72138;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Lucky Zamorak Godsword";//Name of the new item
            ItemDef.description = "A brutally heavy sword. Requires Attack (75).".getBytes();//examin info
        }
        if (i == 25343) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 0;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modelId = 71766;//item look
            ItemDef.spriteScale = 1616;
            ItemDef.spritePitch = 192;
            ItemDef.spriteCameraRoll = 1161;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 72137;
            ItemDef.primaryFemaleModel = 72137;
            ItemDef.primaryMaleHeadPiece = -18;
            ItemDef.primaryFemaleHeadPiece = 75;
            ItemDef.name = "Lucky Bandos godsword";
            ItemDef.description = "A brutally heavy sword. Requires Attack (75).".getBytes();
        }
        if(i == 25344)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 71768; //Model ID
            ItemDef.spriteScale = 3355;
            ItemDef.spritePitch = 512;
            ItemDef.spriteCameraRoll = 256;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = 3;
            ItemDef.primaryFemaleHeadPiece = -9;
            ItemDef.primaryMaleModel = 72134;//male wearing
            ItemDef.primaryFemaleModel = 72134;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Lucky Zamorakian spear";//Name of the new item
            ItemDef.description = "A versatile spear wielded by agents of chaos. Requires Attack (75).".getBytes();//examin info
        }
        if(i == 25345)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 66212; //Model ID
            ItemDef.spriteScale = 2151;
            ItemDef.spritePitch = 636;
            ItemDef.spriteCameraRoll = 1521;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.primaryFemaleHeadPiece = 3;
            ItemDef.primaryMaleModel = 66272;//male wearing
            ItemDef.primaryFemaleModel = 66272;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Lucky Saradomin sword";//Name of the new item
            ItemDef.description = "The incredible blade of an icyene. Requires Attack (75).".getBytes();//examin info
        }
        if(i == 25346)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 66196; //Model ID
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 200;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = -2;
            ItemDef.primaryFemaleHeadPiece = 56;
            ItemDef.primaryMaleModel = 66262;//male wearing
            ItemDef.primaryFemaleModel = 66262;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Lucky abyssal whip";//Name of the new item
            ItemDef.description = "A weapon from the Abyss. Requires Attack (70).".getBytes();//examin info
        }
        if(i == 25347)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[0];
            ItemDef.originalModelColors = new int[0];
            ItemDef.modelId = 79426; //Model ID
            ItemDef.spriteScale = 2891;
            ItemDef.spritePitch = 512;
            ItemDef.spriteCameraRoll = 1266;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.primaryFemaleHeadPiece = 0;
            ItemDef.primaryMaleModel = 80034;//male wearing
            ItemDef.primaryFemaleModel = 80034;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Lucky dragon 2h sword";//Name of the new item
            ItemDef.description = "A two-handed dragon sword.".getBytes();//examin info
        }
        if (i == 23106) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 100;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "White whip";
            ItemDef.description = "Made By The White Knights.".getBytes();
        }

        if (i == 25111) { //lava helm
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 10394;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modifiedModelColors[1] = 6020;
            ItemDef.originalModelColors[1] = 6020;
            ItemDef.modelId = 6583;
            ItemDef.spriteScale = 860;
            ItemDef.spritePitch = 2012;
            ItemDef.spriteCameraRoll = 188;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 17;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 6653;
            ItemDef.primaryFemaleModel = 6687;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 6570;
            ItemDef.primaryFemaleHeadPiece = 6575;
            ItemDef.name = "Ivandis helm";
            ItemDef.description = "It's a Ivandis helm".getBytes();
        }
        if (i == 28358)  // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 43072;
            ItemDef.originalModelColors[0] = 925;
            ItemDef.modifiedModelColors[1] = 4550;
            ItemDef.originalModelColors[1] = 925;
            ItemDef.modelId = 74148; //Model ID
            ItemDef.spriteScale = 1330; //zoom increase will make it smaller
            ItemDef.spritePitch = 310; //model rotate up+down increase to move doen away from you
            ItemDef.spriteCameraRoll = 1800; //model rotate side ways increase to move right in circle
            ItemDef.spriteTranslateX = 0; // model offset increase to move to the right
            ItemDef.spriteTranslateY = 1; //model offset increase to move up
            ItemDef.primaryMaleModel = 74147;//male wearing
            ItemDef.primaryFemaleModel = 74146;//female wearing
            ItemDef.secondaryFemaleModel = 74146;//Female arms/sleeves
            ItemDef.secondaryMaleModel = 74147;//male arms/sleeves
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Ice Torva platebody";//Name of the new item
            ItemDef.description = "Provides excellent protection".getBytes();//examin info
        }
        if (i == 28359) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modelId = 74150;
            ItemDef.primaryMaleModel = 70110;
            ItemDef.primaryFemaleModel = 74149;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.spriteScale = 2151;
            ItemDef.spritePitch = 429;
            ItemDef.spriteCameraRoll = 1189;
            ItemDef.spriteTranslateY = 5;
            ItemDef.name = "Ice Torva platelegs";
            ItemDef.description = "A pair of Ice Torva platelegs".getBytes();
        }

        if (i == 25107) { //ladies legs
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 62920;
            ItemDef.modifiedModelColors[1] = 912;
            ItemDef.originalModelColors[1] = 62928;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 5024;
            ItemDef.primaryFemaleModel = 5025;
            ItemDef.modelId = 5026;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ladies Platelegs";
            ItemDef.description = "Ladies platelegs".getBytes();
        }


        if (i == 25112) { //ivandis legs
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modifiedModelColors[1] = 912;
            ItemDef.originalModelColors[1] = 26667;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 5024;
            ItemDef.primaryFemaleModel = 5025;
            ItemDef.modelId = 5026;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ivandis Platelegs";
            ItemDef.description = "Stride through enemies territory in a heart beat.".getBytes();
        }
        if (i == 25109) { //ladies helm
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 10394;
            ItemDef.originalModelColors[0] = 62928;
            ItemDef.modifiedModelColors[1] = 6020;
            ItemDef.originalModelColors[1] = 6020;
            ItemDef.modelId = 6583;
            ItemDef.spriteScale = 860;
            ItemDef.spritePitch = 2012;
            ItemDef.spriteCameraRoll = 188;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 17;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 6653;
            ItemDef.primaryFemaleModel = 6687;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 6570;
            ItemDef.primaryFemaleHeadPiece = 6575;
            ItemDef.name = "Ladies Helm";
            ItemDef.description = "It's a Ladies helm".getBytes();
        }

        if (i == 25113) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 10283;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modifiedModelColors[1] = 10270;
            ItemDef.originalModelColors[1] = 24648;
            ItemDef.modifiedModelColors[2] = 3326;
            ItemDef.originalModelColors[2] = 24640;
            ItemDef.modelId = 8700;
            ItemDef.spriteScale = 710;
            ItemDef.spritePitch = 332;
            ItemDef.spriteCameraRoll = 2000;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 2;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 8726;
            ItemDef.primaryFemaleModel = 8750;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ivandis Gauntlets";
            ItemDef.description = "Ivandis Gauntlets.".getBytes();
        }
        if (i == 25215) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 8741;
            ItemDef.originalModelColors[0] = 924;
            ItemDef.modifiedModelColors[1] = 14490;
            ItemDef.originalModelColors[1] = 921;
            ItemDef.modelId = 6578;
            ItemDef.spriteScale = 1250;
            ItemDef.spritePitch = 468;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 3;
            ItemDef.primaryMaleModel = 6669;
            ItemDef.primaryFemaleModel = 6697;
            ItemDef.secondaryMaleModel = 170;
            ItemDef.secondaryFemaleModel = 348;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Draconic Top";
            ItemDef.description = "A draconic Ahrims top.".getBytes();
        }
        if (i == 25216) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 14490;
            ItemDef.originalModelColors[0] = 924;
            ItemDef.modifiedModelColors[1] = 45468;
            ItemDef.originalModelColors[1] = 921;
            ItemDef.modelId = 6577;
            ItemDef.spriteScale = 1730;
            ItemDef.spritePitch = 504;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 6659;
            ItemDef.primaryFemaleModel = 6691;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Draconic Bottoms";
            ItemDef.description = "A draconic Ahrims bottoms.".getBytes();
        }
        if (i == 25217) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 8741;
            ItemDef.originalModelColors[0] = 924;
            ItemDef.modelId = 5419;
            ItemDef.spriteScale = 730;
            ItemDef.spritePitch = 0;
            ItemDef.spriteCameraRoll = 2036;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 5430;
            ItemDef.primaryFemaleModel = 5435;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 5428;
            ItemDef.primaryFemaleHeadPiece = 5429;
            ItemDef.name = "Draconic Hood";
            ItemDef.description = "A draconic Ahrims Hood.".getBytes();
        }
        if (i == 25234) // change this if you need to "item number"
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 28;
            ItemDef.modifiedModelColors[0] = 74;
            ItemDef.originalModelColors[0] = 38676;
            ItemDef.originalModelColors[0] = 760;
            ItemDef.modelId = 5139;
            ItemDef.spriteScale = 490;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 192;
            ItemDef.spriteCameraYaw = 138;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 20;
            ItemDef.primaryMaleModel = 5114;//male wearing 15413
            ItemDef.primaryFemaleModel = 5114;//female wearing 15413
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Slayer Sword";
            ItemDef.description = "A Slayer sword by thedragon.".getBytes();
        }
        if (i == 25106) {//ladies gaunts
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 10283;
            ItemDef.originalModelColors[0] = 62928;
            ItemDef.modifiedModelColors[1] = 10270;
            ItemDef.originalModelColors[1] = 62928;
            ItemDef.modifiedModelColors[2] = 3326;
            ItemDef.originalModelColors[2] = 62928;
            ItemDef.modelId = 8700;
            ItemDef.spriteScale = 710;
            ItemDef.spritePitch = 332;
            ItemDef.spriteCameraRoll = 2000;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 2;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 8726;
            ItemDef.primaryFemaleModel = 8750;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ladies Gauntlets";
            ItemDef.description = "Ladies Gauntlets.".getBytes();
        }
        if (i == 25118) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Equip";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modelId = 153;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 278;
            ItemDef.primaryFemaleModel = 278;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Demon tail";
            ItemDef.description = "A demon tail.".getBytes();
        }

        if (i == 25119) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Equip";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modelId = 153;
            ItemDef.spriteScale = 760;
            ItemDef.spritePitch = 552;
            ItemDef.spriteCameraRoll = 28;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 242;
            ItemDef.primaryFemaleModel = 242;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Demon Horns #1";
            ItemDef.description = "Horns of a demon.".getBytes();
        }

        if (i == 25120) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Equip";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modelId = 153;
            ItemDef.spriteScale = 760;
            ItemDef.spritePitch = 552;
            ItemDef.spriteCameraRoll = 28;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 239;
            ItemDef.primaryFemaleModel = 239;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Demon Horns #2";
            ItemDef.description = "Horns of a demon.".getBytes();
        }

        if (i == 25121) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Equip";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modelId = 153;
            ItemDef.spriteScale = 760;
            ItemDef.spritePitch = 552;
            ItemDef.spriteCameraRoll = 28;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 229;
            ItemDef.primaryFemaleModel = 229;
            ItemDef.primaryMaleHeadPiece = 0;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Demon Head";
            ItemDef.description = "The head of a demon.".getBytes();
        }

        if (i == 25122) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Equip";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modelId = 153;
            ItemDef.spriteScale = 770;
            ItemDef.spritePitch = 152;
            ItemDef.spriteCameraRoll = 160;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = -6;
            ItemDef.primaryMaleModel = 182;
            ItemDef.primaryFemaleModel = 182;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Demon Feet";
            ItemDef.description = "The feet of a demon.".getBytes();
        }

        if (i == 25123) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Equip";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modelId = 153;
            ItemDef.spriteScale = 770;
            ItemDef.spritePitch = 152;
            ItemDef.spriteCameraRoll = 160;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = -6;
            ItemDef.primaryMaleModel = 180;
            ItemDef.primaryFemaleModel = 180;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Demon Hands";
            ItemDef.description = "The hands of a demon.".getBytes();
        }
        if (i == 25114) { //ivandis chain
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[5];
            ItemDef.originalModelColors = new int[5];
            ItemDef.modifiedModelColors[0] = 914;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modifiedModelColors[1] = 918;
            ItemDef.originalModelColors[1] = 24648;
            ItemDef.modifiedModelColors[2] = 922;
            ItemDef.originalModelColors[2] = 24640;
            ItemDef.modifiedModelColors[3] = 391;
            ItemDef.originalModelColors[3] = 26706;
            ItemDef.modifiedModelColors[4] = 917;
            ItemDef.originalModelColors[4] = 24648;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 568;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 3820;
            ItemDef.primaryFemaleModel = 3821;
            ItemDef.modelId = 3823;
            ItemDef.secondaryMaleModel = 156;
            ItemDef.secondaryFemaleModel = 337;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ivandis Chainmail";
            ItemDef.description = "Its a Ivandis Chain".getBytes();
        }

        if (i == 25115) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[4];
            ItemDef.originalModelColors = new int[4];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modelId = 5037;
            ItemDef.spriteScale = 770;
            ItemDef.spritePitch = 164;
            ItemDef.spriteCameraRoll = 156;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 4954;
            ItemDef.primaryFemaleModel = 5031;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ivandis Boots";
            ItemDef.description = "Ivandis boots".getBytes();
        }

        if (i == 25105) { //ladies chain
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[5];
            ItemDef.originalModelColors = new int[5];
            ItemDef.modifiedModelColors[0] = 914;
            ItemDef.originalModelColors[0] = 62928;
            ItemDef.modifiedModelColors[1] = 918;
            ItemDef.originalModelColors[1] = 62931;
            ItemDef.modifiedModelColors[2] = 922;
            ItemDef.originalModelColors[2] = 62928;
            ItemDef.modifiedModelColors[3] = 391;
            ItemDef.originalModelColors[3] = 62930;
            ItemDef.modifiedModelColors[4] = 917;
            ItemDef.originalModelColors[4] = 62928;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 568;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 3820;
            ItemDef.primaryFemaleModel = 3821;
            ItemDef.modelId = 3823;
            ItemDef.secondaryMaleModel = 156;
            ItemDef.secondaryFemaleModel = 337;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ladies Chainmail";
            ItemDef.description = "Its a Ladies Chain".getBytes();
        }

        if (i == 25104) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 62928;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 62928;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 62928;
            ItemDef.modelId = 5198;//Drop model & inv model
            ItemDef.spriteScale = 1900;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 500;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5196;//female wearing
            ItemDef.primaryMaleModel = 5196;//male wearing
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ladies shield";
            ItemDef.description = "Ladies shield".getBytes();
        }


        if (i == 25103) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[4];
            ItemDef.originalModelColors = new int[4];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 62929;
            ItemDef.modelId = 5037;
            ItemDef.spriteScale = 770;
            ItemDef.spritePitch = 164;
            ItemDef.spriteCameraRoll = 156;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 4954;
            ItemDef.primaryFemaleModel = 5031;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ladies Boots";
            ItemDef.description = "Ladies boots".getBytes();
        }
        if (i == 25102) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 62928;
            ItemDef.modifiedModelColors[1] = 935;
            ItemDef.originalModelColors[1] = 62930;
            ItemDef.modelId = 6033;//Item Look
            ItemDef.spriteScale = 980;
            ItemDef.spritePitch = 350;
            ItemDef.spriteCameraRoll = 1020;
            ItemDef.spriteCameraYaw = 324;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 6031;
            ItemDef.primaryFemaleModel = 6031;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ladies Blade";
            ItemDef.description = "".getBytes();
        }

        if (i == 23109) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 43968;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 43968;
            ItemDef.modelId = 5198;//Drop model & inv model
            ItemDef.spriteScale = 1900;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 500;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5196;//female wearing
            ItemDef.primaryMaleModel = 5196;//male wearing
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Crystal shield";
            ItemDef.description = "Blue Crystal shield".getBytes();
        }

        if (i == 25203) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 43968;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 43968;
            ItemDef.modelId = 3902;//Drop model & inv model
            ItemDef.spriteScale = 1570;
            ItemDef.spritePitch = 192;
            ItemDef.spriteCameraRoll = 76;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5197;//female wearing
            ItemDef.primaryMaleModel = 5197;//male wearing
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Crystal shield";
            ItemDef.description = "Blue Crystal shield".getBytes();
        }

        if (i == 25116) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 24648;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 24640;
            ItemDef.modelId = 5198;//Drop model & inv model
            ItemDef.spriteScale = 1900;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 500;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5196;//female wearing
            ItemDef.primaryMaleModel = 5196;//male wearing
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ivandis shield";
            ItemDef.description = "Ivandis shield".getBytes();
        }

        if (i == 25117) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 26706;
            ItemDef.modifiedModelColors[1] = 935;
            ItemDef.originalModelColors[1] = 24648;
            ItemDef.modelId = 6033;//Item Look
            ItemDef.spriteScale = 980;
            ItemDef.spritePitch = 350;
            ItemDef.spriteCameraRoll = 1020;
            ItemDef.spriteCameraYaw = 324;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 6031;
            ItemDef.primaryFemaleModel = 6031;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ivandis Blade";
            ItemDef.description = "Show no mercy, led anger rule your fury.".getBytes();
        }
        if (i == 23115) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 128;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 128;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 128;
            ItemDef.modelId = 5198;//Drop model & inv model
            ItemDef.spriteScale = 1900;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 500;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5196;//female wearing
            ItemDef.primaryMaleModel = 5196;//male wearing
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Black Crystal shield";
            ItemDef.description = "Black Crystal shield".getBytes();
        }
        if (i == 23117) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear"; //this is the new option to equipt, can change to w/e u want
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;  //original color
            ItemDef.originalModelColors[0] = 0; //changed color
            ItemDef.modelId = 2438;
            ItemDef.spriteScale = 730;
            ItemDef.spritePitch = 516;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -10;
            ItemDef.primaryMaleModel = 3188;
            ItemDef.primaryFemaleModel = 3192;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 1755;
            ItemDef.primaryFemaleHeadPiece = 3187;
            ItemDef.name = "Black h'ween Mask";
            ItemDef.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }
        if (i == 23118) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear"; //this is the new option to equipt, can change to w/e u want
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;  //original color
            ItemDef.originalModelColors[0] = 11200; //changed color
            ItemDef.modelId = 2438;
            ItemDef.spriteScale = 730;
            ItemDef.spritePitch = 516;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -10;
            ItemDef.primaryMaleModel = 3188;
            ItemDef.primaryFemaleModel = 3192;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 1755;
            ItemDef.primaryFemaleHeadPiece = 3187;
            ItemDef.name = "Yellow h'ween Mask";
            ItemDef.description = "Aaaarrrghhh... I'm a monster.".getBytes();
        }

        if (i == 25365) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear"; //t
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 22416;  //original color
            ItemDef.originalModelColors[0] = 11200; //changed color
            ItemDef.modifiedModelColors[1] = 22424;  //original color
            ItemDef.originalModelColors[1] = 11200; //changed color
            ItemDef.modelId = 2745;
            ItemDef.spriteScale = 1030;
            ItemDef.spritePitch = 548;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 314;
            ItemDef.primaryFemaleModel = 477;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Yellow d'hide body";
            ItemDef.description = "really a yellow d'hide body".getBytes();
        }

        if (i == 23094)    //WH1P!!!!
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear"; //this is the new option to equipt, can change to w/e u want
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;  //original color
            ItemDef.originalModelColors[0] = 36133; //changed color
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Rune Whip";
            ItemDef.description = "A whip made of Rune".getBytes();
        }

        if (i == 24632) { //Black Platelegs (B)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 0;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 43968;
            ItemDef.modelId = 3196;
            ItemDef.spriteScale = 1370;
            ItemDef.spritePitch = 204;
            ItemDef.spriteCameraRoll = 804;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 3189;
            ItemDef.primaryFemaleModel = 3194;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Ice Cape";
            ItemDef.description = "It's Black Platelegs (B)".getBytes();
        }

        if (i == 23091) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.itemActions[2] = "Customise";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            //Purple: 926-127
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 128;
            ItemDef.modelId = 2635;//Item Look
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Custom Party Hat";
            ItemDef.description = "A nice hat from a cracker.".getBytes();
        }
        if (i == 24090) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 51136;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Purple santa hat ";
            ItemDef.description = "Purple santa hat.".getBytes();
        }
        if (i == 25322) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 35321;
            ItemDef.modifiedModelColors[1] = 35321;
            ItemDef.originalModelColors[1] = 35321;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "sky santa hat ";
            ItemDef.description = "Sky santa hat.".getBytes();
        }
        if (i == 24091) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 6;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Black santa hat ";
            ItemDef.description = "Black santa hat.".getBytes();
        }

        if (i == 24092) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Mithril santa hat ";
            ItemDef.description = "Mithril santa hat.".getBytes();
        }

        if (i == 24093) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 36133;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Rune santa hat ";
            ItemDef.description = "Rune santa hat.".getBytes();
        }

        if (i == 24094) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 1000;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Dragon santa hat ";
            ItemDef.description = "Dragon santa hat.".getBytes();
        }

        if (i == 24095) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 21662;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Addy santa hat ";
            ItemDef.description = "Addy santa hat.".getBytes();
        }

        if (i == 24096) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 7114;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Gold santa hat ";
            ItemDef.description = "Gold santa hat.".getBytes();
        }

        if (i == 24097) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 10394;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Barrows santa hat ";
            ItemDef.description = "Barrows santa hat.".getBytes();
        }

        if (i == 24098) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 7097;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Blue santa hat ";
            ItemDef.description = "Blue santa hat.".getBytes();
        }

        if (i == 25095) //Replace with the id you want
        {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";//New option
            ItemDef.modelId = 14623; //Model ID
            ItemDef.spriteScale = 800; //1200 zoom increase will make it smaller
            ItemDef.spritePitch = 572; //model rotate up+down increase to move doen away from you
            ItemDef.spriteCameraRoll = 0; //model rotate side ways increase to move right in circle
            ItemDef.spriteTranslateX = 0; // model offset increase to move to the right
            ItemDef.spriteTranslateY = 1; //model offset increase to move up
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.noteable = -1;//noteable
            ItemDef.primaryMaleModel = 14623;//male wearing
            ItemDef.primaryFemaleModel = 14623;//female wearing
            ItemDef.stackable = false;//Stackable
            ItemDef.name = "Winged Sandals";//Name of the new item
            ItemDef.description = "Apollo's gift.".getBytes();//examine info
        }
        if (i == 27885) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";
            ItemDef.modelId = 14045;
            ItemDef.spriteScale = 2000;
            ItemDef.spritePitch = 572;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteTranslateX = 25;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 14046;
            ItemDef.primaryFemaleModel = 14046;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.stackable = false;
            ItemDef.name = "Bandos whip";
            ItemDef.description = "A whip from the warchief Graardor".getBytes();
        }
        if (i == 24100) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 6073;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Orange Whip";
            ItemDef.description = "a Orange Whip".getBytes();
        }

        if (i == 24101) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 51136;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Purple Whip";
            ItemDef.description = "a Purple Whip".getBytes();
        }

        if (i == 24102) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.itemActions[2] = "Customise";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 25;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Custom Whip";
            ItemDef.description = "a Custom Color Whip".getBytes();
        }

        if (i == 24103) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 950;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Red Whip";
            ItemDef.description = "a Red Whip".getBytes();
        }

        if (i == 24104) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Whip";
            ItemDef.description = "a Blue Whip".getBytes();
        }

        if (i == 24105) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 10394;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Barrows Whip";
            ItemDef.description = "a Barrows Whip".getBytes();
        }

        if (i == 24106) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 7114;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Gold Whip";
            ItemDef.description = "a Gold Whip".getBytes();
        }
        if (i == 24107) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 100;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "White Whip";
            ItemDef.description = "a White Whip".getBytes();
        }

        if (i == 25000) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 924;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Dragon Whip";
            ItemDef.description = "It Is a Dragon Whip if ur rich its for u!".getBytes();
        }

        if (i == 25001) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.itemActions[2] = "die!";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Death Whip";
            ItemDef.description = "omfg its a death whip!".getBytes();
        }

        if (i == 28000) { //black phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Black Party Hat";
            ItemDef.description = "An Black Party Hat.".getBytes();
        }

        if (i == 24109) { //orange phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 6073;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Orange Party Hat";
            ItemDef.description = "An Orange Party Hat.".getBytes();
        }

        if (i == 24110) { //Gold phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 8128;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Gold Party Hat";
            ItemDef.description = "A Gold Party Hat.".getBytes();
        }

        if (i == 24111) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 50;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Grey Party Hat";
            ItemDef.description = "A Grey Party Hat.".getBytes();
        }

        if (i == 24112) { //Bronze phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 5652;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Bronze Party Hat";
            ItemDef.description = "A Bronze Party Hat.".getBytes();
        }

        if (i == 24113) { //Steel phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 41;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Steel Party Hat";
            ItemDef.description = "A Steel Party Hat.".getBytes();
        }

        if (i == 24114) { //Mithril phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Mithril Party Hat";
            ItemDef.description = "A Mithril Party Hat.".getBytes();
        }
        if (i == 25090) { //Mithril phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "look at";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 586;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modelId = 546;
            ItemDef.spriteScale = 654;
            ItemDef.spritePitch = 852;
            ItemDef.spriteCameraRoll = 36;
            ItemDef.spriteCameraYaw = 85;
            ItemDef.spriteTranslateX = 8745;
            ItemDef.spriteTranslateY = 5487;
            ItemDef.primaryMaleModel = 9856;
            ItemDef.primaryFemaleModel = 8547;
            ItemDef.primaryMaleHeadPiece = 2103;
            ItemDef.primaryFemaleHeadPiece = 8956;
            ItemDef.name = "rum deal";
            ItemDef.description = "omfg its the rum deal thingy.".getBytes();
        }
        if (i == 24115) { //Adamant phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 21662;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Adamant Party Hat";
            ItemDef.description = "An Addy Party Hat.".getBytes();
        }

        if (i == 24116) { //Rune phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 36133;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Rune Party Hat";
            ItemDef.description = "A Rune Party Hat.".getBytes();
        }

        if (i == 24117) { //Dragon phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 924;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Dragon Party Hat";
            ItemDef.description = "A Dragon Party Hat.".getBytes();
        }

        if (i == 24118) { //Barrows phat
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 10388;
            ItemDef.modelId = 2635;
            ItemDef.spriteScale = 440;
            ItemDef.spritePitch = 76;
            ItemDef.spriteCameraRoll = 1850;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 1;
            ItemDef.primaryMaleModel = 187;
            ItemDef.primaryFemaleModel = 363;
            ItemDef.primaryMaleHeadPiece = 29;
            ItemDef.primaryFemaleHeadPiece = 87;
            ItemDef.name = "Barrows Party Hat";
            ItemDef.description = "A Party Hat worn by the Barrows Brothers.".getBytes();
        }

        if (i == 24119) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 22464;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Green Whip";
            ItemDef.description = "a Green Whip".getBytes();
        }

        if (i == 23119) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[5];
            ItemDef.originalModelColors = new int[5];
            ItemDef.modelId = 93288;
            ItemDef.spriteScale = 2000;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = 1;
            ItemDef.spriteCameraYaw = 14;
            ItemDef.primaryMaleModel = 93287;
            ItemDef.primaryFemaleModel = 93287;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.noteable = -1;
            ItemDef.name = "Death Cape";
            ItemDef.description = "Death Cape made by death! ".getBytes();
        }


        if (i == 23603) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wield";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 28;
            ItemDef.modifiedModelColors[0] = 74;
            ItemDef.originalModelColors[0] = 10512;
            ItemDef.originalModelColors[0] = 10512;
            ItemDef.modelId = 4671;
            ItemDef.spriteScale = 490;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 192;
            ItemDef.spriteCameraYaw = 138;
            ItemDef.noteable = -1;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = 20;
            ItemDef.primaryMaleModel = 4672;
            ItemDef.primaryFemaleModel = 4672;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.stackable = false;
            ItemDef.name = "Barrows defender";
            ItemDef.description = "A defensive weapon.".getBytes();
        }

        if (i == 24571) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 32465;
            ItemDef.modifiedModelColors[1] = 912;
            ItemDef.originalModelColors[1] = 64449;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 5024;
            ItemDef.primaryFemaleModel = 5025;
            ItemDef.modelId = 5026;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Mod Sgs Platelegs";
            ItemDef.description = "A set of Mod Sgs's platelegs.".getBytes();
        }
        if (i == 23172) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 0;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modelId = 12234;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 498;
            ItemDef.spriteCameraRoll = 550;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 12233;
            ItemDef.primaryFemaleModel = 12233;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Bandos C'Bow";
            ItemDef.description = "A great bow, used by the best warriors.".getBytes();
        }
        if (i == 23173) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 0;
            ItemDef.originalModelColors[0] = 0;
            ItemDef.modelId = 13421;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 498;
            ItemDef.spriteCameraRoll = 550;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 13422;
            ItemDef.primaryFemaleModel = 13422;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.stackable = false;
            ItemDef.name = "Dragon C'Bow";
            ItemDef.description = "A powerful and rare crossbow".getBytes();
        }
        if (i == 23015) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modelId = 9226;
            ItemDef.spriteScale = 467;
            ItemDef.spritePitch = 74;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 9233;
            ItemDef.primaryFemaleModel = 9233;
            ItemDef.name = "Death Cape (blue)";
            ItemDef.description = "Its A Death Cape (blue)".getBytes();
        }
        if (i == 23014) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modelId = 9232;
            ItemDef.spriteScale = 467;
            ItemDef.spritePitch = 74;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 9231;
            ItemDef.primaryFemaleModel = 9231;
            ItemDef.name = "Death Cape (green)";
            ItemDef.description = "Its A Death Cape (green)".getBytes();
        }
        if (i == 23013) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modelId = 9230;
            ItemDef.spriteScale = 467;
            ItemDef.spritePitch = 74;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 9229;
            ItemDef.primaryFemaleModel = 9229;
            ItemDef.name = "Death Cape (sky)";
            ItemDef.description = "Its A Death Cape (sky)".getBytes();
        }
        if (i == 23012) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modelId = 9228;
            ItemDef.spriteScale = 467;
            ItemDef.spritePitch = 74;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 9227;
            ItemDef.primaryFemaleModel = 9227;
            ItemDef.name = "Mod Sgs Death Cape";
            ItemDef.description = "Its Mod Sgs's Death cape".getBytes();
        }
        if (i == 25312) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 6073;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Orange cavalier";
            ItemDef.description = "a Orange cavalier".getBytes();
        }
        if (i == 25313) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 51136;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Purple cavalier";
            ItemDef.description = "a Purple cavalier".getBytes();
        }
        if (i == 25314) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.itemActions[2] = "Customise";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 25;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Custom  cavalier";
            ItemDef.description = "a Custom Color cavalier".getBytes();
        }
        if (i == 25315) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 950;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Red cavalier";
            ItemDef.description = "a Red cavalier".getBytes();
        }

        if (i == 26030) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 8245;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 8245;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Dark Gray santa hat ";
            ItemDef.description = "Dark Gray santa hat.".getBytes();
        }
        if (i == 26031) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 18105;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 18105;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Lime Green santa hat ";
            ItemDef.description = "Lime Green santa hat.".getBytes();
        }
        if (i == 26032) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 45549;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 45549;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Unknowed White santa hat ";
            ItemDef.description = "Unknowed White santa hat.".getBytes();
        }
        if (i == 26033) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 50971;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 50971;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Deep Purple santa hat ";
            ItemDef.description = "Deep Purple santa hat.".getBytes();
        }
        if (i == 26034) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 60176;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 60176;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Deeper Purple santa hat ";
            ItemDef.description = "Deeper Purple santa hat.".getBytes();
        }
        if (i == 26035) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 19213;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 19213;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Deep Green santa hat ";
            ItemDef.description = "Deep Green santa hat.".getBytes();
        }
        if (i == 26035) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 3654;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 3654;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Dull Orange santa hat ";
            ItemDef.description = "Dull Orange santa hat.".getBytes();
        }
        if (i == 26036) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 12904;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 12904;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Bright Yellow santa hat ";
            ItemDef.description = "Bright Yellow santa hat.".getBytes();
        }
        if (i == 26037) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 618;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 618;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Bright Pink santa hat ";
            ItemDef.description = "Bright Pink santa hat.".getBytes();
        }
        if (i == 26038) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 46440;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 46440;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Bright Blue santa hat ";
            ItemDef.description = "Bright Blue santa hat.".getBytes();
        }
        if (i == 26039) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 11378;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 11378;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Bright Gray santa hat ";
            ItemDef.description = "Bright Gray santa hat.".getBytes();
        }
        if (i == 26040) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 36207;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 36207;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Bright Sky Blue santa hat ";
            ItemDef.description = "Bright Sky Blue santa hat.".getBytes();
        }
        if (i == 26041) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 32562;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 32562;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Teal santa hat ";
            ItemDef.description = "Teal santa hat.".getBytes();
        }
        if (i == 26042) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 933;
            ItemDef.originalModelColors[0] = 8245;
            ItemDef.modifiedModelColors[1] = 10351;
            ItemDef.originalModelColors[1] = 8245;
            ItemDef.modelId = 2537;
            ItemDef.spriteScale = 540;
            ItemDef.spritePitch = 72;
            ItemDef.spriteCameraRoll = 136;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 189;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.primaryFemaleModel = 366;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 69;
            ItemDef.primaryFemaleHeadPiece = 127;
            ItemDef.stackable = false;
            ItemDef.name = "Dark Gray santa hat ";
            ItemDef.description = "Dark Gray santa hat.".getBytes();
        }

        if (i == 25612) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 944;
            ItemDef.originalModelColors[0] = 32984;
            ItemDef.modelId = 5412;
            ItemDef.spriteScale = 840;
            ItemDef.spritePitch = 280;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -2;
            ItemDef.spriteTranslateY = 56;
            ItemDef.primaryMaleModel = 5409;
            ItemDef.primaryFemaleModel = 5409;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Diamond Whip";
            ItemDef.description = "a Diamond Whip".getBytes();
        }


        if (i == 25613) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 33;
            ItemDef.originalModelColors[0] = 32984;
            ItemDef.modifiedModelColors[1] = 49;
            ItemDef.originalModelColors[1] = 32984;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 32984;
            ItemDef.modelId = 2558;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 568;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 301;
            ItemDef.primaryFemaleModel = 464;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Diamond chainbody";
            ItemDef.description = "a Diamond chainbody".getBytes();
        }

        if (i == 25614) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 24;
            ItemDef.originalModelColors[0] = 32984;
            ItemDef.modifiedModelColors[1] = 61;
            ItemDef.originalModelColors[1] = 32984;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 32984;
            ItemDef.modelId = 2605;
            ItemDef.spriteScale = 1250;
            ItemDef.spritePitch = 488;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 306;
            ItemDef.primaryFemaleModel = 468;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Diamond Platebody";
            ItemDef.description = "a Diamond Platebody".getBytes();
        }

        if (i == 25615) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 32984;
            ItemDef.modelId = 2833;
            ItemDef.spriteScale = 640;
            ItemDef.spritePitch = 108;
            ItemDef.spriteCameraRoll = 156;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 1;
            ItemDef.spriteTranslateY = -4;
            ItemDef.primaryMaleModel = 219;
            ItemDef.primaryFemaleModel = 395;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 57;
            ItemDef.primaryFemaleHeadPiece = 117;
            ItemDef.name = "Diamond Med Helm";
            ItemDef.description = "a Diamond Med Helm".getBytes();
        }

        if (i == 25616) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 32984;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 48030;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Diamond full Helm";
            ItemDef.description = "a Diamond full Helm".getBytes();
        }

        if (i == 25617) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 32984;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 32984;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 32984;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Diamond Platelegs";
            ItemDef.description = "a Diamond platelegs".getBytes();
        }

        if (i == 24343) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 10394;
            ItemDef.originalModelColors[0] = 6069;
            ItemDef.modifiedModelColors[1] = 6020;
            ItemDef.originalModelColors[1] = 6020;
            ItemDef.modelId = 6583;
            ItemDef.spriteScale = 860;
            ItemDef.spritePitch = 2012;
            ItemDef.spriteCameraRoll = 188;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 17;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 6653;
            ItemDef.primaryFemaleModel = 6687;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 6570;
            ItemDef.primaryFemaleHeadPiece = 6575;
            ItemDef.name = "Lava Helm";
            ItemDef.description = "It's a Lava helm".getBytes();
        }
        if (i == 24338) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = 6072;
            ItemDef.modifiedModelColors[1] = 912;
            ItemDef.originalModelColors[1] = 6054;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 5024;
            ItemDef.primaryFemaleModel = 5025;
            ItemDef.modelId = 5026;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Lava Platelegs";
            ItemDef.description = "Lava platelegs".getBytes();
        }
        if (i == 24342) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 10283;
            ItemDef.originalModelColors[0] = 6069;
            ItemDef.modifiedModelColors[1] = 10270;
            ItemDef.originalModelColors[1] = 6073;
            ItemDef.modifiedModelColors[2] = 3326;
            ItemDef.originalModelColors[2] = 6074;
            ItemDef.modelId = 8700;
            ItemDef.spriteScale = 710;
            ItemDef.spritePitch = 332;
            ItemDef.spriteCameraRoll = 2000;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 2;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 8726;
            ItemDef.primaryFemaleModel = 8750;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Lava Gauntlets";
            ItemDef.description = "Lava Gauntlets.".getBytes();
        }
        if (i == 24339) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[5];
            ItemDef.originalModelColors = new int[5];
            ItemDef.modifiedModelColors[0] = 914;
            ItemDef.originalModelColors[0] = 6070;
            ItemDef.modifiedModelColors[1] = 918;
            ItemDef.originalModelColors[1] = 6070;
            ItemDef.modifiedModelColors[2] = 922;
            ItemDef.originalModelColors[2] = 6071;
            ItemDef.modifiedModelColors[3] = 391;
            ItemDef.originalModelColors[3] = 6070;
            ItemDef.modifiedModelColors[4] = 917;
            ItemDef.originalModelColors[4] = 6069;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 568;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 3820;
            ItemDef.primaryFemaleModel = 3821;
            ItemDef.modelId = 3823;
            ItemDef.secondaryMaleModel = 156;
            ItemDef.secondaryFemaleModel = 337;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Lava Chainmail";
            ItemDef.description = "It's a Lava Chain".getBytes();
        }
        if (i == 24340) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 6073;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 6069;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 6069;
            ItemDef.modelId = 5198;
            ItemDef.spriteScale = 1900;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 500;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5196;
            ItemDef.primaryMaleModel = 5196;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Lava shield";
            ItemDef.description = "Lava shield".getBytes();
        }
        if (i == 24341) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[4];
            ItemDef.originalModelColors = new int[4];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 6073;
            ItemDef.modelId = 5037;
            ItemDef.spriteScale = 770;
            ItemDef.spritePitch = 164;
            ItemDef.spriteCameraRoll = 156;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 4954;
            ItemDef.primaryFemaleModel = 5031;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Lava Boots";
            ItemDef.description = "Lava boots".getBytes();
        }
        if (i == 24243) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 10394;
            ItemDef.originalModelColors[0] = -22221;
            ItemDef.modifiedModelColors[1] = 6020;
            ItemDef.originalModelColors[1] = -22221;
            ItemDef.modelId = 6583;
            ItemDef.spriteScale = 860;
            ItemDef.spritePitch = 2012;
            ItemDef.spriteCameraRoll = 188;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 17;
            ItemDef.spriteTranslateY = 0;
            ItemDef.primaryMaleModel = 6653;
            ItemDef.primaryFemaleModel = 6687;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 6570;
            ItemDef.primaryFemaleHeadPiece = 6575;
            ItemDef.name = "Blue Dragon Helm";
            ItemDef.description = "It's a Blue Dragon helm".getBytes();
        }
        if (i == 24238) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 926;
            ItemDef.originalModelColors[0] = -22221;
            ItemDef.modifiedModelColors[1] = 912;
            ItemDef.originalModelColors[1] = -22221;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 5024;
            ItemDef.primaryFemaleModel = 5025;
            ItemDef.modelId = 5026;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Dragon Platelegs";
            ItemDef.description = "Blue Dragon platelegs".getBytes();
        }
        if (i == 24242) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 10283;
            ItemDef.originalModelColors[0] = -22221;
            ItemDef.modifiedModelColors[1] = 10270;
            ItemDef.originalModelColors[1] = -22221;
            ItemDef.modifiedModelColors[2] = 3326;
            ItemDef.originalModelColors[2] = -22221;
            ItemDef.modelId = 8700;
            ItemDef.spriteScale = 710;
            ItemDef.spritePitch = 332;
            ItemDef.spriteCameraRoll = 2000;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 2;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 8726;
            ItemDef.primaryFemaleModel = 8750;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Dragon Gauntlets";
            ItemDef.description = "Blue Dragon Gauntlets.".getBytes();
        }
        if (i == 24239) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[5];
            ItemDef.originalModelColors = new int[5];
            ItemDef.modifiedModelColors[0] = 914;
            ItemDef.originalModelColors[0] = -22221;
            ItemDef.modifiedModelColors[1] = 918;
            ItemDef.originalModelColors[1] = -22221;
            ItemDef.modifiedModelColors[2] = 922;
            ItemDef.originalModelColors[2] = -22221;
            ItemDef.modifiedModelColors[3] = 391;
            ItemDef.originalModelColors[3] = -22221;
            ItemDef.modifiedModelColors[4] = 917;
            ItemDef.originalModelColors[4] = -22221;
            ItemDef.spriteScale = 1100;
            ItemDef.spritePitch = 568;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = 2;
            ItemDef.primaryMaleModel = 3820;
            ItemDef.primaryFemaleModel = 3821;
            ItemDef.modelId = 3823;
            ItemDef.secondaryMaleModel = 156;
            ItemDef.secondaryFemaleModel = 337;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Dragon chainbody";
            ItemDef.description = "It's a Blue Dragon Chain".getBytes();
        }
        if (i == 24240) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 43127;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modifiedModelColors[1] = 38119;
            ItemDef.originalModelColors[1] = 43968;
            ItemDef.modifiedModelColors[2] = 36975;
            ItemDef.originalModelColors[2] = 43968;
            ItemDef.modelId = 5198;
            ItemDef.spriteScale = 1900;
            ItemDef.spritePitch = 500;
            ItemDef.spriteCameraRoll = 500;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryFemaleModel = 5196;
            ItemDef.primaryMaleModel = 5196;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue shield";
            ItemDef.description = "Blue shield".getBytes();
        }
        if (i == 24241) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[4];
            ItemDef.originalModelColors = new int[4];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modelId = 5037;
            ItemDef.spriteScale = 770;
            ItemDef.spritePitch = 164;
            ItemDef.spriteCameraRoll = 156;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 3;
            ItemDef.spriteTranslateY = -3;
            ItemDef.primaryMaleModel = 4954;
            ItemDef.primaryFemaleModel = 5031;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue Boots";
            ItemDef.description = "Blue boots".getBytes();
        }


        if (i == 25712) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43968;
            ItemDef.modelId = 2373;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 300;
            ItemDef.spriteCameraRoll = 1120;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = 4;
            ItemDef.primaryMaleModel = 490;
            ItemDef.primaryFemaleModel = 490;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Blue scimitar";
            ItemDef.description = "a Blue scimitar".getBytes();
        }

        if (i == 25316) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 10394;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Barrows cavalier";
            ItemDef.description = "a Barrows cavalier".getBytes();
        }
        if (i == 25317) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 7114;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Gold cavalier";
            ItemDef.description = "a Gold cavalier".getBytes();
        }
        if (i == 25318) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 100;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "White cavalier";
            ItemDef.description = "a White cavalier".getBytes();
        }
        if (i == 25319) {
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[1];
            ItemDef.originalModelColors = new int[1];
            ItemDef.modifiedModelColors[0] = 7073;
            ItemDef.originalModelColors[0] = 924;
            ItemDef.modelId = 2451;
            ItemDef.spriteScale = 690;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 1856;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 186;
            ItemDef.primaryFemaleModel = 362;
            ItemDef.secondaryMaleModel = -1;
            ItemDef.secondaryFemaleModel = -1;
            ItemDef.primaryMaleHeadPiece = 28;
            ItemDef.primaryFemaleHeadPiece = 86;
            ItemDef.name = "Dragon cavalier";
            ItemDef.description = "a Dragon cavalier".getBytes();
        }
        if (i == 23482) { //Black Platelegs (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 22464;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platelegs (G)";
            ItemDef.description = "It's Steel Platelegs (G)".getBytes();
        }
        if (i == 23483) { //Black Platebody (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 22464;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43072;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platebody (G)";
            ItemDef.description = "It's a Steel Platebody (G)".getBytes();
        }
        if (i == 23484) { //Black Helm (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 22464;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Steel Helm (G)";
            ItemDef.description = "It's a Steel Helm (G)".getBytes();
        }
        if (i == 23485) { //Black Kiteshield (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 57;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 7054;
            ItemDef.originalModelColors[2] = 22464;
            ItemDef.modelId = 2339;
            ItemDef.spriteScale = 1560;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 1104;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 486;
            ItemDef.primaryFemaleModel = 486;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Kiteshield (G)";
            ItemDef.description = "It's a Steel Kiteshield (G)".getBytes();
        }
        if (i == 23486) { //Black Platelegs (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 100;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platelegs (W)";
            ItemDef.description = "It's Steel Platelegs (W)".getBytes();
        }
        if (i == 23487) { //Black Platebody (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 100;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43072;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platebody (W)";
            ItemDef.description = "It's a Steel Platebody (W)".getBytes();
        }
        if (i == 23488) { //Black Helm (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 100;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Steel Helm (W)";
            ItemDef.description = "It's a Steel Helm (W)".getBytes();
        }
        if (i == 23489) { //Black Kiteshield (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 57;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 7054;
            ItemDef.originalModelColors[2] = 100;
            ItemDef.modelId = 2339;
            ItemDef.spriteScale = 1560;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 1104;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 486;
            ItemDef.primaryFemaleModel = 486;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Kiteshield (W)";
            ItemDef.description = "It's a Steel Kiteshield (W)".getBytes();
        }
        if (i == 23490) { //Black Platelegs (B)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 43968;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platelegs (B)";
            ItemDef.description = "It's Steel Platelegs (B)".getBytes();
        }
        if (i == 23491) { //Black Platebody (B)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 43968;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43072;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platebody (B)";
            ItemDef.description = "It's a Steel Platebody (B)".getBytes();
        }
        if (i == 23492) { //Black Helm (B)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 43968;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Steel Helm (B)";
            ItemDef.description = "It's a Steel Helm (B)".getBytes();
        }
        if (i == 23493) { //Black Kiteshield (B)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 57;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 7054;
            ItemDef.originalModelColors[2] = 43968;
            ItemDef.modelId = 2339;
            ItemDef.spriteScale = 1560;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 1104;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 486;
            ItemDef.primaryFemaleModel = 486;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Kiteshield (B)";
            ItemDef.description = "It's a Steel Kiteshield (B)".getBytes();
        }
        if (i == 23494) { //Steel Platelegs (O)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 6073;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platelegs (O)";
            ItemDef.description = "It's Steel Platelegs (O)".getBytes();
        }
        if (i == 23495) { //Steel Platebody (O)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 6073;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43072;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platebody (O)";
            ItemDef.description = "It's a Steel Platebody (O)".getBytes();
        }
        if (i == 23496) { //Steel Helm (O)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 6073;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Steel Helm (O)";
            ItemDef.description = "It's a Steel Helm (O)".getBytes();
        }
        if (i == 23497) { //Steel Kiteshield (O)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 57;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 7054;
            ItemDef.originalModelColors[2] = 6073;
            ItemDef.modelId = 2339;
            ItemDef.spriteScale = 1560;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 1104;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 486;
            ItemDef.primaryFemaleModel = 486;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Kiteshield (O)";
            ItemDef.description = "It's a Steel Kiteshield (O)".getBytes();
        }
        if (i == 23498) { //Steel Platelegs (P)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 51136;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platelegs (P)";
            ItemDef.description = "It's Steel Platelegs (P)".getBytes();
        }
        if (i == 23499) { //Steel Platebody (P)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 51136;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43072;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Platebody (P)";
            ItemDef.description = "It's a Steel Platebody (P)".getBytes();
        }
        if (i == 23500) { //Steel Helm (P)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 51136;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Steel Helm (P)";
            ItemDef.description = "It's a Steel Helm (P)".getBytes();
        }
        if (i == 23501) { //Steel Kiteshield (P)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43072;
            ItemDef.modifiedModelColors[1] = 57;
            ItemDef.originalModelColors[1] = 43072;
            ItemDef.modifiedModelColors[2] = 7054;
            ItemDef.originalModelColors[2] = 51136;
            ItemDef.modelId = 2339;
            ItemDef.spriteScale = 1560;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 1104;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 486;
            ItemDef.primaryFemaleModel = 486;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Steel Kiteshield (P)";
            ItemDef.description = "It's a Steel Kiteshield (P)".getBytes();
        }
        if (i == 23502) { //Mith Platelegs (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43297;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 22464;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Mith Platelegs (G)";
            ItemDef.description = "It's Mith Platelegs (G)".getBytes();
        }
        if (i == 23503) { //Mith Platebody (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 22464;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43297;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Mith Platebody (G)";
            ItemDef.description = "It's a Mith Platebody (G)".getBytes();
        }
        if (i == 23504) { //Mith Helm (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 22464;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Mith Helm (G)";
            ItemDef.description = "It's a Mith Helm (G)".getBytes();
        }
        if (i == 23505) { //Mith Kiteshield (G)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 57;
            ItemDef.originalModelColors[1] = 43297;
            ItemDef.modifiedModelColors[2] = 7054;
            ItemDef.originalModelColors[2] = 22464;
            ItemDef.modelId = 2339;
            ItemDef.spriteScale = 1560;
            ItemDef.spritePitch = 344;
            ItemDef.spriteCameraRoll = 1104;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -6;
            ItemDef.spriteTranslateY = -14;
            ItemDef.primaryMaleModel = 486;
            ItemDef.primaryFemaleModel = 486;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Mith Kiteshield (G)";
            ItemDef.description = "It's a Mith Kiteshield (G)".getBytes();
        }
        if (i == 23506) { //Mith Platelegs (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 41;
            ItemDef.originalModelColors[1] = 43297;
            ItemDef.modifiedModelColors[2] = 57;
            ItemDef.originalModelColors[2] = 100;
            ItemDef.modelId = 2582;
            ItemDef.spriteScale = 1740;
            ItemDef.spritePitch = 444;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = 0;
            ItemDef.spriteTranslateY = -8;
            ItemDef.primaryMaleModel = 268;
            ItemDef.primaryFemaleModel = 432;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Mith Platelegs (W)";
            ItemDef.description = "It's Mith Platelegs (W)".getBytes();
        }
        if (i == 23507) { //Mith Platebody (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[3];
            ItemDef.originalModelColors = new int[3];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 24;
            ItemDef.originalModelColors[1] = 100;
            ItemDef.modifiedModelColors[2] = 41;
            ItemDef.originalModelColors[2] = 43297;
            ItemDef.modelId = 2378;
            ItemDef.spriteScale = 1180;
            ItemDef.spritePitch = 452;
            ItemDef.spriteCameraRoll = 0;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = -1;
            ItemDef.primaryMaleModel = 3379;
            ItemDef.primaryFemaleModel = 3383;
            ItemDef.secondaryMaleModel = 164;
            ItemDef.secondaryFemaleModel = 344;
            ItemDef.primaryMaleHeadPiece = -1;
            ItemDef.primaryFemaleHeadPiece = -1;
            ItemDef.name = "Mith Platebody (W)";
            ItemDef.description = "It's a Mith Platebody (W)".getBytes();
        }
        if (i == 23508) { //Mith Helm (W)
            ItemDef.itemActions = new String[5];
            ItemDef.itemActions[1] = "Wear";
            ItemDef.modifiedModelColors = new int[2];
            ItemDef.originalModelColors = new int[2];
            ItemDef.modifiedModelColors[0] = 61;
            ItemDef.originalModelColors[0] = 43297;
            ItemDef.modifiedModelColors[1] = 926;
            ItemDef.originalModelColors[1] = 100;
            ItemDef.modelId = 2813;
            ItemDef.spriteScale = 800;
            ItemDef.spritePitch = 160;
            ItemDef.spriteCameraRoll = 152;
            ItemDef.spriteCameraYaw = 0;
            ItemDef.spriteTranslateX = -1;
            ItemDef.spriteTranslateY = 6;
            ItemDef.primaryMaleModel = 218;
            ItemDef.primaryFemaleModel = 394;
            ItemDef.primaryMaleHeadPiece = 56;
            ItemDef.primaryFemaleHeadPiece = 116;
            ItemDef.name = "Mith Helm (W)";
            ItemDef.description = "It's a Mith Helm (W)".getBytes();
        }
        if (!aBoolean182 && ItemDef.membersObject) {
            ItemDef.name = "Members Object";
            ItemDef.description = "Login to a members' server to use this object.".getBytes();
            ItemDef.groundActions = null;
            ItemDef.itemActions = null;
            ItemDef.team = 0;
        }

        return ItemDef;
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
        if (i == 26342) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 94200;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 94201;// wield
            class8.primaryFemaleModel = 94201;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Black Energy";
            class8.description = "A strong sword made of Black energy.".getBytes();
        }
        if (i == 26343) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 94202;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 94203;// wield
            class8.primaryFemaleModel = 94203;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Easter Energy sword";
            class8.description = "From the easter bunny. =)".getBytes();
        }
        if (i == 26344) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 94204;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 94205;// wield
            class8.primaryFemaleModel = 94205;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Green Energy sword";
            class8.description = "An Green Energy Sword".getBytes();
        }

        if (i == 26345) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 94206;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 94207;// wield
            class8.primaryFemaleModel = 94207;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Purple Energy sword";
            class8.description = "An Purple Energy Sword".getBytes();
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
        if (i == 25323) {
            class8.name = "Grim reaper hood";
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wear";
            class8.itemActions[4] = "Destroy";
            class8.modelId = 10179;
            class8.primaryMaleModel = 10186;
            class8.secondaryMaleModel = -1;
            class8.team = 0;
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
        if (i == 25311) {
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
        if (i == 25321) {
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
        if (i == 24120) {
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
        if (i == 26338) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 94300;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 94301;// wield
            class8.primaryFemaleModel = 94301;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Energy sword";
            class8.description = "A strong sword made of energy.".getBytes();
        }
        if (i == 26339) {
            class8.itemActions = new String[5];
            class8.itemActions[1] = "Wield";
            class8.modelId = 95221;
            class8.spriteScale = 1570;
            class8.spritePitch = 400;
            class8.spriteCameraRoll = 360;
            class8.spriteCameraYaw = 0;
            class8.spriteTranslateX = 0;
            class8.spriteTranslateY = -5;
            class8.primaryMaleModel = 95222;// wield
            class8.primaryFemaleModel = 95222;
            class8.secondaryMaleModel = -1;
            class8.secondaryFemaleModel = -1;
            class8.primaryMaleHeadPiece = -1;
            class8.primaryFemaleHeadPiece = -1;
            // class8.aBoolean176 = false;
            class8.name = "Red Energy sword";
            class8.description = "A strong sword made of red energy.".getBytes();
        }
//        if (i == 26340) {
//            class8.itemActions = new String[5];
//            class8.itemActions[1] = "Wield";
//            class8.modelId = 6221;
//            class8.spriteScale = 1570;
//            class8.spritePitch = 400;
//            class8.spriteCameraRoll = 360;
//            class8.spriteCameraYaw = 0;
//            class8.spriteTranslateX = 0;
//            class8.spriteTranslateY = -5;
//            class8.primaryMaleModel = 6222;// wield
//            class8.primaryFemaleModel = 6222;
//            class8.secondaryMaleModel = -1;
//            class8.secondaryFemaleModel = -1;
//            class8.primaryMaleHeadPiece = -1;
//            class8.primaryFemaleHeadPiece = -1;
//            // class8.aBoolean176 = false;
//            class8.name = "X-Mas Energy sword";
//            class8.description = "From Santa...".getBytes();
//        }
//        if (i == 26341) {
//            class8.itemActions = new String[5];
//            class8.itemActions[1] = "Wield";
//            class8.modelId = 7221;
//            class8.spriteScale = 1570;
//            class8.spritePitch = 400;
//            class8.spriteCameraRoll = 360;
//            class8.spriteCameraYaw = 0;
//            class8.spriteTranslateX = 0;
//            class8.spriteTranslateY = -5;
//            class8.primaryMaleModel = 7222;// wield
//            class8.primaryFemaleModel = 7222;
//            class8.secondaryMaleModel = -1;
//            class8.secondaryFemaleModel = -1;
//            class8.primaryMaleHeadPiece = -1;
//            class8.primaryFemaleHeadPiece = -1;
//            // class8.aBoolean176 = false;
//            class8.name = "valentines Energy sword";
//            class8.description = "From traxxas Have a Happy valentines Day =)".getBytes();
//        }
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
        if (i == 25324) {
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
        if (i == 25325) {
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
        if (i == 25326) {
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
        if (i == 25327) {
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
        if (i == 25328) {
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
        if (i == 25329) {
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
        if (i == 25330) {
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
        if (i == 25331) {
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
        if (i == 25332) {
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
        if (i == 25333) {
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
        if (i == 25334) {
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
        if (i == 25335) {
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
        if (i == 25336) {
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
        if (i == 25366) {
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
        if (i == 25367) {
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
        if (i == 25368) {
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
        if (i == 25369) {
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
        if (i == 25370) {
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
        if (i == 25370) {
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
        if (i == 25371) {
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
        if (i == 25372) {
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
        if (i == 25373) {
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
        if (i == 25374) {
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
        if (i == 25375) {
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
        if (i == 25376) {
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
        if (i == 25377) {
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
        if (i == 25378) {
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
        if (i == 25379) {
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
        if (i == 25380) {
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
        if (i == 25381) {
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
        if (i == 25382) {
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
        if (i == 25383) {
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
        if (i == 25384) {
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
        if (i == 25385) {
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
        if (i == 25386) {
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
        if (i == 25387) {
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
        if (i == 25388) {
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
        if (i == 25389) {
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
        if (i == 25390) {
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
        if (i == 25391) {
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
        if (i == 25392) {
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
        if (i == 25393) {
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
        if (i == 25394) {
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
        if (i == 25395) {
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
        if (i == 25396) {
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
        if (i == 25397) {
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
        if (i == 25398) {
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
        if (i == 25399) {
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
        if(i == 25500) {
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
        if(i == 25501) {
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
        if(i == 25502) {
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
        if(i == 25503) {
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
        if (i == 26346) {
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
        if (i == 26347) {
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
        if (i == 26348) {
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
        if (i == 26349) {
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
        if (i == 26350) {
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
        if (i == 26351) {
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
        if (i == 26352) {
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
        if (i == 25337) {
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
        if(i == 25563) {
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
        if(i == 25565) {
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
        if(i == 25567) {
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
        if(i == 25568) {
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
        if(i == 25571) {
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
        if (i == 25347) {
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
        if (i == 25348) {
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
        if(i == 25589) {
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
        if(i == 25591) {
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
        if(i == 25519) {
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
        if(i == 25520) {
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
        if(i == 25521) {
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
        if(i == 25557) {
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
        if(i == 25558) {
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
        if(i == 25559) {
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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
            class8.team = 0;
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

    public static Sprite getSprite(int i, int j, int k, int zoom) {
        if (k == 0 && zoom != -1) {
            Sprite sprite = (Sprite) aClass12_158.method222(i);
            if (sprite != null && sprite.maxHeight != j
                    && sprite.maxHeight != -1) {
                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition itemDef = method198(i);
        if (itemDef.stackIDs == null)
            j = -1;
        if (j > 1) {
            int i1 = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (j >= itemDef.stackAmounts[j1]
                        && itemDef.stackAmounts[j1] != 0)
                    i1 = itemDef.stackIDs[j1];

            if (i1 != -1)
                itemDef = method198(i1);
        }
        Model model = itemDef.method201(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.certTemplateID != -1) {
            sprite = method200(itemDef.certID, 10, -1);
            if (sprite == null)
                return null;
        }
        Sprite sprite2 = new Sprite(32, 32);
        int k1 = Rasterizer.centerX;
        int l1 = Rasterizer.centerY;
        int ai[] = Rasterizer.lineOffsets;
        int ai1[] = DrawingArea.pixels;
        float depthBuffer[] = DrawingArea.depthBuffer;
        int i2 = DrawingArea.width;
        int j2 = DrawingArea.height;
        int k2 = DrawingArea.leftX;
        int l2 = DrawingArea.bottomX;
        int i3 = DrawingArea.topY;
        int j3 = DrawingArea.bottomY;
        Rasterizer.aBoolean1464 = false;
        DrawingArea.initDrawingArea(32, 32, sprite2.myPixels, new float[32*32]);
        DrawingArea.drawPixels(32, 0, 0, 0, 32);
        Rasterizer.setDefaultBounds();
        int k3 = itemDef.spriteScale;
        if (zoom != -1)
            k3 = (itemDef.spriteScale * 100) / zoom;
        if (k == -1)
            k3 = (int) (k3 * 1.5D);
        if (k > 0)
            k3 = (int) (k3 * 1.04D);
        int l3 = Rasterizer.anIntArray1470[itemDef.spritePitch] * k3 >> 16;
        int i4 = Rasterizer.anIntArray1471[itemDef.spritePitch] * k3 >> 16;
        model.renderSingle(0, itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX, l3 + model.modelHeight / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);
        for (int i5 = 31; i5 >= 0; i5--) {
            for (int j4 = 31; j4 >= 0; j4--) {
                if (sprite2.myPixels[i5 + j4 * 32] != 0)
                    continue;
                if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1) {
                    sprite2.myPixels[i5 + j4 * 32] = 1;
                    continue;
                }
                if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1) {
                    sprite2.myPixels[i5 + j4 * 32] = 1;
                    continue;
                }
                if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1) {
                    sprite2.myPixels[i5 + j4 * 32] = 1;
                    continue;
                }
                if (j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1)
                    sprite2.myPixels[i5 + j4 * 32] = 1;
            }

        }

        if (k > 0) {
            for (int j5 = 31; j5 >= 0; j5--) {
                for (int k4 = 31; k4 >= 0; k4--) {
                    if (sprite2.myPixels[j5 + k4 * 32] != 0)
                        continue;
                    if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1) {
                        sprite2.myPixels[j5 + k4 * 32] = k;
                        continue;
                    }
                    if (k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1) {
                        sprite2.myPixels[j5 + k4 * 32] = k;
                        continue;
                    }
                    if (j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1) {
                        sprite2.myPixels[j5 + k4 * 32] = k;
                        continue;
                    }
                    if (k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1)
                        sprite2.myPixels[j5 + k4 * 32] = k;
                }

            }

        } else if (k == 0) {
            for (int k5 = 31; k5 >= 0; k5--) {
                for (int l4 = 31; l4 >= 0; l4--)
                    if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
                            && sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
                        sprite2.myPixels[k5 + l4 * 32] = 0x302020;

            }

        }
        if (itemDef.certTemplateID != -1) {
            int l5 = sprite.maxWidth;
            int j6 = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = l5;
            sprite.maxHeight = j6;
        }
        if (k == 0)
            aClass12_158.method223(sprite2, i,  (byte) 2);
        DrawingArea.initDrawingArea(j2, i2, ai1, depthBuffer);
        DrawingArea.setDrawingArea(j3, k2, l2, i3);
        Rasterizer.centerX = k1;
        Rasterizer.centerY = l1;
        Rasterizer.lineOffsets = ai;
        Rasterizer.aBoolean1464 = true;
        sprite2.maxWidth = itemDef.stackable ? 33 : 32;
        sprite2.maxHeight = j;
        return sprite2;
    }
    public static Sprite method200(int i, int j, int k) {
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
            class30_sub2_sub1_sub1_2 = method200(class8.certID, 10, -1);
            if (class30_sub2_sub1_sub1_2 == null)
                return null;
        }
        Sprite class30_sub2_sub1_sub1_1 = new Sprite(32, 32);
        int k1 = Rasterizer.centerX;
        int l1 = Rasterizer.centerY;
        int[] ai = Rasterizer.lineOffsets;
        int[] ai1 = DrawingArea.pixels;
        float depthBuffer[] = DrawingArea.depthBuffer;
        int i2 = DrawingArea.width;
        int j2 = DrawingArea.height;
        int k2 = DrawingArea.leftX;
        int l2 = DrawingArea.bottomX;
        int i3 = DrawingArea.topY;
        int j3 = DrawingArea.bottomY;
        Rasterizer.aBoolean1464 = false;
        DrawingArea.initDrawingArea(32, 32, class30_sub2_sub1_sub1_1.myPixels, new float[32*32]);
        DrawingArea.drawPixels(32, 0, 0, 0, 32);
        Rasterizer.setDefaultBounds();
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
        DrawingArea.initDrawingArea(j2, i2, ai1, depthBuffer);
        DrawingArea.setDrawingArea(j3, k2, l2, i3);
        Rasterizer.centerX = k1;
        Rasterizer.centerY = l1;
        Rasterizer.lineOffsets = ai;
        Rasterizer.aBoolean1464 = true;

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
        lendID = -1;
        lentItemID = -1;
        groundScaleX = 128;
        groundScaleY = 128;
        groundScaleZ = 128;
        ambience = 0;
        diffusion = 0;
        team = 0;
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
        description = ("Swap this note at any bank for the equivalent item.").getBytes();
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
        if (groundScaleX != 128 || groundScaleY != 128 || groundScaleZ != 128)
            model.scaleT(groundScaleX, groundScaleZ, anInt177, groundScaleY);
        if (modifiedModelColors != null) {
            for (int l = 0; l < modifiedModelColors.length; l++)
                model.method476(modifiedModelColors[l], originalModelColors[l]);

        }
        model.method479(64 + ambience, 768 + diffusion, -50, -10, -50, true);
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
            } else if (opcode == 10) {
                stream.readUnsignedShort();
            } else if (opcode == 11)
                stackable = true;
            else if (opcode == 12)
                value = stream.readDWord();
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
                groundScaleX = stream.readUnsignedShort();
            else if (opcode == 111)
                groundScaleY = stream.readUnsignedShort();
            else if (opcode == 112)
                groundScaleZ = stream.readUnsignedShort();
            else if (opcode == 113)
                ambience = stream.readSignedByte();
            else if (opcode == 114)
                diffusion = stream.readSignedByte() * 5;
            else if (opcode == 115)
                team = stream.readUnsignedByte();
            else if (opcode == 121)
                lendID = stream.readUnsignedShort();
            else if (opcode == 122)
                lentItemID = stream.readUnsignedShort();
        } while (true);
    }

}
