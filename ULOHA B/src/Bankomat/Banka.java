package Bankomat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Banka {
    private ArrayList<Klient> klienti;

    
    public Banka() {
	klienti = new ArrayList<>();
    }

    public void nacitajKlientov(String nazovSuboru) throws FileNotFoundException {
	Scanner vstupZoSuboru = new Scanner(new FileReader(nazovSuboru));

	while (vstupZoSuboru.hasNext()) {
	    int klientskeCislo = vstupZoSuboru.nextInt();
	    int pin = vstupZoSuboru.nextInt();
	    Klient klient = new Klient(klientskeCislo, pin);
	    pridajKlienta(klient);
	}

	vstupZoSuboru.close();
    }

 
    public void pridajKlienta(Klient klient) {
	klienti.add(klient);
    }

 
    public Klient vyhladajKlienta(int klientskeCislo, int pin) {
	for (Klient klient : klienti) {
	    if (klient.jeTotoznyS(klientskeCislo, pin)) {
		return klient;
	    }
	}
	JOptionPane.showMessageDialog(null, "Nespravne klientske cislo alebo PIN");
	return null;
    }
}
