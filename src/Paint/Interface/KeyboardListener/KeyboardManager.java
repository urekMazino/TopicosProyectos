package Paint.Interface.KeyboardListener;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import Paint.Logic.Files.FileManager;
import Paint.Logic.Files.FileManagerImp;

public class KeyboardManager {
	
	private Component comp;
	
	public KeyboardManager(Component comp){
		this.comp = comp;
		comp.setFocusable(true);
	}
	
	public void setUpKey(int keyCode,FileManagerImp fileManager){
		comp.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==keyCode){
					fileManager.saveFile(null);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
		});
	}
	
}
