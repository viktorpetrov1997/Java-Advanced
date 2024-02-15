package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < N; i++)
        {
            String[] commandArray = scanner.nextLine().split(" ");
            String command = commandArray[0];

            if(command.equals("1"))
            {
                int X = Integer.parseInt(commandArray[1]);
                stack.push(X);
            }
            else if(command.equals("2"))
            {
                stack.pop();
            }
            else if(command.equals("3"))
            {
                int maxNumber = Collections.max(stack);
                System.out.println(maxNumber);
            }
        }
    }
}
