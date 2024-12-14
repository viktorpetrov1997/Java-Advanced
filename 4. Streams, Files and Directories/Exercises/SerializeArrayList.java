package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList
{
    public static void saveArrayListToFile(ArrayList<Double> list, String path)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(list);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<Double> loadArrayListFromFile(String path)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            return (ArrayList<Double>) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return  null;
        }
    }

    public static void main(String[] args)
    {
        String path = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\10. Serialize Array List\\list.ser";

        // Serialize list
        ArrayList<Double> listToSave = new ArrayList<>();
        listToSave.add(1.1);
        listToSave.add(2.2);
        listToSave.add(3.3);

        saveArrayListToFile(listToSave, path);

        // Deserialize list
        ArrayList<Double> loadedList = loadArrayListFromFile(path);

        if(loadedList != null)
        {
            System.out.println("Deserialized ArrayList: " + loadedList);
        }
    }
}
