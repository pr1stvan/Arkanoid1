import java.util.Comparator;

public class PlayerComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		Integer p1 = o1.getScore();
		Integer p2 = o2.getScore();
		if (p1 < p2 ){
		   return 1;
		 }
		 else if (p1 > p2){
		   return -1;
		 }
		  else return 0;
	}
	

}