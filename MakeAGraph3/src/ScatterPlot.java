import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ScatterPlot extends Plot<Integer, Integer> {
	public ScatterPlot() {
		name = "Scatter Plot";	
		dataset = new DataSet<Integer, Integer>();
		drawables = new ArrayList<DrawableObject>();
	}


	public void setDataSet(DataSet<Integer, Integer> ds){
		dataset = ds;
	}





}
