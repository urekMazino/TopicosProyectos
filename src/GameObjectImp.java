import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

public abstract class GameObjectImp implements GameObject{

	protected CollisionBox collisionBox;
	protected Point2D.Double position = new Point.Double(247,850);
	
	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {
		System.out.println("draw!");
		
	}

	

	
}
