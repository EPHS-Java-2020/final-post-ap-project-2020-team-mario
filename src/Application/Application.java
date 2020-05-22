package Application;

import java.awt.EventQueue;
import javax.swing.JFrame;

import Drawings.Character;

public class Application extends JFrame {
    
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Character());

        setSize(500, 500);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //this is a test comment
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
//hello
//this is sentence