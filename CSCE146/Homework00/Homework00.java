/*
* Written by Lukin Uhte
*/
import java.util.Scanner;
public class Homework00{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input = 0; //Declares input so the while-loop works. input will be locked to 1-4 later.

        System.out.println("Welcome to Vectors Galore, your one-stop shop for Vector Operations!"); //Outside of loop, so it doesn't welcome the user more than once.
        System.out.println("To start, please enter one of the following inputs:");

        while(input != 4){
            System.out.println("Type 1 to add two vectors.");
            System.out.println("Type 2 to subtract two vectors.");
            System.out.println("Type 3 to find the magnitude of a vector.");
            System.out.println("Type 4 to close the program.");
            input = scan.nextInt();
            scan.nextLine(); //Fixup

            if(input > 4 || input < 1){ //In case the user inputs a number other than 1-4.
                System.out.println("You inputted " + input + ", which is not a valid input.");
            }

            if(input == 4){ //Closes the program
                System.out.println("Thank you for using Vectors Galore!");
                System.exit(0);
            }

            if(input == 1 || input == 2){ //Allows the user to input both vectors if they opted to add/subtract.
                    System.out.println("Enter the size of the vectors.");
                    int size = scan.nextInt();
                    scan.nextLine(); //Fixup

                    while(size <= 0){ //This loop ensures that the vectors' size is possible.
                        System.out.println("Your vectors must be of size 1 or higher. Please reinput.");
                        size = scan.nextInt();
                        scan.nextLine(); //Fixup
                    }

                    double[] vec1 = new double[size]; //Initializes a user-inputted vector as an array
                    double[] vec2 = new double[size]; //Initializes a user-inputted vector as an array
                    double[] vec3 = new double[size]; //Initalizes the resulting vector of addition/subtraction as an array

                    for(int i = 1; i <= size; i++){ //Loops through first vector
                        System.out.println("Enter value #" + i + " for the first vector, as a decimal.");
                        vec1[i-1] = scan.nextDouble();
                        scan.nextLine(); //Fixup
                    }
                    for(int i = 1; i <= size; i++){ //Loops through second vector
                        System.out.println("Enter value #" + i + " for the second vector, as a decimal.");
                        vec2[i-1] = scan.nextDouble();
                        scan.nextLine(); //Fixup
                    }

                    for(int i = 0; i < size; i++){ //Loops through result vector
                        if(input == 1){ //Goes back to user's original input of addition vs. subtraction
                            vec3[i] = vec1[i] + vec2[i];
                        }else{
                            vec3[i] = vec1[i] - vec2[i];
                        }
                    }

                    System.out.println("Result:");
                    for(double val : vec1){
                        System.out.println(val);
                    }
                    if(input == 1){ //Goes back to user's original input of addition vs. subtraction
                        System.out.println("+");
                    }else{
                        System.out.println("-");
                    }
                    for(double val : vec2){
                        System.out.println(val);
                    }
                    System.out.println("=");
                    for(double val : vec3){
                        System.out.println(val);
                    }
            }

            if(input == 3){
                    System.out.println("Enter the size of the vector.");
                    int size = scan.nextInt();
                    scan.nextLine(); //Fixup

                    while(size <= 0){ //This loop ensures that the vector's size is possible.
                        System.out.println("Your vector must be of size 1 or higher. Please reinput.");
                        size = scan.nextInt();
                        scan.nextLine(); //Fixup
                    }

                    double[] vec = new double[size];

                    for(int i = 1; i <= size; i++){ //Loops through first vector
                        System.out.println("Enter value #" + i + " for the vector, as a decimal.");
                        vec[i-1] = scan.nextDouble();
                        scan.nextLine(); //Fixup
                    }

                    double total = 0; //Adds up the squares of the values of the vector, then square roots it.
                    for(int i = 0; i < size; i++){
                        total += vec[i] * vec[i];
                    }
                    total = Math.sqrt(total);

                    System.out.println("Magnitude: " + total);
            }
            input = 0;
        }

    }

}