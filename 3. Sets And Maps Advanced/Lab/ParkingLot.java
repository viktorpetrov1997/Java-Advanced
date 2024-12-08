package SetsAndMapsAdvanced.Lab;

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
            String[] commandParts = input.split(", ");
            if(commandParts[0].equals("IN"))
            {
                parkingLot.add(commandParts[1]);
            }
            else
            {
                parkingLot.remove(commandParts[1]);
            }
            input = scanner.nextLine();
        }

        if(parkingLot.isEmpty())
        {
            System.out.println("Parking Lot is Empty");
        }
        else
        {
            for(String carNumber : parkingLot)
            {
                System.out.println(carNumber);
            }
        }
    }
}
