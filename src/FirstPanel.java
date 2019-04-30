import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * A class that represents the first and possibly only panel in the jFrame. 
 * The panel does various things with the mesonet strings.
 * Using various components the strings in the Mesonet file have their hamming distance and their average ascii values compared.
 * @author caleb
 *
 */
public class FirstPanel extends JPanel{
	
	//The word that is being added
	private String writenWord = "";
	
	//The word selected by the JComboBox
	private String chosenWord = "";
	
	//Object that reads an object
	private ReadFile file = new ReadFile(); 
	
	//ArrayList of mesoNet file
	private ArrayList<String> meso = file.getListOfWords();
	
	//ArrayList that holds the strings with a hamming distance of 0
	private ArrayList<String> arrayZero;
	
	//ArrayList that holds the strings with a hamming distance of 1
	private ArrayList<String> arrayOne;
	
	//ArrayList that holds the strings with a hamming distance of 2 
	private ArrayList<String> arrayTwo;
	
	//ArrayList that holds the strings with a hamming distance of 3
	private ArrayList<String> arrayThree;
	
	//ArrayList that holds the strings with a hamming distance of 4
	private ArrayList<String> arrayFour;
	
	
	//a boolean used to see if a string is valid
	private boolean valid = true;
	
	
	//The label that says "Enter Hammind Dist:"
	private JLabel hamLabel;
	
	//The JTextField that represents the value of the JSlider 1-4
	private JTextField hamInput;
	
	//The JSlider that affects the hamInput and whose value is used to decide what strings the textArea box shows. 
	//The slider has values 1-4, which represent the hamming distance of strings.
	private JSlider slider; 
	
	//The button that actually decides when the textArea shows the strings
	private JButton showStation; 
	
	//The text area that shows the strings that have the specified hamming distance according to the JSlider's value
	private JTextArea textArea; 
	
	private JScrollPane sp; 
	
	//A JLabel that says "Compare with"
	private JLabel compare; 
	
	//A combobox that holds the string values that are compared and can be compared with each other
	private JComboBox<String> comparedStrings;
	
	//The calculate button that when pressed calculates the hamming distance that each string has when compared with the chosen string
	//The values are then added up and the total number of strings with a hamming distance of 0-4 can be seen in their respective boxes
	private JButton calculate;
	
	//A label that says "Distance 0"
	private JLabel label0;
	
	//A label that says "Distance 1"
	private JLabel label1;
	
	//A label that says 'Distance 2"
	private JLabel label2;
	
	//A label that says "Distance 3"
	private JLabel label3;
	
	//A label that says "Distance 4"
	private JLabel label4;
	
	//A JTextField that has the number of strigs with a hamming distance of 0 when compared to the chosen string
	private JTextField textField0;
	
	//A JTextField that has the number of strigs with a hamming distance of 1 when compared to the chosen string
	private JTextField textField1;
	
	//A JTextField that has the number of strigs with a hamming distance of 2 when compared to the chosen string
	private JTextField textField2;
	
	//A JTextField that has the number of strigs with a hamming distance of 3 when compared to the chosen string
	private JTextField textField3;
	
	//A JTextField that has the number of strigs with a hamming distance of 4 when compared to the chosen string
	private JTextField textField4;
	
	//A button that when pressed takes the value of the stationAdd TextField and adds it to the JComboBox if the string is valid
	private JButton addStation;
	
	//A TextField where the user can input a string if valid
	private JTextField stationAdd;
	
	//A TextField that says if the string is valid or not
	private JTextField validTextBox;
	
	//A JLabel that says "Valid word:"
	private JLabel test;
	
	//A JButton that calculates the ascii Value
	private JButton getString;
	
	//A TextBox to input a string
	private JTextField asciiBox;
	
	//JLabel to that says "Ascii word"
	private JLabel ascii;
	
	//A TextArea with all of the strings that share said ascii value
	private JTextArea asciiArea;
	
	//A JButton that finds the ascii value of the String in asciiBox
	private JButton calculateAscii;
	
	//JLabel that says asciiValue Round Up
	private JLabel up;
	
	//JLabel that says Rounded Down
	private JLabel down;
	
	
	//JTextField for rounded up
	private JTextField roundUp;
	
