package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionProveedor;
import model.Proveedor;


public class ComboProveedoresEli extends TagSupport{
	
	public int doStartTag() throws JspException {
		try {	         
						
			JspWriter out = pageContext.getOut(); 
		
			out.println("<option value='0'>Seleccione una Categoria</option>");	
			
			ArrayList<Proveedor> lista = new GestionProveedor().listadoproveli();
			
			for(Proveedor pr:lista) {
				out.println("<option value='" + pr.getIdproveedor() + "' >" +pr.getIdproveedor()+" - "+pr.getNomemp()+"</option>");
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
