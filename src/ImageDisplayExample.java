import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageDisplayExample extends JFrame implements Runnable {
    private Dimension frameSize;
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
        this.frameSize = size;

    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        Image img = getScaledImage(0.9);
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
//        label.setSize(frameSize);
        getContentPane().add(label);
        setSize(this.frameSize);
        setPreferredSize(this.frameSize);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Image getScaledImage(double pct) {
        File f = new File("images/beach.jpg");
        System.out.format("image absolute path: %s%n", f.getAbsolutePath());
        ImageIcon icon = new ImageIcon(f.getAbsolutePath());
        Image original = icon.getImage();
        Dimension scaledSize = new Dimension((int) (this.frameSize.width * pct), (int) (this.frameSize.height * pct));
        System.out.format("Image (w, h): (%d,%d)%n", scaledSize.width, scaledSize.height);
        Image scaled = icon.getImage().getScaledInstance(scaledSize.width, scaledSize.height, Image.SCALE_SMOOTH);
        return scaled;
    }

}
