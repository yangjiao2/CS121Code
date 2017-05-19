import java.awt.Color;
import java.util.*;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.lang.Math;
import java.util.List;

public class ScatterPlot extends DimensionalGraph{
	private static int x_scale = 5;
	private static int y_scale = 10;
	private static int x_range;
	private static int y_range;
	private static ArrayList<Integer> x_comp = new ArrayList<Integer>();
	private static ArrayList<Integer> y_comp = new ArrayList<Integer>();
	private static int PAD = GraphCanvas.PAD;
	private List<Pair> data;
	private static int num_y_bar;
	private static int num_x_bar;
	public ScatterPlot(List<Pair> inputdata){
		this.data = inputdata;
		for(Pair<Integer, Integer> thispair: data) {
			x_comp.add(thispair.getFirstInt());
			y_comp.add(thispair.getSecondInt());
		}
		Collections.sort(x_comp);
		Collections.sort(y_comp);
		x_range = x_comp.get(x_comp.size()-1)- x_comp.get(0);
		y_range = y_comp.get(y_comp.size()-1)- y_comp.get(0);
	}
	
	public static void drawAxis(Graphics2D g2, int height, int width){
		
		//		int indent = y_axis_title.length() + 5;
		//		int y_range = Math.abs((Integer) (y_boundaries.getSecondValue() - y_boundaries.getFirstValue()));
		//		
		////		System.out.format("%-" + y_range + "s\n");
		////		System.out.format("%-" + (y_range - 5) + "s%4s |", y_axis_title,"" );
		////		for (int j = 0; j <= y_range/y_scale; j++){
		////			if (j%3 == 0){
		////				System.out.format("%-" + (y_range - 5) + "s%4d -", "", y_boundaries.getSecondValue()%y_scale * y_scale - j * y_scale);
		////			}else{
		////				System.out.format("%-" + (y_range - 5) + "s%4s |", "","");
		////			}
		////		}

//		int x_range = Math.abs((Integer) (x_boundaries.getSecondValue() - x_boundaries.getFirstValue()));
		//		for (int i = 0; i <= x_range/x_scale; i++){
		//			System.out.print("____");
		//		}
		//		for (int i = 0; i <= x_range/x_scale; i++){
		//			System.out.print("|   ");
		//		}
		//		for (int i = 0; i <= x_range/x_scale; i++){
		//			System.out.print((x_boundaries.getFirstValue() + i * x_scale) + "   ");
		//		}
		g2.draw(new Line2D.Double(PAD, PAD, PAD, height-PAD));
        g2.draw(new Line2D.Double(PAD, height-PAD, width-PAD, height-PAD));
	}

	public static void drawAxisTitle(Graphics2D g2, int height, int width){
		int y_label = 0;
		int x_label = 0;
		g2.drawString(y_axis_title, 0, height/2);
		num_y_bar = y_comp.get(y_comp.size()-1)/y_scale;
		for(int m = 0; m < num_y_bar + 1; m++) {
			g2.drawString(String.format("%4d -", y_label), PAD-30, height-PAD-m*((height - 2*PAD)/ num_y_bar));
			y_label = y_label + y_scale;
		}
		g2.drawString(x_axis_title, width/2, height);
		num_x_bar = x_comp.get(x_comp.size()-1)/x_scale;
		for(int m = 0; m < num_x_bar + 1; m++) {
			g2.drawString(String.format("|"), PAD + m* (width - 2*PAD)/num_x_bar, height - PAD + 10);
			g2.drawString(String.format("%4d", x_label), PAD + m* (width - 2*PAD)/num_x_bar, height - PAD + 50);
			x_label = x_label + x_scale;
		}
	}
	
 
	public static void drawDataset(Graphics2D g2, List<Pair> data, int height, int width){
		g2.setPaint(Color.black);
		
//		double xInc = (double)(width - 2*PAD)/(ds.getData().size());
//		double scale = (double)(height - 2*PAD)/getMax();
		for(Pair<Integer, Integer> thispair: data) {
			double x = PAD + (thispair.getFirstInt())/x_scale * ((width - 2*PAD)/num_x_bar);
//			System.out.println(x);
			double y = height - PAD - (thispair.getSecondInt())/y_scale * ((height - 2*PAD)/ num_y_bar);
//			System.out.println(y);
			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
		}
	}
	
	
}
