package Juego;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GasScore extends GameObjectImp{
	
	PlayerCar car;
	
	public GasScore(PlayerCar carro){
		car = carro;
		
	}
	@Override
	public void draw(Graphics g){
		Graphics2D  g2 = (Graphics2D) g;
//		g2.setFont(new Font("TimesRoman", Font.PLAIN, 40));
//		g2.setColor(Color.RED);
//		g2.drawString("Gas: " +car.getGasolina() ,10,40); 

		g2.setColor(Color.BLACK);
		g2.fillRect(10, 60, 40, 400);
		
		g2.setColor(Color.RED);
		int height = (int)(400*(car.getGasolina()/100.0));
		g2.fillRect(10, 60+(400-height), 40, height);

	}
	
}
