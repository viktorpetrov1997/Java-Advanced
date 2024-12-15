package DefiningClasses.Exercises.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Pokemon>> trainersAndTheirPokemons = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("Tournament"))
        {
            String[] data = input.split(" ");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainersAndTheirPokemons.putIfAbsent(trainerName, new ArrayList<>());
            trainersAndTheirPokemons.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainerList = trainersAndTheirPokemons.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String pokemonElement = input;

            for(Trainer trainer : trainerList)
            {
                trainer.executeCommand(pokemonElement);
            }

            input = scanner.nextLine();
        }

        trainerList.stream().sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }
}
