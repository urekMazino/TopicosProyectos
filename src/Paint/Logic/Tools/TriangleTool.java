package Paint.Logic.Tools;

import java.awt.Color;
import java.awt.Point;

import Paint.Logic.Figures.Figure;
import Paint.Logic.Figures.Rectangle;
import Paint.Logic.Figures.Triangle;

public class TriangleTool implements MouseTool{

	@Override
	public Figure createFigure(Point p1, Point p2, boolean isFill, Color color) {
		return new Triangle(p1,p2,isFill,color);
	}
	@Override
	public String getNombre() {
		return "Triangulo";
	}
}
