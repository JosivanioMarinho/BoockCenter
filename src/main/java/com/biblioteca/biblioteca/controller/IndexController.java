package com.biblioteca.biblioteca.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca.models.Vendedor;
import com.biblioteca.biblioteca.repository.VendedorRepository;

@Controller
public class IndexController {
	@Autowired
	private VendedorRepository vendedorBanco;
	
	@PostMapping("/index")
	public String login(Vendedor vendedor) {
		System.out.println("teste");
		String email = vendedor.getEmail();
		String senha = vendedor.getSenha();
		//SELECT...WHERE email=email(banco) AND senha=ssenha(banco);
		Vendedor vendedorDoBanco = vendedorBanco.findByLogin(email, senha);
		//se o vendedor existe
		if(vendedorDoBanco != null) {
		return "telas/paginaInicial";
		}
		return "redirect:/index";
	}
	
	
	@GetMapping("/index")
	public String teste() {
		return  "/telas/index";
	}
	
	
	@PostMapping("/index/cadastro")
	public String cadastro(Vendedor vendedor) {
		vendedorBanco.save(vendedor);
		return "redirect:/index";
	}
}