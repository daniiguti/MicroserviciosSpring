package com.example.demo.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.Modelos.Usuario;

//clase que gestiona si la llamada al plan a(user-service) falla
@Component
public class UserServiceHystrix implements UserService {
	
	//lo que vamos a hacer si falla la llamada a user-service, se viene aquí y devolvemos un usuario vacío
	@Override
	public ResponseEntity<Usuario> getUsuario(String idUsuario) {
		Usuario user = new Usuario("david", "1234", 0);
		return ResponseEntity.ok(user);
	}

}
