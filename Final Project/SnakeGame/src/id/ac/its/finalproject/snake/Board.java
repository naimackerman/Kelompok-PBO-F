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
import java.util.*;

public class Board extends JPanel implements KeyListener, ActionListener {
	// instansiasi objek snake
	Snake snake = new Snake();

	// instansiasi objek apple
	Apple apple = new Apple();
	
	//inisiasi goldenapple
	GoldenApple goldenapple = new GoldenApple();

	// instansiasi objek obstacle
	Obstacle obstacle = new Obstacle();
	
	Scanner scanner = new Scanner(System.in);

	// buat gambar kepala
	private ImageIcon snakeHead;

	String[] options = new String[] { "Easy", "Hard" };

	private Timer timer;
	private int delayeasy = 200;
	private int delayhard = 100;
	
	public static final int gameAreaXoffset = 619;
	public static final int gameAreaYoffset = 613;
	
	private int counter = 1;
	private int flag = 0;
	
	int choice = 5;
	
	private ImageIcon snakeBody;

	// koordinat letak kepala ular
	private int snakeHeadXPos = 379;

	// Buat gambar apple
	private ImageIcon appleImage;
	private ImageIcon goldenappleImage;

	// Buat gambar obstacle
//	private ImageIcon obstacleImsage;

	// Untuk generate random number
	private Random random = new Random();

	private int xPos = random.nextInt(100);
	private int yPos = random.nextInt(100);

	// Buat score game
	Score score = new Score();

	// Buat Highscore
	private String highScore;

