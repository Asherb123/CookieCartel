package DefaultPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Box.Filler;

public class Upgrade extends GameObject {

	public Upgrade(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		
		g.setColor(Color.BLUE);

		g.drawRect(10, 400, 25, 25);
		
		
		
	}
void update() {
	
	
	
	
	
}

}
