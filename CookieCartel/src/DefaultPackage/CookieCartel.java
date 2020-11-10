package DefaultPackage;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CookieCartel {
	public static void main(String[] args) {

		CookieCartel c = new CookieCartel();
		c.setUp();

	}

	JFrame frame;

	public static final int HEIGHT = 500;
	public static final int WIDTH = 800;
	GamePanel gamep;

	public CookieCartel() {

		frame = new JFrame();
		gamep = new GamePanel();
		frame.add(gamep);

	}

	void setUp() {

		frame.setSize(WIDTH, HEIGHT);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

}
