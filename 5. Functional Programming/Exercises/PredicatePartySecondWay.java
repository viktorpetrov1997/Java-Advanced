package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicatePartySecondWay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while(!input.equals("Party!"))
        {
            String criteria = input.split(" ")[2];

            ArrayList<String> toRemove = new ArrayList<>();
            ArrayList<String> toAdd = new ArrayList<>();

            if(input.contains("Length"))
            {
                int length = Integer.parseInt(criteria);
                for(String guest : guestList)
                {
                    if(guest.length() == length)
                    {
                        if(input.contains("Remove"))
                        {
                            toRemove.add(guest);
                        }
                        else
                        {
                            toAdd.add(guest);
                        }
                    }
                }
            }
            else if(input.contains("StartsWith"))
            {
                for(String guest : guestList)
                {
                    if(guest.startsWith(criteria))
                    {
                        if(input.contains("Remove"))
                        {
                            toRemove.add(guest);
                        }
                        else
                        {
                            toAdd.add(guest);
                        }
                    }
                }
            }
            else if(input.contains("EndsWith"))
            {
                for(String guest : guestList)
                {
                    if(guest.endsWith(criteria))
                    {
                        if(input.contains("Remove"))
                        {
                            toRemove.add(guest);
                        }
                        else
                        {
                            toAdd.add(guest);
                        }
                    }
                }
            }

            if(input.contains("Remove"))
            {
                guestList.removeAll(toRemove);
            }
            else
            {
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
            System.out.println(guestList.stream().sorted().collect(Collectors.toList()).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
