package com.example.demoPrueba;

import com.example.demoPrueba.model.Usuario;
import com.example.demoPrueba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoPruebaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoPruebaApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNombre("William");
		usuario.setEmail("william@gmail.com");
		usuarioRepository.save(usuario);


		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Manuel");
		usuario1.setEmail("manuel@gmail.com");
		usuarioRepository.save(usuario1);
	}
}
