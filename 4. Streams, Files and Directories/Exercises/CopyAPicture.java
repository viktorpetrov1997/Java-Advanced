package StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture
{
    public static void main(String[] args)
    {
        String sourceFile = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\9. Copy a Picture\\picture.jpg";
        String destinationFile = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\9. Copy a Picture\\picture-copy.jpg";

        final int BUFFER_SIZE = 4096; // A buffer is used in this program to optimize the process of reading and writing files. It significantly reduces the number of I/O operations, making the program faster and capable of handling large files efficiently.

        try(FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile))
        {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            bytesRead = fis.read(buffer);
            while(bytesRead != -1)
            {
                fos.write(buffer, 0, bytesRead);
                bytesRead = fis.read(buffer);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
