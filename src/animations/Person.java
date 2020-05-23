package animations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Person extends Sprite {

	private int dx;
    private int dy;
    private boolean gunRaised=false;
    private boolean isWalking=false;
    private final int PERIOD=99;
    private int time=0;

    public Person(int x, int y) {
        super(x, y);
    }
    
    public Person() {
        super(500, 500);
    }

    public void move() {
    	super.x += dx;
        super.y += dy;
        if(super.x>1000) {super.x=0;}
        
    }
    
    
    

  //modify the appearance
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
        width =  (int) size.getWidth();
        super.setWidth(width);
        height = (int) size.getHeight();
        super.setHeight(height);
        
        Rectangle2D hair = new Rectangle2D.Double(super.x+7, super.y-225, 50, 10);
        g2d.setColor(new Color(87, 49, 26));
        g2d.fill(hair);

        Rectangle2D head = new Rectangle2D.Double(super.x+7, super.y-215, 50, 50);
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(new Color(255, 210, 143));
        g2d.fill(head);
        Rectangle2D eye1 = new Rectangle2D.Double(super.x+10, super.y-205, 10, 10);
        Rectangle2D eye2 = new Rectangle2D.Double(super.x+31, super.y-205, 10, 10);
        Rectangle2D mouth = new Rectangle2D.Double(super.x+10, super.y-182, 30, 7);
        g2d.setColor(new Color(163, 77, 77));
        g2d.fill(mouth);
        g2d.setColor(new Color(49, 54, 53));
        g2d.fill(eye1);
        g2d.fill(eye2);
        Rectangle2D body = new Rectangle2D.Double(super.x+7, super.y-165, 50, 85);
        g2d.setColor(new Color(77, 73, 73));
        g2d.fill(body);

     
        Rectangle2D leftArm = new Rectangle2D.Double(super.x - 13, super.y - 165, 20, 80);
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(leftArm);
		
		Rectangle2D leftLeg = null;
		Rectangle2D leftShoe = null;
		Rectangle2D rightLeg = null;
		Rectangle2D rightShoe = null;
		
		if(time<=33 && isWalking) {
			leftLeg = new Rectangle2D.Double(super.x+7, super.y-80, 23, 90);
			rightLeg = new Rectangle2D.Double(super.x+34, super.y-80, 23, 70);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);
			
			leftShoe = new Rectangle2D.Double(super.x, super.y+10, 30, 15);    
			rightShoe = new Rectangle2D.Double(super.x+34, super.y-10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		}else if(time<=66 && isWalking) {
			leftLeg = new Rectangle2D.Double(super.x+7, super.y-80, 23, 70);
			rightLeg = new Rectangle2D.Double(super.x+34, super.y-80, 23, 90);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);
			
			leftShoe = new Rectangle2D.Double(super.x, super.y-10, 30, 15);    
			rightShoe = new Rectangle2D.Double(super.x+34, super.y+10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		}else {
			leftLeg = new Rectangle2D.Double(super.x+7, super.y-80, 23, 90);
			rightLeg = new Rectangle2D.Double(super.x+34, super.y-80, 23, 90);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);
			
			leftShoe = new Rectangle2D.Double(super.x, super.y+10, 30, 15);    
			rightShoe = new Rectangle2D.Double(super.x+34, super.y+10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		}
		
		time++;
		if(time==PERIOD) {
			time=0;
		}
        
        
        if(gunRaised) {
        	 Rectangle2D rightArm = new Rectangle2D.Double(super.x+57, super.y-165, 80, 20);
             g2d.setColor(new Color(255, 210, 143));
             g2d.fill(rightArm);
             
            
            Rectangle2D gunHandle = new Rectangle2D.Double(super.x+137, super.y-165, 20, 30);
            Rectangle2D gunBarrel = new Rectangle2D.Double(super.x+157, super.y-165, 40, 15);
            g2d.setColor(new Color(150, 150, 150));
            g2d.fill(gunHandle);
            g2d.fill(gunBarrel);
        }else {
        	 Rectangle2D rightArm = new Rectangle2D.Double(super.x+57, super.y-165, 20, 80);
             g2d.setColor(new Color(255, 210, 143));
             g2d.fill(rightArm);
             
        }
       
        

	}
	
	//modify movements when keys pressed
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
            gunRaised=true;
		} else {

			gunRaised=false;
			isWalking=true;
			if (key == KeyEvent.VK_LEFT) {
				dx = -4;
			}

			if (key == KeyEvent.VK_RIGHT) {
				dx = 4;
			}

			if (key == KeyEvent.VK_UP) {
				dy = -2;
			}

			if (key == KeyEvent.VK_DOWN) {
				dy = 2;
			}
			
		}
    }    
	



	//modify movements when keys released
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();
        isWalking=false;

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}

