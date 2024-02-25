package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> occurrencesOfNumber = new LinkedHashMap<>();

        for(double value : numbers)
        {
            occurrencesOfNumber.putIfAbsent(value, 0);
            occurrencesOfNumber.put(value, occurrencesOfNumber.get(value) + 1);
        }

        for(Map.Entry<Double, Integer> entry : occurrencesOfNumber.entrySet())
        {
            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
