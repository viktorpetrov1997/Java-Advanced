package StacksAndQueues.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class BasicQueueOperations
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

        for (int i = 0; i < N; i++)
        {
            stack.offer(Integer.valueOf(numbers.get(i)));
        }

        for (int i = 0; i < S; i++)
        {
            stack.poll();
        }

        if (stack.contains(X))
        {
            System.out.println("true");
        }
        else
        {
            if(!stack.isEmpty())
            {
                System.out.println(Collections.min(stack));
            }
            else
            {
                System.out.println(0);
            }
        }
    }
}
