package mapSetup;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

import animations.Bullet;

public class Enemy extends Obstacle {

	private int time = 0;
	private int timeToWalk = 0;
	private final int PERIOD = 66;
	private int walkingTime = 200;
	private int bulletCounting = 0;
	private int bulletTime;
	private boolean forward = true;
	public int pX;
	public int injuryTime=0;
	public int pY;
	private int shotCount=0;
	public ArrayList<CopBullet> bullets;
	private boolean isLeft;

	public Enemy(int x, int y, int speed, int bulletTime) {
		super(x, y, speed);
		bullets = new ArrayList<CopBullet>();
		this.bulletTime = bulletTime;
	}

	@Override
	public void drawImage(int x, int y, Graphics g) {
		super.x = sX - x;

		super.y = sY - y;
		pX = x;
		pY = y;
		drawImage(g);

	}

	public void drawImage(Graphics g) {
		
		if (x < 500) {
			isLeft = true;
		} else {
			isLeft = false;
		}

		if (forward) {
			sX += super.speed;
		} else {
			sX -= super.speed;
		}

		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
		
		if (isLeft) {
			Rectangle2D hat = new Rectangle2D.Double(x - 20, y, 90, 10);
			Rectangle2D topHat = new Rectangle2D.Double(x, y - 20, 50, 20);
			g2d.setColor(new Color(50,50,50));
			g2d.fill(hat);
			g2d.fill(topHat);
		} else {
			Rectangle2D hat = new Rectangle2D.Double(x - 20, y, 90, 10);
			Rectangle2D topHat = new Rectangle2D.Double(x, y - 20, 50, 20);
			g2d.setColor(new Color(50, 50, 50));
			g2d.fill(hat);
			g2d.fill(topHat);
		}

		Rectangle2D head = new Rectangle2D.Double(x, y + 10, 50, 50);
		if(injuryTime>0) {
			g2d.setColor(new Color(255, 0, 0));
		}else{
			g2d.setColor(new Color(255, 210, 143));
		}
		g2d.fill(head);

		// glasses
		if (isLeft) {
			Ellipse2D rightLens = new Ellipse2D.Double(x + 35, y + 15, 25, 20);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(rightLens);
			Rectangle2D noseBridge = new Rectangle2D.Double(x + 15, y + 20, 30, 10);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(noseBridge);
			Ellipse2D leftLens = new Ellipse2D.Double(x, y + 15, 25, 20);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(leftLens);
		} else {
			Ellipse2D rightLens = new Ellipse2D.Double(x + 25, y + 15, 25, 20);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(rightLens);
			Rectangle2D noseBridge = new Rectangle2D.Double(x + 5, y + 20, 30, 10);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(noseBridge);
			Ellipse2D leftLens = new Ellipse2D.Double(x - 10, y + 15, 25, 20);
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(leftLens);
		}

		// mouth
		if (isLeft) {
			Ellipse2D mouth = new Ellipse2D.Double(x + 5, y + 40, 40, 20);
			g2d.setColor(new Color(128, 78, 68));
			g2d.fill(mouth);
			Ellipse2D mouthBelow = new Ellipse2D.Double(x + 5, y + 43, 45, 20);
			if(injuryTime>0) {
				g2d.setColor(new Color(255,0,0));
			}else {
				g2d.setColor(new Color(255, 210, 143));
			}
			g2d.fill(mouthBelow);
		} else {
			Ellipse2D mouth = new Ellipse2D.Double(x + 5, y + 40, 40, 20);
			g2d.setColor(new Color(128, 78, 68));
			g2d.fill(mouth);
			Ellipse2D mouthBelow = new Ellipse2D.Double(x, y + 43, 45, 20);
			if(injuryTime>0) {
				g2d.setColor(new Color(255,0,0));
			}else {
				g2d.setColor(new Color(255, 210, 143));
			}
			g2d.fill(mouthBelow);
		}

		Rectangle2D body = new Rectangle2D.Double(x, y + 60, 50, 85);
		g2d.setColor(new Color(50, 50, 50));
		g2d.fill(body);
		int temp = 0;
		g2d.setColor(new Color(255, 255, 255));
		for (temp = 0; temp < 80; temp += 20) {
			Ellipse2D button = new Ellipse2D.Double(x + 25, y + 68 + temp, 5, 5);
			g2d.fill(button);
		}
		
		if (isLeft) {
			Rectangle2D leftArm = new Rectangle2D.Double(x - 20, y + 60, 17, 60);
			Line2D leftLine = new Line2D.Double(x - 2, y + 62, x - 2, y + 77);
			//Rectangle2D rightArm = new Rectangle2D.Double(x + 53, y + 60, 17, 60);
			Rectangle2D rightArm = new Rectangle2D.Double(x + 53, y + 60, 60, 17);
			g2d.setColor(new Color(50,50,50));
			Line2D rightLine = new Line2D.Double(x + 50, y + 62, x + 50, y + 77);
			g2d.fill(leftArm);
			g2d.fill(rightArm);
			g2d.setStroke(new BasicStroke(5));
			g2d.draw(rightLine);
			g2d.draw(leftLine);

			Rectangle2D leftHand = new Rectangle2D.Double(x - 18, y + 120, 15, 20);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(leftHand);
			//Rectangle2D rightHand = new Rectangle2D.Double(x + 53, y + 120, 15, 20);
			Rectangle2D rightHand = new Rectangle2D.Double(x + 113, y + 60, 20, 15);
			g2d.setColor(new Color(150,150,150));
			g2d.fill(rightHand);
			Rectangle2D gun = new Rectangle2D.Double(x+113,y+50, 40, 10);
			g2d.fill(gun);
		} else {
			Rectangle2D leftArm = new Rectangle2D.Double(x - 63, y + 60, 60, 17);
			Rectangle2D rightArm = new Rectangle2D.Double(x + 53, y + 60, 17, 60);
			Line2D leftLine = new Line2D.Double(x - 2, y + 62, x - 2, y + 77);
			g2d.setColor(new Color(50,50,50));
			Line2D rightLine = new Line2D.Double(x + 50, y + 62, x + 50, y + 77);
			g2d.fill(leftArm);
			g2d.fill(rightArm);
			g2d.setStroke(new BasicStroke(5));
			g2d.draw(leftLine);
			g2d.draw(rightLine);

			Rectangle2D rightHand = new Rectangle2D.Double(x + 53, y + 120, 15, 20);
			Rectangle2D leftHand = new Rectangle2D.Double(x - 83, y + 60, 20, 15);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(rightHand);
			g2d.setColor(new Color(150,150,150));
			g2d.fill(leftHand);
			Rectangle2D gun = new Rectangle2D.Double(x-103,y+50, 40, 10);
			g2d.fill(gun);
		}

		

		if (time <= 22) {
			Rectangle2D leftLeg = new Rectangle2D.Double(x, y + 145, 17, 70);
			Rectangle2D rightLeg = new Rectangle2D.Double(x + 33, y + 145, 17, 80);
			g2d.setColor(new Color(77, 68, 64));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			if (isLeft) {
				Rectangle2D leftShoe = new Rectangle2D.Double(x, y + 215, 25, 15);
				Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y + 225, 25, 15);
				g2d.setColor(Color.black);
				g2d.fill(leftShoe);
				g2d.fill(rightShoe);
			} else {
				Rectangle2D leftShoe = new Rectangle2D.Double(x - 10, y + 215, 25, 15);
				Rectangle2D rightShoe = new Rectangle2D.Double(x + 23, y + 225, 25, 15);
				g2d.setColor(Color.black);
				g2d.fill(leftShoe);
				g2d.fill(rightShoe);
			}
		} else if (time <= 44) {
			Rectangle2D leftLeg = new Rectangle2D.Double(x, y + 145, 17, 80);
			Rectangle2D rightLeg = new Rectangle2D.Double(x + 33, y + 145, 17, 80);
			g2d.setColor(new Color(77, 68, 64));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			if (isLeft) {
				Rectangle2D leftShoe = new Rectangle2D.Double(x, y + 225, 25, 15);
				Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y + 225, 25, 15);
				g2d.setColor(Color.black);
				g2d.fill(leftShoe);
				g2d.fill(rightShoe);
			} else {
				Rectangle2D leftShoe = new Rectangle2D.Double(x - 10, y + 225, 25, 15);
				Rectangle2D rightShoe = new Rectangle2D.Double(x + 23, y + 225, 25, 15);
				g2d.setColor(Color.black);
				g2d.fill(leftShoe);
				g2d.fill(rightShoe);
			}
		} else {
			Rectangle2D leftLeg = new Rectangle2D.Double(x, y + 145, 17, 80);
			Rectangle2D rightLeg = new Rectangle2D.Double(x + 33, y + 145, 17, 70);
			g2d.setColor(new Color(77, 68, 64));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			if (isLeft) {
				Rectangle2D leftShoe = new Rectangle2D.Double(x, y + 225, 25, 15);
				Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y + 215, 25, 15);
				g2d.setColor(Color.black);
				g2d.fill(leftShoe);
				g2d.fill(rightShoe);
			} else {
				Rectangle2D leftShoe = new Rectangle2D.Double(x - 10, y + 225, 25, 15);
				Rectangle2D rightShoe = new Rectangle2D.Double(x + 23, y + 215, 25, 15);
				g2d.setColor(Color.black);
				g2d.fill(leftShoe);
				g2d.fill(rightShoe);
			}
		}
		time++;
		if(injuryTime>0) {
			injuryTime--;
		}
		bulletCounting++;
		if (time == PERIOD) {
			time = 0;
		}
		timeToWalk++;
		if (timeToWalk == walkingTime) {
			forward = !forward;
			timeToWalk = 0;
		} 
		if (this.visible  &&  bulletCounting == bulletTime)  {
			bulletCounting = 0;
			CopBullet bullet;
			if (isLeft) {
				bullet = new CopBullet(sX+123,sY+55, 5, isLeft);
			} else {
				bullet = new CopBullet(sX - 108, sY + 55, 5, isLeft);
			}
			bullets.add(bullet);

		}
		for (int i = 0; i < bullets.size(); i++) {

			CopBullet bullet1 = bullets.get(i);

			if (bullet1.isVisible()) {
				bullet1.move();
				bullet1.drawImage(pX, pY, g);
			} else {
				bullets.remove(i);
			}

		}

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y-10,50, 250);
	}
	
	public void checkCollisions(List<Bullet> list) {////
		for(Bullet bullet: list) {
			if(bullet.getBounds().intersects(this.getBounds())) {
				shotCount++;
				injuryTime=15;
				bullet.visible=false;
				if(shotCount==3) {
					this.visible=false;
				}
			}
		}
	}
	public ArrayList<CopBullet> getBullets() {
		return bullets;
	}

}
