package Paint.Interface.ToolBar;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JToolBar;

import Paint.Logic.Tools.ColorListener;
import Paint.Logic.Tools.ToolManager;

public class RecentColorContainer implements ColorListener{

	public ArrayList<Color> recentColors = new ArrayList<>();
	public ArrayList<JButton> buttons = new ArrayList<>();
	private ToolManager toolManager;
	private JToolBar toolBar;
	private int maxColors=10;
	
	public RecentColorContainer(ToolManager toolManager,JToolBar toolBar){
		this.toolBar= toolBar;
		this.toolManager=toolManager;
		toolManager.addColorListener(this);
	}
	
	@Override
	public void colorChanged(Color color) {
		addColor(color);
	}
	
	private void addColor(Color color){
		
		if (recentColors.contains(color)){
			return;
		}
		
		recentColors.add(color);
		addButton(new RecentColor(toolManager,color));
		
		if (recentColors.size()>maxColors){
			recentColors.remove(0);
			removeButton();
		}
	}
	private void addButton(JButton button){
		toolBar.add(button);
		buttons.add(button);
	}
	private void removeButton(){
		toolBar.remove(buttons.get(0));
		buttons.remove(0);
	}
	
}
