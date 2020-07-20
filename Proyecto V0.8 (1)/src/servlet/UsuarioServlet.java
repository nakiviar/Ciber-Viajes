package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mantenimientos.GestionUsuario;

import model.Usuario;
import model.UsuarioPerfil;
import model.UsuarioReporte;

/**
 * Servlet implementation class UsuarioServlet
 */

/*
 * @WebSerlet -> configura el alias del servlet se usan : <form action="alias"
 * <a href=""
 */

@WebServlet("/CrudUsr")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variable para determinar la accion a realizar
		String opcion = request.getParameter("opcion"); // "opcion" viene del jsp
		System.out.println("Opcion :" + opcion);
		// segun el valor de opcion haremos ...
		switch (opcion) { // cada metodo funciona con service()
		case "reg":
			registrar(request, response);
			break;
		case "reg-usuario":
			registrarusuariologin(request,response);
		case "log":
			loguear(request, response);
			break;
		case "bususu":
			buscar(request, response);
			break;	
		case "act":
			actualizar(request, response);
			break;
		case "act-perfil":
			actualizarperfil(request, response);
			break;	
		case "eli":
			eliminar(request, response);
			break;
		case "listar":
			listar(request,response);
			break;
		case "listatipousu":
			listarusuxtipo(request,response);
			break;
		default:
			break;

		}

	}

	private void registrarusuariologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Ingreso al Servlet Registro-login");
		
		String usuario,clave,nombre,apellidopa,apellidoma,fechanac,correo,direccion,telefono,mensaje,url;
		int iddistrito,idtipousu;
		boolean estado;
		
		usuario=request.getParameter("usu");
		clave=request.getParameter("clave");
		nombre=request.getParameter("nom");
		apellidopa=request.getParameter("apepa");
		apellidoma=request.getParameter("apema");
		fechanac=request.getParameter("fecna");
		correo=request.getParameter("correo");
		direccion=request.getParameter("dir");
		iddistrito=Integer.parseInt(request.getParameter("cbodis"));
		telefono=request.getParameter("tele");
		idtipousu=2;
		estado=true;
	
		System.out.println("Usu:"+usuario+"Clave:"+clave+"Nom:"+nombre+"Apepa:"+apellidopa+"Apema:"+apellidoma+
				"Fecha:"+fechanac+"Correo:"+correo+"Direccion:"+direccion+"Telefono:"+telefono+"Distrito:"+iddistrito+"Tipo de usuario:"+idtipousu);
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario);
		u.setClave(clave);
		u.setNombre(nombre);
        u.setApepa(apellidopa);
        u.setApema(apellidoma);
        u.setFechanac(fechanac);
        u.setCorreo(correo);
        u.setDireccion(direccion);
        u.setTelefono(telefono);
        u.setIddistrito(iddistrito);
        u.setTipousu(idtipousu);
        u.setEstado(estado);
		
		int ok = new GestionUsuario().registrarUsuario(u);
		
		if(ok==0) {
			mensaje="Error al registrar";
			url="/registro_usuario.jsp";
		}else {
			mensaje="Registro exitoso";
			url="/login.jsp";
		}
		
		request.setAttribute("aviso2",mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void actualizarperfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Ingreso al Servlet Actualizar");
		
		String usuario,clave,nombre,apellidopa,apellidoma,fechanac,correo,direccion,telefono,mensaje,url;
		int iddistrito,idtipousu;
		boolean estado;
		
		usuario=request.getParameter("usu");
		clave=request.getParameter("clave");
		nombre=request.getParameter("nom");
		apellidopa=request.getParameter("apepa");
		apellidoma=request.getParameter("apema");
		fechanac=request.getParameter("fecha");
		correo=request.getParameter("correo");
		direccion=request.getParameter("dire");
		iddistrito=Integer.parseInt(request.getParameter("cbodis"));
		telefono=request.getParameter("tele");
		idtipousu=2;
		estado=true;
	
		System.out.println("Usu:"+usuario+"Clave:"+clave+"Nom:"+nombre+"Apepa:"+apellidopa+"Apema:"+apellidoma+
				"Fecha:"+fechanac+"Correo:"+correo+"Direccion:"+direccion+"Telefono:"+telefono+"Distrito:"+iddistrito+"Tipo de usuario:"+idtipousu);
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario);
		u.setClave(clave);
		u.setNombre(nombre);
        u.setApepa(apellidopa);
        u.setApema(apellidoma);
        u.setFechanac(fechanac);
        u.setCorreo(correo);
        u.setDireccion(direccion);
        u.setTelefono(telefono);
        u.setIddistrito(iddistrito);
        u.setTipousu(idtipousu);
        u.setEstado(estado);
		
		int ok = new GestionUsuario().actualizarUsuario(u);
		
		if(ok==0) {
			mensaje="Error al actualizar";
			url="/actualizar-perfil-usuario.jsp";
		}else {
			mensaje="Actualizacion exitosa";
			url="/principal_usuario.jsp";
		}
		
		request.setAttribute("aviso2",mensaje);
		request.getRequestDispatcher(url).forward(request, response);

		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ingreso al Servlet Busqueda-Usuario");

		String idusu, mensaje, url;
		idusu = request.getParameter("cod");

		Usuario u = new GestionUsuario().buscar(idusu);

		if (u != null) {
			mensaje = "Producto encontrado";
			url = "/actualizar-usuarios.jsp";

			request.setAttribute("usu", u.getUsuario());
			request.setAttribute("clave", u.getClave());
            request.setAttribute("nom", u.getNombre());
            request.setAttribute("apepa", u.getApepa());
            request.setAttribute("apema", u.getApema());
            request.setAttribute("fecha", u.getFechanac());
            request.setAttribute("correo", u.getCorreo());
            request.setAttribute("dire", u.getDireccion());
            request.setAttribute("iddis", u.getIddistrito());
            request.setAttribute("tele", u.getTelefono());
            request.setAttribute("tipo", u.getTipousu());

		} else {
			mensaje = "Error al seleccionar producto ";
			url = "/actualizar-productos.jsp";
		}

		request.setAttribute("aviso", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void listarusuxtipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
        System.out.println("Entro al servlet Usuario-listadoxtipo");
		
		String mensaje="",url="/listado-usuarios.jsp";
		int tipo=Integer.parseInt(request.getParameter("cbotipo"));
		
		ArrayList<UsuarioReporte>lista= new GestionUsuario().listadoxtipousu(tipo);
		
		if(lista==null) {
			mensaje="No hay usuarios de ese tipo";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet Usuario-listado");
		
		String mensaje="",url="/listado-usuarios.jsp";
		
		ArrayList<UsuarioReporte>lista= new GestionUsuario().listado();
		
		if(lista==null) {
			mensaje="No hay usuarios";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("listado", lista);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void loguear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// aqui es el procesar
		System.out.println("Ingreso al Servlet Usuario");
		// variables
		String usuario, clave, mensaje, url;
		// entradas
		// datos enviados del jsp(request)
		// como parametros -> JSP name
		usuario = request.getParameter("usuario");
		clave = request.getParameter("clave");

		System.out.println("Usu: " + usuario + " - Clave:" + clave);
		// procesos
		// validacion con datos fijos
		// if(usuario.equals("admin@ibm.pe")&&clave.equals("A12345678")) {

		// validacion con base de datos
		UsuarioPerfil up = new GestionUsuario().validarUsuario(usuario, clave);
		System.out.println(up);

		if (up == null ) {
			mensaje = "Usuario o clave erroneo";
			url = "/login.jsp";
		} else if(up.getTipousu()!=2){
			mensaje = "Bienvenido ADMIN";
			url = "/principal_admin.jsp";
		}else {
			mensaje="Bienvenido Cliente";
			url="/principal_usuario.jsp";
		}
		request.setAttribute("aviso", mensaje);
		request.getSession().setAttribute("up", up);
		// enviar a la pagina -> dispatcher
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("Ingreso al Servlet Registro");
		
		String usuario,clave,nombre,apellidopa,apellidoma,fechanac,correo,direccion,telefono,mensaje,url;
		int iddistrito,idtipousu;
		boolean estado;
		
		usuario=request.getParameter("usu");
		clave=request.getParameter("clave");
		nombre=request.getParameter("nom");
		apellidopa=request.getParameter("apepa");
		apellidoma=request.getParameter("apema");
		fechanac=request.getParameter("fecna");
		correo=request.getParameter("correo");
		direccion=request.getParameter("dir");
		iddistrito=Integer.parseInt(request.getParameter("cbodis"));
		telefono=request.getParameter("tele");
		idtipousu=Integer.parseInt(request.getParameter("cbotipo"));
		estado=true;
	
		System.out.println("Usu:"+usuario+"Clave:"+clave+"Nom:"+nombre+"Apepa:"+apellidopa+"Apema:"+apellidoma+
				"Fecha:"+fechanac+"Correo:"+correo+"Direccion:"+direccion+"Telefono:"+telefono+"Distrito:"+iddistrito+"Tipo de usuario:"+idtipousu);
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario);
		u.setClave(clave);
		u.setNombre(nombre);
        u.setApepa(apellidopa);
        u.setApema(apellidoma);
        u.setFechanac(fechanac);
        u.setCorreo(correo);
        u.setDireccion(direccion);
        u.setTelefono(telefono);
        u.setIddistrito(iddistrito);
        u.setTipousu(idtipousu);
        u.setEstado(estado);
		
		int ok = new GestionUsuario().registrarUsuario(u);
		
		if(ok==0) {
			mensaje="Error al registrar";
			url="/registrar-usuario-admin.jsp";
		}else {
			mensaje="Registro exitoso";
			url="/listado-usuarios.jsp";
		}
		
		request.setAttribute("aviso2",mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Ingreso al Servlet Actualizar");
		
		String usuario,clave,nombre,apellidopa,apellidoma,fechanac,correo,direccion,telefono,mensaje,url;
		int iddistrito,idtipousu;
		boolean estado;
		
		usuario=request.getParameter("usu");
		clave=request.getParameter("clave");
		nombre=request.getParameter("nom");
		apellidopa=request.getParameter("apepa");
		apellidoma=request.getParameter("apema");
		fechanac=request.getParameter("fecna");
		correo=request.getParameter("correo");
		direccion=request.getParameter("dire");
		iddistrito=Integer.parseInt(request.getParameter("cbodis"));
		telefono=request.getParameter("tele");
		idtipousu=Integer.parseInt(request.getParameter("cbotipo"));
		estado=true;
	
		System.out.println("Usu:"+usuario+"Clave:"+clave+"Nom:"+nombre+"Apepa:"+apellidopa+"Apema:"+apellidoma+
				"Fecha:"+fechanac+"Correo:"+correo+"Direccion:"+direccion+"Telefono:"+telefono+"Distrito:"+iddistrito+"Tipo de usuario:"+idtipousu);
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario);
		u.setClave(clave);
		u.setNombre(nombre);
        u.setApepa(apellidopa);
        u.setApema(apellidoma);
        u.setFechanac(fechanac);
        u.setCorreo(correo);
        u.setDireccion(direccion);
        u.setTelefono(telefono);
        u.setIddistrito(iddistrito);
        u.setTipousu(idtipousu);
        u.setEstado(estado);
		
		int ok = new GestionUsuario().actualizarUsuario(u);
		
		if(ok==0) {
			mensaje="Error al actualizar";
			url="/actualizar-usuario.jsp";
		}else {
			mensaje="Actualizacion exitosa";
			url="/listado-usuarios.jsp";
		}
		
		request.setAttribute("aviso2",mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entro al servlet eliminar usuario");
		
		String idusuario,mensaje,url;
		idusuario=request.getParameter("cod");
		
		int ok=new GestionUsuario().eliminarUsuario(idusuario);
		
		if(ok==0) {
			mensaje="Error al eliminar";
			url="/eliminar-usuario.jsp";
		}else {
			mensaje="Usuario eliminado";
			url="/listado-usuarios.jsp";
		}
		
		request.setAttribute("aviso2", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
