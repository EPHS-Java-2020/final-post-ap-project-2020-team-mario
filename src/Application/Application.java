package Application;

//Group Member Names: Adi Kulkarni, Sarthak Agarwal, Sameen Rahman, and Kanishk Denduluri
//AP Java Project Title: Getaway Game

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

import animations.Board;

public class Application extends JFrame {
    
    public Application() {

        initUI();
    }

    private void initUI() {
        add(new Board());

        setSize(2000, 1000);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    } 
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}