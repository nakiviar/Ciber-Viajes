package interfaces;

import java.util.ArrayList;

import model.Proveedor;

public interface ProveedorInterface {
	
	public ArrayList<Proveedor> listado();
	
     public int registrarProveedor(Proveedor pr);
	
	public int actualizarProveedor(Proveedor pr);
	
	public int eliminarProveedor(String pro);
	
	public Proveedor buscar(String pro);
	
	public String ObteneridProveedor();
	
    public int reactivarProveedor(String prov);
	
	public ArrayList<Proveedor>listadoproveli();

}
