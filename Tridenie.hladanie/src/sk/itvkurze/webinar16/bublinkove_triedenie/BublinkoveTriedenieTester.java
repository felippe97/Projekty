package sk.itvkurze.webinar16.bublinkove_triedenie;

import java.util.Arrays;

public class BublinkoveTriedenieTester {

	public static void main(String[] args) {
		
		int[] data = PoleUtil.vygenerujPoleCisel(20, 100);	
		
		System.out.println("Nezotriedene data: " + Arrays.toString(data));
		
		TriedicBublinkovymAlgoritmom triedic = new TriedicBublinkovymAlgoritmom(data);
		triedic.zotried();
		
		System.out.println("Nezotriedene data: " + Arrays.toString(data));
	}
}
