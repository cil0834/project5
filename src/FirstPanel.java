import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FirstPanel extends JPanel{
	
	//the word that is being added
	private String chosenWord = "";
	//ArrayList of mesoNet file
	//ArrayList<String> meso;
	
	
	private JTextField stationAdd;
	private JButton addStation;
	private JComboBox comparedStrings;
	
	
	public FirstPanel()
	{	/*
		ReadFile file = new ReadFile();
		meso = file.getListOfWords();
		*/
		//set up the hamming label
		this.setLayout(new GridBagLayout());
		this.setLocation(0, 0);
		GridBagConstraints constraints = null;
		
		//set constraints for hamLabel
		JLabel hamLabel = new JLabel("Enter Hamming Dist:");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(hamLabel, constraints);
		
		//set constraints for hamming input
		JTextField hamInput = new JTextField(12);
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		hamInput.setEditable(false);
		constraints.insets = new Insets(10, 1, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.add(hamInput, constraints);
		
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
		this.add(slider, constraints);		
		
		//the showStation button
		JButton showStation = new JButton("Show Station");
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new  Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(showStation, constraints);
		
		//JTextArea
		JTextArea textArea = new JTextArea(20, 20);
		//TODO add action listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 20, 10, 5);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		this.add(textArea, constraints);
		
		//JLabel for compare with dropdown
		JLabel compare = new JLabel("Compare with:");
		//TODO add button listener
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(20, 5, 20, 1);
		constraints.gridx = 0;
		constraints.gridy = 4;
		this.add(compare, constraints);
		
		//JComboBox
		comparedStrings = new JComboBox();
		//TODO set up combobox
		String tempString = "";
		/*for (int index = 0; index < meso.size(); ++index)
		{
			tempString = meso.get(index);
			comparedStrings.addItem(tempString);
		}
		*/
		comparedStrings.addItem(chosenWord);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(15, 1, 15, 1);
		constraints.gridx = 1;
		constraints.gridy = 4;
		this.add(comparedStrings, constraints);
	
		//Calculate button
		JButton calculate = new JButton("Calculate HD");
		//TODO make calculate button work
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 15, 0);
		constraints.gridx = 0;
		constraints.gridy = 5;
		this.add(calculate, constraints);
	
		//JLabel0
		JLabel label0 = new JLabel("Distance 0");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 6;
		this.add(label0, constraints);
		
		//JLabel1
		JLabel label1 = new JLabel("Distance 1");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 7;
		this.add(label1, constraints);
		
		//JLabel2
		JLabel label2 = new JLabel("Distance 2");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 8;
		this.add(label2, constraints);
		
		//JLabel3
		JLabel label3 = new JLabel("Distance 3");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 9;
		this.add(label3, constraints);
		
		//JLabel4
		JLabel label4 = new JLabel("Distance 4");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 20);
		constraints.gridx = 0;
		constraints.gridy = 10;
		this.add(label4, constraints);
		
		//JTextField0
		JTextField textField0 = new JTextField(12);
		textField0.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 6;
		this.add(textField0, constraints);
		
		//JTextField1
		JTextField textField1 = new JTextField(12);
		textField1.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 7;
		this.add(textField1, constraints);
		
		//JTextField2
		JTextField textField2 = new JTextField(12);
		textField2.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 8;
		this.add(textField2, constraints);
		
		//JTextField3
		JTextField textField3 = new JTextField(12);
		textField3.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 9;
		this.add(textField3, constraints);
		
		//JTextField4
		JTextField textField4 = new JTextField(12);
		textField4.setEditable(false);
		//TODO
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 20, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 10;
		this.add(textField4, constraints);
		
		//add station button
		addStation = new JButton("Add Station");
		//TODO set the station button
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
		JLabel test = new JLabel("You are free to put what ever you want here");
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10 ,10);
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.gridwidth= 3;
		this.add(test, constraints);
		
		
		}
	 public class addWord implements ActionListener {
        public void actionPerformed(ActionEvent e) {
    	chosenWord = stationAdd.getText();
    	Calculation calc = new Calculation();
    	boolean valid = calc.validString(chosenWord);
    	if (valid) {
    	comparedStrings.addItem(stationAdd.getText()); //Removed .toString() because it returns a string.
    	}
        }
	    }
	
}
