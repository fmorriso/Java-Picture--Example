import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
//
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;

public class ImageDisplayExample extends JFrame implements Runnable {
    private final Dimension frameSize;

    /**
     * @param title - The title to be used by the JFrame that we are creating.
     * @param size - A Dimension that helps us scale the JFrame based on available device size.
     * @throws HeadlessException
     */
    public ImageDisplayExample(String title, Dimension size) throws HeadlessException {
        super(title);
        this.frameSize = size;
    }

    /**
     * Runs thiS GUI on a thread.
     */
    @Override
    public void run() {
        Image img = getScaledImage("images/beach.jpg",0.9);
        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);

        getContentPane().add(label);
        setSize(this.frameSize);
        setPreferredSize(this.frameSize);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // causes JFrame to be centered
        setVisible(true);
    }

    /** Gets a scaled Image
     * @param pct - a value > 0.0 and < 1.0 that will be used to scale the the image
     *            based on the previously saved parent JFrame's size.
     * @return Image - scaled to the desired percentage of the parent JFrame's dimension.
     */
    private Image getScaledImage(String pathToImage, double pct) {
        // do some sanity checks
        if(pct <= 0 || pct > 1) {
            throw new IllegalArgumentException("Percentages must be between 0 and 1");
        }
        File f = new File(pathToImage);
        if (!f.exists()) {
            throw new IllegalArgumentException("Image file " + pathToImage + " does not exist");
        }
        // if we get this far, we should be relatively certain the rest of this method will work correctly.
        System.out.format("image absolute path: %s%n", f.getAbsolutePath());
        ImageIcon icon = new ImageIcon(f.getAbsolutePath());
        Image original = icon.getImage();
        // scale the image to fit inside previously scaled JFrame
        Dimension scaledSize = new Dimension((int) (this.frameSize.width * pct), (int) (this.frameSize.height * pct));
        System.out.format("Image (w, h): (%d,%d)%n", scaledSize.width, scaledSize.height);
        // give caller the scaled Image instance.
        return original.getScaledInstance(scaledSize.width, scaledSize.height, Image.SCALE_SMOOTH);
    }

}
