package DefiningClasses.Exercises.RawData;

public class Tire
{
    private double tirePressure;
    private int age;

    public Tire(double tirePressure, int age)
    {
        this.tirePressure = tirePressure;
        this.age = age;
    }

    public double getTirePressure()
    {
        return this.tirePressure;
    }
}

