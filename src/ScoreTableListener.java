import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ScoreTableListener implements ActionListener{
	
	JFrame frame;
	JButton okbutton;
	EventListener sender;
	
	public ScoreTableListener(JFrame jf,JButton b,EventListener sender){
		frame=jf;
		okbutton=b;
		this.sender=sender;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		sender.enable=true;
		frame.dispose();
		
	}
	
	
}
