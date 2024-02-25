package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> locations = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++)
        {
            String[] locationsInfo = scanner.nextLine().split(" ");
            String continent = locationsInfo[0];
            String country = locationsInfo[1];
            String city = locationsInfo[2];

            if(!locations.containsKey(continent))
            {
                LinkedHashMap<String, List<String>> countryAndCity = new LinkedHashMap<>();
                countryAndCity.putIfAbsent(country, new ArrayList<>());
                countryAndCity.get(country).add(city);
                locations.put(continent, countryAndCity);
            }
            else
            {
                if(!locations.get(continent).containsKey(country))
                {
                    locations.get(continent).put(country, new ArrayList<>());
                    locations.get(continent).get(country).add(city);
                }
                else
                {
                    locations.get(continent).get(country).add(city);
                }
            }
        }

        for(Map.Entry<String, LinkedHashMap<String, List<String>>> continent : locations.entrySet())
        {
            System.out.println(continent.getKey() + ":");
            for(Map.Entry<String, List<String>> country : continent.getValue().entrySet())
            {
                System.out.printf("  %s -> ",country.getKey());
                System.out.print(String.join(", ", country.getValue()));
                System.out.println();
            }
        }

    }
}
