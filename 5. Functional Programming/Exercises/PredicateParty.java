package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while(!input.equals("Party!"))
        {
            Predicate<String> predicate = null;

            String criteria = input.split(" ")[2];

            if(input.contains("Length"))
            {
                predicate = x -> x.length() == Integer.parseInt(criteria);
            }
            else if(input.contains("StartsWith"))
            {
                predicate = x -> x.startsWith(criteria);
            }
            else
            {
                predicate = x -> x.endsWith(criteria);
            }

            if(input.contains("Remove"))
            {
                ArrayList<String> toRemove = new ArrayList<>();
                for(String guest : guestList)
                {
                    if(predicate.test(guest))
                    {
                        toRemove.add(guest);
                    }
                }
                guestList.removeAll(toRemove);
            }
            else
            {
                ArrayList<String> toAdd = new ArrayList<>();
                for(String guest : guestList)
                {
                    if(predicate.test(guest))
                    {
                        toAdd.add(guest);
                    }
                }
                guestList.addAll(toAdd);
            }
            input = scanner.nextLine();
        }

        if(guestList.isEmpty())
        {
            System.out.println("Nobody is going to the party!");
        }
        else
        {
            System.out.println(guestList.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
