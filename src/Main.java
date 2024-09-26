import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    String title = String.format("Java Border Layout Demo using java version %s", getJavaVersion());
    System.out.println(title);
    Dimension scaledSize = SwingScreenUtilities.getScaledSize(0.4, 10);

    ImageDisplayExample gui = new ImageDisplayExample(title, scaledSize);
    // javax.swing.SwingUtilities.invokeLater(gui);
    SwingUtilities.invokeLater(() -> new ImageDisplayExample(title, scaledSize));
  }


  /** get the java version that is running the current program
   * @return string containing the java version running the current program
   */
  private static String getJavaVersion()
  {
    Runtime.Version runTimeVersion = Runtime.version();
    return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
  }
}