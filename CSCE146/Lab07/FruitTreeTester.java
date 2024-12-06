/*
* Written by Lukin Uhte
*/
import java.io.*;
import java.util.*;
public class FruitTreeTester
{
    public static void main(String[] args)
    {
        LinkedBST fruitBST = new LinkedBST();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Fruit Tree Tester!");
        System.out.println("Please enter a Fruit File Name.");
        String fileName = scan.nextLine();
        
        try(Scanner fileReader = new Scanner(new File(fileName)))
        {
            while(fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                String type;
                double weight;
                if(line.contains("\t"))
                {
                    type = line.substring(0, line.indexOf("\t"));
                    weight = Double.parseDouble(line.substring(line.indexOf("\t") + 2));
                    Fruit addFruit = new Fruit(type, weight);
                    fruitBST.add(addFruit);
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

        System.out.println("PreOrder:");
        fruitBST.printPreOrder();
        System.out.println("InOrder:");
        fruitBST.printInOrder();
        System.out.println("PostOrder:");
        fruitBST.printPostOrder();
        System.out.println("Removing Banana 0.006167454282033358");
        fruitBST.remove(new Fruit("Banana", 0.006167454282033358));
        fruitBST.printInOrder();
    }
}