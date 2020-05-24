package animations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class Bullet extends Sprite {

    private final int BOARD_WIDTH = 1000;
    private final int BULLET_SPEED = 7;

    public Bullet(int x, int y) {
        super(x, y);
    }

    public void move(int charP) {
        
        super.x += BULLET_SPEED;
        
        if (super.x > charP + 700) {
            visible = false;
        }
    }

	@Override
	protected void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        super.setWidth((int) size.getWidth());
        super.setHeight((int) size.getHeight());
        
        int len = 30+(int)(Math.random()*10);
        Rectangle2D bullet = new Rectangle2D.Double(x, y, len, 5);
        
        
        g2d.setColor(new Color(255, 0, 0));
        g2d.fill(bullet);

	}
}