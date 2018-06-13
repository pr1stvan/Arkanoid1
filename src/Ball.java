import java.awt.Color;
import java.awt.Graphics;


public class Ball extends GameElement {
	
	
	public double xspeed,yspeed;
	public int r;
	
	
	public Ball(double a,double b,double xspeed, double yspeed){
		super(a,b);
		this.xspeed=xspeed;
		this.yspeed=yspeed;
		r=10;
		
		
		
	}
	
	public void update(){
		x+=xspeed;
		y+=yspeed;
	
	}
	
	public void draw(Graphics g){
		int xpos=(int) Math.round(x);
		int ypos=(int) Math.round(y);
		
		g.setColor(Color.BLACK);
		g.drawOval(xpos-r, ypos-r, 2*r, 2*r);
		
	}
	
}
