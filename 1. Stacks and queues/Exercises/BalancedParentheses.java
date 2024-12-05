package StacksAndQueues.Exercises;

import org.ietf.jgss.GSSContext;

import java.util.Scanner;
import java.util.*;

public class BalancedParentheses
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean areBalanced = false;

        String input = scanner.nextLine();
        for(int index = 0; index < input.length(); index++)
        {
            char currentBracket = input.charAt(index);
            if(currentBracket == '(' || currentBracket == '{' || currentBracket == '[')
            {
                openBrackets.push(currentBracket);
            }
            else if(currentBracket == ')' || currentBracket == '}' || currentBracket == ']')
            {
                if(openBrackets.isEmpty())
                {
                    areBalanced = false;
                    break;
                }

                char lastOpenBracket = openBrackets.pop();

                if(lastOpenBracket == '(' && currentBracket == ')')
                {
                    areBalanced = true;
                }
                else if(lastOpenBracket == '{' && currentBracket == '}')
                {
                    areBalanced = true;
                }
                else if(lastOpenBracket == '[' && currentBracket == ']')
                {
                    areBalanced = true;
                }
                else
                {
                    areBalanced = false;
                    break;
                }
            }
        }

        if(areBalanced)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
