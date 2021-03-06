package DefaultPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Grandmas extends GameObject {

	public Grandmas(int x, int y, int width, int height, String aLevels) {
		super(x, y, width, height );
		// TODO Auto-generated constructor stub
		this.aLevels=aLevels;
		
		if (needImage&& aLevels.equals("right")) {
		    loadImage ("gramRight.png");
		}
		else{
		    loadImage ("GramWGun.jpg");
		}
	
	}
	public  BufferedImage image;
	public  boolean needImage = true;
	public  boolean gotImage = false;	
	String aLevels;
	
	void Draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
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
