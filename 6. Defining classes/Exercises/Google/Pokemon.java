package DefiningClasses.Exercises.Google;

public class Pokemon
{
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType)
    {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString()
    {
        return this.pokemonName + " " + this.pokemonType;
    }
}