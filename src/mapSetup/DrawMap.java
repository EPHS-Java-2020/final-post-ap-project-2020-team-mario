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
	public ArrayList<Chicken> chickens;
	private List<List<CopBullet>> bullets;
	private ArrayList<Car> cars;
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
		cars = new ArrayList<Car>();
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
			if (chicken.visible) {
				chicken.drawImage(x,y,g2d);
			}
		}
		for(Car car: cars) {
			car.drawImage(x,y,g2d);
		}
	}
	public void addStuff() {
		if (levels.level == 1) {
			setUpLevel1();
		}else if(levels.level==2) {
			setUpLevel2();
		}

	}
	
	public void setUpLevel2() {
		//floors.add(new Floor(1000 ,1300, 0, 4000));
		bricks.add(new Brick(1200,1240, 0));
		bricks.add(new Brick(1200,1175, 0));
		bricks.add(new Brick(1250,1080, 0));
		bricks.add(new Brick(1250,1030, 0));
		bricks.add(new Brick(1080, 930, 0));
		bricks.add(new Brick(1370,850, 0));
		
		//bottom floor at beginning
		floors.add(new Floor(1000 ,1300, 0, 2150));

		bricks.add(new Brick(1600,1240, 0));
		spikes.add(new Spike(1650,1250,0));
		bricks.add(new Brick(1700,1240, 0));
		
		bricks.add(new Brick(1800,1240, 0));
		spikes.add(new Spike(1850,1250,0));
		spikes.add(new Spike(1900,1250,0));		
		bricks.add(new Brick(1950,1240, 0));

		
		spikes.add(new Spike(2100,1250,0));
		spikes.add(new Spike(2140,1250,0));
		spikes.add(new Spike(2180,1250,0));
		chickens.add(new Chicken(2550,1200,0,3,120));
		chickens.add(new Chicken(2600,1200,0,5,100));
		
		
		bricks.add(new Brick(3150,1600, 0));
		bricks.add(new Brick(3200,2000, 0));
		
		//third floor
		floors.add(new Floor(3250 ,2100, 0, 800));
		bricks.add(new Brick(4150,2050,0));
		
		//prank floor
		floors.add(new Floor(4250 ,2000, 0, 1000));
		floors.add(new Floor(5250 ,2300, 0, 500));
		bricks.add(new Brick(5850,2340,0));
		bricks.add(new Brick(5850,2275,0));
		bricks.add(new Brick(5850,2210,0));
		bricks.add(new Brick(5850,2145,0));
		bricks.add(new Brick(5850,2080,0));
		
		// last floor
		floors.add(new Floor(4250, 3000, 0, 1000));
		cars.add(new Car(4500, 2795, 0));

		//top floor at beginning
		floors.add(new Floor(1400 ,800, 0, 2000));
		floors.add(new Floor(3550 ,800, 0, 1050));

		bricks.add(new Brick(1450,735,0));
		bricks.add(new Brick(1450,670,0));
		
		bricks.add(new Brick(1500,735,0));
		bricks.add(new Brick(1500,670,0)); 
		bricks.add(new Brick(1500,615,0));
		
		bricks.add(new Brick(1550,735,0));
		bricks.add(new Brick(1550,670,0));
		bricks.add(new Brick(1550,605,0));
		bricks.add(new Brick(1550,540,0));
		bricks.add(new Brick(1550,490,0));

		spikes.add(new Spike(1600,745,0));
		spikes.add(new Spike(1650,685,0));
		spikes.add(new Spike(1700,685,0));
		spikes.add(new Spike(1750,625,0));
		spikes.add(new Spike(1800,685,0));
		spikes.add(new Spike(1850,745,0));
		spikes.add(new Spike(2000,745,0));
		spikes.add(new Spike(2050,695,0));
		spikes.add(new Spike(2100,745,0));
		

		bricks.add(new Brick(2600,745,0));
		

		bricks.add(new Brick(3400,745,0));
		bricks.add(new Brick(3400,700,0));
		
		bricks.add(new Brick(3500,745,0));
		bricks.add(new Brick(3500,700,0));
		
		bricks.add(new Brick(4600,745,0));
		bricks.add(new Brick(4600,680,0));
		bricks.add(new Brick(4600,615,0));
		bricks.add(new Brick(4600,550,0));
		bricks.add(new Brick(4600,485,0));
		
		
		enemies.add(new Enemy(2700, 575, 3, 400));
		enemies.add(new Enemy(3600, 575, 5, 200));
		
	}
	
	public void setUpLevel1()
	{
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
		chickens.add(new Chicken(1910,1000,0, 1, 180));

		floors.add(new Floor(3200,925,0, 1200));
		floors.add(new Floor(3200,1000,0, 1200));
		bricks.add(new Brick(3000, 1000, 0));
		bricks.add(new Brick(3000, 1040, 0));
		

		bricks.add(new Brick(3400,865,0));
		chickens.add(new Chicken(3460, 825, 0, 3, 26));
		
		
		bricks.add(new Brick(3600,865,0));
		bricks.add(new Brick(3600,800,0));
	
		spikes.add(new Spike(3650,875,0));
		spikes.add(new Spike(3700,875,0));
		
		
		bricks.add(new Brick(3750,865,0));
		bricks.add(new Brick(3750,800,0));
		bricks.add(new Brick(3750,735,0));
		
		bricks.add(new Brick(3825,865,0));
		bricks.add(new Brick(3825,800,0));
		bricks.add(new Brick(3825,735,0));
		bricks.add(new Brick(3825,670,0));
		bricks.add(new Brick(3825,605,0));
		

		spikes.add(new Spike(3875,875,0));
		spikes.add(new Spike(3925,875,0));
		spikes.add(new Spike(3975,875,0));
		spikes.add(new Spike(4025,875,0));
		spikes.add(new Spike(4075,875,0));
		spikes.add(new Spike(4125,875,0));
		
		bricks.add(new Brick(4200,865,0));
		bricks.add(new Brick(4200,800,0));
		
		bricks.add(new Brick(4400, 770,0));
		bricks.add(new Brick(4400, 830,0));
		bricks.add(new Brick(4400, 890,0));
		floors.add(new Floor(4450, 750, 0, 2000));
		chickens.add(new Chicken(4500, 650, 0, 1, 600));
		chickens.add(new Chicken(4700, 650, 0, 1, 600));
		chickens.add(new Chicken(4900, 650, 0, 1, 600));
		chickens.add(new Chicken(5100, 650, 0, 1, 600));
		chickens.add(new Chicken(5300, 650, 0, 1, 600));
		
		bricks.add(new Brick(6000, 685, 0));
		bricks.add(new Brick(6000, 625, 0));
		spikes.add(new Spike(6050, 685, 0));
		spikes.add(new Spike(6100, 685, 0));
		spikes.add(new Spike(6150, 685, 0));
		spikes.add(new Spike(6200, 685, 0));
		spikes.add(new Spike(6250, 685, 0));
		
		floors.add(new Floor(6100, 925, 0, 2000));
		
		
		
		cars.add(new Car(6700, 720, 0));
	}
	public ArrayList<Chicken> getChickens() {
		return chickens;
	}
	
	public ArrayList<Car> getCars() {
		return cars;
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
