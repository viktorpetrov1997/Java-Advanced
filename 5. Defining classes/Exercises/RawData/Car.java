package DefiningClasses.Exercises.RawData;

import java.util.List;

public class Car
{
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires)
    {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public void extract(String cargoType)
    {
        if(cargoType.equals("fragile"))
        {
            for(Tire tire : tires)
            {
                double tirePressure = tire.getTirePressure();
                if(tirePressure < 1)
                {
                    System.out.println(this.model);
                    break;
                }
            }
        }
        else if(cargoType.equals("flamable"))
        {
            if(this.engine.getEnginePower() > 250)
            {
                System.out.println(this.model);
            }
        }
    }
}
