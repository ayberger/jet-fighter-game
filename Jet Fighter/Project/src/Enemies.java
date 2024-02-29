import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemies extends creature {
	int enemySpeed = 0;
	
	private int startY;
	

	public Enemies(int x, int y, int enemySpeed) {
        super(x, y);
        this.enemySpeed = enemySpeed;
		startY = y;
		

	}
	
	public void update() {
		y+=enemySpeed;
		checkCollusions();
		checkOffScreen();
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(getEnemyImg(), x, y,null);
		
		
	}
	public Image getEnemyImg() {
		ImageIcon ic = new ImageIcon("\"C:\\Users\\Ayberk\\OneDrive\\Masaüstü\\Assets\\plane2.png\"");
		return  ic.getImage();
		
	}
	
	public void checkCollusions() {
	    for (int i = 0; i < GameFrame.getFireList().size(); i++) {
	        Fire f = GameFrame.getFireList().get(i);

	        for (int j = 0; j < GameFrame.getEnemiesList().size(); j++) {
	            Enemies a = GameFrame.getEnemiesList().get(j);

	            if (f.getBounds().intersects(a.getBounds())) {
	                GameFrame.removeFire(f);
	                GameFrame.removeEnemy(a);
	                break;
	            }
	        }
	    }
	}

	
	public void checkOffScreen() {
		if(y>=780) {
			y=startY;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,getEnemyImg().getWidth(null),getEnemyImg().getHeight(null));
	}
	

}
