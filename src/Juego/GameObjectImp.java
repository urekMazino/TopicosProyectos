package Juego;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

public abstract class GameObjectImp implements GameObject{

	protected CollisionBox collisionBox;
	protected Point2D.Double position = new Point.Double(247,850);
	protected LogicaJuego controller;
	
	@Override
	public void update() {
	}

	public void addController(LogicaJuego controller){
		this.controller = controller;
	}
	
	@Override
	public void draw(Graphics g) {
		
	}
	
	@Override
	public Point2D.Double getPosition(){
		return position;
	}
	public void destroy(){
		controller.deleteObject(this);
	}
	public void instantiate(GameObject obj){
		controller.agregarObjeto(obj);
	}

	
}
