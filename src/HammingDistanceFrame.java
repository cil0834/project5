import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
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
    private JLabel compare;
    //button to calculate hamming Distance
    private JButton calculateHammindDist;
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
		//TODO add action listener
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(hamLabel, constraints);
		
		//set constraints for hamming input
		constraints = new GridBagConstraints();
		JTextField hamInput = new JTextField(10);
		//TODO add action listener
		hamInput.setEditable(false);
		constraints.insets = new Insets(10, 1, 10, 10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(hamInput, constraints);
		
		//the slider
		constraints = new GridBagConstraints();
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 4, 2);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		//TODO add action listener
		constraints.insets = new Insets(5, 1, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		panel.add(slider, constraints);		
		
		//the showStation button
		constraints = new GridBagConstraints();
		JButton showStation = new JButton("Show Station");
		//TODO add action listener
		constraints.insets = new  Insets(10, 5, 10, 1);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(showStation, constraints);
		
		//JTextArea
		constraints = new GridBagConstraints();
		JTextArea textArea = new JTextArea(20, 20);
		//TODO add action listener
		constraints.insets = new Insets(5, 5, 10, 5);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		panel.add(textArea, constraints);
		
	}
	
	
	
	
	/*
	 * Making the actual frame
	 */
	 private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setSize(600, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        firstPanel(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createAndShowGUI();
	}

}
