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

    public void draw(){
        int index = ((int)System.currentTimeMillis() / (2*timeBetweenFrame)) % spriteSheetNumberOfColumn;
        int attitude = direction.getFrameLineNumber();

        drawImage
    }
}
