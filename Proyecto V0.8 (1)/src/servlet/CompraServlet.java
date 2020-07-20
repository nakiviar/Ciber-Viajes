package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionProducto;
import model.Producto;

/**
 * Servlet implementation class CompraServlet
 */
@WebServlet("/productoinfo")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("ingreso al servlet Compra");
		
		String cod=request.getParameter("cod");
		
		Producto p = new GestionProducto().buscar(cod);
		
		request.getSession().setAttribute("p", p);
		
		request.getRequestDispatcher("productocompra.jsp").forward(request, response);
		
	}

}
