import java.io.*;
import java.util.stream.IntStream;

public final class ObjectDefinition {

	private short[] default_texture_id, new_texture_id;
	private byte[] aByteArray1422;
	private int[] bgsounds;
	private int hillskewType = 0;
	private short hillskewAmount = -1;
	private int bgsound = -1;
	private int bgsoundrange = 0;
	private int bgsoundmin= 0;
	private boolean render = false;
	private int bgsoundmax = 0;
	boolean hasanimation = false;
	private boolean mapSceneRotated = false;
	private boolean aBoolean211 = false;
	private boolean castshadow = true;
	private boolean allowrandomizedanimation = true;
	private short[] retex_d;
	private short[] retex_s;
	private byte[] recol_p;
	private boolean members = false;
	private boolean aBoolean214 = false;
	private int cursor1Op = -1;
	private int cursor1 = -1;

	public static ObjectDefinition forID(int i) {
		if (i > anIntArray755.length)
			i = anIntArray755.length - 1;
		for (int j = 0; j < 20; j++)
			if (aObjectDefinitionArray782[j].type == i)
				return aObjectDefinitionArray782[j];
		anInt771 = (anInt771 + 1) % 20;
		ObjectDefinition objectDefinition = aObjectDefinitionArray782[anInt771];
		try {
			aStream_753.currentPosition = anIntArray755[i];
		} catch(Exception e) {}
		objectDefinition.type = i;
		objectDefinition.method573();
		objectDefinition.method582(false, aStream_753);

        return objectDefinition;
    }

			public static void dumpObjectcfg() {
	for(int i = 0; i < 45000; i++) {
	ObjectDefinition objectDefinition = forID(i);
	BufferedWriter bw = null;
	try {
	bw = new BufferedWriter(new FileWriter("object.cfg", true));
	if(objectDefinition.aString739!= null) {
	bw.write("ObjectId = "+i+"\t\t"+ objectDefinition.aString739);
	bw.newLine();
	bw.flush();
	bw.close();
	}
	} catch (IOException ioe2) {
	}
	}
}

	public void method573() {
		anIntArray773 = null;
		anIntArray776 = null;
		aString739 = null;
		aByteArray777 = null;
		anIntArray784 = null;
		anIntArray747 = null;
		anInt744 = 1;
		anInt761 = 1;
		aBoolean767 = true;
		aBoolean757 = true;
		hasactions = false;//hasactions
		aBoolean762 = false;
		aBoolean769 = false;
		aBoolean764 = false;
		anInt781 = -1;
		anInt775 = 16;
		aByte737 = 0;
		aByte742 = 0;
		default_texture_id = null;
		new_texture_id = null;
		aStringArray786 = null;
		anInt746 = -1;
		anInt758 = -1;
		aBoolean751 = false;
		aBoolean779 = true;
		anInt748 = 128;
		anInt772 = 128;
		anInt740 = 128;
		anInt768 = 0;
		anInt738 = 0;
		anInt745 = 0;
		anInt783 = 0;
		aBoolean736 = false;
		aBoolean766 = false;
		anInt760 = -1;
		anInt774 = -1;
		anInt749 = -1;
		childrenIDs = null;
	}

	public void method574(OnDemandFetcher onDemandFetcher, int luls) {
		if (anIntArray773 == null)
			return;
		for (int j = 0; j < anIntArray773.length; j++)
			onDemandFetcher.method560(anIntArray773[j] & 0xffff, 0, false);
	}

	public static void method575(int i) {
		aClass12_785 = null;
		aClass12_780 = null;
		anIntArray755 = null;
		aObjectDefinitionArray782 = null;
		aStream_753 = null;
	}

