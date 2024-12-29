package WorkshopBasicAlgorithms;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins
{
    public static Map<Integer, Integer> chooseCoins(List<Integer> coins, int targetSum)
    {
        Map<Integer, Integer> coinCount = new LinkedHashMap<>();
        int currentSum = 0;

        for(int coin : coins)
        {
            if(currentSum >= targetSum)
            {
                break;
            }

            int remainingSum = targetSum - currentSum;
            int count = remainingSum / coin;

            if(count > 0)
            {
                coinCount.put(coin, count);
                currentSum += count * coin;
            }
        }

        if(currentSum != targetSum)
        {
            throw new IllegalArgumentException("Error");
        }

        return coinCount;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> coins = Arrays.stream(scanner.nextLine().substring(7).split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(coins);

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        int totalCoins = usedCoins.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Number of coins to take: " + totalCoins);

        for(Map.Entry<Integer, Integer> entry : usedCoins.entrySet())
        {
            System.out.println(entry.getValue() + " coin(s) with value " + entry.getKey());
        }
    }
}