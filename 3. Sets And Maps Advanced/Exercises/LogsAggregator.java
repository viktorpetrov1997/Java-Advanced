package SetsAndMapsAdvanced.Exercises;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> userDurations = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIps = new TreeMap<>();

        int numberOfLogs = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfLogs; i++)
        {
            String[] logs = scanner.nextLine().split(" ");
            String IP = logs[0];
            String user = logs[1];
            int duration = Integer.parseInt(logs[2]);

            userDurations.put(user, userDurations.getOrDefault(user, 0) + duration);

            userIps.putIfAbsent(user, new TreeSet<>());
            userIps.get(user).add(IP);
        }

        for(String user : userDurations.keySet())
        {
            int totalDuration = userDurations.get(user);
            TreeSet<String> ips = userIps.get(user);
            System.out.printf("%s: %d %s%n", user, totalDuration, ips);
        }
    }
}
