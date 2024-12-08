package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for(int j = 0; j < cols; j++)
            {
                matrix[i][j] = Integer.parseInt(inputTokens[j]);
            }
        }

        List<List<Integer>> diagonals = new ArrayList<>();

        // Process diagonals starting from the last column of the last row upwards and rightwards
        for(int i = cols - 1; i >= 0; i--)
        {
            List<Integer> diagonal = new ArrayList<>();
            int currentRow = rows - 1;
            int currentCol = i;

            while(currentRow >= 0 && currentCol < cols)
            {
                diagonal.add(matrix[currentRow][currentCol]);
                currentRow--;
                currentCol++;
            }
            diagonals.add(diagonal);
        }

        // Process diagonals from each row (except the last row) of the first column and processes diagonals moving upwards and rightwards
        for(int i = rows - 2; i >= 0; i--)
        {
            List<Integer> diagonal = new ArrayList<>();
            int currentRow = i;
            int currentCol = 0;

            while(currentRow >= 0 && currentCol < cols)
            {
                diagonal.add(matrix[currentRow][currentCol]);
                currentRow--;
                currentCol++;
            }
            diagonals.add(diagonal);
        }

        for(List<Integer> diagonal : diagonals)
        {
            for(int value : diagonal)
            {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
