package IteratorsAndComparators.Lab.ComparableBook;

public class Main // This task must be submitted with a package called 'ComparableBook'.
{
    public static void main(String[] args)
    {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        if(bookOne.compareTo(bookTwo) > 0)
        {
            System.out.println(String.format("%s is before %s", bookTwo, bookOne));
        }
        else if(bookOne.compareTo(bookTwo) < 0)
        {
            System.out.println(String.format("%s is before %s", bookOne, bookTwo));
        }
        else
        {
            System.out.println("Books are equal.");
        }
    }
}
