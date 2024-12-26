package IteratorsAndComparators.Exercises.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>
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

    public void printAll()
    {
        if(collection.isEmpty())
        {
            System.out.println();
            return;
        }

        for(int i = 0; i < collection.size(); i++)
        {
            System.out.print(collection.get(i));
            if(i < collection.size() - 1)
            {
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Iterator<String>()
        {
            private int currentIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currentIndex < collection.size();
            }

            @Override
            public String next()
            {
                if(!hasNext())
                {
                    throw new IllegalStateException("No more elements.");
                }
                return collection.get(currentIndex++);
            }
        };
    }
}
