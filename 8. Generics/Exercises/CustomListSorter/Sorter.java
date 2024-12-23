package Generics.Exercises.CustomListSorter;

import java.util.Collections;

public class Sorter
{
    public static <T extends Comparable<T>> void sort(CustomList<T> customList)
    {
        Collections.sort(customList.getList());
    }
}
