public class VarpDefinition
{

    public static void load(FileArchive fileArchive)
    {
        Stream stream = new Stream(fileArchive.method571("varp.dat"), 891);
        anInt702 = 0;
        anInt700 = stream.readUnsignedShort();
        if(aVarpDefinitionArray701 == null)
            aVarpDefinitionArray701 = new VarpDefinition[anInt700];
        if(anIntArray703 == null)
            anIntArray703 = new int[anInt700];
        for(int j = 0; j < anInt700; j++)
        {
            if(aVarpDefinitionArray701[j] == null)
                aVarpDefinitionArray701[j] = new VarpDefinition();
            aVarpDefinitionArray701[j].method547(stream, false, j);
        }

        if(stream.currentPosition != stream.buffer.length)
            System.out.println("varptype load mismatch");
    }

    public void method547(Stream stream, boolean flag, int i)
    {
        if(flag)
            anInt699 = -91;
        do
        {
            int j = stream.readUnsignedByte();
            if(j == 0)
                return;
            if(j == 1)
                anInt705 = stream.readUnsignedByte();
            else
            if(j == 2)
                anInt706 = stream.readUnsignedByte();
            else
            if(j == 3)
            {
                aBoolean707 = true;
                anIntArray703[anInt702++] = i;
            } else
            if(j == 4)
                aBoolean708 = false;
            else
            if(j == 5)
                anInt709 = stream.readUnsignedShort();
            else
            if(j == 6)
                aBoolean710 = true;
            else
            if(j == 7)
                anInt711 = stream.readDWord();
            else
            if(j == 8)
            {
                anInt712 = 1;
                aBoolean713 = true;
            } else
            if(j == 10)
                aString704 = stream.readString();
            else
            if(j == 11)
                aBoolean713 = true;
            else
            if(j == 12)
                anInt714 = stream.readDWord();
            else
            if(j == 13)
                anInt712 = 2;
            else
                System.out.println("Error unrecognised config code: " + j);
        } while(true);
    }

    public VarpDefinition()
    {
        anInt699 = -32357;
        aBoolean707 = false;
        aBoolean708 = true;
        aBoolean710 = false;
        aBoolean713 = false;
        anInt714 = -1;
    }

    private static boolean aBoolean698 = true;
    private int anInt699;
    public static int anInt700;
    public static VarpDefinition aVarpDefinitionArray701[];
    public static int anInt702;
    public static int anIntArray703[];
    public String aString704;
    public int anInt705;
    public int anInt706;
    public boolean aBoolean707;
    public boolean aBoolean708;
    public int anInt709;
    public boolean aBoolean710;
    public int anInt711;
    public int anInt712;
    public boolean aBoolean713;
    public int anInt714;

}
