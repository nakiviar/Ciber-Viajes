package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ProveedorInterface;
import model.Proveedor;
import utils.MySQLConexion;

public class GestionProveedor implements ProveedorInterface{

	@Override
	public ArrayList<Proveedor> listado() {
		
		ArrayList<Proveedor> lista=new ArrayList<Proveedor>();
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="select * from tb_proveedores where estado=?";
			pst=con.prepareStatement(slq);
			pst.setBoolean(1, true);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				Proveedor pr=new Proveedor();
				pr.setIdproveedor(rs.getString(1));
				pr.setNomemp(rs.getString(2));
				pr.setNomdueño(rs.getString(3));
				pr.setDireccion(rs.getString(4));
				pr.setTelefono(rs.getString(5));
				pr.setEstado(rs.getBoolean(6));				
				lista.add(pr);
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return lista;
	}

	@Override
	public int registrarProveedor(Proveedor pr) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="insert into tb_proveedores values(?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, pr.getIdproveedor());
			pst.setString(2, pr.getNomemp());
			pst.setString(3, pr.getNomdueño());
			pst.setString(4, pr.getDireccion());
			pst.setString(5, pr.getTelefono());
			pst.setBoolean(6, pr.isEstado());
			
			rs=pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println("Error en el registro:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public int actualizarProveedor(Proveedor pr) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_proveedores set nombreEmp=?,nombreCargo=?,direccion=?,telefono=? where idproveedor=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, pr.getNomemp());
			pst.setString(2, pr.getNomdueño());
			pst.setString(3, pr.getDireccion());
			pst.setString(4, pr.getTelefono());
			pst.setString(5, pr.getIdproveedor());
			
			rs=pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println("Error en actualizar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public int eliminarProveedor(String pro) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_proveedores set estado=? where idproveedor=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setString(2, pro);
			
			rs=pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println("Error en eliminar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public Proveedor buscar(String pro) {
		
		Proveedor pr=null;
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="select * from tb_proveedores where idproveedor=?";
			pst=con.prepareStatement(slq);
			pst.setString(1, pro);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				pr=new Proveedor();
				pr.setIdproveedor(rs.getString(1));
				pr.setNomemp(rs.getString(2));
				pr.setNomdueño(rs.getString(3));
				pr.setDireccion(rs.getString(4));
				pr.setTelefono(rs.getString(5));
				pr.setEstado(rs.getBoolean(6));				

			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return pr;
	}

	@Override
	public String ObteneridProveedor() {
		
       String idProveedor="PR"; 
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="SELECT COUNT(*) as numero FROM tb_proveedores";
			pst=con.prepareStatement(slq);

			rs=pst.executeQuery();
			
			while(rs.next()) {
				idProveedor=idProveedor+String.format("%03d", rs.getInt(1)+1);//probar con 1
				
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return idProveedor;
	}

	@Override
	public int reactivarProveedor(String prov) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_proveedores set estado=? where idproveedor=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setString(2, prov);
			
			rs=pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Error al reactivar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
				
		return rs;
	}

	@Override
	public ArrayList<Proveedor> listadoproveli() {
		
		ArrayList<Proveedor>lista=new ArrayList<Proveedor>();	
	      
	      Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				con = MySQLConexion.getConexion();
				String sql = "select * from tb_proveedores where estado=?";
				pst = con.prepareStatement(sql);
				pst.setBoolean(1, false);
				rs = pst.executeQuery();

				while (rs.next()) {
				    Proveedor pr = new Proveedor();
				    pr.setIdproveedor(rs.getString(1));
				    pr.setNomemp(rs.getString(2));
				    pr.setNomdueño(rs.getString(3));
				    pr.setDireccion(rs.getString(4));
				    pr.setTelefono(rs.getString(5));
				    pr.setEstado(rs.getBoolean(6));
					lista.add(pr);
				}
			} catch (Exception e) {
				System.out.println("Error en listar:" + e.getMessage());

			} finally {
				MySQLConexion.closeConexion(con);
			}
	      
	      
		return lista;
	}

}
