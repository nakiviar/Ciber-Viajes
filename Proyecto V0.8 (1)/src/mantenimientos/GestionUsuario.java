package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioPerfil;
import model.UsuarioReporte;
import utils.MySQLConexion;

// implementa la interfaz
public class GestionUsuario implements UsuarioInterface {

	@Override
	public UsuarioPerfil validarUsuario(String usuario, String clave) {
		UsuarioPerfil up = null; // valor por default si no encuentra el usuario
 		// Plantilla BD
		Connection con = null;
		PreparedStatement pst = null;
		//--para consultas no olvidar
		ResultSet rs= null;
        try {
        	con = MySQLConexion.getConexion();
        	// String sql = "select * from ... where ... "
        	String sql= "{CALL usp_validaAcceso5 (?,?)}";
        	pst= con.prepareStatement(sql);
        	pst.setString(1, usuario);
        	pst.setString(2, clave);
        	
        	rs = pst.executeQuery(); // cuidado
        	
        	if(rs.next()) { //si hay informacion en rs
        		up = new UsuarioPerfil();
        		up.setUsuario(usuario);
        		up.setClave(clave);
        		up.setNombre(rs.getString(3));
        		up.setApepa(rs.getString(4));
        		up.setApema(rs.getString(5));
        		up.setFecha(rs.getString(6));
        		up.setCorreo(rs.getString(7));
        		up.setDireccion(rs.getString(8));
        		up.setIddistrito(rs.getInt(9));
        		up.setDistrito(rs.getString(10));
        		up.setTelefono(rs.getString(11));
        		up.setTipousu(rs.getInt(12));
        		    	
        	}
			
		} catch (Exception e) {
			System.out.println("Error en la Validar:" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}

		return up;
	}

	@Override
	//registrar ,actualizar eliminar no llevan REsulset
	public int registrarUsuario(Usuario u) {
		int rs=0; // valor x default -> registro 
		// plantilla
		Connection con = null;
		PreparedStatement pst = null;
		//--para consultas no olvidar
        try {
        	con = MySQLConexion.getConexion();
        	// String sql = "select * from ... where ... "
        	String sql= "insert into tb_usuarios values(?,?,?,?,?,?,?,?,?,?,?,?)";
        	pst= con.prepareStatement(sql);
        	pst.setString(1, u.getUsuario());
            pst.setString(2, u.getClave());
            pst.setString(3	, u.getNombre());
            pst.setString(4, u.getApepa());
            pst.setString(5, u.getApema());
            pst.setString(6, u.getFechanac());
            pst.setString(7, u.getCorreo());
            pst.setString(8, u.getDireccion());
            pst.setInt(9, u.getIddistrito());
            pst.setString(10, u.getTelefono());
            pst.setInt(11, u.getTipousu());
        	pst.setBoolean(12, u.isEstado());
            
        	rs = pst.executeUpdate(); // cuidado
        	
			
		} catch (Exception e) {
			System.out.println("Error en la Validar:" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public ArrayList<UsuarioReporte> listado() {
		
       ArrayList<UsuarioReporte> lista=new ArrayList<UsuarioReporte>();
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="{call usp_UsuarioRe()}";
			pst=con.prepareStatement(slq);

			rs=pst.executeQuery();
			
			while(rs.next()) {
				UsuarioReporte u=new UsuarioReporte();
				u.setUsuario(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApepa(rs.getString(3));
				u.setApema(rs.getString(4));
				u.setFechanac(rs.getString(5));
				u.setCorreo(rs.getString(6));
				u.setDireccion(rs.getString(7));
				u.setDistrito(rs.getString(8));;
				u.setTelefono(rs.getString(9));
                u.setTipo(rs.getString(10));;
				lista.add(u);
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return lista;
	}

	@Override
	public Usuario buscar(String usu) {
		
		Usuario u = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_usuarios where idusuario=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usu);

			rs = pst.executeQuery();

			while (rs.next()) {
				u = new Usuario();
				u.setUsuario(usu);;
				u.setClave(rs.getString(2));
				u.setNombre(rs.getString(3));
				u.setApepa(rs.getString(4));
				u.setApema(rs.getString(5));
				u.setFechanac(rs.getString(6));
				u.setCorreo(rs.getString(7));
				u.setDireccion(rs.getString(8));
				u.setIddistrito(rs.getInt(9));
				u.setTelefono(rs.getString(10));
				u.setTipousu(rs.getInt(11));
				u.setEstado(rs.getBoolean(12));

								
			}

		} catch (Exception e) {
			System.out.println("Error en la busqueda:" + e.getMessage());

		} finally {
			MySQLConexion.closeConexion(con);
		}

		return u;
	}

	@Override
	public ArrayList<TipoUsuario> listadotipo() {
		
        ArrayList<TipoUsuario> lista=new ArrayList<TipoUsuario>();
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="select * from tb_tipo_usu";
			pst=con.prepareStatement(slq);

			rs=pst.executeQuery();
			
			while(rs.next()) {
				TipoUsuario tu=new TipoUsuario();
				tu.setTipousu(rs.getInt(1));;
				tu.setDescripcion(rs.getString(2));;
	
				lista.add(tu);
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return lista;
	}

	@Override
	public ArrayList<UsuarioReporte> listadoxtipousu(int tipo) {
		
        ArrayList<UsuarioReporte> lista=new ArrayList<UsuarioReporte>();
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="call usp_UsuarioRextipo(?)";
			pst=con.prepareStatement(slq);
            pst.setInt(1, tipo);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				UsuarioReporte u=new UsuarioReporte();
				u.setUsuario(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApepa(rs.getString(3));
				u.setApema(rs.getString(4));
				u.setFechanac(rs.getString(5));
				u.setCorreo(rs.getString(6));
				u.setDireccion(rs.getString(7));
				u.setDistrito(rs.getString(8));;
				u.setTelefono(rs.getString(9));
                u.setTipo(rs.getString(10));;
				lista.add(u);
	
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return lista;
	}

	@Override
	public String ObteneridUsuario() {

		String idUsuario="U"; 
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="SELECT COUNT(*) as numero FROM tb_usuarios";
			pst=con.prepareStatement(slq);

			rs=pst.executeQuery();
			
			while(rs.next()) {
				idUsuario=idUsuario+String.format("%04d", rs.getInt("numero"));//probar con 1
				
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return idUsuario;
	}

	@Override
	public int actualizarUsuario(Usuario u) {
		
		int rs=0; // valor x default -> registro 
		// plantilla
		Connection con = null;
		PreparedStatement pst = null;
		//--para consultas no olvidar
        try {
        	con = MySQLConexion.getConexion();
        	// String sql = "select * from ... where ... "
        	String sql= "update tb_usuarios set clave=?,nombreusu=?,apepaterno=?,apematerno=?,fechanac=?,correo=?,direccion=?,iddistrito=?,telefono=?,idtipousu=? where idusuario=?";
        	pst= con.prepareStatement(sql);
            pst.setString(1, u.getClave());
            pst.setString(2	, u.getNombre());
            pst.setString(3, u.getApepa());
            pst.setString(4, u.getApema());
            pst.setString(5, u.getFechanac());
            pst.setString(6, u.getCorreo());
            pst.setString(7, u.getDireccion());
            pst.setInt(8, u.getIddistrito());
            pst.setString(9, u.getTelefono());
            pst.setInt(10, u.getTipousu());
            pst.setString(11, u.getUsuario());
      
        	rs = pst.executeUpdate(); // cuidado
        	
			
		} catch (Exception e) {
			System.out.println("Error en la Validar:" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public int eliminarUsuario(String usu) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_usuarios set estado=? where idusuario=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setString(2, usu);
			
			rs=pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Error al eliminar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public int reactivarUsuario(String usu) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_usuarios set estado=? where idusuario=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setString(2, usu);
			
			rs=pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Error al reactivar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
				
		return rs;
	}

	@Override
	public ArrayList<Usuario> listadousueli() {
	
	      ArrayList<Usuario>lista=new ArrayList<Usuario>();	
	      
	      Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				con = MySQLConexion.getConexion();
				String sql = "select * from tb_usuarios where estado=?";
				pst = con.prepareStatement(sql);
				pst.setBoolean(1, false);
				rs = pst.executeQuery();

				while (rs.next()) {
				   Usuario	u = new Usuario();
					u.setUsuario(rs.getString(1));;
					u.setClave(rs.getString(2));
					u.setNombre(rs.getString(3));
					u.setApepa(rs.getString(4));
					u.setApema(rs.getString(5));
					u.setFechanac(rs.getString(6));
					u.setCorreo(rs.getString(7));
					u.setDireccion(rs.getString(8));
					u.setIddistrito(rs.getInt(9));
					u.setTelefono(rs.getString(10));
					u.setTipousu(rs.getInt(11));
					u.setEstado(rs.getBoolean(12));
					lista.add(u);
				
				}

			} catch (Exception e) {
				System.out.println("Error en listar:" + e.getMessage());

			} finally {
				MySQLConexion.closeConexion(con);
			}
	      
	      
		return lista;
	}

}
