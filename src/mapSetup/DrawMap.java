package mapSetup;

import java.awt.*;
import java.util.ArrayList;

public class DrawMap {
	
	private ArrayList<Brick> bricks;
	private ArrayList<Spike> spikes;
	private ArrayList<Floor> floors;
	private ArrayList<Tree> trees;
	
	public DrawMap() {
		bricks = new ArrayList<Brick>();
		spikes = new ArrayList<Spike>();
		floors = new ArrayList<Floor>();
		trees = new ArrayList<Tree>();
		
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
		for (Tree tree: trees) {
			tree.drawImage(x,y,g2d);
		}
	}
	public void addStuff() {
		bricks.add(new Brick(1950, 1200, 0));
		bricks.add(new Brick(1000, 1200, 0));
		bricks.add(new Brick(1950, 1240, 0));
		bricks.add(new Brick(1800, 1200, 0));
		bricks.add(new Brick(1800, 1240, 0));
		spikes.add(new Spike(1850, 1245, 0));
		spikes.add(new Spike(1900, 1245, 0));
		floors.add(new Floor(500 ,1300, 0));
		floors.add(new Floor(1500 ,1300, 0));
		trees.add(new Tree(750, 750, 0));
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
