public class OnDemandData extends Node_Sub2
{

    public OnDemandData()
    {
        incomplete = true;
    }

    int dataType;
    byte buffer[];
    public int retryCount = 0;
    int ID;
    boolean incomplete;
    int loopCycle;
}
