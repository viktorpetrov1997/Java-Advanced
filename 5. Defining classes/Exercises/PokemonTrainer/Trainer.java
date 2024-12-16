package DefiningClasses.Exercises.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer
{
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList)
    {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonList = pokemonList;
    }

    public int getNumberOfBadges()
    {
        return this.numberOfBadges;
    }

    public void executeCommand(String pokemonElement)
    {
        boolean elementExists = false;

        for(Pokemon pokemon : pokemonList)
        {
            if(pokemon.getElement().equals(pokemonElement))
            {
                this.numberOfBadges += 1;
                elementExists = true;
                break;
            }
        }

        if(!elementExists)
        {
            for(int i = 0; i < pokemonList.size(); i++)
            {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if(pokemonList.get(i).getHealth() <= 0)
                {
                    pokemonList.remove(i);
                    i--;
                }
            }

            /*
            List<Pokemon> pokemonsToRemove = new ArrayList<>();
            for(Pokemon pokemon : pokemonList)
            {
                pokemon.setHealth(pokemon.getHealth() - 10);
                if(pokemon.getHealth() <= 0)
                {
                    pokemonsToRemove.add(pokemon);
                }
            }
            pokemonList.removeAll(pokemonsToRemove);
            */ // Second way to decrease health of pokemons and remove some if necessary
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonList.size());
    }
}
