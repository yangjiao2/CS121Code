import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawableBar implements DrawableObject{
	int startx;
	int starty;
	int endx;
	int endy;
	Graphics2D graph;
	
	public DrawableBar(Graphics2D g2, int x1, int y1, int x2, int y2) {
		graph = g2;
		startx = x1;
		starty = y1;
		endx = x2;
		endy = y2;	}

	

	@Override
	public void draw() {
		graph.fill(new Rectangle2D.Double(startx, starty, endx, endy));
	}
	
	@Override
	public void setColor(Color color) {
		graph.setColor(color);
	}

}
