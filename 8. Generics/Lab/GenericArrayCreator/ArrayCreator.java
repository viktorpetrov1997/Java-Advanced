package Generics.Lab.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator // This task must be contained in a package called 'ArrayCreator', not 'GenericArrayCreator', and submitted with a package called 'ArrayCreator', not 'Generics.Lab.GenericArrayCreator', or it will result in an error.
{
    public static <T> T[] create(int length, T item)
    {
        T[] array = (T[]) new Object[length];
        for(int i = 0; i < length; i++)
        {
            array[i] = item;
        }
        return array;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item)
    {
        T[] array = (T[]) Array.newInstance(tClass, length);
        for(int i = 0; i < array.length; i++)
        {
            array[i] = item;
        }
        return array;
    }
}
