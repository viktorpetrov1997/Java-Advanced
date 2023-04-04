package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++)
        {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(')
            {
                indexes.push(i);
            }
            else if (currentSymbol == ')')
            {
                int startIndex = indexes.pop();
                String subExpression = input.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}
