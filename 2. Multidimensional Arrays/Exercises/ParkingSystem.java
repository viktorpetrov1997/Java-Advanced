package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class ParkingSystem
{
    public static boolean isRowFull(int[][] parkingLot, int rows, int cols)
    {
        for(int i = 1; i < cols; i++)
        {
            if(parkingLot[rows][i] != 1)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] parkingLot = new int[rows][cols];

        int countFirstColumnSteps = 0;
        int countSteps = 0;

        String input = scanner.nextLine();
        while(!input.equals("stop"))
        {
            String[] commandArray = input.split(" ");
            int entryRow = Integer.parseInt(commandArray[0]);
            int row = Integer.parseInt(commandArray[1]);
            int col = Integer.parseInt(commandArray[2]);

            if(entryRow <= row)
            {
                for(int i = entryRow; i <= row; i++)
                {
                    ++countFirstColumnSteps;
                }
            }
            else
            {
                for(int i = entryRow; i >= row; i--)
                {
                    ++countFirstColumnSteps;
                }
            }

            for(int i = 1; i <= col; i++)
            {
                ++countSteps;
            }

            if(parkingLot[row][col] == 1)
            {
                if(isRowFull(parkingLot, row, cols))
                {
                    System.out.println("Row " + row + " is full");
                }
                else
                {
                    int minDistance = Integer.MAX_VALUE;
                    int closestSpot = -1;

                    for(int i = 1; i < cols; i++)
                    {
                        if(parkingLot[row][i] == 0)
                        {
                            int distance = Math.abs(col - i);
                            if(distance < minDistance)
                            {
                                minDistance = distance;
                                closestSpot = i;
                            }
                        }
                    }

                    parkingLot[row][closestSpot] = 1;
                    countSteps = 0;

                    for(int i = 1; i <= closestSpot; i++)
                    {
                        ++countSteps;
                    }

                    int steps = countFirstColumnSteps + countSteps;
                    System.out.println(steps);
                }
            }
            else
            {
                parkingLot[row][col] = 1;
                int steps = countFirstColumnSteps + countSteps;
                System.out.println(steps);
            }

            countFirstColumnSteps = 0;
            countSteps = 0;

            input = scanner.nextLine();
        }
    }
}
