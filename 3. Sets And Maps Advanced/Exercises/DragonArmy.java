package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String,int[]>> dragonArmy = new LinkedHashMap<>();

        for(int i = 0; i < N; i++)
        {
            String[] dragonInfo = scanner.nextLine().split(" ");
            String type = dragonInfo[0];
            String name = dragonInfo[1];
            int damage = dragonInfo[2].equals("null") ? 45 : Integer.parseInt(dragonInfo[2]);
            int health = dragonInfo[3].equals("null") ? 250 : Integer.parseInt(dragonInfo[3]);
            int armor = dragonInfo[4].equals("null") ? 10 : Integer.parseInt(dragonInfo[4]);

            dragonArmy.putIfAbsent(type, new TreeMap<>());
            dragonArmy.get(type).put(name, new int[] {damage, health, armor});
        }

        for(Map.Entry<String, TreeMap<String, int[]>> entry : dragonArmy.entrySet())
        {
            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;

            for(int[] stats : entry.getValue().values())
            {
                totalDamage += stats[0];
                totalHealth += stats[1];
                totalArmor += stats[2];
            }

            int count = dragonArmy.get(entry.getKey()).size();
            double avgDamage = totalDamage / count;
            double avgHealth = totalHealth / count;
            double avgArmor = totalArmor / count;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), avgDamage, avgHealth, avgArmor);

            for(Map.Entry<String, int[]> dragonEntry : entry.getValue().entrySet())
            {
                String name = dragonEntry.getKey();
                int[] stats = dragonEntry.getValue();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name, stats[0], stats[1], stats[2]);
            }
        }
    }
}
