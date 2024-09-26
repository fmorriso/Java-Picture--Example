import javax.swing.JColorChooser;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A class to make working with a color chooser easier for students. It uses a
 * JColorChooser to let the user pick a color and returns the chosen color
 * object.
 * 
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class ColorChooser {

	/**
	 * Method to let the user pick a color and return the color object.
	 * 
	 * @return the picked color or red if no color was picked
	 */
	public static Color pickAColor() {
		Color color = Color.white;

		// capture size of screen we're using
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// use a portion of the screen for the JFrame
		Dimension frameSize = new Dimension(screenSize.width * 3 / 5, screenSize.height * 3 / 5);
				
		// create a JFrame to be the parent of the color chooser open dialog
		// if you don't do this then you may not see the dialog.
		JFrame frame = new JFrame("Color Chooser");
		//frame.setPreferredSize(frameSize);
		//frame.setSize(frameSize);
		frame.setAlwaysOnTop(true);
		
		/*JPanel pnl = new JPanel();
		
		//DO NOT DO THIS BECAUSE IT PUTS TWO DIALOGS ON THE PANEL: pnl.add(chooser);
		frame.getContentPane().add(pnl, BorderLayout.CENTER);
		frame.pack();

		// put the JFrame in the middle of the physical screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
*/
		// use the color chooser to pick the color
		JColorChooser chooser = new JColorChooser();
		//chooser.setSize(frameSize);
		//chooser.invalidate();
		//chooser.setPreviewPanel(pnl);
		// public AbstractColorChooserPanel[] getChooserPanels()
		//AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
		color = chooser.showDialog(frame, "Pick a color", color);

		return color;
	}

	/** Main method for testing the ColorChooser */
	public static void main(String[] args) {
		Color pickedColor = ColorChooser.pickAColor();
		System.out.println(pickedColor);
	}

}
