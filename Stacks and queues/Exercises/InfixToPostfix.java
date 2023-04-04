package StacksAndQueues.Exercises;

import java.util.Scanner;
import java.util.*;

public class InfixToPostfix
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> operators = new HashMap<>();
        operators.put('-', 2);
        operators.put('+', 2);
        operators.put('*', 3);
        operators.put('/', 3);
        operators.put('(', 0);
        operators.put(')', 0);

        StringBuffer stringBuffer = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<>();

        boolean isOpenBracket = false;

        for (String tokens : scanner.nextLine().split("\\s+"))
        {

            char token = tokens.charAt(0);

            if (tokens.length() > 1)
            {
                stringBuffer.append(tokens + " ");
                continue;
            }

            if (operators.containsKey(token))
            {

                // operators for comparing by precedence
                int a = operators.get(token);
                int b = stack.isEmpty() ? 0 : operators.get(stack.peek());

                // open bracket
                if (token == '(')
                {
                    stack.push(token);
                    isOpenBracket = true;
                }

                // close bracket
                else if (token == ')')
                {

                    // pop the operator from the operator stack onto the output queue.
                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        stringBuffer.append(stack.pop());
                        stringBuffer.append(" ");
                    }
                    isOpenBracket = false;

                    // pop the open bracket
                    if (stack.isEmpty())
                    {
                        // there are mismatched parentheses.
                        return;
                    }
                    else
                    {
                        stack.pop();
                    }
                }

                // open bracket flag
                else if (isOpenBracket)
                {
                    stack.push(token);
                }

                // there is an operator at the top of the operator stack with greater precedence
                else if (a > b)
                {
                    stack.push(token);
                }

                // greater or equal  precedence
                else
                {
                    // pop operators from the operator stack onto the output queue.
                    while (!stack.isEmpty() && a <= operators.get(stack.peek()))
                    {
                        stringBuffer.append(stack.pop());
                        stringBuffer.append(" ");
                    }
                    // push the operator onto the operator stack.
                    stack.push(token);
                }

            }
            else
            {
                stringBuffer.append(token);
                stringBuffer.append(" ");
            }
        }

        // append operators from stack
        while (!stack.isEmpty())
        {

            char token = stack.pop();

            // there are mismatched parentheses.
            if (token == '(' || token == ')')
            {
                return;
            }

            stringBuffer.append(token);
            stringBuffer.append(" ");
        }

        System.out.println(stringBuffer.toString());
    }
}
