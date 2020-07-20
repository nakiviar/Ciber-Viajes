package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionProducto;
import model.ProductoReporte;


public class ComboProductos extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {	                        
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione un Producto</option>");	
			
			ArrayList<ProductoReporte> lista = new GestionProducto().listadoxreporte();
			
			for(ProductoReporte pro:lista) {
				out.println("<option value='"+pro.getIdprod()+"'>"+pro.getIdprod()+" - "+pro.getDescripcion()+"</option>");
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
