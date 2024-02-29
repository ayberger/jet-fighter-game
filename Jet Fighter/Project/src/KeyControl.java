
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter{
	Fighter s;
	
	
	public KeyControl(Fighter ship) {
		s=ship;
		
	}
	public void keyPressed(KeyEvent e) {
		s.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
		s.keyReleased(e);
	}

	
	
	
}
