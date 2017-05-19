////
////
////import java.io.Console;
////import java.io.*; 
////import java.lang.Math; 
////import java.lang.Boolean; 
////import ptolemy.plot.*;
////	public class Edisc {     
////		public static void main (String args[]) {         
////			Console.myConsole = System.console();    
////			Plot disc = new Plot();     
////			disc.setTitle("Graph of the axial E field from a charged disc");     
////			disc.setXLabel("distance along z");     disc.setYLabel("E field");    
////			PlotFrame myFrame = new PlotFrame("E vs z", disc);     
////			myFrame.setSize(800,600);     
////			int dataSet = 0;         
////			double q = 6.0e-9;   
////			double R  = 10;    
////			double eps = 8.85e-12;               
////			int points = 100;     
////			double E[] = new double[points];     
////			double z[] = new double[points];         
////			for(int i = 0; i < (points-1); i++) {     z[i] = (100*(int)i/points);   
////			double Eqn = q*((2*(Math.PI())*eps*(Math.pow(R,2))))^(-1)*(1 - z[i]*((Math.sqrt((Math.pow(R,2)) + (Math.pow(z[i],2))))))^(-1);    
////			disc.addPoint(dataSet, z[i], Eqn, true);    
////			myFrame.setVisible(true);     } } }
////
////	
////	
////	
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class test extends JPanel {
	int[] data = {
			21, 14, 18, 03, 86, 88, 74, 87, 54, 77,
			61, 55, 48, 60, 49, 36, 38, 27, 20, 18
	};
	final int PAD = 20;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth();
		int h = getHeight();
		// Draw ordinate.
		g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
		// Draw abcissa.
		g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
		double xInc = (double)(w - 2*PAD)/(data.length-1);
		double scale = (double)(h - 2*PAD)/getMax();
		// Mark data points.
		g2.setPaint(Color.red);
		for(int i = 0; i < data.length; i++) {
			double x = PAD + i*xInc;
			double y = h - PAD - scale*data[i];
			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
		}
	}

	private int getMax() {
		int max = -Integer.MAX_VALUE;
		for(int i = 0; i < data.length; i++) {
			if(data[i] > max)
				max = data[i];
		}
		return max;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new test());
		f.setSize(400,400);
		f.setLocation(200,200);
		f.setVisible(true);
	}
}
//
//
//
//
//
//
//
//
//import java.io.*;
//import java.util.*;
//
//public class TestRef {
//	ArrayList<String> lines = new ArrayList<String>();
//	String line= null;
//	public void printThis(){
//		try{
//			FileReader fr = new FileReader("C:\\Users\\nirjari\\Desktop\\all text files\\workflow questions.txt");
//			BufferedReader br = new BufferedReader(fr);
//			FileWriter fw = new FileWriter("C:\\Users\\nirjari\\Desktop\\all text files\\workflow questions_out.txt");
//			PrintWriter out = new PrintWriter(fw);
//			while((line=br.readLine()) != null) {
//				line = line.replace("cgi", "perl");
//				lines.add(line);
//
//			}
//			out.write(lines); // It takes string in the aregument. But when I provide string, the  blank file being returned. With array I get an error "can not find symbol" 
//
//
//		}
//		catch(Exception e){}
//	}
//
//
//
//	FileWriter fstream = new FileWriter(loc, true);
//	BufferedWriter out = new BufferedWriter(fstream);
//
//	out.write("something");
//	out.newLine();