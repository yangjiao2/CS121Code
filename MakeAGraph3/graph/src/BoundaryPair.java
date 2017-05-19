import java.util.Collection;
import java.util.Collections;


public class BoundaryPair {
	private static DataSet dataset;

	public BoundaryPair(DataSet ds){
		dataset = ds;
	}

	public static Pair<Integer, Integer> getFirstBoundary(){
		if (dataset.sort().get(0).getFirstValue() instanceof String){
			return DataPair.createIntIntPair(0,  (int) dataset.getData().size());
		}else{
			return DataPair.createIntIntPair(dataset.getData().get(0).getFirstInt(), dataset.getData().get(dataset.getData().size() - 1).getFirstInt());
		}
	}
	
	public static Pair<Integer, Integer> getSecondBoundary(){
		return Pair.createPair(dataset.getData().get(0).getSecondInt(), dataset.getData().get(dataset.getData().size() - 1).getSecondInt());

	}
}
