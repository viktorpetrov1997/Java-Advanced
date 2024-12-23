package Generics.Exercises.GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static <T> void swapElements(List<T> list, int firstIndex, int secondIndex)
    {
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Box> boxList = new ArrayList<>();

        int numberOfStrings = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfStrings; i++)
        {
            int input = Integer.parseInt(scanner.nextLine());

            Box<Integer> box = new Box<>(input);
            boxList.add(box);
        }

        String[] swapIndexes = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(swapIndexes[0]);
        int secondIndex = Integer.parseInt(swapIndexes[1]);

        swapElements(boxList, firstIndex, secondIndex);

        for(Box box : boxList)
        {
            System.out.println(box);
        }
    }
}
