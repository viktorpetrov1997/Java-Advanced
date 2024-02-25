package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> productShop = new TreeMap<>();

        String input = scanner.nextLine();
        while(!input.equals("Revision"))
        {
            String[] productShopInfo = input.split(", ");
            String shop = productShopInfo[0];
            String product = productShopInfo[1];
            double price = Double.parseDouble(productShopInfo[2]);
            LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();
            productPrice.put(product,price);

            if(productShop.containsKey(shop))
            {
                productShop.get(shop).put(product,price);
            }
            else
            {
                productShop.put(shop,productPrice);
            }

            input = scanner.nextLine();
        }

        for(Map.Entry<String, LinkedHashMap<String, Double>> shop : productShop.entrySet())
        {
            System.out.println(shop.getKey() + "->");
            for(Map.Entry<String, Double> productsAndPrices : shop.getValue().entrySet())
            {
                System.out.printf("Product: %s, Price: %.1f%n", productsAndPrices.getKey(), productsAndPrices.getValue());
            }
        }
    }
}
