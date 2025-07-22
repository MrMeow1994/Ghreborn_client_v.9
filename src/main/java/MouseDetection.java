public class MouseDetection
    implements Runnable
{

    public void run() {
        while(running) {
            synchronized(syncObject) {
                if(coordsIndex < 500) {
                    coordsX[coordsIndex] = aClient805.mouseX;
                    coordsY[coordsIndex] = aClient805.mouseY;
                    coordsIndex++;
                }
            }
            try {
                Thread.sleep(50L);
            } catch(Exception _ex) {

            }
        }
    }

    public MouseDetection(client client1)
    {
        syncObject = new Object();
        coordsY = new int[500];
        running = true;
        coordsX = new int[500];
        aClient805 = client1;
    }

    public client aClient805;
    public Object syncObject;
    public int coordsY[];
    public boolean running;
    public int coordsX[];
    public int coordsIndex;
}
