package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class MatrixOfPalindromes
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        String[][] matrix = new String[rows][cols];

        char character = 'a';
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                String palindrome = "" + character + (char)(character + j) + character;
                matrix[i][j] = palindrome;
            }
            ++character;
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}