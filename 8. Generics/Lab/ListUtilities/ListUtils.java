package Generics.Lab.ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils // This task must be submitted with a package called 'ListUtilities', not 'Generics.Lab.ListUtilities', or it will result in an error.
{
    public static <T extends Comparable<T>> T getMax(List<T> list)
    {
        if(list.isEmpty())
        {
            throw new IllegalArgumentException("List is empty!");
        }
        return Collections.max(list);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list)
    {
        if(list.isEmpty())
        {
            throw new IllegalArgumentException("List is empty!");
        }
        return Collections.min(list);
    }
}
