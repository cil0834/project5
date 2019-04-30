import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A Class that reads the mesonet file and determines the hamming distance of the strings.
 * The class sorts the strings into arrays based off of their hamming distance
 * Also the class keeps count of the number of strings with a hamming distance of 0, 1, 2, 3, 4 compared to the chosenWord
 * @author caleb
 *
 */
public class ReadFile {
/**
 * The arrayList containing all of the words in the mesonet file	
 */
private ArrayList<String> listOfWords;

/**
 * hamming distance 0
 */
private int hammingZero;

/**
 * hamming distance 1
 */
private int hammingOne;

/**
 * hamming distance 2
 */
private int hammingTwo;

/**
 * hamming distance 3
 */
private int hammingThree;

/**
 * hamming distance 4
 */
private int hammingFour;

/**
 * arrayList for distance 0
 */
private ArrayList<String> listZero = new ArrayList<String>();

/**
 * arrayList for distance1
 */
private ArrayList<String> listOne = new ArrayList<String>();

/**
 * arrayList for distance 2
 */
private ArrayList<String> listTwo = new ArrayList<String>();

/**
 * arrayList for distance 3
 */
private ArrayList<String> listThree = new ArrayList<String>();

/**
 * arrayList for distance 4
 */
private ArrayList<String> listFour = new ArrayList<String>();

/**
 * arrayList for ascii values that are equal
 */
private ArrayList<String> asciiList;
	
	
	
	/**
	 * The constructor initializes the arrayList and fills it up with all of the words in the mesonetfile
	 * @throws IOException
	 */
	public ReadFile() throws IOException
	{
		listOfWords = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader("Mesonet")); 
		String tempString = br.readLine();
		
		//while there is still a valid word
		while(tempString != null)
		{
			listOfWords.add(tempString);
			tempString = br.readLine(); 
		}
		br.close();
	}
	
	/**
	 * method that determines the hamming distance for each word compared to the chosen word
	 * The method takes the chosen word as an arguement
	 * The other arguement is an arrayList of the words in teh JComboBox
	 * This method also keeps count of the number of words with a hamming distance of 0, 1, 2, 3, 4
	 * This method also adds the strings to their respective arrayList based off of their hammingdistance
	 */
	public void hammingDistances(String word, ArrayList<String> meso)
	{
		hammingZero = 0;
		hammingOne = 0;
		hammingTwo = 0;
		hammingThree = 0;
		hammingFour= 0;
		
		//used to keep count of the distance
		int distance = 0;
		String tempWord = "";
		this.clearList();
		/**
		 * A for loop to iterate through the listOfWords array list. The first for loop resets the distance variable and initializes 
		 * temp word with the next word in listOfWords.
		 * 
		 * The second for loop compares the individual characters of the words annd increments distance if the characters are equal.
		 * After the strings are compared the distances are determined and the temp word is put into its respective arrayList
		 */
		for(int index = 0; index < meso.size(); ++index)
		{
			//temp = tempWord.charAt(index)
			//realChar = word.charAt(index)
			distance = 0;
			tempWord = meso.get(index);
			for (int i = 0; i < tempWord.length(); ++i)
			{
				
				if(word.charAt(i) != tempWord.charAt(i))
				{
					++distance;
				}
			}
			
			if(distance == 0)
			{
				++hammingZero;
				listZero.add(tempWord);
			}
			
			if(distance == 1)
			{
				++hammingOne;
				listOne.add(tempWord); 
			}
			
			if(distance == 2)
			{
				++hammingTwo;
				listTwo.add(tempWord); 
			}
			
			if(distance == 3)
			{
				++hammingThree;
				listThree.add(tempWord); 
			}
			
			if(distance == 4)
			{
				++hammingFour;
				listFour.add(tempWord);
			}
		}
	}
	
	/**
	 * a method that calculates the individual ascii value of a string rounded up
	 * It uses a for loop to add up the total ascii value of the string then it divides by the length of the string
	 * then uses math.ceil to round up
	 * @param word
	 * @return the ascii value rounded up
	 */
	public int calAsciiUp(String word) 
	{
		double value = 0;
		for (int index = 0; index < word.length(); ++index)
		{
			value = value + (double)word.charAt(index);
		}
		
		double average = value/word.length();
		
		int upAverage = (int)Math.ceil(average);
		
		return upAverage;
	}
	
	/**
	 * a method that calculates the individual ascii value of a string rounded down
	 * It uses a for loop to add up the total ascii value of the string then it divides by the length of the string
	 * then uses math.floor to round down
	 * @param word
	 * @return the ascii value rounded down
	 */
	public int calAsciiDown(String word)
	{
		double value = 0;
		for (int index = 0; index < word.length(); ++index)
		{
			value = value + (double)word.charAt(index);
		}
		
		double average = value/word.length();
		
		int downAverage = (int)Math.floor(average);
		
		return downAverage;
	}
	
	/**
	 * returns hamZero
	 */
	public int getHamZero()
	{
		return hammingZero;
	}
	
	/**
	 * returns hamOne
	 */
	public int getHamOne()
	{
		return hammingOne;
	}
	
	/**
	 * returns hamTwo
	 */
	public int getHamTwo()
	{
		return hammingTwo;
	}
	
	/**
	 * returns hamThree
	 */
	public int getHamThree()
	{
		return hammingThree;
	}
	
	/**
	 * returns hamFour
	 */
	public int getHamFour()
	{
		return hammingFour;
	}
	
	/**
	 * return listZero
	 */
	public ArrayList<String> getListZero()
	{
		return listZero;
	}
	
	/**
	 * return listOne
	 */
	public ArrayList<String> getListOne()
	{
		return listOne;
	}
	
	/**
	 * return listTwo
	 */
	public ArrayList<String> getListTwo()
	{
		return listTwo;
	}
	
	/**
	 * return listThree
	 */
	public ArrayList<String> getListThree()
	{
		return listThree;
	}
	
	/**
	 * return listFour
	 */
	public ArrayList<String> getListFour()
	{
		return listFour;
	}
	
	
	/**
	 * returns the index of the arrayList
	 * @param index
	 * @return
	 */
	public ArrayList<String> getListOfWords()
	{
		return listOfWords;	
	}
	
	/**
	 * A method that clears the hamming lists
	 */
	public void clearList()
	{
		listZero = new ArrayList<String>();
		listOne = new ArrayList<String>();
		listTwo = new ArrayList<String>();
		listThree = new ArrayList<String>();
		listFour = new ArrayList<String>();
	}
	
	
	
	

}
