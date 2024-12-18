package DefiningClasses.Lab.CarInfo;

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
            String model = carDetails[1];
            int horsePower = Integer.parseInt(carDetails[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carList.add(car);
        }

        for(Car car : carList)
        {
            System.out.println(car.carInfo());
        }
    }
}
