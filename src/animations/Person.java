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
import mapSetup.CopBullet;
import mapSetup.DrawMap;
import mapSetup.Floor;
import mapSetup.Spike;
import java.awt.event.MouseEvent;

public class Person extends Sprite {

	private double dx;
	private double dy;
	private final int sX;
	private final int sY;
	private List<Bullet> bullets;
    private boolean gunRaisedRight=false;
    private boolean gunRaisedLeft=false;
	private boolean isWalking = false;
	public boolean onSomething = false;
	public boolean isAlive = true;
	private boolean facingRight=true;
	private final int PERIOD = 66;
	private int time = 0;
	private int count = 0;
	private int jumpCount = 0;
	private boolean hitLeft = false;
	private boolean hitRight = false;
	private boolean isCrouching = false;

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
			if (jumpCount!=0) {
				jumpCount--;
			}
			if (count != 0) {
				count--;
			} else {//ask for this
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
			if (isCrouching) {
				crouchPose(g);
			} else {
				alivePose(g);
			}
		} else {
			deadPose(g);
		}
	}

	protected void deadPose(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		Rectangle2D blood = new Rectangle2D.Double(sX, sY, 275, 100);// super.y+10
		g2d.setColor(Color.red);
		g2d.fill(blood);

		Rectangle2D shoe = new Rectangle2D.Double(sX, sY, 15, 30);// super.y+10
		g2d.setColor(new Color(100, 100, 100));
		g2d.fill(shoe);
		Rectangle2D leg = new Rectangle2D.Double(sX + 15, sY, 90, 23);// super.y-80
		g2d.setColor(new Color(32, 51, 97));
		g2d.fill(leg);

		Rectangle2D body = new Rectangle2D.Double(sX + 105, sY, 85, 28);// super.y-165
		g2d.setColor(new Color(77, 73, 73));
		g2d.fill(body);
		Rectangle2D arm = new Rectangle2D.Double(sX + 110, sY + 4, 80, 20);// super.y-165
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(arm);

		Rectangle2D head = new Rectangle2D.Double(sX + 190, sY - 5, 50, 50);// super.y-215
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(head);
		Rectangle2D eye = new Rectangle2D.Double(sX + 225, sY + 25, 10, 10);// super.y-205
		g2d.setColor(new Color(49, 54, 53));
		g2d.fill(eye);
		Rectangle2D hair = new Rectangle2D.Double(sX + 240, sY - 5, 10, 50);// super.y-225
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

		Rectangle2D hair = new Rectangle2D.Double(sX + 7, sY - 225, 50, 10);
		g2d.setColor(new Color(87, 49, 26));
		g2d.fill(hair);

		Rectangle2D head = new Rectangle2D.Double(sX + 7, sY - 215, 50, 50);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(head);
		Rectangle2D eye1 = new Rectangle2D.Double(sX + 10, sY - 205, 10, 10);
		Rectangle2D eye2 = new Rectangle2D.Double(sX + 31, sY - 205, 10, 10);
		Rectangle2D mouth = new Rectangle2D.Double(sX + 10, sY - 182, 30, 7);
		g2d.setColor(new Color(163, 77, 77));
		g2d.fill(mouth);
		g2d.setColor(new Color(49, 54, 53));
		g2d.fill(eye1);
		g2d.fill(eye2);
		Rectangle2D body = new Rectangle2D.Double(sX + 7, sY - 165, 50, 85);
		g2d.setColor(new Color(77, 73, 73));
		g2d.fill(body);

		Rectangle2D leftLeg = null;
		Rectangle2D leftShoe = null;
		Rectangle2D rightLeg = null;
		Rectangle2D rightShoe = null;

		if (time <= 22 && isWalking) {
			leftLeg = new Rectangle2D.Double(sX + 7, sY - 80, 23, 90);
			rightLeg = new Rectangle2D.Double(sX + 34, sY - 80, 23, 70);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			leftShoe = new Rectangle2D.Double(sX, sY + 10, 30, 15);
			rightShoe = new Rectangle2D.Double(sX + 34, sY - 10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		} else if (time <= 44 && isWalking) {
			leftLeg = new Rectangle2D.Double(sX + 7, sY - 80, 23, 70);
			rightLeg = new Rectangle2D.Double(sX + 34, sY - 80, 23, 90);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			leftShoe = new Rectangle2D.Double(sX, sY - 10, 30, 15);
			rightShoe = new Rectangle2D.Double(sX + 34, sY + 10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		} else {
			leftLeg = new Rectangle2D.Double(sX + 7, sY - 80, 23, 90);
			rightLeg = new Rectangle2D.Double(sX + 34, sY - 80, 23, 90);
			g2d.setColor(new Color(32, 51, 97));
			g2d.fill(leftLeg);
			g2d.fill(rightLeg);

			leftShoe = new Rectangle2D.Double(sX, sY + 10, 30, 15);
			rightShoe = new Rectangle2D.Double(sX + 34, sY + 10, 30, 15);
			g2d.setColor(new Color(100, 100, 100));
			g2d.fill(leftShoe);
			g2d.fill(rightShoe);
		}
		
		

		time++;
		if (time == PERIOD) {
			time = 0;
		}

		super.height = 250;
		
		if (gunRaisedRight) {
			super.width = 210;
			Rectangle2D leftArm = new Rectangle2D.Double(sX - 13, sY - 165, 20, 80);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(leftArm);

			Rectangle2D rightArm = new Rectangle2D.Double(sX + 57, sY - 165, 80, 20);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(rightArm);

			Rectangle2D gunHandle = new Rectangle2D.Double(sX + 137, sY - 165, 20, 30);
			Rectangle2D gunBarrel = new Rectangle2D.Double(sX + 157, sY - 165, 40, 15);
			g2d.setColor(new Color(150, 150, 150));
			g2d.fill(gunHandle);
			g2d.fill(gunBarrel);
		} else if (gunRaisedLeft) {
			super.width = 210;
			Rectangle2D rightArm = new Rectangle2D.Double(sX + 57, sY - 165, 20, 80);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(rightArm);

			Rectangle2D leftArm = new Rectangle2D.Double(sX - 73, sY - 165, 80, 20);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(leftArm);

			Rectangle2D gunHandle = new Rectangle2D.Double(sX - 93, sY - 165, 20, 30);
			Rectangle2D gunBarrel = new Rectangle2D.Double(sX - 133, sY - 165, 40, 15);
			g2d.setColor(new Color(150, 150, 150));
			g2d.fill(gunHandle);
			g2d.fill(gunBarrel);
		} else {
			super.width = 90;

			Rectangle2D leftArm = new Rectangle2D.Double(sX - 13, sY - 165, 20, 80);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(leftArm);

			Rectangle2D rightArm = new Rectangle2D.Double(sX + 57, sY - 165, 20, 80);
			g2d.setColor(new Color(255, 210, 143));
			g2d.fill(rightArm);

		}

		for (Bullet bullets : bullets) {
			bullets.drawImage(g2d);
		}

	}
	protected void crouchPose(Graphics g) {
		
		
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
		
		Rectangle2D hair = new Rectangle2D.Double(sX + 7, sY - 100, 50, 10);
		g2d.setColor(new Color(87, 49, 26));
		g2d.fill(hair);

		Rectangle2D head = new Rectangle2D.Double(sX + 7, sY - 90, 50, 50);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(head);
		Rectangle2D eye1 = new Rectangle2D.Double(sX + 10, sY - 80, 10, 10);
		Rectangle2D eye2 = new Rectangle2D.Double(sX + 31, sY - 80, 10, 10);
		Rectangle2D mouth = new Rectangle2D.Double(sX + 10, sY - 57, 30, 7);
		g2d.setColor(new Color(163, 77, 77));
		g2d.fill(mouth);
		g2d.setColor(new Color(49, 54, 53));
		g2d.fill(eye1);
		g2d.fill(eye2);
		
		Rectangle2D leftLeg = new Rectangle2D.Double(sX + 7, sY - 40, 23, 50);
		Rectangle2D rightLeg = new Rectangle2D.Double(sX + 34, sY - 40, 23, 50);
		g2d.setColor(new Color(32, 51, 97));
		g2d.fill(leftLeg);
		g2d.fill(rightLeg);

		Rectangle2D leftShoe = new Rectangle2D.Double(sX, sY + 10, 30, 15);
		Rectangle2D rightShoe = new Rectangle2D.Double(sX + 34, sY + 10, 30, 15);
		g2d.setColor(new Color(100, 100, 100));
		g2d.fill(leftShoe);
		g2d.fill(rightShoe);
	}

	public Rectangle getBounds() { // wtf this getBounds method for the else statement
		if(isAlive) {
			if (isCrouching) {
				return new Rectangle(sX + 7, sY - 100, 50, 125);
			} else {
				return new Rectangle(sX + 7, sY - 225, 50, 250);
			}
		} else {return new Rectangle(sX, sY + 230, 275, 105);}
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void isOnGround(DrawMap map) {
		List<Floor> floors = map.getFloors();
		/*for (Floor floor: floors) {
			if (getBounds().intersects(floor.getBounds())) {
				onSomething = true;
				return;
			} else {
				onSomething = false;
			}
		}
		*/
		List<Brick> bricks = map.getBricks();
		Rectangle personBounds = this.getBounds();

		// System.out.println(person);
		// System.out.println(bricks);
		// int count=0;
		onSomething = false;
		for (Floor floor : floors) {
			Rectangle brickBounds = floor.getBounds();

			if (brickBounds.intersects(personBounds)) {
				Rectangle2D intersection = getBounds().createIntersection(floor.getBounds());

				if (intersection.getHeight() < intersection.getWidth()) {
					onSomething = true;
					
				} else {
					if (floor.x - 2 <= intersection.getX() && floor.x + 2 >= intersection.getX()) {
						if(!hitLeft) {
							super.x-=4;
							hitLeft = true;
						}
					} else {
						if(!hitRight) {
							super.x+=4;
							hitRight = true;
						}
					}
				}
				
			}
			
		}
	}

	public void fall() {
		if (!(dy == 4)) {
			dy += 0.25;
		}
	}

	public void land() {
		if (jumpCount == 0) {
			dy = 0;
		} 
	}

	public void checkCollisions(DrawMap map) {// this method is new
		// System.out.println("checking collisions");
		
		List<List<CopBullet>> bullets = map.getBullets();
		
		for (List<CopBullet> bulletList: bullets) {
			for (CopBullet bullet: bulletList) {
				Rectangle bounds = bullet.getBounds();
				if (bounds.intersects(getBounds())) {
					isAlive = false;
				}
			}
		}
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
					if ((brick.y - 2 <= intersection.getY() && brick.y + 2 >= intersection.getY())) {
						onSomething = true;
					} else {
						super.y+=Math.abs(dy);
					}
					
				} else {
					if (brick.x - 2 <= intersection.getX() && brick.x + 2 >= intersection.getX()) {
						if(!hitLeft) {
							super.x-=4;
							hitLeft = true;
						}
					} else {
						if(!hitRight) {
							super.x+=4;
							hitRight = true;
						}
					}
				}
				
			}
			
		}
		hitLeft = false;
		hitRight = false;

		List<Spike> spikes = map.getSpikes();
		for (Spike spike : spikes) {
			Rectangle spikeBounds = spike.getBounds();

			if (spikeBounds.intersects(personBounds)) {
				isAlive = false;
			}
		}

	}

	// modify movements when keys pressed
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		
		if ((key == KeyEvent.VK_A || key == KeyEvent.VK_D)  && isAlive) {
            if(key==KeyEvent.VK_A ) {
            	gunRaisedLeft=true;
            	gunRaisedRight=false;
            }else {
            	gunRaisedLeft=false;
            	gunRaisedRight=true;
            }
        	fire();
        	
		} else {
			gunRaisedRight=false;
			gunRaisedLeft=false;
			if (key == KeyEvent.VK_SPACE) {
				if (onSomething) {
					isCrouching = false;
					dy = -8;
					jumpCount = 4;
				}
				onSomething = false;
			}

			if (key == KeyEvent.VK_LEFT) {

				if (!isCrouching) {
					dx = -4;
				}
			}

			if (key == KeyEvent.VK_RIGHT) {
				if (!isCrouching) {
					dx = 4;
				}
			}
			if (key == KeyEvent.VK_DOWN) {
				dx = 0;
				isCrouching = true;
			}
		}

	}

//	public void mousePressed(MouseEvent e) { //person class
//
//		int mouse = 501; //501 = MouseEvent.MOUSE_PRESSED
//		if (mouse == MouseEvent.MOUSE_PRESSED && isAlive) {
//			fire();
//
//			gunRaised = true;
//			count = 30;
//		} 
//		
//	}
	
	public void fire() {
		if(gunRaisedRight) {
			bullets.add(new Bullet(sX + 197, sY - 160, sX, true, null));
		}else {
			bullets.add(new Bullet(sX - 168, sY - 160, sX, false, null));
		}
	}

	public int getSX() {
		return sX;
	}
	public int getSY() {
		return sY;
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
		if (key == KeyEvent.VK_DOWN) {
			isCrouching = false;
		}

	}

	public String toString() {
		return "{PERSON--> (X=" + super.x + ",Y=" + super.y + ")  (WIDTH=" + super.width + ",HEIGHT=" + super.height
				+ ")}";
	}
}
