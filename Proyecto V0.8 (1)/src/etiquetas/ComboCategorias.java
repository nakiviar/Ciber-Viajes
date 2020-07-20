package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionCategorias;
import model.Categorias;



public class ComboCategorias extends TagSupport{
	
      private String valorcombo;
	
	  public void setValorcombo(String valorcombo) {
		this.valorcombo = valorcombo;
	 }
	
	 public int doStartTag() throws JspException {
		try {	         
			
			String valor="";
			
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione una Categoria</option>");	
			
			ArrayList<Categorias> lista = new GestionCategorias().listado();
			
			for(Categorias c:lista) {
				if(c.getIdcategoria().equals(valorcombo))
					valor="selected";
				out.println("<option value='"+c.getIdcategoria()+"'"+valor+">"+c.getNombrecat()+"</option>");
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
