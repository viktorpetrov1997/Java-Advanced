package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditorSecondWay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        StringBuilder str = new StringBuilder();

        ArrayDeque<String> previousStates = new ArrayDeque<>();

        for(int i = 0; i < N; i++)
        {
            String[] commandArray = scanner.nextLine().split(" ");
            String command = commandArray[0];
            if(command.equals("1"))
            {
                previousStates.push(String.valueOf(str));
                String string = commandArray[1];
                str.append(string);
            }
            else if(command.equals("2"))
            {
                previousStates.push(String.valueOf(str));
                int count = Integer.parseInt(commandArray[1]);
                String substring = str.substring(0,str.length() - count);
                str = new StringBuilder(substring);
            }
            else if(command.equals("3"))
            {
                int index = Integer.parseInt(commandArray[1]) - 1;
                System.out.println(str.charAt(index));
            }
            else if(command.equals("4"))
            {
                str = new StringBuilder(previousStates.pop());
            }
        }
    }
}
