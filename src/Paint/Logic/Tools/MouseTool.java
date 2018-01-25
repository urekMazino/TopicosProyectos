package Paint.Logic.Tools;

import java.awt.Color;
import java.awt.Point;

import Paint.Logic.Figures.Figure;

public interface MouseTool {
	
	public Figure createFigure(Point p1,Point p2,boolean isFill,Color color);
	public String getNombre();
}
