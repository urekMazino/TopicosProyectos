package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Star extends WHFigure{

	int[] puntosX,puntosY;
	
	public Star(Point p1, Point p2, boolean isFill, Color color) {
		super(p1, p2, isFill, color);
		puntosX = new int[]{minX,minX+(width/3),minX+(width/5),minX+(width/2),minX+(width*4/5),minX+(2*width/3),minX+width,minX+(2*width/3),minX+(width/2),minX+(1*width/3)};
		puntosY = new int[]{minY+(2*height/5),minY+(3*height/5),minY+height,minY+(4*height/5),minY+height,minY+(3*height/5),minY+(2*height/5),minY+(2*height/5),minY,minY+(2*height/5)};
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if (isFill){
			g.fillPolygon(puntosX,puntosY,10);
		} else {
			g.drawPolygon(puntosX,puntosY,10);
		}
	}

}
