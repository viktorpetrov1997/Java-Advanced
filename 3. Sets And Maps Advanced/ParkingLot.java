package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] reminder = input.split(", ");
            if(reminder[0].equals("IN"))
            {
                parkingLot.add(reminder[1]);
            }
            else
            {
                parkingLot.remove(reminder[1]);
            }
            input = scanner.nextLine();
        }

        if(parkingLot.isEmpty())
        {
            System.out.println("Parking Lot is Empty");
        }
        else
        {
            for (String vehicle : parkingLot)
            {
                System.out.println(vehicle);
            }
        }
    }
}
