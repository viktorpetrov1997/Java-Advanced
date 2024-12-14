package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class MergeTwoFiles
{
    private static void copyContents(BufferedReader reader, BufferedWriter writer) throws IOException
    {
        String line = reader.readLine();
        while(line != null)
        {
            writer.write(line);
            writer.newLine();
            line = reader.readLine();
        }
    }

    public static void main(String[] args)
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\7. Merge Two Files";
        String inputOne = basePath + "\\inputOne.txt";
        String inputTwo = basePath + "\\inputTwo.txt";
        String outputPath = basePath + "\\output.txt";

        try(BufferedReader reader1 = new BufferedReader(new FileReader(inputOne));
            BufferedReader reader2 = new BufferedReader(new FileReader(inputTwo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
        )
        {
            copyContents(reader1, writer);
            copyContents(reader2, writer);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
