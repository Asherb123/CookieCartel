package DefaultPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box.Filler;

public class Upgrade extends GameObject {

	public Upgrade(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		isReady=false;
		gramCost=50;
	}

	
	int gramCost;
	Font titleFont;
	boolean isReady;
	
	
	
	void draw(Graphics g) {
		
		titleFont = new Font("Arial", Font.PLAIN, 35);
		
		g.setFont(titleFont);
		g.drawString("New Grandma! $"+ gramCost, x-50, y-5);
	
		
		g.setColor(Color.RED);
		if (isReady == true) {
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.RED);
		}
			
		
		g.fillRect(x, y, width, height);
		
		
	
	}
		
		
		
		
//	}

void update() {
	
	
	
	
	
}

}
