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

    @Override
    public void draw(Graphics g){
        g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }

    //The following getters are mainly for the DynamicSprite g.drawImage() call, which requires int arguments
    public int getX() {
        return (int)x;
    }
    public int getY() {
        return (int)y;
    }
    public int getWidth() {
        return (int)width;
    }
    public int getHeight() {
        return (int)height;
    }
    public Image getImage() {
        return image;
    }
}
