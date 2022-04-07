package UnZipFolderUpgrade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ZipTester {

	String absolutnaCestaKSuboru = "";
	String riadokSubor = "";
	String slovoNaVymazanie = "";
	String absolutnaCesta = "";
	String novaAbsolutnaCesta = "";

	public ZipTester(String absolutnaCesta, String novaAbsolutnaCesta, String nazovSuboru, String slovo)
			throws IOException {

		this.absolutnaCesta = absolutnaCesta;
		System.out.println(absolutnaCesta);
		this.novaAbsolutnaCesta = novaAbsolutnaCesta;
		System.out.println(novaAbsolutnaCesta);

		try {

			Scanner vstup = new Scanner(System.in);
			absolutnaCestaKSuboru = absolutnaCesta;
			System.out.println("Napiste nazov suboru v ktorom chcete vymazat riadok");

			riadokSubor = nazovSuboru;
			System.out.println(riadokSubor);
			System.out.println("Napiste slovo ktore by sa malo nachadzat v subore");

			slovoNaVymazanie = slovo;
			System.out.println(slovoNaVymazanie);
			vstup.close();

		} catch (NullPointerException ex) {
			System.out.println("Nenasiel som subor");
		}

		UnZipSoftware zipTrieda = new UnZipSoftware();
		HladanieRiadku vyhladaj = new HladanieRiadku();

		try {
			zipTrieda.unZip(absolutnaCestaKSuboru, slovoNaVymazanie, novaAbsolutnaCesta);
			String absolutnaCestaNovehoSuboru = zipTrieda.getNewNameFile() + "\\" + riadokSubor;

			// String link = zipTrieda.getNazovExtrahovanehoSuboru();// ukladame nazov
			// zlozky ktoru sme extrahovali

			/**
			 * metoda hladaj. vyhladava slovo v subore .txt , vymaze kazdy riadok ktory
			 * obsahuje kolucove slovo . sucasne kopiruje subor ktory chce pouzivatel
			 * prepisat do noveho suboru .
			 */
			vyhladaj.hladaj(slovoNaVymazanie, absolutnaCestaNovehoSuboru, riadokSubor);
			File subor = new File(vyhladaj.getCestaNovehoSuboru()); // vytvarame objekt suboru do ktoreho budeme
																	// kopirovat prepisany subor
			// link += "\\" + subor.toString(); //link pomocou ktoreho najdeme cestu k
			// zlozke
			File suborNaVymazanie = new File(absolutnaCestaNovehoSuboru);
			FileInputStream suborStream = new FileInputStream(subor);
			/**
			 * extrahuje prepisany subor do novo vytvoreneho foldera
			 */
			zipTrieda.extractNewFile(suborStream, zipTrieda.getNewNameFile() + "\\." + riadokSubor);
			suborStream.close();
			if (suborNaVymazanie.delete()) {

				System.out.println("Vsetko prebehlo uspesne");
			}

		} catch (Exception ac) {
			ac.printStackTrace();
		}

	}

}
