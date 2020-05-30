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
import java.util.ArrayList;
import java.util.List;

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
	private LevelManager levels;
	
	public static enum SCREEN{
		START_SCREEN,
		LEVEL1,
		LEVEL2
	};
	public static SCREEN currentScreen = SCREEN.START_SCREEN;


	public Board() {

		initBoard();
	}

	private void initBoard() {
		addKeyListener(new TAdapter());
		addMouseListener(new MAdapter());
		setBackground(new Color(79, 127, 240));
		setFocusable(true);
		hasPainted = false;
		person = new Person(500, 450);
		starter=new StartScreen();
		levels = new LevelManager(0);
		map = new DrawMap(levels);
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
			}
			person = new Person();
			map = new DrawMap(levels);
			hasPainted = false;
		}
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
		
		if(currentScreen!=SCREEN.START_SCREEN) {
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
			g.drawString("Return to Main Menu", 1500, 65);
			g2d.draw(new Rectangle(1475, 35, 250, 50));
			
			Font retryTitle  = new Font("arial", Font.BOLD, 20);
			g.setFont(retryTitle);
			g.setColor(Color.white);
			g.drawString("Retry", 775, 65);
			g2d.draw(new Rectangle(1750, 35, 100, 50));
			
		}else {
			starter.drawImage(g);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawCharacter(Graphics g) {
		if (person.visible) {
			person.drawImage(g);
		}
	}
	
	
	private void cycle() {
		List<Bullet> bullets = person.getBullets();

        for (int i = 0; i < bullets.size(); i++) {

        	Bullet bullet = bullets.get(i);

            if (bullet.isVisible()) {

                bullet.move();
            } else {

                bullets.remove(i);
            }
            
        }
        person.move();
	}
	

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {
			repaint();
			if (currentScreen != SCREEN.START_SCREEN) {
				if(starter.needToRefresh) {
					reInitBoard();
					starter.needToRefresh=false;
				} else {

					cycle();
					person.checkCollisions(map);// new change
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
        }
    }

	private class MAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {

			starter.mousePressed(e);
			if (starter.changedFromStartScreen) {
				reInitBoard();
			}

		}
	}

}










