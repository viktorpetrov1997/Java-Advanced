package Generics.Lab.GenericScale;

public class Scale<T extends Comparable<T>> // This task must be submitted with a package called 'GenericScale', not 'Generics.Lab.GenericScale', or it will result in an error.
{
    private T left;
    private T right;

    public Scale(T left, T right)
    {
        this.left = left;
        this.right = right;
    }

    public T getHeavier()
    {
        if(this.left.compareTo(this.right) > 0)
        {
            return this.left;
        }

        if(this.left.compareTo(this.right) < 0)
        {
            return this.right;
        }
        return null;
    }
}
