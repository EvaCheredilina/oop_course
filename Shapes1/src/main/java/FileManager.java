import com.google.gson.Gson;

import java.io.*;

public class FileManager {
    public static void write(Object obj) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Shapes.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(obj);
        } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public static Object read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Shapes.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object obj = null;

        try{
            obj = objectInputStream.readObject();
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }

        return obj;
    }
}