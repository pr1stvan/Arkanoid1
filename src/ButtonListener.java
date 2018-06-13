import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	
	private EventListener ev;
	
	public ButtonListener(EventListener e){
		ev=e;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("uj jatek".equals(cmd))ev.newgameClick();
		else if("pontszamok".equals(cmd))ev.scoreTableClick();
	}
	
	

}
