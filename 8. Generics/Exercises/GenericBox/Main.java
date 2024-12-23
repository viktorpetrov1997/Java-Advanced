package Generics.Exercises.GenericBox;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());;

        for(int i = 0; i < numberOfStrings; i++)
        {
            String input = scanner.nextLine();;

            Box<String> box = new Box<>(input);
            System.out.println(box);
        }
    }
}
