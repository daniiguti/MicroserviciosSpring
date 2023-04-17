package com.example.demo.Usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Modelos.Usuario;

//feign client es para decirle a que microservicio tiene que irse, y en que ip esta, ademas por si falla a donde lo enviamos(fallback)
@FeignClient(name = "user-service", url = "http://localhost:9021", fallback = UserServiceHystrix.class)
public interface UserService {

	@GetMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable String idUsuario);
		
}