	public static void load(FileArchive class30_sub2_sub2Loader) {
        aStream_753 = new Stream(class30_sub2_sub2Loader.method571("loc.dat"), 891);
        Stream stream = new Stream(class30_sub2_sub2Loader.method571("loc.idx"), 891);
		int anInt756 = stream.readUnsignedShort();
		System.out.println("508 Object Amount: " + anInt756);
		anIntArray755 = new int[anInt756];
		int i = 2;
		for (int j = 0; j < anInt756; j++) {
			anIntArray755[j] = i;
			i += stream.readUnsignedShort();
		}
		aObjectDefinitionArray782 = new ObjectDefinition[20];
		for (int k = 0; k < 20; k++)
			aObjectDefinitionArray782[k] = new ObjectDefinition();
		if (Configuration.dumpDataLists) {

			TempWriter writer2 = new TempWriter("Object_fields");
			FieldGenerator generator = new FieldGenerator(writer2::writeLine);
			IntStream.range(0, 100_000).forEach(id -> {
				try {
					ObjectDefinition definition = ObjectDefinition.forID(id);
					generator.add(definition.aString739, id);
				} catch (Exception e) {}
			});
			writer2.close();
		}
	}

	public boolean method577(int i, boolean gfgfg) {
		if (anIntArray776 == null) {
			if (anIntArray773 == null)
				return true;
			if (i != 10)
				return true;
			boolean flag1 = true;
			for (int k = 0; k < anIntArray773.length; k++)
				flag1 &= Model.method463(anIntArray773[k] & 0xffff);

			return flag1;
		}
		for (int j = 0; j < anIntArray776.length; j++)
			if (anIntArray776[j] == i)
				return Model.method463(anIntArray773[j] & 0xffff);

		return true;
	}

