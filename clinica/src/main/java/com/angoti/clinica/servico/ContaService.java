package com.angoti.clinica.servico;

import com.angoti.clinica.dao.ContaDAO;
import com.angoti.clinica.dominio.Conta;

public class ContaService {
	public void salvar(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.inserir(conta);
	}
}
