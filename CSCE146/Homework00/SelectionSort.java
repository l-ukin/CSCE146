/*
* Lukin Uhte
*/
import java.util.Scanner;
public class SelectionSort{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the sorter. Enter the size of the array.");
        int size = keyboard.nextInt();
        keyboard.nextLine();//Useful fix-up, removes \n from nextInt
        if(size <= 1){
            System.out.println("That's invalid");
            System.exit(0);//Terminate the program
        }
        //Create the array
        int[] a = new int[size];
        //Populate the array
        for(int i=0;i<a.length;i++){
            System.out.println("Enter value at index "+i);
            a[i] = keyboard.nextInt();
            keyboard.nextLine();
        }
        //Selection sort in ascending order (smallest to largest)
        for(int i=0;i<a.length;i++){
            int smallestIndex=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j] < a[smallestIndex]){
                smallestIndex = j;
                }
            }
            if(smallestIndex != 1){
                //Swap
                int temp = a[i];
                a[i] = a[smallestIndex];
                a[smallestIndex] = temp;
            }
        }
        //Print it out
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}