import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageDisplayExample extends JFrame  {

    /**
     * Creates a new, initially invisible <code>Frame</code> with the
     * specified title.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @param title the title for the frame
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public ImageDisplayExample(String title, Dimension size) throws HeadlessException {
        super(title);
        // Create an instance of ImageIcon with the path to the image file
        File f = new File("images/beach.jpg");
        System.out.format("image absolute path: %s%n", f.getAbsolutePath());
        ImageIcon icon = new ImageIcon(f.getAbsolutePath());
        JLabel label = new JLabel(icon);
        getContentPane().add(label);
        setSize(size);
        setPreferredSize(size);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
