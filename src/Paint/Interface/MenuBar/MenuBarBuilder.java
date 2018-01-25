package Paint.Interface.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import Paint.Interface.AboutPane.AboutPane;
import Paint.Logic.Files.FileManager;

public class MenuBarBuilder {

	private JMenuBar menuBar;
	
	public void createMenuBar(){
		menuBar = new JMenuBar();
	}
	public void createFileMenu(FileManager fileManager){
		MenuBuilder menuBuilder = new MenuBuilder();
		menuBuilder.newMenu("Archivo", 'A');
		menuBuilder.newMenuItem("Nuevo", 'N', fileManager.getNewFileImp());
		menuBuilder.newMenuItem("Cargar", 'C', fileManager.getLoadFileImp(menuBar));
		menuBuilder.newMenuItem("Guardar", 'G', fileManager.getSaveFileImp(menuBar));
		menuBuilder.newMenuItem("Guardar Como", 'U', fileManager.getSaveFileAsImp(menuBar));
		menuBar.add(menuBuilder.getMenu());
	}
	public void createHelpMenu(){
		MenuBuilder menuBuilder = new MenuBuilder();
		menuBuilder.newMenu("Ayuda", 'Y');
		menuBuilder.newMenuItem("Acerca", 'A', new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuBar.getParent(),new AboutPane(),"Acerca del programa",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		menuBar.add(menuBuilder.getMenu());
	}
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
}
