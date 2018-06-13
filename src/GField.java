import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class GField extends JComponent{
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	public int xpos, ypos;
	
	public GField(int xpos, int ypos){
		super();
		this.xpos=xpos;
		this.ypos=ypos;
		image = new BufferedImage(d.width,d.height,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,d.width, d.height);
		
		
	}
	public void paint(Graphics g){
		g.drawImage(image,0,0,null);
	}
	public Graphics getImg(){
		return image.getGraphics();
		
	}
	
	
	
	public Dimension d = new Dimension(520,600);
	public Dimension getMinimumSize() { 
		return d;
	}
	
	public Dimension getMaximumSize() { 
		return d;
	}
	public Dimension getPreferredSize() { 
		return d;
	}
}
