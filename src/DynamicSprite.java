import java.awt.Graphics;
import java.awt.Image;

public class DynamicSprite extends SolidSprite{
    private boolean isWalking = true;
    private double speed = 5;
    private final int spriteSheetNumberOfColumn = 10;
    private int timeBetweenFrame = 200;
    private Direction direction;

    public DynamicSprite(Image image, double x, double y, double width, double height){
        super(image, x, y, width, height);
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public void draw(Graphics g){
        int index = ((int)System.currentTimeMillis() / (2*timeBetweenFrame)) % spriteSheetNumberOfColumn;
        int attitude = direction.getFrameLineNumber();

        //g.drawImage(this.getImage(), (int) this.getX(), (int) this.getY(), (int) this.getX() + this.getWidth(), (int) this.getY() + this.getHeight(), index * this.getWidth(), attitude * this.getHeight(), (index + 1) * this.getWidth(), (index + 1) * this.getHeight(), null);
    }
}
