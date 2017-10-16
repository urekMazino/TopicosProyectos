import java.awt.event.KeyEvent;

public class Input {
	
	private static KeyEvent event;
	
	public static void updateInput(KeyEvent e){
		event = e;
	}
	public static KeyEvent getInput(){
		return event;
	}
}
