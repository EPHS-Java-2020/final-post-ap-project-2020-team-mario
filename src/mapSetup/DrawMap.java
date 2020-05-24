package mapSetup;

import java.awt.*;
import java.util.ArrayList;

public class DrawMap {
	
	ArrayList<Brick> bricks;
	ArrayList<Spike> spikes;
	
	public DrawMap() {
		bricks = new ArrayList<Brick>();
		spikes = new ArrayList<Spike>();
		for(int i=0; i<5; i++) {
			addStuff( (int)(Math.random()*1000)+1000 );
		}
	}
	public void drawAll(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (Brick brick: bricks) {
			brick.drawImage(x, y, g2d);
		}
	}
	public void addStuff(int x) {
		bricks.add(new Brick(x, 0));
	}

}
