package id.ac.its.nurahmadkhatim074;

import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelFrame extends JFrame {
	private final JLabel label;
	
	public LabelFrame() {
		super("NRP dan Nama");
		setLayout(new FlowLayout());
		
		Icon image = new ImageIcon("foto.jpg");
		label = new JLabel("<html>05111940000074<br>Nur Ahmad Khatim</html>", image, SwingConstants.LEFT);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM); 
		add(label);
	}
}
