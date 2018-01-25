package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends WHFigure{

	int[] puntosX,puntosY;
	
	public Triangle(Point p1, Point p2, boolean isFill, Color color) {
		super(p1, p2, isFill, color);
		puntosX = new int[]{minX,minX+width,minX+(width/2)};
		puntosY = new int[]{minY+height,minY+height,minY};
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if (isFill){
			g.fillPolygon(puntosX,puntosY,3);
		} else {
			g.drawPolygon(puntosX,puntosY,3);
		}
	}

}
