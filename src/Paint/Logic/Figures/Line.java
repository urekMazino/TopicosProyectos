package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends FigureImp{

	public Line(Point p1, Point p2, boolean isFill, Color color) {
		super(p1, p2, isFill, color);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
	

}
