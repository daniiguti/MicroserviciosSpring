package com.example.demo.Usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Modelos.Usuario;

@FeignClient(name = "ms_user-service", url = "http://localhost:9021")
public interface UserService {

	@GetMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable String idUsuario);
		
}
