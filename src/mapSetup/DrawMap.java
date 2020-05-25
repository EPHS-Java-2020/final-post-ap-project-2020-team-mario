package mapSetup;

import java.awt.*;
import java.util.ArrayList;

public class DrawMap {
	
	ArrayList<Brick> bricks;
	ArrayList<Spike> spikes;
	
	public DrawMap() {
		bricks = new ArrayList<Brick>();
		spikes = new ArrayList<Spike>();
		for(int i=0; i<1; i++) {
			addStuff();
		}
	}
	public void drawAll(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (Brick brick: bricks) {
			brick.drawImage(x, y, g2d);
		}
		
		for(Spike spike: spikes) {
			spike.drawImage(x, y, g2d);
		}
	}
	public void addStuff() {
		bricks.add(new Brick((int)(Math.random()*1000)+1000, 0));
		spikes.add(new Spike((int)(Math.random()*1000)+1000, 0));
	}
	
	public ArrayList<Brick> getBricks(){
		return bricks;
	}

	public ArrayList<Spike> getSpikes(){
		return spikes;
	}
}
