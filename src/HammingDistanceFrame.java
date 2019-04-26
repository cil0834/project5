import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*
 * A class that makes a Frame that can be used to calculate various things about the hamming distances of words
 */
public class HammingDistanceFrame extends JFrame{

	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	//the tp left label for the hamming distance
   // private JLabel hamLabel;
    //the text field for the input
    //private JTextField haminput;
    //the slider
    //private JSlider slider;
    //the show station button
    //private JButton showStation;
    //the text area for all of the stations
   // private JTextArea textArea;
    //a text label for to compare
  //  private JLabel compare;
    //button to calculate hamming Distance
    //private JButton calculateHammindDist;
    //label for distance 
    private JLabel distance0;
    //text box for distance 0
    private JTextField distanceZero;
    private JLabel distance1;
    private JTextField distanceOne;
    private JLabel distance2;
    private JTextField distanceTwo;
    private JLabel distance3;
    private JTextField distanceThree;
    private JLabel distance4;
    private JTextField distanceFour;
    //button to add station
    private JButton addStation;
    //text field to input added station
    private JButton inputStation;
    
    
    
    /*
     * The panel that holds all of the project's requirements
     */
	public static void firstPanel(Container panel)
	{
		//set up the hamming label
		panel.setLayout(new GridBagLayout());
		panel.setLocation(0, 0);
		GridBagConstraints constraints = null;
		
		//set constraints for hamLabel
		JLabel hamLabel = new JLabel("Enter Hamming Dist:");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(hamLabel, constraints);
		
		//set constraints for hamming input
		JTextField hamInput = new JTextField(12);
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		hamInput.setEditable(false);
		constraints.insets = new Insets(10, 1, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(hamInput, constraints);
		
		//the slider
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 4, 2);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 1, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		panel.add(slider, constraints);		
		
		//the showStation button
		JButton showStation = new JButton("Show Station");
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new  Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(showStation, constraints);
		
		//JTextArea
		JTextArea textArea = new JTextArea(20, 20);
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 20, 10, 5);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		panel.add(textArea, constraints);
		
		//JLabel for compare with dropdown
		JLabel compare = new JLabel("Compare with:");
		//TODO add button listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(20, 5, 20, 1);
		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(compare, constraints);
		
		//JComboBox
		String[] comparison = new String[50];
		JComboBox comparedStrings = new JComboBox(comparison);
		comparedStrings.setPrototypeDisplayValue("text here");
		//TODO set up combobox
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 1, 15, 1);
		constraints.gridx = 1;
		constraints.gridy = 4;
		panel.add(comparedStrings, constraints);
	
		//Calculate button
		JButton calculate = new JButton("Calculate HD");
		//TODO make calculate button work
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 15, 0);
		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(calculate, constraints);
	
		//JLabel0
		JLabel label0 = new JLabel("Distance 0");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 6;
		panel.add(label0, constraints);
		
		//JLabel1
		JLabel label1 = new JLabel("Distance 1");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 7;
		panel.add(label1, constraints);
		
		//JLabel2
		JLabel label2 = new JLabel("Distance 2");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 8;
		panel.add(label2, constraints);
		
		//JLabel3
		JLabel label3 = new JLabel("Distance 3");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 9;
		panel.add(label3, constraints);
		
		//JLabel4
		JLabel label4 = new JLabel("Distance 4");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 10;
		panel.add(label4, constraints);
		
		//JTextField0
		JTextField textField0 = new JTextField(12);
		textField0.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 6;
		panel.add(textField0, constraints);
		
		//JTextField1
		JTextField textField1 = new JTextField(12);
		textField1.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 7;
		panel.add(textField1, constraints);
		
		//JTextField2
		JTextField textField2 = new JTextField(12);
		textField2.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 8;
		panel.add(textField2, constraints);
		
		//JTextField3
		JTextField textField3 = new JTextField(12);
		textField3.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 9;
		panel.add(textField3, constraints);
		
		//JTextField4
		JTextField textField4 = new JTextField(12);
		textField4.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 10;
		panel.add(textField4, constraints);
		
		//add station button
		JButton addStation = new JButton("Add Station");
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 20, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 11;
		panel.add(addStation, constraints);
		
		//add station textField
		JTextField stationAdd = new JTextField(12);
		stationAdd.setEnabled(true);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 11;
		panel.add(stationAdd, constraints);
		
			
	}

	
	
    
    
    /*
	 * Making the actual frame
	 */
	 private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        //frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));

        //Set up the content pane.
        firstPanel(frame.getContentPane());
        //secondPanel(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createAndShowGUI();
	}

}
