package animations;

import java.awt.BasicStroke;
import shop.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;



public class StartScreen extends JPanel{
	private Rectangle level1Button = new Rectangle(100, 500, 250, 150);
	private Rectangle level2Button = new Rectangle(400, 500, 250, 150);
	private Rectangle level3Button = new Rectangle(700, 500, 250, 150);
	private Rectangle level4Button = new Rectangle(1000, 500, 250, 150);
	public boolean changedFromStartScreen=false;
	public boolean needToRefresh=false;
	public int eggs;
	
	public StartScreen(int eggs) {
		this.eggs = eggs;
	}
	
	
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        
        int sX=250;
        int sY=450;
        
        drawPerson(sX+500, sY, g);
        drawCop(sX, sY-200, g);
		
		Font title  = new Font("arial", Font.BOLD, 50);
		g.setFont(title);
		g.setColor(Color.black);
		g.drawString("ESCAPE JAIL RIGHT NOW!", 300, 100);
		
		
		Font levels = new Font("arial", Font.BOLD, 50);
		g.setFont(levels);
		g.setColor(Color.green);
		g.drawString("Level 1", 150, 600);
		g2d.draw(level1Button);
		
		g.setColor(Color.yellow);
		g.drawString("Level 2", 450, 600);
		g2d.draw(level2Button);
		
		g.setColor(Color.yellow);
		g.drawString("Level 3", 750, 600);
		g2d.draw(level3Button);
		
		g.setColor(Color.red);
		g.drawString("Level 4", 1050, 600);
		g2d.draw(level4Button);
		
		Font coinsTitle = new Font("arial", Font.BOLD, 40);
		g.setFont(coinsTitle);
		g.setColor(Color.black);
		g.drawString("Eggs: " + eggs, 1100, 65);
		
	}
	
	private void drawCop(int x, int y, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        Rectangle2D hat = new Rectangle2D.Double(x, y, 75, 10);
		Rectangle2D topHat = new Rectangle2D.Double(x, y - 10, 50, 10);
		g2d.setColor(new Color(0, 6, 94));
		g2d.fill(hat);
		g2d.fill(topHat);
		
		Rectangle2D head = new Rectangle2D.Double(x, y + 10, 50, 50);
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(head);
		
		Ellipse2D rightLens = new Ellipse2D.Double(x + 35, y + 15, 25, 20);
		g2d.setColor(new Color(0, 0, 0));
		g2d.fill(rightLens);
		Rectangle2D noseBridge = new Rectangle2D.Double(x + 15, y + 20, 30, 10);
		g2d.setColor(new Color(0, 0, 0));
		g2d.fill(noseBridge);
		Ellipse2D leftLens = new Ellipse2D.Double(x, y + 15, 25, 20);
		g2d.setColor(new Color(0, 0, 0));
		g2d.fill(leftLens);
		
		Ellipse2D mouth = new Ellipse2D.Double(x + 5, y + 40, 40, 20);
		g2d.setColor(new Color(128, 78, 68));
		g2d.fill(mouth);
		Ellipse2D mouthBelow = new Ellipse2D.Double(x + 5, y + 43, 45, 20);
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(mouthBelow);
		
		Rectangle2D body = new Rectangle2D.Double(x, y + 60, 50, 85);
		g2d.setColor(new Color(10, 16, 94));
		g2d.fill(body);
		int temp = 0;
		g2d.setColor(new Color(255, 255, 255));
		for (temp = 0; temp < 80; temp += 20) {
			Ellipse2D button = new Ellipse2D.Double(x + 25, y + 68 + temp, 5, 5);
			g2d.fill(button);
		}
		
		Rectangle2D leftArm = new Rectangle2D.Double(x - 20, y + 60, 17, 60);
		Line2D leftLine = new Line2D.Double(x - 2, y + 62, x - 2, y + 77);
		//Rectangle2D rightArm = new Rectangle2D.Double(x + 53, y + 60, 17, 60);
		Rectangle2D rightArm = new Rectangle2D.Double(x + 53, y + 60, 60, 17);
		g2d.setColor(new Color(10, 16, 94));
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
		
		Rectangle2D leftLeg = new Rectangle2D.Double(x, y + 145, 17, 80);
		Rectangle2D rightLeg = new Rectangle2D.Double(x + 33, y + 145, 17, 80);
		g2d.setColor(new Color(77, 68, 64));
		g2d.fill(leftLeg);
		g2d.fill(rightLeg);
		
		Rectangle2D leftShoe = new Rectangle2D.Double(x, y + 225, 25, 15);
		Rectangle2D rightShoe = new Rectangle2D.Double(x + 33, y + 225, 25, 15);
		g2d.setColor(Color.black);
		g2d.fill(leftShoe);
		g2d.fill(rightShoe);
	}
	
	
	private void drawPerson(int sX, int sY, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
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
        
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_R) {
			this.needToRefresh=true;
		}
		else if (key == KeyEvent.VK_M) {
			Board.currentScreen = Board.currentScreen.START_SCREEN;;
		}
	}
	

	
	public void mousePressed(MouseEvent e) { //person class
		if (501 == MouseEvent.MOUSE_PRESSED) {
			int x = e.getX();
			int y = e.getY();
			
			if (Board.currentScreen == Board.SCREEN.START_SCREEN) {
				changedFromStartScreen=true;
				if (x >= level1Button.x && x <= level1Button.x + 250 && y >= level1Button.y
						&& y <= level1Button.y + 150) {
					Board.currentScreen = Board.currentScreen.LEVEL1;
				} else if (x >= level2Button.x && x <= level2Button.x + 250 && y >= level2Button.y
						&& y <= level2Button.y + 150) {
					Board.currentScreen = Board.currentScreen.LEVEL2;
				}else if (x >= level3Button.x && x <= level3Button.x + 250 && y >= level3Button.y
						&& y <= level3Button.y + 150) {
					Board.currentScreen = Board.currentScreen.LEVEL3;
				}else if (x >= level4Button.x && x <= level4Button.x + 250 && y >= level4Button.y
						&& y <= level4Button.y + 150) {
					Board.currentScreen = Board.currentScreen.LEVEL4;
				}
			}else {
				changedFromStartScreen=false;
				if(x>=475 && x<=725 && y>=20 && y<=85) {
					Board.currentScreen = Board.currentScreen.START_SCREEN;
				} else if(x>=750 && x<=850 && y>=20 && y<=85) {
					this.needToRefresh=true;
				}
			}
		} 
		
	}
	
	

	
}
