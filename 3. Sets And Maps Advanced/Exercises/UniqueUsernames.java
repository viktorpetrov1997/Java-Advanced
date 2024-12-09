package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int numberOfUsernames = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfUsernames; i++)
        {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        for(String username : usernames)
        {
            System.out.println(username);
        }
    }
}
