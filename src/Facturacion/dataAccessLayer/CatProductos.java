package Facturacion.dataAccessLayer;

/**
 * @author Felipe Muñiz Generado automaticamente por Java Code Generator.
 *         18/10/2017 14:04:59 Clase de datos para la tabla CatProductos
 * 
 */

public class CatProductos {
	private int CveProd; // int(11) NOT NULL,
	private String Descripcion; // varchar(30) NOT NULL,
	private float Precio; // float NOT NULL,
	private int Existencia; // int(11) NOT NULL,
	private String Status; // varchar(1) NOT NULL,

	// Constructor
	public CatProductos(int CveProd, String Descripcion, float Precio, int Existencia, String Status) {
		this.CveProd = CveProd;
		this.Descripcion = Descripcion;
		this.Precio = Precio;
		this.Existencia = Existencia;
		this.Status = Status;
	}

	// Constructor sin parametros
	public CatProductos() {
		this(0, null, 0.0f, 0, null);
	}

	public int getCveProd() {
		return CveProd;
	}

	public void setCveProd(int cveProd) {
		CveProd = cveProd;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		Precio = precio;
	}

	public int getExistencia() {
		return Existencia;
	}

	public void setExistencia(int existencia) {
		Existencia = existencia;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
