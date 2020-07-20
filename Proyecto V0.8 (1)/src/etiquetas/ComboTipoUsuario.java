package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionUsuario;
import model.TipoUsuario;

public class ComboTipoUsuario extends TagSupport{
	
	private int valorcombo;

	public void setValorcombo(int valorcombo) {
		this.valorcombo = valorcombo;
	}
	
	public int doStartTag() throws JspException {
		try {	        
			
			String valor="";
			
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione un Usuario</option>");	
			
			ArrayList<TipoUsuario> lista = new GestionUsuario().listadotipo();
			
			for(TipoUsuario tu:lista) {
				if(tu.getTipousu()==valorcombo)
					valor="selected";
				out.println("<option value='"+tu.getTipousu()+"'"+valor+">"+tu.getDescripcion()+"</option>");
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
