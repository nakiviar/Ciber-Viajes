package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionCategorias;

public class ComboAutoIDCategoria extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {
			
			String idCategoria = new GestionCategorias().ObteneridCategoria();
			
			JspWriter out = pageContext.getOut();
			out.print(idCategoria);
						
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
