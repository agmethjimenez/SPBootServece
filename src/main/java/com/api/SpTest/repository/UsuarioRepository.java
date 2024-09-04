package com.api.SpTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.SpTest.entity.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
