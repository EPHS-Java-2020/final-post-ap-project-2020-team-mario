package Application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartScreen extends JPanel{
	private boolean waiting=true;
	public StartScreen(){
		initStartScreen();
	}
	
	public void initStartScreen() {
		addKeyListener(new TAdapter());
		setBackground(Color.blue);
		setFocusable(true);
		

	}
	public class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            keyPressed(e);
        }
    }
	
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			waiting=false;
		}

	}
	
	
	
	public void waitFor() {
		while(waiting) {
			
		}
	}
	
	
}
