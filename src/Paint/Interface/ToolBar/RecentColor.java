package Paint.Interface.ToolBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import Paint.Logic.Tools.ToolManager;

public class RecentColor extends JButton{

	public RecentColor(ToolManager toolManager,Color color){
		this.setBackground(color);
		this.setMinimumSize(new Dimension(25,25));
		this.setPreferredSize(new Dimension(25,25));
		this.setMaximumSize(new Dimension(25,25));
		
		this.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        toolManager.cambioColor(color);
		    }
		});
	}
	
}
