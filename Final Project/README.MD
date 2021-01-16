# Snake Game
### Jenis Aplikasi = Game

* MainApp.java

Class ini adalah class utama yang digunakan untuk menjalankan program aplikasi game snake yang dibuat.

dengan ukuran dan warna :
```
 obj.setBounds(10, 10, 910, 750);
        obj.setBackground(Color.GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(board);
 ```

* Snake.java

Snake.java adalah class untuk merepresentasikan class yang di dalamnya terdapat function untuk meng-initiate snake dan menyimpan pergerakan ular serta penambahan panjang ular setelah memakan apple.

Untuk menentukan letak awal ular dapat di lihat di :
```
    private int[] snakexLength = new int[750];
    private int[] snakeyLength = new int[750];
```

Constructor ular terdapat di bagian function :
```
public Snake() {
        this.setLeft(false);
        this.setRight(false);
        this.setUp(false);
        this.setDown(false);
        this.setDeath(false);
        this.setLengthOfSnake(5);
        this.setMoves(0);
    }
```
Selanjutnya, menggunakan setter dan getter untuk mengambil dan menggunakan panjang ular :
```
public int[] getSnakexLength() {
		return snakexLength;
	}

	public void setSnakexLength(int[] snakexLength) {
		this.snakexLength = snakexLength;
	}

	//Getter & Setter untuk SnakeyLength
	public int[] getSnakeyLength() {
		return snakeyLength;
	}

	public void setSnakeyLength(int[] snakeyLength) {
		this.snakeyLength = snakeyLength;
	}
```
Cara pergerakkan ular pada game ini sebatas, gerak ke atas, bawah, kiri dan kanan. Bisa dilihat di function :
```
public void moveRight()
public void moveLeft()
public void moveUp()
public void moveDown()

```
dan jangan lupa untuk menggunakan setter dan getter untuk menyimpan dan update nilai setiap movement ular, baik pergerakkan ke kanan, kiri, atas ataupun bawah

```
public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	//Getter & Setter jika ular ke bawah
	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	//Getter & Setter jika ular ke kiri
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	//Getter & Setter jika ular ke atas
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}
```
Function pergerakkan ke kanan, kiri, atas dan bawah hanya menyatakan kemanakah ular tersebut akan berbelok.
Bagaimana dengan mempertahankan arah jalannya ular tersebut apabila ingin melanjutkan perjalanannya sesuai arah belokkan yang ditentukan?
Oleh karena itu, dibuatlah function movementUp(),movementDown(), movementRight(), dan movementLeft().
Dengan menggunakan looping iterasi yang memindahkan posisi kepala ular ke index selanjutnya dan memindahkan posisi snakeyLength dan snakexLength.
Contoh function akan diwakilkan oleh function movementRight():
```
public void movementRight(){
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            this.getSnakeyLength()[i + 1] = this.getSnakeyLength()[i];
        }
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            if (i == 0) {
                this.getSnakexLength()[i] = this.getSnakexLength()[i] + 6;
            } else {
                this.getSnakexLength()[i] = this.getSnakexLength()[i - 1];
            }
            if (this.getSnakexLength()[0] > 637) {
                this.getSnakexLength()[0] -= 6;
                dead();
            }
        }
    }
```
Untuk lebih jelas lagi terhadap function movement yang terdapat sebuah function baru yakni dead(), akan dijelaskan oleh potongan codingan dibawah ini :
```
public void dead() {
        this.setRight(false);
        this.setLeft(false);
        this.setUp(false);
        this.setDown(false);
        this.setDeath(true);
    }
```
Function dead berfungsi untuk menghentikan pergerakkan ular dan membuat game menjadi over karena ular menabrak dinding/ menabrak bagian tubuhnya sendiri. 
Dapat dilihat dari isi function dead(), semua di set menjadi false kecuali setDeath()
```
private boolean death;

public boolean isDeath() {
		return death;
  }

public void setDeath(boolean death) {
		this.death = death;
	}
```


* Items.java

