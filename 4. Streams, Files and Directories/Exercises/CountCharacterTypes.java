package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes
{
    public static void main(String[] args)
    {
        String basePath = "C:\\Users\\User\\Desktop\\Софтуерно инженерство\\Java Advanced\\5. Streams, Files and Directories\\Streams, Files and Directories - Resources\\Exercises\\4. Count Character Types";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            PrintWriter writer = new PrintWriter(outputPath))
        {
            int numberOfVowels = 0;
            int numberOfOtherSymbols = 0;
            int numberOfPunctuationMarks = 0;

            String line = reader.readLine();

            while(line != null)
            {
                for(char character : line.toCharArray())
                {
                    if(character == 'a' || character == 'e' || character == 'i' || character == 'o'
                            || character == 'u')
                    {
                        ++numberOfVowels;
                    }
                    else if(character == '!' || character == ',' || character == '.' || character == '?')
                    {
                        ++numberOfPunctuationMarks;
                    }
                    else if(character != ' ')
                    {
                        ++numberOfOtherSymbols;
                    }
                }
                line = reader.readLine();
            }

            writer.println("Vowels: " + numberOfVowels);
            writer.println("Other symbols: " + numberOfOtherSymbols);
            writer.println("Punctuation: " + numberOfPunctuationMarks);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
