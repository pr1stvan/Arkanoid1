

public class Vector {
	private double x;
	private double y;
	
	public static double kozbezartszog(Vector v1, Vector v2){
		return Math.acos((v1.x*v2.x+v1.y*v2.y)/(Math.sqrt(v1.x*v1.x+v1.y*v1.y) * Math.sqrt(v2.x*v2.x+v2.y*v2.y)));
	}
	public static Vector add(Vector v1,Vector v2){
		return new Vector(v1.x+v2.x,v1.y+v2.y);
	}
	public static Vector subt(Vector v2,Vector v1){
		return new Vector(v2.x-v1.x,v2.y-v1.y);
	}
	
	public Vector(double x,double y){
		this.x=x;
		this.y=y;
	}
	public void setX(double x){
		this.x=x;
	}
	public void setY(double y){
		this.y=y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void set(Vector other){
		this.x=other.getX();
		this.y=other.getY();
	}
	public double getDirection(){
		double size=Math.sqrt(x*x+y*y);
		double direction=Math.asin(y/size);
		if(x<0)direction=Math.PI-direction;
		return direction;
	}
	
	public void setAbs(double abs){
		
		double dir=getDirection();
		
		x=abs*Math.sin(dir);
		y=abs*Math.cos(dir);
	}
	
	public double getAbs(){
		return Math.sqrt(x*x+y*y);
	}
	public void setDirection(double direction){
		double abs=this.getAbs();
		
		x=Math.cos(direction)*abs;
		y=Math.sin(direction)*abs;
	}
	
}