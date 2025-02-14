import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
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

        /*
        Image treeImg = ImageIO.read(new File("./resource/img/tree.png"));
        Sprite treeSpr1 = new Sprite(treeImg, 75, 50, 2*treeImg.getWidth(null), treeImg.getHeight(null));
        Sprite treeSpr2 = new Sprite(treeImg, 100, 200, treeImg.getWidth(null), treeImg.getHeight(null));
        renderEngine.addToRenderList(treeSpr1);
        renderEngine.addToRenderList(treeSpr2);
        */
        //hero.setDirection(Direction.WEST);


        DynamicSprite hero = new DynamicSprite(ImageIO.read(new File("./resource/img/heroTileSheetLowRes.png")), 200, 300, 48, 50);
        GameEngine gameEngine = new GameEngine(hero);
        Timer gameTimer = new Timer(50, (time)-> gameEngine.update());
        renderEngine.addToRenderList(hero);


        renderTimer.start();
        gameTimer.start();
        displayZoneFrame.addKeyListener(gameEngine);
        displayZoneFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }
}
