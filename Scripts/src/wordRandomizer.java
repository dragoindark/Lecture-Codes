import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class wordRandomizer {

	
	public static String[] wordRandom(String word) {
		String[] randomizedWords=new String[(int) Math.pow(word.length(), word.length())];
		int arrayIndex=0;
		for(int k=0;k<word.length();k++) {
			String randomWord=word;
			for(int l=0;l<word.length();l++) {
				for(int i=0;i<word.length();i++) {
					StringBuilder newWordToAdd=new StringBuilder(randomWord);
					newWordToAdd.setCharAt(l,word.charAt(i));
					randomizedWords[arrayIndex]=newWordToAdd.toString();
					arrayIndex++;
				}
			}
		}
		LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>(Arrays.asList(randomizedWords));
		String[] noDuplicate=linkedHashSet.toArray(new String[] {});
		return noDuplicate;
	}
	
	public static void main(String args[]) {
		System.out.println("Please enter a word to randomize");
		Scanner input=new Scanner(System.in);
		
		String newWord=input.nextLine();
		
		String[] randomWords=wordRandom(newWord);
		
		for(int i=0;i<randomWords.length;i++) {
			System.out.println(randomWords[i]);
		}
	}
}

/*
String[] randomizedWords=new String[(int) Math.pow(word.length(), word.length())];
		int arrayIndex=0;
		for(int i=0;i<word.length();i++) {
			String wordToAdd=word;
			for(int k=0;k<word.length();k++) {
					for(int l=0;l<word.length();l++) {
						StringBuilder newWordToAdd=new StringBuilder(wordToAdd);
						newWordToAdd.setCharAt(k, word.charAt(l));
						wordToAdd.replace(wordToAdd.substring(k),word.substring(l));
						randomizedWords[arrayIndex]=newWordToAdd.toString();
						arrayIndex++;
					}
			}
		}
		System.out.println(arrayIndex);
		return randomizedWords;
 */

