package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines
{
    public static void main(String[] args)
    {
        String filePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\1. Sum Lines\\input.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line = reader.readLine();

            while(line != null)
            {
                int asciiSum = 0;

                for(char character : line.toCharArray())
                {
                    asciiSum += (int) character;
                }

                System.out.println(asciiSum);

                line = reader.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
