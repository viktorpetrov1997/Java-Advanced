package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class HandsOfCards
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("JOKER"))
        {
            String[] parts = input.split(": ");
            String playerName = parts[0];
            String[] cards = parts[1].split(", ");

            playersCards.putIfAbsent(playerName, new HashSet<>());
            playersCards.get(playerName).addAll(Arrays.asList(cards));

            /*
            for(String card : cards)
            {
                playersCards.get(playerName).add(card);
            }
            */
        }

        for(Map.Entry<String, Set<String>> entry : playersCards.entrySet())
        {
            String playerName = entry.getKey();
            Set<String> cards = entry.getValue();

            int totalValue = calculateHandValue(cards);
            System.out.println(playerName + ": " + totalValue);
        }
    }

    private static int calculateHandValue(Set<String> cards)
    {
        Map<Character, Integer> powerValues = new HashMap<>();
        powerValues.put('2', 2);
        powerValues.put('3', 3);
        powerValues.put('4', 4);
        powerValues.put('5', 5);
        powerValues.put('6', 6);
        powerValues.put('7', 7);
        powerValues.put('8', 8);
        powerValues.put('9', 9);
        powerValues.put('1', 10);
        powerValues.put('J', 11);
        powerValues.put('Q', 12);
        powerValues.put('K', 13);
        powerValues.put('A', 14);

        Map<Character, Integer> typeMultipliers = new HashMap<>();
        typeMultipliers.put('S', 4);
        typeMultipliers.put('H', 3);
        typeMultipliers.put('D', 2);
        typeMultipliers.put('C', 1);

        int totalValue = 0;

        for(String card : cards)
        {
            char power = card.length() == 3 ? '1' : card.charAt(0);
            char type = card.charAt(card.length() - 1);

            int powerValue = powerValues.get(power);
            int typeMultiplier = typeMultipliers.get(type);

            totalValue += powerValue * typeMultiplier;
        }

        return totalValue;
    }
}
