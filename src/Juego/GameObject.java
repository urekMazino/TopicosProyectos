package Juego;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public interface GameObject {

	public void update();
	public void draw(Graphics g);
	public Point2D.Double getPosition();
	public void addController(LogicaJuego a);
}
