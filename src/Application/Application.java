package Application;


import java.awt.EventQueue;
import javax.swing.JFrame;

import animations.Board;

public class Application extends JFrame {
    
    public Application() {

        initUI();
    }

    private void initUI() {
    	StartScreen ss = new StartScreen();
    	
    	add(ss);
    	setSize(2000, 1000);
    	ss.waitFor();
    	remove(ss);
    	
    	
    	
        add(new Board());

        //setSize(2000, 1000);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }  
     
    
    
    public static void main(String[] args) {
        System.out.println("yo whazzup");
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}