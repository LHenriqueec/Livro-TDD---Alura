package br.com.alura.service.coesao;

import br.com.alura.entity.coesao.Funcionario;

public class CalculadoraDeSalario {

	public double calculaSalario(Funcionario funcionario) {
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}
}
