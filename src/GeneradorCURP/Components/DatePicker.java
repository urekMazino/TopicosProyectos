package GeneradorCURP.Components;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatePicker extends JPanel{
	
	JComboBox mes,dia,anio;
	String[] mesesArr = {"Mes","ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO",
			"SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
	String[] diasArr = new String[32];
	String[] aniosArr = new String[151];
	
	public DatePicker(){
		
		diasArr[0] = "Dia";
		aniosArr[0]="A�o";
		for (int i=1;i<=31;i++){
			diasArr[i] = i+"";
		}
		int contador=1;
		for (int i=2017;i>1867;i--){
			aniosArr[contador++] = i+"";
		}
		mes = new JComboBox(mesesArr);
		dia   = new JComboBox(diasArr);
		anio  = new JComboBox(aniosArr);
		
		this.add(dia);
		this.add(mes);
		this.add(anio);
		this.setMaximumSize(new Dimension(100000,60));
	}
	
	public String getFecha() throws Exception{
		if (dia.getSelectedIndex()==0){
			throw new Exception("Selecciona dia de nacimiento");
		}
		if (mes.getSelectedIndex()==0){
			throw new Exception("Selecciona mes de nacimiento");
		}
		if (anio.getSelectedIndex()==0){
			throw new Exception("Selecciona a�o de nacimiento");
		}
		String fecha = String.format("%s%02d%02d",aniosArr[anio.getSelectedIndex()],mes.getSelectedIndex(),dia.getSelectedIndex());
		System.out.println(fecha.substring(2, 8));
		if (new SimpleDateFormat("yyyyMMdd").parse(fecha).before(new Date())){
			return fecha.substring(2, 8);
		} else {
			throw new Exception("La fecha de nacimiento es invalida");
		}
		
	}
	
	
}
