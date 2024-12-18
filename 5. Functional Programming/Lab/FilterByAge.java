package FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> personInfo = new LinkedHashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfPeople; i++)
        {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            personInfo.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);

        personInfo.entrySet().stream().filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format)
    {
        switch(format)
        {
            case "name":
                return e -> System.out.println(e.getKey());
            case "age":
                return e -> System.out.println(e.getValue());
            case "name age":
            case "age name":
                return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
        throw new RuntimeException("Bad format!");
    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit)
    {
        if(condition.equals("older"))
        {
            return x -> x >= ageLimit;
        }
        else if(condition.equals("younger"))
        {
            return x -> x <= ageLimit;
        }
        throw new RuntimeException("Bad condition! Use 'older' or 'younger'");
    }
}