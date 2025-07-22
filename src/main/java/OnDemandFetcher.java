import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;
import sign.signlink;

public class OnDemandFetcher extends OnDemandFetcherParent implements Runnable {
   private int[] anIntArray1356;
   private boolean waiting = false;
   private Socket socket;
   private InputStream inputStream;
   private OutputStream outputStream;
   private int expectedSize;
   private OnDemandData current;
   private int loopCycle;
   private int completedSize;
   private byte[] aByteArray1372;
   private int[] mapIndices1;
   private int[] mapIndices2;
   private int[] mapIndices3;
   private int[] anIntArray1360;
   private int[] anIntArray1348;
   private client aClient1343;
   private boolean aBoolean1353 = true;
   private static int anInt1345;
   private boolean aBoolean1355 = false;
   private int anInt1352 = 13603;
   private long aLong1335;
   private int anInt1334;
   public int anInt1349;
   public int anInt1341;
   public String aString1333 = "";
   private int anInt1340 = 923;
   private int anInt1332;
   private int anInt1330;
   private int anInt1366;
   private int anInt1367;
   private int anInt1351;
   private DoubleEndedQueue requested = new DoubleEndedQueue(169);
   private boolean aBoolean1336 = true;
   private CRC32 aCRC32_1338 = new CRC32();
   private byte[] ioBuffer = new byte[500];
   private byte[][] fileStatus = new byte[7][];
   private DoubleEndedQueue aDoubleEndedQueue_1344 = new DoubleEndedQueue(169);
   private final DoubleEndedQueue aDoubleEndedQueue_1358 = new DoubleEndedQueue(169);
   private byte[] gzipInputBuffer = new byte[9999999];
   private Class2 aClass2_1361;
   private int[][] versions;
   private int[][] anIntArrayArray1365;
   private DoubleEndedQueue aDoubleEndedQueue_1368;
   private DoubleEndedQueue aDoubleEndedQueue_1370;

   private boolean crcMatches(int type, int id, byte[] data) {
      if(data != null && data.length >= 2) {
         int length = data.length - 2;
         int hash = ((data[length] & 255) << 8) + (data[length + 1] & 255);
         this.aCRC32_1338.reset();
         this.aCRC32_1338.update(data, 0, length);
         int crc = (int)this.aCRC32_1338.getValue();
         return hash == type && crc == id;
      } else {
         return false;
      }
   }

   private final void readData() {
      try {
         int available = inputStream.available();
         int dataType, fileId, totalLength, chunkIndex;

         if (expectedSize == 0 && available >= 8) {
            waiting = true;

            readFully(inputStream, ioBuffer, 0, 8);

            dataType = ioBuffer[0] & 0xFF;
            fileId = ((ioBuffer[1] & 0xFF) << 16) | ((ioBuffer[2] & 0xFF) << 8) | (ioBuffer[3] & 0xFF);
            totalLength = ((ioBuffer[4] & 0xFF) << 16) | ((ioBuffer[5] & 0xFF) << 8) | (ioBuffer[6] & 0xFF);
            chunkIndex = ioBuffer[7] & 0xFF;

            current = null;
            OnDemandData req = (OnDemandData) requested.reverseGetFirst();

            while (req != null) {
               if (req.dataType == dataType && req.ID == fileId) {
                  current = req;
                  break;
               }
               req = (OnDemandData) requested.reverseGetNext(false);
            }

            if (current == null) {
               if (totalLength == 0) {
                  signlink.reporterror("Rej: " + dataType + "," + fileId);
                  return;
               } else {
                  return; // orphaned packet
               }
            }

            if (totalLength == 0) {
               signlink.reporterror("Rej: " + dataType + "," + fileId);
               current.buffer = null;

               if (current.incomplete) {
                  synchronized (aDoubleEndedQueue_1358) {
                     aDoubleEndedQueue_1358.insertHead(current);
                  }
               } else {
                  current.unlink();
               }

               current = null;
            } else {
               if (current.buffer == null) {
                  current.buffer = new byte[totalLength];
               }
            }

            completedSize = chunkIndex * 500;
            expectedSize = Math.min(500, totalLength - completedSize);
         }

         if (expectedSize > 0 && available >= expectedSize) {
            waiting = true;
            byte[] target = ioBuffer;
            int writePos = 0;

            if (current != null) {
               target = current.buffer;
               writePos = completedSize;
            }

            readFully(inputStream, target, writePos, expectedSize);

            completedSize += expectedSize;

            if (current != null && completedSize >= current.buffer.length) {
               // Save to cache
               if (aClient1343.aClass14Array970[0] != null) {
                  aClient1343.aClass14Array970[current.dataType + 1]
                          .method234(current.buffer.length, current.buffer, (byte) 2, 0);
               }

               // MIDI fix-up
               if (!current.incomplete && current.dataType == 3) {
                  current.incomplete = true;
                  current.dataType = 93;
               }

               if (current.incomplete) {
                  synchronized (aDoubleEndedQueue_1358) {
                     aDoubleEndedQueue_1358.insertHead(current);
                  }
               } else {
                  current.unlink();
               }
            }

            expectedSize = 0;
         }

      } catch (IOException e) {
         try {
            socket.close();
         } catch (Exception ignored) { }

         socket = null;
         inputStream = null;
         outputStream = null;
         expectedSize = 0;
      }
   }

