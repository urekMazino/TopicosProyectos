import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;

public class PlayerCar extends GameObjectImp{

	private Image img;
	private Point2D.Double position = new Point.Double(247,850);
	private double speed = 0,maxSpeed = 200,acceleration = 1;
	private double moveSpeed = 3.5;
	private int LIMITE_IZQUIERDO = 166,LIMITE_DERECHO =400;
	public PlayerCar(){
		try{
			img = new ImageIcon("res/carrito.png").getImage();
		}catch (Exception e){
			e.printStackTrace();
		}
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
	}
	public double getSpeed(){
		return speed;
	}
}
