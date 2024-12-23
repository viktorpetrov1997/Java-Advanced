package Generics.Exercises.Tuple;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String fullName = firstInput[0] + " " + firstInput[1];
        String city = firstInput[2];

        Tuple<String, String> tuple1 = new Tuple<>(fullName, city);

        String[] secondInput = scanner.nextLine().split(" ");
        String name = secondInput[0];
        int litersOfBeer = Integer.parseInt(secondInput[1]);

        Tuple<String, Integer> tuple2 = new Tuple<>(name, litersOfBeer);

        String[] thirdInput = scanner.nextLine().split(" ");
        int integer = Integer.parseInt(thirdInput[0]);
        double doubleValue = Double.parseDouble(thirdInput[1]);

        Tuple<Integer, Double> tuple3 = new Tuple<>(integer, doubleValue);

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
