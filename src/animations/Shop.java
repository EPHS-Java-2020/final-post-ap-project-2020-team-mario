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
	private Rectangle defaultSkinButton = new Rectangle(0, 100, 200 ,200);
	private Rectangle blackSkinButton = new Rectangle(0, 300, 200, 200);
	private Rectangle whiteSkinButton = new Rectangle(0,500, 200, 200);
	private Rectangle redSkinButton = new Rectangle(200, 100, 200, 200);
	private Rectangle useButton = new Rectangle(1100, 460, 150, 50);
	private Rectangle greenSkinButton = new Rectangle(200, 300, 200, 200);
	private Rectangle blueSkinButton = new Rectangle(200, 500, 200, 200);
	private Rectangle purpleSkinButton = new Rectangle(400, 100, 200, 200);
	private Rectangle orangeSkinButton = new Rectangle(400, 300, 200, 200);
	private Rectangle skyblueSkinButton = new Rectangle(400, 500, 200, 200);
	private Rectangle mix1SkinButton = new Rectangle(600, 100, 200, 200);
	private Rectangle mix2SkinButton = new Rectangle(600, 300, 200, 200);
	private Rectangle mix3SkinButton = new Rectangle(600, 500, 200, 200);
	
	//private boolean changedSkins = false;
	//private boolean purchaseStatus = {
	
	public int eggs;
	
	public Color pantColor=new Color(32, 51, 97);
	public Color shirtColor=new Color(77, 73, 73);
	public Color shoeColor=new Color(100, 100, 100);
	public Color decidedPantColor=new Color(32, 51, 97);
	public Color decidedShirtColor=new Color(77, 73, 73);
	public Color decidedShoeColor=new Color(100, 100, 100);
	public boolean colorSchemeChanged=false;
	public boolean colorButtonPressed=false;
	
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
		g.drawString("Price: FREE", 50, 210);
		g2d.draw(defaultSkinButton);
		

		
		Font blackSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(blackSkinTXT);
		g.setColor(Color.black);
		g.drawString("Black Skin", 50, 350);
		g.drawString("Price: 10 eggs", 50, 410);
		g2d.draw(blackSkinButton);
		
		Font whiteSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(whiteSkinTXT);
		g.setColor(Color.white);
		g.drawString("White Skin", 50, 550);
		g.drawString("Price: 10 eggs", 50, 610);
		g2d.draw(whiteSkinButton);
		
		Font redSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(redSkinTXT);
		g.setColor(Color.red);
		g.drawString("Red Skin", 250, 150);
		g.drawString("Price: 20 eggs", 250, 210);
		g2d.draw(redSkinButton);
		
		Font useTXT = new Font("arial", Font.BOLD, 40);
		g.setFont(redSkinTXT);
		g.setColor(Color.black);
		g.drawString("USE SKIN", 1100, 480);
		g2d.draw(useButton);
		
		Font greenSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(greenSkinTXT);
		g.setColor(Color.green);
		g.drawString("Green Skin", 250, 350);
		g.drawString("Price: 20 eggs", 250, 410);
		g2d.draw(greenSkinButton);
		
		Font blueSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(greenSkinTXT);
		g.setColor(Color.blue);
		g.drawString("Blue Skin", 250, 550);
		g.drawString("Price: 20 eggs", 250, 610);
		g2d.draw(blueSkinButton);
		
		Font purpleSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(purpleSkinTXT);
		g.setColor(new Color(176, 2, 120));
		g.drawString("Purple Skin", 450, 150);
		g.drawString("Price: 45 eggs", 450, 210);
		g2d.draw(purpleSkinButton);
		
		Font orangeSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(orangeSkinTXT);
		g.setColor(Color.orange);
		g.drawString("Orange Skin", 450, 350);
		g.drawString("Price: 45 eggs", 450, 410);
		g2d.draw(orangeSkinButton);
		
		Font skyblueSkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(skyblueSkinTXT);
		g.setColor(new Color(0, 255, 255));
		g.drawString("Sky Blue Skin", 450, 550);
		g.drawString("Price: 45 eggs", 450, 610);
		g2d.draw(skyblueSkinButton);
		
		Font mix1SkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(mix1SkinTXT);
		g.setColor(Color.black);
		g.drawString("Mix 1 Skin", 650, 150);
		g.drawString("Price: 75 eggs", 650, 210);
		g2d.draw(mix1SkinButton);
		
		Font mix2SkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(mix2SkinTXT);
		g.setColor(Color.black);
		g.drawString("Mix 2 Skin", 650, 350);
		g.drawString("Price: 75 eggs", 650, 410);
		g2d.draw(mix2SkinButton);
		
		Font mix3SkinTXT = new Font("arial", Font.BOLD, 20);
		g.setFont(mix3SkinTXT);
		g.setColor(Color.black);
		g.drawString("Mix 3 Skin", 650, 550);
		g.drawString("Price: 75 eggs", 650, 610);
		g2d.draw(mix3SkinButton);
        
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
	
	
	public void mousePressed(MouseEvent e) { //something wrong w/ boolean conditions... color changes to default instead of not changing if user enters shop but dpesn't clcik "USE" button
		if(501==MouseEvent.MOUSE_PRESSED) {
			int x = e.getX();
			int y = e.getY();
			
			if(x>=mainMenuButton.x && x<=mainMenuButton.x+265 && y>=mainMenuButton.y && y<=mainMenuButton.y+50) {
				Board.currentScreen = Board.currentScreen.START_SCREEN;
				//colorSchemeChanged=false;
			}else if(x>=defaultSkinButton.x && x<=defaultSkinButton.x+200 && y>=defaultSkinButton.y && y<=defaultSkinButton.y+200) {
				
				pantColor=new Color(32, 51, 97);
				shirtColor=new Color(77, 73, 73);
				shoeColor=new Color(100, 100, 100);
				colorSchemeChanged=false;
			}else if(x>=blackSkinButton.x && x<=blackSkinButton.x+200 && y>=blackSkinButton.y && y<=blackSkinButton.y+200) {
				
				pantColor=new Color(50, 50, 50);
				shirtColor=new Color(0, 0, 0);
				shoeColor=new Color(0, 0, 0);
				colorSchemeChanged=false;
			}else if(x>=whiteSkinButton.x && x<=whiteSkinButton.x+200 && y>=whiteSkinButton.y && y<=whiteSkinButton.y+200) {
				
				pantColor=new Color(0, 0, 0);
				shirtColor=new Color(255, 255, 255);
				shoeColor=new Color(100, 100, 100);
				colorSchemeChanged=false;
			}else if(x>=redSkinButton.x && x<=redSkinButton.x+200 && y>=redSkinButton.y && y<=redSkinButton.y+200) {
		
				pantColor=new Color(100, 0, 0);
				shirtColor=new Color(255, 0, 0);
				shoeColor=new Color(255, 0, 0);
				colorSchemeChanged=false;
			}else if(x>=useButton.x && x<=useButton.x+150 && y>=useButton.y && y<=useButton.y+50) {
				colorSchemeChanged=true;
				this.decidedPantColor=pantColor;
				this.decidedShirtColor=shirtColor;
				this.decidedShoeColor=shoeColor;
				Board.currentScreen = Board.currentScreen.START_SCREEN;
			}
		}
	}
	
	public Color getShirtColor() {
		System.out.println(shirtColor);
		return shirtColor;
	}
	public Color getPantColor() {
		return pantColor;
	}
	public Color getShoeColor() {
		return shoeColor;
	}
}
