import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.lang.Math;
import java.util.List;


public class Bar extends DimensionalGraph {
	// true for horizontal, false for vertical

	private static int y_scale = 2;
	private static int x_scale = y_scale;
	private static boolean orientation = true;
	private static int PAD = GraphCanvas.PAD;
	private static int x_range;
	private static int y_range;
	private static ArrayList<String> x_comp = new ArrayList<String>();
	private static Set x_comp_set;
	private static ArrayList<Integer> y_comp = new ArrayList<Integer>();
	private List<Pair> data;
	private static int num_y_bar;
	private static int num_x_bar;
	public Bar(List<Pair> inputdata){
		this.data = inputdata;
		for(Pair<String, Integer> thispair: data) {
			x_comp.add(thispair.getFirstValue());

			y_comp.add(thispair.getSecondInt());
		}
		x_comp_set =  new HashSet(x_comp);
		x_comp = new ArrayList<String>();
		x_comp.addAll(x_comp_set);

		Collections.sort(x_comp);
		Collections.sort(y_comp);

		y_range = y_comp.get(y_comp.size()-1)- y_comp.get(0);
	}

	public static void changeOrientation(){
		orientation = !orientation;
	}

	public static void swapDimensions(){

	}
	public static void drawAxis(Graphics2D g2, int height, int width){
		g2.draw(new Line2D.Double(PAD, PAD, PAD, height-PAD));
		g2.draw(new Line2D.Double(PAD, height-PAD, width-PAD, height-PAD));
	}

	public static void drawAxisTitle(Graphics2D g2, int height, int width){
		int y_label = 0;
		g2.drawString(y_axis_title, 0, height/2);
		num_y_bar = y_comp.get(y_comp.size()-1)/y_scale;
		for(int m = 0; m < num_y_bar + 1; m++) {
			g2.drawString(String.format("%4d -", y_label), PAD-10, height-PAD-m*((height - 2*PAD)/ num_y_bar));
			y_label = y_label + y_scale;
		}
		g2.drawString(x_axis_title, width/2, height);
		num_x_bar = x_comp.size() ;
		for(int m = 1; m < num_x_bar + 1; m++) {
			g2.drawString(String.format("%4s", x_comp.get(m-1)), PAD + m* (width - 2*PAD)/num_x_bar, height - PAD + 50);
		}
	}



	public static void drawDataset(Graphics2D g2,  List<Pair> data, int height, int width){
		g2.setPaint(Color.black);

		//		double xInc = (double)(width - 2*PAD)/(ds.getData().size()-1);
		//		double scale = (double)(height - 2*PAD)/getMax();
		int i = 1;
		for(Pair<Integer, Integer> thispair: data) {
			double x = PAD + (i * (width - 2*PAD)/num_x_bar);
			int v = 0;
			while(thispair.getSecondInt() > v*y_scale ){
				double y = height - PAD - (thispair.getSecondInt())/y_scale * ((height - 2*PAD)/ num_y_bar) + v*y_scale;
				g2.fill(new Rectangle.Double(x, y, height - PAD, y + 2));
				v ++;
			}
			i ++;
		}
	}
}
