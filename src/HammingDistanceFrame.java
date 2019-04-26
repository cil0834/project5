import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * A class that makes a Frame that can be used to calculate various things about the hamming distances of words
 */
public class HammingDistanceFrame extends JFrame{

	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
    
	public static void addComponents(Container pane)
	{
		
		if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
		pane.setSize(300, 1200);
	    JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//if (shouldFill) {
		//natural height, maximum width
		//c.fill = GridBagConstraints.HORIZONTAL;
		//}
	
		JLabel label = new JLabel("Button 1");
		if (shouldWeightX) {
		c.weightx = 0;
		}
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 10, 10);
		pane.add(label, c);
	
		JTextField text = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.05;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(text, c);
	
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
        addComponents(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createAndShowGUI();
	}

}
