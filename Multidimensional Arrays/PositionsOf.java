package MultidimensionalArrays;

import java.util.Scanner;

public class PositionsOf
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");
        int matrixRows = Integer.parseInt(matrixSize[0]);
        int matrixCols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < matrixCols; col++)
            {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int row = 0; row < matrixRows; row++)
        {
            for (int col = 0; col < matrixCols; col++)
            {
                if(matrix[row][col] == number)
                {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if(!isFound)
        {
            System.out.println("not found");
        }
    }
}
