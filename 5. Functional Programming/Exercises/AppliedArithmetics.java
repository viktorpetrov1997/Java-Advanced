package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addCommand = list -> list.stream().map(number -> number + 1)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiplyCommand = list -> list.stream().map(number -> number * 2)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtractCommand  = list -> list.stream().map(number -> number - 1)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));

        String command = scanner.nextLine();
        while(!command.equals("end"))
        {
            switch(command)
            {
                case "add":
                    numbersList = addCommand.apply(numbersList);
                    break;
                case "subtract":
                    numbersList = subtractCommand.apply(numbersList);
                    break;
                case "multiply":
                    numbersList = multiplyCommand.apply(numbersList);
                    break;
                case "print":
                    printCommand.accept(numbersList);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
