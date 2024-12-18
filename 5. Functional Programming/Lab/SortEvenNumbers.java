package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers
{
    public static void printWithSeparator(List<Integer> numbersList)
    {
        for(int i = 0; i < numbersList.size(); i++)
        {
            if(i < numbersList.size() - 1)
            {
                System.out.print(numbersList.get(i) + ", ");
            }
            else
            {
                System.out.print(numbersList.get(i) + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        numbersList.removeIf(num -> num % 2 != 0);
        printWithSeparator(numbersList);

        System.out.println();

        numbersList.sort(Integer::compareTo);
        printWithSeparator(numbersList);
    }
}
