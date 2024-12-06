/*
/Lukin Uhte
*/
import java.io.*;
import java.util.*;

public class ShowcaseShowdown{
        public static int totalPrice = 0;
        public static String[] prizes;
        public static int[] prices;
        public static String[] prizes2;
        public static String answer = "no";
    public static void main(String[] args) {
        prizes = readFile("./Homework01/prizeList.txt");
        prices = new int[prizes.length]; //List of just prices
        prizes2 = new String[prizes.length]; //List of just prizes
        int i = 0;
        for(String prize : prizes)
        {
            if(!prize.contains("\t"))
                continue;
            else if(!followsFormat(prize))
                continue;
            String first = prize.substring(0, prize.indexOf("\t"));
            String second = prize.substring(prize.indexOf("\t")+1); //+1 so it ignores the \t
            int price = Integer.parseInt(second);
            prices[i] = price;
            prizes2[i] = first;
            i++;
        }
        while(!answer.equals("yes")){
            System.out.println("Welcome to Showcase Showdown!\nHere are your prizes:");
            String[] displayPrizes = pickPrizes(prizes2, prices);
            for(String display : displayPrizes)
            {
                System.out.println(display);
            }
            System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price.");
            Scanner scan = new Scanner(System.in);
            int guess = scan.nextInt();
            scan.nextLine(); //Fixup
            if(guess > totalPrice)
            {
                System.out.println("You guessed " + guess + ", but the actual price was " + totalPrice + ". You went over! You lose!");
            }
            else if(Math.abs(guess - totalPrice) > 1300)
            {
                System.out.println("You guessed " + guess + ", but the actual price was " + totalPrice + ". You were not within $1,300! You lose!");
            }
            else
            {
                System.out.println("Your guess of " + guess + " was within $1,300 of the actual price of " + totalPrice + ". You win!");
            }
            System.out.println("Would you like to quit? Type 'yes' to quit.");
            answer = scan.nextLine();
        }
        System.out.println("Thanks for playing!");
    }

    private static boolean followsFormat(String inputString)
    {
        if(inputString.contains("\t"))
        {
            String first = inputString.substring(0, inputString.indexOf("\t"));
            String second = inputString.substring(inputString.indexOf("\t")+1);
            if(isNumeric(first))
                return false;
            return isNumeric(second);
        }
        return false;
    }
    private static boolean isNumeric(String checkString)
    {
        if(checkString == null ||checkString.equals("") || checkString.isBlank())
            return false;
        try {
            int value = Integer.parseInt(checkString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static String[] pickPrizes(String[] prizeList, int[] priceList)
    {
        String[] returnArray = new String[5];
        for(int i = 0; i < 5; i++)
        {
        int rngPrize = (int) (Math.random() * prizeList.length);
        while(prizeList[rngPrize] == null || prizeList[rngPrize].isBlank() || prizeList[rngPrize].contains("used")) //If this prize has already been selected
        {
            rngPrize = (int) (Math.random() * prizeList.length); //Pick a new one
        }
        returnArray[i] = prizeList[rngPrize]; //Adds prize to return list
        totalPrice += priceList[rngPrize];
        prizeList[rngPrize] = "used"; //Makes a prize listed as already selected in the original list
        }
        return returnArray;
    }
    	public static String[] readFile(String fileName) //Taken from WordSorter, written by JJ Shepherd
	{
		try
		{
			//Creates a scanner for the file and then first counts each word
			Scanner fileScanner = new Scanner(new File(fileName));
			int wordCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				wordCount++;
			}
			if(wordCount <= 0)
				return null;
			//Creates the return array, resets the file scanner, and populates the array
			String[] retArr = new String[wordCount];
			fileScanner = new Scanner(new File(fileName));
			for(int i=0;i<retArr.length;i++)
			{
				if(!fileScanner.hasNextLine())
					break;
				retArr[i] = fileScanner.nextLine();
			}
			return retArr;
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}