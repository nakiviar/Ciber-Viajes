package interfaces;

import java.util.ArrayList;

import model.TipoUsuario;
import model.Usuario;
import model.UsuarioPerfil;
import model.UsuarioReporte;

public interface UsuarioInterface {
	
	//metodos -> public
	
	//valide el acceso al sistema
	public UsuarioPerfil validarUsuario(String usuario, String clave);
	
	
	//registrar los datos del nuevo usuario ,actualizar
	public int registrarUsuario(Usuario u);
	
	public int actualizarUsuario(Usuario u);
	
	public int eliminarUsuario(String usu);
	
	public int reactivarUsuario(String usu);
	
	public ArrayList<UsuarioReporte>listado();
	
	public ArrayList<Usuario>listadousueli();
	
	public Usuario buscar(String usu);
	
	public ArrayList<TipoUsuario> listadotipo();
	
	public ArrayList<UsuarioReporte> listadoxtipousu(int tipo);
	
	public String ObteneridUsuario();
	

}
