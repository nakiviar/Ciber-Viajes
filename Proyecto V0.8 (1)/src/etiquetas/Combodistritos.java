package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionDistrito;
import model.Distrito;

public class Combodistritos extends TagSupport {
	
	private int valorcombo;

	public void setValorcombo(int valorcombo) {
		this.valorcombo = valorcombo;
	}

	public int doStartTag() throws JspException {
		try {	                        
			
			String valor="";
			
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione un distrito</option>");	
			
			ArrayList<Distrito> lista = new GestionDistrito().listado();
			
			for(Distrito d:lista) {
			   if(d.getIddis()==valorcombo)
				   //tiene que ser selected para que jale el valor
				   valor="selected";
			    out.println("<option value='"+d.getIddis()+"'"+valor+">"+d.getNombredis()+"</option>");
				valor="";
			}
			
			
		} catch (IOException e) {
		throw new JspException("Error: " + e.getMessage()); 
		}
		return SKIP_BODY;
		}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
