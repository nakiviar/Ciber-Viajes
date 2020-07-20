package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DistritoInterface;
import model.Distrito;
import utils.MySQLConexion;

public class GestionDistrito implements DistritoInterface{

	@Override
	public ArrayList<Distrito> listado() {
		
		ArrayList<Distrito>lista = new ArrayList<Distrito>();
		
		Connection con =null;
		PreparedStatement pst=null;
		
		ResultSet rs=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="select * from tb_distritos";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				Distrito d = new Distrito();
				d.setIddis(rs.getInt(1));
				d.setNombredis(rs.getString(2));
				
				lista.add(d);
					
			}
			
			
		}catch(Exception ex) {
			System.out.println("Error al listar:"+ex.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		
		
		return lista;
	}

}
