package Generics.Exercises.CustomListIteratorSecondWay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T>
{
    private List<T> list;

    public CustomList()
    {
        this.list = new ArrayList<>();
    }

    public void add(T element)
    {
        this.list.add(element);
    }

    public T remove(int index)
    {
        return this.list.remove(index);
    }

    public boolean contains(T element)
    {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex)
    {
        T firstElement = this.list.get(firstIndex);
        T secondElement = this.list.get(secondIndex);

        this.list.set(secondIndex, firstElement);
        this.list.set(firstIndex, secondElement);
    }

    public int countGreaterThan(T element)
    {
        int countGreaterElements = 0;
        for(T currentElement : this.list)
        {
            if(currentElement.compareTo(element) > 0)
            {
                ++countGreaterElements;
            }
        }
        return countGreaterElements;
    }

    public T getMax()
    {
        return Collections.max(this.list);
    }

    public T getMin()
    {
        return Collections.min(this.list);
    }

    @Override
    public Iterator<T> iterator()
    {
        return this.list.iterator();
    }
}
