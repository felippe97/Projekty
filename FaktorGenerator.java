package Faktorial;


public class FaktorGenerator {
	private int cislo;


	public FaktorGenerator(int cislo) {
		
		this.cislo = cislo;
	}

	public int dalsiFaktor() {
		for (int i = 2; i < cislo; i++)
			while (cislo % i == 0) {
				System.out.println(i + "");
				cislo = cislo / i;

			}
		return cislo;

		
	}

	
	public boolean existujeDalsiFaktor() {
		if (cislo < 0) {
			return false;
		}
		return true;
	
	}

}