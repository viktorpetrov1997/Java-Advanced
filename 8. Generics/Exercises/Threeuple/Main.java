package Generics.Exercises.Threeuple;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String fullName = firstInput[0] + " " + firstInput[1];
        String address = firstInput[2];
        String city = firstInput[3];

        Threeuple<String, String, String> tuple1 = new Threeuple<>(fullName, address, city);

        String[] secondInput = scanner.nextLine().split(" ");
        String name = secondInput[0];
        int litersOfBeer = Integer.parseInt(secondInput[1]);
        boolean drunkOrNot = secondInput[2].equals("drunk");

        Threeuple<String, Integer, Boolean> tuple2 = new Threeuple<>(name, litersOfBeer, drunkOrNot);

        String[] thirdInput = scanner.nextLine().split(" ");
        String personName = thirdInput[0];
        double accountBalance = Double.parseDouble(thirdInput[1]);
        String bankName = thirdInput[2];

        Threeuple<String, Double, String> tuple3 = new Threeuple<>(personName, accountBalance, bankName);

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
