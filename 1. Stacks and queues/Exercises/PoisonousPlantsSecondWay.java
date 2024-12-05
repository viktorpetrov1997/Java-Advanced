package StacksAndQueues.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlantsSecondWay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int totalDays = 0;

        while(true)
        {
            boolean anyDead = false;

            List<Integer> toRemove = new ArrayList<>();

            for(int i = 1; i < plants.size(); i++)
            {
                if(plants.get(i) > plants.get(i - 1))
                {
                    toRemove.add(plants.get(i));
                    anyDead = true;
                }
            }

            if(!anyDead)
            {
                break;
            }

            plants.removeAll(toRemove);
            totalDays++;
        }

        System.out.println(totalDays);
    }
}
