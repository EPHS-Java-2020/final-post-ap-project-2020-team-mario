package animations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import mapSetup.Obstacle;

public class Bullet extends Obstacle{

	private final int BOARD_WIDTH = 1000;
	private final int BULLET_SPEED = 7;
	private boolean facingRight;
	private int length;
	public AffineTransform tx;
	

	public Bullet(int x, int y, int charP, boolean facingRight, AffineTransform tx) {
		super(x, y, 0);
		length = charP;
		this.facingRight = facingRight;
		this.tx = tx;
	}

	public void move() {
		if (facingRight) {
			super.x += BULLET_SPEED;
		} else {
			super.x -= BULLET_SPEED;
		}

		if (super.x > length + 700) {
			visible = false;
		}
	}
	

	@Override
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		Dimension size = getSize();
		super.setWidth((int) size.getWidth());
		super.setHeight((int) size.getHeight());

		int len = 30 + (int) (Math.random() * 10);
		Rectangle2D bullet = new Rectangle2D.Double(x, y, len, 5);

		g2d.setColor(new Color(255, 0, 0));
		if (tx == null) {
			g2d.fill(bullet);
		} else {
			Shape newShape = tx.createTransformedShape(bullet);
			g2d.fill(newShape);
		}
		

	}
}