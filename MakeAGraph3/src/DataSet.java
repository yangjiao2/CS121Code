
import java.util.*;

public class DataSet<E, T>{
	private List<Pair<E, T>> data = new ArrayList<Pair<E, T>>();
	private int size;
	
	public DataSet(){
		size = 0;
	}
	
	public List<Pair<E, T>> getDataSet(){
		return data;
	}
	
	public int size(){
		return size;
	}
	
	public void add(Pair<E, T> thispair){
		data.add(thispair);
		size++;
	}
	

	public void remove(Pair<E, T> thispair){
		data.remove(thispair);
		size--;
	}
	
	
	public void sort(){
		Collections.sort(data, new Comparator<Pair<E, T>>(){
			public int compare(Pair<E, T> p1, Pair<E, T> p2){
				if (p1.getFirstValue() instanceof String){
					if ( p1.getFirstValue().toString().compareTo(p2.getSecondValue().toString()) != 0){
						return  p1.getFirstValue().toString().compareTo(p2.getFirstValue().toString());
					}else{
						return ((Integer) p1.getSecondValue()).compareTo((Integer) p2.getSecondValue());
					}
				}else{
					if (((Integer) p1.getFirstValue()).compareTo((Integer) p2.getSecondValue()) != 0){
						return  ((Integer) p1.getFirstValue()).compareTo((Integer) p2.getSecondValue());
					}else{
						return ((Integer) p1.getSecondValue()).compareTo((Integer) p2.getSecondValue());
					}
				}}});
	}
	
	
	public boolean includes(Pair<E, T> thispair){
		for (Pair<E, T> pairIter: data){
			if (pairIter.getFirstValue() == thispair.getFirstValue() && pairIter.getSecondValue() == thispair.getSecondValue()){
				return true;
			}
		}
		return false;
	}
}
