package com.example.demo.Modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "productos")
public class Producto {
	
	//atribs
    @Id
	private Long id_producto;
	private String nombre;
	private Integer stock;
	private Double precio;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria id_categoria;
	
	//Transient para que no se guarde en la bdd
	@Transient
	private Usuario usuario;
	
    //constructores
    public Producto() {
    	
    }
	public Producto(Long idProducto, String nombre, int stock, double precio, Categoria categoria) {
		this.id_producto = idProducto;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.id_categoria = categoria;
	}

    // getters y setters
	public Long getIdProducto() {
		return id_producto;
	}
	public void setIdProducto(Long idProducto) {
		this.id_producto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Categoria getCategoria() {
		return id_categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.id_categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
       
}
	
