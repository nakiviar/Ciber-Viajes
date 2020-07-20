package interfaces;

import java.util.ArrayList;

import model.Categorias;


public interface CategoriaInterface {
	
	public ArrayList<Categorias> listado();
	
	public int registrarCategoria(Categorias c);
	
	public int actualizarCategoria(Categorias c);
	
	public int eliminarCategoria(String cat);
	
	public Categorias buscar(String cat);
	
	public String ObteneridCategoria();
	
	public int reactivarCategoria(String cat);
	
	public ArrayList<Categorias>listadocateli();

}
