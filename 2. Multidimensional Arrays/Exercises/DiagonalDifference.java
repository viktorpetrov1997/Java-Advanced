package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class DiagonalDifference
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        for(int row = 0; row < matrixSize; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for(int col = 0; col < matrixSize; col++)
            {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        int primaryDiagonal = 0;
        for(int i = 0; i < matrixSize; i++)
        {
            primaryDiagonal += matrix[i][i];
        }

        int secondaryDiagonal = 0;
        for(int i = 0; i < matrixSize; i++)
        {
            secondaryDiagonal += matrix[i][matrixSize - 1 - i];
        }

        int difference = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(difference);
    }
}
