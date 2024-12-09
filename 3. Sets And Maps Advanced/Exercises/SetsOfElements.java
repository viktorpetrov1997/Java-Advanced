package SetsAndMapsAdvanced.Exercises;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] setsLengths = scanner.nextLine().split(" ");
        int firstSetLength = Integer.parseInt(setsLengths[0]);
        int secondSetLength = Integer.parseInt(setsLengths[1]);

        Set<Integer> firstSet = new HashSet<>();

        for(int i = 0; i < firstSetLength; i++)
        {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        Set<Integer> secondSet = new HashSet<>();

        for(int i = 0; i < secondSetLength; i++)
        {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet); // retains only the numbers that are present in both sets

        for(int number : firstSet)
        {
            System.out.print(number + " ");
        }
    }
}
