package id.ac.its.finalproject.snake;


public class Snake {
	//letak ular
	
	int[] snakexLength = new int[750];
	int[] snakeyLength = new int[750];
	
	int lengthOfSnake;
	int moves;
	
	boolean left,right,up,down;
	
	boolean dead;
	
	public Snake()
	{
		this.left=false;
		this.right=false;
		this.up=false;
		this.down=false;
		this.dead=false;
		this.lengthOfSnake=5;
		this.moves=0;
	}
	
	//untuk pergerakkannya
	public void moveRight()
	{
		if(this.moves != 0 && !this.dead)
		{
			this.moves++;
			if(!this.left) //jika gerak ke kanan
			{
				this.right = true;
			}
			
			else //jika gerak ke kiri
			{
				this.right = false;
				this.left = true;
			}
			
			this.up = false;
			this.down = false;
		}
	}
	
	public void moveLeft()
	{
		if(this.moves != 0 && !this.dead)
		{
			this.moves++;
			if(!this.right) //jika gerak ke kanan
			{
				this.left = true;
			}
			
			else //jika gerak ke kiri
			{
				this.right = true;
				this.left = false;
			}
			
			this.up = false;
			this.down = false;
		}
	}
	
	public void moveUp()
	{
		if(this.moves != 0 && !this.dead)
		{
			this.moves++;
			if(!this.down) //jika gerak ke kanan
			{
				this.up = true;
			}
			
			else //jika gerak ke kiri
			{
				this.up = false;
				this.down = true;
			}
			
			this.left = false;
			this.right = false;
		}
	}
	
	public void moveDown()
	{
		if(this.moves != 0 && !this.dead)
		{
			this.moves++;
			if(!this.up) //jika gerak ke kanan
			{
				this.down = true;
			}
			
			else //jika gerak ke kiri
			{
				this.down = false;
				this.up = true;
			}
			
			this.left = false;
			this.right = false;
		}
	}
	
	//jika ular tersebut mati
	
	public void death()
	{
		//maka ular tersebut tidak bergerak
		this.right = false;
		this.left = false;
		this.up = false;
		this.down = false;
		this.dead = true;
	}
	
	//pergerakan ular ke kanan
	    public void movementRight(){
		// pindahkan posisi head ke index selanjutnya
		for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
		    // pindahkan posisi snakeyLength
		    this.snakeyLength[i + 1] = this.snakeyLength[i];
		}
		for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
		    // pindahkan posisi snakexLength
		    if (i == 0) {
			this.snakexLength[i] = this.snakexLength[i] + 6;
		    } else {
			this.snakexLength[i] = this.snakexLength[i - 1];
		    }
		    // jika sudah lewat ujung kanan
		    if (this.snakexLength[0] > 637) {
			// pindahkan kepala kembali ke dalam board
			this.snakexLength[0] -= 6;
			// maot
			death();
		    }
		}
	    }

	    //pergerakan ular ke kiri
	    public void movementLeft(){
		// pindahkan posisi head ke index selanjutnya
		for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
		    // pindahkan posisi snakeyLength
		    this.snakeyLength[i + 1] = this.snakeyLength[i];
		}
		for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
		    // pindahkan posisi snakexLength
		    if (i == 0) {
			this.snakexLength[i] = this.snakexLength[i] - 6;
		    } else {
			this.snakexLength[i] = this.snakexLength[i - 1];
		    }
		    // jika sudah lewat ujung kiri
		    if (this.snakexLength[0] < 25) {
			// pindahkan kepala kembali ke dalam board
			this.snakexLength[0] += 6;
			// maot
			death();
		    }
		}
	    }

	
	//naik ke atas
	public void movementUp()
	{
		//pindah posisi head ke index berikut
		
		for(int i = this.lengthOfSnake - 1; i >= 0; i--)
		{
			this.snakexLength[i + 1] = this.snakexLength[i];
		}
		
		for(int i = this.lengthOfSnake - 1; i >= 0; i--)
		{
			if(i == 0)
			{
				this.snakeyLength[i] = this.snakeyLength[i] - 6;
			}
			else
			{
				this.snakeyLength[i] = this.snakeyLength[i -1];
			}
			
			//jika lewat maka mati
			if(this.snakeyLength[0] < 73)
			{
				this.snakeyLength[0] += 6;
				
				death();
			}
		}
		
	}
	
	//turun ke bawah
	public void movementDown()
	{
        // pindah posisi head ke index berikut
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            
            this.snakexLength[i + 1] = this.snakexLength[i];
        }
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
           
            if (i == 0) {
                this.snakeyLength[i] = this.snakeyLength[i] + 6;
            } else {
                this.snakeyLength[i] = this.snakeyLength[i - 1];
            }
           //jika lewat maka mati
            if (this.snakeyLength[0] > 679) {
                
                this.snakeyLength[0] -= 6;
                
                death();
            }
        }
    }
	
}
