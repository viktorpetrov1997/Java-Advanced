package OtherExamSolutions.JavaAdvancedRegularExam20October2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BallGame
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> strengthsList = new ArrayList<>();
        List<Integer> accuraciesList = new ArrayList<>();

        String[] strengths = scanner.nextLine().split(" ");
        String[] accuracies = scanner.nextLine().split(" ");

        for(int i = 0; i < strengths.length; i++)
        {
            strengthsList.add(Integer.valueOf(strengths[i]));
        }

        for(int i = 0; i < accuracies.length; i++)
        {
            accuraciesList.add(Integer.valueOf(accuracies[i]));
        }

        int totalGoals = 0;

        while(!strengthsList.isEmpty() && !accuraciesList.isEmpty())
        {
            int strength = strengthsList.get(strengthsList.size() - 1);
            int accuracy = accuraciesList.get(0);

            int sum = strength + accuracy;
            if(sum == 100)
            {
                strengthsList.remove(strengthsList.size() - 1);
                accuraciesList.remove(0);
                ++totalGoals;
            }
            else if(sum < 100)
            {
                if(strength < accuracy)
                {
                    strengthsList.remove(strengthsList.size() - 1);
                }
                else if(strength > accuracy)
                {
                    accuraciesList.remove(0);
                }
                else
                {
                    strengthsList.remove(strengthsList.size() - 1);
                    strengthsList.add(sum);
                    accuraciesList.remove(0);
                }
            }
            else
            {
                strengthsList.remove(strengthsList.size() - 1);
                strengthsList.add(strength - 10);
                accuraciesList.add(accuracy);
                accuraciesList.remove(0);
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

        if(!strengthsList.isEmpty())
        {
            System.out.println("Strength values left: " + strengthsList.toString().replaceAll("\\[|\\]", ""));
        }

        if(!accuraciesList.isEmpty())
        {
            System.out.println("Accuracy values left: " + accuraciesList.toString().replaceAll("\\[|\\]", ""));
        }
    }
}
