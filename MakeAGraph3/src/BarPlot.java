import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BarPlot extends Plot<String, Integer> {
	public BarPlot() {
		name = "Bar Plot";	
		dataset = new DataSet<String, Integer>();
		drawables = new ArrayList<DrawableObject>();
	}

	public void setDataSet(DataSet<String, Integer> ds){
		dataset = ds;
	}


}
