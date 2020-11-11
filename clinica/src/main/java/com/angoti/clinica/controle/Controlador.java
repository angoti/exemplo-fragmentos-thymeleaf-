package com.angoti.clinica.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.angoti.clinica.dao.ContaDAO;
import com.angoti.clinica.dominio.Conta;
import com.angoti.clinica.servico.ContaService;

@Controller
public class Controlador {

	@RequestMapping("/")
	public String inicio() {
		return "homepage";
	}

	@RequestMapping("/crud-conta")
	public String cadastrar(Model modelo) {
		ContaDAO dao = new ContaDAO();
		List<Conta> lista = dao.listagem();
		modelo.addAttribute("lista", lista);
		modelo.addAttribute("conta", new Conta());
		return "crud-conta";
	}

	@RequestMapping("/salvar-conta")
	public String salvar(Conta conta) {
		ContaService usuarioService = new ContaService();
		usuarioService.salvar(conta);
		return "mensagem";
	}
	
	@RequestMapping("/excluir-conta")
	public String excluir(@RequestParam(value = "id", required = false) Integer id) {
		System.out.println("---------------> "+id);
		ContaDAO dao = new ContaDAO();
		dao.excluir(id);
		return "mensagem";

	}

}
