package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionProveedor;
import model.Proveedor;

/**
 * Servlet implementation class ProveedorServlet
 */
@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion=request.getParameter("opcion");
		
		switch(opcion) {
		case "lista":
		     listapro(request,response);
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
		case "busprov":
			buscar(request, response);
			break;	
		default:
			break;     
		
		}
		
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al Servlet Busqueda");

		String idprov, mensaje, url;
		idprov = request.getParameter("cod");

		Proveedor pr=new GestionProveedor().buscar(idprov);

		if (pr != null) {
			mensaje = "Proveedor encontrado";
			url = "/actualizar-proveedor.jsp";

			request.setAttribute("codigo", pr.getIdproveedor());
			request.setAttribute("empresa", pr.getNomemp());
			request.setAttribute("dueño", pr.getNomdueño());
			request.setAttribute("direccion", pr.getDireccion());
			request.setAttribute("telefono", pr.getTelefono());

		} else {
			mensaje = "Error al seleccionar proveedor ";
			url = "/actualizar-proveedor.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al serlvet eliminar proveedor");

		String idprov, mensaje, url;

		idprov = request.getParameter("cboprov");

		int ok = new GestionProveedor().eliminarProveedor(idprov);

		if (ok == 0) {
			mensaje = "Error al eliminar";
			url = "/eliminar-proveedor.jsp";
		} else {
			mensaje = "Eliminacion exitosa";
			url = "/listado-proveedores.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Entro al serlvet actualizar proveedor");
		
		String idprov,nomemp,nomcargo,direccion,telefono,mensaje,url;
		boolean estado;
		
		idprov=request.getParameter("idprov");
		nomemp=request.getParameter("name");
		nomcargo=request.getParameter("due");
		direccion=request.getParameter("dire");
		telefono=request.getParameter("tele");
		estado=true;
		
		Proveedor pr=new Proveedor();
		pr.setIdproveedor(idprov);
		pr.setNomemp(nomemp);
		pr.setNomdueño(nomcargo);
		pr.setDireccion(direccion);
		pr.setTelefono(telefono);
		pr.setEstado(estado);
		
		int ok= new GestionProveedor().actualizarProveedor(pr);
		
		if (ok == 0) {
			mensaje = "Error al registrar";
			url = "/actualizar-proveedor.jsp";
		} else {
			mensaje = "Registro exitoso";
			url = "/listado-proveedores.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Entro al serlvet registrar proveedor");
		
		String idprov,nomemp,nomcargo,direccion,telefono,mensaje,url;
		boolean estado;
		
		idprov=request.getParameter("cboprov");
		nomemp=request.getParameter("name");
		nomcargo=request.getParameter("due");
		direccion=request.getParameter("dire");
		telefono=request.getParameter("tele");
		estado=true;
		
		Proveedor pr=new Proveedor();
		pr.setIdproveedor(idprov);
		pr.setNomemp(nomemp);
		pr.setNomdueño(nomcargo);
		pr.setDireccion(direccion);
		pr.setTelefono(telefono);
		pr.setEstado(estado);
		
		int ok= new GestionProveedor().registrarProveedor(pr);
		
		if (ok == 0) {
			mensaje = "Error al registrar";
			url = "/registrar-proveedores.jsp";
		} else {
			mensaje = "Registro exitoso";
			url = "/listado-proveedores.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void listapro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet listado de proveedores");
		
		String mensaje="",url="/listado-proveedores.jsp";
		
		ArrayList<Proveedor> lista=new GestionProveedor().listado();
		
		if(lista==null) {
			mensaje="No hay proveedores";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
