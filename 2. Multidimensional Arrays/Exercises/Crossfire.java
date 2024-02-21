package MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossfire
{
    private static boolean isInRange(int row, int col, List<List<Integer>> matrix)
    {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;

        for (int row = 0; row < rows; row++)
        {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++)
            {
                matrix.get(row).add(count++);
            }
        }

        String line = reader.readLine();

        while (!line.equals("Nuke it from orbit"))
        {
            String[] data = line.split(" ");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int i = row - radius; i <= row + radius; i++)
            {
                if (isInRange(i, col, matrix) && i != row)
                {
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--)
            {
                if (isInRange(row, i, matrix))
                {
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            line = reader.readLine();
        }

        for(List<Integer> integers : matrix)
        {
            for (Integer integer : integers)
            {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}