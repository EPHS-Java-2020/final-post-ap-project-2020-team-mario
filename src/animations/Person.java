package animations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import mapSetup.Brick;
import mapSetup.DrawMap;
import mapSetup.Floor;
import mapSetup.Spike;
import java.awt.event.MouseEvent;

public class Person extends Sprite {

	private double dx;
	private double dy;
	private int sX;
	private int sY;
	private List<Bullet> bullets;
	private boolean gunRaised = false;
	private boolean isWalking = false;
	public boolean onSomething = false;
	public boolean isAlive = true;
	private final int PERIOD = 66;
	private int time = 0;
	private int count = 0;

	public Person(int x, int y) {
		super(x, y);
		sX = x;
		sY = y;
		bullets = new ArrayList<Bullet>();
	}

	public Person() {
		super(500, 500);
		sX = 500;
		sY = 500;
		bullets = new ArrayList<Bullet>();
	}

	public void move() {
		if (isAlive) {
			super.x += dx;
			super.y += dy;
			if (onSomething&&dx!=0) {
				isWalking = true;
			} else {
				isWalking = false;
			}
			if (count != 0) {
				count--;
			} else {
				gunRaised = false;
			}
		} else {
			super.x = super.x;
			super.y = super.y;
		}
		

	}

	public List<Bullet> getBullets() {
		return bullets;
	}

	@Override
	protected void drawImage(Graphics g) {
		if (isAlive) {
			alivePose(g);
		} else {
			deadPose(g);
		}
	}

	protected void deadPose(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		super.y = 350;

		Rectangle2D blood = new Rectangle2D.Double(sX, super.y + 235, 275, 100);// super.y+10
		g2d.setColor(Color.red);
		g2d.fill(blood);

		Rectangle2D shoe = new Rectangle2D.Double(sX, super.y + 235, 15, 30);// super.y+10
		g2d.setColor(new Color(100, 100, 100));
		g2d.fill(shoe);
		Rectangle2D leg = new Rectangle2D.Double(sX + 15, super.y + 235, 90, 23);// super.y-80
		g2d.setColor(new Color(32, 51, 97));
		g2d.fill(leg);

		Rectangle2D body = new Rectangle2D.Double(sX + 105, super.y + 235, 85, 28);// super.y-165
		g2d.setColor(new Color(77, 73, 73));
		g2d.fill(body);
		Rectangle2D arm = new Rectangle2D.Double(sX + 110, super.y + 239, 80, 20);// super.y-165
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(arm);

		Rectangle2D head = new Rectangle2D.Double(sX + 190, super.y + 230, 50, 50);// super.y-215
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(head);
		Rectangle2D eye = new Rectangle2D.Double(sX + 225, super.y + 260, 10, 10);// super.y-205
		g2d.setColor(new Color(49, 54, 53));
		g2d.fill(eye);
		Rectangle2D hair = new Rectangle2D.Double(sX + 240, super.y + 230, 10, 50);// super.y-225
		g2d.setColor(new Color(87, 49, 26));
		g2d.fill(hair);
	}

