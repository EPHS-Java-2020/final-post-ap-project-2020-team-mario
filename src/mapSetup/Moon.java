package mapSetup;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;

import animations.Sprite;

public class Moon extends Obstacle{
	
	public Moon(int x, int y, int speed) {
		super(x,y, speed);
	}
	
	@Override
	public void loadImage() {
		URL url = getClass().getClassLoader().getResource("moon.png");
		ii = new ImageIcon(url);
		image = ii.getImage();
	}
	
	
}
