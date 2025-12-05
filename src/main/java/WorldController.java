public class WorldController
{
    public static final int MAX_FAR_Z = 150;
    public static final int MIN_FAR_Z = 30;
    public static int farZ = MIN_FAR_Z;
    public static int renderDistanceClamp = 500;
    public WorldController(int i, int j, int ai[][][], int k)
    {
        aBoolean429 = true;
        aBoolean434 = true;
        aBoolean435 = false;
        interactiveObjectCache = new InteractiveObject[5000];
        anIntArray486 = new int[10000];
        anIntArray487 = new int[10000];
        mapSizeZ = k;
        mapSizeX = j;
        mapSizeY = i;
        tileArray = new Tile[k][j][i];
            anIntArrayArrayArray445 = new int[k][j + 1][i + 1];
            vertexHeights = ai;
            method274(619);

    }

    public static void method273(int i)
    {
        interactiveObjects = null;
        cullingClusterPointer = null;
        cullingClusters = null;
        tileList = null;
        TILE_VISIBILITY_MAPS = null;
        TILE_VISIBILITY_MAP = null;
    }

    public static void drawFog(boolean dungeon) {
	    int fog = 0;
	    if (!dungeon) {
	        fog = 0xc8c0a8;
	    }
	    int pos = Rasterizer.anIntArray1471[0];
	    int src, dst, a;
	    int fogIntensity = 1;
	    int fogBegin = 2600;
	    int fogEnd = 2800;
	    for (int y = 0; y < DrawingArea.bottomY; y++) {
	        for (int x = 0; x < DrawingArea.viewportRX; x++) {
	            if (DrawingArea.pixels[pos] >= fogEnd) {
	                DrawingArea.pixels[pos] = fog;
	            } else if (DrawingArea.pixels[pos] >= fogBegin) {
	                a = (int)(DrawingArea.pixels[pos] - fogBegin) / fogIntensity;
	                src = ((fog & 0xff00ff) * a >> 8 & 0xff00ff) + ((fog & 0xff00) * a >> 8 & 0xff00);
	                a = 256 - a;
	                dst = DrawingArea.pixels[pos];
	                dst = ((dst & 0xff00ff) * a >> 8 & 0xff00ff) + ((dst & 0xff00) * a >> 8 & 0xff00);
	                DrawingArea.pixels[pos] = src + dst;
	            }
	            pos++;
	        }
	        pos += DrawingArea.width - DrawingArea.viewportRX;
	    }
	}
    public void method274(int i)
    {
        for(int j = 0; j < mapSizeZ; j++)
        {
            for(int k = 0; k < mapSizeX; k++)
            {
                for(int i1 = 0; i1 < mapSizeY; i1++)
                    tileArray[j][k][i1] = null;

            }

        }

        i = 37 / i;
        for(int l = 0; l < anInt472; l++)
        {
            for(int j1 = 0; j1 < cullingClusterPointer[l]; j1++)
                cullingClusters[l][j1] = null;

            cullingClusterPointer[l] = 0;
        }

        for(int k1 = 0; k1 < interactiveObjectCacheCurrentPos; k1++)
            interactiveObjectCache[k1] = null;

        interactiveObjectCacheCurrentPos = 0;
        for(int l1 = 0; l1 < interactiveObjects.length; l1++)
            interactiveObjects[l1] = null;

    }

    public void method275(int i, int j)
    {
        if(j != -34686)
            return;
        currentPositionZ = i;
        for(int k = 0; k < mapSizeX; k++)
        {
            for(int l = 0; l < mapSizeY; l++)
                if(tileArray[i][k][l] == null)
                    tileArray[i][k][l] = new Tile(i, k, l);

        }

    }

    public void method276(int i, int j, int k)
    {
        Tile tile = tileArray[0][j][i];
        for(int l = 0; l < 3; l++)
        {
            Tile tile_1 = tileArray[l][j][i] = tileArray[l + 1][j][i];
            if(tile_1 != null)
            {
                tile_1.anInt1307--;
                for(int j1 = 0; j1 < tile_1.anInt1317; j1++)
                {
                    InteractiveObject interactiveObject = tile_1.aInteractiveObjectArray1318[j1];
                    if((interactiveObject.anInt529 >> 29 & 3) == 2 && interactiveObject.anInt523 == j && interactiveObject.anInt525 == i)
                        interactiveObject.anInt517--;
                }

            }
        }

        while(k >= 0) 
        {
            for(int i1 = 1; i1 > 0; i1++);
        }
        if(tileArray[0][j][i] == null)
            tileArray[0][j][i] = new Tile(0, j, i);
        tileArray[0][j][i].aTile_1329 = tile;
        tileArray[3][j][i] = null;
    }

    public static void createCullingCluster(int z, int lowestX, int lowestZ, int highestX, int highestY, int highestZ, int k1, int lowestY,
                                            int searchMask) {
        CullingCluster cullingCluster = new CullingCluster();
        cullingCluster.tileStartX = lowestX / 128;
        cullingCluster.tileEndX = highestX / 128;
        cullingCluster.tileStartY = lowestY / 128;
        cullingCluster.tileEndY = highestY / 128;
        cullingCluster.searchMask = searchMask;
        cullingCluster.worldStartX = lowestX;
        cullingCluster.worldEndX = highestX;
        cullingCluster.worldStartY = lowestY;
        cullingCluster.worldEndY = highestY;
        cullingCluster.worldEndZ = highestZ;
        cullingCluster.worldStartZ = lowestZ;
        cullingClusters[z][cullingClusterPointer[z]++] = cullingCluster;
    }

    public void method278(int i, int j, int k, int l)
    {
        Tile tile = tileArray[i][j][k];
        if(tile == null)
        {
            return;
        } else
        {
            tileArray[i][j][k].anInt1321 = l;
            return;
        }
    }

    public void method279(int i, int j, int k, int l, int i1, int overlaytex, int underlaytex,int k1,
            int l1, int i2, int j2, int k2, int l2, int i3, int j3, 
            int k3, int l3, int i4, int j4, int k4, int l4, boolean tex)
    {
        if(l == 0)
        {
            PlainTile plainTile = new PlainTile(k2, l2, i3, j3, underlaytex, k4, false, tex);
            for(int i5 = i; i5 >= 0; i5--)
                if(tileArray[i5][j][k] == null)
                    tileArray[i5][j][k] = new Tile(i5, j, k);

            tileArray[i][j][k].plainTile = plainTile;
            return;
        }
        if(l == 1)
        {
            PlainTile plainTile_1 = new PlainTile(k3, l3, i4, j4, overlaytex, l4, k1 == l1 && k1 == i2 && k1 == j2, tex);
            for(int j5 = i; j5 >= 0; j5--)
                if(tileArray[j5][j][k] == null)
                    tileArray[j5][j][k] = new Tile(j5, j, k);

            tileArray[i][j][k].plainTile = plainTile_1;
            return;
        }
        ShapedTile shapedTile = new ShapedTile(k, k3, j3, i2, overlaytex, underlaytex,i4, i1, k2, k4, i3, j2, l1, k1, l, j4, l3, l2, 3, j, l4, tex);
        for(int k5 = i; k5 >= 0; k5--)
            if(tileArray[k5][j][k] == null)
                tileArray[k5][j][k] = new Tile(k5, j, k);

        tileArray[i][j][k].aShapedTile_1312 = shapedTile;
    }

    public void method280(int i, int j, int k, int l, Animable animable, byte byte0, long i1,
                          int j1)
    {
        if(animable == null)
            return;
        Class49 class49 = new Class49();
        class49.renderable = animable;
        class49.anInt812 = j1 * 128 + 64;
        class49.anInt813 = k * 128 + 64;
        if(l <= 0)
            aBoolean435 = !aBoolean435;
        class49.anInt811 = j;
        class49.anInt815 = i1;
        class49.aByte816 = byte0;
        if(tileArray[i][j1][k] == null)
            tileArray[i][j1][k] = new Tile(i, j1, k);
        tileArray[i][j1][k].groundDecoration = class49;
    }

    public void method281(byte byte0, int i, int j, Animable animable, int k, Animable animable_1, Animable class30_sub2_sub4_2,
                          int l, int i1)
    {
        Class3 class3 = new Class3();
        class3.aAnimable_48 = class30_sub2_sub4_2;
        class3.anInt46 = i * 128 + 64;
        class3.anInt47 = i1 * 128 + 64;
        if(byte0 != 7)
            return;
        class3.anInt45 = k;
        class3.anInt51 = j;
        class3.aAnimable_49 = animable;
        class3.aAnimable_50 = animable_1;
        int j1 = 0;
        Tile tile = tileArray[l][i][i1];
        if(tile != null)
        {
            for(int k1 = 0; k1 < tile.anInt1317; k1++)
                if(tile.aInteractiveObjectArray1318[k1].aAnimable_521 instanceof Model)
                {
                    int l1 = ((Model) tile.aInteractiveObjectArray1318[k1].aAnimable_521).anInt1654;
                    if(l1 > j1)
                        j1 = l1;
                }

        }
        class3.anInt52 = j1;
        if(tileArray[l][i][i1] == null)
            tileArray[l][i][i1] = new Tile(l, i, i1);
        tileArray[l][i][i1].aClass3_1316 = class3;
    }

    public void method282(int i, Animable animable, boolean flag, long j, int k, byte byte0, int l,
                          Animable animable_1, int i1, int j1, int k1)
    {
        if(!flag)
            aBoolean434 = !aBoolean434;
        if(animable == null && animable_1 == null)
            return;
        Class10 class10 = new Class10();
        class10.anInt280 = j;
        class10.aByte281 = byte0;
        class10.anInt274 = l * 128 + 64;
        class10.anInt275 = k * 128 + 64;
        class10.anInt273 = i1;
        class10.aAnimable_278 = animable;
        class10.aAnimable_279 = animable_1;
        class10.anInt276 = i;
        class10.anInt277 = j1;
        for(int l1 = k1; l1 >= 0; l1--)
            if(tileArray[l1][l][k] == null)
                tileArray[l1][l][k] = new Tile(l1, l, k);

        tileArray[k1][l][k].aClass10_1313 = class10;
    }

    public void method283(long i, int j, int k, int l, int i1, int j1, int k1,
                          Animable animable, int l1, byte byte0, int i2, int j2)
    {
        if(animable == null)
            return;
        Class26 class26 = new Class26();
        class26.anInt505 = i;
        while(l >= 0) 
            aBoolean435 = !aBoolean435;
        class26.aByte506 = byte0;
        class26.anInt500 = l1 * 128 + 64 + j1;
        class26.anInt501 = j * 128 + 64 + i2;
        class26.anInt499 = k1;
        class26.aAnimable_504 = animable;
        class26.anInt502 = j2;
        class26.anInt503 = k;
        for(int k2 = i1; k2 >= 0; k2--)
            if(tileArray[k2][l1][j] == null)
                tileArray[k2][l1][j] = new Tile(k2, l1, j);

        tileArray[i1][l1][j].aClass26_1314 = class26;
    }

    public boolean method284(long i, byte byte0, int j, int k, Animable animable, int l, int i1,
                             int j1, byte byte1, int k1, int l1)
    {
        if(byte1 != 110)
            anInt431 = 250;
        if(animable == null)
        {
            return true;
        } else
        {
            int i2 = l1 * 128 + 64 * l;
            int j2 = k1 * 128 + 64 * k;
            return method287(i1, l1, k1, l, k, i2, j2, j, animable, j1, false, i, byte0);
        }
    }

    public boolean method285(int i, int j, byte byte0, int k, long l, int i1, int j1,
                             int k1, Animable animable, boolean flag)
    {
        if(animable == null)
            return true;
        int l1 = k1 - j1;
        int i2 = i1 - j1;
        int j2 = k1 + j1;
        int k2 = i1 + j1;
        if(flag)
        {
            if(j > 640 && j < 1408)
                k2 += 128;
            if(j > 1152 && j < 1920)
                j2 += 128;
            if(j > 1664 || j < 384)
                i2 -= 128;
            if(j > 128 && j < 896)
                l1 -= 128;
        }
        l1 /= 128;
        if(byte0 == 6)
            byte0 = 0;
        else
            throw new NullPointerException();
        i2 /= 128;
        j2 /= 128;
        k2 /= 128;
        return method287(i, l1, i2, (j2 - l1) + 1, (k2 - i2) + 1, k1, i1, k, animable, j, true, l, (byte)0);
    }

    public boolean method286(int i, int j, int k, Animable animable, int l, int i1, int j1,
                             int k1, int l1, int i2, long j2, int k2, byte byte0)
    {
        if(byte0 != 35)
        {
            for(int l2 = 1; l2 > 0; l2++);
        }
        if(animable == null)
            return true;
        else
            return method287(j, l1, k2, (i2 - l1) + 1, (i1 - k2) + 1, j1, k, k1, animable, l, true, j2, (byte)0);
    }

    private boolean method287(int i, int j, int k, int l, int i1, int j1, int k1,
                              int l1, Animable animable, int i2, boolean flag, long j2, byte byte0)
    {
        for(int k2 = j; k2 < j + l; k2++)
        {
            for(int l2 = k; l2 < k + i1; l2++)
            {
                if(k2 < 0 || l2 < 0 || k2 >= mapSizeX || l2 >= mapSizeY)
                    return false;
                Tile tile = tileArray[i][k2][l2];
                if(tile != null && tile.anInt1317 >= 5)
                    return false;
            }

        }

        InteractiveObject interactiveObject = new InteractiveObject();
        interactiveObject.anInt529 = j2;
        interactiveObject.aByte530 = byte0;
        interactiveObject.anInt517 = i;
        interactiveObject.anInt519 = j1;
        interactiveObject.anInt520 = k1;
        interactiveObject.anInt518 = l1;
        interactiveObject.aAnimable_521 = animable;
        interactiveObject.anInt522 = i2;
        interactiveObject.anInt523 = j;
        interactiveObject.anInt525 = k;
        interactiveObject.anInt524 = (j + l) - 1;
        interactiveObject.anInt526 = (k + i1) - 1;
        for(int i3 = j; i3 < j + l; i3++)
        {
            for(int j3 = k; j3 < k + i1; j3++)
            {
                int k3 = 0;
                if(i3 > j)
                    k3++;
                if(i3 < (j + l) - 1)
                    k3 += 4;
                if(j3 > k)
                    k3 += 8;
                if(j3 < (k + i1) - 1)
                    k3 += 2;
                for(int l3 = i; l3 >= 0; l3--)
                    if(tileArray[l3][i3][j3] == null)
                        tileArray[l3][i3][j3] = new Tile(l3, i3, j3);

                Tile tile_1 = tileArray[i][i3][j3];
                tile_1.aInteractiveObjectArray1318[tile_1.anInt1317] = interactiveObject;
                tile_1.anIntArray1319[tile_1.anInt1317] = k3;
                tile_1.anInt1320 |= k3;
                tile_1.anInt1317++;
            }

        }

        if(flag)
            interactiveObjectCache[interactiveObjectCacheCurrentPos++] = interactiveObject;
        return true;
    }

    public void method288(byte byte0)
    {
        if(byte0 != 104)
            aBoolean435 = !aBoolean435;
        for(int i = 0; i < interactiveObjectCacheCurrentPos; i++)
        {
            InteractiveObject interactiveObject = interactiveObjectCache[i];
            method289(-997, interactiveObject);
            interactiveObjectCache[i] = null;
        }

        interactiveObjectCacheCurrentPos = 0;
    }

    private void method289(int i, InteractiveObject interactiveObject)
    {
        if(i >= 0)
            return;
        for(int j = interactiveObject.anInt523; j <= interactiveObject.anInt524; j++)
        {
            for(int k = interactiveObject.anInt525; k <= interactiveObject.anInt526; k++)
            {
                Tile tile = tileArray[interactiveObject.anInt517][j][k];
                if(tile != null)
                {
                    for(int l = 0; l < tile.anInt1317; l++)
                    {
                        if(tile.aInteractiveObjectArray1318[l] != interactiveObject)
                            continue;
                        tile.anInt1317--;
                        for(int i1 = l; i1 < tile.anInt1317; i1++)
                        {
                            tile.aInteractiveObjectArray1318[i1] = tile.aInteractiveObjectArray1318[i1 + 1];
                            tile.anIntArray1319[i1] = tile.anIntArray1319[i1 + 1];
                        }

                        tile.aInteractiveObjectArray1318[tile.anInt1317] = null;
                        break;
                    }

                    tile.anInt1320 = 0;
                    for(int j1 = 0; j1 < tile.anInt1317; j1++)
                        tile.anInt1320 |= tile.anIntArray1319[j1];

                }
            }

        }

    }

    public void method290(int i, int j, int k, int l, int i1)
    {
        Tile tile = tileArray[i1][l][i];
        if(j <= 0)
            aBoolean429 = !aBoolean429;
        if(tile == null)
            return;
        Class26 class26 = tile.aClass26_1314;
        if(class26 == null)
        {
            return;
        } else
        {
            int j1 = l * 128 + 64;
            int k1 = i * 128 + 64;
            class26.anInt500 = j1 + ((class26.anInt500 - j1) * k) / 16;
            class26.anInt501 = k1 + ((class26.anInt501 - k1) * k) / 16;
            return;
        }
    }

    public void method291(int i, int j, int k, byte byte0)
    {
        Tile tile = tileArray[j][i][k];
        if(byte0 != -119)
            aBoolean434 = !aBoolean434;
        if(tile == null)
        {
            return;
        } else
        {
            tile.aClass10_1313 = null;
            return;
        }
    }

    public void method292(int i, int j, int k, int l)
    {
        Tile tile = tileArray[k][l][j];
        if(tile == null)
        {
            return;
        } else
        {
            tile.aClass26_1314 = null;
            if(i == 0);
            return;
        }
    }

    public void method293(int i, int j, int k, int l)
    {
        if(j >= 0)
        {
            for(int i1 = 1; i1 > 0; i1++);
        }
        Tile tile = tileArray[i][k][l];
        if(tile == null)
            return;
        for(int j1 = 0; j1 < tile.anInt1317; j1++)
        {
            InteractiveObject interactiveObject = tile.aInteractiveObjectArray1318[j1];
            if((interactiveObject.anInt529 >> 29 & 3) == 2 && interactiveObject.anInt523 == k && interactiveObject.anInt525 == l)
            {
                method289(-997, interactiveObject);
                return;
            }
        }

    }

    public void method294(byte byte0, int i, int j, int k)
    {
        Tile tile = tileArray[i][k][j];
        if(tile == null)
            return;
        tile.groundDecoration = null;
        if(byte0 == 9)
            byte0 = 0;
    }

    public void method295(int i, int j, int k)
    {
        Tile tile = tileArray[i][j][k];
        if(tile == null)
        {
            return;
        } else
        {
            tile.aClass3_1316 = null;
            return;
        }
    }

    public Class10 method296(int i, int j, int k, boolean flag)
    {
        if(flag)
            anInt433 = -195;
        Tile tile = tileArray[i][j][k];
        if(tile == null)
            return null;
        else
            return tile.aClass10_1313;
    }

    public Class26 method297(int i, int j, int k, int l)
    {
        if(j <= 0)
            throw new NullPointerException();
        Tile tile = tileArray[l][i][k];
        if(tile == null)
            return null;
        else
            return tile.aClass26_1314;
    }

    public InteractiveObject method298(int i, int j, byte byte0, int k)
    {
        Tile tile = tileArray[k][i][j];
        if(tile == null)
            return null;
        for(int l = 0; l < tile.anInt1317; l++)
        {
            InteractiveObject interactiveObject = tile.aInteractiveObjectArray1318[l];
            if((interactiveObject.anInt529 >> 29 & 3) == 2 && interactiveObject.anInt523 == i && interactiveObject.anInt525 == j)
                return interactiveObject;
        }

        if(byte0 == 4)
            byte0 = 0;
        else
            anInt432 = -376;
        return null;
    }

    public Class49 method299(int i, int j, int k, int l)
    {
        Tile tile = tileArray[k][j][i];
        if(l != 0)
        {
            for(int i1 = 1; i1 > 0; i1++);
        }
        if(tile == null || tile.groundDecoration == null)
            return null;
        else
            return tile.groundDecoration;
    }

    public long method300(int i, int j, int k)
    {
        Tile tile = tileArray[i][j][k];
        if(tile == null || tile.aClass10_1313 == null)
            return 0;
        else
            return tile.aClass10_1313.anInt280;
    }

    public long method301(int i, int j, int k, int l)
    {
        Tile tile = tileArray[i][j][l];
        if(k != 0)
            return anInt430;
        if(tile == null || tile.aClass26_1314 == null)
            return 0;
        else
            return tile.aClass26_1314.anInt505;
    }

    public long method302(int i, int j, int k)
    {
        Tile tile = tileArray[i][j][k];
        if(tile == null)
            return 0;
        for(int l = 0; l < tile.anInt1317; l++)
        {
            InteractiveObject interactiveObject = tile.aInteractiveObjectArray1318[l];
            if((interactiveObject.anInt529 >> 29 & 3) == 2 && interactiveObject.anInt523 == j && interactiveObject.anInt525 == k)
                return interactiveObject.anInt529;
        }

        return 0;
    }

    public long method303(int i, int j, int k)
    {
        Tile tile = tileArray[i][j][k];
        if(tile == null || tile.groundDecoration == null)
            return 0;
        else
            return tile.groundDecoration.anInt815;
    }

    public int method304(int i, int j, int k, long l)
    {
        Tile tile = tileArray[i][j][k];
        if(tile == null)
            return -1;
        if(tile.aClass10_1313 != null && tile.aClass10_1313.anInt280 == l)
            return tile.aClass10_1313.aByte281 & 0xff;
        if(tile.aClass26_1314 != null && tile.aClass26_1314.anInt505 == l)
            return tile.aClass26_1314.aByte506 & 0xff;
        if(tile.groundDecoration != null && tile.groundDecoration.anInt815 == l)
            return tile.groundDecoration.aByte816 & 0xff;
        for(int i1 = 0; i1 < tile.anInt1317; i1++)
            if(tile.aInteractiveObjectArray1318[i1].anInt529 == l)
                return tile.aInteractiveObjectArray1318[i1].aByte530 & 0xff;

        return -1;
    }

   public void method305(int i, int k, int i1)
    {
		int j = 100;
		int l = 5500;
		int j1 = (int)Math.sqrt(k * k + i * i + i1 * i1);
		int k1 = l >> 4;
        for(int l1 = 0; l1 < mapSizeZ; l1++)
        {
            for(int i2 = 0; i2 < mapSizeX; i2++)
            {
                for(int j2 = 0; j2 < mapSizeY; j2++)
                {
                    Tile tile = tileArray[l1][i2][j2];
                    if(tile != null)
                    {
                        Class10 class10 = tile.aClass10_1313;
                        if(class10 != null && class10.aAnimable_278 != null && class10.aAnimable_278.vertexNormals != null)
                        {
                            method307(l1, 1, 1, i2, j2, (Model)class10.aAnimable_278);
                            if(class10.aAnimable_279 != null && class10.aAnimable_279.vertexNormals != null)
                            {
                                method307(l1, 1, 1, i2, j2, (Model)class10.aAnimable_279);
                                mergeNormals((Model)class10.aAnimable_278, (Model)class10.aAnimable_279, 0, 0, 0, false);
                                ((Model)class10.aAnimable_279).method480(j, k1, k, i, i1);
                            }
                            ((Model)class10.aAnimable_278).method480(j, k1, k, i, i1);
                        }
                        for(int k2 = 0; k2 < tile.anInt1317; k2++)
                        {
                            InteractiveObject interactiveObject = tile.aInteractiveObjectArray1318[k2];
                            if(interactiveObject != null && interactiveObject.aAnimable_521 != null && interactiveObject.aAnimable_521.vertexNormals != null)
                            {
                                method307(l1, (interactiveObject.anInt524 - interactiveObject.anInt523) + 1, (interactiveObject.anInt526 - interactiveObject.anInt525) + 1, i2, j2, (Model) interactiveObject.aAnimable_521);
                                ((Model) interactiveObject.aAnimable_521).method480(j, k1, k, i, i1);
                            }
                        }

                        Class49 class49 = tile.groundDecoration;
                        if(class49 != null && class49.renderable.vertexNormals != null)
                        {
                            method306(i2, l1, (Model)class49.renderable, j2);
                            ((Model)class49.renderable).method480(j, k1, k, i, i1);
                        }
                    }
                }

            }

        }

    }


    private void method306(int x, int z, Model model, int y)
    {
        if(x < mapSizeX) {
            Tile tile = tileArray[z][x + 1][y];
            if(tile != null && tile.groundDecoration != null && tile.groundDecoration.renderable.vertexNormals != null)
                mergeNormals(model, (Model) tile.groundDecoration.renderable, 128, 0, 0, true);
        }
        if(y < mapSizeX) {
            Tile tile_1 = tileArray[z][x][y + 1];
            if(tile_1 != null && tile_1.groundDecoration != null && tile_1.groundDecoration.renderable.vertexNormals != null)
                mergeNormals(model, (Model) tile_1.groundDecoration.renderable, 0, 0, 128, true);
        }
        if(x < mapSizeX && y < mapSizeY) {
            Tile tile_2 = tileArray[z][x + 1][y + 1];
            if(tile_2 != null && tile_2.groundDecoration != null && tile_2.groundDecoration.renderable.vertexNormals != null)
                mergeNormals(model, (Model) tile_2.groundDecoration.renderable, 128, 0, 128, true);
        }
        if(x < mapSizeX && y > 0)
        {
            Tile tile = tileArray[z][x + 1][y - 1];
            if(tile != null && tile.groundDecoration != null && tile.groundDecoration.renderable.vertexNormals != null)
                mergeNormals(model, (Model) tile.groundDecoration.renderable, 128, 0, -128, true);
        }
    }

    private void method307(int i, int j, int k, int l, int i1, Model model)
    {
        boolean flag = true;
        int j1 = l;
        int k1 = l + j;
        int l1 = i1 - 1;
        int i2 = i1 + k;
        for(int j2 = i; j2 <= i + 1; j2++)
            if(j2 != mapSizeZ)
            {
                for(int k2 = j1; k2 <= k1; k2++)
                    if(k2 >= 0 && k2 < mapSizeX)
                    {
                        for(int l2 = l1; l2 <= i2; l2++)
                            if(l2 >= 0 && l2 < mapSizeY && (!flag || k2 >= k1 || l2 >= i2 || l2 < i1 && k2 != l))
                            {
                                Tile tile = tileArray[j2][k2][l2];
                                if(tile != null)
                                {
                                    int i3 = (vertexHeights[j2][k2][l2] + vertexHeights[j2][k2 + 1][l2] + vertexHeights[j2][k2][l2 + 1] + vertexHeights[j2][k2 + 1][l2 + 1]) / 4 - (vertexHeights[i][l][i1] + vertexHeights[i][l + 1][i1] + vertexHeights[i][l][i1 + 1] + vertexHeights[i][l + 1][i1 + 1]) / 4;
                                    Class10 class10 = tile.aClass10_1313;
                                    if(class10 != null && class10.aAnimable_278 != null && class10.aAnimable_278.vertexNormals != null)
                                        mergeNormals(model, (Model)class10.aAnimable_278, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
                                    if(class10 != null && class10.aAnimable_279 != null && class10.aAnimable_279.vertexNormals != null)
                                        mergeNormals(model, (Model)class10.aAnimable_279, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
                                    for(int j3 = 0; j3 < tile.anInt1317; j3++)
                                    {
                                        InteractiveObject interactiveObject = tile.aInteractiveObjectArray1318[j3];
                                        if(interactiveObject != null && interactiveObject.aAnimable_521 != null && interactiveObject.aAnimable_521.vertexNormals != null)
                                        {
                                            int k3 = (interactiveObject.anInt524 - interactiveObject.anInt523) + 1;
                                            int l3 = (interactiveObject.anInt526 - interactiveObject.anInt525) + 1;
                                            mergeNormals(model, (Model) interactiveObject.aAnimable_521, (interactiveObject.anInt523 - l) * 128 + (k3 - j) * 64, i3, (interactiveObject.anInt525 - i1) * 128 + (l3 - k) * 64, flag);
                                        }
                                    }

                                }
                            }

                    }

                j1--;
                flag = false;
            }

    }

    private void mergeNormals(Model model, Model model_1, int posX, int posY, int posZ, boolean flag)
    {
        anInt488++;
        int count = 0;
        int[] vertices = model_1.verticesX;
        int vertexCount = model_1.vertexCount;
        for(int vertex = 0; vertex < model.vertexCount; vertex++)
        {
            VertexNormal vertexNormal = model.vertexNormals[vertex];
            VertexNormal offsetVertexNormal  = model.vertexNormalOffset[vertex];
            if(offsetVertexNormal .magnitude != 0)
            {
                int y = model.verticesY[vertex] - posY;
                if(y <= model_1.maxY)
                {
                    int x = model.verticesX[vertex] - posX;
                    if(x >= model_1.minX && x <= model_1.maxX)
                    {
                        int z = model.verticesZ[vertex] - posZ;
                        if(z >= model_1.minZ && z <= model_1.maxZ)
                        {
                            for(int v = 0; v < vertexCount; v++)
                            {
                                VertexNormal vertexNormal2 = model_1.vertexNormals[v];
                                VertexNormal offsetVertexNormal2 = model_1.vertexNormalOffset[v];
                                if(x == vertices[v] && z == model_1.verticesZ[v] && y == model_1.verticesY[v] && offsetVertexNormal2.magnitude != 0)
                                {
                                    vertexNormal.x += offsetVertexNormal2.x;
                                    vertexNormal.y += offsetVertexNormal2.y;
                                    vertexNormal.z += offsetVertexNormal2.z;
                                    vertexNormal.magnitude += offsetVertexNormal2.magnitude;
                                    vertexNormal2.x += offsetVertexNormal .x;
                                    vertexNormal2.y += offsetVertexNormal .y;
                                    vertexNormal2.z += offsetVertexNormal .z;
                                    vertexNormal2.magnitude += offsetVertexNormal .magnitude;
                                    count++;
                                    anIntArray486[vertex] = anInt488;
                                    anIntArray487[v] = anInt488;
                                }
                            }

                        }
                    }
                }
            }
        }

        if(count < 3 || !flag) {
            return;
        }
        for(int triangle = 0; triangle < model.triangleCount; triangle++) {
            if (anIntArray486[model.face_a[triangle]] == anInt488
                    && anIntArray486[model.face_b[triangle]] == anInt488
                    && anIntArray486[model.face_c[triangle]] == anInt488) {
                model.face_render_type[triangle] = -1;
            }
        }
        for(int triangle = 0; triangle < model_1.triangleCount; triangle++) {
            if (anIntArray487[model_1.face_a[triangle]] == anInt488
                    && anIntArray487[model_1.face_b[triangle]] == anInt488
                    && anIntArray487[model_1.face_c[triangle]] == anInt488) {
                model_1.face_render_type[triangle] = -1;
            }
        }
    }

    public void drawMinimapTile(int[] pixels, int pixelPointer, int scanLength, int z, int x, int y)
    {
        Tile tile = tileArray[z][x][y];
        if(tile == null)
            return;
        PlainTile plainTile = tile.plainTile;
        if(plainTile != null)
        {
            int colourRGB = plainTile.colourRGB;
            if(colourRGB == 0) {
                return;
            }
            for(int k1 = 0; k1 < 4; k1++)
            {
                pixels[pixelPointer] = colourRGB;
                pixels[pixelPointer + 1] = colourRGB;
                pixels[pixelPointer + 2] = colourRGB;
                pixels[pixelPointer + 3] = colourRGB;
                pixelPointer += scanLength;
            }
            return;
        }
        ShapedTile shapedTile = tile.aShapedTile_1312;
        if(shapedTile == null)
            return;
        int shape = shapedTile.shape;
        int rotation = shapedTile.rotation;
        int underlayRGB = shapedTile.underlayRGB;
        int overlayRGB = shapedTile.overlayRGB;
        int[] shapePoints = tileShapePoints[shape];
        int[] shapeIndices = tileShapeIndices[rotation];
        int shapePointer = 0;
        if(underlayRGB != 0) {
            for(int i3 = 0; i3 < 4; i3++) {
                pixels[pixelPointer] = shapePoints[shapeIndices[shapePointer++]] != 0 ? overlayRGB : underlayRGB;
                pixels[pixelPointer + 1] = shapePoints[shapeIndices[shapePointer++]] != 0 ? overlayRGB : underlayRGB;
                pixels[pixelPointer + 2] = shapePoints[shapeIndices[shapePointer++]] != 0 ? overlayRGB : underlayRGB;
                pixels[pixelPointer + 3] = shapePoints[shapeIndices[shapePointer++]] != 0 ? overlayRGB : underlayRGB;
                pixelPointer += scanLength;
            }
            return;
        }
        for(int j3 = 0; j3 < 4; j3++) {
            if(shapePoints[shapeIndices[shapePointer++]] != 0)
                pixels[pixelPointer] = overlayRGB;
            if(shapePoints[shapeIndices[shapePointer++]] != 0)
                pixels[pixelPointer + 1] = overlayRGB;
            if(shapePoints[shapeIndices[shapePointer++]] != 0)
                pixels[pixelPointer + 2] = overlayRGB;
            if(shapePoints[shapeIndices[shapePointer++]] != 0)
                pixels[pixelPointer + 3] = overlayRGB;
            pixelPointer += scanLength;
        }
    }

    public static void setupViewport(int i, int j, int k, int l, int ai[])
    {
        left = 0;
        top = 0;
        right = k;
        bottom = l;
        midX = k / 2;
        midY = l / 2;
        boolean[][][][] tileOnScreen = new boolean[9][32][(MAX_FAR_Z * 2) + 3][(MAX_FAR_Z * 2) + 3];
        for(int angleY = 128; angleY <= 384; angleY += 32)
        {
            for(int angleX = 0; angleX < 2048; angleX += 64)
            {
                curveSineY = Model.SINE[angleY];
                curveCosineY = Model.COSINE[angleY];
                curveSineX = Model.SINE[angleX];
                curveCosineX = Model.COSINE[angleX];
                int anglePointerY = (angleY - 128) / 32;
                int anglePointerX = angleX / 64;
                for(int x = -26; x <= 26; x++) {
                    for(int y = -26; y <= 26; y++) {
                        int worldX = x * 128;
                        int worldY = y * 128;
                        boolean visible = false;
                        for(int worldZ = -i; worldZ <= j; worldZ += 128)
                        {
                            if(!onScreen(ai[anglePointerY] + worldZ, worldY, worldX)) {
                                continue;
                            }
                            visible = true;
                            break;
                        }

                        tileOnScreen[anglePointerY][anglePointerX][x + MAX_FAR_Z + 1][y + MAX_FAR_Z + 1] = visible;
                    }

                }

            }

        }

        for(int anglePointerY = 0; anglePointerY < 8; anglePointerY++) {
            for(int anglePointerX = 0; anglePointerX < 32; anglePointerX++) {
                for(int relativeX = -farZ; relativeX < farZ; relativeX++) {
                    for(int relativeZ = -farZ; relativeZ < farZ; relativeZ++) {
                        boolean visible = false;
                        label0:
                        for(int l3 = -1; l3 <= 1; l3++) {
                            for(int j4 = -1; j4 <= 1; j4++) {
                                if(tileOnScreen[anglePointerY][anglePointerX][relativeX + l3 + MAX_FAR_Z + 1][relativeZ + j4 + MAX_FAR_Z + 1])
                                    visible = true;
                                else
                                if(tileOnScreen[anglePointerY][(anglePointerX + 1) % 31][relativeX + l3 + MAX_FAR_Z + 1][relativeZ + j4 + MAX_FAR_Z + 1])
                                    visible = true;
                                else
                                if(tileOnScreen[anglePointerY + 1][anglePointerX][relativeX + l3 + MAX_FAR_Z + 1][relativeZ + j4 + MAX_FAR_Z + 1])
                                {
                                    visible = true;
                                } else
                                {
                                    if(!tileOnScreen[anglePointerY + 1][(anglePointerX + 1) % 31][relativeX + l3 + MAX_FAR_Z + 1][relativeZ + j4 + MAX_FAR_Z + 1])
                                        continue;
                                    visible = true;
                                }
                                break label0;
                            }

                        }

                        TILE_VISIBILITY_MAPS[anglePointerY][anglePointerX][relativeX + farZ][relativeZ + farZ] = visible;
                    }

                }

            }

        }

    }

    public static boolean onScreen(int i, int j, int k)
    {
        int l = j * curveSineX + k * curveCosineX >> 16;
        int i1 = j * curveCosineX - k * curveSineX >> 16;

        int j1 = i * curveSineY + i1 * curveCosineY >> 16;
        int k1 = i * curveCosineY - i1 * curveSineY >> 16;
        if (j1 < 50 || j1 > WorldController.renderDistanceClamp) // Changed 3500 to 6000
            return false;
        int l1 = midX + (l << client.log_view_dist) / j1;
        int i2 = midY + (k1 << client.log_view_dist) / j1;
        return l1 >= left && l1 <= right && i2 >= top && i2 <= bottom;
    }

    public void method312(boolean flag, int i, int j)
    {
        clicked = true;
        clickX = j;
        clickY = i;
        clickedTileX = -1;
        clickedTileY = -1;
        if(flag)
        {
            for(int k = 1; k > 0; k++);
        }
    }

    public void method313(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        if(i < 0)
            i = 0;
        else
        if(i >= mapSizeX * 128)
            i = mapSizeX * 128 - 1;
        if(j < 0)
            j = 0;
        else
        if(j >= mapSizeY * 128)
            j = mapSizeY * 128 - 1;
        anInt448++;
        curveSineY = Model.SINE[j1];
        curveCosineY = Model.COSINE[j1];
        if(flag)
            return;
        curveSineX = Model.SINE[k];
        curveCosineX = Model.COSINE[k];
        TILE_VISIBILITY_MAP = TILE_VISIBILITY_MAPS[(j1 - 128) / 32][k / 64];
        cameraPosX = i;
        cameraPosZ = l;
        cameraPosY = j;
        cameraPositionTileX = i / 128;
        cameraPositionTileY = j / 128;
        plane = i1;
        currentPositionX = cameraPositionTileX - farZ;
        if(currentPositionX < 0)
            currentPositionX = 0;
        currentPositionY = cameraPositionTileY - farZ;
        if(currentPositionY < 0)
            currentPositionY = 0;
        mapBoundsX = cameraPositionTileX + farZ;
        if(mapBoundsX > mapSizeX)
            mapBoundsX = mapSizeX;
        mapBoundsY = cameraPositionTileY + farZ;
        if(mapBoundsY > mapSizeY)
            mapBoundsY = mapSizeY;
        method319(0);
        anInt446 = 0;
        for(int k1 = currentPositionZ; k1 < mapSizeZ; k1++)
        {
            Tile aclass30_sub3[][] = tileArray[k1];
            for(int i2 = currentPositionX; i2 < mapBoundsX; i2++)
            {
                for(int k2 = currentPositionY; k2 < mapBoundsY; k2++)
                {
                    Tile tile = aclass30_sub3[i2][k2];
                    if(tile != null)
                        if(tile.anInt1321 > i1 || !TILE_VISIBILITY_MAP[(i2 - cameraPositionTileX) + farZ][(k2 - cameraPositionTileY) + farZ] && vertexHeights[k1][i2][k2] - l < 1)
                        {
                            tile.aBoolean1322 = false;
                            tile.aBoolean1323 = false;
                            tile.anInt1325 = 0;
                        } else
                        {
                            tile.aBoolean1322 = true;
                            tile.aBoolean1323 = true;
                            if(tile.anInt1317 > 0)
                                tile.aBoolean1324 = true;
                            else
                                tile.aBoolean1324 = false;
                            anInt446++;
                        }
                }

            }

        }

        for(int l1 = currentPositionZ; l1 < mapSizeZ; l1++)
        {
            Tile aclass30_sub3_1[][] = tileArray[l1];
            for(int l2 = -farZ; l2 <= 0; l2++)
            {
                int i3 = cameraPositionTileX + l2;
                int k3 = cameraPositionTileX - l2;
                if(i3 >= currentPositionX || k3 < mapBoundsX)
                {
                    for(int i4 = -farZ; i4 <= 0; i4++)
                    {
                        int k4 = cameraPositionTileY + i4;
                        int i5 = cameraPositionTileY - i4;
                        if(i3 >= currentPositionX)
                        {
                            if(k4 >= currentPositionY)
                            {
                                Tile tile_1 = aclass30_sub3_1[i3][k4];
                                if(tile_1 != null && tile_1.aBoolean1322)
                                    method314(tile_1, true);
                            }
                            if(i5 < mapBoundsY)
                            {
                                Tile tile_2 = aclass30_sub3_1[i3][i5];
                                if(tile_2 != null && tile_2.aBoolean1322)
                                    method314(tile_2, true);
                            }
                        }
                        if(k3 < mapBoundsX)
                        {
                            if(k4 >= currentPositionY)
                            {
                                Tile tile = aclass30_sub3_1[k3][k4];
                                if(tile != null && tile.aBoolean1322)
                                    method314(tile, true);
                            }
                            if(i5 < mapBoundsY)
                            {
                                Tile tile_4 = aclass30_sub3_1[k3][i5];
                                if(tile_4 != null && tile_4.aBoolean1322)
                                    method314(tile_4, true);
                            }
                        }
                        if(anInt446 == 0)
                        {
                            clicked = false;
                            return;
                        }
                    }

                }
            }

        }

        for(int j2 = currentPositionZ; j2 < mapSizeZ; j2++)
        {
            Tile aclass30_sub3_2[][] = tileArray[j2];
            for(int j3 = -farZ; j3 <= 0; j3++)
            {
                int l3 = cameraPositionTileX + j3;
                int j4 = cameraPositionTileX - j3;
                if(l3 >= currentPositionX || j4 < mapBoundsX)
                {
                    for(int l4 = -farZ; l4 <= 0; l4++)
                    {
                        int j5 = cameraPositionTileY + l4;
                        int k5 = cameraPositionTileY - l4;
                        if(l3 >= currentPositionX)
                        {
                            if(j5 >= currentPositionY)
                            {
                                Tile tile_5 = aclass30_sub3_2[l3][j5];
                                if(tile_5 != null && tile_5.aBoolean1322)
                                    method314(tile_5, false);
                            }
                            if(k5 < mapBoundsY)
                            {
                                Tile tile_6 = aclass30_sub3_2[l3][k5];
                                if(tile_6 != null && tile_6.aBoolean1322)
                                    method314(tile_6, false);
                            }
                        }
                        if(j4 < mapBoundsX)
                        {
                            if(j5 >= currentPositionY)
                            {
                                Tile tile_7 = aclass30_sub3_2[j4][j5];
                                if(tile_7 != null && tile_7.aBoolean1322)
                                    method314(tile_7, false);
                            }
                            if(k5 < mapBoundsY)
                            {
                                Tile tile_8 = aclass30_sub3_2[j4][k5];
                                if(tile_8 != null && tile_8.aBoolean1322)
                                    method314(tile_8, false);
                            }
                        }
                        if(anInt446 == 0)
                        {
                            clicked = false;
                            return;
                        }
                    }

                }
            }

        }

        clicked = false;
    }

    public void method314(Tile tile, boolean flag)
    {
        tileList.insertHead(tile);
        do
        {
            Tile tile_1;
            do
            {
                tile_1 = (Tile) tileList.method251();
                if(tile_1 == null)
                    return;
            } while(!tile_1.aBoolean1323);
            int i = tile_1.anInt1308;
            int j = tile_1.anInt1309;
            int k = tile_1.anInt1307;
            int l = tile_1.anInt1310;
            Tile aclass30_sub3[][] = tileArray[k];
            int objectBufferOffset = 10;
            if(tile_1.aBoolean1322)
            {
                if(flag)
                {
                    if(k > 0)
                    {
                        Tile tile_2 = tileArray[k - 1][i][j];
                        if(tile_2 != null && tile_2.aBoolean1323)
                            continue;
                    }
                    if(i <= cameraPositionTileX && i > currentPositionX)
                    {
                        tile = aclass30_sub3[i - 1][j];
                        if(tile != null && tile.aBoolean1323 && (tile.aBoolean1322 || (tile_1.anInt1320 & 1) == 0))
                            continue;
                    }
                    if(i >= cameraPositionTileX && i < mapBoundsX - 1)
                    {
                        Tile tile_4 = aclass30_sub3[i + 1][j];
                        if(tile_4 != null && tile_4.aBoolean1323 && (tile_4.aBoolean1322 || (tile_1.anInt1320 & 4) == 0))
                            continue;
                    }
                    if(j <= cameraPositionTileY && j > currentPositionY)
                    {
                        Tile tile_5 = aclass30_sub3[i][j - 1];
                        if(tile_5 != null && tile_5.aBoolean1323 && (tile_5.aBoolean1322 || (tile_1.anInt1320 & 8) == 0))
                            continue;
                    }
                    if(j >= cameraPositionTileY && j < mapBoundsY - 1)
                    {
                        Tile tile_6 = aclass30_sub3[i][j + 1];
                        if(tile_6 != null && tile_6.aBoolean1323 && (tile_6.aBoolean1322 || (tile_1.anInt1320 & 2) == 0))
                            continue;
                    }
                } else
                {
                    flag = true;
                }
                tile_1.aBoolean1322 = false;
                if(tile_1.aTile_1329 != null)
                {
                    Tile tile_7 = tile_1.aTile_1329;
                    if(tile_7.plainTile != null)
                    {
                        if(!method320(0, i, j))
                            drawPlainTile(tile_7.plainTile, 0, curveSineY, curveCosineY, curveSineX, curveCosineX, i, j);
                    } else
                    if(tile_7.aShapedTile_1312 != null && !method320(0, i, j))
                        method316(i, curveSineY, curveSineX, tile_7.aShapedTile_1312, curveCosineY, j, curveCosineX);
                    Class10 class10 = tile_7.aClass10_1313;
                    if(class10 != null)
                        class10.aAnimable_278.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class10.anInt274 - cameraPosX, class10.anInt273 - cameraPosZ, class10.anInt275 - cameraPosY, class10.anInt280, 5);
                    for(int i2 = 0; i2 < tile_7.anInt1317; i2++)
                    {
                        InteractiveObject interactiveObject = tile_7.aInteractiveObjectArray1318[i2];
                        if(interactiveObject != null)
                            interactiveObject.aAnimable_521.renderAtPoint(interactiveObject.anInt522, curveSineY, curveCosineY, curveSineX, curveCosineX, interactiveObject.anInt519 - cameraPosX, interactiveObject.anInt518 - cameraPosZ, interactiveObject.anInt520 - cameraPosY, interactiveObject.anInt529, 5);
                    }

                }
                boolean flag1 = false;
                if(tile_1.plainTile != null)
                {
                    if(!method320(l, i, j))
                    {
                        flag1 = true;
                        drawPlainTile(tile_1.plainTile, l, curveSineY, curveCosineY, curveSineX, curveCosineX, i, j);
                    }
                } else
                if(tile_1.aShapedTile_1312 != null && !method320(l, i, j))
                {
                    flag1 = true;
                    method316(i, curveSineY, curveSineX, tile_1.aShapedTile_1312, curveCosineY, j, curveCosineX);
                }
                int j1 = 0;
                int j2 = 0;
                Class10 class10_3 = tile_1.aClass10_1313;
                Class26 class26_1 = tile_1.aClass26_1314;
                if(class10_3 != null || class26_1 != null)
                {
                    if(cameraPositionTileX == i)
                        j1++;
                    else
                    if(cameraPositionTileX < i)
                        j1 += 2;
                    if(cameraPositionTileY == j)
                        j1 += 3;
                    else
                    if(cameraPositionTileY > j)
                        j1 += 6;
                    j2 = anIntArray478[j1];
                    tile_1.anInt1328 = anIntArray480[j1];
                }
                if(class10_3 != null)
                {
                    if((class10_3.anInt276 & anIntArray479[j1]) != 0)
                    {
                        if(class10_3.anInt276 == 16)
                        {
                            tile_1.anInt1325 = 3;
                            tile_1.anInt1326 = anIntArray481[j1];
                            tile_1.anInt1327 = 3 - tile_1.anInt1326;
                        } else
                        if(class10_3.anInt276 == 32)
                        {
                            tile_1.anInt1325 = 6;
                            tile_1.anInt1326 = anIntArray482[j1];
                            tile_1.anInt1327 = 6 - tile_1.anInt1326;
                        } else
                        if(class10_3.anInt276 == 64)
                        {
                            tile_1.anInt1325 = 12;
                            tile_1.anInt1326 = anIntArray483[j1];
                            tile_1.anInt1327 = 12 - tile_1.anInt1326;
                        } else
                        {
                            tile_1.anInt1325 = 9;
                            tile_1.anInt1326 = anIntArray484[j1];
                            tile_1.anInt1327 = 9 - tile_1.anInt1326;
                        }
                    } else
                    {
                        tile_1.anInt1325 = 0;
                    }
                    if((class10_3.anInt276 & j2) != 0 && !method321(l, i, j, class10_3.anInt276))
                        class10_3.aAnimable_278.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class10_3.anInt274 - cameraPosX, class10_3.anInt273 - cameraPosZ, class10_3.anInt275 - cameraPosY, class10_3.anInt280, 10);
                    if((class10_3.anInt277 & j2) != 0 && !method321(l, i, j, class10_3.anInt277))
                        class10_3.aAnimable_279.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class10_3.anInt274 - cameraPosX, class10_3.anInt273 - cameraPosZ, class10_3.anInt275 - cameraPosY, class10_3.anInt280, 10);
                }
                if(class26_1 != null && !method322(l, i, j, class26_1.aAnimable_504.modelHeight))
                    if((class26_1.anInt502 & j2) != 0)
                        class26_1.aAnimable_504.renderAtPoint(class26_1.anInt503, curveSineY, curveCosineY, curveSineX, curveCosineX, class26_1.anInt500 - cameraPosX, class26_1.anInt499 - cameraPosZ, class26_1.anInt501 - cameraPosY, class26_1.anInt505, 15);
                    else
                    if((class26_1.anInt502 & 0x300) != 0)
                    {
                        int j4 = class26_1.anInt500 - cameraPosX;
                        int l5 = class26_1.anInt499 - cameraPosZ;
                        int k6 = class26_1.anInt501 - cameraPosY;
                        int i8 = class26_1.anInt503;
                        int k9;
                        if(i8 == 1 || i8 == 2)
                            k9 = -j4;
                        else
                            k9 = j4;
                        int k10;
                        if(i8 == 2 || i8 == 3)
                            k10 = -k6;
                        else
                            k10 = k6;
                        if((class26_1.anInt502 & 0x100) != 0 && k10 < k9)
                        {
                            int i11 = j4 + faceOffsetX2[i8];
                            int k11 = k6 + faceOffsetY2[i8];
                            class26_1.aAnimable_504.renderAtPoint(i8 * 512 + 256, curveSineY, curveCosineY, curveSineX, curveCosineX, i11, l5, k11, class26_1.anInt505, 15);
                        }
                        if((class26_1.anInt502 & 0x200) != 0 && k10 > k9)
                        {
                            int j11 = j4 + faceOffsetX3[i8];
                            int l11 = k6 + faceOffsetY3[i8];
                            class26_1.aAnimable_504.renderAtPoint(i8 * 512 + 1280 & 0x7ff, curveSineY, curveCosineY, curveSineX, curveCosineX, j11, l5, l11, class26_1.anInt505, 15);
                        }
                    }
                if(flag1)
                {
                    Class49 class49 = tile_1.groundDecoration;
                    if(class49 != null)
                        class49.renderable.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class49.anInt812 - cameraPosX, class49.anInt811 - cameraPosZ, class49.anInt813 - cameraPosY, class49.anInt815, 15);
                    Class3 class3_1 = tile_1.aClass3_1316;
                    if(class3_1 != null && class3_1.anInt52 == 0)
                    {
                        if(class3_1.aAnimable_49 != null)
                            class3_1.aAnimable_49.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class3_1.anInt46 - cameraPosX, class3_1.anInt45 - cameraPosZ, class3_1.anInt47 - cameraPosY, class3_1.anInt51, 15);
                        if(class3_1.aAnimable_50 != null)
                            class3_1.aAnimable_50.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class3_1.anInt46 - cameraPosX, class3_1.anInt45 - cameraPosZ, class3_1.anInt47 - cameraPosY, class3_1.anInt51, 15);
                        if(class3_1.aAnimable_48 != null)
                            class3_1.aAnimable_48.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class3_1.anInt46 - cameraPosX, class3_1.anInt45 - cameraPosZ, class3_1.anInt47 - cameraPosY, class3_1.anInt51, 15);
                    }
                }
                int k4 = tile_1.anInt1320;
                if(k4 != 0)
                {
                    if(i < cameraPositionTileX && (k4 & 4) != 0)
                    {
                        Tile tile_17 = aclass30_sub3[i + 1][j];
                        if(tile_17 != null && tile_17.aBoolean1323)
                            tileList.insertHead(tile_17);
                    }
                    if(j < cameraPositionTileY && (k4 & 2) != 0)
                    {
                        Tile tile_18 = aclass30_sub3[i][j + 1];
                        if(tile_18 != null && tile_18.aBoolean1323)
                            tileList.insertHead(tile_18);
                    }
                    if(i > cameraPositionTileX && (k4 & 1) != 0)
                    {
                        Tile tile_19 = aclass30_sub3[i - 1][j];
                        if(tile_19 != null && tile_19.aBoolean1323)
                            tileList.insertHead(tile_19);
                    }
                    if(j > cameraPositionTileY && (k4 & 8) != 0)
                    {
                        Tile tile_20 = aclass30_sub3[i][j - 1];
                        if(tile_20 != null && tile_20.aBoolean1323)
                            tileList.insertHead(tile_20);
                    }
                }
            }
            if(tile_1.anInt1325 != 0)
            {
                boolean flag2 = true;
                for(int k1 = 0; k1 < tile_1.anInt1317; k1++)
                {
                    if(tile_1.aInteractiveObjectArray1318[k1].anInt528 == anInt448 || (tile_1.anIntArray1319[k1] & tile_1.anInt1325) != tile_1.anInt1326)
                        continue;
                    flag2 = false;
                    break;
                }

                if(flag2)
                {
                    Class10 class10_1 = tile_1.aClass10_1313;
                    if(!method321(l, i, j, class10_1.anInt276))
                        class10_1.aAnimable_278.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class10_1.anInt274 - cameraPosX, class10_1.anInt273 - cameraPosZ, class10_1.anInt275 - cameraPosY, class10_1.anInt280, 10);
                    tile_1.anInt1325 = 0;
                }
            }
            if(tile_1.aBoolean1324)
                try
                {
                    int i1 = tile_1.anInt1317;
                    tile_1.aBoolean1324 = false;
                    int l1 = 0;
label0:
                    for(int k2 = 0; k2 < i1; k2++)
                    {
                        InteractiveObject interactiveObject_1 = tile_1.aInteractiveObjectArray1318[k2];
                        if(interactiveObject_1.anInt528 == anInt448)
                            continue;
                        for(int k3 = interactiveObject_1.anInt523; k3 <= interactiveObject_1.anInt524; k3++)
                        {
                            for(int l4 = interactiveObject_1.anInt525; l4 <= interactiveObject_1.anInt526; l4++)
                            {
                                Tile tile_21 = aclass30_sub3[k3][l4];
                                if(tile_21.aBoolean1322)
                                {
                                    tile_1.aBoolean1324 = true;
                                } else
                                {
                                    if(tile_21.anInt1325 == 0)
                                        continue;
                                    int l6 = 0;
                                    if(k3 > interactiveObject_1.anInt523)
                                        l6++;
                                    if(k3 < interactiveObject_1.anInt524)
                                        l6 += 4;
                                    if(l4 > interactiveObject_1.anInt525)
                                        l6 += 8;
                                    if(l4 < interactiveObject_1.anInt526)
                                        l6 += 2;
                                    if((l6 & tile_21.anInt1325) != tile_1.anInt1327)
                                        continue;
                                    tile_1.aBoolean1324 = true;
                                }
                                continue label0;
                            }

                        }

                        interactiveObjects[l1++] = interactiveObject_1;
                        int i5 = cameraPositionTileX - interactiveObject_1.anInt523;
                        int i6 = interactiveObject_1.anInt524 - cameraPositionTileX;
                        if(i6 > i5)
                            i5 = i6;
                        int i7 = cameraPositionTileY - interactiveObject_1.anInt525;
                        int j8 = interactiveObject_1.anInt526 - cameraPositionTileY;
                        if(j8 > i7)
                            interactiveObject_1.anInt527 = i5 + j8;
                        else
                            interactiveObject_1.anInt527 = i5 + i7;
                    }

                    while(l1 > 0) 
                    {
                        int i3 = -50;
                        int l3 = -1;
                        for(int j5 = 0; j5 < l1; j5++)
                        {
                            InteractiveObject interactiveObject_2 = interactiveObjects[j5];
                            if(interactiveObject_2.anInt528 != anInt448)
                                if(interactiveObject_2.anInt527 > i3)
                                {
                                    i3 = interactiveObject_2.anInt527;
                                    l3 = j5;
                                } else
                                if(interactiveObject_2.anInt527 == i3)
                                {
                                    int j7 = interactiveObject_2.anInt519 - cameraPosX;
                                    int k8 = interactiveObject_2.anInt520 - cameraPosY;
                                    int l9 = interactiveObjects[l3].anInt519 - cameraPosX;
                                    int l10 = interactiveObjects[l3].anInt520 - cameraPosY;
                                    if(j7 * j7 + k8 * k8 > l9 * l9 + l10 * l10)
                                        l3 = j5;
                                }
                        }

                        if(l3 == -1)
                            break;
                        InteractiveObject interactiveObject_3 = interactiveObjects[l3];
                        interactiveObject_3.anInt528 = anInt448;
                        if(!method323(l, interactiveObject_3.anInt523, interactiveObject_3.anInt524, interactiveObject_3.anInt525, interactiveObject_3.anInt526, interactiveObject_3.aAnimable_521.modelHeight))
                            interactiveObject_3.aAnimable_521.renderAtPoint(interactiveObject_3.anInt522, curveSineY, curveCosineY, curveSineX, curveCosineX, interactiveObject_3.anInt519 - cameraPosX, interactiveObject_3.anInt518 - cameraPosZ, interactiveObject_3.anInt520 - cameraPosY, interactiveObject_3.anInt529, objectBufferOffset);
                        for(int k7 = interactiveObject_3.anInt523; k7 <= interactiveObject_3.anInt524; k7++)
                        {
                            for(int l8 = interactiveObject_3.anInt525; l8 <= interactiveObject_3.anInt526; l8++)
                            {
                                Tile tile_22 = aclass30_sub3[k7][l8];
                                if(tile_22.anInt1325 != 0)
                                    tileList.insertHead(tile_22);
                                else
                                if((k7 != i || l8 != j) && tile_22.aBoolean1323)
                                    tileList.insertHead(tile_22);
                            }

                        }

                    }
                    if(tile_1.aBoolean1324)
                        continue;
                }
                catch(Exception _ex)
                {
                    tile_1.aBoolean1324 = false;
                }
            if(!tile_1.aBoolean1323 || tile_1.anInt1325 != 0)
                continue;
            if(i <= cameraPositionTileX && i > currentPositionX)
            {
                Tile tile_8 = aclass30_sub3[i - 1][j];
                if(tile_8 != null && tile_8.aBoolean1323)
                    continue;
            }
            if(i >= cameraPositionTileX && i < mapBoundsX - 1)
            {
                Tile tile_9 = aclass30_sub3[i + 1][j];
                if(tile_9 != null && tile_9.aBoolean1323)
                    continue;
            }
            if(j <= cameraPositionTileY && j > currentPositionY)
            {
                Tile tile_10 = aclass30_sub3[i][j - 1];
                if(tile_10 != null && tile_10.aBoolean1323)
                    continue;
            }
            if(j >= cameraPositionTileY && j < mapBoundsY - 1)
            {
                Tile tile_11 = aclass30_sub3[i][j + 1];
                if(tile_11 != null && tile_11.aBoolean1323)
                    continue;
            }
            tile_1.aBoolean1323 = false;
            anInt446--;
            Class3 class3 = tile_1.aClass3_1316;
            if(class3 != null && class3.anInt52 != 0)
            {
                if(class3.aAnimable_49 != null)
                    class3.aAnimable_49.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class3.anInt46 - cameraPosX, class3.anInt45 - cameraPosZ - class3.anInt52, class3.anInt47 - cameraPosY, class3.anInt51,5);
                if(class3.aAnimable_50 != null)
                    class3.aAnimable_50.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class3.anInt46 - cameraPosX, class3.anInt45 - cameraPosZ - class3.anInt52, class3.anInt47 - cameraPosY, class3.anInt51,5);
                if(class3.aAnimable_48 != null)
                    class3.aAnimable_48.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class3.anInt46 - cameraPosX, class3.anInt45 - cameraPosZ - class3.anInt52, class3.anInt47 - cameraPosY, class3.anInt51,5);
            }
            if(tile_1.anInt1328 != 0)
            {
                Class26 class26 = tile_1.aClass26_1314;
                if(class26 != null && !method322(l, i, j, class26.aAnimable_504.modelHeight))
                    if((class26.anInt502 & tile_1.anInt1328) != 0)
                        class26.aAnimable_504.renderAtPoint(class26.anInt503, curveSineY, curveCosineY, curveSineX, curveCosineX, class26.anInt500 - cameraPosX, class26.anInt499 - cameraPosZ, class26.anInt501 - cameraPosY, class26.anInt505, 15);
                    else
                    if((class26.anInt502 & 0x300) != 0)
                    {
                        int l2 = class26.anInt500 - cameraPosX;
                        int j3 = class26.anInt499 - cameraPosZ;
                        int i4 = class26.anInt501 - cameraPosY;
                        int k5 = class26.anInt503;
                        int j6;
                        if(k5 == 1 || k5 == 2)
                            j6 = -l2;
                        else
                            j6 = l2;
                        int l7;
                        if(k5 == 2 || k5 == 3)
                            l7 = -i4;
                        else
                            l7 = i4;
                        if((class26.anInt502 & 0x100) != 0 && l7 >= j6)
                        {
                            int i9 = l2 + faceOffsetX2[k5];
                            int i10 = i4 + faceOffsetY2[k5];
                            class26.aAnimable_504.renderAtPoint(k5 * 512 + 256, curveSineY, curveCosineY, curveSineX, curveCosineX, i9, j3, i10, class26.anInt505, 15);
                        }
                        if((class26.anInt502 & 0x200) != 0 && l7 <= j6)
                        {
                            int j9 = l2 + faceOffsetX3[k5];
                            int j10 = i4 + faceOffsetY3[k5];
                            class26.aAnimable_504.renderAtPoint(k5 * 512 + 1280 & 0x7ff, curveSineY, curveCosineY, curveSineX, curveCosineX, j9, j3, j10, class26.anInt505, 15);
                        }
                    }
                Class10 class10_2 = tile_1.aClass10_1313;
                if(class10_2 != null)
                {
                    if((class10_2.anInt277 & tile_1.anInt1328) != 0 && !method321(l, i, j, class10_2.anInt277))
                        class10_2.aAnimable_279.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class10_2.anInt274 - cameraPosX, class10_2.anInt273 - cameraPosZ, class10_2.anInt275 - cameraPosY, class10_2.anInt280, 10);
                    if((class10_2.anInt276 & tile_1.anInt1328) != 0 && !method321(l, i, j, class10_2.anInt276))
                        class10_2.aAnimable_278.renderAtPoint(0, curveSineY, curveCosineY, curveSineX, curveCosineX, class10_2.anInt274 - cameraPosX, class10_2.anInt273 - cameraPosZ, class10_2.anInt275 - cameraPosY, class10_2.anInt280, 10);
                }
            }
            if(k < mapSizeZ - 1)
            {
                Tile tile_12 = tileArray[k + 1][i][j];
                if(tile_12 != null && tile_12.aBoolean1323)
                    tileList.insertHead(tile_12);
            }
            if(i < cameraPositionTileX)
            {
                Tile tile_13 = aclass30_sub3[i + 1][j];
                if(tile_13 != null && tile_13.aBoolean1323)
                    tileList.insertHead(tile_13);
            }
            if(j < cameraPositionTileY)
            {
                Tile tile_14 = aclass30_sub3[i][j + 1];
                if(tile_14 != null && tile_14.aBoolean1323)
                    tileList.insertHead(tile_14);
            }
            if(i > cameraPositionTileX)
            {
                Tile tile_15 = aclass30_sub3[i - 1][j];
                if(tile_15 != null && tile_15.aBoolean1323)
                    tileList.insertHead(tile_15);
            }
            if(j > cameraPositionTileY)
            {
                Tile tile_16 = aclass30_sub3[i][j - 1];
                if(tile_16 != null && tile_16.aBoolean1323)
                    tileList.insertHead(tile_16);
            }
        } while(true);
    }

    private void drawPlainTile(PlainTile plainTile, int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1;
        int i2 = l1 = (j1 << 7) - cameraPosX;
        int j2;
        int k2 = j2 = (k1 << 7) - cameraPosY;
        int l2;
        int i3 = l2 = i2 + 128;
        int j3;
        int k3 = j3 = k2 + 128;
        int l3 = vertexHeights[i][j1][k1] - cameraPosZ;
        int i4 = vertexHeights[i][j1 + 1][k1] - cameraPosZ;
        int j4 = vertexHeights[i][j1 + 1][k1 + 1] - cameraPosZ;
        int k4 = vertexHeights[i][j1][k1 + 1] - cameraPosZ;
        int l4 = k2 * l + i2 * i1 >> 16;
        k2 = k2 * i1 - i2 * l >> 16;
        i2 = l4;
        l4 = l3 * k - k2 * j >> 16;
        k2 = l3 * j + k2 * k >> 16;
        l3 = l4;
        if (k2 < 50) {
            return;
        }
        l4 = j2 * l + i3 * i1 >> 16;
        j2 = j2 * i1 - i3 * l >> 16;
        i3 = l4;
        l4 = i4 * k - j2 * j >> 16;
        j2 = i4 * j + j2 * k >> 16;
        i4 = l4;
        if (j2 < 50) {
            return;
        }
        l4 = k3 * l + l2 * i1 >> 16;
        k3 = k3 * i1 - l2 * l >> 16;
        l2 = l4;
        l4 = j4 * k - k3 * j >> 16;
        k3 = j4 * j + k3 * k >> 16;
        j4 = l4;
        if (k3 < 50) {
            return;
        }
        l4 = j3 * l + l1 * i1 >> 16;
        j3 = j3 * i1 - l1 * l >> 16;
        l1 = l4;
        l4 = k4 * k - j3 * j >> 16;
        j3 = k4 * j + j3 * k >> 16;
        k4 = l4;
        if (j3 < 50) {
            return;
        }
        int x1 = Rasterizer.centerX + (i2 << client.log_view_dist) / k2;
        int y1 = Rasterizer.centerY + (l3 << client.log_view_dist) / k2;
        int x2 = Rasterizer.centerX + (i3 << client.log_view_dist) / j2;
        int y2 = Rasterizer.centerY + (i4 << client.log_view_dist) / j2;
        int x3 = Rasterizer.centerX + (l2 << client.log_view_dist) / k3;
        int y3 = Rasterizer.centerY + (j4 << client.log_view_dist) / k3;
        int x4 = Rasterizer.centerX + (l1 << client.log_view_dist) / j3;
        int y4 = Rasterizer.centerY + (k4 << client.log_view_dist) / j3;
        Rasterizer.anInt1465 = 0;
        if ((x3 - x4) * (y2 - y4) - (y3 - y4) * (x2 - x4) > 0) {
            Rasterizer.aBoolean1462 = x3 < 0 || x4 < 0 || x2 < 0 || x3 > DrawingArea.viewportRX || x4 > DrawingArea.viewportRX
                    || x2 > DrawingArea.viewportRX;
            if (clicked && method318(clickX, clickY, y3, y4, y2, x3, x4, x2)) {
                clickedTileX = j1;
                clickedTileY = k1;
            }
            if (plainTile.anInt720 == -1 || plainTile.anInt720 > 50) {
                if (plainTile.anInt718 != 0xbc614e) {
                    if (Configuration.hdTexturing && plainTile.anInt720 != -1) {
                        if (plainTile.aBoolean721) {
                            Rasterizer.drawMaterializedTriangle(y3, y4, y2, x3, x4, x2, plainTile.anInt718,
                                    plainTile.anInt719, plainTile.anInt717, i2, i3, l1, l3, i4, k4, k2, j2, j3,
                                    plainTile.anInt720, (float) k3, (float) j3, (float) j2);
                        } else {
                            Rasterizer.drawMaterializedTriangle(y3, y4, y2, x3, x4, x2, plainTile.anInt718,
                                    plainTile.anInt719, plainTile.anInt717, l2, l1, i3, j4, k4, i4, k3, j3, j2,
                                    plainTile.anInt720, (float) k3, (float) j3, (float) j2);
                        }
                    } else {
                        Rasterizer.drawGouraudTriangle(y3, y4, y2, x3, x4, x2, plainTile.anInt718, plainTile.anInt719,
                                plainTile.anInt717, (float) k3, (float) j3, (float) j2, 0);
                    }
                }
            } else if (!lowMem) {
                if (plainTile.aBoolean721) {
                    Rasterizer.drawTexturedTriangle(y3, y4, y2, x3, x4, x2, plainTile.anInt718, plainTile.anInt719, plainTile.anInt717,
                            i2, i3, l1, l3, i4, k4, k2, j2, j3, plainTile.anInt720, (float) k3, (float) j3, (float) j2, 0);
                } else {
                    Rasterizer.drawTexturedTriangle(y3, y4, y2, x3, x4, x2, plainTile.anInt718, plainTile.anInt719, plainTile.anInt717,
                            l2, l1, i3, j4, k4, i4, k3, j3, j2, plainTile.anInt720, (float) k3, (float) j3, (float) j2, 0);
                }
            } else {
                int i7 = textureRGB[plainTile.anInt720];
                Rasterizer.drawGouraudTriangle(y3, y4, y2, x3, x4, x2, method317(i7, plainTile.anInt718),
                        method317(i7, plainTile.anInt719), method317(i7, plainTile.anInt717), (float) k3, (float) j3, (float) j2, 0);
            }
        }
        if ((x1 - x2) * (y4 - y2) - (y1 - y2) * (x4 - x2) > 0) {
            Rasterizer.aBoolean1462 = x1 < 0 || x2 < 0 || x4 < 0 || x1 > DrawingArea.viewportRX || x2 > DrawingArea.viewportRX
                    || x4 > DrawingArea.viewportRX;
            if (clicked && method318(clickX, clickY, y1, y2, y4, x1, x2, x4)) {
                clickedTileX = j1;
                clickedTileY = k1;
            }
            if (plainTile.anInt720 == -1 || plainTile.anInt720 > 50) {
                if (plainTile.anInt716 != 0xbc614e) {
                    if (Configuration.hdTexturing && plainTile.anInt720 != -1) {
                        Rasterizer.drawMaterializedTriangle(y1, y2, y4, x1, x2, x4, plainTile.anInt716, plainTile.anInt717,
                                plainTile.anInt719, i2, i3, l1, l3, i4, k4, k2, j2, j3, plainTile.anInt720, (float) k2, (float) j2, (float) j3);
                    } else {
                        Rasterizer.drawGouraudTriangle(y1, y2, y4, x1, x2, x4, plainTile.anInt716, plainTile.anInt717,
                                plainTile.anInt719, (float) k2, (float) j2, (float) j3, 0);
                    }
                }
            } else {
                if (!lowMem) {
                    Rasterizer.drawTexturedTriangle(y1, y2, y4, x1, x2, x4, plainTile.anInt716, plainTile.anInt717, plainTile.anInt719,
                            i2, i3, l1, l3, i4, k4, k2, j2, j3, plainTile.anInt720, (float) k2, (float) j2, (float) j3, 0);
                } else {
                    int j7 = textureRGB[plainTile.anInt720];
                    Rasterizer.drawGouraudTriangle(y1, y2, y4, x1, x2, x4, method317(j7, plainTile.anInt716),
                            method317(j7, plainTile.anInt717), method317(j7, plainTile.anInt719), (float) k2, (float) j2, (float) j3, 0);
                }
            }
        }
    }

    private void method316(int i, int j, int k, ShapedTile shapedTile, int l, int i1, int j1) {
        int k1 = shapedTile.vertexX.length;
        for (int l1 = 0; l1 < k1; l1++) {
            int i2 = shapedTile.vertexX[l1] - cameraPosX;
            int k2 = shapedTile.vertexY[l1] - cameraPosZ;
            int i3 = shapedTile.vertexZ[l1] - cameraPosY;
            int k3 = i3 * k + i2 * j1 >> 16;
            i3 = i3 * j1 - i2 * k >> 16;
            i2 = k3;
            k3 = k2 * l - i3 * j >> 16;
            i3 = k2 * j + i3 * l >> 16;
            k2 = k3;
            if (i3 < 50) {
                return;
            }
            if (Configuration.hdTexturing || shapedTile.triangleTexture != null) {
                ShapedTile.viewspaceX[l1] = i2;
                ShapedTile.viewspaceY[l1] = k2;
                ShapedTile.viewspaceZ[l1] = i3;
            }
            ShapedTile.screenX[l1] = Rasterizer.centerX + (i2 << client.log_view_dist) / i3;
            ShapedTile.screenY[l1] = Rasterizer.centerY + (k2 << client.log_view_dist) / i3;
            ShapedTile.depthPoint[l1] = i3;
        }

        Rasterizer.anInt1465 = 0;
        k1 = shapedTile.triangleA.length;
        for (int j2 = 0; j2 < k1; j2++) {
            int l2 = shapedTile.triangleA[j2];
            int j3 = shapedTile.triangleB[j2];
            int l3 = shapedTile.triangleC[j2];
            int x1 = ShapedTile.screenX[l2];
            int x2 = ShapedTile.screenX[j3];
            int x3 = ShapedTile.screenX[l3];
            int y1 = ShapedTile.screenY[l2];
            int y2 = ShapedTile.screenY[j3];
            int y3 = ShapedTile.screenY[l3];
            int z1 = ShapedTile.depthPoint[l2];
            int z2 = ShapedTile.depthPoint[j3];
            int z3 = ShapedTile.depthPoint[l3];
            if ((x1 - x2) * (y3 - y2) - (y1 - y2) * (x3 - x2) > 0) {
                Rasterizer.aBoolean1462 = x1 < 0 || x2 < 0 || x3 < 0 || x1 > DrawingArea.viewportRX
                        || x2 > DrawingArea.viewportRX || x3 > DrawingArea.viewportRX;
                if (clicked && method318(clickX, clickY, y1, y2, y3, x1, x2, x3)) {
                    clickedTileX = i;
                    clickedTileY = i1;
                }
                if (shapedTile.triangleTexture == null || shapedTile.triangleTexture[j2] == -1
                        || shapedTile.triangleTexture[j2] > 50) {
                    if (shapedTile.triangleHSLA[j2] != 0xbc614e) {
                        if (Configuration.hdTexturing && shapedTile.triangleTexture != null
                                && shapedTile.triangleTexture[j2] != -1) {
                            if (shapedTile.flat || shapedTile.triangleTexture[j2] == 505) {
                                Rasterizer.drawMaterializedTriangle(y1, y2, y3, x1, x2, x3, shapedTile.triangleHSLA[j2],
                                        shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], ShapedTile.viewspaceX[0],
                                        ShapedTile.viewspaceX[1], ShapedTile.viewspaceX[3], ShapedTile.viewspaceY[0],
                                        ShapedTile.viewspaceY[1], ShapedTile.viewspaceY[3], ShapedTile.viewspaceZ[0],
                                        ShapedTile.viewspaceZ[1], ShapedTile.viewspaceZ[3], shapedTile.triangleTexture[j2], (float) z1, (float) z2, (float) z3);
                            } else {
                                Rasterizer.drawMaterializedTriangle(y1, y2, y3, x1, x2, x3, shapedTile.triangleHSLA[j2],
                                        shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], ShapedTile.viewspaceX[l2],
                                        ShapedTile.viewspaceX[j3], ShapedTile.viewspaceX[l3], ShapedTile.viewspaceY[l2],
                                        ShapedTile.viewspaceY[j3], ShapedTile.viewspaceY[l3], ShapedTile.viewspaceZ[l2],
                                        ShapedTile.viewspaceZ[j3], ShapedTile.viewspaceZ[l3],
                                        shapedTile.triangleTexture[j2], (float) z1, (float) z2, (float) z3);
                            }
                        } else {
                            Rasterizer.drawGouraudTriangle(y1, y2, y3, x1, x2, x3, shapedTile.triangleHSLA[j2],
                                    shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], (float) z1, (float) z2, (float) z3, 0);
                        }
                    }
                } else if (!lowMem) {
                    if (/* true || */shapedTile.flat) {
                        Rasterizer.drawTexturedTriangle(y1, y2, y3, x1, x2, x3, shapedTile.triangleHSLA[j2],
                                shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], ShapedTile.viewspaceX[0],
                                ShapedTile.viewspaceX[1], ShapedTile.viewspaceX[3], ShapedTile.viewspaceY[0],
                                ShapedTile.viewspaceY[1], ShapedTile.viewspaceY[3], ShapedTile.viewspaceZ[0],
                                ShapedTile.viewspaceZ[1], ShapedTile.viewspaceZ[3], shapedTile.triangleTexture[j2], (float) z1, (float) z2, (float) z3, 0);
                    } else {
                        Rasterizer.drawTexturedTriangle(y1, y2, y3, x1, x2, x3, shapedTile.triangleHSLA[j2],
                                shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], ShapedTile.viewspaceX[l2],
                                ShapedTile.viewspaceX[j3], ShapedTile.viewspaceX[l3], ShapedTile.viewspaceY[l2],
                                ShapedTile.viewspaceY[j3], ShapedTile.viewspaceY[l3], ShapedTile.viewspaceZ[l2],
                                ShapedTile.viewspaceZ[j3], ShapedTile.viewspaceZ[l3], shapedTile.triangleTexture[j2], (float) z1, (float) z2, (float) z3, 0);
                    }
                } else {
                    int k5 = textureRGB[shapedTile.triangleTexture[j2]];
                    Rasterizer.drawGouraudTriangle(y1, y2, y3, x1, x2, x3, method317(k5, shapedTile.triangleHSLA[j2]),
                            method317(k5, shapedTile.triangleHSLB[j2]), method317(k5, shapedTile.triangleHSLC[j2]), (float) z1, (float) z2, (float) z3, 0);
                }
            }
        }

    }

    public int method317(int j, int k)
    {
        k = 127 - k;
        k = (k * (j & 0x7f)) / 160;
        if(k < 2)
            k = 2;
        else
        if(k > 126)
            k = 126;
        return (j & 0xff80) + k;
    }

    public boolean method318(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        if(j < k && j < l && j < i1)
            return false;
        if(j > k && j > l && j > i1)
            return false;
        if(i < j1 && i < k1 && i < l1)
            return false;
        if(i > j1 && i > k1 && i > l1)
            return false;
        int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
        int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
        int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
        return i2 * k2 > 0 && k2 * j2 > 0;
    }

    private void method319(int i)
    {
        if(i != 0)
            return;
        int j = cullingClusterPointer[plane];
        CullingCluster aclass47[] = cullingClusters[plane];
        processedCullingClustersPointer = 0;
        for(int k = 0; k < j; k++)
        {
            CullingCluster cullingCluster = aclass47[k];
            if(cullingCluster.searchMask == 1)
            {
                int l = (cullingCluster.tileStartX - cameraPositionTileX) + farZ;
                if(l < 0 || l > 50)
                    continue;
                int k1 = (cullingCluster.tileStartY - cameraPositionTileY) + farZ;
                if(k1 < 0)
                    k1 = 0;
                int j2 = (cullingCluster.tileEndY - cameraPositionTileY) + farZ;
                if(j2 > 50)
                    j2 = 50;
                boolean flag = false;
                while(k1 <= j2) 
                    if(TILE_VISIBILITY_MAP[l][k1++])
                    {
                        flag = true;
                        break;
                    }
                if(!flag)
                    continue;
                int j3 = cameraPosX - cullingCluster.worldStartX;
                if(j3 > 32)
                {
                    cullingCluster.tileDistanceEnum = 1;
                } else
                {
                    if(j3 >= -32)
                        continue;
                    cullingCluster.tileDistanceEnum = 2;
                    j3 = -j3;
                }
                cullingCluster.worldDistanceFromCameraStartY = (cullingCluster.worldStartY - cameraPosY << 8) / j3;
                cullingCluster.worldDistanceFromCameraEndY = (cullingCluster.worldEndY - cameraPosY << 8) / j3;
                cullingCluster.worldDistanceFromCameraStartZ = (cullingCluster.worldEndZ - cameraPosZ << 8) / j3;
                cullingCluster.worldDistanceFromCameraEndZ = (cullingCluster.worldStartZ - cameraPosZ << 8) / j3;
                processedCullingClusters[processedCullingClustersPointer++] = cullingCluster;
                continue;
            }
            if(cullingCluster.searchMask == 2)
            {
                int i1 = (cullingCluster.tileStartY - cameraPositionTileY) + farZ;
                if(i1 < 0 || i1 > 50)
                    continue;
                int l1 = (cullingCluster.tileStartX - cameraPositionTileX) + farZ;
                if(l1 < 0)
                    l1 = 0;
                int k2 = (cullingCluster.tileEndX - cameraPositionTileX) + farZ;
                if(k2 > 50)
                    k2 = 50;
                boolean flag1 = false;
                while(l1 <= k2) 
                    if(TILE_VISIBILITY_MAP[l1++][i1])
                    {
                        flag1 = true;
                        break;
                    }
                if(!flag1)
                    continue;
                int k3 = cameraPosY - cullingCluster.worldStartY;
                if(k3 > 32)
                {
                    cullingCluster.tileDistanceEnum = 3;
                } else
                {
                    if(k3 >= -32)
                        continue;
                    cullingCluster.tileDistanceEnum = 4;
                    k3 = -k3;
                }
                cullingCluster.worldDistanceFromCameraStartX = (cullingCluster.worldStartX - cameraPosX << 8) / k3;
                cullingCluster.worldDistanceFromCameraEndX = (cullingCluster.worldEndX - cameraPosX << 8) / k3;
                cullingCluster.worldDistanceFromCameraStartZ = (cullingCluster.worldEndZ - cameraPosZ << 8) / k3;
                cullingCluster.worldDistanceFromCameraEndZ = (cullingCluster.worldStartZ - cameraPosZ << 8) / k3;
                processedCullingClusters[processedCullingClustersPointer++] = cullingCluster;
            } else
            if(cullingCluster.searchMask == 4)
            {
                int j1 = cullingCluster.worldEndZ - cameraPosZ;
                if(j1 > 128)
                {
                    int i2 = (cullingCluster.tileStartY - cameraPositionTileY) + farZ;
                    if(i2 < 0)
                        i2 = 0;
                    int l2 = (cullingCluster.tileEndY - cameraPositionTileY) + farZ;
                    if(l2 > 50)
                        l2 = 50;
                    if(i2 <= l2)
                    {
                        int i3 = (cullingCluster.tileStartX - cameraPositionTileX) + farZ;
                        if(i3 < 0)
                            i3 = 0;
                        int l3 = (cullingCluster.tileEndX - cameraPositionTileX) + farZ;
                        if(l3 > 50)
                            l3 = 50;
                        boolean flag2 = false;
label0:
                        for(int i4 = i3; i4 <= l3; i4++)
                        {
                            for(int j4 = i2; j4 <= l2; j4++)
                            {
                                if(!TILE_VISIBILITY_MAP[i4][j4])
                                    continue;
                                flag2 = true;
                                break label0;
                            }

                        }

                        if(flag2)
                        {
                            cullingCluster.tileDistanceEnum = 5;
                            cullingCluster.worldDistanceFromCameraStartX = (cullingCluster.worldStartX - cameraPosX << 8) / j1;
                            cullingCluster.worldDistanceFromCameraEndX = (cullingCluster.worldEndX - cameraPosX << 8) / j1;
                            cullingCluster.worldDistanceFromCameraStartY = (cullingCluster.worldStartY - cameraPosY << 8) / j1;
                            cullingCluster.worldDistanceFromCameraEndY = (cullingCluster.worldEndY - cameraPosY << 8) / j1;
                            processedCullingClusters[processedCullingClustersPointer++] = cullingCluster;
                        }
                    }
                }
            }
        }

    }

    private boolean method320(int i, int j, int k)
    {
        int l = anIntArrayArrayArray445[i][j][k];
        if(l == -anInt448)
            return false;
        if(l == anInt448)
            return true;
        int i1 = j << 7;
        int j1 = k << 7;
        if(method324(i1 + 1, vertexHeights[i][j][k], j1 + 1) && method324((i1 + 128) - 1, vertexHeights[i][j + 1][k], j1 + 1) && method324((i1 + 128) - 1, vertexHeights[i][j + 1][k + 1], (j1 + 128) - 1) && method324(i1 + 1, vertexHeights[i][j][k + 1], (j1 + 128) - 1))
        {
            anIntArrayArrayArray445[i][j][k] = anInt448;
            return true;
        } else
        {
            anIntArrayArrayArray445[i][j][k] = -anInt448;
            return false;
        }
    }

    private boolean method321(int i, int j, int k, int l)
    {
        if(!method320(i, j, k))
            return false;
        int i1 = j << 7;
        int j1 = k << 7;
        int k1 = vertexHeights[i][j][k] - 1;
        int l1 = k1 - 120;
        int i2 = k1 - 230;
        int j2 = k1 - 238;
        if(l < 16)
        {
            if(l == 1)
            {
                if(i1 > cameraPosX)
                {
                    if(!method324(i1, k1, j1))
                        return false;
                    if(!method324(i1, k1, j1 + 128))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1, l1, j1))
                        return false;
                    if(!method324(i1, l1, j1 + 128))
                        return false;
                }
                if(!method324(i1, i2, j1))
                    return false;
                return method324(i1, i2, j1 + 128);
            }
            if(l == 2)
            {
                if(j1 < cameraPosY)
                {
                    if(!method324(i1, k1, j1 + 128))
                        return false;
                    if(!method324(i1 + 128, k1, j1 + 128))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1, l1, j1 + 128))
                        return false;
                    if(!method324(i1 + 128, l1, j1 + 128))
                        return false;
                }
                if(!method324(i1, i2, j1 + 128))
                    return false;
                return method324(i1 + 128, i2, j1 + 128);
            }
            if(l == 4)
            {
                if(i1 < cameraPosX)
                {
                    if(!method324(i1 + 128, k1, j1))
                        return false;
                    if(!method324(i1 + 128, k1, j1 + 128))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1 + 128, l1, j1))
                        return false;
                    if(!method324(i1 + 128, l1, j1 + 128))
                        return false;
                }
                if(!method324(i1 + 128, i2, j1))
                    return false;
                return method324(i1 + 128, i2, j1 + 128);
            }
            if(l == 8)
            {
                if(j1 > cameraPosY)
                {
                    if(!method324(i1, k1, j1))
                        return false;
                    if(!method324(i1 + 128, k1, j1))
                        return false;
                }
                if(i > 0)
                {
                    if(!method324(i1, l1, j1))
                        return false;
                    if(!method324(i1 + 128, l1, j1))
                        return false;
                }
                if(!method324(i1, i2, j1))
                    return false;
                return method324(i1 + 128, i2, j1);
            }
        }
        if(!method324(i1 + 64, j2, j1 + 64))
            return false;
        if(l == 16)
            return method324(i1, i2, j1 + 128);
        if(l == 32)
            return method324(i1 + 128, i2, j1 + 128);
        if(l == 64)
            return method324(i1 + 128, i2, j1);
        if(l == 128)
        {
            return method324(i1, i2, j1);
        } else
        {
            System.out.println("Warning unsupported wall type");
            return true;
        }
    }

    private boolean method322(int i, int j, int k, int l)
    {
        if(!method320(i, j, k))
            return false;
        int i1 = j << 7;
        int j1 = k << 7;
        return method324(i1 + 1, vertexHeights[i][j][k] - l, j1 + 1) && method324((i1 + 128) - 1, vertexHeights[i][j + 1][k] - l, j1 + 1) && method324((i1 + 128) - 1, vertexHeights[i][j + 1][k + 1] - l, (j1 + 128) - 1) && method324(i1 + 1, vertexHeights[i][j][k + 1] - l, (j1 + 128) - 1);
    }

    private boolean method323(int i, int j, int k, int l, int i1, int j1)
    {
        if(j == k && l == i1)
        {
            if(!method320(i, j, l))
                return false;
            int k1 = j << 7;
            int i2 = l << 7;
            return method324(k1 + 1, vertexHeights[i][j][l] - j1, i2 + 1) && method324((k1 + 128) - 1, vertexHeights[i][j + 1][l] - j1, i2 + 1) && method324((k1 + 128) - 1, vertexHeights[i][j + 1][l + 1] - j1, (i2 + 128) - 1) && method324(k1 + 1, vertexHeights[i][j][l + 1] - j1, (i2 + 128) - 1);
        }
        for(int l1 = j; l1 <= k; l1++)
        {
            for(int j2 = l; j2 <= i1; j2++)
                if(anIntArrayArrayArray445[i][l1][j2] == -anInt448)
                    return false;

        }

        int k2 = (j << 7) + 1;
        int l2 = (l << 7) + 2;
        int i3 = vertexHeights[i][j][l] - j1;
        if(!method324(k2, i3, l2))
            return false;
        int j3 = (k << 7) - 1;
        if(!method324(j3, i3, l2))
            return false;
        int k3 = (i1 << 7) - 1;
        if(!method324(k2, i3, k3))
            return false;
        return method324(j3, i3, k3);
    }

    private boolean method324(int i, int j, int k)
    {
        for(int l = 0; l < processedCullingClustersPointer; l++)
        {
            CullingCluster cullingCluster = processedCullingClusters[l];
            if(cullingCluster.tileDistanceEnum == 1)
            {
                int i1 = cullingCluster.worldStartX - i;
                if(i1 > 0)
                {
                    int j2 = cullingCluster.worldStartY + (cullingCluster.worldDistanceFromCameraStartY * i1 >> 8);
                    int k3 = cullingCluster.worldEndY + (cullingCluster.worldDistanceFromCameraEndY * i1 >> 8);
                    int l4 = cullingCluster.worldEndZ + (cullingCluster.worldDistanceFromCameraStartZ * i1 >> 8);
                    int i6 = cullingCluster.worldStartZ + (cullingCluster.worldDistanceFromCameraEndZ * i1 >> 8);
                    if(k >= j2 && k <= k3 && j >= l4 && j <= i6)
                        return true;
                }
            } else
            if(cullingCluster.tileDistanceEnum == 2)
            {
                int j1 = i - cullingCluster.worldStartX;
                if(j1 > 0)
                {
                    int k2 = cullingCluster.worldStartY + (cullingCluster.worldDistanceFromCameraStartY * j1 >> 8);
                    int l3 = cullingCluster.worldEndY + (cullingCluster.worldDistanceFromCameraEndY * j1 >> 8);
                    int i5 = cullingCluster.worldEndZ + (cullingCluster.worldDistanceFromCameraStartZ * j1 >> 8);
                    int j6 = cullingCluster.worldStartZ + (cullingCluster.worldDistanceFromCameraEndZ * j1 >> 8);
                    if(k >= k2 && k <= l3 && j >= i5 && j <= j6)
                        return true;
                }
            } else
            if(cullingCluster.tileDistanceEnum == 3)
            {
                int k1 = cullingCluster.worldStartY - k;
                if(k1 > 0)
                {
                    int l2 = cullingCluster.worldStartX + (cullingCluster.worldDistanceFromCameraStartX * k1 >> 8);
                    int i4 = cullingCluster.worldEndX + (cullingCluster.worldDistanceFromCameraEndX * k1 >> 8);
                    int j5 = cullingCluster.worldEndZ + (cullingCluster.worldDistanceFromCameraStartZ * k1 >> 8);
                    int k6 = cullingCluster.worldStartZ + (cullingCluster.worldDistanceFromCameraEndZ * k1 >> 8);
                    if(i >= l2 && i <= i4 && j >= j5 && j <= k6)
                        return true;
                }
            } else
            if(cullingCluster.tileDistanceEnum == 4)
            {
                int l1 = k - cullingCluster.worldStartY;
                if(l1 > 0)
                {
                    int i3 = cullingCluster.worldStartX + (cullingCluster.worldDistanceFromCameraStartX * l1 >> 8);
                    int j4 = cullingCluster.worldEndX + (cullingCluster.worldDistanceFromCameraEndX * l1 >> 8);
                    int k5 = cullingCluster.worldEndZ + (cullingCluster.worldDistanceFromCameraStartZ * l1 >> 8);
                    int l6 = cullingCluster.worldStartZ + (cullingCluster.worldDistanceFromCameraEndZ * l1 >> 8);
                    if(i >= i3 && i <= j4 && j >= k5 && j <= l6)
                        return true;
                }
            } else
            if(cullingCluster.tileDistanceEnum == 5)
            {
                int i2 = j - cullingCluster.worldEndZ;
                if(i2 > 0)
                {
                    int j3 = cullingCluster.worldStartX + (cullingCluster.worldDistanceFromCameraStartX * i2 >> 8);
                    int k4 = cullingCluster.worldEndX + (cullingCluster.worldDistanceFromCameraEndX * i2 >> 8);
                    int l5 = cullingCluster.worldStartY + (cullingCluster.worldDistanceFromCameraStartY * i2 >> 8);
                    int i7 = cullingCluster.worldEndY + (cullingCluster.worldDistanceFromCameraEndY * i2 >> 8);
                    if(i >= j3 && i <= k4 && k >= l5 && k <= i7)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean aBoolean429;
    private int anInt430;
    private static int anInt431 = 360;
    private static int anInt432 = 1;
    private static int anInt433 = -460;
    private boolean aBoolean434;
    private boolean aBoolean435;
    public static boolean lowMem = true;
    int mapSizeZ;
    int mapSizeX;
    int mapSizeY;
    int[][][] vertexHeights;
    Tile[][][] tileArray;
    int currentPositionZ;
    int interactiveObjectCacheCurrentPos;
    InteractiveObject[] interactiveObjectCache;
    int[][][] anIntArrayArrayArray445;
    static int anInt446;
    static int plane;
    static int anInt448;
    static int currentPositionX;
    static int mapBoundsX;
    static int currentPositionY;
    static int mapBoundsY;
    static int cameraPositionTileX;
    static int cameraPositionTileY;
    static int cameraPosX;
    static int cameraPosZ;
    static int cameraPosY;
    static int curveSineY;
    static int curveCosineY;
    static int curveSineX;
    static int curveCosineX;
    static InteractiveObject[] interactiveObjects = new InteractiveObject[100];
    static final int[] faceOffsetX2 = {
        53, -53, -53, 53
    };
    static final int[] faceOffsetY2 = {
        -53, -53, 53, 53
    };
    static final int[] faceOffsetX3 = {
        -45, 45, 45, -45
    };
    static final int[] faceOffsetY3 = {
        45, 45, -45, -45
    };
    static boolean clicked;
    static int clickX;
    static int clickY;
    public static int clickedTileX = -1;
    public static int clickedTileY = -1;
    static int anInt472;
    static int[] cullingClusterPointer;
    static CullingCluster[][] cullingClusters;
    public static int processedCullingClustersPointer;
    static CullingCluster[] processedCullingClusters = new CullingCluster[500];
    static DoubleEndedQueue tileList = new DoubleEndedQueue(169);
    static final int[] anIntArray478 = {
        19, 55, 38, 155, 255, 110, 137, 205, 76
    };
    static final int[] anIntArray479 = {
        160, 192, 80, 96, 0, 144, 80, 48, 160
    };
    static final int[] anIntArray480 = {
        76, 8, 137, 4, 0, 1, 38, 2, 19
    };
    static final int[] anIntArray481 = {
        0, 0, 2, 0, 0, 2, 1, 1, 0
    };
    static final int[] anIntArray482 = {
        2, 0, 0, 2, 0, 0, 0, 4, 4
    };
    static final int[] anIntArray483 = {
        0, 4, 4, 8, 0, 0, 8, 0, 0
    };
    static final int[] anIntArray484 = {
        1, 1, 0, 0, 0, 8, 0, 0, 8
    };
    static final int[] textureRGB = {
        41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 
        41, 41, 41, 41, 41, 43086, 41, 41, 41, 41, 
        41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 
        41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41, 
        41, 41, 41, 41, 41, 41, 3131, 41, 41, 41
    };
    int[] anIntArray486;
    int[] anIntArray487;
    int anInt488;
    int[][] tileShapePoints = {
        new int[16], {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1, 1
        }, {
            1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 
            1, 0, 1, 1, 1, 1
        }, {
            1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 
            0, 0, 1, 0, 0, 0
        }, {
            0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 
            0, 1, 0, 0, 0, 1
        }, {
            0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 
            1, 1, 1, 1, 1, 1
        }, {
            1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 
            1, 1, 1, 1, 1, 1
        }, {
            1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 
            0, 0, 1, 1, 0, 0
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 
            0, 0, 1, 1, 0, 0
        }, {
            1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 
            1, 1, 0, 0, 1, 1
        }, 
        {
            1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 
            0, 0, 1, 0, 0, 0
        }, {
            0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 
            1, 1, 0, 1, 1, 1
        }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
            1, 0, 1, 1, 1, 1
        }
    };
    int[][] tileShapeIndices = {
        {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
            10, 11, 12, 13, 14, 15
        }, {
            12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 
            6, 2, 15, 11, 7, 3
        }, {
            15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 
            5, 4, 3, 2, 1, 0
        }, {
            3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 
            9, 13, 0, 4, 8, 12
        }
    };
    static boolean[][][][] TILE_VISIBILITY_MAPS = new boolean[8][32][(MAX_FAR_Z * 2) + 1][(MAX_FAR_Z * 2) + 1];
    static boolean[][] TILE_VISIBILITY_MAP;
    static int midX;
    static int midY;
    static int left;
    static int top;
    static int right;
    static int bottom;

    static 
    {
        anInt472 = 4;
        cullingClusterPointer = new int[anInt472];
        cullingClusters = new CullingCluster[anInt472][500];
    }
}
