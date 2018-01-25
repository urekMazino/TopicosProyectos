package Paint.Interface.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Paint.Logic.Figures.Figure;
import Paint.Logic.Files.FileListener;
import Paint.Logic.Files.FileListenerAdapter;
import Paint.Logic.Files.ImageFile;
import Paint.Logic.Tools.ColorListener;
import Paint.Logic.Tools.MouseTool;
import Paint.Logic.Tools.ToolListener;

public class Canvas extends JPanel implements ColorListener,ToolListener,FileListener{
	
	private Point p1,p2;
	private Color color;
	private MouseTool tool;
	private Figure figuraActual=null;
	private ImageFile file;
	private boolean isFill;
	
	public Canvas(){
		addListeners();
		this.setBackground(Color.WHITE);
	}

	private void addListeners(){
		
		this.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e){
				p1 = new Point(e.getX(),e.getY());
				isFill = !(e.getButton()==MouseEvent.BUTTON1);
			}
			@Override
			public void mouseReleased(MouseEvent e){
				if (figuraActual!=null){
					file.addFigure(figuraActual);
					figuraActual = null;
				}
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				int x=e.getX(),y=e.getY();
				if ((e.getModifiers() & ActionEvent.CTRL_MASK) ==ActionEvent.CTRL_MASK) {
					int signX = (p1.x>x)?1:-1;
					int signY = (p1.y>y)?1:-1;
					int valorMin = Math.min(signX*(p1.x-x), signY*(p1.y-y));
					
					x = p1.x-(valorMin*signX);
					y = p1.y-(valorMin*signY);
				} 
				
				p2 = new Point(x,y);
				figuraActual = tool.createFigure(p1, p2, isFill,color);
				repaint();
			}
		});
		
	}
	

	public void paint(Graphics g){
		super.paint(g);
		drawFigures(g);
		if (figuraActual!=null){
			figuraActual.draw(g);
		}
	}
	
	private void drawFigures(Graphics g){
		for (Figure figura:file.getFigures()){
			figura.draw(g);
		}
	}
	@Override
	public void toolChanged(MouseTool newTool) {
		this.tool = newTool;
		
	}
	@Override
	public void colorChanged(Color color) {
		this.color = color;
	}

	@Override
	public void fileChanged(ImageFile newFile) {
		file = newFile;
		repaint();
	}

	@Override
	public void newFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savedFile(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadedFile(String name) {
		// TODO Auto-generated method stub
		
	}
}
