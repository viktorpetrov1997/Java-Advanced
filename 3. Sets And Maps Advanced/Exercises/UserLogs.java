package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class UserLogs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        String input = scanner.nextLine();
        while(!input.equals("end"))
        {
            String[] parts = input.split(" ");
            String ipAddress = parts[0].substring(3);
            String user = parts[2].substring(5);

            userLogs.putIfAbsent(user, new LinkedHashMap<>());
            LinkedHashMap<String, Integer> countIPs = userLogs.get(user);
            countIPs.put(ipAddress, countIPs.getOrDefault(ipAddress, 0) + 1);

            input = scanner.nextLine();
        }

        for(Map.Entry<String, LinkedHashMap<String, Integer>> userEntry : userLogs.entrySet())
        {
            System.out.println(userEntry.getKey() + ":");

            LinkedHashMap<String, Integer> countIPs = userEntry.getValue();
            List<String> logEntries = new ArrayList<>();

            for(Map.Entry<String, Integer> ipEntry : countIPs.entrySet())
            {
                logEntries.add(ipEntry.getKey() + " => " + ipEntry.getValue());
            }

            System.out.println(String.join(", ", logEntries) + ".");
        }
    }
}
