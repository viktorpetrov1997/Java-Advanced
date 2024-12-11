package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venueData = new LinkedHashMap<>();

        String regex = "^([a-zA-Z]+(?: [a-zA-Z]+){0,2}) @([a-zA-Z]+(?: [a-zA-Z]+){0,2}) (\\d+) (\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            Matcher matcher = pattern.matcher(input);
            if(!matcher.matches())
            {
                input = scanner.nextLine();
                continue;
            }

            String singer = matcher.group(1);
            String venue = matcher.group(2);
            int ticketsPrice = Integer.parseInt(matcher.group(3));
            int ticketsCount = Integer.parseInt(matcher.group(4));

            int totalMoney = ticketsPrice * ticketsCount;

            venueData.putIfAbsent(venue, new LinkedHashMap<>());
            LinkedHashMap<String, Integer> singers = venueData.get(venue);
            singers.put(singer, singers.getOrDefault(singer, 0) + totalMoney);

            input = scanner.nextLine();
        }

        for(Map.Entry<String, LinkedHashMap<String, Integer>> venueEntry : venueData.entrySet())
        {
            String venue = venueEntry.getKey();
            System.out.println(venue);

            venueEntry.getValue().entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(singerEntry ->
                    {
                        System.out.printf("# %s -> %d%n", singerEntry.getKey(), singerEntry.getValue());
                    });
        }
    }
}
