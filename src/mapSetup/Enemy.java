package mapSetup;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;

public class Enemy extends Obstacle{
	
	private int time = 0;
	private int timeToWalk = 0;
	private final int PERIOD = 66;
	private int walkingTime = 200;
	private boolean forward = true;
	
	public Enemy(int x, int y, int speed) {
		super(x,y,speed);
	}
	
	@Override
	public void drawImage(Graphics g) {
		
		if (forward) {
			sX+=super.speed;
		} else {
			sX-=super.speed;
		}
	
	      Graphics2D g2d = (Graphics2D) g;

			  RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			  rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

			  g2d.setRenderingHints(rh);
	      Rectangle2D hat = new Rectangle2D.Double(x,y,75,10);
	      Rectangle2D topHat = new Rectangle2D.Double(x,y-10,50,10);
	      g2d.setColor(new Color(0, 6, 94));
	      g2d.fill(hat);
	      g2d.fill(topHat);

	      Rectangle2D head = new Rectangle2D.Double(x,y+10,50,50);
	      g2d.setColor(new Color(255, 210, 143));
	      g2d.fill(head);

	      //glasses
	      Ellipse2D rightLens = new Ellipse2D.Double(x+35,y+15,25,20);
	      g2d.setColor(new Color(0, 0, 0));
	      g2d.fill(rightLens);
	      Rectangle2D noseBridge = new Rectangle2D.Double(x+15,y+20,30,10);
	      g2d.setColor(new Color(0, 0, 0));
	      g2d.fill(noseBridge);
	      Ellipse2D leftLens = new Ellipse2D.Double(x,y+15,25,20);
	      g2d.setColor(new Color(0, 0, 0));
	      g2d.fill(leftLens);

	      //mouth
	      Ellipse2D mouth = new Ellipse2D.Double(x+5, y+40,40,20);
	      g2d.setColor(new Color(128, 78, 68));
	      g2d.fill(mouth);
	      Ellipse2D mouthBelow = new Ellipse2D.Double(x+5, y+43,45,20);
	      g2d.setColor(new Color(255, 210, 143));
	      g2d.fill(mouthBelow);
	      
	      Rectangle2D body = new Rectangle2D.Double(x,y+60,50,85);
	      g2d.setColor(new Color(10, 16, 94));
	      g2d.fill(body);
	      int temp = 0;
	      g2d.setColor(new Color(255, 255, 255));
	      for (temp = 0; temp < 80; temp += 20) {
	        Ellipse2D button = new Ellipse2D.Double(x+25,y+68 + temp, 5,5);
	        g2d.fill(button);
	      }
	  
	      Rectangle2D leftArm = new Rectangle2D.Double(x-20,y+60,17,60);
	      Rectangle2D rightArm = new Rectangle2D.Double(x+53, y+ 60, 17, 60);
	      g2d.setColor(new Color(10, 16, 94));
	      Line2D leftLine = new Line2D.Double(x-3,y+62,x-3,y+80);
	      Line2D rightLine = new Line2D.Double(x+50,y+62,x+50,y+80);
	      g2d.fill(leftArm);
	      g2d.fill(rightArm);
	      g2d.setStroke(new BasicStroke(5));
	      g2d.draw(leftLine);
	      g2d.draw(rightLine);

	      Rectangle2D leftHand = new Rectangle2D.Double(x-18,y+120,15,20);
	      Rectangle2D rightHand = new Rectangle2D.Double(x+53,y+120,15,20);
	      g2d.setColor(new Color(255, 210, 143));
	      
	      g2d.fill(leftHand);
	      g2d.fill(rightHand);
	      
	      
	      if (time <= 22) {
	    	  Rectangle2D leftLeg = new Rectangle2D.Double(x,y+145,17,70);
		      Rectangle2D rightLeg = new Rectangle2D.Double(x+33,y+145,17,80);
		      g2d.setColor(new Color(77, 68, 64));
		      g2d.fill(leftLeg);
		      g2d.fill(rightLeg);

		      Rectangle2D leftShoe = new Rectangle2D.Double(x, y+215, 25, 15);
		      Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y+225, 25, 15);
		      g2d.setColor(Color.black);
		      g2d.fill(leftShoe);
		      g2d.fill(rightShoe);
	      } else if (time <= 44) {
	    	  Rectangle2D leftLeg = new Rectangle2D.Double(x,y+145,17,80);
		      Rectangle2D rightLeg = new Rectangle2D.Double(x+33,y+145,17,80);
		      g2d.setColor(new Color(77, 68, 64));
		      g2d.fill(leftLeg);
		      g2d.fill(rightLeg);

		      Rectangle2D leftShoe = new Rectangle2D.Double(x, y+225, 25, 15);
		      Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y+225, 25, 15);
		      g2d.setColor(Color.black);
		      g2d.fill(leftShoe);
		      g2d.fill(rightShoe);
	      } else {
	    	  Rectangle2D leftLeg = new Rectangle2D.Double(x,y+145,17,80);
		      Rectangle2D rightLeg = new Rectangle2D.Double(x+33,y+145,17,70);
		      g2d.setColor(new Color(77, 68, 64));
		      g2d.fill(leftLeg);
		      g2d.fill(rightLeg);

		      Rectangle2D leftShoe = new Rectangle2D.Double(x, y+225, 25, 15);
		      Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y+215, 25, 15);
		      g2d.setColor(Color.black);
		      g2d.fill(leftShoe);
		      g2d.fill(rightShoe);
	      }
	      time++;
	      if (time == PERIOD) {
	    	  time = 0;
	      }
	      timeToWalk++;
	      if (timeToWalk == walkingTime) {
	    	  forward = !forward;
	    	  timeToWalk = 0;
	      }
	     
	      
	    }

}
