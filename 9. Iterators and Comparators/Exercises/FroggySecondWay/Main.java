package IteratorsAndComparators.Exercises.FroggySecondWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            List<Integer> numbersList = Arrays.stream(input.split(", ")).map(Integer::parseInt)
                    .collect(Collectors.toList());

            Lake lake = new Lake(numbersList);

            List<String> result = new ArrayList<>();
            for(int element : lake)
            {
                result.add(String.valueOf(element));
            }

            System.out.println(String.join(", ", result));

            input = scanner.nextLine();
        }
    }
}
