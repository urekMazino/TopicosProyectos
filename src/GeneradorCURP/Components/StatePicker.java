package GeneradorCURP.Components;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class StatePicker extends JComboBox{
	
	static String[] estados={"Estado","AGUASCALIENTES",
	"BAJA CALIFORNIA",
	"BAJA CALIFORNIA SUR",
	"CAMPECHE",
	"COAHUILA",
	"COLIMA",
	"CHIAPAS",
	"CHIHUAHUA",
	"DISTRITO FEDERAL",
	"DURANGO",
	"GUANAJUATO",
	"GUERRERO",
	"HIDALGO",
	"JALISCO",
	"MEXICO",
	"MICHOACAN",
	"MORELOS",
	"NAYARIT",
	"NUEVO LEON",
	"OAXACA",
	"PUEBLA",
	"QUERETARO",
	"QUINTANA ROO",
	"SAN LUIS POTOS�",
	"SINALOA",  
	"SONORA",
	"TABASCO",
	"TAMAULIPAS",
	"TLAXCALA",
	"VERACRUZ",
	"YUCAT�N",
	"ZACATECAS",
	"NACIO EN EL EXTRANJERO"};
	static String[] claves={"","AS","BC","BS","CC","CL","CM","CS","CH","DF","DG","GT","GR","HG","JC"
	,"MC","MN","MS","NT","NL","OC","PL","QT","QR","SP","SL","SR","TC","TS","TL","VZ","YN","NE"};
	
	public StatePicker(){
		super(estados);
		this.setMaximumSize(new Dimension(200,20));
	}
	public String getClave() throws Exception{
		if (this.getSelectedIndex()==0){
			throw new Exception("Selecciona la entidad federativa");
		}
		System.out.println();
		return claves[this.getSelectedIndex()];
	}
	
	
	
}
