package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionCategorias;
import model.Categorias;


/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion=request.getParameter("opcion");
		
		switch(opcion) {
		case "lista":
			listado(request,response);
			break;
		case "reg":
			registrar(request,response);
			break;
		case "act":
			actualizar(request,response);
			break;
		case "eli":
			eliminar(request,response);
			break;
		case "buscat":
			buscar(request, response);
			break;	
		default:
			break;
		
		
		}
		
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al Servlet Busqueda de Categorias");

		String idcat, mensaje, url;
		idcat = request.getParameter("cbocat");

		Categorias ca = new GestionCategorias().buscar(idcat);

		if (ca != null) {
			mensaje = "Categoria encontrada";
			url = "/actualizar-categorias.jsp";

			request.setAttribute("codigo", ca.getIdcategoria());
			request.setAttribute("nombre", ca.getNombrecat());
			request.setAttribute("descripcion", ca.getDescripcion());


		} else {
			mensaje = "Error al seleccionar categoria ";
			url = "/actualizar-categorias.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al serlvet eliminar categoria");

		String idcat, mensaje, url;

		idcat = request.getParameter("cbocat");

		int ok = new GestionCategorias().eliminarCategoria(idcat);

		if (ok == 0) {
			mensaje = "Error al eliminar";
			url = "/eliminar-categoria.jsp";
		} else {
			mensaje = "Eliminacion exitosa";
			url = "/listado-categorias.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Entro al serlvet actualizar categoria");
		
		String idcat,nombrecat,desccat,mensaje,url;
		boolean estado;
		
		idcat=request.getParameter("idcat");
		nombrecat=request.getParameter("name");
		desccat=request.getParameter("desc");
		estado=true;
		
		Categorias ca=new Categorias();
		ca.setIdcategoria(idcat);
		ca.setNombrecat(nombrecat);
		ca.setDescripcion(desccat);
		ca.setEstado(estado);
		
		int ok= new GestionCategorias().actualizarCategoria(ca);
		
		if (ok == 0) {
			mensaje = "Error al registrar";
			url = "/actualizar-categorias.jsp";
		} else {
			mensaje = "Actualizacion exitosa";
			url = "/listado-categorias.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al serlvet registrar categoria");
		
		String idcat,nombrecat,desccat,mensaje,url;
		boolean estado;
		
		idcat=request.getParameter("cbocat");
		nombrecat=request.getParameter("name");
		desccat=request.getParameter("desc");
		estado=true;
		
		Categorias ca=new Categorias();
		ca.setIdcategoria(idcat);
		ca.setNombrecat(nombrecat);
		ca.setDescripcion(desccat);
		ca.setEstado(estado);
		
		int ok= new GestionCategorias().registrarCategoria(ca);
		
		if (ok == 0) {
			mensaje = "Error al registrar";
			url = "/registrar-categorias.jsp";
		} else {
			mensaje = "Registro exitoso";
			url = "/listado-categorias.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
			
	}


	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet listado de categorias");
		
		String mensaje="",url;
		url="/listado-categorias.jsp";
		
		ArrayList<Categorias> lista=new GestionCategorias().listado();
		
		if(lista==null) {
			mensaje="No hay categorias";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
