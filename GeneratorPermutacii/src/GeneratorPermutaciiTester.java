

import java.util.ArrayList;


public class GeneratorPermutaciiTester {

	public static void main(String[] args) {
		GeneratorPermutacii generator = new GeneratorPermutacii("JAVA");
		
		ArrayList<String> permutacie = generator.getPermutacie();
		
		for (String permutacia : permutacie) {
			System.out.println(permutacia);
		}
	}
}
