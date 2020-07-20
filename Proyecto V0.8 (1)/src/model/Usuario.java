package model;

public class Usuario {
	
	//atributos -->tbl
	
	private int  tipousu , iddistrito;  
	private String nombre , apepa,apema, usuario, clave , fechanac, correo,direccion,telefono;
	private boolean estado;
	
	public int getTipousu() {
		return tipousu;
	}
	public void setTipousu(int tipousu) {
		this.tipousu = tipousu;
	}
	public int getIddistrito() {
		return iddistrito;
	}
	public void setIddistrito(int iddistrito) {
		this.iddistrito = iddistrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApepa() {
		return apepa;
	}
	public void setApepa(String apepa) {
		this.apepa = apepa;
	}
	public String getApema() {
		return apema;
	}
	public void setApema(String apema) {
		this.apema = apema;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFechanac() {
		return fechanac;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
