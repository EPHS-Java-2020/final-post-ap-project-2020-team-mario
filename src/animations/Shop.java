package animations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Shop {
	private Rectangle mainMenuButton = new Rectangle(475, 35, 265, 50);
	private Rectangle defaultSkinButton = new Rectangle(0, 100, 200 ,300);
	private Rectangle blackSkinButton = new Rectangle(200, 100, 200, 300);
	private Rectangle redSkinButton = new Rectangle(400, 100, 200, 300);
	
	private int eggs;
	
	public Color pantColor=new Color(32, 51, 97);
	public Color shirtColor=new Color(77, 73, 73);
	public Color shoeColor=new Color(100, 100, 100);
	public boolean colorSchemeChanged=false;
	
	public Shop(int eggs) {
		this.eggs=eggs;
	}
	
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        Font mainMenuTXT  = new Font("arial", Font.BOLD, 20);
		g.setFont(mainMenuTXT);
		g.setColor(Color.white);
		g.drawString("Return to Main Menu", 490, 65);
		g2d.draw(mainMenuButton);
		
		Font defaultSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(defaultSkinTXT);
		g.setColor(Color.black);
		g.drawString("Default Skin", 50, 150);
		g2d.draw(defaultSkinButton);
		
		
		Font blackSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(blackSkinTXT);
		g.setColor(Color.black);
		g.drawString("Black Skin", 250, 150);
		g2d.draw(blackSkinButton);
		
		Font redSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(redSkinTXT);
		g.setColor(Color.black);
		g.drawString("Red Skin", 450, 150);
		g2d.draw(redSkinButton);
		
        drawPerson(1200, 400, g);
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
		g2d.setColor(shirtColor);//new Color(77, 73, 73)
		g2d.fill(body);

		Rectangle2D leftLeg = null;
		Rectangle2D leftShoe = null;
		Rectangle2D rightLeg = null;
		Rectangle2D rightShoe = null;

		leftLeg = new Rectangle2D.Double(sX + 7, sY - 80, 23, 90);
		rightLeg = new Rectangle2D.Double(sX + 34, sY - 80, 23, 90);
		g2d.setColor(pantColor);//new Color(32, 51, 97)
		g2d.fill(leftLeg);
		g2d.fill(rightLeg);

		leftShoe = new Rectangle2D.Double(sX, sY + 10, 30, 15);
		rightShoe = new Rectangle2D.Double(sX + 34, sY + 10, 30, 15);
		g2d.setColor(shoeColor);//new Color(100, 100, 100)
		g2d.fill(leftShoe);
		g2d.fill(rightShoe);

		Rectangle2D rightArm = new Rectangle2D.Double(sX + 57, sY - 165, 20, 80);
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(rightArm);

		Rectangle2D leftArm = new Rectangle2D.Double(sX - 13, sY - 165, 20, 80);
		g2d.setColor(new Color(255, 210, 143));
		g2d.fill(leftArm);
        
	}
	
	
	public void mousePressed(MouseEvent e) {
		if(501==MouseEvent.MOUSE_PRESSED) {
			int x = e.getX();
			int y = e.getY();
			
			if(x>=mainMenuButton.x && x<=mainMenuButton.x+265 && y>=mainMenuButton.y && y<=mainMenuButton.y+50) {
				Board.currentScreen = Board.currentScreen.START_SCREEN;
				colorSchemeChanged=false;
			}else if(x>=defaultSkinButton.x && x<=defaultSkinButton.x+200 && y>=defaultSkinButton.y && y<=defaultSkinButton.y+300) {
				pantColor=new Color(32, 51, 97);
				shirtColor=new Color(77, 73, 73);
				shoeColor=new Color(100, 100, 100);
				colorSchemeChanged=true;
			}else if(x>=blackSkinButton.x && x<=blackSkinButton.x+200 && y>=blackSkinButton.y && y<=blackSkinButton.y+300) {
				pantColor=new Color(50, 50, 50);
				shirtColor=new Color(0, 0, 0);
				shoeColor=new Color(0, 0, 0);
				colorSchemeChanged=true;
			}else if(x>=redSkinButton.x && x<=redSkinButton.x+200 && y>=redSkinButton.y && y<=redSkinButton.y+300) {
				pantColor=new Color(100, 0, 0);
				shirtColor=new Color(255, 0, 0);
				shoeColor=new Color(255, 0, 0);
				colorSchemeChanged=true;
			}
		}
	}
	
}
