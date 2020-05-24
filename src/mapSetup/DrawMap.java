package mapSetup;

import java.awt.*;
import java.util.ArrayList;

public class DrawMap {
	
	ArrayList<Brick> bricks;
	ArrayList<Spike> spikes;
	
	public DrawMap() {
		bricks = new ArrayList<Brick>();
		spikes = new ArrayList<Spike>();
	}
	public void drawAll(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		for (Brick brick: bricks) {
			brick.drawImage(x, y, g2d);
		}
	}
	public void addStuff() {
		bricks.add(new Brick(600, 500, 0));
	}

}
