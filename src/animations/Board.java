package animations;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mapSetup.*;

import animations.*;

import java.awt.event.*;


public class Board extends JPanel implements Runnable {

	private Person person;
	private final int DELAY = 10;
	private Thread animator;
	private boolean hasPainted;
	private Floor floor;
	private DrawMap map;
	private StartScreen starter;
	private int eggs = 0;
	private LevelManager levels;
	private Shop shop;
	private HintScreen hints;
	private File file;
	
	public static enum SCREEN{
		HINTS,
		SHOP,
		START_SCREEN,
		LEVEL1,
		LEVEL2,
		LEVEL3,
		LEVEL4
	};
	public static SCREEN currentScreen = SCREEN.START_SCREEN;


	public Board() {

		initBoard();
	}

	private void initBoard()  {
		addKeyListener(new TAdapter());
		addMouseListener(new MAdapter());
		setBackground(new Color(79, 127, 240));
		setFocusable(true);
		hasPainted = false;
		person = new Person(500, 400);
		levels = new LevelManager(0);
		map = new DrawMap(levels);
		
		
//		InputStream is = getClass().getClassLoader().getResourceAsStream("eggs.txt");
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		StringBuffer sb = new StringBuffer();
//		  String line;
//		  try {
//			while ((line = br.readLine()) != null) 
//			  {
//			    sb.append(line); 
//			  }
//			this.eggs = Integer.parseInt(sb.toString());
//			br.close();
//			is.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		FileReader fr = new FileReader(file); 
//	      char [] a = new char[50];
//	      fr.read(a);   // reads the content to the array
//	      
//	      for(char c : a)
//	         System.out.print(c);   // prints the characters one by one
//	      fr.close();
		
		file = new File("eggs.txt");
		try {
			FileReader fr = new FileReader(file);
			char[] a = new char[1000];
			try {
				fr.read(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			String numEggs="";
			for(char c: a) {
				numEggs+=c;
			}
			fr.close();
			this.eggs=Integer.parseInt(numEggs.trim());
		} catch (FileNotFoundException e) {
			this.eggs=0;
			//e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		starter=new StartScreen(eggs);
		try {
			shop = new Shop(eggs);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hints = new HintScreen();
		
	}
	private void reInitBoard() {
		if (currentScreen != SCREEN.START_SCREEN) {
			//System.out.println("Reinit was called");
			if (currentScreen == SCREEN.LEVEL1) {
				levels.changeLevel(1);
				map.changeLevel(1);
			} else if (currentScreen == SCREEN.LEVEL2){
				levels.changeLevel(2);
				map.changeLevel(2);
			} else if (currentScreen == SCREEN.LEVEL3){
				levels.changeLevel(3);
				map.changeLevel(3);
			} else if (currentScreen == SCREEN.LEVEL4){
				levels.changeLevel(4);
				map.changeLevel(4);
			} 
			person = new Person();
			map = new DrawMap(levels);
			hasPainted = false;
		}
		person.isAlive = true;
	}

	@Override
	public void addNotify() {
		super.addNotify();
		animator = new Thread(this);
		animator.start();
	}
	
	public void setCurrentToStart() {
		currentScreen=SCREEN.START_SCREEN;
	}
	public void setCurrentToLevel1() {
		currentScreen=SCREEN.LEVEL1;
	}
	public void setCurrentToLevel2() {
		currentScreen=SCREEN.LEVEL2;
	}

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if(currentScreen!=SCREEN.START_SCREEN && currentScreen!=SCREEN.SHOP && currentScreen!=SCREEN.HINTS) {
			Graphics2D g2d = (Graphics2D) g;
			map.drawAll(g, person.x, person.y);

			if(person.visible) {
				drawCharacter(g);
			} else if(person.escaped) {
				Font finish  = new Font("arial", Font.BOLD, 80);
				g.setFont(finish);
				g.setColor(Color.black);
				g.drawString("FREEDOM!", 800, 300);
			}

			
			//home button

	        RenderingHints rh
	                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);

	        rh.put(RenderingHints.KEY_RENDERING,
	                RenderingHints.VALUE_RENDER_QUALITY);

	        g2d.setRenderingHints(rh);
			
			Font title  = new Font("arial", Font.BOLD, 20);
			g.setFont(title);
			g.setColor(Color.white);
			g.drawString("Return to Main Menu (M)", 490, 65);
			g2d.draw(new Rectangle(475, 35, 265, 50));
			
			Font retryTitle  = new Font("arial", Font.BOLD, 20);
			g.setFont(retryTitle);
			g.setColor(Color.black);
			g.drawString("Retry (R)", 765, 65);
			g2d.draw(new Rectangle(750, 35, 115, 50));
			
			Font ammoTitle = new Font("arial", Font.BOLD, 40);
			g.setFont(ammoTitle);
			g.setColor(Color.black);
			g.drawString("Ammo: " + person.ammo, 100, 65);
			
			Font coinsTitle = new Font("arial", Font.BOLD, 40);
			g.setFont(coinsTitle);
			g.setColor(Color.black);
			g.drawString("Eggs: " + eggs, 1100, 65);
			
		}else if(currentScreen==SCREEN.START_SCREEN){
			starter.drawImage(g);
		}else if(currentScreen==SCREEN.SHOP){
			shop.drawImage(g);
			Font coinsTitle = new Font("arial", Font.BOLD, 40);
			g.setFont(coinsTitle);
			g.setColor(Color.black);
			g.drawString("Eggs: " + eggs, 1100, 65);
		}else if (currentScreen == SCREEN.HINTS){
			hints.drawImage(g);
		} else {
			
		}
		
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawCharacter(Graphics g) {
		if (person.visible) {
			person.setColorScheme(shop.decidedPantColor, shop.decidedShirtColor, shop.decidedShoeColor);
			person.drawImage(g);
		}
	}
	
	
	private void cycle() {
		List<Bullet> bullets = person.getBullets();

        for (int i = 0; i < bullets.size(); i++) {

        	Bullet bullet = bullets.get(i);

            if (bullet.visible) {
                bullet.move();
            } else {
                bullets.remove(i);
                i--; //was not here previously
            }
            
        }
        person.move();
        
        for(int i=0; i<map.getEnemies().size(); i++) {
        	if(!map.getEnemies().get(i).visible) {
        		map.getEnemies().remove(i);
        	}
        }
	}
	

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {
			repaint();
			if (currentScreen != SCREEN.START_SCREEN && currentScreen != SCREEN.SHOP && currentScreen != SCREEN.HINTS) {
				if(starter.needToRefresh) {
					reInitBoard();
					starter.needToRefresh=false;
				} else {

					cycle();
					person.checkCollisions(map);
					ArrayList<Enemy> enemies = map.getEnemies();
					for(Enemy enemy: enemies) {
						enemy.checkCollisions(person.getBullets());
					}
					eggs+=person.coins;
					starter.eggs=eggs;
					shop.eggs=eggs;
				
					
					
					if (person.onSomething) {
						person.land();
					} else {
						person.fall();
						if (person.needToRefresh) {
							reInitBoard();
							person.needToRefresh = false;
						}
					}
				}
			}
			eggs = shop.eggs;
			starter.eggs = eggs;
//			try {
//				PrintStream output = new PrintStream(new File("resources/qeggs.txt"));
//				output.println(this.eggs);
//				output.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
			
			file = new File("eggs.txt");
			try {
				PrintStream fos = new PrintStream("eggs.txt");

				//byte[] mybytes = ("" + eggs).getBytes();

				//fos.write(mybytes);
				fos.println(this.eggs);
				//fos.flush();
				fos.close();
	        }catch(IOException e) {
	        	try {
					file.createNewFile();
					PrintStream fos = new PrintStream("eggs.txt");
					fos.println(this.eggs);
					fos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	        }
			
//			//File file = new File("eggs.txt");
//			try {
//				FileWriter writer = new FileWriter(file);
//				writer.write(this.eggs);
//				writer.flush();
//				writer.close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				try {
//					file.createNewFile();
//					FileWriter writer = new FileWriter(file);
//					writer.write(this.eggs);
//					writer.flush();
//					writer.close();
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				e1.printStackTrace();
//			}

		
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {

				String msg = String.format("Thread interrupted: %s", e.getMessage());

				JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
			}

			beforeTime = System.currentTimeMillis();
		}
	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            person.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            person.keyPressed(e);
            starter.keyPressed(e);
        }
    }

	private class MAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {

			starter.mousePressed(e);
			if (starter.changedFromStartScreen) {
				reInitBoard();
				if(currentScreen==SCREEN.SHOP) {
					shop.mousePressed(e);
				}
				if(currentScreen==SCREEN.HINTS) {
					hints.mousePressed(e);
				}
			}

		}
	}

}










