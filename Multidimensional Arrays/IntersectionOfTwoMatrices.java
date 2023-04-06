package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixCols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < matrixCols; col++)
            {
                firstMatrix[row][col] = inputTokens[col];
            }
        }

        String[][] secondMatrix = new String[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < matrixCols; col++)
            {
                secondMatrix[row][col] = inputTokens[col];
            }
        }

        for (int row = 0; row < matrixRows; row++)
        {
            for (int col = 0; col < matrixCols; col++)
            {
                if(firstMatrix[row][col].equals(secondMatrix[row][col]))
                {
                    System.out.print(firstMatrix[row][col] + " ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
