import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class Main {
  public static void main(String[] args) {
    String title = String.format("Java Picture Scaling Demo using java version %s", getJavaVersion());
    System.out.println(title);
    Dimension scaledSize = SwingScreenUtilities.getScaledSize(0.55, 100);

    ImageDisplayExample gui = new ImageDisplayExample(title, scaledSize);
    SwingUtilities.invokeLater(gui);
  }


  /** get the java version that is running the current program
   * @return string containing the java version running the current program
   */
  private static String getJavaVersion()
  {
    Runtime.Version rtv = Runtime.version();
    return String.format("%s.%s.%s.%s", rtv.feature(), rtv.interim(), rtv.update(), rtv.patch());
  }
}