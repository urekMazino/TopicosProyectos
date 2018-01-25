package GeneradorCURP.Components;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GeneradorCURP.Components.InputFields.IntTextField;
import GeneradorCURP.Components.InputFields.NameField;

public class InputPanelBuilder {

	public JPanel build(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(300,0));
		
		JLabel nombreLabel = new JLabel("Nombre(s)");
		nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		NameField nombreField = new NameField("nombre");
		panel.add(nombreLabel);
		panel.add(nombreField);
		
		JLabel apellidoPLabel = new JLabel("Apellido Paterno");
		apellidoPLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		NameField apellidoPField = new NameField("apellido paterno");
		panel.add(apellidoPLabel);
		panel.add(apellidoPField);
		
		JLabel apellidoMLabel = new JLabel("Apellido Materno");
		apellidoMLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		NameField apellidoMField = new NameField("apellido materno");
		panel.add(apellidoMLabel);
		panel.add(apellidoMField);
		
		JLabel sexoLabel = new JLabel("Sexo");
		sexoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(sexoLabel);
		
		GenderPicker sexo = new GenderPicker();
		panel.add(sexo);
		
		JLabel fechaLabel = new JLabel("Fecha de nacimiento");
		fechaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(fechaLabel);
		
		DatePicker fecha = new DatePicker();
		panel.add(fecha);
		
		JLabel estadoLabel = new JLabel("Entidad Federativa");
		estadoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(estadoLabel);
		StatePicker estado = new StatePicker();
		panel.add(estado);
		
		panel.add(Box.createVerticalGlue());
		
		JLabel resLabel = new JLabel("");
		Font labelFont = resLabel.getFont();
		resLabel.setForeground(Color.RED);
		resLabel.setOpaque(true);
		resLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 23));
		resLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(resLabel);
		
		panel.add(Box.createVerticalGlue());
		
		JButton enviar = new JButton("Generar");
		enviar.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(enviar);
		
		CurpForm form = new CurpForm();
		form.setEnviar(enviar);
		form.setEstado(estado);
		form.setFecha(fecha);
		form.setName(nombreField);
		form.setLastname(apellidoPField);
		form.setLastname2(apellidoMField);
		form.setSexo(sexo);
		form.setResult(resLabel);
		return panel;
	}
	
}
