package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionProducto;
import model.Producto;
import model.ProductoReporte;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		System.out.println("Opcion:" + opcion);

		switch (opcion) {
		case "reg":
			registrar(request, response);
			break;
		case "act":
			actualizar(request, response);
			break;
		case "eli":
			eliminar(request, response);
			break;
		case "bus":
			buscar(request, response);
			break;
		case "lim":
			limpiar(request, response);
			break;
		case "listar":
			listar(request, response);
			break;
		case "listarxcat2":
			listarxcatre(request,response);
		case "listar-cli":
			listadoparaclientes(request,response);
			break;
		case "listarxcatxcli":
			listadoxcatparaclientes(request,response);
		default:
			break;
		}

	}

	private void listadoxcatparaclientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       System.out.println("Ingreso al servlete de categoria-reporte-clientes");
		
		String url,mensaje="",cat;
		url="/listado-productos-displaytag.jsp";
		cat=request.getParameter("combocat");
		
		ArrayList<ProductoReporte>lista = new GestionProducto().listadoxreportexcat(cat);
		
		if(lista==null) {
			mensaje="No hay productos";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void listadoparaclientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro a la opcion listado-reporte-clientes");

		String url, mensaje = "";
		url = "/listado-productos-displaytag.jsp";

		// obtener el listado de Producto usando la gestion
		ArrayList<ProductoReporte> lista = new GestionProducto().listadoxreporte();

		if (lista == null) {
			mensaje = "No hay productos";
		}

		// enviar el listado al jsp
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listado", lista);
		// ir a la pagina

		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void listarxcatre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al servlete de categoria-reporte");
		
		String url,mensaje="",cat;
		url="/listado-productos.jsp";
		cat=request.getParameter("combocat");
		
		ArrayList<ProductoReporte>lista = new GestionProducto().listadoxreportexcat(cat);
		
		if(lista==null) {
			mensaje="No hay productos";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro a la opcion listado-reporte");

		String url, mensaje = "";
		url = "/listado-productos.jsp";

		// obtener el listado de Producto usando la gestion
		ArrayList<ProductoReporte> lista = new GestionProducto().listadoxreporte();

		if (lista == null) {
			mensaje = "No hay productos";
		}

		// enviar el listado al jsp
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		// ir a la pagina

		request.getRequestDispatcher(url).forward(request, response);
	}

	private void limpiar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url;

		url = "/principal.jsp";

		request.setAttribute("codigo", "");
		request.setAttribute("descripcion", "");
		request.setAttribute("stock", "");
		request.setAttribute("precio", "");
		request.setAttribute("categoria", "");

		request.getRequestDispatcher(url).forward(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Ingreso al Servlet Busqueda");

		String idprod, mensaje, url;
		idprod = request.getParameter("cod");

		Producto p = new GestionProducto().buscar(idprod);

		if (p != null) {
			mensaje = "Producto encontrado";
			url = "/actualizar-productos.jsp";

			request.setAttribute("codigo", p.getIdprod());
			request.setAttribute("descripcion", p.getDescripcion());
			request.setAttribute("idpro", p.getIdprod());
			request.setAttribute("idcat", p.getIdcat());
			request.setAttribute("precio", p.getPrecio());
			request.setAttribute("stock", p.getStock());

		} else {
			mensaje = "Error al seleccionar producto ";
			url = "/actualizar-productos.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Ingreso al serlvet eliminar producto");

		String idproducto, mensaje, url;

		idproducto = request.getParameter("cboprod");

		int ok = new GestionProducto().eliminarpro(idproducto);

		if (ok == 0) {
			mensaje = "Error al eliminar";
			url = "/eliminar-producto.jsp";
		} else {
			mensaje = "Eliminacion exitosa";
			url = "/listado-productos.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Ingreso al servlet actualizar de producto");

		String idprod, descripcion, mensaje, url,idcat,idprov;
		int stock;
		double precio;
		boolean estado;

		idprod = request.getParameter("idprod");
		descripcion = request.getParameter("name");
		stock = Integer.parseInt(request.getParameter("sto"));
		idcat =  request.getParameter("cbocat");
		idprov = request.getParameter("cbopro");
		precio = Double.parseDouble(request.getParameter("pre"));
		estado = true;

		System.out.println("IDproducto:" + idprod + "Descripcion:" + descripcion + "Stock:" + stock + "Idcategoria:"
				+ idcat + "Precio:" + precio + "Estado:" + estado);

		Producto p = new Producto();
		p.setIdprod(idprod);
		p.setDescripcion(descripcion);
        p.setStock(stock);
        p.setIdcat(idcat);
        p.setIdprov(idprov);
		p.setPrecio(precio);
		p.setEstado(estado);

		int ok = new GestionProducto().actualizarpro(p);

		if (ok == 0) {
			mensaje = "Error al actualizar";
			url = "/actualizar-productos.jsp";
		} else {
			mensaje = "Actualizacion exitosa";
			url = "/listado-productos.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Ingreso al servlet registro de producto");

		String idprod, descripcion, mensaje, url,idcat,idprov;
		int stock;
		double precio;
		boolean estado;

		idprod = request.getParameter("idprod");
		descripcion = request.getParameter("name");
		stock = Integer.parseInt(request.getParameter("sto"));
		idcat =  request.getParameter("cbocat");
		idprov = request.getParameter("cbopro");
		precio = Double.parseDouble(request.getParameter("pre"));
		estado = true;

		System.out.println("IDproducto:" + idprod + "Descripcion:" + descripcion + "Stock:" + stock + "Idcategoria:"
				+ idcat + "Precio:" + precio + "Estado:" + estado);

		Producto p = new Producto();
		p.setIdprod(idprod);
		p.setDescripcion(descripcion);
        p.setStock(stock);
        p.setIdcat(idcat);
        p.setIdprov(idprov);
		p.setPrecio(precio);
		p.setEstado(estado);

		int ok = new GestionProducto().registarpro(p);

		if (ok == 0) {
			mensaje = "Error al registrar";
			url = "/registrar-productos.jsp";
		} else {
			mensaje = "Registro exitoso";
			url = "/listado-productos.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
