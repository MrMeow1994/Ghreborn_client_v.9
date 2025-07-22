// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OverLayFlo317.java

import java.nio.ByteBuffer;

public class OverLayFlo317
{

    public OverLayFlo317()
    {
        textureId = -1;
        int_9 = 512;
        int_16 = 127;
    }

    public static void load(FileArchive arg1)
    {
        ByteBuffer bb = ByteBuffer.wrap(arg1.method571("flo2.dat"));
        int count = bb.getShort();
        overLayFlo317s = new OverLayFlo317[count];
        for(int i = 0; i < count; i++)
        {
            if(overLayFlo317s[i] == null)
                overLayFlo317s[i] = new OverLayFlo317();
            overLayFlo317s[i].parse(bb);
        }

    }

    private void parse(ByteBuffer byteBuffer)
    {
        do
        {
            int attributeId = byteBuffer.get();
            if(attributeId == 0)
                break;
            if(attributeId == 1)
            {
                rgb = ((byteBuffer.get() & 0xff) << 16) + ((byteBuffer.get() & 0xff) << 8) + (byteBuffer.get() & 0xff);
                method262(rgb);
            } else
            if(attributeId == 2)
                textureId = byteBuffer.get() & 0xff;
            else
            if(attributeId == 3)
            {
                textureId = byteBuffer.getShort() & 0xffff;
                if(textureId == 65535)
                    textureId = -1;
            } else
            if(attributeId != 4)
                if(attributeId == 5)
                    boolean_5 = false;
                else
                if(attributeId != 6)
                    if(attributeId == 7)
                        int_7 = ((byteBuffer.get() & 0xff) << 16) + ((byteBuffer.get() & 0xff) << 8) + (byteBuffer.get() & 0xff);
                    else
                    if(attributeId != 8)
                        if(attributeId == 9)
                            int_9 = byteBuffer.getShort() & 0xffff;
                        else
                        if(attributeId == 10)
                            boolean_10 = false;
                        else
                        if(attributeId == 11)
                            int_11 = byteBuffer.get() & 0xff;
                        else
                        if(attributeId == 12)
                            boolean_12 = true;
                        else
                        if(attributeId == 13)
                            int_13 = ((byteBuffer.get() & 0xff) << 16) + ((byteBuffer.get() & 0xff) << 8) + (byteBuffer.get() & 0xff);
                        else
                        if(attributeId == 14)
                            int_14 = byteBuffer.get() & 0xff;
                        else
                        if(attributeId == 15)
                        {
                            int_15 = byteBuffer.getShort() & 0xffff;
                            if(int_15 == 65535)
                                int_15 = -1;
                        } else
                        if(attributeId == 16)
                            int_16 = byteBuffer.get() & 0xff;
                        else
                            System.err.println((new StringBuilder("[OverlayFloor] Missing AttributeId: ")).append(attributeId).toString());
        } while(true);
    }

    private void method262(int arg0)
    {
        double d = (double)(arg0 >> 16 & 0xff) / 256D;
        double d_5_ = (double)(arg0 >> 8 & 0xff) / 256D;
        double d_6_ = (double)(arg0 & 0xff) / 256D;
        double d_7_ = d;
        if(d_5_ < d_7_)
            d_7_ = d_5_;
        if(d_6_ < d_7_)
            d_7_ = d_6_;
        double d_8_ = d;
        if(d_5_ > d_8_)
            d_8_ = d_5_;
        if(d_6_ > d_8_)
            d_8_ = d_6_;
        double d_9_ = 0.0D;
        double d_10_ = 0.0D;
        double d_11_ = (d_7_ + d_8_) / 2D;
        if(d_7_ != d_8_)
        {
            if(d_11_ < 0.5D)
                d_10_ = (d_8_ - d_7_) / (d_8_ + d_7_);
            if(d_11_ >= 0.5D)
                d_10_ = (d_8_ - d_7_) / (2D - d_8_ - d_7_);
            if(d == d_8_)
                d_9_ = (d_5_ - d_6_) / (d_8_ - d_7_);
            else
            if(d_5_ == d_8_)
                d_9_ = 2D + (d_6_ - d) / (d_8_ - d_7_);
            else
            if(d_6_ == d_8_)
                d_9_ = 4D + (d - d_5_) / (d_8_ - d_7_);
        }
        d_9_ /= 6D;
        anInt394 = (int)(d_9_ * 256D);
        anInt395 = (int)(d_10_ * 256D);
        anInt396 = (int)(d_11_ * 256D);
        if(anInt395 < 0)
            anInt395 = 0;
        else
        if(anInt395 > 255)
            anInt395 = 255;
        if(anInt396 < 0)
            anInt396 = 0;
        else
        if(anInt396 > 255)
            anInt396 = 255;
        if(d_11_ > 0.5D)
            anInt398 = (int)((1.0D - d_11_) * d_10_ * 512D);
        else
            anInt398 = (int)(d_11_ * d_10_ * 512D);
        if(anInt398 < 1)
            anInt398 = 1;
        anInt397 = (int)(d_9_ * (double)anInt398);
        int i = (anInt394 + (int)(Math.random() * 16D)) - 8;
        if(i < 0)
            i = 0;
        else
        if(i > 255)
            i = 255;
        int i_12_ = (anInt395 + (int)(Math.random() * 48D)) - 24;
        if(i_12_ < 0)
            i_12_ = 0;
        else
        if(i_12_ > 255)
            i_12_ = 255;
        int i_13_ = (anInt396 + (int)(Math.random() * 48D)) - 24;
        if(i_13_ < 0)
            i_13_ = 0;
        else
        if(i_13_ > 255)
            i_13_ = 255;
        hsl16 = method263(i, i_12_, i_13_);
    }

    private final int method263(int arg0, int arg1, int arg2)
    {
        if(arg2 > 179)
            arg1 /= 2;
        if(arg2 > 192)
            arg1 /= 2;
        if(arg2 > 217)
            arg1 /= 2;
        if(arg2 > 243)
            arg1 /= 2;
        int i = (arg0 / 4 << 10) + (arg1 / 32 << 7) + arg2 / 2;
        return i;
    }

    public boolean aBoolean393;
    public static OverLayFlo317 overLayFlo317s[];
    public int textureId;
    public int rgb;
    public boolean boolean_5;
    public int int_7;
    public int int_9;
    public boolean boolean_10;
    public int int_11;
    public boolean boolean_12;
    public int int_13;
    public int int_14;
    public int int_15;
    public int int_16;
    public int anInt394;
    public int anInt395;
    public int anInt396;
    public int anInt397;
    public int anInt398;
    public int hsl16;
}
