package sk.itvkurze.webinar16.triednie_vyberom;

import java.util.Random;

public class PoleUtil {
	
	private static Random generator = new Random();

	/**
	 * Vytvara pole tvorene nahodnymi cislami.
	 * @param dlzka velkost generovaneho pola cisla
	 * @param hornaHranica cisla budu generovane z intervalu <1, hornaHranica>
	 * @return pole tvorene nahodnymi cislami
	 */
	public static int[] vygenerujPoleCisel(int dlzka, int hornaHranica)
	{
		int[] pole = new int[dlzka];
		
		for (int i = 0; i < pole.length; i++) {
			pole[i] = generator.nextInt(hornaHranica) + 1;
		}
		
		return pole;
	}
}
