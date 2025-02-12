import java.awt.Graphics;
import java.awt.Image;

public class Sprite implements Displayable {
    private Image image;
    private double x, y;
    private double width, height;
    
    public Sprite(Image image, double x, double y, double width, double height){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }
}
