package br.com.alura.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.alura.entity.Cargo;
import br.com.alura.entity.Funcionario;

public class CalculadoraDeSalarioTest {
	
	private CalculadoraDeSalario calculadora;
	
	@Before
	public void init() {
		calculadora = new CalculadoraDeSalario();
	}

	@Test
	public void deve_calcular_salario_para_desenvolvedores_com_salario_abaixo_do_limite() {
		Funcionario desenvolvedor = new Funcionario("Mauricio", 1500.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(desenvolvedor);
		
		assertEquals(1500.0 * 0.9, salario, 0.00001);
	}
	
	@Test
	public void deve_calcular_salario_para_desenvolvedores_com_salario_acima_do_limite() {
		Funcionario funcionario = new Funcionario("Mauricio", 4000.0, Cargo.DESENVOLVEDOR);
		
		double salario = calculadora.calculaSalario(funcionario);
		
		assertEquals(4000.0 * 0.8, salario, 0.00001);
	}
	
	@Test
	public void deve_calcular_salario_para_DBAs_com_salario_abaixo_do_limite() {
		Funcionario dba = new Funcionario("Mauricio", 500.0, Cargo.DBA);
		
		double salario = calculadora.calculaSalario(dba);
		
		assertEquals(500.0 * 0.85, salario, 0.00001);
	}
}