Items.java adalah parent class dari Apple.java, GoldenApple.java dan Obstacle.java.
Di dalamnya terdapat function yang me-return koordinat kemunculan Apple.java,GoldenApple.java dan Obstacle.java
```
protected int[] ItemsxPos = { 25, 31, 37, 43, 49, 55, 61, 67, 73, 79, 85, 91, 97, 103, 109, 115, 121, 127, 133, 139,145, 151, 157, 163, 169, 175, 181, 187, 193, 199, 205, 211, 217, 223, 229, 235, 241, 247, 253, 259, 265,271, 277, 283, 289, 295, 301, 307, 313, 319, 325, 331, 337, 343, 349, 355, 361, 367, 373, 379, 385, 391,397, 403, 409, 415, 421, 427, 433, 439, 445, 451, 457, 463, 469, 475, 481, 487, 493, 499, 505, 511, 517,523, 529, 535, 541, 547, 553, 559, 565, 571, 577, 583, 589, 595, 601, 607, 613, 619, 625 };
	
protected int[] ItemsyPos = { 73, 79, 85, 91, 97, 103, 109, 115, 121, 127, 133, 139, 145, 151, 157, 163, 169, 175, 181,187, 193, 199, 205, 211, 217, 223, 229, 235, 241, 247, 253, 259, 265, 271, 277, 283, 289, 295, 301, 307,313, 319, 325, 331, 337, 343, 349, 355, 361, 367, 373, 379, 385, 391, 397, 403, 409, 415, 421, 427, 433,439, 445, 451, 457, 463, 469, 475, 481, 487, 493, 499, 505, 511, 517, 523, 529, 535, 541, 547, 553, 559,565, 571, 577, 583, 589, 595, 601, 607, 613, 619, 625, 631, 637, 643, 649, 655, 661, 667 };

```
Sediakan constructor yang akan digunakan untuk Apple.java dan GoldenApple.java :
```
public Items(int[] ItemsxPos, int[] ItemsyPos) {
		this.ItemsxPos = ItemsxPos;
		this.ItemsyPos = ItemsyPos;
}
```

Setter dan Getter untuk mengambil koordinat ItemsxPos dan ItemsyPos :
```
	public int[] getItemsxPos() {
		return ItemsxPos;
	}
	
	public void setItemsxPos(int[] itemsxPos) {
		ItemsxPos = itemsxPos;
	}

	public int[] getItemsyPos() {
		return ItemsyPos;
	}
	
	public void setItemsyPos(int[] itemsyPos) {
		ItemsyPos = itemsyPos;
	}
```

* Apple.java

Apple.java adalah class yang berisi fungsi yang berhubungan dengan menginisiasi apple. dengan function super() untuk mengambil constructor dari parent class Apple.java yaitu, Items.java 
```
	public Apple() {
		super();
		this.score = new Score();
	}

```

Untuk setiap kali ular memakan apel, skor akan bertambah sebanyak 1 poin :
```
@Override
	public int increaseScore() {
		score.increaseScore(1);
		return score.getScore();
	}
```

* GoldenApple.java

GoldenApple.java adalah class berisi fungsi yang memanggil apple khusus dengan pertambahan skor 5, dan muncul jika apel biasa sudah muncul sebanyak 6 kali.
Function yang di dalam GoldenApple.java mirip dengan function di dalam Apple.java, hanya saja terdapat perbedaan di penambahan skornya.

```
public GoldenApple() {
		super();
		this.score = new Score();
	}
	
	@Override
	public int increaseScore() {
		score.increaseScore(5);
		return score.getScore();
	}
```

* Board.java

Board.java adalah class yang digunakan untuk membuat board yang akan dipakai sebagai arena game dan seluruh class akan ditampilkan disini.

Inisasi objek snake,apple, goldenapple, obstacle dan score :
```	
	Snake snake = new Snake();
	Apple apple = new Apple();
	GoldenApple goldenapple = new GoldenApple();
	Obstacle obstacle = new Obstacle();
	Score score = new Score();

```
Pada game Snake ini, terdapat 2 level yang level easy dan level hard, serta terdapat timer sesuai dengan levelnya sehingga diperlukannya array yang berisi level gameplay :
```
private String[] options = new String[] { "Easy", "Hard" };

private Timer timer;
private final int delayeasy = 200;
private final int delayhard = 100;
```
Kita juga membutuhkan panjang dan lebar dari area permainan sehingga memerlukan variabel yang bisa menampung nilai panjang dan lebar dari game area :
```
private final int gameAreaXoffset = 619;
private final int gameAreaYoffset = 613;

```
Berikut ini adalah beberapa variabel yang akan digunakan dalam function di class Board.java
```
	private int counter = 1;
	
	private int totalScore = 0;
	private int totalScore1 = 0;

	private int choice = 5;

	private ImageIcon snakeHead;
	private ImageIcon snakeBody;

	private int snakeHeadXPos = 379;
	private int snakeHeadYPos = 379;
	
	private String highScore;

```

