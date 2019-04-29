import java.io.IOException;
import java.util.ArrayList;

public class Calculation {
	/**
	 * An arrayList that keeps track of what words have been added
	 */
	ArrayList<String> wordList;
	
	/**
	 * A class that checks to see if a word is valid or not
	 * The class is also used to see calculate the hamming distance of various strings
	 */
	public Calculation()
	{
	}
	
	/**
	 * This method takes in a string and checks to make sure that string is valid. If the string is not valid false is returned
	 * otherwise true is returned 
	 * An invalid string is any string that is more than 4 characters, contains characters other than capital letters, and finally
	 * any string that is a duplicate.
	 * this method is to be used by the add station button to make sure the string is right
	 * @throws IOException 
	 */
	public boolean validString(String word) throws IOException
	{
		ReadFile file = new ReadFile();
		wordList = file.getListOfWords();		
		
		if (word.length() != 4)
		{
			return false;
		}
		
		for(int index = 0; index < wordList.size(); ++index)
		{
			if(word.equals(wordList.get(index)))
			{
				return false;
			}
		}
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!(c >= 'A' && c <= 'Z'))
			{
				return false;
			}
		}
		wordList.add(word);
		return true;
	}
}