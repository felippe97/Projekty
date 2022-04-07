package SporiaciUcet;


public class SporiaciUcet
{
	private double urokovaSadzba;
	private double aktualnyZostatok;

		
		public SporiaciUcet()
		{
			aktualnyZostatok = 0;
			urokovaSadzba = 0;
		}

	
		public SporiaciUcet(double pociatocnyZostatok)
		{
			aktualnyZostatok = pociatocnyZostatok;
			double novaUrokovaSadzba = 0;
			urokovaSadzba = novaUrokovaSadzba;
		}


 
	
		public void pripisUrok(double urokovaSadzba)
		{
			
			aktualnyZostatok = aktualnyZostatok + urokovaSadzba;
	 
		}
 
		public double getAktualnyZostatok()
		{
			return aktualnyZostatok;
		}
 
}
