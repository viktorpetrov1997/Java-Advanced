package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parse = s -> Integer.parseInt(s);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> parse.apply(element))
                .collect(Collectors.toList());

        int sum = numbersList.stream().mapToInt(a -> a).sum();

        System.out.println("Count = " + numbersList.size());
        System.out.println("Sum = " + sum);
    }
}
