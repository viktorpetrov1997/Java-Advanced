package StreamsFilesAndDirectories.Exercises.SerializeCustomObject;

import java.io.Serializable;

public class Course implements Serializable
{
    private String name;
    private int numberOfStudents;

    // Constructor
    public Course(String name, int numberOfStudents)
    {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public String toString()
    {
        return "{ name = '" + name + '\'' + ", numberOfStudents = " + numberOfStudents + " }";
    }
}