package MultidimensionalArrays;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < matrixSize; col++)
            {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        for (int i = 0; i < matrixSize; i++)
        {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        int cols = -1;
        for (int i = matrixSize - 1; i >= 0; i--)
        {
            System.out.print(matrix[i][++cols] + " ");
        }
    }
}
