final class ShapedTile
{

    public ShapedTile(int tileZ, int underlaySW, int overlayNW, int heightNE, int overlaytex, int underlaytex, int underlayNE, int rotation,
                      int overlaySW, int i2, int overlayNE, int heightNW, int heightSE, int heightSW, int shape,
                      int underlayNW, int underlaySE, int overlaySE, int j4, int tileX, int l4, boolean tex)
    {
        color61 = overlaySW;
        color71 = overlaySE;
        color81 = overlayNE;
        color91 = overlayNW;
        color62 = underlaySW;
        color72 = underlaySE;
        color82 = underlayNE;
        color92 = underlayNW;
        this.flat = true;
        textured = tex;
        if(heightSW != heightSE || heightSW != heightNE || heightSW != heightNW)
            this.flat = false;
        this.shape = shape;
        this.rotation = rotation;
        this.underlayRGB = i2;
        this.overlayRGB = l4;
        char TILE_WIDTH  = '\200';
        int HALF_TILE = TILE_WIDTH  / 2;
        int QUARTER_TILE = TILE_WIDTH  / 4;
        int THREE_QUARTER_TILE = (TILE_WIDTH  * 3) / 4;
        int shapedTileMesh[] = shapedTilePointData[shape];
        int shapedTileMeshLength = shapedTileMesh.length;
        this.vertexX = new int[shapedTileMeshLength];
        this.vertexY = new int[shapedTileMeshLength];
        this.vertexZ = new int[shapedTileMeshLength];
        int vertexColourOverlay[] = new int[shapedTileMeshLength];
        int vertexColourUnderlay[] = new int[shapedTileMeshLength];
        int tilePosX = tileX * TILE_WIDTH ;
        int tilePosY = tileZ * TILE_WIDTH ;
        for(int vertex = 0; vertex < shapedTileMeshLength; vertex++) {
            int vertexType = shapedTileMesh[vertex];
            if((vertexType & 1) == 0 && vertexType <= 8)
                vertexType = (vertexType - rotation - rotation - 1 & 7) + 1;
            if(vertexType > 8 && vertexType <= 12)
                vertexType = (vertexType - 9 - rotation & 3) + 9;
            if(vertexType > 12 && vertexType <= 16)
                vertexType = (vertexType - 13 - rotation & 3) + 13;
            int vertexX;
            int vertexZ;
            int vertexY;
            int vertexCOverlay;
            int vertexCUnderlay;
            if(vertexType == 1) {
                vertexX = tilePosX;
                vertexZ = tilePosY;
                vertexY = heightSW;
                vertexCOverlay = overlaySW;
                vertexCUnderlay = underlaySW;
            } else if(vertexType == 2) {
                vertexX = tilePosX + HALF_TILE;
                vertexZ = tilePosY;
                vertexY = heightSW + heightSE >> 1;
                vertexCOverlay = overlaySW + overlaySE >> 1;
                vertexCUnderlay = underlaySW + underlaySE >> 1;
            } else if(vertexType == 3) {
                vertexX = tilePosX + TILE_WIDTH ;
                vertexZ = tilePosY;
                vertexY = heightSE;
                vertexCOverlay = overlaySE;
                vertexCUnderlay = underlaySE;
            } else if(vertexType == 4) {
                vertexX = tilePosX + TILE_WIDTH ;
                vertexZ = tilePosY + HALF_TILE;
                vertexY = heightSE + heightNE >> 1;
                vertexCOverlay = overlaySE + overlayNE >> 1;
                vertexCUnderlay = underlaySE + underlayNE >> 1;
            } else if(vertexType == 5) {
                vertexX = tilePosX + TILE_WIDTH ;
                vertexZ = tilePosY + TILE_WIDTH ;
                vertexY = heightNE;
                vertexCOverlay = overlayNE;
                vertexCUnderlay = underlayNE;
            } else if(vertexType == 6) {
                vertexX = tilePosX + HALF_TILE;
                vertexZ = tilePosY + TILE_WIDTH ;
                vertexY = heightNE + heightNW >> 1;
                vertexCOverlay = overlayNE + overlayNW >> 1;
                vertexCUnderlay = underlayNE + underlayNW >> 1;
            } else if(vertexType == 7) {
                vertexX = tilePosX;
                vertexZ = tilePosY + TILE_WIDTH ;
                vertexY = heightNW;
                vertexCOverlay = overlayNW;
                vertexCUnderlay = underlayNW;
            } else if(vertexType == 8) {
                vertexX = tilePosX;
                vertexZ = tilePosY + HALF_TILE;
                vertexY = heightNW + heightSW >> 1;
                vertexCOverlay = overlayNW + overlaySW >> 1;
                vertexCUnderlay = underlayNW + underlaySW >> 1;
            } else if(vertexType == 9) {
                vertexX = tilePosX + HALF_TILE;
                vertexZ = tilePosY + QUARTER_TILE;
                vertexY = heightSW + heightSE >> 1;
                vertexCOverlay = overlaySW + overlaySE >> 1;
                vertexCUnderlay = underlaySW + underlaySE >> 1;
            } else if(vertexType == 10) {
                vertexX = tilePosX + THREE_QUARTER_TILE;
                vertexZ = tilePosY + HALF_TILE;
                vertexY = heightSE + heightNE >> 1;
                vertexCOverlay = overlaySE + overlayNE >> 1;
                vertexCUnderlay = underlaySE + underlayNE >> 1;
            } else if(vertexType == 11) {
                vertexX = tilePosX + HALF_TILE;
                vertexZ = tilePosY + THREE_QUARTER_TILE;
                vertexY = heightNE + heightNW >> 1;
                vertexCOverlay = overlayNE + overlayNW >> 1;
                vertexCUnderlay = underlayNE + underlayNW >> 1;
            } else if(vertexType == 12) {
                vertexX = tilePosX + QUARTER_TILE;
                vertexZ = tilePosY + HALF_TILE;
                vertexY = heightNW + heightSW >> 1;
                vertexCOverlay = overlayNW + overlaySW >> 1;
                vertexCUnderlay = underlayNW + underlaySW >> 1;
            } else if(vertexType == 13) {
                vertexX = tilePosX + QUARTER_TILE;
                vertexZ = tilePosY + QUARTER_TILE;
                vertexY = heightSW;
                vertexCOverlay = overlaySW;
                vertexCUnderlay = underlaySW;
            } else if(vertexType == 14) {
                vertexX = tilePosX + THREE_QUARTER_TILE;
                vertexZ = tilePosY + QUARTER_TILE;
                vertexY = heightSE;
                vertexCOverlay = overlaySE;
                vertexCUnderlay = underlaySE;
            } else if(vertexType == 15) {
                vertexX = tilePosX + THREE_QUARTER_TILE;
                vertexZ = tilePosY + THREE_QUARTER_TILE;
                vertexY = heightNE;
                vertexCOverlay = overlayNE;
                vertexCUnderlay = underlayNE;
            } else {
                vertexX = tilePosX + QUARTER_TILE;
                vertexZ = tilePosY + THREE_QUARTER_TILE;
                vertexY = heightNW;
                vertexCOverlay = overlayNW;
                vertexCUnderlay = underlayNW;
            }
            this.vertexX[vertex] = vertexX;
            this.vertexY[vertex] = vertexY;
            this.vertexZ[vertex] = vertexZ;
            vertexColourOverlay[vertex] = vertexCOverlay;
            vertexColourUnderlay[vertex] = vertexCUnderlay;
        }

        int[] shapedTileElements = shapedTileElementData[shape];
        int vertexCount = shapedTileElements.length / 4;
        this.triangleA = new int[vertexCount];
        this.triangleB = new int[vertexCount];
        this.triangleC = new int[vertexCount];
        this.triangleHSLA = new int[vertexCount];
        this.triangleHSLB = new int[vertexCount];
        this.triangleHSLC = new int[vertexCount];
        if(overlaytex != -1 || underlaytex != -1) {
            this.triangleTexture = new int[vertexCount];
        }
        int offset = 0;
        for(int vertex = 0; vertex < vertexCount; vertex++) {
            int overlayOrUnderlay = shapedTileElements[offset];
            int idxA = shapedTileElements[offset + 1];
            int idxB = shapedTileElements[offset + 2];
            int idxC = shapedTileElements[offset + 3];
            offset += 4;
            if(idxA < 4)
                idxA = idxA - rotation & 3;
            if(idxB < 4)
                idxB = idxB - rotation & 3;
            if(idxC < 4)
                idxC = idxC - rotation & 3;
            this.triangleA[vertex] = idxA;
            this.triangleB[vertex] = idxB;
            this.triangleC[vertex] = idxC;
            if(overlayOrUnderlay == 0) {
                this.triangleHSLA[vertex] = vertexColourOverlay[idxA];
                this.triangleHSLB[vertex] = vertexColourOverlay[idxB];
                this.triangleHSLC[vertex] = vertexColourOverlay[idxC];
                if(this.triangleTexture != null)
                    this.triangleTexture[vertex] = underlaytex;
            } else {
                this.triangleHSLA[vertex] = vertexColourUnderlay[idxA];
                this.triangleHSLB[vertex] = vertexColourUnderlay[idxB];
                this.triangleHSLC[vertex] = vertexColourUnderlay[idxC];
                if(this.triangleTexture != null)
                    this.triangleTexture[vertex] = overlaytex;
            }
        }

        int i9 = heightSW;
        int l9 = heightSE;
        if(heightSE < i9)
            i9 = heightSE;
        if(heightSE > l9)
            l9 = heightSE;
        if(heightNE < i9)
            i9 = heightNE;
        if(heightNE > l9)
            l9 = heightNE;
        if(heightNW < i9)
            i9 = heightNW;
        if(heightNW > l9)
            l9 = heightNW;
        i9 /= 14;
        l9 /= 14;
    }

