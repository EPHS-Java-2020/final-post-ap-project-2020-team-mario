package mapSetup;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
//import Drawings.*;

import javax.swing.ImageIcon;

import animations.Sprite;

public class Car extends Obstacle{
	public boolean isMoving=false;
	
	public Car(int x, int y, int speed) {
		super(x,y, speed);
		
	}
	
	public void move() {
		sX+=10;
	}
	
	public void setX(int x) {
		super.x=x;
	}
	public int getX() {
		return super.x;
	}
	
	@Override
	public void loadImage() {
		ii = new ImageIcon("resources/car.png");
		image = ii.getImage();
		super.width = ii.getIconWidth();
		super.height = ii.getIconHeight();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(super.x+image.getWidth(null)/2, super.y, image.getWidth(null)/2, image.getHeight(null));
	}
	
}