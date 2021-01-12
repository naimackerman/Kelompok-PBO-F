package id.ac.its.finalproject.snake;

public class Apple extends Items{
	
	private Score score;
	
	//Default constructor
	public Apple() {
		super();
		this.score = new Score();
	}

	
	@Override
	public int increaseScore() {
		score.increaseScore(1); //peningkatan skor sesuai dengan jenis apel yang dimakan
		return score.getScore();
	}
}
