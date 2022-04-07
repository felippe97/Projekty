package sk.itvkurze.webinar16.triednie_vkladanim;

public class TriedicVkladanim {

	private int[] data;

	public TriedicVkladanim(int[] data) {
		this.data = data;
	}

	public void zotried() {
		for (int i = 1; i < data.length; i++) {
			int dalsi = data[i];

			int j = i;
			while (j > 0 && data[j - 1] > dalsi) {
				data[j] = data[j - 1];
				j--;
			}

			data[j] = dalsi;
		}
	}
}
