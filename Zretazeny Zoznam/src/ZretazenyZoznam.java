

import java.util.NoSuchElementException;

public class ZretazenyZoznam {

	private Uzol prvy;	// odkaz na zaciatok zretazeneho zoznamu (na 1. uzol v zretazenom zozname)
	
	public Object getPrvy()
	{
		if(prvy == null)
		{
			throw new NoSuchElementException();
		}
		return this.prvy.getData();
	}

	public void pridajNaZaciatok(Object prvok) {
		Uzol novyUzol = new Uzol();
		novyUzol.setData(prvok);
		novyUzol.setDalsi(prvy);
		prvy = novyUzol;
	}
	
	public Object zmazZoZaciatku()
	{
		if(prvy == null)
		{
			throw new NoSuchElementException();
		}
		Object data = prvy.getData();
		prvy = prvy.dalsi;
		return data;
	}
	
	public ZoznamIterator iteratorZoznam()
	{
		return new ZretazenyZoznamIterator();
	}
	
	private class ZretazenyZoznamIterator implements ZoznamIterator
	{
		private Uzol aktualny;
		private Uzol predchadzajuci;
		
		public ZretazenyZoznamIterator()
		{
			this.aktualny = null;
			this.predchadzajuci = null;
		}
		
		@Override
		public Object dalsi() {
			if(!existujeDalsiPrvok())
			{
				throw new NoSuchElementException();
			}
			
			this.predchadzajuci = this.aktualny;
			
			if(this.aktualny == null)
			{
				this.aktualny = prvy;
			}
			else
			{
				this.aktualny = this.aktualny.dalsi;
			}
			
			return this.aktualny.data;
		}

		@Override
		public boolean existujeDalsiPrvok() {
			if(this.aktualny == null)
			{
				return prvy != null;
			}
			else
			{
				return this.aktualny.dalsi != null;
			}
		}

		@Override
		public void pridaj(Object prvok) {
			if(this.aktualny == null)
			{
				pridajNaZaciatok(prvok);
				this.aktualny = prvy;
			}
			else
			{
				Uzol uzol = new Uzol();
				uzol.setData(prvok);
				uzol.setDalsi(this.aktualny.getDalsi());
				this.aktualny.setDalsi(uzol);
				this.aktualny = uzol;
			}
			this.predchadzajuci = this.aktualny;
		}

		@Override
		public void zmaz() {
			if(this.predchadzajuci == this.aktualny)
			{
				throw new IllegalStateException();
			}
			if(this.aktualny == prvy)
			{
				zmazZoZaciatku();
			}
			else
			{
				this.predchadzajuci.setDalsi(this.aktualny.dalsi);
			}
			this.aktualny = this.predchadzajuci;
		}

		@Override
		public void nastav(Object prvok) {
			if(this.aktualny == null)
			{
				throw new NoSuchElementException();
			}
			
			this.aktualny.setData(prvok);;
		}
	}
	
	private class Uzol {
		private Object data;
		private Uzol dalsi;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Uzol getDalsi() {
			return dalsi;
		}

		public void setDalsi(Uzol dalsi) {
			this.dalsi = dalsi;
		}
	}
	
	
}
