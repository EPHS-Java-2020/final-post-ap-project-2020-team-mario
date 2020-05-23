package Application;


import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {
    
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(500, 500);

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
<<<<<<< HEAD
}
=======
}
>>>>>>> c6251c018e63311a079bb4339de1b9fa8320f7f9
