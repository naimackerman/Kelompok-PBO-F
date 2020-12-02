package id.ac.its.evelyn111;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class Label extends JFrame{
    // frame 
    static JFrame f; 
  
    // label to display text 
    static JLabel l;
    static JLabel m;
	
    public static void main(String[] args) 
    { 
        // create a new frame to store text field and button 
        f = new JFrame("Profile"); 
  
        // create a new image icon 
        ImageIcon i = new ImageIcon("1577020.png"); 
  
        // create a label to display text and image 
        l = new JLabel("<html>"
        		+ "05111940000111<br />Evelyn Sierra</html>", i, SwingConstants.HORIZONTAL); 
       
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        // add label to panel 
        p.add(l);
  
        // add panel to frame 
        f.add(p); 
  
        // set the size of frame 
        f.setSize(1080, 1080); 
  
        f.show(); 
    } 
	
	
}
