import java.awt.Graphics;
import java.awt.Image;

public class SpriteManager {
	private int counter=0;
	private Animation animation;
	
	public void update(){
		if (counter>=animation.speed){
			animation.next();
			counter=0;
		}
		counter++;
	}
	
	public void draw(Graphics g,int x, int y){
		animation.draw(g,x,y);
	}

	public  void changeSprite(Animation animation){
		this.animation = animation;
		counter=0;
	}
	public Animation getAnimation(){
		return animation;
	}
	
	public Image getCurrentFrame(){
		return animation.frames[animation.index];
	}
}
