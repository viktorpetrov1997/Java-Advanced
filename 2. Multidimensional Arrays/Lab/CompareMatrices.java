package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] firstMatrixSize = scanner.nextLine().split(" ");
        int firstMatrixRows = Integer.parseInt(firstMatrixSize[0]);
        int firstMatrixCols = Integer.parseInt(firstMatrixSize[1]);

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        for(int row = 0; row < firstMatrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for(int col = 0; col < firstMatrixCols; col++)
            {
                firstMatrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        String[] secondMatrixSize = scanner.nextLine().split(" ");
        int secondMatrixRows = Integer.parseInt(secondMatrixSize[0]);
        int secondMatrixCols = Integer.parseInt(secondMatrixSize[1]);

        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];

        for(int row = 0; row < secondMatrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for(int col = 0; col < secondMatrixCols; col++)
            {
                secondMatrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        if(firstMatrixRows != secondMatrixRows || firstMatrixCols != secondMatrixCols)
        {
            System.out.println("not equal");
            return;
        }

        for(int row = 0; row < firstMatrixRows; row++)
        {
            for(int col = 0; col < secondMatrixCols; col++)
            {
                if(firstMatrix[row][col] != secondMatrix[row][col])
                {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
