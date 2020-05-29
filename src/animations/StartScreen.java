package animations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;



public class StartScreen extends JPanel{
	private Rectangle level1Button = new Rectangle(100, 500, 350, 350);
	private Rectangle level2Button = new Rectangle(550, 500, 350, 350);
	public boolean changedScreens=false;
	
	public StartScreen() {
		
	}
	
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
		
		Font title  = new Font("arial", Font.BOLD, 50);
		g.setFont(title);
		g.setColor(Color.black);
		g.drawString("ESCAPE JAIL RIGHT NOW!", 300, 100);
		
		Font levels = new Font("arial", Font.BOLD, 30);
		g.setFont(levels);
		g.setColor(Color.green);
		g.drawString("Level 1", 200, 600);
		g2d.draw(level1Button);
		
		g.setColor(Color.yellow);
		g.drawString("Level 2", 700, 600);
		g2d.draw(level2Button);
		
	}
	
	public void mousePressed(MouseEvent e) { //person class
		if (501 == MouseEvent.MOUSE_PRESSED) {
			int x = e.getX();
			int y = e.getY();
			
			if (Board.currentScreen == Board.SCREEN.START_SCREEN) {
				changedScreens=true;
				if (x >= level1Button.x && x <= level1Button.x + 350 && y >= level1Button.y
						&& y <= level1Button.y + 350) {
					Board.currentScreen = Board.currentScreen.LEVEL1;
				} else if (x >= level2Button.x && x <= level2Button.x + 350 && y >= level2Button.y
						&& y <= level2Button.y + 350) {
					Board.currentScreen = Board.currentScreen.LEVEL2;
				}
			}else {
				if(x>=775 && x<=1025 && y>=50 && y<=115) {
					Board.currentScreen = Board.currentScreen.START_SCREEN;
				}
			}
		} 
		
	}
	
	

	
}
