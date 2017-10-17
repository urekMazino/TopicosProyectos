import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Input {
	
	
	private static final int NUM_KEYS = 256;
	private static boolean[] keys = new boolean[NUM_KEYS];
	private static boolean[] keysLast = new boolean[NUM_KEYS];
	

	public static void setPanel(PanelJuego panel){
		panel.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void keyPressed(KeyEvent e) {
				keys[e.getKeyCode()] = true;				
			}


			@Override
			public void keyReleased(KeyEvent e) {
				keys[e.getKeyCode()] = false;
				
			}
			
		});
	}
	public static void update(){
		System.arraycopy(keys, 0, keysLast, 0, NUM_KEYS);
	}
	public static boolean isKeyUp(int keyCode){
		return !keys[keyCode] && keysLast[keyCode];
	}
	public static boolean isKeyDown(int keyCode){
		return keys[keyCode] && !keysLast[keyCode];
	}
	public static boolean isKey(int keyCode){
		return keys[keyCode];
	}
	
}
