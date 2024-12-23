package Generics.Exercises.Threeuple;

public class Threeuple<T, U, V>
{
    private T item1;
    private U item2;
    private V item3;

    public Threeuple(T item1, U item2, V item3)
    {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1()
    {
        return this.item1;
    }

    public U getItem2()
    {
        return this.item2;
    }

    public V getItem3()
    {
        return this.item3;
    }

    public void setItem1(T item1)
    {
        this.item1 = item1;
    }

    public void setItem2(U item2)
    {
        this.item2 = item2;
    }

    public void setItem3(V item3)
    {
        this.item3 = item3;
    }

    @Override
    public String toString()
    {
        return this.item1 + " -> " + this.item2 + " -> " + this.item3;
    }
}
