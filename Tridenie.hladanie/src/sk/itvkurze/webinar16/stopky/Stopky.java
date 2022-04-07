package sk.itvkurze.webinar16.stopky;

public class Stopky {

	private boolean suSpustene;
	private long casSpustenia;
	private long uplynulyCas;

	public Stopky()
	{
		vynuluj();
	}
	
	
	public void start()
	{
		if(suSpustene)
		{
			return;
		}
		suSpustene = true;
		casSpustenia = System.currentTimeMillis();
	}
	
	
	public void stop()
	{
		if(!suSpustene)
		{
			return;
		}
		suSpustene = false;
		long casZastavenia = System.currentTimeMillis();
		uplynulyCas = uplynulyCas + (casZastavenia - casSpustenia);
	}
	
	public long getUplynulyCas()
	{
		if(suSpustene)
		{
			long casZastavenia = System.currentTimeMillis();
			return uplynulyCas + (casZastavenia - casSpustenia);
		}
		else
		{
			return uplynulyCas;
		}
	}
	
	private void vynuluj()
	{
		uplynulyCas = 0;
		suSpustene = false;
	}
}
