public class Model extends Animable {

	public static void nullLoader() {
		aClass21Array1661 = null;
		aBooleanArray1663 = null;
		aBooleanArray1664 = null;
		anIntArray1666 = null;
		anIntArray1667 = null;
		anIntArray1668 = null;
		anIntArray1669 = null;
		anIntArray1670 = null;
		anIntArray1671 = null;
		anIntArrayArray1672 = null;
		anIntArray1673 = null;
		anIntArrayArray1674 = null;
		anIntArray1675 = null;
		anIntArray1676 = null;
		anIntArray1677 = null;
	       	SINE = null;
        	COSINE = null;
        	anIntArray1691 = null;
        	anIntArray1692 = null;
	}


	public void read525Model(byte abyte0[], int modelID) {
		Stream nc1 = new Stream(abyte0);
		Stream nc2 = new Stream(abyte0);
		Stream nc3 = new Stream(abyte0);
		Stream nc4 = new Stream(abyte0);
		Stream nc5 = new Stream(abyte0);
		Stream nc6 = new Stream(abyte0);
		Stream nc7 = new Stream(abyte0);
		nc1.currentPosition = abyte0.length - 23;
		int numVertices = nc1.readUnsignedShort();
		int numTriangles = nc1.readUnsignedShort();
		int numTexTriangles = nc1.readUnsignedByte();
		Class21 ModelDef_1 = aClass21Array1661[modelID] = new Class21();
		ModelDef_1.aByteArray368 = abyte0;
		ModelDef_1.anInt369 = numVertices;
		ModelDef_1.anInt370 = numTriangles;
		ModelDef_1.anInt371 = numTexTriangles;
		int l1 = nc1.readUnsignedByte();
		boolean bool = (0x1 & l1) == 1;
		boolean bool_78_ = (l1 & 0x2) == 2;
		int i2 = nc1.readUnsignedByte();
		int j2 = nc1.readUnsignedByte();
		int k2 = nc1.readUnsignedByte();
		int l2 = nc1.readUnsignedByte();
		int i3 = nc1.readUnsignedByte();
		int j3 = nc1.readUnsignedShort();
		int k3 = nc1.readUnsignedShort();
		int l3 = nc1.readUnsignedShort();
		int i4 = nc1.readUnsignedShort();
		int j4 = nc1.readUnsignedShort();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int v = 0;
		int hb = 0;
		int P = 0;
		byte G = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] ab = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if (numTexTriangles > 0) {
			O = new byte[numTexTriangles];
			nc1.currentPosition = 0;
			for (int j5 = 0; j5 < numTexTriangles; j5++) {
				byte byte0 = O[j5] = nc1.readSignedByte();
				if (byte0 == 0)
					k4++;
				if (byte0 >= 1 && byte0 <= 3)
					l4++;
				if (byte0 == 2)
					i5++;
			}
		}
		int k5 = numTexTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if (l1 == 1)
			k5 += numTriangles;
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if (i2 == 255)
			k5 += numTriangles;
		int l6 = k5;
		if (k2 == 1)
			k5 += numTriangles;
		int i7 = k5;
		if (i3 == 1)
			k5 += numVertices;
		int j7 = k5;
		if (j2 == 1)
			k5 += numTriangles;
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if (l2 == 1)
			k5 += numTriangles * 2;
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int l9 = k5;
		k5 += l4 * 6;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		v = numVertices;
		hb = numTriangles;
		P = numTexTriangles;
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		anIntArray1655 = new int[numVertices];
		triangleDrawType = new int[numTriangles];
		anIntArray1638 = new int[numTriangles];
		anIntArray1639 = new int[numTriangles];
		anIntArray1656 = new int[numTriangles];
		if (i3 == 1)
			anIntArray1655 = new int[numVertices];
		if (bool)
			triangleDrawType = new int[numTriangles];
		if (i2 == 255)
			anIntArray1638 = new int[numTriangles];
		else
			G = (byte) i2;
		if (j2 == 1)
			anIntArray1639 = new int[numTriangles];
		if (k2 == 1)
			anIntArray1656 = new int[numTriangles];
		if (l2 == 1)
			D = new short[numTriangles];
		if (l2 == 1 && numTexTriangles > 0)
			x = new byte[numTriangles];
		triangleColours2 = new int[numTriangles];
		int i_115_ = k5;
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if (numTexTriangles > 0) {
			texTrianglesPoint1 = new int[numTexTriangles];
			texTrianglesPoint2 = new int[numTexTriangles];
			texTrianglesPoint3 = new int[numTexTriangles];
			if (l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if (i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.currentPosition = l5;
		nc2.currentPosition = k8;
		nc3.currentPosition = l8;
		nc4.currentPosition = i9;
		nc5.currentPosition = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for (int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.readUnsignedByte();
			int j12 = 0;
			if ((l11 & 1) != 0)
				j12 = nc2.method421();
			int l12 = 0;
			if ((l11 & 2) != 0)
				l12 = nc3.method421();
			int j13 = 0;
			if ((l11 & 4) != 0)
				j13 = nc4.method421();
			vertexX[k11] = l10 + j12;
			vertexY[k11] = i11 + l12;
			vertexZ[k11] = j11 + j13;
			l10 = vertexX[k11];
			i11 = vertexY[k11];
			j11 = vertexZ[k11];
			if (anIntArray1655 != null)
				anIntArray1655[k11] = nc5.readUnsignedByte();
		}
		nc1.currentPosition = j8;
		nc2.currentPosition = i6;
		nc3.currentPosition = k6;
		nc4.currentPosition = j7;
		nc5.currentPosition = l6;
		nc6.currentPosition = l7;
		nc7.currentPosition = i8;
		for (int i12 = 0; i12 < numTriangles; i12++) {
			triangleColours2[i12] =  nc1.readUnsignedShort();
			if (l1 == 1) {
				triangleDrawType[i12] = nc2.readSignedByte();
				if (triangleDrawType[i12] == 2)
					triangleColours2[i12] =  65535;
				triangleDrawType[i12] = 0;
			}
			if (i2 == 255) {
				anIntArray1638[i12] = nc3.readSignedByte();
			}
			if (j2 == 1) {
				anIntArray1639[i12] = nc4.readSignedByte();
				if (anIntArray1639[i12] < 0)
					anIntArray1639[i12] = (256 + anIntArray1639[i12]);
			}
			if (k2 == 1)
				anIntArray1656[i12] = nc5.readUnsignedByte();
			if (l2 == 1)
				D[i12] = (short) (nc6.readUnsignedShort() - 1);
			if (x != null)
				if (D[i12] != -1)
					x[i12] = (byte) (nc7.readUnsignedByte() - 1);
				else
					x[i12] = -1;
		}
		nc1.currentPosition = k7;
		nc2.currentPosition = j6;
		int k12 = 0;
		int i13 = 0;
		int k13 = 0;
		int l13 = 0;
		for (int i14 = 0; i14 < numTriangles; i14++) {
			int j14 = nc2.readUnsignedByte();
			if (j14 == 1) {
				k12 = nc1.method421() + l13;
				l13 = k12;
				i13 = nc1.method421() + l13;
				l13 = i13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 2) {
				i13 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 3) {
				k12 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 4) {
				int l14 = k12;
				k12 = i13;
				i13 = l14;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
		}
		nc1.currentPosition = j9;
		nc2.currentPosition = k9;
		nc3.currentPosition = l9;
		nc4.currentPosition = i10;
		nc5.currentPosition = j10;
		nc6.currentPosition = k10;
		for (int k14 = 0; k14 < numTexTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if (i15 == 0) {
				texTrianglesPoint1[k14] = nc1.readUnsignedShort();
				texTrianglesPoint2[k14] = nc1.readUnsignedShort();
				texTrianglesPoint3[k14] = nc1.readUnsignedShort();
			}
			if (i15 == 1) {
				texTrianglesPoint1[k14] = nc2.readUnsignedShort();
				texTrianglesPoint2[k14] = nc2.readUnsignedShort();
				texTrianglesPoint3[k14] = nc2.readUnsignedShort();
				kb[k14] = nc3.readUnsignedShort();
				N[k14] = nc3.readUnsignedShort();
				y[k14] = nc3.readUnsignedShort();
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
			if (i15 == 2) {
				texTrianglesPoint1[k14] = nc2.readUnsignedShort();
				texTrianglesPoint2[k14] = nc2.readUnsignedShort();
				texTrianglesPoint3[k14] = nc2.readUnsignedShort();
				kb[k14] = nc3.readUnsignedShort();
				N[k14] = nc3.readUnsignedShort();
				y[k14] = nc3.readUnsignedShort();
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
				cb[k14] = nc6.readSignedByte();
				J[k14] = nc6.readSignedByte();
			}
			if (i15 == 3) {
				texTrianglesPoint1[k14] = nc2.readUnsignedShort();
				texTrianglesPoint2[k14] = nc2.readUnsignedShort();
				texTrianglesPoint3[k14] = nc2.readUnsignedShort();
				kb[k14] = nc3.readUnsignedShort();
				N[k14] = nc3.readUnsignedShort();
				y[k14] = nc3.readUnsignedShort();
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
		}
		if (i2 != 255) {
			for (int i12 = 0; i12 < numTriangles; i12++)
				anIntArray1638[i12] = i2;
		}
		anIntArray1640 = triangleColours2;
		vertexCount = numVertices;
		triangleCount = numTriangles;
		verticesX = vertexX;
		verticesY = vertexY;
		verticesZ = vertexZ;
		triangleX = facePoint1;
		triangleY = facePoint2;
		triangleZ = facePoint3;
		convertTexturesTo317(D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, false, x);
	}

	public Model(int modelId, int j) {
		byte[] is = aClass21Array1661[modelId].aByteArray368;
		if (is[is.length - 1] == -1 && is[is.length - 2] == -1)
			read622Model(is, modelId);
		else
			readOldModel(modelId);
		if (newmodel[modelId]) {
			method478(32,32, -1, 32);
			method475(0, 6, -1, 0);
	}
}

	public void scale2(int i) {
		for (int i1 = 0; i1 < vertexCount; i1++) {
			verticesX[i1] = verticesX[i1] / i;
			verticesY[i1] = verticesY[i1] / i;
			verticesZ[i1] = verticesZ[i1] / i;
		}
if(anIntArray1638 != null) {
    for(int j = 0; j < anIntArray1638.length; j++)
        anIntArray1638[j] = 10;
}
	}

	public void read622Model(byte abyte0[], int modelID) {
		Stream nc1 = new Stream(abyte0);
		Stream nc2 = new Stream(abyte0);
		Stream nc3 = new Stream(abyte0);
		Stream nc4 = new Stream(abyte0);
		Stream nc5 = new Stream(abyte0);
		Stream nc6 = new Stream(abyte0);
		Stream nc7 = new Stream(abyte0);
		nc1.currentPosition = abyte0.length - 23;
		int numVertices = nc1.readUnsignedShort();
		int numTriangles = nc1.readUnsignedShort();
		int numTexTriangles = nc1.readUnsignedByte();
		Class21 ModelDef_1 = aClass21Array1661[modelID] = new Class21();
		ModelDef_1.aByteArray368 = abyte0;
		ModelDef_1.anInt369 = numVertices;
		ModelDef_1.anInt370 = numTriangles;
		ModelDef_1.anInt371 = numTexTriangles;
		int l1 = nc1.readUnsignedByte();
		boolean bool = (0x1 & l1) == 1;
		boolean bool_78_ = (l1 & 0x2) == 2;
		boolean bool_25_ = (0x4 & l1) == 4;
		boolean bool_26_ = (0x8 & l1) == 8;
		if (!bool_26_) {
			read525Model(abyte0, modelID);
			return;
		}
		int newformat = 0;
		if (bool_26_) {
			nc1.currentPosition -= 7;
			newformat = nc1.readUnsignedByte();
			nc1.currentPosition += 6;
		}
		if (newformat == 15)
			newmodel[modelID] = true;
		int i2 = nc1.readUnsignedByte();
		int j2 = nc1.readUnsignedByte();
		int k2 = nc1.readUnsignedByte();
		int l2 = nc1.readUnsignedByte();
		int i3 = nc1.readUnsignedByte();
		int j3 = nc1.readUnsignedShort();
		int k3 = nc1.readUnsignedShort();
		int l3 = nc1.readUnsignedShort();
		int i4 = nc1.readUnsignedShort();
		int j4 = nc1.readUnsignedShort();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int v = 0;
		int hb = 0;
		int P = 0;
		byte G = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] ab = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if (numTexTriangles > 0) {
			O = new byte[numTexTriangles];
			nc1.currentPosition = 0;
			for (int j5 = 0; j5 < numTexTriangles; j5++) {
				byte byte0 = O[j5] = nc1.readSignedByte();
				if (byte0 == 0)
					k4++;
				if (byte0 >= 1 && byte0 <= 3)
					l4++;
				if (byte0 == 2)
					i5++;
			}
		}
		int k5 = numTexTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if (bool)
			k5 += numTriangles;
		if (l1 == 1)
			k5 += numTriangles;
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if (i2 == 255)
			k5 += numTriangles;
		int l6 = k5;
		if (k2 == 1)
			k5 += numTriangles;
		int i7 = k5;
		if (i3 == 1)
			k5 += numVertices;
		int j7 = k5;
		if (j2 == 1)
			k5 += numTriangles;
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if (l2 == 1)
			k5 += numTriangles * 2;
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int i_59_ = 6;
		if (newformat != 14) {
			if (newformat >= 15)
				i_59_ = 9;
		} else
			i_59_ = 7;
		int l9 = k5;
		k5 += i_59_ * l4;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		v = numVertices;
		hb = numTriangles;
		P = numTexTriangles;
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		anIntArray1655 = new int[numVertices];
		triangleDrawType = new int[numTriangles];
		anIntArray1638 = new int[numTriangles];
		anIntArray1639 = new int[numTriangles];
		anIntArray1656 = new int[numTriangles];
		if (i3 == 1)
			anIntArray1655 = new int[numVertices];
		if (bool)
			triangleDrawType = new int[numTriangles];
		if (i2 == 255)
			anIntArray1638 = new int[numTriangles];
		else
			G = (byte) i2;
		if (j2 == 1)
			anIntArray1639 = new int[numTriangles];
		if (k2 == 1)
			anIntArray1656 = new int[numTriangles];
		if (l2 == 1)
			D = new short[numTriangles];
		if (l2 == 1 && numTexTriangles > 0)
			x = new byte[numTriangles];
		triangleColours2 = new int[numTriangles];
		int i_115_ = k5;
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if (numTexTriangles > 0) {
			texTrianglesPoint1 = new int[numTexTriangles];
			texTrianglesPoint2 = new int[numTexTriangles];
			texTrianglesPoint3 = new int[numTexTriangles];
			if (l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if (i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.currentPosition = l5;
		nc2.currentPosition = k8;
		nc3.currentPosition = l8;
		nc4.currentPosition = i9;
		nc5.currentPosition = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for (int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.readUnsignedByte();
			int j12 = 0;
			if ((l11 & 1) != 0)
				j12 = nc2.method421();
			int l12 = 0;
			if ((l11 & 2) != 0)
				l12 = nc3.method421();
			int j13 = 0;
			if ((l11 & 4) != 0)
				j13 = nc4.method421();
			vertexX[k11] = l10 + j12;
			vertexY[k11] = i11 + l12;
			vertexZ[k11] = j11 + j13;
			l10 = vertexX[k11];
			i11 = vertexY[k11];
			j11 = vertexZ[k11];
			if (anIntArray1655 != null)
				anIntArray1655[k11] = nc5.readUnsignedByte();
		}
		nc1.currentPosition = j8;
		nc2.currentPosition = i6;
		nc3.currentPosition = k6;
		nc4.currentPosition = j7;
		nc5.currentPosition = l6;
		nc6.currentPosition = l7;
		nc7.currentPosition = i8;
		for (int i12 = 0; i12 < numTriangles; i12++) {
			triangleColours2[i12] = nc1.readUnsignedShort();
			if (l1 == 1) {
				triangleDrawType[i12] = nc2.readSignedByte();
				if (triangleDrawType[i12] == 2)
					triangleColours2[i12] = 65535;
				triangleDrawType[i12] = 0;
			}
			if (i2 == 255) {
				anIntArray1638[i12] = nc3.readSignedByte();
			}
			if (j2 == 1) {
				anIntArray1639[i12] = nc4.readSignedByte();
				if (anIntArray1639[i12] < 0)
					anIntArray1639[i12] = (256 + anIntArray1639[i12]);
			}
			if (k2 == 1)
				anIntArray1656[i12] = nc5.readUnsignedByte();
			if (l2 == 1)
				D[i12] = (short) (nc6.readUnsignedShort() - 1);
			if (x != null)
				if (D[i12] != -1)
					x[i12] = (byte) (nc7.readUnsignedByte() - 1);
				else
					x[i12] = -1;
		}
		nc1.currentPosition = k7;
		nc2.currentPosition = j6;
		int k12 = 0;
		int i13 = 0;
		int k13 = 0;
		int l13 = 0;
		for (int i14 = 0; i14 < numTriangles; i14++) {
			int j14 = nc2.readUnsignedByte();
			if (j14 == 1) {
				k12 = nc1.method421() + l13;
				l13 = k12;
				i13 = nc1.method421() + l13;
				l13 = i13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 2) {
				i13 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 3) {
				k12 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 4) {
				int l14 = k12;
				k12 = i13;
				i13 = l14;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
		}
		nc1.currentPosition = j9;
		nc2.currentPosition = k9;
		nc3.currentPosition = l9;
		nc4.currentPosition = i10;
		nc5.currentPosition = j10;
		nc6.currentPosition = k10;
		for (int k14 = 0; k14 < numTexTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if (i15 == 0) {
				texTrianglesPoint1[k14] = nc1.readUnsignedShort();
				texTrianglesPoint2[k14] = nc1.readUnsignedShort();
				texTrianglesPoint3[k14] = nc1.readUnsignedShort();
			}
			if (i15 == 1) {
				texTrianglesPoint1[k14] = nc2.readUnsignedShort();
				texTrianglesPoint2[k14] = nc2.readUnsignedShort();
				texTrianglesPoint3[k14] = nc2.readUnsignedShort();
				if (newformat < 15) {
					kb[k14] = nc3.readUnsignedShort();
					if (newformat >= 14)
						N[k14] = nc3.v(-1);
					else
						N[k14] = nc3.readUnsignedShort();
					y[k14] = nc3.readUnsignedShort();
				} else {
					kb[k14] = nc3.v(-1);
					N[k14] = nc3.v(-1);
					y[k14] = nc3.v(-1);
				}
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
			if (i15 == 2) {
				texTrianglesPoint1[k14] = nc2.readUnsignedShort();
				texTrianglesPoint2[k14] = nc2.readUnsignedShort();
				texTrianglesPoint3[k14] = nc2.readUnsignedShort();
				if (newformat >= 15) {
					kb[k14] = nc3.v(-1);
					N[k14] = nc3.v(-1);
					y[k14] = nc3.v(-1);
				} else {
					kb[k14] = nc3.readUnsignedShort();
					if (newformat < 14)
						N[k14] = nc3.readUnsignedShort();
					else
						N[k14] = nc3.v(-1);
					y[k14] = nc3.readUnsignedShort();
				}
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
				cb[k14] = nc6.readSignedByte();
				J[k14] = nc6.readSignedByte();
			}
			if (i15 == 3) {
				texTrianglesPoint1[k14] = nc2.readUnsignedShort();
				texTrianglesPoint2[k14] = nc2.readUnsignedShort();
				texTrianglesPoint3[k14] = nc2.readUnsignedShort();
				if (newformat < 15) {
					kb[k14] = nc3.readUnsignedShort();
					if (newformat < 14)
						N[k14] = nc3.readUnsignedShort();
					else
						N[k14] = nc3.v(-1);
					y[k14] = nc3.readUnsignedShort();
				} else {
					kb[k14] = nc3.v(-1);
					N[k14] = nc3.v(-1);
					y[k14] = nc3.v(-1);
				}
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
		}
		if (i2 != 255) {
			for (int i12 = 0; i12 < numTriangles; i12++)
				anIntArray1638[i12] = i2;
		}
		anIntArray1640 = triangleColours2;
		vertexCount = numVertices;
		triangleCount = numTriangles;
		verticesX = vertexX;
		verticesY = vertexY;
		verticesZ = vertexZ;
		triangleX = facePoint1;
		triangleY = facePoint2;
		triangleZ = facePoint3;
	}

	private void readOldModel(int i) {
		int j = -870;
		anInt1614 = 9;
		aBoolean1615 = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		Class21 class21 = aClass21Array1661[i];
		vertexCount = class21.anInt369;
		triangleCount = class21.anInt370;
		anInt1642 = class21.anInt371;
		verticesX = new int[vertexCount];
		verticesY = new int[vertexCount];
		verticesZ = new int[vertexCount];
		triangleX = new int[triangleCount];
		triangleY = new int[triangleCount];
		while (j >= 0)
			aBoolean1618 = !aBoolean1618;
		triangleZ = new int[triangleCount];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (class21.anInt376 >= 0)
			anIntArray1655 = new int[vertexCount];
		if (class21.anInt380 >= 0)
			triangleDrawType = new int[triangleCount];
		if (class21.anInt381 >= 0)
			anIntArray1638 = new int[triangleCount];
		else
			anInt1641 = -class21.anInt381 - 1;
		if (class21.anInt382 >= 0)
			anIntArray1639 = new int[triangleCount];
		if (class21.anInt383 >= 0)
			anIntArray1656 = new int[triangleCount];
		anIntArray1640 = new int[triangleCount];
		Stream stream = new Stream(class21.aByteArray368);
		stream.currentPosition = class21.anInt372;
		Stream stream_1 = new Stream(class21.aByteArray368);
		stream_1.currentPosition = class21.anInt373;
		Stream stream_2 = new Stream(class21.aByteArray368);
		stream_2.currentPosition = class21.anInt374;
		Stream stream_3 = new Stream(class21.aByteArray368);
		stream_3.currentPosition = class21.anInt375;
		Stream stream_4 = new Stream(class21.aByteArray368);
		stream_4.currentPosition = class21.anInt376;
		int k = 0;
		int l = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < vertexCount; j1++) {
			int k1 = stream.readUnsignedByte();
			int i2 = 0;
			if ((k1 & 1) != 0)
				i2 = stream_1.method421();
			int k2 = 0;
			if ((k1 & 2) != 0)
				k2 = stream_2.method421();
			int i3 = 0;
			if ((k1 & 4) != 0)
				i3 = stream_3.method421();
			verticesX[j1] = k + i2;
			verticesY[j1] = l + k2;
			verticesZ[j1] = i1 + i3;
			k = verticesX[j1];
			l = verticesY[j1];
			i1 = verticesZ[j1];
			if (anIntArray1655 != null)
				anIntArray1655[j1] = stream_4.readUnsignedByte();
		}
		stream.currentPosition = class21.anInt379;
		stream_1.currentPosition = class21.anInt380;
		stream_2.currentPosition = class21.anInt381;
		stream_3.currentPosition = class21.anInt382;
		stream_4.currentPosition = class21.anInt383;
		for (int l1 = 0; l1 < triangleCount; l1++) {
			anIntArray1640[l1] =  stream.readUnsignedShort();
			if (triangleDrawType != null)
				triangleDrawType[l1] = stream_1.readUnsignedByte();
			if (anIntArray1638 != null)
				anIntArray1638[l1] = stream_2.readUnsignedByte();
			if (anIntArray1639 != null) {
				anIntArray1639[l1] = stream_3.readUnsignedByte();
			}
			if (anIntArray1656 != null)
				anIntArray1656[l1] = stream_4.readUnsignedByte();
		}
		stream.currentPosition = class21.anInt377;
		stream_1.currentPosition = class21.anInt378;
		int j2 = 0;
		int l2 = 0;
		int j3 = 0;
		int k3 = 0;
		for (int l3 = 0; l3 < triangleCount; l3++) {
			int i4 = stream_1.readUnsignedByte();
			if (i4 == 1) {
				j2 = stream.method421() + k3;
				k3 = j2;
				l2 = stream.method421() + k3;
				k3 = l2;
				j3 = stream.method421() + k3;
				k3 = j3;
				triangleX[l3] = j2;
				triangleY[l3] = l2;
				triangleZ[l3] = j3;
			}
			if (i4 == 2) {
				j2 = j2;
				l2 = j3;
				j3 = stream.method421() + k3;
				k3 = j3;
				triangleX[l3] = j2;
				triangleY[l3] = l2;
				triangleZ[l3] = j3;
			}
			if (i4 == 3) {
				j2 = j3;
				l2 = l2;
				j3 = stream.method421() + k3;
				k3 = j3;
				triangleX[l3] = j2;
				triangleY[l3] = l2;
				triangleZ[l3] = j3;
			}
			if (i4 == 4) {
				int k4 = j2;
				j2 = l2;
				l2 = k4;
				j3 = stream.method421() + k3;
				k3 = j3;
				triangleX[l3] = j2;
				triangleY[l3] = l2;
				triangleZ[l3] = j3;
			}
		}
		stream.currentPosition = class21.anInt384;
		for (int j4 = 0; j4 < anInt1642; j4++) {
			anIntArray1643[j4] = stream.readUnsignedShort();
			anIntArray1644[j4] = stream.readUnsignedShort();
			anIntArray1645[j4] = stream.readUnsignedShort();
		}
	}

	public static void method460(byte abyte0[], int j) {
		if (abyte0 == null) {
			Class21 class21 = aClass21Array1661[j] = new Class21();
			class21.anInt369 = 0;
			class21.anInt370 = 0;
			class21.anInt371 = 0;
			return;
		}
		Stream stream = new Stream(abyte0);
		stream.currentPosition = abyte0.length - 18;
		Class21 class21_1 = aClass21Array1661[j] = new Class21();
		class21_1.aByteArray368 = abyte0;
		class21_1.anInt369 = stream.readUnsignedShort();
		class21_1.anInt370 = stream.readUnsignedShort();
		class21_1.anInt371 = stream.readUnsignedByte();
		int k = stream.readUnsignedByte();
		int l = stream.readUnsignedByte();
		int i1 = stream.readUnsignedByte();
		int j1 = stream.readUnsignedByte();
		int k1 = stream.readUnsignedByte();
		int l1 = stream.readUnsignedShort();
		int i2 = stream.readUnsignedShort();
		int j2 = stream.readUnsignedShort();
		int k2 = stream.readUnsignedShort();
		int l2 = 0;
		class21_1.anInt372 = l2;
		l2 += class21_1.anInt369;
		class21_1.anInt378 = l2;
		l2 += class21_1.anInt370;
		class21_1.anInt381 = l2;
		if (l == 255)
			l2 += class21_1.anInt370;
		else
			class21_1.anInt381 = -l - 1;
		class21_1.anInt383 = l2;
		if (j1 == 1)
			l2 += class21_1.anInt370;
		else
			class21_1.anInt383 = -1;
		class21_1.anInt380 = l2;
		if (k == 1)
			l2 += class21_1.anInt370;
		else
			class21_1.anInt380 = -1;
		class21_1.anInt376 = l2;
		if (k1 == 1)
			l2 += class21_1.anInt369;
		else
			class21_1.anInt376 = -1;
		class21_1.anInt382 = l2;
		if (i1 == 1)
			l2 += class21_1.anInt370;
		else
			class21_1.anInt382 = -1;
		class21_1.anInt377 = l2;
		l2 += k2;
		class21_1.anInt379 = l2;
		l2 += class21_1.anInt370 * 2;
		class21_1.anInt384 = l2;
		l2 += class21_1.anInt371 * 6;
		class21_1.anInt373 = l2;
		l2 += l1;
		class21_1.anInt374 = l2;
		l2 += i2;
		class21_1.anInt375 = l2;
		l2 += j2;
	}

	public static boolean newmodel[];

	public static void method459(int i,
			OnDemandFetcherParent onDemandFetcherParent) {
		aClass21Array1661 = new Class21[100000];
		newmodel = new boolean[100000];
		aOnDemandFetcherParent_1662 = onDemandFetcherParent;
	}

	public static void method461(int i, int j) {
		aClass21Array1661[j] = null;
	}

	public static Model method462(int i, int j) {
		if (aClass21Array1661 == null)
			return null;
		Class21 class21 = aClass21Array1661[j];
		if (class21 == null) {
			aOnDemandFetcherParent_1662.method548(j);
			return null;
		} else {
			return new Model(j,0);
		}
	}

	public static boolean method463(int i) {
		if (aClass21Array1661 == null)
			return false;

		Class21 class21 = aClass21Array1661[i];
		if (class21 == null) {
			aOnDemandFetcherParent_1662.method548(i);
			return false;
		} else {
			return true;
		}
	}

	private Model(boolean flag) {
		anInt1614 = 9;
		aBoolean1615 = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		if (!flag)
			aBoolean1618 = !aBoolean1618;
	}

	public Model(int i, Model amodel[], int j) {
		anInt1614 = 9;
		aBoolean1615 = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		vertexCount = 0;
		triangleCount = 0;
		anInt1642 = 0;
		anInt1641 = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				vertexCount += model.vertexCount;
				triangleCount += model.triangleCount;
				anInt1642 += model.anInt1642;
				flag |= model.triangleDrawType != null;
				if (model.anIntArray1638 != null) {
					flag1 = true;
				} else {
					if (anInt1641 == -1)
						anInt1641 = model.anInt1641;
					if (anInt1641 != model.anInt1641)
						flag1 = true;
				}
				flag2 |= model.anIntArray1639 != null;
				flag3 |= model.anIntArray1656 != null;
			}
		}

		verticesX = new int[vertexCount];
		verticesY = new int[vertexCount];
		verticesZ = new int[vertexCount];
		anIntArray1655 = new int[vertexCount];
		triangleX = new int[triangleCount];
		triangleY = new int[triangleCount];
		triangleZ = new int[triangleCount];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (flag)
			triangleDrawType = new int[triangleCount];
		if (flag1)
			anIntArray1638 = new int[triangleCount];
		if (flag2)
			anIntArray1639 = new int[triangleCount];
		if (flag3)
			anIntArray1656 = new int[triangleCount];
		anIntArray1640 = new int[triangleCount];
		vertexCount = 0;
		triangleCount = 0;
		anInt1642 = 0;
		int l = 0;
		for (int i1 = 0; i1 < i; i1++) {
			Model model_1 = amodel[i1];
			if (model_1 != null) {
				for (int j1 = 0; j1 < model_1.triangleCount; j1++) {
					if (flag)
						if (model_1.triangleDrawType == null) {
							triangleDrawType[triangleCount] = 0;
						} else {
							int k1 = model_1.triangleDrawType[j1];
							if ((k1 & 2) == 2)
								k1 += l << 2;
							triangleDrawType[triangleCount] = k1;
						}
					if (flag1)
						if (model_1.anIntArray1638 == null)
							anIntArray1638[triangleCount] = model_1.anInt1641;
						else
							anIntArray1638[triangleCount] = model_1.anIntArray1638[j1];
					if (flag2)
						if (model_1.anIntArray1639 == null)
							anIntArray1639[triangleCount] = 0;
						else
							anIntArray1639[triangleCount] = model_1.anIntArray1639[j1];

					if (flag3 && model_1.anIntArray1656 != null)
						anIntArray1656[triangleCount] = model_1.anIntArray1656[j1];
					anIntArray1640[triangleCount] = model_1.anIntArray1640[j1];
					triangleX[triangleCount] = method465(model_1,
							model_1.triangleX[j1]);
					triangleY[triangleCount] = method465(model_1,
							model_1.triangleY[j1]);
					triangleZ[triangleCount] = method465(model_1,
							model_1.triangleZ[j1]);
					triangleCount++;
				}

				for (int l1 = 0; l1 < model_1.anInt1642; l1++) {
					anIntArray1643[anInt1642] = method465(model_1,
							model_1.anIntArray1643[l1]);
					anIntArray1644[anInt1642] = method465(model_1,
							model_1.anIntArray1644[l1]);
					anIntArray1645[anInt1642] = method465(model_1,
							model_1.anIntArray1645[l1]);
					anInt1642++;
				}

				l += model_1.anInt1642;
			}
		}

	}

	public Model(int hurr, int ima, boolean flag, Model amodel[]) {
		int i = 2;
		anInt1614 = 9;
		aBoolean1615 = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		vertexCount = 0;
		triangleCount = 0;
		anInt1642 = 0;
		anInt1641 = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				vertexCount += model.vertexCount;
				triangleCount += model.triangleCount;
				anInt1642 += model.anInt1642;
				flag1 |= model.triangleDrawType != null;
				if (model.anIntArray1638 != null) {
					flag2 = true;
				} else {
					if (anInt1641 == -1)
						anInt1641 = model.anInt1641;
					if (anInt1641 != model.anInt1641)
						flag2 = true;
				}
				flag3 |= model.anIntArray1639 != null;
				flag4 |= model.anIntArray1640 != null;
			}
		}

		verticesX = new int[vertexCount];
		verticesY = new int[vertexCount];
		verticesZ = new int[vertexCount];
		triangleX = new int[triangleCount];
		triangleY = new int[triangleCount];
		triangleZ = new int[triangleCount];
		anIntArray1634 = new int[triangleCount];
		anIntArray1635 = new int[triangleCount];
		anIntArray1636 = new int[triangleCount];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (flag1)
			triangleDrawType = new int[triangleCount];
		if (flag2)
			anIntArray1638 = new int[triangleCount];
		if (flag3)
			anIntArray1639 = new int[triangleCount];
		if (flag4)
			anIntArray1640 = new int[triangleCount];
		vertexCount = 0;
		triangleCount = 0;
		anInt1642 = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < i; j1++) {
			Model model_1 = amodel[j1];
			if (model_1 != null) {
				int k1 = vertexCount;
				for (int l1 = 0; l1 < model_1.vertexCount; l1++) {
					verticesX[vertexCount] = model_1.verticesX[l1];
					verticesY[vertexCount] = model_1.verticesY[l1];
					verticesZ[vertexCount] = model_1.verticesZ[l1];
					vertexCount++;
				}

				for (int i2 = 0; i2 < model_1.triangleCount; i2++) {
					triangleX[triangleCount] = model_1.triangleX[i2] + k1;
					triangleY[triangleCount] = model_1.triangleY[i2] + k1;
					triangleZ[triangleCount] = model_1.triangleZ[i2] + k1;
					anIntArray1634[triangleCount] = model_1.anIntArray1634[i2];
					anIntArray1635[triangleCount] = model_1.anIntArray1635[i2];
					anIntArray1636[triangleCount] = model_1.anIntArray1636[i2];
					if (flag1)
						if (model_1.triangleDrawType == null) {
							triangleDrawType[triangleCount] = 0;
						} else {
							int j2 = model_1.triangleDrawType[i2];
							if ((j2 & 2) == 2)
								j2 += i1 << 2;
							triangleDrawType[triangleCount] = j2;
						}
					if (flag2)
						if (model_1.anIntArray1638 == null)
							anIntArray1638[triangleCount] = model_1.anInt1641;
						else
							anIntArray1638[triangleCount] = model_1.anIntArray1638[i2];
					if (flag3)
						if (model_1.anIntArray1639 == null)
							anIntArray1639[triangleCount] = 0;
						else
							anIntArray1639[triangleCount] = model_1.anIntArray1639[i2];
					if (flag4 && model_1.anIntArray1640 != null)
						anIntArray1640[triangleCount] = model_1.anIntArray1640[i2];

					triangleCount++;
				}

				for (int k2 = 0; k2 < model_1.anInt1642; k2++) {
					anIntArray1643[anInt1642] = model_1.anIntArray1643[k2] + k1;
					anIntArray1644[anInt1642] = model_1.anIntArray1644[k2] + k1;
					anIntArray1645[anInt1642] = model_1.anIntArray1645[k2] + k1;
					anInt1642++;
				}

				i1 += model_1.anInt1642;
			}
		}

		method466(false);
	}

	public Model(int derp, boolean flag, boolean flag1, boolean flag2, Model model) {
		anInt1614 = 9;
		aBoolean1615 = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		vertexCount = model.vertexCount;
		triangleCount = model.triangleCount;
		anInt1642 = model.anInt1642;
		if (flag2) {
			verticesX = model.verticesX;
			verticesY = model.verticesY;
			verticesZ = model.verticesZ;
		} else {
			verticesX = new int[vertexCount];
			verticesY = new int[vertexCount];
			verticesZ = new int[vertexCount];
			for (int j = 0; j < vertexCount; j++) {
				verticesX[j] = model.verticesX[j];
				verticesY[j] = model.verticesY[j];
				verticesZ[j] = model.verticesZ[j];
			}

		}
		if (flag) {
			anIntArray1640 = model.anIntArray1640;
		} else {
			anIntArray1640 = new int[triangleCount];
			for (int k = 0; k < triangleCount; k++)
				anIntArray1640[k] = model.anIntArray1640[k];

		}
		if (flag1) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			anIntArray1639 = new int[triangleCount];
			if (model.anIntArray1639 == null) {
				for (int l = 0; l < triangleCount; l++)
					anIntArray1639[l] = 0;

			} else {
				for (int i1 = 0; i1 < triangleCount; i1++)
					anIntArray1639[i1] = model.anIntArray1639[i1];

			}
		}
		anIntArray1655 = model.anIntArray1655;
		anIntArray1656 = model.anIntArray1656;
		triangleDrawType = model.triangleDrawType;
		triangleX = model.triangleX;
		triangleY = model.triangleY;
		triangleZ = model.triangleZ;
		anIntArray1638 = model.anIntArray1638;
		anInt1641 = model.anInt1641;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}

	public Model(boolean flag, int derp, boolean flag1, Model model) {
		anInt1614 = 9;
		aBoolean1615 = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		vertexCount = model.vertexCount;
		triangleCount = model.triangleCount;
		anInt1642 = model.anInt1642;
		if (flag) {
			verticesY = new int[vertexCount];
			for (int j = 0; j < vertexCount; j++)
				verticesY[j] = model.verticesY[j];

		} else {
			verticesY = model.verticesY;
		}
		if (flag1) {
			anIntArray1634 = new int[triangleCount];
			anIntArray1635 = new int[triangleCount];
			anIntArray1636 = new int[triangleCount];
			for (int k = 0; k < triangleCount; k++) {
				anIntArray1634[k] = model.anIntArray1634[k];
				anIntArray1635[k] = model.anIntArray1635[k];
				anIntArray1636[k] = model.anIntArray1636[k];
			}

			triangleDrawType = new int[triangleCount];
			if (model.triangleDrawType == null) {
				for (int l = 0; l < triangleCount; l++)
					triangleDrawType[l] = 0;

			} else {
				for (int i1 = 0; i1 < triangleCount; i1++)
					triangleDrawType[i1] = model.triangleDrawType[i1];

			}
			super.vertexNormals = new VertexNormal[vertexCount];
			for (int j1 = 0; j1 < vertexCount; j1++) {
				VertexNormal class33 = super.vertexNormals[j1] = new VertexNormal();
				VertexNormal class33_1 = model.vertexNormals[j1];
				class33.x = class33_1.x;
				class33.y = class33_1.y;
				class33.z = class33_1.z;
				class33.magnitude = class33_1.magnitude;
			}

			vertexNormalOffset = model.vertexNormalOffset;
		} else {
			anIntArray1634 = model.anIntArray1634;
			anIntArray1635 = model.anIntArray1635;
			anIntArray1636 = model.anIntArray1636;
			triangleDrawType = model.triangleDrawType;
		}
		verticesX = model.verticesX;
		verticesZ = model.verticesZ;
		anIntArray1640 = model.anIntArray1640;
		anIntArray1639 = model.anIntArray1639;
		anIntArray1638 = model.anIntArray1638;
		anInt1641 = model.anInt1641;
		triangleX = model.triangleX;
		triangleY = model.triangleY;
		triangleZ = model.triangleZ;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
		super.anInt1426 = ((Animable) (model)).anInt1426;
		anInt1650 = model.anInt1650;
		anInt1653 = model.anInt1653;
		anInt1652 = model.anInt1652;
		minX = model.minX;
		maxZ = model.maxZ;
		minZ = model.minZ;
		maxX = model.maxX;
	}

	public void method464(int i, Model model, boolean flag) {
		vertexCount = model.vertexCount;
		triangleCount = model.triangleCount;
		anInt1642 = model.anInt1642;
		if (anIntArray1622.length < vertexCount) {
			anIntArray1622 = new int[vertexCount + 10000];
			anIntArray1623 = new int[vertexCount + 10000];
			anIntArray1624 = new int[vertexCount + 10000];
		}
		verticesX = anIntArray1622;
		verticesY = anIntArray1623;
		verticesZ = anIntArray1624;
		for (int k = 0; k < vertexCount; k++) {
			verticesX[k] = model.verticesX[k];
			verticesY[k] = model.verticesY[k];
			verticesZ[k] = model.verticesZ[k];
		}

		if (flag) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			if (anIntArray1625.length < triangleCount)
				anIntArray1625 = new int[triangleCount + 100];
			anIntArray1639 = anIntArray1625;
			if (model.anIntArray1639 == null) {
				for (int l = 0; l < triangleCount; l++)
					anIntArray1639[l] = 0;

			} else {
				for (int i1 = 0; i1 < triangleCount; i1++)
					anIntArray1639[i1] = model.anIntArray1639[i1];

			}
		}
		triangleDrawType = model.triangleDrawType;
		anIntArray1640 = model.anIntArray1640;
		anIntArray1638 = model.anIntArray1638;
		anInt1641 = model.anInt1641;
		anIntArrayArray1658 = model.anIntArrayArray1658;
		anIntArrayArray1657 = model.anIntArrayArray1657;
		triangleX = model.triangleX;
		triangleY = model.triangleY;
		triangleZ = model.triangleZ;
		anIntArray1634 = model.anIntArray1634;
		anIntArray1635 = model.anIntArray1635;
		anIntArray1636 = model.anIntArray1636;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}

	private final int method465(Model model, int i) {
		int j = -1;
		int k = model.verticesX[i];
		int l = model.verticesY[i];
		int i1 = model.verticesZ[i];
		for (int j1 = 0; j1 < vertexCount; j1++) {
			if (k != verticesX[j1] || l != verticesY[j1]
			                                                   || i1 != verticesZ[j1])
				continue;
			j = j1;
			break;
		}

		if (j == -1) {
			verticesX[vertexCount] = k;
			verticesY[vertexCount] = l;
			verticesZ[vertexCount] = i1;
			if (model.anIntArray1655 != null)
				anIntArray1655[vertexCount] = model.anIntArray1655[i];
			j = vertexCount++;
		}
		return j;
	}

	public void method466(boolean flag) {
		super.anInt1426 = 0;
		anInt1650 = 0;
		maxY = 0;
		for (int i = 0; i < vertexCount; i++) {
			int j = verticesX[i];
			int k = verticesY[i];
			int l = verticesZ[i];
			if (-k > super.anInt1426)
				super.anInt1426 = -k;
			if (k > maxY)
				maxY = k;
			int i1 = j * j + l * l;
			if (i1 > anInt1650)
				anInt1650 = i1;
		}
		anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.anInt1426
				* super.anInt1426) + 0.98999999999999999D);
		anInt1652 = anInt1653
		+ (int) (Math.sqrt(anInt1650 * anInt1650 + maxY
				* maxY) + 0.98999999999999999D);
	}

