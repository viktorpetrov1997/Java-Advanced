package StreamsFilesAndDirectories.Lab;

import java.io.*;

class Cube implements Serializable
{
    private String color;
    private double width;
    private double height;
    private double depth;

    public Cube(String color, double width, double height, double depth)
    {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return "Cube { color = " + color + ", width = " + width + ", height = " + height + ", depth = " + depth + " }";
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        String path = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Task Resources\\9. Serialize Custom Object\\cube.ser";

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
