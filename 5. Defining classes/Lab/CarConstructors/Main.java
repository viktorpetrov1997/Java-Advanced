package DefiningClasses.Lab.CarConstructors;

import java.util.ArrayList;
import java.util.List;
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
            String[] carDetails = scanner.nextLine().split(" ");
            String brand = carDetails[0];
            String model = carDetails.length > 1 ? carDetails[1] : "unknown";
            int horsePower = carDetails.length > 2 ? Integer.parseInt(carDetails[2]) : -1;

            Car car = new Car(brand, model, horsePower);

            carList.add(car);
        }

        for(Car car : carList)
        {
            System.out.println(car);
        }
    }
}
