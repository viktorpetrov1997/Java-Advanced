package StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NestedFolders
{
    public static void main(String[] args)
    {
        Path folderPath = Paths.get("C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Task Resources\\8. Nested Folders");

        if(Files.exists(folderPath) && Files.isDirectory(folderPath))
        {
            try
            {
                long folderCount = Files.walk(folderPath)
                        .filter(Files::isDirectory)
                        .peek(path -> System.out.println(path.getFileName()))
                        .count();

                System.out.printf("%d folders%n", folderCount);
            }
            catch(IOException e)
            {
                System.out.println("An error occurred while listing directories: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("The folder path does not exist or is not a directory.");
        }
    }
}
