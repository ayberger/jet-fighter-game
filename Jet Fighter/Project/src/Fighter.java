import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Fighter extends creature{
	
	int velX= 0,velY = 0;
	int speed= 10;
	

	public Fighter(int x, int y) {
		super(x, y);
		
	}
	public void update() {
		y+=velY;
		x+=velX;
		checkCollisions();
		
		
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(getFighterImg(), x, y, null);
	}
	
	public Image getFighterImg() {
		ImageIcon ic = new ImageIcon("\"C:\\Users\\Ayberk\\OneDrive\\Masaüstü\\Assets\\plane.png\"");
		return  ic.getImage();
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key= e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			velX= speed;
			
		}
		else if(key == KeyEvent.VK_S) {
			velX= -speed;
		}
		else if(key == KeyEvent.VK_A) {
			velX= -speed;
		}
		else if(key == KeyEvent.VK_D) {
			velX=speed;
		}
		else if(key == KeyEvent.VK_SPACE) {
			Fire newFire= new Fire(x,y);
					
			GameFrame.addFire(newFire);
		}
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key= e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			velX=0;
		}
		else if(key == KeyEvent.VK_S) {
			velX=0;
		}
		else if(key == KeyEvent.VK_A) {
			velX=0;
		}
		else if(key == KeyEvent.VK_D) {
			velX=0;
		}
		
	}
	
	public void checkCollisions() {
		ArrayList<Enemies> enemies = GameFrame.getEnemiesList();
		
		for(int i = 0; i<enemies.size();i++) {
			Enemies tEnemy = enemies.get(i);
			
			if(getBounds().intersects(tEnemy.getBounds())){
				JOptionPane.showMessageDialog(null, "You died");
				System.exit(0 );
			}
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,getFighterImg().getWidth(null),getFighterImg().getHeight(null));
	}
}
