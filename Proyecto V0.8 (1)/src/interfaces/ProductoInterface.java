package interfaces;

import java.util.ArrayList;

import model.Producto;
import model.ProductoReporte;

public interface ProductoInterface {
	
	public int registarpro(Producto p);
	
	public int actualizarpro(Producto p);
	
	public int eliminarpro(String cod);
	
	public int reactivarProducto(String cod);
	
	public ArrayList<Producto>listadoprodeli();
	
	public Producto buscar(String cod);
	
	public ArrayList<ProductoReporte>listadoxreporte();
	
	public ArrayList<ProductoReporte>listadoxreportexcat(String cat);
	
	public String ObteneridProducto();

}
