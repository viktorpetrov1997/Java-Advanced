package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WriteToFile
{
    public static void main(String[] args) throws IOException
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Lab\\2. Write to File";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

        try(FileInputStream fileInputStream = new FileInputStream(inputPath))
        {
            int readByte = fileInputStream.read();
            while(readByte >= 0)
            {
                if(!punctuation.contains((char)readByte))
                {
                    fileOutputStream.write(readByte);
                }
                readByte = fileInputStream.read();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        fileOutputStream.close();
    }
}
