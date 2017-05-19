package cs121hw4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



public class Filter {
	List <String> withoutheader = new ArrayList<String> ();
	List <String> withoutstopwords = new ArrayList<String> ();
	
	public static List <String> headerFilter(String file){
		try {
			FileInputStream in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public static List <String> stopWordsFilter(List <String> withoutheader){
		return null;
		
	}
	
}
