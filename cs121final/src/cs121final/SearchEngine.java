package cs121final;

import java.io.IOException;
import java.net.MalformedURLException;






import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;





import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class SearchEngine {

	private static String HTMLString;
	private static List<String> quoteList  = new ArrayList<String> ();

	public static void main(String[] args) {
		try {
			// get URL content
			URL url = new URL("http://www.hsa-haiku.org/hendersonawards/henderson.htm#top");
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));

			String inputLine;

			//save to this filename
			String fileName = "C:\\Users\\Yang\\Desktop\\poems.txt";
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}





			while ((inputLine = br.readLine()) != null) {
				HTMLString += inputLine;
			}



			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			Document html = Jsoup.parse(HTMLString);
			String h1 = html.body().getElementsByTag("blockquote").text();
			String t1 = html.body().getElementsByTag("h3").text();
			System.out.println(h1);
			System.out.println(t1);

			List <Element> blockquoteList = html.select("blockquote");
			for (Element ele: blockquoteList){
				int eleNum = blockquoteList.indexOf(ele);
				bw.write(ele.getElementsByTag("blockquote").text().trim().replaceAll("^ +| +$|( )+", "$1"));
				bw.newLine();
				bw.newLine();
				bw.newLine();
//				bw.newLine();
//				if (eleNum %2 != 0){
//					String poem = blockquoteList.get(eleNum - 1).getElementsByTag("blockquote").text();
//					String authoraddress = ele.getElementsByTag("blockquote").text();
//					String result = (poem.replaceAll(authoraddress, "")).trim();
//					//					System.out.println(result);
//					quoteList.add(result);
//				}
			}

			

			bw.close();
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//		RetrieveWeb web = new RetrieveWeb(urlString);
	//		String MIME    = web.getMIMEType( );
	//		Object content = web.getContent( );
	//		System.out.println(MIME);
	//		if ( MIME.equals( "text/html" ) && content instanceof String )
	//		{
	//			System.out.println("---");
	//		    String html = (String)content;
	//		    System.out.print(html);
	//		}

}

