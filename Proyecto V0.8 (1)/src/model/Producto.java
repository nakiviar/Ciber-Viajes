package model;

public class Producto {
	
	private String idprod , descripcion,idcat,idprov;
	private int stock;
	private double precio;
	private boolean estado;
	
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdcat() {
		return idcat;
	}
	public void setIdcat(String idcat) {
		this.idcat = idcat;
	}
	public String getIdprov() {
		return idprov;
	}
	public void setIdprov(String idprov) {
		this.idprov = idprov;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

	
	
	
	
}
