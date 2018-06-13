import java.awt.Graphics;
import java.util.ArrayList;



public class BrickList extends ArrayList<Brick>{
	private static final long serialVersionUID = 1L;
	
	public BrickList(BrickList list) {
		super(list);
	}
	public BrickList() {
		super();
	}
	public void updateAll(){
		for(Brick e :this){
			e.update();
		}
		
	}
	public void drawAll(Graphics g){
		for(Brick e :this){
			e.draw(g);
		}
	}
	
	
}
