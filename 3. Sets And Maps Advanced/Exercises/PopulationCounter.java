package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> countryData = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("report"))
        {
            String[] countryDataParts = input.split("\\|");

            String city = countryDataParts[0];
            String country = countryDataParts[1];
            int cityPopulation = Integer.parseInt(countryDataParts[2]);

            countryData.putIfAbsent(country, new LinkedHashMap<>());
            countryData.get(country).put(city, cityPopulation);

            input = scanner.nextLine();
        }

        countryData.entrySet().stream().sorted((entry1, entry2) ->
        {
            int totalPopulation1 = entry1.getValue().values().stream().mapToInt(Integer::intValue).sum();
            int totalPopulation2 = entry2.getValue().values().stream().mapToInt(Integer::intValue).sum();
            return Integer.compare(totalPopulation2, totalPopulation1);
        }).forEach(countryEntry ->
        {
            String county = countryEntry.getKey();
            LinkedHashMap<String, Integer> cities = countryEntry.getValue();

            int totalPopulation = cities.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println(county + " (total population: " + totalPopulation + ")");

            cities.entrySet().stream().sorted((city1, city2) -> Integer.compare(city2.getValue(), city1.getValue()))
                    .forEach(cityEntry ->
                    {
                        System.out.println("=>" + cityEntry.getKey() + ": " + cityEntry.getValue());
                    });
        });
    }
}
