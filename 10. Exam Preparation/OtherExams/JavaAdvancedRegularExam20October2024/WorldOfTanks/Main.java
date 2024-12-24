package OtherExams.JavaAdvancedRegularExam20October2024.WorldOfTanks;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Terrain swamp = new Terrain("Swamp", 400);
        Terrain valley = new Terrain("Valley", 1400);
        Terrain gorge = new Terrain("Gorge", 800);
        Terrain desert = new Terrain("Desert", 200);

        Tank mark = new Tank("Mark", "V", 29000, 57, 12);
        Tank renault = new Tank("Renault", "FT", 6500, 37, 22);
        Tank m4 = new Tank("M4", "Sherman", 30300, 105, 177);
        Tank tiger = new Tank("Tiger", "I", 54000, 88, 120);
        Tank schneider = new Tank("Schneider", "CA", 13600, 75, 30);

        System.out.println(swamp.addTank(mark));

        System.out.println();

        System.out.println(swamp.addTank(renault));

        System.out.println();

        System.out.println(swamp.getTankByBrandAndModel("Renault", "FT"));

        System.out.println();

        System.out.println(swamp.addTank(m4));

        System.out.println();

        System.out.println(valley.addTank(renault));

        System.out.println();

        System.out.println(valley.addTank(tiger));

        System.out.println();

        System.out.println(valley.addTank(m4));

        System.out.println();

        System.out.println(valley.addTank(m4));

        System.out.println();

        System.out.println(valley.getCount());

        System.out.println();

        System.out.println(desert.addTank(schneider));

        System.out.println();

        System.out.println(desert.removeTank("Panzer", "IV"));

        System.out.println();

        System.out.println(desert.removeTank("Schneider", "CA"));

        System.out.println();

        System.out.println(valley.getTheMostArmoredTank());

        System.out.println();

        System.out.println(valley.getTanksByBarrelCaliberMoreThan(80));

        System.out.println();

        System.out.println(swamp.getStatistics());
        System.out.println(valley.getStatistics());
        System.out.println(gorge.getStatistics());
        System.out.println(desert.getStatistics());
    }
}
