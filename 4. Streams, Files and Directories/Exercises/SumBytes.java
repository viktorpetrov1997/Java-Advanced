package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes
{
    public static void main(String[] args)
    {
        String filePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\2. Sum Bytes\\input.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            long asciiSum = 0;

            String line = reader.readLine();

            while(line != null)
            {
                for(char character : line.toCharArray())
                {
                    asciiSum += (int) character;
                }
                line = reader.readLine();
            }

            System.out.println(asciiSum);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
