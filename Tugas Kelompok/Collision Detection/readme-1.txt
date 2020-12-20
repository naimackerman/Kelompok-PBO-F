Sprite.java adalah class untuk menyimpan pergerakan sprites (spaceship, alien dan missile) dan terdapat function 
public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
}
untuk mengambil kotak icon supaya bisa menentukan apakah tabrakan atau tidak.
Spaceship.java adalah class untuk merepresentasikan spaceship yang didalamnya terdapat function untuk meng-initiate spaceship, menyimpan pergerakan spaceshipnya, list untuk menyimpan penembakan missile yaitu :
private List<Missile> missiles;
public void fire() {
    missiles.add(new Missile(x + width, y + height / 2));
}