package Bankomat;

public class Bankomat {
	private int stav;
	private int klientskeCislo;
	private Klient aktualnyKlient;
	private BankovyUcet aktualnyUcet;
	private Banka banka;

	public static final int START = 1;
	public static final int PIN = 2;
	public static final int UCET = 3;
	public static final int TRANSAKCIA = 4;

	public static final int BEZNY = 1;
	public static final int SPORIACI = 2;

 Bankomat(Banka banka) {
		this.banka = banka;
		reset();
	}

	
	public void reset() {
		klientskeCislo = -1;
		aktualnyKlient = null;
		stav = START;
	}

	
	public void nastavKlientskeCislo(int cislo) {
		assert stav == START;
		this.klientskeCislo = cislo;
		stav = PIN;
	}

	
	public void nastavKlienta(int pin) {
		assert stav == PIN;
		this.aktualnyKlient = banka.vyhladajKlienta(klientskeCislo, pin);
		if (aktualnyKlient == null) {
			stav = START;
		} else {
			stav = UCET;
		}
	}

	
	public void nastavTypUctu(int ucet) {
		assert stav == UCET || stav == TRANSAKCIA;
		if (ucet == BEZNY) {
			this.aktualnyUcet = aktualnyKlient.getBeznyUcet();
		} else {
			this.aktualnyUcet = aktualnyKlient.getSporiaciUcet();
		}
		stav = TRANSAKCIA;
	}

	
	public void vyber(double ciastka) {
		assert stav == TRANSAKCIA;

		this.aktualnyUcet.vyber(ciastka);
	}

	
	public void vloz(double ciastka) {
		assert stav == TRANSAKCIA;

		this.aktualnyUcet.vloz(ciastka);
	}

	
	public double getAktualnyZostatok() {
		assert stav == TRANSAKCIA;
		return this.aktualnyUcet.getAktualnyZostatok();
	}

	
	public void nastavPredchadzajuciStav() {
		if (stav == TRANSAKCIA) {
			stav = UCET;
		} else if (stav == UCET) {
			stav = PIN;
		} else if (stav == PIN) {
			stav = START;
		}
	}


	public int getStav() {
		return this.stav;
	}
}
