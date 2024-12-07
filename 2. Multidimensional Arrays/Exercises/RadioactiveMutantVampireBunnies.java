package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class RadioactiveMutantVampireBunnies
{
    private static void spreadBunnies(char[][] lair, int rows, int cols)
    {
        char[][] updatedLair = new char[rows][cols];
        for(int row = 0; row < rows; row++)
        {
            System.arraycopy(lair[row], 0, updatedLair[row], 0, cols);
        }

        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                if(lair[row][col] == 'B')
                {
                    if(col > 0 && lair[row][col - 1] != 'B')
                    {
                        updatedLair[row][col - 1] = 'B';
                    }

                    if(col < cols - 1 && lair[row][col + 1] != 'B')
                    {
                        updatedLair[row][col + 1] = 'B';
                    }

                    if(row > 0 && lair[row - 1][col] != 'B')
                    {
                        updatedLair[row - 1][col] = 'B';
                    }

                    if(row < rows - 1 && lair[row + 1][col] != 'B')
                    {
                        updatedLair[row + 1][col] = 'B';
                    }
                }
            }
        }

        for(int row = 0; row < rows; row++)
        {
            System.arraycopy(updatedLair[row], 0, lair[row], 0, cols);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] lairSize = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(lairSize[0]);
        int cols = Integer.parseInt(lairSize[1]);
        char[][] lair = new char[rows][cols];

        int currentPlayerRow = 0;
        int currentPlayerCol = 0;

        for(int row = 0; row < rows; row++)
        {
            String inputTokens = scanner.nextLine();
            for(int col = 0; col < cols; col++)
            {
                lair[row][col] = inputTokens.charAt(col);
                if(lair[row][col] == 'P')
                {
                    currentPlayerRow = row;
                    currentPlayerCol = col;
                }
            }
        }

        boolean playerWins = false;
        boolean playerDies = false;

        String commands = scanner.nextLine();
        for(int i = 0; i < commands.length(); i++)
        {
            lair[currentPlayerRow][currentPlayerCol] = '.';

            char command = commands.charAt(i);
            if(command == 'U') currentPlayerRow--;
            if(command == 'D') currentPlayerRow++;
            if(command == 'L') currentPlayerCol--;
            if(command == 'R') currentPlayerCol++;

            if(currentPlayerRow < 0 || currentPlayerRow >= rows || currentPlayerCol < 0 || currentPlayerCol >= cols)
            {
                playerWins = true;
                if(currentPlayerRow < 0)
                {
                    ++currentPlayerRow;
                }
                else
                {
                    ++currentPlayerCol;
                }
            }
            else
            {
                if(lair[currentPlayerRow][currentPlayerCol] == 'B')
                {
                    playerDies = true;
                }
                else
                {
                    lair[currentPlayerRow][currentPlayerCol] = 'P';
                }
            }

            spreadBunnies(lair, rows, cols);

            if(playerWins || playerDies) break;
        }

        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                System.out.print(lair[row][col]);
            }
            System.out.println();
        }

        if(playerWins)
        {
            System.out.printf("won: %d %d%n", currentPlayerRow, currentPlayerCol);
        }
        else if(playerDies)
        {
            System.out.printf("dead: %d %d%n", currentPlayerRow, currentPlayerCol);
        }
    }
}
