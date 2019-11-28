package com.biblioteca.biblioteca.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblioteca.biblioteca.models.Llivro;
import com.biblioteca.biblioteca.models.Vendedor;
import com.biblioteca.biblioteca.repository.LivroRepository;
import com.biblioteca.biblioteca.repository.VendedorRepository;


@Controller
public class IndexController {
	
	@Autowired
	private VendedorRepository vendedorBanco;
	
	@PostMapping("/index")
	public ModelAndView login(Vendedor vendedor, RedirectAttributes att) {
		System.out.println("teste");
		ModelAndView mv = new ModelAndView("redirect:/index");
		ModelAndView mv2 = new ModelAndView("telas/paginaInicial");
		String email = vendedor.getEmail();
		String senha = vendedor.getSenha();
		//SELECT...WHERE email=email(banco) AND senha=senha(banco);
		Vendedor vendedorDoBanco = vendedorBanco.findByLogin(email, senha);
		//se o vendedor existe
		if(vendedorDoBanco != null) {
		return mv2;
		}
		att.addFlashAttribute("mensagem", "Email ou senha inválidos!");
		return mv;
	}
	
	//chamando tela de login;
	@GetMapping("/index")
	public String telaLogin() {
		return "/telas/index";
	}
	
	//cadatro de usuario;
	@PostMapping("/index/cadastro")
	public String cadastro(@Valid Vendedor vendedor, RedirectAttributes att) {
		att.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
		vendedorBanco.save(vendedor);
		return "redirect:/index";
	}
	
	//botão de home;
	@GetMapping("/home")
 	public String home() {
 		return"/telas/paginaInicial";
 	}

	//ir para Tela de cadastro se livros;
	@GetMapping("/index/CadastroLivro")
	public String cadastrarLivro() {
		return "/telas/cadastroLivro";
	}
	
	//cadastro dos livros;
	@Autowired
	private LivroRepository livroBanco;
	private Disco disco;
	
	@PostMapping("/cadastroLivro")
	public String cadastroLivro(Llivro livro){
		livroBanco.save(livro);
		return"redirect:/index/CadastroLivro";
	}
	
	//resultado da busca;
	@RequestMapping("/resultadoBusca")
	public ModelAndView listaLivros() {
		ModelAndView mv = new ModelAndView("/telas/resultBusca");
		Iterable<Llivro> livros = livroBanco.findAll();
		mv.addObject("livros", livros);
		return mv;
	}
		
	
}