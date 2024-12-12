package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.nio.file.Files;

public class ListFiles
{
    public static void main(String[] args)
    {
        String folderPath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Task Resources\\7. List Files\\Files-and-Streams";

        File file = new File(folderPath);

        File[] nestedFiles = file.listFiles();

        for(File nestedFile : nestedFiles)
        {
            if(nestedFile.isFile())
            {
                System.out.printf("%s: %d bytes%n", nestedFile.getName(), nestedFile.length());
            }
        }
    }
}
