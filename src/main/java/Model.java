public class Model extends Animable {

	public static void nullLoader() {
		aClass21Array1661 = null;
		hasAnEdgeToRestrict = null;
		outOfReach = null;
		projected_vertex_y = null;
		anIntArray1667 = null;
		camera_vertex_y = null;
		camera_vertex_x = null;
		camera_vertex_z = null;
		depthListIndices = null;
		faceLists = null;
		anIntArray1673 = null;
		anIntArrayArray1674 = null;
		anIntArray1675 = null;
		anIntArray1676 = null;
		anIntArray1677 = null;
	       	SINE = null;
        	COSINE = null;
        	hsl2rgb = null;
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
		verticesParticle = new int[numVertices];
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		vertexVSkin = new int[numVertices];
		face_render_type = new int[numTriangles];
		face_render_priorities = new int[numTriangles];
		face_alpha = new int[numTriangles];
		triangleTSkin = new int[numTriangles];
		if (i3 == 1)
			vertexVSkin = new int[numVertices];
		if (bool)
			face_render_type = new int[numTriangles];
		if (i2 == 255)
			face_render_priorities = new int[numTriangles];
		else
			G = (byte) i2;
		if (j2 == 1)
			face_alpha = new int[numTriangles];
		if (k2 == 1)
			triangleTSkin = new int[numTriangles];
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
			if (vertexVSkin != null)
				vertexVSkin[k11] = nc5.readUnsignedByte();
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
				face_render_type[i12] = nc2.readSignedByte();
				if (face_render_type[i12] == 2)
					triangleColours2[i12] =  65535;
				face_render_type[i12] = 0;
			}
			if (i2 == 255) {
				face_render_priorities[i12] = nc3.readSignedByte();
			}
			if (j2 == 1) {
				face_alpha[i12] = nc4.readSignedByte();
				if (face_alpha[i12] < 0)
					face_alpha[i12] = (256 + face_alpha[i12]);
			}
			if (k2 == 1)
				triangleTSkin[i12] = nc5.readUnsignedByte();
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
				face_render_priorities[i12] = i2;
		}
		face_color = triangleColours2;
		vertexCount = numVertices;
		triangleCount = numTriangles;
		verticesX = vertexX;
		verticesY = vertexY;
		verticesZ = vertexZ;
		face_a = facePoint1;
		face_b = facePoint2;
		face_c = facePoint3;

		convertTexturesTo317(D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, false, x);
	}

	public Model(int modelId) {
		byte[] is = aClass21Array1661[modelId].aByteArray368;
		if (is[is.length - 1] == -1 && is[is.length - 2] == -1) {
            read622Model(is, modelId);
        } else {
            readOldModel(modelId);
        }

		if (newmodel[modelId]) {
			if(face_render_priorities != null) {
				for(int j = 0; j < face_render_priorities.length; j++)
					face_render_priorities[j] = 10;
			}
	}

		int[][] attachments = ParticleAttachment.getAttachments(modelId);
		if (attachments != null) {
			for (int n = 0;
				 n < attachments.length;
				 n++) {
				int[] attach = attachments[n];
				if (attach[0] == -1) {
					for (int z = 0;
						 z < face_a.length;
						 ++z) {
						verticesParticle[face_a[z]] = attach[1] + 1;
					}
				} else if (attach[0] == -2) {
					for (int z = 0;
						 z < face_b.length;
						 ++z) {
						verticesParticle[face_b[z]] = attach[1] + 1;
					}
				} else if (attach[0] == -3) {
					for (int z = 0;
						 z < face_c.length;
						 ++z) {
						verticesParticle[face_c[z]] = attach[1] + 1;
					}
				} else if (attach[0] == -4) {
					for (int z = 0;
						 z < face_a.length;
						 ++z) {
						verticesParticle[face_a[z]] = attach[1] + 1;
					}

					for (int z = 0;
						 z < face_b.length;
						 ++z) {
						verticesParticle[face_b[z]] = attach[1] + 1;
					}

					for (int z = 0;
						 z < face_c.length;
						 ++z) {
						verticesParticle[face_c[z]] = attach[1] + 1;
					}
				} else {
					verticesParticle[attach[0]] = attach[1] + 1;
				}
			}
		}
}
	public void forceRecolour(int i, int j) {
		for (int k = 0;
			 k < triangleCount;
			 k++)
			face_color[k] = j;
	}

	public void recolour(int i, int j) {
		for (int k = 0;
			 k < triangleCount;
			 k++)
			if (face_color[k] == i) {
				face_color[k] = j;
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
            this.scaledVertices = true;
		}
		if (newformat == 15) {
			newmodel[modelID] = true;
		}
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
		verticesParticle = new int[numVertices];
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		vertexVSkin = new int[numVertices];
		face_render_type = new int[numTriangles];
		face_render_priorities = new int[numTriangles];
		face_alpha = new int[numTriangles];
		triangleTSkin = new int[numTriangles];
		if (i3 == 1)
			vertexVSkin = new int[numVertices];
		if (bool)
			face_render_type = new int[numTriangles];
		if (i2 == 255)
			face_render_priorities = new int[numTriangles];
		else
			G = (byte) i2;
		if (j2 == 1)
			face_alpha = new int[numTriangles];
		if (k2 == 1)
			triangleTSkin = new int[numTriangles];
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
			if (vertexVSkin != null)
				vertexVSkin[k11] = nc5.readUnsignedByte();
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
				face_render_type[i12] = nc2.readSignedByte();
				if (face_render_type[i12] == 2)
					triangleColours2[i12] = 65535;
				face_render_type[i12] = 0;
			}
			if (i2 == 255) {
				face_render_priorities[i12] = nc3.readSignedByte();
			}
			if (j2 == 1) {
				face_alpha[i12] = nc4.readSignedByte();
				if (face_alpha[i12] < 0)
					face_alpha[i12] = (256 + face_alpha[i12]);
			}
			if (k2 == 1)
				triangleTSkin[i12] = nc5.readUnsignedByte();
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
				face_render_priorities[i12] = i2;
		}
		face_color = triangleColours2;
		vertexCount = numVertices;
		triangleCount = numTriangles;
		verticesX = vertexX;
		verticesY = vertexY;
		verticesZ = vertexZ;
		face_a = facePoint1;
		face_b = facePoint2;
		face_c = facePoint3;

		convertTexturesTo317(D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, false, x);

        if (!scaledVertices) {
            downscale();
        }
	}
    public void downscale() {
        for (int i = 0;
             i < vertexCount;
             ++i) {
            verticesX[i] = (verticesX[i] + 7) >> 2;
            verticesY[i] = (verticesY[i] + 7) >> 2;
            verticesZ[i] = (verticesZ[i] + 7) >> 2;
        }
    }

	private void readOldModel(int i) {
		int j = -870;
		anInt1614 = 9;
		rendersWithinOneTile = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		Class21 class21 = aClass21Array1661[i];
		vertexCount = class21.anInt369;
		triangleCount = class21.anInt370;
		numberOfTexturesFaces = class21.anInt371;
		verticesParticle = new int[vertexCount];
		verticesX = new int[vertexCount];
		verticesY = new int[vertexCount];
		verticesZ = new int[vertexCount];
		face_a = new int[triangleCount];
		face_b = new int[triangleCount];
		while (j >= 0)
			aBoolean1618 = !aBoolean1618;
		face_c = new int[triangleCount];
		textures_face_a = new int[numberOfTexturesFaces];
		textures_face_b = new int[numberOfTexturesFaces];
		textures_face_c = new int[numberOfTexturesFaces];
		if (class21.anInt376 >= 0)
			vertexVSkin = new int[vertexCount];
		if (class21.anInt380 >= 0)
			face_render_type = new int[triangleCount];
		if (class21.anInt381 >= 0)
			face_render_priorities = new int[triangleCount];
		else
			face_priority = -class21.anInt381 - 1;
		if (class21.anInt382 >= 0)
			face_alpha = new int[triangleCount];
		if (class21.anInt383 >= 0)
			triangleTSkin = new int[triangleCount];
		face_color = new int[triangleCount];
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
			if (vertexVSkin != null)
				vertexVSkin[j1] = stream_4.readUnsignedByte();
		}
		stream.currentPosition = class21.anInt379;
		stream_1.currentPosition = class21.anInt380;
		stream_2.currentPosition = class21.anInt381;
		stream_3.currentPosition = class21.anInt382;
		stream_4.currentPosition = class21.anInt383;
		for (int l1 = 0; l1 < triangleCount; l1++) {
			face_color[l1] =  stream.readUnsignedShort();
			if (face_render_type != null)
				face_render_type[l1] = stream_1.readUnsignedByte();
			if (face_render_priorities != null)
				face_render_priorities[l1] = stream_2.readUnsignedByte();
			if (face_alpha != null) {
				face_alpha[l1] = stream_3.readUnsignedByte();
			}
			if (triangleTSkin != null)
				triangleTSkin[l1] = stream_4.readUnsignedByte();
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
				face_a[l3] = j2;
				face_b[l3] = l2;
				face_c[l3] = j3;
			}
			if (i4 == 2) {
				j2 = j2;
				l2 = j3;
				j3 = stream.method421() + k3;
				k3 = j3;
				face_a[l3] = j2;
				face_b[l3] = l2;
				face_c[l3] = j3;
			}
			if (i4 == 3) {
				j2 = j3;
				l2 = l2;
				j3 = stream.method421() + k3;
				k3 = j3;
				face_a[l3] = j2;
				face_b[l3] = l2;
				face_c[l3] = j3;
			}
			if (i4 == 4) {
				int k4 = j2;
				j2 = l2;
				l2 = k4;
				j3 = stream.method421() + k3;
				k3 = j3;
				face_a[l3] = j2;
				face_b[l3] = l2;
				face_c[l3] = j3;
			}
		}
		stream.currentPosition = class21.anInt384;
		for (int j4 = 0; j4 < numberOfTexturesFaces; j4++) {
			textures_face_a[j4] = stream.readUnsignedShort();
			textures_face_b[j4] = stream.readUnsignedShort();
			textures_face_c[j4] = stream.readUnsignedShort();
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
			return new Model(j);
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
		rendersWithinOneTile = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		if (!flag)
			aBoolean1618 = !aBoolean1618;
	}

	public Model(int i, Model amodel[], int j) {
		anInt1614 = 9;
		rendersWithinOneTile = false;
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
		numberOfTexturesFaces = 0;
		face_priority = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				vertexCount += model.vertexCount;
				triangleCount += model.triangleCount;
				numberOfTexturesFaces += model.numberOfTexturesFaces;
				flag |= model.face_render_type != null;
				if (model.face_render_priorities != null) {
					flag1 = true;
				} else {
					if (face_priority == -1)
						face_priority = model.face_priority;
					if (face_priority != model.face_priority)
						flag1 = true;
				}
				flag2 |= model.face_alpha != null;
				flag3 |= model.triangleTSkin != null;
                scaledVertices |= model.scaledVertices;
			}
		}
		verticesParticle = new int[vertexCount];
		verticesX = new int[vertexCount];
		verticesY = new int[vertexCount];
		verticesZ = new int[vertexCount];
		vertexVSkin = new int[vertexCount];
		face_a = new int[triangleCount];
		face_b = new int[triangleCount];
		face_c = new int[triangleCount];
		textures_face_a = new int[numberOfTexturesFaces];
		textures_face_b = new int[numberOfTexturesFaces];
		textures_face_c = new int[numberOfTexturesFaces];
		if (flag)
			face_render_type = new int[triangleCount];
		if (flag1)
			face_render_priorities = new int[triangleCount];
		if (flag2)
			face_alpha = new int[triangleCount];
		if (flag3)
			triangleTSkin = new int[triangleCount];
		face_color = new int[triangleCount];
		vertexCount = 0;
		triangleCount = 0;
		numberOfTexturesFaces = 0;
		int l = 0;
		for (int i1 = 0; i1 < i; i1++) {
			Model model_1 = amodel[i1];
			if (model_1 != null) {
				for (int j1 = 0; j1 < model_1.triangleCount; j1++) {
					if (flag)
						if (model_1.face_render_type == null) {
							face_render_type[triangleCount] = 0;
						} else {
							int k1 = model_1.face_render_type[j1];
							if ((k1 & 2) == 2)
								k1 += l << 2;
							face_render_type[triangleCount] = k1;
						}
					if (flag1)
						if (model_1.face_render_priorities == null)
							face_render_priorities[triangleCount] = model_1.face_priority;
						else
							face_render_priorities[triangleCount] = model_1.face_render_priorities[j1];
					if (flag2)
						if (model_1.face_alpha == null)
							face_alpha[triangleCount] = 0;
						else
							face_alpha[triangleCount] = model_1.face_alpha[j1];

					if (flag3 && model_1.triangleTSkin != null)
						triangleTSkin[triangleCount] = model_1.triangleTSkin[j1];
					face_color[triangleCount] = model_1.face_color[j1];
					face_a[triangleCount] = method465(model_1,
							model_1.face_a[j1]);
					face_b[triangleCount] = method465(model_1,
							model_1.face_b[j1]);
					face_c[triangleCount] = method465(model_1,
							model_1.face_c[j1]);
					triangleCount++;
				}

				for (int l1 = 0; l1 < model_1.numberOfTexturesFaces; l1++) {
					textures_face_a[numberOfTexturesFaces] = method465(model_1,
							model_1.textures_face_a[l1]);
					textures_face_b[numberOfTexturesFaces] = method465(model_1,
							model_1.textures_face_b[l1]);
					textures_face_c[numberOfTexturesFaces] = method465(model_1,
							model_1.textures_face_c[l1]);
					numberOfTexturesFaces++;
				}

				l += model_1.numberOfTexturesFaces;
			}
		}

	}

	public Model(Model amodel[]) {
		int i = 2;
		anInt1614 = 9;
		rendersWithinOneTile = false;
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
		numberOfTexturesFaces = 0;
		face_priority = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				vertexCount += model.vertexCount;
				triangleCount += model.triangleCount;
				numberOfTexturesFaces += model.numberOfTexturesFaces;
				flag1 |= model.face_render_type != null;
				if (model.face_render_priorities != null) {
					flag2 = true;
				} else {
					if (face_priority == -1)
						face_priority = model.face_priority;
					if (face_priority != model.face_priority)
						flag2 = true;
				}
				flag3 |= model.face_alpha != null;
				flag4 |= model.face_color != null;
                scaledVertices |= model.scaledVertices;
			}
		}
		verticesParticle = new int[vertexCount];
		verticesX = new int[vertexCount];
		verticesY = new int[vertexCount];
		verticesZ = new int[vertexCount];
		face_a = new int[triangleCount];
		face_b = new int[triangleCount];
		face_c = new int[triangleCount];
		face_shade_a = new int[triangleCount];
		face_shade_b = new int[triangleCount];
		face_shade_c = new int[triangleCount];
		textures_face_a = new int[numberOfTexturesFaces];
		textures_face_b = new int[numberOfTexturesFaces];
		textures_face_c = new int[numberOfTexturesFaces];
		if (flag1)
			face_render_type = new int[triangleCount];
		if (flag2)
			face_render_priorities = new int[triangleCount];
		if (flag3)
			face_alpha = new int[triangleCount];
		if (flag4)
			face_color = new int[triangleCount];
		vertexCount = 0;
		triangleCount = 0;
		numberOfTexturesFaces = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < i; j1++) {
			Model model_1 = amodel[j1];
			if (model_1 != null) {
				int k1 = vertexCount;
				for (int l1 = 0; l1 < model_1.vertexCount; l1++) {
                    int x = model_1.verticesX[l1];
                    int y = model_1.verticesY[l1];
                    int z = model_1.verticesZ[l1];
					int p = model_1.verticesParticle[l1];
                    if (scaledVertices && !model_1.scaledVertices) {
                        x <<= 2;
                        y <<= 2;
                        z <<= 2;
                    }
                    verticesX[vertexCount] = x;
					verticesY[vertexCount] = y;
					verticesZ[vertexCount] = z;
					this.verticesParticle[this.vertexCount] = p;
					vertexCount++;
				}

				for (int i2 = 0; i2 < model_1.triangleCount; i2++) {
					face_a[triangleCount] = model_1.face_a[i2] + k1;
					face_b[triangleCount] = model_1.face_b[i2] + k1;
					face_c[triangleCount] = model_1.face_c[i2] + k1;
					face_shade_a[triangleCount] = model_1.face_shade_a[i2];
					face_shade_b[triangleCount] = model_1.face_shade_b[i2];
					face_shade_c[triangleCount] = model_1.face_shade_c[i2];
					if (flag1)
						if (model_1.face_render_type == null) {
							face_render_type[triangleCount] = 0;
						} else {
							int j2 = model_1.face_render_type[i2];
							if ((j2 & 2) == 2)
								j2 += i1 << 2;
							face_render_type[triangleCount] = j2;
						}
					if (flag2)
						if (model_1.face_render_priorities == null)
							face_render_priorities[triangleCount] = model_1.face_priority;
						else
							face_render_priorities[triangleCount] = model_1.face_render_priorities[i2];
					if (flag3)
						if (model_1.face_alpha == null)
							face_alpha[triangleCount] = 0;
						else
							face_alpha[triangleCount] = model_1.face_alpha[i2];
					if (flag4 && model_1.face_color != null)
						face_color[triangleCount] = model_1.face_color[i2];

					triangleCount++;
				}

				for (int k2 = 0; k2 < model_1.numberOfTexturesFaces; k2++) {
					textures_face_a[numberOfTexturesFaces] = model_1.textures_face_a[k2] + k1;
					textures_face_b[numberOfTexturesFaces] = model_1.textures_face_b[k2] + k1;
					textures_face_c[numberOfTexturesFaces] = model_1.textures_face_c[k2] + k1;
					numberOfTexturesFaces++;
				}

				i1 += model_1.numberOfTexturesFaces;
			}
		}

		calculateDiagonals(false);
	}

	public Model(int derp, boolean flag, boolean flag1, boolean flag2, Model model) {
		anInt1614 = 9;
		rendersWithinOneTile = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		vertexCount = model.vertexCount;
		triangleCount = model.triangleCount;
		numberOfTexturesFaces = model.numberOfTexturesFaces;
		if (flag2) {
			verticesParticle = model.verticesParticle;
			verticesX = model.verticesX;
			verticesY = model.verticesY;
			verticesZ = model.verticesZ;
		} else {
			verticesParticle = new int[vertexCount];
			verticesX = new int[vertexCount];
			verticesY = new int[vertexCount];
			verticesZ = new int[vertexCount];
			for (int j = 0; j < vertexCount; j++) {
				verticesX[j] = model.verticesX[j];
				verticesY[j] = model.verticesY[j];
				verticesZ[j] = model.verticesZ[j];
				verticesParticle[j] = model.verticesParticle[j];
			}

		}
		if (flag) {
			face_color = model.face_color;
		} else {
			face_color = new int[triangleCount];
			for (int k = 0; k < triangleCount; k++)
				face_color[k] = model.face_color[k];

		}
		if (flag1) {
			face_alpha = model.face_alpha;
		} else {
			face_alpha = new int[triangleCount];
			if (model.face_alpha == null) {
				for (int l = 0; l < triangleCount; l++)
					face_alpha[l] = 0;

			} else {
				for (int i1 = 0; i1 < triangleCount; i1++)
					face_alpha[i1] = model.face_alpha[i1];

			}
		}
		vertexVSkin = model.vertexVSkin;
		triangleTSkin = model.triangleTSkin;
		face_render_type = model.face_render_type;
		face_a = model.face_a;
		face_b = model.face_b;
		face_c = model.face_c;
		face_render_priorities = model.face_render_priorities;
		face_priority = model.face_priority;
		textures_face_a = model.textures_face_a;
		textures_face_b = model.textures_face_b;
		textures_face_c = model.textures_face_c;
        scaledVertices = model.scaledVertices;
	}

	public Model(boolean flag, boolean flag1, Model model) {
		anInt1614 = 9;
		rendersWithinOneTile = false;
		anInt1616 = 360;
		anInt1617 = 1;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		vertexCount = model.vertexCount;
		triangleCount = model.triangleCount;
		numberOfTexturesFaces = model.numberOfTexturesFaces;
		if (flag) {
			verticesY = new int[vertexCount];
			for (int j = 0; j < vertexCount; j++)
				verticesY[j] = model.verticesY[j];

		} else {
			verticesY = model.verticesY;
		}
		if (flag1) {
			face_shade_a = new int[triangleCount];
			face_shade_b = new int[triangleCount];
			face_shade_c = new int[triangleCount];
			for (int k = 0; k < triangleCount; k++) {
				face_shade_a[k] = model.face_shade_a[k];
				face_shade_b[k] = model.face_shade_b[k];
				face_shade_c[k] = model.face_shade_c[k];
			}

			face_render_type = new int[triangleCount];
			if (model.face_render_type == null) {
				for (int l = 0; l < triangleCount; l++)
					face_render_type[l] = 0;

			} else {
				for (int i1 = 0; i1 < triangleCount; i1++)
					face_render_type[i1] = model.face_render_type[i1];

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
			face_shade_a = model.face_shade_a;
			face_shade_b = model.face_shade_b;
			face_shade_c = model.face_shade_c;
			face_render_type = model.face_render_type;
		}
		verticesParticle = model.verticesParticle;
		verticesX = model.verticesX;
		verticesZ = model.verticesZ;
		face_color = model.face_color;
		face_alpha = model.face_alpha;
		face_render_priorities = model.face_render_priorities;
		face_priority = model.face_priority;
		face_a = model.face_a;
		face_b = model.face_b;
		face_c = model.face_c;
		textures_face_a = model.textures_face_a;
		textures_face_b = model.textures_face_b;
		textures_face_c = model.textures_face_c;
		super.modelHeight = ((Animable) (model)).modelHeight;
		anInt1650 = model.anInt1650;
		anInt1653 = model.anInt1653;
		anInt1652 = model.anInt1652;
		minX = model.minX;
		maxZ = model.maxZ;
		minZ = model.minZ;
		maxX = model.maxX;
        scaledVertices = model.scaledVertices;
	}

	public void method464(int i, Model model, boolean flag) {
		vertexCount = model.vertexCount;
		triangleCount = model.triangleCount;
		numberOfTexturesFaces = model.numberOfTexturesFaces;
		if (anIntArray1622.length < vertexCount) {
			anIntArray1622 = new int[vertexCount + 10000];
			anIntArray1623 = new int[vertexCount + 10000];
			anIntArray1624 = new int[vertexCount + 10000];
		}
		verticesParticle = new int[vertexCount];
		verticesX = anIntArray1622;
		verticesY = anIntArray1623;
		verticesZ = anIntArray1624;
		for (int k = 0; k < vertexCount; k++) {
			verticesX[k] = model.verticesX[k];
			verticesY[k] = model.verticesY[k];
			verticesZ[k] = model.verticesZ[k];
			verticesParticle[k] = model.verticesParticle[k];
		}

		if (flag) {
			face_alpha = model.face_alpha;
		} else {
			if (anIntArray1625.length < triangleCount)
				anIntArray1625 = new int[triangleCount + 100];
			face_alpha = anIntArray1625;
			if (model.face_alpha == null) {
				for (int l = 0; l < triangleCount; l++)
					face_alpha[l] = 0;

			} else {
				for (int i1 = 0; i1 < triangleCount; i1++)
					face_alpha[i1] = model.face_alpha[i1];

			}
		}
		face_render_type = model.face_render_type;
		face_color = model.face_color;
		face_render_priorities = model.face_render_priorities;
		face_priority = model.face_priority;
		triangleSkin = model.triangleSkin;
		vertexSkin = model.vertexSkin;
		face_a = model.face_a;
		face_b = model.face_b;
		face_c = model.face_c;
		face_shade_a = model.face_shade_a;
		face_shade_b = model.face_shade_b;
		face_shade_c = model.face_shade_c;
		textures_face_a = model.textures_face_a;
		textures_face_b = model.textures_face_b;
		textures_face_c = model.textures_face_c;
        scaledVertices = model.scaledVertices;
	}

	private final int method465(Model model, int i) {
		int j = -1;
		int k = model.verticesX[i];
		int l = model.verticesY[i];
		int i1 = model.verticesZ[i];
		int p = model.verticesParticle[i];
        if (scaledVertices && !model.scaledVertices) {
            k <<= 2;
            l <<= 2;
            i1 <<= 2;
        }
		for (int j1 = 0; j1 < vertexCount; j1++) {
			if (k != verticesX[j1] || l != verticesY[j1] || i1 != verticesZ[j1]) {
				continue;
			}
			j = j1;
			break;
		}

		if (j == -1) {
			verticesParticle[vertexCount] = p;
			verticesX[vertexCount] = k;
			verticesY[vertexCount] = l;
			verticesZ[vertexCount] = i1;
			if (model.vertexVSkin != null)
				vertexVSkin[vertexCount] = model.vertexVSkin[i];
			j = vertexCount++;
		}
		return j;
	}

	public void calculateDiagonals(boolean flag) {
		super.modelHeight = 0;
		anInt1650 = 0;
		maxY = 0;
		for (int i = 0; i < vertexCount; i++) {
			int j = verticesX[i];
			int k = verticesY[i];
			int l = verticesZ[i];
            if (scaledVertices) {
                j >>= 2;
                k >>= 2;
                l >>= 2;
            }
			if (-k > super.modelHeight)
				super.modelHeight = -k;
			if (k > maxY)
				maxY = k;
			int i1 = j * j + l * l;
			if (i1 > anInt1650)
				anInt1650 = i1;
		}
		anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight
				* super.modelHeight) + 0.98999999999999999D);
		anInt1652 = anInt1653
		+ (int) (Math.sqrt(anInt1650 * anInt1650 + maxY
				* maxY) + 0.98999999999999999D);
	}

	public void method467(boolean flag) {
		super.modelHeight = 0;
		maxY = 0;
		for (int i = 0; i < vertexCount; i++) {
			int j = verticesY[i];
			if (-j > super.modelHeight)
				super.modelHeight = -j;
			if (j > maxY)
				maxY = j;
		}

		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight
				* super.modelHeight) + 0.98999999999999999D);
		anInt1652 = anInt1653
		+ (int) (Math.sqrt(anInt1650 * anInt1650 + maxY
				* maxY) + 0.98999999999999999D);
	}

	public void method468(int i) {
		super.modelHeight = 0;
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
            if (scaledVertices) {
                k >>= 2;
                l >>= 2;
                i1 >>= 2;
            }
			if (k < minX)
				minX = k;
			if (k > maxX)
				maxX = k;
			if (i1 < minZ)
				minZ = i1;
			if (i1 > maxZ)
				maxZ = i1;
			if (-l > super.modelHeight)
				super.modelHeight = -l;
			if (l > maxY)
				maxY = l;
			int j1 = k * k + i1 * i1;
			if (j1 > anInt1650)
				anInt1650 = j1;
		}

		anInt1650 = (int) Math.sqrt(anInt1650);
		anInt1653 = (int) Math.sqrt(anInt1650 * anInt1650 + super.modelHeight
				* super.modelHeight);
		if (i != 21073) {
			return;
		} else {
			anInt1652 = anInt1653
			+ (int) Math.sqrt(anInt1650 * anInt1650 + maxY
					* maxY);
			return;
		}
	}

	public void createBones() {
		if (vertexVSkin != null) {
			int ai[] = new int[256];
			int j = 0;
			for (int l = 0; l < vertexCount; l++) {
				int j1 = vertexVSkin[l];
				ai[j1]++;
				if (j1 > j)
					j = j1;
			}

			vertexSkin = new int[j + 1][];
			for (int k1 = 0; k1 <= j; k1++) {
				vertexSkin[k1] = new int[ai[k1]];
				ai[k1] = 0;
			}

			for (int j2 = 0; j2 < vertexCount; j2++) {
				int l2 = vertexVSkin[j2];
				vertexSkin[l2][ai[l2]++] = j2;
			}

			vertexVSkin = null;
		}
		if (triangleTSkin != null) {
			int ai1[] = new int[256];
			int k = 0;
			for (int i1 = 0; i1 < triangleCount; i1++) {
				int l1 = triangleTSkin[i1];
				ai1[l1]++;
				if (l1 > k)
					k = l1;
			}

			triangleSkin = new int[k + 1][];
			for (int i2 = 0; i2 <= k; i2++) {
				triangleSkin[i2] = new int[ai1[i2]];
				ai1[i2] = 0;
			}

			for (int k2 = 0; k2 < triangleCount; k2++) {
				int i3 = triangleTSkin[k2];
				triangleSkin[i3][ai1[i3]++] = k2;
			}

			triangleTSkin = null;
		}
	}

	public void method470(int i, int j) {
		if (vertexSkin == null)
			return;
		if (i == -1)
			return;
		FrameLoader frameLoader = FrameLoader.method531(anInt1614, i);
		if (frameLoader == null)
			return;
		Skinlist skinlist = frameLoader.aSkinlist_637;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		for (int k = 0; k < frameLoader.anInt638; k++) {
			int l = frameLoader.anIntArray639[k];
			method472(skinlist.anIntArray342[l], skinlist.anIntArrayArray343[l],
					frameLoader.anIntArray640[k], frameLoader.anIntArray641[k],
					frameLoader.anIntArray642[k]);
		}

	}

	public void method471(int i, int ai[], int j, int k) {
		if (k == -1)
			return;
		if (ai == null || j == -1) {
			method470(k, 40542);
			return;
		}
		FrameLoader frameLoader = FrameLoader.method531(anInt1614, k);
		if (frameLoader == null)
			return;
		FrameLoader frameLoader_1 = FrameLoader.method531(anInt1614, k);
		if (frameLoader_1 == null) {
			method470(k, 40542);
			return;
		}
		Skinlist skinlist = frameLoader.aSkinlist_637;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		int l = 0;
		int i1 = ai[l++];
		for (int j1 = 0; j1 < frameLoader.anInt638; j1++) {
			int k1;
			for (k1 = frameLoader.anIntArray639[j1]; k1 > i1; i1 = ai[l++])
				;
			if (k1 != i1 || skinlist.anIntArray342[k1] == 0)
				method472(skinlist.anIntArray342[k1],
						skinlist.anIntArrayArray343[k1],
						frameLoader.anIntArray640[j1], frameLoader.anIntArray641[j1],
						frameLoader.anIntArray642[j1]);
		}

		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		l = 0;
		i1 = ai[l++];
		for (int l1 = 0; l1 < frameLoader_1.anInt638; l1++) {
			int i2;
			for (i2 = frameLoader_1.anIntArray639[l1]; i2 > i1; i1 = ai[l++])
				;
			if (i2 == i1 || skinlist.anIntArray342[i2] == 0)
				method472(skinlist.anIntArray342[i2],
						skinlist.anIntArrayArray343[i2],
						frameLoader_1.anIntArray640[l1],
						frameLoader_1.anIntArray641[l1],
						frameLoader_1.anIntArray642[l1]);
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
				if (l3 < vertexSkin.length) {
					int ai5[] = vertexSkin[l3];
					for (int i5 = 0; i5 < ai5.length; i5++) {
						int j6 = ai5[i5];
						anInt1681 += verticesX[j6] >> (scaledVertices ? 2 : 0);
						anInt1682 += verticesY[j6] >> (scaledVertices ? 2 : 0);
						anInt1683 += verticesZ[j6] >> (scaledVertices ? 2 : 0);
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
				if (l2 < vertexSkin.length) {
					int ai1[] = vertexSkin[l2];
					for (int i4 = 0; i4 < ai1.length; i4++) {
						int j5 = ai1[i4];
						verticesX[j5] += j<< (scaledVertices ? 2 : 0);
						verticesY[j5] += k<< (scaledVertices ? 2 : 0);
						verticesZ[j5] += l<< (scaledVertices ? 2 : 0);
					}

				}
			}

			return;
		}
		if (i == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = ai[l1];
				if (i3 < vertexSkin.length) {
					int ai2[] = vertexSkin[i3];
					for (int j4 = 0; j4 < ai2.length; j4++) {
						int k5 = ai2[j4];
						verticesX[k5] -= anInt1681<< (scaledVertices ? 2 : 0);
						verticesY[k5] -= anInt1682<< (scaledVertices ? 2 : 0);
						verticesZ[k5] -= anInt1683<< (scaledVertices ? 2 : 0);
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
						verticesX[k5] += anInt1681<< (scaledVertices ? 2 : 0);
						verticesY[k5] += anInt1682<< (scaledVertices ? 2 : 0);
						verticesZ[k5] += anInt1683<< (scaledVertices ? 2 : 0);
					}

				}
			}
			return;
		}
		if (i == 3) {
			for (int i2 = 0; i2 < i1; i2++) {
				int j3 = ai[i2];
				if (j3 < vertexSkin.length) {
					int ai3[] = vertexSkin[j3];
					for (int k4 = 0; k4 < ai3.length; k4++) {
						int l5 = ai3[k4];
						verticesX[l5] -= anInt1681 << (scaledVertices ? 2 : 0);
						verticesY[l5] -= anInt1682 << (scaledVertices ? 2 : 0);
						verticesZ[l5] -= anInt1683 << (scaledVertices ? 2 : 0);
						verticesX[l5] = (verticesX[l5] * j) / 128;
						verticesY[l5] = (verticesY[l5] * k) / 128;
						verticesZ[l5] = (verticesZ[l5] * l) / 128;
						verticesX[l5] += anInt1681<< (scaledVertices ? 2 : 0);
						verticesY[l5] += anInt1682<< (scaledVertices ? 2 : 0);
						verticesZ[l5] += anInt1683<< (scaledVertices ? 2 : 0);
					}
				}
			}
			return;
		}
		if (i == 5 && triangleSkin != null && face_alpha != null) {
			for (int j2 = 0; j2 < i1; j2++) {
				int k3 = ai[j2];
				if (k3 < triangleSkin.length) {
					int ai4[] = triangleSkin[k3];
					for (int l4 = 0; l4 < ai4.length; l4++) {
						int i6 = ai4[l4];
						face_alpha[i6] += j * 8;
						if (face_alpha[i6] < 0)
							face_alpha[i6] = 0;
						if (face_alpha[i6] > 255)
							face_alpha[i6] = 255;
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

	public void translate(int i, int j, int k, int l) {
		if (scaledVertices) {
			i <<= 2;
			l <<= 2;
			j <<= 2;
		}
		for (int i1 = 0; i1 < vertexCount; i1++) {
			verticesX[i1] += i;
			verticesY[i1] += j;
			verticesZ[i1] += l;
		}
	}

	public void method476(int i, int j) {
		for (int k = 0; k < triangleCount; k++)
			if (face_color[k] == i)
				face_color[k] = j;
	}

	public void method477(int i) {
		for (int j = 0; j < vertexCount; j++)
			verticesZ[j] = -verticesZ[j];
		for (int k = 0; k < triangleCount; k++) {
			int l = face_a[k];
			face_a[k] = face_c[k];
			face_c[k] = l;
		}
	}

	public void scaleT(int i, int j, int k, int l) {
		for (int i1 = 0; i1 < vertexCount; i1++) {
			verticesX[i1] = (verticesX[i1] * i) / 128;
			verticesY[i1] = (verticesY[i1] * l) / 128;
			verticesZ[i1] = (verticesZ[i1] * j) / 128;
		}

	}

public final void method479(int i, int j, int k, int l, int i1, boolean flag) {
		int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
		int k1 = j * j1 >> 8;
		if (face_shade_a == null) {
			face_shade_a = new int[triangleCount];
			face_shade_b = new int[triangleCount];
			face_shade_c = new int[triangleCount];
		}
		if (super.vertexNormals == null) {
			super.vertexNormals = new VertexNormal[vertexCount];
			for (int l1 = 0; l1 < vertexCount; l1++)
				super.vertexNormals[l1] = new VertexNormal();

		}
		for (int i2 = 0; i2 < triangleCount; i2++) {
			if (face_color != null) {
				if (face_color[i2] == 65535) {
					face_a[i2] = 0;
					face_b[i2] = 0;
					face_c[i2] = 0;
				}
			}
			int j2 = face_a[i2];
			int l2 = face_b[i2];
			int i3 = face_c[i2];
			int j3 = verticesX[l2] - verticesX[j2] >> (scaledVertices ? 2 : 0);
			int k3 = verticesY[l2] - verticesY[j2] >> (scaledVertices ? 2 : 0);
			int l3 = verticesZ[l2] - verticesZ[j2] >> (scaledVertices ? 2 : 0);
			int i4 = verticesX[i3] - verticesX[j2] >> (scaledVertices ? 2 : 0);
			int j4 = verticesY[i3] - verticesY[j2] >> (scaledVertices ? 2 : 0);
			int k4 = verticesZ[i3] - verticesZ[j2] >> (scaledVertices ? 2 : 0);
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

			if (face_render_type == null || (face_render_type[i2] & 1) == 0) {

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
				face_shade_a[i2] = method481(face_color[i2], l5,
						face_render_type[i2]);

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
			calculateDiagonals(false);
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
			int k1 = face_a[j1];
			int i2 = face_b[j1];
			int j2 = face_c[j1];
			if (face_render_type == null) {
				int i3 = face_color[j1];
				VertexNormal class33 = super.vertexNormals[k1];
				int k2 = i
				+ (k * class33.x + l * class33.y + i1
						* class33.z) / (j * class33.magnitude);
				face_shade_a[j1] = method481(i3, k2, 0);
				class33 = super.vertexNormals[i2];
				k2 = i
				+ (k * class33.x + l * class33.y + i1
						* class33.z) / (j * class33.magnitude);
				face_shade_b[j1] = method481(i3, k2, 0);
				class33 = super.vertexNormals[j2];
				k2 = i
				+ (k * class33.x + l * class33.y + i1
						* class33.z) / (j * class33.magnitude);
				face_shade_c[j1] = method481(i3, k2, 0);
			} else if ((face_render_type[j1] & 1) == 0) {
				int j3 = face_color[j1];
				int k3 = face_render_type[j1];
				VertexNormal class33_1 = super.vertexNormals[k1];
				int l2 = i
				+ (k * class33_1.x + l * class33_1.y + i1
						* class33_1.z)
						/ (j * class33_1.magnitude);
				face_shade_a[j1] = method481(j3, l2, k3);
				class33_1 = super.vertexNormals[i2];
				l2 = i
				+ (k * class33_1.x + l * class33_1.y + i1
						* class33_1.z)
						/ (j * class33_1.magnitude);
				face_shade_b[j1] = method481(j3, l2, k3);
				class33_1 = super.vertexNormals[j2];
				l2 = i
				+ (k * class33_1.x + l * class33_1.y + i1
						* class33_1.z)
						/ (j * class33_1.magnitude);
				face_shade_c[j1] = method481(j3, l2, k3);
			}
		}

		super.vertexNormals = null;
		vertexNormalOffset = null;
		vertexVSkin = null;
		triangleTSkin = null;
		if (face_render_type != null) {
			for (int l1 = 0; l1 < triangleCount; l1++)
				if ((face_render_type[l1] & 2) == 2)
					return;

		}
		face_color = null;
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

	public final void renderSingle(int hai, int rotation_2, int offsetX, int rotation_1, int offsetY, int zoom_sine, int zoom_cosine) {
		int i = 0;
		int j2 = SINE[i];
		int k2 = COSINE[i];
		int l2 = SINE[rotation_2];
		int i3 = COSINE[rotation_2];
		int j3 = SINE[offsetX];
		int k3 = COSINE[offsetX];
		int l3 = SINE[rotation_1];
		int i4 = COSINE[rotation_1];
		int calculated_zoom = zoom_sine * l3 + zoom_cosine * i4 >> 16;
			for (int k4 = 0; k4 < vertexCount; k4++) {
				int baseVertexX = verticesX[k4] << (scaledVertices ? 0 : 2);
				int baseVertexY = verticesY[k4] << (scaledVertices ? 0 : 2);
				int baseVertexZ = verticesZ[k4] << (scaledVertices ? 0 : 2);
				if (offsetX != 0) {
					int calculatedVertexX = baseVertexY * j3 + baseVertexX * k3 >> 16;
					baseVertexY = baseVertexY * k3 - baseVertexX * j3 >> 16;
					baseVertexX = calculatedVertexX;
					}
					if (i != 0) {
					int calculatedVertexY = baseVertexY * k2 - baseVertexZ * j2 >> 16;
					baseVertexZ = baseVertexY * j2 + baseVertexZ * k2 >> 16;
					baseVertexY = calculatedVertexY;
					}
					if (rotation_2 != 0) {
					int calculatedVertexZ = baseVertexZ * l2 + baseVertexX * i3 >> 16;
					baseVertexZ = baseVertexZ * i3 - baseVertexX * l2 >> 16;
					baseVertexX = calculatedVertexZ;
					}
				baseVertexX += offsetY << 2;
				baseVertexY += zoom_sine << 2;
				baseVertexZ += zoom_cosine << 2;
				int j6 = baseVertexY * i4 - baseVertexZ * l3 >> 16;
				baseVertexZ = baseVertexY * l3 + baseVertexZ * i4 >> 16;
			baseVertexY = j6;
			anIntArray1667[k4] = (baseVertexZ >> 2) - calculated_zoom;
			projected_vertex_x[k4] = Rasterizer.centerX + (baseVertexX << 9) / baseVertexZ;
			projected_vertex_y[k4] = Rasterizer.centerY + (baseVertexY << 9) / baseVertexZ;
			projected_vertex_z[k4] = (baseVertexZ >> 2);
			if (numberOfTexturesFaces > 0) {
				camera_vertex_y[k4] = baseVertexX >> 2;
				camera_vertex_x[k4] = baseVertexY >> 2;
				camera_vertex_z[k4] = baseVertexZ >> 2;
			}
			}

			try {
				translateToScreen(false, false, 0, 20);
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
			textures_face_a = new int[triangleCount];
			textures_face_b = new int[triangleCount];
			textures_face_c = new int[triangleCount];


			for(int i = 0; i < triangleCount; i++) {
				if(textureIds[i] == -1 && face_render_type[i] == 2) {
					face_color[i] = 65535;
					face_render_type[i] = 0;
				}
				if(textureIds[i] >= max || textureIds[i] < 0 || textureIds[i] == 39) {
					face_render_type[i] = 0;
					continue;
				}
				face_render_type[i] = 2+set2;
				set2 += 4;
				int a = face_a[i];
				int b = face_b[i];
				int c = face_c[i];
				face_color[i] = textureIds[i];


				int texture_type = -1;
				if(texture_coordinates != null) {
					texture_type = texture_coordinates[i] & 0xff;
					if(texture_type != 0xff)
						if(texa[texture_type] >= camera_vertex_x.length || texb[texture_type] >= camera_vertex_y.length
								|| texc[texture_type] >= camera_vertex_z.length)
							texture_type = -1;
				}
				if(texture_type == 0xff)
					texture_type = -1;


				textures_face_a[set] = texture_type == -1 ? a : texa[texture_type];
				textures_face_b[set] = texture_type == -1 ? b : texb[texture_type];
				textures_face_c[set++] = texture_type == -1 ? c : texc[texture_type];


			}
			numberOfTexturesFaces = set;
		}
	}
	public final void renderAtPoint(int i, int j, int k, int l, int i1, int j1,
									int k1, int l1, long i2, int bufferOffset) {
		offX = j1 + client.instance.xCameraPos;
		offZ = l1 + client.instance.yCameraPos;
		lastRenderedRotation = i;
		int j2 = l1 * i1 - j1 * l >> 16;
			int k2 = k1 * j + j2 * k >> 16;
			int l2 = anInt1650 * k >> 16;
							int i3 = k2 + l2;
							if (i3 <= 50 || k2 >=  (WorldController.farZ * 140))
								return;
							int j3 = l1 * l + j1 * i1 >> 16;
				int k3 = j3 - anInt1650 << client.log_view_dist;
				if (k3 / i3 >= DrawingArea.viewport_centerX)
					return;
				int l3 = j3 + anInt1650 << client.log_view_dist;
				if (l3 / i3 <= -DrawingArea.viewport_centerX)
					return;
				int i4 = k1 * k - j2 * j >> 16;
				int j4 = anInt1650 * j >> 16;
				int k4 = i4 + j4 << client.log_view_dist;
				if (k4 / i3 <= -DrawingArea.viewport_centerY)
					return;
				int l4 = j4 + (super.modelHeight * k >> 16);
				int i5 = i4 - l4 << client.log_view_dist;
				if (i5 / i3 >= DrawingArea.viewport_centerY)
					return;
				int j5 = l2 + (super.modelHeight * j >> 16);
				boolean flag = false;
				if (k2 - j5 <= 50)
					flag = true;
				boolean flag1 = false;
				if (i2 > 0 && objectExists) {
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
							objectsInCurrentRegion[objectsRendered++] = i2;
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
					int k7 = verticesX[j7] << (scaledVertices ? 0 : 2);
					int l7 = verticesY[j7] << (scaledVertices ? 0 : 2);
					int i8 = verticesZ[j7] << (scaledVertices ? 0 : 2);
					if (i != 0) {
						int j8 = i8 * l6 + k7 * i7 >> 16;
							i8 = i8 * i7 - k7 * l6 >> 16;
							k7 = j8;
					}
					k7 += j1 << 2;
					l7 += k1 << 2;
					i8 += l1 << 2;
					int k8 = i8 * l + k7 * i1 >> 16;
					i8 = i8 * i1 - k7 * l >> 16;
					k7 = k8;
					k8 = l7 * k - i8 * j >> 16;
					i8 = l7 * j + i8 * k >> 16;
					l7 = k8;
					anIntArray1667[j7] = (i8 >> 2) - k2;
			if (i8 >= 50) {
					projected_vertex_x[j7] = l5 + (k7 << client.log_view_dist) / i8;
					projected_vertex_y[j7] = j6 + (l7 << client.log_view_dist) / i8;
					projected_vertex_z[j7] = (i8 >> 2);
				} else {
					projected_vertex_x[j7] = -5000;
					flag = true;
			}
					if (flag || numberOfTexturesFaces > 0) {
						camera_vertex_y[j7] = k7 >> 2;
						camera_vertex_x[j7] = l7 >> 2;
						camera_vertex_z[j7] = i8 >> 2;
					}
				}

				try {
					translateToScreen(flag, flag1, i2, bufferOffset);
					return;
				} catch (Exception _ex) {
					return;
				}
	}

	private final void translateToScreen(boolean flag, boolean flag1, long i, int bufferOffset) {
		for (int j = 0; j < anInt1652; j++)
			depthListIndices[j] = 0;

		for (int k = 0; k < triangleCount; k++)
			if (face_render_type == null || face_render_type[k] != -1) {
				int l = face_a[k];
				int k1 = face_b[k];
				int j2 = face_c[k];
				int i3 = projected_vertex_x[l];
				int l3 = projected_vertex_x[k1];
				int k4 = projected_vertex_x[j2];
				if (flag && (i3 == -5000 || l3 == -5000 || k4 == -5000)) {
					outOfReach[k] = true;
					int j5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2])
					/ 3 + anInt1653;
					faceLists[j5][depthListIndices[j5]++] = k;
				} else {
					if (flag1
							&& method486(anInt1685, anInt1686,
									projected_vertex_y[l], projected_vertex_y[k1],
									projected_vertex_y[j2], i3, l3, k4)) {
						objectsInCurrentRegion[objectsRendered++] = i;
						flag1 = false;
					}
					if ((i3 - l3) * (projected_vertex_y[j2] - projected_vertex_y[k1])
							- (projected_vertex_y[l] - projected_vertex_y[k1])
							* (k4 - l3) > 0) {
						outOfReach[k] = false;
						if (i3 < 0 || l3 < 0 || k4 < 0
								|| i3 > DrawingArea.viewportRX
								|| l3 > DrawingArea.viewportRX
								|| k4 > DrawingArea.viewportRX)
							hasAnEdgeToRestrict[k] = true;
						else
							hasAnEdgeToRestrict[k] = false;
						int k5 = (anIntArray1667[l] + anIntArray1667[k1] + anIntArray1667[j2])
						/ 3 + anInt1653;
						faceLists[k5][depthListIndices[k5]++] = k;
					}
				}
			}

		if (face_render_priorities == null) {
			for (int i1 = anInt1652 - 1; i1 >= 0; i1--) {
				int l1 = depthListIndices[i1];
				if (l1 > 0) {
					int ai[] = faceLists[i1];
					for (int j3 = 0; j3 < l1; j3++)
						rasterise(ai[j3], bufferOffset);

				}
			}

			return;
		}
		for (int j1 = 0; j1 < 12; j1++) {
			anIntArray1673[j1] = 0;
			anIntArray1677[j1] = 0;
		}

		for (int i2 = anInt1652 - 1; i2 >= 0; i2--) {
			int k2 = depthListIndices[i2];
			if (k2 > 0) {
				int ai1[] = faceLists[i2];
				for (int i4 = 0; i4 < k2; i4++) {
					int l4 = ai1[i4];
					int l5 = face_render_priorities[l4];
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
				rasterise(ai2[i6++], bufferOffset);
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
				rasterise(ai2[i6++], bufferOffset);
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
				rasterise(ai2[i6++], bufferOffset);
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
				rasterise(ai4[j7], bufferOffset);

		}

		while (i5 != -1000) {
			rasterise(ai2[i6++], bufferOffset);
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
		for (int m = 0;
			 m < vertexCount;
			 m++) {
			int pid = verticesParticle[m] - 1;
			if (pid < 0) {
				continue;
			}

			final ParticleDefinition def = ParticleDefinition.cache.get(pid);
			int pX = verticesX[m] >> (scaledVertices ? 2 : 0);
			int pY = verticesY[m] >> (scaledVertices ? 2 : 0);
			int pZ = verticesZ[m] >> (scaledVertices ? 2 : 0);
			if (lastRenderedRotation != 0) {
				int sine = Model.SINE[lastRenderedRotation];
				int cosine = Model.COSINE[lastRenderedRotation];
				int rotatedX = pZ * sine + pX * cosine >> 16;
				pZ = pZ * cosine - pX * sine >> 16;
				pX = rotatedX;
			}
			pX += offX;
			pZ += offZ;
			ParticleVector basePos = new ParticleVector(pX, -pY, pZ);
			for (int p = 0;
				 p < def.getSpawnRate();
				 p++) {
				Particle particle = new Particle(def, basePos);
				client.instance.particles.add(particle);
			}
		}
	}

	private final void rasterise(int i, int bufferOffset) {
		if (outOfReach[i]) {
			reduce(i, bufferOffset);
			return;
		}
		int j = face_a[i];
		int k = face_b[i];
		int l = face_c[i];
		Rasterizer.aBoolean1462 = hasAnEdgeToRestrict[i];
		if (face_alpha == null)
			Rasterizer.anInt1465 = 0;
		else
			Rasterizer.anInt1465 = face_alpha[i];
		int i1;
		if (face_render_type == null)
			i1 = 0;
		else
			i1 = face_render_type[i] & 3;
		if (i1 == 0) {
			Rasterizer.drawGouraudTriangle(projected_vertex_y[j], projected_vertex_y[k], projected_vertex_y[l],
					projected_vertex_x[j], projected_vertex_x[k], projected_vertex_x[l], face_shade_a[i],
					face_shade_b[i], face_shade_c[i], projected_vertex_z[j], projected_vertex_z[k],
					projected_vertex_z[l], bufferOffset);
			return;
		}
		if (i1 == 1) {
			Rasterizer.drawFlatTriangle(projected_vertex_y[j], projected_vertex_y[k], projected_vertex_y[l],
					projected_vertex_x[j], projected_vertex_x[k], projected_vertex_x[l], hsl2rgb[face_shade_a[i]],
					projected_vertex_z[j], projected_vertex_z[k], projected_vertex_z[l], bufferOffset);

			return;
		}
		if (i1 == 2) {
			int j1 = face_render_type[i] >> 2;
			int l1 = textures_face_a[j1];
			int j2 = textures_face_b[j1];
			int l2 = textures_face_c[j1];
			Rasterizer.drawTexturedTriangle(projected_vertex_y[j], projected_vertex_y[k], projected_vertex_y[l],
					projected_vertex_x[j], projected_vertex_x[k], projected_vertex_x[l], face_shade_a[i],
					face_shade_b[i], face_shade_c[i], camera_vertex_y[l1], camera_vertex_y[j2], camera_vertex_y[l2],
					camera_vertex_x[l1], camera_vertex_x[j2], camera_vertex_x[l2], camera_vertex_z[l1],
					camera_vertex_z[j2], camera_vertex_z[l2], face_color[i], projected_vertex_z[j],
					projected_vertex_z[k], projected_vertex_z[l], bufferOffset);
			return;
		}
		if (i1 == 3) {
			int k1 = face_render_type[i] >> 2;
				int i2 = textures_face_a[k1];
				int k2 = textures_face_b[k1];
				int i3 = textures_face_c[k1];
			Rasterizer.drawTexturedTriangle(projected_vertex_y[j], projected_vertex_y[k], projected_vertex_y[l],
					projected_vertex_x[j], projected_vertex_x[k], projected_vertex_x[l], face_shade_a[i],
					face_shade_a[i], face_shade_a[i], camera_vertex_y[i2], camera_vertex_y[k2], camera_vertex_y[i3],
					camera_vertex_x[i2], camera_vertex_x[k2], camera_vertex_x[i3], camera_vertex_z[i2],
					camera_vertex_z[k2], camera_vertex_z[i3], face_color[i], projected_vertex_z[j],
					projected_vertex_z[k], projected_vertex_z[l], bufferOffset);
		}
	}

	private final void reduce(int i, int bufferOffset) {
		if (face_color != null)
			if (face_color[i] == 65535)
				return;
		int j = Rasterizer.centerX;
		int k = Rasterizer.centerY;
		int l = 0;
		int i1 = face_a[i];
		int j1 = face_b[i];
		int k1 = face_c[i];
		int l1 = camera_vertex_z[i1];
		int i2 = camera_vertex_z[j1];
		int j2 = camera_vertex_z[k1];

		if (l1 >= 50) {
			anIntArray1678[l] = projected_vertex_x[i1];
			anIntArray1679[l] = projected_vertex_y[i1];
			anIntArray1680[l++] = face_shade_a[i];
		} else {
			int k2 = camera_vertex_y[i1];
			int k3 = camera_vertex_x[i1];
			int k4 = face_shade_a[i];
			if (j2 >= 50) {
				int k5 = (50 - l1) * anIntArray1692[j2 - l1];
				anIntArray1678[l] = j + (k2 + ((camera_vertex_y[k1] - k2) * k5 >> 16) << client.log_view_dist) / 50;
				anIntArray1679[l] = k + (k3 + ((camera_vertex_x[k1] - k3) * k5 >> 16) << client.log_view_dist) / 50;
				anIntArray1680[l++] = k4 + ((face_shade_c[i] - k4) * k5 >> 16);
			}
			if (i2 >= 50) {
				int l5 = (50 - l1) * anIntArray1692[i2 - l1];
				anIntArray1678[l] = j
				+ (k2 + ((camera_vertex_y[j1] - k2) * l5 >> 16) << client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (k3 + ((camera_vertex_x[j1] - k3) * l5 >> 16) << client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = k4
				+ ((face_shade_b[i] - k4) * l5 >> 16);
			}
		}
		if (i2 >= 50) {
			anIntArray1678[l] = projected_vertex_x[j1];
			anIntArray1679[l] = projected_vertex_y[j1];
			anIntArray1680[l++] = face_shade_b[i];
		} else {
			int l2 = camera_vertex_y[j1];
			int l3 = camera_vertex_x[j1];
			int l4 = face_shade_b[i];
			if (l1 >= 50) {
				int i6 = (50 - i2) * anIntArray1692[l1 - i2];
				anIntArray1678[l] = j
				+ (l2 + ((camera_vertex_y[i1] - l2) * i6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (l3 + ((camera_vertex_x[i1] - l3) * i6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = l4
				+ ((face_shade_a[i] - l4) * i6 >> 16);
			}
			if (j2 >= 50) {
				int j6 = (50 - i2) * anIntArray1692[j2 - i2];
				anIntArray1678[l] = j
				+ (l2 + ((camera_vertex_y[k1] - l2) * j6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (l3 + ((camera_vertex_x[k1] - l3) * j6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = l4
				+ ((face_shade_c[i] - l4) * j6 >> 16);
			}
		}
		if (j2 >= 50) {
			anIntArray1678[l] = projected_vertex_x[k1];
			anIntArray1679[l] = projected_vertex_y[k1];
			anIntArray1680[l++] = face_shade_c[i];
		} else {
			int i3 = camera_vertex_y[k1];
			int i4 = camera_vertex_x[k1];
			int i5 = face_shade_c[i];
			if (i2 >= 50) {
				int k6 = (50 - j2) * anIntArray1692[i2 - j2];
				anIntArray1678[l] = j
				+ (i3 + ((camera_vertex_y[j1] - i3) * k6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (i4 + ((camera_vertex_x[j1] - i4) * k6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = i5
				+ ((face_shade_b[i] - i5) * k6 >> 16);
			}
			if (l1 >= 50) {
				int l6 = (50 - j2) * anIntArray1692[l1 - j2];
				anIntArray1678[l] = j
				+ (i3 + ((camera_vertex_y[i1] - i3) * l6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1679[l] = k
				+ (i4 + ((camera_vertex_x[i1] - i4) * l6 >> 16) <<  client.log_view_dist)
				/ 50;
				anIntArray1680[l++] = i5
				+ ((face_shade_a[i] - i5) * l6 >> 16);
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
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRX
						|| j4 > DrawingArea.viewportRX || j5 > DrawingArea.viewportRX)
					Rasterizer.aBoolean1462 = true;
				int l7;
				if (face_render_type == null)
					l7 = 0;
				else
					l7 = face_render_type[i] & 3;
				if (l7 == 0) {
					Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], -1, -1, -1, bufferOffset);
				} else if (l7 == 1) {
					Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5, hsl2rgb[face_shade_a[i]], -1, -1, -1,
							bufferOffset);
				}else if (l7 == 2) {
					int j8 = face_render_type[i] >> 2;
					int k9 = textures_face_a[j8];
					int k10 = textures_face_b[j8];
					int k11 = textures_face_c[j8];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], camera_vertex_y[k9], camera_vertex_y[k10], camera_vertex_y[k11],
							camera_vertex_x[k9], camera_vertex_x[k10], camera_vertex_x[k11], camera_vertex_z[k9],
							camera_vertex_z[k10], camera_vertex_z[k11], face_color[i], -1, -1, -1, bufferOffset);
				} else if (l7 == 3) {
					int k8 = face_render_type[i] >> 2;
					int l9 = textures_face_a[k8];
					int l10 = textures_face_b[k8];
					int l11 = textures_face_c[k8];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, face_shade_a[i], face_shade_a[i],
							face_shade_a[i], camera_vertex_y[l9], camera_vertex_y[l10], camera_vertex_y[l11],
							camera_vertex_x[l9], camera_vertex_x[l10], camera_vertex_x[l11], camera_vertex_z[l9],
							camera_vertex_z[l10], camera_vertex_z[l11], face_color[i], -1, -1, -1, bufferOffset);
				}
			}
			if (l == 4) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRX
						|| j4 > DrawingArea.viewportRX || j5 > DrawingArea.viewportRX
						|| anIntArray1678[3] < 0
						|| anIntArray1678[3] > DrawingArea.viewportRX)
					Rasterizer.aBoolean1462 = true;
				int i8;
				if (face_render_type == null)
					i8 = 0;
				else
					i8 = face_render_type[i] & 3;
				if (i8 == 0) {
					Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], -1, -1, -1, bufferOffset);
					Rasterizer.drawGouraudTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3],
							anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], -1, -1, -1, bufferOffset);
					return;
				}
				if (i8 == 1) {
					int l8 = hsl2rgb[face_shade_a[i]];
					Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5, l8, -1, -1, -1, bufferOffset);
					Rasterizer.drawFlatTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], l8, -1, -1, -1,
							bufferOffset);
					return;
				}
				if (i8 == 2) {
					int i9 = face_render_type[i] >> 2;
					int i10 = textures_face_a[i9];
					int i11 = textures_face_b[i9];
					int i12 = textures_face_c[i9];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], camera_vertex_y[i10], camera_vertex_y[i11], camera_vertex_y[i12],
							camera_vertex_x[i10], camera_vertex_x[i11], camera_vertex_x[i12], camera_vertex_z[i10],
							camera_vertex_z[i11], camera_vertex_z[i12], face_color[i], -1, -1, -1, bufferOffset);
					Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3],
							anIntArray1680[0], anIntArray1680[2], anIntArray1680[3], camera_vertex_y[i10],
							camera_vertex_y[i11], camera_vertex_y[i12], camera_vertex_x[i10], camera_vertex_x[i11],
							camera_vertex_x[i12], camera_vertex_z[i10], camera_vertex_z[i11], camera_vertex_z[i12],
							face_color[i], -1, -1, -1, bufferOffset);
					return;
				}
				if (i8 == 3) {
					int j9 = face_render_type[i] >> 2;
					int j10 = textures_face_a[j9];
					int j11 = textures_face_b[j9];
					int j12 = textures_face_c[j9];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5, face_shade_a[i], face_shade_a[i],
							face_shade_a[i], camera_vertex_y[j10], camera_vertex_y[j11], camera_vertex_y[j12],
							camera_vertex_x[j10], camera_vertex_x[j11], camera_vertex_x[j12], camera_vertex_z[j10],
							camera_vertex_z[j11], camera_vertex_z[j12], face_color[i], -1, -1, -1, bufferOffset);
					Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3],
							face_shade_a[i], face_shade_a[i], face_shade_a[i], camera_vertex_y[j10],
							camera_vertex_y[j11], camera_vertex_y[j12], camera_vertex_x[j10], camera_vertex_x[j11],
							camera_vertex_x[j12], camera_vertex_z[j10], camera_vertex_z[j11], camera_vertex_z[j12],
							face_color[i], -1, -1, -1, bufferOffset);
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
	private boolean rendersWithinOneTile;
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
	public int[] verticesParticle;
    public boolean scaledVertices;
	public int vertexCount;
	public int verticesX[];
	public int verticesY[];
	public int verticesZ[];
	public int triangleCount;
	public int face_a[];
	public int face_b[];
	public int face_c[];
	public int face_shade_a[];
	public int face_shade_b[];
	public int face_shade_c[];
	public int face_render_type[];
	public int face_render_priorities[];
	public int face_alpha[];
	public int[] face_color;
	public int face_priority;
	public int numberOfTexturesFaces;
	public int textures_face_a[];
	public int textures_face_b[];
	public int textures_face_c[];
	public int minX;
	public int maxX;
	public int maxZ;
	public int minZ;
	public int anInt1650;
	public int maxY;
	public int anInt1652;
	public int anInt1653;
	public int anInt1654;
	public int vertexVSkin[];
	public int triangleTSkin[];
	public int vertexSkin[][];
	public int triangleSkin[][];
	public boolean aBoolean1659;
	VertexNormal vertexNormalOffset[];
	private int offX = 0;
	private int offZ = 0;
	private int lastRenderedRotation = 0;
	static Class21 aClass21Array1661[];
	static OnDemandFetcherParent aOnDemandFetcherParent_1662;
	static boolean hasAnEdgeToRestrict[] = new boolean[16000];
	static boolean outOfReach[] = new boolean[16000];
	static int projected_vertex_x[] = new int[16000];
	static int projected_vertex_y[] = new int[16000];
	static int projected_vertex_z[] = new int[16000];
	static int anIntArray1667[] = new int[16000];
	static int camera_vertex_y[] = new int[16000];
	static int camera_vertex_x[] = new int[16000];
	static int camera_vertex_z[] = new int[16000];
	static int depthListIndices[] = new int[16000];
	static int faceLists[][] = new int[16000][512];
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
	public static boolean objectExists;
	public static int anInt1685;
	public static int anInt1686;
	public static int objectsRendered;
	public static long objectsInCurrentRegion[] = new long[1000];
	public static int SINE[];
	public static int COSINE[];
	static int hsl2rgb[];
	static int anIntArray1692[];

	static {
		SINE = Rasterizer.anIntArray1470;
		COSINE = Rasterizer.anIntArray1471;
		hsl2rgb = Rasterizer.hsl2rgb;
		anIntArray1692 = Rasterizer.anIntArray1469;
	}
}
