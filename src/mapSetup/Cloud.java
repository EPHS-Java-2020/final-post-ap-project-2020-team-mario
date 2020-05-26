package mapSetup;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import animations.Sprite;

public class Cloud extends Obstacle{
	
	public Cloud(int x, int y, int speed) {
		super(x,y, speed);
	}
	
	@Override
	public void loadImage() {
		ii = new ImageIcon("src/Drawings/cloud.png");
		image = ii.getImage();
	}
	
	
}