package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public interface Figure extends Serializable {

	public void draw(Graphics g);
	
	public Point getP1();
	public Point getP2();
	public Color getColor();
	public boolean getFill();
	
}
