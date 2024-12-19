package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisor = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkDivision = number -> number % divisor == 0;

        numbersList.removeIf(checkDivision);
        Collections.reverse(numbersList);

        numbersList.forEach(number -> System.out.print(number + " "));
    }
}

