import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimerListener implements ActionListener{

	EventListener ev;
	
	public TimerListener(EventListener ev){
		this.ev=ev;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ev.timerTick();
		
	}
	

}
