package id.ac.its.daffa175;

import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.*;

public class Frame extends JFrame{

	private final JLabel label;

	public Frame() {
		super("Info Mahasiswa");
		setLayout(new FlowLayout());
		
		Icon bug = new ImageIcon("daffa.jpg");
		label = new JLabel("<html>05111940000111<br>Muhammad Daffa</html>", bug, SwingConstants.LEFT);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM); 
		add(label);
	}
}