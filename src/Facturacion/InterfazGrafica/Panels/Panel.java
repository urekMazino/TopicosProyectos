package Facturacion.InterfazGrafica.Panels;

public interface Panel {

	public void nuevoRegistro();
	public void actualizarRegistro();
	public void leerRegistro();
	public void limpiarCampos();
	abstract void initPanel();
	
}
