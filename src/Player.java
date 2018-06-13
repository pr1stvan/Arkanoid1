import java.io.Serializable;


public class Player implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8610587026339220235L;
	private String name;
	private int lives;
	public  int score;
	
	public Player(){
		score=0;
		name=" ";
	}
	
	public void setName(String n){
		if(n==null)name=null;
		else name=new String(n);
		lives=3;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLives(){
		return lives;
	}
	public void death(){
		if(lives!=0)lives--;
	}
	public int getScore(){
		return score;
	}


	
	
}
