package mapSetup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

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
	private ArrayList<Chicken> chickens;
	private List<List<CopBullet>> bullets;
	public LevelManager levels;
	
	public DrawMap(LevelManager levels) {
		this.levels = levels;
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
		bullets = new ArrayList<List<CopBullet>>();
		chickens = new ArrayList<Chicken>();
		addStuff();
		
	}
	public void changeLevel(int level) {
		levels.level = level;
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
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemy.drawImage(x,y,g2d);
			try {
				bullets.set(i,enemy.getBullets());
			} catch (Exception e) {
				bullets.add(enemy.getBullets());
			}
			
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
		for(Chicken chicken: chickens) {
			chicken.drawImage(x,y,g2d);
		}
	}
	public void addStuff() {
		if (levels.level == 1) {
			floors.add(new Floor(500 ,1100, 0, 4000));
			bricks.add(new Brick(1400,1040, 0));
			spikes.add(new Spike(1500,1050,0));
			spikes.add(new Spike(1700,1050,0));
			trees.add(new Tree(800,550,0));
			suns.add(new Sun(200,400,0));
			bricks.add(new Brick(1850,1040, 0));
			bricks.add(new Brick(1850,975, 0));
			cloudes.add(new Cloud(1200,400,0));
			cloudes.add(new Cloud(1800,500,0));
			bricks.add(new Brick(2150,1040, 0));
			bricks.add(new Brick(2150,975, 0));
			bricks.add(new Brick(2430,1040, 0));
			bricks.add(new Brick(2430,975, 0));
			spikes.add(new Spike(2200,1050,0));
			spikes.add(new Spike(2290,1050,0));
			spikes.add(new Spike(2380,1050,0));
			chickens.add(new Chicken(1950,1000,0));
		}

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
	public List<List<CopBullet>> getBullets() {
		return bullets;
	}
}
