package SporiaciUcet;

public class SporiaciUcetTester
{
    public static void main(String[] args)
    {
        SporiaciUcet sporiaciUcet = new SporiaciUcet(500);
        double pripisUrok = 10;
        sporiaciUcet.pripisUrok(pripisUrok);
        sporiaciUcet.pripisUrok(pripisUrok);
        sporiaciUcet.pripisUrok(pripisUrok);
        sporiaciUcet.pripisUrok(pripisUrok);
        sporiaciUcet.pripisUrok(pripisUrok);
       
        System.out.println("Aktualny zostatok na sporiacom ucte: " + sporiaciUcet.getAktualnyZostatok());

      
        System.out.println("Ocakavany vysledok: 550 ");
    }
}