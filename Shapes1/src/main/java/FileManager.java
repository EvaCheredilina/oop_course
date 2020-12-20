import com.google.gson.Gson;

import java.io.*;

public class FileManager {
    public static void write(Object obj) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Shapes.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
        }
        catch (Exception ex){
            System.out.println("File is not found!");
        }
    }

    public static Object read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Shapes.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
        catch (Exception ex){
            System.out.println("File is not found!");
        }
        return null;
    }
}