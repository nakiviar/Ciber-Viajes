package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.CategoriaInterface;
import model.Categorias;
import utils.MySQLConexion;

public class GestionCategorias implements CategoriaInterface{
	
       public ArrayList<Categorias> listado() {
		
		ArrayList<Categorias>lista = new ArrayList<Categorias>();
		
		Connection con =null;
		PreparedStatement pst=null;
		
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="select * from tb_categoria where estado=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, true);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				Categorias c = new Categorias();
				c.setIdcategoria(rs.getString(1));
				c.setNombrecat(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setEstado(rs.getBoolean(4));
				lista.add(c);
					
			}
					
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		
		
		return lista;
	}

	@Override
	public int registrarCategoria(Categorias c) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="insert into tb_categoria values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, c.getIdcategoria());
			pst.setString(2, c.getNombrecat());
			pst.setString(3, c.getDescripcion());
			pst.setBoolean(4, c.isEstado());
			
			rs=pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println("Error en el registro:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public int actualizarCategoria(Categorias c) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_categoria set nombrecategoria=?,descripcion=?  where idcategoria=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, c.getNombrecat());
			pst.setString(2, c.getDescripcion());
			pst.setString(3, c.getIdcategoria());
	
			rs=pst.executeUpdate();
					
		}catch(Exception ex) {
			System.out.println("Error en actualizar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public int eliminarCategoria(String cat) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_categoria set estado=? where idcategoria=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setString(2, cat);
			
			rs=pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println("Error en eliminar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public Categorias buscar(String cat) {
		
		Categorias c=null;
		
		Connection con =null;
		PreparedStatement pst=null;
		
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="select * from tb_categoria where idcategoria=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, cat);
			rs=pst.executeQuery();
			
			while(rs.next()) {
			    c = new Categorias();
				c.setIdcategoria(cat);
				c.setNombrecat(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setEstado(rs.getBoolean(4));
				
			}
					
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return c;
	}

	@Override
	public String ObteneridCategoria() {
		
        String idCategoria="C"; 
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="SELECT COUNT(*) as numero FROM tb_categoria";
			pst=con.prepareStatement(slq);

			rs=pst.executeQuery();
			
			while(rs.next()) {
				idCategoria=idCategoria+String.format("%04d", rs.getInt(1)+1);//probar con 1
				
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return idCategoria;
	}

	@Override
	public int reactivarCategoria(String cat) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_categoria set estado=? where idcategoria=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setString(2, cat);
			
			rs=pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Error al reactivar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
				
		return rs;
	}

	@Override
	public ArrayList<Categorias> listadocateli() {
		
		ArrayList<Categorias>lista=new ArrayList<Categorias>();	
	      
	      Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				con = MySQLConexion.getConexion();
				String sql = "select * from tb_categoria where estado=?";
				pst = con.prepareStatement(sql);
				pst.setBoolean(1, false);
				rs = pst.executeQuery();

				while (rs.next()) {
				    Categorias ca = new Categorias();
		            ca.setIdcategoria(rs.getString(1));
		            ca.setNombrecat(rs.getString(2));
		            ca.setDescripcion(rs.getString(3));
		            ca.setEstado(rs.getBoolean(4));
					lista.add(ca);
				}
			} catch (Exception e) {
				System.out.println("Error en listar:" + e.getMessage());

			} finally {
				MySQLConexion.closeConexion(con);
			}
	      
	      
		return lista;
	}

}
