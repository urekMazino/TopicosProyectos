import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

public class LogicaJuego {

	ArrayList<GameObject> gameObjects = new ArrayList();
	PanelJuego panel;
	
	public void ini(PanelJuego panel){
		Timer loop = new Timer();
		this.panel = panel;
	}

	public void run(){
	    long lastLoopTime = System.nanoTime();
	    final int TARGET_FPS = 60;
	    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
	    long lastFpsTime = 0;
	    while(true){
	        long now = System.nanoTime();
	        long updateLength = now - lastLoopTime;
	        lastLoopTime = now;
	        double delta = updateLength / ((double)OPTIMAL_TIME);

	        lastFpsTime += updateLength;
	        if(lastFpsTime >= 1000000000){
	            lastFpsTime = 0;
	        }
	       if (delta>=1){
		       for (int i=0;i<gameObjects.size();i++){
		    	   gameObjects.get(i).update();
		       }
		       panel.redibujar(gameObjects);
	       } 
	       try{
	            Room.gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
	            System.out.println(Room.gameTime);
	            Thread.sleep(Room.gameTime);
	        }catch(Exception e){
	        }
	    }
}
