package StreamsFilesAndDirectories.Exercises.SerializeCustomObject;

import java.io.*;

public class SerializeCustomObject
{
    public static void saveCourse(Course course, String path)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(course);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Course loadCourse(String path)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            return (Course) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args)
    {
        String path = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\11. Serialize Custom Object\\course.ser";

        Course course = new Course("Java Programming", 30);

        saveCourse(course, path);

        Course loadedCourse = loadCourse(path);

        if(loadedCourse != null)
        {
            System.out.println("Loaded course: " + loadedCourse);
        }
    }
}
