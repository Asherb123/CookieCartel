package DefaultPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

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
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titlefont = new Font("Arial", Font.PLAIN, 60);
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	
	
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
		
		
		
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CookieCartel.WIDTH,CookieCartel.HEIGHT);
		
		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("Haha You Suck", 175, 100);
		
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

}
