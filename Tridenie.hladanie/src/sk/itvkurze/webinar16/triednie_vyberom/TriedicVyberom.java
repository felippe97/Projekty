package sk.itvkurze.webinar16.triednie_vyberom;

public class TriedicVyberom {

	private int[] data;

	public TriedicVyberom(int[] data) {
		this.data = data;
	}

	public void zotried()
	{
		for(int i = 0; i < data.length - 1; i++)
		{
			int minIndex = najdiIndexNajmensiehoPrvkuOdIndexu(i);
			vymenPrvky(minIndex, i);
		}
	}

	private void vymenPrvky(int indexI, int indexJ) {
		int zaloha = data[indexI];
		data[indexI] = data[indexJ];	
		data[indexJ] = zaloha;			
	}


	private int najdiIndexNajmensiehoPrvkuOdIndexu(int indexOd) {
		// data = { -1, 1, -2, 2, 0 }
		int indexMinPrvku = indexOd;
		
		for (int i = indexMinPrvku + 1; i < data.length; i++) {
			if(data[i] < data[indexMinPrvku])
			{
				indexMinPrvku = i;
			}
		}
		return indexMinPrvku;
	}
}
