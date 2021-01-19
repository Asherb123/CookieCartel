package DefaultPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box.Filler;

public class Upgrade extends GameObject {

	public Upgrade(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	
	int gramCost=50;
	Font titleFont;
	void draw(Graphics g) {
		
		titleFont = new Font("Arial", Font.PLAIN, 35);
		
		g.setFont(titleFont);
		g.drawString("New Grandma! $"+ gramCost, x-50, y-5);
	
		
		g.setColor(Color.YELLOW);

		g.fillRect(x, y, width, height);
		
		
		
		
		
		
	}
void update() {
	
	
	
	
	
}

}
