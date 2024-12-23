package Generics.Exercises.CustomListIteratorSecondWay;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] commandParts = input.split(" ");

            String command = commandParts[0];
            switch(command)
            {
                case "Add":
                    String commandValue = commandParts[1];
                    customList.add(commandValue);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandParts[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String element = commandParts[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandParts[1]);
                    int secondIndex = Integer.parseInt(commandParts[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementToBeGreaterThan = commandParts[1];
                    System.out.println(customList.countGreaterThan(elementToBeGreaterThan));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for(String item : customList)
                    {
                        System.out.println(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