Untuk variabel counter, digunakan untuk menghitung berapa kali apel biasa muncul, untuk choice, terdapat pilihan 0 untuk easy, dan 1 untuk hard, inisiasi awalnya adalah 5, yang nantinya akan diubah sesuai dengan pilihan level. 
SnakeHead dan SnakeBody digunakan untuk menginisiasi kepala ular yang menjadi leadnya dan badan ular yang dapat memanjang seiring dengan berapa banyak apel dan golden apel yang dimakan.
snakeHeadXPos dan snakeHeadYPos menunjukkan nilai koordinat letak kepala ular. 
variabel highScore akan digunakan untuk menyimpan nilai skor tertinggi.

Deklarasi variable untuk gambar apel, golden apel dan obstacle mirip dengan deklarasi variable snakeHead dan snakeBody.
```
	private ImageIcon appleImage;
	private ImageIcon goldenappleImage;
	private ImageIcon obstacleImage;
```

Random number akan sangat digunakan dalam merandom array, obstacle dan masih banyak lagi, agar respawn dari setiap objek tidak selalu sama.
```
	private Random random = new Random();

	private final int jumlahArray = 99;
	private int xPos = random.nextInt(jumlahArray);
	private int yPos = random.nextInt(jumlahArray);
	
	private final int jumlahObstacle = 75;
	private int randomObsX[] = new int[jumlahObstacle];
	private int randomObsY[] = new int[jumlahObstacle];

```
Diperlukan constructor yang nantinya akan digunakan di MainApp.java
```
public Board() {
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);

	for (int i = 0; i < jumlahObstacle; i++) {
		randomObsX[i] = obstacle.randomObstacleX(obstacle.ItemsxPos);
		randomObsY[i] = obstacle.randomObstacleY(obstacle.ItemsyPos);
		}

	}

```
Berikut adalah tampilan dari board yang akan di display jika menjalankan MainApp.java, semua akan tersimpan dalam function paint(Graphics g) :
```
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
```

Potongan codingan diatas akan menampilkan warna dan penempatan tulisan dari game area, selanjutnya untuk menampilkan skor dan highskor akan berada di sebelah kanan game area.
Codingan dibawah masih berada di dalam function paint(Graphics g)
```

		int AllScore = totalScore + totalScore1;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.drawString("SCORE : " + AllScore, 720, 110);
		g.drawRect(653, 130, 221, 1);
		score.setScore(AllScore);


		score.sortHighScore();
		highScore = score.getHighScore();
		g.drawString("HIGHSCORE", 705, 180);
		drawString(g, highScore, 705, 200);
```
User akan mulai memainkan game apabila menekan tombol spacebar. Jika tidak menekan, maka item-item tidak akan muncul
```
if (snake.getMoves() == 0) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", Font.BOLD, 26));
		g.drawString("Press Spacebar to Start the Game!", 70, 300);
		g.drawString("Press C to See Credits", 70, 350);
}
```
Untuk memunculkan gambar kepala ular, dapat dilihat pada potongan coding berikut :
```
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
```
Selain untuk memunculkan gambar kepala ular, kita juga perlu memunculkan kepala objek lainnya seperti apel, golden apel dan obstacle
```
	appleImage = new ImageIcon("images/Apple.png");
	goldenappleImage = new ImageIcon("images/GoldenApple.png");
	obstacleImage = new ImageIcon("images/Obstacle.png");
```

Setelah user menekan tombol space, akan muncul kotak pesan yang memilih level easy atau hard. Jika user telah memilih salah satu dari pilihan tersebut item-tem tersebut akan muncul di board
```
if (snake.getMoves() != 0) {

	appleImage.paintIcon(this, g, apple.ItemsxPos[xPos],apple.ItemsyPos[yPos]);

			
	if (counter % 6 == 0) {
		goldenappleImage.paintIcon(this, 							g,goldenapple.ItemsxPos[xPos],goldenapple.ItemsyPos[yPos]);
	}

	if (choice == 1) {
		for (int i = 0; i < jumlahObstacle; i++) {
		obstacleImage.paintIcon(this, g, randomObsX[i], randomObsY[i]);
			}
		}
}
```

