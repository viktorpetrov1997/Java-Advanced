package StreamsFilesAndDirectories.Exercises;

import java.io.File;

public class GetFolderSize
{
    public static long calculateFolderSize(File folder)
    {
        long totalSize = 0;

        File[] files = folder.listFiles();
        if(files != null)
        {
            for(File file : files)
            {
                if(file.isFile())
                {
                    totalSize += file.length();
                }
                else if(file.isDirectory())
                {
                    totalSize += calculateFolderSize(file);
                }
            }
        }
        return totalSize;
    }

    public static void main(String[] args)
    {
        String folderPath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\8. Get Folder Size";

        File folder = new File(folderPath);

        if(folder.exists() && folder.isDirectory())
        {
            long folderSize = calculateFolderSize(folder);
            System.out.println("Folder size: " + folderSize);
        }
    }
}
