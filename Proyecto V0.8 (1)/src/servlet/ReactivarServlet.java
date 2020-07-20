package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionCategorias;
import mantenimientos.GestionProducto;
import mantenimientos.GestionProveedor;
import mantenimientos.GestionUsuario;

/**
 * Servlet implementation class ReactivarServlet
 */
@WebServlet("/ReactivarServlet")
public class ReactivarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion=request.getParameter("opcion");
		
		switch(opcion) {
		
		case"reactivar-usu":
			reactivarusuario(request,response);
			break;
		case"reactivar-pro":
			reactivarproducto(request,response);
			break;
		case"reactivar-prov":
			reactivarproveedor(request,response);
			break;
		case"reactivar-cat":
			reactivarcategoria(request,response);
			break;
		default:
			break;
		
		}
		
		
	}


	private void reactivarcategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet reactivar categoria");
		
        String idcat,mensaje,url;
		
		idcat=request.getParameter("cbocateli");
		
       int ok=new GestionCategorias().reactivarCategoria(idcat);
		
		if(ok==0) {
			mensaje="Error al reactivar";
			url="/reactivar.jsp";
		}else {
			mensaje="Categoria reactivada";
			url="/principal_admin.jsp";
		}
		
		request.setAttribute("aviso5", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void reactivarproveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet reactivar proveedor");
		
        String idprov,mensaje,url;
		
		idprov=request.getParameter("cboproveli");
		
       int ok=new GestionProveedor().reactivarProveedor(idprov);
		
		if(ok==0) {
			mensaje="Error al reactivar";
			url="/reactivar.jsp";
		}else {
			mensaje="Proveedor reactivado";
			url="/principal_admin.jsp";
		}
		
		request.setAttribute("aviso4", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void reactivarproducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet reactivar producto");
		
        String idproducto,mensaje,url;
		
		idproducto=request.getParameter("cboproeli");
		
       int ok=new GestionProducto().reactivarProducto(idproducto);
		
		if(ok==0) {
			mensaje="Error al reactivar";
			url="/reactivar.jsp";
		}else {
			mensaje="Producto reactivado";
			url="/principal_admin.jsp";
		}
		
		request.setAttribute("aviso3", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void reactivarusuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet reactivar usuario");
		
		String idusuario,mensaje,url;
		
		idusuario=request.getParameter("cbousueli");
		
       int ok=new GestionUsuario().reactivarUsuario(idusuario);
		
		if(ok==0) {
			mensaje="Error al reactivar";
			url="/reactivar.jsp";
		}else {
			mensaje="Usuario reactivado";
			url="/principal_admin.jsp";
		}
		
		request.setAttribute("aviso2", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
