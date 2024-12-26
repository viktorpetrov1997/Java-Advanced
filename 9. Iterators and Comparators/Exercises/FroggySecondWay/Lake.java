package IteratorsAndComparators.Exercises.FroggySecondWay;

import java.util.ArrayList;
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
        private boolean isEvenPhase = true;
        private List<Integer> evenIndexes = new ArrayList<>();
        private List<Integer> oddIndexes = new ArrayList<>();

        public Frog()
        {
            for(int i = 0; i < numbers.size(); i++)
            {
                if(i % 2 == 0)
                {
                    evenIndexes.add(i);
                }
                else
                {
                    oddIndexes.add(i);
                }
            }
        }

        @Override
        public boolean hasNext()
        {
            return index < (isEvenPhase ? evenIndexes.size() : oddIndexes.size());
        }

        @Override
        public Integer next()
        {
            int result = isEvenPhase ? numbers.get(evenIndexes.get(index)) : numbers.get(oddIndexes.get(index));
            ++index;
            if(isEvenPhase && index >= evenIndexes.size())
            {
                isEvenPhase = false;
                index = 0;
            }
            return result;
        }
    }
}
