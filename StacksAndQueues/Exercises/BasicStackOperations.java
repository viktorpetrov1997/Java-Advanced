package StacksAndQueues.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> commands = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(commands.get(0));
        int S = Integer.parseInt(commands.get(1));
        int X = Integer.parseInt(commands.get(2));

        for(int i = 0; i < N; i++)
        {
            int number = Integer.parseInt(numbers.get(i));
            stack.push(number);
        }

        for(int i = 0; i < S; i++)
        {
            stack.pop();
        }

        if(stack.isEmpty())
        {
            System.out.println(0);
            return;
        }

        int min = Integer.MAX_VALUE;
        boolean isXPresent = false;
        while(!stack.isEmpty())
        {
            int number = stack.pop();
            if(number < min)
            {
                min = number;
            }
            if(number == X)
            {
                System.out.println("true");
                isXPresent = true;
            }
        }

        if(!isXPresent)
        {
            System.out.println(min);
        }
    }
}
