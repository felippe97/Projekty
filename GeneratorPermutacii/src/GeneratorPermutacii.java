
import java.util.ArrayList;

public class GeneratorPermutacii {

	private String slovo;

	public GeneratorPermutacii(String slovo) {
		this.slovo = slovo;
	}

	public ArrayList<String> getPermutacie() {
		ArrayList<String> vysledky = new ArrayList<String>();

		// prazdny retazec obsahje len jedinu permutaciu a to sam seba
		if (slovo.length() == 0) // if(slovo.isEmpty())
		{
			vysledky.add(slovo);
			return vysledky;
		}

		for (int i = 0; i < slovo.length(); i++) {

			String skrateneSlovo = slovo.substring(0, i) + slovo.substring(i + 1);

			GeneratorPermutacii skratenyGenerator = new GeneratorPermutacii(skrateneSlovo);
			ArrayList<String> skratenePermutacie = skratenyGenerator.getPermutacie();

			for (String s : skratenePermutacie) {
				vysledky.add(slovo.charAt(i) + s);
			}
		}

		return vysledky;
	}
}
