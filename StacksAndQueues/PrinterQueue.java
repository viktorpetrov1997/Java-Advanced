package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Deque<String> files = new ArrayDeque<>();

        String input = scanner.nextLine();

        while(!input.equals("print"))
        {
            if(input.equals("cancel"))
            {
                if(files.isEmpty())
                {
                    System.out.println("Printer is on standby");
                }
                else
                {
                    String firstFileInQueue = files.poll();
                    System.out.printf("Canceled %s%n", firstFileInQueue);
                }
            }
            else
            {
                files.offer(input);
            }
            input = scanner.nextLine();
        }

        for (String file : files)
        {
            System.out.println(file);
        }
    }
}
