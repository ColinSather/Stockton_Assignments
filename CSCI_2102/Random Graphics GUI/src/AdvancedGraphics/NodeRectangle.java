package AdvancedGraphics;
import java.awt.Color;
import java.awt.Graphics;

public class NodeRectangle extends Node {

	// Every subclass of Node must provide implementation 
	// for the draw() method (see below) as well as inheriting the 
	// protected instance variable c for the shape color
	private String name = null;
	private int x = 0;
	private int y = 0;
	private int shapeWidth = 0;
	private int shapeHeight = 0;
	private int plotWidth = 0;
	private int plotHeight = 0;

	public NodeRectangle(String name, int x, int y, int shapeWidth, int shapeHeight, Color c) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.shapeWidth = shapeWidth;
		this.shapeHeight = shapeHeight;
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
		return shapeWidth;
	}
	public int getCoord4() {
		return shapeHeight;
	}
	public String toString() {
		return getName()
			   +", X"+getCoord1()
			   +", Y"+getCoord2()
			   +", W"+getCoord3()
			   +", H"+getCoord4()
			   +", R"+c.getRed()
			   +", G"+c.getGreen()
			   +", B"+c.getBlue();
	}

	public void draw(Graphics g) {
		
		plotWidth = (int) g.getClipBounds().getWidth();
		plotHeight = (int) g.getClipBounds().getHeight();
		
		int dX = x - (shapeWidth / 2) + (plotWidth / 2);
		int dY = y - (shapeHeight / 2) + (plotHeight / 2);
		
		g.setColor(c);
		g.drawRect(dX, dY, shapeWidth, shapeHeight);
				
	}
	
}
