
import java.util.ArrayList;

public class GeneratorPermutacii {

	private String slovo;

	public GeneratorPermutacii(String slovo) {
		this.slovo = slovo;
	}

	/**
	 * Vracia zoznam permutacii daneho slovo.
	 * @return zoznam permutacii
	 */
	public ArrayList<String> getPermutacie() {
		ArrayList<String> vysledky = new ArrayList<String>();
		
		// prazdny retazec obsahje len jedinu permutaciu a to sam seba
		if(slovo.length() == 0)	// if(slovo.isEmpty())
		{
			vysledky.add(slovo);
			return vysledky;
		}
		
		// budeme iterovat cez vsetky pismena v slove
		for(int i = 0; i < slovo.length(); i++)
		{
			// budeme si vytvarat slovo, ktore je skratene, t.j. odstranime z neho i-ty znak
			String skrateneSlovo = slovo.substring(0, i) + slovo.substring(i + 1);
			
			// vygenerujem vsetky permutacie slova
			GeneratorPermutacii skratenyGenerator = new GeneratorPermutacii(skrateneSlovo);
			ArrayList<String> skratenePermutacie = skratenyGenerator.getPermutacie();
			
			// pridame odstraneny znak na zaciatok z kazdej permutacie v ramci skrateneho slova
			for(String s : skratenePermutacie)
			{
				vysledky.add(slovo.charAt(i) + s);
			}
		}
		
		// vratime vsetky permutacie
		return vysledky;
	}
}
