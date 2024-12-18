package DefiningClasses.Exercises.CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Cat> catsInfo = new HashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] catInfo = input.split(" ");
            String breed = catInfo[0];
            String catName = catInfo[1];

            Cat cat = null;

            switch(breed)
            {
                case "Siamese":
                    cat = new Siamese(catName, Double.parseDouble(catInfo[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(catName, Double.parseDouble(catInfo[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(catName, Double.parseDouble(catInfo[2]));
                    break;
            }

            catsInfo.put(catName, cat);
            input = scanner.nextLine();
        }

        String catName = scanner.nextLine();
        if(catsInfo.containsKey(catName))
        {
            System.out.println(catsInfo.get(catName));
        }
    }
}
