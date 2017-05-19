import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Console  extends JPanel {


	private static DataSet dataset = new DataSet();
	public static List<Pair> data = dataset.getData();

	//	private static List<DrawableObject> drawables = new ArrayList<DrawableObject>();
	// could add mode via vector.elements()
	public enum GRAPHMODE{
		SCATTER,
		BAR,
		PIE
	}
	static GRAPHMODE mode; 
	private static GraphCanvas gc;

	public static void changeGraphMode(GRAPHMODE m){
		mode = m;
	}


	//	public static int refreshDrawables(){
	//		return 0;
	//	}

	public static DataSet parseData(String rawData){
		int counter = 0;
		try {

			String s1 = null;
			double i2 = Double.POSITIVE_INFINITY;
			double i1 = Double.POSITIVE_INFINITY;
			String str = rawData.substring(1, rawData.length()-1);
			String[] str_tuple = str.trim().split(",");


			if (mode == GRAPHMODE.BAR || mode == GRAPHMODE.PIE ){
				s1 = str_tuple[0].trim();
				i2 = Integer.parseInt(str_tuple[1].trim());
				if (s1 != null && i2 != Double.POSITIVE_INFINITY){
					Pair newpair =  new Pair(s1, (int)i2);
					data = dataset.add(newpair);
				}else{
					throw new Exception("DataPair (" + s1 + ", " + i2 + ") does not matched with graph mode.");
				}
			}else{
				i1 = Integer.parseInt(str_tuple[0].trim());
				i2 = Integer.parseInt(str_tuple[1].trim());
				if (i1 != Double.POSITIVE_INFINITY && i2 != Double.POSITIVE_INFINITY){
					Pair newpair = new Pair((int)i1, (int)i2);
					data = dataset.add(newpair);
				}else{
					throw new Exception("DataPair (" + i1 + ", " + i2 + ") does not matched with graph mode.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return dataset;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		System.out.println("paintComponent");
		//      g.drawString(Integer.toString(23), PAD+200, PAD + 400);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int height = getHeight();
		int width = getWidth();
		Graph.getInfo();
		if (mode ==  Console.GRAPHMODE.SCATTER){
//			DimensionalGraph.getInfo();
			ScatterPlot sp = new ScatterPlot(data);
			sp.drawTitle(g2, height, width);
			sp.drawAxis(g2, height, width);
			sp.drawAxisTitle(g2, height, width);
			sp.drawDataset(g2, data, height, width);
			System.out.println("Finish");
			return;
		}else if (mode ==  Console.GRAPHMODE.BAR){
//			DimensionalGraph.getInfo();
			Bar b = new Bar(data);
			b.drawTitle(g2, height, width);
			b.drawAxis(g2, height, width);
			b.drawAxisTitle(g2, height, width);
			b.drawDataset(g2, data, height, width);
			return;
		}else if (mode ==  Console.GRAPHMODE.PIE){
//			ChartGraph.getInfo();
			PieChart p = new PieChart(data);
			p.drawTitle(g2, height, width);
			p.drawDataset(g2, data, height, width);
			p.drawLegend(g2, height, width);
			return;
		}

	
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to MakeAGraph!");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the integer corresponding to graph mode:");
		System.out.println("1. Scatter Plot");
		System.out.println("2. Bar Graph");
		System.out.println("3. Pie Chart");


		int m = sc.nextInt();
		switch (m) {
		case 1: 
			DimensionalGraph.getInfo();
			changeGraphMode(GRAPHMODE.SCATTER);
			break;
		case 2:
			DimensionalGraph.getInfo();
			changeGraphMode(GRAPHMODE.BAR);
			break;
		case 3:
			ChartGraph.getInfo();
			changeGraphMode(GRAPHMODE.PIE);
			break;

		}
		
		System.out.println("Please input the integer number of dataset (>1):");
		int num = sc.nextInt();


		Scanner sc3 = new Scanner(System.in);
		for(int i = 0; i< num; i++){
			System.out.println("Please input dataset in the format of (*, *) <Enter> :");
			String rawData= sc3.nextLine();
			dataset = parseData(rawData);

		}



		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Console c = new Console();
		//		GraphCanvas	gc = new GraphCanvas(data, mode);
		f.add(c);
		f.setSize(800,800);
		//		f.setLocation(200,200);
		f.setVisible(true);





	}



}