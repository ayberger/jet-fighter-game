import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Fire  extends creature{
	
	
	

	public Fire(int x, int y) {
		super(x, y);
		
	}
	
	public void  update() {
		y-=7;
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(getFireImg(),x,y,null);
		
	}
	public Image getFireImg() {
		ImageIcon ic = new ImageIcon("\"C:\\Users\\Ayberk\\OneDrive\\Masaüstü\\Assets\\fire.png\"");
		return  ic.getImage();
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,getFireImg().getWidth(null),getFireImg().getHeight(null));
	}
}
