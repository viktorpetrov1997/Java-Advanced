package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersToDivideBy = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) ->
        {
            for(int n : list)
            {
                if(number % n != 0)
                {
                    return false;
                }
            }
            return true;
        });

        for(int i = 1; i <= N; i++)
        {
            if(isDivisible.apply(i, numbersToDivideBy))
            {
                System.out.print(i + " ");
            }
        }
    }
}
