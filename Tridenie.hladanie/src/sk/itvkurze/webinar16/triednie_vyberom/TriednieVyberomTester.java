package sk.itvkurze.webinar16.triednie_vyberom;

import java.util.Arrays;

public class TriednieVyberomTester {

	public static void main(String[] args) {
		// generujeme 20 nahdonych cisel z intervalu 1 do 100
		int[] data = PoleUtil.vygenerujPoleCisel(200, 1000);

		System.out.println("Nezotriedene data: " + Arrays.toString(data));

		TriedicVyberom triedic = new TriedicVyberom(data);
		triedic.zotried();

		System.out.println("Nezotriedene data: " + Arrays.toString(data));
	}
}
