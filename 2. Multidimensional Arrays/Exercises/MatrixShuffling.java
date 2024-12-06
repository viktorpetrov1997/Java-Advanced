package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling
{
    private static boolean validateCommand(String command, int rows, int cols)
    {
        String[] commandParts = command.split("\\s+");

        if(commandParts.length != 5)
        {
            return false;
        }

        if(!commandParts[0].equals("swap"))
        {
            return false;
        }

        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if(row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        String[][] matrix = new String[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            String[] input = scanner.nextLine().split(" ");
            matrix[i] = input;
        }

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] data = input.split(" ");
            if(!validateCommand(input,rows,cols))
            {
                System.out.println("Invalid input!");
            }
            else
            {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                for(int i = 0; i < rows; i++)
                {
                    for(int j = 0; j < cols; j++)
                    {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            input = scanner.nextLine();
        }
    }
}