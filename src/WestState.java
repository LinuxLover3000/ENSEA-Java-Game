import java.awt.geom.Rectangle2D;

public class WestState implements DirectionState{
    private static final Direction direction = Direction.WEST;
    private DynamicSprite dynamicSprite;

    public WestState(DynamicSprite dynamicSprite) {
        this.dynamicSprite = dynamicSprite;
    }

    public Direction getDirection(){
        return direction;
    }

    public void handleMovement(){
        dynamicSprite.setX(dynamicSprite.getX() - (int)dynamicSprite.getSpeed());
    }

    public void handleCollision(){
        dynamicSprite.setPossibleHitbox(new Rectangle2D.Double(dynamicSprite.getX() - dynamicSprite.getSpeed(), dynamicSprite.getY(), dynamicSprite.getWidth(), dynamicSprite.getHeight()));
    }
}
