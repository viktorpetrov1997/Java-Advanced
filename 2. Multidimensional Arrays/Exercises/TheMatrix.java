package MultidimensionalArrays.Exercises;

import java.util.*;

public class TheMatrix
{
    private static final int[] ROW_DIR = {-1, 1, 0, 0};
    private static final int[] COL_DIR = {0, 0, -1, 1};

    // Flood fill using ArrayDeque as a stack
    public static void floodFill(char[][] matrix, int startRow, int startCol, char startChar, char fillChar, int rows, int cols)
    {
        // If the starting character is the same as the fill character, no changes are needed
        if(startChar == fillChar)
        {
            return;
        }

        // Use ArrayDeque as a stack
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {startRow, startCol}); // Push initial position onto the stack

        // Fill the starting position
        matrix[startRow][startCol] = fillChar;

        // Perform DFS using the stack
        while(!stack.isEmpty())
        {
            int[] currentPosition = stack.pop(); // Pop the top element
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            // Check all 4 possible directions
            for(int i = 0; i < 4; i++)
            {
                int newRow = currentRow + ROW_DIR[i];
                int newCol = currentCol + COL_DIR[i];

                // Check if the new position is valid and contains the startChar
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] == startChar)
                {
                    matrix[newRow][newCol] = fillChar; // Fill the cell
                    stack.push(new int[] {newRow, newCol}); // Add the cell to the stack for further exploration
                }
            }
        }
    }

    // Function to print the matrix
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
