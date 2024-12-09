package SetsAndMapsAdvanced.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FixEmails
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> personAndEmail = new TreeMap<>();

        while(true)
        {
            String name = scanner.nextLine();
            if(name.equalsIgnoreCase("stop"))
            {
                break;
            }

            String email = scanner.nextLine();
            personAndEmail.put(name, email);
        }

        for(Map.Entry<String, String> entry : personAndEmail.entrySet())
        {
            String name = entry.getKey();
            String email = entry.getValue();

            if(!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com"))
            {
                System.out.println(name + " -> " + email);
            }
        }

        /*
        personAndEmail.entrySet().stream()
                .filter(entry ->
                {
                    String email = entry.getValue().toLowerCase();
                    return !(email.endsWith(".us") || email.endsWith(".uk") || email.endsWith(".com"));
                }).forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
         */
    }
}
