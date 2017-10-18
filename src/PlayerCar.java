import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;

public class PlayerCar extends GameObjectImp implements CollisionInterface{

	private Image img;
	private double speed = 0,maxSpeed = 200,acceleration = 1;
	private double moveSpeed = 3.5,driftSpeed = 2;
	private int LIMITE_IZQUIERDO = 166,LIMITE_DERECHO =400;
	private CollisionBox collisionBox;
	private boolean hasControl=true,dead=false;
	private double autoMove = 0;
	private int frameCounter=0;
	
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
		if (dead)
			return;
		if (speed<maxSpeed && hasControl){
			speed+=acceleration;
		}
		if (hasControl){
			input();
		} else {
			updatePositionX(autoMove);
			frameCounter++;
			if (frameCounter>30){
				regainControl();
			}
		}
	}
	private void input(){
		if (Input.isKey(KeyEvent.VK_LEFT)){
			updatePositionX(-moveSpeed);
		} else if (Input.isKey(KeyEvent.VK_RIGHT)){
			updatePositionX(+moveSpeed);
		}
	}
	private void updatePositionX(double x){
		if (position.x>LIMITE_DERECHO){
			position.setLocation(LIMITE_DERECHO,position.getY());
			if (!hasControl){
				explode();
			}

		} else if (position.x<LIMITE_IZQUIERDO){
			position.setLocation(LIMITE_IZQUIERDO,position.getY());
			if (!hasControl){
				explode();
			}

		} else {
			position.setLocation(position.getX()+x,position.getY());

		}
	}
	public void explode(){
		speed = 0;
		dead= true;
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
		if (other instanceof EnemyCar)
			crash((EnemyCar)other);
	}
	
	public void crash(EnemyCar other){
		if (other.getPosition().getX()>this.position.getX()){
			autoMove=-driftSpeed;
		} else {
			autoMove=driftSpeed;
		}
		hasControl = false;
		speed = other.getSpeed();
	}
	
	private void regainControl(){
		hasControl = true;
		autoMove = 0;
		frameCounter =0 ;
		speed = maxSpeed;
	}
	@Override
	public CollisionBox getCollisionBox(){
		return collisionBox;
	}
}
