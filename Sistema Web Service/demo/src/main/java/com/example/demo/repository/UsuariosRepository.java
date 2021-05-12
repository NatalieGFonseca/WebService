package com.example.demo.repository;
import com.example.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

	Usuario findOne(Long id);
	
}
