/*
/ Written by Lukin Uhte
*/
import java.io.*;
import java.util.*;

public class TaskOrganizer{
    public static void main(String[] args)
    {
        GenLL<Task>[] organizedTasks = new GenLL[5];
        for(int i = 0; i < organizedTasks.length; i++)
        {
            organizedTasks[i] = new GenLL<Task>();
        }

        System.out.println("Welcome to the Task Organizer!");
        int option = 6;
        Scanner scan = new Scanner(System.in);

        while(option != 9)
        {
            System.out.println("Enter 1. To Add a Task");
            System.out.println("Enter 2. To Remove a Task");
            System.out.println("Enter 3. To Print Tasks To Console");
            System.out.println("Enter 4. To Read from a Task File");
            System.out.println("Enter 5. To Write to a Task File");
            System.out.println("Enter 9. To Quit");
            option = scan.nextInt();
            scan.nextLine();

            if(option == 9) //Exit
            {
                System.out.println("Quitting the Organizer. Goodbye!");
                return;
            }

            if(option == 1) //Add a task
            {
                option = 6;
                System.out.println("Please input the priority of your task.");
                int pri = scan.nextInt();
                scan.nextLine();
                System.out.println("Please input the action.");
                String act = scan.nextLine();
                if(organizedTasks[pri].contains(act))
                    System.out.println("This is a duplicate task.");
                else{
                    organizedTasks[pri].add(new Task(pri, act));
                    System.out.println("Task added!");
                }
            }

            if(option == 2) //Remove a task
            {
                option = 6;
                System.out.println("Please input the priority of your task.");
                int pri = scan.nextInt();
                scan.nextLine();
                System.out.println("Please input the action.");
                String act = scan.nextLine();
                organizedTasks[pri].remove(act);
                System.out.println("Task removed, if it existed.");
            }

            if(option == 3) //Print to Console
            {
                option = 6;
                for(int i = 0; i < organizedTasks.length; i++)
                {
                    organizedTasks[i].print();
                }
            }

            if(option == 4) //Read from file
            {
                option = 6;
                System.out.println("Enter the name of the file");
                String fileName = scan.nextLine();
                GenLL<Task>[] tempArray = new GenLL[5];
                GenLL<Task> tempList0 = new GenLL();
                GenLL<Task> tempList1 = new GenLL();
                GenLL<Task> tempList2 = new GenLL();
                GenLL<Task> tempList3 = new GenLL();
                GenLL<Task> tempList4 = new GenLL();
                try(Scanner fileScanner = new Scanner(new File(fileName)))
                {
                    while(fileScanner.hasNextLine())
                    {
                        String nextVal = fileScanner.nextLine();
                        if(nextVal.length() > 3)
                        {
                            int number = Integer.parseInt(nextVal.substring(0, 1));
                            String taskAct = nextVal.substring(2);
                            if(number == 0)
                            {
                                tempList0.add(new Task(number, taskAct));
                            }
                            if(number == 1)
                            {
                                tempList1.add(new Task(number, taskAct));
                            }
                            if(number == 2)
                            {
                                tempList2.add(new Task(number, taskAct));
                            }
                            if(number == 3)
                            {
                                tempList3.add(new Task(number, taskAct));
                            }
                            if(number == 4)
                            {
                                tempList4.add(new Task(number, taskAct));
                            }
                        }
                    }
                    tempArray[0] = tempList0;
                    tempArray[1] = tempList1;
                    tempArray[2] = tempList2;
                    tempArray[3] = tempList3;
                    tempArray[4] = tempList4;
                } catch (FileNotFoundException e)
                {
                    System.out.println("File not found");
                }
                organizedTasks = tempArray;
                System.out.println("Now reading from " + fileName + ".");
            }

            if(option == 5) //Print to file
            {
                option = 6;
                    System.out.println("Enter the file name.");
                    String outFile = scan.nextLine();
                    try
			        {
      			        File newFile = new File(outFile);
                    try (FileWriter fileWriter = new FileWriter(newFile, false)) {
                        for(int i = 0; i < organizedTasks.length; i++)
                        {
                            fileWriter.write(organizedTasks[i].printString());
                        }
                    }
    		        }catch (IOException e) {
      			        System.out.println(e);
   			        }
            }
        }
    }
}