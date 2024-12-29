package WorkshopBasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort
{
    private static void sort(int[] array)
    {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(array, low, high);
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high)
    {
        int pivot = array[high];
        int i = low - 1;

        for(int j = low; j < high; j++)
        {
            if(array[j] <= pivot)
            {
                i++;
                if(i != j)
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sort(numbers);

        for(int number : numbers)
        {
            System.out.print(number + " ");
        }
    }
}
