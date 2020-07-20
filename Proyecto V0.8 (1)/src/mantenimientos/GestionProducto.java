package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import model.ProductoReporte;
import utils.MySQLConexion;

public class GestionProducto implements ProductoInterface {

	@Override
	public int registarpro(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_productos values(?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getIdprod());
			pst.setString(2, p.getDescripcion());
	        pst.setString(3, p.getIdprov());
	        pst.setString(4, p.getIdcat());
	        pst.setDouble(5, p.getPrecio());
	        pst.setInt(6, p.getStock());
	        pst.setBoolean(7, p.isEstado());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al registar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	@Override
	public int actualizarpro(Producto p) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "update tb_productos set nombrepro=?, idproveedor=?, idcategoria=? , precio=?, stock=? where idprod=? ";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getDescripcion());
			pst.setString(2, p.getIdprov());
	        pst.setString(3, p.getIdcat());
			pst.setDouble(4, p.getPrecio());
			pst.setInt(5, p.getStock());
			pst.setString(6, p.getIdprod());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al actualizar:" + e.getMessage());

		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	public int eliminarpro(String cod) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_productos set estado=? where idprod=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setString(2, cod);
			
			rs=pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println("Error en eliminar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public Producto buscar(String cod) {
		Producto p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_productos where idprod=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, cod);

			rs = pst.executeQuery();

			while (rs.next()) {
				p = new Producto();
				p.setIdprod(cod);
				p.setDescripcion(rs.getString(2));
				p.setIdprov(rs.getString(3));
				p.setIdcat(rs.getString(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				p.setEstado(rs.getBoolean(7));
								
			}

		} catch (Exception e) {
			System.out.println("Error en la busqueda:" + e.getMessage());

		} finally {
			MySQLConexion.closeConexion(con);
		}

		return p;
	}

	

	@Override
	public ArrayList<ProductoReporte> listadoxreporte() {
		
		ArrayList<ProductoReporte> lista = new ArrayList<ProductoReporte>(); // null -> lista vacia

		Connection con = null;
		PreparedStatement pst = null;

		// para los listados / reportes / consultas
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_ProductoRe()}";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			// pasar el rs al arraylist
			while (rs.next()) { // mientras el resultado tiene datos
				ProductoReporte pr = new ProductoReporte();
				pr.setIdprod(rs.getString(1));
				pr.setDescripcion(rs.getString(2));
				pr.setProv(rs.getString(3));
				pr.setCat(rs.getString(4));
				pr.setPrecio(rs.getDouble(5));
				pr.setStock(rs.getInt(6));

				lista.add(pr);
			}

		} catch (Exception e) {
			System.out.println("Error en listado:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
		
	}

	@Override
	public ArrayList<ProductoReporte> listadoxreportexcat(String cat) {
		
		ArrayList<ProductoReporte> lista = new ArrayList<ProductoReporte>(); // null -> lista vacia

		Connection con = null;
		PreparedStatement pst = null;

		// para los listados / reportes / consultas
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_ProductoRexcat(?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, cat);

			rs = pst.executeQuery();
			// pasar el rs al arraylist
			while (rs.next()) { // mientras el resultado tiene datos
				ProductoReporte pr = new ProductoReporte();
				pr.setIdprod(rs.getString(1));
				pr.setDescripcion(rs.getString(2));
				pr.setProv(rs.getString(3));
				pr.setCat(rs.getString(4));
				pr.setPrecio(rs.getDouble(5));
				pr.setStock(rs.getInt(6));

				lista.add(pr);
			}

		} catch (Exception e) {
			System.out.println("Error en listado:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public String ObteneridProducto() {
		
        String idProducto="P"; 
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String slq="SELECT COUNT(*) as numero FROM tb_productos";
			pst=con.prepareStatement(slq);

			rs=pst.executeQuery();
			
			while(rs.next()) {
				idProducto=idProducto+String.format("%04d", rs.getInt(1)+1);//probar con 1
				
			}
						
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
			
		return idProducto;
	}

	@Override
	public int reactivarProducto(String cod) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="update tb_productos set estado=? where idprod=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setString(2, cod);
			
			rs=pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Error al reactivar:"+ex.getMessage());
			
		}finally {
			MySQLConexion.closeConexion(con);
		}
				
		return rs;
	}

	@Override
	public ArrayList<Producto> listadoprodeli() {
		
		ArrayList<Producto>lista=new ArrayList<Producto>();	
	      
	      Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				con = MySQLConexion.getConexion();
				String sql = "select * from tb_productos where estado=?";
				pst = con.prepareStatement(sql);
				pst.setBoolean(1, false);
				rs = pst.executeQuery();

				while (rs.next()) {
				    Producto p = new Producto();
		            p.setIdprod(rs.getString(1));
		            p.setDescripcion(rs.getString(2));
		            p.setIdprov(rs.getString(3));
		            p.setIdcat(rs.getString(4));
		            p.setPrecio(rs.getDouble(5));
		            p.setStock(rs.getInt(6));
		            p.setEstado(rs.getBoolean(7));
					lista.add(p);
				}
			} catch (Exception e) {
				System.out.println("Error en listar:" + e.getMessage());

			} finally {
				MySQLConexion.closeConexion(con);
			}
	      
	      
		return lista;
	}

}
