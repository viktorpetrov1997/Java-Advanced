package Generics.Exercises.GenericCountMethodString;

class Box<T extends Comparable<T>> implements Comparable<Box<T>>
{
    private T value;

    public Box(T value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return this.value.getClass().getName() + ": " + this.value;
    }

    @Override
    public int compareTo(Box<T> other)
    {
        return this.value.compareTo(other.value);
    }
}