Jika sudah memunculkan item-itemnya, maka objektif ular tersebut akan memakan apelnya. Apabila apel yang dimakan sudah 6, maka golden apel akan muncul.
```

if ((apple.ItemsxPos[xPos] == snake.getSnakexLength()[0]) && (apple.ItemsyPos[yPos] == snake.getSnakeyLength()[0]) && !(counter % 6 == 0)) {
			snake.setLengthOfSnake(snake.getLengthOfSnake() + 1);
			xPos = random.nextInt(jumlahArray);
			yPos = random.nextInt(jumlahArray);
			totalScore =+ apple.increaseScore();
			counter++; // untuk menghitung jumlah apple yang telah di makan
	}


if ((goldenapple.ItemsxPos[xPos] == snake.getSnakexLength()[0])&&(goldenapple.ItemsyPos[yPos] == snake.getSnakeyLength()[0]) && (counter % 6 == 0)) {

			snake.setLengthOfSnake(snake.getLengthOfSnake() + 3);
			xPos = random.nextInt(jumlahArray);
			yPos = random.nextInt(jumlahArray);
			totalScore1 =+ goldenapple.increaseScore();
			counter = 1;
	}
```

Ular yang menabrak badannya sendiri atau menabrak obstacle akan mati dan langsung gameover
```

if (choice == 1) {
	for (int i = 0; i < jumlahObstacle; i++) {
				
	if (randomObsX[i] == snake.getSnakexLength()[0] && randomObsY[i] == snake.getSnakeyLength()[0]) {
			snake.dead();
			}
		}
}


for (int i = 1; i < snake.getLengthOfSnake(); i++) {
	if (snake.getSnakexLength()[i] == snake.getSnakexLength()[0] && snake.getSnakeyLength()[i] == snake.getSnakeyLength()[0]) {
			snake.dead();
		}
}
```
Pesan GameOver akan muncul menggunakan function berikut, dan function paint(Graphics g) berakhir di sini
```		
if (snake.isDeath()) {
	score.saveNewScore();

	g.setColor(Color.RED);
	g.setFont(new Font("Courier New", Font.BOLD, 50));
	g.drawString("Game Over!", 190, 340);


	g.setColor(Color.GREEN);
	g.setFont(new Font("Courier New", Font.BOLD, 18));
	g.drawString("Your Score : " + AllScore, 250, 370);

	g.setColor(Color.WHITE);
	g.setFont(new Font("Courier New", Font.BOLD, 20));
	g.drawString("Press R to go to main menu!", 187, 400);

	}
g.dispose();

```
Untuk menampilkan string dengan \n di dalamnya dapat menggunakan function :
```
public void drawString(Graphics g, String text, int x, int y) {
	for (String line : text.split("\n"))
		g.drawString(line, x, y += g.getFontMetrics().getHeight());
}
```

Untuk mengatur pergerakkan ular di dalam class Board.java ada di function 
```
	@Override
	public void actionPerformed(ActionEvent e) {

		timer.start();

		if (snake.isRight()) {
			snake.movementRight();
			repaint();
		}

		if (snake.isLeft()) {
			snake.movementLeft();
			repaint();
		}

		if (snake.isUp()) {
			snake.movementUp();
			repaint();
		}

		if (snake.isDown()) {
			snake.movementDown();
			repaint();
		}
	}
```
Untuk pengaturan pergerakkan ular dapat menggunakan keyboard dengan menekan tombol panah kiri, kanan, atas dan bawah. Berikut adalah functionnya :
```
@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		
		switch (e.getKeyCode()) {

		
		case KeyEvent.VK_SPACE:

			
			choice = JOptionPane.showOptionDialog(null, "Pilih level", "Level", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (snake.getMoves() == 0) {
				snake.setMoves(snake.getMoves() + 1);
				snake.setRight(true);
			
				if (choice == 0) {
					timer = new Timer(delayeasy, this);
					timer.start();
				}
			
				else if (choice == 1) {
					timer = new Timer(delayhard, this);
					timer.start();
				}


				
			} else if (choice == JOptionPane.CLOSED_OPTION) {

			}

		case KeyEvent.VK_RIGHT:
			snake.moveRight();
			break;

		case KeyEvent.VK_LEFT:
			snake.moveLeft();
			break;

		// jika user tekan arrow up
		case KeyEvent.VK_UP:
			snake.moveUp();
			break;

		case KeyEvent.VK_DOWN:
			snake.moveDown();
			break;

		case KeyEvent.VK_C:
			JOptionPane.showMessageDialog(null,
					"Muhammad Daffa 05111940000175\nNur Ahmad Khatim 05111940000074\nEvelyn Sierra 05111940000111");

			break;

		case KeyEvent.VK_R:
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
```
keyReleased dan keyTyped dibiarkan kosong karena tidak akan digunakan dalam permainan Snake Game ini.


