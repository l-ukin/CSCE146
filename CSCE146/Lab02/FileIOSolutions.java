/*
/ Written by Lukin Uhte
*/
import java.io.*;
import java.util.*;
public class FileIOSolutions
{
    public static void pastTense(String inFile, String outFile)
    {

        try
		{
            //First part sets up an array where each index is one word
            Scanner fileReader = new Scanner(new File(inFile));   
            int count = 0;
			while(fileReader.hasNext())
			{
				fileReader.next();
				count++;
			}     
            String[] words = new String[count];
			fileReader = new Scanner(new File(inFile));
			for(int i=0;i<words.length;i++)
			{
				if(!fileReader.hasNext())
					break;
				words[i] = fileReader.next();
			}

            //Next part changes the word "is" to "was", but only if the word is just "is" with punctuation (that way words like "visit" won't become "vwasit")
            for(int i=0;i<words.length;i++)
            {
                if(words[i].toLowerCase().indexOf("is") == 0 && words[i].length() <= 3 && !(words[i].substring(2).equalsIgnoreCase("m"))) //"ism" is the only 3-letter word starting with "is." If the text file contains a non-English three-letter word that starts with "is" (ex. "isp", "ish"), then "is" will become "was" (ex. "wasp", "wash"), so I'm assuming that the text file only uses real English words.
				{
					words[i] = words[i].replace("is", "was");
					words[i] = words[i].replace("Is", "Was");
				}
            }

			//Next part will output the changes to a new text file and print to console.
			try
			{
      			File newFile = new File(outFile);
      			if (!(newFile.createNewFile())) {
        			System.out.println("Error: Output file already exists.");
      			}
    		} catch (IOException e) {
      			System.out.println(e);
   			}

            try (FileWriter fileWriter = new FileWriter(outFile))
			{
                for(String writeW : words)
                {
                    fileWriter.write(writeW + "\n");
                    System.out.println(writeW);
                }
				fileWriter.close();
            }catch(IOException e)
			{
				System.out.println(e);
			}

        }
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    }

	public static double totalTubeVolume(String inFile)
	{
		try
		{
			//This part will scan the file and add each segment to an array
			Scanner fileScanner = new Scanner(new File(inFile));
			int count = 0;
			while(fileScanner.hasNext())
			{
				fileScanner.next();
				count++;
			}
			String[] tubes = new String[count];
			fileScanner = new Scanner(new File(inFile));
			int i = 0;
			while(fileScanner.hasNext())
			{
				tubes[i] = fileScanner.next();
				i++;
			}

			//This part will then go through that array and calculate total volume.
			double total = 0;
			for(int j=2;j<tubes.length;j+=4) //starts at 2 and +4 to ignore tube & ID
			{
				total += (Math.pow(Double.parseDouble(tubes[j]), 2) * Math.PI * Double.parseDouble(tubes[j+1]));
			}
			return total;
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return -1.0; //Should only return -1 if there was an error
	}
}