package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.*;

public class WordCount
{
    public static List<String> readWordsFromFile(String filePath)
    {
        List<String> words = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line = reader.readLine();
            while(line != null)
            {
                String[] tokens = line.split("\\W+");
                words.addAll(Arrays.asList(tokens));
                line = reader.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return words;
    }

    private static Map<String, Integer> countWordOccurrences(List<String> words, String textFile)
    {
        Map<String, Integer> wordsCount = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(textFile)))
        {
            String line = reader.readLine();
            while(line != null)
            {
                String[] tokens = line.split("\\W+");
                for(String token : tokens)
                {
                    if(!token.isEmpty())
                    {
                        if(words.contains(token))
                        {
                            wordsCount.put(token, wordsCount.getOrDefault(token, 0) + 1);
                        }
                    }
                }
                line = reader.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return wordsCount;
    }

    private static List<Map.Entry<String, Integer>> sortByFrequency(Map<String, Integer> wordsCount)
    {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordsCount.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        return sortedEntries;
    }

    public static void writeResultsToFile(List<Map.Entry<String, Integer>> sortedEntries, String resultsFile)
    {
        try(PrintWriter writer = new PrintWriter(resultsFile))
        {
            for(Map.Entry<String, Integer> entry : sortedEntries)
            {
                writer.printf("%s - %d%n", entry.getKey(), entry.getValue());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\6. Word Count";
        String wordsFile = basePath + "\\words.txt";
        String textFile = basePath + "\\text.txt";
        String resultsFile = basePath + "\\results.txt";

        List<String> words = readWordsFromFile(wordsFile);

        Map<String, Integer> wordsCount = countWordOccurrences(words, textFile);

        List<Map.Entry<String, Integer>> sortedEntries = sortByFrequency(wordsCount);

        writeResultsToFile(sortedEntries, resultsFile);
    }
}
