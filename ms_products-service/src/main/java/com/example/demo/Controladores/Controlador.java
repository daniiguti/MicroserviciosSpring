package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelos.Categoria;
import com.example.demo.Modelos.Producto;
import com.example.demo.Servicios.ConexionDB;

@RestController
public class Controlador {
	
	@Autowired
	private ConexionDB conexion;
	
	//obtener todos los productos Y obtener todos los productos de una categoria
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getProductos(@RequestParam(name= "categoriaId", required=false, defaultValue="-1") String categoriaId) {
		Long id;
		try {
			id = Long.valueOf(categoriaId);
		}
		catch(NumberFormatException ex) {
			return ResponseEntity.badRequest().build();
		}
		
		
		List<Producto> productos;
		
		if(id == -1) {
			productos = conexion.getAllProductos();
		}else {
			Categoria c = conexion.getCategoria(id);
			if(c == null) {
				return ResponseEntity.noContent().build();
			}else {
				productos = conexion.getProductosByCategoria(c);
			}
		}

		if(productos.isEmpty()){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(productos);
		}
	}
	
	@GetMapping("/productos/{idProducto}")
	public ResponseEntity<Producto> getProducto(@PathVariable String idProducto){
		Long id;
		try {
			id = Long.valueOf(idProducto);
		}
		catch(NumberFormatException ex) {
			return ResponseEntity.badRequest().build();
		}
		
		Producto p = conexion.getProducto(id);
		if(p != null) {
			return ResponseEntity.ok(p);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//subir un producto
	@PostMapping("/productos")
	public ResponseEntity<Producto> nuevoProducto(@RequestBody Producto nuevo) {
	    Producto producto = conexion.insertarProducto(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	}
	
	//eliminar un producto por su id
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		conexion.eliminarProducto(id);
		return ResponseEntity.noContent().build();
	}
}
