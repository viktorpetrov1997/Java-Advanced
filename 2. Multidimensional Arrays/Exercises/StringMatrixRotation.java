package MultidimensionalArrays.Exercises;

import java.util.*;
import java.util.regex.*;

public class StringMatrixRotation
{
    public static void rotate(char[][] matrix, int rows, int cols, int angle)
    {
        if(angle == 90)
        {
            for(int i = 0; i < cols; i++)
            {
                for(int j = rows - 1; j >= 0; j--)
                {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }
        }
        else if(angle == 180)
        {
            for(int i = rows - 1; i >= 0; i--)
            {
                for(int j = cols - 1; j >= 0; j--)
                {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
        else if(angle == 270)
        {
            for(int i = cols - 1; i >= 0; i--)
            {
                for(int j = 0; j < rows; j++)
                {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }
        }
        else
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
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();

        String regex = "(?<angle>\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rotation);

        int angle = 0;
        if(matcher.find())
        {
            angle = Integer.parseInt(matcher.group("angle"));
        }

        angle = angle % 360;

        List<String> words = new ArrayList<>();
        int maxLength = 0;

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            words.add(input);
            if(maxLength < input.length())
            {
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = words.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(j < words.get(i).length())
                {
                    matrix[i][j] = words.get(i).charAt(j);
                }
                else
                {
                    matrix[i][j] = ' ';
                }
            }
        }
        rotate(matrix,rows,cols,angle);
    }
}