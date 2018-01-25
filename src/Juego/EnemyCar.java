package Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class EnemyCar extends GameObjectImp implements CollisionInterface{

	protected Animation currentAnim,explosionAnim;
	private int LIMITE_IZQUIERDO = 166,LIMITE_DERECHO =400;
	protected SpriteManager spriteManager = new SpriteManager();
	private double deltaY=0;
	private double speed=80,driftSpeed =1.5,autoMove=0;
	private int driftCounter=0;
	private boolean drifting=false,dead = false;
	private CollisionBox collisionBox;
	private PlayerCar playerCar;
	
	public EnemyCar(PlayerCar playerCar){
		position.setLocation(247,0);
		try{
			currentAnim = new Animation("res/carro-enemigo-amarillo.png");
			explosionAnim = new Animation("res/explosion1.png","res/explosion2.png","res/explosion3.png");
			explosionAnim.setRepeat(false);
			spriteManager.changeSprite(currentAnim);

		}catch (Exception e){
			e.printStackTrace();
		}
		collisionBox = new CollisionBox(position,spriteManager.getCurrentFrame().getWidth(null),spriteManager.getCurrentFrame().getHeight(null));
		this.playerCar = playerCar;
	}
	
	public void setSpeed(double speed){
		this.speed  =speed;
	}
	
	public void update(){
		spriteManager.update();
		if (dead==true){
			if (spriteManager.getAnimation().getEnded()){
				this.destroy();
			}
		} 
		if (playerCar.isDead()){
			return;
		}
		deltaY = position.getY();

		goDown();
		if (position.getY()>1000 || position.getY()<-120){
			destroy();
		}
		
		if (drifting){
			driftCounter++;
			updatePositionX(autoMove);
			if (driftCounter>30){
				stabilize();
			}
		}
	}
	public void goDown(){
		position.setLocation(position.getX(),position.getY()+(playerCar.getSpeed()-speed)/10);
	}
	
	public void draw(Graphics g){
		spriteManager.draw(g, (int)position.getX(), (int) position.getY());
		g.setColor(Color.RED);
		g.drawRect((int)position.getX(), (int)position.getY(), collisionBox.width, collisionBox.height);
	}

	public void explode(){
		speed = 0;
		dead = true;
		spriteManager.changeSprite(explosionAnim);
	}
	
	private void updatePositionX(double x){
		if (position.x>LIMITE_DERECHO){
			position.setLocation(LIMITE_DERECHO,position.getY());
			if (drifting){
				explode();
			}

		} else if (position.x<LIMITE_IZQUIERDO){
			position.setLocation(LIMITE_IZQUIERDO,position.getY());
			if (drifting){
				explode();
			}

		} else {
			position.setLocation(position.getX()+x,position.getY());

		}
	}
	
	@Override
	public void collision(GameObject other) {
		position.setLocation(position.getX(),deltaY);
		crash(other);
	}
	public void crash(GameObject other){
		if (other.getPosition().getX()>this.position.getX()){
			autoMove=-driftSpeed;
		} else {
			autoMove=driftSpeed;
		}
		drifting = true;
		driftCounter=0;
	}
	protected void stabilize(){
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
