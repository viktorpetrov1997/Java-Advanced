package MultidimensionalArrays;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");
        int matrixRows = Integer.parseInt(matrixSize[0]);
        int matrixCols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int col = 0; col < matrixCols; col++)
            {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrixRows - 1; row++)
        {
            for (int col = 0; col < matrixCols - 1; col++)
            {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(currentSum > maxSum)
                {
                    maxSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1]);
        System.out.println(maxSum);
    }
}
