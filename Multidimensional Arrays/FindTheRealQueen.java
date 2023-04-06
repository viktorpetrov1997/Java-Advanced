package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen
{
    public static boolean checkIfQueenIsValid(char[][] matrix, int row, int col)
    {
        for(int i = 0; i < 8; i++)
        {
            if(i == row) continue;
            if(matrix[i][col] == 'q')
            {
                return false;
            }
        }

        for(int i = 0; i < 8; i++)
        {
            if(i == col) continue;
            if(matrix[row][i] == 'q')
            {
                return false;
            }
        }

        for (int i = 1; i < 8; i++)
        {
            if (row + i < 8 && col + i < 8 && matrix[row + i][col + i] == 'q')
            {
                return false; // check lower right diagonal
            }
            if (row - i >= 0 && col - i >= 0 && matrix[row - i][col - i] == 'q')
            {
                return false; // check upper left diagonal
            }
            if (row - i >= 0 && col + i < 8 && matrix[row - i][col + i] == 'q')
            {
                return false; // check upper right diagonal
            }
            if (row + i < 8 && col - i >= 0 && matrix[row + i][col - i] == 'q')
            {
                return false; // check lower left diagonal
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++)
        {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < 8; col++)
            {
                matrix[row][col] = inputTokens[col].charAt(0);
            }
        }

        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if (matrix[row][col] == 'q' && checkIfQueenIsValid(matrix, row, col))
                {
                    System.out.printf("%d %d", row, col);
                    return;
                }
            }
        }
    }
}
