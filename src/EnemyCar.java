import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class EnemyCar extends GameObjectImp implements CollisionInterface{

	private Image img;
	private double speed=5;
	private CollisionBox collisionBox;
	
	public EnemyCar(){
		position.setLocation(247,0);
		try{
			img = new ImageIcon("res/carro-enemigo-amarillo.png").getImage();
		}catch (Exception e){
			e.printStackTrace();
		}
		collisionBox = new CollisionBox(position,img.getWidth(null),img.getHeight(null));
	}
	
	public void update(){
		position.setLocation(position.getX(),position.getY()+speed);
		if (position.getY()>1000){
			position.setLocation(position.getX(), 0);
		}
	}
	
	
	public void draw(Graphics g){
		g.drawImage(img, (int)position.getX(), (int) position.getY(), null);
		g.setColor(Color.RED);
		g.drawRect((int)position.getX(), (int)position.getY(), collisionBox.width, collisionBox.height);
	}

	@Override
	public void collision(GameObject other) {
		System.out.println("Oh shit");
	}

	@Override
	public CollisionBox getCollisionBox() {
		return collisionBox;
	}
}
