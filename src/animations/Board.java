package animations;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

import animations.*;


public class Board extends JPanel implements Runnable {

	private Person person;
	//private Enemy enemy;
	private final int DELAY = 10;
	private Thread animator;

	public Board() {

		initBoard();
	}

	private void initBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);

		person = new Person();
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawCharacter(g);

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawCharacter(Graphics g) {
		person.drawImage(g);
	}
	
	private void cycle() {

        /*for (int i = 0; i < bullets.size(); i++) {

        	Bullet bullet = bullets.get(i);

            if (bullet.isVisible()) {

                bullet.move();
            } else {

                bullets.remove(i);
            }
            
        }
        */
        person.move();
	}

	@Override
	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (true) {

			cycle();
			repaint();

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










//public class Board extends JPanel
//        implements Runnable{
//
//	private Character character;
//	
////    private final int B_WIDTH = 1000;
////    private final int B_HEIGHT = 1000;
////    private final int INITIAL_X = -40;
////    private final int INITIAL_Y = 500;
//    private final int DELAY = 10;
//
//    private Image star;
//    private Thread animator;
////    private int starWidth=100, starHeight=100;
////    private int x, y;
////    private int incX=2;
////    private int incY=0;
//
//    public Board() {
//
//        initBoard();
//    }
//
//    private void loadImage() {
//
//        ImageIcon ii = new ImageIcon("images/star.png");
//        star = ii.getImage();
//    }
//
//    private void initBoard() {
//
//    	addKeyListener(new TAdapter());// not same
//        setBackground(Color.black); 
//        setFocusable(true);
//
//        
//        character=new Character();
//
//        //add new Timer(DELAY, this) and start it
//    }
//
//    @Override
//    public void addNotify() {
//        super.addNotify();
//
//        animator = new Thread(this);
//        animator.start();
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        drawCharacter(g);
//        
//        Toolkit.getDefaultToolkit().sync();
//    }
//
//    private void drawCharacter(Graphics g) {
//
//    	Graphics2D g2d = (Graphics2D) g;
////        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
//    	
//    	//draw the character
//    	//Graphics2D g2d = (Graphics2D) g;
//
//        RenderingHints rh
//                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
//                        RenderingHints.VALUE_ANTIALIAS_ON);
//
//        rh.put(RenderingHints.KEY_RENDERING,
//                RenderingHints.VALUE_RENDER_QUALITY);
//
//        g2d.setRenderingHints(rh);
//
//        Dimension size = getSize();
//        double w = size.getWidth();
//        double h = size.getHeight();
//        
//        int x = character.getX();
//        int y = character.getY();
//        
//        Rectangle2D hair = new Rectangle2D.Double(x+7, y-225, 50, 10);
//        g2d.setColor(new Color(87, 49, 26));
//        g2d.fill(hair);
//
//        Rectangle2D head = new Rectangle2D.Double(x+7, y-215, 50, 50);
//        g2d.setStroke(new BasicStroke(3));
//        g2d.setColor(new Color(255, 210, 143));
//        g2d.fill(head);
//        Rectangle2D eye1 = new Rectangle2D.Double(x+10, y-205, 10, 10);
//        Rectangle2D eye2 = new Rectangle2D.Double(x+31, y-205, 10, 10);
//        Rectangle2D mouth = new Rectangle2D.Double(x+10, y-182, 30, 7);
//        g2d.setColor(new Color(163, 77, 77));
//        g2d.fill(mouth);
//        g2d.setColor(new Color(49, 54, 53));
//        g2d.fill(eye1);
//        g2d.fill(eye2);
//        Rectangle2D body = new Rectangle2D.Double(x+7, y-165, 50, 85);
//        g2d.setColor(new Color(77, 73, 73));
//        g2d.fill(body);
//
//        Rectangle2D rightArm = new Rectangle2D.Double(x-13, y-165, 20, 80);
//        Rectangle2D leftArm = new Rectangle2D.Double(x+57, y-165, 20, 80);
//        g2d.setColor(new Color(255, 210, 143));
//        g2d.fill(rightArm);
//        g2d.fill(leftArm);
//
//        Rectangle2D leftLeg = new Rectangle2D.Double(x+7, y-80, 23, 80);
//        Rectangle2D rightLeg = new Rectangle2D.Double(x+34, y-80, 23, 80);
//        g2d.setColor(new Color(32, 51, 97));
//        g2d.fill(leftLeg);
//        g2d.fill(rightLeg);
//        
//        Rectangle2D rightShoe = new Rectangle2D.Double(x+34, y, 30, 15);
//        g2d.setColor(new Color(100, 100, 100));
//        g2d.fill(rightShoe);
//        Rectangle2D leftShoe = new Rectangle2D.Double(x, y, 30, 15);    
//        g2d.setColor(new Color(100, 100, 100));
//        g2d.fill(leftShoe);
//        
//    }
//              
//    
//
//    @Override
//    public void run() {
//
//        long beforeTime, timeDiff, sleep;
//
//        beforeTime = System.currentTimeMillis();
//
//        while (true) {
//
//        	character.move();
//            repaint();
//
//            timeDiff = System.currentTimeMillis() - beforeTime;
//            sleep = DELAY - timeDiff;
//
//            if (sleep < 0) {
//                sleep = 2;
//            }
//
//            try {
//                Thread.sleep(sleep);
//            } catch (InterruptedException e) {
//                
//                String msg = String.format("Thread interrupted: %s", e.getMessage());
//                
//                JOptionPane.showMessageDialog(this, msg, "Error", 
//                    JOptionPane.ERROR_MESSAGE);
//            }
//
//            beforeTime = System.currentTimeMillis();
//        }
//    }
//
//
//	private class TAdapter extends KeyAdapter {
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            character.keyReleased(e);
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            character.keyPressed(e);
//        }
//    }
//}