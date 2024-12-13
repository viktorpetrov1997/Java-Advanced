package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine
{
    public static void main(String[] args)
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Lab\\5. Write Every Third Line";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputPath))))
        {
            String line = reader.readLine();
            int lineNumber = 1;

            while(line != null)
            {
                if(lineNumber % 3 == 0)
                {
                    writer.println(line);
                }
                lineNumber++;
                line = reader.readLine();
            }
        }
        catch(IOException e)
        {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
