import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class GraphCanvas extends JPanel {

	private static Graph graph;
	public static List<Pair> data;


	private static Graphics2D g2;
	protected final  int height = getHeight();
	protected final  int width = getWidth();
	protected final static int PAD = 100;

	private static Console.GRAPHMODE mode; 

	public GraphCanvas(List<Pair> data1, Console.GRAPHMODE m){
		data = data1;
		mode = m;
	}

	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}

//	public void drawGraph( Console.GRAPHMODE mode, Graphics g){
//
//		Graph.getInfo();
//		if (mode ==  Console.GRAPHMODE.SCATTER){
//			DimensionalGraph.getInfo();
//			ScatterPlot.drawTitle(g2, height, width);
//			ScatterPlot.drawAxis(g2, height, width);
//			ScatterPlot.drawAxisTitle(g2, height, width);
//		}else if (mode ==  Console.GRAPHMODE.BAR){
//			DimensionalGraph.getInfo();
//			Bar.drawTitle(g2, height, width);
//			Bar.drawAxis(g2, height, width);
//			Bar.drawAxisTitle(g2, height, width);
//		}else if (mode ==  Console.GRAPHMODE.PIE){
//			ChartGraph.getInfo();
//			PieChart.drawTitle(g2, height, width);
//			PieChart.drawLegend(g2, height, width);
//		}
//		drawData(g2);
//	}
//
//
//
//
//	public void drawData(Graphics2D g){
//		if (mode ==  Console.GRAPHMODE.SCATTER){
//			ScatterPlot.drawDataset(g2, data, height, width);
//		}else if (mode ==  Console.GRAPHMODE.BAR){
//			Bar.drawDataset(g2, data, height, width);
//		}else if (mode ==  Console.GRAPHMODE.PIE){
//			PieChart.drawDataset(g2, data, height, width);
//			PieChart.drawLegend(g2, height, width);
//		}
//
//
//	}

//	public static void draw(List<Pair> data, Console.GRAPHMODE mode){
//		JFrame f = new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//		Console c = new Console();
//		GraphCanvas	gc = new GraphCanvas(data, mode);
//		f.add(gc);
//		f.setSize(400,400);
//		//		f.setLocation(200,200);
//		f.setVisible(true);
//	}


}


