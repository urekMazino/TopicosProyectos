import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

public class LogicaJuego  implements Runnable{
	
	long gameTime = 0;
	ArrayList<GameObject> gameObjects = new ArrayList();
	ArrayList<CollisionInterface> collisionBoxes= new ArrayList();
	PanelJuego panel;
	private boolean running = false;
	private final double TARGET_FPS = 60;
	private final double TIME_BETWEEN_FRAMES = 1/TARGET_FPS;
	
	public void ini(PanelJuego panel){
		PlayerCar car = new PlayerCar();
		agregarObjeto(new BackgroundGenerator(car));
		agregarObjeto(new EnemyCar());
		agregarObjeto(car);
		this.panel = panel;
		Input.setPanel(panel);
		runGameLoop();
	}
	public void agregarObjeto(GameObject obj){
		gameObjects.add(obj);
		if (obj instanceof CollisionInterface ){
			collisionBoxes.add((CollisionInterface)obj);
		}
	}

	public void runGameLoop(){
      Thread loop = new Thread(this);
      loop.start();
   }
	
	private void updateGame(){
		
		for (int i=0;i<collisionBoxes.size();i++){
			CollisionInterface thisCollision = collisionBoxes.get(i);
			for (int j=i+1;j<collisionBoxes.size();j++){
				CollisionInterface otherCollision = collisionBoxes.get(j);
				if (thisCollision.getCollisionBox().testCollision(otherCollision.getCollisionBox())){
					thisCollision.collision((GameObject)otherCollision);
					otherCollision.collision((GameObject)thisCollision);
				} 
			}
		}
		
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
		double frames=0,renders=0,updates=0;
		double timeFrames=0;
		boolean segPaso=true;
		while (running){
			render = false;
			
			currentTime = System.nanoTime()/1000000000.0;
			if (segPaso){
				timeFrames = currentTime;
				frames=0;
				updates=0;
				renders=0;
				segPaso = false;
			}
			deltaTime = currentTime - previousTime;
			previousTime = currentTime;
			timeCounter += deltaTime;
			while(timeCounter >= TIME_BETWEEN_FRAMES){
				timeCounter -= TIME_BETWEEN_FRAMES;
				render = true;
				updates++;
				frames++;
//				System.out.println(currentTime-timeFrames);
				if (currentTime-timeFrames>=1){
					segPaso=true;
					System.out.println(frames+" , "+ renders+" , "+updates);
				}
				updateGame();
			}
			if (render){
				renderGame();
				renders++;
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
