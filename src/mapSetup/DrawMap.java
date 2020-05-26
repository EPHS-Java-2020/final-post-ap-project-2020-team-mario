package mapSetup;

import java.awt.*;
import java.util.ArrayList;

public class DrawMap {
	
	private ArrayList<Brick> bricks;
	private ArrayList<Spike> spikes;
	private ArrayList<Floor> floors;
	
	public DrawMap() {
		bricks = new ArrayList<Brick>();
		spikes = new ArrayList<Spike>();
		floors = new ArrayList<Floor>();
		
		addStuff();
	}
	public void drawAll(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (Brick brick: bricks) {
			brick.drawImage(x, y, g2d);
		}
		
		for(Spike spike: spikes) {
			spike.drawImage(x, y, g2d);
		}
		
		for(Floor floor: floors) {
			floor.drawImage(x, y, g2d);
		}
	}
	public void addStuff() {
		bricks.add(new Brick(1900, 1000, 0));
		bricks.add(new Brick(1800, 1000, 0));
		spikes.add(new Spike(1850, 1000, 0));
		floors.add(new Floor(500 ,1300, 0));
		floors.add(new Floor(1500 ,1300, 0));
	}
	
	public ArrayList<Brick> getBricks(){
		return bricks;
	}
	
	public ArrayList<Floor> getFloors(){
		return floors;
	}

	public ArrayList<Spike> getSpikes(){
		return spikes;
	}
}
