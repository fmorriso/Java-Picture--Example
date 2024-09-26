import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorChooserExample extends JFrame implements ActionListener {
	JButton b;
	Container c;
	ColorChooserExample() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// use a portion of the screen for the JFrame
		Dimension frameSize = new Dimension(screenSize.width * 3 / 5, screenSize.height * 3 / 5);

		c = getContentPane();
		c.setSize(frameSize);
		c.setLayout(new FlowLayout());
		b = new JButton("color");
		b.addActionListener(this);
		c.add(b);
	}
	public void actionPerformed(ActionEvent e) {
		Color initialcolor = Color.RED;
		Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
		c.setBackground(color);
	}

	public static void main(String[] args) {
		ColorChooserExample ch = new ColorChooserExample();
		ch.setSize(1200, 1200);
		ch.setVisible(true);
		ch.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