	public Board() {
		// buat pas mulai gamenya
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paint(Graphics g) {
		// cek jika game udah dimulai
		if (snake.moves == 0) {
			for (int i = 0; i < 5; i++) {
				snake.snakexLength[i] = snakeHeadXPos;
				snakeHeadXPos -= 6;
				snake.snakeyLength[i] = 355;
			}
		}
		// untuk fix bug joptionpane yang selalu ke ujung :)
		if (choice == 0 || choice == 1) {
			g.setColor(Color.GRAY);
			g.fillRect(-10, -10, 910, 750);
		}
		// border judul
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 852, 55);

		// background judul
		g.setColor(Color.black);
		g.fillRect(25, 11, 851, 54);

		// Tampilin Judul
		g.setColor(Color.white);
		g.setFont(new Font("Helvetica", Font.BOLD, 30));
		g.drawString("Snake Game", 350, 50);
		
		// border untuk gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 71, 620, 614);

		// background gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 72, gameAreaXoffset, gameAreaYoffset);

		// border untuk leaderboard
		g.setColor(Color.WHITE);
		g.drawRect(653, 71, 223, 614);

		// background leaderboard
		g.setColor(Color.BLACK);
		g.fillRect(654, 72, 221, 613);

		// Tampilin Score
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.drawString("SCORE : " + score.getScore(), 720, 110);
		g.drawRect(653, 130, 221, 1);

		
		// Tampilin HighScore
		score.sortHighScore();
		highScore = score.getHighScore();
		g.drawString("HIGHSCORE", 705, 180);
		drawString(g, highScore, 705, 200);

		// instansiasi gambar buat kepala ular
		snakeHead = new ImageIcon("images/Head.png");
		snakeHead.paintIcon(this, g, snake.snakexLength[0], snake.snakeyLength[0]);

		for (int i = 0; i < snake.lengthOfSnake; i++) {
			if (i == 0 && (snake.right || snake.left || snake.up || snake.down)) {
				snakeHead = new ImageIcon("images/Head.png");
				snakeHead.paintIcon(this, g, snake.snakexLength[i], snake.snakeyLength[i]);
			}
			if (i != 0) {
				snakeBody = new ImageIcon("images/Body.png");
				snakeBody.paintIcon(this, g, snake.snakexLength[i], snake.snakeyLength[i]);
			}
			
		}

		appleImage = new ImageIcon("images/Apple.png");
		goldenappleImage = new ImageIcon("images/GoldenApple.png");

		
		if (snake.moves != 0) {	
			appleImage.paintIcon(this, g, apple.applexPos[xPos], apple.appleyPos[yPos]);
			
			if (counter % 6 == 0) {
				goldenappleImage.paintIcon(this, g, goldenapple.GoldenApplexPos[xPos], goldenapple.GoldenAppleyPos[yPos]);
			}
		}
		

		// Jika snakenya makan apelnya
		if ((apple.applexPos[xPos] == snake.snakexLength[0]) && (apple.appleyPos[yPos] == snake.snakeyLength[0]) && !(counter % 6 == 0))  {
			snake.lengthOfSnake++;
			score.increaseScore(1);
			xPos = random.nextInt(100);
			yPos = random.nextInt(100);
			
			counter++; //untuk menghitung jumlah apple yang telah di makan
		}
		
		//saat makan golden apel
		if ((goldenapple.GoldenApplexPos[xPos] == snake.snakexLength[0]) && (goldenapple.GoldenAppleyPos[yPos] == snake.snakeyLength[0]) && (counter % 6 == 0))  {
			
			snake.lengthOfSnake++;
			score.increaseScore(5);
			xPos = random.nextInt(100);
			yPos = random.nextInt(100);
			
			counter = 1;
		}
		
		
//		obstacleImage = new ImageIcon("images/Obstacle.png");
//
//		if ((obstacle.obstaclexPos[xPos]) == snake.snakexLength[0]
//				&& (obstacle.obstacleyPos[yPos] == snake.snakeyLength[0])) {
//			snake.dead();
//		}

		
		// Sebelum user mencet spacebar, apple dan obstacle ga muncul
		if (snake.moves == 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 26));
			g.drawString("Press Spacebar to Start the Game!", 70, 300);
			g.drawString("Press C to See Credits", 70, 350);
		}

		// Cek jika kepala menabrak badan
		for (int i = 1; i < snake.lengthOfSnake; i++) {
			// jika tabrakan terjadi
			if (snake.snakexLength[i] == snake.snakexLength[0] && snake.snakeyLength[i] == snake.snakeyLength[0]) {
				// panggil function dead
				snake.dead();
			}
		}
		
		// Cek jika mati
		if (snake.death) {

			// Save Scorenya ke file highscore.dat
			score.saveNewScore();

			// menampilkan tulisan "Game Over!"
			g.setColor(Color.RED);
			g.setFont(new Font("Courier New", Font.BOLD, 50));
			g.drawString("Game Over!", 190, 340);

			// menampilkan score
			g.setColor(Color.GREEN);
			g.setFont(new Font("Courier New", Font.BOLD, 18));
			g.drawString("Your Score : " + score.getScore(), 250, 370);

			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.BOLD, 20));
			g.drawString("Press R to go to main menu!", 187, 400);

		}
		g.dispose();
	}

	// Void untuk menampilkan di layar string dengan \n di dalamnya
	public void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		timer.start();

		// untuk pergerakan ular
		// menggerakkan ular ke kanan
		if (snake.right) {
			// panggil fungsi pada class Snake untuk menggerakkan ular ke kanan
			snake.movementRight();
			// panggil kem matis
			repaint();
		}
		// menggerakkan ular ke kiri
		if (snake.left) {
			// panggil fungsi pada class Snake untuk menggerakkan ular ke kiri
			snake.movementLeft();
			// panggil kembali method paint secara otomatis
			repaint();
		}
		// menggerakkan ular ke atas
		if (snake.up) {
			// panggil fungsi pada class Snake untuk menggerakkan ular ke atas
			snake.movementUp();
			// panggil kembali method paint secara otomatis
			repaint();
		}
		// menggerakkan ular ke bawah
		if (snake.down) {
			// panggil fungsi pada class Snake untuk menggerakkan ular ke bawah
			snake.movementDown();
			// panggil kembali method paint secara otomatis
			repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// kondisi penekanan tombol
		switch (e.getKeyCode()) {

		// jika user tekan spasi
		case KeyEvent.VK_SPACE:

			choice = JOptionPane.showOptionDialog(null, "Pilih level", "Level", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				if (choice == 0) {
					if (snake.moves == 0) {
						snake.moves++;
						snake.right = true;
						timer = new Timer(delayeasy, this);
						timer.start();
					}

				} else if (choice == 1) {
					if (snake.moves == 0) {
						snake.moves++;
						snake.right = true;
						timer = new Timer(delayhard, this);
						timer.start();
					}

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

		case KeyEvent.VK_C:
			JOptionPane.showMessageDialog(null,
						"Muhammad Daffa 05111940000175\nNur Ahmad Khatim 05111940000074\nEvelyn Sierra 05111940000111");
			
			break;

		case KeyEvent.VK_R:

			if (snake.death) {
				snake.moves = 0;
				snake.lengthOfSnake = 5;
				score.resetScore();
				snake.death = false;
				counter = 1;
				repaint();
			}
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
