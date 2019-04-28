import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    /*
	 * Making the actual frame
	 */
	 private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FirstPanel fp = new FirstPanel();
        frame.add(fp);
        //Set up the content pane.
        
        //Display the window.
        frame.pack();
        frame.setVisible(true); 
	    }
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		createAndShowGUI();
	}

}
