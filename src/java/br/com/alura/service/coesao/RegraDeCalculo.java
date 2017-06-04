package br.com.alura.service.coesao;

import br.com.alura.entity.coesao.Funcionario;

public abstract class RegraDeCalculo {

	public double calcula(Funcionario funcionario) {
		if (funcionario.getSalario() > limite()) {
			return funcionario.getSalario() * porcentagemAcimaDoLimite();
		}
		
		return funcionario.getSalario() * porcentagemBase();
	}
	
	protected abstract int limite();
	
	protected abstract double porcentagemAcimaDoLimite();
	
	protected abstract double porcentagemBase();
}