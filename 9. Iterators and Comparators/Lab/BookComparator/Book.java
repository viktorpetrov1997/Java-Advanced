package IteratorsAndComparators.Lab.BookComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book
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
}