* Obstacle.java

Obstacle.java akan memanggil parent constructor dari class Items.java, dan fungsi dari class Obstacle.java ini akan seperti penghalang pada game Snake ini dengan koordinat yang tetap. Apabila pemain memilih level hard, maka obstacle akan diletakkan secara random.
```
public Obstacle() {
	super();
}
    

public int randomObstacleX(int[] obstaclexPos) {
	int random = new Random().nextInt(obstaclexPos.length);
	return obstaclexPos[random];
	}
	

public int randomObstacleY(int[] obstacleyPos) {
	int random = new Random().nextInt(obstacleyPos.length);
	return obstacleyPos[random];
}
```


* Score.java

Score.java adalah class yang berfungsi untuk mengambil dan menyimpan skor pemain,menampilkan skor dan berfungsi untuk memunculkan highscore apabila skor terbaru pemain mengalahkan skor sebelumnya serta mengurutkannya. 

Berikut adalah function getter dan setternya :
```
public int getScore() {
	return this.score;
}
	
public void setScore(int score) {
	this.score = score;
}
```
Untuk penambahan skor dan me-reset skor dapat dilihat dari function increaseScore dan resetScore :
```
public void increaseScore(int increment) {
	this.score += increment;
}

public void resetScore() {
	this.score = 0;
}

```
Untuk menulis skor baru di file :
```
	public void saveNewScore() {
		String newScore = String.valueOf(this.getScore());

		File scoreFile = new File("highscore.dat");
		if (!scoreFile.exists()) {
			try {
				scoreFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter writeFile = null;
		BufferedWriter writer = null;

		try {
			writeFile = new FileWriter(scoreFile, true);
			writer = new BufferedWriter(writeFile);
			writer.write(newScore);
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				return;
			}
		}

	}

```
Setelah mendapatkan skor tertinggi, maka skor tersebut akan diurutkan :
```
public void sortHighScore() {
		FileReader readFile = null;
		BufferedReader reader = null;
		FileWriter writeFile = null;
		BufferedWriter writer = null;
		List<Integer> list = new ArrayList<Integer>();
		try {
			readFile = new FileReader("highscore.dat");
			reader = new BufferedReader(readFile);

			String line = reader.readLine();

			while (line != null) {
				list.add(Integer.parseInt(line));
				line = reader.readLine();
			}

			Collections.sort(list);

			Collections.reverse(list);

			writeFile = new FileWriter("highscore.dat");
			writer = new BufferedWriter(writeFile);

			int size = list.size();

			for (int i = 0; i < 15; i++) {

				if (i > size - 1) {
					String def = "0";
					writer.write(def);
				} else {
					String str = String.valueOf(list.get(i));
					writer.write(str);
				}
				if (i < 14) {
					writer.newLine();
				}
			}
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			}
			catch (IOException e) {
				return;
			}
		}

	}
```



## Diagram kelas umum
![](https://github.com/daffainfo/Kelompok-PBO-F/blob/master/Final%20Project/FP-kelompok-snakegame.png)

## Referensi Aplikasi
* [ZetCode](http://zetcode.com/javagames/snake/)
* [SnakeGame](https://github.com/bagasadif/Final-Project-OOP)

## Link Youtube
* [Video Presentasi](https://youtu.be/ifPgx8E-_iM/)
