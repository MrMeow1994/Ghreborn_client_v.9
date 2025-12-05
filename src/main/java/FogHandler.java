public class FogHandler {    
    /**
     * Grabs distance from player.
     */
    private float fogDistance;
    
    /**
     * Sets the fog color.
     */
    public static int setColor = 0x959698;
    
    /**
     * 
     * @param fogStartDistance
     * @param fogEndDistance
     * @param fogIntensity
     */
    public void renderFog(boolean belowGround, int fogStartDistance, int fogEndDistance, int fogIntensity) {
        getColor(setColor);
        int pos = Rasterizer.lineOffsets[0];
        int src, dst, alpha;
        int fogBegin = (int) (fogStartDistance + fogDistance);
        int fogEnd = (int) (fogEndDistance + fogDistance);
        for (int y = 0; y < DrawingArea.bottomY; y++) {
            for (int x = 0; x < DrawingArea.viewportRX; x++) {
                //if (Class30_Sub2_Sub1.depthBuffer[pos] >= fogEnd) {
                   // Class30_Sub2_Sub1.anIntArray1378[pos] = setColor;
                //} else if (Class30_Sub2_Sub1.depthBuffer[pos] >= fogBegin) {
                    alpha = (int)(DrawingArea.depthBuffer[pos] - fogBegin) / fogIntensity;
                    src = ((setColor & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((setColor & 0xff00) * alpha >> 8 & 0xff00);
                    alpha = 256 - alpha;
                    dst = DrawingArea.pixels[pos];
                    dst = ((dst & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((dst & 0xff00) * alpha >> 8 & 0xff00);
                    DrawingArea.pixels[pos] = src + dst;
                }
                pos++;
            }
            pos += DrawingArea.width - DrawingArea.viewportRX;
        }
   // }
    
    /**
     * 
     * @param fogDistance
     */
    public void setFogDistance(float fogDistance) {
        this.fogDistance = fogDistance;
    }
    
    /**
     * 
     * @param fogColor
     */
    public void getColor(int fogColor) {
        setColor = fogColor;
    }
}