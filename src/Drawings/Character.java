package Drawings;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

public class Character extends JPanel{
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCharacter(g, new Point(1, 3));
    }
	
	public void drawCharacter(Graphics g, Point p) {
		Graphics2D g2d = ( Graphics2D ) g;
		RenderingHints rh
        = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


		rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);


		g2d.setRenderingHints(rh);
		
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(new Color(255, 237, 189));
		g2d.draw(new Rectangle2D.Double(p.x, p.y, 50, 50));
		
	}
}
