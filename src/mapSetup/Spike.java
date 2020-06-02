package mapSetup;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import animations.Sprite;

public class Spike extends Obstacle{
	
	public Spike(int x, int y, int speed) {
		super(x,y, speed);
	}
	
	@Override
	public void loadImage() {
		ii = new ImageIcon("src/Drawings/Spike.png");
		image = ii.getImage();
	}
	
	
	
	
}
	
