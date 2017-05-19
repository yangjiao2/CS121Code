
import java.util.*;


public class DataSet{
	public static List<Pair> data;
	
	public DataSet(){
		data = new ArrayList<Pair>();
	}
	
	public List<Pair> add(Pair thispair){
		System.out.println("add Pair" + thispair.toString());
		data.add(thispair);
		return data;
	}

	// don't know what this function do
//	public void adjustPair(){
//		
//	}
	
	// change input undeclared type for x, y to be a dataPair
	
	public List<Pair>  remove(Pair thispair){
		data.remove(thispair);
		return data;
	}
	
	public List<Pair> getData(){
		return data;
	}
	
	public static List<Pair> sort(){
		Collections.sort(data, new Comparator<Pair>(){
			public int compare(Pair p1, Pair p2){
				if (p1.getFirstValue() instanceof String){
					if ( p1.getSecondValue().toString().compareTo(p2.getSecondValue().toString()) != 0){
						return  p1.getSecondValue().toString().compareTo(p2.getSecondValue().toString());
					}else{
						return ((Integer) p1.getFirstValue()).compareTo((Integer) p2.getFirstValue());
					}
					
				}else{
					if (((Integer) p1.getFirstValue()).compareTo((Integer) p2.getFirstValue()) != 0){
						return  ((Integer) p1.getFirstValue()).compareTo((Integer) p2.getFirstValue());
					}else{
						return ((Integer) p1.getSecondValue()).compareTo((Integer) p2.getSecondValue());
					}
				}}});
		return data;
	}
	
	
	public boolean includes(DataPair thispair){
		for (Pair pairIter: data){
			if (pairIter.getFirstValue() == thispair.pair.getFirstValue() && pairIter.getSecondValue() == thispair.pair.getSecondValue()){
				return true;
			}
		}
		return false;
	}
}
