package Faktorial;

import java.util.Scanner;

public class FaktorGeneratorTester {

	public static void main(String[] args) {
		Scanner vstup = new Scanner(System.in);
		System.out.println("Zadaj cislo");
		int cislo = vstup.nextInt();
		FaktorGenerator faktor = new FaktorGenerator(cislo);
		System.out.println(faktor.dalsiFaktor());
		System.out.println(faktor.existujeDalsiFaktor());
	}

}
