package com.example.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
