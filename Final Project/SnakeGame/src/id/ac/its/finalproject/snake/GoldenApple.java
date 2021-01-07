package id.ac.its.finalproject.snake;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class GoldenApple extends Food{
	public GoldenApple()
	{
		rand = new Random();
		point = new Point((rand.nextInt(25) * Food.SIZE) + Board.gameAreaXoffset, (rand.nextInt(25) * Food.SIZE) + Board.gameAreaYoffset);
		x = point.x;
		y = point.y;

		isVisible = true;
	}
}

