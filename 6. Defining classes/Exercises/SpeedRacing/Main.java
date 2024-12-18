package DefiningClasses.Exercises.SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfCars; i++)
        {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int fuelAmount = Integer.parseInt(carInfo[1]);
            double fuelCostForOneKilometer = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuelAmount, fuelCostForOneKilometer);
            carList.add(car);
        }

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] commandParts = input.split(" ");
            String model = commandParts[1];
            int distance = Integer.parseInt(commandParts[2]);

            for(int i = 0; i < carList.size(); i++)
            {
                if(carList.get(i).getModel().equals(model))
                {
                    if(!carList.get(i).canCarTravelThisDistance(distance))
                    {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            input = scanner.nextLine();
        }

        for(Car car : carList)
        {
            System.out.println(car);
        }
    }
}
