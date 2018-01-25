package Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BackgroundGenerator extends GameObjectImp{

	private Image img;
	private double speed = 0;
	private int position;
	private PlayerCar car;
	public BackgroundGenerator(PlayerCar car){
		this.car = car;
		try{
			img =new ImageIcon("res/fondo.png").getImage();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(){
		this.speed = car.getSpeed()/10;
		position += speed;
		if (position>img.getHeight(null)){
			position-= img.getHeight(null);
		}
	}
	
	@Override
	public void draw(Graphics g){
//		System.out.println(Input.isKey(KeyEvent.VK_A));
		
	
		
		for (int i=-1;i<8;i++){
			g.drawImage(img, 0, i*img.getHeight(null)+position, null);
		}
		
	}
	
}
