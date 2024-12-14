package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.zip.*;

public class CreateZipArchive
{
    public static void main(String[] args)
    {
        String[] inputFiles = {
                "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\12. Create Zip Archive\\file1.txt",
                "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\12. Create Zip Archive\\file2.txt",
                "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\12. Create Zip Archive\\file3.txt"
        };

        String zipFileName = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\12. Create Zip Archive\\files.zip";

        try(FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos))
        {
            for(String inputFile : inputFiles)
            {
                try(FileInputStream fis = new FileInputStream(inputFile))
                {
                    ZipEntry zipEntry = new ZipEntry(new File(inputFile).getName());
                    zos.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int bytesRead = fis.read(buffer);
                    while(bytesRead > 0)
                    {
                        zos.write(buffer, 0, bytesRead);
                        bytesRead = fis.read(buffer);
                    }

                    zos.closeEntry();
                }
                catch(IOException e)
                {
                    System.err.println("Error reading file: " + inputFile);
                    e.printStackTrace();
                }
            }
            System.out.println("Files successfully zipped into " + zipFileName);
        }
        catch(IOException e)
        {
            System.err.println("Error creating zip file");
            e.printStackTrace();
        }
    }
}
