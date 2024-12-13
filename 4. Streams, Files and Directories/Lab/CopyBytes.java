package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes
{
    public static void main(String[] args) throws IOException
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Lab\\3. Copy Bytes";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

        try(FileInputStream fileInputStream = new FileInputStream(inputPath))
        {
            int readByte = fileInputStream.read();
            while(readByte >= 0)
            {
                if(readByte == 10 || readByte == 32)
                {
                    fileOutputStream.write(readByte);
                }
                else
                {
                    String number = String.valueOf(readByte);

                    for(int i = 0; i < number.length(); i++)
                    {
                        fileOutputStream.write(number.charAt(i));
                    }
                }
                readByte = fileInputStream.read();
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        fileOutputStream.close();
    }
}