	// modify the appearance
	protected void alivePose(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

//        Dimension size = getSize();
//        width =  (int) size.getWidth();
//        super.setWidth(width);
//        height = (int) size.getHeight();
//        super.setHeight(height);

		Rectangle2D hair = new Rectangle2D.Double(sX + 7, super.y - 225, 50, 10);
		g2d.setColor(new Color(87, 49, 26));
		g2d.fill(hair);

		Rectangle2D head = new Rectangle2D.Double(sX + 7, super.y - 215, 50, 50);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(head);
		Rectangle2D eye1 = new Rectangle2D.Double(sX + 10, super.y - 205, 10, 10);
		Rectangle2D eye2 = new Rectangle2D.Double(sX + 31, super.y - 205, 10, 10);
		Rectangle2D mouth = new Rectangle2D.Double(sX + 10, super.y - 182, 30, 7);
		g2d.setColor(new Color(163, 77, 77));
		g2d.fill(mouth);
		g2d.setColor(new Color(49, 54, 53));
		g2d.fill(eye1);
		g2d.fill(eye2);
		Rectangle2D body = new Rectangle2D.Double(sX + 7, super.y - 165, 50, 85);
		g2d.setColor(new Color(77, 73, 73));
		g2d.fill(body);

		Rectangle2D leftArm = new Rectangle2D.Double(sX - 13, super.y - 165, 20, 80);
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(leftArm);

		Rectangle2D leftLeg = null;
		Rectangle2D leftShoe = null;
		Rectangle2D rightLeg = null;
		Rectangle2D rightShoe = null;

		if (time <= 22 && isWalking) {
			leftLeg = new Rectangle2D.Double(sX + 7, super.y - 80, 23, 90);
			rightLeg = new Rectangle2D.Double(sX + 34, super.y - 80, 23, 70);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			leftShoe = new Rectangle2D.Double(sX, super.y + 10, 30, 15);
			rightShoe = new Rectangle2D.Double(sX + 34, super.y - 10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		} else if (time <= 44 && isWalking) {
			leftLeg = new Rectangle2D.Double(sX + 7, super.y - 80, 23, 70);
			rightLeg = new Rectangle2D.Double(sX + 34, super.y - 80, 23, 90);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			leftShoe = new Rectangle2D.Double(sX, super.y - 10, 30, 15);
			rightShoe = new Rectangle2D.Double(sX + 34, super.y + 10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		} else {
			leftLeg = new Rectangle2D.Double(sX + 7, super.y - 80, 23, 90);
			rightLeg = new Rectangle2D.Double(sX + 34, super.y - 80, 23, 90);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			leftShoe = new Rectangle2D.Double(sX, super.y + 10, 30, 15);
			rightShoe = new Rectangle2D.Double(sX + 34, super.y + 10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		}

		time++;
		if (time == PERIOD) {
			time = 0;
		}

		super.height = 250;
		if (gunRaised) {
			super.width = 210; // changed
			Rectangle2D rightArm = new Rectangle2D.Double(sX + 57, super.y - 165, 80, 20);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(rightArm);

			Rectangle2D gunHandle = new Rectangle2D.Double(sX + 137, super.y - 165, 20, 30);
			Rectangle2D gunBarrel = new Rectangle2D.Double(sX + 157, super.y - 165, 40, 15);
			g2d.setColor(new Color(150, 150, 150));
			g2d.fill(gunHandle);
			g2d.fill(gunBarrel);
		} else {
			super.width = 90; // changed

			Rectangle2D rightArm = new Rectangle2D.Double(sX + 57, super.y - 165, 20, 80);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(rightArm);

		}

		for (Bullet bullets : bullets) {
			bullets.drawImage(g2d);
		}

	}

	public Rectangle getBounds() { // changed
		return new Rectangle(sX + 7, super.y - 225, 50, 250);
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void isOnGround(DrawMap map) {
		List<Floor> floors = map.getFloors();
		for (Floor floor: floors) {
			if (getBounds().intersects(floor.getBounds())) {
				onSomething = true;
				return;
			} else {
				onSomething = false;
			}
		}
	}

	public void fall() {
		if (!(dy == 8)) {
			dy += 0.25;
		}
	}

	public void land() {
		dy = 0;
		onSomething = true;
	}

	public void checkCollisions(DrawMap map) {// this method is new
		// System.out.println("checking collisions");
		isOnGround(map);

		List<Brick> bricks = map.getBricks();
		Rectangle personBounds = this.getBounds();

		// System.out.println(person);
		// System.out.println(bricks);
		// int count=0;
		for (Brick brick : bricks) {
			Rectangle brickBounds = brick.getBounds();

			if (brickBounds.intersects(personBounds)) {
				Rectangle2D intersection = getBounds().createIntersection(brick.getBounds());

				if (intersection.getHeight() < intersection.getWidth()) {
					onSomething = true;
				} else {
					if (brick.x - 2 <= intersection.getX() && brick.x + 2 >= intersection.getX()) {
						super.x-=4;
					} else {
						super.x+=4;
					}
				}
				
			}
		}

		List<Spike> spikes = map.getSpikes();
		for (Spike spike : spikes) {
			Rectangle spikeBounds = spike.getBounds();

			if (spikeBounds.intersects(personBounds)) {
				isAlive = false;
				System.out.println("you died, YOLO!");
			}
		}

	}

	// modify movements when keys pressed
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			if (onSomething) {
				dy = -8;
			}
			onSomething = false;
		}

		
		if (key == KeyEvent.VK_LEFT) {
			dx = -4;
			
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 4;
			
		}

	}

	public void mousePressed(MouseEvent e) { //person class

		int mouse = 501; //501 = MouseEvent.MOUSE_PRESSED
		if (mouse == MouseEvent.MOUSE_PRESSED) {
			fire();

			gunRaised = true;
			count = 30;
		} 
		
	}
	
	public void fire() {
		bullets.add(new Bullet(sX + 197, super.y - 160, sX));
	}

	public int getSX() {
		return sX;
	}

	// modify movements when keys released
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

	}

	public String toString() {
		return "{PERSON--> (X=" + super.x + ",Y=" + super.y + ")  (WIDTH=" + super.width + ",HEIGHT=" + super.height
				+ ")}";
	}
}
