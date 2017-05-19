

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
			}
		}
	}

	public void stemFile(String file)
	{

		char[] w = new char[501];
		Stemmer s = new Stemmer();

		try{
			FileInputStream in = new FileInputStream(file);

			try{ 
				while(true){  
					int ch = in.read();
					if (Character.isLetter((char) ch))
					{
						int j = 0;
						while(true)
						{  ch = Character.toLowerCase((char) ch);
						w[j] = (char) ch;
						if (j < 500) j++;
						ch = in.read();
						if (!Character.isLetter((char) ch))
						{
							/* to test add(char ch) */
							for (int c = 0; c < j; c++) s.add(w[c]);

							/* or, to test add(char[] w, int j) */
							/* s.add(w, j); */

							s.stem();
							{  String u;

							/* and now, to test toString() : */
							u = s.toString();

							/* to test getResultBuffer(), getResultLength() : */
							/* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */


							//						System.out.print(u);
							}
							break;
						}
						}
					}
					if (ch < 0) break;
				}
			}
			catch (IOException e)
			{  System.out.println("error reading " + file);
			}
			finally{			
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}finally{

		}
	}
	
	public void main(){
		char[] w = new char[501];
		Stemmer s = new Stemmer();

		try{
			FileInputStream in = new FileInputStream("C:\\Users\\Yang\\Enron_mail\\maildir\\whalley-g\\merchant_investments\\3.");

			try{ 
				while(true){  
					int ch = in.read();
					if (Character.isLetter((char) ch))
					{
						int j = 0;
						while(true)
						{  ch = Character.toLowerCase((char) ch);
						w[j] = (char) ch;
						if (j < 500) j++;
						ch = in.read();
						if (!Character.isLetter((char) ch))
						{
							/* to test add(char ch) */
							for (int c = 0; c < j; c++) s.add(w[c]);

							/* or, to test add(char[] w, int j) */
							/* s.add(w, j); */

							s.stem();
							{  String u;

							/* and now, to test toString() : */
							u = s.toString();

							/* to test getResultBuffer(), getResultLength() : */
							/* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */


													System.out.print(u);
							}
							break;
						}
						}
					}
					if (ch < 0) break;
				}
			}
			catch (IOException e)
			{  System.out.println("error reading " + "");
			}
			finally{			
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}finally{

		}
	}
}

