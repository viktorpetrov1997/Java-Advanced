package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadFile
{
    public static void main(String[] args)
    {
        String path = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Lab\\1. Read File\\input.txt";

        try(FileInputStream fileStream = new FileInputStream(path))
        {
            int oneByte = fileStream.read();
            while(oneByte >= 0)
            {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
