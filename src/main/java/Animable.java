public class Animable extends Node_Sub2
{

    public void renderAtPoint(int i, int j, int k, int l, int i1, int j1, int k1,
                              int l1, long i2)
    {
        Model model = method444(4016);
        if(model != null)
        {
            modelHeight = ((Animable) (model)).modelHeight;
            model.renderAtPoint(i, j, k, l, i1, j1, k1, l1, i2);
        }
    }

    public Model method444(int i)
    {
        if(i != 4016)
            anInt1424 = -185;
        return null;
    }

    public Animable()
    {
        anInt1424 = 923;
        modelHeight = 1000;
    }

    private int anInt1424;
    VertexNormal vertexNormals[];
    public int modelHeight;
    public static boolean aBoolean1427;
}
