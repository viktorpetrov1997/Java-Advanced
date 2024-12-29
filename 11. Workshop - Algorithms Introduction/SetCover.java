package WorkshopBasicAlgorithms;

import java.util.*;
import java.util.stream.Collectors;

public class SetCover
{
    public static List<List<Integer>> findSmallestSubset(List<Integer> universe, List<List<Integer>> sets)
    {
        List<Integer> uncoveredElements = new ArrayList<>(universe);
        List<List<Integer>> selectedSets = new ArrayList<>();

        while(!uncoveredElements.isEmpty())
        {
            List<Integer> bestSet = null;
            int maxMatchingElements = 0;

            for(List<Integer> set : sets)
            {
                int numberOfMatchingElements = countCoveredElements(set, uncoveredElements);
                if(numberOfMatchingElements > maxMatchingElements)
                {
                    maxMatchingElements = numberOfMatchingElements;
                    bestSet = set;
                }
            }

            selectedSets.add(bestSet);

            uncoveredElements.removeAll(bestSet);
        }

        return selectedSets;
    }

    public static int countCoveredElements(List<Integer> set, List<Integer> uncoveredElements)
    {
        int count = 0;
        for(Integer element : set)
        {
            if(uncoveredElements.contains(element))
            {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> universe = Arrays.stream(scanner.nextLine().substring(10).split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int numberOfSets = Integer.parseInt(scanner.nextLine().substring(16));

        List<List<Integer>> sets = new ArrayList<>();

        for(int i = 0; i < numberOfSets; i++)
        {
            List<Integer> set = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                    .collect(Collectors.toList());
            sets.add(set);
        }

        List<List<Integer>> result = findSmallestSubset(universe, sets);

        System.out.println("Sets to take (" + result.size() + "):");
        for(List<Integer> set : result)
        {
            System.out.print("{ ");
            for(int i = 0; i < set.size(); i++)
            {
                System.out.print(set.get(i));
                if(i < set.size() - 1)
                {
                    System.out.print(" ");
                }
            }
            System.out.println(" }");
        }
    }
}
