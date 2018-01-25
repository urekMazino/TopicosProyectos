package Paint.Interface.ToolBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.Timer;

import Paint.Helpers.PathResolution;
import Paint.Interface.StatusBar.Fecha;
import Paint.Logic.Tools.MouseTool;
import Paint.Logic.Tools.ToolManager;

public class ToolBarBuilder {

	JToolBar toolBar;
	
	public void createToolBar(){

		toolBar = new JToolBar("ToolBar");
		toolBar.setFloatable(false);
		toolBar.setToolTipText("Herramientas");
		toolBar.setOrientation(JToolBar.VERTICAL);
		toolBar.setBackground(new Color(219,219,219));
		
	
	}
	public void setUpToolButtons(ToolManager toolManager){
		toolBar.add(new JToolBar.Separator());


		MouseTool[] tools = ToolButtonConfig.getMouseTools();
		for (int i=0;i<tools.length;i++){
			addButton(toolManager,tools[i]);
		}
		
		setUpColorSelector(toolManager);
		
		setUpRecentColors(toolManager);
	}
	public void setUpRecentColors(ToolManager toolManager){
		toolBar.add(new JToolBar.Separator());
		RecentColorContainer recentColorContainer = new RecentColorContainer(toolManager,toolBar);
	}
	
	public void setUpColorSelector(ToolManager toolManager){
		ColorSelector colorSelector = new ColorSelector(toolManager);
		colorSelector.setAlignmentX(JToolBar.CENTER);
		
		toolBar.add(new JToolBar.Separator());
//		toolBar.add(new JToolBar.Separator());
//		toolBar.add(new JSeparator(JSeparator.HORIZONTAL));


		toolBar.add(colorSelector);
	}
	private void addButton(ToolManager toolManager,MouseTool tool){
		String toolName = tool.getNombre();
		JButton button = new JButton();

		Image icon = PathResolution.getIcon(toolName+".png").getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(icon));
		button.setToolTipText(toolName);
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				toolManager.cambioHerramienta(tool);
				
			}
			
		});
		
		toolBar.add(button);
	}
	
	public JToolBar getToolBar(){
		return toolBar;
	}
}
