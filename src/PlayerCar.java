import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;

public class PlayerCar extends GameObjectImp implements CollisionInterface{

	private Image img;
	private double speed = 0,maxSpeed = 200,acceleration = 1;
	private double moveSpeed = 3.5;
	private int LIMITE_IZQUIERDO = 166,LIMITE_DERECHO =400;
	private CollisionBox collisionBox;
	
	public PlayerCar(){
		position.setLocation(247,750);
		try{
			img = new ImageIcon("res/carrito.png").getImage();
		}catch (Exception e){
			e.printStackTrace();
		}
		collisionBox = new CollisionBox(position,img.getWidth(null),img.getHeight(null));
		collisionBox.width = collisionBox.width-10;
	}
	
	@Override
	public void update(){
		if (speed<maxSpeed){
			speed+=acceleration;
		}
		if (Input.isKey(KeyEvent.VK_LEFT)){
			updatePositionX(-moveSpeed);
		} else if (Input.isKey(KeyEvent.VK_RIGHT)){
			updatePositionX(+moveSpeed);
		}
	}
	private void updatePositionX(double x){
		position.setLocation(Math.min(LIMITE_DERECHO,Math.max(LIMITE_IZQUIERDO, position.getX()+x)),position.getY());
	}
	@Override
	public void draw(Graphics g){
		g.drawImage(img, (int)position.getX(), (int)position.getY(), null);
		g.drawRect((int)position.getX(), (int)position.getY(), collisionBox.width, collisionBox.height);

	}
	public double getSpeed(){
		return speed;
	}

	@Override
	public void collision(GameObject other) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public CollisionBox getCollisionBox(){
		return collisionBox;
	}
}
