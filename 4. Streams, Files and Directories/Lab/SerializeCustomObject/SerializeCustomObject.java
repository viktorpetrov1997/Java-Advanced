package StreamsFilesAndDirectories.Lab.SerializeCustomObject;

import java.io.*;

public class SerializeCustomObject
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        String path = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Lab\\9. Serialize Custom Object\\cube.ser";

        // Serializing the cube object to a file
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(cube);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        // Deserializing the cube object from the file and printing it
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            Cube object = (Cube) ois.readObject();
            System.out.println(object);
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
