package pt.ipleiria.estg.p2.projeto;

public class PainelDeJogo {
	
	private PainelDeMacas painelDeMacas;

	public PainelDeMacas getPainelDeMacas() {
		return painelDeMacas;
	}

	public void setPainelDeMacas(PainelDeMacas painelDeMacas) {
		this.painelDeMacas = painelDeMacas;
	}
	
	public PainelMovimentoEstrelas getPainelMovimentoDeEstrelas() {
		return painelMovimentoDeEstrelas;
	}

	public void setPainelMovimentoDeEstrelas(PainelMovimentoEstrelas painelMovimentoDeEstrelas) {
		this.painelMovimentoDeEstrelas = painelMovimentoDeEstrelas;
	}

	public PainelDePontuacoes getPainelDePontuacoes() {
		return painelDePontuacoes;
	}

	public void setPainelDePontuacoes(PainelDePontuacoes painelDePontuacoes) {
		this.painelDePontuacoes = painelDePontuacoes;
	}

	public PainelPrincipal getPainelPrincipal() {
		return painelPrincipal;
	}

	public void setPainelPrincipal(PainelPrincipal painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}

	private PainelMovimentoEstrelas painelMovimentoDeEstrelas;
	
	private PainelDePontuacoes painelDePontuacoes;
	
	private PainelPrincipal painelPrincipal;
}
