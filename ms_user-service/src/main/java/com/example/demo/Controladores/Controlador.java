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

import com.example.demo.Modelos.Usuario;
import com.example.demo.Servicios.ConexionDB;

@RestController
public class Controlador {
	
	@Autowired
	private ConexionDB conexion;
	
	//obtener todos los productos Y obtener todos los productos de una categoria
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> usuarios = conexion.getAllUsuarios();

		if(usuarios.isEmpty()){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(usuarios);
		}
	}
	
	@GetMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable String idUsuario){
		
		Usuario u = conexion.getUsuario(idUsuario);
		if(u != null) {
			return ResponseEntity.ok(u);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//subir un producto
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> nuevoUsuario(@RequestBody Usuario nuevo) {	    
		Usuario u = conexion.insertarUsuario(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	
	//eliminar un producto por su id
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> borrarUsuario(@PathVariable String id) {
		conexion.eliminarUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
