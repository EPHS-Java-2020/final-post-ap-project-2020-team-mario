package mapSetup;

import java.awt.*;
import java.util.ArrayList;

public class DrawMap {
	
	private ArrayList<Brick> bricks;
	private ArrayList<Spike> spikes;
	private ArrayList<Floor> floors;
	private ArrayList<boulder> boulders;
	private ArrayList<Bush> bushes;
	private ArrayList<Cloud> cloudes;
	private ArrayList<Moon> moones;
	private ArrayList<Rock> rocks;
	private ArrayList<Sun> suns;
	private ArrayList<Tree> trees;
	
	public DrawMap() {
		bricks = new ArrayList<Brick>();
		spikes = new ArrayList<Spike>();
		floors = new ArrayList<Floor>();
		boulders = new ArrayList<boulder>();
		bushes = new ArrayList<Bush>();
		cloudes = new ArrayList<Cloud>();
		moones= new ArrayList<Moon>();
		rocks = new ArrayList<Rock>();
		suns = new ArrayList<Sun>();
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
		for(boulder boulder: boulders) {
			boulder.drawImage(x, y, g2d);
		}
		for(Bush bush: bushes) {
			bush.drawImage(x, y, g2d);
		}
	}
	public void addStuff() {
		bricks.add(new Brick(1900, 1400, 0));
		bricks.add(new Brick(1800, 1500, 0));
		spikes.add(new Spike(1850, 1500, 0));
		floors.add(new Floor(500 ,1600, 0));
		floors.add(new Floor(1500 ,1550, 0));
		boulders.add(new boulder(800,1400,0));
		bushes.add(new Bush(1000,1300,0));
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
