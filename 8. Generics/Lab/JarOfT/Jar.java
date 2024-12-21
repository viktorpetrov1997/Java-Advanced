package Generics.Lab.JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> // This task must be submitted with a package called 'JarOfT', not 'Generics.Lab.JarOfT', or it will result in an error.
{
    private Deque<T> content;

    public Jar()
    {
        this.content = new ArrayDeque<>();
    }

    public void add(T entity)
    {
        this.content.push(entity);
    }

    public T remove()
    {
        return this.content.pop();
    }
}