	public void method467(boolean flag) {
		super.anInt1426 = 0;
		maxY = 0;
		for (int i = 0; i < vertexCount; i++) {
			int j = verticesY[i];
			if (-j > super.anInt1426)
				super.anInt1426 = -j;
			if (j > maxY)
				maxY = j;
		}

		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.anInt1426
				* super.anInt1426) + 0.98999999999999999D);
		anInt1652 = anInt1653
		+ (int) (Math.sqrt(anInt1650 * anInt1650 + maxY
				* maxY) + 0.98999999999999999D);
	}

	public void method468(int i) {
		super.anInt1426 = 0;
		anInt1650 = 0;
		maxY = 0;
		minX = 0xf423f;
		maxX = 0xfff0bdc1;
		maxZ = 0xfffe7961;
		minZ = 0x1869f;
		for (int j = 0; j < vertexCount; j++) {
			int k = verticesX[j];
			int l = verticesY[j];
			int i1 = verticesZ[j];
			if (k < minX)
				minX = k;
			if (k > maxX)
				maxX = k;
			if (i1 < minZ)
				minZ = i1;
			if (i1 > maxZ)
				maxZ = i1;
			if (-l > super.anInt1426)
				super.anInt1426 = -l;
			if (l > maxY)
				maxY = l;
			int j1 = k * k + i1 * i1;
			if (j1 > anInt1650)
				anInt1650 = j1;
		}

		anInt1650 = (int) Math.sqrt(anInt1650);
		anInt1653 = (int) Math.sqrt(anInt1650 * anInt1650 + super.anInt1426
				* super.anInt1426);
		if (i != 21073) {
			return;
		} else {
			anInt1652 = anInt1653
			+ (int) Math.sqrt(anInt1650 * anInt1650 + maxY
					* maxY);
			return;
		}
	}

	public void method469(byte byte0) {
		if (anIntArray1655 != null) {
			int ai[] = new int[256];
			int j = 0;
			for (int l = 0; l < vertexCount; l++) {
				int j1 = anIntArray1655[l];
				ai[j1]++;
				if (j1 > j)
					j = j1;
			}

			anIntArrayArray1657 = new int[j + 1][];
			for (int k1 = 0; k1 <= j; k1++) {
				anIntArrayArray1657[k1] = new int[ai[k1]];
				ai[k1] = 0;
			}

			for (int j2 = 0; j2 < vertexCount; j2++) {
				int l2 = anIntArray1655[j2];
				anIntArrayArray1657[l2][ai[l2]++] = j2;
			}

			anIntArray1655 = null;
		}
		if (anIntArray1656 != null) {
			int ai1[] = new int[256];
			int k = 0;
			for (int i1 = 0; i1 < triangleCount; i1++) {
				int l1 = anIntArray1656[i1];
				ai1[l1]++;
				if (l1 > k)
					k = l1;
			}

			anIntArrayArray1658 = new int[k + 1][];
			for (int i2 = 0; i2 <= k; i2++) {
				anIntArrayArray1658[i2] = new int[ai1[i2]];
				ai1[i2] = 0;
			}

			for (int k2 = 0; k2 < triangleCount; k2++) {
				int i3 = anIntArray1656[k2];
				anIntArrayArray1658[i3][ai1[i3]++] = k2;
			}

			anIntArray1656 = null;
		}
	}

	public void method470(int i, int j) {
		if (anIntArrayArray1657 == null)
			return;
		if (i == -1)
			return;
		Class36 class36 = Class36.method531(anInt1614, i);
		if (class36 == null)
			return;
		Class18 class18 = class36.aClass18_637;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		for (int k = 0; k < class36.anInt638; k++) {
			int l = class36.anIntArray639[k];
			method472(class18.anIntArray342[l], class18.anIntArrayArray343[l],
					class36.anIntArray640[k], class36.anIntArray641[k],
					class36.anIntArray642[k]);
		}

	}

	public void method471(int i, int ai[], int j, int k) {
		if (k == -1)
			return;
		if (ai == null || j == -1) {
			method470(k, 40542);
			return;
		}
		Class36 class36 = Class36.method531(anInt1614, k);
		if (class36 == null)
			return;
		Class36 class36_1 = Class36.method531(anInt1614, k);
		if (class36_1 == null) {
			method470(k, 40542);
			return;
		}
		Class18 class18 = class36.aClass18_637;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		int l = 0;
		int i1 = ai[l++];
		for (int j1 = 0; j1 < class36.anInt638; j1++) {
			int k1;
			for (k1 = class36.anIntArray639[j1]; k1 > i1; i1 = ai[l++])
				;
			if (k1 != i1 || class18.anIntArray342[k1] == 0)
				method472(class18.anIntArray342[k1],
						class18.anIntArrayArray343[k1],
						class36.anIntArray640[j1], class36.anIntArray641[j1],
						class36.anIntArray642[j1]);
		}

		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		l = 0;
		i1 = ai[l++];
		for (int l1 = 0; l1 < class36_1.anInt638; l1++) {
			int i2;
			for (i2 = class36_1.anIntArray639[l1]; i2 > i1; i1 = ai[l++])
				;
			if (i2 == i1 || class18.anIntArray342[i2] == 0)
				method472(class18.anIntArray342[i2],
						class18.anIntArrayArray343[i2],
						class36_1.anIntArray640[l1],
						class36_1.anIntArray641[l1],
						class36_1.anIntArray642[l1]);
		}

	}

	private void method472(int i, int ai[], int j, int k, int l) {

		int i1 = ai.length;
		if (i == 0) {
			int j1 = 0;
			anInt1681 = 0;
			anInt1682 = 0;
			anInt1683 = 0;
			for (int k2 = 0; k2 < i1; k2++) {
				int l3 = ai[k2];
				if (l3 < anIntArrayArray1657.length) {
					int ai5[] = anIntArrayArray1657[l3];
					for (int i5 = 0; i5 < ai5.length; i5++) {
						int j6 = ai5[i5];
						anInt1681 += verticesX[j6];
						anInt1682 += verticesY[j6];
						anInt1683 += verticesZ[j6];
						j1++;
					}

				}
			}

			if (j1 > 0) {
				anInt1681 = anInt1681 / j1 + j;
				anInt1682 = anInt1682 / j1 + k;
				anInt1683 = anInt1683 / j1 + l;
				return;
			} else {
				anInt1681 = j;
				anInt1682 = k;
				anInt1683 = l;
				return;
			}
		}
		if (i == 1) {
			for (int k1 = 0; k1 < i1; k1++) {
				int l2 = ai[k1];
				if (l2 < anIntArrayArray1657.length) {
					int ai1[] = anIntArrayArray1657[l2];
					for (int i4 = 0; i4 < ai1.length; i4++) {
						int j5 = ai1[i4];
						verticesX[j5] += j;
						verticesY[j5] += k;
						verticesZ[j5] += l;
					}

				}
			}

			return;
		}
		if (i == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = ai[l1];
				if (i3 < anIntArrayArray1657.length) {
					int ai2[] = anIntArrayArray1657[i3];
					for (int j4 = 0; j4 < ai2.length; j4++) {
						int k5 = ai2[j4];
						verticesX[k5] -= anInt1681;
						verticesY[k5] -= anInt1682;
						verticesZ[k5] -= anInt1683;
						int k6 = (j & 0xff) * 8;
						int l6 = (k & 0xff) * 8;
						int i7 = (l & 0xff) * 8;
						if (i7 != 0) {
							int j7 = SINE[i7];
							int i8 = COSINE[i7];
							int l8 = verticesY[k5] * j7 + verticesX[k5] * i8 >> 16;
					verticesY[k5] = verticesY[k5] * i8
					- verticesX[k5] * j7 >> 16;
			verticesX[k5] = l8;
						}
						if (k6 != 0) {
							int k7 = SINE[k6];
							int j8 = COSINE[k6];
							int i9 = verticesY[k5] * j8 - verticesZ[k5] * k7 >> 16;
							verticesZ[k5] = verticesY[k5] * k7 + verticesZ[k5] * j8 >> 16;
							verticesY[k5] = i9;
						}
						if (l6 != 0) {
							int l7 = SINE[l6];
							int k8 = COSINE[l6];
							int j9 = verticesZ[k5] * l7 + verticesX[k5] * k8 >> 16;
							verticesZ[k5] = verticesZ[k5] * k8 - verticesX[k5] * l7 >> 16;
							verticesX[k5] = j9;
						}
						verticesX[k5] += anInt1681;
						verticesY[k5] += anInt1682;
						verticesZ[k5] += anInt1683;
					}

				}
			}
			return;
		}
		if (i == 3) {
			for (int i2 = 0; i2 < i1; i2++) {
				int j3 = ai[i2];
				if (j3 < anIntArrayArray1657.length) {
					int ai3[] = anIntArrayArray1657[j3];
					for (int k4 = 0; k4 < ai3.length; k4++) {
						int l5 = ai3[k4];
						verticesX[l5] -= anInt1681;
						verticesY[l5] -= anInt1682;
						verticesZ[l5] -= anInt1683;
						verticesX[l5] = (verticesX[l5] * j) / 128;
						verticesY[l5] = (verticesY[l5] * k) / 128;
						verticesZ[l5] = (verticesZ[l5] * l) / 128;
						verticesX[l5] += anInt1681;
						verticesY[l5] += anInt1682;
						verticesZ[l5] += anInt1683;
					}
				}
			}
			return;
		}
		if (i == 5 && anIntArrayArray1658 != null && anIntArray1639 != null) {
			for (int j2 = 0; j2 < i1; j2++) {
				int k3 = ai[j2];
				if (k3 < anIntArrayArray1658.length) {
					int ai4[] = anIntArrayArray1658[k3];
					for (int l4 = 0; l4 < ai4.length; l4++) {
						int i6 = ai4[l4];
						anIntArray1639[i6] += j * 8;
						if (anIntArray1639[i6] < 0)
							anIntArray1639[i6] = 0;
						if (anIntArray1639[i6] > 255)
							anIntArray1639[i6] = 255;
					}
				}
			}
		}
	}

	public void method473(int i) {
		for (int j = 0; j < vertexCount; j++) {
			int k = verticesX[j];
			verticesX[j] = verticesZ[j];
			verticesZ[j] = -k;
		}
	}

	public void method474(int i, int j) {
		int k = SINE[i];
		int l = COSINE[i];
		for (int i1 = 0; i1 < vertexCount; i1++) {
			int j1 = verticesY[i1] * l - verticesZ[i1] * k >> 16;
			verticesZ[i1] = verticesY[i1] * k + verticesZ[i1] * l >> 16;
			verticesY[i1] = j1;
		}
	}

	public void method475(int i, int j, int k, int l) {
		for (int i1 = 0; i1 < vertexCount; i1++) {
			verticesX[i1] += i;
			verticesY[i1] += j;
			verticesZ[i1] += l;
		}
	}

	public void method476(int i, int j) {
		for (int k = 0; k < triangleCount; k++)
			if (anIntArray1640[k] == i)
				anIntArray1640[k] = j;
	}

	public void method477(int i) {
		for (int j = 0; j < vertexCount; j++)
			verticesZ[j] = -verticesZ[j];
		for (int k = 0; k < triangleCount; k++) {
			int l = triangleX[k];
			triangleX[k] = triangleZ[k];
			triangleZ[k] = l;
		}
	}

	public void method478(int i, int j, int k, int l) {
		for (int i1 = 0; i1 < vertexCount; i1++) {
			verticesX[i1] = (verticesX[i1] * i) / 128;
			verticesY[i1] = (verticesY[i1] * l) / 128;
			verticesZ[i1] = (verticesZ[i1] * j) / 128;
		}

	}

