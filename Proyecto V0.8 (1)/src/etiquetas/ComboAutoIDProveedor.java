package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionCategorias;
import mantenimientos.GestionProveedor;

public class ComboAutoIDProveedor extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {
			
			String idProveedor = new GestionProveedor().ObteneridProveedor();
			
			JspWriter out = pageContext.getOut();
			out.print(idProveedor);
						
		} catch (IOException e) {
			throw new JspException("Error: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		// acciones al finalizar la etiqueta
		return EVAL_PAGE;
	}

}
