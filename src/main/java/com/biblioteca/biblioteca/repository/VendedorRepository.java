
package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.biblioteca.models.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
    //Script de login, verifica email e senha;
	@Query(value= "SELECT id, nome, email, senha "
			+ "FROM vendedor "
			+"WHERE email=:email AND senha=:senha", nativeQuery=true)
	Vendedor findByLogin(@Param("email")String email, @Param("senha")String senha);
	
}
