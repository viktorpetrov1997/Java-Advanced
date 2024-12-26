package IteratorsAndComparators.Exercises.ListyIterator;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;

        String command = scanner.nextLine();
        while(!command.equals("END"))
        {
            if(command.startsWith("Create"))
            {
                String[] elements = command.length() > 7 ? command.substring(7).split(" ") : new String[0];
                listyIterator = new ListyIterator(elements);
            }
            else if(listyIterator != null)
            {
                switch(command)
                {
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                    case "Print":
                        try
                        {
                            listyIterator.print();
                        }
                        catch(IllegalStateException e)
                        {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }
            command = scanner.nextLine();
        }
    }
}
