package Paint.Interface.AboutPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPane extends JPanel{
	
	public AboutPane(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel escuela = new JLabel("Instituto Tecnologico de Culiac�n");
		escuela.setFont(new Font("Arial", Font.BOLD, 24));
		escuela.setAlignmentX(CENTER_ALIGNMENT);
		this.add(escuela);
		JLabel nombre = new JLabel("Daniel Carbajal Escamilla");
		nombre.setFont(new Font("Calibri", Font.ITALIC, 20));
		nombre.setAlignmentX(CENTER_ALIGNMENT);
		this.add(nombre);
		JLabel materia = new JLabel("Topicos avanzados de programaci�n");
		materia.setFont(new Font("Times new roman", Font.BOLD, 18));
		materia.setAlignmentX(CENTER_ALIGNMENT);
		this.add(materia);
	}

	
}
