package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionCategorias;
import model.Categorias;

public class ComboCategoriasEli extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {	         
						
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione una Categoria</option>");	
			
			ArrayList<Categorias> lista = new GestionCategorias().listadocateli();
			
			for(Categorias c:lista) {
				out.println("<option value='"+c.getIdcategoria()+"'>"+c.getNombrecat()+"</option>");
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
