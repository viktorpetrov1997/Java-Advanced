package DefiningClasses.Exercises.SpeedRacing;

public class Car
{
    private String model;
    private double fuelAmount;
    private double fuelCostForOneKilometer;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostForOneKilometer)
    {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
        this.distanceTraveled = 0;
    }

    public String getModel()
    {
        return this.model;
    }

    public boolean canCarTravelThisDistance(int distance)
    {
        double neededFuel = distance * this.fuelCostForOneKilometer;
        if(neededFuel <= this.fuelAmount)
        {
            this.fuelAmount -= neededFuel;
            this.distanceTraveled += distance;
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