public final void method479(int i, int j, int k, int l, int i1, boolean flag) {
		int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
		int k1 = j * j1 >> 8;
		if (anIntArray1634 == null) {
			anIntArray1634 = new int[triangleCount];
			anIntArray1635 = new int[triangleCount];
			anIntArray1636 = new int[triangleCount];
		}
		if (super.vertexNormals == null) {
			super.vertexNormals = new VertexNormal[vertexCount];
			for (int l1 = 0; l1 < vertexCount; l1++)
				super.vertexNormals[l1] = new VertexNormal();

		}
		for (int i2 = 0; i2 < triangleCount; i2++) {
			if (anIntArray1640 != null && anIntArray1639 != null)
				if (anIntArray1640[i2] == 65535 // Most triangles
						|| anIntArray1640[i2] == 16705 // Nezzy Green
														// Triangles//GWD White
														// Triangles
				)
					anIntArray1639[i2] = 255;
			int j2 = triangleX[i2];
			int l2 = triangleY[i2];
			int i3 = triangleZ[i2];
			int j3 = verticesX[l2] - verticesX[j2];
			int k3 = verticesY[l2] - verticesY[j2];
			int l3 = verticesZ[l2] - verticesZ[j2];
			int i4 = verticesX[i3] - verticesX[j2];
			int j4 = verticesY[i3] - verticesY[j2];
			int k4 = verticesZ[i3] - verticesZ[j2];
			int l4 = k3 * k4 - j4 * l3;
			int i5 = l3 * i4 - k4 * j3;
			int j5;
			for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192
					|| l4 < -8192 || i5 < -8192 || j5 < -8192; j5 >>= 1) {
				l4 >>= 1;
				i5 >>= 1;
			}

			int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
			if (k5 <= 0)
				k5 = 1;
			l4 = (l4 * 256) / k5;
			i5 = (i5 * 256) / k5;
			j5 = (j5 * 256) / k5;

			if (triangleDrawType == null || (triangleDrawType[i2] & 1) == 0) {

				VertexNormal class33_2 = super.vertexNormals[j2];
				class33_2.x += l4;
				class33_2.y += i5;
				class33_2.z += j5;
				class33_2.magnitude++;
				class33_2 = super.vertexNormals[l2];
				class33_2.x += l4;
				class33_2.y += i5;
				class33_2.z += j5;
				class33_2.magnitude++;
				class33_2 = super.vertexNormals[i3];
				class33_2.x += l4;
				class33_2.y += i5;
				class33_2.z += j5;
				class33_2.magnitude++;

			} else {

				int l5 = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
				anIntArray1634[i2] = method481(anIntArray1640[i2], l5,
						triangleDrawType[i2]);

			}
		}

		if (flag) {
			method480(i, k1, k, l, i1);
		} else {
			vertexNormalOffset = new VertexNormal[vertexCount];
			for (int k2 = 0; k2 < vertexCount; k2++) {
				VertexNormal class33 = super.vertexNormals[k2];
				VertexNormal class33_1 = vertexNormalOffset[k2] = new VertexNormal();
				class33_1.x = class33.x;
				class33_1.y = class33.y;
				class33_1.z = class33.z;
				class33_1.magnitude = class33.magnitude;
			}

		}
		if (flag) {
			method466(false);
			return;
		} else {
			method468(21073);
			return;
		}
	}

	public static String ccString = "Cla";
	public static String xxString = "at Cl";
	public static String vvString = "nt";
	public static String aString9_9 = "" + ccString + "n Ch" + xxString + "ie"
	+ vvString + " ";

	public final void method480(int i, int j, int k, int l, int i1) {
		for (int j1 = 0; j1 < triangleCount; j1++) {
			int k1 = triangleX[j1];
			int i2 = triangleY[j1];
			int j2 = triangleZ[j1];
			if (triangleDrawType == null) {
				int i3 = anIntArray1640[j1];
				VertexNormal class33 = super.vertexNormals[k1];
				int k2 = i
				+ (k * class33.x + l * class33.y + i1
						* class33.z) / (j * class33.magnitude);
				anIntArray1634[j1] = method481(i3, k2, 0);
				class33 = super.vertexNormals[i2];
				k2 = i
				+ (k * class33.x + l * class33.y + i1
						* class33.z) / (j * class33.magnitude);
				anIntArray1635[j1] = method481(i3, k2, 0);
				class33 = super.vertexNormals[j2];
				k2 = i
				+ (k * class33.x + l * class33.y + i1
						* class33.z) / (j * class33.magnitude);
				anIntArray1636[j1] = method481(i3, k2, 0);
			} else if ((triangleDrawType[j1] & 1) == 0) {
				int j3 = anIntArray1640[j1];
				int k3 = triangleDrawType[j1];
				VertexNormal class33_1 = super.vertexNormals[k1];
				int l2 = i
				+ (k * class33_1.x + l * class33_1.y + i1
						* class33_1.z)
						/ (j * class33_1.magnitude);
				anIntArray1634[j1] = method481(j3, l2, k3);
				class33_1 = super.vertexNormals[i2];
				l2 = i
				+ (k * class33_1.x + l * class33_1.y + i1
						* class33_1.z)
						/ (j * class33_1.magnitude);
				anIntArray1635[j1] = method481(j3, l2, k3);
				class33_1 = super.vertexNormals[j2];
				l2 = i
				+ (k * class33_1.x + l * class33_1.y + i1
						* class33_1.z)
						/ (j * class33_1.magnitude);
				anIntArray1636[j1] = method481(j3, l2, k3);
			}
		}

		super.vertexNormals = null;
		vertexNormalOffset = null;
		anIntArray1655 = null;
		anIntArray1656 = null;
		if (triangleDrawType != null) {
			for (int l1 = 0; l1 < triangleCount; l1++)
				if ((triangleDrawType[l1] & 2) == 2)
					return;

		}
		anIntArray1640 = null;
	}

	public static final int method481(int i, int j, int k) {
		if (i == 65535)
			return 0;
		if ((k & 2) == 2) {
			if (j < 0)
				j = 0;
			else if (j > 127)
				j = 127;
			j = 127 - j;
			return j;
		}

		j = j * (i & 0x7f) >> 7;
			if (j < 2)
				j = 2;
			else if (j > 126)
				j = 126;
			return (i & 0xff80) + j;
	}

	public final void method482(int hai, int j, int k, int l, int i1, int j1, int k1) {
		int i = 0;
		int l1 = Rasterizer.centerX;
		int i2 = Rasterizer.centerY;
		int j2 = SINE[i];
		int k2 = COSINE[i];
		int l2 = SINE[j];
		int i3 = COSINE[j];
		int j3 = SINE[k];
		int k3 = COSINE[k];
		int l3 = SINE[l];
		int i4 = COSINE[l];
		int j4 = j1 * l3 + k1 * i4 >> 16;
			for (int k4 = 0; k4 < vertexCount; k4++) {
				int l4 = verticesX[k4];
				int i5 = verticesY[k4];
				int j5 = verticesZ[k4];
				if (k != 0) {
					int k5 = i5 * j3 + l4 * k3 >> 16;
			i5 = i5 * k3 - l4 * j3 >> 16;
				l4 = k5;
				}
				if (i != 0) {
					int l5 = i5 * k2 - j5 * j2 >> 16;
			j5 = i5 * j2 + j5 * k2 >> 16;
			i5 = l5;
				}
				if (j != 0) {
					int i6 = j5 * l2 + l4 * i3 >> 16;
				j5 = j5 * i3 - l4 * l2 >> 16;
			l4 = i6;
				}
				l4 += i1;
				i5 += j1;
				j5 += k1;
				int j6 = i5 * i4 - j5 * l3 >> 16;
				j5 = i5 * l3 + j5 * i4 >> 16;
			i5 = j6;
			anIntArray1667[k4] = j5 - j4;
			anIntArray1665[k4] = l1 + (l4 << 9) / j5;
			anIntArray1666[k4] = i2 + (i5 << 9) / j5;
			if (anInt1642 > 0) {
				anIntArray1668[k4] = l4;
				anIntArray1669[k4] = i5;
				anIntArray1670[k4] = j5;
			}
			}

			try {
				method483(false, false, 0);
				return;
			} catch (Exception _ex) {
				return;
			}
	}
	public void convertTexturesTo317(short[] textureIds, int[] texa, int[] texb, int[] texc, boolean osrs, byte[] texture_coordinates) {
		int set = 0;
		int set2 = 0;
		int max = 50;
		if(textureIds != null) {
			anIntArray1643 = new int[triangleCount];
			anIntArray1644 = new int[triangleCount];
			anIntArray1645 = new int[triangleCount];


			for(int i = 0; i < triangleCount; i++) {
				if(textureIds[i] == -1 && triangleDrawType[i] == 2) {
					anIntArray1640[i] = 65535;
					triangleDrawType[i] = 0;
				}
				if(textureIds[i] >= max || textureIds[i] < 0 || textureIds[i] == 39) {
					triangleDrawType[i] = 0;
					continue;
				}
				triangleDrawType[i] = 2+set2;
				set2 += 4;
				int a = triangleX[i];
				int b = triangleY[i];
				int c = triangleZ[i];
				anIntArray1640[i] = textureIds[i];


				int texture_type = -1;
				if(texture_coordinates != null) {
					texture_type = texture_coordinates[i] & 0xff;
					if(texture_type != 0xff)
						if(texa[texture_type] >= anIntArray1669.length || texb[texture_type] >= anIntArray1668.length
								|| texc[texture_type] >= anIntArray1670.length)
							texture_type = -1;
				}
				if(texture_type == 0xff)
					texture_type = -1;


				anIntArray1643[set] = texture_type == -1 ? a : texa[texture_type];
				anIntArray1644[set] = texture_type == -1 ? b : texb[texture_type];
				anIntArray1645[set++] = texture_type == -1 ? c : texc[texture_type];


			}
			anInt1642 = set;
		}
	}
	public final void method443(int i, int j, int k, int l, int i1, int j1,
			int k1, int l1, long i2) {
		int j2 = l1 * i1 - j1 * l >> 16;
			int k2 = k1 * j + j2 * k >> 16;
			int l2 = anInt1650 * k >> 16;
							int i3 = k2 + l2;
							if (i3 <= 50 || k2 >= 30000)
								return;
							int j3 = l1 * l + j1 * i1 >> 16;
				int k3 = j3 - anInt1650 << client.log_view_dist;
				if (k3 / i3 >= DrawingArea.centerY)
					return;
				int l3 = j3 + anInt1650 << client.log_view_dist;
				if (l3 / i3 <= -DrawingArea.centerY)
					return;
				int i4 = k1 * k - j2 * j >> 16;
				int j4 = anInt1650 * j >> 16;
				int k4 = i4 + j4 << client.log_view_dist;
				if (k4 / i3 <= -DrawingArea.anInt1387)
					return;
				int l4 = j4 + (super.anInt1426 * k >> 16);
				int i5 = i4 - l4 << client.log_view_dist;
				if (i5 / i3 >= DrawingArea.anInt1387)
					return;
				int j5 = l2 + (super.anInt1426 * j >> 16);
				boolean flag = false;
				if (k2 - j5 <= 50)
					flag = true;
				boolean flag1 = false;
				if (i2 > 0 && aBoolean1684) {
					int k5 = k2 - l2;
					if (k5 <= 50)
						k5 = 50;
					if (j3 > 0) {
						k3 /= i3;
						l3 /= k5;
					} else {
						l3 /= i3;
						k3 /= k5;
					}
					if (i4 > 0) {
						i5 /= i3;
						k4 /= k5;
					} else {
						k4 /= i3;
						i5 /= k5;
					}
					int i6 = anInt1685 - Rasterizer.centerX;
					int k6 = anInt1686 - Rasterizer.centerY;
					if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
						if (aBoolean1659)
							anIntArray1688[anInt1687++] = i2;
						else
							flag1 = true;
				}
				int l5 = Rasterizer.centerX;
				int j6 = Rasterizer.centerY;
				int l6 = 0;
				int i7 = 0;
				if (i != 0) {
					l6 = SINE[i];
					i7 = COSINE[i];
				}
				for (int j7 = 0; j7 < vertexCount; j7++) {
					int k7 = verticesX[j7];
					int l7 = verticesY[j7];
					int i8 = verticesZ[j7];
					if (i != 0) {
						int j8 = i8 * l6 + k7 * i7 >> 16;
				i8 = i8 * i7 - k7 * l6 >> 16;
							k7 = j8;
					}
					k7 += j1;
					l7 += k1;
					i8 += l1;
					int k8 = i8 * l + k7 * i1 >> 16;
				i8 = i8 * i1 - k7 * l >> 16;
		k7 = k8;
		k8 = l7 * k - i8 * j >> 16;
		i8 = l7 * j + i8 * k >> 16;
		l7 = k8;
		anIntArray1667[j7] = i8 - k2;
		if (i8 >= 50) {
			anIntArray1665[j7] = l5 + (k7 << client.log_view_dist) / i8;
			anIntArray1666[j7] = j6 + (l7 << client.log_view_dist) / i8;
		} else {
			anIntArray1665[j7] = -5000;
			flag = true;
		}
		if (flag || anInt1642 > 0) {
			if(Configuration.distanceFog) {
				anIntArray1670[j7] = i8;
			}
			anIntArray1668[j7] = k7;
			anIntArray1669[j7] = l7;
			anIntArray1670[j7] = i8;
		}
				}

				try {
					method483(flag, flag1, i2);
					return;
				} catch (Exception _ex) {
					return;
				}
	}

	private final void method483(boolean flag, boolean flag1, long i) {
		for (int j = 0; j < anInt1652; j++)
			anIntArray1671[j] = 0;

		for (int k = 0; k < triangleCount; k++)
			if (triangleDrawType == null || triangleDrawType[k] != -1) {
				int l = triangleX[k];
				int k1 = triangleY[k];
				int j2 = triangleZ[k];
				int i3 = anIntArray1665[l];
				int l3 = anIntArray1665[k1];
				int k4 = anIntArray1665[j2];
				if (flag && (i3 == -5000 || l3 == -5000 || k4 == -5000)) {
					aBooleanArray1664[k] = true;
					int j5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2])
					/ 3 + anInt1653;
					anIntArrayArray1672[j5][anIntArray1671[j5]++] = k;
				} else {
					if (flag1
							&& method486(anInt1685, anInt1686,
									anIntArray1666[l], anIntArray1666[k1],
									anIntArray1666[j2], i3, l3, k4)) {
						anIntArray1688[anInt1687++] = i;
						flag1 = false;
					}
					if ((i3 - l3) * (anIntArray1666[j2] - anIntArray1666[k1])
							- (anIntArray1666[l] - anIntArray1666[k1])
							* (k4 - l3) > 0) {
						aBooleanArray1664[k] = false;
						if (i3 < 0 || l3 < 0 || k4 < 0
								|| i3 > DrawingArea.centerX
								|| l3 > DrawingArea.centerX
								|| k4 > DrawingArea.centerX)
							aBooleanArray1663[k] = true;
						else
							aBooleanArray1663[k] = false;
						int k5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2])
						/ 3 + anInt1653;
						anIntArrayArray1672[k5][anIntArray1671[k5]++] = k;
					}
				}
			}

		if (anIntArray1638 == null) {
			for (int i1 = anInt1652 - 1; i1 >= 0; i1--) {
				int l1 = anIntArray1671[i1];
				if (l1 > 0) {
					int ai[] = anIntArrayArray1672[i1];
					for (int j3 = 0; j3 < l1; j3++)
						method484(ai[j3]);

				}
			}

			return;
		}
		for (int j1 = 0; j1 < 12; j1++) {
			anIntArray1673[j1] = 0;
			anIntArray1677[j1] = 0;
		}

		for (int i2 = anInt1652 - 1; i2 >= 0; i2--) {
			int k2 = anIntArray1671[i2];
			if (k2 > 0) {
				int ai1[] = anIntArrayArray1672[i2];
				for (int i4 = 0; i4 < k2; i4++) {
					int l4 = ai1[i4];
					int l5 = anIntArray1638[l4];
					int j6 = anIntArray1673[l5]++;
					anIntArrayArray1674[l5][j6] = l4;
					if (l5 < 10)
						anIntArray1677[l5] += i2;
					else if (l5 == 10)
						anIntArray1675[j6] = i2;
					else
						anIntArray1676[j6] = i2;
				}

			}
		}

		int l2 = 0;
		if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
			l2 = (anIntArray1677[1] + anIntArray1677[2])
			/ (anIntArray1673[1] + anIntArray1673[2]);
		int k3 = 0;
		if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
			k3 = (anIntArray1677[3] + anIntArray1677[4])
			/ (anIntArray1673[3] + anIntArray1673[4]);
		int j4 = 0;
		if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
			j4 = (anIntArray1677[6] + anIntArray1677[8])
			/ (anIntArray1673[6] + anIntArray1673[8]);
		int i6 = 0;
		int k6 = anIntArray1673[10];
		int ai2[] = anIntArrayArray1674[10];
		int ai3[] = anIntArray1675;
		if (i6 == k6) {
			i6 = 0;
			k6 = anIntArray1673[11];
			ai2 = anIntArrayArray1674[11];
			ai3 = anIntArray1676;
		}
		int i5;
		if (i6 < k6)
			i5 = ai3[i6];
		else
			i5 = -1000;
		for (int l6 = 0; l6 < 10; l6++) {
			while (l6 == 0 && i5 > l2) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			while (l6 == 3 && i5 > k3) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			while (l6 == 5 && i5 > j4) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			int i7 = anIntArray1673[l6];
			int ai4[] = anIntArrayArray1674[l6];
			for (int j7 = 0; j7 < i7; j7++)
				method484(ai4[j7]);

		}

		while (i5 != -1000) {
			method484(ai2[i6++]);
			if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
				i6 = 0;
				ai2 = anIntArrayArray1674[11];
				k6 = anIntArray1673[11];
				ai3 = anIntArray1676;
			}
			if (i6 < k6)
				i5 = ai3[i6];
			else
				i5 = -1000;
		}
	}

	private final void method484(int i) {
		if (aBooleanArray1664[i]) {
			method485(i);
			return;
		}
		int j = triangleX[i];
		int k = triangleY[i];
		int l = triangleZ[i];
		Rasterizer.aBoolean1462 = aBooleanArray1663[i];
		if (anIntArray1639 == null)
			Rasterizer.anInt1465 = 0;
		else
			Rasterizer.anInt1465 = anIntArray1639[i];
		int i1;
		if (triangleDrawType == null)
			i1 = 0;
		else
			i1 = triangleDrawType[i] & 3;
		if (i1 == 0) {
			if(Configuration.distanceFog) {
				Rasterizer.drawFogTriangle(anIntArray1666[j], anIntArray1666[k],
						anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
						anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
						anIntArray1636[i]);
			}
			Rasterizer.drawGouraudTriangle(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
					anIntArray1636[i]);
			return;
		}
		if (i1 == 1) {
			if(Configuration.distanceFog) {
				Rasterizer.drawFogTriangle(anIntArray1666[j], anIntArray1666[k],
						anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
						anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
						anIntArray1636[i]);
			}
			Rasterizer.method376(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], anIntArray1691[anIntArray1634[i]]);

			return;
		}
		if (i1 == 2) {
			int j1 = triangleDrawType[i] >> 2;
			int l1 = anIntArray1643[j1];
			int j2 = anIntArray1644[j1];
			int l2 = anIntArray1645[j1];
			if(Configuration.distanceFog) {
				Rasterizer.drawTexturedFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l],
						anIntArray1665[j], anIntArray1665[k],anIntArray1665[l],
						anIntArray1634[i], anIntArray1635[i], anIntArray1636[i],
						anIntArray1668[l2], anIntArray1668[l1], anIntArray1668[j2],
						anIntArray1669[l2], anIntArray1669[l1], anIntArray1669[j2],
						anIntArray1670[l2], anIntArray1670[l1], anIntArray1670[j2],
						anIntArray1640[i]);
			}
			Rasterizer.method378(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
					anIntArray1636[i], anIntArray1668[l1], anIntArray1668[j2],
					anIntArray1668[l2], anIntArray1669[l1], anIntArray1669[j2],
					anIntArray1669[l2], anIntArray1670[l1], anIntArray1670[j2],
					anIntArray1670[l2], anIntArray1640[i]);
			return;
		}
		if (i1 == 3) {
			int k1 = triangleDrawType[i] >> 2;
				int i2 = anIntArray1643[k1];
				int k2 = anIntArray1644[k1];
				int i3 = anIntArray1645[k1];
			if(Configuration.distanceFog) {
				Rasterizer.drawTexturedFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l],
						anIntArray1665[j], anIntArray1665[k],anIntArray1665[l],
						anIntArray1634[i], anIntArray1635[i], anIntArray1636[i],
						anIntArray1668[i3], anIntArray1668[i2], anIntArray1668[k2],
						anIntArray1669[i3], anIntArray1669[i2], anIntArray1669[k2],
						anIntArray1670[i3], anIntArray1670[i2], anIntArray1670[k2],
						anIntArray1640[i]);
			}
				Rasterizer.method378(anIntArray1666[j], anIntArray1666[k],
						anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
						anIntArray1665[l], anIntArray1634[i], anIntArray1634[i],
						anIntArray1634[i], anIntArray1668[i2], anIntArray1668[k2],
						anIntArray1668[i3], anIntArray1669[i2], anIntArray1669[k2],
						anIntArray1669[i3], anIntArray1670[i2], anIntArray1670[k2],
						anIntArray1670[i3], anIntArray1640[i]);
		}
	}

	private final void method485(int i) {
		if (anIntArray1640 != null)
			if (anIntArray1640[i] == 65535)
				return;
		int j = Rasterizer.centerX;
		int k = Rasterizer.centerY;
		int l = 0;
		int i1 = triangleX[i];
		int j1 = triangleY[i];
		int k1 = triangleZ[i];
		int l1 = anIntArray1670[i1];
		int i2 = anIntArray1670[j1];
		int j2 = anIntArray1670[k1];

		if (l1 >= 50) {
			anIntArray1678[l] = anIntArray1665[i1];
			anIntArray1679[l] = anIntArray1666[i1];
			anIntArray1680[l++] = anIntArray1634[i];
		} else {
			int k2 = anIntArray1668[i1];
			int k3 = anIntArray1669[i1];
			int k4 = anIntArray1634[i];
			if (j2 >= 50) {
				int k5 = (50 - l1) * anIntArray1692[j2 - l1];
				anIntArray1678[l] = j + (k2 + ((anIntArray1668[k1] - k2) * k5 >> 16) << client.log_view_dist) / 50;
				anIntArray1679[l] = k + (k3 + ((anIntArray1669[k1] - k3) * k5 >> 16) << client.log_view_dist) / 50;
				anIntArray1680[l++] = k4 + ((anIntArray1636[i] - k4) * k5 >> 16);
			}
			if (i2 >= 50) {
				int l5 = (50 - l1) * anIntArray1692[i2 - l1];
				anIntArray1678[l] = j
				+ (k2 + ((anIntArray1668[j1] - k2) * l5 >> 16) << client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (k3 + ((anIntArray1669[j1] - k3) * l5 >> 16) << client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = k4
				+ ((anIntArray1635[i] - k4) * l5 >> 16);
			}
		}
		if (i2 >= 50) {
			anIntArray1678[l] = anIntArray1665[j1];
			anIntArray1679[l] = anIntArray1666[j1];
			anIntArray1680[l++] = anIntArray1635[i];
		} else {
			int l2 = anIntArray1668[j1];
			int l3 = anIntArray1669[j1];
			int l4 = anIntArray1635[i];
			if (l1 >= 50) {
				int i6 = (50 - i2) * anIntArray1692[l1 - i2];
				anIntArray1678[l] = j
				+ (l2 + ((anIntArray1668[i1] - l2) * i6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (l3 + ((anIntArray1669[i1] - l3) * i6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = l4
				+ ((anIntArray1634[i] - l4) * i6 >> 16);
			}
			if (j2 >= 50) {
				int j6 = (50 - i2) * anIntArray1692[j2 - i2];
				anIntArray1678[l] = j
				+ (l2 + ((anIntArray1668[k1] - l2) * j6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (l3 + ((anIntArray1669[k1] - l3) * j6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = l4
				+ ((anIntArray1636[i] - l4) * j6 >> 16);
			}
		}
		if (j2 >= 50) {
			anIntArray1678[l] = anIntArray1665[k1];
			anIntArray1679[l] = anIntArray1666[k1];
			anIntArray1680[l++] = anIntArray1636[i];
		} else {
			int i3 = anIntArray1668[k1];
			int i4 = anIntArray1669[k1];
			int i5 = anIntArray1636[i];
			if (i2 >= 50) {
				int k6 = (50 - j2) * anIntArray1692[i2 - j2];
				anIntArray1678[l] = j
				+ (i3 + ((anIntArray1668[j1] - i3) * k6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (i4 + ((anIntArray1669[j1] - i4) * k6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = i5
				+ ((anIntArray1635[i] - i5) * k6 >> 16);
			}
			if (l1 >= 50) {
				int l6 = (50 - j2) * anIntArray1692[l1 - j2];
				anIntArray1678[l] = j
				+ (i3 + ((anIntArray1668[i1] - i3) * l6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (i4 + ((anIntArray1669[i1] - i4) * l6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = i5
				+ ((anIntArray1634[i] - i5) * l6 >> 16);
			}
		}
		int j3 = anIntArray1678[0];
		int j4 = anIntArray1678[1];
		int j5 = anIntArray1678[2];
		int i7 = anIntArray1679[0];
		int j7 = anIntArray1679[1];
		int k7 = anIntArray1679[2];
		if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
			Rasterizer.aBoolean1462 = false;
			if (l == 3) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX
						|| j4 > DrawingArea.centerX || j5 > DrawingArea.centerX)
					Rasterizer.aBoolean1462 = true;
				int l7;
				if (triangleDrawType == null)
					l7 = 0;
				else
					l7 = triangleDrawType[i] & 3;
				if (l7 == 0) {
					Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2]);
				} else if (l7 == 1) {
					Rasterizer.method376(i7, j7, k7, j3, j4, j5,
							anIntArray1691[anIntArray1634[i]]);
				}else if (l7 == 2) {
					int j8 = triangleDrawType[i] >> 2;
					int k9 = anIntArray1643[j8];
					int k10 = anIntArray1644[j8];
					int k11 = anIntArray1645[j8];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], anIntArray1668[k9],
							anIntArray1668[k10], anIntArray1668[k11],
							anIntArray1669[k9], anIntArray1669[k10],
							anIntArray1669[k11], anIntArray1670[k9],
							anIntArray1670[k10], anIntArray1670[k11],
							anIntArray1640[i]);
				} else if (l7 == 3) {
					int k8 = triangleDrawType[i] >> 2;
					int l9 = anIntArray1643[k8];
					int l10 = anIntArray1644[k8];
					int l11 = anIntArray1645[k8];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5,
							anIntArray1634[i], anIntArray1634[i],
							anIntArray1634[i], anIntArray1668[l9],
							anIntArray1668[l10], anIntArray1668[l11],
							anIntArray1669[l9], anIntArray1669[l10],
							anIntArray1669[l11], anIntArray1670[l9],
							anIntArray1670[l10], anIntArray1670[l11],
							anIntArray1640[i]);
				}
			}
			if (l == 4) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX
						|| j4 > DrawingArea.centerX || j5 > DrawingArea.centerX
						|| anIntArray1678[3] < 0
						|| anIntArray1678[3] > DrawingArea.centerX)
					Rasterizer.aBoolean1462 = true;
				int i8;
				if (triangleDrawType == null)
					i8 = 0;
				else
					i8 = triangleDrawType[i] & 3;
				if (i8 == 0) {
					Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2]);
					Rasterizer.drawGouraudTriangle(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], anIntArray1680[0],
							anIntArray1680[2], anIntArray1680[3]);
					return;
				}
				if (i8 == 1) {
					int l8 = anIntArray1691[anIntArray1634[i]];
					Rasterizer.method376(i7, j7, k7, j3, j4, j5, l8);
					Rasterizer.method376(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], l8);
					return;
				}
				if (i8 == 2) {
					int i9 = triangleDrawType[i] >> 2;
					int i10 = anIntArray1643[i9];
					int i11 = anIntArray1644[i9];
					int i12 = anIntArray1645[i9];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], anIntArray1668[i10],
							anIntArray1668[i11], anIntArray1668[i12],
							anIntArray1669[i10], anIntArray1669[i11],
							anIntArray1669[i12], anIntArray1670[i10],
							anIntArray1670[i11], anIntArray1670[i12],
							anIntArray1640[i]);
					Rasterizer.method378(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], anIntArray1680[0],
							anIntArray1680[2], anIntArray1680[3],
							anIntArray1668[i10], anIntArray1668[i11],
							anIntArray1668[i12], anIntArray1669[i10],
							anIntArray1669[i11], anIntArray1669[i12],
							anIntArray1670[i10], anIntArray1670[i11],
							anIntArray1670[i12], anIntArray1640[i]);
					return;
				}
				if (i8 == 3) {
					int j9 = triangleDrawType[i] >> 2;
					int j10 = anIntArray1643[j9];
					int j11 = anIntArray1644[j9];
					int j12 = anIntArray1645[j9];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5,
							anIntArray1634[i], anIntArray1634[i],
							anIntArray1634[i], anIntArray1668[j10],
							anIntArray1668[j11], anIntArray1668[j12],
							anIntArray1669[j10], anIntArray1669[j11],
							anIntArray1669[j12], anIntArray1670[j10],
							anIntArray1670[j11], anIntArray1670[j12],
							anIntArray1640[i]);
					Rasterizer.method378(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], anIntArray1634[i],
							anIntArray1634[i], anIntArray1634[i],
							anIntArray1668[j10], anIntArray1668[j11],
							anIntArray1668[j12], anIntArray1669[j10],
							anIntArray1669[j11], anIntArray1669[j12],
							anIntArray1670[j10], anIntArray1670[j11],
							anIntArray1670[j12], anIntArray1640[i]);
				}
			}
		}
	}

	private final boolean method486(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
		if (j < k && j < l && j < i1)
			return false;
		if (j > k && j > l && j > i1)
			return false;
		if (i < j1 && i < k1 && i < l1)
			return false;
		return i <= j1 || i <= k1 || i <= l1;
	}

	private int anInt1614;
	private boolean aBoolean1615;
	private int anInt1616;
	private int anInt1617;
	private boolean aBoolean1618;
	private static int anInt1619 = -192;
	public static int anInt1620;
	public static Model aModel_1621 = new Model(true);
	private static int anIntArray1622[] = new int[2000];
	private static int anIntArray1623[] = new int[2000];
	private static int anIntArray1624[] = new int[2000];
	private static int anIntArray1625[] = new int[2000];
	public int vertexCount;
	public int verticesX[];
	public int verticesY[];
	public int verticesZ[];
	public int triangleCount;
	public int triangleX[];
	public int triangleY[];
	public int triangleZ[];
	public int anIntArray1634[];
	public int anIntArray1635[];
	public int anIntArray1636[];
	public int triangleDrawType[];
	public int anIntArray1638[];
	public int anIntArray1639[];
	public int[] anIntArray1640;
	public int anInt1641;
	public int anInt1642;
	public int anIntArray1643[];
	public int anIntArray1644[];
	public int anIntArray1645[];
	public int minX;
	public int maxX;
	public int maxZ;
	public int minZ;
	public int anInt1650;
	public int maxY;
	public int anInt1652;
	public int anInt1653;
	public int anInt1654;
	public int anIntArray1655[];
	public int anIntArray1656[];
	public int anIntArrayArray1657[][];
	public int anIntArrayArray1658[][];
	public boolean aBoolean1659;
	VertexNormal vertexNormalOffset[];
	static Class21 aClass21Array1661[];
	static OnDemandFetcherParent aOnDemandFetcherParent_1662;
	static boolean aBooleanArray1663[] = new boolean[16000];
	static boolean aBooleanArray1664[] = new boolean[16000];
	static int anIntArray1665[] = new int[16000];
	static int anIntArray1666[] = new int[16000];
	static int anIntArray1667[] = new int[16000];
	static int anIntArray1668[] = new int[16000];
	static int anIntArray1669[] = new int[16000];
	static int anIntArray1670[] = new int[16000];
	static int anIntArray1671[] = new int[16000];
	static int anIntArrayArray1672[][] = new int[16000][512];
	static int anIntArray1673[] = new int[12];
	static int anIntArrayArray1674[][] = new int[12][2000];
	static int anIntArray1675[] = new int[2000];
	static int anIntArray1676[] = new int[2000];
	static int anIntArray1677[] = new int[12];
	static int anIntArray1678[] = new int[10];
	static int anIntArray1679[] = new int[10];
	static int anIntArray1680[] = new int[10];
	static int anInt1681;
	static int anInt1682;
	static int anInt1683;
	public static boolean aBoolean1684;
	public static int anInt1685;
	public static int anInt1686;
	public static int anInt1687;
	public static long anIntArray1688[] = new long[1000];
	public static int SINE[];
	public static int COSINE[];
	static int anIntArray1691[];
	static int anIntArray1692[];

	static {
		SINE = Rasterizer.anIntArray1470;
		COSINE = Rasterizer.anIntArray1471;
		anIntArray1691 = Rasterizer.anIntArray1482;
		anIntArray1692 = Rasterizer.anIntArray1469;
	}
}
