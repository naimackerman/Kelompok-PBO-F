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

GoldenApple.java adalah class berisi fungsi yang memanggil apple khusus dengan pertambahan skor 5, dan muncul jika apel biasa sudah muncul sebanyak 5 kali.
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

Inisasi objek snake,apple, goldenapple dan obstacle :
```	
	Snake snake = new Snake();
	Apple apple = new Apple();
	GoldenApple goldenapple = new GoldenApple();
	Obstacle obstacle = new Obstacle();

```


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
