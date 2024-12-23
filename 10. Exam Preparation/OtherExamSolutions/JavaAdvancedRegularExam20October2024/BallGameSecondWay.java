package OtherExamSolutions.JavaAdvancedRegularExam20October2024;

import java.util.*;

public class BallGameSecondWay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> strengthsStack = new ArrayDeque<>();
        Queue<Integer> accuraciesQueue = new ArrayDeque<>();

        String[] strengths = scanner.nextLine().split(" ");
        String[] accuracies = scanner.nextLine().split(" ");

        for(int i = 0; i < strengths.length; i++)
        {
            strengthsStack.push(Integer.valueOf(strengths[i]));
        }

        for(int i = 0; i < accuracies.length; i++)
        {
            accuraciesQueue.offer(Integer.valueOf(accuracies[i]));
        }

        int totalGoals = 0;

        while(!strengthsStack.isEmpty() && !accuraciesQueue.isEmpty())
        {
            int strength = strengthsStack.peek();
            int accuracy = accuraciesQueue.peek();

            int sum = strength + accuracy;
            if(sum == 100)
            {
                strengthsStack.pop();
                accuraciesQueue.poll();
                ++totalGoals;
            }
            else if(sum < 100)
            {
                if(strength < accuracy)
                {
                    strengthsStack.pop();
                }
                else if(strength > accuracy)
                {
                    accuraciesQueue.poll();
                }
                else
                {
                    strengthsStack.pop();
                    strengthsStack.push(sum);
                    accuraciesQueue.poll();
                }
            }
            else
            {
                strengthsStack.pop();
                strengthsStack.push(strength - 10);
                accuraciesQueue.add(accuraciesQueue.poll());
            }
        }

        if(totalGoals == 3)
        {
            System.out.println("Paul scored a hat-trick!");
        }
        else if(totalGoals == 0)
        {
            System.out.println("Paul failed to score a single goal.");
        }
        else if(totalGoals > 3)
        {
            System.out.println("Paul performed remarkably well!");
        }
        else if(totalGoals > 0 && totalGoals < 3)
        {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if(totalGoals > 0)
        {
            System.out.printf("Goals scored: %d%n", totalGoals);
        }

        if(!strengthsStack.isEmpty())
        {
            List<Integer> strengthsList = new ArrayList<>(strengthsStack);
            Collections.reverse(strengthsList);
            System.out.println("Strength values left: " + strengthsList.toString().replaceAll("\\[|\\]", ""));
        }

        if(!accuraciesQueue.isEmpty())
        {
            System.out.println("Accuracy values left: " + accuraciesQueue.toString().replaceAll("\\[|\\]", ""));
        }
    }
}
