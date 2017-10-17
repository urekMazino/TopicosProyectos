import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

public class LogicaJuego  implements Runnable{
	
	long gameTime = 0;
	ArrayList<GameObject> gameObjects = new ArrayList();
	PanelJuego panel;
	private boolean running = false;
	private final double TARGET_FPS = 60;
	private final double TIME_BETWEEN_FRAMES = 1/TARGET_FPS;
	
	public void ini(PanelJuego panel){
		PlayerCar car = new PlayerCar();
		gameObjects.add(new BackgroundGenerator(car));
		gameObjects.add(car);
		this.panel = panel;
		Input.setPanel(panel);
		runGameLoop();
	}

	public void runGameLoop(){
      Thread loop = new Thread(this);
      loop.start();
   }
	
	private void updateGame(){
		for (int i=0;i<gameObjects.size();i++){
			gameObjects.get(i).update();
		}
		Input.update();
	}
	private void renderGame(){
		panel.redibujar(gameObjects);
	}
	@Override
	public void run() {
		running = true;
		boolean render = false;
		double currentTime = 0;
		double previousTime = System.nanoTime()/1000000000.0;
		double deltaTime = 0;
		double timeCounter = 0;

		while (running){
			render = false;
			
			currentTime = System.nanoTime()/1000000000.0;
			deltaTime = currentTime - previousTime;
			previousTime = currentTime;
			timeCounter += deltaTime;

			while(timeCounter >= TIME_BETWEEN_FRAMES){
				timeCounter -= TIME_BETWEEN_FRAMES;
				render = true;
				
				updateGame();
			}
			if (render){
				renderGame();
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
