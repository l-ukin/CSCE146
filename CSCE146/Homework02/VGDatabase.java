/*
/ Written by Lukin Uhte
*/
import java.io.*;
import java.util.*;

public class VGDatabase{
        public static int choice = 9;
        public static String fileName;
        public static GenLL<String> games;
        public static boolean loaded = false;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Video Game Database!");
        while(choice != 0){
            System.out.println("\nEnter 1 to load the database\nEnter 2 to search the database\nEnter 3 to print current results to the console\nEnter 4 to print current results to file\nEnter 0 to quit");
            choice = scan.nextInt();
            scan.nextLine();

            if(choice == 0) //Exit option
            {
                System.out.println("Quitting the database");
                return;
            }

            if(choice == 1) //Loading option
            {
                choice = 9;
                System.out.println("Enter the name of the file");
                fileName = scan.nextLine();
                games = createList(fileName);
                loaded = true;
                System.out.println("Now reading from " + fileName + ".");
            }

            if(choice == 2) //Searching option
            {
                choice = 9;
                if(loaded)
                {
                    games = createList(fileName);
                    GenLL<String> newList = new GenLL<String>();
                    System.out.println("Enter the name of the game ('*' for all).");
                    String gameCheck = scan.nextLine();
                    if(!(gameCheck.equals("*")))
                    {
                        games.reset();
                        while(games.hasMore())
                        {
                            if(games.getCurrent().substring(0, games.getCurrent().indexOf("\t")).contains(gameCheck))
                            {
                                newList.add(games.getCurrent());
                            }
                            games.goToNext();
                        }
                    }else{
                        while(games.hasMore())
                        {
                            newList.add(games.getCurrent());
                            games.goToNext();
                        }
                    }

                    GenLL<String> newList2 = new GenLL<String>();
                    System.out.println("Enter the name of console ('*' for all).");
                    String consoleCheck = scan.nextLine();

                    if(!(consoleCheck.equals("*")))
                    {
                        while(newList.hasMore())
                        {
                            if(newList.getCurrent().substring(newList.getCurrent().indexOf("\t")).contains(consoleCheck))
                            {
                                newList2.add(newList.getCurrent());
                            }
                            newList.goToNext();
                        }
                    }else{
                        while(newList.hasMore())
                        {
                            newList2.add(newList.getCurrent());
                            newList.goToNext();
                        }
                    }
                    games = newList2;
                    newList2.reset();
                    while(newList2.hasMore())
                    {
                        System.out.println(newList2.getCurrent());
                        newList2.goToNext();
                    }
                }else{
                    System.out.println("No database has been loaded.");
                }

            }

            if(choice == 3) //Print to console
            {
                choice = 9;
                if(loaded)
                {
                    games.reset();
                    while(games.hasMore())
                    {
                        System.out.println(games.getCurrent());
                        games.goToNext();
                    }
                }else{
                    System.out.println("No database has been loaded.");
                }
            }

            if(choice == 4) //Print to file
            {
                boolean append;
                choice = 9;
                if(loaded)
                {
                    System.out.println("Enter the file name.");
                    String outFile = scan.nextLine();
                    try
			        {
      			        File newFile = new File(outFile);
      			        if (!(newFile.createNewFile())) {
        			        System.out.println("Would you like to append (true) or overwrite (false)?");
                            append = scan.nextBoolean();
                            scan.nextLine(); //Fixup
                            FileWriter fileWriter = new FileWriter(newFile, append);
                            games.reset();
                            while(games.hasMore())
                            {
                                fileWriter.write(games.getCurrent() + "\n");
                                games.goToNext();
                            }
                            fileWriter.close();
      			        }else{ //If the file doesn't already exist, no point in asking for append vs. overwrite
                            FileWriter fileWriter = new FileWriter(newFile);
                            games.reset();
                            while(games.hasMore())
                            {
                                fileWriter.write(games.getCurrent() + "\n");
                                games.goToNext();
                            }
                            fileWriter.close();
                        }
    		        }catch (IOException e) {
      			        System.out.println(e);
   			        }
                }else{
                    System.out.println("No database has been loaded.");
                }
            }
        }
    }

    private static GenLL<String> createList(String file)
    {
        GenLL<String> tempList = new GenLL<String>();
        try(Scanner fileScanner = new Scanner(new File(file)))
                {
                    while(fileScanner.hasNextLine())
                    {
                        String nextVal = fileScanner.nextLine();
                        if(nextVal.length() > 1 && nextVal.contains("\t") && nextVal.indexOf("\t") != 0 && nextVal.substring(nextVal.indexOf("\t")).length() >= 3) //Checks if it matches the correct format of "GAME\tCONSOLE"
                        {
                            tempList.add(nextVal); //Fills the linked list with the games from the file
                        }
                    }
                } catch (FileNotFoundException e)
                {
                    System.out.println("File not found");
                }
        return tempList;
    }
}