package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends WHFigure{
	
	public Rectangle(Point p1, Point p2, boolean isFill, Color color) {
		super(p1, p2, isFill, color);
		
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if (isFill){
			g.fillRect(minX, minY, width, height);
		} else {
			g.drawRect(minX, minY, width, height);
		}
		
	}

}
