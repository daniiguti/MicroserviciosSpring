package com.example.demo.Modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	//atribs
	@Id
    private Long id_categoria;
    private String nombre;
    
    
    //constructores
    public Categoria() {
    	
    }
	public Categoria(Long idCategoria, String nombre) {
		this.id_categoria = idCategoria;
		this.nombre = nombre;
	}
	
    // getters y setters
	public Long getIdCategoria() {
		return id_categoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.id_categoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

       
}