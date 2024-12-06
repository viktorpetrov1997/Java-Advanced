package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class SumMatrixElements
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");

        int matrixRows = Integer.parseInt(matrixSize[0]);
        int matrixCols = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[matrixRows][matrixCols];

        int sum = 0;
        for(int row = 0; row < matrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(", ");
            for(int col = 0; col < matrixCols; col++)
            {
                sum += Integer.parseInt(inputTokens[col]);
            }
        }

        System.out.println(matrixRows);
        System.out.println(matrixCols);
        System.out.println(sum);
    }
}
