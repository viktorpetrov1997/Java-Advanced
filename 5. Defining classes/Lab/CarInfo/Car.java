package DefiningClasses.Lab.CarInfo;

public class Car
{
    private String brand;
    private String model;
    private int horsePower;

    public String getBrand()
    {
        return this.brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return this.model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getHorsePower()
    {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower)
    {
        this.horsePower = horsePower;
    }

    public String carInfo()
    {
        return "The car is: " + this.brand + " " + this.model + " - " + this.horsePower + " HP.";
    }
}
