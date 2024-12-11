package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class LegendaryFarming
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        HashMap<String, String> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", "Shadowmourne");
        legendaryItems.put("fragments", "Valanyr");
        legendaryItems.put("motes", "Dragonwrath");

        String obtainedLegendaryItem = null;

        while(obtainedLegendaryItem == null)
        {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for(int i = 0; i < input.length; i += 2)
            {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1];

                if(keyMaterials.containsKey(material))
                {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if(keyMaterials.get(material) >= 250)
                    {
                        obtainedLegendaryItem = legendaryItems.get(material);
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break;
                    }
                }
                else
                {
                    junkMaterials.put(material, junkMaterials.getOrDefault(material, 0) + quantity);
                }
            }
        }

        System.out.println(obtainedLegendaryItem + " obtained!");

        keyMaterials.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        for(Map.Entry<String, Integer> junkMaterialEntry : junkMaterials.entrySet())
        {
            System.out.println(junkMaterialEntry.getKey() + ": " + junkMaterialEntry.getValue());
        }
    }
}
