package DefiningClasses.Exercises.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person
{
    private String name;
    private String birthday;
    private List<Person> parentsList;
    private List<Person> childrenList;

    public Person(String name, String birthday)
    {
        this.name = name;
        this.birthday = birthday;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public String getBirthday()
    {
        return this.birthday;
    }

    public void addParent(Person person)
    {
        if(!this.parentsList.contains(person))
        {
            this.parentsList.add(person);
        }
    }

    public void addChild(Person person)
    {
        if(!this.childrenList.contains(person))
        {
            this.childrenList.add(person);
        }
    }

    public String getOutputForList(List<Person> list)
    {
        StringBuilder output = new StringBuilder();
        if(!list.isEmpty())
        {
            for(Person p : list)
            {
                output.append(String.format("%s %s%n", p.getName(), p.getBirthday()));
            }
        }
        return output.toString();
    }

    @Override
    public String toString()
    {
        return String.format("%s %s%nParents:%n%sChildren:%n%s", this.name, String.join("/", this.birthday), getOutputForList(this.parentsList), getOutputForList(this.childrenList));
    }
}
