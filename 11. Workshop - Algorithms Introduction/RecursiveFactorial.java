package WorkshopBasicAlgorithms;

import java.util.Scanner;

public class RecursiveFactorial
{
    public static int calculateFactorial(int number)
    {
        if(number == 0 || number == 1)
        {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int factorial = calculateFactorial(number);

        System.out.println(factorial);
    }
}
