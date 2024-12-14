package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers
{
    public static void main(String[] args)
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\5. Line Numbers";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            PrintWriter writer = new PrintWriter(outputPath))
        {
            int lineNumber = 1;

            String line = reader.readLine();

            while(line != null)
            {
                writer.printf("%d. %s%n", lineNumber, line);
                ++lineNumber;
                line = reader.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
