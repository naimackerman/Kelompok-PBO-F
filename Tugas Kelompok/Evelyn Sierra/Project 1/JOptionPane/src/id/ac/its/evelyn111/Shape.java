package id.ac.its.evelyn111;
import javax.swing.JOptionPane;

public class Shape {
	public static void main(String[] args)
	{
		String inputStr = JOptionPane.showInputDialog("1. Triangle\n2. Circle");
		int i = Integer.parseInt(inputStr);
		
		if(i == 1)
		{
			String a = JOptionPane.showInputDialog("Masukkan alas segitiga: ");
			int sisi_a = Integer.parseInt(a);
			
			String b = JOptionPane.showInputDialog("Masukkan tinggi segitiga: ");
			int tinggi = Integer.parseInt(b);
			
			String c = JOptionPane.showInputDialog("Masukkan sisi b segitiga: ");
			int sisi_c = Integer.parseInt(c);
			
			String d = JOptionPane.showInputDialog("Masukkan sisi c segitiga: ");
			int sisi_d= Integer.parseInt(d);
			
			areaTriangle(sisi_a, tinggi);
			kelilingsegitiga(sisi_a, sisi_c, sisi_d);
		}
		
		if(i == 2)
		{
			String radius = JOptionPane.showInputDialog("Masukkan radius lingkaran : ");
			double radius_lingkaran = Integer.parseInt(radius);
			
			areaCircle(radius_lingkaran);
			kelilinglingkaran(radius_lingkaran);
		}
		
	}
	
	public static void areaTriangle(int a,int b)
	{
		int areat = (a * b) / 2;
		JOptionPane.showMessageDialog(null, "The area of a triangle is : "+areat);
	}
	
	public static void kelilingsegitiga(int a, int b, int c)
	{
		int kelilingt = a + b + c;
		JOptionPane.showMessageDialog(null, "The circumference of a triangle is : "+kelilingt);
	}
	
	public static void areaCircle(double radius)
	{
		double hitung = 3.14 * radius * radius;
		JOptionPane.showMessageDialog(null, "The area of a Circle is : "+hitung);
	}
	
	public static void kelilinglingkaran(double radius)
	{
		double hitung = 2 * 3.14 * radius;
		JOptionPane.showMessageDialog(null, "The circumference of a Circle is : "+hitung);
	}
}
