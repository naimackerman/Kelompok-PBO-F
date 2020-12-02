package id.ac.its.daffa175;

import javax.swing.JOptionPane;

public class MainApp {
	public static void main(String[] args) {
		String inputStr = JOptionPane.showInputDialog("1. Persegi\n2. Trapesium");
		int i = Integer.parseInt(inputStr);
  
		if(i == 1) {
			String sisi = JOptionPane.showInputDialog("Masukkan panjang sisi persegi: ");
			int sisiPersegi = Integer.parseInt(sisi);
   
			Persegi(sisiPersegi);
		}
  
		if(i == 2) {
			String sisi_a = JOptionPane.showInputDialog("Masukkan panjang sisi trapesium atas: ");
			double sisiTrapesiumA = Integer.parseInt(sisi_a);
			
			String sisi_b = JOptionPane.showInputDialog("Masukkan panjang sisi trapesium bawah: ");
			double sisiTrapesiumB = Integer.parseInt(sisi_b);
			
			String sisi_c = JOptionPane.showInputDialog("Masukkan panjang sisi trapesium samping kanan: ");
			double sisiTrapesiumC = Integer.parseInt(sisi_c);
			
			String sisi_d = JOptionPane.showInputDialog("Masukkan panjang sisi trapesium samping kiri: ");
			double sisiTrapesiumD = Integer.parseInt(sisi_d);
			
			String tinggi = JOptionPane.showInputDialog("Masukkan panjang tinggi trapesium: ");
			double tinggiTrapesium = Integer.parseInt(tinggi);
   
			Trapesium(sisiTrapesiumA, sisiTrapesiumB, sisiTrapesiumC, sisiTrapesiumD, tinggiTrapesium);
		}
	}
 
	public static void Persegi(int sisi) {
		int areaPersegi = sisi * sisi;
		int kelilingPersegi = 4 * sisi;
		
		JOptionPane.showMessageDialog(null, "Luas persegi adalah : "+ areaPersegi);
		JOptionPane.showMessageDialog(null, "Keliling persegi adalah : "+ kelilingPersegi);
	}
 
	public static void Trapesium(double sisi_a, double sisi_b, double sisi_c, double sisi_d, double tinggi) {
		double areaTrapesium = ((sisi_a + sisi_b) * tinggi) / 2;
		double kelilingTrapesium = sisi_a + sisi_b + sisi_c + sisi_d;
		
		JOptionPane.showMessageDialog(null, "Luas trapesium adalah : "+ areaTrapesium);
		JOptionPane.showMessageDialog(null, "Keliling trapesium adalah : "+ kelilingTrapesium);
	}
}