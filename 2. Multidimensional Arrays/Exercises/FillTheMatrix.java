package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix
{
    public static void fillTheMatrixWithPatternA(int[][] matrix, String pattern)
    {
        int number = 0;
        for (int col = 0; col < matrix[0].length; col++)
        {
            for (int row = 0; row < matrix[0].length; row++)
            {
                matrix[row][col] = ++number;
            }
        }
    }

    public static void fillTheMatrixWithPatternB(int[][] matrix, String pattern)
    {
        int number = 0;
        for (int col = 0; col < matrix[0].length; col++)
        {
            if(col % 2 == 0)
            {
                for (int row = 0; row < matrix[0].length; row++)
                {
                    matrix[row][col] = ++number;
                }
            }
            else
            {
                for (int row = matrix[0].length - 1; row >= 0; row--)
                {
                    matrix[row][col] = ++number;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int row = 0; row < matrix[0].length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] sizeAndPattern = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(sizeAndPattern[0]);
        String pattern = sizeAndPattern[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if(pattern.equals("A"))
        {
            fillTheMatrixWithPatternA(matrix,pattern);
        }
        else
        {
            fillTheMatrixWithPatternB(matrix,pattern);
        }

        printMatrix(matrix);
    }
}
