import java.util.ArrayList;

public class PhysicEngine implements Engine {
    private ArrayList<DynamicSprite> movingSpriteList;
    private ArrayList<Sprite> environment;

    public PhysicEngine(){
        movingSpriteList = new ArrayList<DynamicSprite>();
        environment = new ArrayList<Sprite>();
    }

    public void addToMovingSpriteList(DynamicSprite sprite){
        movingSpriteList.add(sprite);
    }

    public void setEnvironment(ArrayList<Sprite> environment){
        this.environment = environment;
    }

    @Override
    public void update(){
        for (DynamicSprite s : movingSpriteList){
            s.moveIfPossible(environment);
        }
    }
}
