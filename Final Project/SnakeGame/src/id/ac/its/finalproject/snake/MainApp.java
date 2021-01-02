package id.ac.its.finalproject.snake;

import java.awt.Color;
import javax.swing.JFrame;

public class MainApp {
    public static void main(String[] args) {
    	JFrame obj = new JFrame("Snake game");
        Board board = new Board();

        obj.setBounds(10, 10, 910, 750);
        obj.setBackground(Color.BLACK);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(Board);
    }
}