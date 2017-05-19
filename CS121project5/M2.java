

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class M2 {
	// empty ctor
	public M2()
	{}
	/*
	 * Global vars
	 */
	Map<String, ArrayList<String>> poemmap = new HashMap<String, ArrayList<String>>();
	

	Set<String> stopWords = new HashSet<String>(Arrays.asList("a", "about", "above", "after","again","against","all","am","an","and","any","are","are\'t","as",
			"at","be","because","been","before","being","below","between", "both","but","by","can\'t","cannot","could","could\'t","did","did\'t","do",
			"does","doesn\'t","doing","don\'t","down","during","each","few","for","from","further","had","hadn\'t","has","hasn\'t","have","haven\'t",
			"having","he","he\'d","he\'ll","he\'s","her","here","here\'s","hers","herself","him","himself","his","how","how\'s","i","i\'d","i\'ll",
			"i\'m","i\'ve","if","in","into","is","isn\'t","it","it\'s","itself","let\'s","me","more","most","mustn\'t","my","myself","no","nor",
			"not","of","off","on","once","only","or","other","ought","our","ours","ourselves","out","over","own","same","shan\'t","she","she\'d","she\'ll",
			"she\'s","should","should\'t","so","some","such","than","that","that\'s","the","their","theirs","them","themselves","then","there","there\'s","these",
			"they","they\'d","they\'ll","they\'re","they\'ve","this","those","through","to","too","under","until","up","very","was","wasn\'t","we","we\'d",
			"we\'ll","we\'re","we\'ve","were","weren\'t","what","what\'s","when","when\'s","where","where\'s","which","while","who","who\'s","whom","why","why\'s",
			"with","won\'t","would","wouldn\'t","you","you\'d","you\'ll","you\'re","you\'ve","your","yours","yourself","yourselves"));

	ArrayList<String> termsList = new ArrayList<String>();
//	ArrayList<Poem> poemsList = new ArrayList<Poem>();
	MyMap myMap = new MyMap();
	int corpusSize = 280; // 280 poems in total, run the Testing project to check
	int corpuscounter = 1;
	/*
	 * Read and tokenize a text file then return ArrayList<String> 
	 */
	public void readFile(File file) throws IOException {

		String line ="";
		String poemId = "20141";
		FileReader reader = new FileReader(file);
		BufferedReader textReader = new BufferedReader(reader);
		while ((line = textReader.readLine()) != null) {
			if (!line.isEmpty()) 
			{   	
				// check if this line is an id
				if (isNumeric(line)){
					poemId = line;
					corpuscounter++;
				}else
				{
					// create poem object here
					readPoem(line.toLowerCase(),poemId);

				}
			}   
		}
	}

	public boolean isNumeric(String str)  
	{  
		try  
		{  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

	// Read pooem
	public void readPoem (String aPoem, String poemName) throws FileNotFoundException, IOException
	{
//		System.out.println(aPoem);
		ArrayList<String> arrayListOfWords= new ArrayList<String>();
		arrayListOfWords = tokenizeStr(aPoem);
		// this is the map of each Poem, to check for frequency of each term

		if (poemmap.containsKey(poemName)){
			ArrayList<String> addedListOfWords = poemmap.get(poemName);
			addedListOfWords.addAll(arrayListOfWords);
			poemmap.put(poemName, addedListOfWords);
		}else{
			poemmap.put(poemName, arrayListOfWords);
		}

		HashMap<String,Integer> wf = new HashMap<String,Integer>();
		for (String term : arrayListOfWords)
		{
//			termsList.add(term);
			if (!wf.containsKey(term))
				wf.put(term, 1);
			else
				wf.put(term, wf.get(term)+1);
		}
		// use wf instead to loop thru unique term only
		for (Entry<String, Integer> entry : wf.entrySet())
		{
			// put frequency of each team in its poem
			// note: List<Frequency> is actually poemName where the term appear in, and the term's frequency
			//df: total number of poems that contains the term, is the size of the List<Frequency>
			String term = entry.getKey();
			if (!stopWords.contains(term))
				myMap.put(term, new Frequency(poemName,wf.get(term)));
		}
		//System.out.println(wf.toString());
	}

	/*
	 * TF-IDF:  Term frequency, inverse document frequency.  To calculate weights.
                tf:  Some measure of term density in document.
                idf: Measures how INFORMATIVE the term is (i.e., its rarity in the corpus)
                        Could just be count of number of documents containing the term.
                        More commonly, idf(term) = log(corpus-size / df(term))
	 */

	public void printPoems () throws IOException
	{
		FileWriter indexfile = new FileWriter("C:\\Users\\Yang\\workspace_java1\\CS121project5\\tf-idf_v7.txt");
		FileWriter termfile = new FileWriter("C:\\Users\\Yang\\workspace_java1\\CS121project5\\terms.txt");
		
		for (Entry<String, List<Frequency>> entry : myMap.entrySet())
		{
//			BufferedWriter bufferedWriter = new BufferedWriter(file);
			String term = entry.getKey();
			termfile.write(term + "\n");
			int df = entry.getValue().size();
			double idf = Math.log10(corpusSize/entry.getValue().size());
			System.out.printf("%-15s(df:%d)\t(idf: %-6f)",term, df, idf);
			indexfile.write(String.format("\n\n%-15s(df:%d)\t(idf: %-6f)",term, df, idf));
//			
//			bufferedWriter.newLine();
//			bufferedWriter.flush();
			for (int i=0; i < entry.getValue().size(); ++i)
			{
				int frequencyint = entry.getValue().get(i).frequency;
				System.out.printf("\n\t %-6s:%-2d",entry.getValue().get(i).poemName, frequencyint);	
				String content = String.format("\n\t %-6s:%-2d", entry.getValue().get(i).poemName, frequencyint);
				ArrayList<String> poemArrayList = poemmap.get(entry.getValue().get(i).poemName);
				ArrayList<Integer> indexList = new ArrayList<Integer>();
				for (int k = 0; k < poemArrayList.size(); k++)
					if(term.equalsIgnoreCase(poemArrayList.get(k)))
						indexList.add(k+1);

				System.out.printf(":%d", indexList.get(0));
				content = content + String.format(":%d", indexList.get(0));
				if (frequencyint != 1){
					for (int j = 1; j < indexList.size(); j++){	
						System.out.printf(", %d",indexList.get(j));	
						content = content + String.format(", %d", indexList.get(j));
					}
				}
				System.out.printf("\t(tf: %d)\t(tf-idf: %-6f)", frequencyint, frequencyint*idf);
				content = content + String.format("\t(tf: %d)\t(tf-idf: %-6f)", frequencyint, frequencyint*idf);
//				bufferedWriter.write(content);
//				bufferedWriter.newLine();
//				bufferedWriter.flush();
				indexfile.write(content);
				//				System.out.print(entry.getValue().get(i).poemName + ":" + entry.getValue().get(i).frequency + "\t\t");
			}
//			bufferedWriter.newLine();
//			bufferedWriter.flush();
			//			System.out.printf("%10s df:%-3d", " ", entry.getValue().size());
			// corpusSize = 280 poems in total, run the Testing project to check
			// TODO calculate idf(term) here using idf(term) = log(corpusSize / df(term))
			//			System.out.printf("%10s idf:%-6f", " ", Math.log10(corpusSize/entry.getValue().size()));
			System.out.print("\n\n");

		}
		System.out.println("Corpus size: " + corpusSize);
		indexfile.close();
		termfile.close();
	}

	public  ArrayList<String> tokenizeStr(String input) throws FileNotFoundException, IOException 
	{
		/** delimiters meaning: 1 or more space OR comma followed by 1 or more space
		 * ' followed by 1 or more space OR '('  or ')' followed by one or more space
		 **/
		String delimiterSplit = "\\s+";  // split string with 1 or more space OR .
		// delimiterSplit to eliminate none-alphanumeric token
		String delimiters = "[^a-zA-Z0-9'’]"; // use this to replace all which is not alphameric char or - WITH empty char
		// replace all type of dash with whitespace to split later
		String temp = input.trim().replaceAll(delimiters, " ");
		String[] tokens = temp.split(delimiterSplit);

		ArrayList<String> stringArrayList= new ArrayList<String>();
		for (int i=0; i < tokens.length; i ++)
		{
			if (!tokens[i].equals("")) // skip empty token 
			{
				stringArrayList.add(tokens[i].toLowerCase().replaceAll(delimiters, ""));
			}
		}

		return stringArrayList;
	}

	public static void main(String[] args) throws IOException {
//		String textFile = "C:\\Users\\Yang\\workspace_cpp\\Cs121Proj5\\cs121Proj5.txt";
		String textFile = "C:\\Users\\Yang\\workspace_java1\\CS121project5\\cs121Proj5.txt";
		// TODO Auto-generated method stub
		File f = new File(textFile);
		//File[] directoryListing = f.listFiles();
		M2 m2 = new M2();
		m2.readFile(f);
		m2.printPoems();

	}

}
