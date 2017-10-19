import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class EnemyCar extends GameObjectImp implements CollisionInterface{

	private Image currentImage;
	private double deltaY=0;
	private double speed=80,driftSpeed =1.5,autoMove=0;
	private int driftCounter=0;
	private boolean drifting=false;
	private CollisionBox collisionBox;
	private PlayerCar playerCar;
	
	public EnemyCar(PlayerCar playerCar){
		position.setLocation(247,0);
		try{
			currentImage = new ImageIcon("res/carro-enemigo-amarillo.png").getImage();

		}catch (Exception e){
			e.printStackTrace();
		}
		collisionBox = new CollisionBox(position,currentImage.getWidth(null),currentImage.getHeight(null));
		this.playerCar = playerCar;
	}
	
	public void update(){
		position.setLocation(position.getX(),position.getY()+(playerCar.getSpeed()-speed)/10);
		if (position.getY()>1000 || position.getY()<0){
			position.setLocation(position.getX(), 0);
		}
		if (drifting){
			driftCounter++;
			position.setLocation(position.getX()+autoMove,position.getY());
			if (driftCounter>30){
				stabilize();
			}
		}
		deltaY = position.getY();
	}
	
	
	public void draw(Graphics g){
		g.drawImage(currentImage, (int)position.getX(), (int) position.getY(), null);
		g.setColor(Color.RED);
		g.drawRect((int)position.getX(), (int)position.getY(), collisionBox.width, collisionBox.height);
	}

	@Override
	public void collision(GameObject other) {
		position.setLocation(position.getX(),deltaY);
		crash();
	}
	public void crash(){
		if (playerCar.getPosition().getX()>this.position.getX()){
			autoMove=-driftSpeed;
		} else {
			autoMove=driftSpeed;
		}
		drifting = true;
		driftCounter=0;
	}
	private void stabilize(){
		drifting = false;
		autoMove = 0;
	}
	public double getSpeed(){
		return speed;
	}

	@Override
	public CollisionBox getCollisionBox() {
		return collisionBox;
	}
}
