package SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Double> studentGrades = new LinkedHashMap<>();

        for(int i = 0; i < numberOfStudents; i++)
        {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble).collect(Collectors.toList());

            double average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            studentGrades.put(studentName,average);
        }

        for (Map.Entry<String, Double> entry : studentGrades.entrySet())
        {
            System.out.printf("%s is graduated with %f\n", entry.getKey(), entry.getValue());
        }
    }
}
