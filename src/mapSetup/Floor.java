package mapSetup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Floor extends Obstacle{
	
	private int length;
	
	
	public Floor(int x, int y, int speed, int length) {
		super(x,y, speed);
		this.length = length;
	}
	
	@Override
	public void drawImage(int x, int y, Graphics g) {
		super.x=sX-x;
		
		
		super.y=sY-y; 
		drawImage(g);
		
	}
	@Override
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.setRenderingHints(rh);
		
		Rectangle2D floor = new Rectangle2D.Double(super.x, super.y, length, 100);// super.y+10
        g2d.setColor(new Color(0, 75, 0));
        g2d.fill(floor);
	}
	@Override
	public boolean intersects(Rectangle rect) {
		return false;
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(super.x, super.y, length, 100);
	}

	

}
