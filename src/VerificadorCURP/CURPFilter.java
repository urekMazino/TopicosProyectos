package VerificadorCURP;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class CURPFilter extends DocumentFilter {
	
	JTextField textField;
	
	public CURPFilter(JTextField textField){
		this.textField = textField;
	}
	   @Override
	   public void insertString(FilterBypass fb, int offset, String string,
	         AttributeSet attr) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.insert(offset, string);

	      if (test(sb.toString())) {
	         super.insertString(fb, offset, string, attr);
	      } else {
	         // warn the user and don't allow the insert
	      }
	      if (testCURP(sb.toString())){
	    	  textField.setBackground(Color.GREEN);
	      } else {
	    	  textField.setBackground(Color.RED);
	      }
	      
	   }
	   private boolean testCURP(String text){
		      return text.matches("^([A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9])([0-9])$");
	   }
	   private boolean test(String text) {
	      return text.matches("^[a-zA-Z0-9]+$");
	   }
	   
	   @Override
	   public void replace(FilterBypass fb, int offset, int length, String text,
	         AttributeSet attrs) throws BadLocationException {

	      Document doc = fb.getDocument();
	      StringBuilder sb = new StringBuilder();
	      sb.append(doc.getText(0, doc.getLength()));
	      sb.replace(offset, offset + length, text);

	      if (test(sb.toString())) {
	         super.replace(fb, offset, length, text.toUpperCase(), attrs);
	      } else {
	         // warn the user and don't allow the insert
	      }
	      if (testCURP(sb.toString())){
	    	  textField.setBackground(Color.GREEN);
	      } else {
	    	  textField.setBackground(Color.RED);
	      }
	   }
	   
	   public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
			      throws BadLocationException {
			    super.remove(fb, offset, length);
			      Document doc = fb.getDocument();
			      StringBuilder sb = new StringBuilder();
			      sb.append(doc.getText(0, doc.getLength()));
			      
			      if (testCURP(sb.toString())){
			    	  textField.setBackground(Color.GREEN);
			      } else {
			    	  textField.setBackground(Color.RED);
			      }
	  }


}
