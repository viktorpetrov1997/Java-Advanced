package DefiningClasses.Exercises.RawData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<Car>> carsByCargoType = new HashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfCars; i++)
        {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);

            List<Tire> tireList = new ArrayList<>();
            for(int tireItems = 5; tireItems <= 12; tireItems += 2)
            {
                double currentTirePressure = Double.parseDouble(carInfo[tireItems]);
                int currentTireAge = Integer.parseInt(carInfo[tireItems + 1]);
                Tire currentTire = new Tire(currentTirePressure, currentTireAge);
                tireList.add(currentTire);
            }

            Car car = new Car(model, engine, cargo, tireList);
            carsByCargoType.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargoType.get(cargoType).add(car);
        }

        String cargoType = scanner.nextLine();

        carsByCargoType.get(cargoType).forEach(car -> car.extract(cargoType));
    }
}
