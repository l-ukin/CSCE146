/*
* Written by Lukin Uhte (with help from lecture example for sorting algorithms)
*/
import java.util.*;
public class Sort{
    public static void main(String[] args)
    {
        String keepGoing = "yes";
        while(keepGoing.equals("yes"))
        {
            System.out.println("Enter any number of strings, and I will sort by SORT's. Once you're done entering sentences, enter quit.");
            String input = "";
            Scanner scan = new Scanner(System.in);
            int count = 0;
            GenLL<String> stringsLL = new GenLL<String>(); //Starting with linked list so we don't have to worry about length
            while(!input.equals("quit"))
            {
                input = scan.nextLine();
                if(!input.equals("quit"))
                {
                    count++;
                    stringsLL.add(input);
                }
            }
            String[] strings = stringsLL.convertToArray(); //Turns our linked list into an array for easier sorting
            mergeSort(strings, "sort");
            System.out.println("\nSORTED! Here is your sort sorted strings!");
            for(String out : strings)
                System.out.println(out);
            System.out.println("Would you like to sort again? \"yes\" to continue, \"no\" to end.");
            keepGoing = scan.nextLine().toLowerCase();
        }
    }

    public static void mergeSort(String[] ogArray, String check) //This method and the merge method were written by following the lecture on sorting. They have been slightly tweaked to match the assignment.
    {
        int size = ogArray.length;
        if(size < 2)
            return;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        String[] left = new String[leftSize];
        String[] right = new String[rightSize];
        for(int i = 0; i < mid; i++)
            left[i] = ogArray[i];
        for(int i = mid; i < size; i++)
            right[i-mid] = ogArray[i];
        mergeSort(left, check);
        mergeSort(right, check);
        merge(left, right, ogArray, check);
    }
    public static void merge(String[] left, String[] right, String[] ogArray, String check)
    {
        int leftSize = left.length;
        int rightSize = right.length;
        int iLeft = 0;
        int iRight = 0;
        int iMerged = 0;
        while(iLeft < leftSize && iRight < rightSize)
        {
            if(numOf(left[iLeft], check) <= numOf(right[iRight], check))
            {
                ogArray[iMerged] = left[iLeft];
                iLeft++;
                iMerged++;
            }else{
                ogArray[iMerged] = right[iRight];
                iRight++;
                iMerged++;
            }
        }
        while(iLeft < leftSize)
        {
            ogArray[iMerged] = left[iLeft];
            iLeft++;
            iMerged++;
        }
        while(iRight < rightSize)
        {
            ogArray[iMerged] = right[iRight];
            iRight++;
            iMerged++;
        }
    }
    public static int numOf(String stringToCheck, String check)
    {
        stringToCheck = stringToCheck.toLowerCase();
        check = check.toLowerCase();
        int returnVal = 0;
        while(stringToCheck.contains(check))
        {
            int num = stringToCheck.indexOf(check)+check.length(); //Adding check.length means it will chop the String to no longer contain this iteration of "sort".
            if(num >= stringToCheck.length()-1){
                returnVal++;
                return returnVal;
            }
            stringToCheck = stringToCheck.substring(num);
            //Example: "hello sort hello sort hello" becomes "hello sort hello" then becomes "hello". Every time it loops through and removes a "sort" from the string, returnVal increases by one.
            returnVal++;
        }
        return returnVal;
    }
}