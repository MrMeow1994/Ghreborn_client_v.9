public class Class38 {
    public static int anInt655;
    public static Class38[] aClass38Array656;
    public int bodyPartId = -1;
    public int[] bodyModelIds;
    public boolean notSelectable = false;
    public int[] headModelIds = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int anInt654 = 9;
    public int[] originalColors = new int[10];
    public int[] modifiedColors = new int[10];

    public static void load(FileArchive fileArchive) {
        Stream stream = new Stream(fileArchive.method571("idk.dat"), 891);
        anInt655 = stream.readUnsignedShort();
        if(aClass38Array656 == null) {
            aClass38Array656 = new Class38[anInt655];
        }

        for(int j = 0; j < anInt655; ++j) {
            if(aClass38Array656[j] == null) {
                aClass38Array656[j] = new Class38();
            }

            aClass38Array656[j].method536(true, stream);
            aClass38Array656[j].originalColors[0] = '\ud7c0';
            aClass38Array656[j].modifiedColors[0] = 6798;
        }

    }

    public void method536(boolean flag, Stream stream) {
        if(!flag) {
            throw new NullPointerException();
        } else {
            while(true) {
                while(true) {
                    int i = stream.readUnsignedByte();
                    if(i == 0) {
                        return;
                    }

                    if(i == 1) {
                        this.bodyPartId = stream.readUnsignedByte();
                    } else if(i == 2) {
                        int j = stream.readUnsignedByte();
                        this.bodyModelIds = new int[j];

                        for(int k = 0; k < j; ++k) {
                            this.bodyModelIds[k] = stream.readUnsignedShort();
                        }
                    } else if(i == 3) {
                        this.notSelectable = true;
                    } else if(i >= 40 && i < 50) {
                        this.originalColors[i - 40] = stream.readUnsignedShort();
                    } else if(i >= 50 && i < 60) {
                        this.modifiedColors[i - 50] = stream.readUnsignedShort();
                    } else if(i >= 60 && i < 70) {
                        this.headModelIds[i - 60] = stream.readUnsignedShort();
                    } else {
                        System.out.println("Error unrecognised config code: " + i);
                    }
                }
            }
        }
    }

    public boolean method537(byte byte0) {
        if(this.bodyModelIds == null) {
            return true;
        } else {
            boolean flag = true;
            int j;
            if(byte0 == 2) {
                boolean var4 = false;
            } else {
                for(j = 1; j > 0; ++j) {
                    ;
                }
            }

            for(j = 0; j < this.bodyModelIds.length; ++j) {
                if(!Model.method463(this.bodyModelIds[j])) {
                    flag = false;
                }
            }

            return flag;
        }
    }

    public Model method538(boolean flag) {
        if(flag) {
            throw new NullPointerException();
        } else if(this.bodyModelIds == null) {
            return null;
        } else {
            Model[] aclass30_sub2_sub4_sub6 = new Model[this.bodyModelIds.length];

            for(int model = 0; model < this.bodyModelIds.length; ++model) {
                aclass30_sub2_sub4_sub6[model] = Model.method462(this.anInt654, this.bodyModelIds[model]);
            }

            Model var5;
            if(aclass30_sub2_sub4_sub6.length == 1) {
                var5 = aclass30_sub2_sub4_sub6[0];
            } else {
                var5 = new Model(aclass30_sub2_sub4_sub6.length, aclass30_sub2_sub4_sub6, -38);
            }

            for(int j = 0; j < 9 && this.originalColors[j] != 0; ++j) {
                var5.method476(this.originalColors[j], this.modifiedColors[j]);
            }

            return var5;
        }
    }

    public boolean method539(boolean flag) {
        if(flag) {
            throw new NullPointerException();
        } else {
            boolean flag1 = true;

            for(int i = 0; i < 10; ++i) {
                if(this.headModelIds[i] != -1 && !Model.method463(this.headModelIds[i])) {
                    flag1 = false;
                }
            }

            return flag1;
        }
    }

    public Model method540(int i) {
        if(i != 0) {
            throw new NullPointerException();
        } else {
            Model[] aclass30_sub2_sub4_sub6 = new Model[this.headModelIds.length];
            int j = 0;

            for(int model = 0; model < this.headModelIds.length; ++model) {
                if(this.headModelIds[model] != -1) {
                    aclass30_sub2_sub4_sub6[j++] = Model.method462(this.anInt654, this.headModelIds[model]);
                }
            }

            Model var6 = new Model(j, aclass30_sub2_sub4_sub6, -38);

            for(int l = 0; l < 9 && this.originalColors[l] != 0; ++l) {
                var6.method476(this.originalColors[l], this.modifiedColors[l]);
            }

            return var6;
        }
    }
}
