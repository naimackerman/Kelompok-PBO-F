package id.ac.its.finalproject.snake;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Board extends JPanel implements KeyListener, ActionListener {
	// instansiasi objek snake
	Snake snake = new Snake();

	// instansiasi objek apple
	Apple apple = new Apple();

	// inisiasi goldenapple
	GoldenApple goldenapple = new GoldenApple();

	// instansiasi objek obstacle
	Obstacle obstacle = new Obstacle();

	// Array berisi level gameplay
	private String[] options = new String[] { "Easy", "Hard" };

	// Memulai timer
	private Timer timer;
	private final int delayeasy = 200;
	private final int delayhard = 100;

	// lebar dan tinggi gameplay
	private final int gameAreaXoffset = 619;
	private final int gameAreaYoffset = 613;

	// counter untuk menghitung apel keluar berapa kali
	private int counter = 1;
	
	private int totalScore = 0;
	private int totalScore1 = 0;

	// choice adalah pilihan level, jika level 0 = easy & 1 = hard
	private int choice = 5;

	// buat gambar snake
	private ImageIcon snakeHead;
	private ImageIcon snakeBody;

	// koordinat letak kepala ular
	private int snakeHeadXPos = 379;
	private int snakeHeadYPos = 379;

	// Buat gambar apple & golden
	private ImageIcon appleImage;
	private ImageIcon goldenappleImage;

	// Buat gambar obstacle
	private ImageIcon obstacleImage;

	// Untuk generate random number
	private Random random = new Random();

	// Untuk merandom array ke berpa
	private final int jumlahArray = 99;
	private int xPos = random.nextInt(jumlahArray);
	private int yPos = random.nextInt(jumlahArray);

	// Buat score game
	Score score = new Score();

	// Buat Highscore
	private String highScore;

	// jumlah obstacle yang akan muncul
	private final int jumlahObstacle = 75;
	private int randomObsX[] = new int[jumlahObstacle];
	private int randomObsY[] = new int[jumlahObstacle];

	// Default constructor
	public Board() {
		// buat pas mulai gamenya
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		for (int i = 0; i < jumlahObstacle; i++) {
			randomObsX[i] = obstacle.randomObstacleX(obstacle.ItemsxPos);
			randomObsY[i] = obstacle.randomObstacleY(obstacle.ItemsyPos);
		}

	}

	public void paint(Graphics g) {
		// cek jika game udah dimulai
		if (snake.getMoves() == 0) {
			for (int i = 0; i < 5; i++) {
				snake.getSnakexLength()[i] = snakeHeadXPos;
				snake.getSnakeyLength()[i] = snakeHeadYPos;
				snakeHeadXPos -= 6;
			}
		}
		// Untuk menutupi JOptionPane yang ada diujung layar
		if (choice == 0 || choice == 1) {
			g.setColor(Color.GRAY);
			g.fillRect(-10, -10, 910, 750);
		}
		// Border untuk judul
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 852, 55);

		// Background judul
		g.setColor(Color.black);
		g.fillRect(25, 11, 851, 54);

		// Menampilkan Judul Judul
		g.setColor(Color.white);
		g.setFont(new Font("Helvetica", Font.BOLD, 30));
		g.drawString("Snake Game", 350, 50);

		// Border untuk gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 71, 620, 614);

		// Background gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 72, gameAreaXoffset, gameAreaYoffset);

		// Border untuk highscore
		g.setColor(Color.WHITE);
		g.drawRect(653, 71, 223, 614);

		// Background highschore
		g.setColor(Color.BLACK);
		g.fillRect(654, 72, 221, 613);
		
		// Menampilkan score
		int AllScore = totalScore + totalScore1;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.drawString("SCORE : " + AllScore, 720, 110);
		g.drawRect(653, 130, 221, 1);
		score.setScore(AllScore);

		// Menampilkan highscore
		score.sortHighScore();
		highScore = score.getHighScore();
		g.drawString("HIGHSCORE", 705, 180);
		drawString(g, highScore, 705, 200);
		
		// Sebelum user memencet spacebar, items yang ada di board tidak muncul
		if (snake.getMoves() == 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 26));
			g.drawString("Press Spacebar to Start the Game!", 70, 300);
			g.drawString("Press C to See Credits", 70, 350);
		}

		// Instansiasi gambar untuk kepala ular
		snakeHead = new ImageIcon("images/Head.png");
		snakeHead.paintIcon(this, g, snake.getSnakexLength()[0], snake.getSnakeyLength()[0]);

		for (int i = 0; i < snake.getLengthOfSnake(); i++) {
			if (i == 0 && (snake.isRight() || snake.isLeft() || snake.isUp() || snake.isDown())) {
				snakeHead = new ImageIcon("images/Head.png");
				snakeHead.paintIcon(this, g, snake.getSnakexLength()[i], snake.getSnakeyLength()[i]);
			}
			if (i != 0) {
				snakeBody = new ImageIcon("images/Body.png");
				snakeBody.paintIcon(this, g, snake.getSnakexLength()[i], snake.getSnakeyLength()[i]);
			}

		}

		// instansiasi gambar buat apel, golden apel, dan osbtacle
		appleImage = new ImageIcon("images/Apple.png");
		goldenappleImage = new ImageIcon("images/GoldenApple.png");
		obstacleImage = new ImageIcon("images/Obstacle.png");

		// Jika saat ular bergerak, menggambar item di board
		if (snake.getMoves() != 0) {

			appleImage.paintIcon(this, g, apple.ItemsxPos[xPos], apple.ItemsyPos[yPos]);

			// Jika kelipatan 6, maka akan muncul golden apple
			if (counter % 6 == 0) {
				goldenappleImage.paintIcon(this, g, goldenapple.ItemsxPos[xPos], goldenapple.ItemsyPos[yPos]);
			}

			// Jika milih level hard, keluar obstacle
			if (choice == 1) {
				for (int i = 0; i < jumlahObstacle; i++) {
					obstacleImage.paintIcon(this, g, randomObsX[i], randomObsY[i]);
				}
			}
		}

		// Jika snakenya makan apelnya
		if ((apple.ItemsxPos[xPos] == snake.getSnakexLength()[0]) && (apple.ItemsyPos[yPos] == snake.getSnakeyLength()[0])
				&& !(counter % 6 == 0)) {
			snake.setLengthOfSnake(snake.getLengthOfSnake() + 1);
			xPos = random.nextInt(jumlahArray);
			yPos = random.nextInt(jumlahArray);
			totalScore =+ apple.increaseScore();
			counter++; // untuk menghitung jumlah apple yang telah di makan
		}

		// saat makan golden apel
		if ((goldenapple.ItemsxPos[xPos] == snake.getSnakexLength()[0])
				&& (goldenapple.ItemsyPos[yPos] == snake.getSnakeyLength()[0]) && (counter % 6 == 0)) {

			snake.setLengthOfSnake(snake.getLengthOfSnake() + 3);
			xPos = random.nextInt(jumlahArray);
			yPos = random.nextInt(jumlahArray);
			totalScore1 =+ goldenapple.increaseScore();
			counter = 1;
		}


		// Jika kepala ular menabrak obstacle
		for (int i = 0; i < jumlahObstacle; i++) {
			//jika ular mengenai obstacle
			if (randomObsX[i] == snake.getSnakexLength()[0] && randomObsY[i] == snake.getSnakeyLength()[0]) {
				snake.dead();
			}
		}

		// Jika kepala ular menabrak badan ular
		for (int i = 1; i < snake.getLengthOfSnake(); i++) {
			if (snake.getSnakexLength()[i] == snake.getSnakexLength()[0] && snake.getSnakeyLength()[i] == snake.getSnakeyLength()[0]) {
				snake.dead();
			}
		}

		// Cek jika ular mati
		if (snake.isDeath()) {

			// Save score ke file highscore.dat
			score.saveNewScore();

			// Menampilkan tulisan "Game Over!"
			g.setColor(Color.RED);
			g.setFont(new Font("Courier New", Font.BOLD, 50));
			g.drawString("Game Over!", 190, 340);

			// Menampilkan score
			g.setColor(Color.GREEN);
			g.setFont(new Font("Courier New", Font.BOLD, 18));
			g.drawString("Your Score : " + AllScore, 250, 370);

			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 20));
			g.drawString("Press R to go to main menu!", 187, 400);

		}
		g.dispose();
	}

	// Untuk menampilkan di layar string dengan \n di dalamnya
	public void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		timer.start();

		// Untuk pergerakan ular
		// Menggerakkan ular ke kanan
		if (snake.isRight()) {
			// Memanggil fungsi pada class Snake untuk menggerakkan ular ke kanan
			snake.movementRight();
			repaint();
		}
		// menggerakkan ular ke kiri
		if (snake.isLeft()) {
			snake.movementLeft();
			repaint();
		}
		// menggerakkan ular ke atas
		if (snake.isUp()) {
			snake.movementUp();
			repaint();
		}
		// menggerakkan ular ke bawah
		if (snake.isDown()) {
			snake.movementDown();
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		// Kondisi penekanan tombol
		switch (e.getKeyCode()) {

		// jika user menekan spasi
		case KeyEvent.VK_SPACE:

			// Dialog untuk memilih level
			choice = JOptionPane.showOptionDialog(null, "Pilih level", "Level", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (snake.getMoves() == 0) {
				snake.setMoves(snake.getMoves() + 1);
				snake.setRight(true);
				// Jika memilih level easy
				if (choice == 0) {
					timer = new Timer(delayeasy, this);
					timer.start();
				}
				// Saat memilih level "hard" maka ular akan semakin cepat
				else if (choice == 1) {
					timer = new Timer(delayhard, this);
					timer.start();
				}


				// Tombol close di dialog pilih level
			} else if (choice == JOptionPane.CLOSED_OPTION) {

			}

		// jika user tekan arrow right
		case KeyEvent.VK_RIGHT:
			snake.moveRight();
			break;

		// jika user tekan arrow left
		case KeyEvent.VK_LEFT:
			snake.moveLeft();
			break;

		// jika user tekan arrow up
		case KeyEvent.VK_UP:
			snake.moveUp();
			break;

		// jika user tekan arrow down
		case KeyEvent.VK_DOWN:
			snake.moveDown();
			break;

		// Memencet C akan memunculkan credit
		case KeyEvent.VK_C:
			JOptionPane.showMessageDialog(null,
					"Muhammad Daffa 05111940000175\nNur Ahmad Khatim 05111940000074\nEvelyn Sierra 05111940000111");

			break;

		// Saat mati, pencet R untuk kembali ke home + kondisi yang lain
		case KeyEvent.VK_R:
			// Kondisi jika ular mati
			if (snake.isDeath()) {
				snake.setMoves(0);
				snake.setLengthOfSnake(5);
				score.resetScore();
				snake.setDeath(false);
				counter = 1;
				timer.stop();
				repaint();
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}