   private void readFully(InputStream in, byte[] buffer, int offset, int length) throws IOException {
      int total = 0;
      while (total < length) {
         int read = in.read(buffer, offset + total, length - total);
         if (read == -1) throw new IOException("Stream closed early");
         total += read;
      }
   }


   public final void start(FileArchive fileArchive, client client1) throws IOException {
      String[] as = new String[]{"model_version", "anim_version", "midi_version", "map_version", "texture_version", "sound_version"};

      byte[] abyte2;
      int j1;
      Stream class30_sub2_sub2_2;
      int k2;
      for(int as1 = 0; as1 < 6; ++as1) {
         abyte2 = fileArchive.method571(as[as1]);
         j1 = abyte2.length / 2;
         class30_sub2_sub2_2 = new Stream(abyte2, 891);
         this.versions[as1] = new int[j1];
         this.fileStatus[as1] = new byte[j1];

         for(k2 = 0; k2 < j1; ++k2) {
            this.versions[as1][k2] = class30_sub2_sub2_2.readUnsignedShort();
         }
      }

      String[] var10 = new String[]{"model_crc", "anim_crc", "midi_crc", "map_crc", "texture_crc", "sound_crc"};

      int var13;
      for(int var11 = 0; var11 < 6; ++var11) {
         byte[] var12 = fileArchive.method571(var10[var11]);
         var13 = var12.length / 4;
         Stream var14 = new Stream(var12, 891);
         this.anIntArrayArray1365[var11] = new int[var13];

         for(int l1 = 0; l1 < var13; ++l1) {
            this.anIntArrayArray1365[var11][l1] = var14.readDWord();
         }
      }

      abyte2 = fileArchive.method571("model_index");
      j1 = this.versions[0].length;
      this.aByteArray1372 = new byte[j1];

      for(var13 = 0; var13 < j1; ++var13) {
         if(var13 < abyte2.length) {
            this.aByteArray1372[var13] = abyte2[var13];
         } else {
            this.aByteArray1372[var13] = 0;
         }
      }

      abyte2 = fileArchive.method571("525map_index");
      class30_sub2_sub2_2 = new Stream(abyte2, 891);
      j1 = class30_sub2_sub2_2.readUnsignedShort();
      this.mapIndices1 = new int[j1];
      this.mapIndices2 = new int[j1];
      this.mapIndices3 = new int[j1];

      for(k2 = 0; k2 < j1; ++k2) {
         this.Greenland();
         this.mapIndices1[k2] = class30_sub2_sub2_2.readUnsignedShort();
         this.mapIndices2[k2] = class30_sub2_sub2_2.readUnsignedShort();
         this.mapIndices3[k2] = class30_sub2_sub2_2.readUnsignedShort();
      }

      abyte2 = fileArchive.method571("anim_index");
      class30_sub2_sub2_2 = new Stream(abyte2, 891);
      j1 = abyte2.length / 2;
      this.anIntArray1360 = new int[j1];

      for(k2 = 0; k2 < j1; ++k2) {
         this.anIntArray1360[k2] = class30_sub2_sub2_2.readUnsignedShort();
      }

      abyte2 = fileArchive.method571("midi_index");
      class30_sub2_sub2_2 = new Stream(abyte2, 891);
      j1 = class30_sub2_sub2_2.readUnsignedShort();
      this.anIntArray1348 = new int[j1];

      for(k2 = 0; k2 < j1; ++k2) {
         this.anIntArray1348[k2] = class30_sub2_sub2_2.readUnsignedShort();
      }

      this.aClient1343 = client1;
      this.aBoolean1353 = true;
      this.aClient1343.method12(this, 2);
   }

