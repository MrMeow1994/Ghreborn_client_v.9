import sign.signlink;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VarBit
{

    public static void load(int i, FileArchive fileArchive)
    {
        if(i != 0)
            anInt644 = 91;
        Stream stream = new Stream(fileArchive.method571("varbit.dat"), 891);
        anInt645 = stream.readUnsignedShort();
        if(cache == null)
            cache = new VarBit[anInt645];
        for(int j = 0; j < anInt645; j++)
        {
            if(cache[j] == null)
                cache[j] = new VarBit();
            cache[j].readValues(stream);
            //System.out.println(""+ cache[j].anInt648+" "+ cache[j].anInt649);
            if(cache[j].aBoolean651)
                VarpDefinition.aVarpDefinitionArray701[cache[j].anInt648].aBoolean713 = true;
        }

        if(stream.currentPosition != stream.buffer.length)
            System.out.println("varbit load mismatch");
        //dumpNpc();
    }
    public static void dumpNpc() {
        for(int i = 0; i < anInt645; ++i) {
            VarBit EntityDef = cache[i];
            BufferedWriter bw = null;

            try {
                bw = new BufferedWriter(new FileWriter(signlink.findcachedir() + "/dumps/525varbit.txt", true));

                    bw.newLine();
                    bw.write("if(i == " + i + ") {//varbit ID");
                    bw.newLine();
                    bw.write("cache[j].anInt648 = " + EntityDef.anInt648 + ";//Config Name");
                    bw.newLine();
                    bw.write("cache[j].anInt649 = " + EntityDef.anInt649 + ";//low");
                    bw.newLine();
                    bw.write("cache[j].anInt650 = " + EntityDef.anInt650 + ";//high");
                    bw.newLine();
                    bw.write("}");
                    bw.newLine();
                    bw.flush();
                    bw.close();
            } catch (IOException var4) {
                ;
            }
        }

    }
    public void method534(Stream stream)
    {
        int opcode = stream.readUnsignedByte();

        if (opcode == 0) {
            return;
        } else if (opcode == 1) {
            anInt648 = stream.readUnsignedShort();
            anInt649 = stream.readUnsignedByte();
            anInt650 = stream.readUnsignedByte();
        } else {
            System.out.println(opcode);
        }
    }
    private void readValues(Stream stream) {
        int opcode = stream.readUnsignedByte();

        if (opcode == 0) {
            return;
        } else if (opcode == 1) {
            anInt648 = stream.readUnsignedShort();
            anInt649 = stream.readUnsignedByte();
            anInt650 = stream.readUnsignedByte();
        } else {
            System.out.println(opcode);
        }
    }
    public VarBit()
    {
        aBoolean651 = false;
        anInt652 = -1;
    }

    private static int anInt644;
    public static int anInt645;
    public static VarBit cache[];
    public String aString647;
    public int anInt648;
    public int anInt649;
    public int anInt650;
    public boolean aBoolean651;
    public int anInt652;
    public int anInt653;
}
