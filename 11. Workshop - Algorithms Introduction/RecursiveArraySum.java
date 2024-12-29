package WorkshopBasicAlgorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecursiveArraySum
{
    public static int calculateSum(List<Integer> array, int index)
    {
        if(index == array.size())
        {
            return 0;
        }
        return array.get(index) + calculateSum(array, index + 1);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = calculateSum(array, 0);

        System.out.println(sum);
    }
}
