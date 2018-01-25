package Paint.Interface.ToolBar;

import Paint.Logic.Tools.LineTool;
import Paint.Logic.Tools.MouseTool;
import Paint.Logic.Tools.OvalTool;
import Paint.Logic.Tools.RectangleTool;
import Paint.Logic.Tools.StarTool;
import Paint.Logic.Tools.TriangleTool;

public final class ToolButtonConfig {

	private ToolButtonConfig(){}
	
	private static MouseTool[] tools = {
			new LineTool(),
			new RectangleTool(),
			new OvalTool(),
			new TriangleTool(),
			new StarTool(),
	};
	
	public static MouseTool[] getMouseTools(){
		return tools;
	}
}
