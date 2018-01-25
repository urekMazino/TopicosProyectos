package Facturacion.InterfazGrafica.Panels;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Facturacion.dataAccessLayer.CatClientes;
import Facturacion.dataAccessLayer.CatProductos;
import Facturacion.dataAccessLayer.DBCatClientes;
import Facturacion.dataAccessLayer.DBCatProductos;
import Facturacion.dataAccessLayer.DBFactDeta;
import Facturacion.dataAccessLayer.FactDeta;

public class PanelDetalles extends JScrollPane{
	
	static String[] columnNames = {"#","clave","cant.","Descripcion","precio U.","importe"};
	static String[][] data;
	JTable table;
	DefaultTableModel model;
	PanelTotal facturaTotal;
	PanelFactura panelFactura;
	
	public PanelDetalles(PanelTotal facturaTotal,PanelFactura panelFactura){
		this.panelFactura = panelFactura;
		this.facturaTotal = facturaTotal;
		model = new DefaultTableModel(0, columnNames.length) ;
		model.setColumnIdentifiers(columnNames);
		table = new JTable(model) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return  column == 0||column == 3 || column==4 || column==5 ? false: true;
		    }
		};
//		for (int i=0;i<5;i++){
//			data[i] = new String[]{i+"","1","1","1","1","1"};
//		}
		table.setFillsViewportHeight(true);
		this.setViewportView(table);
		
		Action action = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        TableCellListener tcl = (TableCellListener)e.getSource();
		        if (tcl.getColumn()==1){
		        	cargarProducto(tcl.getNewValue().toString(),tcl.getRow());
		        } else if (tcl.getColumn()==2){
		        	calcularDetalle(tcl.getRow());
		        }
		    }
		};
		table.putClientProperty("terminateEditOnFocusLost", true);
		TableCellListener tcl = new TableCellListener(table, action);
	
	}
	public void calcularDetalle(int fila){
		int cantidad;
		float precioUnitario;
		try{
			cantidad = Integer.parseInt(model.getValueAt(fila, 2).toString());
			precioUnitario = Float.parseFloat(model.getValueAt(fila, 4).toString());
			float importe =precioUnitario*cantidad;
			model.setValueAt(importe, fila, 5);
			facturaTotal.calcular(table);
		}catch(Exception e){
			
		}
	}
	public void leerDetalles(){
		try {
			limpiar();
			ArrayList<FactDeta> detalles = DBFactDeta.DBLeeRegistros(Integer.parseInt(panelFactura.getFolio()));
			for (int i=0;i<detalles.size();i++){
				model.addRow(new Object[]{detalles.get(i).getRenglon()+1,
						detalles.get(i).getCveProd(),
						detalles.get(i).getCantidad(),
						detalles.get(i).getDescripcion(),
						detalles.get(i).getPrecio(),
						detalles.get(i).getImporte()});
			}
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
	void nuevoRegistro(FactDeta reg) {
		try {
			DBFactDeta.DBInsert(reg);
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
	public void actualizarRegistro(int fila,int cantidad,float precio,float importe) {
		
		FactDeta reg;
		int folio = Integer.parseInt(panelFactura.getFolio());
		int renglon = fila;
		try{
			int claveProducto = Integer.parseInt(model.getValueAt(fila, 1).toString());
			String descripcion = model.getValueAt(fila, 3).toString();
			reg = new FactDeta(folio, renglon, cantidad, claveProducto,descripcion,precio,importe, "A");
			try {
				if (!DBFactDeta.DBUpdate(reg)){
					nuevoRegistro(reg);
				}
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,"No se pudo guardar el producto en la base de datos");
		}

		
	}
	public void cargarProducto(String claveProducto,int fila){
		int Clave;
		try{
			Clave = Integer.parseInt(claveProducto);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Clave no es valida");
			return;
		}
		try {
			CatProductos productosCat = DBCatProductos.DBLeeRegistro(Clave);
			model.setValueAt(productosCat.getDescripcion(), fila, 3);
			model.setValueAt(productosCat.getPrecio(), fila, 4);
			if(model.getValueAt(fila, 2).toString().equals("")){
				model.setValueAt("1", fila, 2);
			}
			calcularDetalle(fila);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this,"No se encontro el producto.");
			limpiarDetalle(fila);
			model.setValueAt("", fila, 1);
		} catch (Exception e) {
			
		}
	}
	public void limpiarDetalle(int fila){
		model.setValueAt("", fila, 3);
		model.setValueAt("", fila, 2);
		model.setValueAt("", fila, 4);
		model.setValueAt("", fila, 5);
	}
	public void actualizarDetalles(){
		for (int i=0;i<model.getRowCount();i++){
			try{
				int fila = i;
				int cantidad = Integer.parseInt(model.getValueAt(i, 2).toString());
				float precioUnitario = Float.parseFloat(model.getValueAt(i, 4).toString());
				float importe = Float.parseFloat(model.getValueAt(i, 5).toString());
				actualizarRegistro(fila,cantidad,precioUnitario,importe);
			}catch(Exception e){
				System.out.println("problema con los detalles");
			}
		}
	}
	public JTable getTable(){
		return table;
	}
	
	public void agregarProducto(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{model.getRowCount()+1, "", "","","",""});
		facturaTotal.calcular(table);
	}
	public void limpiar(){
		model.setRowCount(0);
	}
}
