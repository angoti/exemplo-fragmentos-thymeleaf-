package com.angoti.clinica.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

	@RequestMapping("/")
	public String inicio() {
		return "teste";
	}
	
	@RequestMapping("/pagina2")
	public String pg2() {
		return "teste2";
	}
	
	@RequestMapping("/pagina3")
	public String pg3() {
		return "teste3";
	}
	
	@RequestMapping("/pagina4")
	public String pg4() {
		return "exemplo";
	}
}
