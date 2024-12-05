package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String input = scanner.nextLine();
        while(!input.equals("Home"))
        {
            if(input.equals("back"))
            {
                if(browserHistory.isEmpty() || browserHistory.size() == 1)
                {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                browserHistory.pop();
            }
            else
            {
                browserHistory.push(input);
            }

            System.out.println(browserHistory.peek());

            input = scanner.nextLine();
        }
    }
}
