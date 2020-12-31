package id.ac.its.finalproject.snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainApp() {
        initUI();
    }
    
    private void initUI() {
        
    	setLayout(new BorderLayout());

        setTitle("Snake Game");
        setSize(800, 600);

        Board game = new Board();
        add(game);
        game.requestFocusInWindow();
        getContentPane().validate();
        getContentPane().repaint();

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            MainApp ex = new MainApp();
            ex.setVisible(true);
        });
    }
}