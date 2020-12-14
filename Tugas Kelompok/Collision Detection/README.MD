# Collision Detection
## Deskripsi
* Sprite.java

Sprite.java adalah class untuk menyimpan pergerakan sprites (spaceship, alien dan missile) dan terdapat function

```java
public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
}
```

untuk mengambil kotak icon supaya bisa menentukan apakah tabrakan atau tidak.

* Spaceship.java

Spaceship.java adalah class untuk merepresentasikan spaceship yang didalamnya terdapat function untuk meng-initiate spaceship, menyimpan pergerakan spaceshipnya, list untuk menyimpan penembakan missile yaitu :

```java
private List<Missile> missiles;
public void fire() {
    missiles.add(new Missile(x + width, y + height / 2));
}
```
    
* Board.java

Board class adalah class untuk menampilkan tampilan dari permainan terlihat pada function :

```java
private final int[][] pos = {
    {2380, 29}, {2500, 59}, {1380, 89},
    {780, 109}, {580, 139}, {680, 239},
    {790, 259}, {760, 50}, {790, 150},
    {980, 209}, {560, 45}, {510, 70},
    {930, 159}, {590, 80}, {530, 60},
    {940, 59}, {990, 30}, {920, 200},
    {900, 259}, {660, 50}, {540, 90},
    {810, 220}, {860, 20}, {740, 180},
    {820, 128}, {490, 170}, {700, 30}
};
```
    
Di dalam class Board juga terdapat function untuk menginisiasi posisi dari alienship. initAliens() method digunakan untuk membuat list dari alien objects.

```java
public void initAliens() {
    
    aliens = new ArrayList<>();

    for (int[] p : pos) {
        aliens.add(new Alien(p[0], p[1]));
    }
}
```

Fungsi dari paintComponent(), adalah untuk menggambar sprites atau menuliskan kata game over, tergantung dari variable di dalam game.
Fungsi dari drawObjects() adalah untuk menggambar sprites di dalam window yang ditampilkan.

```java
for (Alien alien : aliens) {
    if (alien.isVisible()) {
        g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
    }
}
```

Sebagai contoh untuk menggambar alien, kita akan menggunakan looping tersebut untuk menggambar alien apabila alien tersebut belum dihancurkan sebelumnya, yang nantinya akan dicek oleh isVisible().

```java
g.setColor(Color.WHITE);
g.drawString("Aliens left: " + aliens.size(), 5, 15);
```

Potongan codingan tersebut untuk menampilkan di pojok kiri atas dari window, berapakah alien yang tersisa

Untuk menampilkan game telah berakhir, digunakan function drawGameOver() seperti yang ditampilkan di bawah ini

```java
private void drawGameOver(Graphics g) {

    String msg = "Game Over";
    Font small = new Font("Helvetica", Font.BOLD, 14);
    FontMetrics fm = getFontMetrics(small);

    g.setColor(Color.white);
    g.setFont(small);
    g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
            B_HEIGHT / 2);
}
```

Untuk setiap aksi event akan direpresentasikan dalam 1 game. Maka diperlukan function untuk menyimpan update dari setiap pergerakan spaceship, alien dan missiles.

```java
@Override
public void actionPerformed(ActionEvent e) {

    inGame();

    updateShip();
    updateMissiles();
    updateAliens();

    checkCollisions();

    repaint();
}
```

Untuk setiap function updateShip() updateMissiles() dan updateAlien() memiliki logic yang sama. Sebagai contoh untuk updateAlien(), kita mengecek apakah ada object alien yang tersisa di list Alien? Game tersebut akan berakhir apabila list tersebut empty, jika tidak maka game akan berlanjut dan alien yang terhancurkan akan di hapus dari list.

```java
private void updateAliens() {

    if (aliens.isEmpty()) {

        ingame = false;
        return;
    }

    for (int i = 0; i < aliens.size(); i++) {

        Alien a = aliens.get(i);
        
        if (a.isVisible()) {
            a.move();
        } else {
            aliens.remove(i);
        }
    }
}  
```

Apabila spaceship tersebut bertabrakan dengan alien, maka akan dicek di function checkCollisions(), untuk mengecek batasan objek spaceship dan alien menggunakan method getBounds() dan intersect apabila batasan objek-objek tersebut bertabrakan

```java
List<Missile> ms = spaceship.getMissiles();

for (Missile m : ms) {

    Rectangle r1 = m.getBounds();

    for (Alien alien : aliens) {

        Rectangle r2 = alien.getBounds();

        if (r1.intersects(r2)) {
            
            m.setVisible(false);
            alien.setVisible(false);
        }
    }
}
```

* Alien.java
Sama seperti class spaceship, alien.java adalah class untuk menginisiasi alien dan mengatur pergerakannya.

```java
public void move() {

    if (x < 0) {
        x = INITIAL_X;
    }

    x -= 1;
}
```

untuk pergerakannya yang secara acak, apabila alien yang belum dihancurkan melewati screen sebelah kiri, maka akan lanjut di keluarkan dari layar sebelah kanan.

* Missiles.java
Untuk class Missiles, terdapat function untuk menginisiasi missile dari spaceship, dan diatur kecepatannya. Namun, perbedaan pergerakan missile dengan alien adalah, missile akan hilang apabila telah mencapai screen sebelah kanan.

```java
public void move() {
    
    x += MISSILE_SPEED;
    
    if (x > BOARD_WIDTH)
        visible = false;
}
```

* CollisionEx.java
Berfungsi untuk mengeksekusi program main. Terdapat fungsi initUI() untuk membuat frame permainan dan fungsi main untuk mengeksekusinya

```java
public class CollisionEx extends JFrame {

    public CollisionEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            CollisionEx ex = new CollisionEx();
            ex.setVisible(true);
        });
    }
}
```

## Class Diagram Image
![](https://raw.githubusercontent.com/daffainfo/Kelompok-PBO-F/master/Tugas%20Kelompok/Collision%20Detection/Collision%20Detection.jpg)

## Running Program Image
![](https://raw.githubusercontent.com/daffainfo/Kelompok-PBO-F/master/Tugas%20Kelompok/Collision%20Detection/Collision%20Detection%20Program.jpg)
