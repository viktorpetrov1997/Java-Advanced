package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentGrades = new TreeMap<>();

        for(int i = 0; i < numberOfStudents; i++)
        {
            String[] studentInfo = scanner.nextLine().split(" ");

            String name = studentInfo[0];
            double grade = Double.parseDouble(studentInfo[1]);

            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);
        }

        for(Map.Entry<String, List<Double>> name : studentGrades.entrySet())
        {
            System.out.print(name.getKey() + " -> ");

            double average = 0;
            for(Double grade : name.getValue())
            {
                System.out.printf("%.2f ", grade);
                average += grade;
            }

            // double average = name.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.printf("(avg: %.2f)", average / name.getValue().size());
            System.out.println();
        }
    }
}
