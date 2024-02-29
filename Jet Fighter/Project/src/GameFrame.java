import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	
	
	int enemySpeed = 0;
	
	Timer mainTimer;
	Fighter fighter;
	
	int enemyCount = 5;
	int level = 1;
	private int highScore = 0;
	
	static ArrayList<Enemies> enemies = new ArrayList<Enemies>();
	static ArrayList<Fire>fires = new ArrayList<Fire>();
	
	Random rand= new Random();
	
	
	public GameFrame() {
		
		setFocusable(true);
		mainTimer= new Timer(10,this);
		mainTimer.start();
		fighter = new Fighter(400,400);
		addKeyListener(new KeyControl(fighter));
		
		startGame();
		

		
		
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		ImageIcon ic = new ImageIcon("\"C:\\Users\\Ayberk\\OneDrive\\Masaüstü\\Assets\\background.jpg\"");
		
		g2.drawImage(ic.getImage(),0,0,null );
		
		fighter.draw(g2);
		
		for(int i = 0; i< enemies.size(); i++) {
			Enemies tEnemy = enemies.get(i);
			tEnemy.draw(g2);
		}
		
		for(int i=0; i<fires.size(); i++) {
			Fire f = fires.get(i);
			f.draw(g2);
		}
		
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
	    fighter.update();
        


	    for (int i = 0; i < fires.size(); i++) {
	        Fire f = fires.get(i);
	        f.update();
	    }

	    for (int i = 0; i < enemies.size(); i++) {
	        Enemies e1 = enemies.get(i);
	        e1.update();
	    }
	    

	    checkEnd();

	    repaint();
	}
 

	
	public static void addEnemy(Enemies enemy) {
		enemies.add(enemy);
		
	}
	
	
	public static void removeEnemy(Enemies enemy) {
		enemies.remove(enemy);
		
		
	}
	public static ArrayList<Enemies> getEnemiesList(){
		return enemies;
		
	}
	
	public static void addFire(Fire f) {
		fires.add(f);
		
	}
	
	public static void removeFire(Fire f) {
		fires.remove(f);
		
		 
	}
	public static ArrayList<Fire> getFireList(){
		return fires;
		
	}
	
	
	public void  startGame() {
		
		
		enemyCount = level*5;
		enemySpeed = 1+(level-1);
		
		
		for(int i = 0; i<enemyCount; i++) {
			addEnemy(new Enemies(rand.nextInt(900),-rand.nextInt(500),enemySpeed));
			
		}
		if (enemies.isEmpty() && fires.isEmpty()) {
		    addFire(new Fire(fighter.x, fighter.y));
		}

	}
	public void checkEnd() {
		if(enemies.size()==0) {
			level++;
			highScore += 10;
			JOptionPane.showMessageDialog(null,"GG! You have completed level"+ (level-1));
			startGame();
			
		}
	}
	public int getHighScore() {
        return highScore;
    }
	
	
}
