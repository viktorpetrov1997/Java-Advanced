package IteratorsAndComparators.Lab.BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>
{
    @Override
    public int compare(Book firstBook, Book secondBook)
    {
        int titleCompare = firstBook.getTitle().compareTo(secondBook.getTitle());

        if(titleCompare != 0)
        {
            return titleCompare;
        }

        return firstBook.getYear() - secondBook.getYear();
    }
}
