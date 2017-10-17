import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelJuego extends JPanel implements KeyListener{

	ArrayList<GameObject> gameObjects = new ArrayList<>();
	
	public PanelJuego(){
		this.setBackground(Color.black);
		this.setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i=0;i<gameObjects.size();i++){
    	   gameObjects.get(i).draw(g);
       }
	}
	public void redibujar(ArrayList<GameObject> gameObjects){
		this.gameObjects = gameObjects;
		this.paintImmediately(getVisibleRect());
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
