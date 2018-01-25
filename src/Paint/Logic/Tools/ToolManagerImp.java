package Paint.Logic.Tools;

import java.awt.Color;
import java.util.ArrayList;

public class ToolManagerImp implements ToolManager{

	private MouseTool currentTool = new LineTool();
	private ArrayList<ToolListener> toolChangeListeners = new ArrayList<>();
	private ArrayList<ColorListener> colorChangeListeners = new ArrayList<>();
	private Color currentColor = Color.BLACK;
	
	@Override
	public void cambioHerramienta(MouseTool tool) {
		currentTool = tool;
		notifyToolChange();
	}

	@Override
	public void notifyToolChange() {
		for(ToolListener listener:toolChangeListeners){
			listener.toolChanged(currentTool);
		}
	}

	@Override
	public void addToolListener(ToolListener newListener) {
		toolChangeListeners.add(newListener);
		newListener.toolChanged(currentTool);
	}

	@Override
	public void cambioColor(Color color) {
		currentColor = color;
		notifyColorChange();
	}
	@Override
	public void notifyColorChange() {
		for(ColorListener listener:colorChangeListeners){
			listener.colorChanged(currentColor);
		}
	}	
	@Override
	public void addColorListener(ColorListener newListener) {
		colorChangeListeners.add(newListener);
		newListener.colorChanged(currentColor);
	}
	

}
