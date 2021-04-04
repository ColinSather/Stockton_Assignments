/*		 _____			   	__	__					______
 *		|				   |   |   |   |   |	   |
 * 		|   __	___  ___  _|_ _|_  	  _|_		   |_____
 * 		|	  |	|	|___|  |   |   |   |   |			 |
 *		|_____|	|	|	|  |   |   |   |   |	   ______|
 *						  
 */						  	

package AdvancedGraphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
public class NodeGraphiti extends Node {
	private String name;
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	
	public NodeGraphiti() {
		
	}
	public NodeGraphiti(String name, int x,int y, int z, int a, Color c) {
		this.name = name;
		this.x1 = x;
		this.y1 = y;
		this.x2 = z;
		this.y2 = a;
		this.c = c;
	}
	public String getName() {
		return name;
	}
	public int getCoord1() {
		return x1;
	}
	public int getCoord2() {
		return x2;
	}
	public int getCoord3() {
		return x2;
	}
	public int getCoord4() {
		return y2;
	}
	// do the same for NodeCircle and Rectangle.
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

	// Override draw() function to draw the graffiti "S" symbol
	@Override
	public void draw(Graphics g) {
		
		// set color and stroke width of new shape
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
		g.fillRect(0, 0, 403, 403);
		g.setColor(c);
		// top portion of graffiti shape /\
		g.drawLine(y1, y1, y2, x1);
		g.drawLine(y1 + 100, y1, y2, x1);
		
		// bottom portion of graffiti shape \/
		g.drawLine(y1, y1 + 100, y2, y2 + 100);
		g.drawLine(y1 + 100, y1 + 100, y2, y2 + 100);
		
		// split left (top to bottom)
		g.drawLine(y1, y1, y1, x2);
		g.drawLine(y1, x1 + 125, y1, y1 + 100);
		
		// split middle (top to bottom) 
		g.drawLine(y2, y1, y2, x2);
		g.drawLine(y2, x1 + 125, y2, y1 + 100);
		
		// right outer most lines of the shape (top to bottom) 
		g.drawLine(y1 + 100, y1, y1 + 100, x2);
		g.drawLine(y1 + 100, x1 + 125, y1 + 100, y1 + 100);
		
		// right most inner slanted connectors (oriented correctly)
		g.drawLine(y2, x1 + 125, y1, x2);
		g.drawLine(200, 175, 250, 225);
		
		// right most outer slanted connector
		g.drawLine(y2+25, x1 + 100, y1 + 100, x2);
		
		// left most outer slanted connector
		g.drawLine(150, 225, 175, 210);
	}
        
}
