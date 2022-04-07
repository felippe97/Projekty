package sk.itvkurze.webinar16.stopky;

import java.util.Scanner;

public class TriedicVyberomCasovac {

	public static void main(String[] args) {
		Scanner vstup = new Scanner(System.in);
		System.out.print("Zadaj velkost dat: ");
		int velkost = vstup.nextInt();
		
	
		int[] data = PoleUtil.vygenerujPoleCisel(velkost, 5000);
		TriedicVyberom triedic = new TriedicVyberom(data);
		Stopky stopky = new Stopky();
		
		stopky.start();
		triedic.zotried();
		stopky.stop();
		
		System.out.println("Uplnynuly cas: " + stopky.getUplynulyCas() + " ms");
	}
}
