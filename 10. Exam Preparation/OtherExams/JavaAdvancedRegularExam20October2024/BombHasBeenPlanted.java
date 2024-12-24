package OtherExams.JavaAdvancedRegularExam20October2024;

import java.util.Scanner;

public class BombHasBeenPlanted
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);
        String[][] map = new String[rows][cols];

        int counterTerroristCurrentRowPosition = 0;
        int counterTerroristCurrentColPosition = 0;

        for(int row = 0; row < rows; row++)
        {
            String[] inputTokens = scanner.nextLine().split("");
            for(int col = 0; col < cols; col++)
            {
                map[row][col] = inputTokens[col];
                if(map[row][col].equals("C"))
                {
                    counterTerroristCurrentRowPosition = row;
                    counterTerroristCurrentColPosition = col;
                }
            }
        }

        int timeToCompleteMission = 16;

        boolean counterTerroristWins = false;
        boolean bombWasNotDefusedSuccessfully = false;
        boolean terroristsWin = false;

        while(true)
        {
            int oldRow = counterTerroristCurrentRowPosition;
            int oldCol = counterTerroristCurrentColPosition;

            String command = scanner.nextLine();
            switch(command)
            {
                case "up" -> --counterTerroristCurrentRowPosition;
                case "down" -> ++counterTerroristCurrentRowPosition;
                case "left" -> --counterTerroristCurrentColPosition;
                case "right" -> ++counterTerroristCurrentColPosition;
                case "defuse" ->
                {
                    if(map[counterTerroristCurrentRowPosition][counterTerroristCurrentColPosition].equals("B"))
                    {
                        timeToCompleteMission -= 4;
                        if(timeToCompleteMission >= 0)
                        {
                            map[counterTerroristCurrentRowPosition][counterTerroristCurrentColPosition] = "D";
                            counterTerroristWins = true;
                        }
                        else
                        {
                            bombWasNotDefusedSuccessfully = true;
                            map[counterTerroristCurrentRowPosition][counterTerroristCurrentColPosition] = "X";
                        }
                    }
                    else
                    {
                        --timeToCompleteMission;
                    }
                }
            }

            if(counterTerroristWins || bombWasNotDefusedSuccessfully)
            {
                break;
            }

            if(counterTerroristCurrentRowPosition < 0 || counterTerroristCurrentRowPosition > rows - 1
                    || counterTerroristCurrentColPosition < 0
                    || counterTerroristCurrentColPosition > cols -1)
            {
                counterTerroristCurrentRowPosition = oldRow;
                counterTerroristCurrentColPosition = oldCol;
            }

            if(map[counterTerroristCurrentRowPosition][counterTerroristCurrentColPosition].equals("T"))
            {
                terroristsWin = true;
                map[counterTerroristCurrentRowPosition][counterTerroristCurrentColPosition] = "*";
                break;
            }

            --timeToCompleteMission;

            if(timeToCompleteMission <= 0)
            {
                bombWasNotDefusedSuccessfully = true;
                break;
            }
        }

        if(bombWasNotDefusedSuccessfully)
        {
            System.out.println("Terrorists win!");
            System.out.println("Bomb was not defused successfully!");
            System.out.printf("Time needed: %d second/s.%n", Math.abs(timeToCompleteMission));
        }
        else if(counterTerroristWins)
        {
            System.out.println("Counter-terrorist wins!");
            System.out.printf("Bomb has been defused: %d second/s remaining.%n", timeToCompleteMission);
        }
        else if(terroristsWin)
        {
            System.out.println("Terrorists win!");
        }

        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }
}
