package BinarneHladanie;

public class BinarnyVyhladavac {
	private int[] cisla;

	public BinarnyVyhladavac(int[] cisla) {
		this.cisla = cisla;
	}

	public int vyhladaj(int hladane) {
		for (int i = 0; i < cisla.length; i++) {
			if (cisla[i] == hladane)return i;
			}
			return vyhladajBinarne(hladane);	
	}
private int vyhladajBinarne(int hodnota) {
		
		int indexOd = 0;
		int indexDo = cisla.length -1;
		
		while(indexOd <= indexDo)
		{
			int stred = (indexOd + indexDo) /2 ;
	
			int rozdiel = cisla[stred] - hodnota;
			
			if (rozdiel== 0)return stred ;
			if (rozdiel < 0)
			{
				indexOd = stred +1;
			}
			if(rozdiel > 0)
			{
				indexDo = stred -1;
			}
			
			
		}
		System.out.println(indexOd);
		
		
		return -(indexOd + 1);
	}
}