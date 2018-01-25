package Paint.Interface.ToolBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import Paint.Logic.Tools.ColorListener;
import Paint.Logic.Tools.ToolManager;

public class ColorSelector extends JButton implements ColorListener{

	public ColorSelector(ToolManager toolManager){
		this.setBackground(Color.BLACK);
		this.setMinimumSize(new Dimension(45, 45));
		this.setPreferredSize(new Dimension(45, 45));
		this.setMaximumSize(new Dimension(45, 45));
		toolManager.addColorListener(this);
		this.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	Color color = JColorChooser.showDialog(ColorSelector.this,"Elige un color",ColorSelector.this.getBackground());
		    	if (color==null){
		    		color = ColorSelector.this.getBackground();
		    	}
		        toolManager.cambioColor(color);
		    }
		});
	}

	@Override
	public void colorChanged(Color color) {
    	ColorSelector.this.setBackground(color);	
	}

	

}
