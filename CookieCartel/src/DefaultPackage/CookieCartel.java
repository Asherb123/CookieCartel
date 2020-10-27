package DefaultPackage;

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

public CookieCartel() {
	
 frame = new JFrame();
	
	
	
	
	
}




void setUp() {
	
	frame.setSize(WIDTH, HEIGHT);
	
	
	
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}

}
