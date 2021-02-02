package DefaultPackage;

import java.applet.AudioClip;
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
import java.io.File;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	Font titleFont;
	Font titlefont;

	Timer frameDraw;
	Timer gameTime;
	int countdown;

	Cookie cookie;
	Grandmas gramRight;
	Grandmas gramWGun;

	OtherImages card;
	OtherImages money1;
	OtherImages Sugar1;
	OtherImages Sugar2;

	int streetv = 0;
	RollingPin rollpin;
	int mult = 1;
	int gramCount;

	Upgrade firstUp;
	Upgrade secondUp;
	Upgrade thirdUp;
	Upgrade fourthUp;

	Random rand;

	Song song; 
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titlefont = new Font("Arial", Font.PLAIN, 60);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		cookie = new Cookie(260, 100, 300, 300);
		gramRight = new Grandmas(575, 125, 200, 200, "right");
		gramWGun = new Grandmas(40, 125, 200, 200, "left");
		rollpin = new RollingPin(69, 420, 60, 60);
		firstUp = new Upgrade(315, 400, 175, 50);

		card = new OtherImages(75, 75, 100, 100,"card.png" );
		money1 = new OtherImages(75, 75, 100, 150, "money1.png");
		Sugar1 = new OtherImages(75, 75, 100, 100, "sugar1.png");
		Sugar2 = new OtherImages(75, 75, 100, 100, "sugar2.png");

		rand = new Random();
			song = new Song("dopeSong.mp3");
			song.play();
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;


	
	
	
	
	void upadateMenuState() {

	}

	void updateGameState() {
		if (streetv >= firstUp.gramCost) {
			firstUp.isReady = true;
		} else {
			firstUp.isReady = false;
		}

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

		card.draw(g);
		money1.draw(g);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, CookieCartel.WIDTH, CookieCartel.HEIGHT);

		cookie.draw(g);
		gramRight.Draw(g);
		gramWGun.Draw(g);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Street Value = $" + streetv, 10, 40);

		firstUp.draw(g);

		if (streetv == firstUp.gramCost) {
			// firstUp.setColor(Color.GREEN);
		}

		// secondUp.draw(g);
		// thirdUp.draw(g);
		// fourthUp.draw(g);
		rollpin.draw(g);

		g.setColor(Color.BLACK);
		g.drawString("" + countdown, 700, 45);

		g.drawString("Grandma Count = " + gramCount, 10, 75);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CookieCartel.WIDTH, CookieCartel.HEIGHT);

		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("Haha You Suck", 175, 100);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Your Street Value Was $" + streetv, 100, 300);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;

			} else if (currentState == MENU) {
				countdown = 60;
				gameTime = new Timer(1000, this);
				currentState = GAME;
				gameTime.start();
				firstUp.gramCost = 50;
				gramCount = 0;
				mult = 1;
			} else {
				currentState++;
			}

		}

		if (currentState == MENU && e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null,
					"You are now the leader of a Cookie Cartel. \n Click the cookie, and you and your grandmas will bake cookies, which will make your street value go up. \n Every grandma takes money out of your street value. Generate as much street value as possible in the time given!");

		}

		if (currentState == GAME && e.getKeyCode() == KeyEvent.VK_ENTER) {
			streetv = 0;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			upadateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			upadateEndState();

		}

		if (e.getSource() == gameTime) {
			countdown = countdown - 1;
		}

		if (countdown == 0 && currentState == GAME) {
			currentState = END;

		}

		repaint();

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
		if (cookie.collisionBox.intersects(rollpin.collisionBox) && currentState == GAME) {
			streetv = streetv + mult;
		}

		if (rollpin.collisionBox.intersects(firstUp.collisionBox) && streetv >= firstUp.gramCost) {

			streetv = streetv - firstUp.gramCost;
			firstUp.gramCost = firstUp.gramCost + 50 + rand.nextInt(50 + 1);
			mult = mult + 1;

			grandma();

		}

	}

	void grandma() {

		gramCount = mult - 1;

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
