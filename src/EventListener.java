import java.awt.*;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EventListener {
	public enum State{BEGIN,PREPARE ,GAME, GAMEOVER};
	public State state;
	private GField gf;
	
	//private Ball ball=new Ball(300,290,-1.5,1);
	private Ball ball=new Ball(300,290,0,-2);
	private BrickList list;
	private Slider slider;
	private JPanel jp;

	private JLabel scoreLabel;
	private JLabel liveLabel;
	
	
	public boolean enable;
	public Player player;
	private Level[] levels;
	private int level;
	private ScoreList scorelist;
	
	private int brickNumber;
	
	private GameElement flagged=null;
	private Pont mousepoint=new Pont(0,0);
	
	
	public EventListener(GField gfield,Level[] levs,JPanel jp,JLabel sl,JLabel ll){
		super();
		this.levels=levs;
		state=State.BEGIN;
		this.jp=jp;
		//ezekbõl nullpointer lehet
		gf=gfield;
		
		
		scorelist=new ScoreList();
		
		scoreLabel=sl;
		liveLabel=ll;
		
		enable=true;
		
	}

	public void mouseMoved(int x,int y) {
		if(enable==true){
			mousepoint.x=x;
			mousepoint.y=y;
		}
		
	}
	public void newgameClick(){
		if(enable==true){
				if(state==State.PREPARE || state==State.GAME){
					scorelist.add(player);
				}
				enable=false;
				player=new Player();
				player.setName(null);
				player.setName(this.getName());
				level=0;
				
				list=new BrickList(levels[level].getList());
				brickNumber=levels[level].getNumberOfBreakable();

				slider=new Slider(gf.getMaximumSize().width/2,gf.getMaximumSize().height-55,80,20);
				state=State.PREPARE;
				
		}
	}
	public void scoreTableClick(){
		if(enable==true){
			enable=false;
			showScores();
		}
	}
	public void mouseClick(){
		if(enable==true){
			if(state==State.PREPARE){
				state=State.GAME;
			}
		}
	}
	
	public String getName(){
		JFrame jf = new JFrame();
		JPanel jp=new JPanel();
		String name=null;
		
		JTextField t=new JTextField(30);
		JButton b=new JButton("ok");
		JLabel label=new JLabel("név:");
		
		GetNameListener gn=new GetNameListener(jf, b, t, name,this);
		b.addActionListener(gn);
		
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		t.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		jp.add(label);
		jp.add(t);
		jp.add(Box.createRigidArea(new Dimension(0, 10)));
		jp.add(b);
		
		
		jf.add(jp);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);
		
		
		return name;
	}
	
	
	
	public void showScores(){
		
		JFrame jf = new JFrame();
		JPanel jp=new JPanel();
		JPanel jbuttonpanel=new JPanel();
		
		
		jp.setLayout(new GridLayout(10,2));
		//JLabel[] scores=new JLabel[10];
		JLabel[] names= new JLabel[10];
		
		JButton jb=new JButton("ok");
		jbuttonpanel.add(jb);
		//String[] s=scorelist.getScores();
		//String[] n=scorelist.getNames();
		String[] dat=scorelist.getData();
		
		for(int i=0;i<10;i++){
		
			names[i]=new JLabel();
			names[i].setText(dat[i]);
		}
		
		for(int i=0;i<10;i++){
			jp.add(names[i]);
		
		}
		
		ScoreTableListener st=new ScoreTableListener(jf, jb, this);
		jb.addActionListener(st);
		
		jf.add(jp,BorderLayout.CENTER);
		jf.add(jbuttonpanel,BorderLayout.SOUTH);
		
		
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);
	}
	
	
	
	
	private void PrepareState(){
		if(gf==null || ball==null || slider==null)return;
		Graphics systemg=gf.getGraphics();
		Graphics g=gf.getImg();
		if(systemg==null || g==null)return;
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,gf.d.width, gf.d.height);
		
		//egér miatt
		gf.xpos=jp.getWidth();
		gf.ypos=jp.getHeight();
		
		//////===================================================================
		ball.xspeed=0;
		ball.yspeed=-8;
		/////====================================================================
		ball.x=slider.x+slider.width/2;
		ball.y=slider.y-ball.r-5;
		//A slider ugyanúgy mozog, mintha játék lenne
		if(mousepoint.x-gf.xpos-slider.width/2>=0 && 
		   mousepoint.x-gf.xpos+slider.width/2<gf.getMaximumSize().width)slider.x=mousepoint.x-gf.xpos-slider.width/2+1;
		if(mousepoint.x-gf.xpos-slider.width/2<0)slider.x=0;
		if(mousepoint.x-gf.xpos>=gf.getMaximumSize().width)slider.x=gf.getMaximumSize().width-slider.width;
		list.drawAll(gf.getImg());
		slider.draw(gf.getImg());
		ball.draw(gf.getImg());
				
		gf.update(systemg);
	}
	
	private void BeginState(){
		if(gf==null || ball==null || slider==null)return;
		Graphics systemg=gf.getGraphics();
		Graphics g=gf.getImg();
		if(systemg==null || g==null)return;
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,gf.d.width, gf.d.height);
		
		//egér miatt
		gf.xpos=jp.getWidth();
		gf.ypos=jp.getHeight();
		
		
		gf.update(systemg);
	}
	
	private void GameOverState(){
		if(gf==null || ball==null || slider==null)return;
		Graphics systemg=gf.getGraphics();
		Graphics g=gf.getImg();
		if(systemg==null || g==null)return;
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,gf.d.width, gf.d.height);
		
		//egér miatt
		gf.xpos=jp.getWidth();
		gf.ypos=jp.getHeight();
		
	
		gf.update(systemg);
	}
	
	private void GameState(){
		if(gf==null || ball==null || slider==null)return;
		Graphics systemg=gf.getGraphics();
		Graphics g=gf.getImg();
		if(systemg==null || g==null)return;
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,gf.d.width, gf.d.height);
		
		//egér miatt
		gf.xpos=jp.getWidth();
		gf.ypos=jp.getHeight();
		
		
		

		//=======================================================================
		//game field edge collision
		//=======================================================================
	
		int ballx=(int)Math.round(ball.x);
		int bally=(int)Math.round(ball.y);
		if(ballx-ball.r<=0){
			ball.xspeed=Math.abs(ball.xspeed);
			flagged=null;
		}
		if(ballx+ball.r>=gf.getMaximumSize().width){
			ball.xspeed=-Math.abs(ball.xspeed);
			flagged=null;
		}
		if(bally-ball.r<=0){
			ball.yspeed=Math.abs(ball.yspeed);
			flagged=null;
		}
		if(bally+ball.r>=gf.getMaximumSize().height){
			
			player.death();
			flagged=null;
			if(player.getLives()==0){
				state=State.GAMEOVER;
				list=null;
				scorelist.add(player);
				player=null;
				
				level=0;
				return;
			}
			else{
				
				state=State.PREPARE;
			}
			
		}
	
		//=======================================================================
		//Brick collision
		//=======================================================================
		BrickList removeList=new BrickList();
	
		for(Brick br :list){
			if(br!=flagged){
				Vector vball=new Vector(ball.x, ball.y);
				Vector[] p=new Vector[5];
			
				p[4]=new Vector(br.x,br.y);
				p[0]=new Vector(br.x,br.y);
				p[1]=new Vector(br.x+br.width-1,br.y);
				p[2]=new Vector(br.x+br.width-1,br.y+br.height-1);
				p[3]=new Vector(br.x,br.y+br.height-1);
			
				double[] distances=new double[4];
			
				for(int i=0;i<4;i++){
					Vector p0ToP1=Vector.subt(p[i+1], p[i]);
					Vector p1ToP0=Vector.subt(p[i], p[i+1]);
					Vector p0ToBall=Vector.subt(vball, p[i] );
					Vector p1ToBall=Vector.subt(vball, p[i+1]);
			
					double p0ball=Vector.kozbezartszog(p0ToP1, p0ToBall);
					double p1ball=Vector.kozbezartszog(p1ToP0,p1ToBall);
					double distance0=p0ToBall.getAbs();
					double distance1=p1ToBall.getAbs();
					double distance2 = 777;
				
				
					if( i==0 && ball.yspeed>0 || i==1 && ball.xspeed<0 ||i==2 && ball.yspeed<0 ||i==3 && ball.xspeed>0){
						if(p0ball>=Math.PI/2){
								if(p0ball*180/Math.PI<=135){
									distance2=distance0;
								}
								else distance2=777;
						}
						else if(p1ball>=Math.PI/2){
							if(p1ball*180/Math.PI<=135){
								distance2=distance1;
							}
							else distance2=777;
						}
						else {
							distance2=Math.sin(p0ball)*distance0;
						}
					}
				
					distances[i]=distance2;
				}
				int min=0;
				for(int i=1;i<4;i++){
					if(distances[i]<distances[min])min=i;
				}
				if(distances[min]<=ball.r){
					if(min==0 || min==2)ball.yspeed=-ball.yspeed;
					if(min==1 || min==3)ball.xspeed=-ball.xspeed;
		
					flagged=br;
					removeList.add(br);
				
				}
			}	
		}
		//törlés
		for(Brick br:removeList){
			if(br.breakable()){
				list.remove(br);
				player.score+=10;
				brickNumber--;
			}
		}
		
		//=======================================================================
		//új pálya betöltése 
		//=======================================================================
		if(brickNumber==0){
			level++;
			if(level<levels.length){
				list=new BrickList(levels[level].getList());
				brickNumber=levels[level].getNumberOfBreakable();
				state=State.PREPARE;
				return;
			}
			else{
				scorelist.add(player);
				player=null;
				state=State.BEGIN;
				return;
			}
			
			
		}
	
		//=======================================================================
		//A slider collision
		//=======================================================================
			
		if(slider!=flagged){
			Vector vball=new Vector(ball.x, ball.y);
			Vector[] p=new Vector[5];
		
			p[4]=new Vector(slider.x,slider.y);
			p[0]=new Vector(slider.x,slider.y);
			p[1]=new Vector(slider.x+slider.width-1,slider.y);
			p[2]=new Vector(slider.x+slider.width-1,slider.y+slider.height-1);
			p[3]=new Vector(slider.x,slider.y+slider.height-1);
		
			double[] distances=new double[4];
		
			for(int i=0;i<4;i++){
				Vector p0ToP1=Vector.subt(p[i+1], p[i]);
				Vector p1ToP0=Vector.subt(p[i], p[i+1]);
				Vector p0ToBall=Vector.subt(vball, p[i] );
				Vector p1ToBall=Vector.subt(vball, p[i+1]);
		
				double p0ball=Vector.kozbezartszog(p0ToP1, p0ToBall);
				double p1ball=Vector.kozbezartszog(p1ToP0,p1ToBall);
				double distance0=p0ToBall.getAbs();
				double distance1=p1ToBall.getAbs();
				double distance2 = 777;
			
			
				if( i==0 && ball.yspeed>0 || i==1 && ball.xspeed<0 ||i==2 && ball.yspeed<0 ||i==3 && ball.xspeed>0){
					if(p0ball>=Math.PI/2){
							if(p0ball*180/Math.PI<=135){
								distance2=distance0;
							}
							else distance2=777;
					}
					else if(p1ball>=Math.PI/2){
						if(p1ball*180/Math.PI<=135){
							distance2=distance1;
						}
						else distance2=777;
					}
					else {
						distance2=Math.sin(p0ball)*distance0;
					}
				}
				
				distances[i]=distance2;
			}
			int min=0;
			for(int i=1;i<4;i++){
				if(distances[i]<distances[min])min=i;
			}
			if(distances[min]<=ball.r){
				Vector sliderPoint=new Vector((slider.x+slider.width/2),slider.y+slider.height);
				Vector sliderPointToBall=new Vector(ball.x-sliderPoint.getX(),ball.y-sliderPoint.getY());
				Vector ballSpeed=new Vector(ball.xspeed,ball.yspeed);
				double direction=sliderPointToBall.getDirection();
				
				ballSpeed.setDirection(direction);
			
				ball.xspeed=ballSpeed.getX();
				ball.yspeed=ballSpeed.getY();
				flagged=slider;
			}
		}	
	
	
		//=======================================================================
		//update the game field
		//=======================================================================
	
		if(mousepoint.x-gf.xpos-slider.width/2>=0 && 
				mousepoint.x-gf.xpos+slider.width/2<gf.getMaximumSize().width)slider.x=mousepoint.x-gf.xpos-slider.width/2+1;
		if(mousepoint.x-gf.xpos-slider.width/2<0)slider.x=0;
		if(mousepoint.x-gf.xpos>=gf.getMaximumSize().width)slider.x=gf.getMaximumSize().width-slider.width;
		ball.update();
		list.drawAll(gf.getImg());
		slider.draw(gf.getImg());
		ball.draw(gf.getImg());
	
		gf.update(systemg);
		
	}
	
	public void timerTick() {
		if(enable==true){
			if(state==State.BEGIN){
				BeginState();
			}
			if(state==State.GAMEOVER){
				GameOverState();
			}
			else if(state==State.PREPARE){
				PrepareState();
			}
			else if(state==State.GAME){
				GameState();
			}
		}
		
		if(player!=null)scoreLabel.setText(Integer.toString(player.score));
		else scoreLabel.setText(Integer.toString(0));
		if(player!=null)liveLabel.setText(Integer.toString(player.getLives()));
		else liveLabel.setText(Integer.toString(0));
		
		
	}

}