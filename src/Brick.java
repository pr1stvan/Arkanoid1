import java.awt.Color;
import java.awt.Graphics;


public class Brick extends GameElement{
	
	public double width;
	public double height;
	public Color color;
	protected boolean breakable;
	
	public Brick(double a, double b,double width, double height) {
		super(a, b);
	
		this.width=width;
		this.height=height;
		
		color=Color.darkGray;
		breakable=false;
	}
	public void draw(Graphics g){
		int xpos=(int) Math.round(x);
		int ypos=(int) Math.round(y);
		
		int iwidth=(int) Math.round(width);
		int iheight=(int) Math.round(height);
		
		g.setColor(color);
		
		g.fillRect(xpos, ypos, iwidth, iheight);
	}
	public boolean breakable(){
		return breakable;
	}

}