   private void dumpmidiIndex(int j1) throws IOException {
      try {
         File e = new File("midi_index.txt");
         if(e.exists()) {
            e.delete();
         } else {
            e.createNewFile();
         }

         BufferedWriter writer = new BufferedWriter(new FileWriter(e));

         for(int id = 0; id < j1; ++id) {
            try {
               writer.append("anIntArray1348[" + id + "] = " + this.anIntArray1348[id]);
               writer.newLine();
               writer.newLine();
               writer.flush();
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }

        //System.out.println("Finished dumping Map index");
         writer.close();
      } catch (Exception var7) {
         var7.printStackTrace();
      }

   }

   public final int method552() {
      Class2 var1 = this.aClass2_1361;
      synchronized(this.aClass2_1361) {
         int i = this.aClass2_1361.method154();
         return i;
      }
   }

   public final void method553() {
      this.aBoolean1353 = false;
   }

   public final void method554(boolean flag, int i) {
      int j = this.mapIndices1.length;
      if(i != 0) {
         anInt1345 = 20;
      }

      for(int k = 0; k < j; ++k) {
         if(flag || this.anIntArray1356[k] != 0) {
            this.method563((byte)2, 3, this.mapIndices3[k], (byte)8);
            this.method563((byte)2, 3, this.mapIndices2[k], (byte)8);
         }
      }

   }

   public final int method555(int i, int j) {
      if(i <= 0) {
         this.aBoolean1355 = !this.aBoolean1355;
      }

      return this.versions[j].length;
   }

   private final void method556(int i, OnDemandData onDemandData) {
      if(i < 8 || i > 8) {
         this.anInt1352 = -339;
      }

      try {
         if(this.socket == null) {
            long l = System.currentTimeMillis();
            if(l - this.aLong1335 < 4000L) {
               return;
            }

            this.aLong1335 = l;
            this.socket = this.aClient1343.method19(29434 + client.ondemand_offset);
            this.inputStream = this.socket.getInputStream();
            this.outputStream = this.socket.getOutputStream();
            this.outputStream.write(15);

            for(int j = 0; j < 8; ++j) {
               this.inputStream.read();
            }

            this.loopCycle = 0;
         }

         this.ioBuffer[0] = (byte)onDemandData.dataType;
         this.ioBuffer[1] = (byte)(onDemandData.ID >> 8);
         this.ioBuffer[2] = (byte)onDemandData.ID;
         if(onDemandData.incomplete) {
            this.ioBuffer[3] = 2;
         } else {
            client var10000 = this.aClient1343;
            if(!client.loggedIn) {
               this.ioBuffer[3] = 1;
            } else {
               this.ioBuffer[3] = 0;
            }
         }

         this.outputStream.write(this.ioBuffer, 0, 4);
         this.anInt1334 = 0;
         this.anInt1349 = -10000;
      } catch (IOException var7) {
         try {
            this.socket.close();
         } catch (Exception var6) {
            ;
         }

         this.socket = null;
         this.inputStream = null;
         this.outputStream = null;
         this.expectedSize = 0;
         ++this.anInt1349;
      }
   }

   public int getModelCount() {
      return 129191;
   }

   public final int method557(int i) {
      if(i != 0) {
         this.anInt1352 = -76;
      }

      return 32767;
   }

   private void Greenland() {
      this.mapIndices1[26] = 8241;
      this.mapIndices2[26] = 926;
      this.mapIndices3[26] = 927;
      this.mapIndices1[27] = 8242;
      this.mapIndices2[27] = 928;
      this.mapIndices3[27] = 929;
   }

   public final void method558(int i, int j) {
      Class2 var3 = this.aClass2_1361;
      synchronized(this.aClass2_1361) {
         OnDemandData onDemandData_1;
         for(onDemandData_1 = (OnDemandData)this.aClass2_1361.method152(); onDemandData_1 != null; onDemandData_1 = (OnDemandData)this.aClass2_1361.method153(false)) {
            if(onDemandData_1.dataType == i && onDemandData_1.ID == j) {
               return;
            }
         }

         onDemandData_1 = new OnDemandData();
         onDemandData_1.dataType = i;
         onDemandData_1.ID = j;
         onDemandData_1.incomplete = true;
         DoubleEndedQueue var5 = this.aDoubleEndedQueue_1370;
         synchronized(this.aDoubleEndedQueue_1370) {
            this.aDoubleEndedQueue_1370.insertHead(onDemandData_1);
         }

         this.aClass2_1361.method150(onDemandData_1);
      }
   }

   public void crcPack(int index, int index_length) {
      try {
         String e = null;
         switch(index) {
         case 1:
            e = "model";
            break;
         case 2:
            e = "anim";
            break;
         case 3:
            e = "midi";
            break;
         case 4:
            e = "map";
            break;
         case 5:
            e = "texture";
         }

         DataOutputStream crc_output = new DataOutputStream(new FileOutputStream("./" + e + "_crc"));
         DataOutputStream version_output = new DataOutputStream(new FileOutputStream("./" + e + "_version"));

         for(int j = 0; j < index_length; ++j) {
            byte[] abyte0 = this.aClient1343.aClass14Array970[index].method233(j);
            if(abyte0 != null) {
               int k = abyte0.length - 2;
               int version = ((abyte0[k] & 255) << 8) + (abyte0[k + 1] & 255);
               this.aCRC32_1338.reset();
               this.aCRC32_1338.update(abyte0, 0, k);
               int crc = (int)this.aCRC32_1338.getValue();
               writeDWord(crc_output, crc);
               version_output.writeShort(version);
            } else {
               writeDWord(crc_output, 0);
               version_output.writeShort(0);
            }
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

   }

   public static void writeDWord(DataOutputStream dos, int i) {
      try {
         dos.writeByte((byte)(i >> 24));
         dos.writeByte((byte)(i >> 16));
         dos.writeByte((byte)(i >> 8));
         dos.writeByte((byte)i);
      } catch (IOException var3) {
         ;
      }

   }

   public final int method559(int i, int j) {
      if(j >= 0) {
         anInt1345 = -7;
      }

      return this.aByteArray1372[i] & 255;
   }
   public static byte[] decompress(byte[] compressed) throws IOException {
      try (GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(compressed));
           ByteArrayOutputStream out = new ByteArrayOutputStream()) {

         byte[] buffer = new byte[4096];
         int len;

         while ((len = gzip.read(buffer)) > 0) {
            out.write(buffer, 0, len);
         }

         return out.toByteArray();
      }
   }
   private final Queue<OnDemandData> retryQueue = new ConcurrentLinkedQueue<>();

   public final void run() {
      final int MAX_IDLE_CYCLES = 750;
      final int MAX_RETRY_COUNT = 250;
      final int MAX_LOOP_CYCLES = 100;
      final int SLEEP_TIME_ACTIVE = 20;
      final int SLEEP_TIME_IDLE = 50;
      final int HEARTBEAT_INTERVAL = 500;
      final int READ_TIMEOUT_MS = 10_000;
      final int MAX_RETRIES_PER_TICK = 10;

      long lastProgress = System.currentTimeMillis();

      try {
         while (aBoolean1353) {
            int sleepTime = (anInt1332 == 0 && aClient1343.aClass14Array970[0] != null)
                    ? SLEEP_TIME_IDLE
                    : SLEEP_TIME_ACTIVE;

            try {
               Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {}

            waiting = true;

            for (int i = 0; i < MAX_LOOP_CYCLES && waiting; i++) {
               waiting = false;

               try {
                  method567(true);
                  method565(false);
               } catch (Exception e) {
                  //System.err.println("❌ method567/method565 error: " + e.getMessage());
                  e.printStackTrace();
               }

               if (anInt1366 == 0 && i >= 5) break;

               try {
                  method568((byte) -56);
               } catch (Exception e) {
                  //System.err.println("❌ method568 error: " + e.getMessage());
               }

               if (inputStream != null) {
                  try {
                     readData();
                     lastProgress = System.currentTimeMillis();
                  } catch (Exception e) {
                     //System.err.println("❌ readData() failure. Resetting socket.");
                     e.printStackTrace();
                     resetSocket();
                     continue;
                  }
               }
            }

            // Retry failed/incomplete files (JS5-style)
            int retries = 0;
            Iterator<OnDemandData> iter = retryQueue.iterator();
            while (iter.hasNext() && retries++ < MAX_RETRIES_PER_TICK) {
               OnDemandData data = iter.next();

               if (!data.incomplete || !containsInRequested(data)) {
                  iter.remove();
                  continue;
               }

               data.loopCycle++;
               if (data.loopCycle >= 50) {
                  data.loopCycle = 0;

                  if (++data.retryCount > MAX_RETRY_COUNT) {
                     //System.err.println("⚠ Max retries reached: type=" + data.dataType + ", id=" + data.ID);
                     data.incomplete = false;
                     data.unlink();
                     iter.remove();
                     continue;
                  }

                  try {
                     method556(8, data);
                    //System.out.println("⟳ Retrying: type=" + data.dataType + ", id=" + data.ID + ", attempt=" + data.retryCount);
                  } catch (Exception e) {
                     //System.err.println("❌ method556 failed: type=" + data.dataType + ", id=" + data.ID);
                     e.printStackTrace();
                     resetSocket(); // optional if you suspect socket desync
                  }
               }
            }

            // Resync retryQueue with any new failures
            for (OnDemandData data = (OnDemandData) requested.reverseGetFirst();
                 data != null;
                 data = (OnDemandData) requested.reverseGetNext(false)) {

               if (data.incomplete && !retryQueue.contains(data)) {
                  retryQueue.offer(data);
               }
            }

            // Kill socket if no progress in 10 seconds
            if (System.currentTimeMillis() - lastProgress > READ_TIMEOUT_MS) {
               //System.err.println("⚠ Socket idle >10s. Resetting.");
               resetSocket();
               lastProgress = System.currentTimeMillis();
               continue;
            }

            // Heartbeat
            if (client.loggedIn && socket != null && outputStream != null &&
                    (anInt1332 > 0 || aClient1343.aClass14Array970[0] == null)) {
               anInt1334++;
               if (anInt1334 > HEARTBEAT_INTERVAL) {
                  anInt1334 = 0;
                  try {
                     outputStream.write(new byte[]{0, 0, 0, 10});
                  } catch (IOException e) {
                     //System.err.println("❌ Heartbeat failed.");
                     lastProgress = 0;
                  }
               }
            }
         }
      } catch (Exception e) {
         signlink.reporterror("od_ex " + e.getMessage());
         e.printStackTrace();
      }
   }
   private boolean containsInRequested(OnDemandData target) {
      for (OnDemandData data = (OnDemandData) requested.reverseGetFirst();
           data != null;
           data = (OnDemandData) requested.reverseGetNext(false)) {
         if (data == target) return true; // or `.equals()` if overridden
      }
      return false;
   }

   private void resetSocket() {
      try { if (socket != null) socket.close(); } catch (IOException ignored) {}
      socket = null;
      inputStream = null;
      outputStream = null;
      expectedSize = 0;
   }


   public final void method560(int var1, int var2, boolean var3) {
      if(this.aClient1343.aClass14Array970[0] != null && this.versions[var2][var1] != 0 && this.fileStatus[var2][var1] != 0 && this.anInt1332 != 0) {
         OnDemandData var4 = new OnDemandData();
         var4.dataType = var2;
         var4.ID = var1;
         if(var3) {
            anInt1345 = -423;
         }

         var4.incomplete = false;
         DoubleEndedQueue var5 = this.aDoubleEndedQueue_1344;
         DoubleEndedQueue var6 = this.aDoubleEndedQueue_1344;
         synchronized(this.aDoubleEndedQueue_1344) {
            this.aDoubleEndedQueue_1344.insertHead(var4);
         }
      }

   }

   public final OnDemandData method561() {
      OnDemandData onDemandData;

      synchronized (aDoubleEndedQueue_1358) {
         onDemandData = (OnDemandData) aDoubleEndedQueue_1358.method251();
      }

      if (onDemandData == null) {
         return null;
      }

      synchronized (aClass2_1361) {
         onDemandData.method330(); // maybe resource release
      }

      if (onDemandData.buffer == null) {
         return onDemandData; // Nothing to decompress
      }

      try {
         onDemandData.buffer = decompress(onDemandData.buffer);
      } catch (IOException e) {
         //System.err.println("Failed to unzip [id=" + onDemandData.ID + ", type=" + onDemandData.dataType + "]: " + e.getMessage());
         onDemandData.buffer = null;
      }


      return onDemandData;
   }


   public int method562(int i, int j, int k, int l) {
      if(j != 0) {
         return anInt1345;
      } else {
         int i1 = (l << 8) + k;

         for(int j1 = 0; j1 < this.mapIndices1.length; ++j1) {
            if(this.mapIndices1[j1] == i1) {
               if(i == 0) {
                  int mapNigga2 = this.mapIndices2[j1] > 9999?-1:this.mapIndices2[j1];
                  return mapNigga2;
               }

               int mapNigga3 = this.mapIndices3[j1] > 9999?-1:this.mapIndices3[j1];
               return mapNigga3;
            }
         }

         return -1;
      }
   }

   public final void method548(int i) {
      this.method558(0, i);
   }

   public final void method563(byte byte0, int i, int j, byte byte1) {
      if(byte1 == 8) {
         boolean byte11 = false;
      } else {
         this.anInt1340 = 237;
      }

      if(this.aClient1343.aClass14Array970[0] != null) {
         if(this.versions[i][j] != 0) {
            byte[] abyte0 = this.aClient1343.aClass14Array970[i + 1].method233(j);
            if(!this.crcMatches(this.versions[i][j], this.anIntArrayArray1365[i][j], abyte0)) {
               this.fileStatus[i][j] = byte0;
               if(byte0 > this.anInt1332) {
                  this.anInt1332 = byte0;
               }

               ++this.anInt1330;
            }
         }
      }
   }

   public final boolean method564(int i, int j) {
      if(j >= 0) {
         throw new NullPointerException();
      } else {
         for(int k = 0; k < this.mapIndices1.length; ++k) {
            if(this.mapIndices3[k] == i) {
               return true;
            }
         }

         return false;
      }
   }

   private final void method565(boolean flag) {
      this.anInt1366 = 0;
      if(!flag) {
         this.anInt1367 = 0;

         OnDemandData onDemandData_1;
         for(onDemandData_1 = (OnDemandData)this.requested.reverseGetFirst(); onDemandData_1 != null; onDemandData_1 = (OnDemandData)this.requested.reverseGetNext(false)) {
            if(onDemandData_1.incomplete) {
               ++this.anInt1366;
            } else {
               ++this.anInt1367;
            }
         }

         while(this.anInt1366 < 10) {
            try {
               onDemandData_1 = (OnDemandData)this.aDoubleEndedQueue_1368.method251();
               if(onDemandData_1 == null) {
                  break;
               }

               if(this.fileStatus[onDemandData_1.dataType][onDemandData_1.ID] != 0) {
                  ++this.anInt1351;
               }

               this.fileStatus[onDemandData_1.dataType][onDemandData_1.ID] = 0;
               this.requested.insertHead(onDemandData_1);
               ++this.anInt1366;
               this.method556(8, onDemandData_1);
               this.waiting = true;
            } catch (Exception var3) {
               ;
            }
         }

      }
   }

   public final void method566(int i) {
      if(i != 0) {
         for(int j = 1; j > 0; ++j) {
            ;
         }
      }

      DoubleEndedQueue var5 = this.aDoubleEndedQueue_1344;
      synchronized(this.aDoubleEndedQueue_1344) {
         this.aDoubleEndedQueue_1344.method256();
      }
   }

   private final void method567(boolean flag) {
      if(flag) {
         DoubleEndedQueue abyte0 = this.aDoubleEndedQueue_1370;
         OnDemandData onDemandData;
         synchronized(this.aDoubleEndedQueue_1370) {
            onDemandData = (OnDemandData)this.aDoubleEndedQueue_1370.method251();
         }

         while(onDemandData != null) {
            this.waiting = true;
            byte[] abyte01 = null;
            if(this.aClient1343.aClass14Array970[0] != null) {
               abyte01 = this.aClient1343.aClass14Array970[onDemandData.dataType + 1].method233(onDemandData.ID);
            }

            DoubleEndedQueue var4 = this.aDoubleEndedQueue_1370;
            synchronized(this.aDoubleEndedQueue_1370) {
               if(abyte01 == null) {
                  this.aDoubleEndedQueue_1368.insertHead(onDemandData);
               } else {
                  onDemandData.buffer = abyte01;
                  DoubleEndedQueue var5 = this.aDoubleEndedQueue_1358;
                  synchronized(this.aDoubleEndedQueue_1358) {
                     this.aDoubleEndedQueue_1358.insertHead(onDemandData);
                  }
               }

               onDemandData = (OnDemandData)this.aDoubleEndedQueue_1370.method251();
            }
         }

      }
   }

   private final void method568(byte byte0) {
      // Legacy byte check – likely unused now
      if (byte0 != -56) {
         for (int i = 1; i > 0; i++) { /* NOP loop */ }
      }

      // Exit early if no need to request more
      while (anInt1366 == 0 && anInt1367 < 10 && anInt1332 != 0) {

         // === STEP 1: Pull from aDoubleEndedQueue_1344 ===
         OnDemandData onDemandData;
         synchronized (aDoubleEndedQueue_1344) {
            onDemandData = (OnDemandData) aDoubleEndedQueue_1344.method251();
         }

         while (onDemandData != null) {
            if (fileStatus[onDemandData.dataType][onDemandData.ID] != 0) {
               fileStatus[onDemandData.dataType][onDemandData.ID] = 0;

               requested.insertHead(onDemandData);
               method556(8, onDemandData);

               waiting = true;
               if (anInt1351 < anInt1330) anInt1351++;

               // Protect against div-by-zero if anInt1330 is misconfigured
               int progress = (anInt1330 == 0) ? 100 : (anInt1351 * 100 / anInt1330);
               aString1333 = "Loading extra files - " + progress + "%";

               anInt1367++;
               if (anInt1367 == 10) return;
            }

            synchronized (aDoubleEndedQueue_1344) {
               onDemandData = (OnDemandData) aDoubleEndedQueue_1344.method251();
            }
         }

         // === STEP 2: Scan for any [fileStatus] set to current pass ===
         for (int type = 0; type < 5; type++) {
            byte[] statusArray = fileStatus[type];
            int length = statusArray.length;

            for (int fileID = 0; fileID < length; fileID++) {
               if (statusArray[fileID] == anInt1332) {
                  statusArray[fileID] = 0;

                  OnDemandData demand = new OnDemandData();
                  demand.dataType = type;
                  demand.ID = fileID;
                  demand.incomplete = false;

                  requested.insertHead(demand);
                  method556(8, demand);

                  waiting = true;
                  if (anInt1351 < anInt1330) anInt1351++;

                  int progress = (anInt1330 == 0) ? 100 : (anInt1351 * 100 / anInt1330);
                  aString1333 = "Loading extra files - " + progress + "%";

                  anInt1367++;
                  if (anInt1367 == 10) return;
               }
            }
         }

         // Decrement and try again
         anInt1332--;
      }
   }

   public final boolean method569(int i, int j) {
      if(j != 5) {
         anInt1345 = 169;
      }

      return this.anIntArray1348.length == 1;
   }

   public OnDemandFetcher() {
      this.aClass2_1361 = new Class2(anInt1345);
      this.versions = new int[7][];
      this.anIntArrayArray1365 = new int[7][];
      this.aDoubleEndedQueue_1368 = new DoubleEndedQueue(169);
      this.aDoubleEndedQueue_1370 = new DoubleEndedQueue(169);
   }
}
