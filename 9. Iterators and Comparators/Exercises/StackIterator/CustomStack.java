package IteratorsAndComparators.Exercises.StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer>
{
    List<Integer> stack;

    public CustomStack()
    {
        this.stack = new ArrayList<>();
    }

    public void push(int element)
    {
        stack.add(element);
    }

    public int pop()
    {
        if(stack.isEmpty())
        {
            throw new IllegalStateException("No elements");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Integer>
    {
        private int currentIndex;

        public StackIterator()
        {
            this.currentIndex = stack.size() - 1;
        }

        @Override
        public boolean hasNext()
        {
            return this.currentIndex >= 0;
        }

        @Override
        public Integer next()
        {
            if(!hasNext())
            {
                throw new IllegalStateException("No more elements.");
            }
            return stack.get(this.currentIndex--);
        }
    }
}
