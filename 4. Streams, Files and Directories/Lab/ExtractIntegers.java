package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Task Resources\\4. Extract Integers";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));

        while(reader.hasNext())
        {
            if(reader.hasNextInt())
            {
                writer.println(reader.nextInt());
            }
            reader.next();
        }
    }
}
