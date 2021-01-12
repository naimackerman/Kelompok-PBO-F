package id.ac.its.finalproject.snake;

public class Snake {
    // menentukan letak ular
    private int[] snakexLength = new int[750];
    private int[] snakeyLength = new int[750];

    //panjang ular dan apakah ular sudah bergerak atau belum
    private int lengthOfSnake;
    private int moves;

    // arah ular
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    //apakah ular sudah mati atau belum
    private boolean death;

    //konstruktor
    public Snake() {
        this.setLeft(false);
        this.setRight(false);
        this.setUp(false);
        this.setDown(false);
        this.setDeath(false);
        this.setLengthOfSnake(5);
        this.setMoves(0);
    }

    //Getter & Setter untuk SnakexLength
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

	//Getter & Setter untuk pergerakan
	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	//Getter & Setter untuk mendapatkan panjang tubuh snake
	public int getLengthOfSnake() {
		return lengthOfSnake;
	}

	public void setLengthOfSnake(int lengthOfSnake) {
		this.lengthOfSnake = lengthOfSnake;
	}

	//Getter & Setter jika ular ke kanan
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

	//Getter & Setter jika ular mati
	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}
    
    //gerak ke kanan
    public void moveRight(){
        if (this.getMoves() != 0 && !this.isDeath()) {
                this.setMoves(this.getMoves() + 1);
                if (!this.isLeft()) {
                    this.setRight(true);
                } else {
                    this.setRight(false);
                    this.setLeft(true);
                }
                this.setUp(false);
                this.setDown(false);
        }
    }

    //gerak ke kiri
    public void moveLeft(){
        if (this.getMoves() != 0 && !this.isDeath()) {
            this.setMoves(this.getMoves() + 1);
            if (!this.isRight()) {
                this.setLeft(true);
            } else {
                this.setLeft(false);
                this.setRight(true);
            }
            this.setUp(false);
            this.setDown(false);
        }
    }

    //gerak ke atas
    public void moveUp(){
        if (this.getMoves() != 0 && !this.isDeath()) {
            this.setMoves(this.getMoves() + 1);
            if (!this.isDown()) {
                this.setUp(true);
            } else {
                this.setUp(false);
                this.setDown(true);
            }
            this.setLeft(false);
            this.setRight(false);
        }
    }

    //gerak ke bawah
    public void moveDown(){
        if (this.getMoves() != 0 && !this.isDeath()) {
            this.setMoves(this.getMoves() + 1);
            if (!this.isUp()) {
                this.setDown(true);
            } else {
                this.setDown(false);
                this.setUp(true);
            }
            this.setLeft(false);
            this.setRight(false);
        }
    }

    //pergerakan ular ke kanan
    public void movementRight(){
        // pindahkan posisi head ke index selanjutnya
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakeyLength
            this.getSnakeyLength()[i + 1] = this.getSnakeyLength()[i];
        }
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakexLength
            if (i == 0) {
                this.getSnakexLength()[i] = this.getSnakexLength()[i] + 6;
            } else {
                this.getSnakexLength()[i] = this.getSnakexLength()[i - 1];
            }
            // jika sudah lewat ujung kanan
            if (this.getSnakexLength()[0] > 637) {
                // pindahkan kepala kembali ke dalam board
                this.getSnakexLength()[0] -= 6;
                // maot
                dead();
            }
        }
    }

    //pergerakan ular ke kiri
    public void movementLeft(){
        // pindahkan posisi head ke index selanjutnya
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakeyLength
            this.getSnakeyLength()[i + 1] = this.getSnakeyLength()[i];
        }
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakexLength
            if (i == 0) {
                this.getSnakexLength()[i] = this.getSnakexLength()[i] - 6;
            } else {
                this.getSnakexLength()[i] = this.getSnakexLength()[i - 1];
            }
            // jika sudah lewat ujung kiri
            if (this.getSnakexLength()[0] < 25) {
                // pindahkan kepala kembali ke dalam board
                this.getSnakexLength()[0] += 6;
                // maot
                dead();
            }
        }
    }

    //pergerakan ular ke atas
    public void movementUp(){
        // pindahkan posisi head ke index selanjutnya
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakexLength
            this.getSnakexLength()[i + 1] = this.getSnakexLength()[i];
        }
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakeyLength
            if (i == 0) {
                this.getSnakeyLength()[i] = this.getSnakeyLength()[i] - 6;
            } else {
                this.getSnakeyLength()[i] = this.getSnakeyLength()[i - 1];
            }
            // jika sudah lewat ujung atas
            if (this.getSnakeyLength()[0] < 73) {
                // pindahkan kepala kembali ke dalam board
                this.getSnakeyLength()[0] += 6;
                // maot
                dead();
            }
        }
    }

    //pergerakan ular ke bawah
    public void movementDown(){
        // pindahkan posisi head ke index selanjutnya
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakexLength
            this.getSnakexLength()[i + 1] = this.getSnakexLength()[i];
        }
        for (int i = this.getLengthOfSnake() - 1; i >= 0; i--) {
            // pindahkan posisi snakeyLength
            if (i == 0) {
                this.getSnakeyLength()[i] = this.getSnakeyLength()[i] + 6;
            } else {
                this.getSnakeyLength()[i] = this.getSnakeyLength()[i - 1];
            }
            // jika sudah lewat ujung bawah
            if (this.getSnakeyLength()[0] > 679) {
                // pindahkan kepala kembali ke dalam board
                this.getSnakeyLength()[0] -= 6;
                // maot
                dead();
            }
        }
    }
    
    // fungsi mati biar ga ngulang nulis kode berkali-kali
    public void dead() {
        // membuat ular tidak bisa bergerak
        this.setRight(false);
        this.setLeft(false);
        this.setUp(false);
        this.setDown(false);
        this.setDeath(true);
    }
}