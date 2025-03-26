import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite{
    private boolean isWalking = true;
    private double speed = 5;
    private final int spriteSheetNumberOfColumn = 10;
    private int timeBetweenFrame = 50;
    private DirectionState directionState = new SouthState(this);
    private Rectangle2D.Double possibleHitBox;

    public DynamicSprite(Image image, double x, double y, double width, double height){
        super(image, x, y, width, height);
    }

    public double getSpeed(){
        return speed;
    }

    public void setPossibleHitbox(Rectangle2D.Double possibleHitBox){
        this.possibleHitBox = possibleHitBox;
    }

    public void setDirection(Direction direction){
        switch(direction) {
            case NORTH:
                directionState = new NorthState(this);
                break;
            case WEST:
                directionState = new WestState(this);
                break;
            case SOUTH:
                directionState = new SouthState(this);
                break;
            case EAST:
                directionState = new EastState(this);
        }
    }

    private void move() {
        directionState.handleMovement();
    }

    private boolean isMovingPossible(ArrayList<Sprite> environment){
        Rectangle2D.Double hitBox = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
        directionState.handleCollision();
        for (Sprite s : environment) {
            if (s instanceof SolidSprite && s != this) {
                Rectangle2D.Double spriteHitBox = new Rectangle2D.Double(s.getX(), s.getY(), s.getWidth(), s.getHeight());
                if (possibleHitBox != null && spriteHitBox.intersects(possibleHitBox)){
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
        int index = (int)(System.currentTimeMillis() / timeBetweenFrame) % spriteSheetNumberOfColumn;
        int attitude = directionState.getDirection().getFrameLineNumber();

        g.drawImage(this.getImage(), this.getX(), this.getY(),
                    this.getX() + this.getWidth(), this.getY() + this.getHeight(),
                    index * this.getWidth(), attitude * this.getHeight(), (index + 1) * this.getWidth(), (attitude + 1) * this.getHeight(), null);
    }
}
