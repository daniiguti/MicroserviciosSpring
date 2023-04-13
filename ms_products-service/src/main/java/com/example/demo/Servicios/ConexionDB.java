package com.example.demo.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repositorios.CategoriaRepository;
import com.example.demo.Repositorios.ProductoRepository;
import com.example.demo.Modelos.Categoria;
import com.example.demo.Modelos.Producto;

@Component
public class ConexionDB {

	@Autowired
	private ProductoRepository repositorioProductos;
	@Autowired
	private CategoriaRepository repositorioCategorias;
	
	//PRODUCTOS
	public List<Producto> getAllProductos() {
		return repositorioProductos.findAll();
	}
	public Producto getProducto(Long id) {
		return repositorioProductos.findById(id).orElse(null);
	}
	public Producto insertarProducto(Producto p) {
		Producto aux = repositorioProductos.findById(p.getIdProducto()).orElse(null);
		if(aux == null) {
			return p;
		}else {
			return repositorioProductos.save(p);
		}
	}
	public void eliminarProducto(Long id) {
		repositorioProductos.deleteById(id);
	}
	public List<Producto> getProductosByCategoria(Categoria c){
		return repositorioProductos.getProductosByCategoria(c.getIdCategoria());
	}
	
	
	//CATEGORIAS
	public List<Categoria> getAllCategorias() {
		return repositorioCategorias.findAll();
	}
	public Categoria getCategoria(Long id) {
		return repositorioCategorias.findById(id).orElse(null);
	}
	public void insertarCategoria(Categoria c) {
		repositorioCategorias.save(c);
		
	}
	public void eliminarCategoria(Long id) {
		repositorioCategorias.deleteById(id);
	}
}
