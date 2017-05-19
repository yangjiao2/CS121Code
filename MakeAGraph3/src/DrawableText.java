import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.lang.Math;

public class DrawableText implements DrawableObject{
	int startx;
	int starty;
	String text;
	Graphics2D graph;
	
	public DrawableText(Graphics2D g2, int x1, int y1) {
		startx = x1;
		starty = y1;
		graph = g2;
	}

	@Override
	public void draw(){
		graph.drawString(text, startx, starty);
	}

	@Override
	public void setColor(Color color) {
		graph.setColor(color);
	}


}
