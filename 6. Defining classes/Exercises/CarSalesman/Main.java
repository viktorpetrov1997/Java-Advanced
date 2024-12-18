package DefiningClasses.Exercises.CarSalesman;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfEngines; i++)
        {
            String[] engineData = scanner.nextLine().split(" ");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficiency = null;

            if(engineData.length == 3)
            {
                if(Character.isDigit(engineData[2].charAt(0)))
                {
                    displacement = Integer.parseInt(engineData[2]);
                }
                else
                {
                    efficiency = engineData[2];
                }
            }
            else if(engineData.length == 4)
            {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.put(model, engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numberOfCars; i++)
        {
            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            Engine engine = engines.get(carData[1]);
            int weight = 0;
            String color = null;

            if(carData.length == 3)
            {
                if(Character.isDigit(carData[2].charAt(0)))
                {
                    weight = Integer.parseInt(carData[2]);
                }
                else
                {
                    color = carData[2];
                }
            }
            else if(carData.length == 4)
            {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            }

            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        for(Car car : cars)
        {
            System.out.println(car);
        }
    }
}
