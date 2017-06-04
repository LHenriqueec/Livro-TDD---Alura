package br.com.alura.entity.coesao;

import br.com.alura.service.coesao.DezOuVintePorCento;
import br.com.alura.service.coesao.QuinzeOuVinteCincoPorCento;
import br.com.alura.service.coesao.RegraDeCalculo;

public enum Cargo {
	
	DESENVOLVEDOR(new DezOuVintePorCento()),
	TESTADOR(new QuinzeOuVinteCincoPorCento()),
	DBA(new QuinzeOuVinteCincoPorCento());
	
	private final RegraDeCalculo regra;
	
	Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}
	
	public RegraDeCalculo getRegra() {
		return regra;
	}
}
