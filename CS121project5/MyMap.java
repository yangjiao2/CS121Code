//Vu Nguyen - 42182872
//Yazen Nasr – 24872793



import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// inherit from HashMap
// note: List<Frequency> is actually poemName where the term appear in, and the term's frequency
public class MyMap extends TreeMap<String,List<Frequency>> {
	public void put(String key, Frequency f) {
        List<Frequency> current = get(key);
        if (current == null) {
            current = new ArrayList<Frequency>();
            super.put(key, current);
        }
        // if the key exists already
        current.add(f);
        // replace the old key in map with new key and current value
        super.put(key, current);
    }
	
//	// testing
//	public static void main(String args[]) {
//        MyMap m = new MyMap();
//        m.put("b", new post("dir1", 2, new ArrayList<Integer>(Arrays.asList(1,2))));
//        m.put("b", new post());
//        m.put("a", new post());
//        m.put("f", new post());
//        m.put("d", new post());
//       
//        
//        for(Map.Entry e : m.entrySet()) {
//            System.out.println(e.getKey() + " -> " + "post: " + e.getValue().toString());
//           
//        }
//    }
}
