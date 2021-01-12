package id.ac.its.finalproject.snake;

import java.util.Random;

public class Obstacle extends Items{
    
	//Default Constructor
    public Obstacle() {
		super();
	}
    
	// Fungsi baru untuk merandom letak obstacle X saat bermain level hard
	public int randomObstacleX(int[] obstaclexPos) {
		int random = new Random().nextInt(obstaclexPos.length);
	    return obstaclexPos[random];
	}
	
	// Fungsi baru untuk merandom letak obstacle Y saat bermain level hard
	public int randomObstacleY(int[] obstacleyPos) {
		int random = new Random().nextInt(obstacleyPos.length);
	    return obstacleyPos[random];
	}
}