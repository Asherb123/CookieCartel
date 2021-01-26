package DefaultPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class OtherImages extends GameObject {

	public OtherImages(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	
		if (needImage) {
		    loadImage ("Sugar2.png");
		}
		else {
			loadImage ("Sugar1.png");
		}
		
		if (gotImage) {
			loadImage ("money1.png");
		}

		if (gotImage) {
			loadImage ("card.png");
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
