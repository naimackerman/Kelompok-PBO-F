package id.ac.its.finalproject.snake;

public class Apple extends Items{
	
	private Score score;
	
	//Default constructor
	public Apple() {
		super();
		this.score = new Score();
	}
	
//	@Override
//	public int getScore() {
//		return score.getScore();
//	}
	
	@Override
	public int increaseScore() {
		score.increaseScore(1);
		return score.getScore();
	}
}
