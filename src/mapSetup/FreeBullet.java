package mapSetup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class FreeBullet extends Obstacle{

	public FreeBullet(int x, int y) {
		super(x, y, 0);
	}
	
	public void drawImage(int x, int y, Graphics g) {
		super.x = sX-x;
		super.y = sY-y;
		
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
		
		Rectangle2D bullet = new Rectangle2D.Double(super.x, super.y, 35, 5);
		g2d.setColor(new Color(50,50,50));
		g2d.fill(bullet);

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,35,5);
	}
}
