import java.io.*;
import java.util.Arrays;

public class AnimationDefinition
{

    public static void load(FileArchive fileArchive)
    {
        Stream stream = new Stream(fileArchive.method571("seq.dat"));
        anInt350 = stream.readUnsignedShort();
        if(anims == null)
            anims = new AnimationDefinition[anInt350];
        for(int j = 0; j < anInt350; j++) {
            if(anims[j] == null)
                anims[j] = new AnimationDefinition();
            anims[j].method259(stream);
            switch(j){
                case 1066:
                    anims[j].soundEffects = new int[] { 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438 };
                    break;
                case 1067:
                    anims[j].soundEffects = new int[] { 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438 };
                    break;
                case 1068:
                    anims[j].soundEffects = new int[] { 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438 };
                    break;
                case 1069:
                    anims[j].soundEffects = new int[] { 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438, 287, 434, 435, 436, 437, 438 };
                    break;
            }
        }
        int withSound = 0;
        for (int i = 0; i < anims.length; i++) {
            if (anims[i].soundEffects != null) {
                withSound++;
            }
        }
        System.out.println("Animations with sound effects: " + withSound);
        if (Configuration.dumpAnimationData) {
            System.out.println("Dumping animation lengths..");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./temp/animation_lengths.cfg"))) {
                for (int j = 0; j < anInt350; j++) {
                    if (anims[j].frame_durations != null && anims[j].frame_durations.length > 0) {
                        int sum = 0;
                        for (int i2 = 0; i2 < anims[j].frame_durations.length; i2++) {
                            if (anims[j].frame_durations[i2] < 100) {
                                sum += anims[j].frame_durations[i2];
                            }
                        }
                        writer.write(j + ":" + sum);
                        writer.newLine();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void dumpValues(int length) {
        System.out.println("Dumping Animations..");
        String[] variablesNames = new String[]{"frameCount", "frameIDs", "frameIDs2", "delays", "loopDelay", "animationFlowControl", "oneSquareAnimation", "forcedPriority", "leftHandItem", "rightHandItem", "frameStep", "resetWhenWalk", "priority", "delayType"};
        File f = new File("anims.txt");

        try {
           f.createNewFile();
           BufferedWriter var21 = new BufferedWriter(new FileWriter(f));

           for(int j = 0; j < length; ++j) {
              String frameCount = String.valueOf(anims[j].frameCount);
              String frameIDs = Arrays.toString(anims[j].frames);
              String frameIDs2 = Arrays.toString(anims[j].secondaryFrames);
              String delays = Arrays.toString(anims[j].frame_durations);
              String loopDelay = String.valueOf(anims[j].anInt356);
              String animationFlowControl = Arrays.toString(anims[j].anIntArray357);
              String oneSquareAnimation = String.valueOf(anims[j].anInt359);
              String forcedPriority = String.valueOf(anims[j].leftHandItem);
              String leftHandItem = String.valueOf(anims[j].rightHandItem);
              String rightHandItem = String.valueOf(anims[j].anInt362);
              String frameStep = String.valueOf(anims[j].anInt363);
              String resetWhenWalk = String.valueOf(anims[j].anInt364);
              String priority = String.valueOf(anims[j].replayMode);
              String delayType = String.valueOf(anims[j].anInt366);
              String[] variables = new String[]{frameCount, frameIDs, frameIDs2, delays, loopDelay, animationFlowControl, oneSquareAnimation, forcedPriority, leftHandItem, rightHandItem, frameStep, resetWhenWalk, priority, delayType};
              var21.write("if (j == " + j + ") {\n");

              for(int k = 0; k < variables.length; ++k) {
                 var21.write("aClass20Array351[ " + j + "]." + variablesNames[k] + " = " + variables[k] + ";\n");
              }

              var21.write("}\n\n");
           }

           var21.close();
        } catch (IOException var211) {
           var211.printStackTrace();
        }

        System.out.println("Dumping Complete!");
     }
    public int method258(int i, byte byte0)
    {
        int j = frame_durations[i];
        if(byte0 != -39)
        {
            for(int k = 1; k > 0; k++);
        }
        if(j == 0)
        {
            FrameLoader frameLoader = FrameLoader.method531(anInt348, frames[i]);
            if(frameLoader != null)
                j = frame_durations[i] = frameLoader.anInt636;
        }
        if(j == 0)
            j = 1;
        return j;
    }

	public void  method259(Stream stream)
	{
		do {
			int i = stream.readUnsignedByte();
			if(i == 0)
				break;
			if(i == 1) {
                frameCount = stream.readUnsignedShort();
                frames = new int[frameCount];
                secondaryFrames = new int[frameCount];
                frame_durations = new int[frameCount];
				for(int i_ = 0; i_ < frameCount; i_++){
					frames[i_] = stream.readDWord();
					secondaryFrames[i_] = -1;
				}
				for(int i_ = 0; i_ < frameCount; i_++)
					frame_durations[i_] = stream.readUnsignedByte();
			}
			else if(i == 2)
				anInt356 = stream.readUnsignedShort();
			else if(i == 3) {
				int k = stream.readUnsignedByte();
				anIntArray357 = new int[k + 1];
				for(int l = 0; l < k; l++)
					anIntArray357[l] = stream.readUnsignedByte();
				anIntArray357[k] = 0x98967f;
			}
			else if(i == 4)
				aBoolean358 = true;
			else if(i == 5)
				anInt359 = stream.readUnsignedByte();
			else if(i == 6)
                leftHandItem = stream.readUnsignedShort() ;
			else if(i == 7)
                rightHandItem = stream.readUnsignedShort();
			else if(i == 8)
				anInt362 = stream.readUnsignedByte();
			else if(i == 9)
				anInt363 = stream.readUnsignedByte();
			else if(i == 10)
				anInt364 = stream.readUnsignedByte();
			else if(i == 11) {
                replayMode = stream.readUnsignedByte();
            }

            else
                System.out.println("Unrecognized seq.dat config code: "+i);
		} while(true);
		if(frameCount == 0)
		{
			frameCount = 1;
			frames = new int[1];
			frames[0] = -1;
			secondaryFrames = new int[1];
			secondaryFrames[0] = -1;
			frame_durations = new int[1];
			frame_durations[0] = -1;
		}
		if(anInt363 == -1)
			if(anIntArray357 != null)
				anInt363 = 2;
			else
				anInt363 = 0;
		if(anInt364 == -1)
		{
			if(anIntArray357 != null)
			{
				anInt364 = 2;
				return;
			}
			anInt364 = 0;
		}
	}

    public AnimationDefinition()
    {
        anInt348 = 9;
        aBoolean349 = false;
        anInt356 = -1;
        aBoolean358 = false;
        anInt359 = 5;
        leftHandItem = -1;
        rightHandItem = -1;
        anInt362 = 99;
        anInt363 = -1;
        anInt364 = -1;
        replayMode = 2;
    }
    private int anInt348;
    private boolean aBoolean349;
    public static int anInt350;
    public static AnimationDefinition anims[];
    public int frameCount;
    public int frames[];
    public int secondaryFrames[];
    private int frame_durations[];
    public int anInt356;
    public int anIntArray357[];
    public boolean aBoolean358;
    public int anInt359;
    public int leftHandItem;
    public int rightHandItem;
    public int anInt362;
    public int anInt363;
    public int anInt364;
    public int replayMode;
    int[] chatFrameIds;
    public int[] soundEffectFrame;
    public int[] soundEffectId;
    public int[] soundEffectDelay;
    public int[] soundEffects;
    public int anInt366;
    public static int anInt367;
}