import java.io.*;

public final class Class14 {

    public static final int INDEX_SIZE = 6;
    public static final int DATA_BLOCK_SIZE = 512;
    public static final int DATA_HEADER_SIZE = 8;
    public static final int DATA_SIZE = DATA_HEADER_SIZE + DATA_BLOCK_SIZE;

    public Class14(int i, RandomAccessFile randomaccessfile, RandomAccessFile randomaccessfile1, int j, boolean flag) {
        anInt306 = 923;
        aBoolean307 = true;
        anInt312 = 65000;
        fileType = j;
        if (!flag) {
            throw new NullPointerException();
        } else {
            dataFile = randomaccessfile;
            indexFile = randomaccessfile1;
            anInt312 = i;
            return;
        }
    }

    public long getFileCount() {
        try {
            if (indexFile != null) {
                return (indexFile.length() / INDEX_SIZE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public synchronized byte[] method233(int fileId) {
        try {
            seekTo(indexFile, -660, fileId * INDEX_SIZE);
            int read;
            for (int j = 0; j < INDEX_SIZE; j += read) {
                read = indexFile.read(buffer, j, INDEX_SIZE - j);
                if (read == -1)
                    return null;
            }

            int fileSize = ((buffer[0] & 0xff) << 16) + ((buffer[1] & 0xff) << 8) + (buffer[2] & 0xff);
            int sectorId = ((buffer[3] & 0xff) << 16) + ((buffer[4] & 0xff) << 8) + (buffer[5] & 0xff);
            if (sectorId <= 0 || (long) sectorId > dataFile.length() / DATA_SIZE)
                return null;
            byte fileData[] = new byte[fileSize];
            int readerIndex = 0;
            int chunkLength = fileId <= 0xffff ? 512 : 510;
            int headerLength = fileId <= 0xffff ? 8 : 10;
            for (int l1 = 0; readerIndex < fileSize; l1++) {
                if (sectorId == 0)
                    return null;
                seekTo(dataFile, -660, sectorId * DATA_SIZE);
                int k = 0;
                int remaining = fileSize - readerIndex;
                if (remaining > chunkLength)
                    remaining = chunkLength;
                int offset;
                for (; k < remaining + headerLength; k += offset) {
                    offset = dataFile.read(buffer, k, (remaining + headerLength) - k);
                    if (offset == -1)
                        return null;
                }

                int currentIndex;
                int currentPart;
                int nextSector;
                int currentFile;

                if (fileId <= 0xffff) {
                    currentIndex = ((buffer[0] & 0xff) << 8) + (buffer[1] & 0xff);//Short
                    currentPart = ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);//Short
                    nextSector = ((buffer[4] & 0xff) << 16) + ((buffer[5] & 0xff) << 8) + (buffer[6] & 0xff);//Medium
                    currentFile = buffer[7] & 0xff;//Byte
                } else {
                    currentIndex = ((buffer[0] & 0xff) << 24) + ((buffer[1] & 0xff) << 16) + ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);//Int
                    currentPart = ((buffer[4] & 0xff) << 8) + (buffer[5] & 0xff);//Short
                    nextSector = ((buffer[6] & 0xff) << 16) + ((buffer[7] & 0xff) << 8) + (buffer[8] & 0xff);//Medium
                    currentFile = buffer[9] & 0xff;//Byte
                }
                if (currentIndex != fileId || currentPart != l1 || currentFile != fileType)
                    return null;
                if (nextSector < 0 || (long) nextSector > dataFile.length() / DATA_SIZE)
                    return null;
                for (int k3 = 0; k3 < remaining; k3++)
                    fileData[readerIndex++] = buffer[k3 + headerLength];

                sectorId = nextSector;
            }

            return fileData;
        } catch (IOException _ex) {
            return null;
        }
    }

    public synchronized boolean method234(int i, byte abyte0[], byte byte0, int j) {
        boolean flag = method235(true, j, i, abyte0);
        if (byte0 == 2)
            byte0 = 0;
        else
            aBoolean307 = !aBoolean307;
        if (!flag)
            flag = method235(false, j, i, abyte0);
        return flag;
    }

    private synchronized boolean method235(boolean overwrite, int fileId, int fileSize, byte[] data) {
        try {
            int firstSectorId;
            if (overwrite) {
                seekTo(indexFile, -660, fileId * INDEX_SIZE);
                int k1;
                for (int i1 = 0; i1 < INDEX_SIZE; i1 += k1) {
                    k1 = indexFile.read(buffer, i1, INDEX_SIZE - i1);
                    if (k1 == -1)
                        return false;
                }

                firstSectorId = ((buffer[3] & 0xff) << 16) + ((buffer[4] & 0xff) << 8) + (buffer[5] & 0xff);
                if (firstSectorId <= 0 || (long) firstSectorId > dataFile.length() / DATA_SIZE)
                    return false;
            } else {
                firstSectorId = (int) ((dataFile.length() + 519L) / DATA_SIZE);
                if (firstSectorId == 0)
                    firstSectorId = 1;
            }
            buffer[0] = (byte) (fileSize >> 16);
            buffer[1] = (byte) (fileSize >> 8);
            buffer[2] = (byte) fileSize;
            buffer[3] = (byte) (firstSectorId >> 16);
            buffer[4] = (byte) (firstSectorId >> 8);
            buffer[5] = (byte) firstSectorId;
            seekTo(indexFile, -660, fileId * 6);
            indexFile.write(buffer, 0, 6);
            int chunkLength = fileId <= 0xffff ? 512 : 510;
            int headerLength = fileId <= 0xffff ? 8 : 10;

            int j1 = 0;
            for (int chunkId = 0; j1 < fileSize; chunkId++) {
                int nextSector = 0;
                if (overwrite) {
                    seekTo(dataFile, -660, firstSectorId * DATA_SIZE);
                    int j2;
                    int l2;
                    for (j2 = 0; j2 < headerLength; j2 += l2) {
                        l2 = dataFile.read(buffer, j2, headerLength - j2);
                        if (l2 == -1)
                            break;
                    }

                    if (j2 == headerLength) {
                        int currentIndex;
                        int currentPart;
                        int currentFile;

                        if (fileId <= 0xffff) {
                            currentIndex = ((buffer[0] & 0xff) << 8) + (buffer[1] & 0xff);//Short
                            currentPart = ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);//Short
                            nextSector = ((buffer[4] & 0xff) << 16) + ((buffer[5] & 0xff) << 8) + (buffer[6] & 0xff);//Medium
                            currentFile = buffer[7] & 0xff;//Byte
                        } else {
                            currentIndex = ((buffer[0] & 0xff) << 24) + ((buffer[1] & 0xff) << 16) + ((buffer[2] & 0xff) << 8) + (buffer[3] & 0xff);//Int
                            currentPart = ((buffer[4] & 0xff) << 8) + (buffer[5] & 0xff);//Short
                            nextSector = ((buffer[6] & 0xff) << 16) + ((buffer[7] & 0xff) << 8) + (buffer[8] & 0xff);//Medium
                            currentFile = buffer[9] & 0xff;//Byte
                        }

                        if (currentIndex != fileId || currentPart != chunkId || currentFile != fileType)
                            return false;
                        if (nextSector < 0 || (long) nextSector > dataFile.length() / DATA_SIZE)
                            return false;
                    }
                }
                if (nextSector == 0) {
                    overwrite = false;
                    nextSector = (int) ((dataFile.length() + 519L) / DATA_SIZE);
                    if (nextSector == 0)
                        nextSector++;
                    if (nextSector == firstSectorId)
                        nextSector++;
                }
                if (fileSize - j1 <= chunkLength)
                    nextSector = 0;
                if (fileId <= 0xffff) {
                    buffer[0] = (byte) (fileId >> 8);//Short
                    buffer[1] = (byte) fileId;
                    buffer[2] = (byte) (chunkId >> 8);//Short
                    buffer[3] = (byte) chunkId;
                    buffer[4] = (byte) (nextSector >> 16);//Medium
                    buffer[5] = (byte) (nextSector >> 8);
                    buffer[6] = (byte) nextSector;
                    buffer[7] = (byte) fileType;//Byte
                } else {
                    buffer[0] = (byte) (fileId >> 24);//Int
                    buffer[1] = (byte) (fileId >> 16);
                    buffer[2] = (byte) (fileId >> 8);
                    buffer[3] = (byte) fileId;
                    buffer[4] = (byte) (chunkId >> 8);//Short
                    buffer[5] = (byte) chunkId;
                    buffer[6] = (byte) (nextSector >> 16);//Medium
                    buffer[7] = (byte) (nextSector >> 8);
                    buffer[8] = (byte) nextSector;
                    buffer[9] = (byte) fileType;//Byte
                }
                seekTo(dataFile, -660, firstSectorId * DATA_SIZE);
                dataFile.write(buffer, 0, headerLength);
                int k2 = fileSize - j1;
                if (k2 > chunkLength)
                    k2 = chunkLength;
                dataFile.write(data, j1, k2);
                j1 += k2;
                firstSectorId = nextSector;
            }

            return true;
        } catch (IOException _ex) {
            return false;
        }
    }

    public synchronized void seekTo(RandomAccessFile randomaccessfile, int indexId, int offset) {
        if (offset < 0) {
            System.err.println("seekTo(): Attempted to seek to negative offset: " + offset + " (index=" + indexId + ")");
            return;
        }

        try {
            randomaccessfile.seek(offset);
        } catch (IOException e) {
            System.err.println("seekTo(): Failed to seek to offset " + offset + " in index " + indexId);
            e.printStackTrace();
        }
    }

    private int anInt306;
    private boolean aBoolean307;
    static byte buffer[] = new byte[520];
    RandomAccessFile dataFile;
    RandomAccessFile indexFile;
    int fileType;
    int anInt312;

}
