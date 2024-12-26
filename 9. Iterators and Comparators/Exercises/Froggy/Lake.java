package IteratorsAndComparators.Exercises.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>
{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers)
    {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Frog();
    }

    private class Frog implements Iterator<Integer>
    {
        private int index = 0;
        private boolean evenDone = false;

        @Override
        public boolean hasNext()
        {
            return index < numbers.size();
        }

        @Override
        public Integer next()
        {
            if(!evenDone)
            {
                if(index < numbers.size())
                {
                    int result = numbers.get(index);

                    index += 2;

                    if(index >= numbers.size())
                    {
                        evenDone = true;
                        index = 1;
                    }

                    return result;
                }
            }
            else
            {
                if(index < numbers.size())
                {
                    int result = numbers.get(index);
                    index += 2;
                    return result;
                }
            }
            throw new java.util.NoSuchElementException();
        }
    }
}
