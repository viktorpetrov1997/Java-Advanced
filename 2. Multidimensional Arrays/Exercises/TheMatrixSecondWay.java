package MultidimensionalArrays.Exercises;

import java.util.*;

public class TheMatrixSecondWay
{
    private static void floodFill(char[][] matrix, int startRow, int startCol, char startChar, char fillChar, int rows, int cols)
    {
        if(startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols || matrix[startRow][startCol] != startChar)
        {
            return;
        }

        // Fill the current cell
        matrix[startRow][startCol] = fillChar;

        // Recursive calls for adjacent cells
        floodFill(matrix,startRow - 1, startCol,  startChar, fillChar, rows, cols); // Up
        floodFill(matrix,  startRow + 1, startCol, startChar, fillChar, rows, cols); // Down
        floodFill(matrix, startRow, startCol - 1, startChar, fillChar, rows, cols); // Left
        floodFill(matrix, startRow, startCol + 1, startChar, fillChar, rows, cols); // Right
    }

    public static void printMatrix(char[][] matrix, int rows, int cols)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        char[][] matrix = new char[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            String row = scanner.nextLine().replace(" ", "");
            for(int j = 0; j < cols; j++)
            {
                matrix[i][j] = row.charAt(j);
            }
        }

        // Fill character
        char fillChar = scanner.nextLine().charAt(0);

        // Starting position
        String[] startingPosition = scanner.nextLine().split(" ");
        int startRow = Integer.parseInt(startingPosition[0]);
        int startCol = Integer.parseInt(startingPosition[1]);

        // Starting character
        char startChar = matrix[startRow][startCol];

        // Perform flood fill
        if(startChar != fillChar)
        {
            floodFill(matrix, startRow, startCol, startChar, fillChar, rows, cols);
        }

        // Print the result
        printMatrix(matrix, rows, cols);
    }
}
