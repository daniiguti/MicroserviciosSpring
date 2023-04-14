package com.example.demo.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repositorios.CategoriaRepository;
import com.example.demo.Repositorios.ProductoRepository;
import com.example.demo.Usuario.UserService;
import com.example.demo.Modelos.Categoria;
import com.example.demo.Modelos.Producto;
import com.example.demo.Modelos.Usuario;

@Component
public class ConexionDB {

	@Autowired
	private ProductoRepository repositorioProductos;
	@Autowired
	private CategoriaRepository repositorioCategorias;
	@Autowired
	private UserService servicioUser;
	
	//PRODUCTOS
	public List<Producto> getAllProductos() {
		return repositorioProductos.findAll();
	}
	public Producto getProducto(Long id) {
		Producto p = repositorioProductos.findById(id).orElse(null);
		if(p != null) {
			Usuario user = servicioUser.getUsuario("dani").getBody();
			p.setUsuario(user);
		}
		
		return p;
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
