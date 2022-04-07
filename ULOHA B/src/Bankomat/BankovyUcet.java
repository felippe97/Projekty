package Bankomat;
import javax.swing.JOptionPane;

public class BankovyUcet {
    private double aktualnyZostatok;

    
    public BankovyUcet() {
	this(0);
    }

    
    public BankovyUcet(double pociatocnyZostatok) {
	this.aktualnyZostatok = pociatocnyZostatok;
    }

   
    public double getAktualnyZostatok() {
	return aktualnyZostatok;
    }

 
    public void vloz(double ciastka) {

	if (ciastka < 0)
	    JOptionPane.showMessageDialog(null, "Nepovolena tranakcia");
	else
	    this.aktualnyZostatok += ciastka;
    }

  
    public void vyber(double ciastka) {

	if (ciastka < 0 || ciastka > aktualnyZostatok)
	    JOptionPane.showMessageDialog(null, "Nepovolena tranakcia");
	else
	    this.aktualnyZostatok -= ciastka;
    }
}
