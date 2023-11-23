package com.example.demoPrueba.repository;

import com.example.demoPrueba.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
