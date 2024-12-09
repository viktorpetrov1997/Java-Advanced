package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class Phonebook
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

        String input = scanner.nextLine();
        while(!input.equals("search"))
        {
            String[] nameAndPhone = input.split("-");

            String name = nameAndPhone[0];
            String phone = nameAndPhone[1];

            phonebook.put(name, phone);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while(!input.equals("stop"))
        {
            String name = input;
            if(phonebook.containsKey(name))
            {
                System.out.println(name + " -> " + phonebook.get(name));
            }
            else
            {
                System.out.printf("Contact %s does not exist.\n", name);
            }
            input = scanner.nextLine();
        }
    }
}
