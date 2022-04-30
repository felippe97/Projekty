

public class ZretazenyZoznamTester {

	public static void main(String[] args) {
		ZretazenyZoznam studenti = new ZretazenyZoznam();
		
		// pridaj prvky na zaciatok zretazeneho zoznamu (Peter, Igor, Marek, Vojto)
		studenti.pridajNaZaciatok("Peter");		// Peter
		studenti.pridajNaZaciatok("Igor");		// Igor Peter
		studenti.pridajNaZaciatok("Marek");		// Marek Igor Peter
		studenti.pridajNaZaciatok("Vojto");		// Vojto Marek Igor Peter
		
		vypisZoznam(studenti);
		System.out.println("Ocakavana hodnota: Vojto Marek Igor Peter");
		
		
		vypisZoznam(studenti);
		System.out.println("Ocakavana hodnota: ");
	}

	private static void vypisZoznam(ZretazenyZoznam studenti) {
		ZoznamIterator iterator = studenti.iteratorZoznam();
		
		while(iterator.existujeDalsiPrvok())
		{
			String student = (String) iterator.dalsi();
			System.out.print(student + " ");
		}
		System.out.println();
	}
}