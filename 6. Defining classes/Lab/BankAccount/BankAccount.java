package DefiningClasses.Lab.BankAccount;

public class BankAccount
{
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 0;
    private int id;
    private double balance;

    public BankAccount()
    {
        ++bankAccountCount;
        this.id = bankAccountCount;
        this.balance = 0;
    }

    public static void setInterestRate(double interest)
    {
        interestRate = interest;
    }

    public double getInterest(int years)
    {
        return interestRate * this.balance * years;
    }

    public void deposit(double amount)
    {
        this.balance += amount;
    }

    public int getId()
    {
        return id;
    }
}
