import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	
private ArrayList<String> listOfWords;
	
	
	
	/**
	 * The constructor initializes the arrayList and fills it up with the Mesonet Strings
	 * @throws IOException
	 */
	public ReadFile() throws IOException
	{
		listOfWords = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader("Mesonet"));
		String tempString = br.readLine();
		
		while(tempString != null || tempString != "")
		{
			listOfWords.add(tempString);
			tempString = br.readLine();
		}
		br.close();
	}
	
	/**
	 * returns the index of the arrayList
	 * @param index
	 * @return
	 */
	public ArrayList getListOfWords()
	{
		return listOfWords;	
	}

}
