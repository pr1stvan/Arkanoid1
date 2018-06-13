
import java.awt.*;

import javax.swing.*;


public class Main {
	private static Level probapalya1(){
		
		BrickList list=new BrickList();
		int number;
		
		
		for(int i=5;i<6;i++){
			for(int j=6;j<8;j++){
				list.add(new BreakableBrick(40*j+1,20*i+1,38,18));
			}
		}
		number=list.size();
		
		
		return new Level(list,number);
	}
	private static Level probapalya2(){
		
		BrickList list=new BrickList();
		int number;
		
		
		for(int i=5;i<9;i++){
			for(int j=5;j<8;j++){
				list.add(new BreakableBrick(40*j+1,20*i+1,38,18));
			}
		}
		number=list.size();
		list.add(new Brick(40*2+1,20*15+1,38,18));
		list.add(new Brick(40*6+1,20*15+1,38,18));
		list.add(new Brick(40*10+1,20*15+1,38,18));
		
		
		return new Level(list,number);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		

		JButton b1=new JButton("uj jatek");
		JButton b2=new JButton("pontszamok");
		JLabel scoreSubtitle=new JLabel("pontszám:");
		JLabel score=new JLabel("0");
		JLabel livesSubtitle=new JLabel("élet:");
		JLabel lives=new JLabel("0");
		
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		
		BoxLayout box=new BoxLayout(jp,BoxLayout.Y_AXIS);
		jp.setLayout(box);
		jp2.setLayout(new GridLayout(4,1));
		
		
		jp.add(b1);
		jp.add(b2);
		jp2.add(scoreSubtitle);
		jp2.add(score);
		jp2.add(livesSubtitle);
		jp2.add(lives);
		
		jf.add(jp,BorderLayout.WEST);
		jf.add(jp2,BorderLayout.EAST);
		
		Level[] levels=new Level[2];
		levels[0]=probapalya1();
		levels[1]=probapalya2();
		
		GField gf=new GField(jp.getSize().width,jp.getSize().height);
		
		jf.add(gf,BorderLayout.CENTER);
		
		EventListener ls=new EventListener(gf,levels,jp,score,lives);
		TimerListener tl=new TimerListener(ls);
		MouseEventListener ml=new MouseEventListener(ls);
		ButtonListener bl=new ButtonListener(ls);
		jp.getSize();
		
		Timer t=new Timer(1,tl);
		t.start();
		jf.addMouseListener(ml);
		jf.addMouseMotionListener(ml);
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		gf.xpos=jp.getSize().width;
		gf.ypos=jp.getSize().height;
		

		
	}
		
}

