import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.lang.Math;

public class DrawablePoint implements DrawableObject {
	List<Pair<Double, Double>> data = new ArrayList<Pair<Double, Double>>();
	double x;
	double y;
	double size;
	Graphics2D graph;
	
	public DrawablePoint(int x1, int y1, int size1) {
		
	}

	@Override
	public void draw() {
		graph.fill(new Ellipse2D.Double(x-size/2, y-size/2, size, size));		
	}

	@Override
	public void setColor(Color color) {
		graph.setColor(color);
	}

}
