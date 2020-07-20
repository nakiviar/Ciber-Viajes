package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionUsuario;
import model.UsuarioReporte;


public class ComboUsuario extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {	                        
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione un Usuario</option>");	
			
			ArrayList<UsuarioReporte> lista = new GestionUsuario().listado();
			
			for(UsuarioReporte u:lista) {
				out.println("<option value='"+u.getUsuario()+"'>"+u.getUsuario()+" - "+u.getNombre()+" "+u.getApepa()+" "+u.getApema()+"</option>");
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
