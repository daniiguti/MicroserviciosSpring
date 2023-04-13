package com.example.demo.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repositorios.UsuarioRepository;
import com.example.demo.Modelos.Usuario;

@Component
public class ConexionDB {
	
	@Autowired
	private UsuarioRepository repositorioUsuarios;
	
	//CATEGORIAS
	public List<Usuario> getAllUsuarios() {
		return repositorioUsuarios.findAll();
	}
	public Usuario getUsuario(String id) {
		return repositorioUsuarios.findById(id).orElse(null);
	}
	public Usuario insertarUsuario(Usuario u) {
		return repositorioUsuarios.save(u);
		
	}
	public void eliminarUsuario(String id) {
		repositorioUsuarios.deleteById(id);
	}
}
