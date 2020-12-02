package id.ac.its.nurahmadkhatim074;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		String inputStr = JOptionPane.showInputDialog("1. Jajar genjang\n2. Layang-layang");
		int i = Integer.parseInt(inputStr);
		
		if (i == 1) {
			String sisi_a = JOptionPane.showInputDialog("Masukkan alas jajar genjang: ");
			double alasJajargenjang = Integer.parseInt(sisi_a);
			
			String sisi_b = JOptionPane.showInputDialog("Masukkan sisi miring jajar genjang: ");
			double sisiMiringJajargenjang = Integer.parseInt(sisi_b);
			
			String tinggi = JOptionPane.showInputDialog("Masukkan tinggi jajar genjang: ");
			double tinggiJajargenjang = Integer.parseInt(tinggi);
			
			Jajargenjang(alasJajargenjang, sisiMiringJajargenjang, tinggiJajargenjang);
		}
		
		if (i == 2) {
			String sisi_a = JOptionPane.showInputDialog("Masukkan sisi pendek layang-layang: ");
			double sisiPendekLayanglayang = Integer.parseInt(sisi_a);
			
			String sisi_b = JOptionPane.showInputDialog("Masukkan sisi panjang layang-layang: ");
			double sisiPanjangLayanglayang = Integer.parseInt(sisi_b);
			
			String diagonal_a = JOptionPane.showInputDialog("Masukkan diagonal pendek layang-layang: ");
			double diagonalPendekLayanglayang = Integer.parseInt(diagonal_a);
			
			String diagonal_b = JOptionPane.showInputDialog("Masukkan diagonal panjang layang-layang: ");
			double diagonalPanjangLayanglayang = Integer.parseInt(diagonal_b);
			
			Layanglayang(sisiPendekLayanglayang, sisiPanjangLayanglayang, diagonalPendekLayanglayang, diagonalPanjangLayanglayang);
		}
	}
		
	public static void Jajargenjang(double sisi_a, double sisi_b, double tinggi) {
		double areaJajargenjang = sisi_a * tinggi;
		double kelilingJajargenjang = 2 * (sisi_a + sisi_b);
		
		JOptionPane.showMessageDialog(null, "Luas Jajar genjang: " + areaJajargenjang);
		JOptionPane.showMessageDialog(null, "Keliling Jajar genjang: " + kelilingJajargenjang);
	}
	
	public static void Layanglayang(double sisi_a, double sisi_b, double diagonal_a, double diagonal_b) {
		double areaLayanglayang = (diagonal_a * diagonal_b) / 2;
		double kelilingLayanglayang = 2 * (sisi_a + sisi_b);
		
		JOptionPane.showMessageDialog(null, "Luas Layang-layang: " + areaLayanglayang);
		JOptionPane.showMessageDialog(null, "Keliling Layang-layang: " + kelilingLayanglayang);
	}
}
