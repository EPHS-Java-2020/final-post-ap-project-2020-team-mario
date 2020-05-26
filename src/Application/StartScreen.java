package Application;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class StartScreen extends JPanel{
	private boolean start = true;
	
	public StartScreen() {
		initBoard();
	}
	
	private void initBoard() {
		
	}

	public void waitFor() {
		
		while(start) {
			
		}
	}
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			start = false;
		}

	}
}
