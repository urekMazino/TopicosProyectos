import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CollisionBox {

	int width,height;
	Point2D.Double position;
	
	public CollisionBox(Point2D.Double position,int width,int height){
		this.position = position;
		this.width = width;
		this.height = height;
	}
	
	public boolean testCollision(CollisionBox other){
		Point2D.Double position2=new Point2D.Double(position.getX()+width, position.getY()+height),
				otherPosition2 = new Point2D.Double(other.position.getX()+other.width, other.position.getY()+other.height);
		
		if (position.getX()>otherPosition2.getX() || other.position.getX() > position2.getX()){
			return false;
		}
		if (position.getY()>otherPosition2.getY() || other.position.getY() > position2.getY()){
			return false;
		}
		
		return true;
	}

	
}
