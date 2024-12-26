package IteratorsAndComparators.Lab.BookComparator;

import java.util.ArrayList;
import java.util.List;

public class Main // This task must be submitted with a package called 'BookComparator'.
{
    public static void main(String[] args)
    {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator());

        for(Book book : books)
        {
            System.out.println("Title: " + book.getTitle() + ", Year: " + book.getYear());
        }
    }
}
