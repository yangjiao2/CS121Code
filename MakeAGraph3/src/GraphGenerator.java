import java.util.*;
import java.util.Scanner;

public class GraphGenerator {
	Plot plot;
	public GraphGenerator(int type) {
		switch (type) {
		case 1: 
			plot = new ScatterPlot();
			break;
		case 2:
			plot = new BarPlot();
			break;
		}
	}
	
	public Plot getPlot(){
		return plot;
	}
}
