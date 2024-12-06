/*
 * Written by Lukin Uhte
 */
public class WordHelper{
    public static String[] sortByLength(String[] inputArray){
        String[] copiedStrings = new String[inputArray.length];
        for(int i = 0; i < inputArray.length; i++){ //Copies over inputArray to copiedStrings
            copiedStrings[i] = inputArray[i];
        }
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped = false;
            for(int i = 0; i < copiedStrings.length-1; i++){
                if(copiedStrings[i].length() > copiedStrings[i+1].length()){
                //Swap
                String temp = copiedStrings[i];
                copiedStrings[i] = copiedStrings[i+1];
                copiedStrings[i+1] = temp;
                hasSwapped = true;
            }
        }
    }
        return copiedStrings;
    }

    public static String[] sortByVowels(String[] inputArray){
        String[] copiedStrings = new String[inputArray.length];
        for(int i = 0; i < inputArray.length; i++){ //Copies over inputArray to copiedStrings
            copiedStrings[i] = inputArray[i];
        }
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped = false;
            for(int i = 0; i < copiedStrings.length-1; i++){
                if(countLetters(copiedStrings[i], true) > countLetters(copiedStrings[i+1], true)){
                //Swap
                String temp = copiedStrings[i];
                copiedStrings[i] = copiedStrings[i+1];
                copiedStrings[i+1] = temp;
                hasSwapped = true;
            }
        }
    }
        return copiedStrings;
    }

    public static String[] sortByConsonants(String[] inputArray){ //Copy-pasted from previous method, but changed 'true's to 'false's
        String[] copiedStrings = new String[inputArray.length];
        for(int i = 0; i < inputArray.length; i++){ //Copies over inputArray to copiedStrings
            copiedStrings[i] = inputArray[i];
        }
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped = false;
            for(int i = 0; i < copiedStrings.length-1; i++){
                if(countLetters(copiedStrings[i], false) > countLetters(copiedStrings[i+1], false)){
                //Swap
                String temp = copiedStrings[i];
                copiedStrings[i] = copiedStrings[i+1];
                copiedStrings[i+1] = temp;
                hasSwapped = true;
            }
        }
    }
        return copiedStrings;
    }

    public static int countLetters(String word, boolean vowelCheck){ //One method to count vowels/consonants, only returns what is requested thru vowelCheck
        int vowels = 0;
        int cons = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.toLowerCase().charAt(i) == 'a' || word.toLowerCase().charAt(i) == 'e' || word.toLowerCase().charAt(i) == 'i' || word.toLowerCase().charAt(i) == 'o' || word.toLowerCase().charAt(i) == 'u'){
                vowels++;
            }else{
                cons++;
            }
        }
        if(vowelCheck){
            return vowels;
        }
        return cons; //Else not needed here, if vowelCheck is true, then it will return vowels and stop.
    }
}