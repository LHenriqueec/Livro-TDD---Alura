package br.com.alura.service;

import br.com.alura.entity.Funcionario;

public class CalculadoraDeSalario {

	public double calculaSalario(Funcionario funcionario) {
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}
}
