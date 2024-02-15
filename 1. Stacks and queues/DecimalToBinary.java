package StacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if(number == 0)
        {
            System.out.println(0);
            return;
        }

        while(number > 0)
        {
            stack.push(number % 2);
            number /= 2;
        }

        while(!stack.isEmpty())
        {
            System.out.print(stack.pop());
        }
    }
}
