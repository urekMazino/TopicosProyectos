package Facturacion.InterfazGrafica.Panels;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Facturacion.InterfazGrafica.Botones.Botones;
import Facturacion.dataAccessLayer.CatClientes;
import Facturacion.dataAccessLayer.DBCatClientes;

public class PanelClientes extends PanelImp{

	private JTextField txtClave,txtNombre,txtRFC,txtDomicilio;
	private JComboBox<String> cmbStatus;
	private String[] statusStrings;
	public PanelClientes(JFrame frame) {
		super(frame);
	}

	@Override
	public void initPanel() {
		statusStrings= new String[]{ "Activo", "Inactivo"};
		txtClave = new JTextField();
		txtNombre = new JTextField();
		txtRFC = new JTextField();
		txtDomicilio = new JTextField();
		cmbStatus = new JComboBox<String>(statusStrings);
		this.setLayout(new GridLayout(11,1));	
		this.add(new Botones(this));
		this.add(new JLabel("Clave"));
		this.add(txtClave);
		this.add(new JLabel("Nombre"));
		this.add(txtNombre);
		this.add(new JLabel("RFC"));
		this.add(txtRFC);
		this.add(new JLabel("Domicilio"));
		this.add(txtDomicilio);
		this.add(new JLabel("Status"));
		this.add(cmbStatus);
	}
	@Override
	public void leerRegistro(){
		int Clave = Integer.parseInt(txtClave.getText());
		try {
			CatClientes cliente = DBCatClientes.DBLeeRegistro(Clave);
			txtNombre.setText(cliente.getNombre());
			txtRFC.setText(cliente.getRFC());
			txtDomicilio.setText(cliente.getDomicilio());
			setComboBox(cliente.getStatus());
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

	private void setComboBox(String str){
		for (int i=0;i<statusStrings.length;i++){
			if (statusStrings[i].equals(str)){
				cmbStatus.setSelectedIndex(i);
			}
		}
	}
	
	@Override
	public void actualizarRegistro() {
		int CveCte = Integer.parseInt(txtClave.getText());
		String Nombre = txtNombre.getText();
		String RFC = txtRFC.getText();
		String Domicilio = txtDomicilio.getText();
		String Status = cmbStatus.getItemAt(cmbStatus.getSelectedIndex()).substring(0, 1);
		CatClientes reg = new CatClientes(CveCte, Nombre, RFC, Domicilio, Status);
		try {
			DBCatClientes.DBUpdate(reg);
			limpiarCampos();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
		
	}

	@Override
	public
	void nuevoRegistro() {
		int CveCte = Integer.parseInt(txtClave.getText());
		String Nombre = txtNombre.getText();
		String RFC = txtRFC.getText();
		String Domicilio = txtDomicilio.getText();
		String Status = cmbStatus.getItemAt(cmbStatus.getSelectedIndex()).substring(0, 1);		CatClientes reg = new CatClientes(CveCte, Nombre, RFC, Domicilio, Status);
		try {
			DBCatClientes.DBInsert(reg);
			limpiarCampos();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

	@Override
	public void limpiarCampos() {
		txtClave.setText("");
		txtNombre.setText("");
		txtRFC.setText("");
		txtDomicilio.setText("");
		cmbStatus.setSelectedIndex(0);
		txtClave.requestFocus();
		
	}
}

