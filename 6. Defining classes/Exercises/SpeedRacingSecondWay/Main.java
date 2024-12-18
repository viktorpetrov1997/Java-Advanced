package DefiningClasses.Exercises.SpeedRacingSecondWay;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfCars; i++)
        {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int fuelAmount = Integer.parseInt(carInfo[1]);
            double fuelCostForOneKilometer = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuelAmount, fuelCostForOneKilometer);
            cars.put(model, car);
        }

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] commandParts = input.split(" ");
            String model = commandParts[1];
            int distance = Integer.parseInt(commandParts[2]);

            Car car = cars.get(model);

            if(!car.canCarTravelThisDistance(distance))
            {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }

        for(Car car : cars.values())
        {
            System.out.println(car);
        }
    }
}
