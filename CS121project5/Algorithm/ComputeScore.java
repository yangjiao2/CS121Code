package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import FindAssociatedWords.AssociatedWords;

public class ComputeScore {
	Hashtable<String, Integer> termpositionweightdict = new Hashtable<String, Integer>();
	Hashtable<String, String> termdocdict = new Hashtable<String, String>();
	Hashtable<ArrayList<String>, ArrayList<Integer>> doctermpositiondict = new Hashtable<ArrayList<String>, ArrayList<Integer>>();
	Hashtable<ArrayList<String>, Float> doctermweightdict = new Hashtable<ArrayList<String>, Float>();
	ArrayList<String> TermList = new ArrayList<String>();
	static ArrayList<String> SQ = new ArrayList<String>();

	private List<String> customstem(String rawTerm){
		List<String> specialtermList = new ArrayList<String> ();
		if (rawTerm.contains("'")){
			specialtermList.add(rawTerm.substring(0, rawTerm.indexOf("'")));
			specialtermList.add(rawTerm.substring (rawTerm.indexOf("'"), rawTerm.length()-1));
		}else{
			specialtermList.add(rawTerm);
		}
		return specialtermList;
	}

	public void filterbytermFile(File file) throws IOException 
	{
		ArrayList<String> copySQ = SQ;
		String line ="";
		FileReader reader = new FileReader(file);
		BufferedReader textReader = new BufferedReader(reader);
		while ((line = textReader.readLine()) != null) {
			if (!line.isEmpty()) 
				TermList.add(line.trim().toLowerCase());
		}
		for(String term: copySQ){
			if (! TermList.contains(term)){
				List<String> termList = customstem(term);
				for (String spterm: termList){
					SQ.remove(spterm);
				}
			}
		}
		//		SQ = copySQ;
	}

	public  void readIndexFile(String indexfile, String termindexwriterfileaddress) throws IOException 
	{
		FileWriter writerfile = new FileWriter(termindexwriterfileaddress);
		List<String> copySQ = SQ;
		String line ="";
		FileReader reader = new FileReader(new File (indexfile));
		BufferedReader textReader = new BufferedReader(reader);
		while ((line = textReader.readLine()) != null) {
			if (!line.isEmpty() && !line.startsWith("\t")){

				for(String items : line.split("\\s+")){
					for (String term: copySQ){
						if (term.equalsIgnoreCase(items)){

							termpositionweightdict.put(term, SQ.indexOf(term));
							writerfile.write(line);
							System.out.println(line);
							String line1 = "";
							while ((line1  = textReader.readLine()) != null && ! line1.isEmpty()) {
								System.out.println(line1);
								writerfile.write(line1);
								writerfile.write("\n");
								Scanner sc = new Scanner(line1);
								String poemid = Integer.toString(sc.nextInt());
								System.out.println(poemid);
								String posNum = sc.next();
								String posNum1 = sc.next();
								System.out.println(posNum1);
								ArrayList<Integer> posList = new ArrayList<Integer> ();
								for (int i = 0; i < 1; i++){
									posList.add(sc.nextInt());
								}
								int tf = sc.nextInt();
								float tfidf = sc.nextFloat();
								termdocdict.put(term, poemid);
								ArrayList<String> key = new ArrayList<String>();
								key.add(poemid);
								key.add(term);
								doctermpositiondict.put(key, posList);
								doctermweightdict.put(key, tfidf);
								if (line1.isEmpty()){
									break;
								}
							}}
					}}}
		}
		writerfile.flush();
		writerfile.close();
		System.out.println("Dictionaries:");
		System.out.println(termpositionweightdict);
		System.out.println(termdocdict);
		System.out.println(doctermpositiondict);
		System.out.println(doctermweightdict);
	}

	public void process(){

	}

	public void readInputSearchQuery(){
		System.out.println("Please input the search query (seperated by space):");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String delimiterSplit = "\\s+";  // split string with 1 or more space OR .
		// delimiterSplit to eliminate none-alphanumeric token
		String delimiters = "[^a-zA-Z0-9'’]"; // use this to replace all which is not alphameric char or - WITH empty char
		// replace all type of dash with whitespace to split later
		String temp = input.trim().replaceAll(delimiters, " ");
		String[] tokens = temp.split(delimiterSplit);
		for(String term: tokens){
			SQ.add(term.toLowerCase());
		}

	}

	public static void main(String[] args) throws IOException {
		ComputeScore cs = new ComputeScore();
		String textFile = "C:\\Users\\Yang\\workspace_java1\\CS121project5\\terms.txt";
		// TODO Auto-generated method stub

		cs.readInputSearchQuery();
		cs.filterbytermFile(new File(textFile));
		System.out.println("Query after filtering: " + SQ.toString());
		String indexFileaddress = "C:\\Users\\Yang\\workspace_java1\\CS121project5\\tf-idf_v7.txt";
		String termindexfileaddress = "C:\\Users\\Yang\\workspace_java1\\CS121project5\\algorithmfortermindex.txt";
		cs.readIndexFile(indexFileaddress, termindexfileaddress);
		cs.process();
		System.out.println("Finish");
	}

}
