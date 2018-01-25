package Facturacion.dataAccessLayer;

/**
 * @author Felipe Muñiz Generado automaticamente por Java Code Generator.
 *         18/10/2017 14:11:30 Clase de datos para la tabla FactDeta
 * 
 */

public class FactDeta {
	private int Folio; // int(11) NOT NULL,
	private int Renglon; // int(11) NOT NULL,
	private int Cantidad; // int(11) NOT NULL,
	private int CveProd; // int(11) NOT NULL,
	private float Precio; // float NOT NULL,
	private float Importe; // float NOT NULL,
	private String Descripcion;
	private String Status; // varchar(1) NOT NULL,

	// Constructor
	public FactDeta(int Folio, int Renglon, int Cantidad, int CveProd,String Descripcion, float Precio, float Importe, String Status) {
		this.Folio = Folio;
		this.Renglon = Renglon;
		this.Cantidad = Cantidad;
		this.CveProd = CveProd;
		this.Precio = Precio;
		this.Importe = Importe;
		this.Status = Status;
		this.Descripcion = Descripcion;
	}

	// Constructor sin parametros
	public FactDeta() {
		this(0, 0, 0, 0,"", 0.0f, 0.0f, null);
	}

	public int getFolio() {
		return Folio;
	}

	public void setFolio(int folio) {
		Folio = folio;
	}

	public int getRenglon() {
		return Renglon;
	}

	public void setRenglon(int renglon) {
		Renglon = renglon;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public int getCveProd() {
		return CveProd;
	}

	public void setCveProd(int cveProd) {
		CveProd = cveProd;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		Precio = precio;
	}

	public float getImporte() {
		return Importe;
	}

	public void setImporte(float importe) {
		Importe = importe;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
