package WorkshopBasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch
{
    public static int getIndex(int[] array, int key)
    {
        int start = 0;
        int end = array.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(key < array[mid])
            {
                end = mid - 1;
            }
            else if(key > array[mid])
            {
                start = mid + 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int key = Integer.parseInt(scanner.nextLine());

        System.out.println(getIndex(numbers, key));
    }
}
