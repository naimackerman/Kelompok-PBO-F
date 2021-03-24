package id.ac.its.finalproject.snake;

public class Items {
	//Array berisi tempat items-items yang akan muncul di gameplay
	protected int[] ItemsxPos = { 25, 31, 37, 43, 49, 55, 61, 67, 73, 79, 85, 91, 97, 103, 109, 115, 121, 127, 133, 139,
			145, 151, 157, 163, 169, 175, 181, 187, 193, 199, 205, 211, 217, 223, 229, 235, 241, 247, 253, 259, 265,
			271, 277, 283, 289, 295, 301, 307, 313, 319, 325, 331, 337, 343, 349, 355, 361, 367, 373, 379, 385, 391,
			397, 403, 409, 415, 421, 427, 433, 439, 445, 451, 457, 463, 469, 475, 481, 487, 493, 499, 505, 511, 517,
			523, 529, 535, 541, 547, 553, 559, 565, 571, 577, 583, 589, 595, 601, 607, 613, 619, 625 };
	
	protected int[] ItemsyPos = { 73, 79, 85, 91, 97, 103, 109, 115, 121, 127, 133, 139, 145, 151, 157, 163, 169, 175, 181,
			187, 193, 199, 205, 211, 217, 223, 229, 235, 241, 247, 253, 259, 265, 271, 277, 283, 289, 295, 301, 307,
			313, 319, 325, 331, 337, 343, 349, 355, 361, 367, 373, 379, 385, 391, 397, 403, 409, 415, 421, 427, 433,
			439, 445, 451, 457, 463, 469, 475, 481, 487, 493, 499, 505, 511, 517, 523, 529, 535, 541, 547, 553, 559,
			565, 571, 577, 583, 589, 595, 601, 607, 613, 619, 625, 631, 637, 643, 649, 655, 661, 667 };

	protected int value;
	
	//Default Constructor
	public Items() {

	}
	
	//Constructor dengan parameter
	public Items(int[] ItemsxPos, int[] ItemsyPos) {
		this.ItemsxPos = ItemsxPos;
		this.ItemsyPos = ItemsyPos;
	}

	//Getter & Setter untuk mendapatkan value didalam array itemsxPos
	public int[] getItemsxPos() {
		return ItemsxPos;
	}
	
	public void setItemsxPos(int[] itemsxPos) {
		ItemsxPos = itemsxPos;
	}

	//Getter & Setter untuk mendapatkan value didalam array itemsyPos
	public int[] getItemsyPos() {
		return ItemsyPos;
	}
	
	public void setItemsyPos(int[] itemsyPos) {
		ItemsyPos = itemsyPos;
	}

	public int increaseScore() {
		return 0;
	}
}
