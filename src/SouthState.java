import java.awt.geom.Rectangle2D;

public class SouthState implements DirectionState{
    private static final Direction direction = Direction.SOUTH;
    private DynamicSprite dynamicSprite;

    public SouthState(DynamicSprite dynamicSprite) {
        this.dynamicSprite = dynamicSprite;
    }

    public Direction getDirection(){
        return direction;
    }

    public void handleMovement(){
        dynamicSprite.setY(dynamicSprite.getY() + (int)dynamicSprite.getSpeed());
    }

    public void handleCollision(){
        dynamicSprite.setPossibleHitbox(new Rectangle2D.Double(dynamicSprite.getX(), dynamicSprite.getY() + dynamicSprite.getSpeed(), dynamicSprite.getWidth(), dynamicSprite.getHeight()));
    }
}
