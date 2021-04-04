package AdvancedGraphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class NodeCircle extends Node {

	// Every subclass of Node must provide implementation 
	// for the draw() method (see below) as well as inheriting the 
	// protected instance variable c for the shape color
	private String name = null;
	private int x = 0;
	private int y = 0;
	private int radius = 0;
	private int plotWidth = 0;
	private int plotHeight = 0;
		
	public NodeCircle(String name, int x, int y, int radius, Color c) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.c = c;
	}
	public String getName() {
		return name;
	}
	public int getCoord1() {
		return x;
	}
	public int getCoord2() {
		return y;
	}
	public int getCoord3() {
		return radius;
	}
	public String toString() {
		return getName()
			   +", X"+getCoord1()
			   +", Y"+getCoord2()
			   +", Rad"+getCoord3()
			   +", R"+c.getRed()
			   +", G"+c.getGreen()
			   +", B"+c.getBlue();
	}
	
	public void draw(Graphics g) {
		plotWidth = (int) g.getClipBounds().getWidth();
		plotHeight = (int) g.getClipBounds().getHeight();
		
		int dX = x - radius + (plotWidth / 2);
		int dY = y - radius + (plotHeight / 2);
		
		g.setColor(c);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
		g.drawOval(dX, dY, radius*2, radius*2);
	}
	
}
