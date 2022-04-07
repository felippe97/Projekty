package Bankomat;
public class Klient {
    private int id;
    private int pin;
    private BankovyUcet beznyUcet;
    private BankovyUcet sporiaciUcet;

    
    public Klient(int id, int pin) {
	this.id = id;
	this.pin = pin;
	beznyUcet = new BankovyUcet();
	sporiaciUcet = new BankovyUcet();
    }

   
    public boolean jeTotoznyS(int klientskeCislo, int pin) {
	return (this.id == klientskeCislo && this.pin == pin);
    }

   
    public BankovyUcet getBeznyUcet() {
	return beznyUcet;
    }

 
    public BankovyUcet getSporiaciUcet() {
	return sporiaciUcet;
    }

}
