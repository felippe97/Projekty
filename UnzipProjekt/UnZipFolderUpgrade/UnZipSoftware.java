package UnZipFolderUpgrade;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipSoftware {
	
	
	private static final int minimalnyPocetBytov = 4000;
	String nameFile = "";
	String filePath = "";
	BufferedOutputStream bos;

	String slovoNaVymazanie;
	

	
	/**
	 * rozbalenie a extrahovanie suboru zip
	 * @param zipFile
	 * @param slovoNaVymazanie
	 * @throws IOException
	 */
	public void unZip(String zipFile,String slovoNaVymazanie,String novaAbsolutnaCesta) throws IOException
	{
		int cislaStarejAbsolutneCesty = zipFile.length() -4;
		int cisloNovejAbsolutnejCesty = novaAbsolutnaCesta.length() + 1;
		

		
	
		
		this.slovoNaVymazanie = slovoNaVymazanie;
		
	
		 nameFile = novaAbsolutnaCesta + "\\";
	     nameFile += zipFile.substring(cisloNovejAbsolutnejCesty,cislaStarejAbsolutneCesty);
		
	
		
		
		File newFile = new File(nameFile);
		
		if(!newFile.exists())
		{
			newFile.mkdir();
		}
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile)); // filter toku na vstup do suboru zip
		ZipEntry entry;  //  premenna do ktorej vlozime subor z polozky zip, uklada cestu k suboru a tiez samotny file
		
		
		while ((entry = zipIn.getNextEntry()) !=null)
		{
			
			filePath = newFile + File.separator +  entry.getName(); // "C:\\Users\\xgelb\\eclipse-workspace\\Zaverecny_Projekt\\newFile\\entry.getName\\"
			if(!entry.isDirectory()) //ak vstup nieje adresar , v nasom pripade je aj subor tak mozme copirovat
			{
				extractFile(zipIn,filePath);
				
			}
			else 
			{
				File dir = new File(filePath);
				dir.mkdir();
				
				
			}
		    zipIn.closeEntry();
		   
          
		}
		zipIn.close();
		 System.out.println("Subor s absolutnou cestou ,," + zipFile + ",, bol extrahovany");
		
		 
		 
		
	}
	
	private void extractFile(ZipInputStream zipIn, String FilePath) throws IOException
	{
	    bos = new BufferedOutputStream(new FileOutputStream(FilePath)); //vytvarame objekt a cestu k subu do ktoreho budeme zapisovat bajty do vyrovnavajucej pamate
		byte[] bytesIn = new byte[minimalnyPocetBytov];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) // vracia celkovy pocet bajtov
		{
			bos.write(bytesIn, 0, read); 
			
		}
		bos.close();
	}
	
	public void extractNewFile(FileInputStream file,String link) throws IOException
	{
		bos = new BufferedOutputStream(new FileOutputStream(link)); //vytvarame objekt a cestu k subu do ktoreho budeme zapisovat bajty do vyrovnavajucej pamate
		byte[] bytesIn = new byte[minimalnyPocetBytov];
		int read = 0;
		while ((read = file.read(bytesIn)) != -1) // vracia celkovy pocet bajtov 
		{
			bos.write(bytesIn, 0, read); 
			
		}
		bos.close();
	}
	
	public String getNazovExtrahovanehoSuboru ()
	{
		return nameFile;
	}
	
	public String getLink()
	{
		return filePath;
	}
	public String getNewNameFile()
	{
		return nameFile;
	}
	
	
	
	
	
//	public void searchClearFile (String nazovSuboruPrehladavanie,String slovoNaVymazanie) throws IOException
//	{
////		File file = new File(nameFile);
////		File[] poleFilov = File.listRoots();
////		for (File file2 : poleFilov) {
////			String nazov = file2.getName();
////			if(nazovSuboruPrehladavanie.equalsIgnoreCase(nazov))
////			{
////				FileReader read = new FileReader(nazov);
////				Scanner scanuj = new Scanner(read);
////				while (scanuj.hasNextLine())
////				{
////					String riadok = scanuj.nextLine();
////					String[] slova = riadok.split(" ");
////					for (String slovo : slova) {
////						if(slovo.equalsIgnoreCase(slovoNaVymazanie))
////						{
////							
////						}
////					}
////					
////				}
////			}
////			
////		}
//		
//		
//		File inputFile = new File(nazovSuboruPrehladavanie);
//		File tempFile = new File("C:\\Users\\xgelb\\eclipse-workspace\\Zaverecny_Projekt\\" + "subor.txt");
//		
//		//File tempFile = new File();
//
//		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//		//String lineToRemove = "bbb";
//		String currentLine;
//
//		while((currentLine = reader.readLine()) != null) {
//		    // trim newline when comparing with lineToRemove
//			String trimmedLine = currentLine.trim();
//		    
//		
//		    String slovo = "false";
//		   
//		    String[] slova = trimmedLine.split(" ");
//		       for (String string : slova) 
//		        {
//					if(string.equalsIgnoreCase(slovoNaVymazanie))
//					{
//						slovo = string;
//						
//					}
//				}
//		    	
//		    
//		    if(slovo.equalsIgnoreCase("false")) continue;
//		    writer.write(currentLine + System.getProperty("line.separator"));
//		    slovo = "false";
//		    
//		}
//		writer.close(); 
//		reader.close();
//		
//		System.out.println("Riadok so vstupnym slovom sa nasiel a bol vymazany");
//		boolean successful = tempFile.renameTo(inputFile);
//	}
//	
	
	
	
	


	
}
