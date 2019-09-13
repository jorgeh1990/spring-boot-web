package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "home" })
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", "Hola Spring Boot con ModelAndView");
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/perfil")
	public String perfil(Model model){
		Usuario usuario = new Usuario();
		usuario.setNombre("Jorge");
		usuario.setApellido("Hernandez");
		usuario.setEmail("ing.jorgeh@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario "+usuario.getNombre());
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model){
		List<Usuario> usuarios= new ArrayList<>();
		usuarios.add(new Usuario("Jorge","Hernandez", "jhernandez@gmail.com"));
		usuarios.add(new Usuario("Melissa","Mardini", "mmardini@gmail.com"));
		usuarios.add(new Usuario("Laina","Hernandez", "lhernandez@gmail.com"));
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", "Listado de usuario");
		return "listar";
	}
}
