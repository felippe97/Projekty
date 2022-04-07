package Bankomat;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BankomatGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int SIRKA = 500;
    private static final int VYSKA = 200;
    private Bankomat bankomat;
    private JTextArea obrazovka;
    private Klavesnica klavesnica;
    private JButton tlacitkoA;
    private JButton tlacitkoB;
    private JButton tlacitkoC;
    private JPanel panelTlacitok;

  
    public BankomatGUI(Bankomat bankomat) {

		this.bankomat = bankomat;
		klavesnica = new Klavesnica();
		nastavAtributy();
		vytvorObrazovku();
		vytvorTlacitka();
		vytvorPanelTlacitok();
	
		setLayout(new FlowLayout());
	
		add(klavesnica);
		add(obrazovka);
		add(panelTlacitok);
		nastavObrazovku();

    }

  
    private void vytvorPanelTlacitok() {

	panelTlacitok = new JPanel();

	panelTlacitok.setLayout(new GridLayout(3, 1));
	panelTlacitok.add(tlacitkoA);
	panelTlacitok.add(tlacitkoB);
	panelTlacitok.add(tlacitkoC);

    }

    private void vytvorObrazovku() {

	obrazovka = new JTextArea(8, 20);
	obrazovka.setEditable(false);
	obrazovka.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    }

    
    private void vytvorTlacitka() {

	tlacitkoA = new JButton("A");

	tlacitkoA.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (bankomat.getStav() == Bankomat.START) {
		    bankomat.nastavKlientskeCislo(Integer.parseInt(klavesnica.getTextovePole().getText()));
		    klavesnica.setTextovePole("");
		    nastavObrazovku();

		} else if (bankomat.getStav() == Bankomat.PIN) {
		    bankomat.nastavKlienta(Integer.parseInt(klavesnica.getTextovePole().getText()));
		    klavesnica.setTextovePole("");
		    nastavObrazovku();

		} else if (bankomat.getStav() == Bankomat.UCET) {
		    bankomat.nastavTypUctu(Bankomat.BEZNY);
		    klavesnica.setTextovePole("");
		    nastavObrazovku();

		} else if (bankomat.getStav() == Bankomat.TRANSAKCIA) {
		    bankomat.vyber(Double.parseDouble(klavesnica.getTextovePole().getText()));
		    bankomat.nastavPredchadzajuciStav();
		    klavesnica.setTextovePole("");
		    nastavObrazovku();
		}

	    }
	});

	tlacitkoB = new JButton("B");

	tlacitkoB.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		if (bankomat.getStav() == Bankomat.UCET) {
		    bankomat.nastavTypUctu(Bankomat.SPORIACI);
		    klavesnica.setTextovePole("");
		    nastavObrazovku();

		} else if (bankomat.getStav() == Bankomat.TRANSAKCIA) {
		    bankomat.vloz(Double.parseDouble(klavesnica.getTextovePole().getText()));
		    bankomat.nastavPredchadzajuciStav();
		    klavesnica.setTextovePole("");
		    nastavObrazovku();
		}

	    }
	});

	tlacitkoC = new JButton("C");

	tlacitkoC.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		if (bankomat.getStav() == Bankomat.UCET) {
		    bankomat.reset();
		    klavesnica.setTextovePole("");
		    nastavObrazovku();
		} else if (bankomat.getStav() == Bankomat.TRANSAKCIA) {
		    bankomat.nastavPredchadzajuciStav();
		    klavesnica.setTextovePole("");
		    nastavObrazovku();
		}
	    }
	});

    }

    
    private void nastavAtributy() {

	setTitle("Bankomat");
	setSize(SIRKA, VYSKA);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }

   
    private void nastavObrazovku() {

	int stav = bankomat.getStav();
	if (stav == Bankomat.START)
	    obrazovka.setText("Zadaj klientske cislo\nA = OK");
	if (stav == Bankomat.PIN)
	    obrazovka.setText("Zadaj PIN\nA = OK");
	if (stav == Bankomat.UCET)
	    obrazovka.setText("Zvol ucet:\nA = Bezny ucet\nB = Sporiaci ucet\nC = Koniec");
	if (stav == Bankomat.TRANSAKCIA)
	    obrazovka.setText("Aktualny zostatok: " + bankomat.getAktualnyZostatok()
		    + " EUR\nZadaj ciastku a zvol operaciu:\nA = Vyber\nB = Vklad\nC = Krok spat");
    }
}
