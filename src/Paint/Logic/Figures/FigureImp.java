package Paint.Logic.Figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class FigureImp implements Figure{

	protected Point p1,p2;
	protected Color color;
	protected boolean isFill;
	
	public FigureImp(Point p1,Point p2,boolean isFill,Color color){
		this.p1 = p1;
		this.p2 = p2;
		this.isFill = isFill;
		this.color = color;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
	}
	
	public Point getP1(){
		return p1;
	}
	public Point getP2(){
		return p2;
	}
	public Color getColor(){
		return color;
	}
	public boolean getFill(){
		return isFill;
	}
	
}
