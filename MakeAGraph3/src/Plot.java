import java.util.*;
// Strategy Design Pattern


public abstract class Plot <E, T>{
	String name;	
	DataSet<E, T> dataset = new DataSet<E, T>();
	List <DrawableObject> drawables = new ArrayList<DrawableObject>();
	
	
	public  void draw(){
		for (int i = 0; i< drawables.size(); i++){
			drawables.get(i).draw();
		}
	}
	
	public abstract void setDataSet(DataSet<E, T> ds);
	
}
