package StacksAndQueues.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> expressionParts = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        ArrayDeque<String> stack = new ArrayDeque<>(expressionParts);

        while(stack.size() > 1)
        {
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            int result = 0;

            if(operator.equals("+"))
            {
                result = firstNumber + secondNumber;
            }
            else
            {
                result = firstNumber - secondNumber;
            }

            stack.push("" + result);
        }

        System.out.println(stack.peek());
    }
}
