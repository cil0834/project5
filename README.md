# project5

For this project I was tasked with making a GUI menu that could find the hamming distances of Strings.
The GUI must be able to do a few things.

1. The GUI must be able to read in Strings and add them to a list of pre-determined strings. These pre-determined strings are located
in the Mesonet file

2. The menu must be able to count up how many of the strings are a hamming distance of 0, 1, 2, 3, and 4 away

3. The menu must be able to display the strings that are 1, 2, 3, and 4 away.

Onto the classes. There are two classes and a driver class

1. The first class is called ReadFile: This class reads the file and does some calculations to find the hamming distance and ascii
value certain strings.

The read file constructor reads in a file and adds it to an arrayList called listOfWords. 
A method called getListOfWords is used so the arrayList can be use to initialize the arrayList in the FirstPanel class

The next method is called hammingDistances
/**
	 * method that determines the hamming distance for each word compared to the chosen word
	 * The method takes the chosen word as an arguement
	 * The other arguement is an arrayList of the words in teh JComboBox
	 * This method also keeps count of the number of words with a hamming distance of 0, 1, 2, 3, 4
	 * This method also adds the strings to their respective arrayList based off of their hammingdistance
	 */
    
    inside of the hammingDistances method
   /**
		 * A for loop to iterate through the listOfWords array list. The first for loop resets the distance variable and initializes 
		 * temp word with the next word in listOfWords.
		 * 
		 * The second for loop compares the individual characters of the words annd increments distance if the characters are equal.
		 * After the strings are compared the distances are determined and the temp word is put into its respective arrayList
		 */

The next method is calAsciiUp
/**
	 * a method that calculates the individual ascii value of a string rounded up
	 * It uses a for loop to add up the total ascii value of the string then it divides by the length of the string
	 * then uses math.ceil to round up
	 * @param word
	 * @return the ascii value rounded up
	 */
  
The next method is calAsciiDown
/**
	 * a method that calculates the individual ascii value of a string rounded down
	 * It uses a for loop to add up the total ascii value of the string then it divides by the length of the string
	 * then uses math.floor to round down
	 * @param word
	 * @return the ascii value rounded down
	 */

There are private variables that are ints called
hammingZero hammingOne, hammingTwo, hammingThree, hammingFour 
These private variables are in FirstPanel specifically in the JTextBoxes to represent the hamming distances of the selected words

There are also private ArrayList<String> variables 
listZero ... listFour
These list are used by the JTextArea so the strings with the respective hamming distances in relation to the choesn word can
be shown
  
The method ClearList is used to clear all of the arrayList listZero ... listFour
This method is used in the hammingDistances method so that when a new word is choesn the arrayLists reset and don't show incorrect
values in the strings

The asciiValues method takes in the chosen word which is the word in the 


The second class is the FirstPanel class. It was named FirstPanel, because a second panel was planned but it never happened.

There are two sections to the first panel.

The first section deals solely with calculating the hamming distance of a chosen word and with showing the words in the 
JComboBox's hamming distance in relation to the chosen word.

The second section hasa box that sends out an error message if something wrong was done.
Below the error box there are various components that do variou the ascii value of the string in the JComboBox

The first part of the panel is the JLabel that says "Enter Hamming Dist:"
Next to that component is a JTextField that represents the value of the JSlider under it.
The JSlider can be moved to change the value of the JTextField, and when the Show Station button under it is hit
the strings with a hamming distance of the value in the JTextField in relation to the String in the JComboBox are displayed
If the Show Station button is hit before there is a value in JTextField is assigned an error message is displayed in the 
error JTextField

The JComboBox holds all of the strings in the file that is read. However new strings can be added by using the JTextField
next to the Add Station button. Only strings that are 4 characters long contain capital letters only and are not already
present in the JComboBox can added. If someone attempts to add an invalid string an error is displayed in the error box. 

The Calculate HD Button displays the number of strings in the JComboBox with a hamming distance of 0, 1, 2, 3, 4 compared to the
selected String. 
The value of the hamming distances can be changed by selecting a new String and recalculating.









![alt text](https://github.com/cil0834/project5/blob/master/Untitled%20Diagram%20(2).png)
