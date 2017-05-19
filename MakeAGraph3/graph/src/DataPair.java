
public class DataPair {
	public static Pair pair;
	
//	
//	public static getPair(){
//		return 
//	}
	public static Pair<Integer, Integer> createIntIntPair(int a, int b ){
		pair = new Pair(a, b);
		return pair;
	}
	
	public static Pair<String, Integer> createStringIntPair(String a, int b){
//		return Pair.createPair(a, b);
		pair = new Pair(a, b);
		return pair;
	}
	

}
