/*
/ Written by Lukin Uhte
*/
import java.io.*;
import java.util.*;
public class RobotSim{
    private static int comNum = 0;
    public static void main(String[] args)
    {
        comNum = 0;
        Scanner scan = new Scanner(System.in);
        String quit = "no";
        System.out.println("Welcome to the Robot Simulator!");
        while(!(quit.equals("yes")))
        {
            System.out.println("Enter the file for the board.");
            String boardFile = scan.nextLine();
            System.out.println("Enter the file for the Robot Commands");
            String commandFile = scan.nextLine();
            try(Scanner fileScan = new Scanner(new File(boardFile))){
                String[][] board = new String[10][10];
                LLQueue<String> commands = new LLQueue<String>();
                //The following while loop will set up a 2D array where each index is one of the 100 spots on the board.
                while(fileScan.hasNextLine())
                {
                    for(int i = 0; i < board.length; i++)
                    {
                        String[] line = fileScan.nextLine().trim().split("");
                        for(int j = 0; j < line.length; j++)
                        {
                            board[i][j] = line[j];
                        }
                    }
                }
                fileScan.close();
                board[0][0] = "O";
                Scanner fileScan2 = new Scanner(new File(commandFile));
                while(fileScan2.hasNextLine())
                {
                    String command = fileScan2.nextLine();
                    if(command.equals("Move Up") || command.equals("Move Down") || command.equals("Move Right") || command.equals("Move Left")) //Maybe a better way to do this? idc, it works
                    {
                        commands.enqueue(command);
                    }
                }
                fileScan2.close();
                for(int r = 0; r < board.length; r++)
                {
                    for(int c = 0; c < board[r].length; c++)
                    {
                        System.out.print(board[r][c]);
                        if(c == 9)
                            System.out.print("\n");
                    }
                }
                System.out.println("Simulation begin");
                //Now that setup is complete, it's time to simulate!
                while(!(commands.peek() == null))
                {
                    String currentCommand = commands.dequeue();
                    move(board, currentCommand, commands);
                    comNum++;
                }
                System.out.println("Simulation end.\nWould you like to quit? \"yes\" to quit, anything else will run another simulation.");
                quit = scan.nextLine().toLowerCase();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    public static void move(String[][] board, String cmd, LLQueue commands)
    {
        int currentRow = 0;
        int currentCol = 0;
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[r].length; c++)
            {
                if(board[r][c].equals("O"))
                {
                    currentRow = r;
                    currentCol = c;
                }
            }
        }
        //All of the following if-statements do essentially the same thing with some key features changed.
        //They check if the current row/column is already an edge that would have them moving off the board, and crash if so.
        //Then, they find the new row/column, and if it's an "X" then it crashes. If not, it changes it to "O" and changes the old spot to "_".
        if(cmd.equals("Move Up"))
        {
            if(currentRow == 0)
            {
                crash(commands);
                return;
            }
            int newRow = currentRow-1;
            if(board[newRow][currentCol].equals("X"))
            {
                crash(commands);
                return;
            }
            board[currentRow][currentCol] = "_";
            board[newRow][currentCol] = "O";
        }
        if(cmd.equals("Move Down"))
        {
            if(currentRow == 9)
            {
                crash(commands);
                return;
            }
            int newRow = currentRow+1;
            if(board[newRow][currentCol].equals("X"))
            {
                crash(commands);
                return;
            }
            board[currentRow][currentCol] = "_";
            board[newRow][currentCol] = "O";
        }
        if(cmd.equals("Move Left"))
        {
            if(currentCol == 0)
            {
                crash(commands);
                return;
            }
            int newCol = currentCol-1;
            if(board[currentRow][newCol].equals("X"))
            {
                crash(commands);
                return;
            }
            board[currentRow][currentCol] = "_";
            board[currentRow][newCol] = "O";
        }
        if(cmd.equals("Move Right"))
        {
            if(currentCol == 9)
            {
                crash(commands);
                return;
            }
            int newCol = currentCol+1;
            if(board[currentRow][newCol].equals("X"))
            {
                crash(commands);
                return;
            }
            board[currentRow][currentCol] = "_";
            board[currentRow][newCol] = "O";
        }
        System.out.println("Command " + comNum + "\n");
        for(int r = 0; r < board.length; r++)
            {
                for(int c = 0; c < board[r].length; c++)
                {
                    System.out.print(board[r][c]);
                    if(c == 9)
                        System.out.print("\n");
                }
            }
    }

    public static void crash(LLQueue commands)
    {
        System.out.println("CRASH!");
        while(commands.peek() != null)
        {
            commands.dequeue(); //This empties the queue, therefore halting the program.
        }
    }
}