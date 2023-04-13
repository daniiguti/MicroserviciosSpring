package com.example.demo.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Modelos.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query(value="SELECT * FROM PRODUCTOS WHERE id_categoria LIKE '%' || ?1 || '%'", nativeQuery=true)
	public List<Producto> getProductosByCategoria(Long id_categoria);
}
