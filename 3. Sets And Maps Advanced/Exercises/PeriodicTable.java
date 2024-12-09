package SetsAndMapsAdvanced.Exercises;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numberOfChemicalCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalCompounds = new TreeSet<>();

        for(int i = 0; i < numberOfChemicalCompounds; i++)
        {
            String[] compound = scanner.nextLine().split(" ");
            for(String element : compound)
            {
                chemicalCompounds.add(element);
            }
        }

        for(String element : chemicalCompounds)
        {
            System.out.print(element + " ");
        }
    }
}
