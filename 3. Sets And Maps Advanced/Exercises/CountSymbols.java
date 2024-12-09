package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> countSymbols = new TreeMap<>();

        for(int i = 0; i < text.length(); i++)
        {
            char currentSymbol = text.charAt(i);
            countSymbols.putIfAbsent(currentSymbol, 0);
            countSymbols.put(currentSymbol, countSymbols.get(currentSymbol) + 1);
        }

        for(Map.Entry<Character, Integer> entry : countSymbols.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
