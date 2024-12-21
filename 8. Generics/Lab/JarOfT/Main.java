package Generics.Lab.JarOfT;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Jar<String> jar = new Jar<>();

        jar.add("tomatoes");
        jar.add("pickles");
        jar.add("mushrooms");
        jar.add("carrots");

        jar.remove();
    }
}
