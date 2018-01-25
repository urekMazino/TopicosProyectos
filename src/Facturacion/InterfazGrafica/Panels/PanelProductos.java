package Facturacion.InterfazGrafica.Panels;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Facturacion.InterfazGrafica.Botones.Botones;
import Facturacion.dataAccessLayer.CatClientes;
import Facturacion.dataAccessLayer.CatProductos;
import Facturacion.dataAccessLayer.DBCatClientes;
import Facturacion.dataAccessLayer.DBCatProductos;

public class PanelProductos extends PanelImp{

	private JTextField txtClave,txtDescripcion,txtPrecio,txtExistencia;
	private JComboBox<String> cmbStatus;
	private String[] statusStrings;
	public PanelProductos(JFrame frame) {
		super(frame);
	}

	@Override
	public void initPanel() {
		statusStrings= new String[]{ "Activo", "Inactivo"};
		txtClave = new JTextField();
		txtDescripcion = new JTextField();
		txtPrecio = new JTextField();
		txtExistencia = new JTextField();
		cmbStatus = new JComboBox<String>(statusStrings);
		this.setLayout(new GridLayout(11,1));	
		this.add(new Botones(this));
		this.add(new JLabel("Clave"));
		this.add(txtClave);
		this.add(new JLabel("Descripcion"));
		this.add(txtDescripcion);
		this.add(new JLabel("Precio"));
		this.add(txtPrecio);
		this.add(new JLabel("Existencia"));
		this.add(txtExistencia);
		this.add(new JLabel("Status"));
		this.add(cmbStatus);
	}
	@Override
	public void leerRegistro(){
		int Clave = Integer.parseInt(txtClave.getText());
		try {
			CatProductos producto = DBCatProductos.DBLeeRegistro(Clave);			
			txtDescripcion.setText(producto.getDescripcion());
			txtPrecio.setText(""+producto.getPrecio());
			txtExistencia.setText(""+producto.getExistencia());
			setComboBox(producto.getStatus());
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
		int clave = Integer.parseInt(txtClave.getText());
		String descripcion = txtDescripcion.getText();
		float precio = Float.parseFloat(txtPrecio.getText());
		int existencia = Integer.parseInt(txtExistencia.getText());
		String Status = cmbStatus.getItemAt(cmbStatus.getSelectedIndex()).substring(0, 1);
		CatProductos reg = new CatProductos(clave, descripcion, precio, existencia, Status);
		try {
			DBCatProductos.DBUpdate(reg);
			limpiarCampos();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
		
	}

	@Override
	public
	void nuevoRegistro() {
		int clave = Integer.parseInt(txtClave.getText());
		String descripcion = txtDescripcion.getText();
		float precio = Float.parseFloat(txtPrecio.getText());
		int existencia = Integer.parseInt(txtExistencia.getText());
		String Status = cmbStatus.getItemAt(cmbStatus.getSelectedIndex()).substring(0, 1);
		CatProductos reg = new CatProductos(clave, descripcion, precio, existencia, Status);
		try {
			DBCatProductos.DBInsert(reg);
			limpiarCampos();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

	@Override
	public void limpiarCampos() {
		txtClave.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtExistencia.setText("");
		cmbStatus.setSelectedIndex(0);
		txtClave.requestFocus();
		
	}
}

