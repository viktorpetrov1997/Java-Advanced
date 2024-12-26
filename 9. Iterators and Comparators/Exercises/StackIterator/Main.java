package IteratorsAndComparators.Exercises.StackIterator;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();

        String command = scanner.nextLine();
        while(!command.equals("END"))
        {
            if(command.startsWith("Push"))
            {
                String[] commandParts = command.substring(5).trim().split(", ");
                for(String element : commandParts)
                {
                    customStack.push(Integer.parseInt(element));
                }
            }
            else if(command.equals("Pop"))
            {
                try
                {
                    customStack.pop();
                }
                catch(IllegalStateException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            command = scanner.nextLine();
        }

        for(Integer element : customStack)
        {
            System.out.println(element);
        }

        for(Integer element : customStack)
        {
            System.out.println(element);
        }
    }
}
