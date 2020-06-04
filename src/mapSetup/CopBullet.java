package mapSetup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class CopBullet extends Obstacle{
	
	public int startPos;
	public boolean isLeft;
	
	public CopBullet(int x, int y, int speed, boolean isLeft) {
		super(x,y,speed);
		startPos = sX;
		this.isLeft = isLeft;
		
	}
	
	
	public void move() {
		if (isLeft) {
			sX+=speed;
			if (startPos - sX == -1000) {
				visible = false;
			}
		} else {
			sX-=speed;
			if (startPos - sX == 1000) {
				visible = false;
			}
		}
		
	}
	
	@Override
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		Rectangle2D bullet = new Rectangle2D.Double(x,y,30, 6);
		g2d.setColor(Color.green);
		g2d.fill(bullet);
		
		

	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,30,6);
	}

}
