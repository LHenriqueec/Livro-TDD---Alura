package br.com.alura.entity;

import br.com.alura.service.DezOuVintePorCento;
import br.com.alura.service.QuinzeOuVinteCincoPorCento;
import br.com.alura.service.RegraDeCalculo;

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
