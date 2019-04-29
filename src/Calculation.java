public class Calculation {
	/**
	 * A class that checks to see if a word is valid or not. 
	 * The class is also used to see calculate the hamming distance of various strings
	 */
	public Calculation()
	{
	}
	
	/**
	 * This method takes in a string and checks to make sure that string is valid. If the string is not valid false is returned
	 * otherwise true is returned 
	 * this method is to be used by the add station button to make sure the string is right
	 */
	public boolean validString(String word)
	{
		if (word.length() != 4)
		{
			return false;
		}
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!(c >= 'A' && c <= 'Z'))
			{
				return false;
			}
		}
		return true;
	}
}