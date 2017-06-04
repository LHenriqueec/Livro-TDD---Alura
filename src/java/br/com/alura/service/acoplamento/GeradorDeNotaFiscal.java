package br.com.alura.service.acoplamento;

import java.util.Calendar;
import java.util.List;

import br.com.alura.entity.acoplamento.NotaFiscal;
import br.com.alura.entity.acoplamento.Pedido;

public class GeradorDeNotaFiscal {
	
	private final List<AcaoAposGerarNota> acoes;
	
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
		this.acoes = acoes;
	}

	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(), 
							pedido.getValorTotal() * 0.94, Calendar.getInstance());
		
		acoes.forEach(acao -> acao.executa(nf));
		
		return nf;
	}
}
