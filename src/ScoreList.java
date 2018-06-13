
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreList {
	private ArrayList<Player> list;
	
	public ScoreList(){
		read();
	}
	
	@SuppressWarnings("unchecked")
	public void read(){
		try{
	    	
	        FileInputStream fileIn = new FileInputStream("score.txt");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        list = (ArrayList<Player>) in.readObject();
	        in.close();
	        fileIn.close();
	    }catch(IOException i){
	    	   list=null;
	 
	    }catch(ClassNotFoundException c){ 
	        list=null; 
	    }
		
	}
	
	public void write(){
		if(list!=null){
			try{
				FileOutputStream fileOut =
				new FileOutputStream("score.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(list);
				out.close();
				fileOut.close();
				
			}catch(IOException i){
		          i.printStackTrace();
		    }
		}	
	}
	
	public void add(Player pl){
		if(list==null){
			list=new ArrayList<Player>();
			list.add(pl);
		}
		else list.add(pl);
		write();
	}
	
	public String[] getData(){
		 String[] str =new String[10];
		  
	      int db=0;
	      
	      if(list!=null){
	    	  Collections.sort(list,new PlayerComparator());
	    	  
	    	  for(Player player :list){
	    		  if(db<str.length)str[db]=new String((db+1)+". "+player.getName()+" "+player.score);
	    		  db++;
	    	  }
	      }
	      
	      while(db<10){
	    	  str[db]=new String((db+1)+". ");
	    	  db++;
	      }
	      
	      return str;
	}
	
	
	
}
