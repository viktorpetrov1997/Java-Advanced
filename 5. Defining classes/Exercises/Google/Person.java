package DefiningClasses.Exercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person
{
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person()
    {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pokemons)
    {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }

    public List<Pokemon> getPokemons()
    {
        return this.pokemons;
    }

    public List<Parent> getParents()
    {
        return this.parents;
    }

    public List<Child> getChildren()
    {
        return this.children;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Company:").append("\n");
        if(this.company != null)
        {
            sb.append(this.company).append("\n");
        }

        sb.append("Car:").append("\n");
        if(this.car != null)
        {
            sb.append(this.car).append("\n");
        }

        sb.append("Pokemon:").append("\n");
        for(Pokemon pokemon : this.pokemons)
        {
            sb.append(pokemon).append("\n");
        }

        sb.append("Parents:").append("\n");
        for(Parent parent : this.parents)
        {
            sb.append(parent).append("\n");
        }

        sb.append("Children:").append("\n");
        for(Child child : this.children)
        {
            sb.append(child).append("\n");
        }

        return sb.toString();
    }
}
