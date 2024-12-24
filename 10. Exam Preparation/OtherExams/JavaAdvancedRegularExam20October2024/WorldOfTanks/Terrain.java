package OtherExams.JavaAdvancedRegularExam20October2024.WorldOfTanks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Terrain
{
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area)
    {
        this.type = type;
        this.tanks = new ArrayList<>();
        this.area = area;
    }

    public String addTank(Tank tank)
    {
        for(Tank currentTank : this.tanks)
        {
            if(currentTank.getBrand().equals(tank.getBrand()) && currentTank.getModel().equals(tank.getModel()))
            {
                return "Tank with this brand and model already exists!";
            }
        }

        if(this.type.equals("Swamp") && tank.getWeight() > 14000)
        {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }

        this.tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public boolean removeTank(String brand, String model)
    {
        Tank tank = this.getTankByBrandAndModel(brand, model);

        if(tank == null)
        {
            return false;
        }

        this.tanks.remove(tank);

        return true;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber)
    {
        List<String> tanksWithBarrelCaliberMoreThanTheGivenOne = this.tanks.stream()
                .filter(tank -> tank.getBarrelCaliber() > barrelCaliber)
                .map(Tank::getBrand).collect(Collectors.toList());

        if(tanksWithBarrelCaliberMoreThanTheGivenOne.isEmpty())
        {
            return "There are no tanks with the specified caliber.";
        }

        return "Tanks with caliber more than " + barrelCaliber + "mm: " + String.join(", ", tanksWithBarrelCaliberMoreThanTheGivenOne);
    }

    public Tank getTankByBrandAndModel(String brand, String model)
    {
        return this.tanks.stream()
                .filter(tank -> tank.getBrand().equals(brand) && tank.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public String getTheMostArmoredTank()
    {
        Tank mostArmoredTank = this.tanks.stream()
                .max((tank1, tank2) -> Integer.compare(tank1.getArmor(), tank2.getArmor())).orElse(null);

        assert mostArmoredTank != null;

        return String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                mostArmoredTank.getBrand(), mostArmoredTank.getModel(), mostArmoredTank.getArmor());
    }

    public int getCount()
    {
        return this.tanks.size();
    }

    public String getStatistics()
    {
        if(this.tanks.isEmpty())
        {
            return String.format("There are no tanks in the %s.", this.type.toLowerCase());
        }

        StringBuilder printTanks = new StringBuilder(String.format("Tanks located in the %s:", this.type.toLowerCase()));

        for(Tank tank : this.tanks)
        {
            printTanks.append("\n");
            printTanks.append("-- ").append(tank.getBrand()).append(" ").append(tank.getModel());
            // WRONG! -> printTanks.append("-- ").append(tank.getBrand()).append(" ").append(tank.getModel()).append("\n");
            // There shouldn't be a new line printed after printing of the tanks has finished.
            // That's why I'm adding the new line before printing each tank.
            // This way after printing the last tank a new line will not be added at the end.
        }

        return printTanks.toString();
    }
}
