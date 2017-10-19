import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Animation {
	Image[] frames;
	boolean repeat=true,ended=false;
	int speed = 20,index=0;
	
	public Animation(String...imagenes){
		frames = new Image[imagenes.length];
		for (int i=0;i<imagenes.length;i++){
			frames[i] = new ImageIcon(imagenes[i]).getImage();
		}
	}
	public void next(){
		index++;
		if (index>=frames.length){
			if (!repeat){
				ended = true;
			} else {
				index=0;
			}
		}
	}
	public void draw(Graphics g, int x, int y){
		if (!ended)
			g.drawImage(frames[index], x,y,null);
	}
	public void setRepeat(boolean repeat){
		this.repeat = repeat;
	}
}
