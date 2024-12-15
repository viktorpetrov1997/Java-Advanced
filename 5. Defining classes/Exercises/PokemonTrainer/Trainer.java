package DefiningClasses.Exercises.PokemonTrainer;

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
        for(Pokemon pokemon : pokemonList)
        {
            if(pokemon.getElement().equals(pokemonElement))
            {
                this.numberOfBadges += 1;
            }
            else if(pokemon.getHealth() <= 0)
            {
                pokemonList.remove(pokemon);
            }
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonList.size());
    }
}
