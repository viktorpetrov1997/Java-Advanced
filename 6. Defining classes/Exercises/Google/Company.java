package DefiningClasses.Exercises.Google;

public class Company
{
    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName, String department, double salary)
    {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return this.companyName + " " + this.department + " " + String.format("%.2f", this.salary);
    }
}
