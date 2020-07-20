package model;

public class Proveedor {
	
	private String idproveedor,nomemp,nomdueño,direccion,telefono;
	private boolean estado;
	
	public String getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getNomemp() {
		return nomemp;
	}
	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}
	public String getNomdueño() {
		return nomdueño;
	}
	public void setNomdueño(String nomdueño) {
		this.nomdueño = nomdueño;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
