import java.awt.Color;
import java.util.Random;


//más színû
public class BreakableBrick extends Brick {
	

	public BreakableBrick(double a, double b, double width, double height) {
		super(a, b, width, height);
		breakable=true;
		Random rnd=new Random();
		int number=rnd.nextInt(3);
		
		if(number==0)color=Color.GREEN;
		else if(number==1)color=Color.BLUE;
		else if(number==2)color=Color.RED;
		else color=Color.BLACK;
		
	}
	
	

}
