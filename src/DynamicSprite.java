import java.awt.Graphics;
import java.awt.Image;

public class DynamicSprite extends SolidSprite{
    private boolean isWalking = true;
    private double speed = 5;
    private final int spriteSheetNumberOfColumn = 10;
    private int timeBetweenFrame = 200;
    private Direction direction = Direction.SOUTH;

    public DynamicSprite(Image image, double x, double y, double width, double height){
        super(image, x, y, width, height);
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g){
        int index = ((int)System.currentTimeMillis() / timeBetweenFrame) % spriteSheetNumberOfColumn;
        int attitude = direction.getFrameLineNumber();

        g.drawImage(this.getImage(), this.getX(), this.getY(),
                    this.getX() + this.getWidth(), this.getY() + this.getHeight(),
                    index * this.getWidth(), attitude * this.getHeight(), (index + 1) * this.getWidth(), (attitude + 1) * this.getHeight(), null);
    }
}
