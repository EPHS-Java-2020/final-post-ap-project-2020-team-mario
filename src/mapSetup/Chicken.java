package mapSetup;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import animations.Sprite;

public class Chicken extends Obstacle{
	private int dx=1;
	private int walkingTimer=0;
	private int walkingTime=180;
	private int stepTimer=0;
	private int stepTime=66;
	public boolean isEgg = false;
	
	public Chicken(int x, int y, int speed, int dx, int walkingDistance) {
		super(x,y, speed);
		this.dx=dx;
		this.walkingTime=walkingDistance;
	}
	
	public void loadImage() {
		ii = new ImageIcon("src/Drawings/Egg.png");
		image = ii.getImage();
		super.width=ii.getIconWidth();
		super.height=ii.getIconHeight();
	}
	
	public void drawEgg(Graphics g) {
		
		y+=30;
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.drawImage(image, x, y, null);
		
		y-=30;

	}
	
	
	@Override
	public void drawImage(int x, int y, Graphics g) {
		super.x=sX-x;
		
		super.y=sY-y;
		if (isEgg) {
			drawEgg(g);
		} else {
			
			drawImage(g);
			
		}
	}
	
	@Override
	public void drawImage(Graphics g) {
		sX+=dx;
		
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
		Rectangle2D head = new Rectangle2D.Double(x, y, 30, 30);
		g2d.setColor(new Color(242, 224, 124));
		g2d.fill(head);

		Rectangle2D rightEye = new Rectangle2D.Double(x, y + 5, 5, 5);
		g2d.setColor(new Color(0, 0, 0));
		g2d.fill(rightEye);
		Rectangle2D leftEye = new Rectangle2D.Double(x + 10, y + 5, 5, 5);
		g2d.setColor(new Color(0, 0, 0));
		g2d.fill(leftEye);

		Rectangle2D beak = new Rectangle2D.Double(x - 17, y + 12, 27, 10);
		Line2D seperate = new Line2D.Double(x - 17, y + 16, x + 10, y + 17);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(245, 118, 69));
		g2d.fill(beak);
		g2d.setColor(Color.black);
		g2d.draw(seperate);
		Rectangle2D bottomBeak = new Rectangle2D.Double(x - 5, y + 22, 13, 3);
		g2d.setColor(new Color(240, 75, 12));
		g2d.fill(bottomBeak);

		Rectangle2D neck = new Rectangle2D.Double(x + 15, y + 30, 15, 5);
		g2d.setColor(new Color(242, 224, 124));
		g2d.fill(neck);

		Rectangle2D body = new Rectangle2D.Double(x + 12, y + 35, 50, 40);
		g2d.setColor(new Color(219, 207, 178));
		g2d.fill(body);

		
		if(stepTimer<=22) {
			Rectangle2D rightLeg = new Rectangle2D.Double(x + 25, y + 75, 2, 25);
			g2d.setColor(new Color(173, 147, 81));
			g2d.fill(rightLeg);
			Rectangle2D rightFoot = new Rectangle2D.Double(x + 20, y + 100, 7, 5);
			g2d.setColor(new Color(219, 149, 83));
			g2d.fill(rightFoot);
			
			
			Rectangle2D leftLeg = new Rectangle2D.Double(x + 35, y + 75, 2, 20);
			g2d.setColor(new Color(173, 147, 81));
			g2d.fill(leftLeg);
			Rectangle2D leftFoot = new Rectangle2D.Double(x + 30, y + 95, 7, 5);
			g2d.setColor(new Color(219, 149, 83));
			g2d.fill(leftFoot);
		}else if(stepTimer<=44) {
			Rectangle2D rightLeg = new Rectangle2D.Double(x + 25, y + 75, 2, 25);
			g2d.setColor(new Color(173, 147, 81));
			g2d.fill(rightLeg);

			Rectangle2D leftLeg = new Rectangle2D.Double(x + 35, y + 75, 2, 25);
			g2d.setColor(new Color(173, 147, 81));
			g2d.fill(leftLeg);

			Rectangle2D rightFoot = new Rectangle2D.Double(x + 20, y + 100, 7, 5);
			g2d.setColor(new Color(219, 149, 83));
			g2d.fill(rightFoot);

			Rectangle2D leftFoot = new Rectangle2D.Double(x + 30, y + 100, 7, 5);
			g2d.setColor(new Color(219, 149, 83));
			g2d.fill(leftFoot);
		}else {
			Rectangle2D leftLeg = new Rectangle2D.Double(x + 35, y + 75, 2, 25);
			g2d.setColor(new Color(173, 147, 81));
			g2d.fill(leftLeg);
			Rectangle2D leftFoot = new Rectangle2D.Double(x + 30, y + 100, 7, 5);
			g2d.setColor(new Color(219, 149, 83));
			g2d.fill(leftFoot);
			
			Rectangle2D rightLeg = new Rectangle2D.Double(x + 25, y + 75, 2, 20);
			g2d.setColor(new Color(173, 147, 81));
			g2d.fill(rightLeg);
			Rectangle2D rightFoot = new Rectangle2D.Double(x + 20, y + 95, 7, 5);
			g2d.setColor(new Color(219, 149, 83));
			g2d.fill(rightFoot);

			
		}
		
		
		stepTimer++;
		if(stepTimer==66) {
			stepTimer=0;
		}
		walkingTimer++;
		if(walkingTimer==walkingTime) {
			walkingTimer=0;
			dx*=-1;
		}
	}
	
	
	public String toString() {
		return "{BRICK--> (X="+super.x+",Y="+super.y+")  (WIDTH="+super.width+",HEIGHT="+super.height+")}";
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,66,100);
	}
	
	
	

}
