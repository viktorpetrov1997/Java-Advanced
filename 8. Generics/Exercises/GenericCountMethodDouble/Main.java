package Generics.Exercises.GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static <T extends Comparable<T>> int countGreaterElements(List<Box<T>> elements, Box<T> elementToCompare)
    {
        int count = 0;
        for(Box<T> element : elements)
        {
            if(element.compareTo(elementToCompare) > 0)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> elements = new ArrayList<>();

        for(int i = 0; i < numberOfElements; i++)
        {
            double value = Double.parseDouble(scanner.nextLine());
            elements.add(new Box<>(value));
        }

        double compareValue = Double.parseDouble(scanner.nextLine());
        Box<Double> elementToCompare = new Box<>(compareValue);

        int result = countGreaterElements(elements, elementToCompare);
        System.out.println(result);
    }
}
