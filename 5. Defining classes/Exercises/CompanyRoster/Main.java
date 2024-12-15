package DefiningClasses.Exercises.CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Department> departments = new HashMap<>();

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfEmployees; i++)
        {
            String[] employeeInfo = scanner.nextLine().split(" ");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];

            Employee employee = null;

            if(employeeInfo.length == 6)
            {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            else if(employeeInfo.length == 5)
            {
                String fourthParameter = employeeInfo[4];
                if(fourthParameter.contains("@"))
                {
                    String email = fourthParameter;
                    employee = new Employee(name, salary, position, department, email);
                }
                else
                {
                    int age = Integer.parseInt(fourthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            else if(employeeInfo.length == 4)
            {
                employee = new Employee(name, salary, position, department);
            }

            if(!departments.containsKey(department))
            {
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

        /*
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
        */ // Second way to print the employees sorted by salary in descending order
    }
}
