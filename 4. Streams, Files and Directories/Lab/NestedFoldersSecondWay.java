package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFoldersSecondWay
{
    public static void main(String[] args)
    {
        String path = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Task Resources\\8. Nested Folders";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;

        while(!dirs.isEmpty())
        {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();

            if(nestedFiles != null)
            {
                for(File nestedFile : nestedFiles)
                {
                    if(nestedFile.isDirectory())
                    {
                        dirs.offer(nestedFile);
                    }
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
