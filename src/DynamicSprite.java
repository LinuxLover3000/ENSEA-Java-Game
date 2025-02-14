import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite{
    private boolean isWalking = true;
    private double speed = 5;
    private final int spriteSheetNumberOfColumn = 10;
    private int timeBetweenFrame = 50;
    private Direction direction = Direction.SOUTH;

    public DynamicSprite(Image image, double x, double y, double width, double height){
        super(image, x, y, width, height);
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    private void move() {
        switch(direction) {
            case NORTH:
                y -= speed;
                break;
            case WEST:
                x -= speed;
                break;
            case SOUTH:
                y += speed;
                break;
            case EAST:
                x += speed;
        }
    }

    private boolean isMovingPossible(ArrayList<Sprite> environment){
        Rectangle2D.Double hitBox = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
        Rectangle2D.Double possibleHitBox;
        switch(direction) {
            case NORTH:
                possibleHitBox = new Rectangle2D.Double(getX(), getY() - speed, getWidth(), getHeight());
                break;
            case WEST:
                possibleHitBox = new Rectangle2D.Double(getX() - speed, getY(), getWidth(), getHeight());
                break;
            case SOUTH:
                possibleHitBox = new Rectangle2D.Double(getX(), getY() + speed, getWidth(), getHeight());
                break;
            case EAST:
                possibleHitBox = new Rectangle2D.Double(getX() + speed, getY(), getWidth(), getHeight());
                break;
            default:
                possibleHitBox = hitBox;
        }
        for (Sprite s : environment) {
            if (s instanceof SolidSprite && s != this) {
                Rectangle2D.Double spriteHitBox = new Rectangle2D.Double(s.getX(), s.getY(), s.getWidth(), s.getHeight());
                if (spriteHitBox.intersects(possibleHitBox)){
                    return false;
                }
            }
        }
        return true;
    }

    public void moveIfPossible(ArrayList<Sprite> environment){
        if(isMovingPossible(environment)){
            move();
        }
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