    int[] vertexX;
    int[] vertexY;
    int[] vertexZ;
    int[] triangleHSLA;
    int[] triangleHSLB;
    int[] triangleHSLC;
    int[] triangleA;
    int[] triangleB;
    int[] triangleC;
    int[] triangleTexture;
    boolean flat;
    int shape;
    int rotation;
    int underlayRGB;
    int overlayRGB;
    static int[] screenX = new int[6];
    static int[] screenY = new int[6];
    static int[] viewspaceX = new int[6];
    static int[] viewspaceY = new int[6];
    static int[] viewspaceZ = new int[6];

    static final int[][] shapedTilePointData = {
        {
            1, 3, 5, 7
        }, {
            1, 3, 5, 7
        }, {
            1, 3, 5, 7
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 6
        }, {
            1, 3, 5, 7, 2, 6
        }, {
            1, 3, 5, 7, 2, 8
        }, {
            1, 3, 5, 7, 2, 8
        }, {
            1, 3, 5, 7, 11, 12
        }, {
            1, 3, 5, 7, 11, 12
        }, {
            1, 3, 5, 7, 13, 14
        }
    };
    static final int[][] shapedTileElementData = {
        {
            0, 1, 2, 3, 0, 0, 1, 3
        }, {
            1, 1, 2, 3, 1, 0, 1, 3
        }, {
            0, 1, 2, 3, 1, 0, 1, 3
        }, {
            0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 
            4, 3
        }, {
            0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 
            2, 4
        }, {
            0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 
            2, 4
        }, {
            0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 
            4, 3
        }, {
            0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 
            4, 5, 1, 0, 5, 3
        }, {
            0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 
            3, 5, 1, 0, 4, 5
        }, {
            0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 
            2, 3, 1, 4, 3, 5
        }, {
            0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 
            2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 
            1, 4, 2, 3
        }, {
            1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 
            2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 
            0, 4, 2, 3
        }, {
            1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 
            4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 
            0, 1, 2, 5
        }
    };
    public int color61;
    public int color71;
    public int color81;
    public int color91;
    public int color62;
    public int color72;
    public int color82;
    public int color92;
    public boolean textured;
}
