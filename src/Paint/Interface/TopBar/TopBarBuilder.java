package Paint.Interface.TopBar;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.Timer;

import Paint.Helpers.PathResolution;
import Paint.Interface.StatusBar.Fecha;
import Paint.Interface.StatusBar.StatusLabel;
import Paint.Interface.ToolBar.ColorSelector;
import Paint.Interface.ToolBar.ToolButtonConfig;
import Paint.Logic.Files.FileManager;
import Paint.Logic.Tools.MouseTool;
import Paint.Logic.Tools.ToolManager;

public class TopBarBuilder {

	private JToolBar topBar;
	
	public void createToolBar(){

		topBar = new JToolBar("TopBar");
		topBar.setFloatable(false);
		topBar.setToolTipText("Barra de archivos");
		topBar.setOrientation(JToolBar.HORIZONTAL);
		topBar.setBackground(new Color(219,219,219));
	
	}
	
	public void setUpButtons(FileManager fileManager){
		
		newFileButton(fileManager);
		loadFileButton(fileManager);
		saveFileButton(fileManager);
		
	}
	public void newFileButton(FileManager fileManager){
		addButton(fileManager,"nuevo",fileManager.getNewFileImp());
	}
	public void saveFileButton(FileManager fileManager){
		addButton(fileManager,"guardar",fileManager.getSaveFileImp(topBar));
	}
	public void loadFileButton(FileManager fileManager){
		addButton(fileManager,"abrir",fileManager.getLoadFileImp(topBar));
	}
	
	private void addButton(FileManager fileManager,String iconName,ActionListener listener){
		JButton button = new JButton();

		Image icon = PathResolution.getIcon(iconName+".png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(icon));
		button.setToolTipText(iconName);
		
		button.addActionListener(listener);
		
		topBar.add(button);
	}
	
	public JToolBar getTopBar(){
		return topBar;
	}
	
}
