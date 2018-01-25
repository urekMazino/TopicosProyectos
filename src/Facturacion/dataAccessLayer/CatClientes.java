package Facturacion.dataAccessLayer;

/**
 * @author Felipe Muñiz Generado automaticamente por Java Code Generator.
 *         18/10/2017 13:29:10 Clase de datos para la tabla CatClientes
 * 
 */

public class CatClientes {
	private int CveCte; // int(11) NOT NULL,
	private String Nombre; // varchar(30) NOT NULL,
	private String RFC; // varchar(13) NOT NULL,
	private String Domicilio; // varchar(40) NOT NULL,
	private String Status; // varchar(1) NOT NULL,

	// Constructor
	public CatClientes(int CveCte, String Nombre, String RFC, String Domicilio, String Status) {
		this.CveCte = CveCte;
		this.Nombre = Nombre;
		this.RFC = RFC;
		this.Domicilio = Domicilio;
		this.Status = Status;
	}

	// Constructor sin parametros
	public CatClientes() {
		this(0, null, null, null, null);
	}

	public int getCveCte() {
		return CveCte;
	}

	public void setCveCte(int cveCte) {
		CveCte = cveCte;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
