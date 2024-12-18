package DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] commandParts = input.split(" ");

            String command = commandParts[0];
            switch(command.toLowerCase())
            {
                case "create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.printf("Account ID%d created%n", account.getId());
                    break;
                case "deposit":
                    int depositId = Integer.parseInt(commandParts[1]);
                    int amount = Integer.parseInt(commandParts[2]);
                    if(accounts.containsKey(depositId))
                    {
                        accounts.get(depositId).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n", amount, depositId);
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "setinterest":
                    double interest = Double.parseDouble(commandParts[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "getinterest":
                    int interestId = Integer.parseInt(commandParts[1]);
                    int years = Integer.parseInt(commandParts[2]);
                    if(accounts.containsKey(interestId))
                    {
                        double calculatedInterest = accounts.get(interestId).getInterest(years);
                        System.out.printf("%.2f%n", calculatedInterest);
                    }
                    else
                    {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
