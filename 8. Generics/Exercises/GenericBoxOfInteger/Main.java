package Generics.Exercises.GenericBoxOfInteger;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());;

        for(int i = 0; i < numberOfStrings; i++)
        {
            int input = Integer.parseInt(scanner.nextLine());

            Box<Integer> box = new Box<>(input);
            System.out.println(box);
        }
    }
}