	//JTextField for rounded down
	private JTextField roundDown;
	
	
	public FirstPanel() throws IOException
	{	
		//set up the hamming label
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		//set constraints for hamLabel
		hamLabel = new JLabel("Enter Hamming Dist:");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(hamLabel, constraints);
		
		//set constraints for hamming input
		hamInput = new JTextField(12);
		
		constraints = new GridBagConstraints();
		hamInput.setEditable(false);
		constraints.insets = new Insets(10, 1, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.add(hamInput, constraints);
		
		//the slider
		slider = new JSlider(JSlider.HORIZONTAL, 1, 4, 2);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		//TODO add action listener
		 slider.addChangeListener(new ChangeListener(){
	            @Override
	            public void stateChanged(ChangeEvent e) {
	               hamInput.setText(String.valueOf(slider.getValue()));
	            }
	        });
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 1, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		this.add(slider, constraints);		
		
		//the showStation button
		showStation = new JButton("Show Station");
		//TODO add action listener
		showStation.addActionListener(new showStation());
		
		constraints = new GridBagConstraints();
		constraints.insets = new  Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(showStation, constraints);
		 
		//JTextArea
		textArea = new JTextArea(5, 10);
		textArea.setEditable(false);
		sp = new JScrollPane(textArea);
		this.add(sp);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 20, 10, 5);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		this.add(sp, constraints);
		
		//JLabel for compare with dropdown
		compare = new JLabel("Compare with:");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(20, 5, 20, 1);
		constraints.gridx = 0;
		constraints.gridy = 4;
		this.add(compare, constraints);
	
		//JComboBox
		comparedStrings = new JComboBox<String>();
		//TODO set up combobox
		
		//for loop that adds the strings to the jcombobox
		for(int index = 0; index < meso.size(); ++index)
		{
		comparedStrings.addItem(meso.get(index));
		}
		//comparedStrings.addItem(writenWord);
	
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 1, 15, 1);
		constraints.gridx = 1;
		constraints.gridy = 4;
		this.add(comparedStrings, constraints);
	
