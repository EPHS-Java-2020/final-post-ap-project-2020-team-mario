package mapSetup;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import animations.Sprite;

public class Brick extends Sprite{
	
	private ImageIcon ii;
	private Image brick;
	private int sX;
	private int sY;
	
	public Brick(int x, int speed) {
		super(x,550);
		sX=x;
		sY=550;
		loadImage();
	}
	
	public void loadImage() {
		ii = new ImageIcon("src/Drawings/Fancy Brick.png");
		brick = ii.getImage();
	}
	
	public void drawImage(int x, int y, Graphics g) {
		super.x=sX-x;
		
		//super.x+=x;
		
		super.y=550; //super.y-=y
		drawImage(g);
		
	}
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.setRenderingHints(rh);
		
		g2d.drawImage(brick, super.x, super.y, this);
	}
	
	
}
