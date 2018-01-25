package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Point;

public class WHFigure extends FigureImp{

	protected int width,height,minX,minY;
	
	public WHFigure(Point p1, Point p2, boolean isFill, Color color) {
		super(p1, p2, isFill, color);
		width = Math.abs(p1.x-p2.x);
		height = Math.abs(p1.y-p2.y);
		minX = Math.min(p1.x, p2.x);
		minY = Math.min(p1.y, p2.y);
	}
	
}
