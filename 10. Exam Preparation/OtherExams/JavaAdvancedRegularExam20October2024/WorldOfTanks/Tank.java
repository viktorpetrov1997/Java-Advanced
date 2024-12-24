package OtherExams.JavaAdvancedRegularExam20October2024.WorldOfTanks;

public class Tank
{
    private String brand;
    private String model;
    private int weight;
    private int barrelCaliber;
    private int armor;

    public Tank(String brand, String model, int weight, int barrelCaliber, int armor)
    {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.barrelCaliber = barrelCaliber;
        this.armor = armor;
    }

    public String getBrand()
    {
        return this.brand;
    }

    public String getModel()
    {
        return this.model;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public int getBarrelCaliber()
    {
        return this.barrelCaliber;
    }

    public int getArmor()
    {
        return this.armor;
    }

    @Override
    public String toString()
    {
        return String.format("Brand: %s, Model: %s, Weight: %dkg, Barrel caliber: %dmm, Armor: %dmm", this.brand,
                this.model, this.weight, this.barrelCaliber, this.armor);
    }
}
