import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Main {
    JFrame displayZoneFrame;
    RenderEngine renderEngine;
    GameEngine gameEngine;
    PhysicEngine physicEngine;

    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        DynamicSprite hero = new DynamicSprite(ImageIO.read(new File("./resource/img/heroTileSheetLowRes.png")), 200, 300, 48, 50);

        renderEngine = new RenderEngine();
        gameEngine = new GameEngine(hero);
        physicEngine = new PhysicEngine();

        Timer renderTimer = new Timer(50, (time)-> renderEngine.update());
        Timer gameTimer = new Timer(50, (time)-> gameEngine.update());
        Timer physicTimer = new Timer(50, (time)-> physicEngine.update());

        displayZoneFrame.getContentPane().add(renderEngine);

        /*
        Image treeImg = ImageIO.read(new File("./resource/img/tree.png"));
        Sprite treeSpr1 = new Sprite(treeImg, 75, 50, 2*treeImg.getWidth(null), treeImg.getHeight(null));
        Sprite treeSpr2 = new Sprite(treeImg, 100, 200, treeImg.getWidth(null), treeImg.getHeight(null));
        renderEngine.addToRenderList(treeSpr1);
        renderEngine.addToRenderList(treeSpr2);
        */
        //hero.setDirection(Direction.WEST);

        renderTimer.start();
        gameTimer.start();
        physicTimer.start();

        displayZoneFrame.addKeyListener(gameEngine);
        displayZoneFrame.setVisible(true);

        SolidSprite testSprite = new SolidSprite(ImageIO.read(new File("./resource/img/rock.png")), 250, 300, 64, 64);
        renderEngine.addToRenderList(hero);
        renderEngine.addToRenderList(testSprite);
        physicEngine.addToMovingSpriteList(hero);
        ArrayList<Sprite> a = new ArrayList<Sprite>();
        a.add(testSprite);
        physicEngine.setEnvironment(a);

    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }
}
