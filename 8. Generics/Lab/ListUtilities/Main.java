package Generics.Lab.ListUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 4, 13, 14, 12, -10);

        System.out.println("Integers:");
        System.out.println("Max: " + ListUtils.getMax(integers));
        System.out.println("Min: " + ListUtils.getMin(integers));

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        System.out.println();

        System.out.println("Strings:");
        System.out.println("Max: " + ListUtils.getMax(strings));
        System.out.println("Min: " + ListUtils.getMin(strings));
    }
}
