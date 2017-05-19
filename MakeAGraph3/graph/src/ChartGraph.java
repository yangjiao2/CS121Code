import java.awt.Graphics2D;
import java.util.Scanner;
import java.awt.Font;
import java.awt.FontMetrics;

public class ChartGraph extends Graph{
	protected static String x_axis_title;
	protected static String y_axis_title;
//	protected static Pair<Integer, Integer> x_boundaries = new BoundaryPair(ds).getFirstBoundary();
//	protected static Pair<Integer, Integer> y_boundaries = new BoundaryPair(ds).getSecondBoundary();
//	protected static int x_scale;
//	protected static int y_scale;
	// get info
	
	public static void getInfo(){
//		System.out.println("Please provide info for making chart graph:");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("x_axis title:");
//		x_axis_title = sc.nextLine();
//		System.out.println("y_axis title:");
//		y_axis_title = sc.nextLine();
		System.out.println("Please provide info for making graph");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("title:");
		title = sc2.nextLine();
		return;
	}
	
	public static void drawTitle(Graphics2D g2, int height, int width){

		Font fnt = new java.awt.Font("Sanserif", Font.BOLD, 26);
		g2.setFont (fnt);
		g2.drawString(title, width/2-50 - title.length() * 4, 50);
		
		Font fnt1 = new java.awt.Font("Sanserif", Font.BOLD, 16);
		g2.setFont (fnt1);
	}
}
