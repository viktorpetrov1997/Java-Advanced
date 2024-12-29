package WorkshopBasicAlgorithms;

import java.util.Scanner;

public class RecursiveArraySumSecondWay
{
    public static int calculateSum(int[] array, int index)
    {
        if(index == array.length)
        {
            return 0;
        }
        return array[index] + calculateSum(array, index + 1);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputStrings = input.split(" ");

        int[] array = new int[inputStrings.length];

        for(int i = 0; i < inputStrings.length; i++)
        {
            array[i] = Integer.parseInt(inputStrings[i]);
        }

        int sum = calculateSum(array, 0);

        System.out.println(sum);
    }
}
