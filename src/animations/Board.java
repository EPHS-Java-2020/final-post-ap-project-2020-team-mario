package animations;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mapSetup.*;

import animations.*;


public class Board extends JPanel implements Runnable {

	private Person person;
	private final int DELAY = 10;
	private Thread animator;
	private boolean hasPainted;
	private Image floor;
	private DrawMap map;
	


	public Board() {

		initBoard();
	}

	private void initBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		hasPainted = false;
		Floor theFloor = new Floor();
		floor = theFloor.getFloor();
		person = new Person(500, 0);
		map = new DrawMap();
	}

	@Override
	public void addNotify() {
		System.out.println("In Notify");
		

		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		map.drawAll(g, person.x-person.getSX(), person.y);
		g2d.drawImage(floor, 0, 600, this);
		g2d.drawImage(floor, 700, 600, this);

		if(person.visible) {drawCharacter(g);} //if-statement new (w/out the drawCharacter method)

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawCharacter(Graphics g) {
		person.drawImage(g);
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

			person.checkCollisions(map);//new change
			cycle();
			repaint();
			person.isOnGround();
			if (person.onSomething) {
				person.land();
			} else {
				person.fall();
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



}










