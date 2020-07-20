package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionProducto;
import mantenimientos.GestionUsuario;

public class ComboAutoIDProducto extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {
			
			String idProducto = new GestionProducto().ObteneridProducto();
			
			JspWriter out = pageContext.getOut();
			out.print(idProducto);
						
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
