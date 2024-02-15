package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        int[][] correctedMatrix = new int[rows][];

        for (int row = 0; row < rows; row++)
        {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowData;
            correctedMatrix[row] = Arrays.copyOf(rowData, rowData.length);
        }

        String[] numberPosition = scanner.nextLine().split(" ");
        int number = matrix[Integer.parseInt(numberPosition[0])][Integer.parseInt(numberPosition[1])];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == number)
                {
                    int up = 0;
                    int down = 0;
                    int left = 0;
                    int right = 0;
                    if(i - 1 >= 0 && matrix[i-1][j] != number)
                    {
                        up = matrix[i-1][j];
                    }
                    if(i + 1 < rows && matrix[i+1][j] != number)
                    {
                        down = matrix[i+1][j];
                    }
                    if(j - 1 >= 0 && matrix[i][j-1] != number)
                    {
                        left = matrix[i][j-1];
                    }
                    if(j + 1 < matrix[i].length && matrix[i][j+1] != number)
                    {
                        right = matrix[i][j+1];
                    }
                    int sum = up + down + left + right;

                    correctedMatrix[i][j] = sum;
                }
            }
        }

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < correctedMatrix[row].length; col++)
            {
                System.out.print(correctedMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