		//Calculate button
		calculate = new JButton("Calculate HD");
		//TODO make calculate button work
		calculate.addActionListener(new calculateHD());
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 15, 0);
		constraints.gridx = 0;
		constraints.gridy = 5;
		this.add(calculate, constraints);
	
		//JLabel0
		label0 = new JLabel("Distance 0");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 6;
		this.add(label0, constraints);
		
		//JLabel1
		label1 = new JLabel("Distance 1"); 
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 7;
		this.add(label1, constraints);
		
		//JLabel2
		label2 = new JLabel("Distance 2");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 8;
		this.add(label2, constraints);
		
		//JLabel3
		label3 = new JLabel("Distance 3");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 9;
		this.add(label3, constraints);
		
		//JLabel4
		label4 = new JLabel("Distance 4");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 10;
		this.add(label4, constraints);
		
		//JTextField0
		textField0 = new JTextField(12);
		textField0.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 6;
		this.add(textField0, constraints);
		
		//JTextField1
		textField1 = new JTextField(12);
		textField1.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 7;
		this.add(textField1, constraints);
		
		//JTextField2
		textField2 = new JTextField(12);
		textField2.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 8;
		this.add(textField2, constraints);
		
		//JTextField3
		textField3 = new JTextField(12);
		textField3.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 9;
		this.add(textField3, constraints);
		
		//JTextField4
		textField4 = new JTextField(12);
		textField4.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 10;
		this.add(textField4, constraints);
		
		//add station button
		addStation = new JButton("Add Station");
		//TODO
		addStation.addActionListener(new addWord());
		
		
				
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 20, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 11;
		this.add(addStation, constraints);
		
		
		//add station textField
		stationAdd = new JTextField(12);
		stationAdd.setEnabled(true);
		//TODO add action listener
		chosenWord = addStation.getText();
			
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 11;
		this.add(stationAdd, constraints);
		
		//the error message
		test = new JLabel("Valid word");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10 ,10);
		constraints.gridx = 3;
		constraints.gridy = 0;
		this.add(test, constraints); 
		
		//The text box that reports an error
		validTextBox = new JTextField(12);
		validTextBox.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 4;
		constraints.gridy = 0;
		this.add(validTextBox, constraints);
		
		//AsciiValue button
		getString = new JButton("Get String");
		getString.addActionListener(new getWord());
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		this.add(getString, constraints);
		
		//TextField where string is held
		asciiBox = new JTextField(12);
		asciiBox.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 4;
		constraints.gridy = 2;
		this.add(asciiBox, constraints);
		
		//label to clarify what is in the asciiBox
		ascii = new JLabel("Ascii Word:");
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 3;
		constraints.gridy = 2;
		this.add(ascii, constraints);
		
		//JButton that calculates ascii value
		calculateAscii = new JButton("Calculate Ascii Value");
		calculateAscii.addActionListener(new getAsciiAverages());
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 3;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		this.add(calculateAscii, constraints);
		
		//JLabel that says round up
		up = new JLabel("Rounded up:");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 3;
		constraints.gridy = 4;
		this.add(up, constraints);
		
		//JLabel that says round down
		down = new JLabel("Rounded down:");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 3;
		constraints.gridy = 5;
		this.add(down, constraints);
		
		//round up textField
		roundUp = new JTextField(12);
		roundUp.setEditable(false);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 4;
		constraints.gridy = 4;
		this.add(roundUp, constraints);
		
		//round down textField
		roundDown = new JTextField(12);
		roundDown.setEditable(false);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 4;
		constraints.gridy = 5;
		this.add(roundDown, constraints);
		}
	
	
	/**
	 * The button for the showStation it takes the value of the JTextField hamInput
	 * It then shows the Strings with that hamming distance value compared to chosenWord
	 * The hamInput is taken and then if loops are used to decide which arrayList to iterate through.
	 */
	
	public class showStation implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//setHam input text to an int
			int input = slider.getValue();
			String text = "";
			String tempString ="";
			//shows strings with hamming distance of one
			if(input == 1)
			{
				for(int index = 0; index < arrayOne.size(); ++index)
				{
					//textArea.setText(arrayOne.get(index));
					tempString = arrayOne.get(index);
					text = text + tempString + "\n";
				}
				textArea.setText(text);
			}
			
			//shows strings with hamming distance of two
			if(input == 2)
			{
				for(int index = 0; index < arrayTwo.size(); ++index)
				{
					//textArea.setText(arrayTwo.get(index));
					tempString = arrayTwo.get(index);
					text = text + tempString + "\n";
				}
				textArea.setText(text);
			}
			
			//shows strings with hamming distance of three
			if(input == 3)
			{
				for(int index = 0; index < arrayThree.size(); ++index)
				{
					//textArea.setText(arrayThree.get(index));
					tempString = arrayThree.get(index);
					text = text + tempString + "\n";
				}
				textArea.setText(text);
			}
			
			//shows strings with hamming distance of four
			if(input == 4)
			{
				for(int index = 0; index < arrayFour.size(); ++index)
				{
					//textArea.setText(arrayFour.get(index));
					tempString = arrayFour.get(index);
					text = text + tempString + "\n";
				}
				textArea.setText(text);
			}
		}
	}
	
	
	
	/**
	 * The button for the JButton calculate
	 * It calculates the hamming distance between the chosen string in the JComboBox and it assigns the number of strings that
	 * have a hamming distance of 0, 1, 2, 3, 4 and it puts them in their respective boxes
	 * It also finds finds the strings and adds them to their respective arrayLists
	 * @author caleb
	 *
	 */
	
	public class calculateHD implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			chosenWord = (String) comparedStrings.getSelectedItem();
			file.hammingDistances(chosenWord, meso);
			
			// set the text fields with their values
			textField0.setText(Integer.toString(file.getHamZero()));
			textField1.setText(Integer.toString(file.getHamOne()));
			textField2.setText(Integer.toString(file.getHamTwo()));
			textField3.setText(Integer.toString(file.getHamThree()));
			textField4.setText(Integer.toString(file.getHamFour()));
			
			//set the arrays as well
			arrayZero = file.getListZero();
			arrayOne = file.getListOne();
			arrayTwo = file.getListTwo();
			arrayThree = file.getListThree();
			arrayFour = file.getListFour();
		}
	};
	
	
	
	
	/**
	 * The actionLitener for the addStation button that adds a word to the JComboBox only if the word is 4 characters long and capitalized
	 * The validTextBox is set to "Valid String" if added correctly other wise it is set to "Invalid String"
	 * @author caleb
	 *
	 */
	 public class addWord implements ActionListener {
        public void actionPerformed(ActionEvent e) {
    	writenWord = stationAdd.getText();
    	valid = valid(writenWord);
    	if (valid) {
    	meso.add(writenWord);
    	Collections.sort(meso);
    	comparedStrings.removeAllItems();
    	for(int index = 0; index < meso.size(); ++index)
		{
		comparedStrings.addItem(meso.get(index));
		}
    	//comparedStrings.addItem(stationAdd.getText());
    	validTextBox.setText("Valid String");
    	//meso.add(writenWord);
    	}
    	if(!valid)
    	{
    		validTextBox.setText("Invalid String");
    	}
        }
	 }
	 
	 /**
	  * A button that when pressed takes the word in the JComboBox and puts it in the JTextField asciiBox
	  * @author caleb
	  *
	  */
	 public class getWord implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	       asciiBox.setText((String)comparedStrings.getSelectedItem());
	        }
	       	}
	 
	 public class getAsciiAverages implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	String word = asciiBox.getText();
	        	
	        	int up = file.calAsciiUp(word);
	        	int down = file.calAsciiDown(word);
	        	
	        	roundUp.setText(Integer.toString(up));
	        	roundDown.setText(Integer.toString(down));
	        }
	 		}
	 
	 /**
	  * A method that test if a word is valid
	  * @param word
	  * @return whether the string is valid or not
	  */
	 public boolean valid(String word)
	 {
		 if (word.length() != 4)
			{
				return false;
			}
			
			for(int index = 0; index < meso.size(); ++index)
			{
				if(word.equals(meso.get(index)))
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
			return true;
	 }
	 
}
