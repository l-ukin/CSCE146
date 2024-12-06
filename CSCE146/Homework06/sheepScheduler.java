/*
/ Written by Lukin Uhte
*/
import java.io.*;
import java.util.*;
public class sheepScheduler
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        MinHeap<Sheep> heap = new MinHeap<Sheep>(); //I finally figured out my mistake in my last lab, unfortunately too late... I forgot to make it extend Comparable<> instead of just Comparable!!
        System.out.println("Welcome to the Sheep Scheduler! Please input a file name.");
        String fileName = scan.nextLine();

        try(Scanner fileReader = new Scanner(new File(fileName)))
        {
            while(fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                String name;
                int sheerTime;
                int arrivalTime;
                if(line.contains("\t"))
                {
                    int index = line.indexOf("\t");
                    name = line.substring(0, index);
                    String nums = line.substring(index + 1);
                    if(!nums.contains("\t"))
                    {
                        continue; //If it's set up incorrectly in the file, it won't add it to the heap.
                    }
                    String s = nums.substring(0, nums.indexOf("\t"));
                    sheerTime = Integer.parseInt(s); //I had to split this up because VSCode was being weird about it?
                    arrivalTime = Integer.parseInt(nums.substring(nums.indexOf("\t") + 1));
                    Sheep newSheep = new Sheep(name, sheerTime, arrivalTime);
                    heap.add(newSheep);
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

        System.out.println("Schedule:");
        heap.print();
    }
}