

import java.util.HashMap;

public class Poem {
	public String name;
	public HashMap<String,Integer> WordFre;
	
	public Poem()
	{
		this.name = "";
		this.WordFre = null;
	}
	public Poem(String n, HashMap<String,Integer> wf)
	{
		this.name = n;
		this.WordFre = wf;
	}
	
}
