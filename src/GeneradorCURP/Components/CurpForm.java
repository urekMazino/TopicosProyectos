package GeneradorCURP.Components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GeneradorCURP.Components.InputFields.NameField;

public class CurpForm {

	NameField name,lastname,lastname2;
	JLabel result;
	DatePicker fecha;
	StatePicker estado;
	GenderPicker sexo;
	JButton enviar;
	
	String nameStr,lastnameStr,lastname2Str,fechaStr,estadoStr,sexoStr;
	
	public void setName(NameField name) {
		this.name = name;
	}
	public void setLastname(NameField lastname) {
		this.lastname = lastname;
	}
	public void setLastname2(NameField lastname2 ) {
		this.lastname2 = lastname2;
	}
	public void setFecha(DatePicker fecha) {
		this.fecha = fecha;
	}
	public void setEstado(StatePicker estado) {
		this.estado = estado;
	}
	public void setSexo(GenderPicker sexo) {
		this.sexo = sexo;
	}
	public void setResult(JLabel result) {
		this.result = result;
	}
	public void setEnviar(JButton enviar) {
		this.enviar = enviar;
		enviar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				validateForm();
			}
			
		});
	}
	private boolean getValues(){
		try{
			nameStr = name.getNombre();
			lastnameStr = lastname.getNombre();
			lastname2Str = lastname2.getNombre();
			sexoStr = sexo.getGender();
			fechaStr = fecha.getFecha();
			estadoStr = estado.getClave();
			return true;
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,
					e.getMessage(),
				    "Error",
				    JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	public void validateForm(){
		getValues();
		String CURP = lastnameStr.substring(0,1);
		String primeraVocal = findRegex(lastnameStr.substring(1,lastnameStr.length()),"([aeiouâãäåæçèéêëìíîïðñòóôõøùúûü])");
		primeraVocal = (primeraVocal.equals(""))?"X":primeraVocal;
		CURP += primeraVocal+lastname2Str.substring(0,1);
		CURP += nameStr.substring(0,1);
		CURP += fechaStr+sexoStr+estadoStr;
		String primeraConsonante = "";
				primeraConsonante = findRegex(lastnameStr.substring(1,lastnameStr.length()),"([^aeiouâãäåæçèéêëìíîïðñòóôõøùúûü])");
		String primeraConsonante2 = "";
			primeraConsonante2 = findRegex(lastname2Str.substring(1,lastname2Str.length()),"([^aeiouâãäåæçèéêëìíîïðñòóôõøùúûü])");
		String primeraConsonante3 = "";
			primeraConsonante3 = findRegex(nameStr.substring(1,nameStr.length()),"([^aeiouâãäåæçèéêëìíîïðñòóôõøùúûü])");
		CURP += primeraConsonante+primeraConsonante2+primeraConsonante3;
		CURP += "00";
		this.result.setText(CURP);
		System.out.println(CURP);
	}
	private String findRegex(String str,String regex){
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    if (matcher.find()) {
	        return String.valueOf(matcher.group(1));
	    }
		return "";
	}
	
}
