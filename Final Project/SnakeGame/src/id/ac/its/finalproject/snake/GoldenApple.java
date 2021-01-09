package id.ac.its.finalproject.snake;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class GoldenApple {
	
	protected Random rand  = new Random();
	protected Point point = new Point (rand.nextInt((500 - 300)+300) , rand.nextInt(500 - 300)+300);
		public int x = point.x;
		public int y = point.y;
	
}

