package IteratorsAndComparators.Lab.ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>
{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors)
    {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle()
    {
        return this.title;
    }

    private void setTitle(String title)
    {
        this.title = title;
    }

    public int getYear()
    {
        return this.year;
    }

    private void setYear(int year)
    {
        this.year = year;
    }

    public List<String> getAuthors()
    {
        return this.authors;
    }

    private void setAuthors(String... authors)
    {
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    @Override
    public int compareTo(Book otherBook)
    {
        int titleCompare = this.title.compareTo(otherBook.title);

        if(titleCompare != 0)
        {
            return titleCompare;
        }

        return this.year - otherBook.year;
    }

    @Override
    public String toString()
    {
        return String.format("Book => [Title: %s, Year: %s, Authors: %s]", this.title, this.year,
                String.join(", ", this.authors));
    }
}