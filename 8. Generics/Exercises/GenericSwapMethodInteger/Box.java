package Generics.Exercises.GenericSwapMethodInteger;

public class Box<T>
{
    private T value;

    public Box(T value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value.getClass().getName() + ": " + this.value;
    }
}
