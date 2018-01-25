package Paint.Logic.Tools;

import java.awt.Color;

public interface ToolManager {

	public void cambioHerramienta(MouseTool tool);
	public void notifyToolChange();
	public void notifyColorChange();
	public void addToolListener(ToolListener newListener);
	public void addColorListener(ColorListener newListener);
	public void cambioColor(Color color);
	
}
