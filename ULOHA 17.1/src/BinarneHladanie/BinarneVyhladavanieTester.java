package BinarneHladanie;

public class BinarneVyhladavanieTester {
	public static void main(String[] args) {
		int[] cisla = new int[10];
		for (int i = 0; i < 10; i++) {
			cisla[i] = i * i;
		}
		BinarnyVyhladavac vyhladavac = new BinarnyVyhladavac(cisla);
		System.out.println(vyhladavac.vyhladaj(4));
		System.out.println("Ocakavana hodnota: 2");
		System.out.println(vyhladavac.vyhladaj(81));
		System.out.println("Ocakavana hodnota: 9");
		System.out.println(vyhladavac.vyhladaj(0));
		System.out.println("Ocakavana hodnota: 0");
		System.out.println(vyhladavac.vyhladaj(3));
		System.out.println("Ocakavana hodnota: -3");
		System.out.println(vyhladavac.vyhladaj(-1));
		System.out.println("Ocakavana hodnota: -1");
		System.out.println(vyhladavac.vyhladaj(100));
		System.out.println("Ocakavana hodnota: -11");
	}
}