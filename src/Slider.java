import java.awt.Color;
import java.awt.Graphics;


public class Slider extends GameElement {
	
	public final double width,height;
	public Slider(double a, double b,double width,double height) {
		super(a,b);
		this.width=width;
		this.height=height;
		
	}
	public void draw(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect((int)Math.round(x),(int)Math.round(y), (int)Math.round(width),(int) Math.round(height));
	}
	public void update(){
		
	}

}