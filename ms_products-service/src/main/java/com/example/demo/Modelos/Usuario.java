package com.example.demo.Modelos;

public class Usuario {
	
	private String usuario;
	private String contrasenia;
	private int compra;
	
	//constructores
	public Usuario() {
		
	}
	public Usuario(String usuario, String contrasenia, int compra) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.compra = compra;
	}
	
	//getters y setters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getCompra() {
		return compra;
	}
	public void setCompra(int compra) {
		this.compra = compra;
	}	
	
}
