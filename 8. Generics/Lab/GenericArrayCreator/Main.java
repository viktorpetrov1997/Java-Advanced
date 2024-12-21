package Generics.Lab.GenericArrayCreator;

public class Main
{
    public static void main(String[] args)
    {
        String[] strings = ArrayCreator.create(String.class, 10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);

        for(String string : strings)
        {
            System.out.print(string + " ");
        }

        System.out.println();

        for(Integer integer : integers)
        {
            System.out.print(integer + " ");
        }
    }
}
