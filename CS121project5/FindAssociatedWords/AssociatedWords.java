package FindAssociatedWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class AssociatedWords {

	public ArrayList<String> associatedTermList = new ArrayList<String>();


	public void printAllAssociatedTerms(File file) throws IOException
	{
		boolean run = true;
		FileWriter termfile = new FileWriter("C:\\Users\\Yang\\workspace_java1\\CS121project5\\associateterms4.txt");
		// Make sure to type input in lowercase
		//			System.out.print("Enter the search term: ");

		BufferedReader bufferRead = new BufferedReader(new FileReader(file));
		String s;
		while ((s = bufferRead.readLine()) != null) {

			// Make a URL to the web page
			//			String url = "http://wordassociations.net/search?hl=en&q=mother&button=Search"; // for testing
			String url = "http://wordassociations.net/search?hl=en&q=" + s + "&button=Search";
			termfile.write(String.format("%-13s: ", s));
			System.out.print(s + ": ");
			Document doc=Jsoup.connect(url).get();
			String termsstring = "";
			for (int k = 2; k < 5; k++){
				if (doc.getElementsByTag("ul").size() > k){
					Element noun = doc.getElementsByTag("ul").get(k);
					String nounText = noun.text();

					// split the nounText to get all associated terms
					String delimiterSplit = "\\s+";  // split string with 1 or more space OR .
					String[] nounTokens = nounText.split(delimiterSplit);
					//				System.out.println(nounTokens);
					// loop thru the nounTokens to find associated terms
					//			System.out.println("Terms that are associcated with \"" + s + "\":\n ");
					boolean doesNotHaveAny = true;

					for (String term : nounTokens)
					{

						// check if this term contained in the associated list and print out
						if (associatedTermList.contains(term.toLowerCase()) && term.toLowerCase() != s && !term.trim().toLowerCase().equalsIgnoreCase(s.trim().toLowerCase()) && !termsstring.contains(" " + term.toLowerCase() + ",")){
//							System.out.print("\"" + term.trim().toLowerCase() + "\", ");
//							System.out.println("\"" + s.trim().toLowerCase() + "\"");
							termsstring += term.toLowerCase() + ", ";
							doesNotHaveAny = false;
						}
					}
					if (doesNotHaveAny){

						System.out.print("");
						//					System.out.println("The Poems collection does NOT have any terms that is associated with \"" + s + "\".");

						//			System.out.println(noun.toString());
						//			System.out.println(nounText.toString());
					}
				}
			}
			if (termsstring.length() > 2){
				System.out.print(termsstring.substring(0, termsstring.length()-2));
				termfile.write(termsstring.substring(0, termsstring.length()-2));
			}
			System.out.println();
			termfile.write("\n");
	
		}
		termfile.close();
	}
	/*
	 * Read and tokenize a text file then return ArrayList<String> 
	 */
	public  void readFile(File file) throws IOException 
	{

		String line ="";
		FileReader reader = new FileReader(file);
		BufferedReader textReader = new BufferedReader(reader);
		while ((line = textReader.readLine()) != null) {
			if (!line.isEmpty()) 
				associatedTermList.add(line);
		}
	}

	public static void main(String[] args) throws IOException {

		AssociatedWords aw = new AssociatedWords();
		String textFile = "C:\\Users\\Yang\\workspace_java1\\CS121project5\\terms.txt";
		// TODO Auto-generated method stub
		File f = new File(textFile);	
		// read from terms.txt
		aw.readFile(f);

		aw.printAllAssociatedTerms(f);
		

	}


}
