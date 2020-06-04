package animations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

public class HintScreen {
	private Rectangle mainMenuButton = new Rectangle(475, 35, 265, 50);
	
	public HintScreen() {
		
	}
	
	public void drawImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        Font mainMenuTXT  = new Font("arial", Font.BOLD, 20);
		g.setFont(mainMenuTXT);
		g.setColor(Color.white);
		g.drawString("Return to Main Menu", 490, 65);
		g2d.draw(mainMenuButton);
		
		Font headings  = new Font("arial", Font.BOLD, 50);
		g.setFont(headings);
		g.setColor(Color.black);
		
		g.drawString("Key Controls", 100, 100);
		g.drawString("Hazards", 100, 290);
		g.drawString("Icons To Look For", 100, 510);
		
		
		Font instructions  = new Font("arial", Font.BOLD, 30);
		g.setFont(instructions);
		g.setColor(new Color(75, 75, 75));
		
		//keystrokes
		g.drawString("• Use right arrow key to move right, left arrow key to move left", 200, 150);
		g.drawString("• Use D key to shoot right, A key to shoot left", 200, 190);
		g.drawString("• Use space key to jump", 200, 230);
		
		//hazards
		g.drawString("• Spikes --> jump over them", 200, 340);
		g.drawString("• Jumping out of bounds --> retry or you will respawn and automatically retry", 200, 380);
		g.drawString("• Chickens --> jump on them to get eggs, or they will run over you", 200, 420);
		g.drawString("• Evil Spies --> shoot them 3 times to kill them or dodge their lasers", 200, 460);
		
		//icons to look for
		g.drawString("• Grey Laser Cartridges --> helps your ammo", 200, 550);
		g.drawString("• Eggs --> get them by jumping on chickens", 200, 590);
		
		//finish a level
		g.drawString("• Look for a big red car to help you escape prison ", 200, 630);
	}
	
	public void mousePressed(MouseEvent e) {
		if(501==MouseEvent.MOUSE_PRESSED) {
			int x = e.getX();
			int y = e.getY();
			
			if(x>=mainMenuButton.getX() && x<=mainMenuButton.getMaxX()) {
				Board.currentScreen = Board.currentScreen.START_SCREEN;
			}
		}
	}
}
