package FunctionalProgramming.Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");

        Consumer<String> printNames = name -> System.out.println("Sir " + name);

        for(String name : names)
        {
            printNames.accept(name);
        }
    }
}
