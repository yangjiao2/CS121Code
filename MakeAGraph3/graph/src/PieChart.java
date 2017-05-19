import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class PieChart extends ChartGraph{
	
//	private static int x_scale = 5;
//	private static int y_scale = 10;
	private static int startPosition = -4;
	private static int degrees = 0;
	private static ArrayList<String> x_comp = new ArrayList<String>();
	private static ArrayList<Integer> y_comp = new ArrayList<Integer>();
	private static int PAD = GraphCanvas.PAD;
	private static List<Pair> data;
	private static int total_y = 0;
	private static Color[] cols;
	private static int blocksize;
	
	public PieChart(List<Pair> inputdata) {
		this.data = inputdata;
		total_y = 0;
		for(Pair<String, Integer> thispair: data) {
			x_comp.add(thispair.getFirstValue());
			y_comp.add(thispair.getSecondInt());
			total_y += thispair.getSecondInt();
		}
		cols = getUniqueColors(data.size());
	}
	

	public static Color[] getUniqueColors(int amount) {
//	    final int lowerLimit = 0x10;
//	    final int upperLimit = 0xE0;    
//	    final int colorStep = (int) ((upperLimit-lowerLimit)/Math.pow(amount,1f/3));
//
//	    final List<Integer> colors = new ArrayList<Integer>(amount);
//
//	    for (int R = lowerLimit;R < upperLimit; R+=colorStep)
//	        for (int G = lowerLimit;G < upperLimit; G+=colorStep)
//	            for (int B = lowerLimit;B < upperLimit; B+=colorStep) {
//	                if (colors.size() >= amount) { //The calculated step is not very precise, so this safeguard is appropriate
//	                    return colors;
//	                } else {
//	                    int color = (R<<16)+(G<<8)+(B);
//	                    colors.add(color);
//	                }               
//	            }
//	    return colors;
		Color[] cols = new Color[amount];
		for (int i = 0; i < amount; i++)
		    cols[i] = Color.getHSBColor((float) i / amount, 1, 1);
		return cols;
	}
	
	public static void drawLegend(Graphics2D g2, int height, int width){
		int max = 0;
		for (int i = 0; i < data.size(); i++) {
			int temp = data.get(i).getFirstValue().toString().length() * 10;
	        if (temp > max) max = temp;
	     }
		
		for (int i = 0; i < data.size(); i++) {
	        g2.setColor( cols[i] );
	        g2.fillRect(max, 30 + i*20, width/30, 10);
	        g2.setColor( Color.BLACK );
	        g2.drawString(data.get(i).getFirstValue().toString(), 10 ,  40 + i*20);
	     }
	}
	
	public static void drawDataset(Graphics2D g2, List<Pair> data, int height, int width){
		
		g2.setPaint(Color.black);
		
		
		
//		double xInc = (double)(width - 2*PAD)/(ds.getData().size());
//		double scale = (double)(height - 2*PAD)/getMax();
		for(int i = 0; i < data.size(); i++) {
			degrees =(int)(((double)data.get(i).getSecondInt())/((double)total_y) * 360 + 0.5);
			g2.setColor(cols[i]);
			g2.fillArc(PAD, PAD, width - 2*PAD, height - 2*PAD, startPosition, degrees);
			startPosition += degrees;
			
//			double x = PAD + (thispair.getFirstInt())/x_scale * ((width - 2*PAD)/num_x_bar);
////			System.out.println(x);
//			double y = height - PAD - (thispair.getSecondInt())/y_scale * ((height - 2*PAD)/ num_y_bar);
////			System.out.println(y);
//			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
		}
		
		
	}
}
