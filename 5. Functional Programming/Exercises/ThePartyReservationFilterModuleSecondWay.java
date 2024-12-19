package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ThePartyReservationFilterModuleSecondWay
{
    private static Predicate<String> doesNameMatchFilter(String filterType, String filterParameter)
    {
        switch(filterType)
        {
            case "Starts with":
                return name -> name.startsWith(filterParameter);
            case "Ends with":
                return name -> name.endsWith(filterParameter);
            case "Length":
                return name -> name.length() == Integer.parseInt(filterParameter);
            case "Contains":
                return name -> name.contains(filterParameter);
            default:
                throw new IllegalArgumentException("Unknown filter type: " + filterType);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.asList(scanner.nextLine().split(" "));

        List<String[]> filters = new ArrayList<>();

        String command = scanner.nextLine();
        while(!command.equals("Print"))
        {
            String[] commandParts = command.split(";");
            String action = commandParts[0];
            String filterType = commandParts[1];
            String filterParameter = commandParts[2];

            switch(action)
            {
                case "Add filter":
                    filters.add(new String[]{filterType, filterParameter});
                    break;
                case "Remove filter":
                    filters.removeIf(filter -> filter[0].equals(filterType) && filter[1].equals(filterParameter));
                    break;
            }
            command = scanner.nextLine();
        }

        List<String> filteredInvitations = new ArrayList<>(invitations);

        for(String[] filter : filters)
        {
            String filterType = filter[0];
            String filterParameter = filter[1];

            filteredInvitations.removeIf(name -> doesNameMatchFilter(filterType, filterParameter).test(name));
        }

        System.out.println(String.join(" ", filteredInvitations));
    }
}
