import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseEventListener implements MouseListener, MouseMotionListener{
	
	EventListener ev;
	
	public MouseEventListener(EventListener e){
		ev=e;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		ev.mouseMoved(arg0.getX(),arg0.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		ev.mouseMoved(arg0.getX(),arg0.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ev.mouseClick();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
