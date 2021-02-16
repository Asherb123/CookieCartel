package DefaultPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Cookie extends GameObject {

	public Cookie(int x, int y, int width, int height) {
		super(x, y, width, height);
		collisionBox.width=width-150;
		collisionBox.height=height-150;
		collisionBox.x=x+60;
		collisionBox.y=y+60;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("cookie.png");
		}
	}
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	void draw(Graphics g) {
		
		
        
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
        }
       
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	} 
	
}
