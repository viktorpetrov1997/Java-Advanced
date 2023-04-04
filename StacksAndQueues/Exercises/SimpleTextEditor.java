package StacksAndQueues.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditor
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        StringBuilder str = new StringBuilder();

        List<String> previousStates = new ArrayList<>();

        for(int i = 0; i < N; i++)
        {
            String[] commandArray = scanner.nextLine().split(" ");
            String command = commandArray[0];
            if(command.equals("1"))
            {
                previousStates.add(String.valueOf(str));
                String string = commandArray[1];
                str.append(string);
            }
            else if(command.equals("2"))
            {
                previousStates.add(String.valueOf(str));
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
                str = new StringBuilder(previousStates.get(previousStates.size() - 1));
                previousStates.remove(previousStates.size() - 1);
            }
        }
    }
}
