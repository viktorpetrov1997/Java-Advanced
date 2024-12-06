package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class TheHeiganDance
{
    private static boolean isRowValid(boolean[][] hsChamber, int startPlRow)
    {
        return startPlRow >= 0 && startPlRow < hsChamber[startPlRow].length;
    }

    private static boolean isColValid(boolean[][] hsChamber, int startPlCol)
    {
        return startPlCol >= 0 && startPlCol < hsChamber.length;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double heigansPoints = 3000000.0;
        int playerPoints = 18500;

        int startPlayerRow = 7;
        int startPlayerCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while(playerPoints > 0 && heigansPoints > 0)
        {
            heigansPoints -= damage;

            if(activeCloud)
            {
                playerPoints -= 3500;
                activeCloud = false;

                if(playerPoints < 0)
                {
                    break;
                }
            }

            if(heigansPoints < 0)
            {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean[][] hsChamber = new boolean[15][15];

            for(int i = row - 1; i <= row + 1; i++)
            {
                if(i >= 0 && i < hsChamber.length)
                {
                    for(int j = col - 1; j <= col + 1; j++)
                    {
                        if(j >= 0 && j < hsChamber[row].length)
                        {
                            hsChamber[i][j] = true;
                        }
                    }
                }
            }

            if(hsChamber[startPlayerRow][startPlayerCol])
            {
                if(isRowValid(hsChamber, startPlayerRow - 1) && !hsChamber[startPlayerRow - 1][startPlayerCol])
                {
                    startPlayerRow--;
                }
                else if(isColValid(hsChamber, startPlayerCol + 1) && !hsChamber[startPlayerRow][startPlayerCol + 1])
                {
                    startPlayerCol++;
                }
                else if(isRowValid(hsChamber, startPlayerRow + 1) && !hsChamber[startPlayerRow + 1][startPlayerCol])
                {
                    startPlayerRow++;
                }
                else if(isColValid(hsChamber, startPlayerCol - 1) && !hsChamber[startPlayerRow][startPlayerCol - 1])
                {
                    startPlayerCol--;
                }

                if(hsChamber[startPlayerRow][startPlayerCol])
                {
                    switch(spell)
                    {
                        case "Cloud":
                            playerPoints -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if(heigansPoints > 0)
        {
            System.out.printf("Heigan: %.2f%n", heigansPoints);
        }
        else
        {
            System.out.println("Heigan: Defeated!");
        }

        if(playerPoints > 0)
        {
            System.out.printf("Player: %d%n", playerPoints);
        }
        else
        {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + startPlayerRow + ", " + startPlayerCol);
    }
}