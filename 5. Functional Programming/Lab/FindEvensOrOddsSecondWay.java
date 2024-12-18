package FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOddsSecondWay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        String oddOrEven = scanner.nextLine();

        Predicate<Integer> condition = oddOrEven.equals("odd") ? (x -> x % 2 != 0) : (x -> x % 2 == 0);

        for(int i = lowerBound; i <= upperBound; i++)
        {
            if(condition.test(i))
            {
                System.out.print(i + " ");
            }
        }
    }
}
