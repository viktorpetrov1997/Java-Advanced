package WorkshopBasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort // This task is not included in the exercises.
{
    public static void bubbleSort(int[] array)
    {
        int arrayLength = array.length;
        for(int i = 0; i < arrayLength - 1; i++)
        {
            for(int j = 0; j < arrayLength - i - 1; j++)
            {
                if(array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bubbleSort(numbers);

        System.out.println("Sorted Array:");

        for(int number : numbers)
        {
            System.out.print(number + " ");
        }
    }
}
