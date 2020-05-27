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
	private ArrayList<Enemy> enemies;
	
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
		enemies = new ArrayList<Enemy>();
		
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
		
		for (Enemy enemy: enemies) {
			enemy.drawImage(x,y,g2d);
		}
		for(Cloud cloud: cloudes) {
			cloud.drawImage(x,y,g2d);
		}
		for(Moon moon: moones) {
			moon.drawImage(x,y,g2d);
		}
		for(Rock rock: rocks) {
			rock.drawImage(x,y,g2d);
		}
		for(Sun sun:suns) {
			sun.drawImage(x,y,g2d);
		}
		for(Tree tree:trees) {
			tree.drawImage(x,y,g2d);
		}
	}
	public void addStuff() {
		floors.add(new Floor(500 ,1100, 0));
		bricks.add(new Brick(1500, 1040, 0));
		bricks.add(new Brick(1500, 980, 0));
		bricks.add(new Brick(1650, 1040, 0));
		bricks.add(new Brick(1650, 980, 0));
		floors.add(new Floor(1500 ,1100, 0));
		enemies.add(new Enemy(1500, 850, 2));
		trees.add(new Tree(800,550,0));
		suns.add(new Sun(200,400,0));
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
