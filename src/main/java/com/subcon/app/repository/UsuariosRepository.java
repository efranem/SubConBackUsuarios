package com.subcon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.subcon.app.dao.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	@Query("select x from Usuario x where x.usuario = :usuario and x.password = :password")
	public Usuario login(String usuario, String password);

}
