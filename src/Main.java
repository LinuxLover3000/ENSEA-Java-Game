import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Main {
    JFrame displayZoneFrame;
    RenderEngine renderEngine;

    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        renderEngine = new RenderEngine();
        Timer renderTimer = new Timer(50, (time)-> renderEngine.update());
        
        displayZoneFrame.getContentPane().add(renderEngine);

        renderTimer.start();
        displayZoneFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }
}
