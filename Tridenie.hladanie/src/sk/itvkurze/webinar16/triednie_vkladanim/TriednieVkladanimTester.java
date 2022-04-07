package sk.itvkurze.webinar16.triednie_vkladanim;

import java.util.Arrays;

public class TriednieVkladanimTester {

	public static void main(String[] args) {
		// generujeme 20 nahdonych cisel z intervalu 1 do 100
		int[] data = PoleUtil.vygenerujPoleCisel(20, 100);	
		
		System.out.println("Nezotriedene data: " + Arrays.toString(data));
		
		TriedicVkladanim triedic = new TriedicVkladanim(data);
		triedic.zotried();
		
		System.out.println("Nezotriedene data: " + Arrays.toString(data));
	}
}
