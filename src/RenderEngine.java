import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;

public class RenderEngine extends JPanel implements Engine {
    private ArrayList<Displayable> renderList;
    
    public RenderEngine(){
        renderList = new ArrayList<Displayable>();
    }

    public void setRenderList(ArrayList<Displayable> renderList){
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable){
        renderList.add(displayable);
    }

    public void paint(Graphics g){
        super.paint(g);
        for (Displayable d : renderList){
            d.draw(g);
        }
    }

    public void update(){
        repaint();
        //System.out.println("RenderEngine update()");
    }
}
