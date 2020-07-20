package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionProveedor;
import model.Proveedor;


public class ComboProveedores extends TagSupport{
	
	 private String valorcombo;
		
	public void setValorcombo(String valorcombo) {
		this.valorcombo = valorcombo;
	}

		public int doStartTag() throws JspException {
			try {	                        
				
				String valor="";
				
				JspWriter out = pageContext.getOut(); 
			
				out.println("<option value='0'>Seleccione un Proveedor</option>");	
				
				ArrayList<Proveedor> lista = new GestionProveedor().listado();
							
				for(Proveedor pr:lista) {
					if(pr.getIdproveedor().equals(valorcombo))
						valor ="selected";
					out.println("<option value='" + pr.getIdproveedor() + "'" + valor + " >" +pr.getIdproveedor()+" - "+pr.getNomemp()+"</option>");
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