	public Model method578(int i, int j, int k, int l, int i1, int j1, int k1) {
		Model model = method581(0, i, k1, j);
		if (model == null)
			return null;
		if (aBoolean762 || aBoolean769)
			model = new Model(aBoolean762, -819, aBoolean769, model);
		if (aBoolean762) {
			int l1 = (k + l + i1 + j1) / 4;
			for (int i2 = 0; i2 < model.vertexCount; i2++) {
				int j2 = model.verticesX[i2];
				int k2 = model.verticesZ[i2];
				int l2 = k + ((l - k) * (j2 + 64)) / 128;
				int i3 = j1 + ((i1 - j1) * (j2 + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
				model.verticesY[i2] += j3 - l1;
			}
			model.method467(false);
		}
		return model;
	}

	public boolean method579(boolean lolz) {
		if (anIntArray773 == null)
			return true;
		boolean flag1 = true;
		for (int i = 0; i < anIntArray773.length; i++)
			flag1 &= Model.method463(anIntArray773[i] & 0xffff);
		return flag1;
	}

	public ObjectDefinition method580(boolean lolz) {
		int i = -1;
		if(anInt774 != -1)
		{
			VarBit varBit = VarBit.cache[anInt774];
			int j = varBit.anInt648;
			int k = varBit.anInt649;
			int l = varBit.anInt650;
			int i1 = client.anIntArray1232[l - k];
			i = clientInstance.variousSettings[j] >> k & i1;
		} else
		if(anInt749 != -1)
			i = clientInstance.variousSettings[anInt749];

		int var;

		if (i >= 0 && i < childrenIDs.length) {
			var = childrenIDs[i];
		} else
			var = childrenIDs[childrenIDs.length - 1];

		return var != -1 ? forID(var) : null;
	}

	public Model method581(int i, int j, int k, int l) {
		Model model = null;
		long l1;
		if (anIntArray776 == null) {
			if (j != 10)
				return null;
			l1 = (long)((type << 6) + l) + ((long)(k + 1) << 32);
			Model model_1 = (Model) aClass12_780.method222(l1);
			if (model_1 != null)
				return model_1;
			if (anIntArray773 == null)
				return null;
			boolean flag1 = aBoolean751 ^ (l > 3);
			int k1 = anIntArray773.length;
			for (int i2 = 0; i2 < k1; i2++) {
				int l2 = anIntArray773[i2];
				if (flag1)
					l2 += 0x10000;
				model = (Model) aClass12_785.method222(l2);
				if (model == null) {
					model = Model.method462(anInt770, l2 & 0xffff);
					if (model == null)
						return null;
					if (flag1)
						model.method477(0);
					aClass12_785.method223(model, l2, (byte)2);
				}
				if (k1 > 1)
					A_MODEL_ARRAY_741[i2] = model;
			}

			if (k1 > 1)
				model = new Model(k1, A_MODEL_ARRAY_741, -38);
		} else {
			int i1 = -1;
			for (int j1 = 0; j1 < anIntArray776.length; j1++) {
				if (anIntArray776[j1] != j)
					continue;
				i1 = j1;
				break;
			}

			if (i1 == -1)
				return null;
			l1 = (long)((type << 8) + (i1 << 3) + l) + ((long)(k + 1) << 32);
			Model model_2 = (Model) aClass12_780.method222(l1);
			if (model_2 != null)
				return model_2;
			int j2 = anIntArray773[i1];
			boolean flag3 = aBoolean751 ^ (l > 3);
			if (flag3)
				j2 += 0x10000;
			model = (Model) aClass12_785.method222(j2);
			if (model == null) {
				model = Model.method462(anInt770, j2 & 0xffff);
				if (model == null)
					return null;
				if (flag3)
					model.method477(0);
				aClass12_785.method223(model, j2, (byte)2);
			}
		}
		boolean flag;
		flag = anInt748 != 128 || anInt772 != 128 || anInt740 != 128;
		boolean flag2;
		flag2 = anInt738 != 0 || anInt745 != 0 || anInt783 != 0;
		Model model_3 = new Model(9, anIntArray784 == null, Class36
				.method532(k, false), l == 0 && k == -1 && !flag && !flag2, model);
		if (k != -1) {
			model_3.method469((byte)-71);
			model_3.method470(k, 40542);
			model_3.anIntArrayArray1658 = null;
			model_3.anIntArrayArray1657 = null;
		}
		while (l-- > 0)
			model_3.method473(360);
		if (anIntArray784 != null) {
			for (int k2 = 0; k2 < anIntArray784.length; k2++)
				model_3.method476(anIntArray784[k2],
						anIntArray747[k2]);

		}
		if (flag)
			model_3.method478(anInt748, anInt740, anInt743, anInt772);
		if (flag2)
			model_3.method475(anInt738, anInt745, 16384, anInt783);
		model_3.method479(64 + aByte737, 768 + aByte742, -50, -10, -50,
				!aBoolean769);
		if (anInt760 == 1)
			model_3.anInt1654 = model_3.anInt1426;
		aClass12_780.method223(model_3, l1, (byte)2);
		return model_3;
	}

	private void method582(boolean hurr, Stream stream) {
		while (true) {
			int j = stream.readUnsignedByte();
			if (j == 0) {
				break;
			} else if (j == 1) {
					int k = stream.readUnsignedByte();
					if (k > 0)
						if (anIntArray773 == null) {
							anIntArray776 = new int[k];
							anIntArray773 = new int[k];
							for (int k1 = 0; k1 < k; k1++) {
								anIntArray773[k1] = stream.readUnsignedShort();
								anIntArray776[k1] = stream.readUnsignedByte();
							}
						} else {
							stream.currentPosition += k * 3;
						}
				} else if (j == 2)
					aString739 = stream.readString();
				else if (j == 5) {
					int l = stream.readUnsignedByte();
					if (l > 0)
						if (anIntArray773 == null) {
							anIntArray773 = new int[l];
							anIntArray776 = null;
							for (int l1 = 0; l1 < l; l1++) {
								anIntArray773[l1] = stream.readUnsignedShort();
							}
						} else {
							stream.currentPosition += l * 2;
						}
				} else if (j == 14)
					anInt744 = stream.readUnsignedByte();
				else if (j == 15)
					anInt761 = stream.readUnsignedByte();
				else if (j == 17)
					aBoolean767 = false;
				else if (j == 18)
					aBoolean757 = false;
				else if (j == 19) {
					int i = stream.readUnsignedByte();
					if (i == 1)
						hasactions = true;
				} else if (j == 21)
					aBoolean762 = true;
				else if (j == 22)
					aBoolean769 = false; // change to false to fix gowwars waterfalls??
				else if (j == 23)
					aBoolean764 = true;
				else if (j == 24) {
					anInt781 = stream.readUnsignedShort();
					if (anInt781 == 65535)
						anInt781 = -1;
				} else if (j == 27){
				aBoolean757 = true;
				} else if (j == 28)
					anInt775 = stream.readUnsignedByte();
				else if (j == 29)
					aByte737 = stream.readSignedByte();
				else if (j == 39)
					aByte742 = (byte) (stream.readSignedByte() * 25);
				else if (j >= 30 && j < 35) {
					if (aStringArray786 == null)
						aStringArray786 = new String[10];
					aStringArray786[j - 30] = stream.readString();
					if (aStringArray786[j - 30].equalsIgnoreCase("hidden"))
						aStringArray786[j - 30] = null;
				} else if (j == 40) {
					int i1 = stream.readUnsignedByte();
					anIntArray784 = new int[i1];
					anIntArray747 = new int[i1];
					for (int i2 = 0; i2 < i1; i2++) {
						anIntArray784[i2] = stream.readUnsignedShort();
						anIntArray747[i2] = stream.readUnsignedShort();
					}
			} else if (j == 41) {
				int count = stream.readUnsignedByte();
				this.retex_d = new short[count];
				this.retex_s = new short[count];
				for (int len = 0; len < count; len++) {
					this.retex_s[len] = (short) stream.readUnsignedShort();
					this.retex_d[len] = (short) stream.readUnsignedShort();
				}
			} else if (j == 42) {
				int count = stream.readUnsignedByte();
				this.recol_p = new byte[count];
				for (int len = 0; len < count; len++) {
					this.recol_p[len] = stream.readSignedByte();
				}
				} else if (j == 60)
					anInt746 = stream.readUnsignedShort();
				else if (j == 62)
					aBoolean751 = true;
				else if (j == 64)
					aBoolean779 = false;
				else if (j == 65)
					anInt748 = stream.readUnsignedShort();
				else if (j == 66)
					anInt772 = stream.readUnsignedShort();
				else if (j == 67)
					anInt740 = stream.readUnsignedShort();
		 		else if (j == 68)
					this.anInt758 = stream.readUnsignedShort();
				else if (j == 69)
					anInt768 = stream.readUnsignedByte();
				else if (j == 70)
					anInt738 = stream.readUnsignedShort();
				else if (j == 71)
					anInt745 = stream.readUnsignedShort();
				else if (j == 72)
					anInt783 = stream.readUnsignedShort();
				else if (j == 73)
					aBoolean736 = true;
				else if (j == 74) {
					aBoolean766 = true;
				} else if (j == 75) {
					anInt760 = stream.readUnsignedByte();
				} else if (j == 77 || j == 92) {
					anInt774 = stream.readUnsignedShort();
					if (anInt774 == 65535)
						anInt774 = -1;
					anInt749 = stream.readUnsignedShort();
					if (anInt749 == 65535)
						anInt749 = -1;

					int var3 = -1;
					if (j == 92) {
						var3 = stream.readUnsignedShort();

						if (var3 == 65535)
							var3 = -1;
					}

					int j1 = stream.readUnsignedByte();
					childrenIDs = new int[j1 + 2];
					for (int j2 = 0; j2 <= j1; j2++) {
						childrenIDs[j2] = stream.readUnsignedShort();
						if (childrenIDs[j2] == 65535)
							childrenIDs[j2] = -1;
					}
					childrenIDs[j1 + 1] = var3;
			} else if (j == 78) {
				this.bgsound = stream.readUnsignedShort();
				this.bgsoundrange = stream.readUnsignedByte();
			} else if (j == 79) {
				this.bgsoundmin = stream.readUnsignedShort(); // interval
				this.bgsoundmax = stream.readUnsignedShort(); // interval
				this.bgsoundrange = stream.readUnsignedByte();

				int count = stream.readUnsignedByte();
				this.bgsounds = new int[count];
				for (int len = 0; len < count; len++) {
					this.bgsounds[len] = stream.readUnsignedShort();
				}
			} else if (j == 81) {
				this.hillskewType = 2;
				this.hillskewAmount = (short) (stream.readUnsignedByte() * 256);
			} else if (j == 82) {
				this.render = true;
			} else if (j == 88) {
				this.castshadow = false;
			} else if (j == 89) {
				this.allowrandomizedanimation = false;
			} else if (j == 90) {
				this.aBoolean211 = true;
			} else if (j == 91) {
				this.members = true;
			} else if (j == 93) {
				this.hillskewType = 3;
				this.hillskewAmount = (short) stream.readUnsignedShort();
			} else if (j == 94) {
				this.hillskewType = 4;
			} else if (j == 95) {
				this.hillskewType = 5;
			} else if (j == 96) {
				this.hasanimation = true;
			} else if (j == 97) {
				this.mapSceneRotated = true;
			} else if (j == 98) {
				this.aBoolean214 = true;
			} else if (j == 99) {
				this.cursor1Op = stream.readUnsignedByte();
				this.cursor1 = stream.readUnsignedShort();
			} else if (j == 100) {
				stream.readUnsignedByte();
				 stream.readUnsignedShort();
			} else if (j == 101) {
				stream.readUnsignedByte();
			} else if (j == 102) {
				 stream.readUnsignedShort();
				}

		}
		if (aString739 != null && !aString739.equals("null")) {
			hasactions = anIntArray773 != null && (anIntArray776 == null || anIntArray776[0] == 10);
			if (aStringArray786 != null)
				hasactions = true;
		}
		if (aBoolean766) {
			aBoolean767 = false;
			aBoolean757 = false;
		}
		if (anInt760 == -1)
			anInt760 = aBoolean767 ? 1 : 0;
	}

	public ObjectDefinition() {
		type = -1;
	}

	public boolean aBoolean736;
	public byte aByte737;
	public int anInt738;
	public String aString739;
	public int anInt740;
	public static final Model[] A_MODEL_ARRAY_741 = new Model[4];
	public byte aByte742;
	public int anInt744;
	public int anInt745;
	public int anInt746;
	public int[] anIntArray747;
	public int anInt748;
	public int anInt749;
	public boolean aBoolean751;
	public static boolean aBoolean752;
	public static Stream aStream_753;
	public int type;
	public static int[] anIntArray755;
	public boolean aBoolean757;
	public int anInt758;
	public int childrenIDs[];
	public int anInt760;
	public int anInt761;
	public boolean aBoolean762;
	public boolean aBoolean764;
	public static client clientInstance;
	public boolean aBoolean766;
	public boolean aBoolean767;
	public int anInt768;
	public boolean aBoolean769;
	public static int anInt771;
	public int anInt772;
	public int[] anIntArray773;
	public int anInt774;
	public int anInt775;
	public int dummy;
	public int[] anIntArray776;
	public byte aByteArray777[];
	public boolean hasactions;
	public boolean aBoolean779;
	public static Class12 aClass12_780 = new Class12(false, 30);
	public int anInt781;
	public static ObjectDefinition[] aObjectDefinitionArray782;
	public int anInt783;
	public int[] anIntArray784;
	public static Class12 aClass12_785 = new Class12(false, 500);
	public String aStringArray786[];
	public int anInt770;
	public int anInt743;

}