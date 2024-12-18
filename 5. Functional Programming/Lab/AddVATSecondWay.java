package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVATSecondWay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVat = number -> number * 1.2;

        System.out.println("Prices with VAT:");
        for(double number : numbersList)
        {
            double priceWithVAT = addVat.apply(number);
            System.out.printf("%.2f%n", priceWithVAT);
        }
    }
}
