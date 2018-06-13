
public class Level {
	
	private BrickList list;
	private int number;
	
	public Level(){
		list=new BrickList();
		
		//palya letrehozas
		for(int i=0;i<13;i++){
			list.add(new BreakableBrick(40*i+1, 0+1, 38, 18));
		}
		
		for(int i=1;i<7;i++){
			for(int j=0;j<13;j++){
				list.add(new BreakableBrick(40*j+1,20*i+1,38,18));
			}
		}
		number=list.size();
	}
	public Level(BrickList list,int number){
		this.list=list;
		this.number=number;
	}
	public BrickList getList(){
		return list;
	}
	public int getNumberOfBreakable(){
		return number;
	}
	

}
