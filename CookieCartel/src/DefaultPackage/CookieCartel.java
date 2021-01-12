package DefaultPackage;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CookieCartel {
	public static void main(String[] args) {

		CookieCartel c = new CookieCartel();
		c.setUp();
		
	}

	JFrame frame;
	
	BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
	
	
	public static final int HEIGHT = 500;
	public static final int WIDTH = 800;
	GamePanel gamep;
	
public CookieCartel() {

		frame = new JFrame();
		gamep = new GamePanel();
		frame.add(gamep);
		frame.addKeyListener(gamep);
		frame.addMouseListener(gamep);
		frame.addMouseMotionListener(gamep);
		
	}

	void setUp() {

		frame.setSize(WIDTH, HEIGHT);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
		frame.getContentPane().setCursor(blankCursor);
	}

}
