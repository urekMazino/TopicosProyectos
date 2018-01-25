package Facturacion.dataAccessLayer;

/**
 * @author Felipe Muñiz Generado automaticamente por Java Code Generator.
 *         18/10/2017 14:08:01 Clase de datos para la tabla FactEnca
 * 
 */

public class FactEnca {
	private int Folio; // int(11) NOT NULL,
	private String Fecha; // varchar(8) NOT NULL,
	private int CveCte; // int(11) NOT NULL,
	private float SubTotal; // float NOT NULL,
	private float Impuesto; // float NOT NULL,
	private float Total; // float NOT NULL,
	private String Status; // varchar(1) NOT NULL,

	// Constructor
	public FactEnca(int Folio, String Fecha, int CveCte, float SubTotal, float Impuesto, float Total, String Status) {
		this.Folio = Folio;
		this.Fecha = Fecha;
		this.CveCte = CveCte;
		this.SubTotal = SubTotal;
		this.Impuesto = Impuesto;
		this.Total = Total;
		this.Status = Status;
	}

	// Constructor sin parametros
	public FactEnca() {
		this(0, null, 0, 0.0f, 0.0f, 0.0f, null);
	}

	public int getFolio() {
		return Folio;
	}

	public void setFolio(int folio) {
		Folio = folio;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public int getCveCte() {
		return CveCte;
	}

	public void setCveCte(int cveCte) {
		CveCte = cveCte;
	}

	public float getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(float subTotal) {
		SubTotal = subTotal;
	}

	public float getImpuesto() {
		return Impuesto;
	}

	public void setImpuesto(float impuesto) {
		Impuesto = impuesto;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
