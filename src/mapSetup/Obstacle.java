package mapSetup;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import animations.Sprite;

public abstract class Obstacle extends Sprite{
	
	public ImageIcon ii;
	public Image image;
	public int sX;
	public int sY;
	
	public Obstacle(int x, int y, int speed) {
		super(x,y);
		sX=x;
		sY=y;
		loadImage();
	}
	
	public void loadImage() {
		
	}
	
	public void drawImage(int x, int y, Graphics g) {
		super.x=sX-x;
		
		//super.x+=x;
		
		super.y=sY; //super.y-=y
		drawImage(g);
		
	}
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.setRenderingHints(rh);
		
		g2d.drawImage(image, super.x, super.y, this);
	}
	public boolean intersects(Rectangle rect) {
		return rect.intersects(getBounds());
	}
	public Rectangle getBounds() {
		return new Rectangle(super.x, super.y, image.getWidth(null), image.getHeight(null));
	}
	
	
}