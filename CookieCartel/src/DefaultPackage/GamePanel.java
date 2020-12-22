package DefaultPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	Font titleFont; 
	Font titlefont;
	Timer frameDraw;
	Cookie cookie;
	Grandmas gramRight;
	Grandmas gramWGun;
	int streetv = 0;
	RollingPin rollpin;
	int mult = 1;
	
	
	
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titlefont = new Font("Arial", Font.PLAIN, 60);
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	cookie = new Cookie(260, 100, 300, 300);
	gramRight = new Grandmas(575, 125, 200, 200, "right");
	gramWGun = new Grandmas(40, 125, 200, 200, "left");
	rollpin = new RollingPin(69, 420, 10, 10);
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	
	
	int currentState = MENU;

	void upadateMenuState() {

	}

	void updateGameState() {

	}

	void upadateEndState() {

	}

	
	
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, CookieCartel.WIDTH, CookieCartel.HEIGHT);
		
		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("COOKIE CARTEL", 175, 100);
		
		g.setFont(titleFont);
		g.drawString("Press ENTER to Start", 175, 250);
		g.drawString("Press SPACE For Instructions", 90, 400);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, CookieCartel.WIDTH, CookieCartel.HEIGHT);
		
		cookie.draw(g);
		gramRight.Draw(g);
		gramWGun.Draw(g);
		rollpin.draw(g);
		
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Street Value= "+streetv, 10, 40);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CookieCartel.WIDTH,CookieCartel.HEIGHT);
		
		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("Haha You Suck", 175, 100);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Your Street Value Was   ", 100, 300);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    upadateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    upadateEndState();
		
		}
		repaint();
		
		System.out.println("Action");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		rollpin.update(e.getX(), e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (cookie.collisionBox.intersects(rollpin.collisionBox)) {
			streetv=streetv+mult;
		}
	if (streetv==50) {
		
		JOptionPane.showMessageDialog(null, "Looks like you're making some dough! Here's your first Grandma");
		
		mult=2;
		streetv=0;
		
	}
	 
	
	
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
