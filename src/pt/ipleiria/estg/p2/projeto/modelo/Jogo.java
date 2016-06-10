package pt.ipleiria.estg.p2.projeto.modelo;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelDeMacas;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelDeMovimentosEstrelas;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelDePontuacoes;
import pt.ipleiria.estg.p2.projeto.modelo.paineis.PainelPrincipal;

public class Jogo {
	private PainelDeMacas painelDeMacas;
    private PainelDeMovimentosEstrelas painelDeMovimentosEstrelas;
    private PainelDePontuacoes painelDePontuacoes;
    private PainelPrincipal painelPrincipal;
    private Objetivo objetivo;
    
    
	public Jogo(GridPanel gridPanelPainelDeMacas, GridPanel gridPanelPainelDeMovimentosEstrelas,
			GridPanel gridPanelPainelDePontuacoes, GridPanel gridPanelPainelPrincipal) {
		 //Definir objetivo
        objetivo = new Objetivo(10, 150, 5000, 0);
        // criar paineis
        painelDeMacas = new PainelDeMacas(gridPanelPainelDeMacas, objetivo.getNumeroDeMacasParaApanhar());
        painelDeMovimentosEstrelas = new PainelDeMovimentosEstrelas(gridPanelPainelDeMovimentosEstrelas, objetivo.getNumeroDeMovimentosMaximo());
        painelDePontuacoes = new PainelDePontuacoes(gridPanelPainelDePontuacoes);
        painelPrincipal = new PainelPrincipal(gridPanelPainelPrincipal, this);
	}


	public void iterar(long tempo) {
		painelPrincipal.iterar(tempo);
	}

    public void decrementarMovimentosDisponiveis()
    {
        painelDeMovimentosEstrelas.decrementarValor();
    }
    
    public void decrementarMacasPorApanhar()
    {
        painelDeMacas.decrementarValor();
    }
    
}
