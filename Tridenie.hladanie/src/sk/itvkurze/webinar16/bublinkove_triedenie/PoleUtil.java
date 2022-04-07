package sk.itvkurze.webinar16.bublinkove_triedenie;

import java.util.Random;

public class PoleUtil {
	
	private static Random generator = new Random();

	
	public static int[] vygenerujPoleCisel(int dlzka, int hornaHranica)
	{
		int[] pole = new int[dlzka];
		
		for (int i = 0; i < pole.length; i++) {
			pole[i] = generator.nextInt(hornaHranica) + 1;
		}
		
		return pole;
	}
}
