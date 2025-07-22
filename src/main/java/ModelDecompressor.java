import java.io.DataInputStream;
import java.io.FileInputStream;

import sign.signlink;

public class ModelDecompressor {

public static void loadModels() {
try {
DataInputStream dataFile = new DataInputStream(new FileInputStream(signlink.findcachedir() + ("/models/models.dat"))); //Example C:/my client/models/1.dat
DataInputStream indexFile = new DataInputStream(new FileInputStream(signlink.findcachedir() + ("/models/models.idx"))); //Example C:/my client/models/1.idx
int length = indexFile.readInt();
for(int i = 0; i < length; i++) {
int id = indexFile.readInt();
int invlength = indexFile.readInt();
byte[] data = new byte[invlength];
dataFile.readFully(data);
Model.method460(data, id);
}
indexFile.close();
dataFile.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}