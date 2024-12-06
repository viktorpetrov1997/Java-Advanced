package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum
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
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }

        int sum = 0;
        int bestSum = 0;
        int row = 0;
        int col = 0;


        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(i + 2 < rows && j + 2 < cols)
                {
                    sum = matrix[i][j] + matrix[i][j + 1] + + matrix[i][j + 2] +
                            matrix[i + 1][j] + matrix[i + 1][j + 1] + + matrix[i + 1][j + 2] +
                            matrix[i + 2][j] + matrix[i + 2][j + 1] + + matrix[i + 2][j + 2];
                }
                if(bestSum < sum)
                {
                    bestSum = sum;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        for(int i = row; i <= row + 2; i++)
        {
            for(int j = col; j <= col + 2; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}