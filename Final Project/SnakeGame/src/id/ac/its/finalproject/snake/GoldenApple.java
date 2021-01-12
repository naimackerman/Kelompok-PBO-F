package id.ac.its.finalproject.snake;

public class GoldenApple extends Items{
	
	private Score score;
	
	//Default constructor
	public GoldenApple() {
		super();
		this.score = new Score();
	}

//	@Override
//	public int getScore() {
//		return score.getScore();
//	}
	
	@Override
	public int increaseScore() {
		score.increaseScore(5);
		return score.getScore();
	}
}
