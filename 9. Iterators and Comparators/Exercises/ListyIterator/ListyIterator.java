package IteratorsAndComparators.Exercises.ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator
{
    private List<String> collection;
    private int index;

    public ListyIterator(String... elements)
    {
        this.collection = new ArrayList<>();
        for(String element : elements)
        {
            this.collection.add(element);
        }
        this.index = 0;
    }

    public boolean move()
    {
        if(index + 1 < collection.size())
        {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext()
    {
        return index + 1 < collection.size();
    }

    public void print()
    {
        if(collection.isEmpty())
        {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(collection.get(index));
    }
}
