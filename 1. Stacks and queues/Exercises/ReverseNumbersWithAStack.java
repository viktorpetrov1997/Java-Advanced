package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        ArrayDeque<String> stack = new ArrayDeque<>();

        for(String number : numbers)
        {
            stack.push(number);
        }

        while(!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
    }
}
