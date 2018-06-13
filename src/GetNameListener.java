import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class GetNameListener implements ActionListener{
	
	JFrame frame;
	JButton okbutton;
	JTextField jt;
	String name=null;
	EventListener sender;
	
	public GetNameListener(JFrame jf,JButton b,JTextField t,String name,EventListener sender){
		frame=jf;
		okbutton=b;
		jt=t;
		this.name=name;
		this.sender=sender;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		sender.player.setName(new String(jt.getText()));
		
		sender.enable=true;
		frame.dispose();
		
	}
	
	
}
