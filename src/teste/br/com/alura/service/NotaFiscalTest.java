package br.com.alura.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.alura.entity.acoplamento.NotaFiscal;
import br.com.alura.entity.acoplamento.Pedido;
import br.com.alura.service.acoplamento.AcaoAposGerarNota;
import br.com.alura.service.acoplamento.GeradorDeNotaFiscal;
import br.com.alura.service.acoplamento.NFDao;
import br.com.alura.service.acoplamento.SAP;

public class NotaFiscalTest {
	
	private GeradorDeNotaFiscal gerador;
	private NFDao dao;
	private SAP sap;
	private List<AcaoAposGerarNota> acoes;
	
	@Before
	public void init() {
		dao = mock(NFDao.class);
		sap = mock(SAP.class);
		
		acoes = Arrays.asList(dao, sap);
		gerador = new GeradorDeNotaFiscal(acoes);
	}

	@Test
	public void deve_gerar_nf_com_valor_de_imposto_descontado() {
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		assertEquals(1000 * 0.94, nf.getValor(), 0.00001);
	}
	
	@Test
	public void deve_persistir_nf_gerada() {
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		verify(dao).executa(nf);
	}
	
	@Test
	public void deve_enviar_nf_para_sap() {
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		verify(sap).executa(nf);
	}
}
