package DefaultPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class OtherImages extends GameObject {

	String imageName;
	public OtherImages(int x, int y, int width, int height, String imageName) {
	super(x, y, width, height);
		// TODO Auto-generated constructor stub
	this.imageName=imageName;
		if (needImage) {
		    loadImage (imageName);
		}
		
		
	}

	public  BufferedImage image;
	public  boolean needImage = true;
	public  boolean gotImage = false;	
	
	void draw(Graphics g) {
		
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
		
	}

void update() {
	
	
	
	
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
